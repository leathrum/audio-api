package edu.jsu.leathrum.audiotest2.client;

import com.google.gwt.animation.client.AnimationScheduler;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import edu.jsu.leathrum.audio.shared.client.Audio;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class AudioTest2 implements EntryPoint, ClickHandler {
	Audio audio = Audio.createIfSupported();
	Button playButton = new Button("Play");
	int sampleRate = 41000;
	int x = 0;
	float frequency = 440.0f;
	private float[] buffer;

    public void onModuleLoad() {
		audio.setup(1,sampleRate);
		buffer = new float[20500];
        playButton.addClickHandler(this);
		RootPanel.get("playbutton").add(playButton);
	}

	public void animate(){
      sound();
      AnimationScheduler.get().requestAnimationFrame(
		new AnimationScheduler.AnimationCallback() {
			public void execute(double timestamp) {
				if (playing) animate();  // yes it loops back -- that's the point
			};
		});
    }
	
	private float twopi = (float) (2.0f * Math.PI);
			
	private void sound() {
		//int written = 0;
        for (int i = 0; i < buffer.length; i++)
        	buffer[i] = (float) Math.sin(twopi * frequency * x++ / sampleRate );
		//written = 
        audio.writeAudio(buffer);
	}
	
	private boolean playing = false;
	
	public void onClick(ClickEvent e) {
		if (playing) stop(); else start();
		playing = !playing;
	}
	
	public void start() { 
		x = 0;
		audio.connect();
		animate();
        playButton.getElement().getStyle().setColor("red");
	}
	
	public void stop() { 
		audio.disconnect();
        playButton.getElement().getStyle().setColor("black");
	}
	
}

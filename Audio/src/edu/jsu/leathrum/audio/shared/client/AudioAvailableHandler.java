package edu.jsu.leathrum.audio.shared.client;

import com.google.gwt.event.shared.EventHandler;

public interface AudioAvailableHandler extends EventHandler {
	public void onAudioAvailable(AudioAvailableEvent e);
}

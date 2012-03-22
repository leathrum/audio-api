package edu.jsu.leathrum.audio.shared.client;

import com.google.gwt.event.shared.HandlerRegistration;
import edu.jsu.leathrum.audio.shared.client.HasAudioAvailableHandlers;
import edu.jsu.leathrum.audio.shared.client.AudioAvailableEvent;

public class Audio extends com.google.gwt.media.client.Audio
        implements HasAudioAvailableHandlers {
	
	com.google.gwt.dom.client.AudioElement audioElement;
	
	// need to provide constructor in order to get super()
	protected Audio(com.google.gwt.dom.client.AudioElement audio) {
	   super(audio);
	   audioElement = audio;
	}
	
	// reference implementation
    public HandlerRegistration addAudioAvalableHandler(AudioAvailableHandler h) {
      return addDomHandler(h, AudioAvailableEvent.getType());	
    }
	
    // need to get object of super type if supported, then recast it here
    // by creating new object of this type with the same audio element
	public static Audio createIfSupported() {
		com.google.gwt.media.client.Audio audio = 
				com.google.gwt.media.client.Audio.createIfSupported();
		return new Audio(audio.getAudioElement());
	}
	
	// below are native method implementations of Mozilla Audio Data API methods
	public native void setup(int channels, int sampleRate) /*-{
		var a = this.@edu.jsu.leathrum.audio.shared.client.Audio::audioElement;
		a.mozSetup(channels, sampleRate);
    }-*/;

	public native int writeAudio(float[] buffer) /*-{
		var a = this.@edu.jsu.leathrum.audio.shared.client.Audio::audioElement;
	    return a.mozWriteAudio(buffer);
    }-*/;
	
	public native int currentSampleOffset() /*-{
		var a = this.@edu.jsu.leathrum.audio.shared.client.Audio::audioElement;
	    return a.mozCurrentSampleOffset();
    }-*/;

	// instead of fields, implemented here as native methods that return field value
	public native int getChannels() /*-{
		var a = this.@edu.jsu.leathrum.audio.shared.client.Audio::audioElement;
        return a.mozChannels;
    }-*/;

	public native int getSampleRate() /*-{
		var a = this.@edu.jsu.leathrum.audio.shared.client.Audio::audioElement;
        return a.mozSampleRate;
    }-*/;

	public native int getFrameBufferLength() /*-{
	    var a = this.@edu.jsu.leathrum.audio.shared.client.Audio::audioElement;
        return a.mozFrameBufferLength;
    }-*/;
	
	public native void connect() /*-{
      var a = this.@edu.jsu.leathrum.audio.shared.client.Audio::audioElement;
      a.connect();
    }-*/;

	public native void disconnect() /*-{
      var a = this.@edu.jsu.leathrum.audio.shared.client.Audio::audioElement;
      a.disconnect();
    }-*/;

}

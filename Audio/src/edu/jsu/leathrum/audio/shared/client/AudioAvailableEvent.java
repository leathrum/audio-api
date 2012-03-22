package edu.jsu.leathrum.audio.shared.client;

import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.dom.client.NativeEvent;

public class AudioAvailableEvent  extends DomEvent<AudioAvailableHandler> {
	private static Type<AudioAvailableHandler> TYPE
	    = new Type<AudioAvailableHandler>("MozAudioAvailable",null);
	public DomEvent.Type<AudioAvailableHandler> getAssociatedType() {
		return TYPE;
	}
	public static DomEvent.Type<AudioAvailableHandler> getType() {
		return TYPE;
	}
	
	
	
	float[] frameBuffer;
	float time;
	
	protected void dispatch(AudioAvailableHandler handler) {
		frameBuffer = getbuffer(this.getNativeEvent());
		time = gettime(this.getNativeEvent());
		handler.onAudioAvailable(this);
	}
	
	private native float[] getbuffer(NativeEvent e) /*-{
	    return e.frameBuffer;
    }-*/;
	
	private native float gettime(NativeEvent e) /*-{
	    return e.time;
    }-*/;
}

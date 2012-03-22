package edu.jsu.leathrum.audio.shared.client;

import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.event.shared.HandlerRegistration;

public interface HasAudioAvailableHandlers extends HasHandlers {
    public HandlerRegistration addAudioAvalableHandler(AudioAvailableHandler h);
}

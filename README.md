# GWT Audio API Wrapper for Mozilla Audio Data API

This GWT library provides objects, interfaces, and methods to implement the
[Mozilla Audio Data API](https://wiki.mozilla.org/Audio_Data_API),
and provides compatibility also with the WebKit/W3C
[Web Audio API](https://dvcs.w3.org/hg/audio/raw-file/tip/webaudio/specification.html) (but does not provide a full implementation of that
API).  For functional compatibility with the Web Audio API, 
two methods not part of the Mozilla Audio
Data API are included here:  `Audio.connect()` and `Audio.disconnect()`.

The `AudioText2` code provides a working example of a simple tone
generator, which has been tested to work in both Firefox and Chromium.
This just shows a "Play" button which triggers a tone at 440Hz (A above middle
C in standard tuning).

The directory structure and library import files are set up to work in Eclipse.

### Package

    edu.jsu.leathrum.audio.shared

### Audio

    public class Audio extends com.google.media.client.Audio
      implements HasAudioAvailableHandlers  // <-- for reference implementation

constructor is protected  
methods:

    public static Audio createIfSupported() // overrides
    public void setup(int channels, int sampleRate) 
                                            // mozSetup(channels, sampleRate)
    public void writeAudio(float[] buffer)  // mozWriteAudio(buffer)
    public int currentSampleOffset()        // mozCurrentSampleOffset()
    public int getChannels()                // returns mozChannels
    public int getSampleRate()              // returns mozSampleRate
    public int getFrameBufferLength()       // returns mozFrameBufferLength
    public void connect()                   // for Webkit compatibility
    public void disconnect()                // for Webkit compatibility
    public HandlerRegistration              // reference implementation
        addAudioAvalableHandler(AudioAvailableHandler h) 

### AudioAvailableEvent

    public class AudioAvailableEvent extends DomEvent<AudioAvailableHandler>

uses constructor from super  
methods:

    public DomEvent.Type<AudioAvailableHandler> getType()
    public DomEvent.Type<AudioAvailableHandler> getType()
    protected void dispatch(AudioAvailableHandler handler)

### AudioAvailableHandler

    public interface AudioAvailableHandler extends EventHandler

methods:

    public void onAudioAvailable(AudioAvailableEvent e)

### HasAudioAvailableHandlers

    public interface HasAudioAvailableHandlers

methods:

    public HandlerRegistration 
        addAudioAvailableHandler(AudioAvailableHandler h)

## Notes on WebKit Compatibility

WebKit compatibility is provided through a JavaScript library
`moz2wk-audio.js` which is found in the
`Audio/src/edu/jsu/leathrum/audio/shared/public`
directory and is included automatically in any project importing the
library through the `Audio.gwt.xml`
file in the `Audio/src/edu/jsu/leathrum/audio/shared` directory.
This JavaScript library provides implementations of the Mozilla Audio Data API
methods and properties (attached to the WebKit `HTMLAudioElement` object)
when in a WebKit browser environment, and provides empty implementations
of the `connect()` and `disconnect()` methods otherwise.

## Acknowledgements

Aside from the authors responsible for writing the API documentation cited
above, I should note that the tone generator code was based on both the
tone generator code in the
[Mozilla Audio Data API](https://wiki.mozilla.org/Audio_Data_API) page
and the tone generator for the Web Audio API at
[0xfe.blogspot.com](http://0xfe.blogspot.com/2011/08/generating-tones-with-web-audio-api.html).


package androidx.camera.video.internal.config;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.EncoderProfilesProxy;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.AudioSpec;
import androidx.camera.video.internal.audio.AudioSettings;
import androidx.camera.video.internal.encoder.AudioEncoderConfig;
import androidx.core.util.Supplier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public final class AudioEncoderConfigAudioProfileResolver implements Supplier<AudioEncoderConfig> {
    private static final String TAG = "AudioEncAdPrflRslvr";
    private final int mAudioProfile;
    private final EncoderProfilesProxy.AudioProfileProxy mAudioProfileProxy;
    private final AudioSettings mAudioSettings;
    private final AudioSpec mAudioSpec;
    private final Timebase mInputTimebase;
    private final String mMimeType;

    public AudioEncoderConfigAudioProfileResolver(@NonNull String str, int i, @NonNull Timebase timebase, @NonNull AudioSpec audioSpec, @NonNull AudioSettings audioSettings, @NonNull EncoderProfilesProxy.AudioProfileProxy audioProfileProxy) {
        this.mMimeType = str;
        this.mAudioProfile = i;
        this.mInputTimebase = timebase;
        this.mAudioSpec = audioSpec;
        this.mAudioSettings = audioSettings;
        this.mAudioProfileProxy = audioProfileProxy;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.core.util.Supplier
    @NonNull
    public AudioEncoderConfig get() {
        Logger.d(TAG, "Using resolved AUDIO bitrate from AudioProfile");
        return AudioEncoderConfig.builder().setMimeType(this.mMimeType).setProfile(this.mAudioProfile).setInputTimebase(this.mInputTimebase).setChannelCount(this.mAudioSettings.getChannelCount()).setSampleRate(this.mAudioSettings.getSampleRate()).setBitrate(AudioConfigUtil.scaleAndClampBitrate(this.mAudioProfileProxy.getBitrate(), this.mAudioSettings.getChannelCount(), this.mAudioProfileProxy.getChannels(), this.mAudioSettings.getSampleRate(), this.mAudioProfileProxy.getSampleRate(), this.mAudioSpec.getBitrate())).build();
    }
}

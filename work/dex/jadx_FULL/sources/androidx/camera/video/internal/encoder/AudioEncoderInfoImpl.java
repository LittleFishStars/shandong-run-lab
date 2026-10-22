package androidx.camera.video.internal.encoder;

import android.media.MediaCodecInfo;
import android.util.Range;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RequiresApi(21)
public class AudioEncoderInfoImpl extends EncoderInfoImpl implements AudioEncoderInfo {
    private final MediaCodecInfo.AudioCapabilities mAudioCapabilities;

    public AudioEncoderInfoImpl(@NonNull MediaCodecInfo mediaCodecInfo, @NonNull String str) throws InvalidConfigException {
        super(mediaCodecInfo, str);
        MediaCodecInfo.AudioCapabilities audioCapabilities = this.mCodecCapabilities.getAudioCapabilities();
        Objects.requireNonNull(audioCapabilities);
        this.mAudioCapabilities = audioCapabilities;
    }

    @NonNull
    public static AudioEncoderInfoImpl from(@NonNull AudioEncoderConfig audioEncoderConfig) throws InvalidConfigException {
        return new AudioEncoderInfoImpl(EncoderInfoImpl.findCodecAndGetCodecInfo(audioEncoderConfig), audioEncoderConfig.getMimeType());
    }

    @Override // androidx.camera.video.internal.encoder.AudioEncoderInfo
    @NonNull
    public Range<Integer> getBitrateRange() {
        return this.mAudioCapabilities.getBitrateRange();
    }
}

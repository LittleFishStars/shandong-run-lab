package androidx.camera.video.internal.encoder;

import android.media.MediaFormat;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Timebase;
import com.google.auto.value.AutoValue;
import com.zj.adlib.dx7;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@AutoValue
@RequiresApi(21)
public abstract class AudioEncoderConfig implements EncoderConfig {

    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract AudioEncoderConfig autoBuild();

        @NonNull
        public AudioEncoderConfig build() {
            AudioEncoderConfig audioEncoderConfigAutoBuild = autoBuild();
            if (Objects.equals(audioEncoderConfigAutoBuild.getMimeType(), "audio/mp4a-latm") && audioEncoderConfigAutoBuild.getProfile() == -1) {
                throw new IllegalArgumentException("Encoder mime set to AAC, but no AAC profile was provided.");
            }
            return audioEncoderConfigAutoBuild;
        }

        @NonNull
        public abstract Builder setBitrate(int i);

        @NonNull
        public abstract Builder setChannelCount(int i);

        @NonNull
        public abstract Builder setInputTimebase(@NonNull Timebase timebase);

        @NonNull
        public abstract Builder setMimeType(@NonNull String str);

        @NonNull
        public abstract Builder setProfile(int i);

        @NonNull
        public abstract Builder setSampleRate(int i);
    }

    @NonNull
    public static Builder builder() {
        return new AutoValue_AudioEncoderConfig.Builder().setProfile(-1);
    }

    public abstract int getBitrate();

    public abstract int getChannelCount();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    @NonNull
    public abstract Timebase getInputTimebase();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    @NonNull
    public abstract String getMimeType();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    public abstract int getProfile();

    public abstract int getSampleRate();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    @NonNull
    public MediaFormat toMediaFormat() {
        MediaFormat mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat(getMimeType(), getSampleRate(), getChannelCount());
        mediaFormatCreateAudioFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_BIT_RATE, getBitrate());
        if (getProfile() != -1) {
            if (getMimeType().equals("audio/mp4a-latm")) {
                mediaFormatCreateAudioFormat.setInteger("aac-profile", getProfile());
            } else {
                mediaFormatCreateAudioFormat.setInteger(dx7.f41301a, getProfile());
            }
        }
        return mediaFormatCreateAudioFormat;
    }
}

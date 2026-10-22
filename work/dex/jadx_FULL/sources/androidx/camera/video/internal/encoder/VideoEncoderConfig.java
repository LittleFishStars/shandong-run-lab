package androidx.camera.video.internal.encoder;

import android.media.MediaFormat;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Timebase;
import com.google.auto.value.AutoValue;
import com.zj.adlib.dx7;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@AutoValue
@RequiresApi(21)
public abstract class VideoEncoderConfig implements EncoderConfig {
    private static final int VIDEO_COLOR_FORMAT_DEFAULT = 2130708361;
    private static final int VIDEO_INTRA_FRAME_INTERVAL_DEFAULT = 1;

    @AutoValue.Builder
    public static abstract class Builder {
        @NonNull
        public abstract VideoEncoderConfig build();

        @NonNull
        public abstract Builder setBitrate(int i);

        @NonNull
        public abstract Builder setColorFormat(int i);

        @NonNull
        public abstract Builder setDataSpace(@NonNull VideoEncoderDataSpace videoEncoderDataSpace);

        @NonNull
        public abstract Builder setFrameRate(int i);

        @NonNull
        public abstract Builder setIFrameInterval(int i);

        @NonNull
        public abstract Builder setInputTimebase(@NonNull Timebase timebase);

        @NonNull
        public abstract Builder setMimeType(@NonNull String str);

        @NonNull
        public abstract Builder setProfile(int i);

        @NonNull
        public abstract Builder setResolution(@NonNull Size size);
    }

    @NonNull
    public static Builder builder() {
        return new AutoValue_VideoEncoderConfig.Builder().setProfile(-1).setIFrameInterval(1).setColorFormat(VIDEO_COLOR_FORMAT_DEFAULT).setDataSpace(VideoEncoderDataSpace.ENCODER_DATA_SPACE_UNSPECIFIED);
    }

    public abstract int getBitrate();

    public abstract int getColorFormat();

    @NonNull
    public abstract VideoEncoderDataSpace getDataSpace();

    public abstract int getFrameRate();

    public abstract int getIFrameInterval();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    @NonNull
    public abstract Timebase getInputTimebase();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    @NonNull
    public abstract String getMimeType();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    public abstract int getProfile();

    @NonNull
    public abstract Size getResolution();

    @Override // androidx.camera.video.internal.encoder.EncoderConfig
    @NonNull
    public MediaFormat toMediaFormat() {
        Size resolution = getResolution();
        MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(getMimeType(), resolution.getWidth(), resolution.getHeight());
        mediaFormatCreateVideoFormat.setInteger("color-format", getColorFormat());
        mediaFormatCreateVideoFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_BIT_RATE, getBitrate());
        mediaFormatCreateVideoFormat.setInteger("frame-rate", getFrameRate());
        mediaFormatCreateVideoFormat.setInteger("i-frame-interval", getIFrameInterval());
        if (getProfile() != -1) {
            mediaFormatCreateVideoFormat.setInteger(dx7.f41301a, getProfile());
        }
        VideoEncoderDataSpace dataSpace = getDataSpace();
        if (dataSpace.getStandard() != 0) {
            mediaFormatCreateVideoFormat.setInteger("color-standard", dataSpace.getStandard());
        }
        if (dataSpace.getTransfer() != 0) {
            mediaFormatCreateVideoFormat.setInteger("color-transfer", dataSpace.getTransfer());
        }
        if (dataSpace.getRange() != 0) {
            mediaFormatCreateVideoFormat.setInteger("color-range", dataSpace.getRange());
        }
        return mediaFormatCreateVideoFormat;
    }
}

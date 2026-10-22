package androidx.camera.video;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.Consumer;
import com.google.auto.value.AutoValue;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@AutoValue
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY})
public abstract class MediaSpec {
    private static final int AAC_DEFAULT_PROFILE = 2;
    private static final String AUDIO_ENCODER_MIME_MPEG4_DEFAULT = "audio/mp4a-latm";
    private static final String AUDIO_ENCODER_MIME_WEBM_DEFAULT = "audio/vorbis";
    public static final int OUTPUT_FORMAT_AUTO = -1;
    public static final int OUTPUT_FORMAT_MPEG_4 = 0;
    public static final int OUTPUT_FORMAT_WEBM = 1;
    private static final String VIDEO_ENCODER_MIME_MPEG4_DEFAULT = "video/avc";
    private static final String VIDEO_ENCODER_MIME_WEBM_DEFAULT = "video/x-vnd.on2.vp8";

    @AutoValue.Builder
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static abstract class Builder {
        @NonNull
        public abstract MediaSpec build();

        @NonNull
        public Builder configureAudio(@NonNull Consumer<AudioSpec.Builder> consumer) {
            AudioSpec.Builder builder = getAudioSpec().toBuilder();
            consumer.accept(builder);
            setAudioSpec(builder.build());
            return this;
        }

        @NonNull
        public Builder configureVideo(@NonNull Consumer<VideoSpec.Builder> consumer) {
            VideoSpec.Builder builder = getVideoSpec().toBuilder();
            consumer.accept(builder);
            setVideoSpec(builder.build());
            return this;
        }

        @SuppressLint({"KotlinPropertyAccess"})
        public abstract AudioSpec getAudioSpec();

        @SuppressLint({"KotlinPropertyAccess"})
        public abstract VideoSpec getVideoSpec();

        @NonNull
        public abstract Builder setAudioSpec(@NonNull AudioSpec audioSpec);

        @NonNull
        public abstract Builder setOutputFormat(int i);

        @NonNull
        public abstract Builder setVideoSpec(@NonNull VideoSpec videoSpec);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface OutputFormat {
    }

    @NonNull
    public static Builder builder() {
        return new AutoValue_MediaSpec.Builder().setOutputFormat(-1).setAudioSpec(AudioSpec.builder().build()).setVideoSpec(VideoSpec.builder().build());
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static String outputFormatToAudioMime(int i) {
        return i != 1 ? "audio/mp4a-latm" : "audio/vorbis";
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static int outputFormatToAudioProfile(int i) {
        return Objects.equals(outputFormatToAudioMime(i), "audio/mp4a-latm") ? 2 : -1;
    }

    public static int outputFormatToMuxerFormat(int i) {
        return i != 1 ? 0 : 1;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static String outputFormatToVideoMime(int i) {
        return i != 1 ? "video/avc" : "video/x-vnd.on2.vp8";
    }

    @NonNull
    public abstract AudioSpec getAudioSpec();

    public abstract int getOutputFormat();

    @NonNull
    public abstract VideoSpec getVideoSpec();

    @NonNull
    public abstract Builder toBuilder();
}

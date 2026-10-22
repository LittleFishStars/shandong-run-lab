package androidx.camera.video.internal.audio;

import android.annotation.SuppressLint;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.source.i;
import com.google.auto.value.AutoValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@AutoValue
@RequiresApi(21)
public abstract class AudioSettings {
    public static final List<Integer> COMMON_SAMPLE_RATES = Collections.unmodifiableList(Arrays.asList(48000, Integer.valueOf(i.K), 22050, 11025, 8000, 4800));

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract AudioSettings autoBuild();

        @NonNull
        public final AudioSettings build() {
            AudioSettings audioSettingsAutoBuild = autoBuild();
            String str = "";
            if (audioSettingsAutoBuild.getAudioSource() == -1) {
                str = " audioSource";
            }
            if (audioSettingsAutoBuild.getSampleRate() <= 0) {
                str = str + " sampleRate";
            }
            if (audioSettingsAutoBuild.getChannelCount() <= 0) {
                str = str + " channelCount";
            }
            if (audioSettingsAutoBuild.getAudioFormat() == -1) {
                str = str + " audioFormat";
            }
            if (str.isEmpty()) {
                return audioSettingsAutoBuild;
            }
            throw new IllegalArgumentException("Required settings missing or non-positive:" + str);
        }

        @NonNull
        public abstract Builder setAudioFormat(int i);

        @NonNull
        public abstract Builder setAudioSource(int i);

        @NonNull
        public abstract Builder setChannelCount(@IntRange(from = 1) int i);

        @NonNull
        public abstract Builder setSampleRate(@IntRange(from = 1) int i);
    }

    @NonNull
    @SuppressLint({"Range"})
    public static Builder builder() {
        return new AutoValue_AudioSettings.Builder().setAudioSource(-1).setSampleRate(-1).setChannelCount(-1).setAudioFormat(-1);
    }

    public abstract int getAudioFormat();

    public abstract int getAudioSource();

    public int getBytesPerFrame() {
        return AudioUtils.getBytesPerFrame(getAudioFormat(), getChannelCount());
    }

    @IntRange(from = 1)
    public abstract int getChannelCount();

    @IntRange(from = 1)
    public abstract int getSampleRate();

    @NonNull
    public abstract Builder toBuilder();
}

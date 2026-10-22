package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.google.auto.value.AutoValue;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@AutoValue
@RequiresApi(21)
public abstract class AudioStats {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final double AUDIO_AMPLITUDE_NONE = 0.0d;
    public static final int AUDIO_STATE_ACTIVE = 0;
    public static final int AUDIO_STATE_DISABLED = 1;
    public static final int AUDIO_STATE_ENCODER_ERROR = 3;
    public static final int AUDIO_STATE_MUTED = 5;
    public static final int AUDIO_STATE_SOURCE_ERROR = 4;
    public static final int AUDIO_STATE_SOURCE_SILENCED = 2;
    private static final Set<Integer> ERROR_STATES = Collections.unmodifiableSet(new HashSet(Arrays.asList(2, 3, 4)));

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface AudioState {
    }

    @NonNull
    public static AudioStats of(int i, @Nullable Throwable th, double d) {
        return new AutoValue_AudioStats(i, d, th);
    }

    @OptIn(markerClass = {ExperimentalAudioApi.class})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public double getAudioAmplitude() {
        return getAudioState() == 1 ? AUDIO_AMPLITUDE_NONE : getAudioAmplitudeInternal();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public abstract double getAudioAmplitudeInternal();

    public abstract int getAudioState();

    @Nullable
    public abstract Throwable getErrorCause();

    public boolean hasAudio() {
        return getAudioState() == 0;
    }

    public boolean hasError() {
        return ERROR_STATES.contains(Integer.valueOf(getAudioState()));
    }
}

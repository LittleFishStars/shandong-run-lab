package androidx.camera.video;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
final class AutoValue_AudioStats extends AudioStats {
    private final double audioAmplitudeInternal;
    private final int audioState;
    private final Throwable errorCause;

    public AutoValue_AudioStats(int i, double d, @Nullable Throwable th) {
        this.audioState = i;
        this.audioAmplitudeInternal = d;
        this.errorCause = th;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AudioStats)) {
            return false;
        }
        AudioStats audioStats = (AudioStats) obj;
        if (this.audioState == audioStats.getAudioState() && Double.doubleToLongBits(this.audioAmplitudeInternal) == Double.doubleToLongBits(audioStats.getAudioAmplitudeInternal())) {
            Throwable th = this.errorCause;
            if (th == null) {
                if (audioStats.getErrorCause() == null) {
                    return true;
                }
            } else if (th.equals(audioStats.getErrorCause())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.video.AudioStats
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public double getAudioAmplitudeInternal() {
        return this.audioAmplitudeInternal;
    }

    @Override // androidx.camera.video.AudioStats
    public int getAudioState() {
        return this.audioState;
    }

    @Override // androidx.camera.video.AudioStats
    @Nullable
    public Throwable getErrorCause() {
        return this.errorCause;
    }

    public int hashCode() {
        int iDoubleToLongBits = (((this.audioState ^ 1000003) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.audioAmplitudeInternal) >>> 32) ^ Double.doubleToLongBits(this.audioAmplitudeInternal)))) * 1000003;
        Throwable th = this.errorCause;
        return iDoubleToLongBits ^ (th == null ? 0 : th.hashCode());
    }

    public String toString() {
        return "AudioStats{audioState=" + this.audioState + ", audioAmplitudeInternal=" + this.audioAmplitudeInternal + ", errorCause=" + this.errorCause + "}";
    }
}

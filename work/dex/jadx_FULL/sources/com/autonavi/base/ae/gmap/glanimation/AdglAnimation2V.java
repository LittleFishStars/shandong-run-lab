package com.autonavi.base.ae.gmap.glanimation;

import android.os.SystemClock;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AdglAnimation2V extends AbstractAdglAnimation {
    private double curValue1;
    private double curValue2;
    private AbstractAdglAnimationParam2V v2Param = null;

    public AdglAnimation2V(int i) {
        reset();
        this.duration = i;
        this.curValue1 = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.curValue2 = AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation
    public void doAnimation(Object obj) {
        if (this.isOver) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis() - this.startTime;
        this.offsetTime = jUptimeMillis;
        float f = jUptimeMillis / this.duration;
        if (f > 1.0f) {
            this.isOver = true;
            f = 1.0f;
        } else if (f < 0.0f) {
            this.isOver = true;
            return;
        }
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.setNormalizedTime(f);
            this.curValue1 = this.v2Param.getCurXValue();
            this.curValue2 = this.v2Param.getCurYValue();
        }
    }

    public double getCurValue(int i) {
        return i == 0 ? this.curValue1 : this.curValue2;
    }

    public double getEndValue(int i) {
        if (i == 0) {
            AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
            return abstractAdglAnimationParam2V != null ? abstractAdglAnimationParam2V.getToXValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V2 = this.v2Param;
        return abstractAdglAnimationParam2V2 != null ? abstractAdglAnimationParam2V2.getToYValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public double getStartValue(int i) {
        if (i == 0) {
            AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
            return abstractAdglAnimationParam2V != null ? abstractAdglAnimationParam2V.getFromXValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V2 = this.v2Param;
        return abstractAdglAnimationParam2V2 != null ? abstractAdglAnimationParam2V2.getFromYValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public void reset() {
        this.isOver = false;
        this.duration = 0;
        this.curValue1 = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.curValue2 = AudioStats.AUDIO_AMPLITUDE_NONE;
        AbstractAdglAnimationParam2V abstractAdglAnimationParam2V = this.v2Param;
        if (abstractAdglAnimationParam2V != null) {
            abstractAdglAnimationParam2V.reset();
        }
    }
}

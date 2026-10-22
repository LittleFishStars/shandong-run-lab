package com.aliyun.svideosdk.common.struct.effect;

import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.project.Source;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class TrackEffectWaterMark extends EffectBase {
    protected EffectRect mEffectRect = new EffectRect();

    @Visible
    public static final class Builder {
        private TrackEffectWaterMark effectMv = new TrackEffectWaterMark();

        public TrackEffectWaterMark build() {
            return this.effectMv;
        }

        public Builder setHeightRatio(float f) {
            this.effectMv.setHeightRatio(f);
            return this;
        }

        public Builder setWidthRatio(float f) {
            this.effectMv.setWidthRatio(f);
            return this;
        }

        public Builder setXRadio(float f) {
            this.effectMv.setXRadio(f);
            return this;
        }

        public Builder setYRatio(float f) {
            this.effectMv.setYRatio(f);
            return this;
        }

        public Builder source(Source source) {
            this.effectMv.setSource(source);
            return this;
        }
    }

    public float getHeightRatio() {
        return this.mEffectRect.getHeightRatio();
    }

    public float getWidthRatio() {
        return this.mEffectRect.getWidthRatio();
    }

    public float getXRadio() {
        return this.mEffectRect.getXRadio();
    }

    public float getYRadio() {
        return this.mEffectRect.getYRadio();
    }

    public void setHeightRatio(float f) {
        this.mEffectRect.setHeightRatio(f);
    }

    public void setWidthRatio(float f) {
        this.mEffectRect.setWidthRatio(f);
    }

    public void setXRadio(float f) {
        this.mEffectRect.setXRadio(f);
    }

    public void setYRatio(float f) {
        this.mEffectRect.setYRatio(f);
    }
}

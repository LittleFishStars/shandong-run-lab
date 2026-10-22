package com.aliyun.svideosdk.common.struct.effect;

import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.project.FrameTime;
import com.aliyun.svideosdk.common.struct.project.Source;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class EffectPaster extends EffectBase {
    public static final int PASTER_TYPE_CAPTION = 2;
    public static final int PASTER_TYPE_GIF = 0;
    public static final int PASTER_TYPE_IMAGE = 3;

    @Deprecated
    public static final int PASTER_TYPE_TEXT = 1;
    public ActionBase action;
    public int displayHeight;
    public int displayWidth;
    public long duration;
    public long end;
    public List<com.aliyun.svideosdk.common.struct.project.Frame> frameArry;
    public int height;
    public boolean isTrack;

    @Deprecated
    public int kernelFrame;
    private float mHeightRatio;
    private float mWidthRatio;
    private float mXRatio;
    private float mYRatio;
    public boolean mirror;
    public String name;
    public float rotation;
    public long start;
    public List<FrameTime> timeArry;
    public int width;
    public float x;
    public float y;

    public EffectPaster(Source source) {
        this.isTrack = true;
        setSource(source);
    }

    @Deprecated
    public EffectPaster(String str) {
        this(new Source(str));
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.EffectBase
    public void copy(EffectBase effectBase) {
        super.copy(effectBase);
        if (effectBase instanceof EffectPaster) {
            EffectPaster effectPaster = (EffectPaster) effectBase;
            effectPaster.name = this.name;
            effectPaster.duration = this.duration;
            effectPaster.rotation = this.rotation;
            effectPaster.x = this.x;
            effectPaster.y = this.y;
            effectPaster.start = this.start;
            effectPaster.end = this.end;
            effectPaster.frameArry = this.frameArry;
            effectPaster.timeArry = this.timeArry;
            effectPaster.width = this.width;
            effectPaster.height = this.height;
            effectPaster.displayWidth = this.displayWidth;
            effectPaster.displayHeight = this.displayHeight;
            effectPaster.isTrack = this.isTrack;
            effectPaster.kernelFrame = this.kernelFrame;
            effectPaster.mWidthRatio = this.mWidthRatio;
            effectPaster.mHeightRatio = this.mHeightRatio;
            effectPaster.mirror = this.mirror;
            effectPaster.mXRatio = this.mXRatio;
            effectPaster.mYRatio = this.mYRatio;
        }
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof EffectPaster) && getViewId() == ((EffectPaster) obj).getViewId();
    }

    public float getHeightRatio() {
        return this.mHeightRatio;
    }

    public int getPasterType() {
        return 0;
    }

    public float getWidthRatio() {
        return this.mWidthRatio;
    }

    public float getXRatio() {
        return this.mXRatio;
    }

    public float getYRatio() {
        return this.mYRatio;
    }

    public void setHeightRatio(float f) {
        this.mHeightRatio = f;
    }

    public void setWidthRatio(float f) {
        this.mWidthRatio = f;
    }

    public void setXRatio(float f) {
        this.mXRatio = f;
    }

    public void setYRatio(float f) {
        this.mYRatio = f;
    }

    public EffectSticker toEffectSticker() {
        EffectSticker effectSticker = new EffectSticker(this.mSource);
        effectSticker.viewId = this.viewId;
        effectSticker.resId = this.resId;
        effectSticker.setXRadio(this.x);
        effectSticker.setYRatio(this.y);
        effectSticker.setWidthRatio(this.width);
        effectSticker.setHeightRatio(this.height);
        effectSticker.setRotation(this.rotation);
        effectSticker.setFlipH(this.mirror);
        return effectSticker;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.EffectBase
    public String toString() {
        return "EffectPaster{, name='" + this.name + "', width=" + this.width + ", height=" + this.height + ", displayWidth=" + this.displayWidth + ", displayHeight=" + this.displayHeight + ", start=" + this.start + ", end=" + this.end + ", y=" + this.y + ", x=" + this.x + ", rotation=" + this.rotation + ", duration=" + this.duration + ", kernelFrame=" + this.kernelFrame + ", frameArry=" + this.frameArry + ", timeArry=" + this.timeArry + ", mXRatio=" + this.mXRatio + ", mYRatio=" + this.mYRatio + ", mWidthRatio=" + this.mWidthRatio + ", mHeightRatio=" + this.mHeightRatio + ", mirror=" + this.mirror + ", isTrack=" + this.isTrack + '}';
    }
}

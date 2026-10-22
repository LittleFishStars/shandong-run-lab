package com.aliyun.svideosdk.editor.impl;

import android.graphics.PointF;
import android.graphics.RectF;
import com.aliyun.Visible;
import com.aliyun.common.utils.Size;
import com.aliyun.svideosdk.common.struct.effect.EffectImage;
import com.aliyun.svideosdk.common.struct.effect.TrackEffect;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public class AliyunPasterControllerImage extends AliyunPasterAbstractController<TrackEffect<EffectImage>> {
    private f mEditor;

    public AliyunPasterControllerImage(TrackEffect<EffectImage> trackEffect, o oVar, f fVar) {
        super(trackEffect, oVar);
        this.mEditor = fVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void apply() {
        if (((TrackEffect) this.mModel).getViewId() != 0) {
            this.mEditor.b((TrackEffect<EffectImage>) this.mModel);
        }
        ((TrackEffect) this.mModel).setViewId(this.mEditor.a((TrackEffect<EffectImage>) this.mModel));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public long getDuration() {
        return TimeUnit.MILLISECONDS.toMicros(((TrackEffect) this.mModel).getDuration());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public PointF getPosition() {
        PointF pointF = new PointF(((EffectImage) ((TrackEffect) this.mModel).getBean()).getXRadio(), ((EffectImage) ((TrackEffect) this.mModel).getBean()).getYRadio());
        Size displaySize = this.mRender.getDisplaySize();
        pointF.x *= displaySize.getWidth();
        pointF.y *= displaySize.getHeight();
        return pointF;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public float getRotate() {
        return ((EffectImage) ((TrackEffect) this.mModel).getBean()).getRotation();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public RectF getSize() {
        float xRadio = ((EffectImage) ((TrackEffect) this.mModel).getBean()).getXRadio();
        float yRadio = ((EffectImage) ((TrackEffect) this.mModel).getBean()).getYRadio();
        float widthRatio = ((EffectImage) ((TrackEffect) this.mModel).getBean()).getWidthRatio();
        float heightRatio = ((EffectImage) ((TrackEffect) this.mModel).getBean()).getHeightRatio();
        Size displaySize = this.mRender.getDisplaySize();
        float f = widthRatio * 0.5f;
        float f2 = heightRatio * 0.5f;
        RectF rectF = new RectF(xRadio - f, yRadio - f2, xRadio + f, yRadio + f2);
        rectF.left *= displaySize.getWidth();
        rectF.right *= displaySize.getWidth();
        rectF.top *= displaySize.getHeight();
        rectF.bottom *= displaySize.getHeight();
        return rectF;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public long getStartTime() {
        return TimeUnit.MILLISECONDS.toMicros(((TrackEffect) this.mModel).getStartTime());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public int getType() {
        return 3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.impl.g
    public int remove() {
        this.mEditor.b((TrackEffect<EffectImage>) this.mModel);
        ((TrackEffect) this.mModel).setViewId(0);
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public void setDuration(long j, TimeUnit timeUnit) {
        ((TrackEffect) this.mModel).setDuration(j, timeUnit);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public void setPosition(PointF pointF) {
        PointF pointF2 = new PointF();
        Size displaySize = this.mRender.getDisplaySize();
        pointF2.x = pointF.x / displaySize.getWidth();
        pointF2.y = pointF.y / displaySize.getHeight();
        ((EffectImage) ((TrackEffect) this.mModel).getBean()).setXRadio(pointF2.x);
        ((EffectImage) ((TrackEffect) this.mModel).getBean()).setYRatio(pointF2.y);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public void setRotate(float f) {
        ((EffectImage) ((TrackEffect) this.mModel).getBean()).setRotation(f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setSize(float f, float f2) {
        Size displaySize = this.mRender.getDisplaySize();
        float width = f / displaySize.getWidth();
        float height = f2 / displaySize.getHeight();
        ((EffectImage) ((TrackEffect) this.mModel).getBean()).setWidthRatio(width);
        ((EffectImage) ((TrackEffect) this.mModel).getBean()).setHeightRatio(height);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public void setStartTime(long j, TimeUnit timeUnit) {
        ((TrackEffect) this.mModel).setStartTime(j, timeUnit);
    }
}

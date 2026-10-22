package com.aliyun.svideosdk.editor.impl;

import android.graphics.PointF;
import android.graphics.RectF;
import com.aliyun.Visible;
import com.aliyun.common.utils.Size;
import com.aliyun.svideosdk.common.AliyunCaption;
import com.aliyun.svideosdk.common.AliyunColor;
import com.aliyun.svideosdk.common.AliyunFontStyle;
import com.aliyun.svideosdk.common.AliyunTypeface;
import com.aliyun.svideosdk.common.ISource;
import com.aliyun.svideosdk.common.struct.effect.ActionBase;
import com.aliyun.svideosdk.common.struct.project.Source;
import com.aliyun.svideosdk.editor.AliyunPasterRender;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public class AliyunPasterControllerCompoundCaption extends AliyunPasterAbstractController<AliyunCaption> {
    public static final int AlignCenter = 4;
    public static final int AlignLeft = 1;
    public static final int AlignRight = 2;

    public AliyunPasterControllerCompoundCaption(AliyunCaption aliyunCaption, AliyunPasterRender aliyunPasterRender) {
        super(aliyunCaption, aliyunPasterRender);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int addFrameAnimation(ActionBase actionBase) {
        actionBase.setTargetId(((AliyunCaption) this.mModel).getId());
        int iHashCode = actionBase.hashCode();
        actionBase.setId(iHashCode);
        ((AliyunCaption) this.mModel).addAction(actionBase);
        return iHashCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int apply() {
        return ((AliyunCaption) this.mModel).getId() == 0 ? this.mRender.addCaption((AliyunCaption) this.mModel) : this.mRender.updateCaption((AliyunCaption) this.mModel);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int clearFrameAnimation() {
        ((AliyunCaption) this.mModel).clearAction();
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AliyunColor getBackgroundColor() {
        return ((AliyunCaption) this.mModel).getBackgroundColor();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public float getBackgroundCornerRadius() {
        return ((AliyunCaption) this.mModel).getBackgroundCornerRadius() * this.mRender.getDisplaySize().getWidth();
    }

    public String getBubbleEffectTemplate() {
        if (getBubbleEffectTemplateSource() != null) {
            return getBubbleEffectTemplateSource().getPath();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ISource getBubbleEffectTemplateSource() {
        return ((AliyunCaption) this.mModel).getBubbleSource();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AliyunColor getColor() {
        return ((AliyunCaption) this.mModel).getColor();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public long getDuration() {
        return ((AliyunCaption) this.mModel).getDuration();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getFontEffectTemplate() {
        if (((AliyunCaption) this.mModel).getFontEffectSource() != null) {
            return ((AliyunCaption) this.mModel).getFontEffectSource().getPath();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ISource getFontEffectTemplateSource() {
        return ((AliyunCaption) this.mModel).getFontEffectSource();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ISource getFontPath() {
        return ((AliyunCaption) this.mModel).getFontSource();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public AliyunFontStyle getFontStyle() {
        return ((AliyunCaption) this.mModel).getFontStyle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AliyunTypeface getFontTypeface() {
        return ((AliyunCaption) this.mModel).getFontStyle().getTypeface();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public List<ActionBase> getFrameAnimations() {
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = ((AliyunCaption) this.mModel).getActionList().iterator();
        while (it.hasNext()) {
            arrayList.add((ActionBase) it.next());
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AliyunColor getOutlineColor() {
        return ((AliyunCaption) this.mModel).getOutlineColor();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public float getOutlineWidth() {
        return ((AliyunCaption) this.mModel).getOutlineWidth();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public PointF getPosition() {
        PointF position = ((AliyunCaption) this.mModel).getPosition();
        Size displaySize = this.mRender.getDisplaySize();
        position.x *= displaySize.getWidth();
        position.y *= displaySize.getHeight();
        return position;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public float getRotate() {
        return ((AliyunCaption) this.mModel).getRotate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public float getScale() {
        return ((AliyunCaption) this.mModel).getScale();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AliyunColor getShadowColor() {
        return ((AliyunCaption) this.mModel).getShadowColor();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PointF getShadowOffset() {
        return ((AliyunCaption) this.mModel).getShadowOffset();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public RectF getSize() {
        RectF size = ((AliyunCaption) this.mModel).getSize();
        Size displaySize = this.mRender.getDisplaySize();
        size.left *= displaySize.getWidth();
        size.right *= displaySize.getWidth();
        size.top *= displaySize.getHeight();
        size.bottom *= displaySize.getHeight();
        return size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public long getStartTime() {
        return ((AliyunCaption) this.mModel).getStartTime();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getText() {
        return ((AliyunCaption) this.mModel).getText();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int getTextAlignment() {
        return ((AliyunCaption) this.mModel).getTextAlignment();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public int getType() {
        return 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.impl.g
    public int remove() {
        return this.mRender.removeCaption((AliyunCaption) this.mModel);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int removeFrameAnimation(ActionBase actionBase) {
        return ((AliyunCaption) this.mModel).removeAction(actionBase);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackgroundColor(AliyunColor aliyunColor) {
        ((AliyunCaption) this.mModel).setBackgroundColor(aliyunColor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackgroundCornerRadius(float f) {
        ((AliyunCaption) this.mModel).setBackgroundCornerRadius(f / this.mRender.getDisplaySize().getWidth());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBubbleEffectTemplate(Source source) {
        ((AliyunCaption) this.mModel).setBubbleSource(source);
    }

    public void setBubbleEffectTemplate(String str) {
        setBubbleEffectTemplate(new Source(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setColor(AliyunColor aliyunColor) {
        ((AliyunCaption) this.mModel).setColor(aliyunColor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public void setDuration(long j, TimeUnit timeUnit) {
        ((AliyunCaption) this.mModel).setDuration(timeUnit.toMicros(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setFontEffectTemplate(Source source) {
        ((AliyunCaption) this.mModel).setFontEffectSource(source);
    }

    public void setFontEffectTemplate(String str) {
        setFontEffectTemplate(new Source(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setFontPath(ISource iSource) {
        AliyunFontStyle fontStyle = ((AliyunCaption) this.mModel).getFontStyle();
        fontStyle.setFontSource(iSource);
        ((AliyunCaption) this.mModel).setFontStyle(fontStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public void setFontStyle(AliyunFontStyle aliyunFontStyle) {
        ((AliyunCaption) this.mModel).setFontStyle(aliyunFontStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setFontTypeface(AliyunTypeface aliyunTypeface) {
        AliyunFontStyle fontStyle = ((AliyunCaption) this.mModel).getFontStyle();
        fontStyle.setTypeface(aliyunTypeface);
        ((AliyunCaption) this.mModel).setFontStyle(fontStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int setFrameAnimation(ActionBase actionBase) {
        if (actionBase == null) {
            return ((AliyunCaption) this.mModel).clearAction();
        }
        actionBase.setTargetId(((AliyunCaption) this.mModel).getId());
        int iHashCode = actionBase.hashCode();
        actionBase.setId(iHashCode);
        ((AliyunCaption) this.mModel).clearAction();
        ((AliyunCaption) this.mModel).addAction(actionBase);
        return iHashCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOutlineColor(AliyunColor aliyunColor) {
        ((AliyunCaption) this.mModel).setOutlineColor(aliyunColor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setOutlineWidth(float f) {
        ((AliyunCaption) this.mModel).setOutlineWidth(f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public void setPosition(PointF pointF) {
        PointF pointF2 = new PointF();
        Size displaySize = this.mRender.getDisplaySize();
        pointF2.x = pointF.x / displaySize.getWidth();
        pointF2.y = pointF.y / displaySize.getHeight();
        ((AliyunCaption) this.mModel).setPosition(pointF2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public void setRotate(float f) {
        ((AliyunCaption) this.mModel).setRotate(f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setScale(float f) {
        ((AliyunCaption) this.mModel).setScale(f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setShadowColor(AliyunColor aliyunColor) {
        ((AliyunCaption) this.mModel).setShadowColor(aliyunColor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setShadowOffset(PointF pointF) {
        ((AliyunCaption) this.mModel).setShadowOffset(pointF);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.aliyun.svideosdk.editor.AliyunIPasterController
    public void setStartTime(long j, TimeUnit timeUnit) {
        ((AliyunCaption) this.mModel).setStartTime(timeUnit.toMicros(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setText(String str) {
        ((AliyunCaption) this.mModel).setText(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTextAlignment(int i) {
        ((AliyunCaption) this.mModel).setTextAlignment(i);
    }
}

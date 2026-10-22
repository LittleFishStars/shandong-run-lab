package com.aliyun.svideosdk.common.struct.project;

import android.graphics.PointF;
import android.graphics.RectF;
import com.aliyun.svideosdk.common.AliyunCaption;
import com.aliyun.svideosdk.common.AliyunColor;
import com.aliyun.svideosdk.common.AliyunFontStyle;
import com.aliyun.svideosdk.common.AliyunTypeface;
import com.aliyun.svideosdk.common.struct.effect.ActionBase;
import com.google.android.exoplayer2.source.rtsp.d;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CaptionTrack extends PhotoPasterTrack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient AliyunCaption f25675a;

    @SerializedName("Text")
    private String b;

    @SerializedName("FontSize")
    private float c;

    @SerializedName("FaceType")
    private int d;

    @SerializedName("TextColor")
    private int e;

    @SerializedName("OutlineColor")
    private int f;

    @SerializedName("OutlineWidth")
    private float g;

    @SerializedName("ShadowColor")
    private int h;

    @SerializedName("ShadowOffsetH")
    private float i;

    @SerializedName("ShadowOffsetV")
    private float j;

    @SerializedName("Font")
    private Source k;

    @SerializedName("FontEffectSource")
    private Source l;

    @SerializedName("TextAlignment")
    private int m;

    @SerializedName(d.x)
    public float mScale;

    @SerializedName("TextBgColor")
    private int n;

    @SerializedName("BackgroundCornerRadius")
    private float o;

    public CaptionTrack() {
        setType(PasterTrack.Type.caption);
    }

    public static CaptionTrack fromCaption(AliyunCaption aliyunCaption) {
        CaptionTrack captionTrack = new CaptionTrack();
        captionTrack.setCaption(aliyunCaption);
        captionTrack.setId(aliyunCaption.getId());
        captionTrack.updateInfo();
        return captionTrack;
    }

    public int getBackgroundColor() {
        return this.n;
    }

    public float getBackgroundCornerRadius() {
        return this.o;
    }

    public Source getFont() {
        return this.k;
    }

    public Source getFontEffectSource() {
        return this.l;
    }

    public float getFontSize() {
        return this.c;
    }

    public int getOutlineColor() {
        return this.f;
    }

    public float getOutlineWidth() {
        return this.g;
    }

    public float getScale() {
        return this.mScale;
    }

    public int getShadowColor() {
        return this.h;
    }

    public float getShadowOffsetX() {
        return this.i;
    }

    public float getShadowOffsetY() {
        return this.j;
    }

    public String getText() {
        return this.b;
    }

    public int getTextAlignment() {
        return this.m;
    }

    public int getTextColor() {
        return this.e;
    }

    public int getTypeface() {
        return this.d;
    }

    public void setBackgroundColor(int i) {
        this.n = i;
    }

    public void setBackgroundCornerRadius(float f) {
        this.o = f;
    }

    public void setCaption(AliyunCaption aliyunCaption) {
        this.f25675a = aliyunCaption;
    }

    public void setFont(Source source) {
        this.k = source;
    }

    public void setFontEffectSource(Source source) {
        this.l = source;
    }

    public void setFontSize(float f) {
        this.c = f;
    }

    public void setOutlineColor(int i) {
        this.f = i;
    }

    public void setOutlineWidth(float f) {
        this.g = f;
    }

    public void setScale(float f) {
        this.mScale = f;
    }

    public void setShadowColor(int i) {
        this.h = i;
    }

    public void setShadowOffsetX(float f) {
        this.i = f;
    }

    public void setShadowOffsetY(float f) {
        this.j = f;
    }

    public void setText(String str) {
        this.b = str;
    }

    public void setTextAlignment(int i) {
        this.m = i;
    }

    public void setTextColor(int i) {
        this.e = i;
    }

    public void setTypeface(int i) {
        this.d = i;
    }

    public AliyunCaption toCaption() {
        AliyunCaption aliyunCaption = this.f25675a;
        if (aliyunCaption == null) {
            aliyunCaption = new AliyunCaption();
            setCaption(aliyunCaption);
        }
        if (getFontEffectSource() != null) {
            aliyunCaption.setFontEffectSource(getFontEffectSource());
        }
        if (getSource() != null) {
            aliyunCaption.setBubbleSource(getSource());
        }
        aliyunCaption.setStartTime((long) (getTimelineIn() * 1000000.0f));
        aliyunCaption.setDuration((long) ((getTimelineOut() - getTimelineIn()) * 1000000.0f));
        aliyunCaption.setRotate(getRotation());
        aliyunCaption.setScale(getScale());
        aliyunCaption.setText(getText());
        aliyunCaption.setSize(new RectF(0.0f, 0.0f, getWidth(), getHeight()));
        aliyunCaption.setPosition(new PointF(getX(), getY()));
        aliyunCaption.setFontStyle(getFont() == null ? new AliyunFontStyle("", getFontSize(), AliyunTypeface.get(getTypeface())) : new AliyunFontStyle(getFont(), getFontSize(), AliyunTypeface.get(getTypeface())));
        aliyunCaption.setColor(new AliyunColor(getTextColor()));
        aliyunCaption.setOutlineColor(new AliyunColor(getOutlineColor()));
        aliyunCaption.setOutlineWidth(getOutlineWidth());
        aliyunCaption.setShadowColor(new AliyunColor(getShadowColor()));
        aliyunCaption.setTextAlignment(getTextAlignment());
        aliyunCaption.setBackgroundColor(new AliyunColor(getBackgroundColor()));
        aliyunCaption.setBackgroundCornerRadius(getBackgroundCornerRadius());
        aliyunCaption.setShadowOffset(new PointF(getShadowOffsetX(), getShadowOffsetY()));
        aliyunCaption.getActionList().clear();
        Iterator<ActionBase> it = getActions().iterator();
        while (it.hasNext()) {
            aliyunCaption.addAction(it.next());
        }
        return aliyunCaption;
    }

    @Override // com.aliyun.svideosdk.common.struct.project.PhotoPasterTrack
    public String toString() {
        return super.toString() + "CompoundCaption{mText='" + this.b + "', mScale=" + this.mScale + ", mFontSize=" + this.c + ", mTypeface=" + this.d + ", mFontColor=" + this.e + ", mOutlineColor=" + this.f + ", mOutlineWidth=" + this.g + ", mShadowColor=" + this.h + ", mShadowOffsetX=" + this.i + ", mShadowOffsetY=" + this.j + ", mFont=" + this.k + ", mFontEffect=" + this.l + '}';
    }

    public void updateInfo() {
        AliyunCaption aliyunCaption = this.f25675a;
        if (aliyunCaption == null) {
            return;
        }
        setTimelineIn(aliyunCaption.getStartTime() / 1000000.0f);
        setTimelineOut(getTimelineIn() + (this.f25675a.getDuration() / 1000000.0f));
        setRotation(this.f25675a.getRotate());
        setScale(this.f25675a.getScale());
        setText(this.f25675a.getText());
        PointF position = this.f25675a.getPosition();
        setX(position.x);
        setY(position.y);
        RectF size = this.f25675a.getSize();
        setWidth(size.width());
        setHeight(size.height());
        AliyunFontStyle fontStyle = this.f25675a.getFontStyle();
        setFontSize(fontStyle.getFontSize());
        if (fontStyle.getFontSource() != null) {
            setFont(new Source(fontStyle.getFontSource().getId(), fontStyle.getFontSource().getPath(), fontStyle.getFontSource().getURL()));
        }
        setTypeface(fontStyle.getTypeface().ordinal());
        setTextColor(this.f25675a.getColor().toArgb());
        setOutlineColor(this.f25675a.getOutlineColor().toArgb());
        setOutlineWidth(this.f25675a.getOutlineWidth());
        setShadowColor(this.f25675a.getShadowColor().toArgb());
        PointF shadowOffset = this.f25675a.getShadowOffset();
        setShadowOffsetX(shadowOffset.x);
        setShadowOffsetY(shadowOffset.y);
        setBackgroundColor(this.f25675a.getBackgroundColor().toArgb());
        setBackgroundCornerRadius(this.f25675a.getBackgroundCornerRadius());
        setTextAlignment(this.f25675a.getTextAlignment());
        if (this.f25675a.getFontEffectSource() != null) {
            setFontEffectSource(new Source(this.f25675a.getFontEffectSource().getId(), this.f25675a.getFontEffectSource().getPath(), this.f25675a.getFontEffectSource().getURL()));
        }
        if (this.f25675a.getBubbleSource() != null) {
            setSource(new Source(this.f25675a.getBubbleSource().getId(), this.f25675a.getBubbleSource().getPath(), this.f25675a.getBubbleSource().getURL()));
        }
        List<Object> actionList = this.f25675a.getActionList();
        getActions().clear();
        for (Object obj : actionList) {
            if (obj instanceof ActionBase) {
                getActions().add((ActionBase) obj);
            }
        }
    }
}

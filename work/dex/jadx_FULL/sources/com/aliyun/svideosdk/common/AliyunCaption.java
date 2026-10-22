package com.aliyun.svideosdk.common;

import android.graphics.PointF;
import android.graphics.RectF;
import com.aliyun.Visible;
import com.aliyun.common.utils.q;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class AliyunCaption extends AliyunObject {
    private static final int ALIVC_OBJECT_NOT_INITED = -20011025;
    protected List<Object> mActions = new ArrayList();
    private ISource mBubbleSource;
    private ISource mFontEffectSource;
    private ISource mFontSource;

    public AliyunCaption() {
        this.mNativeHandle = nativeCreate();
    }

    private AliyunCaption(long j) {
        this.mNativeHandle = j;
    }

    private native void nativeAddFrameAnimation(long j, Object obj);

    private native void nativeClearFrameAnimation(long j);

    private native long nativeCreate();

    private native void nativeDispose(long j);

    private native AliyunColor nativeGetBackgroundColor(long j);

    private native float nativeGetBackgroundCornerRadius(long j);

    private native String nativeGetBubbleEffectTemplate(long j);

    private native AliyunColor nativeGetColor(long j);

    private native long nativeGetDuration(long j);

    private native String nativeGetFontEffectTemplate(long j);

    private native AliyunFontStyle nativeGetFontStyle(long j);

    private native int nativeGetId(long j);

    private native AliyunColor nativeGetOutlineColor(long j);

    private native float nativeGetOutlineWidth(long j);

    private native PointF nativeGetPosition(long j);

    private native float nativeGetRotation(long j);

    private native float nativeGetScale(long j);

    private native AliyunColor nativeGetShadowColor(long j);

    private native PointF nativeGetShadowOffset(long j);

    private native RectF nativeGetSize(long j);

    private native long nativeGetStartTime(long j);

    private native String nativeGetText(long j);

    private native int nativeGetTextAlignment(long j);

    private native void nativeRemoveFrameAnimation(long j, Object obj);

    private native void nativeSetBackgroundColor(long j, AliyunColor aliyunColor);

    private native void nativeSetBackgroundCornerRadius(long j, float f);

    private native void nativeSetBubbleEffectTemplate(long j, String str);

    private native void nativeSetColor(long j, AliyunColor aliyunColor);

    private native void nativeSetDuration(long j, long j2);

    private native void nativeSetFontEffectTemplate(long j, String str);

    private native void nativeSetFontStyle(long j, AliyunFontStyle aliyunFontStyle);

    private native void nativeSetOutlineColor(long j, AliyunColor aliyunColor);

    private native void nativeSetOutlineWidth(long j, float f);

    private native void nativeSetPosition(long j, PointF pointF);

    private native void nativeSetRotation(long j, float f);

    private native void nativeSetScale(long j, float f);

    private native void nativeSetShadowColor(long j, AliyunColor aliyunColor);

    private native void nativeSetShadowOffset(long j, PointF pointF);

    private native void nativeSetSize(long j, RectF rectF);

    private native void nativeSetStartTime(long j, long j2);

    private native void nativeSetText(long j, String str);

    private native void nativeSetTextAlignment(long j, int i);

    public int addAction(Object obj) {
        if (this.mNativeHandle == 0) {
            return ALIVC_OBJECT_NOT_INITED;
        }
        this.mActions.add(obj);
        nativeAddFrameAnimation(this.mNativeHandle, obj);
        return 0;
    }

    public int clearAction() {
        if (this.mNativeHandle == 0) {
            return ALIVC_OBJECT_NOT_INITED;
        }
        this.mActions.clear();
        nativeClearFrameAnimation(this.mNativeHandle);
        return 0;
    }

    public List<Object> getActionList() {
        return this.mActions;
    }

    public AliyunColor getBackgroundColor() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetBackgroundColor(j);
        }
        return null;
    }

    public float getBackgroundCornerRadius() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetBackgroundCornerRadius(j);
        }
        return 0.0f;
    }

    public ISource getBubbleSource() {
        return this.mBubbleSource;
    }

    public AliyunColor getColor() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetColor(j);
        }
        return null;
    }

    public long getDuration() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetDuration(j);
        }
        return -20011025L;
    }

    public ISource getFontEffectSource() {
        return this.mFontEffectSource;
    }

    public ISource getFontSource() {
        return this.mFontSource;
    }

    public AliyunFontStyle getFontStyle() {
        ISource iSource;
        long j = this.mNativeHandle;
        if (j == 0) {
            return null;
        }
        AliyunFontStyle aliyunFontStyleNativeGetFontStyle = nativeGetFontStyle(j);
        if (aliyunFontStyleNativeGetFontStyle != null && (iSource = this.mFontSource) != null) {
            aliyunFontStyleNativeGetFontStyle.setFontSource(iSource);
        }
        return aliyunFontStyleNativeGetFontStyle;
    }

    public int getId() {
        long j = this.mNativeHandle;
        return j != 0 ? nativeGetId(j) : ALIVC_OBJECT_NOT_INITED;
    }

    public AliyunColor getOutlineColor() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetOutlineColor(j);
        }
        return null;
    }

    public float getOutlineWidth() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetOutlineWidth(j);
        }
        return -2.0011024E7f;
    }

    public PointF getPosition() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetPosition(j);
        }
        return null;
    }

    public float getRotate() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetRotation(j);
        }
        return -2.0011024E7f;
    }

    public float getScale() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetScale(j);
        }
        return -2.0011024E7f;
    }

    public AliyunColor getShadowColor() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetShadowColor(j);
        }
        return null;
    }

    public PointF getShadowOffset() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetShadowOffset(j);
        }
        return null;
    }

    public RectF getSize() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetSize(j);
        }
        return null;
    }

    public long getStartTime() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetStartTime(j);
        }
        return -20011025L;
    }

    public String getText() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetText(j);
        }
        return null;
    }

    public int getTextAlignment() {
        long j = this.mNativeHandle;
        if (j != 0) {
            return nativeGetTextAlignment(j);
        }
        return 1;
    }

    public int removeAction(Object obj) {
        if (this.mNativeHandle == 0) {
            return ALIVC_OBJECT_NOT_INITED;
        }
        this.mActions.remove(obj);
        nativeRemoveFrameAnimation(this.mNativeHandle, obj);
        return 0;
    }

    public void setBackgroundColor(AliyunColor aliyunColor) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetBackgroundColor(j, aliyunColor);
        }
    }

    public void setBackgroundCornerRadius(float f) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetBackgroundCornerRadius(j, f);
        }
    }

    public void setBubbleSource(ISource iSource) {
        if (this.mNativeHandle != 0) {
            this.mBubbleSource = iSource;
            nativeSetBubbleEffectTemplate(this.mNativeHandle, iSource != null ? iSource.getPath() : null);
        }
    }

    public void setColor(AliyunColor aliyunColor) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetColor(j, aliyunColor);
        }
    }

    public void setDuration(long j) {
        long j2 = this.mNativeHandle;
        if (j2 != 0) {
            nativeSetDuration(j2, j);
        }
    }

    public void setFontEffectSource(ISource iSource) {
        if (this.mNativeHandle != 0) {
            this.mFontEffectSource = iSource;
            nativeSetFontEffectTemplate(this.mNativeHandle, iSource != null ? iSource.getPath() : null);
        }
    }

    public void setFontStyle(AliyunFontStyle aliyunFontStyle) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetFontStyle(j, aliyunFontStyle);
            String path = aliyunFontStyle.getFontSource() != null ? aliyunFontStyle.getFontSource().getPath() : null;
            ISource iSource = this.mFontSource;
            if (iSource == null || q.b(iSource.getPath()) || !this.mFontSource.getPath().equals(path)) {
                this.mFontSource = aliyunFontStyle.getFontSource();
            }
        }
    }

    public void setOutlineColor(AliyunColor aliyunColor) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetOutlineColor(j, aliyunColor);
        }
    }

    public void setOutlineWidth(float f) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetOutlineWidth(j, f);
        }
    }

    public void setPosition(PointF pointF) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetPosition(j, pointF);
        }
    }

    public void setRotate(float f) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetRotation(j, f);
        }
    }

    public void setScale(float f) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetScale(j, f);
        }
    }

    public void setShadowColor(AliyunColor aliyunColor) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetShadowColor(j, aliyunColor);
        }
    }

    public void setShadowOffset(PointF pointF) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetShadowOffset(j, pointF);
        }
    }

    public void setSize(RectF rectF) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetSize(j, rectF);
        }
    }

    public void setStartTime(long j) {
        long j2 = this.mNativeHandle;
        if (j2 != 0) {
            nativeSetStartTime(j2, j);
        }
    }

    public void setText(String str) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetText(j, str);
        }
    }

    public void setTextAlignment(int i) {
        long j = this.mNativeHandle;
        if (j != 0) {
            nativeSetTextAlignment(j, i);
        }
    }
}

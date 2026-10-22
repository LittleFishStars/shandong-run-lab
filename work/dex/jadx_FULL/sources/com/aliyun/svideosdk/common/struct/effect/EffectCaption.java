package com.aliyun.svideosdk.common.struct.effect;

import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.project.Source;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class EffectCaption extends EffectText {
    public int gifViewId;
    public long preBegin;
    public long preEnd;
    public long textBegin;
    public int textCenterX;
    public int textCenterY;
    public long textEnd;
    public float textRotation;

    public EffectCaption(Source source) {
        super(source);
        this.gifViewId = 0;
    }

    @Deprecated
    public EffectCaption(String str) {
        super(str);
        this.gifViewId = 0;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.EffectText, com.aliyun.svideosdk.common.struct.effect.EffectPaster, com.aliyun.svideosdk.common.struct.effect.EffectBase
    public void copy(EffectBase effectBase) {
        super.copy(effectBase);
        if (effectBase instanceof EffectCaption) {
            EffectCaption effectCaption = (EffectCaption) effectBase;
            effectCaption.gifViewId = this.gifViewId;
            effectCaption.textBegin = this.textBegin;
            effectCaption.textEnd = this.textEnd;
            effectCaption.preBegin = this.preBegin;
            effectCaption.preEnd = this.preEnd;
            effectCaption.textCenterX = this.textCenterX;
            effectCaption.textCenterY = this.textCenterY;
            effectCaption.textRotation = this.textRotation;
        }
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.EffectText, com.aliyun.svideosdk.common.struct.effect.EffectPaster
    public int getPasterType() {
        return 2;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.EffectText, com.aliyun.svideosdk.common.struct.effect.EffectPaster, com.aliyun.svideosdk.common.struct.effect.EffectBase
    public String toString() {
        return "EffectCaption{gifViewId=" + this.gifViewId + ", textBegin=" + this.textBegin + ", textEnd=" + this.textEnd + ", preBegin=" + this.preBegin + ", preEnd=" + this.preEnd + ", textCenterX=" + this.textCenterX + ", textCenterY=" + this.textCenterY + ", textRotation=" + this.textRotation + ", textAlignment=" + this.textAlignment + ", text='" + this.text + "', textBmpPath='" + this.textBmpPath + "', textWidth=" + this.textWidth + ", textHeight=" + this.textHeight + ", textColor=" + this.textColor + ", dTextColor=" + this.dTextColor + ", textStrokeColor=" + this.textStrokeColor + ", dTextStrokeColor=" + this.dTextStrokeColor + ", font='" + this.font + "', hasStroke=" + this.hasStroke + ", hasLabel=" + this.hasLabel + ", textLabelColor=" + this.textLabelColor + ", mBackgroundBmp=" + this.mBackgroundBmp + ", mBackgroundBmpPath='" + this.mBackgroundBmpPath + "', mTextSize=" + this.mTextSize + ", mTextPaddingX=" + this.mTextPaddingX + ", mTextPaddingY=" + this.mTextPaddingY + ", mTextAlignment=" + this.mTextAlignment + ", needSaveBmp=" + this.needSaveBmp + ", mTextMaxLines=" + this.mTextMaxLines + ", name='" + this.name + "', width=" + this.width + ", height=" + this.height + ", start=" + this.start + ", end=" + this.end + ", y=" + this.y + ", x=" + this.x + ", rotation=" + this.rotation + ", duration=" + this.duration + ", kernelFrame=" + this.kernelFrame + ", frameArry=" + this.frameArry + ", timeArry=" + this.timeArry + ", mirror=" + this.mirror + ", isTrack=" + this.isTrack + '}';
    }
}

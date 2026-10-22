package com.aliyun.svideosdk.common.struct.effect;

import android.graphics.Bitmap;
import android.text.Layout;
import com.aliyun.Visible;
import com.aliyun.common.utils.k;
import com.aliyun.common.utils.q;
import com.aliyun.svideosdk.common.struct.project.Source;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class EffectText extends EffectPaster {
    public float bitmapScale;
    public int breakStrategy;
    public int dTextColor;
    public int dTextStrokeColor;

    @Deprecated
    public String font;
    public Source fontSource;
    public boolean hasLabel;
    public boolean hasStroke;
    public Bitmap mBackgroundBmp;
    public String mBackgroundBmpPath;
    public boolean mIncludePad;
    public float mSpacingAdd;
    public float mSpacingMult;
    public Layout.Alignment mTextAlignment;
    public int mTextMaxLines;
    public int mTextPaddingX;
    public int mTextPaddingY;
    public int mTextSize;
    public boolean needSaveBmp;
    public String text;
    public Layout.Alignment textAlignment;
    public String textBmpPath;
    public int textColor;
    public int textHeight;
    public int textLabelColor;
    public int textStrokeColor;
    public int textWidth;
    public boolean useLineSpacingFromFallbacks;

    public EffectText(Source source) {
        super(source);
        this.textLabelColor = 0;
        this.needSaveBmp = true;
        this.mTextMaxLines = 0;
        this.bitmapScale = 1.0f;
        this.breakStrategy = 1;
        this.useLineSpacingFromFallbacks = true;
        this.mSpacingMult = 1.0f;
        this.mSpacingAdd = 0.0f;
        this.mIncludePad = true;
    }

    @Deprecated
    public EffectText(String str) {
        super(str);
        this.textLabelColor = 0;
        this.needSaveBmp = true;
        this.mTextMaxLines = 0;
        this.bitmapScale = 1.0f;
        this.breakStrategy = 1;
        this.useLineSpacingFromFallbacks = true;
        this.mSpacingMult = 1.0f;
        this.mSpacingAdd = 0.0f;
        this.mIncludePad = true;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.EffectPaster, com.aliyun.svideosdk.common.struct.effect.EffectBase
    public void copy(EffectBase effectBase) {
        super.copy(effectBase);
        if (effectBase instanceof EffectText) {
            EffectText effectText = (EffectText) effectBase;
            effectText.textAlignment = this.textAlignment;
            effectText.text = this.text;
            effectText.textBmpPath = this.textBmpPath;
            effectText.textWidth = this.textWidth;
            effectText.textHeight = this.textHeight;
            effectText.textColor = this.textColor;
            effectText.dTextColor = this.dTextColor;
            effectText.textStrokeColor = this.textStrokeColor;
            effectText.font = this.font;
            if (this.fontSource != null) {
                Source source = new Source();
                source.setId(this.fontSource.getId());
                source.setPath(this.fontSource.getPath());
                source.setURL(this.fontSource.getURL());
                effectText.fontSource = source;
            }
            effectText.hasStroke = this.hasStroke;
            effectText.hasLabel = this.hasLabel;
            effectText.textLabelColor = this.textLabelColor;
            effectText.mBackgroundBmp = this.mBackgroundBmp;
            effectText.mBackgroundBmpPath = this.mBackgroundBmpPath;
            effectText.mTextSize = this.mTextSize;
            effectText.mTextPaddingX = this.mTextPaddingX;
            effectText.mTextPaddingY = this.mTextPaddingY;
            effectText.mTextAlignment = this.mTextAlignment;
            effectText.needSaveBmp = this.needSaveBmp;
            effectText.mTextMaxLines = this.mTextMaxLines;
            effectText.bitmapScale = this.bitmapScale;
            effectText.breakStrategy = this.breakStrategy;
            effectText.useLineSpacingFromFallbacks = this.useLineSpacingFromFallbacks;
            effectText.mSpacingAdd = this.mSpacingAdd;
            effectText.mSpacingMult = this.mSpacingMult;
            effectText.mIncludePad = this.mIncludePad;
        }
    }

    public String generateTextFinger() {
        return k.a(this.textAlignment + getViewId() + this.text + this.textWidth + this.textHeight + this.width + this.height + this.textColor + this.textStrokeColor + this.font + this.hasLabel + this.hasStroke + this.textLabelColor);
    }

    public String getFontPath() {
        Source source = this.fontSource;
        return (source == null || q.b(source.getPath())) ? this.font : this.fontSource.getPath();
    }

    public Source getFontSource() {
        Source source = this.fontSource;
        return source != null ? source : new Source(this.font);
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.EffectPaster
    public int getPasterType() {
        return 1;
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.EffectPaster, com.aliyun.svideosdk.common.struct.effect.EffectBase
    public String toString() {
        return "EffectText{textAlignment=" + this.textAlignment + ", text='" + this.text + "', textBmpPath='" + this.textBmpPath + "', textWidth=" + this.textWidth + ", textHeight=" + this.textHeight + ", textColor=" + this.textColor + ", dTextColor=" + this.dTextColor + ", textStrokeColor=" + this.textStrokeColor + ", dTextStrokeColor=" + this.dTextStrokeColor + ", font='" + this.font + "', hasStroke=" + this.hasStroke + ", hasLabel=" + this.hasLabel + ", textLabelColor=" + this.textLabelColor + ", mBackgroundBmp=" + this.mBackgroundBmp + ", mBackgroundBmpPath='" + this.mBackgroundBmpPath + "', mTextSize=" + this.mTextSize + ", mTextPaddingX=" + this.mTextPaddingX + ", mTextPaddingY=" + this.mTextPaddingY + ", mTextAlignment=" + this.mTextAlignment + ", needSaveBmp=" + this.needSaveBmp + ", mTextMaxLines=" + this.mTextMaxLines + ", name='" + this.name + "', width=" + this.width + ", height=" + this.height + ", start=" + this.start + ", end=" + this.end + ", y=" + this.y + ", x=" + this.x + ", rotation=" + this.rotation + ", duration=" + this.duration + ", kernelFrame=" + this.kernelFrame + ", frameArry=" + this.frameArry + ", timeArry=" + this.timeArry + ", mirror=" + this.mirror + ", isTrack=" + this.isTrack + ", bitmapScale=" + this.bitmapScale + ", breakStrategy=" + this.breakStrategy + ", useLineSpacingFromFallbacks=" + this.useLineSpacingFromFallbacks + ", mIncludePad=" + this.mIncludePad + ", mSpacingAdd=" + this.mSpacingAdd + ", mSpacingMult=" + this.mSpacingMult + '}';
    }
}

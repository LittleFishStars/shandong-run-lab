package com.aliyun.svideosdk.editor.impl;

import android.graphics.Bitmap;
import android.os.Build;
import android.text.Layout;
import android.widget.TextView;
import com.aliyun.svideosdk.common.struct.effect.EffectBase;
import com.aliyun.svideosdk.common.struct.effect.EffectText;
import com.aliyun.svideosdk.common.struct.project.Source;
import com.aliyun.svideosdk.editor.AliyunPasterBaseView;
import com.aliyun.svideosdk.editor.AliyunPasterManager;
import com.aliyun.svideosdk.editor.impl.text.TextBitmap;
import com.aliyun.svideosdk.editor.impl.text.TextBitmapGenerator;
import com.aliyun.svideosdk.nativerender.BitmapGenerator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Deprecated
class l extends k implements BitmapGenerator {
    private TextBitmap g;
    private TextBitmapGenerator h;
    protected EffectText i;

    public l(EffectText effectText, o oVar, AliyunPasterManager aliyunPasterManager) {
        super(effectText, oVar, aliyunPasterManager, false);
        this.i = effectText;
    }

    public l(EffectText effectText, o oVar, AliyunPasterManager aliyunPasterManager, boolean z) {
        super(effectText, oVar, aliyunPasterManager, z);
        this.i = effectText;
    }

    private void a(TextView textView) {
        try {
            int i = Build.VERSION.SDK_INT;
            this.i.breakStrategy = textView.getBreakStrategy();
            this.i.mIncludePad = textView.getIncludeFontPadding();
            this.i.mSpacingAdd = textView.getLineSpacingExtra();
            this.i.mSpacingMult = textView.getLineSpacingMultiplier();
            if (i > 27) {
                this.i.useLineSpacingFromFallbacks = textView.isFallbackLineSpacing();
            }
        } catch (Exception unused) {
        }
    }

    public void b() {
        if (isRevert()) {
            return;
        }
        this.i.textColor = this.b.getTextColor();
        this.i.textStrokeColor = this.b.getTextStrokeColor();
        this.i.text = this.b.getText();
        this.i.fontSource = this.b.getPasterTextFontSource();
        this.i.hasStroke = this.b.isTextHasStroke();
        this.i.hasLabel = this.b.isTextHasLabel();
        this.i.textLabelColor = this.b.getTextBgLabelColor();
        int pasterTextWidth = this.b.getPasterTextWidth();
        if (pasterTextWidth != 0) {
            this.i.textWidth = pasterTextWidth;
        }
        int pasterTextHeight = this.b.getPasterTextHeight();
        if (pasterTextHeight != 0) {
            this.i.textHeight = pasterTextHeight;
        }
        this.i.width = this.b.getPasterWidth();
        this.i.height = this.b.getPasterHeight();
        this.i.mBackgroundBmp = this.b.getBackgroundBitmap();
        float textFixSize = this.b.getTextFixSize();
        if (textFixSize <= 0.0f && (this.b.getTextView() instanceof TextView)) {
            textFixSize = ((TextView) this.b.getTextView()).getTextSize();
            a((TextView) this.b.getTextView());
        }
        EffectText effectText = this.i;
        effectText.mTextSize = (int) textFixSize;
        effectText.bitmapScale = textFixSize > 199.0f ? textFixSize / 199.0f : 1.0f;
        effectText.mTextPaddingX = this.b.getTextPaddingX();
        this.i.mTextPaddingY = this.b.getTextPaddingY();
        this.i.mTextAlignment = this.b.getTextAlign();
        this.i.mTextMaxLines = this.b.getTextMaxLines();
    }

    @Override // com.aliyun.svideosdk.editor.impl.k, com.aliyun.svideosdk.editor.AliyunPasterController
    public int editCompleted() {
        if (this.b == null) {
            return -4;
        }
        a();
        b();
        if (isOnlyApplyUI()) {
            return 0;
        }
        if (this.c) {
            return this.mRender.showTextPaster(this, this.i);
        }
        int iAddSubtitle = this.mRender.addSubtitle(this, this.i);
        if (iAddSubtitle != 0) {
            return iAddSubtitle;
        }
        this.c = true;
        return iAddSubtitle;
    }

    @Override // com.aliyun.svideosdk.nativerender.BitmapGenerator
    public Bitmap generateBitmap(int i, int i2) {
        if (this.h == null) {
            this.g = new TextBitmap();
            this.h = new TextBitmapGenerator();
        }
        TextBitmap textBitmap = this.g;
        EffectText effectText = this.i;
        textBitmap.mText = effectText.text;
        textBitmap.mFontPath = effectText.getFontPath();
        TextBitmap textBitmap2 = this.g;
        textBitmap2.mBmpWidth = i;
        textBitmap2.mBmpHeight = i2;
        EffectText effectText2 = this.i;
        textBitmap2.mTextWidth = effectText2.textWidth;
        textBitmap2.mTextHeight = effectText2.textHeight;
        textBitmap2.mTextColor = effectText2.textColor;
        textBitmap2.mTextStrokeColor = effectText2.textStrokeColor;
        Layout.Alignment alignment = Layout.Alignment.ALIGN_CENTER;
        textBitmap2.mBackgroundColor = effectText2.textLabelColor;
        textBitmap2.mBackgroundBmp = effectText2.mBackgroundBmp;
        textBitmap2.mTextSize = effectText2.mTextSize;
        textBitmap2.mTextPaddingX = effectText2.mTextPaddingX;
        textBitmap2.mTextPaddingY = effectText2.mTextPaddingY;
        textBitmap2.mTextAlignment = effectText2.mTextAlignment;
        textBitmap2.mMaxLines = effectText2.mTextMaxLines;
        textBitmap2.bitmapScale = effectText2.bitmapScale;
        textBitmap2.breakStrategy = effectText2.breakStrategy;
        textBitmap2.useLineSpacingFromFallbacks = effectText2.useLineSpacingFromFallbacks;
        textBitmap2.mSpacingAdd = effectText2.mSpacingAdd;
        textBitmap2.mSpacingMult = effectText2.mSpacingMult;
        textBitmap2.mIncludePad = effectText2.mIncludePad;
        this.h.updateTextBitmap(textBitmap2);
        return this.h.generateBitmap(i, i2);
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public int getConfigTextColor() {
        return this.i.dTextColor;
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public int getConfigTextStrokeColor() {
        return this.i.dTextStrokeColor;
    }

    @Override // com.aliyun.svideosdk.editor.impl.k, com.aliyun.svideosdk.editor.AliyunPasterController
    public EffectBase getEffect() {
        return this.i;
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public String getPasterTextFont() {
        return this.i.getFontPath();
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public Source getPasterTextFontSource() {
        return this.i.fontSource;
    }

    @Override // com.aliyun.svideosdk.editor.impl.k, com.aliyun.svideosdk.editor.AliyunPasterController
    public int getPasterType() {
        return 1;
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public String getText() {
        return this.i.text;
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public int getTextBgLabelColor() {
        return this.i.textLabelColor;
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public int getTextColor() {
        return this.i.textColor;
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public int getTextStrokeColor() {
        return this.i.textStrokeColor;
    }

    @Override // com.aliyun.svideosdk.editor.impl.k, com.aliyun.svideosdk.editor.AliyunPasterController
    public boolean isPasterExists() {
        return true;
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public boolean isTextHasStroke() {
        return this.i.hasLabel;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, com.aliyun.svideosdk.common.struct.effect.EffectText] */
    @Override // com.aliyun.svideosdk.editor.impl.k, com.aliyun.svideosdk.editor.AliyunPasterController
    public void setEffect(EffectBase effectBase) {
        if (effectBase instanceof EffectText) {
            ?? r2 = (EffectText) effectBase;
            this.i = r2;
            this.f25734a = r2;
        }
    }

    @Override // com.aliyun.svideosdk.editor.impl.a, com.aliyun.svideosdk.editor.AliyunPasterController
    public void setPasterView(AliyunPasterBaseView aliyunPasterBaseView) {
        super.setPasterView(aliyunPasterBaseView);
    }
}

package com.aliyun.svideosdk.editor.impl.text;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Layout;
import android.text.TextUtils;
import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.effect.EffectText;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public class TextBitmap {
    public Bitmap mBackgroundBmp;
    public String mBackgroundImg;
    public int mBmpHeight;
    public int mBmpWidth;
    public String mFontPath;
    public CharSequence mText;
    public Layout.Alignment mTextAlignment;
    public int mTextColor;
    public int mTextHeight;
    public int mTextSize;
    public int mTextStrokeColor;
    public int mTextWidth;
    public int mBackgroundColor = 0;
    public int mTextPaddingX = 0;
    public int mTextPaddingY = 0;
    public int mMaxLines = 0;
    public float bitmapScale = 1.0f;
    public CharSequence mEmojiText = "";
    public int breakStrategy = 1;
    public boolean useLineSpacingFromFallbacks = true;
    public float mSpacingMult = 1.0f;
    public float mSpacingAdd = 0.0f;
    public boolean mIncludePad = true;

    public static TextBitmap fromEffectText(EffectText effectText) {
        TextBitmap textBitmap = new TextBitmap();
        textBitmap.mText = effectText.text;
        textBitmap.mFontPath = effectText.getFontPath();
        textBitmap.mBmpWidth = effectText.width;
        textBitmap.mBmpHeight = effectText.height;
        textBitmap.mTextWidth = effectText.textWidth;
        textBitmap.mTextHeight = effectText.textHeight;
        textBitmap.mTextColor = effectText.textColor;
        textBitmap.mTextStrokeColor = effectText.textStrokeColor;
        textBitmap.mBackgroundColor = effectText.textLabelColor;
        textBitmap.mTextSize = effectText.mTextSize;
        textBitmap.mTextPaddingX = effectText.mTextPaddingX;
        textBitmap.mTextPaddingY = effectText.mTextPaddingY;
        textBitmap.mTextAlignment = effectText.mTextAlignment;
        textBitmap.mMaxLines = effectText.mTextMaxLines;
        if (!TextUtils.isEmpty(effectText.mBackgroundBmpPath) && new File(effectText.mBackgroundBmpPath).exists()) {
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(effectText.mBackgroundBmpPath);
            effectText.mBackgroundBmp = bitmapDecodeFile;
            textBitmap.mBackgroundBmp = bitmapDecodeFile;
        }
        return textBitmap;
    }
}

package com.aliyun.svideosdk.editor.impl.text;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ScaleXSpan;
import android.util.Log;
import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.asset.TypefaceConfig;
import com.aliyun.svideosdk.nativerender.BitmapGenerator;
import com.zj.adlib.b85;
import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public class TextBitmapGenerator implements BitmapGenerator {
    public static final float MAX_TEXT_SIZE = 199.0f;
    private TextBitmap mTextBitmap;
    private final Canvas mCanvas = new Canvas();
    private final b mTextBox = new b();

    public class a implements FilenameFilter {
        public a(TextBitmapGenerator textBitmapGenerator) {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.toLowerCase().endsWith(".ttf");
        }
    }

    private void configureLayout(com.aliyun.svideosdk.editor.impl.text.a aVar, TextBitmap textBitmap) {
        TypefaceConfig typefaceConfig;
        TypefaceConfig typefaceConfig2;
        if (TextUtils.isEmpty(textBitmap.mFontPath)) {
            typefaceConfig = new TypefaceConfig();
        } else {
            try {
                File file = new File(textBitmap.mFontPath);
                if (file.exists()) {
                    typefaceConfig2 = new TypefaceConfig(Typeface.createFromFile(textBitmap.mFontPath));
                } else {
                    File parentFile = file.getParentFile();
                    String[] list = parentFile.list(new a(this));
                    if (list == null || list.length <= 0) {
                        typefaceConfig2 = new TypefaceConfig();
                    } else {
                        File file2 = new File(parentFile, list[0]);
                        if (file2.exists()) {
                            typefaceConfig2 = new TypefaceConfig(Typeface.createFromFile(file2));
                        } else {
                            Log.e("AliYunLog", "Font file[" + file2.getAbsolutePath() + "] not exist!");
                            typefaceConfig2 = new TypefaceConfig();
                        }
                    }
                }
                typefaceConfig = typefaceConfig2;
            } catch (Exception e) {
                Log.e("AliYunLog", "Load font error!", e);
                typefaceConfig = new TypefaceConfig();
            }
        }
        aVar.b(textBitmap.mTextPaddingX, textBitmap.mTextPaddingY);
        aVar.c(textBitmap.mTextSize);
        aVar.c(textBitmap.mTextWidth, textBitmap.mTextHeight);
        aVar.a(textBitmap.mBmpWidth, textBitmap.mBmpHeight);
        aVar.c(textBitmap.useLineSpacingFromFallbacks);
        aVar.f(textBitmap.breakStrategy);
        aVar.b(textBitmap.mIncludePad);
        aVar.a(textBitmap.mSpacingAdd, textBitmap.mSpacingMult);
        aVar.a(textBitmap.mText);
        aVar.b(textBitmap.mTextColor);
        aVar.a(textBitmap.mTextAlignment);
        aVar.e(textBitmap.mTextStrokeColor);
        aVar.a(Paint.Join.ROUND);
        aVar.a(textBitmap.mBackgroundColor);
        aVar.a(textBitmap.mBackgroundBmp);
        aVar.a(typefaceConfig.typeface);
        aVar.a(typefaceConfig.fakeBold);
        aVar.d(textBitmap.mMaxLines);
    }

    private Bitmap generateScaleEmojiBitmap() {
        try {
            b bVar = new b();
            TextBitmap textBitmap = this.mTextBitmap;
            float f = textBitmap.bitmapScale;
            float f2 = textBitmap.mTextSize / f;
            int i = (int) (textBitmap.mBmpWidth / f);
            int i2 = (int) (textBitmap.mBmpHeight / f);
            TextBitmap textBitmap2 = new TextBitmap();
            textBitmap2.mTextSize = (int) f2;
            TextBitmap textBitmap3 = this.mTextBitmap;
            textBitmap2.mText = textBitmap3.mEmojiText;
            textBitmap2.mBmpHeight = i2;
            textBitmap2.mBmpWidth = i;
            textBitmap2.mFontPath = textBitmap3.mFontPath;
            textBitmap2.mMaxLines = textBitmap3.mMaxLines;
            textBitmap2.mTextAlignment = textBitmap3.mTextAlignment;
            textBitmap2.mTextHeight = (int) (textBitmap3.mTextHeight / f);
            textBitmap2.mTextWidth = (int) (textBitmap3.mTextWidth / f);
            textBitmap2.mTextPaddingX = (int) (textBitmap3.mTextPaddingX / f);
            textBitmap2.mTextPaddingY = (int) (textBitmap3.mTextPaddingY / f);
            textBitmap2.mTextStrokeColor = textBitmap3.mTextStrokeColor;
            textBitmap2.mTextColor = textBitmap3.mTextColor;
            textBitmap2.mBackgroundColor = 0;
            configureLayout(bVar, textBitmap2);
            bVar.c();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            bVar.setBounds(0, 0, i, i2);
            int iSave = canvas.save();
            bVar.draw(canvas);
            canvas.restoreToCount(iSave);
            TextBitmap textBitmap4 = this.mTextBitmap;
            float f3 = textBitmap4.mBmpWidth / i;
            float f4 = textBitmap4.mBmpHeight / i2;
            Matrix matrix = new Matrix();
            matrix.postScale(f3, f4);
            return Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, i, i2, matrix, true);
        } catch (Exception e) {
            Log.e("AliYunLog", "generateScaleEmojiBitmap  error!", e);
            return null;
        }
    }

    private Bitmap getImageAligned(Drawable drawable, int i, int i2) {
        return rasterize(drawable, i, i2);
    }

    public static boolean isEmojiCharacter(int i) {
        return (128 <= i && i <= 687) || (768 <= i && i <= 1023) || ((1536 <= i && i <= 1791) || ((3072 <= i && i <= 3199) || ((7616 <= i && i <= 7679) || ((7680 <= i && i <= 7935) || ((8192 <= i && i <= 8351) || ((8400 <= i && i <= 8527) || ((8592 <= i && i <= 9215) || ((9312 <= i && i <= 9727) || ((9728 <= i && i <= 10223) || ((10496 <= i && i <= 10751) || ((11008 <= i && i <= 11263) || ((11360 <= i && i <= 11391) || ((11776 <= i && i <= 11903) || ((42128 <= i && i <= 42191) || ((57344 <= i && i <= 63743) || ((65024 <= i && i <= 65039) || ((65072 <= i && i <= 65103) || ((126976 <= i && i <= 127023) || ((127136 <= i && i <= 127231) || ((127232 <= i && i <= 128591) || ((128640 <= i && i <= 128767) || ((129296 <= i && i <= 129387) || (129408 <= i && i <= 129504)))))))))))))))))))))));
    }

    private boolean isLineBreak(CharSequence charSequence) {
        return TextUtils.equals(charSequence, "\n") || TextUtils.equals(charSequence, "\t") || TextUtils.equals(charSequence, b85.b);
    }

    private Bitmap rasterize(Drawable drawable, int i, int i2) {
        Bitmap bitmapGenerateScaleEmojiBitmap;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        this.mCanvas.setBitmap(bitmapCreateBitmap);
        drawable.setBounds(0, 0, i, i2);
        int iSave = this.mCanvas.save();
        drawable.draw(this.mCanvas);
        this.mCanvas.restoreToCount(iSave);
        TextBitmap textBitmap = this.mTextBitmap;
        if (textBitmap.mTextSize > 199.0f && !TextUtils.isEmpty(textBitmap.mEmojiText) && (bitmapGenerateScaleEmojiBitmap = generateScaleEmojiBitmap()) != null) {
            this.mCanvas.drawBitmap(bitmapGenerateScaleEmojiBitmap, 0.0f, 0.0f, (Paint) null);
        }
        return bitmapCreateBitmap;
    }

    private void replaceEmojiText() {
        try {
            TextBitmap textBitmap = this.mTextBitmap;
            if (textBitmap.mTextSize > 199.0f && !TextUtils.isEmpty(textBitmap.mText)) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
                Paint paint = new Paint(1);
                paint.setTextSize(this.mTextBitmap.mTextSize);
                String string = this.mTextBitmap.mText.toString();
                int i = 0;
                boolean z = false;
                float fMeasureText = 0.0f;
                while (i < string.length()) {
                    if (isEmojiCharacter(Character.codePointAt(this.mTextBitmap.mText, i))) {
                        if (fMeasureText <= 0.0f) {
                            fMeasureText = 0.98f * (paint.measureText(string.subSequence(i, i + 2).toString()) / paint.measureText(" "));
                        }
                        if (i <= this.mTextBitmap.mText.length() - 2) {
                            spannableStringBuilder2.append(string.subSequence(i, i + 2));
                        }
                        spannableStringBuilder.append((CharSequence) " ");
                        spannableStringBuilder.setSpan(new ScaleXSpan(fMeasureText), spannableStringBuilder.length() - 1, spannableStringBuilder.length(), 17);
                        i++;
                        z = true;
                    } else {
                        spannableStringBuilder.append(string.charAt(i));
                        if (isLineBreak(String.valueOf(string.charAt(i)))) {
                            spannableStringBuilder2.append(string.charAt(i));
                        } else {
                            float fMeasureText2 = paint.measureText(String.valueOf(string.charAt(i))) / paint.measureText(" ");
                            spannableStringBuilder2.append((CharSequence) " ");
                            spannableStringBuilder2.setSpan(new ScaleXSpan(fMeasureText2), spannableStringBuilder2.length() - 1, spannableStringBuilder2.length(), 17);
                        }
                    }
                    i++;
                }
                if (z) {
                    this.mTextBitmap.mEmojiText = spannableStringBuilder2;
                }
                this.mTextBitmap.mText = spannableStringBuilder;
            }
        } catch (Exception e) {
            Log.e("AliYunLog", "replaceEmojiText  error!", e);
        }
    }

    public int align2(int i, int i2) {
        return ((i + i2) - 1) & (~(i2 - 1));
    }

    @Override // com.aliyun.svideosdk.nativerender.BitmapGenerator
    public Bitmap generateBitmap(int i, int i2) {
        TextBitmap textBitmap = this.mTextBitmap;
        if (textBitmap != null) {
            textBitmap.mBmpWidth = i;
            textBitmap.mBmpHeight = i2;
        }
        configureLayout(this.mTextBox, textBitmap);
        this.mTextBox.c();
        return getImageAligned(this.mTextBox, i, i2);
    }

    public Bitmap generateTextBitmap(TextBitmap textBitmap) {
        this.mTextBitmap = textBitmap;
        replaceEmojiText();
        configureLayout(this.mTextBox, textBitmap);
        this.mTextBox.c();
        return getImageAligned(this.mTextBox, textBitmap.mBmpWidth, textBitmap.mBmpHeight);
    }

    public void updateTextBitmap(TextBitmap textBitmap) {
        this.mTextBitmap = textBitmap;
        replaceEmojiText();
    }
}

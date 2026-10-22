package com.autonavi.base.ae.gmap.glyph;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityManager;
import com.autonavi.base.amap.mapcore.tools.GLConvertUtil;
import com.zj.adlib.gia;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class GlyphLoader {
    private static Map<String, Typeface> FontFaceMap = new HashMap();

    public static long createGlyphLoader() {
        return nativeCreateGlyphLoader();
    }

    private static String decodeUnicode(short s) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append((char) s);
        return stringBuffer.toString();
    }

    public static void destroyGlyphLoader(long j) {
        nativeDestroyGlyphLoader(j);
    }

    private static FontMetricsRequestParam genFontMetricsParam(byte[] bArr) {
        FontMetricsRequestParam fontMetricsRequestParam = new FontMetricsRequestParam();
        fontMetricsRequestParam.fFontSize = GLConvertUtil.getInt(bArr, 0) * 0.001f;
        fontMetricsRequestParam.nFontStyleCode = GLConvertUtil.getInt(bArr, 4);
        int i = 12;
        if (1 == GLConvertUtil.getInt(bArr, 8)) {
            int i2 = GLConvertUtil.getInt(bArr, 12);
            fontMetricsRequestParam.strName = new String(bArr, 16, i2);
            i = 16 + i2;
        }
        fontMetricsRequestParam.languageArr = new String(bArr, i + 4, GLConvertUtil.getInt(bArr, i));
        return fontMetricsRequestParam;
    }

    private static GlyphRequestParam genGlyphRequestParam(byte[] bArr) {
        GlyphRequestParam glyphRequestParam = new GlyphRequestParam();
        int i = GLConvertUtil.getInt(bArr, 0);
        glyphRequestParam.strBuffer = new String(bArr, 4, i);
        int i2 = i + 4;
        Font font = new Font();
        font.nFontStyleCode = GLConvertUtil.getInt(bArr, i2);
        int i3 = i2 + 4;
        font.nFontSize = GLConvertUtil.getInt(bArr, i3);
        int i4 = i3 + 4;
        int i5 = GLConvertUtil.getInt(bArr, i4);
        int i6 = i4 + 4;
        font.strName = new String(bArr, i6, i5);
        int i7 = i6 + i5;
        FontMetrics fontMetrics = new FontMetrics();
        int i8 = GLConvertUtil.getInt(bArr, i7);
        int i9 = i7 + 4;
        fontMetrics.fAscent = i8 * 0.001f;
        int i10 = GLConvertUtil.getInt(bArr, i9);
        int i11 = i9 + 4;
        fontMetrics.fDescent = i10 * 0.001f;
        int i12 = GLConvertUtil.getInt(bArr, i11);
        int i13 = i11 + 4;
        fontMetrics.fLeading = i12 * 0.001f;
        int i14 = GLConvertUtil.getInt(bArr, i13);
        int i15 = i13 + 4;
        fontMetrics.fHeight = i14 * 0.001f;
        font.fontMetrics = fontMetrics;
        glyphRequestParam.font = font;
        glyphRequestParam.drawingMode = GLConvertUtil.getInt(bArr, i15);
        int i16 = i15 + 4;
        int i17 = GLConvertUtil.getInt(bArr, i16);
        int i18 = i16 + 4;
        glyphRequestParam.strokeWidth = i17 * 0.001f;
        int i19 = GLConvertUtil.getInt(bArr, i18);
        int i20 = i18 + 4;
        glyphRequestParam.languageArr = new String(bArr, i20, i19);
        glyphRequestParam.isEmoji = GLConvertUtil.getInt(bArr, i20);
        int i21 = i20 + 4;
        glyphRequestParam.isSDF = GLConvertUtil.getInt(bArr, i21);
        int i22 = i21 + 4;
        int i23 = GLConvertUtil.getInt(bArr, i22);
        int i24 = i22 + 4;
        if (1 == i23) {
            GlyphMetrics glyphMetrics = new GlyphMetrics();
            glyphMetrics.nWidth = GLConvertUtil.getInt(bArr, i24);
            int i25 = i24 + 4;
            glyphMetrics.nHeight = GLConvertUtil.getInt(bArr, i25);
            int i26 = i25 + 4;
            int i27 = GLConvertUtil.getInt(bArr, i26);
            int i28 = i26 + 4;
            glyphMetrics.fLeft = i27 * 0.001f;
            glyphMetrics.fTop = GLConvertUtil.getInt(bArr, i28) * 0.001f;
            glyphMetrics.fAdvance = GLConvertUtil.getInt(bArr, i28 + 4) * 0.001f;
            glyphRequestParam.fGlyphMetrics = glyphMetrics;
        }
        return glyphRequestParam;
    }

    private static FontMetrics getFontMetrics(byte[] bArr) {
        FontMetricsRequestParam fontMetricsRequestParamGenFontMetricsParam = genFontMetricsParam(bArr);
        TextPaint textPaintNewTextPaint = newTextPaint(new FontStyle(fontMetricsRequestParamGenFontMetricsParam.nFontStyleCode), fontMetricsRequestParamGenFontMetricsParam.fFontSize, fontMetricsRequestParamGenFontMetricsParam.strName, false, 0.0f);
        Paint.FontMetrics fontMetrics = textPaintNewTextPaint.getFontMetrics();
        FontMetrics fontMetrics2 = new FontMetrics();
        fontMetrics2.bSuccess = true;
        fontMetrics2.fAscent = Math.abs(fontMetrics.ascent);
        fontMetrics2.fDescent = Math.abs(fontMetrics.descent);
        fontMetrics2.fLeading = Math.abs(fontMetrics.leading);
        fontMetrics2.fHeight = Math.abs(fontMetrics.ascent) + Math.abs(fontMetrics.descent);
        textPaintNewTextPaint.setTypeface(null);
        return fontMetrics2;
    }

    private static GlyphMetrics getGlyphMetrics(byte[] bArr) {
        GlyphRequestParam glyphRequestParamGenGlyphRequestParam = genGlyphRequestParam(bArr);
        FontStyle fontStyle = new FontStyle(glyphRequestParamGenGlyphRequestParam.font.nFontStyleCode);
        boolean z = glyphRequestParamGenGlyphRequestParam.drawingMode != 0;
        String str = glyphRequestParamGenGlyphRequestParam.strBuffer;
        Font font = glyphRequestParamGenGlyphRequestParam.font;
        return loadGlyphMetrics(str, fontStyle, font.nFontSize, font.strName, z, glyphRequestParamGenGlyphRequestParam.strokeWidth, glyphRequestParamGenGlyphRequestParam.isEmoji > 0, glyphRequestParamGenGlyphRequestParam.isSDF > 0);
    }

    private static GlyphRaster getGlyphRaster(byte[] bArr) {
        GlyphRequestParam glyphRequestParamGenGlyphRequestParam = genGlyphRequestParam(bArr);
        FontStyle fontStyle = new FontStyle(glyphRequestParamGenGlyphRequestParam.font.nFontStyleCode);
        int i = glyphRequestParamGenGlyphRequestParam.drawingMode;
        boolean z = i != 0;
        if (i == 3) {
            String str = glyphRequestParamGenGlyphRequestParam.strBuffer;
            Font font = glyphRequestParamGenGlyphRequestParam.font;
            return loadPathRaster(str, fontStyle, font.nFontSize, font.strName, z, glyphRequestParamGenGlyphRequestParam.strokeWidth * 2.0f);
        }
        String str2 = glyphRequestParamGenGlyphRequestParam.strBuffer;
        Font font2 = glyphRequestParamGenGlyphRequestParam.font;
        return loadGlyphRaster(str2, fontStyle, font2.nFontSize, font2.strName, z, glyphRequestParamGenGlyphRequestParam.strokeWidth, glyphRequestParamGenGlyphRequestParam.isEmoji > 0, glyphRequestParamGenGlyphRequestParam.isSDF > 0);
    }

    private static GlyphMetrics loadGlyphMetrics(String str, FontStyle fontStyle, float f, String str2, boolean z, float f2, boolean z2, boolean z3) {
        GlyphMetrics glyphMetrics = new GlyphMetrics();
        if (fontStyle == null || TextUtils.isEmpty(str)) {
            return glyphMetrics;
        }
        try {
            if (z2) {
                glyphMetrics.bSuccess = true;
                glyphMetrics.fLeft = 0.0f;
                glyphMetrics.fTop = 0.0f;
                int i = (int) f;
                glyphMetrics.nWidth = i;
                glyphMetrics.nHeight = i;
                glyphMetrics.fAdvance = f;
            } else {
                TextPaint textPaintNewTextPaint = newTextPaint(fontStyle, f, str2, z, f2);
                Rect rect = new Rect();
                textPaintNewTextPaint.getTextBounds(str, 0, str.length(), rect);
                if (rect.width() == 0 && rect.height() == 0) {
                    float fMeasureText = textPaintNewTextPaint.measureText(" ", 0, 1);
                    float fAbs = Math.abs(textPaintNewTextPaint.getFontMetrics().ascent) + Math.abs(textPaintNewTextPaint.getFontMetrics().descent);
                    rect.top = 0;
                    rect.left = 0;
                    rect.right = (int) fMeasureText;
                    rect.bottom = (int) fAbs;
                }
                if (z && f2 > 0.0f) {
                    float f3 = f2 / 2.0f;
                    rect.top = (int) (rect.top - f3);
                    rect.left = (int) (rect.left - f3);
                    rect.right = (int) (rect.right + f3);
                    rect.bottom = (int) (rect.bottom + f3);
                }
                glyphMetrics.bSuccess = true;
                glyphMetrics.fLeft = rect.left;
                glyphMetrics.fTop = Math.abs(textPaintNewTextPaint.getFontMetrics().ascent) - Math.abs(rect.top);
                glyphMetrics.nWidth = rect.width();
                glyphMetrics.nHeight = rect.height();
                glyphMetrics.fAdvance = textPaintNewTextPaint.measureText(str);
                textPaintNewTextPaint.setTypeface(null);
            }
        } catch (Exception unused) {
            glyphMetrics.bSuccess = false;
        }
        return glyphMetrics;
    }

    private static GlyphRaster loadGlyphRaster(String str, FontStyle fontStyle, float f, String str2, boolean z, float f2, boolean z2, boolean z3) {
        boolean zBooleanValue;
        int i;
        GlyphRaster glyphRaster = new GlyphRaster();
        if (fontStyle == null || TextUtils.isEmpty(str)) {
            return glyphRaster;
        }
        try {
            Context context = gia.f41914a;
            zBooleanValue = context != null ? ((Boolean) ReflectUtil.invoke("android.view.accessibility.AccessibilityManager", (AccessibilityManager) context.getApplicationContext().getSystemService("accessibility"), "isHighTextContrastEnabled", null)).booleanValue() : false;
        } catch (Throwable th) {
            Log.e("HighText", "highText exception:" + th.toString());
        }
        try {
            TextPaint textPaintNewTextPaint = newTextPaint(fontStyle, f, str2, z, f2);
            Rect rect = new Rect();
            textPaintNewTextPaint.getTextBounds(str, 0, str.length(), rect);
            if (rect.width() == 0 && rect.height() == 0) {
                float fMeasureText = textPaintNewTextPaint.measureText(" ", 0, 1);
                float fAbs = Math.abs(textPaintNewTextPaint.getFontMetrics().ascent) + Math.abs(textPaintNewTextPaint.getFontMetrics().descent);
                rect.right = (int) fMeasureText;
                rect.bottom = (int) fAbs;
                rect.left = 0;
                rect.top = 0;
            }
            if (z && f2 > 0.0f) {
                float f3 = f2 / 2.0f;
                rect.top = (int) (rect.top - f3);
                rect.left = (int) (rect.left - f3);
                rect.right = (int) (rect.right + f3);
                rect.bottom = (int) (rect.bottom + f3);
            }
            if (!rect.isEmpty()) {
                Bitmap.Config config = Bitmap.Config.ALPHA_8;
                if (z2 || zBooleanValue) {
                    config = Bitmap.Config.ARGB_8888;
                    i = 4;
                } else {
                    i = 1;
                }
                int i2 = z3 ? 3 : 0;
                int i3 = i2 * 2;
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(rect.width() + i3, rect.height() + i3, config);
                new Canvas(bitmapCreateBitmap).drawText(str, (0 - rect.left) + i2, (0 - rect.top) + i2, textPaintNewTextPaint);
                int iWidth = rect.width() + i3;
                int iHeight = rect.height() + i3;
                int i4 = iWidth * iHeight;
                byte[] bArr = new byte[i4 * i];
                bitmapCreateBitmap.copyPixelsToBuffer(ByteBuffer.wrap(bArr));
                if (zBooleanValue) {
                    byte[] bArr2 = new byte[i4];
                    for (int i5 = 0; i5 < iHeight; i5++) {
                        for (int i6 = 0; i6 < iWidth * i; i6 += i) {
                            int i7 = i5 * iWidth;
                            bArr2[(i6 / i) + i7] = bArr[(i7 * i) + i6];
                        }
                    }
                    bArr = bArr2;
                }
                glyphRaster.bitmapWidth = iWidth;
                glyphRaster.bitmapHeight = iHeight;
                if (z2) {
                    glyphRaster.bitmapPixelMode = 1;
                } else {
                    glyphRaster.bitmapPixelMode = 0;
                }
                glyphRaster.bitmapSize = bArr.length;
                glyphRaster.bitmapBuffer = bArr;
                bitmapCreateBitmap.recycle();
                glyphRaster.bSuccess = true;
            }
            textPaintNewTextPaint.setTypeface(null);
        } catch (Exception unused) {
            glyphRaster.bSuccess = false;
        }
        return glyphRaster;
    }

    public static GlyphRaster loadPathRaster(String str, FontStyle fontStyle, float f, String str2, boolean z, float f2) {
        GlyphRaster glyphRaster = new GlyphRaster();
        if (fontStyle == null || TextUtils.isEmpty(str)) {
            return glyphRaster;
        }
        try {
            TextPaint textPaintNewTextPaint = newTextPaint(fontStyle, f, str2, false, 0.0f);
            Rect rect = new Rect();
            textPaintNewTextPaint.getTextBounds(str, 0, str.length(), rect);
            new Canvas(Bitmap.createBitmap(rect.width(), rect.height(), Bitmap.Config.ALPHA_8)).drawText(str, 0 - rect.left, 0 - rect.top, textPaintNewTextPaint);
            TextPaint textPaintNewTextPaint2 = newTextPaint(fontStyle, f, str2, z, f2);
            Rect rect2 = new Rect();
            textPaintNewTextPaint2.getTextBounds(str, 0, str.length(), rect2);
            if (z && f2 > 0.0f) {
                float f3 = 0.5f * f2;
                rect2.top = (int) (rect2.top - f3);
                rect2.left = (int) (rect2.left - f3);
                rect2.right = (int) (rect2.right + f3);
                rect2.bottom = (int) (rect2.bottom + f3);
            }
            if (!rect2.isEmpty()) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(rect2.width(), rect2.height(), Bitmap.Config.ALPHA_8);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                float f4 = 0 - rect2.left;
                float f5 = 0 - rect2.top;
                Path path = new Path();
                textPaintNewTextPaint.getTextPath(str, 0, str.length(), f4, f5, path);
                canvas.drawPath(path, textPaintNewTextPaint2);
                int iWidth = rect2.width() * rect2.height();
                byte[] bArr = new byte[iWidth];
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                glyphRaster.bitmapWidth = rect2.width();
                glyphRaster.bitmapHeight = rect2.height();
                glyphRaster.bitmapPixelMode = 0;
                glyphRaster.bitmapSize = iWidth;
                bitmapCreateBitmap.copyPixelsToBuffer(byteBufferWrap);
                bitmapCreateBitmap.recycle();
                glyphRaster.bitmapBuffer = bArr;
                glyphRaster.bSuccess = true;
            }
            textPaintNewTextPaint.setTypeface(null);
            textPaintNewTextPaint2.setTypeface(null);
        } catch (Exception unused) {
            glyphRaster.bSuccess = false;
        }
        return glyphRaster;
    }

    private static native long nativeCreateGlyphLoader();

    private static native void nativeDestroyGlyphLoader(long j);

    /* JADX WARN: Code duplicated, block: B:35:0x006b A[Catch: all -> 0x0076, TryCatch #0 {, blocks: (B:33:0x0061, B:35:0x006b, B:36:0x0074), top: B:45:0x0061, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0080  */
    /* JADX WARN: Code duplicated, block: B:45:0x0061 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    private static TextPaint newTextPaint(FontStyle fontStyle, float f, String str, boolean z, float f2) {
        boolean z2;
        Typeface typefaceCreate;
        TextPaint textPaint = new TextPaint();
        if (fontStyle == null) {
            return textPaint;
        }
        textPaint.setColor(-1);
        textPaint.setAntiAlias(true);
        textPaint.setFilterBitmap(true);
        textPaint.setTextSize(f);
        textPaint.setTextAlign(Paint.Align.LEFT);
        if (z) {
            textPaint.setStyle(Paint.Style.STROKE);
            textPaint.setStrokeWidth(f2);
        } else {
            textPaint.setStyle(Paint.Style.FILL);
        }
        int slant = fontStyle.getSlant();
        int i = 2;
        boolean z3 = slant != 0 && (slant == 1 || slant == 2);
        switch (fontStyle.getWeight()) {
            case 0:
            case 100:
            case 200:
            case 300:
            case 400:
            default:
                z2 = false;
                break;
            case 500:
            case 600:
            case 700:
            case 800:
            case 900:
            case 1000:
                z2 = true;
                break;
        }
        if ((!z2 || !z3) && !z2) {
            if (!z3) {
            }
            if (str.isEmpty()) {
                typefaceCreate = Typeface.create(Typeface.DEFAULT, i);
            } else {
                try {
                    synchronized (FontFaceMap) {
                        typefaceCreate = FontFaceMap.get(str);
                        if (typefaceCreate == null) {
                            typefaceCreate = Typeface.createFromFile(str);
                            FontFaceMap.put(str, typefaceCreate);
                        }
                    }
                } catch (Exception unused) {
                    typefaceCreate = Typeface.create(Typeface.DEFAULT, i);
                }
            }
            textPaint.setTypeface(typefaceCreate);
            return textPaint;
        }
        textPaint.setFakeBoldText(true);
        i = 0;
        if (str.isEmpty()) {
            synchronized (FontFaceMap) {
                typefaceCreate = FontFaceMap.get(str);
                if (typefaceCreate == null) {
                    typefaceCreate = Typeface.createFromFile(str);
                    FontFaceMap.put(str, typefaceCreate);
                }
            }
        } else {
            typefaceCreate = Typeface.create(Typeface.DEFAULT, i);
        }
        textPaint.setTypeface(typefaceCreate);
        return textPaint;
    }

    private static String decodeUnicode(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        return stringBuffer.toString();
    }
}

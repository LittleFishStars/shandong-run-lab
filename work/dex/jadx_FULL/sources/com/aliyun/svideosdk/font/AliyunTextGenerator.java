package com.aliyun.svideosdk.font;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.Xfermode;
import android.os.Build;
import android.text.Layout;
import android.text.TextPaint;
import android.util.Log;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.aliyun.Visible;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
class AliyunTextGenerator {
    private static final int FONT_WEIGHT_BOLD = 600;
    private static final int FONT_WEIGHT_NORMAL = 450;
    private static final String TAG = "AliyunTextGenerator";
    private boolean mIsItalic;
    private boolean mOnlyLayout;
    private c mTextLayout;

    @Visible
    public static class TextGlyph {
        public RectF bound;
        public int codePoint = -1;
        public boolean colorGlyph = false;
        public PointF pos;
    }

    @Visible
    public static class TextLayout {
        public Bitmap bitmap;
        public RectF bound;
        public List<TextGlyph> glyphList;
    }

    @Visible
    public AliyunTextGenerator(String str, String str2) {
        this(str, str2, 48.0f, 0.0f, false, false, false, 1, 0, 0, false);
    }

    @Visible
    public AliyunTextGenerator(String str, String str2, float f, float f2, boolean z, boolean z2, boolean z3, int i, int i2, int i3, boolean z4) {
        this.mOnlyLayout = false;
        this.mIsItalic = z2;
        int i4 = 600;
        Typeface typefaceA = a.a(getApplicationContext(), str2, z ? 600 : 450, z2);
        if (!z) {
            i4 = 450;
        }
        this.mTextLayout = new b(str, a.a(typefaceA, f, i4, z2, f2), 0.0f, z3, 132, i, i2, -1);
        this.mOnlyLayout = z4;
    }

    private PointF calcGlyphSizeInCanvasPixel(c.b bVar, Canvas canvas) {
        Matrix matrix = canvas.getMatrix();
        if (matrix == null) {
            return new PointF(bVar.b.width(), bVar.b.height());
        }
        float[] fArr = {0.0f, 0.0f, bVar.b.width(), bVar.b.height()};
        matrix.mapPoints(fArr);
        return new PointF(Math.abs(fArr[2] - fArr[0]), Math.abs(fArr[3] - fArr[1]));
    }

    private Context getApplicationContext() {
        try {
            Class<?> cls = Class.forName(ProcessUtils.ACTIVITY_THREAD);
            return (Application) cls.getMethod("getApplication", new Class[0]).invoke(cls.getMethod(ProcessUtils.CURRENT_ACTIVITY_THREAD, new Class[0]).invoke(null, null), null);
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Paint selectPaint(c cVar, boolean z) {
        Layout layoutA = cVar.a();
        if (layoutA == null) {
            return null;
        }
        TextPaint paint = layoutA.getPaint();
        if (!z) {
            return paint;
        }
        Paint paint2 = new Paint();
        paint2.setTypeface(paint.getTypeface());
        paint2.setTextSize(paint.getTextSize());
        paint2.setFakeBoldText(paint.isFakeBoldText());
        paint2.setTextSkewX(paint.getTextSkewX());
        paint2.setLetterSpacing(paint.getLetterSpacing());
        return paint2;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x005e  */
    public boolean drawTextGlyph(c cVar, int i, int i2, float f, float f2, Canvas canvas, boolean z, boolean z2) {
        Paint paintSelectPaint;
        boolean z3;
        int i3;
        if (canvas == null) {
            return false;
        }
        try {
            c.b bVarA = cVar.a(i, i2);
            if (bVarA == null || (paintSelectPaint = selectPaint(cVar, z2)) == null) {
                return false;
            }
            paintSelectPaint.setAntiAlias(z);
            paintSelectPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
            boolean z4 = (f == 0.0f && f2 == 0.0f) ? false : true;
            if (z4) {
                canvas.translate(f, f2);
            }
            if (Build.VERSION.SDK_INT < 30) {
                PointF pointFCalcGlyphSizeInCanvasPixel = calcGlyphSizeInCanvasPixel(bVarA, canvas);
                if (pointFCalcGlyphSizeInCanvasPixel.x >= 256.0f || pointFCalcGlyphSizeInCanvasPixel.y >= 256.0f) {
                    z3 = true;
                } else {
                    z3 = false;
                }
            } else {
                z3 = false;
            }
            if (z3) {
                float fWidth = bVarA.b.width() / bVarA.b.height();
                int i4 = 256;
                if (fWidth >= 1.0f) {
                    i3 = (int) (256 / fWidth);
                } else {
                    i4 = (int) (256 * fWidth);
                    i3 = 256;
                }
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i4, i3, Bitmap.Config.ARGB_8888);
                bitmapCreateBitmap.eraseColor(0);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                Matrix matrix = new Matrix();
                RectF rectF = bVarA.b;
                matrix.postTranslate(-rectF.left, -rectF.top);
                matrix.postScale(i4 / bVarA.b.width(), i3 / bVarA.b.height());
                canvas2.setMatrix(matrix);
                Xfermode xfermode = paintSelectPaint.getXfermode();
                paintSelectPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
                paintSelectPaint.setStyle(Paint.Style.FILL);
                String strD = cVar.d();
                int i5 = bVarA.g;
                int i6 = bVarA.h;
                PointF pointF = bVarA.f25771a;
                canvas2.drawText(strD, i5, i6, pointF.x, pointF.y, paintSelectPaint);
                paintSelectPaint.setXfermode(xfermode);
                canvas.drawBitmap(bitmapCreateBitmap, (Rect) null, bVarA.b, paintSelectPaint);
            } else {
                paintSelectPaint.setStyle(Paint.Style.FILL);
                String strD2 = cVar.d();
                int i7 = bVarA.g;
                int i8 = bVarA.h;
                PointF pointF2 = bVarA.f25771a;
                canvas.drawText(strD2, i7, i8, pointF2.x, pointF2.y, paintSelectPaint);
            }
            if (z4) {
                canvas.translate(-f, -f2);
            }
            return true;
        } catch (Exception e) {
            Log.e(TAG, "" + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    @Visible
    public TextLayout generateTextGlyph() {
        TextLayout textLayout = new TextLayout();
        RectF rectFB = this.mTextLayout.b();
        if (this.mIsItalic && rectFB != null) {
            rectFB.set(rectFB.left, rectFB.top, rectFB.right + (this.mTextLayout.a(0, this.mTextLayout.a(0) - 1).b.width() / 2.0f), rectFB.bottom);
        }
        if (rectFB.width() <= 0.0f || rectFB.height() <= 0.0f) {
            Log.e("TextLayoutGeneratorJava", "generate font text layout fail");
            return textLayout;
        }
        textLayout.bound = rectFB;
        textLayout.glyphList = new ArrayList();
        if (this.mOnlyLayout) {
            for (int i = 0; i < this.mTextLayout.c(); i++) {
                for (int i2 = 0; i2 < this.mTextLayout.a(i); i2++) {
                    c.b bVarA = this.mTextLayout.a(i, i2);
                    TextGlyph textGlyph = new TextGlyph();
                    textGlyph.codePoint = bVarA.i;
                    textGlyph.pos = bVarA.f25771a;
                    textGlyph.bound = bVarA.b;
                    textGlyph.colorGlyph = bVarA.d;
                    textLayout.glyphList.add(textGlyph);
                }
            }
        } else {
            textLayout.bitmap = Bitmap.createBitmap((int) rectFB.width(), (int) rectFB.height(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(textLayout.bitmap);
            HashSet hashSet = new HashSet();
            for (int i3 = 0; i3 < this.mTextLayout.c(); i3++) {
                for (int i4 = 0; i4 < this.mTextLayout.a(i3); i4++) {
                    c.b bVarA2 = this.mTextLayout.a(i3, i4);
                    TextGlyph textGlyph2 = new TextGlyph();
                    textGlyph2.codePoint = bVarA2.i;
                    textGlyph2.pos = bVarA2.f25771a;
                    textGlyph2.bound = bVarA2.b;
                    textGlyph2.colorGlyph = bVarA2.d;
                    textLayout.glyphList.add(textGlyph2);
                    int i5 = textGlyph2.codePoint;
                    if (i5 < 0) {
                        drawTextGlyph(this.mTextLayout, i3, i4, 0.0f, 0.0f, canvas, true, false);
                    } else if (!hashSet.contains(Integer.valueOf(i5))) {
                        hashSet.add(Integer.valueOf(textGlyph2.codePoint));
                        drawTextGlyph(this.mTextLayout, i3, i4, 0.0f, 0.0f, canvas, true, false);
                    }
                }
            }
        }
        return textLayout;
    }
}

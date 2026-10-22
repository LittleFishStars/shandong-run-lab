package com.byazt.oq;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.view.View;
import com.byazt.or.tt;
import com.byazt.yj.da;
import com.byazt.yj.gr;
import com.byazt.yj.m;
import com.byazt.yj.yp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, 1207})
public class ImageFlipSlide extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f28903a;
    public Paint c;
    public Path n;
    public final Rect sp;
    public float tt;
    public List<String> uj;
    public Bitmap ve;
    public final boolean x;

    public ImageFlipSlide(Context context, boolean z) {
        super(context);
        this.tt = 0.1f;
        this.f28903a = new Rect();
        this.sp = new Rect();
        this.x = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBlurPx() {
        if (this.uj == null) {
            return 0;
        }
        for (int i = 0; i < this.uj.size(); i++) {
            if (this.uj.get(i).contains("blur")) {
                return Integer.parseInt(this.uj.get(i).split("\\(")[1].split("px")[0]);
            }
        }
        return 0;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.ve;
        if (bitmap == null) {
            return;
        }
        if (!this.x) {
            canvas.clipPath(this.n);
            canvas.drawBitmap(this.ve, 0.0f, 0.0f, this.c);
            return;
        }
        this.f28903a.left = (int) (bitmap.getWidth() * (1.0f - this.tt));
        this.f28903a.right = this.ve.getWidth();
        Rect rect = this.f28903a;
        rect.top = 0;
        rect.bottom = this.ve.getHeight();
        this.sp.left = (int) (getWidth() * (1.0f - this.tt));
        this.sp.right = getWidth();
        Rect rect2 = this.sp;
        rect2.top = 0;
        rect2.bottom = getHeight();
        canvas.drawBitmap(this.ve, this.f28903a, this.sp, this.c);
    }

    public void c(String str, String str2, List<String> list) {
        final yp ypVarKey = com.byazt.mf.c.c().n().from(str).key(str2);
        this.uj = list;
        ypVarKey.config(Bitmap.Config.ARGB_4444).type(2);
        if (getBlurPx() != 0) {
            ypVarKey.converter(new da() { // from class: com.byazt.oq.ImageFlipSlide.1
                @Override // com.byazt.yj.da
                public Bitmap coverterTo(Bitmap bitmap) {
                    try {
                        return tt.c(ImageFlipSlide.this.getContext(), bitmap, ImageFlipSlide.this.getBlurPx());
                    } catch (Exception unused) {
                        return bitmap;
                    }
                }
            });
        }
        post(new Runnable() { // from class: com.byazt.oq.ImageFlipSlide.2
            @Override // java.lang.Runnable
            public void run() {
                ypVarKey.to(new gr<Bitmap>() { // from class: com.byazt.oq.ImageFlipSlide.2.1
                    @Override // com.byazt.yj.gr
                    public void onFailed(int i, String str3, Throwable th) {
                    }

                    @Override // com.byazt.yj.gr
                    public void onSuccess(m<Bitmap> mVar) {
                        try {
                            ImageFlipSlide imageFlipSlide = ImageFlipSlide.this;
                            imageFlipSlide.ve = imageFlipSlide.c(mVar.getResult(), ImageFlipSlide.this.getWidth(), ImageFlipSlide.this.getHeight());
                        } catch (Exception unused) {
                        }
                        ImageFlipSlide.this.invalidate();
                    }
                });
            }
        });
        Paint paint = new Paint();
        this.c = paint;
        paint.setAntiAlias(true);
        this.c.setDither(true);
        if (this.x) {
            this.c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        }
        List<String> list2 = this.uj;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        ColorMatrix colorMatrix = new ColorMatrix();
        for (int i = 0; i < this.uj.size(); i++) {
            c(colorMatrix, this.uj.get(i));
        }
        this.c.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }

    private void c(ColorMatrix colorMatrix, String str) {
        try {
            ColorMatrix colorMatrix2 = new ColorMatrix();
            if (str.startsWith("hue-rotate")) {
                colorMatrix2.setRotate(0, Integer.parseInt(str.split("\\(")[1].split("deg")[0]));
            } else if (!str.startsWith("grayscale") && !str.startsWith("contrast")) {
                if (str.startsWith("invert")) {
                    float f = (Integer.parseInt(str.split("\\(")[1].split("%")[0]) / 100.0f) * 255.0f;
                    colorMatrix2.set(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, f, 0.0f, -1.0f, 0.0f, 0.0f, f, 0.0f, 0.0f, -1.0f, 0.0f, f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
                } else if (str.startsWith("sepia")) {
                    float f2 = Integer.parseInt(str.split("\\(")[1].split("%")[0]) / 100.0f;
                    colorMatrix2.setScale(f2, f2, 1.0f, 1.0f);
                } else if (str.startsWith("brightness")) {
                    float f3 = Integer.parseInt(str.split("\\(")[1].split("%")[0]) / 100.0f;
                    colorMatrix2.setScale(f3, f3, f3, 1.0f);
                }
            } else {
                colorMatrix2.setSaturation(Integer.parseInt(str.split("\\(")[1].split("%")[0]) / 100.0f);
            }
            colorMatrix.postConcat(colorMatrix2);
        } catch (Exception unused) {
        }
    }

    public void c(float f) {
        this.tt = f;
        invalidate();
    }

    public void c(Path path) {
        this.n = path;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap c(Bitmap bitmap, int i, int i2) {
        int i3;
        int i4;
        int i5;
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = i;
        float f2 = (width * 1.0f) / f;
        float f3 = i2;
        float f4 = (height * 1.0f) / f3;
        Matrix matrix = new Matrix();
        int i6 = 0;
        if (f4 > f2) {
            int i7 = (int) (f3 * f2);
            float f5 = 1.0f / f2;
            matrix.setScale(f5, f5);
            i4 = i7;
            i3 = width;
            i5 = (height / 2) - (i7 / 2);
        } else {
            int i8 = (int) (f * f4);
            float f6 = 1.0f / f4;
            matrix.setScale(f6, f6);
            i3 = i8;
            i4 = height;
            i5 = 0;
            i6 = (width / 2) - (i8 / 2);
        }
        return Bitmap.createBitmap(bitmap, i6, i5, i3, i4, matrix, false);
    }
}

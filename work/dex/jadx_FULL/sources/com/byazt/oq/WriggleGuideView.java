package com.byazt.oq;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.byazt.nr.z;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.hzchengdun.securityguard.SecExceptionCode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, SecExceptionCode.SEC_ERROR_LBSRISK})
public class WriggleGuideView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28913a;
    public int c;
    public c da;
    public boolean i;
    public Paint n;
    public boolean sp;
    public int tt;
    public Bitmap uj;
    public Bitmap ve;
    public boolean x;

    public interface c {
    }

    private Bitmap ve(int i, int i2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-1);
        canvas.drawCircle(i / 2, 10.0f, this.f28913a, paint);
        return bitmapCreateBitmap;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.da != null) {
            this.da = null;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.sp) {
            this.c = getWidth();
            int height = getHeight();
            this.tt = height;
            c(this.c, height);
            tt(this.c, this.tt);
            this.sp = false;
        }
        Bitmap bitmap = this.ve;
        if (bitmap == null || this.uj == null) {
            return;
        }
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.n);
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        canvas.drawBitmap(this.uj, 0.0f, 0.0f, this.n);
        this.n.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(ve(this.c, this.tt), 0.0f, 0.0f, this.n);
        this.n.setXfermode(null);
        canvas.restoreToCount(iSaveLayer);
        if (this.x) {
            this.f28913a += 5;
            invalidate();
            if (this.f28913a >= this.c) {
                this.x = false;
            }
        }
    }

    private void c(final int i, final int i2) {
        z.c(getContext(), "tt_wriggle_union", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.oq.WriggleGuideView.1
            @Override // com.byazt.qr.c
            public void c(Bitmap bitmap) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                if (bitmap != null) {
                    canvas.drawBitmap(bitmap, (Rect) null, new RectF(0.0f, 0.0f, i, i2), WriggleGuideView.this.n);
                }
                WriggleGuideView.this.ve = bitmapCreateBitmap;
                WriggleGuideView.this.c();
            }
        }, 320);
    }

    private void tt(final int i, final int i2) {
        z.c(getContext(), "tt_wriggle_union_white", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.oq.WriggleGuideView.2
            @Override // com.byazt.qr.c
            public void c(Bitmap bitmap) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                Paint paint = new Paint(1);
                if (bitmap != null) {
                    canvas.drawBitmap(bitmap, (Rect) null, new RectF(0.0f, 0.0f, i, i2), paint);
                }
                WriggleGuideView.this.uj = bitmapCreateBitmap;
                WriggleGuideView.this.c();
            }
        }, 320);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.ve == null || this.uj == null || this.i) {
            return;
        }
        this.i = true;
        post(new Runnable() { // from class: com.byazt.oq.WriggleGuideView.3
            @Override // java.lang.Runnable
            public void run() {
                WriggleGuideView.this.invalidate();
            }
        });
    }
}

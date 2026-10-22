package com.byazt.oq;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.view.View;
import com.byazt.nr.z;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, 1711})
public class FlowLightView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28900a;
    public Rect c;
    public Paint da;
    public Bitmap i;
    public int n;
    public Xfermode sl;
    public int sp;
    public PorterDuff.Mode t;
    public Rect tt;
    public LinearGradient u;
    public int uj;
    public int ve;
    public int[] x;
    public final List<c> yp;

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, 2286})
    public static class c {
        public final int c;
        public int tt = 0;

        public c(int i) {
            this.c = i;
        }

        public void c() {
            this.tt += this.c;
        }
    }

    public FlowLightView(Context context) {
        super(context);
        this.t = PorterDuff.Mode.DST_IN;
        this.yp = new ArrayList();
        c();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.i;
        if (bitmap == null) {
            return;
        }
        canvas.drawBitmap(bitmap, this.c, this.tt, this.da);
        canvas.save();
        Iterator<c> it = this.yp.iterator();
        while (it.hasNext()) {
            c next = it.next();
            this.u = new LinearGradient(next.tt, 0.0f, next.tt + this.sp, this.f28900a, this.x, (float[]) null, Shader.TileMode.CLAMP);
            this.da.setColor(-1);
            this.da.setShader(this.u);
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.da);
            this.da.setShader(null);
            next.c();
            if (next.tt > getWidth()) {
                it.remove();
            }
        }
        this.da.setXfermode(this.sl);
        canvas.drawBitmap(this.i, this.c, this.tt, this.da);
        this.da.setXfermode(null);
        canvas.restore();
        invalidate();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.i == null) {
            return;
        }
        this.c = new Rect(0, 0, this.i.getWidth(), this.i.getHeight());
        this.tt = new Rect(0, 0, getWidth(), getHeight());
    }

    private void c() {
        this.ve = Color.parseColor("#00ffffff");
        this.uj = Color.parseColor("#ffffffff");
        int color = Color.parseColor("#00ffffff");
        this.n = color;
        this.f28900a = 10;
        this.sp = 40;
        this.x = new int[]{this.ve, this.uj, color};
        setLayerType(1, null);
        this.da = new Paint(1);
        z.c(getContext(), "tt_splash_unlock_image_arrow", new com.byazt.qr.c<Bitmap>() { // from class: com.byazt.oq.FlowLightView.1
            @Override // com.byazt.qr.c
            public void c(Bitmap bitmap) {
                FlowLightView.this.i = bitmap;
                FlowLightView.this.post(new Runnable() { // from class: com.byazt.oq.FlowLightView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FlowLightView.this.invalidate();
                    }
                });
            }
        }, 320);
        this.sl = new PorterDuffXfermode(this.t);
    }

    public void c(int i) {
        this.yp.add(new c(i));
        postInvalidate();
    }
}

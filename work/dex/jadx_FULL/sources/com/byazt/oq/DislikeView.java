package com.byazt.oq;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, 1691})
public class DislikeView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28898a;
    public int c;
    public Paint n;
    public Paint sp;
    public int tt;
    public Paint uj;
    public final RectF ve;
    public int x;

    public DislikeView(Context context) {
        super(context);
        this.ve = new RectF();
        c();
    }

    private void c() {
        Paint paint = new Paint();
        this.uj = paint;
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.sp = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.n = paint3;
        paint3.setAntiAlias(true);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.ve;
        int i = this.f28898a;
        canvas.drawRoundRect(rectF, i, i, this.n);
        RectF rectF2 = this.ve;
        int i2 = this.f28898a;
        canvas.drawRoundRect(rectF2, i2, i2, this.uj);
        int i3 = this.c;
        int i4 = this.tt;
        canvas.drawLine(i3 * 0.3f, i4 * 0.3f, i3 * 0.7f, i4 * 0.7f, this.sp);
        int i5 = this.c;
        int i6 = this.tt;
        canvas.drawLine(i5 * 0.7f, i6 * 0.3f, i5 * 0.3f, i6 * 0.7f, this.sp);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.c = i;
        this.tt = i2;
        RectF rectF = this.ve;
        int i5 = this.x;
        rectF.set(i5, i5, i - i5, i2 - i5);
    }

    public void setBgColor(int i) {
        this.n.setStyle(Paint.Style.FILL);
        this.n.setColor(i);
    }

    public void setDislikeColor(int i) {
        this.sp.setColor(i);
    }

    public void setDislikeWidth(int i) {
        this.sp.setStrokeWidth(i);
    }

    public void setRadius(int i) {
        this.f28898a = i;
    }

    public void setStrokeColor(int i) {
        this.uj.setStyle(Paint.Style.STROKE);
        this.uj.setColor(i);
    }

    public void setStrokeWidth(int i) {
        this.uj.setStrokeWidth(i);
        this.x = i;
    }
}

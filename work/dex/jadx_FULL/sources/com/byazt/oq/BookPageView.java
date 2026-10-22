package com.byazt.oq;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Shader;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, 1873})
public class BookPageView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Point f28893a;
    public Paint c;
    public Point n;
    public Point sp;
    public Paint tt;
    public Point uj;
    public Point ve;

    public BookPageView(Context context) {
        super(context);
        this.c = new Paint();
        this.tt = new Paint();
        this.ve = new Point();
        this.uj = new Point();
        this.n = new Point();
        this.f28893a = new Point();
        this.sp = new Point();
        this.c.setColor(-16711936);
        this.c.setTextSize(25.0f);
        post(new Runnable() { // from class: com.byazt.oq.BookPageView.1
            @Override // java.lang.Runnable
            public void run() {
                BookPageView bookPageView = BookPageView.this;
                bookPageView.ve.x = bookPageView.getWidth() - 10;
                BookPageView bookPageView2 = BookPageView.this;
                bookPageView2.ve.y = bookPageView2.getHeight() - 10;
                BookPageView.this.tt.setShader(new LinearGradient(0.0f, 0.0f, BookPageView.this.getWidth(), BookPageView.this.getHeight(), -7829368, -12303292, Shader.TileMode.MIRROR));
                BookPageView.this.tt.setStyle(Paint.Style.FILL_AND_STROKE);
                BookPageView.this.tt.setStrokeWidth(6.0f);
                BookPageView.this.tt.setShadowLayer(10.0f, 5.0f, 5.0f, -1);
            }
        });
    }

    public void c(Point point) {
        Point point2 = this.ve;
        point2.x = point.x;
        point2.y = point.y;
        invalidate();
    }

    public Path getFilterAreaPath() {
        Path path = new Path();
        Point point = this.uj;
        path.moveTo(point.x, point.y);
        Point point2 = this.f28893a;
        path.lineTo(point2.x, point2.y);
        Point point3 = this.sp;
        path.lineTo(point3.x, point3.y);
        path.close();
        return path;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c();
        Path path = new Path();
        Point point = this.f28893a;
        path.moveTo(point.x, point.y);
        Point point2 = this.ve;
        path.lineTo(point2.x, point2.y);
        Point point3 = this.sp;
        path.lineTo(point3.x, point3.y);
        path.close();
        canvas.drawPath(path, this.tt);
    }

    private void c() {
        this.uj.x = getWidth();
        this.uj.y = getHeight();
        Point point = this.n;
        Point point2 = this.ve;
        int i = point2.x;
        Point point3 = this.uj;
        int i2 = (i + point3.x) / 2;
        point.x = i2;
        int i3 = (point2.y + point3.y) / 2;
        point.y = i3;
        Point point4 = this.f28893a;
        int i4 = point3.y;
        point4.x = i2 - (((i4 - i3) * (i4 - i3)) / (point3.x - i2));
        point4.y = i4;
        Point point5 = this.sp;
        point5.x = point3.x;
        int i5 = point.y;
        int i6 = point3.x;
        int i7 = point.x;
        point5.y = i5 - (((i6 - i7) * (i6 - i7)) / (point3.y - i5));
    }
}

package com.ipd.dsp.internal.t1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.ipd.dsp.internal.c2.s;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@SuppressLint({"AppCompatCustomView"})
public class n extends ImageView {
    public final Path f;
    public final Paint g;
    public float h;
    public float i;
    public float j;
    public float k;
    public b l;
    public final GestureDetector m;
    public final com.ipd.dsp.internal.x1.a n;

    public class a implements GestureDetector.OnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(@NonNull MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, @NonNull MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(@NonNull MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, @NonNull MotionEvent motionEvent2, float f, float f2) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(@NonNull MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(@NonNull MotionEvent motionEvent) {
            if (n.this.l == null) {
                return false;
            }
            n.this.n.a(n.this.getWidth(), n.this.getHeight());
            n.this.n.a(n.this.h, n.this.i, motionEvent.getRawX(), motionEvent.getRawY());
            n.this.n.b(motionEvent.getX(), motionEvent.getY(), motionEvent.getRawX(), motionEvent.getRawY());
            n.this.l.a(motionEvent, n.this.n);
            return true;
        }
    }

    public interface b {
        void a(float f, float f2, float f3, float f4, com.ipd.dsp.internal.x1.a aVar);

        void a(MotionEvent motionEvent, com.ipd.dsp.internal.x1.a aVar);
    }

    public n(Context context) {
        super(context);
        this.n = new com.ipd.dsp.internal.x1.a();
        this.f = new Path();
        Paint paint = new Paint();
        this.g = paint;
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(s.a(context, 15.0f));
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(-1);
        paint.setAlpha(102);
        paint.setDither(true);
        this.m = new GestureDetector(context, new a());
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f, this.g);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.m.onTouchEvent(motionEvent)) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.f.reset();
                this.h = motionEvent.getX();
                float y = motionEvent.getY();
                this.i = y;
                float f = this.h;
                this.j = f;
                this.k = y;
                this.f.moveTo(f, y);
                this.n.a(getWidth(), getHeight());
                this.n.a(this.h, this.i, motionEvent.getRawX(), motionEvent.getRawY());
                invalidate();
            } else if (actionMasked == 1) {
                this.f.reset();
                this.n.b(motionEvent.getX(), motionEvent.getY(), motionEvent.getRawX(), motionEvent.getRawY());
                invalidate();
                b bVar = this.l;
                if (bVar != null) {
                    bVar.a(this.h, this.i, motionEvent.getX(), motionEvent.getY(), this.n);
                }
            } else if (actionMasked == 2) {
                a(motionEvent.getX(), motionEvent.getY());
                invalidate();
            }
        }
        return true;
    }

    public void setOnSlideTouchListener(b bVar) {
        this.l = bVar;
    }

    public final void a(float f, float f2) {
        float fAbs = Math.abs(f - this.j);
        float fAbs2 = Math.abs(f2 - this.k);
        if (fAbs > 3.0f || fAbs2 > 3.0f) {
            Path path = this.f;
            float f3 = this.j;
            float f4 = this.k;
            path.quadTo(f3, f4, (f + f3) / 2.0f, (f2 + f4) / 2.0f);
            this.j = f;
            this.k = f2;
        }
    }
}

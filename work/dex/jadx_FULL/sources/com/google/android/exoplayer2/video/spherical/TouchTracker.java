package com.google.android.exoplayer2.video.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.BinderThread;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class TouchTracker extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, OrientationListener.Listener {
    public static final float c = 45.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f31192a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final GestureDetector f5390a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Listener f5391a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PointF f5389a = new PointF();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final PointF f5392b = new PointF();
    public volatile float b = 3.1415927f;

    public interface Listener {
        void onScrollChange(PointF pointF);

        default boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    public TouchTracker(Context context, Listener listener, float f) {
        this.f5391a = listener;
        this.f31192a = f;
        this.f5390a = new GestureDetector(context, this);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.f5389a.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // com.google.android.exoplayer2.video.spherical.OrientationListener.Listener
    @BinderThread
    public void onOrientationChange(float[] fArr, float f) {
        this.b = -f;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float x = (motionEvent2.getX() - this.f5389a.x) / this.f31192a;
        float y = motionEvent2.getY();
        PointF pointF = this.f5389a;
        float f3 = (y - pointF.y) / this.f31192a;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d = this.b;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        PointF pointF2 = this.f5392b;
        pointF2.x -= (fCos * x) - (fSin * f3);
        float f4 = pointF2.y + (fSin * x) + (fCos * f3);
        pointF2.y = f4;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f4));
        this.f5391a.onScrollChange(this.f5392b);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.f5391a.onSingleTapUp(motionEvent);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f5390a.onTouchEvent(motionEvent);
    }
}

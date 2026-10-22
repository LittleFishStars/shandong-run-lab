package com.kwad.sdk.widget;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class h implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private GestureDetector MT;
    private d iH;
    private View mView;
    private MotionEvent qp;

    public h(Context context, @NonNull View view, d dVar) {
        this.mView = view;
        view.setOnTouchListener(this);
        this.MT = new GestureDetector(context, this);
        this.iH = dVar;
    }

    private boolean a(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = false;
        if (action == 0) {
            this.qp = MotionEvent.obtain(motionEvent);
        } else if (action == 1) {
            MotionEvent motionEvent2 = this.qp;
            if (motionEvent2 != null && b(motionEvent2, motionEvent)) {
                d dVar = this.iH;
                if (dVar != null) {
                    dVar.a(view, this.qp.getX(), this.qp.getY(), motionEvent.getX(), motionEvent.getY());
                }
                z = true;
            }
            this.qp = null;
        }
        return z;
    }

    private static boolean b(MotionEvent motionEvent, MotionEvent motionEvent2) {
        return ((Math.abs(motionEvent.getX() - motionEvent2.getX()) > 20.0f ? 1 : (Math.abs(motionEvent.getX() - motionEvent2.getX()) == 20.0f ? 0 : -1)) > 0) || ((Math.abs(motionEvent.getY() - motionEvent2.getY()) > 20.0f ? 1 : (Math.abs(motionEvent.getY() - motionEvent2.getY()) == 20.0f ? 0 : -1)) > 0);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        d dVar = this.iH;
        if (dVar == null) {
            return false;
        }
        dVar.a(this.mView);
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.qp != null && motionEvent.getAction() == 1 && b(this.qp, motionEvent)) {
            return a(view, motionEvent);
        }
        boolean zOnTouchEvent = this.MT.onTouchEvent(motionEvent);
        motionEvent.getAction();
        if (zOnTouchEvent) {
            return true;
        }
        return a(view, motionEvent);
    }

    public h(View view, d dVar) {
        if (view == null) {
            return;
        }
        this.mView = view;
        view.setOnTouchListener(this);
        this.MT = new GestureDetector(view.getContext(), this);
        this.iH = dVar;
    }
}

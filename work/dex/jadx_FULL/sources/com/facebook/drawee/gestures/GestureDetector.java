package com.facebook.drawee.gestures;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.facebook.common.internal.VisibleForTesting;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class GestureDetector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public final float f29977a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public long f1626a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public ClickListener f1627a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public boolean f1628a;

    @VisibleForTesting
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @VisibleForTesting
    public boolean f1629b;

    @VisibleForTesting
    public float c;

    public interface ClickListener {
        boolean b();
    }

    public GestureDetector(Context context) {
        this.f29977a = ViewConfiguration.get(context).getScaledTouchSlop();
        a();
    }

    public static GestureDetector c(Context context) {
        return new GestureDetector(context);
    }

    public void a() {
        this.f1627a = null;
        e();
    }

    public boolean b() {
        return this.f1628a;
    }

    public boolean d(MotionEvent motionEvent) {
        ClickListener clickListener;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f1628a = true;
            this.f1629b = true;
            this.f1626a = motionEvent.getEventTime();
            this.b = motionEvent.getX();
            this.c = motionEvent.getY();
        } else if (action == 1) {
            this.f1628a = false;
            if (Math.abs(motionEvent.getX() - this.b) > this.f29977a || Math.abs(motionEvent.getY() - this.c) > this.f29977a) {
                this.f1629b = false;
            }
            if (this.f1629b && motionEvent.getEventTime() - this.f1626a <= ViewConfiguration.getLongPressTimeout() && (clickListener = this.f1627a) != null) {
                clickListener.b();
            }
            this.f1629b = false;
        } else if (action != 2) {
            if (action == 3) {
                this.f1628a = false;
                this.f1629b = false;
            }
        } else if (Math.abs(motionEvent.getX() - this.b) > this.f29977a || Math.abs(motionEvent.getY() - this.c) > this.f29977a) {
            this.f1629b = false;
        }
        return true;
    }

    public void e() {
        this.f1628a = false;
        this.f1629b = false;
    }

    public void f(ClickListener clickListener) {
        this.f1627a = clickListener;
    }
}

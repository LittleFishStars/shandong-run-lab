package com.alibaba.ariver.console.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24042a = "AriverRemoteDebug:FloatLayout";
    private float b;
    private float c;
    private float d;
    private float e;
    private int f;
    private int g;
    private int h;

    public b(Context context) {
        super(context);
        this.h = new ViewConfiguration().getScaledTouchSlop();
    }

    public void a(int i, int i2) {
        this.f = i;
        this.g = i2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.b = motionEvent.getX();
            this.c = motionEvent.getY();
        } else {
            if (action == 1) {
                if (Math.abs(this.d) <= this.h && Math.abs(this.e) <= this.h) {
                    this.c = 0.0f;
                    this.b = 0.0f;
                    return super.onTouchEvent(motionEvent);
                }
                a();
                this.c = 0.0f;
                this.b = 0.0f;
                return true;
            }
            if (action == 2) {
                this.d = motionEvent.getX() - this.b;
                this.e = motionEvent.getY() - this.c;
                a();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    private void a() {
        setTranslationX(this.d);
        setTranslationY(this.e);
        RVLogger.d(f24042a, "updateViewPosition " + this.f + " " + this.g + " " + this.d + " " + this.e);
        int i = this.f;
        if (getX() <= 0.0f) {
            setX(0.0f);
        } else if (getX() + getWidth() > i) {
            setX(i - getWidth());
        }
        int i2 = this.g;
        if (getY() <= 0.0f) {
            setY(0.0f);
        } else if (getY() + getHeight() > i2) {
            setY(i2 - getHeight());
        }
    }
}

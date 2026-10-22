package com.alibaba.ariver.console.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24041a = "ConsoleToggleButton";
    private float b;
    private float c;
    private float d;
    private float e;
    private int f;
    private int g;
    private int h;

    public a(Context context) {
        super(context);
        a(context);
        this.h = new ViewConfiguration().getScaledTouchSlop();
    }

    private void a(Context context) {
        Resources resources = context.getResources();
        int color = resources.getColor(R.color.console_toggle_button_background);
        setText(resources.getString(R.string.console_toggle_button_text));
        setBackgroundColor(color);
        setTextSize(15.0f);
        setPadding(18, 12, 18, 12);
        setTextColor(-1);
    }

    @Override // android.widget.TextView, android.view.View
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

    public void a(int i, int i2) {
        this.f = i;
        this.g = i2;
    }

    private void a() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.rightMargin = (int) (layoutParams.rightMargin - this.d);
        layoutParams.bottomMargin = (int) (layoutParams.bottomMargin - this.e);
        RVLogger.d(f24041a, "updateViewPosition " + this.f + " " + this.g + " " + this.d + " " + this.e);
        int i = this.f;
        int i2 = layoutParams.rightMargin;
        if (i2 <= 0) {
            layoutParams.rightMargin = 0;
        } else if (i2 + getWidth() > i) {
            layoutParams.rightMargin = i - getWidth();
        }
        int i3 = this.g;
        int i4 = layoutParams.bottomMargin;
        if (i4 <= 0) {
            layoutParams.bottomMargin = 0;
        } else if (i4 + getHeight() > i3) {
            layoutParams.bottomMargin = i3 - getHeight();
        }
        getParent().requestLayout();
    }
}

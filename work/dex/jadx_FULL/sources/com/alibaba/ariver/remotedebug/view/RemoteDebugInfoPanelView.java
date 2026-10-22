package com.alibaba.ariver.remotedebug.view;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.common.utils.DimensionUtil;
import com.alibaba.ariver.kernel.common.utils.DisplayUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RemoteDebugInfoPanelView extends LinearLayout {
    private static final int f = -16711936;
    private static final int g = -65536;
    private static final int h = -7829368;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ImageView f24393a;
    private TextView b;
    private TextView c;
    private ViewGroup d;
    private a e;
    private float i;
    private float j;
    private float k;
    private float l;
    private int m;

    public RemoteDebugInfoPanelView(Context context) {
        super(context);
        this.m = 0;
        d();
    }

    private void d() {
        Context context = getContext();
        Activity activity = (Activity) context;
        this.d = (ViewGroup) activity.findViewById(R.id.content);
        ImageView imageView = new ImageView(context);
        this.f24393a = imageView;
        imageView.setBackgroundColor(f);
        int density = (int) (DimensionUtil.getDensity(context) * 4.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(density, density);
        layoutParams.gravity = 16;
        layoutParams.setMargins(25, 0, 25, 0);
        this.f24393a.setLayoutParams(layoutParams);
        TextView textView = new TextView(context);
        this.b = textView;
        textView.setMinWidth((int) (DimensionUtil.getDensity(context) * 100.0f));
        this.b.setTextColor(-1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        layoutParams2.setMargins(0, 0, 25, 0);
        this.b.setLayoutParams(layoutParams2);
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.ariver.remotedebug.view.RemoteDebugInfoPanelView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        TextView textView2 = new TextView(context);
        this.c = textView2;
        textView2.setTextColor(-1);
        this.c.setText(com.alibaba.ariver.remotedebug.R.string.remote_debug_exit);
        this.c.setPadding(0, 25, 25, 25);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.ariver.remotedebug.view.RemoteDebugInfoPanelView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RemoteDebugInfoPanelView.this.e != null) {
                    RemoteDebugInfoPanelView.this.e.a();
                }
            }
        });
        int titleAndStatusBarHeight = DisplayUtils.getTitleAndStatusBarHeight(activity);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 16;
        this.c.setLayoutParams(layoutParams3);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 5;
        layoutParams4.rightMargin = 20;
        layoutParams4.topMargin = titleAndStatusBarHeight + 20;
        addView(this.f24393a);
        addView(this.b);
        addView(this.c);
        setOrientation(0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#CC606066"));
        gradientDrawable.setCornerRadius(18.0f);
        setBackgroundDrawable(gradientDrawable);
        this.m = titleAndStatusBarHeight;
        this.d.addView(this, layoutParams4);
    }

    private void e() {
        try {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
            layoutParams.rightMargin = (int) (layoutParams.rightMargin - this.i);
            layoutParams.topMargin = (int) (layoutParams.topMargin + this.j);
            int width = this.d.getWidth();
            int i = layoutParams.rightMargin;
            if (i <= 0) {
                layoutParams.rightMargin = 0;
            } else if (i + getWidth() > width) {
                layoutParams.rightMargin = width - getWidth();
            }
            int i2 = layoutParams.topMargin;
            int i3 = this.m;
            if (i2 < i3) {
                layoutParams.topMargin = i3;
            } else if (i2 + getHeight() > this.d.getHeight()) {
                layoutParams.topMargin = this.d.getHeight() - getHeight();
            }
            this.d.updateViewLayout(this, layoutParams);
        } catch (Throwable th) {
            RVLogger.e(RemoteDebugInfoPanelView.class.getSimpleName(), "updateViewPosition...e=" + th);
        }
    }

    public void b() {
        this.f24393a.setBackgroundColor(f);
        this.b.setText(com.alibaba.ariver.remotedebug.R.string.tiny_remote_debug_connected);
    }

    public void c() {
        this.f24393a.setBackgroundColor(-65536);
        this.b.setText(com.alibaba.ariver.remotedebug.R.string.tiny_remote_debug_disconnected);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.k = motionEvent.getX();
            this.l = motionEvent.getY();
        } else {
            if (action == 1) {
                if (Math.abs(this.i) <= 3.0f && Math.abs(this.j) <= 3.0f) {
                    this.l = 0.0f;
                    this.k = 0.0f;
                    return super.onTouchEvent(motionEvent);
                }
                e();
                this.l = 0.0f;
                this.k = 0.0f;
                return true;
            }
            if (action == 2) {
                this.i = motionEvent.getX() - this.k;
                this.j = motionEvent.getY() - this.l;
                e();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setActionEventListener(a aVar) {
        this.e = aVar;
    }

    public void setExitText(String str) {
        this.c.setText(str);
    }

    public void setStateText(String str) {
        this.b.setText(str);
    }

    public void a() {
        this.f24393a.setBackgroundColor(h);
        this.b.setText(com.alibaba.ariver.remotedebug.R.string.tiny_remote_debug_connecting);
    }

    public RemoteDebugInfoPanelView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.m = 0;
        d();
    }

    public RemoteDebugInfoPanelView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.m = 0;
        d();
    }
}

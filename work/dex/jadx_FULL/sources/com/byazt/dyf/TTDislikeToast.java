package com.byazt.dyf;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 746, 2101})
public class TTDislikeToast extends FrameLayout {
    public Handler c;
    public TextView tt;

    public TTDislikeToast(Context context) {
        this(context, null);
    }

    public TTDislikeToast(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        TextView textView = new TextView(context);
        this.tt = textView;
        textView.setClickable(false);
        this.tt.setFocusable(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        int iC = com.byazt.pr.c.tt().c(getContext(), 20.0f);
        int iC2 = com.byazt.pr.c.tt().c(getContext(), 12.0f);
        this.tt.setPadding(iC, iC2, iC, iC2);
        this.tt.setLayoutParams(layoutParams);
        this.tt.setTextColor(-1);
        this.tt.setTextSize(16.0f);
        this.tt.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(com.byazt.pr.c.tt().c(getContext(), 6.0f));
        this.tt.setBackgroundDrawable(gradientDrawable);
        addView(this.tt);
    }

    public TTDislikeToast(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new Handler(Looper.getMainLooper());
        setVisibility(8);
        setClickable(false);
        setFocusable(false);
        c(context);
    }

    public void c(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.c.removeCallbacksAndMessages(null);
        this.c.post(new Runnable() { // from class: com.byazt.dyf.TTDislikeToast.1
            @Override // java.lang.Runnable
            public void run() {
                if (TTDislikeToast.this.tt != null) {
                    TTDislikeToast.this.tt.setText(String.valueOf(str));
                }
                TTDislikeToast.this.setVisibility(0);
            }
        });
        this.c.postDelayed(new Runnable() { // from class: com.byazt.dyf.TTDislikeToast.2
            @Override // java.lang.Runnable
            public void run() {
                TTDislikeToast.this.setVisibility(8);
            }
        }, 2000L);
    }

    public void c() {
        setVisibility(8);
        this.c.removeCallbacksAndMessages(null);
    }
}

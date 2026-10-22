package com.kc.cw.ad.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import com.kc.cw.ad.d.b.f;
import com.kc.cw.ad.internal.utilities.ViewUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class RegionClickView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f39078a;
    private GradientDrawable b;
    private TextView c;

    public RegionClickView(Context context) {
        super(context);
        this.f39078a = false;
        a(context);
    }

    public RegionClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f39078a = false;
        a(context);
    }

    public RegionClickView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f39078a = false;
        a(context);
    }

    private void a(Context context, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.b = gradientDrawable;
        gradientDrawable.setColor(Color.parseColor("#80000000"));
        this.b.setAlpha(178);
        if (i == 1) {
            this.b.setStroke(1, Color.parseColor("#E8E8E8"));
        }
        this.b.setCornerRadius(ViewUtil.dip2px(context, 30.0f));
        setBackgroundDrawable(this.b);
    }

    public void a(Context context) {
        if (this.f39078a) {
            return;
        }
        this.f39078a = true;
        a(context, 1);
        TextView textView = new TextView(context);
        this.c = textView;
        textView.getPaint().setFakeBoldText(true);
        this.c.setLines(1);
        this.c.setTextSize(2, 14.0f);
        this.c.setTextColor(Color.parseColor("#FFFFFF"));
        this.c.setText("点击跳转至第三方应用或详情页");
        this.c.setGravity(17);
        setGravity(17);
        setOrientation(1);
        addView(this.c);
    }

    public void a(String str, float f) {
        setTitle(str);
        setTitleColor("#FFFFFF");
        setTitleSize(f * 14.0f);
        setBackGroundAlpha(0.7d);
        setBackgroundColor("#80000000");
    }

    public void setBackGroundAlpha(double d) {
        GradientDrawable gradientDrawable = this.b;
        if (gradientDrawable == null || d <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            return;
        }
        gradientDrawable.setAlpha((int) (d * 255.0d));
    }

    public void setBackgroundColor(String str) {
        GradientDrawable gradientDrawable = this.b;
        if (gradientDrawable == null || str == null) {
            return;
        }
        try {
            gradientDrawable.setColor(Color.parseColor(str));
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public void setTitle(String str) {
        TextView textView = this.c;
        if (textView == null || str == null) {
            return;
        }
        try {
            textView.setText(str);
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public void setTitleColor(String str) {
        TextView textView = this.c;
        if (textView == null || str == null) {
            return;
        }
        try {
            textView.setTextColor(Color.parseColor(str));
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public void setTitleSize(float f) {
        TextView textView = this.c;
        if (textView == null || f <= 0.0f) {
            return;
        }
        textView.setTextSize(2, f);
    }
}

package com.beizi.fusion.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.so;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class RegionClickView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f27955a;
    GradientDrawable b;
    TextView c;
    private Boolean d;

    public RegionClickView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27955a = false;
        init(context);
    }

    private void a(Context context, int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.b = gradientDrawable;
        gradientDrawable.setColor(Color.parseColor("#80000000"));
        if (i == 1) {
            this.b.setStroke(1, Color.parseColor("#E8E8E8"));
        }
        this.b.setCornerRadius(so.a(context, 30.0f));
        setBackgroundDrawable(this.b);
    }

    public void init(Context context) {
        if (this.f27955a) {
            return;
        }
        this.f27955a = true;
        a(context, 1);
        TextView textView = new TextView(context);
        this.c = textView;
        textView.setLines(1);
        this.c.setTextSize(2, 18.0f);
        this.c.setTextColor(Color.parseColor("#949494"));
        this.c.setText("点击跳转详情页或第三方应用     >");
        this.c.setGravity(17);
        setGravity(17);
        setOrientation(1);
        addView(this.c);
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
            e.printStackTrace();
        }
    }

    public void setDownloadApp(Boolean bool) {
        this.d = bool;
    }

    public void setRegionalClickViewBean(AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickViewBean) {
        String downloadTitle;
        if (regionalClickViewBean == null) {
            return;
        }
        if (this.d.booleanValue()) {
            downloadTitle = regionalClickViewBean.getDownloadTitle();
            if (TextUtils.isEmpty(downloadTitle)) {
                downloadTitle = "点击下载应用";
            }
        } else {
            downloadTitle = regionalClickViewBean.getTitle();
        }
        setTitle(downloadTitle);
        setTitleColor(regionalClickViewBean.getTitleColor());
        setBackGroundAlpha(regionalClickViewBean.getBackgroundAlpha());
        setBackgroundColor(regionalClickViewBean.getBackgroundColor());
    }

    public void setTitle(String str) {
        TextView textView = this.c;
        if (textView == null || str == null) {
            return;
        }
        try {
            textView.setText(str);
        } catch (Exception e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }
    }

    public RegionClickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f27955a = false;
        init(context);
    }

    public RegionClickView(Context context) {
        super(context);
        this.f27955a = false;
        init(context);
    }
}

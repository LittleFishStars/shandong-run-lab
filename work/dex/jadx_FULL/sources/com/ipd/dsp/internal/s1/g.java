package com.ipd.dsp.internal.s1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.ipd.dsp.ad.DspNativeAd;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.internal.c2.s;
import com.ipd.dsp.internal.e1.l;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@SuppressLint({"ViewConstructor"})
public class g extends LinearLayout {
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 2;
    public final float f;
    public final int g;

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public g(Context context) {
        super(context);
        setOrientation(1);
        float fB = s.b(context);
        this.f = fB;
        this.g = (int) s.a(fB, 2.0f);
    }

    public void a(l lVar, int i2) {
        if (i2 == 0) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
            gradientDrawable.setColors(new int[]{Color.parseColor("#33000000"), Color.parseColor("#00000000")});
            setBackground(gradientDrawable);
            int iA = (int) s.a(this.f, 40.0f);
            int i3 = this.g;
            setPadding(iA, i3 * 5, iA, i3 * 2);
        } else if (i2 == 1) {
            com.ipd.dsp.internal.u1.a aVarA = new com.ipd.dsp.internal.u1.a.C0921a().c(10.0f).a();
            aVarA.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
            aVarA.setColors(new int[]{Color.parseColor("#33000000"), Color.parseColor("#00000000")});
            setBackground(aVarA);
            int i4 = this.g;
            int i5 = i4 * 2;
            setPadding(i5, i4 * 6, i5, i5);
        } else if (i2 == 2) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
            gradientDrawable2.setColors(new int[]{Color.parseColor("#66000000"), Color.parseColor("#33000000")});
            setBackground(gradientDrawable2);
            int i6 = this.g;
            setPadding(i6, 0, i6, 0);
        }
        if (i2 == 2) {
            a(getContext(), (DspNativeAd.AppMiitInfo) lVar, true);
        } else {
            a(getContext(), lVar);
            a(getContext(), (DspNativeAd.AppMiitInfo) lVar, false);
        }
    }

    public final void a(Context context, DspNativeAd.AppMiitInfo appMiitInfo) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setGravity(17);
        if (o.c(appMiitInfo.getDescriptionUrl())) {
            linearLayout.addView(a(context));
            linearLayout.addView(a(context, "功能简介", appMiitInfo.getDescriptionUrl()));
        }
        if (o.c(appMiitInfo.getPermissionsUrl())) {
            linearLayout.addView(a(context));
            linearLayout.addView(a(context, "应用权限", appMiitInfo.getPermissionsUrl()));
        }
        if (o.c(appMiitInfo.getPrivacyAgreement())) {
            linearLayout.addView(a(context));
            linearLayout.addView(a(context, "隐私政策", appMiitInfo.getPrivacyAgreement()));
        }
        if (linearLayout.getChildCount() > 0) {
            linearLayout.addView(a(context));
        }
        if (linearLayout.getChildCount() > 0) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 17;
            addView(linearLayout, layoutParams);
        }
    }

    public final TextView a(Context context, String str, String str2) {
        TextView textView = new TextView(context);
        textView.setGravity(17);
        textView.setText(Html.fromHtml(String.format(Locale.getDefault(), "<a href='%s'>%s</a>", str2, str)));
        textView.setLinkTextColor(-1);
        textView.setTextSize(8.0f);
        textView.setLinksClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i2 = this.g * 5;
        layoutParams.setMarginStart(i2);
        layoutParams.setMarginEnd(i2);
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    public final View a(Context context) {
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#FFB7B7B7"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(2, -1);
        layoutParams.gravity = 16;
        int i2 = this.g;
        layoutParams.setMargins(0, i2, 0, i2);
        view.setLayoutParams(layoutParams);
        return view;
    }

    public final void a(Context context, DspNativeAd.AppMiitInfo appMiitInfo, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (o.c(appMiitInfo.getAppName())) {
            arrayList.add("应用名: " + appMiitInfo.getAppName());
        }
        if (o.c(appMiitInfo.getVersionName())) {
            arrayList.add("应用版本: " + appMiitInfo.getVersionName());
        }
        if (o.c(appMiitInfo.getAuthorName())) {
            arrayList.add("开发者: " + appMiitInfo.getAuthorName());
        }
        if (o.c(appMiitInfo.getIcpNumber())) {
            arrayList.add("备案号: " + appMiitInfo.getIcpNumber());
        }
        if (o.c(appMiitInfo.getSuitableAge())) {
            arrayList.add("适用年龄: " + appMiitInfo.getSuitableAge());
        }
        if (arrayList.isEmpty()) {
            return;
        }
        TextView textView = new TextView(context);
        if (z) {
            if (o.c(appMiitInfo.getDescriptionUrl())) {
                arrayList.add(String.format(Locale.getDefault(), "<a href='%s'>%s</a>", appMiitInfo.getDescriptionUrl(), "功能简介"));
            }
            if (o.c(appMiitInfo.getPermissionsUrl())) {
                arrayList.add(String.format(Locale.getDefault(), "<a href='%s'>%s</a>", appMiitInfo.getPermissionsUrl(), "应用权限"));
            }
            if (o.c(appMiitInfo.getPrivacyAgreement())) {
                arrayList.add(String.format(Locale.getDefault(), "<a href='%s'>%s</a>", appMiitInfo.getPrivacyAgreement(), "隐私政策"));
            }
            textView.setText(Html.fromHtml(TextUtils.join(" | ", arrayList), 63));
            textView.setLinksClickable(true);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setGravity(GravityCompat.START);
            textView.setLinkTextColor(-1);
        } else {
            textView.setText(TextUtils.join(" | ", arrayList));
        }
        textView.setTextColor(-1);
        textView.setTextSize(z ? 6.0f : 8.0f);
        textView.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        int i2 = this.g;
        layoutParams.topMargin = i2;
        layoutParams.setMarginStart(i2);
        layoutParams.setMarginEnd(this.g);
        addView(textView, layoutParams);
    }
}

package com.kc.cw.ad.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kc.cw.ad.internal.utilities.ViewUtil;
import com.kc.cw.ad.widget.RegionClickView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f38816a;

    public j(Context context) {
        this.f38816a = context;
    }

    private ViewGroup.MarginLayoutParams a(int i, int i2, float f) {
        int i3;
        int i4;
        float screenHeightDp = ViewUtil.getScreenHeightDp(this.f38816a);
        TextUtils.isEmpty("50%");
        String str = "75%";
        if (TextUtils.isEmpty("75%")) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "screenHeightDp = " + screenHeightDp + ",adHeightDp = " + i2);
            str = screenHeightDp > ((float) i2) ? "63" : "188";
        }
        String str2 = TextUtils.isEmpty("250") ? "325" : "250";
        String str3 = TextUtils.isEmpty("40") ? "65" : "40";
        float screenWidthDp = ViewUtil.getScreenWidthDp(this.f38816a);
        int i5 = (Integer.parseInt("50") * i) / 100;
        if (str.endsWith("%")) {
            i3 = (Integer.parseInt(str.substring(0, str.indexOf("%"))) * i2) / 100;
        } else {
            i3 = i2 - Integer.parseInt(str);
            com.kc.cw.ad.d.b.f.a("OctopusAd", "adHeightDp = " + i2 + ", centerYInt = " + i3);
        }
        int i6 = 400;
        if (str2.endsWith("%")) {
            int i7 = Integer.parseInt(str2.substring(0, str2.indexOf("%")));
            if (screenWidthDp >= 400.0f) {
                i4 = (i7 * 400) / 100;
                i6 = i4;
            } else {
                i6 = (((int) screenWidthDp) * i7) / 100;
            }
        } else {
            i4 = Integer.parseInt(str2);
            if (i4 < 400) {
                i6 = i4;
            }
        }
        int i8 = str3.endsWith("%") ? (Integer.parseInt(str3.substring(0, str3.indexOf("%"))) * i6) / 100 : Integer.parseInt(str3);
        int iDip2px = ViewUtil.dip2px(this.f38816a, i6 * f);
        int iDip2px2 = ViewUtil.dip2px(this.f38816a, i8 * f);
        int iDip2px3 = ViewUtil.dip2px(this.f38816a, i5);
        int iDip2px4 = ViewUtil.dip2px(this.f38816a, i3);
        com.kc.cw.ad.d.b.f.a("OctopusAd", "widthInt = " + iDip2px + ",heightInt = " + iDip2px2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iDip2px, iDip2px2);
        com.kc.cw.ad.d.b.f.a("OctopusAd", "centerYInt = " + iDip2px4 + ",centerXInt = " + iDip2px3 + ",adWidthDp = " + i + ",adHeightDp = " + i2);
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = iDip2px4 - (iDip2px2 / 2);
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = iDip2px3 - (iDip2px / 2);
        return layoutParams;
    }

    public View a(int i, int i2, String str, boolean z) {
        if (this.f38816a == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            str = "点击跳转至第三方应用或详情页";
        }
        com.kc.cw.ad.d.b.f.c("OctopusAd", "adWidthDp = " + i + ",adHeightDp = " + i2);
        float f = ((float) i) / 360.0f;
        RegionClickView regionClickView = new RegionClickView(this.f38816a);
        regionClickView.a(str, f);
        regionClickView.setLayoutParams(a(i, i2, f));
        return regionClickView;
    }

    public void a() {
        this.f38816a = null;
    }
}

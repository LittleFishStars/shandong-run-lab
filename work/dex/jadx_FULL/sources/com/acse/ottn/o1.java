package com.acse.ottn;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.acse.ottn.util.HelpShopAppUtil;
import com.igexin.assist.util.AssistUtils;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class o1 {
    public static o1 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<HashMap<String, String>> f23119a = new ArrayList();

    public static o1 c() {
        if (b == null) {
            synchronized (o1.class) {
                if (b == null) {
                    b = new o1();
                }
            }
        }
        return b;
    }

    public void a(List<HashMap<String, String>> list) {
        this.f23119a = list;
    }

    public String b() {
        try {
            if (HelpShopAppUtil.getContext() == null) {
                return "demo";
            }
            PackageManager packageManager = HelpShopAppUtil.getContext().getPackageManager();
            return packageManager.getPackageInfo(HelpShopAppUtil.getContext().getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<HashMap<String, String>> d() {
        return this.f23119a;
    }

    public boolean e() {
        String strB = p4.b();
        return AssistUtils.BRAND_HW.equals(strB) || AssistUtils.BRAND_HON.equals(strB) || "tdtech".equals(strB) || "ptac".equals(strB) || "tyh612m".equals(strB) || p4.t();
    }

    public boolean f() {
        String strB = p4.b();
        return e() || "oppo".equals(strB) || "vivo".equals(strB) || "xiaomi".equals(strB) || "redmi".equals(strB) || "realme".equals(strB) || "oneplus".equals(strB) || "blackshark".equals(strB) || "samsung".equals(strB);
    }

    public final Object g() throws ObjectStreamException {
        return b;
    }

    public void a(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if (n3.a() != null) {
            n3.a().a("screenWidth", i);
            n3.a().a("screenHight", i2);
        }
    }

    public void a(String str) {
        if (n3.a() == null) {
            return;
        }
        n3.a().b("accessiblity_state", str);
    }

    public String a() {
        if (n3.a() == null) {
            return l0.k;
        }
        String strE = n3.a().e("accessiblity_state");
        return TextUtils.isEmpty(strE) ? l0.k : strE;
    }
}

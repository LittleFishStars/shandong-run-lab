package com.zj.adlib;

import android.app.Activity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.gyf.immersionbar.e;
import com.huachenjie.base.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class cr8 {
    public static void a(Object object, boolean isDarkFont) {
        e eVarV3;
        if (object == null) {
            return;
        }
        if (object instanceof Activity) {
            eVarV3 = e.p3((Activity) object);
        } else if (object instanceof DialogFragment) {
            eVarV3 = e.x3((DialogFragment) object);
        } else if (object instanceof android.app.DialogFragment) {
            eVarV3 = e.t3((android.app.DialogFragment) object);
        } else if (object instanceof Fragment) {
            eVarV3 = e.z3((Fragment) object);
        } else {
            eVarV3 = object instanceof android.app.Fragment ? e.v3((android.app.Fragment) object) : null;
        }
        if (eVarV3 != null) {
            eVarV3.G2(R.color.transparent).T2(isDarkFont).u1(R.color.white).G1(true).a1();
        }
    }

    public static void b(Activity activity, boolean isDarkFont) {
        a(activity, isDarkFont);
    }

    public static void c(android.app.DialogFragment fragment, boolean isDarkFont) {
        a(fragment, isDarkFont);
    }

    public static void d(android.app.Fragment fragment, boolean isDarkFont) {
        a(fragment, isDarkFont);
    }

    public static void e(DialogFragment fragment, boolean isDarkFont) {
        a(fragment, isDarkFont);
    }

    public static void f(Fragment fragment, boolean isDarkFont) {
        a(fragment, isDarkFont);
    }
}

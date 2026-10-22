package com.zj.adlib;

import android.graphics.drawable.Drawable;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import androidx.annotation.DrawableRes;
import androidx.annotation.RawRes;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.i;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class xf7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f45814a = 8192;

    public xf7() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean a(String str, String str2) {
        try {
            String[] list = Utils.a().getAssets().list(str);
            if (list == null || list.length <= 0) {
                return i.g1(str2, Utils.a().getAssets().open(str));
            }
            boolean zA = true;
            for (String str3 : list) {
                zA &= a(str + WVNativeCallbackUtil.SEPERATER + str3, str2 + WVNativeCallbackUtil.SEPERATER + str3);
            }
            return zA;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean b(@RawRes int i, String str) {
        return i.g1(str, Utils.a().getResources().openRawResource(i));
    }

    public static int c(String str) {
        return Utils.a().getResources().getIdentifier(str, "anim", Utils.a().getPackageName());
    }

    public static int d(String str) {
        return Utils.a().getResources().getIdentifier(str, "color", Utils.a().getPackageName());
    }

    public static int e(String str) {
        return Utils.a().getResources().getIdentifier(str, "dimen", Utils.a().getPackageName());
    }

    public static Drawable f(@DrawableRes int i) {
        return ContextCompat.getDrawable(Utils.a(), i);
    }

    public static int g(String str) {
        return Utils.a().getResources().getIdentifier(str, "drawable", Utils.a().getPackageName());
    }

    public static int h(String str) {
        return Utils.a().getResources().getIdentifier(str, "id", Utils.a().getPackageName());
    }

    public static int i(String str) {
        return Utils.a().getResources().getIdentifier(str, "layout", Utils.a().getPackageName());
    }

    public static int j(String str) {
        return Utils.a().getResources().getIdentifier(str, "menu", Utils.a().getPackageName());
    }

    public static int k(String str) {
        return Utils.a().getResources().getIdentifier(str, "mipmap", Utils.a().getPackageName());
    }

    public static int l(String str) {
        return Utils.a().getResources().getIdentifier(str, TypedValues.Custom.S_STRING, Utils.a().getPackageName());
    }

    public static int m(String str) {
        return Utils.a().getResources().getIdentifier(str, "style", Utils.a().getPackageName());
    }

    public static List<String> n(String str) {
        return o(str, "");
    }

    public static List<String> o(String str, String str2) {
        try {
            return i.n0(Utils.a().getResources().getAssets().open(str), str2);
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static String p(String str) {
        return q(str, null);
    }

    public static String q(String str, String str2) {
        try {
            byte[] bArrM0 = i.m0(Utils.a().getAssets().open(str));
            if (bArrM0 == null) {
                return "";
            }
            if (i.C0(str2)) {
                return new String(bArrM0);
            }
            try {
                return new String(bArrM0, str2);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return "";
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static List<String> r(@RawRes int i) {
        return s(i, "");
    }

    public static List<String> s(@RawRes int i, String str) {
        return i.n0(Utils.a().getResources().openRawResource(i), str);
    }

    public static String t(@RawRes int i) {
        return u(i, null);
    }

    public static String u(@RawRes int i, String str) {
        byte[] bArrM0 = i.m0(Utils.a().getResources().openRawResource(i));
        if (bArrM0 == null) {
            return null;
        }
        if (i.C0(str)) {
            return new String(bArrM0);
        }
        try {
            return new String(bArrM0, str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }
}

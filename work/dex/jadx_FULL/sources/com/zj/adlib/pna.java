package com.zj.adlib;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class pna {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f44023a;

    public pna(Context context) {
        this.f44023a = context;
    }

    public static boolean b(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strX = zwa.X(context);
        try {
            File file = new File(strX + str2 + str + ".dat");
            if (file.exists() && !boa.l(file)) {
                return false;
            }
            try {
                boa.h(strX + str2);
                boa.k(str, context);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static boolean d(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strV = zwa.v(context);
        try {
            File file = new File(strV + str2 + str);
            if (file.exists() && !boa.l(file)) {
                return false;
            }
            try {
                boa.h(strV + str2);
                boa.k(str, context);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public final void a(com.amap.api.col.p0003l.ax axVar) {
        c(axVar);
    }

    public final boolean c(com.amap.api.col.p0003l.ax axVar) {
        if (axVar != null) {
            String pinyin = axVar.getPinyin();
            boolean zB = b(pinyin, this.f44023a, "vmap/");
            if (pinyin.equals("quanguogaiyaotu")) {
                pinyin = "quanguo";
            }
            boolean z = true;
            boolean z2 = b(pinyin, this.f44023a, "map/") || zB;
            if (!d(boa.i(axVar.getUrl()), this.f44023a, "map/") && !z2) {
                z = false;
            }
            if (z) {
                axVar.i();
                return z;
            }
            axVar.h();
        }
        return false;
    }
}

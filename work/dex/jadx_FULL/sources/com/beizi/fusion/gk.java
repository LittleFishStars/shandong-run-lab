package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.beizi.fusion.model.RequestInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class gk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String f27349a = "OaidUtil";
    private static String b;
    public static b7.b c = new a();
    private static boolean d = true;

    public class a implements b7.b {
        @Override // com.beizi.fusion.b7.b
        public void a(String str) {
            Log.e(gk.f27349a, "code cn Oaid:" + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            gk.b = str;
            Context contextM = q1.h().m();
            co.b(contextM, "__OAID__", gk.b);
            co.b(contextM, "__CNOAID__", gk.b);
            if (RequestInfo.getInstance(contextM).getDevInfo() != null) {
                if (al.c() && BeiZis.isLimitPersonalAds()) {
                    return;
                }
                RequestInfo.getInstance(contextM).getDevInfo().setOaid(gk.b);
                RequestInfo.getInstance(contextM).getDevInfo().setCnOaid(gk.b);
            }
        }
    }
}

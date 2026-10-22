package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.model.Manager;
import com.beizi.fusion.model.RequestInfo;
import com.beizi.fusion.model.ResponseInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class al {
    public static void a(boolean z) {
        try {
            if (z) {
                try {
                    s3.a(false);
                } catch (Throwable unused) {
                }
                BeiZis.setLimitPersonalAds(false);
                return;
            }
            try {
                s3.a(true);
            } catch (Throwable unused2) {
            }
            BeiZis.setLimitPersonalAds(true);
            if (q1.h().m() == null || !c()) {
                return;
            }
            if (RequestInfo.getInstance(q1.h().m()).getDevInfo() != null && !TextUtils.isEmpty(RequestInfo.getInstance(q1.h().m()).getDevInfo().getOaid())) {
                RequestInfo.getInstance(q1.h().m()).getDevInfo().setOaid("");
            }
            if (RequestInfo.getInstance(q1.h().m()).getDevInfo() == null || TextUtils.isEmpty(RequestInfo.getInstance(q1.h().m()).getDevInfo().getHonorOaid())) {
                return;
            }
            RequestInfo.getInstance(q1.h().m()).getDevInfo().setHonorOaid("");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean b() {
        int iA = a();
        boolean zIsLimitPersonalAds = BeiZis.isLimitPersonalAds();
        if (iA == 0 || iA == 2) {
            return zIsLimitPersonalAds;
        }
        return false;
    }

    public static boolean c() {
        int iA = a();
        return iA == 0 || iA == 2;
    }

    private static int a() {
        Context contextM = q1.h().m();
        if (contextM == null) {
            return 0;
        }
        if (!ResponseInfo.getInstance(contextM).isInit()) {
            ResponseInfo.getInstance(contextM).init();
        }
        Manager manager = ResponseInfo.getInstance(contextM).getManager();
        if (manager != null) {
            return manager.getPersonalRecommend();
        }
        return 0;
    }
}

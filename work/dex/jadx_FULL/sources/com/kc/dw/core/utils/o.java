package com.kc.dw.core.utils;

import android.app.NotificationManager;
import android.content.Context;
import android.text.TextUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class o extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f39391a;
    public final Context b;
    public final DownloadUtils c;

    public o(DownloadUtils downloadUtils, String str, Context context) {
        this.c = downloadUtils;
        this.f39391a = str;
        this.b = context;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        String[] strArr;
        try {
            i0 i0Var = DownloadUtils.h.get(Integer.valueOf(DownloadUtils.a(this.f39391a)));
            if (i0Var != null && (strArr = i0Var.e) != null) {
                LogUtil.d("DownloadUtils", "Report send dn_succ");
                for (String str : strArr) {
                    if (!TextUtils.isEmpty(str)) {
                        z.a(this.b, str, new j());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int iA = DownloadUtils.a(this.f39391a);
        com.kc.dw.core.download.a.C1023a.f39242a.a(this.f39391a);
        NotificationManager notificationManager = this.c.f39336a;
        if (notificationManager != null) {
            notificationManager.cancel(iA);
        }
        DownloadUtils.a(this.b, this.f39391a);
        DownloadUtils.h.remove(Integer.valueOf(DownloadUtils.a(this.f39391a)));
    }
}

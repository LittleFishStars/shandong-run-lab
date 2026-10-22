package com.alibaba.triver.permission;

import android.text.TextUtils;
import com.alibaba.triver.utils.CommonUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<String> f25107a;

    static {
        ArrayList arrayList = new ArrayList();
        f25107a = arrayList;
        arrayList.add("sendMtop");
        f25107a.add("remoteLog");
        f25107a.add("tyroRequest");
        f25107a.add("showRemoteDebugPanel");
        f25107a.add("showRemoteDebugMask");
        f25107a.add("needShowAuthSettingEntry");
        f25107a.add("reportCicadaStatus");
        f25107a.add("getPrefetchData");
    }

    public static boolean a(String str) {
        if (TextUtils.equals(str, "remoteLog") && f25107a.contains("remoteLog") && CommonUtils.closeRemoteLogWhite()) {
            f25107a.remove("remoteLog");
        }
        return f25107a.contains(str);
    }
}

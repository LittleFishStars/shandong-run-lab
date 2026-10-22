package com.kwai.library.ipneigh;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public final class c {
    private static d F(Context context, boolean z) {
        return b(context, false, false);
    }

    private static d b(Context context, boolean z, boolean z2) {
        String strJ;
        try {
            if (!b.isWifiConnected(context)) {
                return new d("", false, "");
            }
            String strGs = b.gs(((WifiManager) context.getApplicationContext().getSystemService("wifi")).getDhcpInfo().gateway);
            if (z) {
                strJ = "";
            } else {
                strJ = a.iO("timeout 5 ip neigh show " + strGs);
            }
            if (z || TextUtils.isEmpty(strJ)) {
                strJ = KwaiIpNeigh.j(strGs, false);
            }
            String strIQ = b.iQ(strJ);
            return new d(strIQ, !TextUtils.isEmpty(strIQ), strJ);
        } catch (Throwable th) {
            return new d("", false, th.getMessage());
        }
    }

    public static d eV(Context context) {
        return F(context, false);
    }
}

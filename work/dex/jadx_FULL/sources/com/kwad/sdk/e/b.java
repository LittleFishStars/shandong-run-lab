package com.kwad.sdk.e;

import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b implements a {
    private static volatile b bgt;
    private static c bgu;

    private b() {
    }

    public static synchronized b QY() {
        if (bgt == null) {
            synchronized (b.class) {
                if (bgt == null) {
                    bgt = new b();
                }
            }
        }
        return bgt;
    }

    private static String QZ() {
        return a(false, "", 2);
    }

    public static void a(c cVar) {
        bgu = cVar;
    }

    @Override // com.kwad.sdk.e.a
    public final String QO() {
        c cVar = bgu;
        return cVar != null ? cVar.QO() : QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String QP() {
        c cVar = bgu;
        return cVar != null ? cVar.QP() : QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String QQ() {
        c cVar = bgu;
        return cVar != null ? cVar.QQ() : QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String QR() {
        c cVar = bgu;
        return cVar != null ? cVar.QR() : QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String QS() {
        c cVar = bgu;
        return cVar != null ? cVar.QS() : QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String QT() {
        c cVar = bgu;
        return cVar != null ? cVar.QT() : QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String QU() {
        c cVar = bgu;
        return cVar != null ? cVar.QU() : QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String QV() {
        c cVar = bgu;
        return cVar != null ? cVar.QV() : QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String QW() {
        c cVar = bgu;
        return cVar != null ? cVar.QW() : QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String QX() {
        c cVar = bgu;
        return cVar != null ? cVar.QX() : QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String getAppId() {
        c cVar = bgu;
        return cVar != null ? cVar.getAppId() : QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String getDeviceId() {
        c cVar = bgu;
        return cVar != null ? cVar.getDeviceId() : QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String getIMEI() {
        c cVar = bgu;
        return cVar != null ? cVar.getIMEI() : QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String getIccId() {
        c cVar = bgu;
        return cVar != null ? cVar.getIccId() : QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String getIp() {
        c cVar = bgu;
        return cVar != null ? cVar.getIp() : QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String getLocation() {
        c cVar = bgu;
        return cVar != null ? cVar.getLocation() : QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String getMac() {
        c cVar = bgu;
        return cVar != null ? cVar.getMac() : QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String getOaid() {
        c cVar = bgu;
        return cVar != null ? cVar.getOaid() : QZ();
    }

    @Override // com.kwad.sdk.e.a
    public final String getSdkVersion() {
        c cVar = bgu;
        return cVar != null ? cVar.getSdkVersion() : QZ();
    }

    public static String a(boolean z, Object obj, int i) {
        HashMap map = new HashMap();
        map.put("userSet", String.valueOf(z));
        map.put("value", obj);
        map.put("errorCode", String.valueOf(i));
        return new JSONObject(map).toString();
    }
}

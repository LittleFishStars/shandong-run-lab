package com.alibaba.analytics.core.sync;

import android.content.Context;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.analytics.a.y;
import com.alibaba.analytics.a.z;
import com.alibaba.analytics.core.model.LogField;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    public static final com.alibaba.analytics.core.selfmonitor.g mMonitor = new com.alibaba.analytics.core.selfmonitor.g();
    static String aX = null;
    static String aY = null;
    private static long e = 0;
    private static boolean O = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static Class f661a = null;
    private static int v = 0;
    private static final String aZ = String.valueOf((char) 1);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static GZIPOutputStream f662a = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ByteArrayOutputStream f23790a = null;

    public static byte[] a(Map<String, String> map) throws Exception {
        return a(map, 1);
    }

    private static byte[] b(Map<String, String> map) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        String strW = w();
        if (strW == null || strW.length() <= 0) {
            byteArrayOutputStream.write(com.alibaba.analytics.a.d.d(0));
        } else {
            byteArrayOutputStream.write(com.alibaba.analytics.a.d.d(strW.getBytes().length));
            byteArrayOutputStream.write(strW.getBytes());
        }
        if (map != null && map.size() > 0) {
            for (String str : map.keySet()) {
                try {
                    byteArrayOutputStream.write(com.alibaba.analytics.a.d.f(Integer.valueOf(str).intValue()));
                    String str2 = map.get(str);
                    if (str2 != null) {
                        byteArrayOutputStream.write(com.alibaba.analytics.a.d.f(str2.getBytes().length));
                        byteArrayOutputStream.write(str2.getBytes());
                    } else {
                        byteArrayOutputStream.write(com.alibaba.analytics.a.d.f(0));
                    }
                } catch (Exception unused) {
                    com.alibaba.analytics.a.j.i("BizRequest", "EventId NumberFormatException. eventId", str, ",eventLogs", map.get(str));
                }
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return byteArray;
    }

    public static String w() {
        String str;
        String appkey = com.alibaba.analytics.a.a.getAppkey();
        Context context = com.alibaba.analytics.core.d.a().getContext();
        String strG = com.alibaba.analytics.core.d.a().g();
        if (strG == null) {
            strG = "";
        }
        Map<String, String> mapB = y.b(context);
        if (mapB == null || (str = mapB.get(LogField.APPVERSION.toString())) == null) {
            str = "";
        }
        String strJ = com.alibaba.analytics.a.a.j();
        if (strJ == null) {
            strJ = "";
        }
        String str2 = mapB != null ? mapB.get(LogField.UTDID.toString()) : "";
        String strE = com.alibaba.analytics.b.a.a().E();
        StringBuilder sb = new StringBuilder(com.alibaba.analytics.core.d.a().m122k() ? String.format("ak=%s&av=%s&avsys=%s&c=%s&d=%s&sv=%s&dk=%s", appkey, strG, str, strJ, str2, strE, com.alibaba.analytics.core.d.a().n()) : String.format("ak=%s&av=%s&avsys=%s&c=%s&d=%s&sv=%s", appkey, strG, str, strJ, str2, strE));
        if (com.alibaba.analytics.core.d.a().m116h()) {
            if (v == 0) {
                aY = z.D();
            }
            int i = v + 1;
            v = i;
            if (i > 50) {
                v = 0;
            }
        }
        if (!TextUtils.isEmpty(aY)) {
            sb.append("&");
            sb.append("wua=");
            sb.append(aY);
        }
        sb.append("&");
        sb.append(LoginConstants.UNDER_LINE);
        sb.append("ut_sample");
        sb.append("=");
        sb.append(com.alibaba.analytics.core.a.a.a.a().get("ut_sample"));
        sb.append("&");
        sb.append(LoginConstants.UNDER_LINE);
        sb.append("utap_system");
        sb.append("=");
        sb.append(com.alibaba.analytics.core.a.a.a.a().get("utap_system"));
        sb.append("&");
        sb.append(LoginConstants.UNDER_LINE);
        sb.append("ap_stat");
        sb.append("=");
        sb.append(com.alibaba.analytics.core.a.a.a.a().get("ap_stat"));
        sb.append("&");
        sb.append(LoginConstants.UNDER_LINE);
        sb.append("ap_alarm");
        sb.append("=");
        sb.append(com.alibaba.analytics.core.a.a.a.a().get("ap_alarm"));
        sb.append("&");
        sb.append(LoginConstants.UNDER_LINE);
        sb.append("ap_counter");
        sb.append("=");
        sb.append(com.alibaba.analytics.core.a.a.a.a().get("ap_counter"));
        sb.append("&");
        sb.append(LoginConstants.UNDER_LINE);
        sb.append("ut_bussiness");
        sb.append("=");
        sb.append(com.alibaba.analytics.core.a.a.a.a().get("ut_bussiness"));
        sb.append("&");
        sb.append(LoginConstants.UNDER_LINE);
        sb.append("ut_realtime");
        sb.append("=");
        sb.append(com.alibaba.analytics.core.a.a.a.a().get("ut_realtime"));
        String string = sb.toString();
        com.alibaba.analytics.a.j.i("PostData", "send url :" + string);
        return string;
    }

    public static byte[] a(Map<String, String> map, int i) throws Exception {
        byte[] bArrA = com.alibaba.analytics.a.e.a(b(map));
        if (bArrA == null) {
            return null;
        }
        if (bArrA.length >= 16777216) {
            if (com.alibaba.analytics.core.d.a().m115g()) {
                mMonitor.a(com.alibaba.analytics.core.selfmonitor.f.a(com.alibaba.analytics.core.selfmonitor.f.s, String.valueOf(bArrA.length), Double.valueOf(1.0d)));
            }
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(1);
        byteArrayOutputStream.write(com.alibaba.analytics.a.d.e(bArrA.length));
        byteArrayOutputStream.write(i);
        byte b = (byte) 9;
        if (com.alibaba.analytics.core.d.a().m122k()) {
            b = (byte) (b | com.google.common.base.a.r);
        }
        byteArrayOutputStream.write((byte) (b | 32));
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(bArrA);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e2) {
            com.alibaba.analytics.a.j.e(null, e2, new Object[0]);
        }
        return byteArray;
    }

    public static int a(byte[] bArr) throws Throwable {
        int i = -1;
        if (bArr != null && bArr.length >= 12) {
            e = bArr.length;
            if (com.alibaba.analytics.a.d.a(bArr, 1, 3) + 8 != bArr.length) {
                com.alibaba.analytics.a.j.e("", "recv len error");
            } else {
                boolean z = 1 == (bArr[5] & 1);
                int iA = com.alibaba.analytics.a.d.a(bArr, 8, 4);
                int length = bArr.length - 12 >= 0 ? bArr.length - 12 : 0;
                if (length <= 0) {
                    aX = null;
                } else if (z) {
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(bArr, 12, bArr2, 0, length);
                    byte[] bArrB = com.alibaba.analytics.a.e.b(bArr2);
                    aX = new String(bArrB, 0, bArrB.length);
                } else {
                    aX = new String(bArr, 12, length);
                }
                i = iA;
            }
        } else {
            com.alibaba.analytics.a.j.e("", "recv errCode UNKNOWN_ERROR");
        }
        if (107 == i) {
            com.alibaba.analytics.core.d.a().a(true);
        }
        if (109 == i) {
            com.alibaba.analytics.core.d.a().d(true);
        }
        if (115 == i) {
            com.alibaba.analytics.core.d.a().c(true);
        }
        if (116 == i) {
            com.alibaba.analytics.core.d.a().b(true);
        }
        com.alibaba.analytics.a.j.d("", "errCode", Integer.valueOf(i));
        return i;
    }
}

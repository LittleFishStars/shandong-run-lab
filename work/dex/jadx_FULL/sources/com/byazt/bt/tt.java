package com.byazt.bt;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.MotionEventCompat;
import com.alibaba.android.arouter.utils.Consts;
import com.byazt.nr.m;
import com.zj.adlib.u15;
import java.lang.reflect.Field;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 274, 13})
public class tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f28330a;
    public static c n;
    public static AtomicBoolean c = new AtomicBoolean(false);
    public static final Map<String, String> tt = new ConcurrentHashMap();
    public static volatile long ve = 0;
    public static final AtomicBoolean uj = new AtomicBoolean(false);

    public interface c {
        void c(String str);

        void tt(String str);
    }

    public static void c(c cVar) {
        n = cVar;
    }

    public static String[] tt(com.byazt.dna.c cVar, boolean z, int i, com.byazt.lz.ve veVar) {
        return uj(cVar, z, i, veVar);
    }

    private static String[] uj(com.byazt.dna.c cVar, boolean z, int i, com.byazt.lz.ve veVar) {
        String[] strArr = {"", ""};
        Map<String, String> mapC = c(false, cVar, z, i, veVar);
        if (mapC != null) {
            strArr[0] = mapC.get("local_ipv4");
            strArr[1] = mapC.get("local_ipv6");
        }
        return strArr;
    }

    private static String[] ve(com.byazt.dna.c cVar, boolean z, int i, com.byazt.lz.ve veVar) {
        String[] strArrTt = tt(cVar, z, i, veVar);
        if (TextUtils.isEmpty(strArrTt[0]) && TextUtils.isEmpty(strArrTt[1])) {
            x.c("", cVar, i);
        }
        return strArrTt;
    }

    public static String c(com.byazt.dna.c cVar, boolean z, int i, com.byazt.lz.ve veVar) {
        Map<String, String> mapC = c(false, cVar, z, i, veVar);
        String str = mapC != null ? mapC.get("mac") : "";
        return str == null ? "" : str;
    }

    private static String tt(byte[] bArr) {
        return (bArr[0] & 255) + Consts.DOT + (bArr[1] & 255) + Consts.DOT + (bArr[2] & 255) + Consts.DOT + (bArr[3] & 255);
    }

    private static Map<String, String> c(boolean z, com.byazt.dna.c cVar, int i) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() + 300000;
        if (!z) {
            if (c.get()) {
                ve = 0L;
                c.set(false);
            }
            if (jElapsedRealtime - ve < 300000) {
                uj.set(true);
                return tt;
            }
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                ve = jElapsedRealtime;
                uj.set(true);
                return null;
            }
            HashMap map = new HashMap();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (networkInterfaceNextElement != null) {
                    map.put(networkInterfaceNextElement.getName(), networkInterfaceNextElement);
                }
            }
            c(map, cVar, i);
            c(map, cVar);
            ve = jElapsedRealtime;
            uj.set(true);
            return tt;
        } catch (Throwable unused) {
        }
    }

    public static Map<String, String> c(boolean z, com.byazt.dna.c cVar, boolean z2, int i, com.byazt.lz.ve veVar) {
        Map<String, String> mapC;
        if (!c(cVar, z2, veVar)) {
            return tt;
        }
        if (uj.get()) {
            return c(z, cVar, i);
        }
        synchronized (tt.class) {
            mapC = c(z, cVar, i);
        }
        return mapC;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0066  */
    /* JADX WARN: Code duplicated, block: B:31:0x006c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:0x0075  */
    /* JADX WARN: Code duplicated, block: B:45:0x0095  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b0  */
    public static String[] c(boolean z, AtomicBoolean atomicBoolean, com.byazt.dna.c cVar, boolean z2, int i, com.byazt.lz.ve veVar) {
        String strDecryptAESWithCBC;
        String strDecryptAESWithCBC2;
        long j;
        String str;
        String[] strArrVe;
        String[] strArr = {"", ""};
        String strC = x.c(cVar);
        long j2 = 0;
        try {
            com.byazt.dna.n nVar = (com.byazt.dna.n) com.byazt.ut.uj.getService("armor_service");
            if (TextUtils.isEmpty(strC)) {
                strDecryptAESWithCBC2 = null;
                j = 0;
            } else {
                JSONObject jSONObject = new JSONObject(strC);
                strDecryptAESWithCBC2 = nVar.decryptAESWithCBC(jSONObject.getString("value"));
                try {
                    j = jSONObject.getLong("time");
                } catch (JSONException e) {
                    e = e;
                    strDecryptAESWithCBC = null;
                    j = 0;
                    m.c(e);
                    if (strDecryptAESWithCBC2 == null) {
                        strArr[0] = strDecryptAESWithCBC2;
                        strArr[1] = strDecryptAESWithCBC;
                        if (z) {
                            return strArr;
                        }
                    } else {
                        strArr[0] = strDecryptAESWithCBC2;
                        strArr[1] = strDecryptAESWithCBC;
                        if (z) {
                            return strArr;
                        }
                    }
                    if (atomicBoolean.getAndSet(false)) {
                        strArrVe = ve(cVar, z2, i, veVar);
                        return !TextUtils.isEmpty(strArrVe[0]) ? strArrVe : strArrVe;
                    }
                    if (strDecryptAESWithCBC2 != null) {
                        strDecryptAESWithCBC2 = null;
                    }
                    if (strDecryptAESWithCBC != null) {
                    }
                    if (!TextUtils.isEmpty(strDecryptAESWithCBC2)) {
                    }
                    strArr[0] = strDecryptAESWithCBC2;
                    strArr[1] = str;
                    return strArr;
                }
            }
            try {
                String strTt = x.tt(cVar);
                if (TextUtils.isEmpty(strTt)) {
                    strDecryptAESWithCBC = null;
                } else {
                    JSONObject jSONObject2 = new JSONObject(strTt);
                    strDecryptAESWithCBC = nVar.decryptAESWithCBC(jSONObject2.getString("value"));
                    try {
                        j2 = jSONObject2.getLong("time");
                    } catch (JSONException e2) {
                        e = e2;
                        m.c(e);
                    }
                }
            } catch (JSONException e3) {
                e = e3;
                strDecryptAESWithCBC = null;
            }
        } catch (JSONException e4) {
            e = e4;
            strDecryptAESWithCBC = null;
            strDecryptAESWithCBC2 = null;
        }
        if (strDecryptAESWithCBC2 == null || strDecryptAESWithCBC != null) {
            strArr[0] = strDecryptAESWithCBC2;
            strArr[1] = strDecryptAESWithCBC;
            if (z) {
                return strArr;
            }
        }
        if (atomicBoolean.getAndSet(false)) {
            strArrVe = ve(cVar, z2, i, veVar);
            if (!TextUtils.isEmpty(strArrVe[0]) && TextUtils.isEmpty(strArrVe[1])) {
                if (strDecryptAESWithCBC2 == null) {
                    strDecryptAESWithCBC2 = "";
                }
                strArrVe[0] = strDecryptAESWithCBC2;
                strArrVe[1] = strDecryptAESWithCBC != null ? strDecryptAESWithCBC : "";
                return strArrVe;
            }
        }
        if (strDecryptAESWithCBC2 != null && System.currentTimeMillis() - j > 3600000) {
            strDecryptAESWithCBC2 = null;
        }
        str = (strDecryptAESWithCBC != null || System.currentTimeMillis() - j2 <= 3600000) ? strDecryptAESWithCBC : null;
        if (!TextUtils.isEmpty(strDecryptAESWithCBC2) && TextUtils.isEmpty(str)) {
            return ve(cVar, z2, i, veVar);
        }
        strArr[0] = strDecryptAESWithCBC2;
        strArr[1] = str;
        return strArr;
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00fe  */
    private static void c(Map<String, NetworkInterface> map, com.byazt.dna.c cVar) {
        int i;
        Iterator<Map.Entry<String, NetworkInterface>> it;
        String str;
        String hostAddress;
        cVar = cVar;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        JSONArray jSONArray = new JSONArray();
        Iterator<Map.Entry<String, NetworkInterface>> it2 = map.entrySet().iterator();
        String str2 = "";
        String strC = "";
        String strC2 = strC;
        String str3 = strC2;
        while (it2.hasNext()) {
            Map.Entry<String, NetworkInterface> next = it2.next();
            if (next != null) {
                String key = next.getKey();
                NetworkInterface value = next.getValue();
                if (value != null) {
                    try {
                        if (TextUtils.equals(key, "wlan0")) {
                            strC = c(value, cVar);
                        }
                        if (TextUtils.equals(key, "eth0")) {
                            strC2 = c(value, cVar);
                        }
                    } catch (Throwable unused) {
                    }
                    List<InetAddress> listC = c(value);
                    if (listC != null) {
                        for (InetAddress inetAddress : listC) {
                            String hostAddress2 = inetAddress.getHostAddress();
                            if (TextUtils.equals(key, "wlan0") && (inetAddress instanceof Inet6Address) && inetAddress.isLinkLocalAddress() && (hostAddress = inetAddress.getHostAddress()) != null && hostAddress.startsWith("fe80")) {
                                str3 = hostAddress;
                            }
                            if (TextUtils.isEmpty(hostAddress2)) {
                                it = it2;
                                str = str2;
                            } else if (hostAddress2.indexOf(58) < 0) {
                                it = it2;
                                str = str2;
                            } else {
                                int iIndexOf = hostAddress2.indexOf(37);
                                try {
                                    it = it2;
                                    if ("dummy0".equals(key)) {
                                        try {
                                            JSONObject jSONObject = new JSONObject();
                                            str = str2;
                                            try {
                                                jSONObject.put("type", "client_tun");
                                                jSONObject.put("value", iIndexOf < 0 ? hostAddress2.toUpperCase() : hostAddress2.substring(0, iIndexOf).toUpperCase());
                                                jSONArray.put(jSONObject);
                                            } catch (JSONException unused2) {
                                            }
                                        } catch (JSONException unused3) {
                                            str = str2;
                                        }
                                    } else {
                                        str = str2;
                                        if ("wlan0".equals(key)) {
                                            JSONObject jSONObject2 = new JSONObject();
                                            jSONObject2.put("type", "client_anpi");
                                            jSONObject2.put("value", iIndexOf < 0 ? hostAddress2.toUpperCase() : hostAddress2.substring(0, iIndexOf).toUpperCase());
                                            jSONArray.put(jSONObject2);
                                        }
                                    }
                                } catch (JSONException unused4) {
                                    it = it2;
                                }
                            }
                            if (!inetAddress.isLoopbackAddress() && !inetAddress.isLinkLocalAddress() && !TextUtils.isEmpty(hostAddress2)) {
                                if (inetAddress instanceof Inet6Address) {
                                    sb.append(hostAddress2);
                                    sb.append(",");
                                } else if (inetAddress instanceof Inet4Address) {
                                    sb2.append(hostAddress2);
                                    sb2.append(",");
                                }
                            }
                            it2 = it;
                            str2 = str;
                        }
                    }
                }
            }
            it2 = it2;
            str2 = str2;
        }
        String str4 = str2;
        if (TextUtils.isEmpty(sb)) {
            i = 1;
        } else {
            i = 1;
            sb = sb.delete(sb.length() - 1, sb.length());
        }
        if (!TextUtils.isEmpty(sb2)) {
            sb2 = sb2.delete(sb2.length() - i, sb2.length());
        }
        Map<String, String> map2 = tt;
        map2.put("enc_ipv4", sb2.toString());
        map2.put("enc_ipv6", sb.toString());
        map2.put("register_ipv6", jSONArray.toString());
        if (!TextUtils.isEmpty(strC)) {
            map2.put("mac", strC);
        } else {
            map2.put("mac", strC2);
        }
        map2.put("zaid_ipv6", TextUtils.isEmpty(str3) ? str4 : str3);
    }

    private static String c(NetworkInterface networkInterface, com.byazt.dna.c cVar) throws SocketException {
        com.byazt.lz.c customController = cVar.getCustomController();
        if (customController != null && !customController.isCanUseWifiState()) {
            return customController.getMacAddress();
        }
        byte[] hardwareAddress = networkInterface.getHardwareAddress();
        if (hardwareAddress == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : hardwareAddress) {
            sb.append(String.format("%02X:", Byte.valueOf(b)));
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private static void c(Map<String, NetworkInterface> map, com.byazt.dna.c cVar, int i) {
        String[] strArr = {"", ""};
        Iterator<Map.Entry<String, NetworkInterface>> it = map.entrySet().iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            NetworkInterface value = it.next().getValue();
            if (value != null) {
                for (InetAddress inetAddress : c(value)) {
                    boolean z3 = inetAddress instanceof Inet4Address;
                    if (!z3 || !z) {
                        if (z3 || !z2) {
                            if (c(z3, inetAddress, strArr)) {
                                if (!TextUtils.isEmpty(strArr[0]) && !TextUtils.isEmpty(strArr[1])) {
                                    Map<String, String> map2 = tt;
                                    map2.put("local_ipv4", strArr[0]);
                                    map2.put("local_ipv6", strArr[1]);
                                    return;
                                }
                            } else {
                                String hostAddress = inetAddress.getHostAddress();
                                if (!TextUtils.isEmpty(hostAddress) && !hostAddress.startsWith("127")) {
                                    if (z3) {
                                        x.c(((com.byazt.dna.n) com.byazt.ut.uj.getService("armor_service")).encryptAESWithCBC(hostAddress), cVar, i);
                                        strArr[0] = hostAddress;
                                        c cVar2 = n;
                                        if (cVar2 != null) {
                                            cVar2.c(hostAddress);
                                        }
                                        if (z2) {
                                            Map<String, String> map3 = tt;
                                            map3.put("local_ipv4", hostAddress);
                                            map3.put("local_ipv6", strArr[1]);
                                            return;
                                        }
                                        z = true;
                                    } else {
                                        int iIndexOf = hostAddress.indexOf(37);
                                        if (iIndexOf >= 0) {
                                            hostAddress = hostAddress.substring(0, iIndexOf);
                                        }
                                        if (c(hostAddress)) {
                                            x.tt(((com.byazt.dna.n) com.byazt.ut.uj.getService("armor_service")).encryptAESWithCBC(hostAddress), cVar, i);
                                            strArr[1] = hostAddress;
                                            c cVar3 = n;
                                            if (cVar3 != null) {
                                                cVar3.tt(hostAddress);
                                            }
                                            if (z) {
                                                Map<String, String> map4 = tt;
                                                map4.put("local_ipv4", strArr[0]);
                                                map4.put("local_ipv6", hostAddress);
                                                return;
                                            }
                                            z2 = true;
                                        } else {
                                            continue;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static List<InetAddress> c(NetworkInterface networkInterface) {
        if (networkInterface == null) {
            return Collections.emptyList();
        }
        try {
            Object objC = n.c(networkInterface, "java.net.NetworkInterface", "addrs", null);
            if (!(objC instanceof InetAddress[])) {
                return Collections.list(networkInterface.getInetAddresses());
            }
            return Arrays.asList((InetAddress[]) objC);
        } catch (Throwable unused) {
            return Collections.list(networkInterface.getInetAddresses());
        }
    }

    private static boolean c(boolean z, InetAddress inetAddress, String[] strArr) {
        Field declaredField;
        if (z) {
            try {
                if (!TextUtils.isEmpty(strArr[0])) {
                    return true;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        if (!z && !TextUtils.isEmpty(strArr[1])) {
            return true;
        }
        if (z) {
            declaredField = InetAddress.class.getDeclaredField("holder");
        } else {
            declaredField = Inet6Address.class.getDeclaredField("holder6");
        }
        declaredField.setAccessible(true);
        Object obj = declaredField.get(inetAddress);
        Class<?> cls = obj.getClass();
        if (z) {
            Field declaredField2 = cls.getDeclaredField("address");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            int iIntValue = obj2 instanceof Integer ? ((Integer) obj2).intValue() : 0;
            byte[] bArr = {(byte) ((iIntValue >>> 24) & 255), (byte) ((iIntValue >>> 16) & 255), (byte) ((iIntValue >>> 8) & 255), (byte) (iIntValue & 255)};
            String strTt = tt(bArr);
            if (bArr[0] != 127) {
                strArr[0] = strTt;
            }
        } else {
            Field declaredField3 = cls.getDeclaredField("ipaddress");
            declaredField3.setAccessible(true);
            Object obj3 = declaredField3.get(obj);
            if (obj3 instanceof byte[]) {
                String strC = c((byte[]) obj3);
                if (!c(strC)) {
                    return true;
                }
                strArr[1] = strC;
            }
        }
        return true;
    }

    private static String c(byte[] bArr) {
        StringBuilder sb = new StringBuilder(39);
        for (int i = 0; i < 8; i++) {
            int i2 = i << 1;
            sb.append(Integer.toHexString(((bArr[i2] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (bArr[i2 + 1] & 255)));
            if (i < 7) {
                sb.append(u15.f19942b);
            }
        }
        return sb.toString();
    }

    private static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        char cCharAt = str.charAt(0);
        if ((cCharAt != '2' && cCharAt != '3' && cCharAt != '5') || str.length() < 2) {
            return false;
        }
        char cCharAt2 = str.charAt(1);
        if (cCharAt2 >= '0' && cCharAt2 <= '9') {
            return true;
        }
        if (cCharAt2 < 'a' || cCharAt2 > 'f') {
            return cCharAt2 >= 'A' && cCharAt2 <= 'F';
        }
        return true;
    }

    public static boolean c(com.byazt.dna.c cVar, boolean z, com.byazt.lz.ve veVar) {
        if (!c(veVar)) {
            return false;
        }
        if (!z) {
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(cVar.getData());
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && !jSONObjectOptJSONObject.isNull("name") && "tt_inner_isw".equals(jSONObjectOptJSONObject.optString("name"))) {
                    return jSONObjectOptJSONObject.optBoolean("value", true);
                }
            }
        } catch (JSONException unused) {
        }
        return true;
    }

    public static boolean c(com.byazt.lz.ve veVar) {
        if (!TextUtils.isEmpty(f28330a)) {
            return !TextUtils.equals("0", f28330a);
        }
        Map<String, Object> mapSp = veVar.sp();
        if (mapSp != null) {
            Object obj = mapSp.get("uip");
            if (obj instanceof String) {
                String str = (String) obj;
                f28330a = str;
                return !TextUtils.equals("0", str);
            }
        }
        f28330a = "1";
        return true;
    }
}

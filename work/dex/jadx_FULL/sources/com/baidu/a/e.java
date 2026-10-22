package com.baidu.a;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile e f26243a;

    private e() {
    }

    public static e a() {
        if (f26243a == null) {
            synchronized (e.class) {
                if (f26243a == null) {
                    f26243a = new e();
                }
            }
        }
        return f26243a;
    }

    private Map<String, ArrayList> b(String str) {
        try {
            InetAddress[] allByName = InetAddress.getAllByName(str);
            if (allByName == null || allByName.length == 0) {
                j.a("Dns resolve failed, host(%s), get empty resolve result", str);
                return null;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            HashMap map = new HashMap();
            for (InetAddress inetAddress : allByName) {
                if (inetAddress instanceof Inet4Address) {
                    String hostAddress = inetAddress.getHostAddress();
                    if (d.a(hostAddress)) {
                        arrayList.add(hostAddress);
                    }
                } else if (inetAddress instanceof Inet6Address) {
                    String hostAddress2 = inetAddress.getHostAddress();
                    if (d.b(hostAddress2)) {
                        arrayList2.add(hostAddress2);
                    }
                }
            }
            map.put("ipv4", arrayList);
            map.put("ipv6", arrayList2);
            if (arrayList.isEmpty() && arrayList2.isEmpty()) {
                j.a("Dns resolve failed, host(%s), get no valid resolve result", str);
                return null;
            }
            j.a("Dns resolve successful, host(%s), ipv4List(%s), ipv6List(%s)", str, arrayList.toString(), arrayList2.toString());
            return map;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            j.a("Dns resolve failed, host(%s), caught UnknownHostException", str);
            return null;
        }
    }

    public b a(String str) {
        ArrayList arrayList;
        ArrayList arrayList2;
        Map<String, ArrayList> mapB = b(str);
        if (mapB != null) {
            arrayList = mapB.get("ipv4");
            arrayList2 = mapB.get("ipv6");
        } else {
            arrayList = null;
            arrayList2 = null;
        }
        return ((arrayList == null || arrayList.isEmpty()) && (arrayList2 == null || arrayList2.isEmpty())) ? new b(b.a.BDHttpDnsResolveErrorDnsResolve) : new b(b.EnumC0255b.RESOLVE_FROM_DNS, b.a.BDHttpDnsResolveOK, arrayList, arrayList2);
    }
}

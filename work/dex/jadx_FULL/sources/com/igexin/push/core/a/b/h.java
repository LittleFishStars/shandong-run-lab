package com.igexin.push.core.a.b;

import com.igexin.push.config.SDKUrlConfig;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class h extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f37933a = com.igexin.push.config.c.f37909a + "_RedirectServerAction";

    private static void a(String str, JSONArray jSONArray) {
        try {
            com.igexin.c.a.c.a.a(f37933a + "|start fetch idc config, url : " + str, new Object[0]);
            com.igexin.c.a.b.e.a().a((com.igexin.c.a.d.f) new com.igexin.push.f.a.f(new com.igexin.push.core.h.c(str, jSONArray)), false, true);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(f37933a + e.toString(), new Object[0]);
        }
    }

    private static void a(JSONObject jSONObject) {
        long jOptLong = jSONObject.optLong("delay");
        if (jOptLong >= 0) {
            com.igexin.push.core.e.b(jOptLong);
        }
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("address_list");
        com.igexin.c.a.c.a.a("redirect|" + jOptLong + "|" + jSONArrayOptJSONArray.toString(), new Object[0]);
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            String strOptString = jSONArrayOptJSONArray.optString(i);
            int iIndexOf = strOptString.indexOf(44);
            if (iIndexOf > 0) {
                String strSubstring = strOptString.substring(0, iIndexOf);
                String strSubstring2 = strOptString.substring(iIndexOf + 1);
                long jCurrentTimeMillis = System.currentTimeMillis();
                try {
                    long j = Long.parseLong(strSubstring2);
                    com.igexin.push.c.a.b bVar = new com.igexin.push.c.a.b();
                    bVar.f37885a = "socket://".concat(String.valueOf(strSubstring));
                    bVar.b = jCurrentTimeMillis + (j * 1000);
                    arrayList.add(bVar);
                } catch (NumberFormatException e) {
                    com.igexin.c.a.c.a.a(e);
                }
            }
        }
        com.igexin.push.c.c.a().d().a(arrayList);
    }

    public static String[] a(JSONArray jSONArray) {
        String[] strArr = null;
        try {
            strArr = new String[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                strArr[i] = "https://" + jSONArray.getString(i);
            }
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(f37933a + "|parseIDCConfigURL exception" + e.toString(), new Object[0]);
        }
        return strArr;
    }

    private static void b(JSONObject jSONObject) {
        if (jSONObject.has("loc") && jSONObject.has("conf")) {
            try {
                SDKUrlConfig.setLocation(jSONObject.getString("loc"));
                String str = com.igexin.push.core.e.f;
                StringBuilder sb = new StringBuilder();
                String str2 = f37933a;
                sb.append(str2);
                sb.append(" set group id : ");
                sb.append(com.igexin.push.core.e.f);
                com.igexin.c.a.c.a.a(sb.toString(), new Object[0]);
                JSONArray jSONArray = jSONObject.getJSONArray("conf");
                String[] strArrA = a(jSONArray);
                if (strArrA == null || strArrA.length <= 1) {
                    return;
                }
                String[] idcConfigUrl = SDKUrlConfig.getIdcConfigUrl();
                if (idcConfigUrl != null && (idcConfigUrl.length <= 1 || strArrA[1].equals(idcConfigUrl[1]))) {
                    com.igexin.c.a.c.a.a(str2 + "|current idc config url == new idc config url, return", new Object[0]);
                    return;
                }
                if (com.igexin.push.core.e.ao == 0) {
                    a(strArrA[1], jSONArray);
                    return;
                }
                if (System.currentTimeMillis() - com.igexin.push.core.e.ao > com.heytap.mcssdk.constant.a.n) {
                    a(strArrA[1], jSONArray);
                    return;
                }
                com.igexin.c.a.c.a.a(str2 + "|get idc cfg last time less than 2 hours return", new Object[0]);
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(f37933a + e.toString(), new Object[0]);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00ed A[Catch: Exception -> 0x010a, TRY_LEAVE, TryCatch #1 {Exception -> 0x010a, blocks: (B:3:0x0022, B:5:0x0032, B:29:0x00cd, B:30:0x00e7, B:32:0x00ed, B:7:0x0038, B:9:0x0066, B:11:0x0069, B:13:0x006f, B:15:0x0072, B:18:0x007d, B:19:0x0095, B:21:0x009d, B:22:0x009f, B:23:0x00a3, B:25:0x00b1, B:26:0x00b4), top: B:38:0x0022, inners: #0 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:32:0x00ed, please report this as an issue */
    @Override // com.igexin.push.core.a.b.a
    public final boolean a(Object obj, JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        String str = f37933a;
        sb.append(str);
        sb.append("|redirect server resp data : ");
        sb.append(jSONObject);
        com.igexin.c.a.c.a.a(sb.toString(), new Object[0]);
        try {
            a(jSONObject);
            com.igexin.c.a.b.a.a.d.a().g();
            if (jSONObject.has("loc") && jSONObject.has("conf")) {
                try {
                    SDKUrlConfig.setLocation(jSONObject.getString("loc"));
                    String str2 = com.igexin.push.core.e.f;
                    com.igexin.c.a.c.a.a(str + " set group id : " + com.igexin.push.core.e.f, new Object[0]);
                    JSONArray jSONArray = jSONObject.getJSONArray("conf");
                    String[] strArrA = a(jSONArray);
                    if (strArrA != null && strArrA.length > 1) {
                        String[] idcConfigUrl = SDKUrlConfig.getIdcConfigUrl();
                        if (idcConfigUrl != null && (idcConfigUrl.length <= 1 || strArrA[1].equals(idcConfigUrl[1]))) {
                            com.igexin.c.a.c.a.a(str + "|current idc config url == new idc config url, return", new Object[0]);
                        } else if (com.igexin.push.core.e.ao != 0 && System.currentTimeMillis() - com.igexin.push.core.e.ao <= com.heytap.mcssdk.constant.a.n) {
                            com.igexin.c.a.c.a.a(str + "|get idc cfg last time less than 2 hours return", new Object[0]);
                        } else {
                            String str3 = strArrA[1];
                            a(str3, jSONArray);
                        }
                    }
                } catch (Exception e) {
                    com.igexin.c.a.c.a.a(f37933a + e.toString(), new Object[0]);
                }
                if (com.igexin.push.g.g.a()) {
                    com.igexin.c.a.c.a.a(f37933a + "|redirect reInit so ~~~~~", new Object[0]);
                    com.igexin.push.g.g.d();
                }
            } else if (com.igexin.push.g.g.a()) {
                com.igexin.c.a.c.a.a(f37933a + "|redirect reInit so ~~~~~", new Object[0]);
                com.igexin.push.g.g.d();
            }
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(f37933a + e2.toString(), new Object[0]);
        }
        return true;
    }
}

package com.byazt.ke;

import android.text.TextUtils;
import android.util.Base64;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.byazt.gs.a;
import com.byazt.ml.ve;
import com.byazt.vb.n;
import com.byazt.vb.uj;
import com.byazt.vb.x;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 723, 20})
public class c implements com.byazt.gs.c<com.byazt.vb.tt> {
    public static final SimpleDateFormat tt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    public n uj;
    public final String ve = "x-pglcypher";
    public final boolean c = tt();

    private boolean a(JSONObject jSONObject) {
        return jSONObject != null && jSONObject.length() > 0;
    }

    private int n(JSONObject jSONObject) {
        int iIndexOf;
        if (jSONObject == null) {
            return 0;
        }
        try {
            String strOptString = jSONObject.optString("s_sig_ts");
            if (strOptString == null || (iIndexOf = strOptString.indexOf(LoginConstants.UNDER_LINE)) < 5) {
                return 512;
            }
            String strSubstring = strOptString.substring(0, iIndexOf);
            String strSubstring2 = strOptString.substring(iIndexOf + 1);
            JSONObject jSONObjectI = c().uj().t().i();
            if (c((jSONObjectI != null ? jSONObjectI.optString("device_id") : "") + LoginConstants.UNDER_LINE + strSubstring, strSubstring2)) {
                return Math.abs((System.currentTimeMillis() / 1000) - Long.valueOf(strSubstring).longValue()) > 300 ? 513 : 0;
            }
            return 512;
        } catch (Throwable unused) {
            return 512;
        }
    }

    private String tt(int i) {
        return i >= 4 ? OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE : "application/octet-stream;tt-data=a";
    }

    public static byte[] tt(JSONObject jSONObject) {
        return jSONObject == null ? new byte[0] : jSONObject.toString().getBytes(StandardCharsets.UTF_8);
    }

    private Map<String, String> uj(JSONObject jSONObject) {
        HashMap map = new HashMap();
        map.put("Content-Type", "application/json; charset=utf-8");
        if (a(jSONObject)) {
            map.put("Content-Encoding", "union_sdk_encode");
        }
        return map;
    }

    public boolean ve(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            return jSONObject.optString("message").equalsIgnoreCase("success");
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public n c() {
        if (this.uj == null) {
            this.uj = com.byazt.epi.c.tt("csj").tt();
        }
        return this.uj;
    }

    private static boolean tt() {
        try {
            return new File("/system/bin/su").exists() || new File("/system/xbin/su").exists();
        } catch (Exception unused) {
            return false;
        }
    }

    private static PublicKey ve() throws Exception {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode("MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKtjHB7PDkflFl5bX4x/25mE9x2/C6kd\n8wVgzXFiC67Jx+meptu1hL54XgnPnI+AvxXhEgN/+DZUmrRPdvB+UZECAwEAAQ==".getBytes(Charset.forName("UTF-8")), 2)));
    }

    public List<com.byazt.vb.tt> tt(List<com.byazt.vb.tt> list) {
        ArrayList arrayList = new ArrayList();
        for (com.byazt.vb.tt ttVar : list) {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObjectSp = ttVar.sp();
                String strOptString = jSONObjectSp.optString("label");
                if (TextUtils.isEmpty(strOptString)) {
                    strOptString = jSONObjectSp.optString("event");
                }
                jSONObject.putOpt("event", strOptString);
                long jOptLong = jSONObjectSp.optLong("event_ts", System.currentTimeMillis());
                jSONObject.putOpt("local_time_ms", Long.valueOf(jOptLong));
                jSONObject.putOpt("datetime", tt.format(new Date(jOptLong)));
                JSONObject jSONObject2 = new JSONObject();
                if (jSONObjectSp.has("params") && jSONObjectSp.has("event")) {
                    jSONObject2 = jSONObjectSp.optJSONObject("params");
                } else {
                    Iterator<String> itKeys = jSONObjectSp.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        if (!TextUtils.equals(next, "label")) {
                            jSONObject2.putOpt(next, jSONObjectSp.opt(next));
                        }
                    }
                }
                jSONObject.putOpt("params", jSONObject2);
                com.byazt.fo.c cVar = new com.byazt.fo.c(ttVar.ve(), jSONObject);
                cVar.c(ttVar.uj());
                cVar.tt(ttVar.n());
                arrayList.add(cVar);
            } catch (Exception e) {
                ve.ve(e.getMessage(), c());
            }
        }
        return arrayList;
    }

    @Override // com.byazt.gs.c
    public com.byazt.lph.tt c(List<com.byazt.vb.tt> list) {
        x xVarT;
        com.byazt.lph.tt ttVarC;
        String strA;
        uj ujVarUj = c().uj();
        if (ujVarUj != null) {
            try {
                if (ujVarUj.uj() && (xVarT = ujVarUj.t()) != null && list != null && !list.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    String str = "1streqid";
                    String strA2 = "2ndreqid";
                    String str2 = "";
                    boolean z = false;
                    for (com.byazt.vb.tt ttVar : list) {
                        try {
                            if (TextUtils.equals("show", com.byazt.ml.c.c(ttVar, c()))) {
                                String strC = com.byazt.ml.c.c(ttVar.sp(), this.uj);
                                if (!z) {
                                    strA = com.byazt.ml.c.a(ttVar, this.uj);
                                } else {
                                    strA2 = com.byazt.ml.c.a(ttVar, this.uj);
                                    strA = strA2;
                                }
                                str2 = strC;
                                str = strA;
                                z = true;
                            }
                            arrayList.add(ttVar);
                        } catch (Throwable th) {
                            th = th;
                            ve.ve("NetApiImpl", "uploadEvent error" + th.getMessage(), c());
                            return new com.byazt.lph.tt(false, 509, th.getMessage(), false, "error");
                        }
                    }
                    int iDa = xVarT.da();
                    if (arrayList.isEmpty()) {
                        return null;
                    }
                    JSONObject jSONObjectC = xVarT.c(tt(arrayList), this.c);
                    byte[] bArrC = xVarT.c(jSONObjectC, iDa);
                    if (bArrC == null) {
                        JSONObject jSONObjectC2 = xVarT.c(jSONObjectC);
                        bArrC = tt(jSONObjectC2);
                        ttVarC = c(bArrC, uj(jSONObjectC2), "application/json; charset=utf-8");
                    } else {
                        ttVarC = c(bArrC, c(iDa), tt(iDa));
                    }
                    if (z) {
                        int length = bArrC != null ? bArrC.length : 0;
                        if (ttVarC != null) {
                            com.byazt.ml.c.c(ttVarC.c, ttVarC.tt, ttVarC.ve, str + "|" + strA2, length, str2);
                        }
                    }
                    return ttVarC;
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return null;
    }

    private void tt(byte[] bArr, Map<String, String> map, String str) {
        n nVarC;
        uj ujVarUj;
        x xVarT;
        if (bArr == null || bArr.length == 0 || (nVarC = c()) == null || (ujVarUj = nVarC.uj()) == null || (xVarT = ujVarUj.t()) == null || !xVarT.c()) {
            return;
        }
        a aVarN = xVarT.n();
        aVarN.c(xVarT.tt());
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                aVarN.c(entry.getKey(), entry.getValue());
            }
        }
        aVarN.c(str, bArr);
        aVarN.c("User-Agent", ujVarUj.n());
        aVarN.c(new com.byazt.gs.ve() { // from class: com.byazt.ke.c.1
            @Override // com.byazt.gs.ve
            public void c(com.byazt.gs.uj ujVar, com.byazt.gs.n nVar) {
                if (nVar == null || !nVar.c()) {
                    c.this.c();
                } else {
                    nVar.tt();
                    c.this.c();
                }
            }

            @Override // com.byazt.gs.ve
            public void c(com.byazt.gs.uj ujVar, IOException iOException) {
                iOException.getMessage();
                c.this.c();
            }
        });
    }

    private Map<String, String> c(int i) {
        HashMap map = new HashMap();
        if (i >= 4) {
            map.put("Content-Encoding", "union_sdk_encode");
            map.put("x-pglcypher", String.valueOf(i));
        }
        map.put("Content-Type", tt(i));
        return map;
    }

    private com.byazt.lph.tt c(byte[] bArr, Map<String, String> map, String str) {
        int iN;
        boolean zVe;
        boolean z;
        int i;
        boolean z2;
        String str2;
        try {
            uj ujVarUj = c().uj();
            x xVarT = ujVarUj.t();
            a aVarN = xVarT.n();
            aVarN.c(xVarT.a());
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    aVarN.c(entry.getKey(), entry.getValue());
                }
            }
            aVarN.c(str, bArr);
            aVarN.c("User-Agent", ujVarUj.n());
            com.byazt.gs.n nVarC = aVarN.c();
            if (nVarC == null) {
                return new com.byazt.lph.tt(false, 510, "RSP IS NULL", false, "error");
            }
            if (!nVarC.c() || TextUtils.isEmpty(nVarC.tt())) {
                iN = 0;
                zVe = false;
            } else {
                JSONObject jSONObject = new JSONObject(nVarC.tt());
                zVe = ve(jSONObject);
                iN = n(jSONObject);
            }
            int iVe = nVarC.ve();
            String str3 = nVarC.n() != null ? nVarC.n().get("x-tt-logid") : "error";
            boolean z3 = !zVe && iVe == 200;
            String strUj = nVarC.uj();
            if (strUj == null || TextUtils.isEmpty(strUj)) {
                strUj = "DEFAULT OK";
            }
            if (iN != 0) {
                str2 = "RSP FAIL";
                z2 = true;
                i = iN;
                z = false;
            } else {
                z = zVe;
                i = iVe;
                z2 = z3;
                str2 = strUj;
            }
            tt(bArr, map, str);
            return new com.byazt.lph.tt(z, i, str2, z2, str3);
        } catch (Throwable th) {
            ve.ve("NetApiImpl", "uploadEvent error" + th.getMessage(), c());
            return new com.byazt.lph.tt(false, 511, th.getMessage(), false, "error");
        }
    }

    private boolean c(String str, String str2) throws Exception {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(ve().getEncoded()));
        Signature signature = Signature.getInstance("Sha1withRSA");
        signature.initVerify(publicKeyGeneratePublic);
        signature.update(str.getBytes());
        return signature.verify(Base64.decode(str2.getBytes(Charset.forName("UTF-8")), 2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.byazt.gs.c
    public com.byazt.lph.tt c(JSONObject jSONObject) {
        x xVarT;
        int i;
        boolean z;
        String str;
        boolean z2;
        int i2;
        int i3;
        uj ujVarUj = c().uj();
        if (ujVarUj == null || !ujVarUj.uj() || jSONObject == null || jSONObject.length() <= 0 || (xVarT = ujVarUj.t()) == null) {
            return null;
        }
        a aVarN = xVarT.n();
        aVarN.c(xVarT.sp());
        int iDa = xVarT.da();
        byte[] bArrTt = xVarT.tt(jSONObject, iDa);
        if (bArrTt == null) {
            aVarN.tt(xVarT.c(jSONObject).toString());
        } else {
            aVarN.c(tt(iDa), bArrTt);
            aVarN.c("x-pglcypher", String.valueOf(iDa));
        }
        aVarN.c("User-Agent", ujVarUj.n());
        String strUj = "error unknown";
        int iVe = 0;
        try {
            com.byazt.gs.n nVarC = aVarN.c();
            if (nVarC == null) {
                return new com.byazt.lph.tt(false, 0, "error unknown", false, "ignore");
            }
            if (!nVarC.c() || TextUtils.isEmpty(nVarC.tt())) {
                i3 = 0;
                z = false;
            } else {
                JSONObject jSONObject2 = new JSONObject(nVarC.tt());
                int iOptInt = jSONObject2.optInt("code", -1);
                strUj = jSONObject2.optString("data", "");
                z = true;
                i3 = iOptInt == 20000 ? 1 : 0;
                if (iOptInt != 60005) {
                    z = false;
                }
            }
            try {
                iVe = nVarC.ve();
                if (!nVarC.c()) {
                    strUj = nVarC.uj();
                }
                str = strUj;
                i2 = iVe;
                z2 = i3;
            } catch (Throwable unused) {
                i = iVe;
                iVe = i3;
                str = strUj;
                z2 = iVe;
                i2 = i;
            }
            return new com.byazt.lph.tt(z2, i2, str, z, "ignore");
        } catch (Throwable unused2) {
            i = 0;
            z = false;
        }
    }
}

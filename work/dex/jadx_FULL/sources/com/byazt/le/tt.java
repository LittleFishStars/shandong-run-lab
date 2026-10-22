package com.byazt.le;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.byazt.aas.my;
import com.byazt.dna.n;
import com.byazt.dna.u;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import com.byazt.ut.uj;
import com.byazt.vx.eo;
import com.byazt.vx.rl;
import com.byazt.vx.ve;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1581, 13})
public class tt implements c<com.byazt.ng.c> {
    public static final byte[] c = new byte[0];

    private byte[] tt(List<com.byazt.ng.c> list) throws Throwable {
        GZIPOutputStream gZIPOutputStream = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONObject jSONObjectVe = ve(list);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        try {
            try {
                try {
                    GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream2.write(jSONObjectVe.toString().getBytes());
                        gZIPOutputStream2.close();
                    } catch (Exception e) {
                        e = e;
                        gZIPOutputStream = gZIPOutputStream2;
                        m.c(e);
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        return byteArrayOutputStream.toByteArray();
                    } catch (Throwable th) {
                        th = th;
                        gZIPOutputStream = gZIPOutputStream2;
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (IOException e2) {
                                m.c(e2);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    m.c(e3);
                }
            } catch (Exception e4) {
                e = e4;
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private byte[] uj(List<com.byazt.ng.c> list) {
        try {
            return c(ve.c(ve(list)).toString());
        } catch (Throwable th) {
            m.c(th);
            return null;
        }
    }

    private JSONObject ve(List<com.byazt.ng.c> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_user_agent", ((u) uj.getService("device_info_new")).getUserAgent());
            jSONObject.put("client_ip", my.c());
            jSONObject.put("header", rl.tt());
            JSONArray jSONArray = new JSONArray();
            Iterator<com.byazt.ng.c> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().tt);
            }
            jSONObject.put("event_v3", jSONArray);
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("_gen_time", System.currentTimeMillis());
        } catch (JSONException e) {
            m.c(e);
        }
        return jSONObject;
    }

    @Override // com.byazt.le.c
    public boolean c() {
        n nVarA = eo.a();
        return (com.byazt.bp.tt.tt().uj() || nVarA == null || !nVarA.getArmorLoadStatus()) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x007c  */
    private com.byazt.ng.n c(String str, byte[] bArr, boolean z) {
        String str2;
        boolean z2;
        String str3;
        com.byazt.va.n nVarTt = com.byazt.yp.tt.c().tt().tt();
        nVarTt.c(str);
        String strX = com.byazt.bp.c.t().x();
        if (!TextUtils.isEmpty(strX)) {
            nVarTt.tt("X-Tt-Env", strX);
            nVarTt.tt("x-use-ppe", "1");
        }
        if (z) {
            nVarTt.tt("x-pglcypher", "4");
            nVarTt.tt("Content-Encoding", "union_sdk_encode");
            str2 = OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE;
        } else {
            str2 = "application/octet-stream;tt-data=a";
        }
        nVarTt.tt("User-Agent", com.byazt.yl.tt.c);
        nVarTt.c(str2, bArr);
        com.byazt.hm.tt ttVarC = nVarTt.c();
        boolean z3 = true;
        if (ttVarC != null) {
            try {
                if (c(new JSONObject(ttVarC.n()))) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } catch (JSONException e) {
                com.byazt.eu.tt.uj("uploadEvent", "ignore:" + e.toString());
                m.c(e);
            }
        } else {
            z2 = false;
        }
        int iTt = ttVarC != null ? ttVarC.tt() : 0;
        if (z2 || iTt != 200) {
            if (ttVarC != null) {
                String strVe = ttVarC.ve();
                if (z2) {
                    str3 = strVe;
                } else {
                    str3 = strVe + "::" + ttVarC.n();
                }
            } else {
                str3 = "error unknown";
            }
            z3 = false;
        } else {
            str3 = "server say not success";
        }
        return new com.byazt.ng.n(z2, iTt, str3, z3);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0070  */
    private com.byazt.ng.n c(String str, byte[] bArr) {
        boolean z;
        String str2;
        com.byazt.va.n nVarTt = com.byazt.yp.tt.c().tt().tt();
        nVarTt.c(str);
        String strX = com.byazt.bp.c.t().x();
        if (!TextUtils.isEmpty(strX)) {
            nVarTt.tt("X-Tt-Env", strX);
            nVarTt.tt("x-use-ppe", "1");
        }
        nVarTt.tt("User-Agent", com.byazt.yl.tt.c);
        nVarTt.tt("Content-Encoding", "union_sdk_encode");
        nVarTt.c("application/json; charset=utf-8", bArr);
        com.byazt.hm.tt ttVarC = nVarTt.c();
        boolean z2 = true;
        if (ttVarC != null) {
            try {
                if (c(new JSONObject(ttVarC.n()))) {
                    z = true;
                } else {
                    z = false;
                }
            } catch (JSONException e) {
                com.byazt.eu.tt.uj("uploadEvent", "ignore:" + e.toString());
                m.c(e);
            }
        } else {
            z = false;
        }
        int iTt = ttVarC != null ? ttVarC.tt() : 0;
        if (z || iTt != 200) {
            if (ttVarC != null) {
                String strVe = ttVarC.ve();
                if (z) {
                    str2 = strVe;
                } else {
                    str2 = strVe + "::" + ttVarC.n();
                }
            } else {
                str2 = "error unknown";
            }
            z2 = false;
        } else {
            str2 = "server say not success";
        }
        return new com.byazt.ng.n(z, iTt, str2, z2);
    }

    @Override // com.byazt.le.c
    public com.byazt.ng.n c(List<com.byazt.ng.c> list) {
        if (list == null) {
            return null;
        }
        try {
            if (list.isEmpty()) {
                return null;
            }
            com.byazt.eu.tt.tt(MediationConstant.TAG, "--==-- v3: " + list.size());
            boolean zC = c();
            byte[] bArrC = c(list, zC);
            if (bArrC != null && bArrC.length > 0) {
                return c(com.byazt.bp.ve.tt(), bArrC, zC);
            }
            return c(com.byazt.bp.ve.tt(), gt.tt().jf() == 1 ? c : uj(list));
        } catch (Throwable th) {
            com.byazt.eu.tt.uj("ReportNetApiImpl", "uploadEvent error:");
            m.c(th);
            return new com.byazt.ng.n(false, 509, "service_busy", false);
        }
    }

    private byte[] c(List<com.byazt.ng.c> list, boolean z) throws Throwable {
        byte[] bArrTt = tt(list);
        n nVarA = eo.a();
        if (bArrTt == null) {
            return null;
        }
        if (z) {
            return nVarA.encrypt(bArrTt);
        }
        return c(bArrTt, bArrTt.length);
    }

    private byte[] c(String str) {
        try {
            return str == null ? new byte[0] : str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            return new byte[0];
        }
    }

    private byte[] c(byte[] bArr, int i) {
        if (bArr != null && i > 0) {
            try {
                if (bArr.length == i) {
                    return com.byazt.vx.u.c(bArr, i);
                }
            } catch (Throwable th) {
                m.c(th);
            }
        }
        return null;
    }

    private boolean c(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                return jSONObject.optInt("code") == 20000 || "success".equals(jSONObject.optString("message"));
            } catch (Throwable unused) {
            }
        }
        return false;
    }
}

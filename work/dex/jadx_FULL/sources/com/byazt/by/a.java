package com.byazt.by;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.byazt.aas.da;
import com.byazt.aas.gr;
import com.byazt.nr.m;
import com.byazt.nys.PluginConstants;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.byazt.ukr.yp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zj.adlib.bv9;
import com.zj.adlib.yg3;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FILEPLAY_NO_BUFFRING, 34})
public class a {
    public static volatile a c;

    private Pair<Integer, JSONObject> a(String str) {
        return gt.tt().jf() == 1 ? new Pair<>(3, new JSONObject()) : uj(str);
    }

    public static a c() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    private Pair<Integer, JSONObject> sp(String str) {
        com.byazt.dna.n nVarTt = gr.tt();
        if (TextUtils.isEmpty(str)) {
            return a(str);
        }
        JSONObject jSONObjectN = null;
        if (nVarTt != null) {
            jSONObjectN = nVarTt.getArmorLoadStatus() ? n(str) : null;
            if (jSONObjectN == null || TextUtils.isEmpty(jSONObjectN.optString("message"))) {
                yp.c().c(3, -1L, (String) null, nVarTt.getSpecificArmorLoadStatus());
                return a(str);
            }
        }
        return new Pair<>(4, jSONObjectN);
    }

    public JSONObject n(String str) {
        com.byazt.dna.n nVarTt = gr.tt();
        if (TextUtils.isEmpty(str) || nVarTt == null || !nVarTt.getArmorLoadStatus()) {
            return null;
        }
        try {
            byte[] bArrEncrypt = nVarTt.encrypt(str.getBytes(StandardCharsets.UTF_8));
            if (bArrEncrypt == null) {
                return null;
            }
            String strEncodeToString = Base64.encodeToString(bArrEncrypt, 0);
            if (TextUtils.isEmpty(strEncodeToString)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("message", strEncodeToString);
            jSONObject.put("cypher", 4);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public com.byazt.wo.tt tt(String str) {
        int iIntValue;
        JSONObject jSONObject = new JSONObject();
        com.byazt.wo.tt ttVar = new com.byazt.wo.tt();
        HashMap map = new HashMap();
        try {
            ttVar.c(str.length());
            Pair<Integer, JSONObject> pairC = c().c(str, false);
            if (pairC != null) {
                JSONObject jSONObject2 = (JSONObject) pairC.second;
                try {
                    Object obj = pairC.first;
                    iIntValue = obj != null ? ((Integer) obj).intValue() : 3;
                    jSONObject = jSONObject2;
                } catch (Throwable unused) {
                    jSONObject = jSONObject2;
                }
            } else {
                iIntValue = 3;
            }
            jSONObject.put("ad_sdk_version", p.n);
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.6.1.1");
            if (iIntValue != 3) {
                map.put("x-ad-sdk-version", p.n);
                map.put("x-plugin-version", "7.6.1.1");
                map.put("x-pglcypher", String.valueOf(iIntValue));
            }
        } catch (Throwable unused2) {
        }
        ttVar.c(map);
        ttVar.tt(jSONObject);
        return ttVar;
    }

    public Pair<Integer, JSONObject> uj(String str) {
        return new Pair<>(3, com.byazt.nr.c.c(str));
    }

    public Pair<Integer, ?> ve(String str) {
        try {
            if (!TextUtils.isEmpty(str) && gt.tt().di()) {
                return c(str, "get_ad");
            }
        } catch (Throwable th) {
            m.ve(th.getMessage());
        }
        return uj(str);
    }

    public com.byazt.wo.tt c(String str) {
        Object obj;
        com.byazt.wo.tt ttVar = new com.byazt.wo.tt();
        HashMap map = new HashMap();
        try {
            ttVar.c(str.length());
            Pair<Integer, ?> pairVe = c().ve(str);
            int iIntValue = 3;
            if (pairVe != null) {
                obj = pairVe.second;
                Object obj2 = pairVe.first;
                if (obj2 != null) {
                    iIntValue = ((Integer) obj2).intValue();
                }
            } else {
                obj = null;
            }
            if (iIntValue == 4) {
                map.put("x-ad-sdk-version", p.n);
                map.put("x-plugin-version", "7.6.1.1");
                map.put("x-pglcypher", String.valueOf(iIntValue));
                map.put("Content-Type", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
                ttVar.c((byte[]) obj);
                ttVar.c(map);
            } else {
                JSONObject jSONObject = (JSONObject) obj;
                jSONObject.put("ad_sdk_version", p.n);
                jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.6.1.1");
                ttVar.tt(jSONObject);
                ttVar.c(map);
            }
        } catch (Throwable unused) {
        }
        return ttVar;
    }

    private static String tt(byte[] bArr, String str) {
        com.byazt.dna.n nVarTt;
        if (bArr != null) {
            try {
                if (bArr.length == 0 || (nVarTt = gr.tt()) == null) {
                    return null;
                }
                byte[] bArrDecrypt = nVarTt.decrypt(bArr);
                String strTt = da.tt(bArrDecrypt);
                if (!TextUtils.isEmpty(strTt)) {
                    return strTt;
                }
                yp.c().c((bArrDecrypt == null || bArrDecrypt.length == 0) ? 1 : 2, -1L, str, nVarTt.getSpecificArmorLoadStatus());
                return null;
            } catch (Exception e) {
                m.c(e);
            }
        }
        return null;
    }

    public Pair<Integer, JSONObject> c(String str, boolean z) {
        try {
            if (gt.tt().di()) {
                return sp(str);
            }
        } catch (Throwable th) {
            m.ve(th.getMessage());
        }
        return uj(str);
    }

    public Pair<Integer, ?> c(String str, String str2) {
        com.byazt.dna.n nVarTt = gr.tt();
        if (TextUtils.isEmpty(str)) {
            return a(str);
        }
        byte[] bArrEncrypt = null;
        if (nVarTt != null) {
            bArrEncrypt = nVarTt.getArmorLoadStatus() ? nVarTt.encrypt(da.c(str.getBytes(StandardCharsets.UTF_8))) : null;
            if (bArrEncrypt == null || bArrEncrypt.length == 0) {
                yp.c().c(3, -1L, str2, nVarTt.getSpecificArmorLoadStatus());
                if (yg3.SOURCE_TYPE_SETTINGS.equals(str2)) {
                    return uj(str);
                }
                return a(str);
            }
        }
        return new Pair<>(4, bArrEncrypt);
    }

    public static Pair<Boolean, JSONObject> c(com.byazt.hm.tt ttVar, String str, boolean z) {
        if (com.byazt.lf.c.c(ttVar.uj())) {
            return new Pair<>(Boolean.FALSE, c(ttVar.sl(), str));
        }
        String strN = ttVar.n();
        if (strN != null && !strN.startsWith(bv9.b) && !strN.endsWith("}") && !strN.contains("message") && !strN.contains("cypher")) {
            return new Pair<>(Boolean.FALSE, c(ttVar.sl(), str));
        }
        JSONObject jSONObject = null;
        if (strN != null) {
            try {
                jSONObject = new JSONObject(strN);
            } catch (JSONException e) {
                m.c(e);
            }
        }
        return new Pair<>(Boolean.TRUE, c(jSONObject, true, z));
    }

    public static JSONObject c(JSONObject jSONObject, boolean z, boolean z2) {
        if (jSONObject == null) {
            return null;
        }
        try {
            String strC = c(jSONObject, z);
            String strOptString = jSONObject.optString("auction_price", "");
            if (TextUtils.isEmpty(strC)) {
                return jSONObject;
            }
            JSONObject jSONObject2 = new JSONObject(strC);
            if (z2) {
                try {
                    jSONObject2.put("auction_price", strOptString);
                } catch (Throwable unused) {
                }
            }
            return jSONObject2;
        } catch (Throwable unused2) {
            return jSONObject;
        }
    }

    public static String c(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return null;
        }
        try {
            int iOptInt = jSONObject.optInt("cypher", -1);
            String strOptString = jSONObject.optString("message");
            com.byazt.dna.n nVarTt = gr.tt();
            if (iOptInt == 3) {
                return com.byazt.nr.c.ve(strOptString);
            }
            if (iOptInt != 4 || nVarTt == null) {
                return strOptString;
            }
            String strDecryptWithCBC = nVarTt.decryptWithCBC(strOptString);
            if (!TextUtils.isEmpty(strDecryptWithCBC) || !z) {
                return strDecryptWithCBC;
            }
            yp.c().c(1, -1L, (String) null, nVarTt.getSpecificArmorLoadStatus());
            return strDecryptWithCBC;
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject c(byte[] bArr, String str) {
        try {
            String strTt = tt(bArr, str);
            if (TextUtils.isEmpty(strTt)) {
                return null;
            }
            return new JSONObject(strTt);
        } catch (Exception e) {
            m.c(e);
            return null;
        }
    }
}

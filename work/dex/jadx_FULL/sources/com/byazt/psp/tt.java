package com.byazt.psp;

import android.text.TextUtils;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, AVMDLDataLoader.KeyIsIsEncryptVersion, 13})
public class tt extends c {
    public static volatile tt uj;
    public final Map<String, String> ve;

    private tt() {
        super("gm_label_v_v_s_3");
        this.ve = new ConcurrentHashMap();
        tt();
    }

    public static tt uj() {
        if (uj == null) {
            synchronized (tt.class) {
                if (uj == null) {
                    uj = new tt();
                }
            }
        }
        return uj;
    }

    public void c(String str, int i, double d) {
        if (!com.byazt.bp.tt.tt().kk() || TextUtils.isEmpty(str)) {
            return;
        }
        c(3, str, i, d);
    }

    @Override // com.byazt.psp.c
    public boolean tt(String str, JSONObject jSONObject, Map<String, Object> map) {
        try {
            Object obj = map.get("user_label_value");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(str, jSONObject2);
            jSONObject2.putOpt("label_info", c(obj != null ? (com.byazt.nbs.ve) obj : null));
            jSONObject2.putOpt("ecpm_ttl", Integer.valueOf(com.byazt.bp.tt.tt().tx()));
            jSONObject2.putOpt("rule_id", map.get("rule_id"));
            jSONObject2.putOpt("group_type", map.get("group_type"));
            jSONObject2.putOpt("rule_in_use", map.get("rule_in_use"));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.putOpt("ecpm", map.get("ecpm"));
            jSONObject3.putOpt("timestamp", String.valueOf(System.currentTimeMillis()));
            jSONObject2.putOpt("ecpm_info", jSONObject3);
            jSONObject2.putOpt("refresh_time", map.get("refresh_time"));
            return true;
        } catch (JSONException e) {
            m.c(e);
            return false;
        }
    }

    public void ve(String str, JSONObject jSONObject, Map<String, Object> map) {
        if (!com.byazt.bp.tt.tt().kk() || TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        try {
            jSONObject.putOpt("rule_id", map.get("rule_id"));
        } catch (JSONException e) {
            m.c(e);
        }
    }

    @Override // com.byazt.psp.c
    public void c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        com.byazt.eu.tt.tt("DynamicLabelValueManagerAbs", "readCacheFromSp-SP_NAME_V3，cpmKey:" + str + "，type_value_timestamp:" + str2);
        if (str.startsWith("cpm_key_")) {
            this.ve.put(str, str2);
        }
    }

    @Override // com.byazt.psp.c
    public Map<String, String> c() {
        return this.ve;
    }

    @Override // com.byazt.psp.c
    public void c(String str, int i, String str2) {
        if (i == 3) {
            this.ve.put(str, str2);
        }
    }

    @Override // com.byazt.psp.c
    public JSONObject c(com.byazt.nbs.ve veVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("label_name", veVar != null ? veVar.c() : "-1");
            jSONObject.putOpt("label_id", veVar != null ? Integer.valueOf(veVar.ve()) : "-1");
            jSONObject.putOpt("label_version", veVar != null ? veVar.uj() : "-1");
            return jSONObject;
        } catch (JSONException e) {
            m.c(e);
            return null;
        }
    }
}

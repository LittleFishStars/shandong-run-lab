package com.byazt.tl;

import android.text.TextUtils;
import com.aliyun.credentials.utils.AuthConstant;
import com.byazt.nr.m;
import com.byazt.omf.gt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 467, 15})
public class uj {
    public boolean c;
    public String tt;
    public com.byazt.vo.ve uj;
    public String ve;

    public static uj c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return c(new JSONObject(str));
        } catch (JSONException e) {
            m.tt("OncallUploadConfig", "parse failed:".concat(String.valueOf(e)));
            return null;
        }
    }

    public com.byazt.vo.ve n() {
        return this.uj;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(AuthConstant.INI_ENABLE, Boolean.valueOf(this.c));
            jSONObject.putOpt("upload_api", this.tt);
            jSONObject.putOpt("alert_text", this.ve);
            com.byazt.vo.ve veVar = this.uj;
            if (veVar != null) {
                jSONObject.putOpt("filter_word", veVar.toJson());
            }
        } catch (JSONException e) {
            m.tt("OncallUploadConfig", e);
        }
        return jSONObject.toString();
    }

    public boolean tt() {
        return this.c;
    }

    public String uj() {
        return this.ve;
    }

    public String ve() {
        return this.tt;
    }

    public static uj c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        uj ujVar = new uj();
        ujVar.c = jSONObject.optBoolean(AuthConstant.INI_ENABLE);
        ujVar.tt = jSONObject.optString("upload_api");
        ujVar.ve = jSONObject.optString("alert_text");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("filter_word");
        if (jSONObjectOptJSONObject != null) {
            com.byazt.vo.ve fromJson = com.byazt.vo.ve.parseFromJson(jSONObjectOptJSONObject);
            if (fromJson != null) {
                if (TextUtils.isEmpty(fromJson.getId())) {
                    fromJson.setId("99:1");
                }
                if (TextUtils.isEmpty(fromJson.getName())) {
                    fromJson.setName("素材反馈");
                }
                fromJson.setNewUi(false);
            }
            ujVar.uj = fromJson;
        }
        return ujVar;
    }

    public static com.byazt.vo.ve c() {
        uj ujVarIj = gt.tt().ij();
        if (ujVarIj == null || TextUtils.isEmpty(ujVarIj.tt)) {
            return null;
        }
        if (gt.tt().cg()) {
            com.byazt.vo.ve veVar = new com.byazt.vo.ve();
            veVar.setId("99:1");
            veVar.setNewUi(true);
            veVar.setName("其他问题");
            return veVar;
        }
        return ujVarIj.n();
    }
}

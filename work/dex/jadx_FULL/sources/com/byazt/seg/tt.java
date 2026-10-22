package com.byazt.seg;

import android.text.TextUtils;
import com.alibaba.ariver.permission.b;
import com.byazt.nr.m;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 947, 13})
public class tt extends com.byazt.ku.c {
    public tt() {
    }

    public static tt n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return tt(new JSONObject(str));
        } catch (JSONException e) {
            m.c(e);
            return null;
        }
    }

    public static tt tt(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        tt ttVar = new tt();
        ttVar.c(jSONObject.optString("name"));
        ttVar.tt(jSONObject.optString("version"));
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    com.byazt.ku.c.C0458c c0458c = new com.byazt.ku.c.C0458c();
                    c0458c.c(jSONObjectOptJSONObject.optString("url"));
                    c0458c.tt(jSONObjectOptJSONObject.optString(TKDownloadReason.KSAD_TK_MD5));
                    c0458c.c(jSONObjectOptJSONObject.optInt(b.b));
                    arrayList.add(c0458c);
                }
            }
        }
        ttVar.c(arrayList);
        if (ttVar.a()) {
            return ttVar;
        }
        return null;
    }

    @Override // com.byazt.ku.c
    public boolean a() {
        return (TextUtils.isEmpty(ve()) || TextUtils.isEmpty(tt())) ? false : true;
    }

    @Override // com.byazt.ku.c
    public String x() {
        if (!a()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("name", tt());
            jSONObject.putOpt("version", ve());
            JSONArray jSONArray = new JSONArray();
            if (getResources() != null) {
                for (com.byazt.ku.c.C0458c c0458c : getResources()) {
                    if (c0458c != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("url", c0458c.c());
                        jSONObject2.putOpt(TKDownloadReason.KSAD_TK_MD5, c0458c.tt());
                        jSONObject2.putOpt(b.b, Integer.valueOf(c0458c.ve()));
                        jSONArray.put(jSONObject2);
                    }
                }
            }
            jSONObject.putOpt("resources", jSONArray);
            return jSONObject.toString();
        } catch (JSONException e) {
            m.c(e);
            return null;
        }
    }

    public tt(com.byazt.ku.c cVar) {
        if (cVar != null) {
            c(cVar.tt());
            tt(cVar.ve());
            c(cVar.getResources());
        }
    }
}

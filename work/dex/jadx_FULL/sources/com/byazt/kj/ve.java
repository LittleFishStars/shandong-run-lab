package com.byazt.kj;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.byazt.gqp.da;
import com.byazt.nr.m;
import com.byazt.ukr.yp;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 159, 54})
public class ve extends c {
    public String x;

    public ve(com.byazt.tjs.c cVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        super(cVar, str, str2, jSONObject, str3, str4);
        this.x = "inspect_data";
    }

    @Override // com.byazt.kj.c
    public void c() {
        try {
            this.f28731a.putOpt("req_id", this.ve);
            this.f28731a.put(this.x, new JSONArray());
        } catch (Exception e) {
            m.c(e);
        }
    }

    @Override // com.byazt.kj.c
    public void c(Context context, String str, com.byazt.tjs.tt ttVar, WebResourceResponse webResourceResponse, da daVar, Map<String, Object> map) {
    }

    @Override // com.byazt.kj.c
    public void c(String str, String str2) {
    }

    @Override // com.byazt.kj.c
    public void c(JSONObject jSONObject, String str, da daVar, String str2, String str3, Map<String, String> map, Map<String, Object> map2) {
    }

    @Override // com.byazt.kj.c
    public boolean c(WebView webView) {
        return true;
    }

    @Override // com.byazt.kj.c
    public boolean c(da daVar) {
        return true;
    }

    public JSONObject n() {
        try {
            int i = this.c.tt().get();
            JSONArray jSONArrayOptJSONArray = this.f28731a.optJSONArray(this.x);
            if (jSONArrayOptJSONArray == null) {
                return null;
            }
            int length = jSONArrayOptJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i2);
                int iOptInt = jSONObject.optInt("jump_number", -1);
                if (iOptInt != -1 && iOptInt == i) {
                    return jSONObject;
                }
            }
        } catch (Exception e) {
            m.c(e);
        }
        return null;
    }

    @Override // com.byazt.kj.c
    public void tt(Context context, String str, com.byazt.tjs.tt ttVar, WebResourceResponse webResourceResponse, da daVar, Map<String, Object> map) {
    }

    public void uj() {
        JSONObject jSONObject = this.f28731a;
        if (jSONObject == null) {
            return;
        }
        yp.c().uj(jSONObject.toString(), this.f28731a.optString("req_id"));
    }

    @Override // com.byazt.kj.c
    public void ve() {
        this.c.c(new Runnable() { // from class: com.byazt.kj.ve.1
            @Override // java.lang.Runnable
            public void run() {
                ve.this.uj();
            }
        });
    }

    @Override // com.byazt.kj.c
    public void c(String str) {
        int i = this.c.tt().get();
        JSONArray jSONArrayOptJSONArray = this.f28731a.optJSONArray(this.x);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("jump_number", i);
            jSONObject.put("jump_url", str);
            jSONArrayOptJSONArray.put(jSONObject);
            this.f28731a.put("inspect_data", jSONArrayOptJSONArray);
        } catch (Exception e) {
            m.c(e);
        }
    }

    @Override // com.byazt.kj.c
    public void c(com.byazt.tjs.tt ttVar, WebResourceResponse webResourceResponse, da daVar, c.InterfaceC0455c interfaceC0455c) {
        Uri uriC = ttVar.c();
        if (uriC != null) {
            try {
                String string = uriC.toString();
                String lowerCase = "unknown";
                if (daVar != null && daVar.tt() != null) {
                    lowerCase = daVar.tt().trim().toLowerCase();
                }
                JSONObject jSONObjectN = n();
                if (jSONObjectN != null) {
                    JSONArray jSONArrayOptJSONArray = jSONObjectN.optJSONArray(lowerCase);
                    if (jSONArrayOptJSONArray == null) {
                        jSONArrayOptJSONArray = new JSONArray();
                    }
                    jSONArrayOptJSONArray.put(string);
                    jSONObjectN.putOpt(lowerCase, jSONArrayOptJSONArray);
                } else {
                    m.uj("weblp", "error pageCountJson is null");
                }
            } catch (Exception e) {
                m.c(e);
                m.ve("weblp", "error", e);
            }
        }
        interfaceC0455c.c(false, null);
    }
}

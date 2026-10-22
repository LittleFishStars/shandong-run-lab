package com.byazt.ete;

import android.text.TextUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 47})
public class eo {
    public String c;
    public String tt;
    public List<com.byazt.fx.tt> ve = new ArrayList();

    public eo(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.c = jSONObject.optString("id");
        this.tt = jSONObject.optString("url");
        ve();
    }

    private void ve() {
        String strC = c(this.c);
        if (!TextUtils.isEmpty(strC)) {
            tt(strC);
            return;
        }
        com.byazt.va.ve veVarVe = com.byazt.hy.n.c().tt().ve();
        if (veVarVe == null || TextUtils.isEmpty(this.tt)) {
            return;
        }
        veVarVe.c(this.tt);
        veVarVe.c(new com.byazt.mh.c() { // from class: com.byazt.ete.eo.1
            @Override // com.byazt.mh.c
            public void c(com.byazt.va.uj ujVar, com.byazt.hm.tt ttVar) {
                if (ttVar != null) {
                    try {
                        if (!ttVar.i() || ttVar.n() == null) {
                            return;
                        }
                        com.byazt.it.ve veVarC = com.byazt.omf.tt.c();
                        String strN = ttVar.n();
                        veVarC.put(eo.this.c, strN);
                        eo.this.tt(strN);
                    } catch (Exception unused) {
                    }
                }
            }

            @Override // com.byazt.mh.c
            public void c(com.byazt.va.uj ujVar, IOException iOException) {
            }
        });
    }

    public List<com.byazt.fx.tt> tt() {
        return this.ve;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("pattern");
            for (int i = 0; i < jSONArray.length(); i++) {
                this.ve.add(new com.byazt.fx.tt(jSONArray.getJSONObject(i)));
            }
        } catch (Exception unused) {
        }
    }

    public String c() {
        return this.c;
    }

    private String c(String str) {
        com.byazt.it.ve veVarC;
        if (TextUtils.isEmpty(str) || (veVarC = com.byazt.omf.tt.c()) == null) {
            return null;
        }
        return veVarC.get(str, "");
    }

    public eo(String str, JSONArray jSONArray) {
        this.c = str;
        c(jSONArray);
    }

    private void c(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                this.ve.add(new com.byazt.fx.tt(jSONArray.getJSONObject(i)));
            } catch (Exception unused) {
                return;
            }
        }
    }
}

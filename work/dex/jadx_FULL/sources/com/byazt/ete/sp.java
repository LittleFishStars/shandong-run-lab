package com.byazt.ete;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 91})
public class sp {
    public String c;
    public List<String> tt;

    public sp(Map<String, Object> map) {
        this.c = "";
        this.tt = new ArrayList();
        try {
            this.c = (String) map.get("auto_test_param");
            String str = (String) map.get("auto_test_hosts");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            this.tt = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                this.tt.add(jSONArray.optString(i));
            }
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
        }
    }

    public String c() {
        return this.c;
    }

    public List<String> tt() {
        return this.tt;
    }
}

package com.byazt.ds;

import android.content.SharedPreferences;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1480, 115})
public class rh extends ve {
    public final x n;

    public rh(x xVar) {
        super(true, false, false);
        this.n = xVar;
    }

    @Override // com.byazt.ds.ve
    public boolean c(JSONObject jSONObject) throws JSONException {
        SharedPreferences sharedPreferencesN = this.n.n();
        String string = sharedPreferencesN.getString("install_id", null);
        String string2 = sharedPreferencesN.getString("device_id", null);
        String string3 = sharedPreferencesN.getString("ssid", null);
        i.c(jSONObject, "install_id", string);
        i.c(jSONObject, "device_id", string2);
        i.c(jSONObject, "ssid", string3);
        long j = 0;
        long j2 = sharedPreferencesN.getLong("register_time", 0L);
        if ((i.tt(string) && i.tt(string2)) || j2 == 0) {
            j = j2;
        } else {
            sharedPreferencesN.edit().putLong("register_time", 0L).apply();
        }
        jSONObject.put("register_time", j);
        return true;
    }
}

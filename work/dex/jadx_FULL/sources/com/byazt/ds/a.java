package com.byazt.ds;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1480, 34})
public class a extends ve {
    public final Context n;

    public a(Context context) {
        super(false, false);
        this.n = context;
    }

    public static String tt(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(Base64.decode(str.getBytes("UTF-8"), 0));
        } catch (UnsupportedEncodingException e) {
            com.byazt.nr.m.c(e);
            return str;
        }
    }

    @Override // com.byazt.ds.ve
    public boolean c(JSONObject jSONObject) throws Throwable {
        SharedPreferences sharedPreferencesTt = com.byazt.nys.tt.tt(this.n, "snssdk_openudid", 0);
        String strTt = tt(sharedPreferencesTt.getString("custom_a", null));
        if (TextUtils.isEmpty(strTt)) {
            strTt = sharedPreferencesTt.getString("clientudid", null);
        }
        if (!i.c(strTt)) {
            try {
                strTt = UUID.randomUUID().toString();
                strTt = c("clientudid.dat", strTt);
            } catch (Exception unused) {
            }
            String strC = c(strTt);
            SharedPreferences.Editor editorEdit = sharedPreferencesTt.edit();
            editorEdit.putString("custom_a", strC);
            editorEdit.apply();
        }
        jSONObject.put("clientudid", strTt);
        return true;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 0);
        } catch (UnsupportedEncodingException e) {
            com.byazt.nr.m.c(e);
            return str;
        }
    }
}

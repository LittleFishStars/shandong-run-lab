package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.config.AesDecrypt;
import com.huawei.agconnect.config.IDecrypt;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class h implements AesDecrypt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f37372a;
    private final String b;
    private IDecrypt c;

    public h(Context context, String str) {
        Log.d("AGC_FlexibleDecrypt", "init");
        this.f37372a = context;
        this.b = str;
    }

    @Override // com.huawei.agconnect.config.AesDecrypt
    public String decrypt(String str, String str2) {
        if (this.c == null) {
            this.c = decryptComponent();
        }
        if (this.c == null) {
            Log.w("AGC_FlexibleDecrypt", "decrypt Flexible Decrypt error, use old instead");
            this.c = new g(this.f37372a, this.b).decryptComponent();
        }
        return this.c.decrypt(l.a(this.f37372a, this.b, "agc_plugin_", str), str2);
    }

    @Override // com.huawei.agconnect.config.AesDecrypt
    public IDecrypt decryptComponent() {
        String strA = l.a(this.f37372a, this.b, "agc_plugin_", "crypto_component");
        if (strA == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(Hex.decodeHexString(strA), "utf-8"));
            return new f(new d(jSONObject.getString("rx"), jSONObject.getString("ry"), jSONObject.getString("rz"), jSONObject.getString("salt"), jSONObject.getString("algorithm"), jSONObject.getInt("iterationCount")));
        } catch (UnsupportedEncodingException | IllegalArgumentException | JSONException e) {
            Log.e("AGC_FlexibleDecrypt", "FlexibleDecrypt exception: " + e.getMessage());
            return null;
        }
    }
}

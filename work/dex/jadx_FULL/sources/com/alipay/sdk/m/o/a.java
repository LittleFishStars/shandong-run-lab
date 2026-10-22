package com.alipay.sdk.m.o;

import android.text.TextUtils;
import com.alipay.sdk.m.y.g;
import java.util.Locale;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f25475a = null;
    public String b = null;
    public String c = null;
    public String d = null;

    public void a(String str) {
        g.d(com.alipay.sdk.m.n.a.B, "DebugUpgradeWarnData setData:" + str);
        this.f25475a = str;
        this.b = null;
        this.c = null;
        this.d = null;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() >= 3) {
                this.b = jSONArray.getString(0);
                this.d = jSONArray.getString(1);
                this.c = jSONArray.getString(2);
            }
        } catch (Throwable th) {
            g.a(th);
        }
    }

    public String b() {
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        if (TextUtils.equals(language, "zh") && TextUtils.equals(country, "CN")) {
            return this.b;
        }
        return (TextUtils.equals(language, "zh") && TextUtils.equals(country, "TW")) ? this.c : this.d;
    }

    public String a() {
        return this.f25475a;
    }
}

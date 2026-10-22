package com.alipay.sdk.m.t;

import android.text.TextUtils;
import com.alipay.sdk.m.y.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f25506a;
    public final String b;

    public b(String str, String str2) {
        this.f25506a = str;
        this.b = str2;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.f25506a;
    }

    public JSONObject c() {
        if (TextUtils.isEmpty(this.b)) {
            return null;
        }
        try {
            return new JSONObject(this.b);
        } catch (Exception e) {
            g.a(e);
            return null;
        }
    }

    public String toString() {
        return String.format("<Letter envelop=%s body=%s>", this.f25506a, this.b);
    }
}

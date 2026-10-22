package com.acse.ottn;

import android.webkit.JavascriptInterface;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f22784a;

    public interface a {
        void a(JSONObject jSONObject, m0 m0Var);
    }

    public void a(a aVar) {
        this.f22784a = aVar;
    }

    @JavascriptInterface
    public void copy(Object obj, m0 m0Var) {
        this.f22784a.a((JSONObject) obj, m0Var);
    }
}

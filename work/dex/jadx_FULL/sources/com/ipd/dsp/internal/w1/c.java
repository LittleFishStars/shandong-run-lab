package com.ipd.dsp.internal.w1;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.c2.g;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.internal.c2.r;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f38598a;
    public a b;
    public ConcurrentHashMap<String, String> c = new ConcurrentHashMap<>();

    public interface a {
        JSONObject a();

        void a(int i, int i2);

        void a(int i, JSONObject jSONObject);

        void a(com.ipd.dsp.internal.h1.a.c cVar, JSONObject jSONObject);

        void a(String str);

        void a(@Nullable JSONObject jSONObject);

        void b();

        boolean b(String str);

        void c(String str);

        void d();

        void d(String str);

        @Nullable
        Context getContext();

        JSONObject getCustomData();

        String getOriginalUrl();

        void setTitle(int i);
    }

    public c(String str, a aVar) {
        this.f38598a = str;
        this.b = aVar;
    }

    public String a(String str) {
        if (str != null) {
            return this.c.get(str);
        }
        return null;
    }

    @JavascriptInterface
    public boolean copyToClipBoard(String str) {
        ClipboardManager clipboardManager;
        a aVar = this.b;
        if (aVar == null) {
            return false;
        }
        try {
            Context context = aVar.getContext();
            if (context == null || (clipboardManager = (ClipboardManager) context.getSystemService("clipboard")) == null) {
                return false;
            }
            clipboardManager.setPrimaryClip(ClipData.newPlainText(null, str));
            return true;
        } catch (Throwable th) {
            r.a(th);
            return false;
        }
    }

    @JavascriptInterface
    public void exit() {
        a aVar = this.b;
        if (aVar != null) {
            aVar.b();
        }
    }

    @JavascriptInterface
    public String getAdData() {
        JSONObject jSONObjectA;
        a aVar = this.b;
        return (aVar == null || (jSONObjectA = aVar.a()) == null) ? "{}" : jSONObjectA.toString();
    }

    @JavascriptInterface
    public String getCustomData() {
        JSONObject customData;
        a aVar = this.b;
        return (aVar == null || (customData = aVar.getCustomData()) == null) ? "{}" : customData.toString();
    }

    @JavascriptInterface
    public String getDeviceInfo() {
        try {
            return new JSONObject(g.a().h()).toString();
        } catch (Throwable unused) {
            return "{}";
        }
    }

    @JavascriptInterface
    public String getOriginalUrl() {
        a aVar = this.b;
        return aVar != null ? aVar.getOriginalUrl() : "";
    }

    @JavascriptInterface
    public long getTime() {
        return System.currentTimeMillis();
    }

    @JavascriptInterface
    public String getUserAgentString() {
        return this.f38598a;
    }

    @JavascriptInterface
    public boolean launch(String str) {
        a aVar = this.b;
        if (aVar != null) {
            return aVar.b(str);
        }
        return false;
    }

    @JavascriptInterface
    public void onAdClick() {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a((JSONObject) null);
        }
    }

    @JavascriptInterface
    public void onAdEvent(@NonNull String str, String str2) {
        com.ipd.dsp.internal.h1.a.c cVarA;
        JSONObject jSONObject;
        if (this.b == null || (cVarA = com.ipd.dsp.internal.h1.a.e.a(str)) == null) {
            return;
        }
        if (o.c(str2)) {
            try {
                jSONObject = new JSONObject(str2);
            } catch (JSONException e) {
                r.a(e);
                jSONObject = null;
            }
        } else {
            jSONObject = null;
        }
        this.b.a(cVarA, jSONObject);
    }

    @JavascriptInterface
    public void onAdReward(String str) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.c(str);
        }
    }

    @JavascriptInterface
    public void onAdSkip(String str) {
        a aVar = this.b;
        if (aVar != null) {
            aVar.d(str);
        }
    }

    @JavascriptInterface
    public void onClickEvent(int i, String str) {
        JSONObject jSONObject;
        if (this.b == null) {
            return;
        }
        if (o.c(str)) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
                jSONObject = null;
            }
        } else {
            jSONObject = null;
        }
        this.b.a(i, jSONObject);
    }

    @JavascriptInterface
    public void onPageLoad() {
        a aVar = this.b;
        if (aVar != null) {
            aVar.d();
        }
    }

    @JavascriptInterface
    public void onVideoPlayEvent(int i, int i2) {
        try {
            a aVar = this.b;
            if (aVar != null) {
                aVar.a(i, i2);
            }
        } catch (Throwable th) {
            Log.e("Dsp", "onAdEventErr", th);
        }
    }

    @JavascriptInterface
    public void setEventAndAction(String str, String str2) {
        this.c.put(str, str2);
    }

    @JavascriptInterface
    public void setTitle(String str) {
        a aVar = this.b;
        if (aVar != null) {
            try {
                aVar.setTitle(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                this.b.a(str);
            }
        }
    }

    @JavascriptInterface
    public String sign(String str) {
        return str;
    }

    public void a() {
        this.b = null;
        this.c.clear();
        this.c = null;
    }

    @JavascriptInterface
    public void onAdClick(String str) {
        JSONObject jSONObject;
        if (this.b != null) {
            if (o.c(str)) {
                try {
                    jSONObject = new JSONObject(str);
                } catch (JSONException e) {
                    r.a(e);
                    jSONObject = null;
                }
            } else {
                jSONObject = null;
            }
            this.b.a(jSONObject);
        }
    }
}

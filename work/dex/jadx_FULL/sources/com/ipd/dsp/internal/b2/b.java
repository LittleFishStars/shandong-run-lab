package com.ipd.dsp.internal.b2;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.Dsp;
import com.ipd.dsp.internal.c2.g;
import com.ipd.dsp.internal.c2.j;
import com.ipd.dsp.internal.c2.r;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class b implements Runnable {
    public final String f;
    public final String g;
    public final Map<String, Object> h;
    public final int i;
    public final com.ipd.dsp.internal.y1.b.a j;

    public b(@NonNull String str, @NonNull String str2, @Nullable Map<String, Object> map, int i, @Nullable com.ipd.dsp.internal.y1.b.a aVar) {
        this.f = str;
        this.g = str2;
        this.h = map;
        this.j = aVar;
        this.i = Math.max(2, Math.min(10, i));
    }

    public void a(String str) {
        if (this.j != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                int iOptInt = jSONObject.optInt("code");
                String strOptString = jSONObject.optString("msg");
                final JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                if (jSONObjectOptJSONObject == null) {
                    b(new com.ipd.dsp.internal.f1.a(iOptInt, strOptString), null);
                } else if (this instanceof a) {
                    this.j.a(jSONObjectOptJSONObject.toString());
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zj.adlib.nla
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f43554a.a(jSONObjectOptJSONObject);
                        }
                    });
                }
            } catch (Throwable th) {
                r.a(th);
                b(com.ipd.dsp.internal.f1.a.f(), th);
            }
        }
    }

    public void b(@NonNull final com.ipd.dsp.internal.f1.a aVar, @Nullable final Throwable th) {
        if (th instanceof com.ipd.dsp.internal.z1.b) {
            com.ipd.dsp.internal.z1.a.a().a(((com.ipd.dsp.internal.z1.b) th).f);
        }
        if (this.j != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zj.adlib.zka
                @Override // java.lang.Runnable
                public final void run() {
                    this.f46284a.a(aVar, th);
                }
            });
        }
    }

    public HttpURLConnection b(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestProperty("ipd-wa", g.a().G());
        httpURLConnection.setRequestProperty("ipd-ver", Dsp.getSDKVersion());
        if (httpURLConnection instanceof HttpsURLConnection) {
            try {
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(j.a());
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(j.f38226a);
                return httpURLConnection;
            } catch (Throwable th) {
                r.a(th);
            }
        }
        return httpURLConnection;
    }

    public final /* synthetic */ void a(JSONObject jSONObject) {
        this.j.a(jSONObject.toString());
    }

    public final /* synthetic */ void a(com.ipd.dsp.internal.f1.a aVar, Throwable th) {
        this.j.a(aVar.f38306a, aVar.b, th);
    }
}

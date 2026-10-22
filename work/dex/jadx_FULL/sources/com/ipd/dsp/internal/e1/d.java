package com.ipd.dsp.internal.e1;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ipd.dsp.Dsp;
import com.ipd.dsp.internal.c2.o;
import java.io.Serializable;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class d implements Serializable {
    public boolean A;
    public boolean B;
    public String C;
    public g D;
    public boolean E;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public boolean p;
    public j q;
    public b r;
    public f s;
    public h t;
    public k u;
    public int v;
    public c w;
    public String x;
    public boolean y;
    public boolean z;

    public void a(@NonNull JSONObject jSONObject) throws SignatureException {
        this.C = jSONObject.toString();
        String strOptString = jSONObject.optString("ad_item_id");
        this.j = strOptString;
        if (TextUtils.isEmpty(strOptString)) {
            this.j = jSONObject.optString("order_no");
        }
        this.k = jSONObject.optString("title");
        this.l = jSONObject.optString("desc");
        this.m = jSONObject.optString("cta_descr");
        this.n = jSONObject.optString("logo");
        this.o = jSONObject.optString("image");
        this.p = jSONObject.optBoolean("area_enable", true);
        this.q = new j(jSONObject.optJSONObject("video"));
        this.r = new b(jSONObject.optJSONObject("click_action"));
        f fVar = new f(jSONObject.optJSONObject("layout"));
        this.s = fVar;
        if (fVar.j == 0) {
            fVar.j = o.c(this.q.f) ? 4 : 1;
        }
        this.v = Math.max(0, jSONObject.optInt("price", -1));
        this.y = "full".equals(jSONObject.optString("screen_show"));
        this.z = jSONObject.optBoolean("is_show_retain_page", true);
        this.A = jSONObject.optBoolean("is_show_end_page", true);
        this.B = jSONObject.optBoolean("is_award", i.b.equals(this.h));
        this.E = jSONObject.optBoolean("is_can_use_backkey", false);
        this.w = new c();
        this.t = new h(jSONObject.optJSONObject("ad_source"));
        this.u = new k(jSONObject.optJSONObject("event_urls"));
        this.D = new g();
        if (o.c(this.x)) {
            a();
        }
    }

    public Map<String, Object> b() {
        HashMap map = new HashMap();
        map.put("appid", this.f);
        map.put(MediationConstant.EXTRA_ADID, this.g);
        map.put("ad_item_id", this.j);
        map.put("sdk_version", Dsp.getSDKVersion());
        map.put("trade_id", this.i);
        map.put("ad_type", this.h);
        if (o.c(this.D.f)) {
            map.put("user_id_o", o.d(this.D.f));
        }
        if (o.c(this.D.g)) {
            map.put("extra_o", o.d(this.D.g));
        }
        return map;
    }

    public final void a() throws SignatureException {
        Object[] objArr = new Object[7];
        b bVar = this.r;
        objArr[0] = bVar.k;
        objArr[1] = this.o;
        objArr[2] = this.n;
        objArr[3] = bVar.j;
        objArr[4] = this.g;
        objArr[5] = this.i;
        objArr[6] = this.q.f;
        for (int i = 0; i < 7; i++) {
            Object obj = objArr[i];
            if (obj instanceof String) {
                String str = (String) obj;
                if (!str.isEmpty()) {
                    try {
                        objArr[i] = URLEncoder.encode(str, StandardCharsets.UTF_8.name());
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        try {
            if (Objects.equals(com.ipd.dsp.internal.c2.l.a(String.format(Locale.getDefault(), "apk_url=%s&image=%s&logo=%s&page=%s&pm_posid=%s&trade_no=%s&video_url=%s&key=YDUIWS71HTE26XA8COLP0R5GBVZN34JM", objArr)).toUpperCase(Locale.getDefault()), this.x)) {
                return;
            }
        } catch (Throwable unused2) {
        }
        throw new SignatureException();
    }
}

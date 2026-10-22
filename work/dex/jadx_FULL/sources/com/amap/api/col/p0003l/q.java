package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import com.zj.adlib.d9b;
import com.zj.adlib.l6b;
import com.zj.adlib.m4b;
import com.zj.adlib.s4b;
import com.zj.adlib.u4b;
import com.zj.adlib.w4b;
import com.zj.adlib.x4b;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f1076a = "";
    public static final String b = s4b.v("SRFZHZUVZT3BOa0ZiemZRQQ");
    public static final String c = s4b.v("FbGJzX3Nkaw");
    public static final String d = s4b.v("SWjJuYVh2eEMwSzVmNklFSmh0UXpVb2xtOVM4eU9Ua3E");
    public static final String e = s4b.v("FQU5EU0RLMTA");
    public static final String f = s4b.v("FMTAw");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f26043a = false;

    public static class a implements fj.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public q f26044a = new q();

        @Override // com.amap.api.col.3l.fj.a
        public final hs a(byte[] bArr, Map<String, String> map) {
            return new t(bArr, map);
        }

        @Override // com.amap.api.col.3l.fj.a
        public final Map<String, String> b() {
            return this.f26044a.d();
        }

        @Override // com.amap.api.col.3l.fj.a
        public final String a() {
            return q.e();
        }

        @Override // com.amap.api.col.3l.fj.a
        public final String b(String str, String str2, String str3, String str4) {
            return this.f26044a.c(str, str2, str3, str4);
        }

        @Override // com.amap.api.col.3l.fj.a
        public final String a(Context context, String str) {
            return q.b(context, str);
        }
    }

    public static fj.a a() {
        return new a();
    }

    public static String b(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(s4b.v("UY29kZQ")) != 1) {
                return "";
            }
            String strOptString = new JSONObject(jSONObject.optString(s4b.v("FZGF0YQ"))).optString(s4b.v("FYWRpdQ"));
            if (TextUtils.isEmpty(strOptString)) {
                return "";
            }
            w4b.b(strOptString);
            p.a(context).c(strOptString);
            return strOptString;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String e() {
        return w4b.a();
    }

    public final String c(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(s4b.v("LdGlk"), str);
            jSONObject.put(s4b.v("FZGl1"), str2);
            jSONObject.put(s4b.v("AZGl1Mg"), str3);
            jSONObject.put(s4b.v("EZGl1Mw"), str4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        String string = jSONObject.toString();
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        String strB = l6b.b();
        if (!TextUtils.isEmpty(strB)) {
            String strA = u4b.a(d9b.a((string + "\u0000").getBytes(), strB.getBytes()));
            if (!TextUtils.isEmpty(strA)) {
                try {
                    return s4b.v("Fa2V5PQ") + URLEncoder.encode(u4b.a(x4b.b(strB.getBytes("utf-8"), x4b.a(f())))) + s4b.v("SJmRhdGE9") + URLEncoder.encode(strA);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
        return null;
    }

    public final synchronized Map<String, String> d() {
        if (f26043a) {
            return null;
        }
        f26043a = true;
        HashMap map = new HashMap();
        map.put(s4b.v("FZW50"), s4b.v("FMg"));
        StringBuilder sb = new StringBuilder();
        sb.append(s4b.v("SY2hhbm5lbD0"));
        String str = c;
        sb.append(str);
        sb.append(s4b.v("SJmRpdj0"));
        String str2 = e;
        sb.append(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(str2);
        stringBuffer.append(s4b.v("FQA"));
        stringBuffer.append(d);
        String strD = l6b.d(stringBuffer.toString());
        sb.append(s4b.v("FJnNpZ249"));
        sb.append(strD.toUpperCase(Locale.US));
        sb.append(s4b.v("SJm91dHB1dD1qc29u") + "\u0000");
        map.put(s4b.v("FaW4"), u4b.a(d9b.a(sb.toString().getBytes(), b.getBytes())));
        map.put(s4b.v("Sa2V5dA"), f);
        return map;
    }

    public final String f() {
        if (!TextUtils.isEmpty(this.f1076a)) {
            return this.f1076a;
        }
        String strA = m4b.a("TUpJaVFGNk5LXHtSX1ZwQlRiV1VVZmtYWU1haV1hYWHCiXJtZcKLdmp8wpFewo1/wphwwoFzZmR8aWp6X2k6XsKDwoF+WGbChGdAScKLwoVXfmNxYEvCjcKLSG7CjGNvwoZtVFZ7WMKXYMKfwo5dZcKHfzZXUG85X0hNOVJrb2U8ZlJGW8KCe8KOV8KQWllrcGrCjcKIT25lUHPCicKGVsKKeG5fwp56XsKbc8KJbUVYR0pqU09gfE5/WT5YeHNAwoDCh1Z4V8KQT3JQYmxQbcKYwpFxdG/Ci3rCmMKQwop+YVbCmWFxwpxBdW07Zjp/ODlAbcKEY1pQwoJowohbV1VmV1laWmtcYGbClXfCk2NvesKdwohdWFnCol/CjWTCmMKicG1ENnAvPFtpcXtfclhfXsKAwolgRWNbS29OwpFafV3CkMKLTcKCwolrU3DCmGnCmX9wdsKPcXDCg3LCnFpGcDVTeTxNWW07bXJePVRfQn3ChGNraFhbwpNcwpXChMKNaFVjeVF8wojChm9YbmvChGDCmHvChGVQWjo0Z3o9djleOztWcVxSfWE9woLChkZdcGTCgVzCjMKUVE12wpV5bcKVwprCnntZworCgsKfwpHCksKnwpHClURURW9YaDtwXU1bck5YX3hSVFZUYlxKWFlua1xeYm9jU8KDa3ZrwpZ5am9Za3jCknR3fA");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strA.length(); i++) {
            stringBuffer.append((char) (strA.charAt(i) - (i % 48)));
        }
        String string = stringBuffer.toString();
        StringBuffer stringBuffer2 = new StringBuffer();
        for (int i2 = 0; i2 < string.length() / 2; i2++) {
            stringBuffer2.append((char) ((string.charAt(i2) + string.charAt((string.length() - 1) - i2)) / 2));
        }
        String string2 = stringBuffer2.toString();
        this.f1076a = string2;
        return string2;
    }
}

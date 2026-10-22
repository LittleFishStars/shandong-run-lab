package com.zj.adlib;

import com.google.android.exoplayer2.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class wl1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f45619a = "ClearKeyUtil";

    public static byte[] a(byte[] bArr) {
        return gj9.f41922a >= 27 ? bArr : gj9.z0(c(gj9.I(bArr)));
    }

    public static byte[] b(byte[] bArr) {
        if (gj9.f41922a >= 27) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject(gj9.I(bArr));
            StringBuilder sb = new StringBuilder("{\"keys\":[");
            JSONArray jSONArray = jSONObject.getJSONArray("keys");
            for (int i = 0; i < jSONArray.length(); i++) {
                if (i != 0) {
                    sb.append(",");
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                sb.append("{\"k\":\"");
                sb.append(d(jSONObject2.getString("k")));
                sb.append("\",\"kid\":\"");
                sb.append(d(jSONObject2.getString("kid")));
                sb.append("\",\"kty\":\"");
                sb.append(jSONObject2.getString("kty"));
                sb.append("\"}");
            }
            sb.append("]}");
            return gj9.z0(sb.toString());
        } catch (JSONException e) {
            Log.e(f45619a, "Failed to adjust response data: " + gj9.I(bArr), e);
            return bArr;
        }
    }

    public static String c(String str) {
        return str.replace('+', '-').replace('/', '_');
    }

    public static String d(String str) {
        return str.replace('-', '+').replace('_', '/');
    }
}

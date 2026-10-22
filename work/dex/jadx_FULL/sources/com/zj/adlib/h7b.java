package com.zj.adlib;

import android.content.Context;
import com.amap.api.col.p0003l.fm;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class h7b extends fm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f42068a = null;
    public Context b = null;

    @Override // com.amap.api.col.p0003l.hs
    public final byte[] getEntityBytes() {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            JSONObject jSONObject = this.f42068a;
            if (jSONObject != null) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    stringBuffer.append(next + "=" + URLEncoder.encode(this.f42068a.get(next).toString(), "utf-8") + "&");
                }
            }
            stringBuffer.append("output=json");
            String strJ = j4b.j(this.b);
            stringBuffer.append("&key=".concat(String.valueOf(strJ)));
            String strA = l4b.a();
            stringBuffer.append("&ts=".concat(String.valueOf(strA)));
            stringBuffer.append("&scode=" + l4b.c(this.b, strA, "key=".concat(String.valueOf(strJ))));
            return stringBuffer.toString().getBytes("utf-8");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.amap.api.col.p0003l.hs
    public final Map<String, String> getParams() {
        return null;
    }

    @Override // com.amap.api.col.p0003l.hs
    public final Map<String, String> getRequestHead() {
        HashMap map = new HashMap();
        map.put("Content-Type", "application/x-www-form-urlencoded");
        map.put("Accept-Encoding", "gzip");
        map.put("User-Agent", "AMAP SDK Android core 4.3.1");
        map.put("X-INFO", l4b.i(this.b));
        map.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "4.3.1", "core"));
        map.put("logversion", "2.1");
        return map;
    }

    @Override // com.amap.api.col.p0003l.hs
    public final String getSDKName() {
        return "core";
    }

    @Override // com.amap.api.col.p0003l.hs
    public final String getURL() {
        return n4b.a().h() ? "https://restsdk.amap.com/sdk/compliance/params" : "http://restsdk.amap.com/sdk/compliance/params";
    }
}

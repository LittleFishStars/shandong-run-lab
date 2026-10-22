package com.zj.adlib;

import android.content.Context;
import android.os.Handler;
import com.alibaba.ariver.kernel.RVParams;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.TraceLocation;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class d4b extends com.amap.api.col.p0003l.ez<List<TraceLocation>, List<LatLng>> implements Runnable {
    public int L;
    public int M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f41105a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<TraceLocation> f15924a;
    public String k;

    public d4b(Context context, Handler handler, List<TraceLocation> list, String str, int i, int i2) {
        super(context, list);
        this.f15924a = list;
        this.f41105a = handler;
        this.M = i;
        this.L = i2;
        this.k = str;
    }

    public static List<LatLng> o(String str) throws com.amap.api.col.p0003l.ex {
        JSONArray jSONArrayOptJSONArray;
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("data") && (jSONArrayOptJSONArray = jSONObject.optJSONObject("data").optJSONArray("points")) != null && jSONArrayOptJSONArray.length() != 0) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    arrayList.add(new LatLng(Double.parseDouble(jSONObjectOptJSONObject.optString("y")), Double.parseDouble(jSONObjectOptJSONObject.optString("x"))));
                }
                return arrayList;
            }
            return arrayList;
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.col.p0003l.ez, com.amap.api.col.p0003l.ey
    public final /* synthetic */ Object a(String str) throws com.amap.api.col.p0003l.ex {
        return o(str);
    }

    @Override // com.amap.api.col.p0003l.ez, com.amap.api.col.p0003l.ey
    public final String c() {
        JSONArray jSONArray = new JSONArray();
        long j = 0;
        for (int i = 0; i < this.f15924a.size(); i++) {
            TraceLocation traceLocation = this.f15924a.get(i);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("x", traceLocation.getLongitude());
                jSONObject.put("y", traceLocation.getLatitude());
                jSONObject.put("ag", (int) traceLocation.getBearing());
                long time = traceLocation.getTime();
                if (i == 0) {
                    if (time == 0) {
                        time = (System.currentTimeMillis() - 10000) / 1000;
                    }
                    jSONObject.put(RVParams.TOOLBAR_MENU, time / 1000);
                } else if (time != 0) {
                    long j2 = time - j;
                    if (j2 < 1000) {
                        jSONObject.put(RVParams.TOOLBAR_MENU, 1);
                    } else {
                        jSONObject.put(RVParams.TOOLBAR_MENU, j2 / 1000);
                    }
                } else {
                    jSONObject.put(RVParams.TOOLBAR_MENU, 1);
                }
                j = time;
                jSONObject.put(RVParams.SHOW_PROGRESS, (int) traceLocation.getSpeed());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jSONArray.put(jSONObject);
        }
        ((com.amap.api.col.p0003l.ey) this).f = getURL() + "&" + jSONArray.toString();
        return jSONArray.toString();
    }

    @Override // com.amap.api.col.p0003l.hs
    public final String getIPV6URL() {
        return zwa.y(getURL());
    }

    @Override // com.amap.api.col.p0003l.hs
    public final String getURL() {
        String str = "key=" + j4b.j(((com.amap.api.col.p0003l.ey) this).b);
        String strA = l4b.a();
        return "http://restsdk.amap.com/v4/grasproad/driving?" + str + "&ts=".concat(String.valueOf(strA)) + "&scode=".concat(String.valueOf(l4b.c(((com.amap.api.col.p0003l.ey) this).b, strA, str)));
    }

    @Override // com.amap.api.col.p0003l.hs
    public final boolean isSupportIPV6() {
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        new ArrayList();
        try {
            try {
                h4b.b().e(this.k, this.L, m());
                h4b.b().a(this.k).b(this.f41105a);
            } catch (com.amap.api.col.p0003l.ex e) {
                h4b.b();
                h4b.c(this.f41105a, this.M, e.a());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

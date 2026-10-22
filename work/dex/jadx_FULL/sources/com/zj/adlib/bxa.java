package com.zj.adlib;

import android.content.Context;
import android.util.Log;
import com.amap.api.col.p0003l.ea;
import com.amap.api.col.p0003l.fh;
import com.amap.api.col.p0003l.r;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.PolylineOptions;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class bxa {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Map<String, ea> f15653a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f40858a = "";

    public static void a() {
        try {
            if (axa.f15410a) {
                Iterator<Map.Entry<String, ea>> it = f15653a.entrySet().iterator();
                while (it.hasNext()) {
                    it.next().getValue().a();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void b(int i, String str, String str2) {
        if (i == 0) {
            Log.i("linklog", str + " " + str2);
            return;
        }
        Log.e("linklog", str + " " + str2);
    }

    public static void c(int i, String str, String str2, String str3, String str4) {
        Map<String, ea> map;
        ea eaVar;
        try {
            String str5 = str3 + str4;
            if (axa.f15411b) {
                b(i, str2, str5);
            }
            if (!axa.f15410a || (map = f15653a) == null || (eaVar = map.get(str)) == null) {
                return;
            }
            eaVar.a(i, str2, str5);
        } catch (Throwable unused) {
        }
    }

    public static void d(Context context) {
        if (context == null) {
            return;
        }
        try {
            k();
            r.c(zwa.t()).g(context.getApplicationContext());
        } catch (Throwable unused) {
        }
    }

    public static void e(String str, String str2) {
        c(0, "normal", f40858a, str, str2);
    }

    public static void f(String str, String str2, MarkerOptions markerOptions) {
        if (markerOptions == null) {
            m(str, str2);
            return;
        }
        m(str, str2 + " " + markerOptions.getPosition() + " " + markerOptions.getIcons());
    }

    public static void g(String str, String str2, PolygonOptions polygonOptions) {
        if (polygonOptions == null) {
            m(str, str2);
            return;
        }
        StringBuilder sb = new StringBuilder();
        List<LatLng> points = polygonOptions.getPoints();
        if (points != null) {
            sb.append("points size =");
            sb.append(points.size());
        }
        sb.append(";width=");
        sb.append(polygonOptions.getStrokeWidth());
        sb.append(";fillColor=");
        sb.append(polygonOptions.getFillColor());
        sb.append(";strokeColor=");
        sb.append(polygonOptions.getStrokeColor());
        sb.append(";visible=");
        sb.append(polygonOptions.isVisible());
        m(str, str2 + " " + sb.toString());
    }

    public static void h(String str, String str2, PolylineOptions polylineOptions) {
        if (polylineOptions == null) {
            m(str, str2);
            return;
        }
        StringBuilder sb = new StringBuilder();
        List<LatLng> points = polylineOptions.getPoints();
        if (points != null) {
            sb.append("points size =");
            sb.append(points.size());
        }
        sb.append(";width=");
        sb.append(polylineOptions.getWidth());
        sb.append(";color=");
        sb.append(polylineOptions.getColor());
        sb.append(";visible=");
        sb.append(polylineOptions.isVisible());
        m(str, str2 + " " + sb.toString());
    }

    public static void i(String str, String str2, List<MarkerOptions> list) {
        if (list != null) {
            Iterator<MarkerOptions> it = list.iterator();
            while (it.hasNext()) {
                f(str, str2, it.next());
            }
        }
    }

    public static void j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            boolean zX = fh.x(jSONObject.optString("able", ""), false);
            boolean zX2 = fh.x(jSONObject.optString("mobile", ""), false);
            boolean zX3 = fh.x(jSONObject.optString("debugupload", ""), false);
            boolean zX4 = fh.x(jSONObject.optString("debugwrite", ""), false);
            boolean zX5 = fh.x(jSONObject.optString("forcedUpload", ""), false);
            axa.f15410a = zX;
            boolean zX6 = fh.x(jSONObject.optString("di", ""), false);
            String strOptString = jSONObject.optString("dis", "");
            if (!zX6 || s4b.C(strOptString)) {
                r.c(zwa.t()).k(zX, zX2, zX4, zX3, Arrays.asList(jSONObject.optString("filter", "").split("&")));
                if (zX5) {
                    r.c(zwa.t()).j(zX5);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void k() {
        try {
            f15653a.put("overlay", new q0b());
            f15653a.put("normal", new p0b());
        } catch (Throwable unused) {
        }
    }

    public static void l(String str, String str2) {
        c(1, "normal", f40858a, str, str2);
    }

    public static void m(String str, String str2) {
        c(1, "overlay", f40858a, str, str2);
    }
}

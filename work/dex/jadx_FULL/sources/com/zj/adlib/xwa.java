package com.zj.adlib;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class xwa {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f20746a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static boolean f20747b = false;
    public static boolean c = false;
    public static boolean d = false;
    public static boolean e = false;
    public static boolean f = false;
    public static boolean g = false;
    public static boolean h = false;
    public static boolean i = false;
    public static boolean j = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap<String, Boolean> f45909a = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static ConcurrentHashMap<Integer, Integer> f20745a = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<Integer, Integer> b = new ConcurrentHashMap<>();

    public static <T> String a(Map<String, T> map) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(bv9.b);
            for (Map.Entry<String, T> entry : map.entrySet()) {
                sb.append("\"" + entry.getKey() + "\":");
                sb.append(entry.getValue());
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            sb.append("}");
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String b(boolean z) {
        try {
            return "{\"Quest\":" + z + "}";
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void c(Context context) {
        if (c) {
            return;
        }
        try {
            HashMap map = new HashMap();
            map.put("amap_3dmap_heatmap", 1);
            i(context, "O009", a(map));
            c = true;
        } catch (Throwable unused) {
        }
    }

    public static void d(Context context, int i2) {
        try {
            HashMap map = new HashMap();
            map.put("amap_3dmap_draw_fail", Integer.valueOf(i2));
            i(context, "O023", a(map));
        } catch (Throwable unused) {
        }
    }

    public static void e(Context context, int i2, int i3, String str) {
        if (context == null) {
            return;
        }
        try {
            synchronized (f20745a) {
                if (!f20745a.containsKey(Integer.valueOf(i2)) || f20745a.get(Integer.valueOf(i2)).intValue() < 2) {
                    HashMap map = new HashMap();
                    map.put("amap_3dmap_map_request_type", String.valueOf(i3));
                    map.put("amap_3dmap_map_request_info", str);
                    i(context, "O019", a(map));
                    if (f20745a.containsKey(Integer.valueOf(i2))) {
                        f20745a.put(Integer.valueOf(i2), Integer.valueOf(f20745a.get(Integer.valueOf(i2)).intValue() + 1));
                    } else {
                        f20745a.put(Integer.valueOf(i2), 0);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void f(Context context, int i2, long j2, long j3) {
        try {
            synchronized (b) {
                if (!b.containsKey(Integer.valueOf(i2)) || b.get(Integer.valueOf(i2)).intValue() < 2) {
                    HashMap map = new HashMap();
                    map.put("amap_3dmap_map_request_rendertime", Long.valueOf(j2));
                    map.put("amap_3dmap_map_request_size", Long.valueOf(j3));
                    i(context, "O020", a(map));
                    if (b.containsKey(Integer.valueOf(i2))) {
                        b.put(Integer.valueOf(i2), Integer.valueOf(b.get(Integer.valueOf(i2)).intValue() + 1));
                    } else {
                        b.put(Integer.valueOf(i2), 0);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void g(Context context, long j2) {
        try {
            HashMap map = new HashMap();
            map.put("amap_3dmap_rendertime", Long.valueOf(j2));
            map.put("amap_3dmap_render_background", 0L);
            i(context, "O005", a(map));
        } catch (Throwable unused) {
        }
    }

    public static synchronized void h(Context context, String str) {
        try {
            if (f45909a != null && !TextUtils.isEmpty(str)) {
                if (f45909a.containsKey(str) && f45909a.get(str).booleanValue()) {
                    return;
                }
                HashMap map = new HashMap();
                map.put("amap_3dmap_coordinate", str);
                i(context, "O008", a(map));
                if (!f45909a.containsKey(str)) {
                    f45909a.put(str, Boolean.TRUE);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void i(Context context, String str, String str2) {
        if (context == null) {
            return;
        }
        try {
            lbb lbbVar = new lbb(context, "3dmap", "9.5.0", str);
            lbbVar.a(str2);
            mbb.d(lbbVar, context);
        } catch (Throwable unused) {
        }
    }

    public static void j(Context context, boolean z) {
        try {
            String strB = b(z);
            lbb lbbVar = new lbb(context, "3dmap", "9.5.0", "O001");
            lbbVar.a(strB);
            mbb.d(lbbVar, context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void k(Context context) {
        if (d) {
            return;
        }
        try {
            HashMap map = new HashMap();
            map.put("amap_3dmap_offlinemap", 1);
            i(context, "O010", a(map));
            d = true;
        } catch (Throwable unused) {
        }
    }

    public static void l(Context context, String str) {
        try {
            HashMap map = new HashMap();
            map.put("amap_3dmap_engine_init_fail", str);
            i(context, "O021", a(map));
        } catch (Throwable unused) {
        }
    }

    public static void m(Context context, boolean z) {
        if (f20746a) {
            return;
        }
        try {
            HashMap map = new HashMap();
            map.put("amap_3dmap_stylemap", Integer.valueOf(z ? 1 : 0));
            i(context, "O006", a(map));
            f20746a = true;
        } catch (Throwable unused) {
        }
    }

    public static void n(Context context) {
        if (e) {
            return;
        }
        try {
            HashMap map = new HashMap();
            map.put("amap_3dmap_particleoverlay", 1);
            i(context, "O011", a(map));
            e = true;
        } catch (Throwable unused) {
        }
    }

    public static void o(Context context, String str) {
        try {
            HashMap map = new HashMap();
            map.put("amap_3dmap_res_load_fail", str);
            i(context, "O022", a(map));
        } catch (Throwable unused) {
        }
    }

    public static void p(Context context, boolean z) {
        if (f20747b) {
            return;
        }
        try {
            HashMap map = new HashMap();
            map.put("amap_3dmap_indoormap", Integer.valueOf(z ? 1 : 0));
            i(context, "O007", a(map));
            f20747b = true;
        } catch (Throwable unused) {
        }
    }

    public static void q(Context context) {
        if (g) {
            return;
        }
        try {
            HashMap map = new HashMap();
            map.put("amap_3dmap_bzmapreview", 1);
            i(context, "O012", a(map));
            g = true;
        } catch (Throwable unused) {
        }
    }

    public static void r(Context context) {
        if (h) {
            return;
        }
        try {
            HashMap map = new HashMap();
            map.put("amap_3dmap_wxmapreview", 1);
            i(context, "O013", a(map));
            h = true;
        } catch (Throwable unused) {
        }
    }

    public static void s(Context context) {
        if (i) {
            return;
        }
        try {
            HashMap map = new HashMap();
            map.put("amap_3dmap_dxmapreview", 1);
            i(context, "0016", a(map));
            i = true;
        } catch (Throwable unused) {
        }
    }

    public static void t(Context context) {
        if (f) {
            return;
        }
        try {
            HashMap map = new HashMap();
            map.put("amap_3dmap_renderfps", 1);
            i(context, "O014", a(map));
            f = true;
        } catch (Throwable unused) {
        }
    }

    public static void u(Context context) {
        if (j) {
            return;
        }
        try {
            HashMap map = new HashMap();
            map.put("amap_3dmap_buildingoverlay", 1);
            i(context, "O015", a(map));
            j = true;
        } catch (Throwable unused) {
        }
    }
}

package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.zj.adlib.m4b;
import com.zj.adlib.phb;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class f {
    private static f f;
    private static long i;
    private File d;
    private String e;
    private Context g;
    private boolean h;
    private LinkedHashMap<String, Long> c = new LinkedHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f26204a = "";
    String b = null;

    private f(Context context) {
        this.e = null;
        Context applicationContext = context.getApplicationContext();
        this.g = applicationContext;
        String path = applicationContext.getFilesDir().getPath();
        if (this.e == null) {
            this.e = i.l(this.g);
        }
        try {
            this.d = new File(path, "reportRecorder");
        } catch (Throwable th) {
            phb.a(th);
        }
        c();
    }

    public static synchronized f a(Context context) {
        if (f == null) {
            f = new f(context);
        }
        return f;
    }

    private synchronized void c() {
        LinkedHashMap<String, Long> linkedHashMap = this.c;
        if (linkedHashMap == null || linkedHashMap.size() <= 0) {
            try {
                this.f26204a = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
                Iterator<String> it = i.a(this.d).iterator();
                while (it.hasNext()) {
                    try {
                        try {
                            String[] strArrSplit = new String(com.autonavi.aps.amapapi.security.a.b(m4b.g(it.next()), this.e), "UTF-8").split(",");
                            if (strArrSplit != null && strArrSplit.length > 1) {
                                this.c.put(strArrSplit[0], Long.valueOf(Long.parseLong(strArrSplit[1])));
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    private void d() {
        try {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Long> entry : this.c.entrySet()) {
                try {
                    sb.append(m4b.f(com.autonavi.aps.amapapi.security.a.a((entry.getKey() + "," + entry.getValue()).getBytes("UTF-8"), this.e)) + "\n");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            String string = sb.toString();
            if (TextUtils.isEmpty(string)) {
                return;
            }
            i.a(this.d, string);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final synchronized void b() {
        try {
            if (b(this.g)) {
                for (Map.Entry<String, Long> entry : this.c.entrySet()) {
                    try {
                        if (!this.f26204a.equals(entry.getKey())) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("param_long_first", entry.getKey());
                            jSONObject.put("param_long_second", entry.getValue());
                            g.a(this.g, "O023", jSONObject);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final synchronized void a() {
        if (this.h) {
            d();
            this.h = false;
        }
    }

    public final synchronized void a(AMapLocation aMapLocation) {
        try {
            if ((!this.c.containsKey(this.f26204a) && this.c.size() >= 8) || (this.c.containsKey(this.f26204a) && this.c.size() >= 9)) {
                ArrayList arrayList = new ArrayList();
                Iterator<Map.Entry<String, Long>> it = this.c.entrySet().iterator();
                while (it.hasNext()) {
                    try {
                        arrayList.add(it.next().getKey());
                        if (arrayList.size() == this.c.size() - 7) {
                            break;
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    this.c.remove((String) it2.next());
                }
            }
            if (aMapLocation.getErrorCode() != 0) {
                return;
            }
            if (aMapLocation.getLocationType() != 6 && aMapLocation.getLocationType() != 5) {
                if (this.c.containsKey(this.f26204a)) {
                    long jLongValue = this.c.get(this.f26204a).longValue() + 1;
                    i = jLongValue;
                    this.c.put(this.f26204a, Long.valueOf(jLongValue));
                } else {
                    this.c.put(this.f26204a, 1L);
                    i = 1L;
                }
                long j = i;
                if (j != 0 && j % 100 == 0) {
                    a();
                }
                this.h = true;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private boolean b(Context context) {
        if (this.b == null) {
            this.b = h.a(context, "pref", "lastavedate", "0");
        }
        if (this.b.equals(this.f26204a)) {
            return false;
        }
        SharedPreferences.Editor editorA = h.a(context, "pref");
        h.a(editorA, "lastavedate", this.f26204a);
        h.a(editorA);
        this.b = this.f26204a;
        return true;
    }
}

package com.zj.adlib;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.SystemClock;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.amap.api.col.p0003l.ff;
import com.amap.api.col.p0003l.fh;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class g9b {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static volatile ConcurrentHashMap<String, c> f16729a = new ConcurrentHashMap<>(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile List<String> f41849a = Collections.synchronizedList(new ArrayList(8));

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static volatile ConcurrentHashMap<String, b> f16730b = new ConcurrentHashMap<>(8);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Random f16728a = new Random();
    public static ConcurrentHashMap<String, String> c = new ConcurrentHashMap<>(8);
    public static List<lbb> b = Collections.synchronizedList(new ArrayList(16));

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public double f41850a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int f16731a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f16732a;

        public a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f41851a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public i9b f16733a;

        public b() {
        }

        public /* synthetic */ b(byte b) {
            this();
        }
    }

    public static synchronized String a(String str, String str2) throws ff {
        try {
            try {
                System.currentTimeMillis();
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                    Context context = fh.f838a;
                    try {
                        if (f41849a == null) {
                            f41849a = Collections.synchronizedList(new ArrayList(8));
                        }
                        if (context != null && !f41849a.contains(str2)) {
                            f41849a.add(str2);
                            String strC = r8b.c(context, "Yb3Blbl9odHRwX2NvbnRyb2w", str2);
                            if (!TextUtils.isEmpty(strC)) {
                                h(str2, new JSONObject(strC));
                            }
                        }
                    } catch (Throwable th) {
                        v6b.b(th, "hlUtil", "llhl");
                    }
                    if (f16729a != null && f16729a.size() > 0) {
                        if (!f16729a.containsKey(str2)) {
                            return str;
                        }
                        c cVar = f16729a.get(str2);
                        if (cVar == null) {
                            return str;
                        }
                        if (m(str, cVar, str2)) {
                            throw new ff("服务QPS超限");
                        }
                        return p(str, cVar, str2);
                    }
                    return str;
                }
                return str;
            } catch (Throwable th2) {
                throw th2;
            }
        } catch (ff e) {
            throw e;
        } catch (Throwable th3) {
            v6b.b(th3, "hlUtil", "pcr");
            return str;
        }
    }

    public static void b() {
        try {
            Context context = fh.f838a;
            if (context == null) {
                return;
            }
            mbb.e(q(), context);
        } catch (Throwable unused) {
        }
    }

    public static synchronized void c(r4b r4bVar, JSONObject jSONObject) {
        if (r4bVar == null) {
            return;
        }
        try {
            String strA = r4bVar.a();
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            if (jSONObject == null) {
                e(strA);
            }
            if (!fh.x(jSONObject.optString("able", null), false)) {
                e(strA);
            } else {
                r8b.d(fh.f838a, "Yb3Blbl9odHRwX2NvbnRyb2w", strA, jSONObject.toString());
                h(strA, jSONObject);
            }
        } catch (Throwable th) {
            v6b.b(th, "hlUtil", "par");
        }
    }

    public static void d(c cVar, JSONObject jSONObject) {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("block");
            if (jSONArrayOptJSONArray == null) {
                return;
            }
            HashMap map = new HashMap(8);
            byte b2 = 0;
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("api");
                    if (!TextUtils.isEmpty(strOptString)) {
                        if (!strOptString.startsWith(WVNativeCallbackUtil.SEPERATER)) {
                            strOptString = WVNativeCallbackUtil.SEPERATER.concat(strOptString);
                        }
                        if (strOptString.endsWith(WVNativeCallbackUtil.SEPERATER)) {
                            strOptString = strOptString.substring(0, strOptString.length() - 1);
                        }
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("periods");
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i2);
                            if (jSONObjectOptJSONObject2 != null) {
                                a aVar = new a(b2);
                                aVar.f16732a = jSONObjectOptJSONObject2.optString(nd9.f18397d);
                                aVar.f16731a = jSONObjectOptJSONObject2.optInt("duration");
                                aVar.f41850a = jSONObjectOptJSONObject2.optDouble("percent");
                                arrayList.add(aVar);
                            }
                        }
                        map.put(strOptString, arrayList);
                    }
                }
            }
            cVar.f41852a = map;
        } catch (Throwable th) {
            v6b.b(th, "hlUtil", "pbr");
        }
    }

    public static synchronized void e(String str) {
        try {
            if (f16729a.containsKey(str)) {
                f16729a.remove(str);
            }
            SharedPreferences.Editor editorB = r8b.b(fh.f838a, "Yb3Blbl9odHRwX2NvbnRyb2w");
            r8b.f(editorB, str);
            r8b.e(editorB);
        } catch (Throwable th) {
            v6b.b(th, "hlUtil", "rc");
        }
    }

    public static void f(String str, c cVar) {
        try {
            if (f16729a == null) {
                f16729a = new ConcurrentHashMap<>(8);
            }
            f16729a.put(str, cVar);
        } catch (Throwable th) {
            v6b.b(th, "hlUtil", "ucr");
        }
    }

    public static void g(String str, String str2, String str3) {
        try {
            Context context = fh.f838a;
            if (context != null && !TextUtils.isEmpty(str)) {
                if (c == null) {
                    c = new ConcurrentHashMap<>(8);
                }
                synchronized (c) {
                    if (c.containsKey(str2)) {
                        return;
                    }
                    c.put(str2, str3);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("timestamp", System.currentTimeMillis());
                    jSONObject.put("type", s6b.e);
                    jSONObject.put("name", str);
                    jSONObject.put("version", s6b.a(str));
                    jSONObject.put("hostname", str2 + "#" + str3);
                    String string = jSONObject.toString();
                    if (TextUtils.isEmpty(string)) {
                        return;
                    }
                    lbb lbbVar = new lbb(context, "core", "2.0", "O005");
                    lbbVar.a(string);
                    mbb.d(lbbVar, context);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void h(String str, JSONObject jSONObject) {
        try {
            c cVar = new c((byte) 0);
            d(cVar, jSONObject);
            r(cVar, jSONObject);
            if (cVar.b == null && cVar.f41852a == null) {
                e(str);
            } else {
                f(str, cVar);
            }
        } catch (Throwable unused) {
        }
    }

    public static void i(URL url, i9b i9bVar) {
        List<String> list;
        try {
            if (f16730b == null) {
                f16730b = new ConcurrentHashMap<>(8);
            }
            Map<String, List<String>> map = i9bVar.f17169a;
            if (map != null && map.containsKey("nb") && (list = i9bVar.f17169a.get("nb")) != null && list.size() > 0) {
                byte b2 = 0;
                String[] strArrSplit = list.get(0).split("#");
                if (strArrSplit.length < 2) {
                    return;
                }
                int i = Integer.parseInt(strArrSplit[0]);
                long j = Integer.parseInt(strArrSplit[1]);
                b bVar = new b(b2);
                bVar.f16733a = i9bVar;
                if (j <= 0) {
                    j = 30;
                }
                bVar.f41851a = SystemClock.elapsedRealtime() + (j * 1000);
                if (i == 1) {
                    f16730b.put(NativeCallContext.DOMAIN_APP, bVar);
                } else {
                    if (i != 2 || url == null) {
                        return;
                    }
                    f16730b.put(url.getPath(), bVar);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void j(boolean z, String str) {
        try {
            Context context = fh.f838a;
            if (context != null && !TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                if (z) {
                    jSONObject.put("type", s6b.b);
                } else {
                    jSONObject.put("type", s6b.f44621a);
                }
                jSONObject.put("name", str);
                jSONObject.put("version", s6b.a(str));
                String string = jSONObject.toString();
                lbb lbbVar = new lbb(context, "core", "2.0", "O005");
                lbbVar.a(string);
                mbb.d(lbbVar, context);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void k(boolean z, String str, String str2, int i) {
        Context context = fh.f838a;
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("timestamp", System.currentTimeMillis());
            String strA = s6b.a(str);
            if (z) {
                jSONObject.put("type", s6b.d);
            } else {
                jSONObject.put("type", s6b.c);
            }
            jSONObject.put("name", str);
            jSONObject.put("version", strA);
            jSONObject.put("uri", Uri.parse(str2).getPath());
            jSONObject.put("blockLevel", i);
            String string = jSONObject.toString();
            if (TextUtils.isEmpty(string)) {
                return;
            }
            lbb lbbVar = new lbb(context, "core", "2.0", "O005");
            lbbVar.a(string);
            if (b == null) {
                b = Collections.synchronizedList(new ArrayList(16));
            }
            synchronized (b) {
                try {
                    b.add(lbbVar);
                    if (b.size() >= 15) {
                        b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static boolean l(a aVar) {
        if (aVar == null || aVar.f41850a == 1.0d) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(aVar.f16732a) && aVar.f16731a > 0) {
            long timeInMillis = jCurrentTimeMillis - s4b.i(aVar.f16732a, "HH:mm:ss").getTimeInMillis();
            if (timeInMillis > 0 && timeInMillis < aVar.f16731a * 1000) {
                if (aVar.f41850a == AudioStats.AUDIO_AMPLITUDE_NONE) {
                    return true;
                }
                if (f16728a == null) {
                    f16728a = new Random();
                }
                f16728a.setSeed(((long) UUID.randomUUID().hashCode()) + jCurrentTimeMillis);
                if (f16728a.nextDouble() > aVar.f41850a) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean m(String str, c cVar, String str2) {
        try {
            Map<String, List<a>> map = cVar.f41852a;
            if (map != null && map.size() > 0) {
                if (map.containsKey("*")) {
                    Iterator<Map.Entry<String, List<a>>> it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        if (n(it.next().getValue())) {
                            k(false, str2, str, 1);
                            return true;
                        }
                    }
                } else {
                    String path = Uri.parse(str).getPath();
                    if (map.containsKey(path) && n(map.get(path))) {
                        k(false, str2, str, 2);
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            v6b.b(th, "hlUtil", "inb");
        }
    }

    public static boolean n(List<a> list) {
        if (list != null && list.size() > 0) {
            Iterator<a> it = list.iterator();
            while (it.hasNext()) {
                if (l(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static i9b o(String str, String str2) {
        Uri uri;
        try {
            if (f16730b == null) {
                return null;
            }
            if (f16730b.containsKey(NativeCallContext.DOMAIN_APP)) {
                b bVar = f16730b.get(NativeCallContext.DOMAIN_APP);
                if (SystemClock.elapsedRealtime() <= bVar.f41851a) {
                    i9b i9bVar = bVar.f16733a;
                    if (i9bVar != null) {
                        i9bVar.f17170a = false;
                    }
                    k(true, str2, str, 1);
                    return i9bVar;
                }
                f16730b.remove(NativeCallContext.DOMAIN_APP);
            } else if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null) {
                String path = uri.getPath();
                if (f16730b.containsKey(path)) {
                    b bVar2 = f16730b.get(path);
                    if (SystemClock.elapsedRealtime() <= bVar2.f41851a) {
                        i9b i9bVar2 = bVar2.f16733a;
                        if (i9bVar2 != null) {
                            i9bVar2.f17170a = false;
                        }
                        k(true, str2, str, 2);
                        return i9bVar2;
                    }
                    f16730b.remove(path);
                }
            }
            return null;
        } catch (Throwable unused) {
        }
    }

    public static String p(String str, c cVar, String str2) {
        try {
            Map<String, String> map = cVar.b;
            if (map != null && map.size() > 0) {
                Uri uri = Uri.parse(str);
                String authority = uri.getAuthority();
                if (!map.containsKey(authority)) {
                    return str;
                }
                String str3 = map.get(authority);
                str = uri.buildUpon().authority(str3).toString();
                g(str2, authority, str3);
                return str;
            }
            return str;
        } catch (Throwable th) {
            v6b.b(th, "hlUtil", "pdr");
            return str;
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x0028 */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0024, code lost:
    
        r0 = th;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<lbb> q() {
        ArrayList arrayList;
        Throwable th;
        ArrayList arrayList2 = null;
        try {
            synchronized (b) {
                try {
                    List<lbb> list = b;
                    if (list != null && list.size() > 0) {
                        arrayList = new ArrayList();
                        arrayList.addAll(b);
                        b.clear();
                        arrayList2 = arrayList;
                    }
                    return arrayList2;
                } catch (Throwable th2) {
                    arrayList = arrayList2;
                    th = th2;
                }
            }
            while (true) {
                try {
                    break;
                } catch (Throwable unused) {
                    return arrayList;
                }
            }
            throw th;
            while (true) {
                break;
                break;
            }
            throw th;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static void r(c cVar, JSONObject jSONObject) {
        JSONArray jSONArrayNames;
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("domainMap");
            if (jSONObjectOptJSONObject == null || (jSONArrayNames = jSONObjectOptJSONObject.names()) == null) {
                return;
            }
            HashMap map = new HashMap(8);
            int length = jSONArrayNames.length();
            for (int i = 0; i < length; i++) {
                String strOptString = jSONArrayNames.optString(i);
                map.put(strOptString, jSONObjectOptJSONObject.optString(strOptString));
            }
            cVar.b = map;
        } catch (Throwable th) {
            v6b.b(th, "hlUtil", "pdr");
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map<String, List<a>> f41852a;
        public Map<String, String> b;

        public c() {
            this.f41852a = new HashMap(8);
            this.b = new HashMap(8);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && c.class == obj.getClass()) {
                c cVar = (c) obj;
                if (this.f41852a.equals(cVar.f41852a) && this.b.equals(cVar.b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            Map<String, List<a>> map = this.f41852a;
            int iHashCode = map != null ? map.hashCode() : 0;
            Map<String, String> map2 = this.b;
            return iHashCode + (map2 != null ? map2.hashCode() : 0);
        }

        public /* synthetic */ c(byte b) {
            this();
        }
    }
}

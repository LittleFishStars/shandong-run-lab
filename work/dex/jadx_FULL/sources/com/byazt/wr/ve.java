package com.byazt.wr;

import android.content.SharedPreferences;
import com.byazt.bwm.x;
import com.byazt.dna.z;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1361, 54})
public class ve implements com.byazt.iy.n {
    public static ThreadPoolExecutor c = null;
    public static int tt = 3;
    public long i;
    public long sl;
    public final com.byazt.yy.tt t;
    public final File uj;
    public final File ve;
    public volatile boolean x;
    public final boolean yp;
    public final Object n = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f29166a = new ConcurrentHashMap();
    public Map<String, Object> sp = new HashMap();
    public final List<Runnable> da = new ArrayList();
    public AtomicBoolean u = new AtomicBoolean(false);

    @com.byazt.zqa.c(c = {0, 1, 1361, 24})
    public final class c implements SharedPreferences.Editor {
        public c() {
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            ve.this.apply();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            try {
                ve.ve(ve.this);
                ve.this.sp.clear();
            } catch (Exception unused) {
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            ve.this.c(str, Boolean.valueOf(z));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            ve.this.c(str, Float.valueOf(f));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            ve.this.c(str, Integer.valueOf(i));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            ve.this.c(str, Long.valueOf(j));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            ve.this.c(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            ve.this.c(str, set);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            ve.this.remove(str);
            return this;
        }
    }

    public ve(File file, com.byazt.yy.c cVar, com.byazt.yy.tt ttVar, boolean z) {
        this.x = false;
        this.yp = z;
        File file2 = new File(file.getParent(), file.getName() + ".prop");
        if (file2.exists() && file2.length() > 0) {
            cVar = new com.byazt.wr.c(null);
            file = file2;
        }
        this.ve = file;
        this.uj = new File(file.getPath() + ".bak");
        this.x = false;
        cVar = cVar == null ? new com.byazt.wr.c(null) : cVar;
        if (ttVar == null) {
            this.t = new com.byazt.wr.c(null);
        } else {
            this.t = ttVar;
        }
        c(cVar);
    }

    public static /* synthetic */ long ve(ve veVar) {
        long j = veVar.i;
        veVar.i = 1 + j;
        return j;
    }

    @Override // com.byazt.iy.n
    public void apply() {
        if (!this.x) {
            if (this.u.compareAndSet(false, true)) {
                c(new Runnable() { // from class: com.byazt.wr.ve.3
                    @Override // java.lang.Runnable
                    public void run() {
                        ve.this.u.set(false);
                        ve.this.apply();
                    }
                });
            }
        } else if (this.sl != this.i && this.u.compareAndSet(false, true)) {
            ve().execute(new Runnable() { // from class: com.byazt.wr.ve.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Map<String, Object> mapN = ve.this.n();
                        if (mapN != null) {
                            ve.this.t.c(mapN, ve.this.ve);
                        }
                        ve.this.u.set(false);
                    } catch (Exception e) {
                        ve.this.c("apply write error", (Throwable) e);
                    }
                }
            });
        }
    }

    @Override // com.byazt.iy.n
    public void applySync() {
        if (!this.x) {
            if (this.u.compareAndSet(false, true)) {
                c(new Runnable() { // from class: com.byazt.wr.ve.5
                    @Override // java.lang.Runnable
                    public void run() {
                        ve.this.u.set(false);
                        ve.this.applySync();
                    }
                });
            }
        } else if (this.u.compareAndSet(false, true)) {
            try {
                Map<String, Object> mapN = n();
                if (mapN != null) {
                    this.t.c(mapN, this.ve);
                }
                this.u.set(false);
            } catch (Exception e) {
                c("applySync write error", (Throwable) e);
            }
        }
    }

    @Override // com.byazt.iy.n
    public void clear() {
        if (!this.x) {
            c(new Runnable() { // from class: com.byazt.wr.ve.2
                @Override // java.lang.Runnable
                public void run() {
                    ve.this.f29166a.clear();
                    synchronized ("SharedPreferencesImpl") {
                        ve.this.sp.clear();
                        ve.ve(ve.this);
                    }
                }
            });
            return;
        }
        this.f29166a.clear();
        synchronized ("SharedPreferencesImpl") {
            this.sp.clear();
            this.i++;
        }
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public boolean contains(String str) {
        boolean zContainsKey;
        if (str == null) {
            str = "";
        }
        synchronized (this.n) {
            tt();
            zContainsKey = this.f29166a.containsKey(str);
        }
        return zContainsKey;
    }

    @Override // com.byazt.iy.n
    public int get(String str, int i) {
        return getInt(str, i);
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        Map<String, ?> mapUj;
        if (!this.yp) {
            return uj();
        }
        synchronized (this.n) {
            tt();
            mapUj = uj();
        }
        return mapUj;
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        boolean zC;
        if (str == null) {
            str = "";
        }
        if (!this.yp) {
            return c(str, z);
        }
        synchronized (this.n) {
            tt();
            zC = c(str, z);
        }
        return zC;
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        float fC;
        if (str == null) {
            str = "";
        }
        if (!this.yp) {
            return c(str, f);
        }
        synchronized (this.n) {
            tt();
            fC = c(str, f);
        }
        return fC;
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public int getInt(String str, int i) {
        int iC;
        if (str == null) {
            str = "";
        }
        if (!this.yp) {
            return c(str, i);
        }
        synchronized (this.n) {
            tt();
            iC = c(str, i);
        }
        return iC;
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public long getLong(String str, long j) {
        long jC;
        if (str == null) {
            str = "";
        }
        if (!this.yp) {
            return c(str, j);
        }
        synchronized (this.n) {
            tt();
            jC = c(str, j);
        }
        return jC;
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public String getString(String str, String str2) {
        String strC;
        if (str == null) {
            str = "";
        }
        if (!this.yp) {
            return c(str, str2);
        }
        synchronized (this.n) {
            tt();
            strC = c(str, str2);
        }
        return strC;
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> setC;
        if (str == null) {
            str = "";
        }
        if (!this.yp) {
            return c(str, set);
        }
        synchronized (this.n) {
            tt();
            setC = c(str, set);
        }
        return setC;
    }

    @Override // com.byazt.iy.n
    public void put(String str, int i) {
        c(str, Integer.valueOf(i));
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // com.byazt.iy.n
    public void remove(String str) {
        synchronized ("SharedPreferencesImpl") {
            this.sp.put(str, null);
            this.i++;
        }
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> n() {
        HashMap map;
        synchronized ("SharedPreferencesImpl") {
            map = new HashMap(this.sp);
            this.sp = new HashMap();
        }
        HashMap map2 = new HashMap(this.f29166a);
        if (map.isEmpty() && map2.isEmpty()) {
            return map2;
        }
        int i = 0;
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            Object obj = map2.get(str);
            if (value == null) {
                if (obj != null) {
                    map2.remove(str);
                    i++;
                }
            } else if (!value.equals(obj)) {
                map2.put(str, value);
                i++;
            }
        }
        if (i > 0) {
            return map2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(com.byazt.yy.c cVar) {
        Map<String, Object> mapC;
        synchronized (this.n) {
            if (this.x) {
                return;
            }
            if (this.uj.exists()) {
                this.ve.delete();
                this.uj.renameTo(this.ve);
            }
            try {
                mapC = cVar.c(this.ve);
            } catch (Throwable th) {
                c("loadFromDisk error", th);
                mapC = null;
            }
            synchronized (this.n) {
                try {
                    this.x = true;
                    if (mapC != null) {
                        try {
                            for (Map.Entry<String, Object> entry : mapC.entrySet()) {
                                Object value = entry.getValue();
                                if (value != null) {
                                    String key = entry.getKey();
                                    if (key == null) {
                                        key = "";
                                    }
                                    this.f29166a.put(key, value);
                                }
                            }
                        } catch (Throwable th2) {
                            this.n.notifyAll();
                            throw th2;
                        }
                    }
                    this.n.notifyAll();
                } catch (Throwable th3) {
                    throw th3;
                }
            }
            synchronized (this.da) {
                Iterator<Runnable> it = this.da.iterator();
                while (it.hasNext()) {
                    it.next().run();
                }
                this.da.clear();
            }
        }
    }

    private Map<String, ?> uj() {
        HashMap map = new HashMap(this.f29166a);
        map.putAll(this.sp);
        return map;
    }

    private static ThreadPoolExecutor ve() {
        ThreadPoolExecutor threadPoolExecutor = c;
        if (threadPoolExecutor != null) {
            return threadPoolExecutor;
        }
        synchronized (ve.class) {
            ThreadPoolExecutor threadPoolExecutor2 = c;
            if (threadPoolExecutor2 != null) {
                return threadPoolExecutor2;
            }
            int i = tt;
            com.byazt.jtc.uj ujVar = new com.byazt.jtc.uj(i, i, 1000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new x("SharedPreferencesImpl"));
            c = ujVar;
            return ujVar;
        }
    }

    @Override // com.byazt.iy.n
    public long get(String str, long j) {
        return getLong(str, j);
    }

    @Override // com.byazt.iy.n
    public void put(String str, long j) {
        c(str, Long.valueOf(j));
    }

    @Override // com.byazt.iy.n
    public float get(String str, float f) {
        return getFloat(str, f);
    }

    @Override // com.byazt.iy.n
    public void put(String str, float f) {
        c(str, Float.valueOf(f));
    }

    @Override // com.byazt.iy.n
    public boolean get(String str, boolean z) {
        return getBoolean(str, z);
    }

    @Override // com.byazt.iy.n
    public void put(String str, boolean z) {
        c(str, Boolean.valueOf(z));
    }

    private void c(final com.byazt.yy.c cVar) {
        synchronized (this.n) {
            this.x = false;
        }
        ve().execute(new Runnable() { // from class: com.byazt.wr.ve.1
            @Override // java.lang.Runnable
            public void run() {
                ve.this.tt(cVar);
            }
        });
    }

    @Override // com.byazt.iy.n
    public String get(String str, String str2) {
        return getString(str, str2);
    }

    @Override // com.byazt.iy.n
    public void put(String str, String str2) {
        c(str, str2);
    }

    @Override // com.byazt.iy.n
    public Set<String> get(String str, Set<String> set) {
        return getStringSet(str, set);
    }

    @Override // com.byazt.iy.n
    public void put(String str, Set<String> set) {
        c(str, set);
    }

    private String c(String str, String str2) {
        try {
            Object obj = this.sp.get(str);
            if (obj == null) {
                obj = this.f29166a.get(str);
            }
            return obj != null ? String.valueOf(obj) : str2;
        } catch (Exception e) {
            c("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return str2;
        }
    }

    private Set<String> c(String str, Set<String> set) {
        try {
            Set<String> set2 = (Set) this.sp.get(str);
            if (set2 == null) {
                set2 = (Set) this.f29166a.get(str);
            }
            return set2 != null ? set2 : set;
        } catch (Exception e) {
            c("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return set;
        }
    }

    private int c(String str, int i) {
        try {
            Object obj = this.sp.get(str);
            if (obj == null) {
                obj = this.f29166a.get(str);
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
            if (obj instanceof Float) {
                return ((Float) obj).intValue();
            }
            return obj != null ? ((Integer) obj).intValue() : i;
        } catch (Exception e) {
            c("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return i;
        }
    }

    private long c(String str, long j) {
        try {
            Long l = (Long) this.sp.get(str);
            if (l == null) {
                l = (Long) this.f29166a.get(str);
            }
            return l != null ? l.longValue() : j;
        } catch (Exception e) {
            c("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return j;
        }
    }

    private void tt() {
        while (!this.x) {
            try {
                this.n.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    private float c(String str, float f) {
        try {
            Object obj = this.sp.get(str);
            if (obj == null) {
                obj = this.f29166a.get(str);
            }
            if (obj instanceof Integer) {
                return ((Integer) obj).floatValue();
            }
            if (obj instanceof Float) {
                return ((Float) obj).floatValue();
            }
            return obj != null ? ((Float) obj).floatValue() : f;
        } catch (Exception e) {
            c("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return f;
        }
    }

    private boolean c(String str, boolean z) {
        try {
            Boolean bool = (Boolean) this.sp.get(str);
            if (bool == null) {
                bool = (Boolean) this.f29166a.get(str);
            }
            return bool != null ? bool.booleanValue() : z;
        } catch (Exception e) {
            c("getValue error key =".concat(String.valueOf(str)), (Throwable) e);
            return z;
        }
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public c edit() {
        synchronized (this.n) {
            tt();
        }
        return new c();
    }

    private void c(Runnable runnable) {
        synchronized (this.da) {
            if (this.x) {
                runnable.run();
            } else {
                this.da.add(runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void c(String str, T t) {
        if (str == null) {
            str = "";
        }
        synchronized ("SharedPreferencesImpl") {
            this.sp.put(str, t);
            this.i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, Throwable th) {
        z zVar = (z) com.byazt.ut.uj.getService("event");
        if (zVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("file", this.ve.getAbsolutePath());
                jSONObject.put("msg", str);
                jSONObject.put(bolts.c.f, "SharedPreferencesImpl");
            } catch (JSONException unused) {
            }
            zVar.onExceptionEvent("kv", jSONObject, th);
        }
    }
}

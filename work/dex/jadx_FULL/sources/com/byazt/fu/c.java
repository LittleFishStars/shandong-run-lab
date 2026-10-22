package com.byazt.fu;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.byazt.iy.n;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.keva.KevaMonitor;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2145, 20})
public class c implements n {
    public Keva c;
    public static final Map<String, n> tt = new HashMap();
    public static volatile boolean ve = false;
    public static volatile boolean uj = true;

    private c(String str, boolean z, int i) {
        if (i != 1) {
            tt(str, z);
        } else {
            c(str, z);
        }
    }

    public static n c(Context context, String str, boolean z, int i) {
        if (!uj) {
            return null;
        }
        try {
            if (!ve) {
                ve = c(context);
            }
            if (TextUtils.isEmpty(str)) {
                str = "tt_ad_sdk_keva";
            }
            if (!uj) {
                return null;
            }
            Map<String, n> map = tt;
            n cVar = map.get(str);
            if (cVar == null) {
                cVar = new c(str, z, i);
                if (uj) {
                    map.put(str, cVar);
                }
            }
            if (uj) {
                return cVar;
            }
            return null;
        } catch (Throwable unused) {
            uj = false;
            return null;
        }
    }

    private void tt(String str, boolean z) {
        if (z) {
            this.c = Keva.getRepoSync(str, 1);
        } else {
            this.c = Keva.getRepoSync(str, 0);
        }
    }

    @Override // com.byazt.iy.n
    public void apply() {
    }

    @Override // com.byazt.iy.n
    public void applySync() {
    }

    @Override // com.byazt.iy.n
    public void clear() {
        this.c.clear();
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public boolean contains(String str) {
        return this.c.contains(str);
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return null;
    }

    @Override // com.byazt.iy.n
    public int get(String str, int i) {
        return getInt(str, i);
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.c.getAll();
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.c.getBoolean(str, z);
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.c.getFloat(str, f);
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.c.getInt(str, i);
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.c.getLong(str, j);
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public String getString(String str, String str2) {
        return this.c.getString(str, str2);
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return this.c.getStringSet(str, set);
    }

    @Override // com.byazt.iy.n
    public void put(String str, int i) {
        this.c.storeInt(str, i);
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // com.byazt.iy.n
    public void remove(String str) {
        this.c.erase(str);
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // com.byazt.iy.n
    public long get(String str, long j) {
        return getLong(str, j);
    }

    @Override // com.byazt.iy.n
    public void put(String str, long j) {
        this.c.storeLong(str, j);
    }

    @Override // com.byazt.iy.n
    public float get(String str, float f) {
        return getFloat(str, f);
    }

    @Override // com.byazt.iy.n
    public void put(String str, float f) {
        this.c.storeFloat(str, f);
    }

    @Override // com.byazt.iy.n
    public boolean get(String str, boolean z) {
        return getBoolean(str, z);
    }

    @Override // com.byazt.iy.n
    public void put(String str, boolean z) {
        this.c.storeBoolean(str, z);
    }

    @Override // com.byazt.iy.n
    public String get(String str, String str2) {
        return getString(str, str2);
    }

    @Override // com.byazt.iy.n
    public void put(String str, String str2) {
        this.c.storeString(str, str2);
    }

    @Override // com.byazt.iy.n
    public Set<String> get(String str, Set<String> set) {
        return getStringSet(str, set);
    }

    @Override // com.byazt.iy.n
    public void put(String str, Set<String> set) {
        this.c.getStringSet(str, set);
    }

    private static boolean c(Context context) {
        if (context == null) {
            return false;
        }
        KevaBuilder kevaBuilder = KevaBuilder.getInstance();
        kevaBuilder.setMonitor(new KevaMonitor() { // from class: com.byazt.fu.c.1
        });
        kevaBuilder.setContext(context);
        return true;
    }

    private void c(String str, boolean z) {
        if (z) {
            this.c = Keva.getRepo(str, 1);
        } else {
            this.c = Keva.getRepo(str, 0);
        }
    }
}

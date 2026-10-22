package com.byazt.wr;

import android.content.SharedPreferences;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1361, 15})
public class uj implements com.byazt.iy.n {
    public SharedPreferences c;

    public uj(SharedPreferences sharedPreferences) {
        this.c = sharedPreferences;
    }

    @Override // com.byazt.iy.n
    public void apply() {
    }

    @Override // com.byazt.iy.n
    public void applySync() {
    }

    @Override // com.byazt.iy.n
    public void clear() {
        try {
            this.c.edit().clear().apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public boolean contains(String str) {
        return this.c.contains(str);
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.c.edit();
    }

    @Override // com.byazt.iy.n
    public int get(String str, int i) {
        try {
            return this.c.getInt(str, i);
        } catch (Exception unused) {
            return i;
        }
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        try {
            return this.c.getAll();
        } catch (Exception unused) {
            return Collections.emptyMap();
        }
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        try {
            return this.c.getBoolean(str, z);
        } catch (Exception unused) {
            return z;
        }
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        try {
            return this.c.getFloat(str, f);
        } catch (Exception unused) {
            return f;
        }
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public int getInt(String str, int i) {
        try {
            return this.c.getInt(str, i);
        } catch (Exception unused) {
            return i;
        }
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public long getLong(String str, long j) {
        try {
            return this.c.getLong(str, j);
        } catch (Exception unused) {
            return j;
        }
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public String getString(String str, String str2) {
        try {
            return this.c.getString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        try {
            return this.c.getStringSet(str, set);
        } catch (Exception unused) {
            return set;
        }
    }

    @Override // com.byazt.iy.n
    public void put(String str, int i) {
        try {
            this.c.edit().putInt(str, i).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.c.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.byazt.iy.n
    public void remove(String str) {
        try {
            this.c.edit().remove(str).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.iy.n, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.c.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.byazt.iy.n
    public long get(String str, long j) {
        try {
            return this.c.getLong(str, j);
        } catch (Exception unused) {
            return j;
        }
    }

    @Override // com.byazt.iy.n
    public void put(String str, long j) {
        try {
            this.c.edit().putLong(str, j).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.iy.n
    public float get(String str, float f) {
        try {
            return this.c.getFloat(str, f);
        } catch (Exception unused) {
            return f;
        }
    }

    @Override // com.byazt.iy.n
    public void put(String str, float f) {
        try {
            this.c.edit().putFloat(str, f).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.iy.n
    public boolean get(String str, boolean z) {
        try {
            return this.c.getBoolean(str, z);
        } catch (Exception unused) {
            return z;
        }
    }

    @Override // com.byazt.iy.n
    public void put(String str, boolean z) {
        try {
            this.c.edit().putBoolean(str, z).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.iy.n
    public String get(String str, String str2) {
        try {
            return this.c.getString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    @Override // com.byazt.iy.n
    public void put(String str, String str2) {
        try {
            this.c.edit().putString(str, str2).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.iy.n
    public Set<String> get(String str, Set<String> set) {
        try {
            return this.c.getStringSet(str, set);
        } catch (Exception unused) {
            return set;
        }
    }

    @Override // com.byazt.iy.n
    public void put(String str, Set<String> set) {
        try {
            this.c.edit().putStringSet(str, set).apply();
        } catch (Throwable unused) {
        }
    }
}

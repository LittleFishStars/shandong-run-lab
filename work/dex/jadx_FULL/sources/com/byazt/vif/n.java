package com.byazt.vif;

import android.content.SharedPreferences;
import com.byazt.it.sp;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2075, 46})
public class n implements sp {
    public final com.byazt.iy.n c;

    @com.byazt.zqa.c(c = {0, 1, 2075, 151})
    public static class c implements SharedPreferences.Editor {
        public final SharedPreferences.Editor c;
        public final com.byazt.iy.n tt;

        public c(SharedPreferences.Editor editor, com.byazt.iy.n nVar) {
            this.c = editor;
            this.tt = nVar;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            this.c.apply();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.c.clear();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return this.c.commit();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            com.byazt.bnf.tt.c(str, Boolean.valueOf(z), this.tt);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            com.byazt.bnf.tt.c(str, Float.valueOf(f), this.tt);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            com.byazt.bnf.tt.c(str, Integer.valueOf(i), this.tt);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            com.byazt.bnf.tt.c(str, Long.valueOf(j), this.tt);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            com.byazt.bnf.tt.c(str, str2, this.tt);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            com.byazt.bnf.tt.c(str, set, this.tt);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            com.byazt.bnf.tt.tt(str, this.tt);
            return this;
        }
    }

    public n(com.byazt.iy.n nVar) {
        this.c = nVar;
    }

    @Override // com.byazt.it.c
    public void apply() {
        this.c.apply();
    }

    @Override // com.byazt.it.c
    public void applySync() {
        this.c.applySync();
    }

    @Override // com.byazt.it.c
    public void clear() {
        this.c.clear();
    }

    @Override // com.byazt.it.c, android.content.SharedPreferences
    public boolean contains(String str) {
        return this.c.contains(str);
    }

    @Override // com.byazt.it.c, android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new c(this.c.edit(), this.c);
    }

    @Override // com.byazt.it.c
    public int get(String str, int i) {
        return com.byazt.bnf.tt.c(str, this.c, i);
    }

    @Override // com.byazt.it.c, android.content.SharedPreferences
    public Map<String, String> getAll() {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.c.getAll().entrySet()) {
            map.put((String) entry.getKey(), com.byazt.bnf.tt.c((String) entry.getValue()));
        }
        return map;
    }

    @Override // com.byazt.it.c, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return com.byazt.bnf.tt.c(str, this.c, z);
    }

    @Override // com.byazt.it.c, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return com.byazt.bnf.tt.c(str, this.c, f);
    }

    @Override // com.byazt.it.c, android.content.SharedPreferences
    public int getInt(String str, int i) {
        return com.byazt.bnf.tt.c(str, this.c, i);
    }

    @Override // com.byazt.it.c, android.content.SharedPreferences
    public long getLong(String str, long j) {
        return com.byazt.bnf.tt.c(str, this.c, j);
    }

    @Override // com.byazt.it.c, android.content.SharedPreferences
    public String getString(String str, String str2) {
        return com.byazt.bnf.tt.c(str, this.c, str2);
    }

    @Override // com.byazt.it.c, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return com.byazt.bnf.tt.c(str, this.c, set);
    }

    @Override // com.byazt.it.c
    public void put(String str, int i) {
        com.byazt.bnf.tt.c(str, Integer.valueOf(i), this.c);
    }

    @Override // com.byazt.it.c, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.c.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.byazt.it.c
    public void remove(String str) {
        com.byazt.bnf.tt.tt(str, this.c);
    }

    @Override // com.byazt.it.c, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.c.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.byazt.it.c
    public long get(String str, long j) {
        return com.byazt.bnf.tt.c(str, this.c, j);
    }

    @Override // com.byazt.it.c
    public void put(String str, long j) {
        com.byazt.bnf.tt.c(str, Long.valueOf(j), this.c);
    }

    @Override // com.byazt.it.c
    public float get(String str, float f) {
        return com.byazt.bnf.tt.c(str, this.c, f);
    }

    @Override // com.byazt.it.c
    public void put(String str, float f) {
        com.byazt.bnf.tt.c(str, Float.valueOf(f), this.c);
    }

    @Override // com.byazt.it.c
    public boolean get(String str, boolean z) {
        return com.byazt.bnf.tt.c(str, this.c, z);
    }

    @Override // com.byazt.it.c
    public void put(String str, boolean z) {
        com.byazt.bnf.tt.c(str, Boolean.valueOf(z), this.c);
    }

    @Override // com.byazt.it.c
    public String get(String str, String str2) {
        return com.byazt.bnf.tt.c(str, this.c, str2);
    }

    @Override // com.byazt.it.c
    public void put(String str, String str2) {
        com.byazt.bnf.tt.c(str, str2, this.c);
    }

    @Override // com.byazt.it.c
    public Set<String> get(String str, Set<String> set) {
        return com.byazt.bnf.tt.c(str, this.c, set);
    }

    @Override // com.byazt.it.c
    public void put(String str, Set<String> set) {
        com.byazt.bnf.tt.c(str, set, this.c);
    }
}

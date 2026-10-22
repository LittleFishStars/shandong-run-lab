package com.byazt.vif;

import android.content.SharedPreferences;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2075, 13})
public class tt implements com.byazt.it.n {
    public final com.byazt.iy.n c;

    public tt(com.byazt.iy.n nVar) {
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
        return this.c.edit();
    }

    @Override // com.byazt.it.c
    public int get(String str, int i) {
        return this.c.getInt(str, i);
    }

    @Override // com.byazt.it.c, android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.c.getAll();
    }

    @Override // com.byazt.it.c, android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.c.getBoolean(str, z);
    }

    @Override // com.byazt.it.c, android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.c.getFloat(str, f);
    }

    @Override // com.byazt.it.c, android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.c.getInt(str, i);
    }

    @Override // com.byazt.it.c, android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.c.getLong(str, j);
    }

    @Override // com.byazt.it.c, android.content.SharedPreferences
    public String getString(String str, String str2) {
        return this.c.getString(str, str2);
    }

    @Override // com.byazt.it.c, android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return this.c.getStringSet(str, set);
    }

    @Override // com.byazt.it.c
    public void put(String str, int i) {
        this.c.put(str, i);
    }

    @Override // com.byazt.it.c, android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.c.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.byazt.it.c
    public void remove(String str) {
        this.c.remove(str);
    }

    @Override // com.byazt.it.c, android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.c.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // com.byazt.it.c
    public long get(String str, long j) {
        return this.c.getLong(str, j);
    }

    @Override // com.byazt.it.c
    public void put(String str, long j) {
        this.c.put(str, j);
    }

    @Override // com.byazt.it.c
    public float get(String str, float f) {
        return this.c.getFloat(str, f);
    }

    @Override // com.byazt.it.c
    public void put(String str, float f) {
        this.c.put(str, f);
    }

    @Override // com.byazt.it.c
    public boolean get(String str, boolean z) {
        return this.c.getBoolean(str, z);
    }

    @Override // com.byazt.it.c
    public void put(String str, boolean z) {
        this.c.put(str, z);
    }

    @Override // com.byazt.it.c
    public String get(String str, String str2) {
        return this.c.getString(str, str2);
    }

    @Override // com.byazt.it.c
    public void put(String str, String str2) {
        this.c.put(str, str2);
    }

    @Override // com.byazt.it.c
    public Set<String> get(String str, Set<String> set) {
        return this.c.getStringSet(str, set);
    }

    @Override // com.byazt.it.c
    public void put(String str, Set<String> set) {
        this.c.put(str, set);
    }
}

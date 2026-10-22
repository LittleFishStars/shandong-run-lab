package com.byazt.iy;

import android.content.SharedPreferences;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public interface n extends SharedPreferences {
    void apply();

    void applySync();

    void clear();

    @Override // android.content.SharedPreferences
    boolean contains(String str);

    @Override // android.content.SharedPreferences
    SharedPreferences.Editor edit();

    float get(String str, float f);

    int get(String str, int i);

    long get(String str, long j);

    String get(String str, String str2);

    Set<String> get(String str, Set<String> set);

    boolean get(String str, boolean z);

    @Override // android.content.SharedPreferences
    Map getAll();

    @Override // android.content.SharedPreferences
    boolean getBoolean(String str, boolean z);

    @Override // android.content.SharedPreferences
    float getFloat(String str, float f);

    @Override // android.content.SharedPreferences
    int getInt(String str, int i);

    @Override // android.content.SharedPreferences
    long getLong(String str, long j);

    @Override // android.content.SharedPreferences
    String getString(String str, String str2);

    @Override // android.content.SharedPreferences
    Set<String> getStringSet(String str, Set<String> set);

    void put(String str, float f);

    void put(String str, int i);

    void put(String str, long j);

    void put(String str, String str2);

    void put(String str, Set<String> set);

    void put(String str, boolean z);

    @Override // android.content.SharedPreferences
    void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener);

    void remove(String str);

    @Override // android.content.SharedPreferences
    void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener);
}

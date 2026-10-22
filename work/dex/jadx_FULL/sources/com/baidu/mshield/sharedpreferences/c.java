package com.baidu.mshield.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.baidu.mshield.utility.g;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c implements SharedPreferences {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f26721a;
    public Context b;
    public int c;
    public SharedPreferences.Editor d;
    public boolean e;
    public String f;
    public String g;

    public c(Context context, SharedPreferences sharedPreferences, String str, boolean z, int i) {
        this(context, sharedPreferences, str, z, i, null);
    }

    public final Bundle a(String str, String str2, String str3) {
        try {
            com.baidu.mshield.b.c.a.b("SPT callProviderGet:" + str + LoginConstants.UNDER_LINE + str2 + LoginConstants.UNDER_LINE + str3);
            Bundle bundle = new Bundle();
            bundle.putString("operation", str);
            bundle.putString("pref_name", this.f);
            bundle.putString(CachedContentIndex.a.e, str2);
            bundle.putString("defult_value", str3);
            if (this.e && !TextUtils.isEmpty(this.g)) {
                return g.a(this.b, "CallPreferences", bundle, this.g);
            }
            return g.a(this.b, "CallPreferences", bundle);
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return null;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        throw new RuntimeException("This preference not allow to call contains.");
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        SharedPreferences.Editor editor = this.d;
        if (editor != null) {
            return editor;
        }
        SharedPreferences sharedPreferences = this.f26721a;
        if (sharedPreferences != null) {
            return sharedPreferences.edit();
        }
        return null;
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        throw new RuntimeException("This preference not allow to call getAll.");
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        try {
            if (this.c == 1 && (!this.e || TextUtils.isEmpty(this.g))) {
                if (this.f26721a == null) {
                    return z;
                }
                com.baidu.mshield.b.c.a.b("SPT getBoolean:return by mBase");
                return this.f26721a.getBoolean(str, z);
            }
            Bundle bundleA = a("getBoolean", str, String.valueOf(z));
            if (bundleA != null) {
                com.baidu.mshield.b.c.a.b("SPT getBoolean:return by resultBundle");
                return bundleA.getBoolean("result", z);
            }
            return z;
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        try {
            if (this.c == 1 && (!this.e || TextUtils.isEmpty(this.g))) {
                if (this.f26721a == null) {
                    return f;
                }
                com.baidu.mshield.b.c.a.b("SPT getFloat:return by mBase");
                return this.f26721a.getFloat(str, f);
            }
            Bundle bundleA = a("getFloat", str, String.valueOf(f));
            if (bundleA != null) {
                com.baidu.mshield.b.c.a.b("SPT getFloat:return by resultBundle");
                return bundleA.getFloat("result", f);
            }
            return f;
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        try {
            if (this.c == 1 && (!this.e || TextUtils.isEmpty(this.g))) {
                if (this.f26721a == null) {
                    return i;
                }
                com.baidu.mshield.b.c.a.b("SPT getInt:return by mBase");
                return this.f26721a.getInt(str, i);
            }
            Bundle bundleA = a("getInt", str, String.valueOf(i));
            if (bundleA != null) {
                com.baidu.mshield.b.c.a.b("SPT getInt:return by resultBundle");
                return bundleA.getInt("result", i);
            }
            return i;
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        try {
            if (this.c == 1 && (!this.e || TextUtils.isEmpty(this.g))) {
                if (this.f26721a == null) {
                    return j;
                }
                com.baidu.mshield.b.c.a.b("SPT getLong:return by mBase");
                return this.f26721a.getLong(str, j);
            }
            Bundle bundleA = a("getLong", str, String.valueOf(j));
            if (bundleA != null) {
                com.baidu.mshield.b.c.a.b("SPT getLong:return by resultBundle");
                return bundleA.getLong("result", j);
            }
            return j;
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        try {
            if (this.c == 1 && (!this.e || TextUtils.isEmpty(this.g))) {
                if (this.f26721a == null) {
                    return str2;
                }
                com.baidu.mshield.b.c.a.b("SPT getString:return by mBase");
                return this.f26721a.getString(str, str2);
            }
            Bundle bundleA = a("getString", str, str2);
            if (bundleA != null) {
                com.baidu.mshield.b.c.a.b("SPT getString:return by resultBundle");
                return bundleA.getString("result", str2);
            }
            return str2;
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        throw new RuntimeException("This preference not allow to call getStringSet.");
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        try {
            SharedPreferences sharedPreferences = this.f26721a;
            if (sharedPreferences != null) {
                sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        try {
            SharedPreferences sharedPreferences = this.f26721a;
            if (sharedPreferences != null) {
                sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
    }

    public c(Context context, SharedPreferences sharedPreferences, String str, boolean z, int i, String str2) {
        this.b = context;
        this.c = i;
        this.f26721a = sharedPreferences;
        this.d = new b(context, sharedPreferences != null ? sharedPreferences.edit() : null, str, z, this.c, str2);
        this.e = z;
        this.f = str;
        this.g = str2;
    }
}

package com.baidu.mshield.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.mshield.utility.g;
import com.google.android.exoplayer2.upstream.cache.CachedContentIndex;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b implements SharedPreferences.Editor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences.Editor f26720a;
    public Context b;
    public int c;
    public String d;
    public boolean e;
    public String f;

    public b(Context context, SharedPreferences.Editor editor, String str, boolean z, int i, String str2) {
        this.b = context;
        this.f26720a = editor;
        this.c = i;
        this.d = str;
        this.e = z;
        this.f = str2;
    }

    public final Bundle a(Bundle bundle) {
        try {
            com.baidu.mshield.b.c.a.b("SPT callProviderPut:" + bundle);
            bundle.putString("pref_name", this.d);
            if (this.e && !TextUtils.isEmpty(this.f)) {
                return g.a(this.b, "CallPreferences", bundle, this.f);
            }
            return g.a(this.b, "CallPreferences", bundle);
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return null;
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public void apply() {
        SharedPreferences.Editor editor;
        if (this.c == 1) {
            if ((!this.e || TextUtils.isEmpty(this.f)) && (editor = this.f26720a) != null) {
                editor.apply();
            }
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        throw new RuntimeException("This editor not allow to call clear.");
    }

    @Override // android.content.SharedPreferences.Editor
    public boolean commit() {
        SharedPreferences.Editor editor;
        if (this.c != 1 || ((this.e && !TextUtils.isEmpty(this.f)) || (editor = this.f26720a) == null)) {
            return true;
        }
        return editor.commit();
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String str, boolean z) {
        try {
            if (this.c != 1 || (this.e && !TextUtils.isEmpty(this.f))) {
                Bundle bundle = new Bundle();
                bundle.putString("operation", "putBoolean");
                bundle.putString(CachedContentIndex.a.e, str);
                bundle.putBoolean("value", z);
                a(bundle);
            } else {
                if (this.f26720a == null) {
                    return this;
                }
                com.baidu.mshield.b.c.a.b("SPT putBoolean:put by mBase");
                SharedPreferences.Editor editor = this.f26720a;
                if (editor != null) {
                    editor.putBoolean(str, z);
                }
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String str, float f) {
        try {
            if (this.c != 1 || (this.e && !TextUtils.isEmpty(this.f))) {
                Bundle bundle = new Bundle();
                bundle.putString("operation", "putFloat");
                bundle.putString(CachedContentIndex.a.e, str);
                bundle.putFloat("value", f);
                a(bundle);
            } else {
                if (this.f26720a == null) {
                    return this;
                }
                com.baidu.mshield.b.c.a.b("SPT putFloat:put by mBase");
                SharedPreferences.Editor editor = this.f26720a;
                if (editor != null) {
                    editor.putFloat(str, f);
                }
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String str, int i) {
        try {
            if (this.c != 1 || (this.e && !TextUtils.isEmpty(this.f))) {
                Bundle bundle = new Bundle();
                bundle.putString("operation", "putInt");
                bundle.putString(CachedContentIndex.a.e, str);
                bundle.putInt("value", i);
                a(bundle);
            } else {
                if (this.f26720a == null) {
                    return this;
                }
                com.baidu.mshield.b.c.a.b("SPT putInt:put by mBase");
                SharedPreferences.Editor editor = this.f26720a;
                if (editor != null) {
                    editor.putInt(str, i);
                }
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String str, long j) {
        try {
            if (this.c != 1 || (this.e && !TextUtils.isEmpty(this.f))) {
                Bundle bundle = new Bundle();
                bundle.putString("operation", "putLong");
                bundle.putString(CachedContentIndex.a.e, str);
                bundle.putLong("value", j);
                a(bundle);
            } else {
                if (this.f26720a == null) {
                    return this;
                }
                com.baidu.mshield.b.c.a.b("SPT putLong:put by mBase");
                SharedPreferences.Editor editor = this.f26720a;
                if (editor != null) {
                    editor.putLong(str, j);
                }
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String str, String str2) {
        try {
            if (this.c != 1 || (this.e && !TextUtils.isEmpty(this.f))) {
                Bundle bundle = new Bundle();
                bundle.putString("operation", "putString");
                bundle.putString(CachedContentIndex.a.e, str);
                bundle.putString("value", str2);
                a(bundle);
            } else {
                if (this.f26720a == null) {
                    return this;
                }
                com.baidu.mshield.b.c.a.b("SPT putString:put by mBase");
                SharedPreferences.Editor editor = this.f26720a;
                if (editor != null) {
                    editor.putString(str, str2);
                }
            }
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        throw new RuntimeException("This editor not allow to call putStringSet.");
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String str) {
        throw new RuntimeException("This editor not allow to call remove.");
    }
}

package com.zj.adlib;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.blankj.utilcode.util.Utils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@SuppressLint({"ApplySharedPref"})
public final class nt7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, nt7> f43605a = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SharedPreferences f18509a;

    public nt7(String str) {
        this.f18509a = Utils.a().getSharedPreferences(str, 0);
    }

    public static nt7 i() {
        return l("", 0);
    }

    public static nt7 j(int i) {
        return l("", i);
    }

    public static nt7 k(String str) {
        return l(str, 0);
    }

    public static nt7 l(String str, int i) {
        if (u(str)) {
            str = "spUtils";
        }
        Map<String, nt7> map = f43605a;
        nt7 nt7Var = map.get(str);
        if (nt7Var == null) {
            synchronized (nt7.class) {
                nt7Var = map.get(str);
                if (nt7Var == null) {
                    nt7Var = new nt7(str, i);
                    map.put(str, nt7Var);
                }
            }
        }
        return nt7Var;
    }

    public static boolean u(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public void A(@NonNull String str, long j, boolean z) {
        if (z) {
            this.f18509a.edit().putLong(str, j).commit();
        } else {
            this.f18509a.edit().putLong(str, j).apply();
        }
    }

    public void B(@NonNull String str, String str2) {
        C(str, str2, false);
    }

    public void C(@NonNull String str, String str2, boolean z) {
        if (z) {
            this.f18509a.edit().putString(str, str2).commit();
        } else {
            this.f18509a.edit().putString(str, str2).apply();
        }
    }

    public void D(@NonNull String str, Set<String> set) {
        E(str, set, false);
    }

    public void E(@NonNull String str, Set<String> set, boolean z) {
        if (z) {
            this.f18509a.edit().putStringSet(str, set).commit();
        } else {
            this.f18509a.edit().putStringSet(str, set).apply();
        }
    }

    public void F(@NonNull String str, boolean z) {
        G(str, z, false);
    }

    public void G(@NonNull String str, boolean z, boolean z2) {
        if (z2) {
            this.f18509a.edit().putBoolean(str, z).commit();
        } else {
            this.f18509a.edit().putBoolean(str, z).apply();
        }
    }

    public void H(@NonNull String str) {
        I(str, false);
    }

    public void I(@NonNull String str, boolean z) {
        if (z) {
            this.f18509a.edit().remove(str).commit();
        } else {
            this.f18509a.edit().remove(str).apply();
        }
    }

    public void a() {
        b(false);
    }

    public void b(boolean z) {
        if (z) {
            this.f18509a.edit().clear().commit();
        } else {
            this.f18509a.edit().clear().apply();
        }
    }

    public boolean c(@NonNull String str) {
        return this.f18509a.contains(str);
    }

    public Map<String, ?> d() {
        return this.f18509a.getAll();
    }

    public boolean e(@NonNull String str) {
        return f(str, false);
    }

    public boolean f(@NonNull String str, boolean z) {
        return this.f18509a.getBoolean(str, z);
    }

    public float g(@NonNull String str) {
        return h(str, -1.0f);
    }

    public float h(@NonNull String str, float f) {
        return this.f18509a.getFloat(str, f);
    }

    public int m(@NonNull String str) {
        return n(str, -1);
    }

    public int n(@NonNull String str, int i) {
        return this.f18509a.getInt(str, i);
    }

    public long o(@NonNull String str) {
        return p(str, -1L);
    }

    public long p(@NonNull String str, long j) {
        return this.f18509a.getLong(str, j);
    }

    public String q(@NonNull String str) {
        return r(str, "");
    }

    public String r(@NonNull String str, String str2) {
        return this.f18509a.getString(str, str2);
    }

    public Set<String> s(@NonNull String str) {
        return t(str, Collections.emptySet());
    }

    public Set<String> t(@NonNull String str, Set<String> set) {
        return this.f18509a.getStringSet(str, set);
    }

    public void v(@NonNull String str, float f) {
        w(str, f, false);
    }

    public void w(@NonNull String str, float f, boolean z) {
        if (z) {
            this.f18509a.edit().putFloat(str, f).commit();
        } else {
            this.f18509a.edit().putFloat(str, f).apply();
        }
    }

    public void x(@NonNull String str, int i) {
        y(str, i, false);
    }

    public void y(@NonNull String str, int i, boolean z) {
        if (z) {
            this.f18509a.edit().putInt(str, i).commit();
        } else {
            this.f18509a.edit().putInt(str, i).apply();
        }
    }

    public void z(@NonNull String str, long j) {
        A(str, j, false);
    }

    public nt7(String str, int i) {
        this.f18509a = Utils.a().getSharedPreferences(str, i);
    }
}

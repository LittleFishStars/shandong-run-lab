package com.kwad.sdk.core.diskcache.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bg;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {
    private com.kwad.sdk.core.diskcache.a.a aRU;

    /* JADX INFO: renamed from: com.kwad.sdk.core.diskcache.b.a$a, reason: collision with other inner class name */
    public static final class C1278a {
        static final a aRV = new a(0);
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public static a Lx() {
        return C1278a.aRV;
    }

    private boolean Ly() {
        init(((f) ServiceProvider.get(f.class)).getContext());
        return this.aRU == null;
    }

    @Nullable
    private File er(String str) {
        if (Ly() || TextUtils.isEmpty(str)) {
            return null;
        }
        return b.a(this.aRU, str);
    }

    private synchronized void init(Context context) {
        if (this.aRU != null || context == null) {
            return;
        }
        try {
            this.aRU = com.kwad.sdk.core.diskcache.a.a.a(bg.ee(context), 1, 1, 209715200L);
        } catch (Throwable unused) {
        }
    }

    public final boolean a(String str, com.kwad.sdk.core.network.a.a.C1286a c1286a) {
        File fileEr;
        if (!Ly() && !TextUtils.isEmpty(str)) {
            String strEs = c.es(str);
            if (b.a(this.aRU, str, strEs, c1286a) && (fileEr = er(strEs)) != null && fileEr.exists()) {
                return true;
            }
        }
        return false;
    }

    public final boolean b(String str, @NonNull String str2, com.kwad.sdk.core.network.a.a.C1286a c1286a) {
        File fileEr;
        if (!Ly() && !TextUtils.isEmpty(str)) {
            String strEs = c.es(str2);
            if (b.a(this.aRU, str, strEs, c1286a) && (fileEr = er(strEs)) != null && fileEr.exists()) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final File cO(String str) {
        if (Ly() || TextUtils.isEmpty(str)) {
            return null;
        }
        return er(c.es(str));
    }

    public final void delete() {
        if (Ly()) {
            return;
        }
        try {
            this.aRU.delete();
        } catch (IOException unused) {
        }
    }

    public final void eq(String str) {
        if (Ly() || TextUtils.isEmpty(str)) {
            return;
        }
        b.a(this.aRU, str, c.es(str));
    }

    public final boolean remove(String str) {
        if (Ly()) {
            return false;
        }
        try {
            az.aC(str, "cacheKey is not allowed empty");
            return this.aRU.remove(c.es(str));
        } catch (IOException unused) {
            return false;
        }
    }

    private a() {
    }
}

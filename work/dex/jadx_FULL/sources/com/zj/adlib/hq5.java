package com.zj.adlib;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRuntime;
import com.google.mlkit.common.internal.MlKitComponentDiscoveryService;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public class hq5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static hq5 f42179a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Object f17053a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ComponentRuntime f17054a;

    @NonNull
    @KeepForSdk
    public static hq5 c() {
        hq5 hq5Var;
        synchronized (f17053a) {
            yw6.s(f42179a != null, "MlKitContext has not been initialized");
            hq5Var = (hq5) yw6.l(f42179a);
        }
        return hq5Var;
    }

    @NonNull
    @KeepForSdk
    public static hq5 d(@NonNull Context context, @NonNull List<ComponentRegistrar> list) {
        hq5 hq5Var;
        synchronized (f17053a) {
            yw6.s(f42179a == null, "MlKitContext is already initialized");
            hq5 hq5Var2 = new hq5();
            f42179a = hq5Var2;
            ComponentRuntime componentRuntime = new ComponentRuntime(b19.f40656a, list, (Component<?>[]) new Component[]{Component.of(h(context), Context.class, new Class[0]), Component.of(hq5Var2, hq5.class, new Class[0])});
            hq5Var2.f17054a = componentRuntime;
            componentRuntime.initializeEagerComponents(true);
            hq5Var = f42179a;
        }
        return hq5Var;
    }

    @NonNull
    @KeepForSdk
    public static hq5 e(@NonNull Context context) {
        hq5 hq5VarG;
        synchronized (f17053a) {
            hq5VarG = f42179a;
            if (hq5VarG == null) {
                hq5VarG = g(context);
            }
        }
        return hq5VarG;
    }

    @NonNull
    @KeepForSdk
    public static hq5 f(@NonNull Context context, @NonNull List<ComponentRegistrar> list) {
        hq5 hq5VarD;
        synchronized (f17053a) {
            hq5VarD = f42179a;
            if (hq5VarD == null) {
                hq5VarD = d(context, list);
            }
        }
        return hq5VarD;
    }

    @NonNull
    public static hq5 g(@NonNull Context context) {
        hq5 hq5Var;
        synchronized (f17053a) {
            yw6.s(f42179a == null, "MlKitContext is already initialized");
            hq5 hq5Var2 = new hq5();
            f42179a = hq5Var2;
            Context contextH = h(context);
            ComponentRuntime componentRuntimeBuild = ComponentRuntime.builder(b19.f40656a).addLazyComponentRegistrars(ComponentDiscovery.forContext(contextH, MlKitComponentDiscoveryService.class).discoverLazy()).addComponent(Component.of(contextH, Context.class, new Class[0])).addComponent(Component.of(hq5Var2, hq5.class, new Class[0])).build();
            hq5Var2.f17054a = componentRuntimeBuild;
            componentRuntimeBuild.initializeEagerComponents(true);
            hq5Var = f42179a;
        }
        return hq5Var;
    }

    public static Context h(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }

    @NonNull
    @KeepForSdk
    public <T> T a(@NonNull Class<T> cls) {
        yw6.s(f42179a == this, "MlKitContext has been deleted");
        yw6.l(this.f17054a);
        return (T) this.f17054a.get(cls);
    }

    @NonNull
    @KeepForSdk
    public Context b() {
        return (Context) a(Context.class);
    }
}

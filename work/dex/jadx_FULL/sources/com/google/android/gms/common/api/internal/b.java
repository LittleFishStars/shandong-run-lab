package com.google.android.gms.common.api.internal;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.zj.adlib.yw6;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f31235a = Collections.newSetFromMap(new WeakHashMap());

    @NonNull
    @KeepForSdk
    public static <L> ListenerHolder<L> a(@NonNull L l, @NonNull Looper looper, @NonNull String str) {
        yw6.m(l, "Listener must not be null");
        yw6.m(looper, "Looper must not be null");
        yw6.m(str, "Listener type must not be null");
        return new ListenerHolder<>(looper, l, str);
    }

    @NonNull
    @KeepForSdk
    public static <L> ListenerHolder<L> b(@NonNull L l, @NonNull Executor executor, @NonNull String str) {
        yw6.m(l, "Listener must not be null");
        yw6.m(executor, "Executor must not be null");
        yw6.m(str, "Listener type must not be null");
        return new ListenerHolder<>(executor, l, str);
    }

    @NonNull
    @KeepForSdk
    public static <L> ListenerHolder.a<L> c(@NonNull L l, @NonNull String str) {
        yw6.m(l, "Listener must not be null");
        yw6.m(str, "Listener type must not be null");
        yw6.i(str, "Listener type must not be empty");
        return new ListenerHolder.a<>(l, str);
    }

    @NonNull
    public final ListenerHolder d(@NonNull Object obj, @NonNull Looper looper, @NonNull String str) {
        ListenerHolder listenerHolderA = a(obj, looper, "NO_TYPE");
        this.f31235a.add(listenerHolderA);
        return listenerHolderA;
    }

    public final void e() {
        Iterator it = this.f31235a.iterator();
        while (it.hasNext()) {
            ((ListenerHolder) it.next()).a();
        }
        this.f31235a.clear();
    }
}

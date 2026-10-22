package com.google.mlkit.common.sdkinternal;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@KeepForSdk
public abstract class LazyInstanceMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @GuardedBy("instances")
    public final Map f32453a = new HashMap();

    @NonNull
    @KeepForSdk
    public V a(@NonNull K k) {
        synchronized (this.f32453a) {
            if (this.f32453a.containsKey(k)) {
                return (V) this.f32453a.get(k);
            }
            V vCreate = create(k);
            this.f32453a.put(k, vCreate);
            return vCreate;
        }
    }

    @NonNull
    @KeepForSdk
    public abstract V create(@NonNull K k);
}

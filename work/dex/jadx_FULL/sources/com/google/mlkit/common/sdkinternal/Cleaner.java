package com.google.mlkit.common.sdkinternal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.sdkinternal.c;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class Cleaner {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ReferenceQueue f32452a = new ReferenceQueue();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Set f6623a = Collections.synchronizedSet(new HashSet());

    public interface Cleanable {
        @KeepForSdk
        void clean();
    }

    @NonNull
    @KeepForSdk
    public static Cleaner a() {
        Cleaner cleaner = new Cleaner();
        cleaner.b(cleaner, new Runnable() { // from class: com.zj.adlib.bbc
            @Override // java.lang.Runnable
            public final void run() {
            }
        });
        final ReferenceQueue referenceQueue = cleaner.f32452a;
        final Set set = cleaner.f6623a;
        Thread thread = new Thread(new Runnable() { // from class: com.zj.adlib.s6c
            @Override // java.lang.Runnable
            public final void run() {
                ReferenceQueue referenceQueue2 = referenceQueue;
                Set set2 = set;
                while (!set2.isEmpty()) {
                    try {
                        ((c) referenceQueue2.remove()).clean();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }, "MlKitCleaner");
        thread.setDaemon(true);
        thread.start();
        return cleaner;
    }

    @NonNull
    @KeepForSdk
    public Cleanable b(@NonNull Object obj, @NonNull Runnable runnable) {
        c cVar = new c(obj, this.f32452a, this.f6623a, runnable, null);
        this.f6623a.add(cVar);
        return cVar;
    }
}

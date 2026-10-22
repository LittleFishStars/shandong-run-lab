package com.google.mlkit.common.sdkinternal;

import com.zj.adlib.iec;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class c extends PhantomReference implements Cleaner.Cleanable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f32458a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Set f6629a;

    public /* synthetic */ c(Object obj, ReferenceQueue referenceQueue, Set set, Runnable runnable, iec iecVar) {
        super(obj, referenceQueue);
        this.f6629a = set;
        this.f32458a = runnable;
    }

    @Override // com.google.mlkit.common.sdkinternal.Cleaner.Cleanable
    public final void clean() {
        if (this.f6629a.remove(this)) {
            clear();
            this.f32458a.run();
        }
    }
}

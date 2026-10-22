package androidx.p002lifecycle;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Deprecated
public interface LifecycleRegistryOwner extends LifecycleOwner {
    @Override // androidx.p002lifecycle.LifecycleOwner
    @NonNull
    LifecycleRegistry getLifecycle();
}

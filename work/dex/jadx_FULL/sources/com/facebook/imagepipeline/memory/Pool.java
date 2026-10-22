package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.ResourceReleaser;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface Pool<V> extends ResourceReleaser<V>, MemoryTrimmable {
    @Override // com.facebook.common.references.ResourceReleaser
    void a(V v);

    V get(int i);
}

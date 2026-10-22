package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.zj.adlib.b50;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface Allocator {

    public interface AllocationNode {
        b50 a();

        @Nullable
        AllocationNode b();
    }

    void a(b50 b50Var);

    void b(AllocationNode allocationNode);

    b50 c();

    int getIndividualAllocationLength();

    int getTotalBytesAllocated();

    void trim();
}

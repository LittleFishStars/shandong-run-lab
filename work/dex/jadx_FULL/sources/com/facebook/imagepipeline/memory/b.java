package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.zj.adlib.ax6;
import com.zj.adlib.nu6;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ThreadSafe
public class b extends BasePool<NativeMemoryChunk> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f29999a;

    public b(MemoryTrimmableRegistry memoryTrimmableRegistry, nu6 nu6Var, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, nu6Var, poolStatsTracker);
        SparseIntArray sparseIntArray = nu6Var.f18513a;
        this.f29999a = new int[sparseIntArray.size()];
        int i = 0;
        while (true) {
            int[] iArr = this.f29999a;
            if (i >= iArr.length) {
                initialize();
                return;
            } else {
                iArr[i] = sparseIntArray.keyAt(i);
                i++;
            }
        }
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public int getBucketedSize(int i) {
        if (i <= 0) {
            throw new BasePool.InvalidSizeException(Integer.valueOf(i));
        }
        for (int i2 : this.f29999a) {
            if (i2 >= i) {
                return i2;
            }
        }
        return i;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public int getSizeInBytes(int i) {
        return i;
    }

    public int n() {
        return this.f29999a[0];
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.memory.BasePool
    public NativeMemoryChunk alloc(int i) {
        return new NativeMemoryChunk(i);
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public void free(NativeMemoryChunk nativeMemoryChunk) {
        ax6.i(nativeMemoryChunk);
        nativeMemoryChunk.close();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public int getBucketedSizeForValue(NativeMemoryChunk nativeMemoryChunk) {
        ax6.i(nativeMemoryChunk);
        return nativeMemoryChunk.g();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public boolean isReusable(NativeMemoryChunk nativeMemoryChunk) {
        ax6.i(nativeMemoryChunk);
        return !nativeMemoryChunk.isClosed();
    }
}

package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.zj.adlib.ax6;
import com.zj.adlib.nu6;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ThreadSafe
public class a extends BasePool<byte[]> implements ByteArrayPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f29998a;

    public a(MemoryTrimmableRegistry memoryTrimmableRegistry, nu6 nu6Var, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, nu6Var, poolStatsTracker);
        SparseIntArray sparseIntArray = nu6Var.f18513a;
        this.f29998a = new int[sparseIntArray.size()];
        for (int i = 0; i < sparseIntArray.size(); i++) {
            this.f29998a[i] = sparseIntArray.keyAt(i);
        }
        initialize();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public int getBucketedSize(int i) {
        if (i <= 0) {
            throw new BasePool.InvalidSizeException(Integer.valueOf(i));
        }
        for (int i2 : this.f29998a) {
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
        return this.f29998a[0];
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public byte[] alloc(int i) {
        return new byte[i];
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public void free(byte[] bArr) {
        ax6.i(bArr);
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public int getBucketedSizeForValue(byte[] bArr) {
        ax6.i(bArr);
        return bArr.length;
    }
}

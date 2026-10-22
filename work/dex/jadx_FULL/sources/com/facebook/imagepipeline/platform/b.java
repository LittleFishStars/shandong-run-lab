package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.ipd.dsp.internal.q.u;
import com.zj.adlib.ax6;
import com.zj.adlib.bj3;
import com.zj.adlib.q13;
import com.zj.adlib.rm1;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ThreadSafe
@TargetApi(19)
public class b extends DalvikPurgeableDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bj3 f30004a;

    public b(bj3 bj3Var) {
        this.f30004a = bj3Var;
    }

    public static void e(byte[] bArr, int i) {
        bArr[i] = -1;
        bArr[i + 1] = u.D7;
    }

    @Override // com.facebook.imagepipeline.platform.DalvikPurgeableDecoder, com.facebook.imagepipeline.platform.PlatformDecoder
    public /* bridge */ /* synthetic */ rm1 a(q13 q13Var, Bitmap.Config config, int i) {
        return super.a(q13Var, config, i);
    }

    @Override // com.facebook.imagepipeline.platform.DalvikPurgeableDecoder, com.facebook.imagepipeline.platform.PlatformDecoder
    public /* bridge */ /* synthetic */ rm1 b(q13 q13Var, Bitmap.Config config) {
        return super.b(q13Var, config);
    }

    @Override // com.facebook.imagepipeline.platform.DalvikPurgeableDecoder
    public /* bridge */ /* synthetic */ rm1 d(Bitmap bitmap) {
        return super.d(bitmap);
    }

    @Override // com.facebook.imagepipeline.platform.DalvikPurgeableDecoder
    public Bitmap decodeByteArrayAsPurgeable(rm1<PooledByteBuffer> rm1Var, BitmapFactory.Options options) {
        PooledByteBuffer pooledByteBufferS = rm1Var.s();
        int size = pooledByteBufferS.size();
        rm1<byte[]> rm1VarA = this.f30004a.a(size);
        try {
            byte[] bArrS = rm1VarA.s();
            pooledByteBufferS.f0(0, bArrS, 0, size);
            return (Bitmap) ax6.j(BitmapFactory.decodeByteArray(bArrS, 0, size, options), "BitmapFactory returned null");
        } finally {
            rm1.p(rm1VarA);
        }
    }

    @Override // com.facebook.imagepipeline.platform.DalvikPurgeableDecoder
    public Bitmap decodeJPEGByteArrayAsPurgeable(rm1<PooledByteBuffer> rm1Var, int i, BitmapFactory.Options options) {
        byte[] bArr = DalvikPurgeableDecoder.endsWithEOI(rm1Var, i) ? null : DalvikPurgeableDecoder.f30002a;
        PooledByteBuffer pooledByteBufferS = rm1Var.s();
        ax6.d(i <= pooledByteBufferS.size());
        int i2 = i + 2;
        rm1<byte[]> rm1VarA = this.f30004a.a(i2);
        try {
            byte[] bArrS = rm1VarA.s();
            pooledByteBufferS.f0(0, bArrS, 0, i);
            if (bArr != null) {
                e(bArrS, i);
                i = i2;
            }
            return (Bitmap) ax6.j(BitmapFactory.decodeByteArray(bArrS, 0, i, options), "BitmapFactory returned null");
        } finally {
            rm1.p(rm1VarA);
        }
    }
}

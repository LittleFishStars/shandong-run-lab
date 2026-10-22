package com.zj.adlib;

import com.alibaba.ariver.resource.parser.a.e;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteBufferOutputStream;
import com.google.common.base.a;
import com.ipd.dsp.internal.q.u;
import com.scwang.smartrefresh.header.internal.MaterialProgressDrawable;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class h13 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f42027a = {-1, u.m7, -1, -37, 0, 67, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, u.n7, 0, 17, 8};
    public static final byte[] b = {3, 1, 34, 0, 2, 17, 0, 3, 17, 0, -1, -60, 0, 31, 0, 0, 1, 5, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, -1, -60, 0, -75, a.r, 0, 2, 1, 3, 3, 2, 4, 3, 5, 5, 4, 4, 0, 0, 1, 125, 1, 2, 3, 0, 4, 17, 5, a.u, com.google.android.exoplayer2.text.cea.a.e, e.j, 65, 6, 19, 81, 97, 7, 34, 113, a.x, e.k, -127, -111, -95, 8, 35, 66, -79, u.o7, a.y, 82, -47, -16, 36, e.l, 98, 114, -126, 9, 10, a.z, a.A, a.B, a.C, a.D, com.google.android.exoplayer2.text.cea.a.g, com.google.android.exoplayer2.text.cea.a.h, com.google.android.exoplayer2.text.cea.a.i, MaterialProgressDrawable.c, com.google.android.exoplayer2.text.cea.a.j, 42, e.m, e.n, e.o, e.p, MaterialProgressDrawable.d, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, aq6.f40585a, 121, 122, -125, -124, -123, -122, -121, -120, -119, -118, -110, -109, -108, -107, -106, -105, -104, -103, -102, -94, -93, -92, -91, -90, -89, -88, -87, -86, -78, -77, -76, -75, -74, -73, -72, -71, -70, u.p7, u.q7, -60, u.r7, u.s7, u.t7, -56, u.u7, u.v7, -46, -45, -44, -43, -42, -41, u.m7, u.D7, u.A7, u.B7, -30, -29, -28, -27, -26, -25, -24, -23, -22, -15, -14, -13, -12, -11, -10, -9, -8, -7, -6, -1, -60, 0, 31, 1, 0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, -1, -60, 0, -75, 17, 0, 2, 1, 2, 4, 4, 3, 4, 7, 5, 4, 4, 0, 1, 2, 119, 0, 1, 2, 3, 17, 4, 5, com.google.android.exoplayer2.text.cea.a.e, e.j, 6, a.u, 65, 81, 7, 97, 113, 19, 34, e.k, -127, 8, a.x, 66, -111, -95, -79, u.o7, 9, 35, e.l, 82, -16, a.y, 98, 114, -47, 10, a.z, 36, e.m, u.B7, com.google.android.exoplayer2.text.cea.a.g, -15, a.A, a.B, a.C, a.D, com.google.android.exoplayer2.text.cea.a.h, com.google.android.exoplayer2.text.cea.a.i, MaterialProgressDrawable.c, com.google.android.exoplayer2.text.cea.a.j, 42, e.n, e.o, e.p, MaterialProgressDrawable.d, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, aq6.f40585a, 121, 122, -126, -125, -124, -123, -122, -121, -120, -119, -118, -110, -109, -108, -107, -106, -105, -104, -103, -102, -94, -93, -92, -91, -90, -89, -88, -87, -86, -78, -77, -76, -75, -74, -73, -72, -71, -70, u.p7, u.q7, -60, u.r7, u.s7, u.t7, -56, u.u7, u.v7, -46, -45, -44, -43, -42, -41, u.m7, u.D7, u.A7, -30, -29, -28, -27, -26, -25, -24, -23, -22, -14, -13, -12, -11, -10, -9, -8, -7, -6, -1, u.A7, 0, 12, 3, 1, 0, 2, 17, 3, 17, 0, 63, 0, -114, -118, MaterialProgressDrawable.c, -96, a.q, -1, u.D7};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PooledByteBufferFactory f16908a;

    public h13(PooledByteBufferFactory pooledByteBufferFactory) {
        this.f16908a = pooledByteBufferFactory;
    }

    public rm1<PooledByteBuffer> a(short s, short s2) throws Throwable {
        PooledByteBufferOutputStream pooledByteBufferOutputStreamF = null;
        try {
            try {
                PooledByteBufferFactory pooledByteBufferFactory = this.f16908a;
                byte[] bArr = f42027a;
                int length = bArr.length;
                byte[] bArr2 = b;
                pooledByteBufferOutputStreamF = pooledByteBufferFactory.f(length + bArr2.length + 4);
                pooledByteBufferOutputStreamF.write(bArr);
                pooledByteBufferOutputStreamF.write((byte) (s2 >> 8));
                pooledByteBufferOutputStreamF.write((byte) (s2 & 255));
                pooledByteBufferOutputStreamF.write((byte) (s >> 8));
                pooledByteBufferOutputStreamF.write((byte) (s & 255));
                pooledByteBufferOutputStreamF.write(bArr2);
                rm1<PooledByteBuffer> rm1VarH = rm1.H(pooledByteBufferOutputStreamF.g());
                pooledByteBufferOutputStreamF.close();
                return rm1VarH;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            if (pooledByteBufferOutputStreamF != null) {
                pooledByteBufferOutputStreamF.close();
            }
            throw th;
        }
    }
}

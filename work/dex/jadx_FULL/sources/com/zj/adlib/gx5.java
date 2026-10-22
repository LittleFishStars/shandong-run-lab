package com.zj.adlib;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.memory.NativePooledByteBufferOutputStream;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.memory.b;
import com.facebook.imagepipeline.memory.c;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ThreadSafe
public class gx5 implements PooledByteBufferFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f42005a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final qu6 f16901a;

    public gx5(b bVar, qu6 qu6Var) {
        this.f42005a = bVar;
        this.f16901a = qu6Var;
    }

    @VisibleForTesting
    public c g(InputStream inputStream, NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream) throws IOException {
        this.f16901a.a(inputStream, nativePooledByteBufferOutputStream);
        return nativePooledByteBufferOutputStream.g();
    }

    @Override // com.facebook.imagepipeline.memory.PooledByteBufferFactory
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public c b(int i) {
        ax6.d(i > 0);
        rm1 rm1VarJ = rm1.J(this.f42005a.get(i), this.f42005a);
        try {
            return new c(rm1VarJ, i);
        } finally {
            rm1VarJ.close();
        }
    }

    @Override // com.facebook.imagepipeline.memory.PooledByteBufferFactory
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public c e(InputStream inputStream) throws Throwable {
        NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.f42005a);
        try {
            return g(inputStream, nativePooledByteBufferOutputStream);
        } finally {
            nativePooledByteBufferOutputStream.close();
        }
    }

    @Override // com.facebook.imagepipeline.memory.PooledByteBufferFactory
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public c a(InputStream inputStream, int i) throws Throwable {
        NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.f42005a, i);
        try {
            return g(inputStream, nativePooledByteBufferOutputStream);
        } finally {
            nativePooledByteBufferOutputStream.close();
        }
    }

    @Override // com.facebook.imagepipeline.memory.PooledByteBufferFactory
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public c c(byte[] bArr) throws Throwable {
        NativePooledByteBufferOutputStream nativePooledByteBufferOutputStream = new NativePooledByteBufferOutputStream(this.f42005a, bArr.length);
        try {
            try {
                nativePooledByteBufferOutputStream.write(bArr, 0, bArr.length);
                c cVarG = nativePooledByteBufferOutputStream.g();
                nativePooledByteBufferOutputStream.close();
                return cVarG;
            } catch (IOException e) {
                throw i69.d(e);
            }
        } catch (Throwable th) {
            nativePooledByteBufferOutputStream.close();
            throw th;
        }
    }

    @Override // com.facebook.imagepipeline.memory.PooledByteBufferFactory
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public NativePooledByteBufferOutputStream d() {
        return new NativePooledByteBufferOutputStream(this.f42005a);
    }

    @Override // com.facebook.imagepipeline.memory.PooledByteBufferFactory
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public NativePooledByteBufferOutputStream f(int i) {
        return new NativePooledByteBufferOutputStream(this.f42005a, i);
    }
}

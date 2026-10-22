package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.MemoryFile;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.zj.adlib.ax6;
import com.zj.adlib.i69;
import com.zj.adlib.pu6;
import com.zj.adlib.q13;
import com.zj.adlib.rm1;
import com.zj.adlib.s51;
import com.zj.adlib.tm1;
import com.zj.adlib.ux4;
import com.zj.adlib.yu9;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a extends DalvikPurgeableDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Method f30003a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f1658a;

    public a(boolean z) {
        this.f1658a = z;
    }

    public static MemoryFile e(rm1<PooledByteBuffer> rm1Var, int i, @Nullable byte[] bArr) throws Throwable {
        OutputStream outputStream;
        ux4 ux4Var;
        pu6 pu6Var = null;
        OutputStream outputStream2 = null;
        MemoryFile memoryFile = new MemoryFile(null, (bArr == null ? 0 : bArr.length) + i);
        memoryFile.allowPurging(false);
        try {
            pu6 pu6Var2 = new pu6(rm1Var.s());
            try {
                ux4Var = new ux4(pu6Var2, i);
                try {
                    outputStream2 = memoryFile.getOutputStream();
                    s51.a(ux4Var, outputStream2);
                    if (bArr != null) {
                        memoryFile.writeBytes(bArr, 0, i, bArr.length);
                    }
                    rm1.p(rm1Var);
                    tm1.b(pu6Var2);
                    tm1.b(ux4Var);
                    tm1.a(outputStream2, true);
                    return memoryFile;
                } catch (Throwable th) {
                    th = th;
                    outputStream = outputStream2;
                    pu6Var = pu6Var2;
                    rm1.p(rm1Var);
                    tm1.b(pu6Var);
                    tm1.b(ux4Var);
                    tm1.a(outputStream, true);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
                ux4Var = null;
            }
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
            ux4Var = null;
        }
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
        return decodeFileDescriptorAsPurgeable(rm1Var, rm1Var.s().size(), null, options);
    }

    public Bitmap decodeFileDescriptorAsPurgeable(rm1<PooledByteBuffer> rm1Var, int i, byte[] bArr, BitmapFactory.Options options) throws Throwable {
        MemoryFile memoryFile = null;
        try {
            try {
                MemoryFile memoryFileE = e(rm1Var, i, bArr);
                try {
                    FileDescriptor fileDescriptorG = g(memoryFileE);
                    Bitmap bitmap = (Bitmap) ax6.j(this.f1658a ? yu9.f20932a.a(fileDescriptorG, null, options) : BitmapFactory.decodeFileDescriptor(fileDescriptorG, null, options), "BitmapFactory returned null");
                    if (memoryFileE != null) {
                        memoryFileE.close();
                    }
                    return bitmap;
                } catch (IOException e) {
                    e = e;
                    throw i69.d(e);
                } catch (Throwable th) {
                    th = th;
                    memoryFile = memoryFileE;
                    if (memoryFile != null) {
                        memoryFile.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    @Override // com.facebook.imagepipeline.platform.DalvikPurgeableDecoder
    public Bitmap decodeJPEGByteArrayAsPurgeable(rm1<PooledByteBuffer> rm1Var, int i, BitmapFactory.Options options) {
        return decodeFileDescriptorAsPurgeable(rm1Var, i, DalvikPurgeableDecoder.endsWithEOI(rm1Var, i) ? null : DalvikPurgeableDecoder.f30002a, options);
    }

    public final synchronized Method f() {
        if (f30003a == null) {
            try {
                f30003a = MemoryFile.class.getDeclaredMethod("getFileDescriptor", new Class[0]);
            } catch (Exception e) {
                throw i69.d(e);
            }
        }
        return f30003a;
    }

    public final FileDescriptor g(MemoryFile memoryFile) {
        try {
            return (FileDescriptor) f().invoke(memoryFile, new Object[0]);
        } catch (Exception e) {
            throw i69.d(e);
        }
    }
}

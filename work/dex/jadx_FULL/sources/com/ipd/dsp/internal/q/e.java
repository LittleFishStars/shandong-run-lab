package com.ipd.dsp.internal.q;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.Dsp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e implements com.ipd.dsp.internal.f.l<Bitmap> {
    public static final com.ipd.dsp.internal.f.h<Integer> b = com.ipd.dsp.internal.f.h.a("com.ipd.dsp.internal.components.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    public static final com.ipd.dsp.internal.f.h<Bitmap.CompressFormat> c = com.ipd.dsp.internal.f.h.a("com.ipd.dsp.internal.components.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    public static final String d = "BitmapEncoder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final com.ipd.dsp.internal.j.b f38496a;

    public e(@NonNull com.ipd.dsp.internal.j.b bVar) {
        this.f38496a = bVar;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0075 A[Catch: all -> 0x00c6, TRY_LEAVE, TryCatch #2 {all -> 0x00c6, blocks: (B:3:0x0021, B:8:0x0034, B:18:0x0053, B:32:0x006f, B:34:0x0075, B:39:0x00c2, B:40:0x00c5, B:31:0x006c), top: B:48:0x0021 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:34:0x0075, please report this as an issue */
    @Override // com.ipd.dsp.internal.f.d
    public boolean a(@NonNull com.ipd.dsp.internal.i.v<Bitmap> vVar, @NonNull File file, @NonNull com.ipd.dsp.internal.f.i iVar) {
        FileOutputStream fileOutputStream;
        Bitmap bitmap = vVar.get();
        Bitmap.CompressFormat compressFormatA = a(bitmap, iVar);
        com.ipd.dsp.internal.e0.b.a("encode: [%dx%d] %s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), compressFormatA);
        try {
            long jA = com.ipd.dsp.internal.d0.i.a();
            Integer num = (Integer) iVar.a(b);
            boolean z = false;
            if (num == null) {
                com.ipd.dsp.internal.e0.b.a();
                return false;
            }
            int iIntValue = num.intValue();
            OutputStream cVar = null;
            try {
                try {
                    try {
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            cVar = this.f38496a != null ? new com.ipd.dsp.internal.g.c(fileOutputStream, this.f38496a) : fileOutputStream;
                            bitmap.compress(compressFormatA, iIntValue, cVar);
                            cVar.close();
                            z = true;
                            cVar.close();
                        } catch (IOException e) {
                            e = e;
                            cVar = fileOutputStream;
                            if (Dsp.isDebugLogEnable()) {
                                com.ipd.dsp.internal.c2.k.a(d, "Failed to encode Bitmap", e);
                            }
                            if (cVar != null) {
                                cVar.close();
                            }
                            if (Dsp.isDebugLogEnable()) {
                                com.ipd.dsp.internal.c2.k.e(d, "Compressed with type: " + compressFormatA + " of size " + com.ipd.dsp.internal.d0.o.a(bitmap) + " in " + com.ipd.dsp.internal.d0.i.a(jA) + ", options format: " + iVar.a(c) + ", hasAlpha: " + bitmap.hasAlpha());
                            }
                            com.ipd.dsp.internal.e0.b.a();
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (IOException unused2) {
                    }
                } catch (IOException e2) {
                    e = e2;
                }
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.e(d, "Compressed with type: " + compressFormatA + " of size " + com.ipd.dsp.internal.d0.o.a(bitmap) + " in " + com.ipd.dsp.internal.d0.i.a(jA) + ", options format: " + iVar.a(c) + ", hasAlpha: " + bitmap.hasAlpha());
                }
                com.ipd.dsp.internal.e0.b.a();
                return z;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Throwable th3) {
            com.ipd.dsp.internal.e0.b.a();
            throw th3;
        }
    }

    @Deprecated
    public e() {
        this.f38496a = null;
    }

    public final Bitmap.CompressFormat a(Bitmap bitmap, com.ipd.dsp.internal.f.i iVar) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) iVar.a(c);
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    @Override // com.ipd.dsp.internal.f.l
    @NonNull
    public com.ipd.dsp.internal.f.c a(@NonNull com.ipd.dsp.internal.f.i iVar) {
        return com.ipd.dsp.internal.f.c.TRANSFORMED;
    }
}

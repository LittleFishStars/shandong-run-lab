package com.ipd.dsp.internal.n;

import androidx.annotation.NonNull;
import com.ipd.dsp.Dsp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class v implements com.ipd.dsp.internal.f.d<InputStream> {
    public static final String b = "StreamEncoder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ipd.dsp.internal.j.b f38451a;

    public v(com.ipd.dsp.internal.j.b bVar) {
        this.f38451a = bVar;
    }

    @Override // com.ipd.dsp.internal.f.d
    public boolean a(@NonNull InputStream inputStream, @NonNull File file, @NonNull com.ipd.dsp.internal.f.i iVar) {
        byte[] bArr = (byte[]) this.f38451a.b(65536, byte[].class);
        try {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                while (true) {
                    try {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            fileOutputStream.close();
                            fileOutputStream.close();
                            this.f38451a.put(bArr);
                            return true;
                        }
                        fileOutputStream.write(bArr, 0, i);
                    } catch (Throwable th) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
            } catch (IOException e) {
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.a(b, "Failed to encode data onto the OutputStream", e);
                }
                this.f38451a.put(bArr);
                return false;
            }
        } catch (Throwable th3) {
            this.f38451a.put(bArr);
            throw th3;
        }
    }
}

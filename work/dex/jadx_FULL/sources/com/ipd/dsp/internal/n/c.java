package com.ipd.dsp.internal.n;

import androidx.annotation.NonNull;
import com.ipd.dsp.Dsp;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c implements com.ipd.dsp.internal.f.d<ByteBuffer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38418a = "ByteBufferEncoder";

    @Override // com.ipd.dsp.internal.f.d
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull File file, @NonNull com.ipd.dsp.internal.f.i iVar) {
        try {
            com.ipd.dsp.internal.d0.a.a(byteBuffer, file);
            return true;
        } catch (IOException e) {
            if (!Dsp.isDebugLogEnable()) {
                return false;
            }
            com.ipd.dsp.internal.c2.k.a(f38418a, "Failed to write data", e);
            return false;
        }
    }
}

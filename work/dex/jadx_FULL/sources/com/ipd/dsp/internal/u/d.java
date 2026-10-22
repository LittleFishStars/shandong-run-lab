package com.ipd.dsp.internal.u;

import androidx.annotation.NonNull;
import com.ipd.dsp.Dsp;
import com.ipd.dsp.internal.c2.k;
import com.ipd.dsp.internal.f.l;
import com.ipd.dsp.internal.i.v;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class d implements l<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38547a = "GifEncoder";

    @Override // com.ipd.dsp.internal.f.l
    @NonNull
    public com.ipd.dsp.internal.f.c a(@NonNull com.ipd.dsp.internal.f.i iVar) {
        return com.ipd.dsp.internal.f.c.SOURCE;
    }

    @Override // com.ipd.dsp.internal.f.d
    public boolean a(@NonNull v<c> vVar, @NonNull File file, @NonNull com.ipd.dsp.internal.f.i iVar) {
        try {
            com.ipd.dsp.internal.d0.a.a(vVar.get().c(), file);
            return true;
        } catch (IOException e) {
            if (!Dsp.isDebugLogEnable()) {
                return false;
            }
            k.e(f38547a, "Failed to encode GIF drawable data", e);
            return false;
        }
    }
}

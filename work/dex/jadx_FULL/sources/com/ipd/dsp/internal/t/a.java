package com.ipd.dsp.internal.t;

import androidx.annotation.NonNull;
import com.ipd.dsp.internal.f.i;
import com.ipd.dsp.internal.f.k;
import com.ipd.dsp.internal.i.v;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a implements k<File, File> {
    @Override // com.ipd.dsp.internal.f.k
    public boolean a(@NonNull File file, @NonNull i iVar) {
        return true;
    }

    @Override // com.ipd.dsp.internal.f.k
    public v<File> a(@NonNull File file, int i, int i2, @NonNull i iVar) {
        return new b(file);
    }
}

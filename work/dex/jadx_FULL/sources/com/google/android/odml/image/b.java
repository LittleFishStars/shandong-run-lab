package com.google.android.odml.image;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class b {
    @NonNull
    public static ByteBuffer a(@NonNull MlImage mlImage) {
        zzg zzgVarK = mlImage.k();
        if (zzgVarK.a().b() == 2) {
            return ((f) zzgVarK).b().asReadOnlyBuffer();
        }
        throw new IllegalArgumentException("Extract ByteBuffer from an MlImage created by objects other than Bytebuffer is not supported");
    }
}

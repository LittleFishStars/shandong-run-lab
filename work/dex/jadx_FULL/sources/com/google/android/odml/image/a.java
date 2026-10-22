package com.google.android.odml.image;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class a {
    @NonNull
    public static Bitmap a(@NonNull MlImage mlImage) {
        zzg zzgVarK = mlImage.k();
        if (zzgVarK.a().b() == 1) {
            return ((e) zzgVarK).b();
        }
        throw new IllegalArgumentException("Extracting Bitmap from an MlImage created by objects other than Bitmap is not supported");
    }
}

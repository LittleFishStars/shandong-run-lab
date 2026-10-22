package com.google.android.odml.image;

import android.media.Image;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@RequiresApi(19)
public class c {
    @NonNull
    public static Image a(@NonNull MlImage mlImage) {
        zzg zzgVarK = mlImage.k();
        if (zzgVarK.a().b() == 3) {
            return ((g) zzgVarK).b();
        }
        throw new IllegalArgumentException("Extract Media Image from an MlImage created by objects other than Media Image is not supported");
    }
}

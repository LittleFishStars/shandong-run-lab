package com.kwad.sdk.core.videocache.c;

import android.content.Context;
import com.kwad.sdk.core.videocache.f;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {
    private static f baG;

    public static f b(Context context, int i, int i2) {
        f fVar = baG;
        if (fVar != null) {
            return fVar;
        }
        f fVarC = c(context, i, i2);
        baG = fVarC;
        return fVarC;
    }

    private static f c(Context context, int i, int i2) {
        return new f.a(context).aO(536870912L).eN(i).eO(i2).OY();
    }

    public static f cm(Context context) {
        return b(context, 0, 0);
    }
}

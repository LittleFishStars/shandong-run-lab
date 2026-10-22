package com.byazt.yf;

import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 508, 215})
public class yp {
    public static yp c(final com.byazt.xf.ve veVar) {
        return new yp() { // from class: com.byazt.yf.yp.1
            @Override // com.byazt.yf.yp
            public boolean c() {
                com.byazt.xf.ve veVar2 = veVar;
                return veVar2 != null ? veVar2.i() : super.c();
            }

            @Override // com.byazt.yf.yp
            public i tt() {
                com.byazt.xf.uj ujVarZ;
                com.byazt.xf.ve veVar2 = veVar;
                return (veVar2 == null || (ujVarZ = veVar2.z()) == null || ujVarZ.c() == AudioStats.AUDIO_AMPLITUDE_NONE || ujVarZ.tt() == AudioStats.AUDIO_AMPLITUDE_NONE) ? super.tt() : new i(ujVarZ.c(), ujVarZ.tt());
            }

            @Override // com.byazt.yf.yp
            public boolean ve() {
                com.byazt.xf.ve veVar2 = veVar;
                return veVar2 != null ? veVar2.x() : super.ve();
            }
        };
    }

    public boolean c() {
        return true;
    }

    @Nullable
    public i tt() {
        return null;
    }

    public boolean ve() {
        return true;
    }
}

package com.byazt.aas;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 130})
public class m {

    public interface c {
        void c();

        void c(com.byazt.uph.tt ttVar, com.byazt.yj.m mVar);
    }

    public static void c(com.byazt.sml.tt ttVar, int i, int i2, final c cVar, String str, int i3, com.byazt.yj.gt gtVar, boolean z) {
        com.byazt.nr.m.uj("splashLoadAd", " getImageBytes url ".concat(String.valueOf(ttVar)));
        com.byazt.hy.n.c().ve().c(ttVar, new com.byazt.uph.c.tt() { // from class: com.byazt.aas.m.1
            @Override // com.byazt.uph.c.tt
            public void c(com.byazt.yj.m mVar, com.byazt.uph.tt ttVar2) {
                c cVar2;
                if (ttVar2.uj() && (cVar2 = cVar) != null) {
                    cVar2.c(ttVar2, mVar);
                    return;
                }
                c cVar3 = cVar;
                if (cVar3 != null) {
                    cVar3.c();
                }
            }

            @Override // com.byazt.uph.c.tt
            public void c(int i4, String str2, Throwable th) {
                c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.c();
                }
            }
        }, i, i2, str, i3, gtVar, z);
    }

    public static Drawable c(byte[] bArr, int i) {
        if (bArr != null && bArr.length > 0) {
            try {
                return new BitmapDrawable(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
            } catch (Throwable unused) {
                return new ColorDrawable(0);
            }
        }
        return new ColorDrawable(0);
    }
}

package com.kwad.sdk.utils.c;

import android.content.Context;
import com.kwad.sdk.utils.cf;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class d {
    private static boolean bsN = true;
    private static f bsO;
    private static e bsP;
    private static b bsQ;
    private static c bsR;

    public static String eI(Context context) {
        if (bsP == null) {
            bsP = new e();
        }
        return bsP.a(context, bsN);
    }

    public static com.kwad.sdk.k.a.d eJ(Context context) {
        if (bsR == null) {
            bsR = new c();
        }
        return bsR.a(context, bsN);
    }

    public static com.kwad.sdk.core.request.model.b k(boolean z, int i) {
        if (bsQ == null) {
            bsQ = new b();
        }
        b.a aVar = new b.a();
        aVar.bsM = z;
        aVar.aXf = i;
        return bsQ.a(aVar, bsN);
    }

    public static List<cf.a> p(Context context, int i) {
        if (bsO == null) {
            bsO = new f();
        }
        f.a aVar = new f.a();
        aVar.mContext = context;
        aVar.maxSize = i;
        return bsO.a(aVar, false);
    }
}

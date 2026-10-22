package com.google.android.gms.dynamite;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class g implements DynamiteModule.VersionPolicy {
    /* JADX WARN: Code duplicated, block: B:7:0x001c A[DONT_INVERT, PHI: r4
      0x001c: PHI (r4v2 int) = (r4v1 int), (r4v3 int) binds: [B:3:0x0014, B:5:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Code duplicated, block: B:9:0x0021  */
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.a a(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.a aVar = new DynamiteModule.VersionPolicy.a();
        aVar.f31326a = iVersions.a(context, str);
        int iB = iVersions.b(context, str, true);
        aVar.b = iB;
        int i = aVar.f31326a;
        if (i == 0) {
            i = 0;
            if (iB == 0) {
                aVar.c = 0;
            } else if (iB >= i) {
                aVar.c = 1;
            } else {
                aVar.c = -1;
            }
        } else if (iB >= i) {
            aVar.c = 1;
        } else {
            aVar.c = -1;
        }
        return aVar;
    }
}

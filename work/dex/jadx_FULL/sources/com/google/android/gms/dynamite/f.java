package com.google.android.gms.dynamite;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class f implements DynamiteModule.VersionPolicy {
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.a a(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        int iB;
        DynamiteModule.VersionPolicy.a aVar = new DynamiteModule.VersionPolicy.a();
        int iA = iVersions.a(context, str);
        aVar.f31326a = iA;
        int i = 0;
        if (iA != 0) {
            iB = iVersions.b(context, str, false);
            aVar.b = iB;
        } else {
            iB = iVersions.b(context, str, true);
            aVar.b = iB;
        }
        int i2 = aVar.f31326a;
        if (i2 == 0) {
            if (iB == 0) {
                aVar.c = 0;
            }
            return aVar;
        }
        i = i2;
        if (i >= iB) {
            aVar.c = -1;
        } else {
            aVar.c = 1;
        }
        return aVar;
    }
}

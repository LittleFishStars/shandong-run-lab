package com.google.android.gms.dynamite;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c implements DynamiteModule.VersionPolicy {
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.a a(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.a aVar = new DynamiteModule.VersionPolicy.a();
        int iA = iVersions.a(context, str);
        aVar.f31326a = iA;
        if (iA != 0) {
            aVar.c = -1;
        } else {
            int iB = iVersions.b(context, str, true);
            aVar.b = iB;
            if (iB != 0) {
                aVar.c = 1;
            }
        }
        return aVar;
    }
}

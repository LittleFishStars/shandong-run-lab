package com.kc.cw.ad.internal.a;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: com.kc.cw.ad.internal.a.a$1, reason: invalid class name */
    @Keep
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final int[] f38830a;

        static {
            int[] iArr = new int[i.values().length];
            f38830a = iArr;
            try {
                iArr[i.FADE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38830a[i.PUSH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f38830a[i.MOVEIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f38830a[i.REVEAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static g a(i iVar, long j, h hVar) {
        i iVar2 = i.RANDOM;
        if (iVar == iVar2) {
            ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, i.values());
            arrayList.remove(i.NONE);
            arrayList.remove(iVar2);
            Collections.shuffle(arrayList);
            iVar = (i) arrayList.get(0);
        }
        int i = AnonymousClass1.f38830a[iVar.ordinal()];
        if (i == 1) {
            return new c(j);
        }
        if (i == 2) {
            return new e(j, hVar);
        }
        if (i == 3) {
            return new d(j, hVar);
        }
        if (i != 4) {
            return null;
        }
        return new f(j, hVar);
    }
}

package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.common.zzag;
import com.google.errorprone.annotations.RestrictedInheritance;
import com.zj.adlib.ivd;
import com.zj.adlib.x7c;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ShowFirstParty
@KeepForSdk
@RestrictedInheritance(allowedOnPath = ".*javatests/com/google/android/gmscore/integ/client/common/robolectric/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x7c f31208a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final HashMap f5452a;
    public static final x7c b;

    static {
        ivd ivdVar = new ivd();
        ivdVar.d("com.google.android.gms");
        ivdVar.a(204200000L);
        zzl zzlVar = f.d;
        ivdVar.c(zzag.zzn(zzlVar.zzf(), f.b.zzf()));
        zzl zzlVar2 = f.c;
        ivdVar.b(zzag.zzn(zzlVar2.zzf(), f.f5638a.zzf()));
        f31208a = ivdVar.e();
        ivd ivdVar2 = new ivd();
        ivdVar2.d("com.android.vending");
        ivdVar2.a(82240000L);
        ivdVar2.c(zzag.zzm(zzlVar.zzf()));
        ivdVar2.b(zzag.zzm(zzlVar2.zzf()));
        b = ivdVar2.e();
        f5452a = new HashMap();
    }
}

package com.google.android.gms.internal.common;

import com.zj.adlib.lqd;
import com.zj.adlib.psd;
import com.zj.adlib.pud;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d extends zzw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ psd f31331a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(psd psdVar, pud pudVar, CharSequence charSequence) {
        super(pudVar, charSequence);
        this.f31331a = psdVar;
    }

    @Override // com.google.android.gms.internal.common.zzw
    public final int a(int i) {
        return i + 1;
    }

    @Override // com.google.android.gms.internal.common.zzw
    public final int b(int i) {
        zzo zzoVar = this.f31331a.f44054a;
        CharSequence charSequence = ((zzw) this).f5736a;
        int length = charSequence.length();
        lqd.b(i, length, "index");
        while (i < length) {
            if (zzoVar.a(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }
}

package com.google.android.gms.internal.common;

import com.zj.adlib.pud;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
abstract class zzw extends zzj {
    public int L = 0;
    public int M = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzo f31334a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CharSequence f5736a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f5737a;

    public zzw(pud pudVar, CharSequence charSequence) {
        this.f31334a = pudVar.f44064a;
        this.f5737a = pudVar.f18941a;
        this.f5736a = charSequence;
    }

    public abstract int a(int i);

    public abstract int b(int i);

    @Override // com.google.android.gms.internal.common.zzj
    @CheckForNull
    public final /* bridge */ /* synthetic */ Object zza() {
        int iA;
        int i = this.L;
        while (true) {
            int i2 = this.L;
            if (i2 == -1) {
                zzb();
                return null;
            }
            int iB = b(i2);
            if (iB == -1) {
                iB = this.f5736a.length();
                this.L = -1;
                iA = -1;
            } else {
                iA = a(iB);
                this.L = iA;
            }
            if (iA == i) {
                int i3 = iA + 1;
                this.L = i3;
                if (i3 > this.f5736a.length()) {
                    this.L = -1;
                }
            } else {
                if (i < iB) {
                    this.f5736a.charAt(i);
                }
                if (i < iB) {
                    this.f5736a.charAt(iB - 1);
                }
                if (!this.f5737a || i != iB) {
                    int i4 = this.M;
                    if (i4 == 1) {
                        iB = this.f5736a.length();
                        this.L = -1;
                        if (iB > i) {
                            this.f5736a.charAt(iB - 1);
                        }
                    } else {
                        this.M = i4 - 1;
                    }
                    return this.f5736a.subSequence(i, iB).toString();
                }
                i = this.L;
            }
        }
    }
}

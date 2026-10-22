package com.zj.adlib;

import com.google.android.gms.internal.mlkit_common.zzps;
import com.google.android.gms.internal.mlkit_common.zzpt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class jmd extends zzps {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f42620a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f17434a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f17435a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f17436a;

    @Override // com.google.android.gms.internal.mlkit_common.zzps
    public final zzps a(boolean z) {
        this.f17436a = true;
        this.f42620a = (byte) (1 | this.f42620a);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzps
    public final zzps b(int i) {
        this.f17434a = 1;
        this.f42620a = (byte) (this.f42620a | 2);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzps
    public final zzpt c() {
        String str;
        if (this.f42620a == 3 && (str = this.f17435a) != null) {
            return new nmd(str, this.f17436a, this.f17434a, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f17435a == null) {
            sb.append(" libraryName");
        }
        if ((this.f42620a & 1) == 0) {
            sb.append(" enableFirelog");
        }
        if ((this.f42620a & 2) == 0) {
            sb.append(" firelogEventType");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    public final zzps d(String str) {
        this.f17435a = "common";
        return this;
    }
}

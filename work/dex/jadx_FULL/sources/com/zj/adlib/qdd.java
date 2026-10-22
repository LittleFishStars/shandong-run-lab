package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_common.zzmd;
import com.google.android.gms.internal.mlkit_vision_common.zzme;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class qdd extends zzmd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f44185a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f19066a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f19067a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f19068a;

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzmd
    public final zzmd a(boolean z) {
        this.f19068a = true;
        this.f44185a = (byte) (1 | this.f44185a);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzmd
    public final zzmd b(int i) {
        this.f19066a = 1;
        this.f44185a = (byte) (this.f44185a | 2);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzmd
    public final zzme c() {
        String str;
        if (this.f44185a == 3 && (str = this.f19067a) != null) {
            return new eed(str, this.f19068a, this.f19066a, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f19067a == null) {
            sb.append(" libraryName");
        }
        if ((this.f44185a & 1) == 0) {
            sb.append(" enableFirelog");
        }
        if ((this.f44185a & 2) == 0) {
            sb.append(" firelogEventType");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    public final zzmd d(String str) {
        this.f19067a = "vision-common";
        return this;
    }
}

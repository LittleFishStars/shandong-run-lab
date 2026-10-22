package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode.zzto;
import com.google.android.gms.internal.mlkit_vision_barcode.zztp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class csd extends zzto {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f41038a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f15888a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f15889a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f15890a;

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzto
    public final zzto a(boolean z) {
        this.f15890a = true;
        this.f41038a = (byte) (1 | this.f41038a);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzto
    public final zzto b(int i) {
        this.f15888a = 1;
        this.f41038a = (byte) (this.f41038a | 2);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzto
    public final zztp c() {
        String str;
        if (this.f41038a == 3 && (str = this.f15889a) != null) {
            return new esd(str, this.f15890a, this.f15888a, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f15889a == null) {
            sb.append(" libraryName");
        }
        if ((this.f41038a & 1) == 0) {
            sb.append(" enableFirelog");
        }
        if ((this.f41038a & 2) == 0) {
            sb.append(" firelogEventType");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    public final zzto d(String str) {
        this.f15889a = str;
        return this;
    }
}

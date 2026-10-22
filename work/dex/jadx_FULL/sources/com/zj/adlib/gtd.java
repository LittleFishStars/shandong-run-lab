package com.zj.adlib;

import com.google.android.gms.internal.mlkit_vision_barcode.zzut;
import com.google.android.gms.internal.mlkit_vision_barcode.zzuu;
import com.igexin.push.config.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class gtd extends zzut {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f41986a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f16875a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f16876a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public short f16877a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f16878a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f16879b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f16880b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f16881b;
    public float c;
    public float d;
    public float e;
    public float f;

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzut
    public final zzut a(boolean z) {
        this.f16881b = true;
        this.f16877a = (short) (this.f16877a | 512);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzut
    public final zzut b(float f) {
        this.d = 0.8f;
        this.f16877a = (short) (this.f16877a | 64);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzut
    public final zzut c(float f) {
        this.c = 0.5f;
        this.f16877a = (short) (this.f16877a | 32);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzut
    public final zzut d(float f) {
        this.b = 0.8f;
        this.f16877a = (short) (this.f16877a | 8);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzut
    public final zzut e(int i) {
        this.f16879b = 5;
        this.f16877a = (short) (this.f16877a | 2);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzut
    public final zzut f(float f) {
        this.f41986a = 0.25f;
        this.f16877a = (short) (this.f16877a | 4);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzut
    public final zzut g(long j) {
        this.f16880b = 3000L;
        this.f16877a = (short) (this.f16877a | 256);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzut
    public final zzut h(boolean z) {
        this.f16878a = z;
        this.f16877a = (short) (this.f16877a | 16);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzut
    public final zzut i(float f) {
        this.e = 0.1f;
        this.f16877a = (short) (this.f16877a | 1024);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzut
    public final zzut j(long j) {
        this.f16876a = c.j;
        this.f16877a = (short) (this.f16877a | 128);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzut
    public final zzut k(float f) {
        this.f = 0.05f;
        this.f16877a = (short) (this.f16877a | 2048);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzut
    public final zzuu l() {
        if (this.f16877a == 4095) {
            return new itd(this.f16875a, this.f16879b, this.f41986a, this.b, this.f16878a, this.c, this.d, this.f16876a, this.f16880b, this.f16881b, this.e, this.f, null);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.f16877a & 1) == 0) {
            sb.append(" recentFramesToCheck");
        }
        if ((this.f16877a & 2) == 0) {
            sb.append(" recentFramesContainingPredictedArea");
        }
        if ((this.f16877a & 4) == 0) {
            sb.append(" recentFramesIou");
        }
        if ((this.f16877a & 8) == 0) {
            sb.append(" maxCoverage");
        }
        if ((this.f16877a & 16) == 0) {
            sb.append(" useConfidenceScore");
        }
        if ((this.f16877a & 32) == 0) {
            sb.append(" lowerConfidenceScore");
        }
        if ((this.f16877a & 64) == 0) {
            sb.append(" higherConfidenceScore");
        }
        if ((this.f16877a & 128) == 0) {
            sb.append(" zoomIntervalInMillis");
        }
        if ((this.f16877a & 256) == 0) {
            sb.append(" resetIntervalInMillis");
        }
        if ((this.f16877a & 512) == 0) {
            sb.append(" enableZoomThreshold");
        }
        if ((this.f16877a & 1024) == 0) {
            sb.append(" zoomInThreshold");
        }
        if ((this.f16877a & 2048) == 0) {
            sb.append(" zoomOutThreshold");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    public final zzut m(int i) {
        this.f16875a = 10;
        this.f16877a = (short) (this.f16877a | 1);
        return this;
    }
}

package com.zj.adlib;

import com.google.android.gms.internal.mlkit_common.zzlm;
import com.google.android.gms.internal.mlkit_common.zzls;
import com.google.android.gms.internal.mlkit_common.zzqa;
import com.google.android.gms.internal.mlkit_common.zzqb;
import com.google.mlkit.common.sdkinternal.ModelType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class pmd extends zzqa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f44019a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f18894a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public zzlm f18895a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public zzls f18896a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ModelType f18897a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f18898a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f18899a;
    public boolean b;

    @Override // com.google.android.gms.internal.mlkit_common.zzqa
    public final zzqa a(zzls zzlsVar) {
        if (zzlsVar == null) {
            throw new NullPointerException("Null downloadStatus");
        }
        this.f18896a = zzlsVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzqa
    public final zzqa b(zzlm zzlmVar) {
        if (zzlmVar == null) {
            throw new NullPointerException("Null errorCode");
        }
        this.f18895a = zzlmVar;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzqa
    public final zzqa c(int i) {
        this.f18894a = i;
        this.f44019a = (byte) (this.f44019a | 4);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzqa
    public final zzqa d(ModelType modelType) {
        if (modelType == null) {
            throw new NullPointerException("Null modelType");
        }
        this.f18897a = modelType;
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzqa
    public final zzqa e(boolean z) {
        this.b = z;
        this.f44019a = (byte) (this.f44019a | 2);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzqa
    public final zzqa f(boolean z) {
        this.f18899a = z;
        this.f44019a = (byte) (this.f44019a | 1);
        return this;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzqa
    public final zzqb g() {
        zzlm zzlmVar;
        String str;
        ModelType modelType;
        zzls zzlsVar;
        if (this.f44019a == 7 && (zzlmVar = this.f18895a) != null && (str = this.f18898a) != null && (modelType = this.f18897a) != null && (zzlsVar = this.f18896a) != null) {
            return new tmd(zzlmVar, str, this.f18899a, this.b, modelType, zzlsVar, this.f18894a, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f18895a == null) {
            sb.append(" errorCode");
        }
        if (this.f18898a == null) {
            sb.append(" tfliteSchemaVersion");
        }
        if ((this.f44019a & 1) == 0) {
            sb.append(" shouldLogRoughDownloadTime");
        }
        if ((this.f44019a & 2) == 0) {
            sb.append(" shouldLogExactDownloadTime");
        }
        if (this.f18897a == null) {
            sb.append(" modelType");
        }
        if (this.f18896a == null) {
            sb.append(" downloadStatus");
        }
        if ((this.f44019a & 4) == 0) {
            sb.append(" failureStatusCode");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    public final zzqa h(String str) {
        this.f18898a = "NA";
        return this;
    }
}

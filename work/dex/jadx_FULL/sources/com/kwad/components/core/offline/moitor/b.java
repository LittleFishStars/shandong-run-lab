package com.kwad.components.core.offline.moitor;

import com.ksad.json.annotation.KsJson;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsJson
public class b extends com.kwad.sdk.commercial.c.a {
    public String acX;
    public long acY;
    public long acZ;
    public long ada;
    public String adb;

    public final b K(long j) {
        this.acY = j;
        return this;
    }

    public final b L(long j) {
        this.acZ = j;
        return this;
    }

    public final b aS(String str) {
        this.acX = str;
        return this;
    }

    public final b aT(String str) {
        this.errorMsg = str;
        return this;
    }

    public final b aU(String str) {
        this.adb = str;
        return this;
    }

    public final b bs(int i) {
        this.ada = i;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    /* JADX INFO: renamed from: bt, reason: merged with bridge method [inline-methods] */
    public final b setErrorCode(int i) {
        this.errorCode = i;
        return this;
    }
}

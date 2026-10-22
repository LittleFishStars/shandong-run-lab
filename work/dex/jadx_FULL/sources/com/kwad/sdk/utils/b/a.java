package com.kwad.sdk.utils.b;

import com.ksad.json.annotation.KsJson;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@KsJson
public class a extends com.kwad.sdk.commercial.c.a {
    public int bsH = -1;
    public int bsI = -1;
    public int bsJ = -1;

    @Override // com.kwad.sdk.core.response.a.a
    public String toString() {
        return "KvOperationRecord{putCount=" + this.bsH + ", getFailedCount=" + this.bsI + ", getSuccessCount=" + this.bsJ + '}';
    }
}

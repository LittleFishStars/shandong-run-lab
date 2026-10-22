package com.kwad.sdk.core.videocache;

import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
final class c {
    public final File aZK;
    public final com.kwad.sdk.core.videocache.a.c aZL;
    public final com.kwad.sdk.core.videocache.a.a aZM;
    public final com.kwad.sdk.core.videocache.d.c aZN;
    public final com.kwad.sdk.core.videocache.b.b aZO;
    public final int aZP;
    public final int aZQ;

    public c(File file, com.kwad.sdk.core.videocache.a.c cVar, com.kwad.sdk.core.videocache.a.a aVar, com.kwad.sdk.core.videocache.d.c cVar2, com.kwad.sdk.core.videocache.b.b bVar, int i, int i2) {
        this.aZK = file;
        this.aZL = cVar;
        this.aZM = aVar;
        this.aZN = cVar2;
        this.aZO = bVar;
        this.aZP = i;
        this.aZQ = i2;
    }

    public final File fu(String str) {
        return new File(this.aZK, this.aZL.generate(str));
    }
}

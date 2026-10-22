package com.kwad.components.ad;

import com.kwad.sdk.components.e;
import com.kwad.sdk.f;
import com.kwad.sdk.n;
import com.kwad.sdk.o;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class c extends e {
    public final void a(final com.kwad.sdk.g.a<Boolean> aVar) {
        if (o.Gs().GV()) {
            aVar.accept(Boolean.TRUE);
        } else {
            f.a(new n() { // from class: com.kwad.components.ad.c.1
                @Override // com.kwad.sdk.n, com.kwad.sdk.m
                public final void M() {
                    aVar.accept(Boolean.TRUE);
                }

                @Override // com.kwad.sdk.n, com.kwad.sdk.m
                public final void N() {
                    aVar.accept(Boolean.FALSE);
                }
            });
        }
    }
}

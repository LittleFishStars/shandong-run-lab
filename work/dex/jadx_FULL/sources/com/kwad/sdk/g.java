package com.kwad.sdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public final class g {
    private volatile boolean aFV = false;
    private com.kwad.sdk.g.a aFW;

    private g(com.kwad.sdk.g.a aVar) {
        this.aFW = aVar;
    }

    public static g aj(final long j) {
        return f(new com.kwad.sdk.g.a() { // from class: com.kwad.sdk.g.1
            @Override // com.kwad.sdk.g.a
            public final void accept(Object obj) {
                p.ap(j);
            }
        });
    }

    public static g ak(final long j) {
        return f(new com.kwad.sdk.g.a() { // from class: com.kwad.sdk.g.2
            @Override // com.kwad.sdk.g.a
            public final void accept(Object obj) {
                p.aq(j);
            }
        });
    }

    public static g al(final long j) {
        return f(new com.kwad.sdk.g.a() { // from class: com.kwad.sdk.g.3
            @Override // com.kwad.sdk.g.a
            public final void accept(Object obj) {
                p.at(j);
            }
        });
    }

    public static g am(final long j) {
        return f(new com.kwad.sdk.g.a() { // from class: com.kwad.sdk.g.4
            @Override // com.kwad.sdk.g.a
            public final void accept(Object obj) {
                p.au(j);
            }
        });
    }

    private static g f(com.kwad.sdk.g.a aVar) {
        return new g(aVar);
    }

    public final synchronized void report() {
        if (this.aFW != null && !this.aFV) {
            this.aFW.accept(null);
            this.aFV = true;
        }
    }
}

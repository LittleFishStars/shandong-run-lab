package com.kwad.components.offline.d;

import com.kwad.components.offline.api.obiwan.IObiwanLogcat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c implements com.kwad.sdk.core.d.a.a {
    private final IObiwanLogcat axS;

    public c(IObiwanLogcat iObiwanLogcat) {
        this.axS = iObiwanLogcat;
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void d(String str, String str2) {
        this.axS.d(str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void e(String str, String str2) {
        this.axS.e(str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void i(String str, String str2) {
        this.axS.i(str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void printStackTraceOnly(Throwable th) {
        this.axS.printStackTraceOnly(th);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void v(String str, String str2) {
        this.axS.v(str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void w(String str, String str2) {
        this.axS.w(str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void v(String str, String str2, boolean z) {
        this.axS.v(str, str2, true);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void w(String str, String str2, boolean z) {
        this.axS.w(str, str2, z);
    }
}

package com.kwad.sdk.core.download;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class d implements c {
    private AdInfo mAdInfo;

    public d(AdTemplate adTemplate) {
        this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, int i, int i2, int i3) {
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, int i, String str2, e eVar) {
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, e eVar) {
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, String str2, e eVar) {
    }

    @Override // com.kwad.sdk.core.download.c
    public final void a(String str, Throwable th, e eVar) {
    }

    @Override // com.kwad.sdk.core.download.c
    public final void b(String str, e eVar) {
    }

    @Override // com.kwad.sdk.core.download.c
    public void b(String str, String str2, e eVar) {
    }

    @Override // com.kwad.sdk.core.download.c
    public final void c(String str, e eVar) {
    }

    @Override // com.kwad.sdk.core.download.c
    public final void d(String str, e eVar) {
    }

    @Override // com.kwad.sdk.core.download.c
    public final void e(String str, e eVar) {
    }

    @Override // com.kwad.sdk.core.download.c
    public final void f(String str, e eVar) {
    }

    @Override // com.kwad.sdk.core.download.c
    public final void g(String str, e eVar) {
    }

    @Override // com.kwad.sdk.core.download.c
    public final String qo() {
        return this.mAdInfo.downloadId;
    }

    @Override // com.kwad.sdk.core.download.c
    public final String qp() {
        return this.mAdInfo.adBaseInfo.appPackageName;
    }
}

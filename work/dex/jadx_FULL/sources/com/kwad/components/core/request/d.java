package com.kwad.components.core.request;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdResultData;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class d extends c {
    @Override // com.kwad.components.core.request.c
    public void a(@NonNull AdResultData adResultData, boolean z) {
        b(adResultData);
    }

    @Override // com.kwad.components.core.request.l
    public void b(@NonNull AdResultData adResultData) {
    }

    @Override // com.kwad.components.core.request.l
    public void onError(int i, String str) {
    }

    @Override // com.kwad.components.core.request.c
    public void a(int i, String str, boolean z) {
        onError(i, str);
    }
}

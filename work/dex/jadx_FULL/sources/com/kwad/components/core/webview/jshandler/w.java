package com.kwad.components.core.webview.jshandler;

import android.os.Vibrator;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class w implements com.kwad.sdk.core.webview.c.a {
    private Vibrator hw;

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.hw = (Vibrator) ServiceProvider.getContext().getSystemService("vibrator");
        by.a(ServiceProvider.getContext(), this.hw);
        cVar.b(null);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "startVibrate";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}

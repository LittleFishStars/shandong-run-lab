package com.kwad.components.core.r;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.tachikoma.d.e;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends e {
    protected com.kwad.components.core.webview.tachikoma.f.c akL;

    public static b a(e.b bVar) {
        b bVar2 = new b();
        bVar2.mAdResultData = bVar.iH();
        bVar2.Cd = bVar.getTemplateId();
        Bundle bundle = new Bundle();
        bundle.putString("templateId", bVar.getTemplateId());
        bVar2.setArguments(bundle);
        return bVar2;
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.e
    public final com.kwad.components.core.webview.tachikoma.d.b kQ() {
        return super.kQ();
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.e
    public final com.kwad.components.core.webview.tachikoma.d.c kR() {
        return new c();
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.e, android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        com.kwad.components.core.webview.tachikoma.f.c cVar = this.akL;
        if (cVar != null) {
            cVar.hu();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.d.e, android.app.Fragment
    public final void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        com.kwad.components.core.webview.tachikoma.f.c cVar = this.akL;
        if (cVar != null) {
            cVar.hm();
        }
    }

    @Nullable
    public static b a(b bVar, Activity activity, com.kwad.components.core.webview.tachikoma.f.c cVar) {
        if (activity == null || activity.isFinishing()) {
            return null;
        }
        bVar.akL = cVar;
        bVar.show(activity.getFragmentManager(), "webTKCloseDialog");
        return bVar;
    }
}

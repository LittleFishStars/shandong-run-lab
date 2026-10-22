package com.kwad.components.core.t;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class n {
    public static boolean e(@NonNull AdTemplate adTemplate, boolean z) {
        if (!z && com.kwad.sdk.core.response.helper.b.dQ(com.kwad.sdk.core.response.helper.e.eO(adTemplate))) {
            return com.kwad.sdk.core.config.e.Kz();
        }
        return false;
    }

    public static void i(@NonNull Context context, @NonNull AdTemplate adTemplate) {
        com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(context).aq(true).aJ(adTemplate));
    }
}

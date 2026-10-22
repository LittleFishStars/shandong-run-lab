package com.kwad.components.ad.feed.monitor;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.videocache.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.y;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    public static Pair<Integer, String> q(@NonNull AdTemplate adTemplate) {
        String strM = com.kwad.sdk.core.response.helper.a.M(e.eO(adTemplate));
        if (TextUtils.isEmpty(strM)) {
            return new Pair<>(2, "empty videoUrl");
        }
        int iGa = com.kwad.sdk.core.config.e.Ga();
        int i = 1;
        String str = "";
        if (iGa < 0) {
            File fileCO = com.kwad.sdk.core.diskcache.b.a.Lx().cO(strM);
            if (!y.Q(fileCO)) {
                com.kwad.sdk.core.network.a.a.C1286a c1286a = new com.kwad.sdk.core.network.a.a.C1286a();
                int i2 = com.kwad.sdk.core.diskcache.b.a.Lx().a(strM, c1286a) ? 1 : 2;
                str = c1286a.msg;
                i = i2;
            }
            adTemplate.setDownloadSize(fileCO != null ? fileCO.length() : 0L);
        } else if (iGa > 0) {
            com.kwad.sdk.core.network.a.a.C1286a c1286a2 = new com.kwad.sdk.core.network.a.a.C1286a();
            f fVarCm = com.kwad.sdk.core.videocache.c.a.cm(ServiceProvider.getContext());
            if (!fVarCm.fz(strM)) {
                i = fVarCm.a(strM, (long) (iGa * 1024), c1286a2, null) ? 1 : 2;
            }
            str = c1286a2.msg;
            adTemplate.setDownloadSize(iGa * 1024);
        } else {
            adTemplate.setDownloadSize(0L);
        }
        return new Pair<>(Integer.valueOf(i), str);
    }
}

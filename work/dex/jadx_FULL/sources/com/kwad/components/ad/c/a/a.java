package com.kwad.components.ad.c.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.video.k;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.core.videocache.f;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.y;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    @WorkerThread
    public static boolean a(@NonNull AdTemplate adTemplate, final AdVideoPreCacheConfig adVideoPreCacheConfig, final b bVar) {
        String str;
        String strM = com.kwad.sdk.core.response.helper.a.M(e.eO(adTemplate));
        if (TextUtils.isEmpty(strM)) {
            a(bVar, "字段为null");
            return false;
        }
        final long adVideoPreCacheSize = ((long) adVideoPreCacheConfig.getAdVideoPreCacheSize()) * 1024;
        boolean zA = true;
        if (adVideoPreCacheSize > 0) {
            long j = adVideoPreCacheConfig.isContinueLoadingAll() ? -1L : adVideoPreCacheSize;
            com.kwad.sdk.core.network.a.a.C1286a c1286a = new com.kwad.sdk.core.network.a.a.C1286a();
            f fVarCm = com.kwad.sdk.core.videocache.c.a.cm(ServiceProvider.getContext());
            if (fVarCm.fy(strM)) {
                a(bVar);
            } else {
                zA = fVarCm.a(strM, j, c1286a, new AdHttpResponseListener() { // from class: com.kwad.components.ad.c.a.a.1
                    private boolean cr = false;

                    @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
                    public final boolean onReadProgress(long j2, long j3) {
                        if ((j2 >= adVideoPreCacheSize || j2 >= j3) && !this.cr) {
                            this.cr = true;
                            a.a(bVar);
                            if (!adVideoPreCacheConfig.isContinueLoadingAll()) {
                                return true;
                            }
                        }
                        return false;
                    }

                    @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
                    public final void onResponseEnd() {
                    }

                    @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
                    public final void onResponseStart() {
                    }
                });
            }
            str = c1286a.msg;
        } else {
            String str2 = "";
            if (adVideoPreCacheSize < 0) {
                File fileCO = com.kwad.sdk.core.diskcache.b.a.Lx().cO(strM);
                if (!y.Q(fileCO)) {
                    com.kwad.sdk.core.network.a.a.C1286a c1286a2 = new com.kwad.sdk.core.network.a.a.C1286a();
                    boolean zA2 = com.kwad.sdk.core.diskcache.b.a.Lx().a(strM, c1286a2);
                    str2 = c1286a2.msg;
                    zA = zA2;
                }
                adTemplate.setDownloadSize(fileCO != null ? fileCO.length() : 0L);
                if (zA) {
                    a(bVar);
                }
            } else {
                a(bVar);
            }
            str = str2;
        }
        if (zA) {
            k.n(strM, adVideoPreCacheConfig.getAdVideoPreCacheSize());
        } else {
            a(bVar, str);
        }
        return zA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(b bVar) {
        if (bVar == null) {
            return;
        }
        bVar.ai();
    }

    private static void a(b bVar, String str) {
        if (bVar == null) {
            return;
        }
        bVar.aj();
    }
}

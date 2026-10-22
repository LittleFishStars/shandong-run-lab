package com.kwad.sdk.resourceCache;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.resourceCache.model.WarmUpReportMessage;
import com.kwad.sdk.resourceCache.model.WarmUpResponse;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.i;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class c {
    public static void a(final WarmUpResponse.ResourceItem resourceItem, final int i, int i2, final String str) {
        final int i3 = 0;
        i.execute(new bi() { // from class: com.kwad.sdk.resourceCache.c.4
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.sdk.commercial.c.d((com.kwad.sdk.commercial.c.a) new WarmUpReportMessage().setDownloadStatus(3).setResourceType(i).setResourceKey(resourceItem.resourceKey).setUrl(resourceItem.url).setErrorCode(i3).setErrorMsg(str), true);
            }
        });
    }

    public static void b(final WarmUpResponse.ResourceItem resourceItem, final int i) {
        i.execute(new bi() { // from class: com.kwad.sdk.resourceCache.c.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.sdk.commercial.c.d((com.kwad.sdk.commercial.c.a) new WarmUpReportMessage().setDownloadStatus(1).setResourceType(i).setResourceKey(resourceItem.resourceKey).setUrl(resourceItem.url), false);
            }
        });
    }

    public static void c(final WarmUpResponse.ResourceItem resourceItem, final int i) {
        i.execute(new bi() { // from class: com.kwad.sdk.resourceCache.c.2
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.sdk.commercial.c.d((com.kwad.sdk.commercial.c.a) new WarmUpReportMessage().setDownloadStatus(4).setResourceType(i).setResourceKey(resourceItem.resourceKey).setUrl(resourceItem.url), false);
            }
        });
    }

    public static void d(final WarmUpResponse.ResourceItem resourceItem, final int i) {
        i.execute(new bi() { // from class: com.kwad.sdk.resourceCache.c.3
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.sdk.commercial.c.d((com.kwad.sdk.commercial.c.a) new WarmUpReportMessage().setDownloadStatus(2).setResourceType(i).setResourceKey(resourceItem.resourceKey).setUrl(resourceItem.url), false);
            }
        });
    }

    public static void a(final WarmUpResponse.ResourceItem resourceItem, final int i, final String str) {
        i.execute(new bi() { // from class: com.kwad.sdk.resourceCache.c.5
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.sdk.commercial.c.d((com.kwad.sdk.commercial.c.a) new WarmUpReportMessage().setDownloadStatus(5).setResourceType(i).setResourceKey(resourceItem.resourceKey).setUrl(resourceItem.url).setZipFileMd5(str), false);
            }
        });
    }

    public static void a(final WarmUpResponse.ResourceItem resourceItem, final int i, final String str, final int i2) {
        i.execute(new bi() { // from class: com.kwad.sdk.resourceCache.c.6
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.sdk.commercial.c.d((com.kwad.sdk.commercial.c.a) new WarmUpReportMessage().setDownloadStatus(6).setResourceType(i).setResourceKey(resourceItem.resourceKey).setUrl(resourceItem.url).setZipFileMd5(str).setErrorCode(i2), true);
            }
        });
    }

    public static void a(final List<WarmUpResponse.ResourceItem> list, final List<WarmUpResponse.ResourceItem> list2, final int i) {
        i.execute(new bi() { // from class: com.kwad.sdk.resourceCache.c.7
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                try {
                    com.kwad.sdk.commercial.c.b(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.buy, new WarmUpReportMessage().setFreeDisk(i).setConfigItems(ac.Y(new ArrayList(list)).toString()).setLocalItems(ac.Y(new ArrayList(list2)).toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

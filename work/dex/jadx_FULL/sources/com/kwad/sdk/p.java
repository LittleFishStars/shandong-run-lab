package com.kwad.sdk;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.model.SDKInitMsg;
import com.kwad.sdk.utils.bi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public final class p {
    private static int aGM;

    public static void a(final com.kwai.adclient.kscommerciallogger.model.d dVar, final String str) {
        com.kwad.sdk.utils.i.execute(new bi() { // from class: com.kwad.sdk.p.7
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.sdk.commercial.c.a(ILoggerReporter.Category.ERROR_LOG, dVar, new SDKInitMsg().setInitCount(p.aGM).setErrorReason(str).setInitStatus(2));
            }
        });
    }

    public static void ap(long j) {
        final long jCurrentTimeMillis = j > 0 ? System.currentTimeMillis() - j : -1L;
        aGM++;
        com.kwad.sdk.utils.i.execute(new bi() { // from class: com.kwad.sdk.p.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.sdk.commercial.c.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.buy, new SDKInitMsg().setLaunchIntervalTime(jCurrentTimeMillis).setInitCount(p.aGM).setInitStatus(0));
            }
        });
    }

    public static void aq(final long j) {
        if (j > 10000) {
            j = -1;
        }
        com.kwad.sdk.utils.i.execute(new bi() { // from class: com.kwad.sdk.p.2
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.sdk.commercial.c.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.buy, new SDKInitMsg().setTotalDurationTime(j).setInitCount(p.aGM).setInitStatus(1));
            }
        });
    }

    public static void ar(final long j) {
        if (j > 10000) {
            j = -1;
        }
        com.kwad.sdk.utils.i.execute(new bi() { // from class: com.kwad.sdk.p.3
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.sdk.commercial.c.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.buy, new SDKInitMsg().setTotalDurationTime(j).setInitCount(p.aGM).setInitStatus(6));
            }
        });
    }

    public static void as(final long j) {
        if (j > 10000) {
            j = -1;
        }
        com.kwad.sdk.utils.i.execute(new bi() { // from class: com.kwad.sdk.p.4
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.sdk.commercial.c.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.buy, new SDKInitMsg().setTotalDurationTime(j).setInitCount(p.aGM).setInitStatus(3));
            }
        });
    }

    public static void at(final long j) {
        if (j > 10000) {
            j = -1;
        }
        com.kwad.sdk.utils.i.execute(new bi() { // from class: com.kwad.sdk.p.5
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.sdk.commercial.c.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.buy, new SDKInitMsg().setTotalDurationTime(j).setInitCount(p.aGM).setInitStatus(4));
            }
        });
    }

    public static void au(final long j) {
        if (j > 10000) {
            j = -1;
        }
        com.kwad.sdk.utils.i.execute(new bi() { // from class: com.kwad.sdk.p.6
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.sdk.commercial.c.a(ILoggerReporter.Category.APM_LOG, com.kwai.adclient.kscommerciallogger.model.a.buy, new SDKInitMsg().setTotalDurationTime(j).setInitCount(p.aGM).setInitStatus(5));
            }
        });
    }
}

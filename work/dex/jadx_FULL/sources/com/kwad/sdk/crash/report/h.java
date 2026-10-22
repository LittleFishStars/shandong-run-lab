package com.kwad.sdk.crash.report;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class h {
    private static void a(ReportEvent reportEvent) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(reportEvent);
        try {
            com.kwad.sdk.crash.report.request.b.a(arrayList, null);
        } catch (Throwable unused) {
        }
    }

    public static void ak(String str, String str2) {
        a(al(str, str2));
    }

    private static ReportEvent al(String str, String str2) {
        ReportEvent reportEvent = new ReportEvent();
        reportEvent.clientTimeStamp = System.currentTimeMillis();
        reportEvent.timeZone = Calendar.getInstance().getTimeZone().getID();
        reportEvent.statPackage = new ReportEvent.StatPackage();
        ReportEvent.CustomStatEvent customStatEvent = new ReportEvent.CustomStatEvent();
        customStatEvent.key = str;
        customStatEvent.value = str2;
        reportEvent.statPackage.customStatEvent = customStatEvent;
        return reportEvent;
    }

    private static void a(List<ReportEvent> list, com.kwad.sdk.crash.report.request.b.a aVar) {
        try {
            com.kwad.sdk.crash.report.request.b.a(list, null, aVar);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, List<String> list, com.kwad.sdk.crash.report.request.b.a aVar) {
        if (list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(al(str, it.next()));
        }
        a(arrayList, aVar);
    }
}

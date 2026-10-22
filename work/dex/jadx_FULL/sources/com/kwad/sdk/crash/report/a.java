package com.kwad.sdk.crash.report;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.crash.model.message.ExceptionMessage;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {
    public static void b(@NonNull ExceptionMessage exceptionMessage) {
        n nVar = new n(10211L);
        nVar.errorMsg = exceptionMessage.getReportMsg();
        com.kwad.sdk.core.report.g.a(nVar);
    }
}

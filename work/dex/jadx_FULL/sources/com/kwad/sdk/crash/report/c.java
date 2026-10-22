package com.kwad.sdk.crash.report;

import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class c implements e {
    private ArrayList<a> bfD = new ArrayList<>();

    public static class a {
        private ExceptionMessage bfE;
        private int bfF;

        public a(ExceptionMessage exceptionMessage, int i) {
            this.bfE = exceptionMessage;
            this.bfF = i;
        }
    }

    private void QG() {
        if (this.bfD.isEmpty()) {
            return;
        }
        try {
            Iterator<a> it = this.bfD.iterator();
            while (it.hasNext()) {
                a next = it.next();
                b(next.bfE, next.bfF, null);
                it.remove();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    private void b(ExceptionMessage exceptionMessage, int i, @Nullable CountDownLatch countDownLatch) {
        if (exceptionMessage == null || !c(exceptionMessage)) {
            return;
        }
        if (i == 3) {
            com.kwad.sdk.crash.report.a.b(exceptionMessage);
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(com.kwad.sdk.crash.report.request.c.d(exceptionMessage));
        com.kwad.sdk.crash.report.request.b.a(arrayList, countDownLatch);
    }

    private boolean c(ExceptionMessage exceptionMessage) {
        try {
            com.kwad.sdk.crash.e eVarQd = com.kwad.sdk.crash.e.Qd();
            if (eVarQd.Qi() != null && eVarQd.Qh() != 2) {
                List<com.kwad.sdk.crash.a> list = eVarQd.Qi().bdU;
                double d = eVarQd.Qi().bdv;
                String appId = eVarQd.getAppId();
                String sdkVersion = eVarQd.getSdkVersion();
                for (com.kwad.sdk.crash.a aVar : list) {
                    if (aVar != null && (com.kwad.sdk.crash.utils.c.b(aVar.bds) || aVar.bds.contains(appId))) {
                        if (com.kwad.sdk.crash.utils.c.b(aVar.bdt) || aVar.bdt.contains(sdkVersion)) {
                            if (com.kwad.sdk.crash.utils.c.b(aVar.bdu) || a(exceptionMessage.mCrashDetail, aVar.bdu)) {
                                d = aVar.bdv;
                            }
                        }
                    }
                }
                return Math.random() < d;
            }
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w("BaseExceptionUploader", Log.getStackTraceString(e));
            return true;
        }
    }

    public final void a(ExceptionMessage exceptionMessage, int i, @Nullable CountDownLatch countDownLatch) {
        try {
            QG();
            b(exceptionMessage, i, countDownLatch);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            this.bfD.add(new a(exceptionMessage, i));
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }

    private static boolean a(String str, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }
}

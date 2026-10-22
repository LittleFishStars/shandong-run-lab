package com.kwad.sdk.crash.utils;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class f {

    public static abstract class a {
        private a() {
        }

        public abstract Object QM();

        public abstract void println(Object obj);

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public static class b extends a {
        private final PrintWriter bgn;

        public b(PrintWriter printWriter) {
            super((byte) 0);
            this.bgn = printWriter;
        }

        @Override // com.kwad.sdk.crash.utils.f.a
        public final Object QM() {
            return this.bgn;
        }

        @Override // com.kwad.sdk.crash.utils.f.a
        public final void println(Object obj) {
            this.bgn.println(obj);
        }
    }

    public static void a(Throwable th, PrintWriter printWriter) {
        a(th, new b(printWriter));
    }

    private static void a(Throwable th, a aVar) {
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        setNewSetFromMap.add(th);
        synchronized (aVar.QM()) {
            aVar.println(th);
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                aVar.println("\tat " + stackTraceElement);
            }
            for (Throwable th2 : th.getSuppressed()) {
                a(th2, aVar, "Suppressed: ", "\t", setNewSetFromMap);
            }
            Throwable cause = th.getCause();
            if (cause != null) {
                a(cause, aVar, "Caused by: ", "", setNewSetFromMap);
            }
        }
    }

    private static void a(Throwable th, a aVar, String str, String str2, Set<Throwable> set) {
        while (!set.contains(th)) {
            set.add(th);
            StackTraceElement[] stackTrace = th.getStackTrace();
            aVar.println(str2 + str + th);
            int length = stackTrace.length;
            for (int i = 0; i < length; i++) {
                aVar.println(str2 + "\tat " + stackTrace[i]);
            }
            for (Throwable th2 : th.getSuppressed()) {
                a(th2, aVar, "Suppressed: ", str2 + "\t", set);
            }
            th = th.getCause();
            if (th == null) {
                return;
            } else {
                str = "Caused by: ";
            }
        }
        aVar.println("\t[CIRCULAR REFERENCE:" + th + "]");
    }
}

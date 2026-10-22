package com.kwad.sdk.core.d;

import android.util.Log;
import com.ksad.annotation.invoker.ForInvoker;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class c {
    public static boolean aSP = true;
    private static boolean aSQ = com.kwad.sdk.core.d.a.pe.booleanValue();
    private static final com.kwad.sdk.core.d.a.a aSR = new b();
    private static final List<com.kwad.sdk.core.d.a.a> aSS = new CopyOnWriteArrayList();

    public interface a {
        void b(com.kwad.sdk.core.d.a.a aVar);
    }

    private static String DH() {
        int lineNumber;
        String fileName;
        if (!aSQ) {
            return "";
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length > 3) {
            fileName = stackTrace[3].getFileName();
            lineNumber = stackTrace[3].getLineNumber();
        } else {
            lineNumber = -1;
            fileName = "unknown";
        }
        return "(" + fileName + com.google.common.net.c.b + lineNumber + ')';
    }

    @ForInvoker(methodId = "registerLogger")
    private static void Me() {
        com.kwad.sdk.commercial.g.a.register();
    }

    private static void U(final String str, final String str2) {
        a(new a() { // from class: com.kwad.sdk.core.d.c.1
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.d(str, str2);
            }
        });
    }

    private static void V(String str, String str2) {
        if (str2 == null || str2.length() <= 4000) {
            U(str, str2);
        } else {
            U(str, str2.substring(0, 4000));
            V(str, str2.substring(4000));
        }
    }

    public static void W(final String str, String str2) {
        final String strEJ = eJ(str2);
        a(new a() { // from class: com.kwad.sdk.core.d.c.5
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.v(c.eI(str), strEJ, true);
            }
        });
    }

    public static void a(com.kwad.sdk.core.d.a.a aVar) {
        List<com.kwad.sdk.core.d.a.a> list = aSS;
        if (list.contains(aVar)) {
            return;
        }
        list.add(aVar);
    }

    public static void c(final String str, String str2, String str3) {
        final String strEJ = eJ(str2 + '\n' + str3);
        a(new a() { // from class: com.kwad.sdk.core.d.c.10
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.e(c.eI(str), strEJ);
            }
        });
    }

    public static void d(String str, String str2) {
        V(eI(str), eJ(str2));
    }

    public static void e(final String str, String str2) {
        final String strEJ = eJ(str2);
        a(new a() { // from class: com.kwad.sdk.core.d.c.9
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.e(c.eI(str), strEJ);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String eI(String str) {
        return "KSAd_" + str;
    }

    private static String eJ(String str) {
        return str + " " + DH();
    }

    public static void i(final String str, String str2) {
        final String strEJ = eJ(str2);
        a(new a() { // from class: com.kwad.sdk.core.d.c.6
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.i(c.eI(str), strEJ);
            }
        });
    }

    public static void init(boolean z) {
        aSP = z;
        List<com.kwad.sdk.core.d.a.a> list = aSS;
        list.clear();
        list.add(aSR);
        Me();
    }

    public static void printStackTrace(final Throwable th) {
        if (th != null) {
            a(new a() { // from class: com.kwad.sdk.core.d.c.2
                @Override // com.kwad.sdk.core.d.c.a
                public final void b(com.kwad.sdk.core.d.a.a aVar) {
                    aVar.printStackTraceOnly(th);
                }
            });
        }
        if (com.kwad.sdk.core.d.a.pe.booleanValue()) {
            throw new RuntimeException(th);
        }
    }

    public static void printStackTraceOnly(final Throwable th) {
        if (th != null) {
            a(new a() { // from class: com.kwad.sdk.core.d.c.3
                @Override // com.kwad.sdk.core.d.c.a
                public final void b(com.kwad.sdk.core.d.a.a aVar) {
                    aVar.printStackTraceOnly(th);
                }
            });
        }
    }

    public static void v(final String str, String str2) {
        final String strEJ = eJ(str2);
        a(new a() { // from class: com.kwad.sdk.core.d.c.4
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.v(c.eI(str), strEJ);
            }
        });
    }

    public static void w(final String str, String str2) {
        final String strEJ = eJ(str2);
        a(new a() { // from class: com.kwad.sdk.core.d.c.7
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.w(c.eI(str), strEJ);
            }
        });
    }

    public static void d(String str, Throwable th) {
        d(str, th.getMessage());
    }

    private static void a(a aVar) {
        for (com.kwad.sdk.core.d.a.a aVar2 : aSS) {
            if (aVar2 != null) {
                try {
                    aVar.b(aVar2);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static void e(final String str, String str2, Throwable th) {
        final String strEJ = eJ(str2 + '\n' + Log.getStackTraceString(th));
        a(new a() { // from class: com.kwad.sdk.core.d.c.11
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.e(c.eI(str), strEJ);
            }
        });
    }

    public static void w(final String str, Throwable th) {
        final String strEJ = eJ(Log.getStackTraceString(th));
        a(new a() { // from class: com.kwad.sdk.core.d.c.8
            @Override // com.kwad.sdk.core.d.c.a
            public final void b(com.kwad.sdk.core.d.a.a aVar) {
                aVar.w(c.eI(str), strEJ, com.kwad.sdk.core.d.a.pe.booleanValue());
            }
        });
    }
}

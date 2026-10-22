package com.kwad.sdk.core.download;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.LruHashMap;
import com.kwad.sdk.utils.an;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b {
    public static final WeakHashMap<String, Integer> aRY = new WeakHashMap<>();
    private static final Map<String, Integer> aRZ = Collections.synchronizedMap(new LruHashMap(10));
    private static final Map<String, String> aSa = new LruHashMap(10);
    private final WeakHashMap<c, AdTemplate> aKQ;
    private final Map<c, AdTemplate> aKR;
    private final com.kwad.sdk.app.a aSb;
    private volatile boolean mHasInit;

    public static final class a {
        static final b aSj = new b(0);
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static b Lz() {
        return a.aSj;
    }

    private void V(final String str) {
        final e eVar = new e();
        b(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                String strQo = cVar.qo();
                b.aRZ.put(strQo, 12);
                cVar.b(strQo, str, eVar);
            }
        });
    }

    private void W(final String str) {
        final e eVar = new e();
        b(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                String strQo = cVar.qo();
                b.aRZ.put(strQo, 0);
                cVar.f(strQo, eVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void de(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        W(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eF(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        V(str);
        com.kwad.sdk.d dVarEA = com.kwad.sdk.c.Ey().EA();
        if (dVarEA != null) {
            dVarEA.cM(str);
        }
    }

    public static int ey(String str) {
        Integer num;
        if (TextUtils.isEmpty(str) || (num = aRZ.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final List<AdTemplate> FA() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.aKR) {
            for (AdTemplate adTemplate : this.aKR.values()) {
                if (adTemplate != null) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }

    public final void S(final String str, final String str2) {
        final e eVar = new e();
        aRZ.put(str, 8);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.9
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.a(str, str2, eVar);
            }
        });
    }

    public final synchronized void bS(Context context) {
        if (!this.mHasInit || context == null) {
            return;
        }
        try {
            com.kwad.sdk.app.b.HO().b(this.aSb);
            this.aKR.clear();
            this.mHasInit = false;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    public final void c(final String str, int i, final String str2) {
        aRZ.put(str, 7);
        final e eVar = new e();
        final int i2 = 0;
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.10
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.a(str, i2, str2, eVar);
            }
        });
    }

    public final void eA(final String str) {
        final e eVar = new e();
        aRZ.put(str, 4);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.11
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.b(str, eVar);
            }
        });
    }

    public final void eB(final String str) {
        final e eVar = new e();
        aRZ.put(str, 1);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.12
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.c(str, eVar);
            }
        });
    }

    public final void eC(final String str) {
        final e eVar = new e();
        aRZ.put(str, 5);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.13
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.d(str, eVar);
            }
        });
    }

    public final void eD(final String str) {
        final e eVar = new e();
        aRZ.put(str, 9);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.14
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.e(str, eVar);
            }
        });
    }

    public final void eE(final String str) {
        final e eVar = new e();
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.g(str, eVar);
            }
        });
    }

    public final void ez(final String str) {
        aRZ.put(str, 1);
        final e eVar = new e();
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.7
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.a(str, eVar);
            }
        });
    }

    public final void g(final String str, final Throwable th) {
        final e eVar = new e();
        aRZ.put(str, 11);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.a(str, th, eVar);
            }
        });
    }

    public final synchronized void init(Context context) {
        if (!this.mHasInit && context != null) {
            com.kwad.sdk.c.Ey().a(new com.kwad.sdk.b() { // from class: com.kwad.sdk.core.download.b.1
                private static String l(DownloadTask downloadTask) {
                    String url = downloadTask.getUrl();
                    String str = (String) b.aSa.get(url);
                    if (!TextUtils.isEmpty(str)) {
                        return str;
                    }
                    String strMd5 = an.md5(downloadTask.getUrl());
                    b.aSa.put(url, strMd5);
                    return strMd5;
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void a(DownloadTask downloadTask, int i, int i2) {
                    b.this.a(l(downloadTask), i2 > 0 ? (int) ((i * 100.0f) / i2) : 0, i, i2);
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void b(DownloadTask downloadTask) {
                    if (downloadTask.getSmallFileSoFarBytes() == 0) {
                        if (com.kwad.framework.a.a.pe.booleanValue()) {
                            com.kwad.sdk.core.d.c.d("DownloadStatusManager", "onDownloadStart(), id=" + l(downloadTask));
                        }
                        b.this.ez(l(downloadTask));
                    }
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void c(DownloadTask downloadTask) {
                    b.this.eA(l(downloadTask));
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void d(DownloadTask downloadTask) {
                    b.this.eC(l(downloadTask));
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void e(DownloadTask downloadTask) {
                    String strL = l(downloadTask);
                    int i = downloadTask.downloadType;
                    if (i != 0) {
                        b.aRY.put(strL, Integer.valueOf(i));
                    }
                    b.this.eB(strL);
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void f(DownloadTask downloadTask) {
                    b.this.eE(l(downloadTask));
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void a(DownloadTask downloadTask) {
                    b.this.S(l(downloadTask), downloadTask.getTargetFilePath());
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void a(DownloadTask downloadTask, Throwable th) {
                    String str;
                    if (th == null || th.getStackTrace().length <= 0) {
                        str = "";
                    } else {
                        str = th.getMessage() + " @ " + th.getStackTrace()[0].getFileName() + th.getStackTrace()[0].getClassName() + th.getStackTrace()[0].getLineNumber();
                    }
                    b.this.c(l(downloadTask), 0, str);
                }
            });
            com.kwad.sdk.app.b.HO().a(this.aSb);
            this.mHasInit = true;
        }
    }

    private b() {
        WeakHashMap<c, AdTemplate> weakHashMap = new WeakHashMap<>();
        this.aKQ = weakHashMap;
        this.aKR = Collections.synchronizedMap(weakHashMap);
        this.mHasInit = false;
        this.aSb = new com.kwad.sdk.app.a() { // from class: com.kwad.sdk.core.download.b.6
            @Override // com.kwad.sdk.app.a
            public final void V(String str) {
                b.this.eF(str);
            }

            @Override // com.kwad.sdk.app.a
            public final void W(String str) {
                b.this.de(str);
            }
        };
    }

    private void b(String str, com.kwad.sdk.g.a<c> aVar) {
        Set<c> setKeySet = this.aKR.keySet();
        synchronized (this.aKR) {
            for (c cVar : setKeySet) {
                if (cVar != null && TextUtils.equals(str, cVar.qp())) {
                    try {
                        aVar.accept(cVar);
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                    }
                }
            }
        }
    }

    public final void a(c cVar, AdTemplate adTemplate) {
        this.aKR.put(cVar, adTemplate);
    }

    public final void a(c cVar) {
        this.aKR.remove(cVar);
    }

    public final void a(final String str, final int i, final int i2, final int i3) {
        aRZ.put(str, 2);
        a(str, new com.kwad.sdk.g.a<c>() { // from class: com.kwad.sdk.core.download.b.8
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void accept(c cVar) {
                cVar.a(str, i, i2, i3);
            }
        });
    }

    private void a(String str, com.kwad.sdk.g.a<c> aVar) {
        Set<c> setKeySet = this.aKR.keySet();
        synchronized (this.aKR) {
            for (c cVar : setKeySet) {
                if (cVar != null && TextUtils.equals(cVar.qo(), str)) {
                    try {
                        aVar.accept(cVar);
                    } catch (Exception e) {
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                    }
                }
            }
        }
    }
}

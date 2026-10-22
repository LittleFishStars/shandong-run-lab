package com.byazt.aas;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 9})
public class aw {
    public static volatile aw c;
    public String tt;
    public final Set<String> ve = Collections.synchronizedSet(new HashSet());

    @com.byazt.zqa.c(c = {0, 1, 131, 665})
    public static class c {
        public final String c;
        public final AtomicInteger tt = new AtomicInteger(0);
        public final AtomicInteger ve = new AtomicInteger(0);

        public c(String str) {
            this.c = str;
        }

        public void c() {
            this.tt.incrementAndGet();
        }

        public int n() {
            return this.ve.get();
        }

        public void tt() {
            this.ve.incrementAndGet();
        }

        public int uj() {
            return this.tt.get();
        }

        public String ve() {
            return this.c;
        }
    }

    private void tt(File file) {
        try {
            if (file.exists()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (file.setLastModified(jCurrentTimeMillis)) {
                    return;
                }
                file.renameTo(file);
                if (file.lastModified() < jCurrentTimeMillis) {
                    com.byazt.nr.m.tt("WebCacheResourceManager", "Last modified date " + new Date(file.lastModified()) + " is not set for file " + file.getAbsolutePath());
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ve(String str) {
        File file = new File(tt(), str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static aw c() {
        if (c == null) {
            synchronized (aw.class) {
                if (c == null) {
                    c = new aw();
                }
            }
        }
        return c;
    }

    private String tt() {
        if (TextUtils.isEmpty(this.tt)) {
            try {
                File file = new File(com.byazt.nr.sp.tt(com.byazt.omf.gt.getContext(), false, null), "tt_web_resource");
                if (!file.exists()) {
                    file.mkdirs();
                }
                this.tt = file.getAbsolutePath();
            } catch (Throwable th) {
                com.byazt.nr.m.uj("WebCacheResourceManager", "init root path error: ".concat(String.valueOf(th)));
            }
        }
        return this.tt;
    }

    public void c(Set<com.byazt.ete.d.ve> set, com.byazt.ete.d.c cVar) {
        tt(set, cVar);
        Iterator<com.byazt.ete.d.ve> it = set.iterator();
        while (it.hasNext()) {
            c(it.next(), cVar);
        }
    }

    private void c(final com.byazt.ete.d.ve veVar, final com.byazt.ete.d.c cVar) {
        File[] fileArrListFiles;
        com.byazt.ete.d.ve veVarTt;
        com.byazt.ete.d.uj ujVarVe = veVar.ve();
        if (ujVarVe == null) {
            return;
        }
        final String strC = ujVarVe.c();
        if (this.ve.contains(strC)) {
            return;
        }
        File file = new File(tt());
        if (file.exists() && (fileArrListFiles = file.listFiles()) != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    String name = file2.getName();
                    String strSubstring = name.substring(0, name.indexOf("$"));
                    String strSubstring2 = name.substring(name.indexOf("$") + 1);
                    if (!strSubstring.equals(veVar.c())) {
                        continue;
                    } else {
                        if (strSubstring2.equals(com.byazt.nr.a.tt(ujVarVe.tt()))) {
                            return;
                        }
                        com.byazt.nr.x.ve(file2);
                        if (cVar != null && (veVarTt = tt(veVar.c())) != null) {
                            cVar.tt(veVarTt);
                        }
                    }
                }
            }
        }
        this.ve.add(strC);
        File file3 = new File(tt(), com.byazt.nr.a.tt(strC));
        com.byazt.va.tt ttVarUj = com.byazt.hy.n.c().tt().uj();
        ttVarUj.c(strC);
        ttVarUj.c(file3.getParent(), file3.getName());
        ttVarUj.c(new com.byazt.mh.c() { // from class: com.byazt.aas.aw.1
            @Override // com.byazt.mh.c
            public void c(com.byazt.va.uj ujVar, final com.byazt.hm.tt ttVar) {
                aw.this.ve.remove(strC);
                if (ttVar.i() && ttVar.x() != null && ttVar.x().exists()) {
                    com.byazt.bwm.n.c(new com.byazt.bwm.sp("downloadZip") { // from class: com.byazt.aas.aw.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                String absolutePath = ttVar.x().getAbsolutePath();
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                com.byazt.nr.zb.c(absolutePath, aw.this.ve(veVar.uj()));
                                AnonymousClass1 anonymousClass2 = AnonymousClass1.this;
                                com.byazt.ete.d.c cVar2 = cVar;
                                if (cVar2 != null) {
                                    cVar2.c(veVar);
                                }
                            } catch (Throwable th) {
                                StringBuilder sb = new StringBuilder("unzip web resources failed：");
                                AnonymousClass1 anonymousClass3 = AnonymousClass1.this;
                                sb.append(aw.this.ve(veVar.uj()));
                                com.byazt.nr.m.ve("WebCacheResourceManager", sb.toString(), th);
                            }
                            try {
                                ttVar.x().delete();
                            } catch (Throwable unused) {
                            }
                        }
                    }, 5);
                    return;
                }
                com.byazt.nr.m.uj("WebCacheResourceManager", "download resources failed 1：" + strC);
            }

            @Override // com.byazt.mh.c
            public void c(com.byazt.va.uj ujVar, IOException iOException) {
                aw.this.ve.remove(strC);
                com.byazt.nr.m.uj("WebCacheResourceManager", "download resources failed 2：" + strC);
            }
        });
    }

    public void tt(Set<com.byazt.ete.d.ve> set, com.byazt.ete.d.c cVar) {
        File[] fileArrListFiles;
        boolean z;
        com.byazt.ete.d.ve veVarTt;
        File file = new File(tt());
        if (file.exists() && (fileArrListFiles = file.listFiles(new FileFilter() { // from class: com.byazt.aas.aw.2
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2.isDirectory();
            }
        })) != null) {
            for (File file2 : fileArrListFiles) {
                String strSubstring = file2.getName().substring(0, file2.getName().indexOf("$"));
                Iterator<com.byazt.ete.d.ve> it = set.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().c().equals(strSubstring)) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    com.byazt.nr.x.ve(file2);
                    if (cVar != null && (veVarTt = tt(strSubstring)) != null) {
                        cVar.tt(veVarTt);
                    }
                }
            }
        }
    }

    public static com.byazt.ete.d.ve tt(String str) {
        if (com.byazt.ete.d.c().isEmpty()) {
            return null;
        }
        for (com.byazt.ete.d.ve veVar : com.byazt.ete.d.c()) {
            if (veVar.c().equals(str)) {
                return veVar;
            }
        }
        return null;
    }

    private void c(File file) {
        tt(file);
        try {
            com.byazt.omf.x.m().pf().c(file);
        } catch (Throwable unused) {
        }
    }

    public Set<com.byazt.ete.d.ve> c(String str) {
        if (!com.byazt.ete.d.c || com.byazt.ete.d.c().isEmpty()) {
            return null;
        }
        HashSet hashSet = new HashSet();
        try {
            String path = new URL(str).getPath();
            if (path != null && !path.isEmpty()) {
                for (com.byazt.ete.d.ve veVar : com.byazt.ete.d.c()) {
                    if (path.contains(veVar.tt())) {
                        hashSet.add(veVar);
                    }
                }
                return hashSet;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public WebResourceResponse c(WebResourceResponse webResourceResponse, String str, Set<com.byazt.ete.d.ve> set, Map<String, c> map) {
        c cVar;
        com.byazt.ete.d.uj ujVarVe;
        try {
            String path = new URL(str).getPath();
            if (map != null) {
                cVar = map.get(path);
                if (cVar == null) {
                    cVar = new c(path);
                    map.put(path, cVar);
                }
            } else {
                cVar = new c(path);
            }
            String strC = "text/html";
            for (com.byazt.ete.d.ve veVar : set) {
                File file = new File(ve(veVar.uj()), path.substring(path.indexOf(veVar.tt())).replace(veVar.tt(), ""));
                if (file.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    if (webResourceResponse == null && (ujVarVe = veVar.ve()) != null) {
                        for (com.byazt.ete.d.tt ttVar : ujVarVe.ve()) {
                            if (TextUtils.equals(ttVar.tt(), file.getName())) {
                                strC = ttVar.c();
                                break;
                            }
                        }
                        WebResourceResponse webResourceResponse2 = new WebResourceResponse(strC, "utf-8", fileInputStream);
                        try {
                            cVar.c();
                            webResourceResponse = webResourceResponse2;
                        } catch (Exception unused) {
                            return webResourceResponse2;
                        }
                    }
                    webResourceResponse.setData(fileInputStream);
                    c(new File(ve(veVar.uj())));
                    return webResourceResponse;
                }
            }
            cVar.tt();
            return webResourceResponse;
        } catch (Exception unused2) {
            return webResourceResponse;
        }
    }

    public void c(com.byazt.ete.d.c cVar) {
        try {
            for (File file : new File(tt()).listFiles()) {
                if (System.currentTimeMillis() - file.lastModified() >= 604800000) {
                    try {
                        com.byazt.nr.x.ve(file);
                        String name = file.getName();
                        String strSubstring = name.substring(0, name.indexOf("$"));
                        if (cVar != null) {
                            cVar.tt(tt(strSubstring));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
        } catch (Throwable unused2) {
        }
    }
}

package com.byazt.tlc;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.byazt.bwm.sp;
import com.byazt.nr.a;
import com.byazt.nr.m;
import com.byazt.nr.x;
import com.byazt.ol.n;
import com.byazt.omf.gt;
import com.byazt.omf.rh;
import com.byazt.or.da;
import com.byazt.six.uj;
import com.byazt.six.ve;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1664, 13})
public class tt extends ve {
    public static volatile tt c;
    public static AtomicReference<com.byazt.seg.tt> n = new AtomicReference<>(null);
    public static volatile File ve;
    public AtomicBoolean tt = new AtomicBoolean(false);
    public AtomicBoolean uj = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            if (n.get() != null) {
                return;
            }
            File file = new File(c(), "package_ugen_temp.json");
            Long lValueOf = Long.valueOf(file.length());
            if (lValueOf.longValue() > 0 && file.exists() && file.isFile()) {
                byte[] bArr = new byte[lValueOf.intValue()];
                fileInputStream = new FileInputStream(file);
                try {
                    fileInputStream.read(bArr);
                    n.set(com.byazt.seg.tt.tt(new JSONObject(new String(bArr, "utf-8"))));
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                    return;
                } catch (IOException e) {
                    m.c(e);
                    return;
                }
            }
            return;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
        }
        try {
            m.ve("PlayComponentEngineCacheManager", "version init error", th);
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    m.c(e2);
                }
            }
        }
    }

    public static tt tt() {
        if (c == null) {
            synchronized (tt.class) {
                if (c == null) {
                    c = new tt();
                }
            }
        }
        return c;
    }

    public void a() {
        try {
            n();
            File fileC = c();
            if (fileC == null || !fileC.exists()) {
                return;
            }
            if (fileC.getParentFile() != null) {
                x.ve(fileC.getParentFile());
            } else {
                x.ve(fileC);
            }
        } catch (Throwable th) {
            m.c(th);
        }
    }

    public void n() {
        ve.tt(c(), n.get(), "package_ugen_temp.json");
        n.set(null);
    }

    public void sp() {
        com.byazt.seg.tt ttVar = n.get();
        if (ttVar == null || !ttVar.a()) {
            return;
        }
        boolean zC = c(ttVar.getResources());
        if (!zC) {
            n();
        }
        this.uj.set(zC);
    }

    public void uj() {
        try {
            if (this.tt.get()) {
                return;
            }
            boolean z = true;
            this.tt.set(true);
            com.byazt.seg.tt ttVar = new com.byazt.seg.tt(gt.c().c(2));
            com.byazt.seg.tt ttVar2 = n.get();
            if (!ttVar.a()) {
                this.tt.set(false);
                return;
            }
            if (!ve.c(ttVar2, ttVar.ve())) {
                this.tt.set(false);
                return;
            }
            rh.a().post(new Runnable() { // from class: com.byazt.tlc.tt.2
                @Override // java.lang.Runnable
                public void run() {
                    n.c().tt();
                }
            });
            List<com.byazt.ku.c.C0458c> listTt = tt(ttVar, ttVar2);
            if (listTt == null) {
                z = false;
            }
            if (listTt == null) {
                this.tt.set(false);
            }
            if (z && c(ttVar.getResources())) {
                n.set(ttVar);
                ve.c(c(), n.get(), "package_ugen_temp.json");
                tt(listTt);
            }
            sp();
            this.tt.set(false);
        } catch (Throwable unused) {
        }
    }

    public void ve() {
        com.byazt.bwm.n.c(new sp("enginecache-init") { // from class: com.byazt.tlc.tt.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    tt.this.i();
                    tt.this.sp();
                    tt.this.uj();
                } catch (Throwable unused) {
                }
            }
        });
    }

    public boolean x() {
        AtomicBoolean atomicBoolean = this.uj;
        return atomicBoolean != null && atomicBoolean.get();
    }

    @Override // com.byazt.six.ve
    public File c() {
        if (ve == null) {
            try {
                File file = new File(new File(uj.c(), "tt_ugen_pkg"), "engine");
                file.mkdirs();
                ve = file;
            } catch (Throwable th) {
                m.ve("PlayComponentEngineCacheManager", "ge", th);
            }
        }
        return ve;
    }

    private File tt(String str) {
        com.byazt.seg.tt ttVar;
        if (!x() || (ttVar = n.get()) == null) {
            return null;
        }
        for (com.byazt.ku.c.C0458c c0458c : ttVar.getResources()) {
            if (c0458c.c() != null && c0458c.c().equals(str)) {
                File file = new File(c(), a.tt(c0458c.c()));
                String strC = a.c(file);
                if (c0458c.tt() == null || !c0458c.tt().equals(strC)) {
                    return null;
                }
                return file;
            }
        }
        return null;
    }

    public WebResourceResponse c(WebView webView, da.c cVar, String str) {
        File fileTt;
        try {
            if (TextUtils.isEmpty(str) || cVar == da.c.IMAGE || (fileTt = tt(str)) == null) {
                return null;
            }
            return new WebResourceResponse(cVar.getType(), "utf-8", new FileInputStream(fileTt));
        } catch (Throwable th) {
            m.ve("PlayComponentEngineCacheManager", "grwe", th);
            return null;
        }
    }
}

package com.kc.cw.ad.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.kc.cw.ad.DownloadService;
import com.kc.cw.ad.internal.activity.DownloadDialogActivity;
import com.kc.cw.ad.internal.q;
import com.kc.cw.ad.model.ComplianceInfo;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f38810a;
    private WeakReference<Context> b;
    private com.kc.cw.ad.b.a c;
    private int d;
    private String e;
    private boolean f;
    private boolean g;
    private boolean h;
    private b i;
    private com.kc.cw.ad.a.c.b j;
    private ComplianceInfo k;

    private c(Context context) {
        this.b = new WeakReference<>(context);
    }

    public static c a(Context context) {
        if (f38810a == null) {
            synchronized (c.class) {
                try {
                    if (f38810a == null) {
                        f38810a = new c(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f38810a;
    }

    private boolean g() {
        String str;
        b bVar = this.i;
        if (bVar == null) {
            return false;
        }
        if (TextUtils.isEmpty(bVar.a())) {
            str = "apkUrl can not be empty!";
        } else if (TextUtils.isEmpty(this.i.b())) {
            str = "apkName can not be empty!";
        } else {
            if (this.i.b().endsWith(".apk")) {
                return true;
            }
            str = "apkName must endsWith .apk!";
        }
        com.kc.cw.ad.d.b.f.c("ApkDownloadManager", str);
        return false;
    }

    public b a() {
        return this.i;
    }

    public c a(int i) {
        this.d = i;
        return this;
    }

    public c a(com.kc.cw.ad.a.c.b bVar) {
        this.j = bVar;
        return this;
    }

    public c a(com.kc.cw.ad.b.a aVar) {
        this.c = aVar;
        return this;
    }

    public c a(b bVar) {
        this.i = bVar;
        return this;
    }

    public c a(ComplianceInfo complianceInfo) {
        this.k = complianceInfo;
        return this;
    }

    public c a(String str) {
        if (!str.equals(this.e)) {
            this.g = false;
            this.h = false;
        }
        this.e = str;
        return this;
    }

    public c a(boolean z) {
        this.f = z;
        return this;
    }

    public c b(Context context) {
        this.b = new WeakReference<>(context);
        return this;
    }

    public ComplianceInfo b() {
        return this.k;
    }

    public void b(boolean z) {
        StringBuilder sb;
        com.kc.cw.ad.a.c.b bVar = this.j;
        if (bVar != null) {
            if (z) {
                if (this.h) {
                    return;
                } else {
                    this.h = true;
                }
            } else if (this.g) {
                return;
            } else {
                this.g = true;
            }
            List<com.kc.cw.ad.a.c.i> listT = bVar.t();
            if (listT != null) {
                for (int i = 0; i < listT.size(); i++) {
                    com.kc.cw.ad.a.c.i iVar = listT.get(i);
                    if (iVar != null && !TextUtils.isEmpty(iVar.d())) {
                        String strD = iVar.d();
                        if (strD.contains("track=oct")) {
                            if (z) {
                                sb = new StringBuilder();
                                sb.append(strD);
                                sb.append("&opt=5");
                            } else if (this.d != 0) {
                                sb = new StringBuilder();
                                sb.append(strD);
                                sb.append("&opt=");
                                sb.append(this.d);
                            }
                            strD = sb.toString();
                        }
                        new com.kc.cw.ad.internal.i(strD).b();
                    }
                }
            }
        }
    }

    public void c() {
        if (q.a().t() || this.f) {
            e();
            return;
        }
        try {
            if (this.b.get() != null) {
                Intent intent = new Intent(this.b.get(), (Class<?>) DownloadDialogActivity.class);
                intent.setFlags(268435456);
                this.b.get().startActivity(intent);
                com.kc.cw.ad.b.a aVar = this.c;
                if (aVar != null) {
                    aVar.b();
                }
            }
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public void d() {
        com.kc.cw.ad.b.a aVar = this.c;
        if (aVar != null) {
            aVar.c();
        }
    }

    public void e() {
        if (!g()) {
            Log.d("OctopusAd", "startDownloadService download:下载必要参数为null");
            return;
        }
        try {
            if (this.b.get() != null) {
                this.b.get().startService(new Intent(this.b.get(), (Class<?>) DownloadService.class));
            }
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public void f() {
        f38810a = null;
        this.b = null;
    }
}

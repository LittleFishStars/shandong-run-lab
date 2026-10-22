package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.MapsInitializer;
import com.zj.adlib.a7b;
import com.zj.adlib.aoa;
import com.zj.adlib.coa;
import com.zj.adlib.j9b;
import com.zj.adlib.yna;
import com.zj.adlib.zna;
import com.zj.adlib.zwa;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class bs implements hn.a {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f739a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f740a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public by f741a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public aoa f742a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public j9b f743a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public yna f744a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public zna f745a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f746a;
    public long c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f25892a = 0;
    public long b = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f747a = true;
    public long d = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f748b = false;

    public interface a {
        void c();
    }

    public static class b extends db {
        public final String f;

        public b(String str) {
            this.f = str;
        }

        @Override // com.amap.api.col.p0003l.hs
        public final String getIPV6URL() {
            return getURL();
        }

        @Override // com.amap.api.col.p0003l.hs
        public final Map<String, String> getRequestHead() {
            return null;
        }

        @Override // com.amap.api.col.p0003l.hs
        public final String getURL() {
            return this.f;
        }

        @Override // com.amap.api.col.p0003l.hs
        public final boolean isSupportIPV6() {
            return false;
        }
    }

    public bs(aoa aoaVar, String str, Context context, by byVar) throws IOException {
        this.f742a = null;
        this.f744a = yna.b(context.getApplicationContext());
        this.f742a = aoaVar;
        this.f739a = context;
        this.f746a = str;
        this.f741a = byVar;
        f();
    }

    public final void a() {
        try {
            if (!zwa.h0(this.f739a)) {
                by byVar = this.f741a;
                if (byVar != null) {
                    byVar.a(by.a.network_exception);
                    return;
                }
                return;
            }
            h();
            if (fh.f25939a != 1) {
                by byVar2 = this.f741a;
                if (byVar2 != null) {
                    byVar2.a(by.a.amap_exception);
                    return;
                }
                return;
            }
            if (!g()) {
                this.f747a = true;
            }
            if (this.f747a) {
                long jI = i();
                this.c = jI;
                if (jI != -1 && jI != -2) {
                    this.b = jI;
                }
                this.f25892a = 0L;
            }
            by byVar3 = this.f741a;
            if (byVar3 != null) {
                byVar3.m();
            }
            if (this.f25892a >= this.b) {
                onFinish();
            } else {
                e();
                this.f743a.b(this);
            }
        } catch (AMapException e) {
            a7b.m(e, "SiteFileFetch", "download");
            by byVar4 = this.f741a;
            if (byVar4 != null) {
                byVar4.a(by.a.amap_exception);
            }
        } catch (IOException unused) {
            by byVar5 = this.f741a;
            if (byVar5 != null) {
                byVar5.a(by.a.file_io_exception);
            }
        }
    }

    public final void b(long j) {
        by byVar;
        long j2 = this.c;
        if (j2 <= 0 || (byVar = this.f741a) == null) {
            return;
        }
        byVar.a(j2, j);
        this.d = System.currentTimeMillis();
    }

    public final void c(a aVar) {
        this.f740a = aVar;
    }

    public final void d() {
        j9b j9bVar = this.f743a;
        if (j9bVar != null) {
            j9bVar.a();
        }
    }

    public final void e() throws IOException {
        coa coaVar = new coa(this.f746a);
        coaVar.setConnectionTimeout(30000);
        coaVar.setSoTimeout(30000);
        this.f743a = new j9b(coaVar, this.f25892a, this.b, MapsInitializer.getProtocol() == 2);
        this.f745a = new zna(this.f742a.b() + File.separator + this.f742a.c(), this.f25892a);
    }

    public final void f() {
        File file = new File(this.f742a.b() + this.f742a.c());
        if (!file.exists()) {
            this.f25892a = 0L;
            this.b = 0L;
            return;
        }
        this.f747a = false;
        this.f25892a = file.length();
        try {
            long jI = i();
            this.c = jI;
            this.b = jI;
        } catch (IOException unused) {
            by byVar = this.f741a;
            if (byVar != null) {
                byVar.a(by.a.file_io_exception);
            }
        }
    }

    public final boolean g() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f742a.b());
        sb.append(File.separator);
        sb.append(this.f742a.c());
        return new File(sb.toString()).length() >= 10;
    }

    public final void h() throws AMapException {
        if (fh.f25939a != 1) {
            for (int i = 0; i < 3; i++) {
                try {
                    fh.c(this.f739a, zwa.t(), "", null);
                    if (fh.f25939a == 1) {
                        return;
                    }
                } catch (Throwable th) {
                    a7b.m(th, "SiteFileFetch", "authOffLineDownLoad");
                    th.printStackTrace();
                }
            }
        }
    }

    public final long i() throws IOException {
        Map<String, String> mapM;
        if (fo.a(this.f739a, zwa.t()).f26036a != fo.c.SuccessCode) {
            return -1L;
        }
        String strA = this.f742a.a();
        try {
            w.j();
            mapM = w.m(new b(strA), MapsInitializer.getProtocol() == 2);
        } catch (ff e) {
            e.printStackTrace();
            mapM = null;
        }
        int i = -1;
        if (mapM != null) {
            for (String str : mapM.keySet()) {
                if ("Content-Length".equalsIgnoreCase(str)) {
                    i = Integer.parseInt(mapM.get(str));
                }
            }
        }
        return i;
    }

    public final void j() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.f742a == null || jCurrentTimeMillis - this.d <= 500) {
            return;
        }
        k();
        this.d = jCurrentTimeMillis;
        b(this.f25892a);
    }

    public final void k() {
        this.f744a.f(this.f742a.e(), this.f742a.d(), this.c, this.f25892a, this.b);
    }

    @Override // com.amap.api.col.3l.hn.a
    public final void onDownload(byte[] bArr, long j) {
        try {
            this.f745a.a(bArr);
            this.f25892a = j;
            j();
        } catch (IOException e) {
            e.printStackTrace();
            a7b.m(e, "fileAccessI", "fileAccessI.write(byte[] data)");
            by byVar = this.f741a;
            if (byVar != null) {
                byVar.a(by.a.file_io_exception);
            }
            j9b j9bVar = this.f743a;
            if (j9bVar != null) {
                j9bVar.a();
            }
        }
    }

    @Override // com.amap.api.col.3l.hn.a
    public final void onException(Throwable th) {
        zna znaVar;
        this.f748b = true;
        d();
        by byVar = this.f741a;
        if (byVar != null) {
            byVar.a(by.a.network_exception);
        }
        if ((th instanceof IOException) || (znaVar = this.f745a) == null) {
            return;
        }
        znaVar.b();
    }

    @Override // com.amap.api.col.3l.hn.a
    public final void onFinish() {
        j();
        by byVar = this.f741a;
        if (byVar != null) {
            byVar.n();
        }
        zna znaVar = this.f745a;
        if (znaVar != null) {
            znaVar.b();
        }
        a aVar = this.f740a;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.amap.api.col.3l.hn.a
    public final void onStop() {
        if (this.f748b) {
            return;
        }
        by byVar = this.f741a;
        if (byVar != null) {
            byVar.o();
        }
        k();
    }
}

package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import com.zj.adlib.a7b;
import com.zj.adlib.boa;
import com.zj.adlib.gia;
import com.zj.adlib.j9b;
import com.zj.adlib.p4b;
import com.zj.adlib.pwa;
import com.zj.adlib.zwa;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class b0 implements hn.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f25888a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f734a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public j9b f735a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RandomAccessFile f736a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f737a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f25889a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f738a;
        public String b;
        public String c;
        public String d;
        public String e;

        public a(String str, String str2, String str3, String str4) {
            this.f738a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4 + ".tmp";
            this.e = str4;
        }

        public final String a() {
            return this.f738a;
        }

        public final void b(c cVar) {
            this.f25889a = cVar;
        }

        public final String c() {
            return this.b;
        }

        public final String d() {
            return this.d;
        }

        public final String e() {
            return this.e;
        }

        public final c f() {
            return this.f25889a;
        }
    }

    public static class b extends db {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f25890a;

        public b(a aVar) {
            this.f25890a = aVar;
        }

        @Override // com.amap.api.col.p0003l.hs
        public final String getIPV6URL() {
            return getURL();
        }

        @Override // com.amap.api.col.p0003l.db, com.amap.api.col.p0003l.hs
        public final Map<String, String> getParams() {
            return null;
        }

        @Override // com.amap.api.col.p0003l.hs
        public final Map<String, String> getRequestHead() {
            return null;
        }

        @Override // com.amap.api.col.p0003l.hs
        public final String getURL() {
            a aVar = this.f25890a;
            if (aVar != null) {
                return aVar.a();
            }
            return null;
        }

        @Override // com.amap.api.col.p0003l.hs
        public final boolean isSupportIPV6() {
            return false;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f25891a;
        public String b;

        public c(String str, String str2) {
            this.f25891a = str;
            this.b = str2;
        }

        public final String a() {
            return this.f25891a;
        }

        public final String b() {
            return this.b;
        }

        public final boolean c() {
            return (TextUtils.isEmpty(this.f25891a) || TextUtils.isEmpty(this.b)) ? false : true;
        }
    }

    public static class d extends a {
        public d(String str, String str2, String str3, String str4) {
            super(str, str2, str3, str4);
        }

        public final void g(String str, String str2) {
            b(new c(str, str2));
        }
    }

    public b0(Context context, a aVar) {
        this.f25888a = context.getApplicationContext();
        this.f734a = aVar;
        this.f735a = new j9b(new b(aVar));
        this.f737a = aVar.d();
    }

    public final void a() {
        j9b j9bVar;
        if (gia.f41914a == null || fo.a(gia.f41914a, zwa.t()).f26036a == fo.c.SuccessCode) {
            try {
                if (!b() || (j9bVar = this.f735a) == null) {
                    return;
                }
                j9bVar.b(this);
            } catch (Throwable th) {
                a7b.m(th, "AuthTaskDownload", "startDownload()");
            }
        }
    }

    public final boolean b() {
        c cVarF = this.f734a.f();
        return (cVarF != null && cVarF.c() && pwa.b(this.f25888a, cVarF.a(), cVarF.b(), "").equalsIgnoreCase(this.f734a.c())) ? false : true;
    }

    @Override // com.amap.api.col.3l.hn.a
    public final void onDownload(byte[] bArr, long j) {
        try {
            if (this.f736a == null) {
                File file = new File(this.f737a);
                File parentFile = file.getParentFile();
                if (!parentFile.exists()) {
                    parentFile.mkdirs();
                }
                this.f736a = new RandomAccessFile(file, "rw");
            }
            this.f736a.seek(j);
            this.f736a.write(bArr);
        } catch (Throwable th) {
            a7b.m(th, "AuthTaskDownload", "onDownload()");
        }
    }

    @Override // com.amap.api.col.3l.hn.a
    public final void onException(Throwable th) {
        try {
            RandomAccessFile randomAccessFile = this.f736a;
            if (randomAccessFile == null) {
                return;
            }
            randomAccessFile.close();
        } catch (Throwable th2) {
            a7b.m(th2, "AuthTaskDownload", "onException()");
        }
    }

    @Override // com.amap.api.col.3l.hn.a
    public final void onFinish() {
        try {
            RandomAccessFile randomAccessFile = this.f736a;
            if (randomAccessFile == null) {
                return;
            }
            try {
                randomAccessFile.close();
            } catch (Throwable th) {
                a7b.m(th, "AuthTaskDownload", "onFinish3");
            }
            String strC = this.f734a.c();
            String strA = p4b.a(this.f737a);
            if (strA == null || !strC.equalsIgnoreCase(strA)) {
                try {
                    new File(this.f737a).delete();
                    return;
                } catch (Throwable th2) {
                    a7b.m(th2, "AuthTaskDownload", "onFinish");
                    return;
                }
            }
            String strE = this.f734a.e();
            try {
                bp bpVar = new bp();
                File file = new File(this.f737a);
                bpVar.b(file, new File(strE), -1L, boa.b(file), null);
                c cVarF = this.f734a.f();
                if (cVarF != null && cVarF.c()) {
                    pwa.c(this.f25888a, cVarF.a(), cVarF.b(), strA);
                }
                new File(this.f737a).delete();
                return;
            } catch (Throwable th3) {
                a7b.m(th3, "AuthTaskDownload", "onFinish1");
                return;
            }
            a7b.m(th, "AuthTaskDownload", "onFinish()");
        } catch (Throwable th4) {
            a7b.m(th4, "AuthTaskDownload", "onFinish()");
        }
    }

    @Override // com.amap.api.col.3l.hn.a
    public final void onStop() {
    }
}

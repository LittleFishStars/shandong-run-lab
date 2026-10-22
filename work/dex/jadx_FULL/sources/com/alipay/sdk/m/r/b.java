package com.alipay.sdk.m.r;

import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.alipay.sdk.m.y.e;
import com.alipay.sdk.m.y.f;
import com.alipay.sdk.m.y.g;
import com.alipay.sdk.m.y.q;
import com.alipay.sdk.m.y.r;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {
    public com.alipay.sdk.m.w.a b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f25495a = "LocalWebPayManager";
    public String c = null;
    public String d = null;
    public String e = null;
    public String f = null;
    public String g = "0";
    public Map<String, String> h = null;
    public com.alipay.sdk.m.r.a i = null;
    public volatile boolean j = false;

    /* JADX INFO: renamed from: com.alipay.sdk.m.r.b$b, reason: collision with other inner class name */
    public class RunnableC0205b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.alipay.sdk.m.r.a f25497a;
        public final /* synthetic */ com.alipay.sdk.m.s.a.InterfaceC0206a b;

        public RunnableC0205b(com.alipay.sdk.m.r.a aVar, com.alipay.sdk.m.s.a.InterfaceC0206a interfaceC0206a) {
            this.f25497a = aVar;
            this.b = interfaceC0206a;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = b.this.f;
            File file = new File(str);
            if (file.exists()) {
                e.b(str);
            }
            file.mkdir();
            com.alipay.sdk.m.s.a.a(this.f25497a.b(), b.this.f + "/downloading.zip", this.b);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f25498a = new b();
    }

    public static b e() {
        return c.f25498a;
    }

    public final boolean b() {
        File file = new File(this.c);
        try {
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(this.d);
            if (!file2.exists()) {
                file2.mkdir();
            }
            return new File(this.d).exists() && new File(this.e).exists();
        } catch (Throwable th) {
            g.a(th);
        }
    }

    public boolean c() {
        return (this.i == null || this.j || (!TextUtils.equals(this.i.c(), com.alipay.sdk.m.r.a.C0204a.b) && !TextUtils.equals(this.i.c(), com.alipay.sdk.m.r.a.C0204a.c))) ? false : true;
    }

    public void d() {
        g.b(com.alipay.sdk.m.n.a.B, "LocalWebPayManager clearData");
        this.b = null;
        this.g = "0";
        this.i = null;
        this.h = null;
    }

    public String f() {
        g.d("LocalWebPayManager", "getLocalConfigVersion=" + this.g);
        return this.g;
    }

    public final void g() {
        JSONObject jSONObjectD = e.d(this.e);
        g.b(com.alipay.sdk.m.n.a.B, "readContentFromConfigJson jsonConfigJson=" + jSONObjectD);
        if (jSONObjectD != null) {
            try {
                String string = jSONObjectD.getString("version");
                JSONObject jSONObject = jSONObjectD.getJSONObject("homeHtml");
                JSONObject jSONObject2 = jSONObjectD.getJSONObject("fileList");
                this.g = string;
                JSONObject jSONObjectA = f.a(jSONObject, jSONObject2);
                Iterator<String> itKeys = jSONObjectA.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        this.h.put(next, jSONObjectA.getString(next));
                    } catch (Throwable th) {
                        g.a(th);
                    }
                }
            } catch (Throwable th2) {
                g.c("LocalWebPayManager", "readContentFromConfigJson fileContent error");
                g.a(th2);
                com.alipay.sdk.m.m.a.a(this.b, com.alipay.sdk.m.m.b.l, "LocalWebPayManager.readContentFromConfigJsonError", th2);
            }
        }
    }

    public class a implements com.alipay.sdk.m.s.a.InterfaceC0206a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.alipay.sdk.m.r.a f25496a;

        public a(com.alipay.sdk.m.r.a aVar) {
            this.f25496a = aVar;
        }

        @Override // com.alipay.sdk.m.s.a.InterfaceC0206a
        public void a(File file) {
            g.d("LocalWebPayManager", "checkAndUpdateLocalData downloadListener onSuccess");
            b.this.b(this.f25496a);
            b.this.j = false;
        }

        @Override // com.alipay.sdk.m.s.a.InterfaceC0206a
        public void a(Throwable th) {
            g.a(th);
            b.this.j = false;
        }
    }

    @WorkerThread
    public void a(com.alipay.sdk.m.w.a aVar) {
        if (this.b != null) {
            g.c(com.alipay.sdk.m.n.a.B, "LocalWebPayManager.init mBizContext not null");
            com.alipay.sdk.m.m.a.b(aVar, com.alipay.sdk.m.m.b.l, "LocalWebPayManager.init", "mBizContext not null");
            d();
        }
        this.b = aVar;
        String absolutePath = aVar.b().getFilesDir().getAbsolutePath();
        this.c = absolutePath + "/localWebPay";
        this.d = absolutePath + "/localWebPay/localWebFiles";
        this.e = absolutePath + "/localWebPay/localWebFiles/sdkConfig.json";
        this.f = absolutePath + "/localWebPay/localWebPayDownloadingFiles";
        this.h = new HashMap();
        boolean zB = b();
        g.b(com.alipay.sdk.m.n.a.B, "LocalWebPayManager init checkConfigFile=" + zB);
        if (zB) {
            g();
        }
    }

    public final void b(com.alipay.sdk.m.r.a aVar) {
        if (aVar == null) {
            return;
        }
        g.e("LocalWebPayManager", "unzipAndCheckSHA256 dataSHA256:" + aVar.a());
        try {
            File[] fileArrListFiles = new File(this.f).listFiles();
            File file = null;
            for (int i = 0; i < fileArrListFiles.length; i++) {
                if (fileArrListFiles[i].getName().endsWith(".zip")) {
                    file = fileArrListFiles[i];
                }
            }
            String strA = q.a(file);
            g.e("LocalWebPayManager", "unzipAndCheckSHA256 fileSha256:" + strA);
            if (TextUtils.equals(strA, aVar.a())) {
                g.e("LocalWebPayManager", "unzipAndCheckSHA256 unzip");
                r.a(file.getAbsolutePath(), this.f);
                File file2 = new File(this.d);
                File file3 = new File(this.f);
                if (file2.exists()) {
                    e.b(this.d);
                }
                g.e("LocalWebPayManager", "unzipAndCheckSHA256 resultReNameTo:" + file3.renameTo(file2));
            }
        } catch (Throwable th) {
            g.a(th);
            com.alipay.sdk.m.m.a.a(this.b, com.alipay.sdk.m.m.b.l, "LocalWebPayManager.unzipAndCheckSHA256Error", th);
        }
    }

    public void a(com.alipay.sdk.m.r.a aVar) {
        g.d("LocalWebPayManager", "h5LocalData :" + aVar);
        this.i = aVar;
    }

    public void a() {
        g.d("LocalWebPayManager", "checkAndUpdateLocalData isDownloading=" + this.j);
        com.alipay.sdk.m.r.a aVar = this.i;
        if (aVar != null && !this.j && ((TextUtils.equals(aVar.c(), com.alipay.sdk.m.r.a.C0204a.f25494a) || TextUtils.equals(aVar.c(), com.alipay.sdk.m.r.a.C0204a.b)) && !TextUtils.isEmpty(aVar.b()))) {
            this.j = true;
            new Thread(new RunnableC0205b(aVar, new a(aVar))).start();
        } else {
            g.d("LocalWebPayManager", "checkAndUpdateLocalData return");
        }
    }

    public String b(String str) {
        String str2;
        if (c()) {
            String strA = a(str);
            if (TextUtils.isEmpty(this.h.get(strA))) {
                g.e("LocalWebPayManager", "getLocalFilePath get null, url：" + str);
                str2 = "";
            } else {
                str2 = this.d + WVNativeCallbackUtil.SEPERATER + this.h.get(strA);
            }
        } else {
            str2 = "";
        }
        g.b("LocalWebPayManager", "getLocalFilePath result:" + str2);
        return str2;
    }

    public final String a(String str) {
        int iIndexOf;
        return (TextUtils.isEmpty(str) || (iIndexOf = str.indexOf(63)) == -1) ? str : str.substring(0, iIndexOf);
    }
}

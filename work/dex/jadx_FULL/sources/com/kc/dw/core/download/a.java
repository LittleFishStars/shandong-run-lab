package com.kc.dw.core.download;

import android.os.Environment;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<String, d> f39241a = new ConcurrentHashMap<>();
    public g b = new g();
    public String c = com.kc.dw.base.a.getContext().getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/msdownload";

    /* JADX INFO: renamed from: com.kc.dw.core.download.a$a, reason: collision with other inner class name */
    @Keep
    public static class C1023a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f39242a = new a();
    }

    public static a b() {
        return C1023a.f39242a;
    }

    public String a() {
        return this.c;
    }

    public void a(String str) {
        d dVar = this.f39241a.get(str);
        if (dVar != null) {
            ThreadPoolExecutor threadPoolExecutor = dVar.c;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.remove(dVar);
            }
            Map<Object, h> map = dVar.e;
            if (map != null) {
                map.remove(dVar.b);
            }
            try {
                File file = new File(dVar.f39245a.c);
                if (file.exists() && file.isFile()) {
                    LogUtil.e("DownloadTask", "file.delete");
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.f39241a.remove(str);
    }

    public d b(String str) {
        return this.f39241a.get(str);
    }

    public g c() {
        return this.b;
    }
}

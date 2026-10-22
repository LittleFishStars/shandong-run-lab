package com.kc.dw.core.service.logrecord;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.ipd.dsp.internal.l0.g;
import com.kc.dw.core.loader.AdParallelLoader;
import com.kc.dw.core.utils.PackageBean;
import com.kc.dw.core.utils.d1;
import com.kc.dw.core.utils.p0;
import com.kc.dw.core.utils.t;
import com.kc.dw.core.utils.w0;
import com.kc.dw.core.utils.z;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f39315a;
    public static volatile boolean b;
    public static b d;
    public static final List<File> c = Collections.synchronizedList(new ArrayList());
    public static final AtomicInteger e = new AtomicInteger(0);

    @Keep
    public class a implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CountDownLatch[] f39316a;
        public final File b;

        public a(CountDownLatch[] countDownLatchArr, File file) {
            this.f39316a = countDownLatchArr;
            this.b = file;
        }

        public void onFailure(Call call, IOException iOException) {
            Log.e("LogFileHelper", "upload logFile error");
            c.c.clear();
            c.e.incrementAndGet();
            this.f39316a[0].countDown();
        }

        /* JADX WARN: Code duplicated, block: B:11:0x001b A[Catch: all -> 0x0032, Exception -> 0x0034, TRY_LEAVE, TryCatch #2 {Exception -> 0x0034, blocks: (B:4:0x0003, B:10:0x0017, B:11:0x001b), top: B:25:0x0003, outer: #0 }] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v6, types: [java.util.concurrent.CountDownLatch] */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r2v8 */
        /* JADX WARN: Type inference failed for: r2v9 */
        /* JADX WARN: Type inference failed for: r3v8, types: [java.util.concurrent.CountDownLatch[]] */
        public void onResponse(Call call, Response response) throws IOException {
            ?? r2;
            ?? r3 = 0;
            r3 = 0;
            r3 = 0;
            try {
                if (response != null) {
                    try {
                        if (response.code() == 200) {
                            try {
                                this.b.delete();
                                c.e.set(0);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            c.c.clear();
                            c.e.incrementAndGet();
                            Log.e("LogFileHelper", "upload logFile error2");
                        }
                        r3 = this.f39316a[0];
                        r2 = r3;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        r2 = this.f39316a[r3];
                    }
                } else {
                    c.c.clear();
                    c.e.incrementAndGet();
                    Log.e("LogFileHelper", "upload logFile error2");
                    r3 = this.f39316a[0];
                    r2 = r3;
                }
                r2.countDown();
            } catch (Throwable th) {
                this.f39316a[r3].countDown();
                throw th;
            }
        }
    }

    @Keep
    public interface b {
        void a();
    }

    public static void a() {
        if (b) {
            Log.i("LogFileHelper", "clearing return");
            return;
        }
        try {
            b = true;
            File fileC = com.kc.dw.core.bquery.c.c(com.kc.dw.base.a.getContext());
            long length = fileC.length() - g.f;
            if (length > 0) {
                com.kc.dw.core.bquery.c.a(fileC, length);
            }
        } catch (Throwable th) {
            try {
                th.printStackTrace();
            } finally {
                b = false;
            }
        }
    }

    public static /* synthetic */ boolean a(File file, String str) {
        return (str == null || str.endsWith("_temp")) ? false : true;
    }

    public static void b() {
        try {
            b bVar = d;
            if (bVar != null) {
                bVar.a();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void c() {
        String str;
        try {
            File[] fileArrListFiles = com.kc.dw.core.bquery.c.c(com.kc.dw.base.a.getContext()).listFiles(new FilenameFilter() { // from class: com.kc.dw.core.service.logrecord.c$$ExternalSyntheticLambda0
                @Override // java.io.FilenameFilter
                public final boolean accept(File file, String str2) {
                    return c.a(file, str2);
                }
            });
            if ((fileArrListFiles != null ? fileArrListFiles.length : 0) == 0) {
                return;
            }
            c.addAll(Arrays.asList(fileArrListFiles));
            while (true) {
                List<File> list = c;
                if (list.isEmpty()) {
                    return;
                }
                File fileRemove = list.remove(0);
                if (fileRemove != null && fileRemove.exists()) {
                    CountDownLatch[] countDownLatchArr = new CountDownLatch[1];
                    countDownLatchArr[0] = new CountDownLatch(1);
                    String strB = t.b(fileRemove);
                    if (TextUtils.isEmpty(strB)) {
                        t.c(fileRemove);
                        str = "content is null, delete";
                    } else {
                        Charset charset = d1.f39359a;
                        byte[] bArrDecode = Base64.decode(strB, 0);
                        if (bArrDecode == null || bArrDecode.length == 0) {
                            t.c(fileRemove);
                            str = "content byte[] is null, delete";
                        } else {
                            Map<String, String> mapWrapParams = AdParallelLoader.wrapParams(bArrDecode);
                            if (mapWrapParams == null || mapWrapParams.isEmpty()) {
                                str = "map is null, continue";
                            } else {
                                PackageBean.LogBean logBeanB = com.kc.dw.core.utils.b.b();
                                p0.p = logBeanB;
                                z.a(w0.a((logBeanB == null || TextUtils.isEmpty(logBeanB.getUploadUrl())) ? "https://sdk.1rtb.net/sdk/log" : p0.p.getUploadUrl(), mapWrapParams), new a(countDownLatchArr, fileRemove));
                                try {
                                    countDownLatchArr[0].await(10L, TimeUnit.SECONDS);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                    Log.e("LogFileHelper", str);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

package com.kc.dw.core.service.logrecord;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.huachenjie.common.constants.UserConstants;
import com.kc.dw.core.AdSdk;
import com.kc.dw.core.SsdAdConfig;
import com.kc.dw.core.router.log.EventBean;
import com.kc.dw.core.router.log.EventListBean;
import com.kc.dw.core.utils.PackageBean;
import com.kc.dw.core.utils.d1;
import com.kc.dw.core.utils.f0;
import com.kc.dw.core.utils.k;
import com.kc.dw.core.utils.p0;
import com.kc.dw.core.utils.r;
import com.kc.dw.core.utils.v;
import com.kc.dw.core.utils.w0;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.zj.adlib.ze1;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class d implements com.kc.dw.core.router.service.c {
    public static final int j = 0;
    public ConcurrentHashMap<String, Object> b;
    public volatile List<String> c;
    public String e;
    public long f;
    public Runnable i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<EventBean> f39317a = Collections.synchronizedList(new ArrayList());
    public volatile boolean d = false;
    public final Random g = new Random();
    public final Handler h = new Handler(Looper.getMainLooper());

    @Keep
    public class a implements com.kc.dw.core.router.service.a.InterfaceC1044a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f39318a;

        public a(d dVar) {
            this.f39318a = dVar;
        }

        @Override // com.kc.dw.core.router.service.a.InterfaceC1044a
        public void onActivityPause(Activity activity) {
        }

        @Override // com.kc.dw.core.router.service.a.InterfaceC1044a
        public void onActivityResume(Activity activity) {
        }

        @Override // com.kc.dw.core.router.service.a.InterfaceC1044a
        public void onAppStateUpdate(boolean z) {
            if (z) {
                return;
            }
            try {
                this.f39318a.a(true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    static {
        Charset.forName("UTF-8");
    }

    public d() {
        try {
            d();
            com.kc.dw.core.router.helper.a.a(new a(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map a(d dVar) {
        ConcurrentHashMap<String, Object> concurrentHashMap = dVar.b;
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
            return dVar.b;
        }
        ConcurrentHashMap<String, Object> concurrentHashMap2 = new ConcurrentHashMap<>();
        concurrentHashMap2.put("os", 2);
        concurrentHashMap2.put("commit", "a0b7cd6f");
        concurrentHashMap2.put("oem", "1005");
        concurrentHashMap2.put("sdk_code", 3000400L);
        concurrentHashMap2.put("app_ver", w0.o(com.kc.dw.base.a.getContext()));
        String strB = p0.b(com.kc.dw.base.a.getContext());
        if (strB == null) {
            strB = "";
        }
        concurrentHashMap2.put("app_pkg", strB);
        concurrentHashMap2.put(ze1.p, Build.MANUFACTURER);
        concurrentHashMap2.put("brand", Build.BRAND);
        concurrentHashMap2.put(ze1.k, Build.MODEL);
        concurrentHashMap2.put("device_type", Integer.valueOf(k.a()));
        concurrentHashMap2.put("inst_uuid", r.a().a("inst_uuid", ""));
        concurrentHashMap2.put("init_uuid", SsdAdConfig.initUUID());
        HashMap map = new HashMap(4);
        String strA = dVar.a();
        dVar.e = strA;
        if (!TextUtils.isEmpty(strA)) {
            map.put("a", dVar.e);
            dVar.b = concurrentHashMap2;
        }
        String strC = w0.c(com.kc.dw.base.a.getContext());
        map.put("b", strC != null ? strC : "");
        concurrentHashMap2.put(UserConstants.URL_PARAMS.b, map);
        return concurrentHashMap2;
    }

    public static boolean a(d dVar, EventListBean eventListBean, File file) {
        String json;
        String str;
        dVar.getClass();
        String strEncodeToString = null;
        try {
            json = v.f39411a.toJson(eventListBean);
        } catch (Exception e) {
            e.printStackTrace();
            json = null;
        }
        if (TextUtils.isEmpty(json)) {
            str = "content is null, return";
        } else {
            try {
                strEncodeToString = Base64.encodeToString(json.getBytes(d1.f39359a), 0);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (!TextUtils.isEmpty(strEncodeToString)) {
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                    try {
                        bufferedWriter.write(strEncodeToString);
                        bufferedWriter.close();
                        return true;
                    } catch (Throwable th) {
                        try {
                            bufferedWriter.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    return false;
                }
            }
            str = "content64 is null, return";
        }
        Log.e("d", str);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f = System.currentTimeMillis();
        try {
            Runnable runnable = this.i;
            if (runnable != null) {
                this.h.removeCallbacks(runnable);
                this.i = null;
            }
        } catch (Exception unused) {
        }
        try {
            long jB = b();
            if (jB > 0 && !TextUtils.isEmpty(a())) {
                f fVar = new f(this);
                this.i = fVar;
                this.h.postDelayed(fVar, jB);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final String a() {
        if (TextUtils.isEmpty(this.e)) {
            String localOaid = AdSdk.getLocalOaid();
            if (!TextUtils.isEmpty(localOaid)) {
                this.e = localOaid;
            }
        }
        return this.e;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0064 A[Catch: Exception -> 0x0077, TryCatch #0 {Exception -> 0x0077, blocks: (B:3:0x0002, B:6:0x000c, B:8:0x0013, B:11:0x001c, B:14:0x0027, B:16:0x003b, B:29:0x0067, B:31:0x0071, B:19:0x0046, B:23:0x0054, B:28:0x0064), top: B:36:0x0002 }] */
    @Override // com.kc.dw.core.router.service.c
    public void a(int i, EventBean eventBean) {
        boolean z;
        if (eventBean != null) {
            try {
                if (TextUtils.isEmpty(eventBean.event)) {
                    return;
                }
                e();
                if (this.c != null && !this.c.isEmpty() && this.c.contains(eventBean.event)) {
                    this.f39317a.add(eventBean);
                    if (this.f39317a.size() > p0.a(10)) {
                        a(false);
                    } else {
                        if (!TextUtils.isEmpty(a())) {
                            long jB = b();
                            if (this.i == null && jB > 0 && System.currentTimeMillis() - this.f >= jB) {
                                z = true;
                            }
                            if (z) {
                                a(false);
                            }
                        }
                        z = false;
                        if (z) {
                            a(false);
                        }
                    }
                    if (this.f39317a.size() > 200) {
                        this.f39317a.remove(0);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void a(boolean z) {
        if (this.f39317a.isEmpty()) {
            if (c()) {
                ExecutorService executorService = f0.f39362a;
                f0.b.f39363a.a(new e(this, null));
                return;
            }
            return;
        }
        List<EventBean> listSubList = this.f39317a.subList(0, z ? this.f39317a.size() : Math.min(this.f39317a.size(), p0.a(10)));
        ArrayList arrayList = new ArrayList(listSubList);
        listSubList.clear();
        ExecutorService executorService2 = f0.f39362a;
        f0.b.f39363a.a(new e(this, arrayList));
    }

    public final long b() {
        int iIntValue;
        Integer backGroundTimeDur;
        if (com.kc.dw.core.service.c.a()) {
            PackageBean.LogBean logBeanB = com.kc.dw.core.utils.b.b();
            p0.p = logBeanB;
            if (logBeanB == null || logBeanB.getTimeDur() == null) {
                iIntValue = 10;
            } else {
                backGroundTimeDur = p0.p.getTimeDur();
                iIntValue = backGroundTimeDur.intValue();
            }
        } else {
            PackageBean.LogBean logBeanB2 = com.kc.dw.core.utils.b.b();
            p0.p = logBeanB2;
            if (logBeanB2 == null || logBeanB2.getBackGroundTimeDur() == null) {
                iIntValue = 60;
            } else {
                backGroundTimeDur = p0.p.getBackGroundTimeDur();
                iIntValue = backGroundTimeDur.intValue();
            }
        }
        return ((long) iIntValue) * 1000;
    }

    public final boolean c() {
        boolean z;
        if (!this.f39317a.isEmpty()) {
            return true;
        }
        boolean z2 = c.f39315a;
        try {
            File[] fileArrListFiles = com.kc.dw.core.bquery.c.c(com.kc.dw.base.a.getContext()).listFiles();
            z = fileArrListFiles != null && fileArrListFiles.length > 0;
        } catch (Exception unused) {
        }
        return z;
    }

    public final void d() {
        c.d = new c.b(this) { // from class: com.kc.dw.core.service.logrecord.d$$ExternalSyntheticLambda0
            public final d f$0;

            {
                this.f$0 = this;
            }

            @Override // com.kc.dw.core.service.logrecord.c.b
            public final void a() {
                this.f$0.f();
            }
        };
    }

    public final void e() {
        try {
            if (!this.d || this.c == null || this.c.isEmpty()) {
                PackageBean.LogBean logBeanB = com.kc.dw.core.utils.b.b();
                p0.p = logBeanB;
                String[] uploadEvents = logBeanB != null ? logBeanB.getUploadEvents() : null;
                if (uploadEvents != null && uploadEvents.length > 0) {
                    this.c = Arrays.asList(uploadEvents);
                    this.d = true;
                } else if (this.c == null || this.c.isEmpty()) {
                    this.c = new ArrayList(Arrays.asList("e1", "s1", "s3", "e5", "s5", "e6", "e7", "s7", "f7", "e8"));
                    this.d = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

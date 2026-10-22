package cj.mobile.jt.core;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import cj.mobile.jt.common.lifecycle.f;
import cj.mobile.jt.common.utils.e0;
import cj.mobile.jt.common.utils.e1;
import cj.mobile.jt.common.utils.h;
import cj.mobile.jt.common.utils.h1;
import cj.mobile.jt.common.utils.i1;
import cj.mobile.jt.common.utils.j;
import cj.mobile.jt.common.utils.j0;
import cj.mobile.jt.common.utils.o;
import cj.mobile.jt.common.utils.p;
import cj.mobile.jt.common.utils.x0;
import cj.mobile.jt.common.video.cache.c;
import cj.mobile.jt.common.video.n0;
import cj.mobile.jt.core.modle.c0;
import cj.mobile.jt.core.modle.d0;
import com.ipd.dsp.internal.l0.g;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class JuTuiAdSdk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f22454a = false;
    public static Context b;
    public static JuTuiAdSdk c;
    public static JuTuiPrivacyController d;

    public static void a(Application application) {
        try {
            if (f.j == null) {
                synchronized (f.k) {
                    if (f.j == null) {
                        f.j = new f(application);
                    }
                }
            }
            f fVar = f.j;
        } catch (Exception unused) {
        }
    }

    public static Context getAppContext() {
        return b;
    }

    public static JuTuiAdSdk getInstance() {
        if (c == null) {
            synchronized (JuTuiAdSdk.class) {
                if (c == null) {
                    c = new JuTuiAdSdk();
                }
            }
        }
        return c;
    }

    public static String getVersionName() {
        return "4.2.0.5";
    }

    public static boolean isInitComplete() {
        return f22454a;
    }

    public synchronized void init(Context context, JuTuiInitConfig juTuiInitConfig) {
        File file;
        if (f22454a) {
            return;
        }
        if (context == null || juTuiInitConfig == null || e1.a(juTuiInitConfig.getAppId()) || e1.a(juTuiInitConfig.getToken())) {
            cj.mobile.jt.common.log.a.b("init fail, because less params");
        } else {
            b = h.a(context);
            d0 d0VarA = d0.a();
            d0VarA.getClass();
            int i = p.b;
            p pVar = o.f22397a;
            pVar.f22399a.execute(new c0(d0VarA));
            i1 i1VarA = i1.a();
            Context context2 = b;
            if (TextUtils.isEmpty(i1VarA.f22387a)) {
                pVar.f22399a.execute(new h1(i1VarA, context2));
            }
            AdSettings.d = juTuiInitConfig.isEnable();
            AdSettings.setNeedPersonalRecommend(juTuiInitConfig.isNeedPersonalRecommend());
            AdSettings.setAppId(juTuiInitConfig.getAppId());
            AdSettings.setToken(juTuiInitConfig.getToken());
            JuTuiPrivacyController privateController = d;
            if (privateController == null) {
                privateController = juTuiInitConfig.getPrivateController();
            }
            AdSettings.init(privateController);
            j0.a(b);
            j0 j0VarA = j0.a();
            j0VarA.getClass();
            new Thread(new e0(j0VarA)).start();
            j.a(b);
            x0.b(b);
            cj.mobile.jt.common.track.b.a(b);
            a((Application) b);
            c cVarA = c.a();
            Context context3 = b;
            cVarA.getClass();
            cj.mobile.jt.common.log.a.a("VideoCacheManager", "Initializing VideoCacheManager");
            cVarA.f22419a = new cj.mobile.jt.common.video.cache.h(context3, g.g, 100, 86400000L);
            cj.mobile.jt.common.log.a.a("VideoCacheManager", "VideoCacheManager initialized successfully");
            cj.mobile.jt.common.log.a.a("VideoCacheManager", "Clearing all cache");
            cj.mobile.jt.common.video.cache.h hVar = cVarA.f22419a;
            if (hVar != null && (file = hVar.f22423a) != null && file.exists()) {
                File[] fileArrListFiles = hVar.f22423a.listFiles();
                if (fileArrListFiles != null) {
                    for (File file2 : fileArrListFiles) {
                        file2.delete();
                    }
                }
                cj.mobile.jt.common.log.a.a("VideoDiskCache", "Disk cache cleared");
            }
            n0.a().a((Application) b);
            f22454a = true;
        }
    }

    public void setCustomController(JuTuiPrivacyController juTuiPrivacyController) {
        if (f22454a) {
            Log.w("JuTuiAdSdk", "请在调用 init 之前调用 setCustomController 修改敏感信息");
        } else {
            d = juTuiPrivacyController;
            AdSettings.init(juTuiPrivacyController);
        }
    }
}

package com.kwad.components.core.d;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.android.arouter.utils.Consts;
import com.kuaishou.aegon.Aegon;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.report.t;
import com.kwad.sdk.crash.d;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.report.h;
import com.kwad.sdk.crash.utils.g;
import com.kwad.sdk.o;
import com.kwad.sdk.q;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bf;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.i;
import com.kwad.sdk.utils.n;
import com.kwai.CpuMemoryProfiler;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    private static boolean PQ;
    private static boolean PR;
    private static List<Throwable> PT;
    private static Map<String, String> PU;
    private static final AtomicBoolean mHasInit = new AtomicBoolean(false);
    private static final AtomicBoolean PS = new AtomicBoolean(false);
    private static final List<b> PV = new CopyOnWriteArrayList();
    private static final List<c> PW = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: com.kwad.components.core.d.a$a, reason: collision with other inner class name */
    public static class C1196a {
        public static String an(Context context) {
            File file = new File(getDataDir(context), "kwad_ex");
            if (!file.exists()) {
                file.mkdir();
            }
            return file.getAbsolutePath();
        }

        private static File getDataDir(Context context) {
            File externalFilesDir;
            if (Build.VERSION.SDK_INT >= 29 && (externalFilesDir = context.getExternalFilesDir(null)) != null) {
                return new File(externalFilesDir.getAbsolutePath());
            }
            File dataDir = context.getDataDir();
            if (dataDir != null) {
                return dataDir;
            }
            File file = new File(Environment.getDataDirectory().getPath() + "/data/" + context.getPackageName());
            if (file.exists()) {
                return file;
            }
            return new File("/data/data/" + context.getPackageName());
        }
    }

    public interface b {
        String getKey();

        JSONObject getValue();
    }

    public interface c {
        void onCrashOccur(int i, String str);
    }

    public static void a(b bVar) {
        PV.add(bVar);
    }

    private static com.kwad.sdk.crash.model.b ak(String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.kwad.sdk.crash.model.b();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            com.kwad.sdk.crash.model.b bVar = new com.kwad.sdk.crash.model.b();
            bVar.parseJson(jSONObject);
            return bVar;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.w("KsAdExceptionCollectorHelper", e);
            return new com.kwad.sdk.crash.model.b();
        }
    }

    private static String al(String str) {
        try {
            int iIndexOf = str.indexOf(46, str.indexOf(46) + 1);
            if (iIndexOf > 0) {
                return str.substring(0, iIndexOf);
            }
            return null;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            return null;
        }
    }

    public static synchronized void am(Context context) {
        if (context != null) {
            if (!PS.get() && !PR) {
                PR = true;
                i.execute(new bi() { // from class: com.kwad.components.core.d.a.2
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        if (e.b(com.kwad.sdk.core.config.c.aNb)) {
                            com.kwad.sdk.core.d.c.d("KsAdExceptionCollectorHelper", "init Native");
                            com.kwad.sdk.crash.b.b(a.pi());
                            a.PS.set(true);
                        }
                    }
                });
            }
        }
    }

    private static void b(Throwable th) {
        if (PT == null) {
            PT = new CopyOnWriteArrayList();
        }
        PT.add(th);
    }

    public static synchronized void initAsync(Context context) {
        if (context != null) {
            if (!mHasInit.get() && !PQ) {
                PQ = true;
                i.execute(new bi() { // from class: com.kwad.components.core.d.a.1
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        if (e.b(com.kwad.sdk.core.config.c.aNb)) {
                            com.kwad.sdk.core.d.c.d("KsAdExceptionCollectorHelper", "init");
                            com.kwad.sdk.crash.b.a(a.pi());
                            a.mHasInit.set(true);
                            a.pg();
                            a.ph();
                        }
                    }
                });
            }
        }
    }

    public static void j(String str, String str2) {
        if (mHasInit.get()) {
            h.ak(str, str2);
        } else {
            k(str, str2);
        }
    }

    private static void k(String str, String str2) {
        if (PU == null) {
            PU = new ConcurrentHashMap();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        PU.put(str, str2);
    }

    private static boolean pf() {
        return e.b(com.kwad.sdk.core.config.c.aNc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void pg() {
        if (PT == null || !pf()) {
            return;
        }
        Iterator<Throwable> it = PT.iterator();
        while (it.hasNext()) {
            com.kwad.sdk.crash.b.u(it.next());
        }
        PT.clear();
        PT = null;
        ServiceProvider.h(new com.kwad.sdk.g.a<Throwable>() { // from class: com.kwad.components.core.d.a.3
            private static void c(Throwable th) {
                com.kwad.sdk.crash.b.u(th);
            }

            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(Throwable th) {
                c(th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ph() {
        Map<String, String> map = PU;
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                h.ak(entry.getKey(), entry.getValue());
            }
        }
        PU.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static com.kwad.sdk.crash.c pi() {
        String strA = e.a(com.kwad.sdk.core.config.c.aOA);
        com.kwad.sdk.core.d.c.d("KsAdExceptionCollectorHelper", "configStr:" + strA);
        com.kwad.sdk.crash.model.b bVarAk = ak(strA);
        String str = bVarAk.beI;
        String str2 = bVarAk.beJ;
        boolean zA = g.a(bVarAk);
        boolean zB = g.b(bVarAk);
        final Context context = ServiceProvider.getContext();
        String strAn = C1196a.an(context);
        com.kwad.sdk.crash.c.a aVarFW = new com.kwad.sdk.crash.c.a().cw(context).bW(zA).bX(zB).bY(o.Gs().Fu()).fX(str).fW(str2);
        o.Gs();
        com.kwad.sdk.crash.c.a aVarGe = aVarFW.ge(ExceptionMessage.getSdkCrashVersionName(o.getSDKVersion(), 1));
        o.Gs();
        return aVarGe.eV(BuildConfig.VERSION_CODE).gf(ExceptionMessage.getSdkCrashVersionName(o.Gs().getApiVersion(), 1)).eW(o.Gs().getApiVersionCode()).eX(1).gd("com.kwad.sdk").gg(context.getPackageName()).gh(ServiceProvider.getSDKConfig().appId).gi(ServiceProvider.getSDKConfig().appName).gj(n.cZ(context)).gk(bVarAk.beE).gl(bVarAk.beF).ga(bf.getDeviceId()).gb(ServiceProvider.getSDKConfig().appId).fZ(bVarAk.version).gm(bVarAk.beH).gn(bVarAk.beG).fY("Android").gc(strAn).a(new com.kwad.sdk.crash.h() { // from class: com.kwad.components.core.d.a.5
            @Override // com.kwad.sdk.crash.h
            public final com.kwad.sdk.crash.model.message.a pr() {
                com.kwad.sdk.crash.model.message.a aVar = new com.kwad.sdk.crash.model.message.a();
                aVar.gs(t.Nj());
                aVar.putString("mKsadAppId", ServiceProvider.getSDKConfig().appId);
                aVar.putString("mKsadAppName", ServiceProvider.getSDKConfig().appName);
                aVar.putString("mKsadAppPackageName", context.getPackageName());
                aVar.putString("mKsadAppVersion", n.cZ(context));
                aVar.putString("mKsadSdkName", "com.kwad.sdk");
                o.Gs();
                aVar.putString("mKsadSdkVersion", ExceptionMessage.getSdkCrashVersionName(o.getSDKVersion(), 1));
                o.Gs();
                aVar.putInt("mKsadSdKVersionCode", BuildConfig.VERSION_CODE);
                aVar.putString("mKsadSdkApiVersion", ExceptionMessage.getSdkCrashVersionName(o.Gs().getApiVersion(), 1));
                aVar.putInt("mKsadSdKApiVersionCode", o.Gs().getApiVersionCode());
                aVar.putInt("mKsadSdkType", 1);
                aVar.putInt("mBuildNumber", 5560136);
                for (b bVar : a.PV) {
                    String key = bVar.getKey();
                    JSONObject value = bVar.getValue();
                    if (key != null && value != null) {
                        aVar.b(bVar.getKey(), bVar.getValue());
                    }
                }
                return aVar;
            }
        }).a(new f() { // from class: com.kwad.components.core.d.a.4
            @Override // com.kwad.sdk.crash.f
            public final void a(int i, ExceptionMessage exceptionMessage) {
                q.bh(context);
                if (i == 1 || i == 3 || i == 4) {
                    com.kwad.sdk.core.d.c.d("KsAdExceptionCollectorHelper", "onOccurred crashType=" + i);
                }
                Iterator it = a.PW.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).onCrashOccur(i, exceptionMessage.mCrashDetail);
                }
            }
        }).d(pj()).e(pk()).N(e.Jt()).k(e.a(com.kwad.sdk.core.config.c.aPJ)).Qc();
    }

    private static String[] pj() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(al(KsAdSDKImpl.class.getName()));
            arrayList.add(al(DownloadTask.class.getName()));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        try {
            arrayList.add(al(CpuMemoryProfiler.class.getName()));
            arrayList.add(al(Aegon.class.getName()));
        } catch (Throwable unused) {
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static String[] pk() {
        String[] strArr = new String[1];
        try {
            String name = d.class.getName();
            strArr[0] = name.substring(0, name.lastIndexOf(Consts.DOT));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        return strArr;
    }

    public static void reportSdkCaughtException(Throwable th) {
        com.kwad.sdk.core.d.c.printStackTrace(th);
        if (!mHasInit.get()) {
            b(th);
        } else if (pf()) {
            com.kwad.sdk.crash.b.u(th);
        }
    }

    public static void a(c cVar) {
        PW.add(cVar);
    }
}

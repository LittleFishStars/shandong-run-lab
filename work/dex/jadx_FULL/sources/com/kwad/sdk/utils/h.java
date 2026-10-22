package com.kwad.sdk.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.WorkerThread;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.kwad.sdk.collector.AppStatusRules;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class h {
    private static Handler arT;
    private static WeakReference<Context> arZ;
    private static Messenger boh;
    private static volatile ExecutorService boi;
    private static volatile AppStatusRules boj;
    private static com.kwad.sdk.collector.h bok;
    private static ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.kwad.sdk.utils.h.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                Messenger messenger = new Messenger(iBinder);
                Message messageObtain = Message.obtain();
                messageObtain.what = 100;
                if (!h.Ug()) {
                    com.kwad.sdk.core.d.c.w("AppStatusHelper", "clientMessenger init error");
                    return;
                }
                messageObtain.replyTo = h.boh;
                try {
                    messenger.send(messageObtain);
                } catch (RemoteException unused) {
                }
            } catch (SecurityException e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                com.kwad.sdk.service.d.gatherException(e);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* JADX INFO: renamed from: com.kwad.sdk.utils.h$2, reason: invalid class name */
    public class AnonymousClass2 extends bi {
        final /* synthetic */ Context dK;

        public AnonymousClass2(Context context) {
            this.dK = context;
        }

        @Override // com.kwad.sdk.utils.bi
        public final void doTask() {
            com.kwad.sdk.collector.c.a(this.dK, new com.kwad.sdk.collector.c.a() { // from class: com.kwad.sdk.utils.h.2.1
                @Override // com.kwad.sdk.collector.c.a
                public final void b(AppStatusRules appStatusRules) {
                    appStatusRules.initStatus(AnonymousClass2.this.dK);
                    AppStatusRules unused = h.boj = appStatusRules;
                    h.b(AnonymousClass2.this.dK, h.boj);
                    h.cO(AnonymousClass2.this.dK);
                    boolean zEE = bt.eE(AnonymousClass2.this.dK);
                    boolean zIsAppStatusTargetNotEmpty = AppStatusRules.isAppStatusTargetNotEmpty(h.boj);
                    com.kwad.sdk.core.d.c.d("AppStatusHelper", "appStatusTargetNotEmpty: " + zIsAppStatusTargetNotEmpty + ", permissionGranted: " + zEE);
                    if (zEE && zIsAppStatusTargetNotEmpty) {
                        long jObtainDefaultScanInterval = h.boj.obtainDefaultScanInterval();
                        if (jObtainDefaultScanInterval > 0) {
                            h.c(AnonymousClass2.this.dK, jObtainDefaultScanInterval);
                        } else {
                            h.cQ(AnonymousClass2.this.dK);
                        }
                    }
                    boolean zIsUploadTargetNotEmpty = AppStatusRules.isUploadTargetNotEmpty(h.boj);
                    boolean z = h.boj.obtainUploadConfigFileMaxSize() > 0;
                    com.kwad.sdk.core.d.c.d("AppStatusHelper", "uploadTargetNotEmpty: " + zIsUploadTargetNotEmpty + ", enableUpload: " + z);
                    if (zIsUploadTargetNotEmpty && z && zEE) {
                        h.Uh();
                        h.boi.submit(new Runnable() { // from class: com.kwad.sdk.utils.h.2.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    com.kwad.sdk.collector.j.a(AnonymousClass2.this.dK, h.boj);
                                } catch (Throwable th) {
                                    com.kwad.sdk.service.d.gatherException(th);
                                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                                }
                            }
                        });
                    }
                }

                @Override // com.kwad.sdk.collector.c.a
                public final void x(int i, String str) {
                    com.kwad.sdk.core.d.c.e("AppStatusHelper", "fetchAppStatusConfig onFetchError: " + str + ", code: " + i);
                }
            });
        }
    }

    public interface b {
        void D(List<com.kwad.sdk.collector.model.b> list);
    }

    public static class d implements b {
        private b bos = null;

        public d(b bVar) {
        }

        @Override // com.kwad.sdk.utils.h.b
        public final void D(List<com.kwad.sdk.collector.model.b> list) {
            JSONArray jSONArrayV = a.V(list);
            if (jSONArrayV != null) {
                h.bok.c(jSONArrayV);
            }
            b bVar = this.bos;
            if (bVar != null) {
                bVar.D(list);
            }
        }
    }

    private static List<com.kwad.sdk.collector.model.b> U(List<com.kwad.sdk.collector.model.b> list) {
        return list.isEmpty() ? list : new ArrayList(new LinkedHashSet(list));
    }

    public static AppStatusRules Uf() {
        return boj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean Ug() {
        if (boh == null) {
            try {
                boh = new Messenger(new c(Looper.getMainLooper()));
            } catch (Throwable unused) {
            }
        }
        return boh != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Uh() {
        if (boi == null) {
            synchronized (h.class) {
                if (boi == null) {
                    ExecutorService executorServiceOh = GlobalThreadPools.Oh();
                    boi = executorServiceOh;
                    com.kwad.sdk.core.threads.c.a((ThreadPoolExecutor) executorServiceOh, "appStatusHelper");
                }
            }
        }
    }

    private static boolean Ui() {
        try {
            Class<?> cls = Class.forName("com.kwad.sdk.api.proxy.app.ServiceProxyRemote");
            Context context = ServiceProvider.getContext();
            return context.getPackageManager().queryIntentServices(new Intent(context, cls), 65536).size() > 0;
        } catch (ClassNotFoundException e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return false;
        }
    }

    public static void a(Context context, long j, com.kwad.sdk.collector.h hVar) {
        if (be.useStoragePermissionDisable() || com.kwad.sdk.core.config.e.ao(8192L) || context == null || com.kwad.sdk.utils.d.cM(context)) {
            return;
        }
        bok = hVar;
        boolean zIsInMainProcess = SystemUtil.isInMainProcess(context);
        com.kwad.sdk.core.d.c.d("AppStatusHelper", "isMainProcess: " + zIsInMainProcess);
        if (zIsInMainProcess) {
            arZ = new WeakReference<>(context);
            if (arT == null) {
                arT = new Handler(Looper.getMainLooper());
            }
            arT.postDelayed(new AnonymousClass2(context), 30000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public static void b(Context context, AppStatusRules appStatusRules) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        String string = appStatusRules.toJson().toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        com.kwad.sdk.crash.utils.h.k(file.getAbsolutePath(), com.kwad.sdk.core.a.c.encodeKsSdk(string), false);
    }

    @WorkerThread
    public static void cO(Context context) {
        if (boj == null) {
            boj = cP(context);
        }
    }

    @Nullable
    @WorkerThread
    private static AppStatusRules cP(Context context) {
        File file = new File(context.getFilesDir(), "LOCAL_APP_STATUS_RULES_JSON");
        if (!file.exists()) {
            return null;
        }
        try {
            String strJ = com.kwad.sdk.crash.utils.h.J(file);
            if (TextUtils.isEmpty(strJ)) {
                return null;
            }
            if (com.kwad.sdk.core.a.c.isEncodeKsSdk(strJ)) {
                strJ = com.kwad.sdk.core.a.c.decodeKsSdk(strJ);
            }
            JSONObject jSONObject = new JSONObject(strJ);
            AppStatusRules appStatusRules = new AppStatusRules();
            appStatusRules.parseJson(jSONObject);
            return appStatusRules;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cQ(Context context) {
        if (context == null) {
            return;
        }
        boolean zUi = Ui();
        com.kwad.sdk.core.d.c.d("AppStatusHelper", "isServiceAvailable: " + zUi);
        if (zUi) {
            com.kwad.sdk.collector.b.a.a(context, serviceConnection);
        } else {
            a(context, new d(null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public static List<com.kwad.sdk.collector.model.b> cR(Context context) {
        if (!bt.eE(context)) {
            return new ArrayList();
        }
        if (boj == null) {
            boj = cP(context);
        }
        return cS(context);
    }

    @RequiresPermission("android.permission.WRITE_EXTERNAL_STORAGE")
    private static List<com.kwad.sdk.collector.model.b> cS(Context context) {
        ArrayList arrayList = new ArrayList();
        if (be.useStoragePermissionDisable() || com.kwad.sdk.core.config.e.ao(8192L) || com.kwad.sdk.utils.d.cM(context)) {
            return arrayList;
        }
        AppStatusRules appStatusRulesUf = Uf();
        for (AppStatusRules.Strategy strategy : com.kwad.sdk.collector.i.c(appStatusRulesUf)) {
            arrayList.addAll(a(strategy));
            strategy.setNeedSaveLaunchTime(System.currentTimeMillis());
        }
        AppStatusRules.Strategy strategyD = com.kwad.sdk.collector.i.d(appStatusRulesUf);
        arrayList.addAll(a(strategyD));
        strategyD.setNeedSaveLaunchTime(System.currentTimeMillis());
        return U(arrayList);
    }

    public static void c(final Context context, final long j) {
        if (arT == null) {
            arT = new Handler(Looper.getMainLooper());
        }
        arT.post(new bi() { // from class: com.kwad.sdk.utils.h.3
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                h.cQ(context);
                h.arT.postDelayed(this, j);
            }
        });
    }

    public static class a implements com.kwad.sdk.core.b {
        private String appName;
        private List<Long> boq = new ArrayList();
        private String packageName;

        private a(String str, String str2) {
            this.appName = str;
            this.packageName = str2;
        }

        @Nullable
        public static JSONArray V(List<com.kwad.sdk.collector.model.b> list) {
            List<a> listW;
            try {
                listW = W(list);
            } catch (Exception e) {
                com.kwad.sdk.service.d.gatherException(e);
                listW = null;
            }
            if (listW == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<a> it = listW.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().toJson());
            }
            return jSONArray;
        }

        @Nullable
        private static List<a> W(List<com.kwad.sdk.collector.model.b> list) {
            a aVar;
            if (list != null && list.size() != 0) {
                HashMap map = new HashMap();
                try {
                    for (com.kwad.sdk.collector.model.b bVar : list) {
                        String strB = com.kwad.sdk.collector.model.c.b(bVar);
                        if (map.containsKey(strB)) {
                            aVar = (a) map.get(strB);
                        } else {
                            a aVar2 = new a(com.kwad.sdk.collector.model.c.a(bVar), com.kwad.sdk.collector.model.c.b(bVar));
                            map.put(strB, aVar2);
                            aVar = aVar2;
                        }
                        long jC = com.kwad.sdk.collector.model.c.c(bVar) / 1000;
                        if (aVar != null) {
                            aVar.bd(jC);
                        }
                    }
                    return new ArrayList(map.values());
                } catch (ClassCastException e) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                }
            }
            return null;
        }

        private void bd(long j) {
            this.boq.add(Long.valueOf(j));
        }

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.appName = jSONObject.optString("appName");
            this.packageName = jSONObject.optString(ALPParamConstant.PACKAGENAME);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("runningTimes");
            if (jSONArrayOptJSONArray != null) {
                this.boq.clear();
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    try {
                        this.boq.add(Long.valueOf(jSONArrayOptJSONArray.getLong(i)));
                    } catch (JSONException e) {
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                    }
                }
            }
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            ac.putValue(jSONObject, "appName", this.appName);
            ac.putValue(jSONObject, ALPParamConstant.PACKAGENAME, this.packageName);
            JSONArray jSONArray = new JSONArray();
            Iterator<Long> it = this.boq.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().longValue());
            }
            ac.putValue(jSONObject, "runningTimes", jSONArray);
            return jSONObject;
        }

        public a() {
        }
    }

    public static void a(final Context context, final b bVar) {
        if (context == null || be.useStoragePermissionDisable() || com.kwad.sdk.core.config.e.ao(8192L) || com.kwad.sdk.utils.d.cM(context)) {
            return;
        }
        Uh();
        boi.submit(new Runnable() { // from class: com.kwad.sdk.utils.h.4
            @Override // java.lang.Runnable
            public final void run() {
                List listCR;
                try {
                    HashSet hashSet = new HashSet();
                    if (!bt.eE(context) || (listCR = h.cR(context)) == null) {
                        return;
                    }
                    Iterator it = listCR.iterator();
                    while (it.hasNext()) {
                        com.kwad.sdk.core.d.c.d("AppStatusHelper", "AppRunningInfo: " + ((com.kwad.sdk.collector.model.b) it.next()));
                    }
                    hashSet.addAll(listCR);
                    if (bVar != null) {
                        bVar.D(new ArrayList(hashSet));
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                    com.kwad.sdk.service.d.gatherException(th);
                }
            }
        });
    }

    @NonNull
    private static List<com.kwad.sdk.collector.model.b> a(AppStatusRules.Strategy strategy) {
        boolean zIsNeedLaunch = strategy.isNeedLaunch();
        com.kwad.sdk.core.d.c.d("AppStatusHelper", "analysisByFile, strategy: " + strategy.getName() + ", needLaunch: " + zIsNeedLaunch);
        if (!zIsNeedLaunch) {
            return new ArrayList();
        }
        return com.kwad.sdk.collector.b.HX().a(strategy);
    }

    public static class c extends Handler {
        public c(@NonNull Looper looper) {
            super(looper);
        }

        private static void X(List<a> list) {
            if (list == null) {
                return;
            }
            h.bok.c(ac.Y(list));
        }

        private void c(Message message) {
            ArrayList arrayList;
            List listA;
            Bundle data = message.getData();
            List<AppStatusRules.Strategy> listA2 = null;
            if (data != null) {
                try {
                    if (data.containsKey("resultJson")) {
                        listA = ac.a(data.getString("resultJson"), new com.kwad.sdk.core.c<a>() { // from class: com.kwad.sdk.utils.h.c.1
                            private static a Ur() {
                                return new a();
                            }

                            @Override // com.kwad.sdk.core.c
                            public final /* synthetic */ com.kwad.sdk.core.b IA() {
                                return Ur();
                            }
                        });
                        arrayList = null;
                    } else {
                        arrayList = (ArrayList) data.getSerializable("data");
                        listA = null;
                    }
                } catch (Throwable unused) {
                    arrayList = null;
                    listA = null;
                }
                if (arrayList != null) {
                    com.kwad.sdk.core.d.c.d("AppStatusHelper", "ClientHandler: handleMessage data size: " + arrayList.size());
                    c((ArrayList<com.kwad.sdk.collector.model.b>) arrayList);
                }
                if (listA != null) {
                    X(listA);
                }
            }
            if (h.arZ != null && h.arZ.get() != null && data != null) {
                if (data.containsKey("allStrategyJson")) {
                    String string = data.getString("allStrategyJson");
                    if (string != null) {
                        listA2 = ac.a(string, new com.kwad.sdk.core.c<AppStatusRules.Strategy>() { // from class: com.kwad.sdk.utils.h.c.2
                            private static AppStatusRules.Strategy Us() {
                                return new AppStatusRules.Strategy();
                            }

                            @Override // com.kwad.sdk.core.c
                            public final /* synthetic */ com.kwad.sdk.core.b IA() {
                                return Us();
                            }
                        });
                    }
                } else {
                    listA2 = (ArrayList) data.getSerializable("allStrategy");
                }
                if (listA2 != null) {
                    for (AppStatusRules.Strategy strategy : listA2) {
                        long needSaveLaunchTime = strategy.getNeedSaveLaunchTime();
                        if (needSaveLaunchTime >= 0) {
                            com.kwad.sdk.collector.i.a((Context) h.arZ.get(), strategy, needSaveLaunchTime);
                        }
                    }
                }
            }
            if (h.arZ == null || h.serviceConnection == null) {
                return;
            }
            com.kwad.sdk.core.d.c.d("AppStatusHelper", "unbindASService");
            com.kwad.sdk.collector.b.a.b((Context) h.arZ.get(), h.serviceConnection);
        }

        @Override // android.os.Handler
        public final void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            if (message.what != 101) {
                return;
            }
            try {
                c(message);
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }

        private static void c(ArrayList<com.kwad.sdk.collector.model.b> arrayList) {
            JSONArray jSONArrayV;
            if (arrayList == null || (jSONArrayV = a.V(arrayList)) == null) {
                return;
            }
            h.bok.c(jSONArrayV);
        }
    }
}

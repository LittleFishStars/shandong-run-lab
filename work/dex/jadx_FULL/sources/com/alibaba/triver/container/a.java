package com.alibaba.triver.container;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.app.ipc.IpcServerUtils;
import com.alibaba.ariver.integration.RVMain;
import com.alibaba.ariver.integration.ipc.server.RVAppRecord;
import com.alibaba.ariver.kernel.api.IIpcChannel;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcChannelManager;
import com.alibaba.ariver.kernel.ipc.IpcClientKernelUtils;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.triver.Triver;
import com.alibaba.triver.ipc.client.IpcMsgClientService;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.kit.api.proxy.IDeviceInfoProxy;
import com.alibaba.triver.point.OnPreloadPoint;
import com.alibaba.triver.utils.CommonUtils;
import com.byazt.hv.TTDownloadField;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    private static final String A = "arAppList";
    private static final String B = "enableAr";
    private static int G = 0;
    private static int H = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f24773a = "PreLaunchProcess";
    public static final String b = "PreLaunchProcessPhase";
    public static final String c = "unknown process";
    public static final String d = "preLaunch";
    public static final String e = "processMessage";
    public static int f = 4;
    public static int g = 3;
    public static int h = 1;
    public static int i = 2;
    public static int j = 1;
    public static int k = 1;
    private static final String l = "CHOOSE_LAUNCH_ACTIVITY_FINISH";
    private static final String m = "RELEASE_PROCESS_FINISH";
    private static final String n = "PROCESS_REBOOT_FINISH";
    private static final String o = "PRELAUNCH_PROCESS_FINISH";
    private static final String p = "topMaxProcessNum";
    private static final String q = "mediumMaxProcessNum";
    private static final String r = "bottomMaxProcessNum";
    private static final String s = "topMaxIdleProcessNum";
    private static final String t = "mediumMaxIdleProcessNum";
    private static final String u = "bottomMaxIdleProcessNum";
    private static final String v = "IsHitHotStart";
    private static final String w = "AppID";
    private static final String x = "phoneScore";
    private static final String y = "Triver_Process";
    private static final String z = "LaunchProcess";
    private HandlerThread E;
    private Handler F;
    private String[] I;
    private boolean J;
    private Object K = new Object();
    private b M = new b();
    private static final List<d> C = new ArrayList();
    private static Map<String, WeakReference<Activity>> D = new ConcurrentHashMap();
    private static a L = null;

    /* JADX INFO: renamed from: com.alibaba.triver.container.a$a, reason: collision with other inner class name */
    public static class C0160a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Class<? extends TriverSubActivity> f24784a;
        public Class<? extends IpcMsgClientService> b;
        public String c;
        public volatile IBinder d;
        public volatile c e;

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof C0160a)) {
                return false;
            }
            C0160a c0160a = (C0160a) obj;
            return this.f24784a.equals(c0160a.f24784a) && this.b.equals(c0160a.b) && this.c.equals(c0160a.c);
        }
    }

    public class c implements IBinder.DeathRecipient {
        private Context b;
        private ServiceConnection c;
        private C0160a d;
        private RVAppRecord e;

        public c(Context context, C0160a c0160a, RVAppRecord rVAppRecord, ServiceConnection serviceConnection) {
            this.b = context.getApplicationContext();
            this.c = serviceConnection;
            this.d = c0160a;
            this.e = rVAppRecord;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            a aVar;
            d dVarC;
            synchronized (a.L) {
                try {
                    try {
                        RVLogger.d(Triver.TAG, "binderDied in: " + this.d.b);
                        if (Triver.isProcessAlive(this.b, a.this.b(this.d))) {
                            a aVar2 = a.this;
                            aVar2.c(aVar2.c(this.d));
                            return;
                        }
                        if (this.b != null && this.c != null) {
                            RVAppRecord rVAppRecord = this.e;
                            if (rVAppRecord != null) {
                                a.d(rVAppRecord.getAppId());
                                IpcChannelManager.getInstance().unRegisterClientChannel(this.e.getStartToken());
                                a.a().a(this.e.getAppId(), true);
                            }
                            try {
                                ServiceConnection serviceConnection = this.c;
                                if (serviceConnection != null) {
                                    this.b.unbindService(serviceConnection);
                                }
                            } catch (Throwable unused) {
                            }
                            ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.container.a.c.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((OnPreloadPoint) ExtensionPoint.as(OnPreloadPoint.class).create()).processDiedPreload();
                                }
                            });
                            aVar = a.this;
                            dVarC = aVar.c(this.d);
                            aVar.c(dVarC);
                            return;
                        }
                        a aVar3 = a.this;
                        aVar3.c(aVar3.c(this.d));
                    } catch (Throwable th) {
                        a aVar4 = a.this;
                        aVar4.c(aVar4.c(this.d));
                        throw th;
                    }
                } catch (Exception e) {
                    RVLogger.e(Triver.TAG, "binderDied exception:", e);
                    aVar = a.this;
                    dVarC = aVar.c(this.d);
                }
            }
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static int f24788a = 0;
        public static int b = 1;
        public static int c = 2;
        public static int d = 3;
        public static int e = 4;
        public static int f = 5;
        public C0160a g;
        public int h = f24788a;
        public String i;
        public long j;
        public int k;

        public d(C0160a c0160a) {
            this.g = c0160a;
        }

        public String toString() {
            return "ProcessInfo:" + this.g.c + ",status:" + this.h + ",appId:" + this.i + ",apptoken:" + this.j;
        }
    }

    private a() {
        u();
        C0160a c0160a = new C0160a();
        c0160a.f24784a = TriverSubActivity.TriverSubActivity1.class;
        c0160a.b = IpcMsgClientService.IpcMsgClientService1.class;
        c0160a.c = ":wml1";
        d dVar = new d(c0160a);
        List<d> list = C;
        list.add(dVar);
        C0160a c0160a2 = new C0160a();
        c0160a2.f24784a = TriverSubActivity.TriverSubActivity2.class;
        c0160a2.b = IpcMsgClientService.IpcMsgClientService2.class;
        c0160a2.c = ":wml2";
        list.add(new d(c0160a2));
        C0160a c0160a3 = new C0160a();
        c0160a3.f24784a = TriverSubActivity.TriverSubActivity3.class;
        c0160a3.b = IpcMsgClientService.IpcMsgClientService3.class;
        c0160a3.c = ":wml3";
        list.add(new d(c0160a3));
        C0160a c0160a4 = new C0160a();
        c0160a4.f24784a = TriverSubActivity.TriverSubActivity4.class;
        c0160a4.b = IpcMsgClientService.IpcMsgClientService4.class;
        c0160a4.c = ":wml4";
        list.add(new d(c0160a4));
        C0160a c0160a5 = new C0160a();
        c0160a5.f24784a = TriverSubActivity.TriverSubActivity5.class;
        c0160a5.b = IpcMsgClientService.IpcMsgClientService5.class;
        c0160a5.c = ":wml5";
        list.add(new d(c0160a5));
        try {
            ((IConfigProxy) RVProxy.get(IConfigProxy.class)).registerListener("triver_common_config", new IConfigProxy.ConfigListener() { // from class: com.alibaba.triver.container.a.1
                @Override // com.alibaba.triver.kit.api.proxy.IConfigProxy.ConfigListener
                public void onConfigUpdate(Map<String, String> map) {
                    try {
                        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
                        if (configsByGroup == null) {
                            configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
                        }
                        String str = configsByGroup != null ? configsByGroup.get(a.p) : "";
                        RVLogger.d(Triver.TAG, "update max:" + str);
                        if (!TextUtils.isEmpty(str)) {
                            a.f = Integer.valueOf(str).intValue();
                        }
                        String str2 = configsByGroup != null ? configsByGroup.get(a.q) : "";
                        RVLogger.d(Triver.TAG, "update medium:" + str2);
                        if (!TextUtils.isEmpty(str2)) {
                            a.g = Integer.valueOf(str2).intValue();
                        }
                        String str3 = configsByGroup != null ? configsByGroup.get(a.r) : "";
                        RVLogger.d(Triver.TAG, "update bottom:" + str3);
                        if (!TextUtils.isEmpty(str3)) {
                            a.h = Integer.valueOf(str3).intValue();
                        }
                        String str4 = configsByGroup != null ? configsByGroup.get(a.s) : "";
                        RVLogger.d(Triver.TAG, "update max idle:" + str4);
                        if (!TextUtils.isEmpty(str4)) {
                            a.i = Integer.valueOf(str4).intValue();
                        }
                        String str5 = configsByGroup != null ? configsByGroup.get(a.t) : "";
                        RVLogger.d(Triver.TAG, "update medium idle:" + str5);
                        if (!TextUtils.isEmpty(str5)) {
                            a.j = Integer.valueOf(str5).intValue();
                        }
                        String str6 = configsByGroup != null ? configsByGroup.get(a.u) : "";
                        RVLogger.d(Triver.TAG, "update bottom idle:" + str6);
                        if (!TextUtils.isEmpty(str6)) {
                            a.k = Integer.valueOf(str6).intValue();
                        }
                        RVLogger.d(Triver.TAG, "update ar config");
                        a.this.J = TROrangeController.enableAr();
                        if (a.this.J) {
                            String str7 = configsByGroup != null ? configsByGroup.get(a.A) : "";
                            if (!TextUtils.isEmpty(str7)) {
                                try {
                                    a.this.I = str7.split(",");
                                } catch (Exception unused) {
                                }
                            }
                        } else {
                            a.this.I = null;
                        }
                        a.s();
                    } catch (Exception e2) {
                        RVLogger.e(Triver.TAG, "onConfigUpdate exception:", e2);
                    }
                }
            });
        } catch (Throwable th) {
            RVLogger.d(Triver.TAG, th.getMessage());
        }
        s();
        t();
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int A() {
        return c(d.b) + c(d.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int B() {
        return c(d.c);
    }

    private C0160a C() {
        C0160a c0160a;
        synchronized (L) {
            try {
                if (G == 0) {
                    RVLogger.d(Triver.TAG, "getNextLaunchActivityInfo finish");
                    F();
                    return null;
                }
                d dVarF = f();
                if (dVarF != null) {
                    C0160a c0160a2 = dVarF.g;
                    RVLogger.d(Triver.TAG, "Use last process: " + b(dVarF));
                    RVLogger.d(Triver.TAG, "getNextLaunchActivityInfo finish");
                    F();
                    return c0160a2;
                }
                d dVarE = e();
                if (dVarE != null) {
                    RVLogger.d(Triver.TAG, "Use idle process: " + b(dVarE));
                    C0160a c0160a3 = dVarE.g;
                    RVLogger.d(Triver.TAG, "getNextLaunchActivityInfo finish");
                    F();
                    return c0160a3;
                }
                d dVarX = x();
                if (B() < G && dVarX != null) {
                    RVLogger.d(Triver.TAG, "Use new process: " + b(dVarX));
                    if (!TROrangeController.enableUseMainProcessWhenSubProcessNotReady()) {
                        C0160a c0160a4 = dVarX.g;
                        RVLogger.d(Triver.TAG, "getNextLaunchActivityInfo finish");
                        F();
                        return c0160a4;
                    }
                    RVAppRecord appRecord = RVMain.getAppRecord(dVarX.j);
                    if (appRecord != null && appRecord.getSceneParams() != null) {
                        appRecord.getSceneParams().putString(TriverAppMonitorConstants.KEY_STAGE_PROCESS_MODEL, TriverAppMonitorConstants.KEY_STAGE_SUB_PROCESS_PRELOAD_MISS);
                    }
                    RVLogger.d(Triver.TAG, "getNextLaunchActivityInfo finish");
                    F();
                    return null;
                }
                d dVarV = v();
                if (dVarV != null && (c0160a = dVarV.g) != null) {
                    RVLogger.d(Triver.TAG, "Reuse background info: " + b(dVarV));
                    RVLogger.d(Triver.TAG, "getNextLaunchActivityInfo finish");
                    F();
                    return c0160a;
                }
                RVAppRecord appRecord2 = RVMain.getAppRecord(dVarV.j);
                if (TROrangeController.enableUseMainProcessWhenSubProcessNotReady()) {
                    if (appRecord2 != null && appRecord2.getSceneParams() != null) {
                        appRecord2.getSceneParams().putString(TriverAppMonitorConstants.KEY_STAGE_PROCESS_MODEL, TriverAppMonitorConstants.KEY_STAGE_SUB_PROCESS_PRELOAD_MISS);
                    }
                    RVLogger.d(Triver.TAG, "getNextLaunchActivityInfo finish");
                    F();
                    return null;
                }
                d dVarV2 = v();
                if (dVarV2 == null) {
                    this.F.post(new b(true));
                    RVLogger.e(Triver.TAG, "Error, Can't find container to launch, please Check");
                    RVLogger.d(Triver.TAG, "getNextLaunchActivityInfo finish");
                    F();
                    return null;
                }
                if (appRecord2 != null) {
                    appRecord2.finishClient();
                }
                RVLogger.d(Triver.TAG, "Fallback: Reuse info:" + b(dVarV2));
                C0160a c0160a5 = dVarV2.g;
                RVLogger.d(Triver.TAG, "getNextLaunchActivityInfo finish");
                F();
                return c0160a5;
            } catch (Throwable th) {
                RVLogger.d(Triver.TAG, "getNextLaunchActivityInfo finish");
                F();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        synchronized (L) {
            for (d dVar : C) {
                if (dVar.h == d.d) {
                    c(dVar);
                }
            }
            this.F.post(new b(true));
        }
    }

    private void E() {
        HandlerThread handlerThread = this.E;
        if (handlerThread == null || !handlerThread.isAlive()) {
            return;
        }
        RVLogger.d(Triver.TAG, "resume clean");
        this.F.postDelayed(this.M, 15000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F() {
        try {
            RVLogger.d(Triver.TAG, "=========printStatus start==========");
            Iterator<d> it = C.iterator();
            while (it.hasNext()) {
                RVLogger.d(Triver.TAG, it.next().toString());
            }
            RVLogger.d(Triver.TAG, "=========printStatus end==========");
        } catch (Exception e2) {
            RVLogger.e(Triver.TAG, "printStatus exception:", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void s() {
        try {
            int deviceLevel = ((IDeviceInfoProxy) RVProxy.get(IDeviceInfoProxy.class)).getDeviceLevel();
            if (deviceLevel == CommonUtils.DeviceLevel.Level0.ordinal()) {
                G = f;
                H = i;
            } else if (deviceLevel == CommonUtils.DeviceLevel.Level1.ordinal() || deviceLevel == CommonUtils.DeviceLevel.Level2.ordinal() || deviceLevel == CommonUtils.DeviceLevel.UNKNOWN.ordinal()) {
                G = g;
                H = j;
            } else {
                G = h;
                H = k;
            }
        } catch (Throwable unused) {
            G = g;
            H = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if ((RVProxy.get(RVEnvironmentService.class) == null ? null : ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext()) == null || !ProcessUtils.isMainProcess()) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.alibaba.triver.container.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.t();
                }
            }, 5000L);
            return;
        }
        HandlerThread handlerThread = new HandlerThread("AppManagerThread");
        this.E = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(this.E.getLooper());
        this.F = handler;
        handler.removeCallbacks(this.M);
        this.F.postDelayed(this.M, 10000L);
    }

    private void u() {
        try {
            DimensionSet dimensionSetCreate = DimensionSet.create();
            dimensionSetCreate.addDimension(v);
            dimensionSetCreate.addDimension(w);
            dimensionSetCreate.addDimension(f24773a);
            dimensionSetCreate.addDimension(b);
            MeasureSet measureSetCreate = MeasureSet.create();
            measureSetCreate.addMeasure(new Measure(x));
            AppMonitor.register(y, z, measureSetCreate, dimensionSetCreate);
        } catch (Throwable th) {
            RVLogger.e(Triver.TAG, "initMonitor exception:", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d v() {
        return b(d.c);
    }

    private d w() {
        return b(d.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d x() {
        return b(d.f24788a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d y() {
        return b(d.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int z() {
        return c(d.f24788a);
    }

    public List<Long> j() {
        ArrayList arrayList = new ArrayList();
        for (d dVar : C) {
            if (dVar.h == d.c) {
                arrayList.add(Long.valueOf(dVar.j));
            }
        }
        if (arrayList.size() != 0) {
            return arrayList;
        }
        return null;
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f24785a;

        public b(boolean z) {
            this.f24785a = z;
        }

        private void a(d dVar) {
            dVar.g.d = null;
            dVar.g.e = null;
            a.b(dVar, d.f24788a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:144:0x03ab, code lost:
        
            if (r19.b.y() == null) goto L158;
         */
        /* JADX WARN: Code restructure failed: missing block: B:156:0x03cc, code lost:
        
            if (r19.b.y() == null) goto L158;
         */
        /* JADX WARN: Code restructure failed: missing block: B:158:0x03cf, code lost:
        
            com.alibaba.ariver.kernel.common.utils.RVLogger.d(com.alibaba.triver.Triver.TAG, "pause clean");
            r19.b.F.removeCallbacks(r19.b.M);
         */
        /* JADX WARN: Code restructure failed: missing block: B:233:?, code lost:
        
            return;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            try {
                try {
                    RVLogger.d(Triver.TAG, "CleanWorker in");
                    if (a.A() > a.H) {
                        RVLogger.d(Triver.TAG, "ready clear idle");
                        a.this.b(false);
                    }
                    Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
                    if (applicationContext != null) {
                        for (d dVar : a.C) {
                            String strB = a.this.b(dVar);
                            if (dVar.h == d.f24788a && Triver.isProcessAlive(applicationContext, strB)) {
                                dVar.h = d.e;
                            } else if (!Triver.isProcessAlive(applicationContext, strB)) {
                                int i = dVar.h;
                                int i2 = d.f24788a;
                                if (i != i2) {
                                    a.b(dVar, i2);
                                }
                            }
                        }
                        HashMap map = new HashMap();
                        ArrayList<d> arrayList = new ArrayList();
                        for (d dVar2 : a.C) {
                            if (dVar2.h == d.e) {
                                map.put(a.this.b(dVar2), dVar2);
                                arrayList.add(dVar2);
                            }
                        }
                        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) applicationContext.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses();
                        HashMap map2 = new HashMap();
                        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                            if (!TextUtils.isEmpty(runningAppProcessInfo.processName)) {
                                map2.put(runningAppProcessInfo.processName, runningAppProcessInfo);
                            }
                        }
                        for (d dVar3 : arrayList) {
                            if (!a.this.J || !dVar3.g.equals(a.g().g)) {
                                if (map2.containsKey(a.this.b(dVar3))) {
                                    try {
                                        RVLogger.d(Triver.TAG, "release process: " + dVar3.g.c);
                                        try {
                                            RVLogger.d(Triver.TAG, "Try to unlinkToDeath");
                                            if (dVar3.g.e != null && dVar3.g.d != null) {
                                                dVar3.g.d.unlinkToDeath(dVar3.g.e, 0);
                                            }
                                        } catch (Throwable unused) {
                                        }
                                        try {
                                            RVLogger.d(Triver.TAG, "Try to release resource");
                                            IpcServerUtils.sendMsgToClient("", dVar3.g.e.e.getStartToken(), 201, com.alibaba.triver.ipc.b.f25006a, null);
                                        } catch (Throwable unused2) {
                                        }
                                        try {
                                            if (dVar3.g.e != null && dVar3.g.e.c != null) {
                                                applicationContext.unbindService(dVar3.g.e.c);
                                            }
                                            Intent intent = new Intent();
                                            intent.setClass(applicationContext, dVar3.g.b);
                                            applicationContext.stopService(intent);
                                        } catch (Exception unused3) {
                                        }
                                        try {
                                            a.this.a(dVar3.g.f24784a);
                                            a.d(dVar3.g.e.e.getAppId());
                                        } catch (Exception unused4) {
                                        }
                                        try {
                                            if (a.d(dVar3)) {
                                                RVLogger.d(Triver.TAG, "Skip wml1 release, because H5 may run in this process");
                                                dVar3.g.d = null;
                                                dVar3.g.e = null;
                                                a.b(dVar3, d.b);
                                                Thread.sleep(1000L);
                                                synchronized (a.L) {
                                                    if (!Triver.isProcessAlive(applicationContext, a.this.b(dVar3)) || a.G == 1) {
                                                        a(dVar3);
                                                    } else if (!a.d(dVar3)) {
                                                        RVLogger.e(Triver.TAG, "Try to kill " + dVar3.g.c + " but we fail");
                                                    }
                                                }
                                                if (!this.f24785a) {
                                                    if (a.this.v() != null || a.this.y() != null) {
                                                        a.this.F.postDelayed(a.this.M, 15000L);
                                                        return;
                                                    } else {
                                                        RVLogger.d(Triver.TAG, "pause clean");
                                                        a.this.F.removeCallbacks(a.this.M);
                                                        return;
                                                    }
                                                }
                                            } else {
                                                int i3 = ((ActivityManager.RunningAppProcessInfo) map2.get(a.this.b(dVar3))).pid;
                                                RVLogger.d(Triver.TAG, "kill process: " + dVar3.g.c + " " + i3);
                                                Process.killProcess(i3);
                                            }
                                        } catch (Exception e) {
                                            RVLogger.w(Log.getStackTraceString(e));
                                        }
                                        try {
                                            HashMap map3 = new HashMap();
                                            map3.put("targetProcess", a.this.b(dVar3));
                                            ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog(a.m, "releaseProcess finish", "process", "", "", map3);
                                        } catch (Exception unused5) {
                                        }
                                        Thread.sleep(1000L);
                                        synchronized (a.L) {
                                            if (!Triver.isProcessAlive(applicationContext, a.this.b(dVar3)) || a.G == 1) {
                                                a(dVar3);
                                            } else if (!a.d(dVar3)) {
                                                RVLogger.e(Triver.TAG, "Try to kill " + dVar3.g.c + " but we fail");
                                            }
                                        }
                                    } catch (Throwable th) {
                                        Thread.sleep(1000L);
                                        synchronized (a.L) {
                                            if (!Triver.isProcessAlive(applicationContext, a.this.b(dVar3)) || a.G == 1) {
                                                a(dVar3);
                                            } else if (!a.d(dVar3)) {
                                                RVLogger.e(Triver.TAG, "Try to kill " + dVar3.g.c + " but we fail");
                                            }
                                            throw th;
                                        }
                                    }
                                } else {
                                    RVLogger.d(Triver.TAG, "remove dead process: " + dVar3.g.c);
                                    a(dVar3);
                                }
                            }
                        }
                        if (!this.f24785a) {
                            if (a.this.v() == null) {
                            }
                            a.this.F.postDelayed(a.this.M, 15000L);
                            return;
                        }
                    } else if (!this.f24785a) {
                        if (a.this.v() != null || a.this.y() != null) {
                            a.this.F.postDelayed(a.this.M, 15000L);
                            return;
                        } else {
                            RVLogger.d(Triver.TAG, "pause clean");
                            a.this.F.removeCallbacks(a.this.M);
                            return;
                        }
                    }
                } catch (Exception e2) {
                    RVLogger.e(Triver.TAG, "CleanWorker exception:", e2);
                    if (!this.f24785a) {
                        if (a.this.v() == null) {
                        }
                        a.this.F.postDelayed(a.this.M, 15000L);
                        return;
                    }
                }
            } catch (Throwable th2) {
                if (!this.f24785a) {
                    if (a.this.v() == null && a.this.y() == null) {
                        RVLogger.d(Triver.TAG, "pause clean");
                        a.this.F.removeCallbacks(a.this.M);
                    } else {
                        a.this.F.postDelayed(a.this.M, 15000L);
                    }
                    throw th2;
                }
            }
            RVLogger.d(Triver.TAG, "use once");
        }

        public b() {
            this.f24785a = false;
        }
    }

    public static d g() {
        List<d> list = C;
        return list.get(list.size() - 1);
    }

    public static int i() {
        return B();
    }

    public void d() {
        DimensionValueSet dimensionValueSetCreate = DimensionValueSet.create();
        dimensionValueSetCreate.setValue(f24773a, "1");
        dimensionValueSetCreate.setValue(b, "succ");
        AppMonitor.Stat.commit(y, z, dimensionValueSetCreate, (MeasureValueSet) null);
    }

    public d e() {
        return b(d.b);
    }

    public d f() {
        return b(d.f);
    }

    public int h() {
        return G;
    }

    private d e(String str) {
        for (d dVar : C) {
            if (!TextUtils.isEmpty(str) && str.equals(dVar.i)) {
                return dVar;
            }
        }
        return null;
    }

    public void c() {
        DimensionValueSet dimensionValueSetCreate = DimensionValueSet.create();
        dimensionValueSetCreate.setValue(f24773a, "1");
        dimensionValueSetCreate.setValue(b, "start");
        AppMonitor.Stat.commit(y, z, dimensionValueSetCreate, (MeasureValueSet) null);
    }

    public String b() {
        d dVarX;
        if (G == 0) {
            return null;
        }
        d dVarF = f();
        if (dVarF != null) {
            return b(dVarF);
        }
        d dVarE = e();
        if (dVarE != null) {
            return b(dVarE);
        }
        if (B() < h() && (dVarX = x()) != null) {
            return b(dVarX);
        }
        d dVarW = w();
        if (dVarW != null) {
            return b(dVarW);
        }
        d dVarV = v();
        if (dVarV != null) {
            return b(dVarV);
        }
        return null;
    }

    public static void d(String str) {
        try {
            WeakReference<Activity> weakReferenceRemove = D.remove(str);
            if (weakReferenceRemove != null) {
                weakReferenceRemove.get().finish();
            }
        } catch (Exception e2) {
            RVLogger.e(Triver.TAG, "removeProxyAndFinish error", e2);
        }
    }

    private static int c(int i2) {
        Iterator<d> it = C.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (it.next().h == i2) {
                i3++;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(d dVar) {
        dVar.h = d.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(d dVar) {
        return dVar.g.c.equals(":wml1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d c(C0160a c0160a) {
        for (d dVar : C) {
            if (dVar.g == c0160a) {
                return dVar;
            }
        }
        return null;
    }

    public static a a() {
        if (L == null) {
            synchronized (a.class) {
                if (L == null) {
                    L = new a();
                }
            }
        }
        return L;
    }

    public long c(String str) {
        RVLogger.d(Triver.TAG, "getStartToken:" + str);
        for (d dVar : C) {
            if (!TextUtils.isEmpty(str) && str.equals(dVar.i)) {
                return dVar.j;
            }
        }
        return -1L;
    }

    private d b(int i2) {
        for (d dVar : C) {
            if (dVar.h == i2) {
                return dVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z2) {
        Handler handler;
        Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
        if (applicationContext != null && ProcessUtils.isMainProcess()) {
            RVLogger.d(Triver.TAG, "registerMemoryWatch in");
            applicationContext.registerComponentCallbacks(new ComponentCallbacks2() { // from class: com.alibaba.triver.container.a.4
                @Override // android.content.ComponentCallbacks
                public void onConfigurationChanged(Configuration configuration) {
                }

                @Override // android.content.ComponentCallbacks
                public void onLowMemory() {
                }

                @Override // android.content.ComponentCallbacks2
                public void onTrimMemory(int i2) {
                    RVLogger.e(Triver.TAG, "onTrimMemory:" + i2);
                    if (a.L == null) {
                        return;
                    }
                    if (i2 == 5) {
                        a.this.b(false);
                        return;
                    }
                    if (i2 == 10) {
                        a.this.b(true);
                        return;
                    }
                    if (i2 == 15) {
                        a.this.b(true);
                        a.this.D();
                    } else {
                        if (i2 == 40) {
                            a.this.b(false);
                            return;
                        }
                        if (i2 == 60) {
                            a.this.b(true);
                        } else {
                            if (i2 != 80) {
                                return;
                            }
                            a.this.b(true);
                            a.this.D();
                        }
                    }
                }
            });
        } else {
            if (!z2 || (handler = this.F) == null) {
                return;
            }
            handler.postDelayed(new Runnable() { // from class: com.alibaba.triver.container.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(false);
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(d dVar) {
        return b(dVar.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(C0160a c0160a) {
        try {
            return ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext().getPackageName() + c0160a.c;
        } catch (Exception unused) {
            return c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z2) {
        synchronized (L) {
            for (d dVar : C) {
                if (dVar.h == d.b && (z2 || A() > H)) {
                    c(dVar);
                }
            }
            for (d dVar2 : C) {
                if (dVar2.h == d.f && (z2 || A() > H)) {
                    c(dVar2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(C0160a c0160a, String str) {
        try {
            DimensionValueSet dimensionValueSetCreate = DimensionValueSet.create();
            if (c0160a != null) {
                if (Triver.isProcessAlive(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext(), b(c0160a))) {
                    dimensionValueSetCreate.setValue(v, String.valueOf(true));
                } else {
                    dimensionValueSetCreate.setValue(v, String.valueOf(false));
                }
            }
            dimensionValueSetCreate.setValue(f24773a, "1");
            dimensionValueSetCreate.setValue(w, str);
            MeasureValueSet measureValueSetCreate = MeasureValueSet.create();
            measureValueSetCreate.setValue(x, ((IDeviceInfoProxy) RVProxy.get(IDeviceInfoProxy.class)).getDeviceScore());
            AppMonitor.Stat.commit(y, z, dimensionValueSetCreate, measureValueSetCreate);
        } catch (Exception e2) {
            RVLogger.e(Triver.TAG, "commitStartActivityInfo exception:", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(d dVar, int i2) {
        dVar.i = null;
        dVar.j = 0L;
        dVar.h = i2;
    }

    public void b(String str) {
        synchronized (L) {
            try {
                try {
                    RVLogger.d(Triver.TAG, "moveToForeground:" + str);
                    d dVarE = e(str);
                    if (dVarE.g != null) {
                        dVarE.h = d.c;
                    } else {
                        RVLogger.e(Triver.TAG, "moveToForeground:Can't find target in sActivityStack?");
                    }
                    RVLogger.d(Triver.TAG, "moveToForeground finish");
                } catch (Exception e2) {
                    RVLogger.e(Triver.TAG, "moveToForeground exception:", e2);
                    RVLogger.d(Triver.TAG, "moveToForeground finish");
                }
                F();
            } catch (Throwable th) {
                RVLogger.d(Triver.TAG, "moveToForeground finish");
                F();
                throw th;
            }
        }
    }

    public void a(Context context, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (ProcessUtils.isMainProcess()) {
            C0160a c0160aC = C();
            if (c0160aC != null) {
                Class<? extends IpcMsgClientService> cls = c0160aC.b;
                if (cls != null) {
                    Intent intent = new Intent(context, cls);
                    intent.putExtra(e, bundle);
                    context.startService(intent);
                    return;
                }
                return;
            }
            RVLogger.e(Triver.TAG, "Next Activity is null?");
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putBundle(e, bundle);
        IpcClientKernelUtils.sendMsgToServer(IpcMessageConstants.BIZ_APP, 105, bundle2);
    }

    public void a(final Context context, long j2) {
        Handler handler = this.F;
        if (handler == null) {
            RVLogger.e(Triver.TAG, "workerHandler is null");
        } else {
            handler.postDelayed(new Runnable() { // from class: com.alibaba.triver.container.a.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            RVLogger.d(Triver.TAG, "preLaunchProcess in");
                            if (ProcessUtils.isMainProcess()) {
                                synchronized (a.L) {
                                    if (a.this.f() != null) {
                                        RVLogger.e(Triver.TAG, "There is already a last used process waiting");
                                    } else if (a.this.e() != null) {
                                        RVLogger.e(Triver.TAG, "There is already a process ready for pre-start");
                                    } else if (a.B() >= a.G) {
                                        RVLogger.e(Triver.TAG, "Reach the max process num :" + a.G);
                                    } else if (a.z() > 0) {
                                        d dVarX = a.this.x();
                                        if (a.this.a(context, dVarX.g)) {
                                            RVLogger.d(Triver.TAG, "Pre launch process:" + a.this.b(dVarX));
                                            try {
                                                HashMap map = new HashMap();
                                                map.put("targetProcess", a.this.b(dVarX));
                                                ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog(a.o, "preLaunch process finish", "process", "", "", map);
                                            } catch (Exception unused) {
                                            }
                                            a.b(dVarX, d.b);
                                        }
                                    } else {
                                        RVLogger.w(Triver.TAG, "There is no process can be pre launch");
                                    }
                                }
                            } else {
                                RVLogger.e(Triver.TAG, "preLaunchProcess can't be invoked in sub process!");
                            }
                            RVLogger.d(Triver.TAG, "preLaunchProcess finish");
                            a.this.F();
                        } catch (Exception e2) {
                            RVLogger.e(Triver.TAG, "preLaunchProcess exception:", e2);
                            RVLogger.d(Triver.TAG, "preLaunchProcess finish");
                            a.this.F();
                        }
                    } catch (Throwable th) {
                        RVLogger.d(Triver.TAG, "preLaunchProcess finish");
                        a.this.F();
                        throw th;
                    }
                }
            }, j2);
        }
    }

    public void a(final Context context) {
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.NORMAL).execute(new Runnable() { // from class: com.alibaba.triver.container.a.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    try {
                        RVLogger.d(Triver.TAG, "preLaunchProcess in");
                        if (ProcessUtils.isMainProcess()) {
                            synchronized (a.L) {
                                if (a.this.f() != null) {
                                    RVLogger.e(Triver.TAG, "There is already a last used process waiting");
                                } else if (a.this.e() != null) {
                                    RVLogger.e(Triver.TAG, "There is already a process ready for pre-start");
                                } else if (a.B() >= a.G) {
                                    RVLogger.e(Triver.TAG, "Reach the max process num :" + a.G);
                                } else if (a.z() > 0) {
                                    d dVarX = a.this.x();
                                    if (a.this.a(context, dVarX.g)) {
                                        RVLogger.d(Triver.TAG, "Pre launch process:" + a.this.b(dVarX));
                                        try {
                                            HashMap map = new HashMap();
                                            map.put("targetProcess", a.this.b(dVarX));
                                            ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog(a.o, "preLaunch process finish", "process", "", "", map);
                                        } catch (Exception unused) {
                                        }
                                        a.b(dVarX, d.b);
                                    }
                                } else {
                                    RVLogger.w(Triver.TAG, "There is no process can be pre launch");
                                }
                            }
                        } else {
                            RVLogger.e(Triver.TAG, "preLaunchProcess can't be invoked in sub process!");
                        }
                        RVLogger.d(Triver.TAG, "preLaunchProcess finish");
                        a.this.F();
                    } catch (Exception e2) {
                        RVLogger.e(Triver.TAG, "preLaunchProcess exception:", e2);
                        RVLogger.d(Triver.TAG, "preLaunchProcess finish");
                        a.this.F();
                    }
                } catch (Throwable th) {
                    RVLogger.d(Triver.TAG, "preLaunchProcess finish");
                    a.this.F();
                    throw th;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Context context, C0160a c0160a) {
        if (c0160a == null) {
            RVLogger.d(Triver.TAG, "preLaunchService finish");
            F();
            return false;
        }
        try {
            if (c0160a.d == null || !c0160a.d.isBinderAlive()) {
                Intent intent = new Intent();
                intent.putExtra(d, true);
                intent.setClass(context, c0160a.b);
                context.startService(intent);
                c();
            }
            return true;
        } catch (Exception e2) {
            RVLogger.e(Triver.TAG, "preLaunchService exception:", e2);
            return false;
        } finally {
            RVLogger.d(Triver.TAG, "preLaunchService finish");
            F();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        if (context == null) {
            return;
        }
        RVLogger.d(Triver.TAG, "killForArProcess");
        if (!this.J || g().h != d.e) {
            return;
        }
        if (g().h == d.f24788a) {
            try {
                RVLogger.d(Triver.TAG, "notify ar dead");
                synchronized (this.K) {
                    this.K.notifyAll();
                }
                return;
            } catch (Exception unused) {
                return;
            }
        }
        d dVarG = g();
        int i2 = 0;
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses()) {
            if (!TextUtils.isEmpty(runningAppProcessInfo.processName) && runningAppProcessInfo.processName.equals(b(dVarG))) {
                i2 = runningAppProcessInfo.pid;
            }
        }
        if (i2 == 0) {
            RVLogger.e("Can't find AR process pid");
            return;
        }
        try {
            RVLogger.d(Triver.TAG, "release ar process: " + dVarG.g.c);
            try {
                RVLogger.d(Triver.TAG, "Try to unlinkToDeath");
                if (dVarG.g.e != null && dVarG.g.d != null) {
                    dVarG.g.d.unlinkToDeath(dVarG.g.e, 0);
                }
            } catch (Throwable unused2) {
            }
            try {
                RVLogger.d(Triver.TAG, "Try to release resource");
                IpcServerUtils.sendMsgToClient("", dVarG.g.e.e.getStartToken(), 201, com.alibaba.triver.ipc.b.f25006a, null);
            } catch (Throwable unused3) {
            }
            try {
                if (dVarG.g.e != null && dVarG.g.e.c != null) {
                    context.unbindService(dVarG.g.e.c);
                }
                Intent intent = new Intent();
                intent.setClass(context, dVarG.g.b);
                context.stopService(intent);
            } catch (Exception unused4) {
            }
            try {
                a(dVarG.g.f24784a);
                d(dVarG.g.e.e.getAppId());
            } catch (Exception unused5) {
            }
            try {
                RVLogger.d(Triver.TAG, "kill ar process: " + dVarG.g.c + " " + i2);
                Process.killProcess(i2);
            } catch (Exception e2) {
                RVLogger.w(Log.getStackTraceString(e2));
            }
            try {
                HashMap map = new HashMap();
                map.put("targetProcess", b(dVarG));
                ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog(m, "releaseProcess finish", "process", "", "", map);
            } catch (Exception unused6) {
            }
            try {
                synchronized (this.K) {
                    try {
                        RVLogger.d(Triver.TAG, "AR killed, notify ar dead");
                        dVarG.g.d = null;
                        dVarG.g.e = null;
                        b(dVarG, d.f24788a);
                        this.K.notifyAll();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Exception unused7) {
            }
        } catch (Throwable th2) {
            try {
                synchronized (this.K) {
                    try {
                        RVLogger.d(Triver.TAG, "AR killed, notify ar dead");
                        dVarG.g.d = null;
                        dVarG.g.e = null;
                        b(dVarG, d.f24788a);
                        this.K.notifyAll();
                        throw th2;
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
            } catch (Exception unused8) {
            }
        }
    }

    public void a(C0160a c0160a) {
        synchronized (L) {
            try {
                if (c0160a != null) {
                    try {
                        if (!c0160a.f24784a.equals(TriverMainActivity.class)) {
                            Application applicationContext = ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext();
                            d dVarC = c(c0160a);
                            if (!Triver.isProcessAlive(applicationContext, b(dVarC))) {
                                b(dVarC, d.f24788a);
                            } else {
                                b(dVarC, d.b);
                            }
                            RVLogger.d(Triver.TAG, "revertLaunchSetting finish");
                            F();
                            return;
                        }
                    } catch (Exception e2) {
                        RVLogger.e(Triver.TAG, "revertLaunchSetting exception:", e2);
                        RVLogger.d(Triver.TAG, "revertLaunchSetting finish");
                    }
                }
                RVLogger.d(Triver.TAG, "revertLaunchSetting finish");
                F();
            } catch (Throwable th) {
                RVLogger.d(Triver.TAG, "revertLaunchSetting finish");
                F();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, RVAppRecord rVAppRecord, C0160a c0160a, IBinder iBinder, ServiceConnection serviceConnection) {
        try {
            if (c0160a.e != null) {
                iBinder.unlinkToDeath(c0160a.e, 0);
                if (c0160a.e.c != null) {
                    context.unbindService(c0160a.e.c);
                }
            }
        } catch (Exception unused) {
        }
        try {
            c0160a.e = new c(context, c0160a, rVAppRecord, serviceConnection);
            iBinder.linkToDeath(c0160a.e, 0);
        } catch (Exception unused2) {
        }
    }

    public C0160a a(Context context, RVAppRecord rVAppRecord, RVAppRecord rVAppRecord2) {
        d next;
        if (rVAppRecord2 == null) {
            return a(context, rVAppRecord);
        }
        long startToken = rVAppRecord2.getStartToken();
        List<d> list = C;
        synchronized (list) {
            Iterator<d> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next != null && next.g != null && next.j == startToken) {
                    break;
                }
            }
            try {
                if (next == null) {
                    return a(context, rVAppRecord);
                }
                a(context, rVAppRecord, next.g);
                RVLogger.d(Triver.TAG, "preLaunchActivity finish");
                return next.g;
            } catch (Exception e2) {
                RVLogger.e(Triver.TAG, "preLaunchActivity exception:", e2);
                RVLogger.d(Triver.TAG, "preLaunchActivity finish");
            } finally {
                RVLogger.d(Triver.TAG, "preLaunchActivity finish");
                F();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0074  */
    /* JADX WARN: Code duplicated, block: B:60:0x00db A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x00dd A[Catch: all -> 0x0122, TRY_LEAVE, TryCatch #3 {all -> 0x0122, blocks: (B:39:0x008e, B:41:0x0096, B:43:0x00a0, B:44:0x00a2, B:50:0x00bf, B:51:0x00c0, B:61:0x00dd, B:78:0x011e, B:66:0x00f3, B:68:0x00fa, B:70:0x0106, B:71:0x010e, B:74:0x011a, B:58:0x00d2), top: B:101:0x0077 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x00f3 A[Catch: all -> 0x0122, TRY_ENTER, TryCatch #3 {all -> 0x0122, blocks: (B:39:0x008e, B:41:0x0096, B:43:0x00a0, B:44:0x00a2, B:50:0x00bf, B:51:0x00c0, B:61:0x00dd, B:78:0x011e, B:66:0x00f3, B:68:0x00fa, B:70:0x0106, B:71:0x010e, B:74:0x011a, B:58:0x00d2), top: B:101:0x0077 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x00fa A[Catch: all -> 0x0122, TryCatch #3 {all -> 0x0122, blocks: (B:39:0x008e, B:41:0x0096, B:43:0x00a0, B:44:0x00a2, B:50:0x00bf, B:51:0x00c0, B:61:0x00dd, B:78:0x011e, B:66:0x00f3, B:68:0x00fa, B:70:0x0106, B:71:0x010e, B:74:0x011a, B:58:0x00d2), top: B:101:0x0077 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0106 A[Catch: all -> 0x0122, TryCatch #3 {all -> 0x0122, blocks: (B:39:0x008e, B:41:0x0096, B:43:0x00a0, B:44:0x00a2, B:50:0x00bf, B:51:0x00c0, B:61:0x00dd, B:78:0x011e, B:66:0x00f3, B:68:0x00fa, B:70:0x0106, B:71:0x010e, B:74:0x011a, B:58:0x00d2), top: B:101:0x0077 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x011a A[Catch: all -> 0x0122, DONT_GENERATE, TRY_ENTER, TryCatch #3 {all -> 0x0122, blocks: (B:39:0x008e, B:41:0x0096, B:43:0x00a0, B:44:0x00a2, B:50:0x00bf, B:51:0x00c0, B:61:0x00dd, B:78:0x011e, B:66:0x00f3, B:68:0x00fa, B:70:0x0106, B:71:0x010e, B:74:0x011a, B:58:0x00d2), top: B:101:0x0077 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x013b  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.alibaba.triver.container.a] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7, types: [com.alibaba.triver.container.a$a] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARN: Type inference failed for: r9v9 */
    public C0160a a(final Context context, RVAppRecord rVAppRecord) {
        boolean z2;
        ?? Equals;
        ?? r9;
        final C0160a c0160aC;
        C0160a c0160a;
        String[] strArr;
        Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup("triver_common_config");
        int i2 = 0;
        if (configsByGroup != null) {
            try {
                String appId = rVAppRecord.getAppId();
                if ("true".equalsIgnoreCase(configsByGroup.get(TRiverConstants.ORANGE_KEY_TRIVER_STOP_ALL_MULTI_PROCESS))) {
                    G = 0;
                    return null;
                }
                String str = configsByGroup.get(TRiverConstants.ORANGE_KEY_TRIVER_STOP_MULTI_PROCESS_MINIAPP_ID);
                if (!TextUtils.isEmpty(str)) {
                    for (String str2 : str.split(",")) {
                        Equals = appId.equals(str2);
                        if (Equals != 0) {
                            return null;
                        }
                    }
                }
                if ("true".equals(configsByGroup.get(TRiverConstants.ORANGE_KEY_TRIVER_OLD_SINGLE_PROCESS_MODE))) {
                    z2 = true;
                    try {
                        G = 1;
                    } catch (Exception e2) {
                        e = e2;
                        RVLogger.e(Triver.TAG, "getNextLaunchActivityInfo error", e);
                    }
                } else {
                    z2 = false;
                }
            } catch (Exception e3) {
                e = e3;
                z2 = false;
            }
        } else {
            z2 = false;
        }
        try {
            try {
                try {
                    synchronized (L) {
                        try {
                            final String appId2 = rVAppRecord.getAppId();
                            try {
                                if (!this.J || TextUtils.isEmpty(appId2) || (strArr = this.I) == null) {
                                    c0160aC = null;
                                } else {
                                    int length = strArr.length;
                                    c0160aC = null;
                                    while (i2 < length) {
                                        try {
                                            if (appId2.equals(strArr[i2])) {
                                                d dVarG = g();
                                                if (dVarG.h == d.e) {
                                                    synchronized (this.K) {
                                                        RVLogger.d(Triver.TAG, "AR process is in wait list, we need to wait");
                                                        this.F.postAtFrontOfQueue(new Runnable() { // from class: com.alibaba.triver.container.a.8
                                                            @Override // java.lang.Runnable
                                                            public void run() {
                                                                a.this.b(context);
                                                            }
                                                        });
                                                        this.K.wait(1000L);
                                                    }
                                                }
                                                RVLogger.d(Triver.TAG, "Ready to start Ar mimiapp");
                                                c0160aC = dVarG.g;
                                            }
                                            i2++;
                                            c0160aC = c0160aC;
                                        } catch (Exception e4) {
                                            e = e4;
                                            RVLogger.e(Triver.TAG, "AR launch exception:", e);
                                            if (c0160aC == null) {
                                                if (z2) {
                                                    c0160a = new C0160a();
                                                    try {
                                                        c0160a.f24784a = TriverSubActivity.class;
                                                        c0160a.b = IpcMsgClientService.IpcMsgClientService1.class;
                                                        c0160a.c = ":wml1";
                                                        c0160aC = c0160a;
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        Equals = c0160a;
                                                        try {
                                                            throw th;
                                                        } catch (Exception e5) {
                                                            e = e5;
                                                            RVLogger.e(Triver.TAG, "preLaunchActivity exception:", e);
                                                            r9 = Equals;
                                                            RVLogger.d(Triver.TAG, "preLaunchActivity finish");
                                                            F();
                                                            if (r9 != 0) {
                                                                a(r9);
                                                            }
                                                            return null;
                                                        }
                                                    }
                                                } else {
                                                    c0160aC = C();
                                                }
                                            }
                                            if (c0160aC != null) {
                                                this.F.postAtFrontOfQueue(new Runnable() { // from class: com.alibaba.triver.container.a.9
                                                    @Override // java.lang.Runnable
                                                    public void run() {
                                                        try {
                                                            a.this.a(c0160aC, appId2);
                                                        } catch (Exception unused) {
                                                        }
                                                    }
                                                });
                                            }
                                            if (c0160aC != null) {
                                                a(context, rVAppRecord, c0160aC);
                                                E();
                                                RVLogger.d(Triver.TAG, "preLaunchActivity finish");
                                                F();
                                                return c0160aC;
                                            }
                                            r9 = c0160aC;
                                            RVLogger.d(Triver.TAG, "preLaunchActivity finish");
                                            F();
                                            if (r9 != 0) {
                                                a(r9);
                                            }
                                            return null;
                                        }
                                    }
                                }
                            } catch (Exception e6) {
                                e = e6;
                                c0160aC = null;
                            }
                            if (c0160aC == null) {
                                if (z2) {
                                    c0160a = new C0160a();
                                    c0160a.f24784a = TriverSubActivity.class;
                                    c0160a.b = IpcMsgClientService.IpcMsgClientService1.class;
                                    c0160a.c = ":wml1";
                                    c0160aC = c0160a;
                                } else {
                                    c0160aC = C();
                                }
                            }
                            if (c0160aC != null) {
                                this.F.postAtFrontOfQueue(new Runnable() { // from class: com.alibaba.triver.container.a.9
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            a.this.a(c0160aC, appId2);
                                        } catch (Exception unused) {
                                        }
                                    }
                                });
                            }
                            if (c0160aC != null) {
                                a(context, rVAppRecord, c0160aC);
                                E();
                                RVLogger.d(Triver.TAG, "preLaunchActivity finish");
                                F();
                                return c0160aC;
                            }
                            r9 = c0160aC;
                            RVLogger.d(Triver.TAG, "preLaunchActivity finish");
                            F();
                            if (r9 != 0) {
                                a(r9);
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            Equals = 0;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Throwable th4) {
                RVLogger.d(Triver.TAG, "preLaunchActivity finish");
                F();
                throw th4;
            }
        } catch (Exception e7) {
            e = e7;
            Equals = 0;
        }
    }

    private void a(final Context context, final RVAppRecord rVAppRecord, final C0160a c0160a) {
        Intent intent = new Intent();
        intent.setClass(context, c0160a.b);
        context.startService(intent);
        context.bindService(intent, new ServiceConnection() { // from class: com.alibaba.triver.container.a.10
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                RVLogger.d(Triver.TAG, "onServiceConnected " + componentName);
                IpcChannelManager.getInstance().registerClientChannel(rVAppRecord.getStartToken(), IIpcChannel.Stub.asInterface(iBinder));
                c0160a.d = iBinder;
                a aVar = a.this;
                Context context2 = context;
                RVAppRecord rVAppRecord2 = rVAppRecord;
                C0160a c0160a2 = c0160a;
                aVar.a(context2, rVAppRecord2, c0160a2, c0160a2.d, this);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                RVLogger.d(Triver.TAG, "onServiceDisconnected " + componentName);
            }
        }, 1);
        a(rVAppRecord.getAppId(), rVAppRecord.getStartToken(), c0160a);
        RVLogger.d(Triver.TAG, "preLaunchActivity: " + c0160a.f24784a);
        try {
            HashMap map = new HashMap();
            map.put("targetProcess", b(c0160a));
            ((RVMonitor) RVProxy.get(RVMonitor.class)).flowLog(l, "choose launch activity finish", "process", rVAppRecord.getAppId(), (rVAppRecord.getAppModel() == null || rVAppRecord.getAppModel().getAppInfoModel() == null) ? "" : rVAppRecord.getAppModel().getAppInfoModel().getMainUrl(), map);
        } catch (Exception e2) {
            RVLogger.e(Triver.TAG, "bindIPC ", e2);
        }
    }

    private void a(String str, long j2, C0160a c0160a) {
        if (c0160a == null) {
            RVLogger.d(Triver.TAG, "addStack finish");
            F();
            return;
        }
        try {
            try {
                RVLogger.d(Triver.TAG, "addStack:" + c0160a.f24784a + " " + str);
                d dVarC = c(c0160a);
                dVarC.h = d.c;
                dVarC.i = str;
                dVarC.j = j2;
            } catch (Exception e2) {
                RVLogger.e(Triver.TAG, "addStack exception:", e2);
            }
        } finally {
            RVLogger.d(Triver.TAG, "addStack finish");
            F();
        }
    }

    public void a(String str, boolean z2) {
        String[] strArr;
        synchronized (L) {
            try {
                try {
                    RVLogger.d(Triver.TAG, "removeFromStack:" + str);
                    d dVarE = e(str);
                    if (dVarE == null) {
                        RVLogger.d(Triver.TAG, "removeFromStack finish");
                        F();
                        return;
                    }
                    String strB = b(dVarE);
                    C0160a c0160a = dVarE.g;
                    if (!TextUtils.isEmpty(strB) && c0160a != null) {
                        RVLogger.d(Triver.TAG, "removeFromStack:" + strB);
                        a(c0160a.f24784a);
                        if (z2) {
                            b(dVarE, d.f24788a);
                        } else {
                            if (this.J && !TextUtils.isEmpty(str) && (strArr = this.I) != null) {
                                for (String str2 : strArr) {
                                    if (str.equals(str2)) {
                                        RVLogger.d(Triver.TAG, "release ar process:" + b(dVarE));
                                        c(dVarE);
                                        b(false);
                                        this.F.postDelayed(new Runnable() { // from class: com.alibaba.triver.container.a.2
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                a.this.b(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
                                            }
                                        }, 500L);
                                        RVLogger.d(Triver.TAG, "removeFromStack finish");
                                        F();
                                        return;
                                    }
                                }
                            }
                            d dVarF = f();
                            if (dVarF != null && !dVarF.g.equals(c0160a)) {
                                if (A() >= H) {
                                    c(dVarE);
                                } else {
                                    b(dVarE, d.b);
                                }
                            } else if ((dVarF == null || !dVarF.g.equals(c0160a)) && dVarF == null) {
                                b(dVarE, d.f);
                            }
                            b(false);
                        }
                    } else {
                        RVLogger.e(Triver.TAG, "removeFromStack:Can't find target in sActivityStack?");
                    }
                    RVLogger.d(Triver.TAG, "removeFromStack finish");
                    F();
                } catch (Exception e2) {
                    RVLogger.e(Triver.TAG, "removeFromStack exception:", e2);
                    RVLogger.d(Triver.TAG, "removeFromStack finish");
                }
            } catch (Throwable th) {
                RVLogger.d(Triver.TAG, "removeFromStack finish");
                F();
                throw th;
            }
        }
    }

    public void a(String str) {
        synchronized (L) {
            try {
                try {
                    RVLogger.d(Triver.TAG, "moveToBackground:" + str);
                    d dVarE = e(str);
                    if (dVarE.g != null) {
                        dVarE.h = d.d;
                    } else {
                        RVLogger.e(Triver.TAG, "moveToBackground:Can't find target in sActivityStack?");
                    }
                    RVLogger.d(Triver.TAG, "moveToBackground finish");
                } catch (Exception e2) {
                    RVLogger.e(Triver.TAG, "moveToBackground exception:", e2);
                    RVLogger.d(Triver.TAG, "moveToBackground finish");
                }
                F();
            } catch (Throwable th) {
                RVLogger.d(Triver.TAG, "moveToBackground finish");
                F();
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Class cls) {
        if (cls == null) {
            return false;
        }
        try {
            for (ActivityManager.AppTask appTask : ((ActivityManager) ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext().getSystemService(TTDownloadField.TT_ACTIVITY)).getAppTasks()) {
                ActivityManager.RecentTaskInfo taskInfo = appTask.getTaskInfo();
                if (taskInfo != null && taskInfo.baseIntent != null && taskInfo.baseIntent.getComponent() != null && cls.getCanonicalName().equalsIgnoreCase(taskInfo.baseIntent.getComponent().getClassName())) {
                    appTask.finishAndRemoveTask();
                    return true;
                }
            }
        } catch (Throwable th) {
            RVLogger.e(Triver.TAG, "removeFromRecentTasksList exception", th);
        }
        return false;
    }

    public static void a(String str, int i2) {
        for (d dVar : C) {
            if (!TextUtils.isEmpty(str) && str.equals(dVar.i)) {
                dVar.k = i2;
            }
        }
    }

    public static boolean a(int i2) {
        if (i2 == -1) {
            return false;
        }
        try {
            Iterator<d> it = C.iterator();
            while (it.hasNext()) {
                if (it.next().k == i2) {
                    return true;
                }
            }
        } catch (Exception e2) {
            RVLogger.e(Triver.TAG, "isTriverTask error", e2);
        }
        return false;
    }

    public static void a(String str, Activity activity) {
        try {
            WeakReference<Activity> weakReferenceRemove = D.remove(str);
            if (weakReferenceRemove != null && weakReferenceRemove.get() != null) {
                weakReferenceRemove.get().finish();
            }
            D.put(str, new WeakReference<>(activity));
        } catch (Exception e2) {
            RVLogger.e(Triver.TAG, "addProxy error", e2);
        }
    }
}

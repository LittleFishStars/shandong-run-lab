package com.alibaba.triver.container;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.app.AppUtils;
import com.alibaba.ariver.app.PageNode;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.point.activity.ActivityResultPoint;
import com.alibaba.ariver.app.ipc.IpcClientUtils;
import com.alibaba.ariver.engine.api.embedview.IEmbedView;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.proxy.RVResourceManager;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.R;
import com.alibaba.triver.basic.api.RequestPermission;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorData;
import com.alibaba.triver.kit.api.appmonitor.LaunchMonitorUtils;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.common.TriverAppMonitorConstants;
import com.alibaba.triver.kit.api.proxy.IDeviceInfoProxy;
import com.alibaba.triver.kit.api.proxy.ITriverMonitorProxy;
import com.alibaba.triver.triver_render.render.WMLTRWebView;
import com.alibaba.triver.utils.CommonUtils;
import com.alibaba.triver.utils.c;
import com.alibaba.triver.utils.f;
import com.byazt.hv.TTDownloadField;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverContainerHelper {
    private static final String b = "TriverContainerHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    f f24763a;
    private volatile long c;
    private boolean d = false;
    private Handler e;
    private com.alibaba.triver.app.a f;
    private InsideBroadcastReceiver g;
    private Activity h;
    private App i;

    public class InsideBroadcastReceiver extends BroadcastReceiver {
        public InsideBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            TriverContainerHelper.this.c = intent.getIntExtra("from-webview-id", 0);
        }
    }

    public TriverContainerHelper(Activity activity) {
        this.h = activity;
    }

    public void b() {
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.IDLE).execute(new Runnable() { // from class: com.alibaba.triver.container.TriverContainerHelper.2
            @Override // java.lang.Runnable
            public void run() {
                RVLogger.d(TriverContainerHelper.b, "cleanData" + TriverContainerHelper.this.i);
                AppModel appModel = (AppModel) TriverContainerHelper.this.i.getData(AppModel.class);
                if (appModel != null) {
                    ((RVResourceManager) RVProxy.get(RVResourceManager.class)).deleteDownloadPackage(appModel);
                }
            }
        });
    }

    public void c() {
        if (this.d) {
            RVLogger.d(b, "Move to front");
            IpcClientUtils.sendMsgToServerByApp(this.i, 102, null);
            this.d = false;
        }
        com.alibaba.triver.app.a aVar = this.f;
        if (aVar != null) {
            this.e.removeCallbacks(aVar);
            this.f = null;
        }
    }

    public void d() {
        if (LaunchMonitorUtils.canReportOnPause(this.i)) {
            LaunchMonitorUtils.commitMonitorInSub(this.i);
        }
    }

    public void e() {
        this.d = true;
        com.alibaba.triver.app.a aVar = this.f;
        if (aVar != null) {
            this.e.removeCallbacks(aVar);
        }
        com.alibaba.triver.app.a aVar2 = new com.alibaba.triver.app.a(this.i);
        this.f = aVar2;
        this.e.postDelayed(aVar2, CommonUtils.getKeepAliveSeconds() * 1000);
    }

    public void a(App app) {
        this.i = app;
        LaunchMonitorData subMonitorData = LaunchMonitorUtils.getSubMonitorData(app);
        if (subMonitorData == null) {
            subMonitorData = new LaunchMonitorData();
            if (app != null) {
                app.setData(LaunchMonitorData.class, subMonitorData);
            }
        }
        this.g = new InsideBroadcastReceiver();
        LocalBroadcastManager.getInstance(this.h).registerReceiver(this.g, new IntentFilter(RequestPermission.ACTION_WV_CAMERA_FILTER));
        this.e = new Handler(this.h.getMainLooper());
        f fVar = new f(this.h);
        this.f24763a = fVar;
        fVar.a(new f.a() { // from class: com.alibaba.triver.container.TriverContainerHelper.1
            @Override // com.alibaba.triver.utils.f.a
            public void a(int i) {
                if (TriverContainerHelper.this.i != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("height", (Object) Integer.valueOf(CommonUtils.px2dp(i)));
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("data", (Object) jSONObject);
                    AppUtils.sendToApp(TriverContainerHelper.this.i, RVParams.KEYBOARD_HEIGHT, jSONObject2, null);
                }
            }

            @Override // com.alibaba.triver.utils.f.a
            public void b(int i) {
                if (TriverContainerHelper.this.i != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("height", (Object) 0);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("data", (Object) jSONObject);
                    AppUtils.sendToApp(TriverContainerHelper.this.i, RVParams.KEYBOARD_HEIGHT, jSONObject2, null);
                }
            }
        });
        if (subMonitorData.containsKey(TriverAppMonitorConstants.KEY_STAGE_CONTAINER_FINISH)) {
            return;
        }
        subMonitorData.addPoint(TriverAppMonitorConstants.KEY_STAGE_CONTAINER_FINISH);
    }

    public void a() {
        if (this.g != null) {
            LocalBroadcastManager.getInstance(this.h).unregisterReceiver(this.g);
            this.g = null;
        }
        LaunchMonitorUtils.commitMonitorInSub(this.i);
        this.f24763a.a();
    }

    public void a(final App app, final Context context) {
        try {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.alibaba.triver.container.TriverContainerHelper.3
                @Override // java.lang.Runnable
                public void run() {
                    ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.NORMAL).execute(new Runnable() { // from class: com.alibaba.triver.container.TriverContainerHelper.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int iA;
                            int iA2;
                            try {
                                HashMap map = new HashMap();
                                String processName = ProcessUtils.getProcessName();
                                map.put(TRiverConstants.KEY_CURRENT_PROCESS_NAME, processName);
                                map.put(TRiverConstants.KEY_MONITOR_PHONE_CLASS, String.valueOf(((IDeviceInfoProxy) RVProxy.get(IDeviceInfoProxy.class)).getDeviceLevel()));
                                int i = 0;
                                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses()) {
                                    if (!TextUtils.isEmpty(runningAppProcessInfo.processName) && runningAppProcessInfo.processName.contains(":wml")) {
                                        i++;
                                    }
                                }
                                map.put(TRiverConstants.KEY_MONITOR_CURRENT_PROCESS_NUM, String.valueOf(i));
                                if (ProcessUtils.isMainProcess()) {
                                    int iMyPid = Process.myPid();
                                    iA = c.a(processName, context);
                                    iA2 = iMyPid;
                                } else {
                                    iA2 = c.a(context.getPackageName(), context);
                                    iA = Process.myPid();
                                }
                                float fA = c.a(iA2, context);
                                float fA2 = c.a(iA, context);
                                float fA3 = c.a();
                                map.put(TRiverConstants.KEY_MONITOR_MAIN_PROCESS_MEMORY, String.valueOf(fA));
                                map.put(TRiverConstants.KEY_MONITOR_SUB_PROCESS_MEMORY, String.valueOf(fA2));
                                map.put(TRiverConstants.KEY_MONITOR_MAIN_PROCESS_MEMORY_RATE, String.valueOf((fA / fA3) * 100.0f));
                                map.put(TRiverConstants.KEY_MONITOR_SUB_PROCESS_MEMORY_RATE, String.valueOf((fA2 / fA3) * 100.0f));
                                map.put(TRiverConstants.KEY_MONITOR_DEVICE_TOTAL_MEMORY, String.valueOf(fA3));
                                ((ITriverMonitorProxy) RVProxy.get(ITriverMonitorProxy.class)).addDatas2Performance(app, TRiverConstants.KEY_MONITOR_MULTI_CONTAINER_INFO, map);
                                try {
                                    for (Map.Entry entry : map.entrySet()) {
                                        RVLogger.d(TriverContainerHelper.b, "commitContainerInfo: " + entry.getKey() + "," + entry.getValue());
                                    }
                                } catch (Exception unused) {
                                }
                            } catch (Throwable th) {
                                RVLogger.e(TriverContainerHelper.b, "commitContainerInfo exception:", th);
                            }
                        }
                    });
                }
            }, 5000L);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(int i, int i2, Intent intent) {
        View view;
        if (this.i != null) {
            ((ActivityResultPoint) ExtensionPoint.as(ActivityResultPoint.class).node(this.i).create()).onActivityResult(i, i2, intent);
            try {
                View view2 = this.i.getEngineProxy().getTopRender().getView();
                if (view2 != 0 && view2.hashCode() == this.c) {
                    if (view2 instanceof WMLTRWebView) {
                        ((WMLTRWebView) view2).onActivityResult(i, i2, intent);
                        return;
                    } else {
                        if (view2.findViewById(R.id.triver_webview_id) instanceof WMLTRWebView) {
                            ((WMLTRWebView) view2.findViewById(R.id.triver_webview_id)).onActivityResult(i, i2, intent);
                            return;
                        }
                        return;
                    }
                }
                for (IEmbedView iEmbedView : ((PageNode) this.i.getEngineProxy().getTopRender().getPage()).getPageContext().getEmbedViewManager().findAllEmbedView()) {
                    if ("webview".equals(iEmbedView.getType()) && (view = iEmbedView.getView(0, 0, "", "", null)) != 0 && view.hashCode() == this.c) {
                        if (view instanceof WMLTRWebView) {
                            ((WMLTRWebView) view).onActivityResult(i, i2, intent);
                            return;
                        } else if (view.findViewById(R.id.triver_webview_id) instanceof WMLTRWebView) {
                            ((WMLTRWebView) view.findViewById(R.id.triver_webview_id)).onActivityResult(i, i2, intent);
                            return;
                        }
                    }
                }
            } catch (Exception e) {
                RVLogger.w(b, "onActivityResult: ", e);
            }
        }
    }
}

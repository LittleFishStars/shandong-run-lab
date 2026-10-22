package com.alibaba.ariver.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.EntryInfo;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.app.api.monitor.RVPerformanceTracker;
import com.alibaba.ariver.app.extensions.CustomServerMsgExtension;
import com.alibaba.ariver.app.ipc.IpcClientUtils;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.engine.api.bridge.remote.RemoteCallbackPool;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.monitor.ErrId;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.api.track.Event;
import com.alibaba.ariver.kernel.api.track.EventTracker;
import com.alibaba.ariver.kernel.api.track.TrackId;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceKey;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.ariver.kernel.ipc.IpcMessage;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.ariver.kernel.ipc.IpcMessageHandler;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.content.ResourcePackage;
import com.alibaba.ariver.resource.api.extension.AppModelInitPoint;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.api.prepare.PrepareData;
import com.alibaba.ariver.resource.content.GlobalPackagePool;
import com.alibaba.ariver.resource.runtime.ResourceContextManager;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AppMsgReceiver implements IpcMessageHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23810a = "AriverApp:AppMsgReceiver";
    private AppNode b;

    public AppMsgReceiver(AppNode appNode) {
        this.b = appNode;
    }

    private void a(EntryInfo entryInfo) {
        if (this.b.getSplashView() != null) {
            this.b.getSplashView().showLoading(entryInfo);
        }
    }

    private void b(EntryInfo entryInfo) {
        if (this.b.getSplashView() != null) {
            this.b.getSplashView().update(entryInfo);
        }
    }

    @Override // com.alibaba.ariver.kernel.ipc.IpcMessageHandler
    public void handleMessage(IpcMessage ipcMessage) {
        Page pageByNodeId;
        ResourceContext resourceContext;
        Message message = ipcMessage.bizMsg;
        RVLogger.d(f23810a, "handle ipc msg: " + message.what + " data: " + message.getData() + " fromPending: " + (message.arg1 == 1));
        EntryInfo entryInfo = (EntryInfo) BundleUtils.getParcelable(message.getData(), RVConstants.EXTRA_ENTRY_INFO);
        HashMap map = null;
        switch (message.what) {
            case 0:
                boolean z = BundleUtils.getBoolean(message.getData(), RVConstants.EXTRA_NEED_WAIT_LOADING_ANIM, false);
                if (entryInfo != null) {
                    this.b.setData(EntryInfo.class, entryInfo);
                }
                this.b.getSceneParams().putBoolean(RVConstants.EXTRA_NEED_WAIT_LOADING_ANIM, z);
                a(entryInfo);
                break;
            case 1:
                if (entryInfo != null) {
                    this.b.setData(EntryInfo.class, entryInfo);
                }
                b(entryInfo);
                break;
            case 2:
                RVTraceUtils.traceBeginSection(RVTraceKey.RV_AppMsgReceiver_handleEnterApp);
                this.b.putBooleanValue(RVConstants.EXTRA_RECEIVED_PREPARE_FINISH, true);
                a(message.getData());
                RVTraceUtils.traceEndSection(RVTraceKey.RV_AppMsgReceiver_handleEnterApp);
                break;
            case 3:
                String string = BundleUtils.getString(message.getData(), RVConstants.EXTRA_PREPARE_EXCEPTION_CODE);
                String string2 = BundleUtils.getString(message.getData(), RVConstants.EXTRA_PREPARE_EXCEPTION_MESSAGE);
                Bundle bundle = message.getData().getBundle(RVConstants.EXTRA_PREPARE_EXCEPTION_EXTRAS);
                RVLogger.d(f23810a, "prepareFail client with code: " + string + ", msg: " + string2 + ", splashView: " + this.b.getSplashView());
                if (this.b.getSplashView() != null) {
                    if (bundle != null) {
                        map = new HashMap();
                        for (String str : bundle.keySet()) {
                            if (str != null) {
                                map.put(str, bundle.getString(str));
                            }
                        }
                    }
                    this.b.getSplashView().showError(string, string2, map);
                }
                ((RVMonitor) RVProxy.get(RVMonitor.class)).error(this.b.getActivePage(), ErrId.RV_TYPE_APP_PREPARE_ERROR, string, string2, null, null);
                PrepareData prepareData = (PrepareData) BundleUtils.getParcelable(message.getData(), RVConstants.EXTRA_PREPARE_DATA);
                Event eventError = ((EventTracker) RVProxy.get(EventTracker.class)).error(this.b, "ResPrepareFail", string);
                if (eventError != null && prepareData != null) {
                    a(string, prepareData, eventError);
                    break;
                }
                break;
            case 4:
                RVLogger.d(f23810a, "force finish for reason: " + BundleUtils.getString(message.getData(), RVConstants.EXTRA_PREPARE_ABORT_REASON));
                this.b.exit();
                break;
            case 5:
                if (this.b.getSplashView() != null) {
                    this.b.getSplashView().exit(null);
                }
                break;
            case 7:
                JSONObject jSONObjectUnmarshallJSONObject = JSONUtils.unmarshallJSONObject(BundleUtils.getByteArray(message.getData(), "data"));
                boolean z2 = BundleUtils.getBoolean(message.getData(), "keepCallback", false);
                SendToNativeCallback callback = RemoteCallbackPool.getInstance().getCallback(BundleUtils.getLong(message.getData(), IpcMessageConstants.EXTRA_NODE_ID), BundleUtils.getString(message.getData(), "clientId"), !z2);
                StringBuilder sb = new StringBuilder();
                sb.append("SERVER_MSG_REMOTE_API_CALLBACK found callback: ");
                sb.append(callback != null);
                sb.append(", keepCallback: ");
                sb.append(z2);
                RVLogger.d(f23810a, sb.toString());
                if (callback != null) {
                    callback.onCallback(jSONObjectUnmarshallJSONObject, z2);
                }
                break;
            case 8:
                final NativeCallContext nativeCallContext = (NativeCallContext) message.getData().getParcelable(IpcMessageConstants.EXTRA_REMOTE_CALL_CONTEXT);
                boolean z3 = message.getData().getBoolean(IpcMessageConstants.EXTRA_REMOTE_CALL_NEED_PERMISSION, true);
                if (nativeCallContext == null) {
                    RVLogger.w(f23810a, "SERVER_MSG_REMOTE_API_CALL callContext == null!!");
                } else {
                    Node node = nativeCallContext.getNode();
                    if (node != null) {
                        if ((node instanceof App) || (pageByNodeId = this.b.getPageByNodeId(node.getNodeId())) == null) {
                            nativeCallContext.setNode(this.b);
                        } else {
                            nativeCallContext.setNode(pageByNodeId);
                        }
                    }
                    SendToNativeCallback sendToNativeCallback = new SendToNativeCallback() { // from class: com.alibaba.ariver.app.AppMsgReceiver.1
                        @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
                        public void onCallback(JSONObject jSONObject, boolean z4) {
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("clientId", nativeCallContext.getId());
                            bundle2.putByteArray(IpcMessageConstants.EXTRA_REMOTE_CALLBACK_DATA, JSONUtils.marshallJSONObject(jSONObject));
                            bundle2.putBoolean(IpcMessageConstants.EXTRA_REMOTE_CALLBACK_KEEP, z4);
                            IpcClientUtils.sendMsgToServerByApp(AppMsgReceiver.this.b, 7, bundle2);
                        }
                    };
                    if (this.b.isExited()) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("error", (Object) "remote App already exited!");
                        sendToNativeCallback.onCallback(jSONObject, false);
                    } else {
                        this.b.getEngineProxy().getBridge().sendToNative(nativeCallContext, sendToNativeCallback, z3);
                    }
                }
                break;
            case 9:
                String string3 = BundleUtils.getString(message.getData(), IpcMessageConstants.EXTRA_EVENT);
                final String string4 = BundleUtils.getString(message.getData(), "clientId");
                AppUtils.sendToApp(this.b, string3, JSONUtils.unmarshallJSONObject(BundleUtils.getByteArray(message.getData(), "data")), new SendToRenderCallback() { // from class: com.alibaba.ariver.app.AppMsgReceiver.2
                    @Override // com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback
                    public void onCallBack(JSONObject jSONObject2) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("clientId", string4);
                        IpcClientUtils.sendMsgToServerByApp(AppMsgReceiver.this.b, 7, bundle2);
                    }
                });
                break;
            case 10:
                Node child = this.b.getChild(BundleUtils.getLong(message.getData(), IpcMessageConstants.EXTRA_PAGE_NODE_ID));
                if (child instanceof Page) {
                    ((Page) child).exit(false);
                }
                break;
            case 11:
                Intent intent = (Intent) BundleUtils.getParcelable(message.getData(), "intent");
                RVLogger.d(f23810a, "SERVER_MSG_START_ACTIVITY: " + intent);
                if (intent != null) {
                    if (this.b.getActivePage() != null && this.b.getActivePage().getPageContext() != null && this.b.getActivePage().getPageContext().getActivity() != null) {
                        RVLogger.d(f23810a, "SERVER_MSG_START_ACTIVITY use activity to start!");
                        this.b.getActivePage().getPageContext().getActivity().startActivityForResult(intent, 1024);
                    } else if (this.b.getAppContext() != null) {
                        RVLogger.d(f23810a, "SERVER_MSG_START_ACTIVITY use context to start!");
                        this.b.getAppContext().getContext().startActivity(intent);
                    } else {
                        RVLogger.d(f23810a, "SERVER_MSG_START_ACTIVITY cannot find activity to start!");
                    }
                }
                break;
            case 12:
                String string5 = BundleUtils.getString(message.getData(), IpcMessageConstants.EXTRA_STUB_NAME);
                long jElapsedRealtime = BundleUtils.getLong(message.getData(), IpcMessageConstants.EXTRA_STUB_TS);
                if (jElapsedRealtime == 0) {
                    jElapsedRealtime = SystemClock.elapsedRealtime();
                }
                ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.b, string5, jElapsedRealtime);
                break;
            case 13:
                ResourcePackage resourcePackage = GlobalPackagePool.getInstance().getPackage(RVConstants.TINY_WEB_COMMON_APPID);
                if (resourcePackage != null) {
                    resourcePackage.reload();
                }
                break;
            case 14:
                AppModel appModel = (AppModel) BundleUtils.getParcelable(message.getData(), IpcMessageConstants.EXTRA_FALLBACK_APP_MODEL);
                if (appModel != null && TextUtils.equals(appModel.getAppId(), this.b.getAppId()) && (resourceContext = ResourceContextManager.getInstance().get(this.b.getAppId())) != null) {
                    resourceContext.getOnlineResourceFetcher().startFallback(appModel);
                    break;
                }
                break;
            case 15:
                AppModel appModel2 = (AppModel) BundleUtils.getParcelable(message.getData(), "appInfo");
                if (appModel2 != null) {
                    ((AppModelInitPoint) ExtensionPoint.as(AppModelInitPoint.class).node(this.b).create()).onGetAppInfo(appModel2);
                }
                break;
            case 16:
                String string6 = BundleUtils.getString(message.getData(), IpcMessageConstants.EXTRA_STUB_NAME);
                String string7 = BundleUtils.getString(message.getData(), IpcMessageConstants.EXTRA_ATTR_VALUE);
                if (!TextUtils.isEmpty(string6) && !TextUtils.isEmpty(string7)) {
                    ((EventTracker) RVProxy.get(EventTracker.class)).addAttr(this.b, string6, string7);
                    break;
                }
                break;
            case 17:
                ((CustomServerMsgExtension) ExtensionPoint.as(CustomServerMsgExtension.class).node(this.b).create()).onGetMessage(this.b, ipcMessage);
                break;
        }
    }

    private void a(Bundle bundle) {
        PrepareData prepareData;
        boolean z = BundleUtils.getBoolean(this.b.getSceneParams(), RVConstants.EXTRA_PREPARE_NEED_WAIT_IPC, false);
        RVLogger.d(f23810a, "handleEnterApp needWaitIpc: " + z);
        Bundle bundle2 = (Bundle) BundleUtils.getParcelable(bundle, RVConstants.EXTRA_START_PARAMS);
        Bundle bundle3 = (Bundle) BundleUtils.getParcelable(bundle, RVConstants.EXTRA_SCENE_PARAMS);
        RVPerformanceTracker rVPerformanceTracker = (RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class);
        AppNode appNode = this.b;
        rVPerformanceTracker.track(appNode, appNode.getStartUrl(), PerfId.jumpAppStart, this.b.getSceneParams().getLong(RVConstants.EXTRA_JUMP_APP_START_TIMESTAMP));
        long j = this.b.getSceneParams().getLong(RVConstants.EXTRA_START_ACTIVITY_TIMESTAMP);
        RVPerformanceTracker rVPerformanceTracker2 = (RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class);
        AppNode appNode2 = this.b;
        rVPerformanceTracker2.track(appNode2, appNode2.getStartUrl(), PerfId.startActivity, j);
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.b, TrackId.Stub_StartNebulaActivity, j);
        long j2 = BundleUtils.getLong(bundle3, RVConstants.EXTRA_SETUP_TIMESTAMP);
        RVPerformanceTracker rVPerformanceTracker3 = (RVPerformanceTracker) RVProxy.get(RVPerformanceTracker.class);
        AppNode appNode3 = this.b;
        rVPerformanceTracker3.track(appNode3, appNode3.getStartUrl(), PerfId.setupStart, j2);
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.b, TrackId.Stub_SetupStart, j2);
        if (z) {
            ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.b, TrackId.Stub_PrepareIPCFinish);
            if (bundle2 != null) {
                RVLogger.d(f23810a, "handleEnterApp with new startParam: " + bundle2);
                this.b.getStartParams().putAll(bundle2);
            }
            if (bundle3 != null) {
                RVLogger.d(f23810a, "handleEnterApp with new sceneParam: " + bundle3);
                String string = BundleUtils.getString(bundle3, "appType", "WEB_TINY");
                RVLogger.d(f23810a, "handleEnterApp with new appType: " + string);
                String configWithProcessCache = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_setNewTypeH5", "yes");
                if ("WEB_H5".equals(string) && "yes".equals(configWithProcessCache)) {
                    this.b.setAppType(string);
                }
                this.b.getSceneParams().putAll(bundle3);
            }
            String configWithProcessCache2 = ((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_notStartWhenDestroyed", null);
            if (this.b.isDestroyed() && !"NO".equalsIgnoreCase(configWithProcessCache2)) {
                RVLogger.w(f23810a, "app is destroyed");
            } else {
                this.b.start();
            }
        }
        long j3 = BundleUtils.getLong(bundle3, RVConstants.EXTRA_SETUP_END_TIMESTAMP, 0L);
        Event eventStub = j3 > 0 ? ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.b, TrackId.Stub_SetupEnd, j3) : null;
        if (eventStub == null || (prepareData = (PrepareData) BundleUtils.getParcelable(bundle, RVConstants.EXTRA_PREPARE_DATA)) == null) {
            return;
        }
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.b, TrackId.Stub_Resource_PrepareStart, prepareData.getBeginTime());
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.b, TrackId.Stub_Resource_PrepareFinish, prepareData.getEndTime());
        ((EventTracker) RVProxy.get(EventTracker.class)).cost(this.b, TrackId.Cost_Resource_Rpc, prepareData.getRequestEndTime() - prepareData.getRequestBeginTime());
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.b, TrackId.Stub_Rpc_Start, prepareData.getRequestBeginTime());
        ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.b, TrackId.Stub_Rpc_End, prepareData.getRequestEndTime());
        ((EventTracker) RVProxy.get(EventTracker.class)).cost(this.b, TrackId.Cost_Resource_Download, prepareData.getDownloadEndTime() - prepareData.getDownloadTime());
        ((EventTracker) RVProxy.get(EventTracker.class)).cost(this.b, TrackId.Cost_Resource_UnZip, prepareData.getInstallEndTime() - prepareData.getInstallTime());
        if (prepareData.getData() != null) {
            if (BundleUtils.getBoolean(prepareData.getData(), TrackId.Stub_CCDN_PREPARE_FAIL, false)) {
                ((EventTracker) RVProxy.get(EventTracker.class)).stub(this.b, TrackId.Stub_CCDN_PREPARE_FAIL);
            }
            long j4 = BundleUtils.getLong(prepareData.getData(), TrackId.Stub_CCDN_PREPARE_START, 0L);
            long j5 = BundleUtils.getLong(prepareData.getData(), TrackId.Stub_CCDN_PREPARE_END, 0L);
            if (j4 != 0 && j5 != 0) {
                ((EventTracker) RVProxy.get(EventTracker.class)).cost(this.b, TrackId.Cost_CCDN_Prepare, j5 - j4);
            }
        }
        a("1", prepareData, eventStub);
    }

    private void a(String str, PrepareData prepareData, Event event) {
        HashMap map = new HashMap();
        map.put("res_errc", str);
        map.put("res_req", prepareData.getRequestMode());
        map.put("res_off", prepareData.getOfflineMode());
        map.put("res_nbu", prepareData.getNbUrl());
        map.put("res_rpc", Boolean.toString(prepareData.getRequestEndTime() > 0));
        map.put("res_dl", Boolean.toString(prepareData.getDownloadEndTime() > 0));
        event.setAttrData(map);
    }
}

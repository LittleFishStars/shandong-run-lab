package com.alibaba.ariver.apt;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.jsapi.AppRunTimeInfoBridgeExtension;
import com.alibaba.ariver.jsapi.DatePickerBridgeExtension;
import com.alibaba.ariver.jsapi.EmbedViewBridgeExtension;
import com.alibaba.ariver.jsapi.EmbedWebViewBridgeExtension;
import com.alibaba.ariver.jsapi.GetClientInfoBridgeExtension;
import com.alibaba.ariver.jsapi.LoadingBridgeExtension;
import com.alibaba.ariver.jsapi.NotificationBridgeExtension;
import com.alibaba.ariver.jsapi.StartParamsBridgeExtension;
import com.alibaba.ariver.jsapi.actionsheet.ActionSheetBridgeExtension;
import com.alibaba.ariver.jsapi.app.AppBridgeExtension;
import com.alibaba.ariver.jsapi.app.TabBarBridgeExtension;
import com.alibaba.ariver.jsapi.app.TitleBarBridgeExtension;
import com.alibaba.ariver.jsapi.app.WindowBridgeExtension;
import com.alibaba.ariver.jsapi.city.ChooseCityBridgeExtension;
import com.alibaba.ariver.jsapi.dialog.DialogBridgeExtension;
import com.alibaba.ariver.jsapi.engine.EngineBridgeExtension;
import com.alibaba.ariver.jsapi.engine.InputBridgeExtension;
import com.alibaba.ariver.jsapi.engine.OrientationBridgeExtension;
import com.alibaba.ariver.jsapi.internalapi.InternalApiBridgeExtension;
import com.alibaba.ariver.jsapi.location.ChooseLocationBridgeExtension;
import com.alibaba.ariver.jsapi.logging.AppPerformanceBridgeExtension;
import com.alibaba.ariver.jsapi.logging.HandleLoggingActionBridgeExtension;
import com.alibaba.ariver.jsapi.mtop.MtopBridgeExtention;
import com.alibaba.ariver.jsapi.multimedia.audio.AudioRecordBridgeExtension;
import com.alibaba.ariver.jsapi.multimedia.audio.BackGroundAudioBridgeExtension;
import com.alibaba.ariver.jsapi.multimedia.audio.ForeGroundAudioBridgeExtension;
import com.alibaba.ariver.jsapi.multimedia.image.ChooseImageBridgeExtension;
import com.alibaba.ariver.jsapi.multimedia.image.CompressImageBridgeExtension;
import com.alibaba.ariver.jsapi.multimedia.image.ImageInfoBridgeExtension;
import com.alibaba.ariver.jsapi.multimedia.image.PreviewImageBridgeExtension;
import com.alibaba.ariver.jsapi.multimedia.image.SaveImageToAlbumBridgeExtension;
import com.alibaba.ariver.jsapi.multimedia.video.SaveVideoToAlbumBridgeExtension;
import com.alibaba.ariver.jsapi.multimedia.video.VideoSelectBridgeExtension;
import com.alibaba.ariver.jsapi.network.NetworkBridgeExtension;
import com.alibaba.ariver.jsapi.resource.ResourceJsApiBridgeExtension;
import com.alibaba.ariver.jsapi.resource.SnapshotBridgeExtension;
import com.alibaba.ariver.jsapi.rpc.RpcBridgeExtension;
import com.alibaba.ariver.jsapi.rpc.TinyAppxRpcBridgeExtension;
import com.alibaba.ariver.jsapi.rpc.TinyRpcBridgeExtension;
import com.alibaba.ariver.jsapi.security.OpenAuthExtension;
import com.alibaba.ariver.jsapi.security.PermissionConfigExtension;
import com.alibaba.ariver.jsapi.security.ProgramSettingExtension;
import com.alibaba.ariver.jsapi.security.TBAuthorizeBridge;
import com.alibaba.ariver.jsapi.security.TBAuthorizeOpenSettingExtension;
import com.alibaba.ariver.jsapi.toast.ToastBridgeExtension;
import com.alibaba.ariver.jsapi.websocket.WebSocketBridgeExtension;
import com.alibaba.ariver.jsapi.worker.WorkerBridgeExtension;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionOpt;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class d {
    public static void a() {
    }

    public static void b() {
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(ToastBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.1
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("toast".equals(str) && objArr.length == 7) {
                    ((ToastBridgeExtension) extension).toast((String) objArr[0], ((Integer) objArr[1]).intValue(), (String) objArr[2], ((Integer) objArr[3]).intValue(), ((Integer) objArr[4]).intValue(), (Page) objArr[5], (BridgeCallback) objArr[6]);
                }
                if ("hideToast".equals(str) && objArr.length == 1) {
                    return ((ToastBridgeExtension) extension).hideToast((Page) objArr[0]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(EmbedViewBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.12
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("sendMessage".equals(str) && objArr.length == 6) {
                    ((EmbedViewBridgeExtension) extension).sendMessage((String) objArr[0], (String) objArr[1], (JSONObject) objArr[2], (String) objArr[3], (BridgeCallback) objArr[4], (Page) objArr[5]);
                }
                if ("render".equals(str) && objArr.length == 6) {
                    ((EmbedViewBridgeExtension) extension).render((String) objArr[0], (JSONObject) objArr[1], (JSONObject) objArr[2], (String) objArr[3], (BridgeCallback) objArr[4], (Page) objArr[5]);
                }
                if ("remove".equals(str) && objArr.length == 4) {
                    return ((EmbedViewBridgeExtension) extension).remove((String) objArr[0], (String) objArr[1], (BridgeCallback) objArr[2], (Page) objArr[3]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(AppBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.23
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("getSceneStackInfo".equals(str) && objArr.length == 2) {
                    return ((AppBridgeExtension) extension).getSceneStackInfo((App) objArr[0], (Page) objArr[1]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(TabBarBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.34
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("setTabBar".equals(str) && objArr.length == 5) {
                    return ((TabBarBridgeExtension) extension).setTabBar((String) objArr[0], (String) objArr[1], (Integer) objArr[2], (JSONObject) objArr[3], (App) objArr[4]);
                }
                if ("addTabBarItem".equals(str) && objArr.length == 6) {
                    return ((TabBarBridgeExtension) extension).addTabBarItem((String) objArr[0], (String) objArr[1], (String) objArr[2], (String) objArr[3], ((Integer) objArr[4]).intValue(), (Page) objArr[5]);
                }
                if ("removeTabBarItem".equals(str) && objArr.length == 2) {
                    return ((TabBarBridgeExtension) extension).removeTabBarItem(((Integer) objArr[0]).intValue(), (Page) objArr[1]);
                }
                if ("switchTab".equals(str) && objArr.length == 3) {
                    return ((TabBarBridgeExtension) extension).switchTab((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), (Page) objArr[2]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(WindowBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.43
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("getRunScene".equals(str) && objArr.length == 1) {
                    return ((WindowBridgeExtension) extension).getRunScene((App) objArr[0]);
                }
                if ("pushWindow".equals(str) && objArr.length == 6) {
                    return ((WindowBridgeExtension) extension).pushWindow((String) objArr[0], (JSONObject) objArr[1], (Page) objArr[2], (App) objArr[3], (Executor) objArr[4], (BridgeCallback) objArr[5]);
                }
                if ("popTo".equals(str) && objArr.length == 5) {
                    return ((WindowBridgeExtension) extension).popTo((App) objArr[0], (String) objArr[1], (String) objArr[2], (JSONObject) objArr[3], ((Integer) objArr[4]).intValue());
                }
                if (!"popWindow".equals(str) || objArr.length != 2) {
                    return null;
                }
                ((WindowBridgeExtension) extension).popWindow((App) objArr[0], (JSONObject) objArr[1]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(TitleBarBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.44
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("getTitleAndStatusbarHeight".equals(str) && objArr.length == 1) {
                    return ((TitleBarBridgeExtension) extension).getTitleAndStatusbarHeight((App) objArr[0]);
                }
                if (com.alipay.sdk.m.c0.d.p.equals(str) && objArr.length == 6) {
                    return ((TitleBarBridgeExtension) extension).setTitle((String) objArr[0], (String) objArr[1], (String) objArr[2], (String) objArr[3], ((Boolean) objArr[4]).booleanValue(), (Page) objArr[5]);
                }
                if ("setTitleColor".equals(str) && objArr.length == 4) {
                    return ((TitleBarBridgeExtension) extension).setTitleColor(((Integer) objArr[0]).intValue(), ((Boolean) objArr[1]).booleanValue(), ((Boolean) objArr[2]).booleanValue(), (Page) objArr[3]);
                }
                if ("setBarBottomLineColor".equals(str) && objArr.length == 2) {
                    return ((TitleBarBridgeExtension) extension).setBarBottomLineColor(((Integer) objArr[0]).intValue(), (Page) objArr[1]);
                }
                if ("setTransparentTitle".equals(str) && objArr.length == 2) {
                    return ((TitleBarBridgeExtension) extension).setTransparentTitle((String) objArr[0], (Page) objArr[1]);
                }
                if ("getTitleColor".equals(str) && objArr.length == 1) {
                    return ((TitleBarBridgeExtension) extension).getTitleColor((Page) objArr[0]);
                }
                if (RVParams.LONG_SHOW_TITLE_LOADING.equals(str) && objArr.length == 1) {
                    return ((TitleBarBridgeExtension) extension).showTitleLoading((Page) objArr[0]);
                }
                if ("hideTitleLoading".equals(str) && objArr.length == 1) {
                    return ((TitleBarBridgeExtension) extension).hideTitleLoading((Page) objArr[0]);
                }
                if (RVParams.LONG_SHOW_OPTION_MENU.equals(str) && objArr.length == 1) {
                    return ((TitleBarBridgeExtension) extension).showOptionMenu((Page) objArr[0]);
                }
                if ("hideOptionMenu".equals(str) && objArr.length == 1) {
                    return ((TitleBarBridgeExtension) extension).hideOptionMenu((Page) objArr[0]);
                }
                if (com.alipay.sdk.m.c0.d.r.equals(str) && objArr.length == 1) {
                    return ((TitleBarBridgeExtension) extension).showBackButton((Page) objArr[0]);
                }
                if ("hideBackButton".equals(str) && objArr.length == 1) {
                    return ((TitleBarBridgeExtension) extension).hideBackButton((Page) objArr[0]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(DatePickerBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.45
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"datePicker".equals(str) || objArr.length != 7) {
                    return null;
                }
                ((DatePickerBridgeExtension) extension).datePicker((ApiContext) objArr[0], ((Integer) objArr[1]).intValue(), (String) objArr[2], (String) objArr[3], (String) objArr[4], ((Boolean) objArr[5]).booleanValue(), (BridgeCallback) objArr[6]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(EmbedWebViewBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.46
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("getEmbedWebViewEnv".equals(str) && objArr.length == 1) {
                    return ((EmbedWebViewBridgeExtension) extension).getEmbedWebViewEnv((Page) objArr[0]);
                }
                if ("postWebViewMessage".equals(str) && objArr.length == 2) {
                    return ((EmbedWebViewBridgeExtension) extension).postWebViewMessage((Page) objArr[0], (JSONObject) objArr[1]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(TinyRpcBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.47
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"tinyRpc".equals(str) || objArr.length != 7) {
                    return null;
                }
                ((TinyRpcBridgeExtension) extension).tinyRpc((String) objArr[0], (JSONObject) objArr[1], (JSONObject) objArr[2], (App) objArr[3], (Page) objArr[4], (ApiContext) objArr[5], (BridgeCallback) objArr[6]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(TinyAppxRpcBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.2
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"appxrpc".equals(str) || objArr.length != 7) {
                    return null;
                }
                ((TinyAppxRpcBridgeExtension) extension).appxrpc((String) objArr[0], (JSONObject) objArr[1], (JSONObject) objArr[2], (App) objArr[3], (Page) objArr[4], (BridgeCallback) objArr[5], (ApiContext) objArr[6]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(RpcBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.3
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"rpc".equals(str) || objArr.length != 15) {
                    return null;
                }
                ((RpcBridgeExtension) extension).rpc((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Boolean) objArr[2]).booleanValue(), (String) objArr[3], (JSONObject) objArr[4], (String) objArr[5], (JSONObject) objArr[6], ((Boolean) objArr[7]).booleanValue(), ((Boolean) objArr[8]).booleanValue(), ((Integer) objArr[9]).intValue(), ((Boolean) objArr[10]).booleanValue(), (String) objArr[11], (App) objArr[12], (Page) objArr[13], (BridgeCallback) objArr[14]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(MtopBridgeExtention.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.4
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"sendMtop".equals(str) || objArr.length != 19) {
                    return null;
                }
                ((MtopBridgeExtention) extension).sendMtop((String) objArr[0], (String) objArr[1], (Boolean) objArr[2], (String) objArr[3], (String) objArr[4], (String) objArr[5], ((Integer) objArr[6]).intValue(), (JSONObject) objArr[7], (JSONObject) objArr[8], (JSONObject) objArr[9], ((Integer) objArr[10]).intValue(), (String) objArr[11], (String) objArr[12], (String) objArr[13], (String) objArr[14], (String) objArr[15], (App) objArr[16], (ApiContext) objArr[17], (BridgeCallback) objArr[18]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(AppRunTimeInfoBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.5
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("getLocaleInfo".equals(str) && objArr.length == 2) {
                    return ((AppRunTimeInfoBridgeExtension) extension).getLocaleInfo((App) objArr[0], (Page) objArr[1]);
                }
                if ("getLayoutDirection".equals(str) && objArr.length == 2) {
                    return ((AppRunTimeInfoBridgeExtension) extension).getLayoutDirection((App) objArr[0], (Page) objArr[1]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(LoadingBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.6
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (RVParams.LONG_SHOW_LOADING.equals(str) && objArr.length == 5) {
                    return ((LoadingBridgeExtension) extension).showLoading((App) objArr[0], (Page) objArr[1], (String) objArr[2], ((Integer) objArr[3]).intValue(), ((Boolean) objArr[4]).booleanValue());
                }
                if ("hideLoading".equals(str) && objArr.length == 2) {
                    return ((LoadingBridgeExtension) extension).hideLoading((App) objArr[0], (Page) objArr[1]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(EngineBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.7
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("measureText".equals(str) && objArr.length == 3) {
                    return ((EngineBridgeExtension) extension).measureText(((Float) objArr[0]).floatValue(), (String) objArr[1], (String) objArr[2]);
                }
                if ("checkJSAPI".equals(str) && objArr.length == 2) {
                    return ((EngineBridgeExtension) extension).checkJSAPI((Page) objArr[0], (String) objArr[1]);
                }
                if ("h5PageReload".equals(str) && objArr.length == 1) {
                    return ((EngineBridgeExtension) extension).h5PageReload((ApiContext) objArr[0]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(OrientationBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.8
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("getScreenOrientation".equals(str) && objArr.length == 1) {
                    return ((OrientationBridgeExtension) extension).getScreenOrientation((Page) objArr[0]);
                }
                if ("setScreenOrientation".equals(str) && objArr.length == 3) {
                    return ((OrientationBridgeExtension) extension).setScreenOrientation((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), (Page) objArr[2]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(InputBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.9
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("toggleSoftInput".equals(str) && objArr.length == 1) {
                    return ((InputBridgeExtension) extension).toggleSoftInput((ApiContext) objArr[0]);
                }
                if ("showSoftInput".equals(str) && objArr.length == 3) {
                    return ((InputBridgeExtension) extension).showSoftInput(((Boolean) objArr[0]).booleanValue(), (String) objArr[1], (ApiContext) objArr[2]);
                }
                if ("inputFocus4Android".equals(str) && objArr.length == 3) {
                    return ((InputBridgeExtension) extension).inputFocus4Android((ApiContext) objArr[0], (String) objArr[1], (String) objArr[2]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(ActionSheetBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.10
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"actionSheet".equals(str) || objArr.length != 7) {
                    return null;
                }
                ((ActionSheetBridgeExtension) extension).actionSheet((ApiContext) objArr[0], (Page) objArr[1], (String) objArr[2], (String) objArr[3], (JSONArray) objArr[4], (JSONArray) objArr[5], (BridgeCallback) objArr[6]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(NotificationBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.11
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("addNotifyListener".equals(str) && objArr.length == 4) {
                    ((NotificationBridgeExtension) extension).addNotifyListener((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), (ApiContext) objArr[2], (BridgeCallback) objArr[3]);
                }
                if ("removeNotifyListener".equals(str) && objArr.length == 1) {
                    return ((NotificationBridgeExtension) extension).removeNotifyListener((String) objArr[0]);
                }
                if ("postNotification".equals(str) && objArr.length == 3) {
                    return ((NotificationBridgeExtension) extension).postNotification((String) objArr[0], (JSONObject) objArr[1], (Page) objArr[2]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(GetClientInfoBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.13
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("getClientInfo".equals(str) && objArr.length == 0) {
                    return ((GetClientInfoBridgeExtension) extension).getClientInfo();
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(AppPerformanceBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.14
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("onAppPerfEvent".equals(str) && objArr.length == 5) {
                    return ((AppPerformanceBridgeExtension) extension).onAppPerfEvent((Page) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue(), ((Long) objArr[3]).longValue(), (Map) objArr[4]);
                }
                if ("onCubeAppPerfEvent".equals(str) && objArr.length == 5) {
                    return ((AppPerformanceBridgeExtension) extension).onCubeAppPerfEvent((Page) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue(), ((Long) objArr[3]).longValue(), (Map) objArr[4]);
                }
                if ("onBizPerfEvent".equals(str) && objArr.length == 3) {
                    return ((AppPerformanceBridgeExtension) extension).onBizPerfEvent((Page) objArr[0], (JSONObject) objArr[1], (ApiContext) objArr[2]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(HandleLoggingActionBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.15
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"handleLoggingAction".equals(str) || objArr.length != 3) {
                    return null;
                }
                ((HandleLoggingActionBridgeExtension) extension).handleLoggingAction((JSONObject) objArr[0], (Page) objArr[1], (BridgeCallback) objArr[2]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(DialogBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.16
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("agreementConfirm".equals(str) && objArr.length == 10) {
                    ((DialogBridgeExtension) extension).agreementConfirm((App) objArr[0], (String) objArr[1], (String) objArr[2], (String) objArr[3], (String) objArr[4], (String) objArr[5], (String) objArr[6], (String) objArr[7], (JSONArray) objArr[8], (BridgeCallback) objArr[9]);
                }
                if ("alert".equals(str) && objArr.length == 8) {
                    ((DialogBridgeExtension) extension).alert((Page) objArr[0], (String) objArr[1], (String) objArr[2], (String) objArr[3], (String) objArr[4], (String) objArr[5], (String) objArr[6], (BridgeCallback) objArr[7]);
                }
                if ("confirm".equals(str) && objArr.length == 9) {
                    ((DialogBridgeExtension) extension).confirm((Page) objArr[0], (String) objArr[1], (String) objArr[2], (String) objArr[3], (String) objArr[4], (String) objArr[5], (String) objArr[6], (String) objArr[7], (BridgeCallback) objArr[8]);
                }
                if (!"prompt".equals(str) || objArr.length != 9) {
                    return null;
                }
                ((DialogBridgeExtension) extension).prompt((Page) objArr[0], (String) objArr[1], (String) objArr[2], (String) objArr[3], (String) objArr[4], (String) objArr[5], (String) objArr[6], (String) objArr[7], (BridgeCallback) objArr[8]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(InternalApiBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.17
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"internalAPI".equals(str) || objArr.length != 5) {
                    return null;
                }
                ((InternalApiBridgeExtension) extension).internalAPI((JSONObject) objArr[0], (BridgeCallback) objArr[1], (Page) objArr[2], (ApiContext) objArr[3], (String) objArr[4]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(ChooseCityBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.18
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("getCities".equals(str) && objArr.length == 9) {
                    ((ChooseCityBridgeExtension) extension).getCities((ApiContext) objArr[0], (App) objArr[1], (Page) objArr[2], ((Boolean) objArr[3]).booleanValue(), ((Boolean) objArr[4]).booleanValue(), (JSONArray) objArr[5], (JSONArray) objArr[6], (JSONObject) objArr[7], (BridgeCallback) objArr[8]);
                }
                if (!"getCustomCities".equals(str) || objArr.length != 9) {
                    return null;
                }
                ((ChooseCityBridgeExtension) extension).getCustomCities((ApiContext) objArr[0], (App) objArr[1], (Page) objArr[2], ((Boolean) objArr[3]).booleanValue(), ((Boolean) objArr[4]).booleanValue(), (JSONArray) objArr[5], (JSONArray) objArr[6], (JSONObject) objArr[7], (BridgeCallback) objArr[8]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(ChooseLocationBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.19
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"beehiveGetPOI".equals(str) || objArr.length != 5) {
                    return null;
                }
                ((ChooseLocationBridgeExtension) extension).beehiveGetPOI((ApiContext) objArr[0], (App) objArr[1], (Page) objArr[2], (JSONObject) objArr[3], (BridgeCallback) objArr[4]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(WebSocketBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.20
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("connectSocket".equals(str) && objArr.length == 11) {
                    ((WebSocketBridgeExtension) extension).connectSocket((App) objArr[0], (Page) objArr[1], (String) objArr[2], (JSONObject) objArr[3], (String) objArr[4], ((Boolean) objArr[5]).booleanValue(), (JSONArray) objArr[6], (JSONObject) objArr[7], ((Boolean) objArr[8]).booleanValue(), (JSONObject) objArr[9], (BridgeCallback) objArr[10]);
                }
                if ("sendSocketMessage".equals(str) && objArr.length == 6) {
                    return ((WebSocketBridgeExtension) extension).sendSocketMessage((App) objArr[0], (Page) objArr[1], (String) objArr[2], (String) objArr[3], ((Boolean) objArr[4]).booleanValue(), ((Boolean) objArr[5]).booleanValue());
                }
                if ("closeSocket".equals(str) && objArr.length == 4) {
                    return ((WebSocketBridgeExtension) extension).closeSocket((App) objArr[0], (Page) objArr[1], (String) objArr[2], ((Boolean) objArr[3]).booleanValue());
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(StartParamsBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.21
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("setStartParam".equals(str) && objArr.length == 2) {
                    return ((StartParamsBridgeExtension) extension).setStartParam((String) objArr[0], (Page) objArr[1]);
                }
                if ("getStartupParams".equals(str) && objArr.length == 3) {
                    return ((StartParamsBridgeExtension) extension).getStartupParams((Page) objArr[0], (App) objArr[1], (String[]) objArr[2]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(ResourceJsApiBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.22
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("addPkgRes".equals(str) && objArr.length == 2) {
                    return ((ResourceJsApiBridgeExtension) extension).addPkgRes((App) objArr[0], (String) objArr[1]);
                }
                if ("checkApp".equals(str) && objArr.length == 2) {
                    return ((ResourceJsApiBridgeExtension) extension).checkApp((String) objArr[0], (String) objArr[1]);
                }
                if (!"installApp".equals(str) || objArr.length != 2) {
                    return null;
                }
                ((ResourceJsApiBridgeExtension) extension).installApp((String) objArr[0], (BridgeCallback) objArr[1]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(SnapshotBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.24
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("saveSnapshot".equals(str) && objArr.length == 3) {
                    return ((SnapshotBridgeExtension) extension).saveSnapshot((App) objArr[0], (String) objArr[1], (String) objArr[2]);
                }
                if ("deleteSnapshot".equals(str) && objArr.length == 2) {
                    return ((SnapshotBridgeExtension) extension).deleteSnapshot((App) objArr[0], (String) objArr[1]);
                }
                if ("getSnapshotConfig".equals(str) && objArr.length == 2) {
                    return ((SnapshotBridgeExtension) extension).getSnapshotConfig((App) objArr[0], (BridgeCallback) objArr[1]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(TBAuthorizeOpenSettingExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.25
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"openSetting".equals(str) || objArr.length != 5) {
                    return null;
                }
                ((TBAuthorizeOpenSettingExtension) extension).openSetting((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), (App) objArr[2], (ApiContext) objArr[3], (BridgeCallback) objArr[4]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(OpenAuthExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.26
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("getAuthorize".equals(str) && objArr.length == 10) {
                    ((OpenAuthExtension) extension).getAuthorize((String) objArr[0], (JSONArray) objArr[1], (JSONObject) objArr[2], (String) objArr[3], (String) objArr[4], ((Boolean) objArr[5]).booleanValue(), (App) objArr[6], (Page) objArr[7], (BridgeCallback) objArr[8], (ApiContext) objArr[9]);
                }
                if ("getAuthCode".equals(str) && objArr.length == 13) {
                    ((OpenAuthExtension) extension).getAuthCode((String) objArr[0], (JSONArray) objArr[1], (JSONObject) objArr[2], (String) objArr[3], (String) objArr[4], ((Boolean) objArr[5]).booleanValue(), (String) objArr[6], (String) objArr[7], (App) objArr[8], (Page) objArr[9], (BridgeCallback) objArr[10], (JSONObject) objArr[11], (ApiContext) objArr[12]);
                }
                if ("getAuthUserInfo".equals(str) && objArr.length == 7) {
                    ((OpenAuthExtension) extension).getAuthUserInfo((JSONArray) objArr[0], (JSONObject) objArr[1], ((Boolean) objArr[2]).booleanValue(), (App) objArr[3], (String) objArr[4], (ApiContext) objArr[5], (BridgeCallback) objArr[6]);
                }
                if ("getBusinessAuth".equals(str) && objArr.length == 10) {
                    ((OpenAuthExtension) extension).getBusinessAuth((String) objArr[0], (JSONArray) objArr[1], (JSONObject) objArr[2], (String) objArr[3], (String) objArr[4], ((Boolean) objArr[5]).booleanValue(), (App) objArr[6], (Page) objArr[7], (BridgeCallback) objArr[8], (ApiContext) objArr[9]);
                }
                if ("getComponentAuth".equals(str) && objArr.length == 10) {
                    ((OpenAuthExtension) extension).getComponentAuth((String) objArr[0], (JSONArray) objArr[1], (JSONObject) objArr[2], (String) objArr[3], (String) objArr[4], ((Boolean) objArr[5]).booleanValue(), (App) objArr[6], (Page) objArr[7], (BridgeCallback) objArr[8], (ApiContext) objArr[9]);
                }
                if (!"showAuthGuide".equals(str) || objArr.length != 7) {
                    return null;
                }
                ((OpenAuthExtension) extension).showAuthGuide((String) objArr[0], (String) objArr[1], (String) objArr[2], (String) objArr[3], (String) objArr[4], (App) objArr[5], (BridgeCallback) objArr[6]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(TBAuthorizeBridge.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.27
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("authorize".equals(str) && objArr.length == 8) {
                    ((TBAuthorizeBridge) extension).authorize((String) objArr[0], (String) objArr[1], (String) objArr[2], (String) objArr[3], (App) objArr[4], (Page) objArr[5], (ApiContext) objArr[6], (BridgeCallback) objArr[7]);
                }
                if ("getTBCode".equals(str) && objArr.length == 3) {
                    ((TBAuthorizeBridge) extension).getTBCode((App) objArr[0], (ApiContext) objArr[1], (BridgeCallback) objArr[2]);
                }
                if ("openSetting".equals(str) && objArr.length == 5) {
                    ((TBAuthorizeBridge) extension).openSetting((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), (App) objArr[2], (ApiContext) objArr[3], (BridgeCallback) objArr[4]);
                }
                if ("setTBSessionInfo".equals(str) && objArr.length == 3) {
                    return ((TBAuthorizeBridge) extension).setTBSessionInfo((String) objArr[0], (String) objArr[1], (App) objArr[2]);
                }
                if ("getTBSessionInfo".equals(str) && objArr.length == 2) {
                    return ((TBAuthorizeBridge) extension).getTBSessionInfo((String) objArr[0], (App) objArr[1]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(PermissionConfigExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.28
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("getPermissionConfig".equals(str) && objArr.length == 2) {
                    return ((PermissionConfigExtension) extension).getPermissionConfig((App) objArr[0], (ApiContext) objArr[1]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(ProgramSettingExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.29
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"getSetting".equals(str) || objArr.length != 5) {
                    return null;
                }
                ((ProgramSettingExtension) extension).getSetting((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), (App) objArr[2], (ApiContext) objArr[3], (BridgeCallback) objArr[4]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(WorkerBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.30
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("registerWorker".equals(str) && objArr.length == 4) {
                    ((WorkerBridgeExtension) extension).registerWorker((Page) objArr[0], (ApiContext) objArr[1], (BridgeCallback) objArr[2], (String) objArr[3]);
                }
                if (com.alibaba.triver.embed.webview.b.f24908a.equals(str) && objArr.length == 3) {
                    return ((WorkerBridgeExtension) extension).postMessage((Page) objArr[0], (JSONObject) objArr[1], (String) objArr[2]);
                }
                if ("loadPlugin".equals(str) && objArr.length == 3) {
                    return ((WorkerBridgeExtension) extension).loadPlugin((String) objArr[0], (App) objArr[1], (ApiContext) objArr[2]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(AudioRecordBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.31
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("startMonitorBackgroundAudio".equals(str) && objArr.length == 12) {
                    ((AudioRecordBridgeExtension) extension).startMonitorBackgroundAudio(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue(), (String) objArr[3], ((Integer) objArr[4]).intValue(), ((Integer) objArr[5]).intValue(), ((Integer) objArr[6]).intValue(), ((Integer) objArr[7]).intValue(), (String) objArr[8], (String) objArr[9], (org.json.JSONObject) objArr[10], (BridgeCallback) objArr[11]);
                }
                if ("stopAudioRecord".equals(str) && objArr.length == 2) {
                    ((AudioRecordBridgeExtension) extension).stopAudioRecord((org.json.JSONObject) objArr[0], (BridgeCallback) objArr[1]);
                }
                if ("pauseAudioRecord".equals(str) && objArr.length == 2) {
                    ((AudioRecordBridgeExtension) extension).pauseAudioRecord((org.json.JSONObject) objArr[0], (BridgeCallback) objArr[1]);
                }
                if ("resumeAudioRecord".equals(str) && objArr.length == 2) {
                    ((AudioRecordBridgeExtension) extension).resumeAudioRecord((org.json.JSONObject) objArr[0], (BridgeCallback) objArr[1]);
                }
                if (!"getAvailableAudioSources".equals(str) || objArr.length != 2) {
                    return null;
                }
                ((AudioRecordBridgeExtension) extension).getAvailableAudioSources((org.json.JSONObject) objArr[0], (BridgeCallback) objArr[1]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(ForeGroundAudioBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.32
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("startMonitorForegroundAudio".equals(str) && objArr.length == 3) {
                    return ((ForeGroundAudioBridgeExtension) extension).startMonitorForegroundAudio((String) objArr[0], (org.json.JSONObject) objArr[1], (BridgeCallback) objArr[2]);
                }
                if ("stopMonitorForegroundAudio".equals(str) && objArr.length == 3) {
                    return ((ForeGroundAudioBridgeExtension) extension).stopMonitorForegroundAudio((String) objArr[0], (org.json.JSONObject) objArr[1], (BridgeCallback) objArr[2]);
                }
                if ("getForegroundAudioOption".equals(str) && objArr.length == 4) {
                    return ((ForeGroundAudioBridgeExtension) extension).getForegroundAudioOption((String) objArr[0], (String) objArr[1], (org.json.JSONObject) objArr[2], (BridgeCallback) objArr[3]);
                }
                if ("setForegroundAudioOption".equals(str) && objArr.length == 4) {
                    return ((ForeGroundAudioBridgeExtension) extension).setForegroundAudioOption((String) objArr[0], (String) objArr[1], (org.json.JSONObject) objArr[2], (BridgeCallback) objArr[3]);
                }
                if ("playForegroundAudio".equals(str) && objArr.length == 3) {
                    return ((ForeGroundAudioBridgeExtension) extension).playForegroundAudio((String) objArr[0], (org.json.JSONObject) objArr[1], (BridgeCallback) objArr[2]);
                }
                if ("pauseForegroundAudio".equals(str) && objArr.length == 3) {
                    return ((ForeGroundAudioBridgeExtension) extension).pauseForegroundAudio((String) objArr[0], (org.json.JSONObject) objArr[1], (BridgeCallback) objArr[2]);
                }
                if ("stopForegroundAudio".equals(str) && objArr.length == 3) {
                    return ((ForeGroundAudioBridgeExtension) extension).stopForegroundAudio((String) objArr[0], (org.json.JSONObject) objArr[1], (BridgeCallback) objArr[2]);
                }
                if ("seekForegroundAudio".equals(str) && objArr.length == 4) {
                    return ((ForeGroundAudioBridgeExtension) extension).seekForegroundAudio((String) objArr[0], ((Integer) objArr[1]).intValue(), (org.json.JSONObject) objArr[2], (BridgeCallback) objArr[3]);
                }
                if ("destroyForegroundAudio".equals(str) && objArr.length == 3) {
                    return ((ForeGroundAudioBridgeExtension) extension).destroyForegroundAudio((String) objArr[0], (org.json.JSONObject) objArr[1], (BridgeCallback) objArr[2]);
                }
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(BackGroundAudioBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.33
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("startMonitorBackgroundAudio".equals(str) && objArr.length == 1) {
                    ((BackGroundAudioBridgeExtension) extension).startMonitorBackgroundAudio((BridgeCallback) objArr[0]);
                }
                if ("stopMonitorBackgroundAudio".equals(str) && objArr.length == 1) {
                    ((BackGroundAudioBridgeExtension) extension).stopMonitorBackgroundAudio((BridgeCallback) objArr[0]);
                }
                if ("getBackgroundAudioOption".equals(str) && objArr.length == 3) {
                    ((BackGroundAudioBridgeExtension) extension).getBackgroundAudioOption((String) objArr[0], (org.json.JSONObject) objArr[1], (BridgeCallback) objArr[2]);
                }
                if ("setBackgroundAudioOption".equals(str) && objArr.length == 3) {
                    ((BackGroundAudioBridgeExtension) extension).setBackgroundAudioOption((String) objArr[0], (org.json.JSONObject) objArr[1], (BridgeCallback) objArr[2]);
                }
                if ("playBackgroundAudio".equals(str) && objArr.length == 14) {
                    ((BackGroundAudioBridgeExtension) extension).playBackgroundAudio((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), (String) objArr[2], (String) objArr[3], (String) objArr[4], (String) objArr[5], (String) objArr[6], (String) objArr[7], (String) objArr[8], (String) objArr[9], ((Boolean) objArr[10]).booleanValue(), ((Boolean) objArr[11]).booleanValue(), (org.json.JSONObject) objArr[12], (BridgeCallback) objArr[13]);
                }
                if ("pauseBackgroundAudio".equals(str) && objArr.length == 2) {
                    ((BackGroundAudioBridgeExtension) extension).pauseBackgroundAudio((org.json.JSONObject) objArr[0], (BridgeCallback) objArr[1]);
                }
                if ("stopBackgroundAudio".equals(str) && objArr.length == 2) {
                    ((BackGroundAudioBridgeExtension) extension).stopBackgroundAudio((org.json.JSONObject) objArr[0], (BridgeCallback) objArr[1]);
                }
                if ("seekBackgroundAudio".equals(str) && objArr.length == 3) {
                    ((BackGroundAudioBridgeExtension) extension).seekBackgroundAudio(((Integer) objArr[0]).intValue(), (org.json.JSONObject) objArr[1], (BridgeCallback) objArr[2]);
                }
                if ("getBackgroundAudioPlayerState".equals(str) && objArr.length == 2) {
                    ((BackGroundAudioBridgeExtension) extension).getBackgroundAudioPlayerState((org.json.JSONObject) objArr[0], (BridgeCallback) objArr[1]);
                }
                if (!"getAudioPlayStateRecord".equals(str) || objArr.length != 3) {
                    return null;
                }
                ((BackGroundAudioBridgeExtension) extension).getAudioPlayStateRecord((String) objArr[0], (org.json.JSONObject) objArr[1], (BridgeCallback) objArr[2]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(ImageInfoBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.35
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"getImageInfo".equals(str) || objArr.length != 3) {
                    return null;
                }
                ((ImageInfoBridgeExtension) extension).getImageInfo((String) objArr[0], (org.json.JSONObject) objArr[1], (BridgeCallback) objArr[2]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(CompressImageBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.36
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"compressImage".equals(str) || objArr.length != 10) {
                    return null;
                }
                ((CompressImageBridgeExtension) extension).compressImage((String[]) objArr[0], ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue(), ((Integer) objArr[4]).intValue(), (String) objArr[5], (String) objArr[6], (String) objArr[7], (org.json.JSONObject) objArr[8], (BridgeCallback) objArr[9]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(ChooseImageBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.37
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"chooseImage".equals(str) || objArr.length != 5) {
                    return null;
                }
                ((ChooseImageBridgeExtension) extension).chooseImage((String[]) objArr[0], (String[]) objArr[1], ((Integer) objArr[2]).intValue(), (org.json.JSONObject) objArr[3], (BridgeCallback) objArr[4]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(SaveImageToAlbumBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.38
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"saveImageToPhotosAlbum".equals(str) || objArr.length != 3) {
                    return null;
                }
                ((SaveImageToAlbumBridgeExtension) extension).saveImageToPhotosAlbum((String) objArr[0], (org.json.JSONObject) objArr[1], (BridgeCallback) objArr[2]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(PreviewImageBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.39
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("imageViewer".equals(str) && objArr.length == 4) {
                    ((PreviewImageBridgeExtension) extension).imageViewer((String[]) objArr[0], ((Integer) objArr[1]).intValue(), (org.json.JSONObject) objArr[2], (BridgeCallback) objArr[3]);
                }
                if (!"mediaBrowser".equals(str) || objArr.length != 4) {
                    return null;
                }
                ((PreviewImageBridgeExtension) extension).mediaBrowser((String[]) objArr[0], ((Integer) objArr[1]).intValue(), (org.json.JSONObject) objArr[2], (BridgeCallback) objArr[3]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(VideoSelectBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.40
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"chooseVideo".equals(str) || objArr.length != 8) {
                    return null;
                }
                ((VideoSelectBridgeExtension) extension).chooseVideo((String[]) objArr[0], (String[]) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Boolean) objArr[3]).booleanValue(), ((Integer) objArr[4]).intValue(), ((Boolean) objArr[5]).booleanValue(), (org.json.JSONObject) objArr[6], (BridgeCallback) objArr[7]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(SaveVideoToAlbumBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.41
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if (!"saveVideoToPhotosAlbum".equals(str) || objArr.length != 3) {
                    return null;
                }
                ((SaveVideoToAlbumBridgeExtension) extension).saveVideoToPhotosAlbum((String) objArr[0], (org.json.JSONObject) objArr[1], (BridgeCallback) objArr[2]);
                return null;
            }
        });
        ExtensionOpt.setupMethodInvokeOptimizerForBridge(NetworkBridgeExtension.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.apt.d.42
            @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
            public Object doMethodInvoke(String str, Extension extension, Object[] objArr) {
                if ("getNetworkType".equals(str) && objArr.length == 1) {
                    return ((NetworkBridgeExtension) extension).getNetworkType((ApiContext) objArr[0]);
                }
                return null;
            }
        });
    }

    public static void c() {
    }
}

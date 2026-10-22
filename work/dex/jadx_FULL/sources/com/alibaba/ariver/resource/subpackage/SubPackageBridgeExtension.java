package com.alibaba.ariver.resource.subpackage;

import android.os.SystemClock;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.resources.Resource;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.network.NetworkUtil;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.LangResourceUtil;
import com.alibaba.ariver.kernel.common.utils.PatternUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.R;
import com.alibaba.ariver.resource.api.ResourceContext;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.ariver.resource.parser.PackageParseUtils;
import com.alibaba.ariver.resource.parser.ParseContext;
import com.alibaba.ariver.resource.parser.ParseFailedException;
import com.alibaba.ariver.resource.runtime.ResourceContextManager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SubPackageBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24468a = "AriverRes:SubPackageBridgeExtension";
    private static final String b = "wifi";
    private Set<String> c = new HashSet();
    private final Map<String, Future<BridgeResponse>> d = new ConcurrentHashMap();

    private synchronized void a(final App app, final AppModel appModel, List<String> list, final BridgeCallback bridgeCallback, final boolean z) {
        if (list != null) {
            if (!list.isEmpty()) {
                JSONObject subPackages = appModel.getAppInfoModel().getSubPackages();
                for (int i = 0; i < list.size(); i++) {
                    final String str = list.get(i);
                    final String string = subPackages.getString(str);
                    final Future<BridgeResponse> future = this.d.get(string);
                    if (future != null) {
                        RVLogger.d(f24468a, "prepareSubPackage reuse task " + string);
                        ExecutorUtils.runNotOnMain(ExecutorType.IO, new Runnable() { // from class: com.alibaba.ariver.resource.subpackage.SubPackageBridgeExtension.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    BridgeResponse bridgeResponse = (BridgeResponse) future.get();
                                    RVLogger.d(SubPackageBridgeExtension.f24468a, "prepareSubPackage " + string + " got first task result " + bridgeResponse + " needSend " + z);
                                    if (z) {
                                        bridgeCallback.sendBridgeResponse(bridgeResponse);
                                    }
                                } catch (Throwable th) {
                                    RVLogger.e(SubPackageBridgeExtension.f24468a, "await first task error!", th);
                                }
                            }
                        });
                        return;
                    }
                    final a aVar = new a();
                    this.d.put(string, aVar);
                    RVLogger.d(f24468a, "prepareSubPackage begin task for " + string);
                    new com.alibaba.ariver.resource.subpackage.a(app, appModel, str, new com.alibaba.ariver.resource.subpackage.a.InterfaceC0153a() { // from class: com.alibaba.ariver.resource.subpackage.SubPackageBridgeExtension.2
                        @Override // com.alibaba.ariver.resource.subpackage.a.InterfaceC0153a
                        public void a(String str2) {
                            BridgeResponse error;
                            BridgeCallback bridgeCallback2;
                            try {
                                SubPackageBridgeExtension.this.a(appModel, str2);
                                error = BridgeResponse.SUCCESS;
                                SubPackageBridgeExtension.this.c.add(str);
                            } catch (Throwable th) {
                                if (th instanceof ParseFailedException) {
                                    ParseFailedException parseFailedException = th;
                                    ParseContext parseContext = new ParseContext();
                                    parseContext.appId = app.getAppId();
                                    parseContext.packagePath = str2;
                                    parseFailedException.setParseContext(parseContext);
                                    SubPackageBridgeExtension.this.onVerifyError(parseFailedException);
                                }
                                RVLogger.e(SubPackageBridgeExtension.f24468a, "prepareSubPackage error ", th);
                                error = new BridgeResponse.Error(16, LangResourceUtil.getString(R.string.ariver_resource_parse_error) + str);
                            }
                            aVar.a(error);
                            if (z && (bridgeCallback2 = bridgeCallback) != null) {
                                bridgeCallback2.sendBridgeResponse(error);
                            }
                            SubPackageBridgeExtension.this.d.remove(string);
                        }

                        @Override // com.alibaba.ariver.resource.subpackage.a.InterfaceC0153a
                        public void b(String str2) {
                            BridgeCallback bridgeCallback2;
                            BridgeResponse.Error error = new BridgeResponse.Error(14, LangResourceUtil.getString(R.string.ariver_resource_download_error) + str);
                            if (z && (bridgeCallback2 = bridgeCallback) != null) {
                                bridgeCallback2.sendBridgeResponse(error);
                            }
                            aVar.a(error);
                            SubPackageBridgeExtension.this.d.remove(string);
                        }
                    }).a();
                }
                if (!z) {
                    bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                }
                return;
            }
        }
        RVLogger.w(f24468a, "loadSubPackage...no valid root need load: " + app.getAppId());
        bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(13, "无有效的分包"));
    }

    /* JADX WARN: Code duplicated, block: B:38:0x012c  */
    /* JADX WARN: Code duplicated, block: B:50:0x0130 A[SYNTHETIC] */
    @ThreadType(ExecutorType.URGENT_DISPLAY)
    @ActionFilter
    public void loadSubPackage(@BindingNode(App.class) App app, @BindingParam({"preload"}) String str, @BindingParam(required = true, value = {"packages"}) JSONArray jSONArray, @BindingCallback BridgeCallback bridgeCallback) {
        AppModel appModel = (AppModel) app.getData(AppModel.class);
        if (appModel == null) {
            RVLogger.w(f24468a, "loadSubPackage...non appModel");
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, "非分包模式_1"));
            return;
        }
        if (appModel.getAppInfoModel() == null) {
            RVLogger.w(f24468a, "loadSubPackage...non getAppInfoModel" + appModel);
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, "非分包模式_2"));
            return;
        }
        if (appModel.getAppInfoModel().getSubPackages() == null) {
            RVLogger.w(f24468a, "loadSubPackage...non getSubPackages" + appModel);
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, "非分包模式_3"));
            return;
        }
        if ("wifi".equals(str) && !TextUtils.equals(NetworkUtil.NETWORK_TYPE_WIFI, NetworkUtil.getDetailNetworkType(app.getAppContext().getContext()))) {
            RVLogger.w(f24468a, "loadSubPackage...networkType is dismatch:" + str);
            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, LangResourceUtil.getString(R.string.ariver_resource_network_is_dismatch)));
            return;
        }
        ArrayList arrayList = new ArrayList();
        JSONObject subPackages = appModel.getAppInfoModel().getSubPackages();
        boolean z = true;
        for (int i = 0; i < jSONArray.size(); i++) {
            String string = jSONArray.getString(i);
            if (!TextUtils.isEmpty(string)) {
                if (TextUtils.isEmpty(subPackages.getString(string))) {
                    string = string.endsWith(WVNativeCallbackUtil.SEPERATER) ? string.substring(0, string.length() - 1) : string + WVNativeCallbackUtil.SEPERATER;
                    if (!TextUtils.isEmpty(subPackages.getString(string))) {
                        RVLogger.d(f24468a, "loadSubPackage, root path non-match, adapted here, rootAttrib: " + string + " correct rootPath: " + string);
                        if (!this.c.contains(string)) {
                            arrayList.add(string);
                            z = false;
                        }
                    }
                } else if (!this.c.contains(string)) {
                    arrayList.add(string);
                    z = false;
                }
            }
        }
        if (!z) {
            a(app, appModel, arrayList, bridgeCallback, jSONArray.size() == 1);
        } else {
            bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
            RVLogger.d(f24468a, "loadSubPackage... all packages has loaded.");
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    public void onVerifyError(ParseFailedException parseFailedException) {
        ParseContext parseContext = parseFailedException.getParseContext();
        if (parseContext != null) {
            RVLogger.w(f24468a, "onVerifyError, delete sub packagePath: " + parseContext.packagePath);
            FileUtils.delete(parseContext.packagePath);
        }
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    public class a implements Future<BridgeResponse> {
        private CountDownLatch b;
        private BridgeResponse c;

        private a() {
            this.b = new CountDownLatch(1);
            this.c = null;
        }

        public synchronized void a(BridgeResponse bridgeResponse) {
            RVLogger.d(SubPackageBridgeExtension.f24468a, "ResultDispatchFuture set result " + bridgeResponse);
            this.c = bridgeResponse;
            this.b.countDown();
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            return false;
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return false;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.b.getCount() == 0;
        }

        @Override // java.util.concurrent.Future
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BridgeResponse get() throws InterruptedException {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.b.await(30L, TimeUnit.SECONDS);
            RVLogger.d(SubPackageBridgeExtension.f24468a, "ResultDispatchFuture wait task dispatch for " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
            return this.c;
        }

        @Override // java.util.concurrent.Future
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public BridgeResponse get(long j, @NonNull TimeUnit timeUnit) throws InterruptedException {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.b.await(j, timeUnit);
            RVLogger.d(SubPackageBridgeExtension.f24468a, "ResultDispatchFuture wait task dispatch for " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
            return this.c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppModel appModel, String str) {
        if (!TextUtils.isEmpty(appModel.getAppId()) && !TextUtils.isEmpty(str)) {
            ParseContext parseContext = new ParseContext();
            parseContext.appId = appModel.getAppId();
            parseContext.onlineHost = appModel.getAppInfoModel().getVhost();
            parseContext.packagePath = str;
            parseContext.ignorePatterns = Collections.singletonList(PatternUtils.compile(RVConstants.FILE_API_PERMISSION));
            Map<String, Resource> map = PackageParseUtils.parsePackage(parseContext);
            ResourceContext resourceContext = ResourceContextManager.getInstance().get(appModel.getAppId());
            if (resourceContext == null || resourceContext.getMainPackage() == null) {
                return;
            }
            for (Resource resource : map.values()) {
                RVLogger.d(f24468a, "add subPackage resource: " + resource);
                resourceContext.getMainPackage().add(resource);
            }
            return;
        }
        RVLogger.w(f24468a, "parseIntoResourceContext callback...appId downloadUrl is null");
    }
}

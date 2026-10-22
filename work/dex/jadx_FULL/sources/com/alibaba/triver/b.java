package com.alibaba.triver;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.ariver.app.api.monitor.RVMonitor;
import com.alibaba.ariver.app.view.EmbedViewHelper;
import com.alibaba.ariver.integration.RVInitializer;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.resource.api.prepare.PrepareCallback;
import com.alibaba.ariver.resource.api.prepare.PrepareCallbackParam;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareController;
import com.alibaba.triver.impl.InitializerPrinter;
import com.alibaba.triver.kit.api.appmonitor.TriverLaunchPointer;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.proxy.ITriverAppMonitorProxy;
import com.alibaba.triver.kit.api.utils.TRiverUtils;
import com.alibaba.triver.point.TriverLifecyclePoint;
import com.alibaba.triver.resource.d;
import com.alibaba.triver.utils.CommonUtils;
import com.aliyun.vod.log.core.AliyunLogCommon;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class b extends EmbedViewHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected long f24672a;
    private Activity b;

    public b(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.b = fragmentActivity;
        RVInitializer.setPrinter(new InitializerPrinter());
        RVInitializer.init(fragmentActivity.getApplicationContext());
    }

    public boolean a(Uri uri, Bundle bundle) {
        ((TriverLifecyclePoint) ExtensionPoint.as(TriverLifecyclePoint.class).create()).onCreate();
        this.f24672a = SystemClock.elapsedRealtime();
        if (uri == null) {
            return false;
        }
        String appId = TRiverUtils.getAppId(uri);
        if (TextUtils.isEmpty(appId)) {
            ((RVMonitor) RVProxy.get(RVMonitor.class)).errorLog("WXAriverComponent", "appid is empty", "WXAriverComponent", appId, "", null);
            return false;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString(TRiverConstants.KEY_ORI_URL, uri.toString());
        bundle2.putString(RVStartParams.KEY_ENABLE_POLYFILL_WORKER, "true");
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        if (CommonUtils.isApkDebug(this.b)) {
            bundle2.putString(AliyunLogCommon.LogLevel.DEBUG, "framework");
        }
        for (String str : uri.getQueryParameterNames()) {
            if (!TextUtils.isEmpty(str)) {
                String queryParameter = uri.getQueryParameter(str);
                if (!TextUtils.isEmpty(queryParameter)) {
                    bundle2.putString(str, queryParameter.trim());
                }
            }
        }
        ((ITriverAppMonitorProxy) RVProxy.get(ITriverAppMonitorProxy.class)).commitTriverLaunch(TriverLaunchPointer.build().setAppId(appId).setStage("appStart").setStatus(Double.valueOf(1.0d)).setStartParams(bundle2).create());
        Bundle bundle3 = new Bundle();
        bundle2.remove(TRiverConstants.KEY_LOCAL_DEBUG);
        bundle3.putLong(RVConstants.EXTRA_JUMP_APP_START_TIMESTAMP, bundle.getLong(RVConstants.EXTRA_JUMP_APP_START_TIMESTAMP, 0L));
        renderView(appId, bundle2, bundle3);
        return true;
    }

    @Override // com.alibaba.ariver.app.view.EmbedViewHelper
    public PrepareController createPrepareController(PrepareContext prepareContext, PrepareCallback prepareCallback) {
        return new d(prepareContext, prepareCallback);
    }

    @Override // com.alibaba.ariver.app.view.EmbedViewHelper
    public void renderView(String str, Bundle bundle, @Nullable Bundle bundle2) {
        super.renderView(str, bundle, bundle2);
    }

    @Override // com.alibaba.ariver.app.view.EmbedViewHelper, com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void startApp(PrepareCallbackParam prepareCallbackParam) {
        super.startApp(prepareCallbackParam);
    }
}

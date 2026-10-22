package com.zj.adlib;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.alibcprotocol.base.AlibcUrlCheck;
import com.alibaba.alibcprotocol.callback.AlibcComponentReRenderCallback;
import com.alibaba.alibcprotocol.callback.CpsCommitCallback;
import com.alibaba.alibcprotocol.container.AlibcContainerManager;
import com.alibaba.alibcprotocol.param.AlibcBizParams;
import com.alibaba.alibcprotocol.route.RouteRequest;
import com.alibaba.alibcprotocol.route.proxy.IAlibcAdProxy;
import com.alibaba.alibcprotocol.route.proxy.impl.AlibcProxy;
import com.alibaba.ariver.kernel.api.monitor.PerfId;
import com.alibaba.baichuan.trade.common.executor.ExecutorManager;
import com.alibaba.baichuan.trade.common.executor.ExecutorType;
import com.alibaba.baichuan.trade.common.ut.AlibcUserTracker;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.fastjson.JSONObject;
import com.baichuan.nb_trade.AlibcDefaultActivity;
import com.baichuan.nb_trade.distribute.d;
import com.baichuan.nb_trade.utils.AlibcBizUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class rga extends com.baichuan.nb_trade.distribute.b {
    public static final String b = "rga";
    public static String c = "";

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RouteRequest f44451a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ d f19308a;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public a(RouteRequest routeRequest, String str, String str2, d dVar) {
            this.f44451a = routeRequest;
            this.f = str;
            this.g = str2;
            this.f19308a = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            rga.e(rga.this, this.f44451a, this.f, this.g, this.f19308a);
        }
    }

    public class b implements CpsCommitCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f44452a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ RouteRequest f19310a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ d f19311a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f19313a;
        public final /* synthetic */ String b;

        public b(long j, d dVar, String str, RouteRequest routeRequest, String str2) {
            this.f44452a = j;
            this.f19311a = dVar;
            this.f19313a = str;
            this.f19310a = routeRequest;
            this.b = str2;
        }

        @Override // com.alibaba.alibcprotocol.callback.CpsCommitCallback
        public final void onFail(String str, String str2) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f44452a;
            AlibcLogger.e(rga.b, "union convert fail: code = " + str + ", msg = " + str2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(UserTrackConstant.ORIGINAL_URL, (Object) this.f19313a);
            jSONObject.put(UserTrackConstant.RECOVERY_ID, (Object) rga.c);
            jSONObject.put("costTime", (Object) String.valueOf(jCurrentTimeMillis));
            AlibcUserTracker.getInstance().trackAlarm(false, UserTrackConstant.E_CONVERT_UNION, str, str2, jSONObject);
            this.f19311a.a(-1, "[AppInnerHandler]" + str2);
            AlibcContainerManager.loadUrl(this.f19310a, this.b, this.f19313a, rga.c);
        }

        @Override // com.alibaba.alibcprotocol.callback.CpsCommitCallback
        public final void onSuccess(Map<String, String> map) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f44452a;
            String str = map.get("url");
            String str2 = map.get("status");
            AlibcLogger.i(rga.b, "convert success: url = " + str + ", status = " + str2);
            this.f19311a.a(4000, "");
            if (TextUtils.isEmpty(str)) {
                boolean z = "3".equals(str2) && AlibcUrlCheck.regularCheck(AlibcProtocolConstant.TUNION_URL_PATTERNS, this.f19313a);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("status", (Object) str2);
                jSONObject.put(UserTrackConstant.ORIGINAL_URL, (Object) this.f19313a);
                jSONObject.put(UserTrackConstant.RECOVERY_ID, (Object) rga.c);
                jSONObject.put("costTime", (Object) String.valueOf(jCurrentTimeMillis));
                AlibcUserTracker.getInstance().trackAlarm(z, UserTrackConstant.E_CONVERT_UNION, "code_empty", "empty url", jSONObject);
                AlibcContainerManager.loadUrl(this.f19310a, this.b, this.f19313a, rga.c);
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("status", (Object) str2);
            jSONObject2.put(UserTrackConstant.ORIGINAL_URL, (Object) this.f19313a);
            jSONObject2.put(UserTrackConstant.RECOVERY_ID, (Object) rga.c);
            jSONObject2.put(UserTrackConstant.RESULT_URL, (Object) str);
            jSONObject2.put("costTime", (Object) String.valueOf(jCurrentTimeMillis));
            AlibcUserTracker.getInstance().trackAlarm(true, UserTrackConstant.E_CONVERT_UNION, "", "", jSONObject2);
            AlibcContainerManager.loadUrl(this.f19310a, this.b, str, rga.c);
        }
    }

    public static Map<String, String> d(AlibcTradeContext alibcTradeContext, String str) {
        HashMap map = new HashMap(16);
        AlibcBizParams alibcBizParams = alibcTradeContext.bizParams;
        if (alibcBizParams != null) {
            Map<String, String> extParams = alibcBizParams.getExtParams();
            if (extParams != null) {
                if (!TextUtils.isEmpty(str)) {
                    extParams.put(AlibcProtocolConstant.RECOVER_ID, str);
                }
                for (Map.Entry<String, String> entry : extParams.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                        map.put(key, value);
                    }
                }
            }
        } else {
            alibcTradeContext.bizParams = new AlibcBizParams();
            HashMap map2 = new HashMap();
            map2.put(AlibcProtocolConstant.RECOVER_ID, str);
            alibcTradeContext.bizParams.setExtParams(map2);
        }
        return map;
    }

    public static /* synthetic */ void e(rga rgaVar, RouteRequest routeRequest, String str, String str2, d dVar) {
        ((IAlibcAdProxy) AlibcProxy.get(IAlibcAdProxy.class)).executeConvert(routeRequest, str, c, rgaVar.new b(System.currentTimeMillis(), dVar, str, routeRequest, str2));
    }

    @Override // com.baichuan.nb_trade.distribute.b
    public final boolean a(RouteRequest routeRequest, AlibcTradeContext alibcTradeContext) {
        AlibcLogger.i(b, "appInner handler execute shouldHandle");
        return true;
    }

    @Override // com.baichuan.nb_trade.distribute.b
    public final void a(RouteRequest routeRequest, AlibcTradeContext alibcTradeContext, d dVar, AlibcComponentReRenderCallback alibcComponentReRenderCallback) {
        Map<String, String> extParams;
        String str = b;
        AlibcLogger.i(str, "appInner handler execute handle");
        String pageType = routeRequest.getPageType();
        String bizType = routeRequest.getBizType();
        String rawUrl = routeRequest.getRawUrl();
        if (!routeRequest.isLaunchApp()) {
            dVar.a(4000, "");
            if (TextUtils.isEmpty(rawUrl)) {
                return;
            }
            AlibcTradeContext.getInstance().context = null;
            WeakReference<Activity> weakReference = alibcTradeContext.mActivity;
            Activity activity = weakReference != null ? weakReference.get() : null;
            if (activity == null) {
                WeakReference<Activity> weakReference2 = alibcTradeContext.mRawActivity;
                activity = weakReference2 != null ? weakReference2.get() : null;
            }
            if (activity != null) {
                AlibcLogger.i(str, "load webview page");
                Intent intent = new Intent(activity, (Class<?>) AlibcDefaultActivity.class);
                intent.putExtra(PerfId.loadUrl, rawUrl);
                Map<String, Object> extParams2 = routeRequest.getExtParams();
                if (extParams2 != null) {
                    String strValueOf = String.valueOf(extParams2.get("disableNav"));
                    if (!TextUtils.isEmpty(strValueOf)) {
                        intent.putExtra("disableNav", strValueOf);
                    }
                }
                activity.startActivity(intent);
                return;
            }
            return;
        }
        boolean zEquals = "miniapp".equals(pageType);
        String strGenerateRecoverId = zEquals ? AlibcBizUtils.generateRecoverId() : "";
        c = strGenerateRecoverId;
        Map<String, String> mapD = d(alibcTradeContext, strGenerateRecoverId);
        AlibcBizParams alibcBizParams = alibcTradeContext.bizParams;
        String str2 = (alibcBizParams == null || (extParams = alibcBizParams.getExtParams()) == null) ? "" : extParams.get("link_type");
        try {
            String strA = com.baichuan.nb_trade.distribute.b.a(zEquals, rawUrl, bizType, mapD);
            Map<String, Object> extParams3 = routeRequest.getExtParams();
            long jCurrentTimeMillis = extParams3 != null ? System.currentTimeMillis() - ((Long) extParams3.get("startTime")).longValue() : 0L;
            if (!zEquals) {
                if (!"detail".equals(bizType) && !"shop".equals(bizType)) {
                    AlibcContainerManager.loadUrl(routeRequest, pageType, strA, c);
                    return;
                }
                ExecutorManager.getTaskExecutor(ExecutorType.NORMAL).execute(new a(routeRequest, strA, pageType, dVar));
                return;
            }
            if (TextUtils.isEmpty(str2) || !"triver_card".equals(str2)) {
                dVar.a(4000, "");
                AlibcContainerManager.loadUrl(routeRequest, pageType, strA, c);
            } else {
                AlibcContainerManager.loadUrl(pageType, strA, alibcComponentReRenderCallback);
            }
            AlibcLogger.i(str, "cost of load miniapp url: " + jCurrentTimeMillis + "ms");
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put(UserTrackConstant.RECOVERY_ID, (Object) c);
            jSONObject2.put("costTime", (Object) Long.valueOf(jCurrentTimeMillis));
            AlibcUserTracker.getInstance().trackStat(UserTrackConstant.E_URL_LOAD_COST, jSONObject, jSONObject2);
        } catch (Exception e) {
            AlibcLogger.e(b, "found exception: " + e.getMessage());
            dVar.a(-100, "[AppInnerHandler]url is invalid");
        }
    }
}

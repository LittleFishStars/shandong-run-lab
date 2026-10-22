package com.baichuan.nb_trade.core;

import android.app.Application;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.alibcprotocol.route.proxy.IAlibcToolProxy;
import com.alibaba.alibcprotocol.route.proxy.impl.AlibcProxy;
import com.alibaba.baichuan.trade.common.AlibcTradeCommon;
import com.alibaba.baichuan.trade.common.executor.ExecutorManager;
import com.alibaba.baichuan.trade.common.executor.ExecutorType;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.fastjson.JSONObject;
import com.baichuan.nb_trade.callback.AlibcTradeInitCallback;
import com.baichuan.nb_trade.model.InitResult;
import com.baichuan.nb_trade.utils.AlibcBizUtils;
import com.zj.adlib.tga;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AlibcTradeSDK extends tga {
    public static final String b = "AlibcTradeSDK";

    public enum InitStrategy {
        INIT,
        BEFORE_CALL_API
    }

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f26228a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Application f1221a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AlibcTradeInitCallback f1222a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Map f1223a;

        public a(Application application, Map map, long j, AlibcTradeInitCallback alibcTradeInitCallback) {
            this.f1221a = application;
            this.f1223a = map;
            this.f26228a = j;
            this.f1222a = alibcTradeInitCallback;
        }

        @Override // java.lang.Runnable
        public final void run() {
            JSONObject jSONObject = new JSONObject();
            AlibcTradeBaseBiz.AlibcTradeBizResult alibcTradeBizResultInit = AlibcTradeBiz.init(this.f1221a, this.f1223a, jSONObject);
            jSONObject.put("costTime", (Object) String.valueOf(System.currentTimeMillis() - this.f26228a));
            if (alibcTradeBizResultInit.isSuccess) {
                tga.b(this.f1222a, jSONObject);
                return;
            }
            InitResult initResultNewFailureResult = InitResult.newFailureResult(alibcTradeBizResultInit.errCode, alibcTradeBizResultInit.errMsg);
            tga.f44916a = initResultNewFailureResult;
            tga.c(this.f1222a, initResultNewFailureResult, jSONObject);
        }
    }

    public static synchronized void checkIsInit(Application application, AlibcTradeInitCallback alibcTradeInitCallback) {
        if (AlibcTradeCommon.sApplication == null) {
            AlibcLogger.e("AlibcTradeSDK", "未调用init方法初始化");
        } else if (tga.f19810a.isInitialized()) {
            alibcTradeInitCallback.onSuccess();
        } else {
            e(application, AlibcTradeCommon.sExtParams, alibcTradeInitCallback);
        }
    }

    public static synchronized void e(Application application, Map<String, Object> map, AlibcTradeInitCallback alibcTradeInitCallback) {
        try {
            if (!application.getPackageName().equals(AlibcBizUtils.getProcessName(application))) {
                alibcTradeInitCallback.onFailure(1500, AlibcProtocolConstant.SDK_NOT_INITIALIZED_MSG);
            } else if (tga.a(alibcTradeInitCallback)) {
                tga.f19810a.setState(1);
                long jCurrentTimeMillis = System.currentTimeMillis();
                ((IAlibcToolProxy) AlibcProxy.get(IAlibcToolProxy.class)).startTraceLogcat(application);
                ExecutorManager.getTaskExecutor(ExecutorType.NORMAL).execute(new a(application, map, jCurrentTimeMillis, alibcTradeInitCallback));
            }
        } catch (Exception e) {
            alibcTradeInitCallback.onFailure(1700, AlibcProtocolConstant.SDK_INITIAL_EXCEPTION_MSG);
            AlibcLogger.e(b, "init exception: " + e.getMessage());
        }
    }

    public static synchronized void init(Application application, Map<String, Object> map, AlibcTradeInitCallback alibcTradeInitCallback, InitStrategy initStrategy) {
        AlibcTradeCommon.sApplication = application;
        AlibcTradeCommon.sExtParams = map;
        if (initStrategy == InitStrategy.INIT) {
            e(application, map, alibcTradeInitCallback);
        }
    }
}

package com.alibaba.triver.resource;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppException;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.network.CommonResponse;
import com.alibaba.triver.kit.api.orange.TROrangeController;
import com.alibaba.triver.request.limit.AppOpenLimitClient;
import com.amap.api.maps.model.MyLocationStyle;
import com.kc.aw.lib.constants.AdConstant;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CountDownLatch f25157a = null;
    private JSONObject b;

    public static PrepareException b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String string = jSONObject.getString("errorCode");
        String string2 = jSONObject.getString("errorMsg");
        String string3 = jSONObject.getString(MyLocationStyle.ERROR_INFO);
        String string4 = jSONObject.getString("errorSubInfo");
        HashMap map = new HashMap();
        map.put(MyLocationStyle.ERROR_INFO, string3);
        map.put("errorSubInfo", string4);
        UpdateAppException updateAppException = new UpdateAppException(string, string2, map);
        return new PrepareException(updateAppException.getCode(), updateAppException.getMessage(), updateAppException);
    }

    public void a(final String str) {
        ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.URGENT).execute(new Runnable() { // from class: com.alibaba.triver.resource.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.f25157a = new CountDownLatch(1);
                CommonResponse<JSONObject, JSONObject> commonResponseExecute = new AppOpenLimitClient().execute(new AppOpenLimitClient.AppOpenLimitParam(str, null));
                b.this.b = commonResponseExecute.successData;
                b.this.f25157a.countDown();
            }
        });
    }

    @WorkerThread
    public synchronized JSONObject a() {
        if (TROrangeController.closeAppLimit()) {
            return null;
        }
        CountDownLatch countDownLatch = this.f25157a;
        if (countDownLatch == null) {
            return null;
        }
        try {
            countDownLatch.await(TROrangeController.getAppLimitWaitMillis(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            RVLogger.e("AppLimitChecker", "getResultSync await error", e);
        }
        return this.b;
    }

    public static boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return TextUtils.equals(jSONObject.getString("errorCode"), AdConstant.NATIVE_TYPE.LEFT_TEXT);
    }
}

package com.alibaba.alibctriver.container;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.alibcprotocol.callback.AlibcComponentReRenderCallback;
import com.alibaba.alibcprotocol.container.AlibcBaseContainer;
import com.alibaba.alibcprotocol.container.callback.AlibcContainerCallback;
import com.alibaba.alibcprotocol.jsbridge.callback.AlibcPluginCallback;
import com.alibaba.alibcprotocol.route.RouteRequest;
import com.alibaba.alibctriver.AlibcTRiver;
import com.alibaba.baichuan.trade.common.ut.AlibcUserTracker;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.alibaba.fastjson.JSONObject;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcTRiverContainer implements AlibcBaseContainer {
    private static final String CONTAINER_TAG = "miniapp";
    private static final String TAG = "AlibcTRiverContainer";
    private AlibcTradeContext context;

    @Override // com.alibaba.alibcprotocol.container.AlibcBaseContainer
    public void closeContainer() {
    }

    @Override // com.alibaba.alibcprotocol.container.AlibcBaseContainer
    public String getContainerTag() {
        return "miniapp";
    }

    @Override // com.alibaba.alibcprotocol.container.AlibcBaseContainer
    public void goBack(boolean z) {
    }

    @Override // com.alibaba.alibcprotocol.container.AlibcBaseContainer
    public void initContainer(AlibcTradeContext alibcTradeContext, AlibcPluginCallback alibcPluginCallback, AlibcContainerCallback alibcContainerCallback) {
        this.context = alibcTradeContext;
        try {
            Map<String, Object> map = alibcTradeContext.extParams;
            if (map != null) {
                Object obj = map.get("initTriver");
                if ((obj instanceof Boolean) && !((Boolean) obj).booleanValue()) {
                    return;
                }
            }
        } catch (Throwable th) {
            AlibcLogger.e(TAG, "parse init triver param exception: " + th.getMessage());
        }
        AlibcTRiver.a aVarB = AlibcTRiver.a().b();
        if (1 != aVarB.d) {
            alibcContainerCallback.onInitSuccess();
            return;
        }
        alibcContainerCallback.onInitFail(7, "小程序SDK初始化失败");
        HashMap map2 = new HashMap();
        map2.put("errorCode", String.valueOf(aVarB.e));
        map2.put("errorMsg", aVarB.f);
        AlibcLogger.saveLog("baichuan", "TRIVER_INIT_FAIL", "TRIVER_SDK_INIT", "triver init fail", map2, "error");
    }

    @Override // com.alibaba.alibcprotocol.container.AlibcBaseContainer
    public void reload() {
    }

    @Override // com.alibaba.alibcprotocol.container.AlibcBaseContainer
    public void runTask(RouteRequest routeRequest, String str, String str2) {
        String str3 = TAG;
        AlibcLogger.i(str3, "the target load url: " + str);
        AlibcTradeContext alibcTradeContext = this.context;
        if (alibcTradeContext != null) {
            if (alibcTradeContext.context != null) {
                AlibcLogger.i(str3, "context: load triver page");
                AlibcTRiver.a().a(this.context.context, str, str2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(UserTrackConstant.URL_TYPE, (Object) getContainerTag());
                jSONObject.put(UserTrackConstant.ORIGINAL_URL, (Object) str);
                jSONObject.put(UserTrackConstant.CONTAINER_TYPE, (Object) "miniapp");
                AlibcUserTracker.getInstance().trackCounter(UserTrackConstant.E_CONTAINER_LOAD, 1, jSONObject);
                return;
            }
            WeakReference<Activity> weakReference = alibcTradeContext.mActivity;
            Activity activity = weakReference != null ? weakReference.get() : null;
            if (activity == null) {
                WeakReference<Activity> weakReference2 = this.context.mRawActivity;
                activity = weakReference2 != null ? weakReference2.get() : null;
            }
            if (activity != null) {
                AlibcLogger.i(str3, "activity: load triver page");
                AlibcTRiver.a().a(activity, str, str2);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(UserTrackConstant.URL_TYPE, (Object) getContainerTag());
                jSONObject2.put(UserTrackConstant.ORIGINAL_URL, (Object) str);
                jSONObject2.put(UserTrackConstant.CONTAINER_TYPE, (Object) "miniapp");
                AlibcUserTracker.getInstance().trackCounter(UserTrackConstant.E_CONTAINER_LOAD, 1, jSONObject2);
            }
        }
    }

    @Override // com.alibaba.alibcprotocol.container.AlibcBaseContainer
    public void runTask(String str, String str2) {
    }

    @Override // com.alibaba.alibcprotocol.container.AlibcBaseContainer
    public void runTask(String str, String str2, Context context) {
    }

    @Override // com.alibaba.alibcprotocol.container.AlibcBaseContainer
    public void runTask(String str, AlibcComponentReRenderCallback alibcComponentReRenderCallback) {
        if (alibcComponentReRenderCallback != null) {
            Context context = AlibcTradeContext.getInstance().context;
            if (context instanceof FragmentActivity) {
                AlibcTRiver.a().a((FragmentActivity) context, Uri.parse(str), alibcComponentReRenderCallback);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(UserTrackConstant.URL_TYPE, (Object) getContainerTag());
                jSONObject.put(UserTrackConstant.ORIGINAL_URL, (Object) str);
                jSONObject.put(UserTrackConstant.CONTAINER_TYPE, (Object) "miniapp");
                AlibcUserTracker.getInstance().trackCounter(UserTrackConstant.E_CONTAINER_LOAD, 1, jSONObject);
            }
        }
    }
}

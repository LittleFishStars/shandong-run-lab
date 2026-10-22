package com.alibaba.triver.app;

import android.text.TextUtils;
import com.alibaba.ariver.app.AppUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.model.GoBackCallback;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.proxy.IConfigProxy;
import com.alibaba.triver.utils.CommonUtils;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24615a = "AriverEngine:ClosePerform";
    private App d;
    private AppModel e;
    private Boolean c = null;
    private a b = new a();

    public class a implements SendToRenderCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f24617a = false;
        public long b = 0;
        public GoBackCallback c;

        public a() {
        }

        public void a(GoBackCallback goBackCallback) {
            this.c = goBackCallback;
        }

        @Override // com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback
        public void onCallBack(JSONObject jSONObject) {
            this.f24617a = false;
            if (!CommonUtils.unableCloseWindowEventIntercept()) {
                boolean z = JSONUtils.getBoolean(jSONObject, "prevent", false) || JSONUtils.getBoolean(jSONObject, RVConstants.EXTRA_PREVENTED, false);
                if (b.this.c == null) {
                    b bVar = b.this;
                    bVar.c = Boolean.valueOf(bVar.a());
                }
                RVLogger.d(b.f24615a, "closeWindow event prevent " + z + " with cfgOpen: " + b.this.c);
                if (z && b.this.c.booleanValue()) {
                    return;
                }
            }
            ((RVExecutorService) RVProxy.get(RVExecutorService.class)).getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.app.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    b.this.b(aVar.c);
                }
            });
        }
    }

    public b(App app) {
        this.d = app;
        if (app != null) {
            this.e = (AppModel) app.getData(AppModel.class);
        }
    }

    public abstract void b(GoBackCallback goBackCallback);

    private void b() {
        AppUtils.sendToApp(this.d, "closeWindow", null, new SendToRenderCallback() { // from class: com.alibaba.triver.app.b.1
            @Override // com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback
            public void onCallBack(JSONObject jSONObject) {
                if (b.this.b != null) {
                    b.this.b.onCallBack(jSONObject);
                }
            }
        });
    }

    public boolean a() {
        JSONArray array;
        if (this.d == null) {
            return false;
        }
        try {
            Map<String, String> configsByGroup = ((IConfigProxy) RVProxy.get(IConfigProxy.class)).getConfigsByGroup(TRiverConstants.GROUP_TRIVER_WHITE_LIST_CONFIG);
            if (configsByGroup != null) {
                String str = configsByGroup.get("closeWindowAccessList");
                if (!TextUtils.isEmpty(str) && (array = JSON.parseArray(str)) != null) {
                    return array.contains(this.d.getAppId());
                }
            }
            return false;
        } catch (Exception e) {
            RVLogger.e("Triver:CloseWindowPerform", "enableInterceptBack() getAccessList error", e);
            return false;
        }
    }

    public void a(GoBackCallback goBackCallback) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        a aVar = this.b;
        if (!(((aVar.f24617a ^ true) && (((jCurrentTimeMillis - aVar.b) > 500L ? 1 : ((jCurrentTimeMillis - aVar.b) == 500L ? 0 : -1)) > 0)) ? false : true)) {
            RVLogger.d(f24615a, "send closeWindow event to bridge!");
            a aVar2 = this.b;
            aVar2.f24617a = true;
            aVar2.b = jCurrentTimeMillis;
            aVar2.a(goBackCallback);
            b();
            return;
        }
        RVLogger.d(f24615a, "ignore bridge, perform exit!");
        b(goBackCallback);
    }
}

package com.alibaba.ariver.engine.api.common;

import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.model.ExitCallback;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.kernel.RVEvents;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class CommonExitPerform {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24056a = "AriverEngine:CommonExitPerform";
    private CollectJsApiHandler b;
    private Render c;

    public class CollectJsApiHandler implements SendToRenderCallback {
        public ExitCallback exitCallback;
        public boolean waiting = false;

        public CollectJsApiHandler() {
        }

        @Override // com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback
        public void onCallBack(JSONObject jSONObject) {
            this.waiting = false;
            RVLogger.d(CommonExitPerform.this.f24056a, "collectJsApi param : " + jSONObject);
            JSONArray jSONArray = JSONUtils.getJSONArray(jSONObject, "syncJsApis", null);
            if (jSONArray != null && !jSONArray.isEmpty()) {
                for (int i = 0; i < jSONArray.size(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        CommonExitPerform.this.handleCollectedApi(JSONUtils.getString(jSONObject2, "apiName"), JSONUtils.getJSONObject(jSONObject2, "params", null));
                    }
                }
            }
            if (CommonExitPerform.this.needCheckDslError()) {
                CommonExitPerform.this.checkDslErrorAndExit(this.exitCallback);
            } else {
                this.exitCallback.afterProcess(false);
            }
        }
    }

    public CommonExitPerform(Render render) {
        this.c = render;
    }

    private void a(final ExitCallback exitCallback) {
        if (this.b == null && this.c != null) {
            CollectJsApiHandler collectJsApiHandler = new CollectJsApiHandler();
            this.b = collectJsApiHandler;
            collectJsApiHandler.waiting = true;
            collectJsApiHandler.exitCallback = exitCallback;
            EngineUtils.sendToRender(this.c, RVEvents.COLLECT_DESTROY_API, null, collectJsApiHandler);
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.ariver.engine.api.common.CommonExitPerform.1
                @Override // java.lang.Runnable
                public void run() {
                    if (CommonExitPerform.this.b == null || !CommonExitPerform.this.b.waiting) {
                        return;
                    }
                    RVLogger.d(CommonExitPerform.this.f24056a, "collectJsApiHandler overtime, do exit");
                    exitCallback.afterProcess(false);
                }
            }, 1000L);
        }
    }

    public abstract void checkDslErrorAndExit(ExitCallback exitCallback);

    public abstract void handleCollectedApi(String str, JSONObject jSONObject);

    public abstract boolean needCheckDslError();

    public abstract boolean needCollectDestroyJsApi();

    public void runExit(ExitCallback exitCallback) {
        if (needCollectDestroyJsApi()) {
            a(exitCallback);
        } else if (needCheckDslError()) {
            checkDslErrorAndExit(exitCallback);
        } else {
            exitCallback.afterProcess(false);
        }
    }
}

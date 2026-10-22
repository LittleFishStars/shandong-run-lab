package com.alibaba.ariver.legacy.v8worker;

import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback;
import com.alibaba.ariver.kernel.common.bigdata.BigDataChannelManager;
import com.alibaba.ariver.kernel.common.bigdata.IBigDataChannelCallback;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class b implements IBigDataChannelCallback {
    private static final String d = "V8Worker";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    n f24298a;
    String b;
    String c;

    public b(n nVar) {
        this.f24298a = nVar;
    }

    @Override // com.alibaba.ariver.kernel.common.bigdata.IBigDataChannelCallback
    public void onChannelCreated(String str, String str2, String str3) {
        RVLogger.d(d, "onChannelCreated channelId: " + str + ", workerId: " + str2 + ", elementId: " + str3);
        if (!this.f24298a.getWorkerId().equals(str2)) {
            this.b = null;
            this.c = null;
        } else {
            this.b = str;
            this.c = str3;
            BigDataChannelManager.getInstance().readyForNextData(this.b, this.c);
        }
    }

    @Override // com.alibaba.ariver.kernel.common.bigdata.IBigDataChannelCallback
    public void onChannelReleased(String str) {
        String str2 = this.b;
        if (str2 == null || !str2.equals(str)) {
            return;
        }
        this.b = null;
        this.c = null;
    }

    @Override // com.alibaba.ariver.kernel.common.bigdata.IBigDataChannelCallback
    public void onReceiveData(JSONObject jSONObject) {
        if (this.c == null) {
            return;
        }
        String string = JSONUtils.getString(jSONObject, "element", null);
        if (jSONObject == null || TextUtils.isEmpty(string) || !this.c.equals(string)) {
            return;
        }
        String string2 = JSONUtils.getString(jSONObject, "func", null);
        int i = JSONUtils.getInt(jSONObject, "viewId", 0);
        jSONObject.remove("viewId");
        jSONObject.remove("func");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("data", (Object) jSONObject);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("func", (Object) string2);
        jSONObject3.put("param", (Object) jSONObject2);
        jSONObject3.put("viewId", (Object) Integer.valueOf(i));
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("handlerName", (Object) com.igexin.push.config.c.x);
        jSONObject4.put("data", (Object) jSONObject3);
        this.f24298a.sendJsonToWorker(jSONObject4, new SendToWorkerCallback() { // from class: com.alibaba.ariver.legacy.v8worker.b.1
            @Override // com.alibaba.ariver.engine.api.bridge.SendToWorkerCallback
            public void onCallBack(JSONObject jSONObject5) {
                b bVar = b.this;
                if (bVar.b == null || bVar.c == null) {
                    return;
                }
                BigDataChannelManager bigDataChannelManager = BigDataChannelManager.getInstance();
                b bVar2 = b.this;
                bigDataChannelManager.readyForNextData(bVar2.b, bVar2.c);
            }
        });
    }
}

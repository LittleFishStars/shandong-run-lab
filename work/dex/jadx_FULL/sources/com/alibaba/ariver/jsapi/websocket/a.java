package com.alibaba.ariver.jsapi.websocket;

import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.b;
import com.alibaba.ariver.websocket.core.c;
import com.alibaba.fastjson.JSONObject;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24183a = "AriverAPI:WebSocketBridgeCallback";
    private Page b;
    private boolean c;
    private String d;

    public a(Page page, String str, boolean z) {
        this.b = page;
        this.c = z;
        this.d = str;
    }

    @Override // com.alibaba.ariver.websocket.core.c
    public void a() {
        if (this.b == null) {
            return;
        }
        RVLogger.d(f24183a, "enter onSocketOpen. ");
        if (!this.c || TextUtils.isEmpty(this.d)) {
            a("socketOpen", (JSONObject) null);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("socketTaskID", (Object) this.d);
        jSONObject.put("data", (Object) jSONObject2);
        a("onSocketTaskOpen", jSONObject);
    }

    @Override // com.alibaba.ariver.websocket.core.c
    public void b() {
        if (this.b == null) {
            return;
        }
        RVLogger.d(f24183a, "enter onSocketClose. ");
        if (!this.c || TextUtils.isEmpty(this.d)) {
            a("socketClose", (JSONObject) null);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("socketTaskID", (Object) this.d);
        jSONObject.put("data", (Object) jSONObject2);
        a("onSocketTaskClose", jSONObject);
    }

    @Override // com.alibaba.ariver.websocket.core.c
    public void a(byte[] bArr) {
        if (this.b == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("data", (Object) new String(Base64.encode(bArr, 2), "utf-8"));
            jSONObject.put("isBuffer", (Object) Boolean.TRUE);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("data", (Object) jSONObject);
            if (this.c && !TextUtils.isEmpty(this.d)) {
                jSONObject.put("socketTaskID", (Object) this.d);
                a("onSocketTaskMessage", jSONObject2);
            } else {
                a(b.b, jSONObject2);
            }
        } catch (UnsupportedEncodingException e) {
            RVLogger.e(f24183a, String.format("create string by buffer error. exception : %s", e.toString()));
        }
    }

    @Override // com.alibaba.ariver.websocket.core.c
    public void a(String str) {
        if (this.b == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", (Object) str);
        jSONObject.put("isBuffer", (Object) Boolean.FALSE);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("data", (Object) jSONObject);
        if (this.c && !TextUtils.isEmpty(this.d)) {
            jSONObject.put("socketTaskID", (Object) this.d);
            a("onSocketTaskMessage", jSONObject2);
        } else {
            a(b.b, jSONObject2);
        }
    }

    @Override // com.alibaba.ariver.websocket.core.c
    public void a(int i, String str) {
        if (this.b == null) {
            return;
        }
        RVLogger.d(f24183a, "enter onSocketError. " + str);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("error", Integer.valueOf(i));
        JSONObject jSONObject2 = new JSONObject();
        if (this.c && !TextUtils.isEmpty(this.d)) {
            jSONObject2.put("socketTaskID", (Object) this.d);
            jSONObject.put("data", (Object) jSONObject2);
            a("onSocketTaskError", jSONObject);
            return;
        }
        a("socketError", jSONObject);
    }

    private void a(String str, JSONObject jSONObject) {
        Page page = this.b;
        if (page == null) {
            return;
        }
        EngineUtils.sendToRender(page.getRender(), str, jSONObject, null);
    }

    public void a(Page page) {
        this.b = page;
    }
}

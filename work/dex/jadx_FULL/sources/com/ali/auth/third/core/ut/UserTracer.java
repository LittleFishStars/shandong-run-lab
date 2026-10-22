package com.ali.auth.third.core.ut;

import android.os.Build;
import android.text.TextUtils;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.model.RpcRequest;
import com.ali.auth.third.core.service.RpcService;
import com.ali.auth.third.core.service.UserTrackerService;
import com.ali.auth.third.core.service.impl.CredentialManager;
import com.ali.auth.third.core.util.CommonUtils;
import com.ali.auth.third.core.util.JSONUtils;
import com.ali.auth.third.core.util.SystemUtils;
import com.alibaba.alibclinkpartner.linkpartner.constants.ALPParamConstant;
import com.alibaba.ariver.kernel.api.monitor.ErrId;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class UserTracer implements UserTrackerService {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f23443a;

        public a(UserTracer userTracer, JSONObject jSONObject) {
            this.f23443a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            RpcRequest rpcRequest = new RpcRequest();
            rpcRequest.target = "mtop.taobao.havana.mlogin.userTracerLog";
            rpcRequest.version = "1.0";
            rpcRequest.addParam("userTracerInfo", this.f23443a);
            rpcRequest.addParam("ts", System.currentTimeMillis() + "");
            ((RpcService) KernelContext.getService(RpcService.class)).invoke(rpcRequest, String.class);
        }
    }

    public static JSONObject getAppInfo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("memorySize", CommonUtils.getTotalMemory());
            jSONObject.put("deviceId", CommonUtils.getAndroidId());
            jSONObject.put("uuid", KernelContext.UUID);
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("osType", "android");
            jSONObject.put("osVersion", Build.VERSION.SDK_INT + "");
        } catch (Exception unused2) {
        }
        try {
            jSONObject.put(ALPParamConstant.SDKNAME, "alibabauth_sdk");
            jSONObject.put("sdkVersion", KernelContext.sdkVersion);
            jSONObject.put(UserTrackConstant.SDK_TYPE, KernelContext.isMini ? ErrId.EmbedWebViewType.MINI : "std");
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put("appId", KernelContext.getApplicationContext().getPackageName() + "|" + SystemUtils.getApkPublicKeyDigest());
            jSONObject.put("appKey", KernelContext.getAppKey());
            jSONObject.put("appName", CommonUtils.getAppLabel());
            jSONObject.put("appVersion", CommonUtils.getAndroidAppVersion());
        } catch (Exception unused4) {
        }
        try {
            jSONObject.put("openId", CredentialManager.INSTANCE.getInternalSession().user.openId);
        } catch (Exception unused5) {
        }
        return jSONObject;
    }

    public void init() {
    }

    @Override // com.ali.auth.third.core.service.UserTrackerService
    public void send(String str, Map<String, String> map) {
        JSONObject appInfo = getAppInfo();
        try {
            if (!TextUtils.isEmpty(str)) {
                appInfo.put("action", str);
            }
            if (map != null) {
                appInfo.put("actionExt", JSONUtils.toJsonObject(map));
            }
            new Thread(new a(this, appInfo)).start();
        } catch (Exception unused) {
        }
    }
}

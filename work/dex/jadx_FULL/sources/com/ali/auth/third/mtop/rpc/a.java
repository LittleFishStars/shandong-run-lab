package com.ali.auth.third.mtop.rpc;

import android.text.TextUtils;
import com.ali.auth.third.core.MemberSDK;
import com.ali.auth.third.core.context.KernelContext;
import com.ali.auth.third.core.model.LoginReturnData;
import com.ali.auth.third.core.model.RpcRequest;
import com.ali.auth.third.core.model.RpcRequestCallbackWithCode;
import com.ali.auth.third.core.model.RpcResponse;
import com.ali.auth.third.core.rpc.protocol.RpcException;
import com.ali.auth.third.core.trace.SDKLogger;
import com.ali.auth.third.core.util.JSONUtils;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import mtopsdk.mtop.domain.BaseOutDo;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;
import mtopsdk.mtop.intf.MtopSetting;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f23495a;

    /* JADX INFO: renamed from: com.ali.auth.third.mtop.rpc.a$a, reason: collision with other inner class name */
    public class C0122a implements IRemoteBaseListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RpcRequestCallbackWithCode f23496a;
        final /* synthetic */ Class b;

        public C0122a(RpcRequestCallbackWithCode rpcRequestCallbackWithCode, Class cls) {
            this.f23496a = rpcRequestCallbackWithCode;
            this.b = cls;
        }

        public void onError(int i, MtopResponse mtopResponse, Object obj) {
            this.f23496a.onError(mtopResponse != null ? mtopResponse.getRetCode() : "-1", a.this.c(mtopResponse, this.b));
        }

        public void onSuccess(int i, MtopResponse mtopResponse, BaseOutDo baseOutDo, Object obj) {
            this.f23496a.onSuccess(a.this.c(mtopResponse, this.b));
        }

        public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
            String retCode = mtopResponse != null ? mtopResponse.getRetCode() : "-1";
            try {
                this.f23496a.onSystemError(retCode, a.this.c(mtopResponse, this.b));
            } catch (RpcException unused) {
                this.f23496a.onSystemError(retCode, null);
            }
        }
    }

    private <V> RpcResponse<V> a(MtopResponse mtopResponse, Class<V> cls) {
        try {
            return b(mtopResponse, cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static synchronized a a() {
        if (f23495a == null) {
            f23495a = new a();
        }
        return f23495a;
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [T, java.lang.Object] */
    private <V> RpcResponse<V> b(MtopResponse mtopResponse, Class<V> cls) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        RpcResponse<V> rpcResponse = new RpcResponse<>();
        byte[] bytedata = mtopResponse.getBytedata();
        if (bytedata != null && (jSONObjectOptJSONObject = new JSONObject(new String(bytedata)).optJSONObject("data")) != null) {
            rpcResponse.code = jSONObjectOptJSONObject.optInt("code");
            rpcResponse.codeGroup = jSONObjectOptJSONObject.optString("codeGroup");
            rpcResponse.message = jSONObjectOptJSONObject.optString("message");
            rpcResponse.actionType = jSONObjectOptJSONObject.optString("actionType");
            rpcResponse.success = jSONObjectOptJSONObject.optBoolean("success");
            if (!TextUtils.isEmpty(jSONObjectOptJSONObject.optString("returnValue"))) {
                rpcResponse.returnValue = JSONUtils.parseStringValue(jSONObjectOptJSONObject.optString("returnValue"), cls);
            }
        }
        return rpcResponse;
    }

    private MtopRequest b(RpcRequest rpcRequest) throws JSONException {
        MtopRequest mtopRequest = new MtopRequest();
        mtopRequest.setApiName(rpcRequest.target);
        mtopRequest.setVersion(rpcRequest.version);
        mtopRequest.setNeedEcode(false);
        mtopRequest.setNeedSession(false);
        JSONObject jSONObject = new JSONObject();
        for (int i = 0; i < rpcRequest.paramNames.size(); i++) {
            if (rpcRequest.paramNames.get(i) != null) {
                jSONObject.put(rpcRequest.paramNames.get(i), rpcRequest.paramValues.get(i).toString());
            }
        }
        mtopRequest.setData(jSONObject.toString());
        return mtopRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <V> RpcResponse<V> c(MtopResponse mtopResponse, Class<V> cls) {
        if (mtopResponse != null && mtopResponse.isApiSuccess()) {
            return a(mtopResponse, cls);
        }
        if (mtopResponse == null) {
            return null;
        }
        if (mtopResponse.isNetworkError()) {
            throw new RpcException((Integer) 7, mtopResponse.getRetMsg());
        }
        if (mtopResponse.isApiLockedResult()) {
            throw new RpcException((Integer) 400, mtopResponse.getRetMsg());
        }
        if (mtopResponse.is41XResult()) {
            throw new RpcException((Integer) 401, mtopResponse.getRetMsg());
        }
        if (mtopResponse.isExpiredRequest()) {
            throw new RpcException((Integer) 402, mtopResponse.getRetMsg());
        }
        if (mtopResponse.isIllegelSign()) {
            throw new RpcException((Integer) 403, mtopResponse.getRetMsg());
        }
        if (mtopResponse.isSystemError()) {
            throw new RpcException((Integer) 406, mtopResponse.getRetMsg());
        }
        if (mtopResponse.isSessionInvalid()) {
            throw new RpcException((Integer) 407, mtopResponse.getRetMsg());
        }
        if (mtopResponse.isMtopServerError()) {
            throw new RpcException((Integer) 406, mtopResponse.getRetMsg());
        }
        if (mtopResponse.isMtopSdkError()) {
            throw new RpcException((Integer) 406, mtopResponse.getRetMsg());
        }
        return a(mtopResponse, cls);
    }

    public <V> RpcResponse<V> a(RpcRequest rpcRequest, Class<V> cls) {
        return a(rpcRequest, cls, (String) null);
    }

    public <V> RpcResponse<V> a(RpcRequest rpcRequest, Class<V> cls, String str) {
        MtopResponse mtopResponse;
        MtopResponse mtopResponseSyncRequest;
        try {
            MtopBuilder connectionTimeoutMilliSecond = Mtop.instance("OPEN", KernelContext.context).build(b(rpcRequest), MemberSDK.ttid).reqMethod(MethodEnum.POST).setBizId(94).setConnectionTimeoutMilliSecond(10000);
            if (!TextUtils.isEmpty(str)) {
                connectionTimeoutMilliSecond.setReqUserId(str);
            }
            connectionTimeoutMilliSecond.retryTime(1);
            connectionTimeoutMilliSecond.setOpenBiz("baichuan");
            mtopResponseSyncRequest = connectionTimeoutMilliSecond.syncRequest();
            try {
                SDKLogger.d("login.MTOPWrapperImpl", "receive MtopResponse" + mtopResponseSyncRequest);
            } catch (Exception e) {
                mtopResponse = mtopResponseSyncRequest;
                e = e;
                SDKLogger.e("login.MTOPWrapperImpl", "MtopResponse error", e);
                e.printStackTrace();
                mtopResponseSyncRequest = mtopResponse;
            }
        } catch (Exception e2) {
            e = e2;
            mtopResponse = null;
        }
        if (mtopResponseSyncRequest != null) {
            return c(mtopResponseSyncRequest, cls);
        }
        SDKLogger.e("login.MTOPWrapperImpl", "MtopResponse response=null");
        return null;
    }

    public String a(RpcRequest rpcRequest) {
        return a(rpcRequest, LoginReturnData.class).toString();
    }

    public <T> void a(RpcRequest rpcRequest, Class<T> cls, RpcRequestCallbackWithCode rpcRequestCallbackWithCode) {
        if (rpcRequest == null || rpcRequestCallbackWithCode == null) {
            return;
        }
        try {
            MtopSetting.setMtopDomain("OPEN", "", "guide-acs.wapa.taobao.com", "");
            MtopBusiness mtopBusinessBuild = MtopBusiness.build(Mtop.instance("OPEN", KernelContext.context), b(rpcRequest), MemberSDK.ttid);
            mtopBusinessBuild.setOpenBiz("baichuan");
            mtopBusinessBuild.registerListener(new C0122a(rpcRequestCallbackWithCode, cls));
            mtopBusinessBuild.startRequest();
        } catch (Throwable unused) {
        }
    }
}

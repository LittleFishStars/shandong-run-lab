package com.alibaba.ariver.jsapi.rpc;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingRequest;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.rpc.RVRpcException;
import com.alibaba.ariver.kernel.common.rpc.RVRpcResponse;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.RVTraceUtils;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alipay.mobile.common.transport.utils.ReadSettingServerUrl;
import com.alipay.sdk.m.o.b;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RpcBridgeExtension implements BridgeExtension {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24167a = "AriverRpc:RpcBridgeExtension";
    private static final String b = "client_trace_id";
    private static final String c = "Mgw-TraceId";
    private static final String d = "client`";
    private static final String e = "rpc-TraceId";

    @Nullable
    private String a(String str) {
        return (!TextUtils.isEmpty(str) && str.startsWith("\"") && str.endsWith("\"")) ? str.substring(1, str.length() - 1).replaceAll("\\\\", "") : str;
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x01f1 A[Catch: all -> 0x0275, TryCatch #6 {all -> 0x0275, blocks: (B:102:0x01db, B:104:0x01f1, B:106:0x01f6, B:108:0x0208, B:110:0x022e, B:113:0x023b, B:115:0x0261, B:117:0x0267, B:118:0x026a, B:114:0x0251), top: B:136:0x01db }] */
    /* JADX WARN: Code duplicated, block: B:106:0x01f6 A[Catch: all -> 0x0275, TryCatch #6 {all -> 0x0275, blocks: (B:102:0x01db, B:104:0x01f1, B:106:0x01f6, B:108:0x0208, B:110:0x022e, B:113:0x023b, B:115:0x0261, B:117:0x0267, B:118:0x026a, B:114:0x0251), top: B:136:0x01db }] */
    /* JADX WARN: Code duplicated, block: B:113:0x023b A[Catch: all -> 0x0275, TRY_ENTER, TryCatch #6 {all -> 0x0275, blocks: (B:102:0x01db, B:104:0x01f1, B:106:0x01f6, B:108:0x0208, B:110:0x022e, B:113:0x023b, B:115:0x0261, B:117:0x0267, B:118:0x026a, B:114:0x0251), top: B:136:0x01db }] */
    /* JADX WARN: Code duplicated, block: B:114:0x0251 A[Catch: all -> 0x0275, TryCatch #6 {all -> 0x0275, blocks: (B:102:0x01db, B:104:0x01f1, B:106:0x01f6, B:108:0x0208, B:110:0x022e, B:113:0x023b, B:115:0x0261, B:117:0x0267, B:118:0x026a, B:114:0x0251), top: B:136:0x01db }] */
    /* JADX WARN: Code duplicated, block: B:117:0x0267 A[Catch: all -> 0x0275, TryCatch #6 {all -> 0x0275, blocks: (B:102:0x01db, B:104:0x01f1, B:106:0x01f6, B:108:0x0208, B:110:0x022e, B:113:0x023b, B:115:0x0261, B:117:0x0267, B:118:0x026a, B:114:0x0251), top: B:136:0x01db }] */
    /* JADX WARN: Code duplicated, block: B:61:0x012e  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12, types: [com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback] */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v4, types: [com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback] */
    /* JADX WARN: Type inference failed for: r8v9 */
    @ThreadType(ExecutorType.NETWORK)
    @ActionFilter
    public void rpc(@BindingParam(stringDefault = "", value = {"operationType"}) String str, @BindingParam(booleanDefault = false, value = {"openRpc"}) boolean z, @BindingParam(booleanDefault = false, value = {"httpGet"}) boolean z2, @BindingParam(stringDefault = "json", value = {"type"}) String str2, @BindingRequest JSONObject jSONObject, @BindingParam({"gateway"}) String str3, @BindingParam({"headers"}) JSONObject jSONObject2, @BindingParam(booleanDefault = true, value = {"compress"}) boolean z3, @BindingParam(booleanDefault = false, value = {"retryable"}) boolean z4, @BindingParam(intDefault = 0, value = {b.r0}) int i, @BindingParam(booleanDefault = false, value = {"getResponse"}) boolean z5, @BindingParam({"region"}) String str4, @BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        Class<?> cls;
        boolean zIsAssignableFrom;
        Object obj;
        String str5;
        String str6;
        String str7;
        String str8;
        StringBuilder sb;
        String string;
        RpcExceptionHandleProxy rpcExceptionHandleProxy;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        StringBuilder sb2;
        RpcBridgeExtension rpcBridgeExtension;
        RVTraceUtils.traceBeginSection("RV_Extension_invoke_RpcBridgeExtension_rpc_" + str);
        ?? B = !TextUtils.isEmpty(str3) ? a.b(str3) : 0;
        String gwfurl = TextUtils.isEmpty(str3) ? ReadSettingServerUrl.getInstance().getGWFURL(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext()) : str3;
        if (TextUtils.isEmpty(gwfurl)) {
            gwfurl = "https://mobilegw.alipay.com/mgw.htm";
        }
        String str9 = gwfurl;
        boolean zA = a.a(str2);
        Object value = JSONUtils.getValue(jSONObject, "requestData", null);
        Object jSONString = value == null ? "" : value;
        try {
            cls = jSONString.getClass();
            try {
                zIsAssignableFrom = byte[].class.isAssignableFrom(cls);
            } catch (Throwable th) {
                th = th;
                RVLogger.e(f24167a, th);
                zIsAssignableFrom = false;
            }
        } catch (Throwable th2) {
            th = th2;
            cls = null;
        }
        boolean z6 = zIsAssignableFrom;
        if (!zA) {
            if (cls == null) {
                try {
                    cls = jSONString.getClass();
                } catch (Throwable th3) {
                    RVLogger.e(f24167a, "parse error: ", th3);
                    obj = "";
                }
            }
            if (JSONArray.class.isAssignableFrom(cls)) {
                jSONString = ((JSONArray) jSONString).toJSONString();
            }
        }
        obj = jSONString;
        B = bridgeCallback;
        try {
            try {
                RVRpcResponse rVRpcResponseA = a.a(z, str, obj, str9, z3, jSONObject2, B, z4, app, page, i, str2, z2, -1, str4);
                if (rVRpcResponseA == null) {
                    try {
                        B.sendBridgeResponse(BridgeResponse.SUCCESS);
                        sb = new StringBuilder();
                        sb.append("RV_Extension_invoke_RpcBridgeExtension_rpc_");
                        str5 = str;
                    } catch (Throwable th4) {
                        th = th4;
                        str5 = str;
                        str6 = "RV_Extension_invoke_RpcBridgeExtension_rpc_";
                        str8 = null;
                        str7 = e;
                        RVLogger.e(f24167a, th);
                        rpcExceptionHandleProxy = (RpcExceptionHandleProxy) RVProxy.get(RpcExceptionHandleProxy.class);
                        jSONObject3 = new JSONObject();
                        if (!TextUtils.isEmpty(str8)) {
                            jSONObject3.put(str7, (Object) str8);
                        }
                        if (rpcExceptionHandleProxy == null) {
                        }
                        jSONObject4 = new JSONObject();
                        if (th instanceof RVRpcException) {
                            jSONObject4.put("error", (Object) Integer.valueOf(th.getCode()));
                            jSONObject4.put(SendToNativeCallback.KEY_MESSAGE, (Object) th.getMessage());
                        } else {
                            jSONObject4.put("error", (Object) Integer.valueOf(AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE));
                            jSONObject4.put(SendToNativeCallback.KEY_MESSAGE, (Object) th.getMessage());
                        }
                        if (!TextUtils.isEmpty(str8)) {
                            jSONObject4.put(str7, (Object) str8);
                        }
                        B.sendJSONResponse(jSONObject4);
                        sb2 = new StringBuilder();
                        sb2.append(str6);
                        sb2.append(str5);
                        string = sb2.toString();
                    }
                    sb.append(str5);
                    string = sb.toString();
                    return;
                }
                str5 = str;
                str6 = "RV_Extension_invoke_RpcBridgeExtension_rpc_";
                try {
                    Map<String, String> headers = rVRpcResponseA.getHeaders();
                    if (headers != null) {
                        try {
                            if (headers.size() > 0) {
                                String str10 = headers.get(c);
                                String str11 = headers.get(b);
                                if (!TextUtils.isEmpty(str10)) {
                                    str8 = str10;
                                } else if (TextUtils.isEmpty(str11)) {
                                    str8 = null;
                                } else {
                                    str8 = d + str11;
                                }
                            } else {
                                str8 = null;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            str8 = null;
                        }
                    } else {
                        str8 = null;
                    }
                    try {
                        Object response = rVRpcResponseA.getResponse();
                        JSONObject jSONObject5 = new JSONObject();
                        try {
                            if (zA) {
                                if (z6) {
                                    jSONObject5.put("resData", response);
                                    rpcBridgeExtension = this;
                                } else {
                                    try {
                                        rpcBridgeExtension = this;
                                        jSONObject5.put("resData", (Object) rpcBridgeExtension.a((String) response));
                                    } catch (Throwable th6) {
                                        th = th6;
                                        B = B;
                                        str7 = e;
                                    }
                                }
                                if (z5) {
                                    jSONObject5.put("header", (Object) rpcBridgeExtension.a(rVRpcResponseA.getHeaders()));
                                }
                            } else {
                                B = B;
                                String str12 = (String) response;
                                JSONObject object = JSONUtils.parseObject(str12);
                                if (object == null) {
                                    jSONObject5.put("resData", (Object) a(str12));
                                    if (z5) {
                                        jSONObject5.put("header", (Object) a(rVRpcResponseA.getHeaders()));
                                    }
                                } else if (z5) {
                                    jSONObject5 = new JSONObject();
                                    jSONObject5.put("header", (Object) a(rVRpcResponseA.getHeaders()));
                                    jSONObject5.put("resData", (Object) object);
                                } else {
                                    jSONObject5 = object;
                                }
                            }
                            boolean zIsEmpty = TextUtils.isEmpty(str8);
                            str7 = e;
                            if (!zIsEmpty) {
                                try {
                                    jSONObject5.put(str7, (Object) str8);
                                } catch (Throwable th7) {
                                    th = th7;
                                    RVLogger.e(f24167a, th);
                                    rpcExceptionHandleProxy = (RpcExceptionHandleProxy) RVProxy.get(RpcExceptionHandleProxy.class);
                                    jSONObject3 = new JSONObject();
                                    if (!TextUtils.isEmpty(str8)) {
                                        jSONObject3.put(str7, (Object) str8);
                                    }
                                    if (rpcExceptionHandleProxy == null) {
                                    }
                                    jSONObject4 = new JSONObject();
                                    if (th instanceof RVRpcException) {
                                        jSONObject4.put("error", (Object) Integer.valueOf(th.getCode()));
                                        jSONObject4.put(SendToNativeCallback.KEY_MESSAGE, (Object) th.getMessage());
                                    } else {
                                        jSONObject4.put("error", (Object) Integer.valueOf(AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE));
                                        jSONObject4.put(SendToNativeCallback.KEY_MESSAGE, (Object) th.getMessage());
                                    }
                                    if (!TextUtils.isEmpty(str8)) {
                                        jSONObject4.put(str7, (Object) str8);
                                    }
                                    B.sendJSONResponse(jSONObject4);
                                    sb2 = new StringBuilder();
                                }
                            }
                            B.sendJSONResponse(jSONObject5);
                            sb2 = new StringBuilder();
                        } catch (Throwable th8) {
                            th = th8;
                        }
                    } catch (Throwable th9) {
                        th = th9;
                        str7 = e;
                    }
                } catch (Throwable th10) {
                    th = th10;
                    str7 = e;
                    str8 = null;
                }
                sb2.append(str6);
                sb2.append(str5);
                string = sb2.toString();
                str8 = null;
                str7 = e;
            } catch (Throwable th11) {
                th = th11;
                str5 = str;
                str6 = "RV_Extension_invoke_RpcBridgeExtension_rpc_";
            }
            RVLogger.e(f24167a, th);
            rpcExceptionHandleProxy = (RpcExceptionHandleProxy) RVProxy.get(RpcExceptionHandleProxy.class);
            jSONObject3 = new JSONObject();
            if (!TextUtils.isEmpty(str8)) {
                jSONObject3.put(str7, (Object) str8);
            }
            if (rpcExceptionHandleProxy == null && rpcExceptionHandleProxy.handledRpcException(page, jSONObject, jSONObject3, bridgeCallback, th)) {
                RVLogger.d(f24167a, "rpc exception handled by " + rpcExceptionHandleProxy.getClass().getCanonicalName());
                sb = new StringBuilder();
                sb.append(str6);
                sb.append(str5);
                string = sb.toString();
                return;
            }
            jSONObject4 = new JSONObject();
            if (th instanceof RVRpcException) {
                jSONObject4.put("error", (Object) Integer.valueOf(th.getCode()));
                jSONObject4.put(SendToNativeCallback.KEY_MESSAGE, (Object) th.getMessage());
            } else {
                jSONObject4.put("error", (Object) Integer.valueOf(AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE));
                jSONObject4.put(SendToNativeCallback.KEY_MESSAGE, (Object) th.getMessage());
            }
            if (!TextUtils.isEmpty(str8)) {
                jSONObject4.put(str7, (Object) str8);
            }
            B.sendJSONResponse(jSONObject4);
            sb2 = new StringBuilder();
            sb2.append(str6);
            sb2.append(str5);
            string = sb2.toString();
        } finally {
            RVTraceUtils.traceEndSection(str6 + str5);
        }
    }

    private JSONObject a(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            JSONObject jSONObject = new JSONObject();
            for (String str : map.keySet()) {
                String str2 = map.get(str);
                jSONObject.put(str, (Object) str2);
                RVLogger.d(f24167a, "response headers " + str + " " + str2);
            }
            return jSONObject;
        }
        RVLogger.d(f24167a, "response headers == null");
        return null;
    }
}

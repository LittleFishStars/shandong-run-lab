package com.alibaba.triver.inside.impl;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.rpc.RVRpcConfig;
import com.alibaba.ariver.kernel.common.rpc.RVRpcException;
import com.alibaba.ariver.kernel.common.rpc.RVRpcProxy;
import com.alibaba.ariver.kernel.common.rpc.RVRpcResponse;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.rpc.RpcServiceHolder;
import com.alibaba.triver.kit.api.common.TRiverConstants;
import com.alibaba.triver.kit.api.proxy.IEnvProxy;
import com.alipay.mobile.common.rpc.RpcException;
import com.alipay.mobile.common.rpc.RpcInvokeContext;
import com.alipay.mobile.common.transport.utils.LogCatUtil;
import com.alipay.mobile.common.transport.utils.MiscUtils;
import com.alipay.mobile.common.transport.utils.TransportEnvUtil;
import com.alipay.mobile.framework.service.common.MpaasRpcService;
import com.alipay.mobile.framework.service.ext.SimpleRpcService;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RpcProxyImpl implements RVRpcProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24985a = "NXRpcImpl";

    private void a(RpcInvokeContext rpcInvokeContext, RVRpcConfig rVRpcConfig) {
        if (rpcInvokeContext == null) {
            return;
        }
        if (MiscUtils.isDebugger(TransportEnvUtil.getContext())) {
            String envValue = ((IEnvProxy) RVProxy.get(IEnvProxy.class)).getEnvValue(TRiverConstants.KEY_ENVIRONMENT_INDEX);
            LogCatUtil.debug(f24985a, "envIndex:" + envValue + ",configGw:" + rVRpcConfig.getGwUrl());
            if (TextUtils.equals(envValue, "1")) {
                rpcInvokeContext.setUseMultiplexLink(true);
                rpcInvokeContext.setGwUrl("QN".equals(((IEnvProxy) RVProxy.get(IEnvProxy.class)).getEnvValue("appName")) ? "https://mobilegwpre.alipay.com/mgw.htm" : "https://tinyapp-gateway-pre.alipay.com/mgw.htm");
                LogCatUtil.debug(f24985a, "taobao pre env,use pre gw");
            } else if (TextUtils.equals(envValue, "2")) {
                rpcInvokeContext.setUseMultiplexLink(true);
                rpcInvokeContext.setGwUrl("http://mobilegw-eu95-26.rz01b.dev.alipay.net/mgw.htm");
            }
        }
        if (rVRpcConfig == null) {
            return;
        }
        if (rVRpcConfig.getTimeout() != null && rVRpcConfig.getTimeout().longValue() > 0) {
            rpcInvokeContext.setTimeout(rVRpcConfig.getTimeout().longValue());
        }
        if (rVRpcConfig.getAppId() != null) {
            rpcInvokeContext.setAppId(rVRpcConfig.getAppId());
        }
        rVRpcConfig.getGwUrl();
        if (rVRpcConfig.getRequestHeader() != null) {
            rpcInvokeContext.setRequestHeaders(rVRpcConfig.getRequestHeader());
        }
        if (rVRpcConfig.isCompress() != null) {
            rpcInvokeContext.setCompress(rVRpcConfig.isCompress().booleanValue());
        }
        if (rVRpcConfig.getAppKey() != null) {
            rpcInvokeContext.setAppKey(rVRpcConfig.getAppKey());
        }
        if (rVRpcConfig.isResetCookie() != null) {
            rpcInvokeContext.setResetCookie(rVRpcConfig.isResetCookie().booleanValue());
        }
        if (rVRpcConfig.isBgRpc() != null) {
            rpcInvokeContext.setBgRpc(rVRpcConfig.isBgRpc().booleanValue());
        }
        if (rVRpcConfig.isAllowRetry() != null) {
            rpcInvokeContext.setAllowRetry(rVRpcConfig.isAllowRetry().booleanValue());
        }
        if (rVRpcConfig.isUrgent() != null) {
            rpcInvokeContext.setUrgent(rVRpcConfig.isUrgent().booleanValue());
        }
        if (rVRpcConfig.isRpcV2() != null) {
            rpcInvokeContext.setRpcV2(rVRpcConfig.isRpcV2().booleanValue());
        }
        if (rVRpcConfig.isAllowBgLogin() != null) {
            rpcInvokeContext.setAllowBgLogin(rVRpcConfig.isAllowBgLogin().booleanValue());
        }
        if (rVRpcConfig.isAllowNonNet() != null) {
            rpcInvokeContext.setAllowNonNet(rVRpcConfig.isAllowNonNet().booleanValue());
        }
        if (rVRpcConfig.isSwitchUserLoginRpc() != null) {
            rpcInvokeContext.setSwitchUserLoginRpc(rVRpcConfig.isSwitchUserLoginRpc().booleanValue());
        }
        if (rVRpcConfig.isGetMethod() != null) {
            rpcInvokeContext.setGetMethod(rVRpcConfig.isGetMethod().booleanValue());
        }
        if (rVRpcConfig.isEnableEncrypt() != null) {
            rpcInvokeContext.setDisableEncrypt(!rVRpcConfig.isEnableEncrypt().booleanValue());
        }
        if (rVRpcConfig.isDisableEncrypt() != null) {
            rpcInvokeContext.setDisableEncrypt(rVRpcConfig.isDisableEncrypt().booleanValue());
        }
    }

    @Override // com.alibaba.ariver.kernel.common.rpc.RVRpcProxy
    public <T> T getPBRpcProxy(Class<T> cls) {
        return (T) getPBRpcProxy(cls, null);
    }

    @Override // com.alibaba.ariver.kernel.common.rpc.RVRpcProxy
    public <T> T getRpcProxy(Class<T> cls) {
        return (T) getRpcProxy(cls, null);
    }

    @Override // com.alibaba.ariver.kernel.common.rpc.RVRpcProxy
    public RVRpcResponse sendSimpleRpc(@Nullable Node node, boolean z, String str, RVRpcConfig rVRpcConfig, Object obj, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            RVLogger.e(f24985a, "sendSimpleRpc operationType is empty");
        }
        try {
            MpaasRpcService mpaasRpcService = RpcServiceHolder.get();
            SimpleRpcService simpleRpcService = (SimpleRpcService) mpaasRpcService.getRpcProxy(SimpleRpcService.class);
            RpcInvokeContext rpcInvokeContext = mpaasRpcService.getRpcInvokeContext(simpleRpcService);
            HashMap map2 = new HashMap();
            map2.put("OpenAuthLogin", "YES");
            map2.put("bizSource", "tinyapp");
            rpcInvokeContext.setExtParams(map2);
            a(rpcInvokeContext, rVRpcConfig);
            String strEncodeToString = null;
            if (z) {
                try {
                    strEncodeToString = Base64.encodeToString(simpleRpcService.executeRPC(str, Base64.decode((String) obj, 0), (Map) null), 0);
                } catch (IllegalArgumentException e) {
                    RVLogger.e(f24985a, e);
                }
            } else {
                if (TextUtils.isEmpty((String) obj)) {
                    obj = "[{}]";
                }
                strEncodeToString = simpleRpcService.executeRPC(str, (String) obj, (Map) null);
            }
            return new RVRpcResponse(rpcInvokeContext.getResponseHeaders(), strEncodeToString, "");
        } catch (RpcException e2) {
            throw new RVRpcException(e2.getCause(), e2.getCode());
        } catch (Throwable th) {
            throw new RVRpcException(th.getCause(), -1);
        }
    }

    @Override // com.alibaba.ariver.kernel.common.rpc.RVRpcProxy
    public RVRpcResponse sendSimpleRpcJsapi(@Nullable Node node, boolean z, String str, RVRpcConfig rVRpcConfig, Object obj, Map<String, String> map) {
        return null;
    }

    @Override // com.alibaba.ariver.kernel.common.rpc.RVRpcProxy
    public <T> T getPBRpcProxy(Class<T> cls, RVRpcConfig rVRpcConfig) {
        if (cls == null) {
            RVLogger.e(f24985a, "getPBRpcProxy rpcProxyClazz is null");
        }
        try {
            MpaasRpcService mpaasRpcService = RpcServiceHolder.get();
            T t = (T) mpaasRpcService.getRpcProxy(cls);
            a(mpaasRpcService.getRpcInvokeContext(t), rVRpcConfig);
            return t;
        } catch (RpcException e) {
            throw new RVRpcException(e.getCause(), e.getCode());
        } catch (Throwable th) {
            throw new RVRpcException(th.getCause(), -1);
        }
    }

    @Override // com.alibaba.ariver.kernel.common.rpc.RVRpcProxy
    public <T> T getRpcProxy(Class<T> cls, RVRpcConfig rVRpcConfig) {
        if (cls == null) {
            RVLogger.e(f24985a, "getRpcProxy rpcProxyClazz is null");
        }
        try {
            MpaasRpcService mpaasRpcService = RpcServiceHolder.get();
            T t = (T) mpaasRpcService.getRpcProxy(cls);
            a(mpaasRpcService.getRpcInvokeContext(t), rVRpcConfig);
            return t;
        } catch (RpcException e) {
            throw new RVRpcException(e.getCause(), e.getCode());
        } catch (Throwable th) {
            throw new RVRpcException(th.getCause(), -1);
        }
    }
}

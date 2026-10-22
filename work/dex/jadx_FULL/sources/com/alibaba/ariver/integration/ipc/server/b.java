package com.alibaba.ariver.integration.ipc.server;

import android.os.Bundle;
import android.util.Log;
import com.alibaba.ariver.app.ipc.IpcServerUtils;
import com.alibaba.ariver.kernel.api.IIpcChannel;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.IpcChannelManager;
import com.alibaba.ariver.kernel.ipc.IpcMessageConstants;
import com.alibaba.fastjson.JSONObject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24083a = "AriverInt:RemoteReplyHandler";
    private IIpcChannel b;
    private String c;
    private String d;
    private long e;
    private long f;

    public b(String str, String str2, long j, long j2) {
        this.f = j;
        this.d = str;
        this.b = IpcChannelManager.getInstance().getClientChannel(j);
        this.e = j2;
        this.c = str2;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        if (this.b == null) {
            RVLogger.e(f24083a, "Client channel is not found!!!" + Log.getStackTraceString(new Throwable("Just Print!")));
            return null;
        }
        if ("onCallback".equalsIgnoreCase(method.getName())) {
            JSONObject jSONObject = (JSONObject) objArr[0];
            boolean zBooleanValue = ((Boolean) objArr[1]).booleanValue();
            Bundle bundle = new Bundle();
            bundle.putByteArray("data", JSONUtils.marshallJSONObject(jSONObject));
            bundle.putBoolean("keepCallback", zBooleanValue);
            bundle.putString("clientId", this.c);
            bundle.putLong(IpcMessageConstants.EXTRA_NODE_ID, this.e);
            RVLogger.d(f24083a, "send RemoteCall back to client: " + bundle);
            IpcServerUtils.sendMsgToClient(this.d, this.f, 7, bundle);
        }
        return null;
    }
}

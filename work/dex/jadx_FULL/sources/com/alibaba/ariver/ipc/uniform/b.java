package com.alibaba.ariver.ipc.uniform;

import android.os.Parcelable;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.uniform.IIPCManager;
import com.alibaba.ariver.kernel.ipc.uniform.IPCCallManager;
import com.alibaba.ariver.kernel.ipc.uniform.IPCException;
import com.alibaba.ariver.kernel.ipc.uniform.IPCParameter;
import com.alibaba.ariver.kernel.ipc.uniform.IPCResult;
import com.alibaba.ariver.kernel.ipc.uniform.IPCResultDesc;
import com.alibaba.ariver.kernel.ipc.uniform.IPCRetryHandler;
import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b implements IPCCallManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24099a = "AriverKernel:RemoteCall";
    private IPCRetryHandler b;
    private IIPCManager c;

    public class a implements InvocationHandler {
        private a() {
        }

        private Object a(Method method, Object[] objArr, int i) throws IPCException {
            RVLogger.d("AriverKernel:RemoteCall", "IPCCallManagerImpl IPCCallProxyHandler#invoke");
            if (b.this.c == null) {
                RVLogger.d("AriverKernel:RemoteCall", "IPCCallManagerImpl IPCCallProxyHandler#invoke, ipcManager==null.");
                IPCException iPCException = new IPCException("You must set IIPCManager. example: IPCCallManager#setIIPCManager");
                iPCException.errorCode = 2;
                iPCException.errorMsg = IPCResultDesc.IPC_NO_BINDER_MSG;
                if (b.this.b == null || !b.this.b.retryIPCCall(method, objArr, iPCException, i)) {
                    throw iPCException;
                }
                if (b.this.c == null) {
                    RVLogger.w("AriverKernel:RemoteCall", "IPCCallManagerImpl IPCCallProxyHandler#invoke, retry later, ipcManager still is null.");
                    throw iPCException;
                }
            }
            Class<?> declaringClass = method.getDeclaringClass();
            Class<?>[] parameterTypes = method.getParameterTypes();
            IPCParameter iPCParameter = new IPCParameter();
            iPCParameter.className = declaringClass.getName();
            iPCParameter.methodName = method.getName();
            iPCParameter.returnType = method.getReturnType().getName();
            iPCParameter.paramTypes = new String[parameterTypes.length];
            if (b.this.a(parameterTypes)) {
                iPCParameter.serType = (byte) 2;
                iPCParameter.paramTypes[0] = parameterTypes[0].getName();
                iPCParameter.paramValues = new ArrayList(iPCParameter.paramTypes.length);
                iPCParameter.parcelable = (Parcelable) objArr[0];
            } else {
                b.this.a(objArr, parameterTypes, iPCParameter);
            }
            RVLogger.d("AriverKernel:RemoteCall", "IPCCallManagerImpl start ipc call. ipcParameter=[" + iPCParameter.toString() + "]");
            IPCResult iPCResultCall = new IPCCallable(b.this.c).call(iPCParameter);
            try {
                if (iPCResultCall == null) {
                    throw new IPCException(106, IPCResultDesc.RETURN_IPCRESULT_IS_NULL_MSG);
                }
                if (iPCResultCall.resultCode != 0) {
                    throw new IPCException(iPCResultCall.resultCode, iPCResultCall.resultMsg);
                }
                if (method.getGenericReturnType() == Void.TYPE) {
                    return null;
                }
                return iPCResultCall.serType == 2 ? iPCResultCall.parcelable : ObjSerializUtil.deserializ(iPCResultCall.resultValue, method.getReturnType().getClassLoader());
            } catch (IPCException e) {
                if (b.this.b == null || !b.this.b.retryIPCCall(method, objArr, e, i)) {
                    throw e;
                }
                return a(method, objArr, i);
            }
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            return a(method, objArr, 0);
        }
    }

    @Override // com.alibaba.ariver.kernel.ipc.uniform.IPCCallManager
    public <T> T getIpcProxy(Class<T> cls) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a());
    }

    @Override // com.alibaba.ariver.kernel.ipc.uniform.IPCCallManager
    public synchronized void setIIPCManager(IIPCManager iIPCManager) {
        this.c = iIPCManager;
        StringBuilder sb = new StringBuilder();
        sb.append("IPCCallManagerImpl [setIIPCManager] Finished. ");
        sb.append(iIPCManager == null ? " ipcManager is null" : "");
        RVLogger.d("AriverKernel:RemoteCall", sb.toString());
    }

    @Override // com.alibaba.ariver.kernel.ipc.uniform.IPCCallManager
    public void setIPCCallRetryHandler(IPCRetryHandler iPCRetryHandler) {
        this.b = iPCRetryHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(Class<?>[] clsArr) throws IPCException {
        int length = clsArr.length;
        if (length == 0) {
            return false;
        }
        if (length == 1) {
            return Parcelable.class.isAssignableFrom(clsArr[0]);
        }
        int i = 0;
        for (Class<?> cls : clsArr) {
            if (Parcelable.class.isAssignableFrom(cls)) {
                i++;
            }
        }
        if (i == 0) {
            return false;
        }
        IPCException iPCException = new IPCException("parameter more than one,and not all Serialize,not support");
        iPCException.errorCode = 3;
        iPCException.errorMsg = IPCResultDesc.IPC_PARAMER_ERROR_MSG;
        throw iPCException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object[] objArr, Class<?>[] clsArr, IPCParameter iPCParameter) {
        for (int i = 0; i < clsArr.length; i++) {
            iPCParameter.paramTypes[i] = clsArr[i].getName();
        }
        if (iPCParameter.paramTypes.length > 0) {
            iPCParameter.paramValues = new ArrayList(iPCParameter.paramTypes.length);
            for (int i2 = 0; i2 < iPCParameter.paramTypes.length; i2++) {
                iPCParameter.paramValues.add(ObjSerializUtil.serializ((Serializable) objArr[i2]));
            }
        }
    }
}

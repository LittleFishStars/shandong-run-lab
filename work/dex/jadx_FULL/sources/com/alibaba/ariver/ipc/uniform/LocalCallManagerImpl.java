package com.alibaba.ariver.ipc.uniform;

import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.ipc.uniform.IPCParameter;
import com.alibaba.ariver.kernel.ipc.uniform.IPCResult;
import com.alibaba.ariver.kernel.ipc.uniform.IPCResultDesc;
import com.alibaba.ariver.kernel.ipc.uniform.LocalCallManager;
import com.alibaba.ariver.kernel.ipc.uniform.LocalCallRetryHandler;
import com.alibaba.ariver.kernel.ipc.uniform.ServiceBeanManager;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LocalCallManagerImpl implements LocalCallManager {
    private static final String TAG = "AriverKernel:RemoteCall";
    private LocalCallRetryHandler localCallRetryHandler;
    private ServiceBeanManager serviceBeanManager;

    public LocalCallManagerImpl(ServiceBeanManager serviceBeanManager) {
        this.serviceBeanManager = serviceBeanManager;
    }

    private boolean equals(Class<?>[] clsArr, String[] strArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (!TextUtils.equals(clsArr[i].getName(), strArr[i])) {
                return false;
            }
        }
        return true;
    }

    private Method getMethod(IPCParameter iPCParameter, Object obj) {
        for (Method method : obj.getClass().getMethods()) {
            if (TextUtils.equals(iPCParameter.methodName, method.getName())) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                String[] strArr = iPCParameter.paramTypes;
                if (parameterTypes.length == strArr.length && equals(parameterTypes, strArr)) {
                    return method;
                }
            }
        }
        return null;
    }

    @Override // com.alibaba.ariver.kernel.ipc.uniform.LocalCallManager
    public IPCResult call(IPCParameter iPCParameter) {
        RVLogger.d("AriverKernel:RemoteCall", "LocalCallManagerImpl start local call");
        Object serviceBean = this.serviceBeanManager.getServiceBean(iPCParameter.className);
        if (serviceBean == null) {
            RVLogger.w("AriverKernel:RemoteCall", "LocalCallManagerImpl Service not found,className=[" + iPCParameter.className + "] serviceBeanManager hashcode=[" + this.serviceBeanManager.hashCode() + "] service bean count=[" + this.serviceBeanManager.getServiceBeanCount() + "]");
            IPCResult iPCResult = new IPCResult();
            iPCResult.resultCode = 100;
            iPCResult.resultMsg = IPCResultDesc.SERVICE_NOT_FOUND_MSG;
            LocalCallRetryHandler localCallRetryHandler = this.localCallRetryHandler;
            if (localCallRetryHandler == null) {
                RVLogger.w("AriverKernel:RemoteCall", "LocalCallManagerImpl Service not found,localCallRetryHandler is null,no retry!");
                return iPCResult;
            }
            if (!localCallRetryHandler.retryLocalCall(iPCParameter, iPCResult, this.serviceBeanManager, 1)) {
                RVLogger.w("AriverKernel:RemoteCall", "LocalCallManagerImpl Service not found. no retry!");
                return iPCResult;
            }
            RVLogger.d("AriverKernel:RemoteCall", "Service not found. ye retry!");
            Object serviceBean2 = this.serviceBeanManager.getServiceBean(iPCParameter.className);
            if (serviceBean2 == null) {
                RVLogger.d("AriverKernel:RemoteCall", "LocalCallManagerImpl Service not found. retry fail!");
                return iPCResult;
            }
            serviceBean = serviceBean2;
        }
        Method method = getMethod(iPCParameter, serviceBean);
        if (method == null) {
            RVLogger.w("AriverKernel:RemoteCall", "LocalCallManagerImpl serviceBean=[" + serviceBean.getClass().getName() + "],Method not found,className=[" + iPCParameter.className + "]");
            IPCResult iPCResult2 = new IPCResult();
            iPCResult2.resultCode = 101;
            iPCResult2.resultMsg = IPCResultDesc.METHOD_NOT_FOUND_MSG;
            return iPCResult2;
        }
        RVLogger.d("AriverKernel:RemoteCall", "LocalCallManagerImpl serviceBean=[" + serviceBean.getClass().getName() + "],method=[" + method.getName() + "]");
        if (!TextUtils.equals(iPCParameter.returnType, method.getReturnType().getName())) {
            RVLogger.d("AriverKernel:RemoteCall", "Not the same returnType, peer returnType=[" + iPCParameter.returnType + "] local returnType=[" + method.getReturnType().getName() + "]");
            IPCResult iPCResult3 = new IPCResult();
            iPCResult3.resultCode = 105;
            iPCResult3.resultMsg = IPCResultDesc.METHOD_NOT_FOUND_MSG;
            return iPCResult3;
        }
        List<byte[]> list = iPCParameter.paramValues;
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (list != null && parameterTypes.length != list.size()) {
            IPCResult iPCResult4 = new IPCResult();
            iPCResult4.resultCode = 102;
            iPCResult4.resultMsg = IPCResultDesc.NUMBER_OF_PARAMETERS_NOT_MATCH_MSG;
            return iPCResult4;
        }
        Object[] objArr = new Object[parameterTypes.length];
        if (parameterTypes.length > 0) {
            try {
                if (iPCParameter.serType == 2) {
                    objArr[0] = iPCParameter.parcelable;
                } else {
                    for (int i = 0; i < parameterTypes.length; i++) {
                        objArr[i] = ObjSerializUtil.deserializ(list.get(i), parameterTypes[i].getClassLoader());
                    }
                }
            } catch (Exception e) {
                RVLogger.e("AriverKernel:RemoteCall", "LocalCallManagerImpl call Exception", e);
                IPCResult iPCResult5 = new IPCResult();
                iPCResult5.resultCode = 103;
                iPCResult5.resultMsg = "Param deserializ error. exception: " + e.getMessage();
                return iPCResult5;
            }
        }
        try {
            Object objInvoke = method.invoke(serviceBean, objArr);
            if (objInvoke == null) {
                RVLogger.d("AriverKernel:RemoteCall", "LocalCallManagerImpl invoke success, result is void");
                return new IPCResult();
            }
            IPCResult iPCResult6 = new IPCResult();
            iPCResult6.resultType = objInvoke.getClass().getName();
            if (objInvoke instanceof Parcelable) {
                iPCResult6.serType = (byte) 2;
                iPCResult6.parcelable = (Parcelable) objInvoke;
            } else {
                iPCResult6.resultValue = ObjSerializUtil.serializ((Serializable) objInvoke);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("LocalCallManagerImpl invoke success, result type = ");
            String str = iPCResult6.resultType;
            if (str == null) {
                str = "is null";
            }
            sb.append(str);
            RVLogger.d("AriverKernel:RemoteCall", sb.toString());
            return iPCResult6;
        } catch (Throwable th) {
            RVLogger.e("AriverKernel:RemoteCall", "LocalCallManager Exception", th);
            IPCResult iPCResult7 = new IPCResult();
            iPCResult7.resultCode = 104;
            iPCResult7.resultMsg = "Invoke method error. exception: " + th.getMessage();
            return iPCResult7;
        }
    }

    @Override // com.alibaba.ariver.kernel.ipc.uniform.LocalCallManager
    public void setLocalCallRetryHandler(LocalCallRetryHandler localCallRetryHandler) {
        this.localCallRetryHandler = localCallRetryHandler;
    }
}

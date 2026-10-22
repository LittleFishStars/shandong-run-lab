package com.alibaba.ariver.kernel.api.extension;

import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ExtensionOpt {
    public static final String TAG = "AriverKernel:ExtensionOpt";
    private static ExceptionHandler exceptionHandler;
    private static Map<Class<? extends Extension>, MethodInvokeOptimizer> methodInvokeOptMap = new ConcurrentHashMap();
    private static Map<Class<? extends Extension>, MethodInvokeOptimizer> bridgeInvokeOptMap = new ConcurrentHashMap();

    public interface ExceptionHandler {
        void reportException(Throwable th, String str, String str2, String str3, Map<String, String> map);

        boolean shouldThrowOut(Throwable th, String str, String str2);
    }

    public interface MethodInvokeOptimizer {
        Object doMethodInvoke(String str, Extension extension, Object[] objArr);
    }

    public static class MismatchMethodException extends Exception {
        public MismatchMethodException(String str) {
            super("mismatched method to invoke: " + str);
        }
    }

    public static void clearAllMethodInvokeOptimizer() {
        if (methodInvokeOptMap.size() > 0) {
            methodInvokeOptMap = new ConcurrentHashMap();
        }
        if (bridgeInvokeOptMap.size() > 0) {
            bridgeInvokeOptMap = new ConcurrentHashMap();
        }
        RVLogger.d(TAG, "clearAllMethodInvokeOptimizer");
    }

    public static MethodInvokeOptimizer getMethodInvokeOptimizer(Class<? extends Extension> cls, boolean z) {
        if (cls == null) {
            return null;
        }
        Map<Class<? extends Extension>, MethodInvokeOptimizer> map = z ? bridgeInvokeOptMap : methodInvokeOptMap;
        if (map.size() == 0) {
            return null;
        }
        return map.get(cls);
    }

    public static void reportException(Throwable th, String str, String str2, String str3, Map<String, String> map) {
        ExceptionHandler exceptionHandler2 = exceptionHandler;
        if (exceptionHandler2 == null) {
            return;
        }
        try {
            exceptionHandler2.reportException(th, str, str2, str3, map);
        } catch (Throwable th2) {
            RVLogger.e(TAG, "reportException, occur error: " + th2);
        }
    }

    public static void setupExceptionHandler(ExceptionHandler exceptionHandler2) {
        RVLogger.d(TAG, "setupExceptionHandler, old: " + exceptionHandler + ", new: " + exceptionHandler2);
        exceptionHandler = exceptionHandler2;
    }

    public static void setupMethodInvokeOptimizer(Class<? extends Extension> cls, MethodInvokeOptimizer methodInvokeOptimizer) {
        if (cls == null || methodInvokeOptimizer == null) {
            return;
        }
        if (methodInvokeOptMap.put(cls, methodInvokeOptimizer) != null) {
            RVLogger.d(TAG, "setupMethodInvokeOptimizer, duplicate: " + cls.getName());
            return;
        }
        RVLogger.d(TAG, "setupMethodInvokeOptimizer: " + cls.getName());
    }

    public static void setupMethodInvokeOptimizerForBridge(Class<? extends Extension> cls, MethodInvokeOptimizer methodInvokeOptimizer) {
        if (cls == null || methodInvokeOptimizer == null) {
            return;
        }
        if (bridgeInvokeOptMap.put(cls, methodInvokeOptimizer) != null) {
            RVLogger.d(TAG, "setupMethodInvokeOptimizerForBridge, duplicate: " + cls.getName());
            return;
        }
        RVLogger.d(TAG, "setupMethodInvokeOptimizerForBridge: " + cls.getName());
    }

    public static boolean shouldThrowOut(Throwable th, String str, String str2) {
        boolean z = "doMethodInvoke".equals(str) && "FinalCatch".equals(str2);
        RVLogger.d(TAG, "shouldThrowOut, t: " + th + ", s: " + str + ", f: " + str2 + ", r: " + z);
        return z;
    }
}

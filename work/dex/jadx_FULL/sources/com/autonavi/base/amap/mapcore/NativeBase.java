package com.autonavi.base.amap.mapcore;

import com.autonavi.base.amap.mapcore.annotations.ParameterIsClass;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class NativeBase {
    private static final String CREATE_OVERLAY = "createOverlay";
    private static final int STACK_NUMBER = 3;
    private static final String UPDATE_OPTIONS = "updateOptions";
    private boolean mCalledFuntion = false;
    protected boolean useRunnable = true;
    protected volatile boolean destroy = false;
    ArrayList<Method> methodMap = new ArrayList<>();
    ArrayList<Runnable> runnableArrayList = new ArrayList<>();

    public static class Method {
        private boolean baseClass;
        private Class<?>[] clazz;
        private String methodName;
        private Object object;
        private Object[] param;

        public Method(Object obj, String str, boolean z, Object... objArr) {
            this.object = obj;
            this.methodName = str;
            this.baseClass = z;
            if (objArr != null) {
                try {
                    if (objArr.length > 0) {
                        this.clazz = new Class[objArr.length];
                        if ((NativeBase.CREATE_OVERLAY.equals(str) || NativeBase.UPDATE_OPTIONS.equals(str)) ? true : z) {
                            for (int i = 0; i < objArr.length; i++) {
                                if (i == 1) {
                                    this.clazz[i] = objArr[i].getClass().getSuperclass();
                                } else {
                                    this.clazz[i] = objArr[i].getClass();
                                }
                            }
                        } else {
                            for (int i2 = 0; i2 < objArr.length; i2++) {
                                this.clazz[i2] = objArr[i2].getClass();
                            }
                        }
                        this.param = new Object[objArr.length];
                        for (int i3 = 0; i3 < objArr.length; i3++) {
                            this.param[i3] = objArr[i3];
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public synchronized void callAllFunction() {
        java.lang.reflect.Method declaredMethod;
        if (isReady() && !this.destroy) {
            if (this.mCalledFuntion) {
                return;
            }
            try {
                this.mCalledFuntion = true;
                if (this.useRunnable) {
                    while (this.runnableArrayList.size() > 0 && !this.destroy) {
                        Runnable runnable = this.runnableArrayList.get(0);
                        if (runnable != null) {
                            runnable.run();
                        }
                        this.runnableArrayList.remove(0);
                    }
                    return;
                }
                for (Method method : this.methodMap) {
                    try {
                        if (this.destroy) {
                            break;
                        }
                        if (method.object != null && (declaredMethod = method.object.getClass().getDeclaredMethod(method.methodName, method.clazz)) != null) {
                            declaredMethod.setAccessible(true);
                            declaredMethod.invoke(method.object, method.param);
                        }
                    } catch (Throwable unused) {
                    }
                }
                this.methodMap.clear();
            } catch (Throwable unused2) {
            }
        }
    }

    public abstract void createNative();

    public void destroy() {
        this.destroy = true;
        synchronized (this) {
            this.runnableArrayList.clear();
            this.methodMap.clear();
        }
    }

    public void finalize() throws Throwable {
        super.finalize();
        try {
            finalizeNative();
        } catch (Throwable th) {
            th.toString();
        }
    }

    public abstract void finalizeNative();

    public abstract long getNative();

    public boolean isReady() {
        return getNative() != 0;
    }

    public synchronized void storeUncallFunction(Object obj, Object obj2, Object... objArr) {
        try {
            if (!this.useRunnable || obj2 == null) {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                if (stackTrace != null && stackTrace.length >= 3) {
                    this.methodMap.add(new Method(obj, stackTrace[3].getMethodName(), false, objArr));
                }
            } else {
                synchronized (this.runnableArrayList) {
                    this.runnableArrayList.add((Runnable) obj2);
                }
            }
            this.mCalledFuntion = false;
        } catch (Throwable unused) {
        }
    }

    public synchronized void storeUncallFunctionArray(Object obj, Object obj2, Object[] objArr) {
        try {
            if (!this.useRunnable || obj2 == null) {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                if (stackTrace != null && stackTrace.length >= 3) {
                    this.methodMap.add(new Method(obj, stackTrace[3].getMethodName(), false, objArr));
                }
            } else {
                synchronized (this.runnableArrayList) {
                    this.runnableArrayList.add((Runnable) obj2);
                }
            }
            this.mCalledFuntion = false;
        } catch (Throwable unused) {
        }
    }

    public void validate() {
        ParameterIsClass parameterIsClass;
        Class<?>[] parameterTypes;
        java.lang.reflect.Method[] methods = getClass().getMethods();
        if (methods == null) {
            return;
        }
        for (java.lang.reflect.Method method : methods) {
            if (method.isAnnotationPresent(ParameterIsClass.class) && (parameterIsClass = (ParameterIsClass) method.getAnnotation(ParameterIsClass.class)) != null && parameterIsClass.required() && (parameterTypes = method.getParameterTypes()) != null) {
                for (Class<?> cls : parameterTypes) {
                    if (!(cls instanceof Object)) {
                        throw new RuntimeException("函数：" + method + " 参数不是对象类型");
                    }
                }
            }
        }
    }
}

package com.kc.bw.hiddenapibypass;

import android.os.Build;
import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import dalvik.system.VMRuntime;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class HiddenApiBypass {
    public static final boolean $assertionsDisabled = false;
    public static final int SDK_INIT;
    public static final int SDK_VERSION_CODE_P = 28;
    public static final String TAG = "hidden-api";
    public static long artFieldBias = 0;
    public static long artFieldSize = 0;
    public static long artMethodBias = 0;
    public static long artMethodSize = 0;
    public static long artOffset = 0;
    public static long classOffset = 0;
    public static boolean enableLog = false;
    public static long iFieldOffset = 0;
    public static boolean initSuccess = false;
    public static long methodOffset;
    public static long methodsOffset;
    public static long sFieldOffset;
    public static Unsafe unsafe;

    static {
        boolean z;
        long jObjectFieldOffset;
        long jObjectFieldOffset2;
        String str;
        int i = Build.VERSION.SDK_INT;
        SDK_INIT = i;
        try {
            if (i >= 28) {
                try {
                    unsafe = (Unsafe) Unsafe.class.getDeclaredMethod("getUnsafe", new Class[0]).invoke(null, new Object[0]);
                    CoreOjClassLoader coreOjClassLoader = new CoreOjClassLoader();
                    Class<?> clsLoadClass = coreOjClassLoader.loadClass(Executable.class.getName());
                    Class<?> clsLoadClass2 = coreOjClassLoader.loadClass(MethodHandle.class.getName());
                    Class<?> clsLoadClass3 = coreOjClassLoader.loadClass(Class.class.getName());
                    methodOffset = unsafe.objectFieldOffset(clsLoadClass.getDeclaredField("artMethod"));
                    classOffset = unsafe.objectFieldOffset(clsLoadClass.getDeclaredField("declaringClass"));
                    artOffset = unsafe.objectFieldOffset(clsLoadClass2.getDeclaredField("artFieldOrMethod"));
                    try {
                        jObjectFieldOffset = unsafe.objectFieldOffset(clsLoadClass3.getDeclaredField("fields"));
                        jObjectFieldOffset2 = jObjectFieldOffset;
                    } catch (NoSuchFieldException unused) {
                        jObjectFieldOffset = unsafe.objectFieldOffset(clsLoadClass3.getDeclaredField("iFields"));
                        jObjectFieldOffset2 = unsafe.objectFieldOffset(clsLoadClass3.getDeclaredField("sFields"));
                    }
                    iFieldOffset = jObjectFieldOffset;
                    sFieldOffset = jObjectFieldOffset2;
                    methodsOffset = unsafe.objectFieldOffset(clsLoadClass3.getDeclaredField("methods"));
                    Method declaredMethod = Helper.NeverCall.class.getDeclaredMethod("a", new Class[0]);
                    Method declaredMethod2 = Helper.NeverCall.class.getDeclaredMethod("b", new Class[0]);
                    declaredMethod.setAccessible(true);
                    declaredMethod2.setAccessible(true);
                    MethodHandle methodHandleUnreflect = MethodHandles.lookup().unreflect(declaredMethod);
                    MethodHandle methodHandleUnreflect2 = MethodHandles.lookup().unreflect(declaredMethod2);
                    long j = unsafe.getLong(methodHandleUnreflect, artOffset);
                    long j2 = unsafe.getLong(methodHandleUnreflect2, artOffset);
                    long j3 = unsafe.getLong(Helper.NeverCall.class, methodsOffset);
                    artMethodSize = j2 - j;
                    if (enableLog) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(artMethodSize);
                        sb.append(" ");
                        sb.append(Long.toString(j, 16));
                        sb.append(", ");
                        sb.append(Long.toString(j2, 16));
                        sb.append(", ");
                        sb.append(Long.toString(j3, 16));
                        Log.v("hidden-api", sb.toString());
                    }
                    artMethodBias = (j - j3) - artMethodSize;
                    Field declaredField = Helper.NeverCall.class.getDeclaredField("i");
                    Field declaredField2 = Helper.NeverCall.class.getDeclaredField("j");
                    declaredField.setAccessible(true);
                    declaredField2.setAccessible(true);
                    MethodHandle methodHandleUnreflectGetter = MethodHandles.lookup().unreflectGetter(declaredField);
                    MethodHandle methodHandleUnreflectGetter2 = MethodHandles.lookup().unreflectGetter(declaredField2);
                    long j4 = unsafe.getLong(methodHandleUnreflectGetter, artOffset);
                    long j5 = unsafe.getLong(methodHandleUnreflectGetter2, artOffset);
                    long j6 = unsafe.getLong(Helper.NeverCall.class, iFieldOffset);
                    artFieldSize = j5 - j4;
                    if (enableLog) {
                        Log.v("hidden-api", artFieldSize + " " + Long.toString(j4, 16) + ", " + Long.toString(j5, 16) + ", " + Long.toString(j6, 16));
                    }
                    artFieldBias = j4 - j6;
                    initSuccess = true;
                    str = "hidden true";
                } catch (Throwable th) {
                    th = th;
                    z = false;
                    initSuccess = z;
                    unsafe = null;
                    methodOffset = 0L;
                    classOffset = 0L;
                    artOffset = 0L;
                    methodsOffset = 0L;
                    iFieldOffset = 0L;
                    sFieldOffset = 0L;
                    artMethodSize = 0L;
                    artMethodBias = 0L;
                    artFieldSize = 0L;
                    artFieldBias = 0L;
                    Log.w("hidden-api", "Initialize error " + th);
                    return;
                }
            } else {
                str = "[" + i + "]ignore do hidden api exemptions";
            }
            Log.w("hidden-api", str);
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
    }

    public static boolean addHiddenApiExemptions(String... strArr) {
        if (initSuccess && SDK_INIT >= 28) {
            Set<String> set = Helper.signaturePrefixes;
            set.addAll(Arrays.asList(strArr));
            String[] strArr2 = new String[set.size()];
            set.toArray(strArr2);
            return setHiddenApiExemptions(strArr2);
        }
        Log.w("hidden-api", "[" + SDK_INIT + "]ignore addHiddenApiExemptions");
        return false;
    }

    public static boolean clearHiddenApiExemptions() {
        if (initSuccess && SDK_INIT >= 28) {
            Helper.signaturePrefixes.clear();
            return setHiddenApiExemptions(new String[0]);
        }
        Log.w("hidden-api", "[" + SDK_INIT + "]ignore clearHiddenApiExemptions");
        return false;
    }

    public static Constructor<?> getDeclaredConstructor(Class<?> cls, Class<?>... clsArr) throws NoSuchMethodException {
        if (initSuccess && SDK_INIT >= 28) {
            for (Executable executable : getDeclaredMethods(cls)) {
                if (executable instanceof Constructor) {
                    int i = 0;
                    Class<?>[] parameterTypes = new Class[0];
                    if (SDK_INIT >= 28) {
                        parameterTypes = executable.getParameterTypes();
                    }
                    if (parameterTypes.length == clsArr.length) {
                        while (true) {
                            if (i >= clsArr.length) {
                                if (SDK_INIT < 28) {
                                    break;
                                }
                                return (Constructor) executable;
                            }
                            if (clsArr[i] != parameterTypes[i]) {
                                break;
                            }
                            i++;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        Log.w("hidden-api", "[" + SDK_INIT + "]ignore getDeclaredConstructor");
        throw new NoSuchMethodException("Cannot find matching constructor");
    }

    public static Method getDeclaredMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        if (initSuccess && SDK_INIT >= 28) {
            for (Executable executable : getDeclaredMethods(cls)) {
                int i = SDK_INIT;
                if (i < 28 || executable.getName().equals(str)) {
                    if (executable instanceof Method) {
                        int i2 = 0;
                        Class<?>[] parameterTypes = new Class[0];
                        if (i >= 28) {
                            parameterTypes = executable.getParameterTypes();
                        }
                        if (parameterTypes.length == clsArr.length) {
                            while (true) {
                                if (i2 >= clsArr.length) {
                                    if (SDK_INIT < 28) {
                                        break;
                                    }
                                    return (Method) executable;
                                }
                                if (clsArr[i2] != parameterTypes[i2]) {
                                    break;
                                }
                                i2++;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        Log.w("hidden-api", "[" + SDK_INIT + "]ignore getDeclaredMethod");
        throw new NoSuchMethodException("Cannot find matching method");
    }

    public static List<Executable> getDeclaredMethods(Class<?> cls) {
        int i;
        int i2 = 0;
        List<Executable> listAsList = Arrays.asList(new Executable[0]);
        if (!initSuccess || (i = SDK_INIT) < 28) {
            Log.w("hidden-api", "[" + SDK_INIT + "]ignore getDeclaredMethods");
            return listAsList;
        }
        if (!cls.isPrimitive() && !cls.isArray()) {
            try {
                Method declaredMethod = Helper.NeverCall.class.getDeclaredMethod("a", new Class[0]);
                declaredMethod.setAccessible(true);
                MethodHandle methodHandleUnreflect = i >= 26 ? MethodHandles.lookup().unreflect(declaredMethod) : null;
                long j = unsafe.getLong(cls, methodsOffset);
                if (j == 0) {
                    return listAsList;
                }
                int i3 = unsafe.getInt(j);
                if (enableLog) {
                    Log.d("hidden-api", cls + " has " + i3 + " methods");
                }
                ArrayList arrayList = new ArrayList(i3);
                while (i2 < i3) {
                    long j2 = j;
                    unsafe.putLong(methodHandleUnreflect, artOffset, artMethodBias + (((long) i2) * artMethodSize) + j);
                    int i4 = SDK_INIT;
                    Executable executable = i4 >= 26 ? (Executable) MethodHandles.reflectAs(Executable.class, methodHandleUnreflect) : null;
                    if (enableLog && i4 >= 28) {
                        Log.v("hidden-api", "got " + cls.getTypeName() + Consts.DOT + executable.getName() + "(" + ((String) Arrays.stream(executable.getParameterTypes()).map(new HiddenApiBypass$$ExternalSyntheticLambda0()).collect(Collectors.joining())) + ")");
                    }
                    arrayList.add(executable);
                    i2++;
                    j = j2;
                }
                return arrayList;
            } catch (Throwable unused) {
            }
        }
        return listAsList;
    }

    public static List<Field> getInstanceFields(Class<?> cls) {
        int i;
        List<Field> listAsList = Arrays.asList(new Field[0]);
        if (!initSuccess || (i = SDK_INIT) < 28) {
            Log.w("hidden-api", "[" + SDK_INIT + "]ignore getInstanceFields");
            return listAsList;
        }
        if (!cls.isPrimitive() && !cls.isArray()) {
            try {
                Field declaredField = Helper.NeverCall.class.getDeclaredField("i");
                declaredField.setAccessible(true);
                MethodHandle methodHandleUnreflectGetter = i >= 26 ? MethodHandles.lookup().unreflectGetter(declaredField) : null;
                long j = unsafe.getLong(cls, iFieldOffset);
                if (j == 0) {
                    return listAsList;
                }
                int i2 = unsafe.getInt(j);
                if (enableLog) {
                    Log.d("hidden-api", cls + " has " + i2 + " fields");
                }
                ArrayList arrayList = new ArrayList(i2);
                for (int i3 = 0; i3 < i2; i3++) {
                    unsafe.putLong(methodHandleUnreflectGetter, artOffset, artFieldBias + (((long) i3) * artFieldSize) + j);
                    int i4 = SDK_INIT;
                    Field field = i4 >= 28 ? (Field) MethodHandles.reflectAs(Field.class, methodHandleUnreflectGetter) : null;
                    if (enableLog && i4 >= 28) {
                        Log.v("hidden-api", "got " + field.getType() + " " + cls.getTypeName() + Consts.DOT + field.getName());
                    }
                    if (!Modifier.isStatic(field.getModifiers())) {
                        arrayList.add(field);
                    }
                }
                return arrayList;
            } catch (Throwable unused) {
            }
        }
        return listAsList;
    }

    public static List<Field> getStaticFields(Class<?> cls) {
        int i;
        List<Field> listAsList = Arrays.asList(new Field[0]);
        if (!initSuccess || (i = SDK_INIT) < 28) {
            Log.w("hidden-api", "[" + SDK_INIT + "]ignore getStaticFields");
            return listAsList;
        }
        if (!cls.isPrimitive() && !cls.isArray()) {
            try {
                Field declaredField = Helper.NeverCall.class.getDeclaredField("s");
                declaredField.setAccessible(true);
                MethodHandle methodHandleUnreflectGetter = i >= 26 ? MethodHandles.lookup().unreflectGetter(declaredField) : null;
                long j = unsafe.getLong(cls, sFieldOffset);
                if (j == 0) {
                    return listAsList;
                }
                int i2 = unsafe.getInt(j);
                if (enableLog) {
                    Log.d("hidden-api", cls + " has " + i2 + " fields");
                }
                ArrayList arrayList = new ArrayList(i2);
                for (int i3 = 0; i3 < i2; i3++) {
                    unsafe.putLong(methodHandleUnreflectGetter, artOffset, artFieldBias + (((long) i3) * artFieldSize) + j);
                    int i4 = SDK_INIT;
                    Field field = i4 >= 28 ? (Field) MethodHandles.reflectAs(Field.class, methodHandleUnreflectGetter) : null;
                    if (enableLog && i4 >= 28) {
                        Log.v("hidden-api", "got " + field.getType() + " " + cls.getTypeName() + Consts.DOT + field.getName());
                    }
                    if (Modifier.isStatic(field.getModifiers())) {
                        arrayList.add(field);
                    }
                }
                return arrayList;
            } catch (Throwable unused) {
            }
        }
        return listAsList;
    }

    public static Object invoke(Class<?> cls, Object obj, String str, Object... objArr) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (initSuccess && SDK_INIT >= 28) {
            if (obj != null && !cls.isInstance(obj)) {
                throw new IllegalArgumentException("this object is not an instance of the given class");
            }
            int i = 0;
            Method declaredMethod = Helper.InvokeStub.class.getDeclaredMethod(BridgeDSL.INVOKE, Object[].class);
            declaredMethod.setAccessible(true);
            long j = unsafe.getLong(cls, methodsOffset);
            if (j == 0) {
                throw new NoSuchMethodException("Cannot find matching method");
            }
            int i2 = unsafe.getInt(j);
            if (enableLog) {
                Log.d("hidden-api", cls + " has " + i2 + " methods");
            }
            while (i < i2) {
                long j2 = j;
                unsafe.putLong(declaredMethod, methodOffset, (((long) i) * artMethodSize) + j + artMethodBias);
                if (enableLog && SDK_INIT >= 28) {
                    Log.v("hidden-api", "got " + cls.getTypeName() + Consts.DOT + declaredMethod.getName() + "(" + ((String) Arrays.stream(declaredMethod.getParameterTypes()).map(new HiddenApiBypass$$ExternalSyntheticLambda0()).collect(Collectors.joining())) + ")");
                }
                if (str.equals(declaredMethod.getName()) && Helper.checkArgsForInvokeMethod(declaredMethod.getParameterTypes(), objArr)) {
                    return declaredMethod.invoke(obj, objArr);
                }
                i++;
                j = j2;
            }
        }
        Log.w("hidden-api", "[" + SDK_INIT + "]ignore invoke");
        throw new NoSuchMethodException("Cannot find matching method");
    }

    public static Object newInstance(Class<?> cls, Object... objArr) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        if (initSuccess && SDK_INIT >= 28) {
            Method declaredMethod = Helper.InvokeStub.class.getDeclaredMethod(BridgeDSL.INVOKE, Object[].class);
            Constructor declaredConstructor = Helper.InvokeStub.class.getDeclaredConstructor(Object[].class);
            declaredConstructor.setAccessible(true);
            long j = unsafe.getLong(cls, methodsOffset);
            if (j == 0) {
                throw new NoSuchMethodException("Cannot find matching constructor");
            }
            int i = unsafe.getInt(j);
            if (enableLog) {
                Log.d("hidden-api", cls + " has " + i + " methods");
            }
            for (int i2 = 0; i2 < i; i2++) {
                long j2 = (((long) i2) * artMethodSize) + j + artMethodBias;
                unsafe.putLong(declaredMethod, methodOffset, j2);
                if (enableLog && SDK_INIT >= 28) {
                    Log.v("hidden-api", "got " + cls.getTypeName() + Consts.DOT + declaredMethod.getName() + "(" + ((String) Arrays.stream(declaredMethod.getParameterTypes()).map(new HiddenApiBypass$$ExternalSyntheticLambda0()).collect(Collectors.joining())) + ")");
                }
                if ("<init>".equals(declaredMethod.getName())) {
                    unsafe.putLong(declaredConstructor, methodOffset, j2);
                    unsafe.putObject(declaredConstructor, classOffset, cls);
                    if (Helper.checkArgsForInvokeMethod(declaredConstructor.getParameterTypes(), objArr)) {
                        return declaredConstructor.newInstance(objArr);
                    }
                }
            }
        }
        Log.w("hidden-api", "[" + SDK_INIT + "]ignore newInstance");
        throw new NoSuchMethodException("Cannot find matching constructor");
    }

    public static boolean setHiddenApiExemptions(String... strArr) {
        String str;
        if (!initSuccess || SDK_INIT < 28) {
            str = "[" + SDK_INIT + "]ignore setHiddenApiExemptions";
        } else {
            try {
                invoke(VMRuntime.class, invoke(VMRuntime.class, null, "getRuntime", new Object[0]), "setHiddenApiExemptions", strArr);
                return true;
            } catch (Throwable th) {
                str = "setHiddenApiExemptions " + Log.getStackTraceString(th);
            }
        }
        Log.w("hidden-api", str);
        return false;
    }
}

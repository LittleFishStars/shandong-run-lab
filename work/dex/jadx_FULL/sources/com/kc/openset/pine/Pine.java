package com.kc.openset.pine;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.pine.callback.MethodHook;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final class Pine {
    static final boolean $assertionsDisabled = false;
    private static final int ARCH_ARM = 1;
    private static final int ARCH_ARM64 = 2;
    private static final int ARCH_X86 = 3;
    public static final Object[] EMPTY_OBJECT_ARRAY;
    private static final String TAG = OSETSDKProtected.getString2(2005);
    private static int arch;
    public static long closeElf;
    public static long findElfSymbol;
    public static long getMethodDeclaringClass;
    private static volatile int hookMode;
    private static volatile boolean initialized;
    public static long openElf;
    public static long resumeVM;
    private static final Map<String, Method> sBridgeMethods;
    private static HookHandler sHookHandler;
    private static HookListener sHookListener;
    private static final Object sHookLock;
    private static final Map<Long, HookRecord> sHookRecords;
    public static long suspendVM;
    public static long syncMethodEntry;

    @Keep
    public static class CallFrame {
        public Object[] args;
        private HookRecord hookRecord;
        public final Member method;
        private Object result;
        boolean returnEarly;
        public Object thisObject;
        private Throwable throwable;

        static {
            OSETSDKProtected.interface11(4566);
        }

        public CallFrame(HookRecord hookRecord, Object obj, Object[] objArr) {
            this.hookRecord = hookRecord;
            this.method = hookRecord.target;
            this.thisObject = obj;
            this.args = objArr;
        }

        public native Object getResult();

        public native Object getResultOrThrowable() throws Throwable;

        public native Throwable getThrowable();

        public native boolean hasThrowable();

        public native Object invokeOriginalMethod() throws IllegalAccessException, InvocationTargetException;

        public native Object invokeOriginalMethod(Object obj, Object... objArr) throws IllegalAccessException, InvocationTargetException;

        public native void resetResult();

        public native void setResult(Object obj);

        public native void setResultIfNoException(Object obj);

        public native void setThrowable(Throwable th);
    }

    @Keep
    public interface HookHandler {
        MethodHook.Unhook handleHook(HookRecord hookRecord, MethodHook methodHook, int i, boolean z, boolean z2);

        void handleUnhook(HookRecord hookRecord, MethodHook methodHook);
    }

    @Keep
    public interface HookListener {
        void afterHook(Member member, MethodHook.Unhook unhook);

        void beforeHook(Member member, MethodHook methodHook);
    }

    @Keep
    public interface HookMode {
        public static final int AUTO = 0;

        @Deprecated
        public static final int INLINE = 1;
        public static final int INLINE_WITHOUT_JIT = 3;
        public static final int REPLACEMENT = 2;
    }

    @Keep
    public static final class HookRecord {
        public final long artMethod;
        public Method backup;
        public Method bridge;
        private Set<MethodHook> callbacks = new HashSet();
        public boolean isStatic;
        public int paramNumber;
        public Class<?>[] paramTypes;
        public volatile Object paramTypesCache;
        public boolean skipUpdateDeclaringClass;
        public final Member target;
        public long trampoline;

        static {
            OSETSDKProtected.interface11(4570);
        }

        public HookRecord(Member member, long j) {
            this.target = member;
            this.artMethod = j;
        }

        public native void addCallback(MethodHook methodHook);

        public native Object callBackup(Object obj, Object... objArr) throws IllegalAccessException, InvocationTargetException;

        public native boolean emptyCallbacks();

        public native MethodHook[] getCallbacks();

        public native boolean isPending();

        public native void removeCallback(MethodHook methodHook);
    }

    @Keep
    public interface LibLoader {
        void loadLib();
    }

    static {
        OSETSDKProtected.interface11(4572);
        EMPTY_OBJECT_ARRAY = new Object[0];
        sBridgeMethods = new HashMap(8, 2.0f);
        sHookRecords = new ConcurrentHashMap();
        sHookLock = new Object();
        sHookHandler = new HookHandler() { // from class: com.kc.openset.pine.Pine.1
            static {
                OSETSDKProtected.interface11(4565);
            }

            @Override // com.kc.openset.pine.Pine.HookHandler
            public native MethodHook.Unhook handleHook(HookRecord hookRecord, MethodHook methodHook, int i, boolean z, boolean z2);

            @Override // com.kc.openset.pine.Pine.HookHandler
            public native void handleUnhook(HookRecord hookRecord, MethodHook methodHook);
        };
    }

    private Pine() {
        throw new RuntimeException(OSETSDKProtected.getString2(2006));
    }

    public static native Object callBackupMethod(HookRecord hookRecord, Object obj, Object[] objArr) throws IllegalAccessException, InvocationTargetException;

    public static native long cloneExtras(long j);

    public static native boolean compile(Member member);

    private static native boolean compile0(long j, Member member);

    public static native long currentArtThread0();

    public static native boolean decompile(Member member, boolean z);

    private static native boolean decompile0(Member member, boolean z);

    public static native void disableHiddenApiPolicy(boolean z, boolean z2);

    private static native void disableHiddenApiPolicy0(boolean z, boolean z2);

    @Deprecated
    public static native boolean disableJitInline();

    private static native boolean disableJitInline0();

    public static native boolean disableProfileSaver();

    private static native boolean disableProfileSaver0();

    private static native void enableFastNative();

    public static native void ensureInitialized();

    public static native long getAddress(long j, Object obj);

    private static native long getAddress0(long j, Object obj);

    public static native void getArgsArm32(int i, int i2, int[] iArr, int[] iArr2, float[] fArr);

    public static native void getArgsArm64(long j, long j2, boolean[] zArr, long[] jArr, long[] jArr2, double[] dArr);

    public static native void getArgsX86(int i, int[] iArr, int i2);

    public static native long getArtMethod(Member member);

    public static native HookHandler getHookHandler();

    public static native HookListener getHookListener();

    public static native int getHookMode();

    public static native HookRecord getHookRecord(long j);

    public static native Object getObject(long j, long j2);

    private static native Object getObject0(long j, long j2);

    public static native Object handleCall(HookRecord hookRecord, Object obj, Object[] objArr) throws Throwable;

    public static native MethodHook.Unhook hook(Member member, MethodHook methodHook);

    public static native MethodHook.Unhook hook(Member member, MethodHook methodHook, boolean z);

    private static native Method hook0(long j, Class<?> cls, HookRecord hookRecord, Member member, Method method, boolean z, boolean z2, boolean z3);

    public static native void hookNewMethod(HookRecord hookRecord, int i, boolean z);

    public static native Method hookReplace(HookRecord hookRecord, Method method, Method method2, boolean z);

    private static native Method hookReplace0(long j, Class<?> cls, HookRecord hookRecord, Member member, Method method, Method method2, boolean z, boolean z2, boolean z3);

    private static native void init0(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5);

    private static native void initBridgeMethods();

    private static native void initialize();

    public static native Object invokeOriginalMethod(Member member, Object obj, Object... objArr) throws IllegalAccessException, InvocationTargetException;

    public static native boolean is64Bit();

    public static native boolean isHooked(Member member);

    public static native boolean isInitialized();

    public static native void log(String str);

    public static native void log(String str, Object... objArr);

    private static native void makeClassesVisiblyInitialized(long j);

    public static native void requestError(String str);

    public static native void requestError(String str, Throwable th);

    public static native void requestError(Throwable th);

    private static native void resolve(Method method);

    public static native void setDebuggable(boolean z);

    private static native void setDebuggable0(boolean z);

    public static native void setHookHandler(HookHandler hookHandler);

    public static native void setHookListener(HookListener hookListener);

    public static native void setHookMode(int i);

    public static native void setJitCompilationAllowed(boolean z);

    public static native void setJitCompilationAllowed(boolean z, boolean z2);

    private static native void setJitCompilationAllowed0(boolean z, boolean z2);

    private static native void syncMethodInfo(Member member, Method method, boolean z);
}

package com.kwad.sdk.crash.utils;

import android.os.Build;
import androidx.annotation.Keep;
import com.kwad.sdk.crash.model.message.FastUnwindBackTraceElement;
import com.kwad.sdk.crash.model.message.FastUnwindBacktrace;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class BacktraceUtil {
    private static boolean sIsInit = false;
    private static FastUnwindBackTraceElement sNativePollOnceElement;
    private static final Set<FastUnwindBackTraceElement> sUnwindSet = new CopyOnWriteArraySet();
    private static final Set<FastUnwindBackTraceElement> sIgnoreSet = new CopyOnWriteArraySet();
    private static final Map<Long, Integer> sThreadIdMap = new HashMap();

    public static class ThreadStateAndLockInfo implements Serializable {
        public static final String STATE_BLOCKED = "Blocked";
        public static final String STATE_WAITING_FOR_LOCK_INFLATION = "WaitingForLockInflation";
        public String lockClassName;
        public String threadState;
        public int tid;
        public long updateTime;

        public boolean isBlock() {
            return this.threadState.equals(STATE_BLOCKED) || this.threadState.equals(STATE_WAITING_FOR_LOCK_INFLATION);
        }
    }

    private static native FastUnwindBackTraceElement[] FrameInfoToNativeTrace(String str);

    private static native StackTraceElement[] FrameInfoToTrace(String str);

    private static native String GetThreadFrameInfo(Object obj, boolean z, boolean z2, boolean z3);

    private static native int GetThreadNativeTid(Thread thread);

    private static native void HookLogMessage();

    private static native void HookUnwind();

    private static native int InitUtil();

    private static native boolean UnwindTraceElement(FastUnwindBackTraceElement fastUnwindBackTraceElement);

    public static Object[] backtraceInfoToArrays(FastUnwindBacktrace fastUnwindBacktrace) {
        ArrayList arrayList = new ArrayList();
        if (fastUnwindBacktrace != null) {
            arrayList.addAll(fastUnwindBacktrace.backtraces);
        }
        return arrayList.toArray();
    }

    public static Object[] frameInfoToTraceElements(String str) {
        StackTraceElement[] stackTraceElementArrFrameInfoToTrace = FrameInfoToTrace(str);
        if (stackTraceElementArrFrameInfoToTrace == null) {
            return new StackTraceElement[0];
        }
        ArrayList arrayList = new ArrayList();
        FastUnwindBackTraceElement[] fastUnwindBackTraceElementArrFrameInfoToNativeTrace = FrameInfoToNativeTrace(str);
        if (fastUnwindBackTraceElementArrFrameInfoToNativeTrace != null) {
            for (FastUnwindBackTraceElement fastUnwindBackTraceElement : fastUnwindBackTraceElementArrFrameInfoToNativeTrace) {
                if (fastUnwindBackTraceElement.hasUnwind) {
                    arrayList.add(fastUnwindBackTraceElement);
                }
            }
        }
        for (StackTraceElement stackTraceElement : stackTraceElementArrFrameInfoToTrace) {
            if (stackTraceElement.getMethodName() != null && !stackTraceElement.getMethodName().isEmpty()) {
                arrayList.add(stackTraceElement);
            }
        }
        return arrayList.toArray();
    }

    public static String getThreadFrameInfo(Thread thread, Boolean bool) {
        Boolean bool2 = Boolean.TRUE;
        return getThreadFrameInfo(thread, bool, bool2, bool2);
    }

    public static int getThreadNativeTid(Thread thread) {
        Map<Long, Integer> map = sThreadIdMap;
        if (map.containsKey(Long.valueOf(thread.getId()))) {
            return map.get(Long.valueOf(thread.getId())).intValue();
        }
        int iGetThreadNativeTid = GetThreadNativeTid(thread);
        map.put(Long.valueOf(thread.getId()), Integer.valueOf(iGetThreadNativeTid));
        return iGetThreadNativeTid;
    }

    public static ThreadStateAndLockInfo getThreadStateAndLockInfo(FastUnwindBacktrace fastUnwindBacktrace) {
        if (fastUnwindBacktrace == null || fastUnwindBacktrace.threadDumpStr.isEmpty()) {
            return null;
        }
        if (fastUnwindBacktrace.threadStateStr.isEmpty()) {
            String strSubstring = fastUnwindBacktrace.threadDumpStr.substring(0, fastUnwindBacktrace.threadDumpStr.indexOf(",Thread"));
            fastUnwindBacktrace.threadStateStr = strSubstring.substring(strSubstring.lastIndexOf(",") + 1);
        }
        ThreadStateAndLockInfo threadStateAndLockInfo = new ThreadStateAndLockInfo();
        threadStateAndLockInfo.threadState = fastUnwindBacktrace.threadStateStr;
        if (Build.VERSION.SDK_INT >= 28) {
            threadStateAndLockInfo.tid = fastUnwindBacktrace.threadId;
            threadStateAndLockInfo.lockClassName = fastUnwindBacktrace.lockType;
        } else {
            String[] strArrSplit = fastUnwindBacktrace.lockMsg.split("held by thread");
            try {
                threadStateAndLockInfo.tid = Integer.parseInt(strArrSplit[strArrSplit.length - 1].trim());
                threadStateAndLockInfo.threadState = ThreadStateAndLockInfo.STATE_BLOCKED;
                int iIndexOf = fastUnwindBacktrace.lockMsg.indexOf("(a ") + 3;
                int iIndexOf2 = fastUnwindBacktrace.lockMsg.indexOf(")");
                if (iIndexOf > 0 && iIndexOf2 > iIndexOf) {
                    threadStateAndLockInfo.lockClassName = fastUnwindBacktrace.lockMsg.substring(iIndexOf, iIndexOf2);
                }
            } catch (Exception unused) {
            }
        }
        return threadStateAndLockInfo;
    }

    public static void hookLogMessage() {
        HookLogMessage();
    }

    public static void hookUnwind() {
        HookUnwind();
    }

    public static int init() {
        int iInitUtil = InitUtil();
        sIsInit = true;
        return iInitUtil;
    }

    public static boolean isNativePollOnce(FastUnwindBacktrace fastUnwindBacktrace) {
        if (fastUnwindBacktrace == null || fastUnwindBacktrace.backtraces.isEmpty()) {
            return false;
        }
        for (FastUnwindBackTraceElement fastUnwindBackTraceElement : fastUnwindBacktrace.backtraces) {
            if (!fastUnwindBackTraceElement.isNative) {
                FastUnwindBackTraceElement fastUnwindBackTraceElement2 = sNativePollOnceElement;
                if (fastUnwindBackTraceElement2 != null) {
                    return fastUnwindBackTraceElement2.equals(fastUnwindBackTraceElement);
                }
                if (!unwindTraceElement(fastUnwindBackTraceElement) || !fastUnwindBackTraceElement.declaringClass.equals("android.os.MessageQueue") || !fastUnwindBackTraceElement.methodName.equals("nativePollOnce") || fastUnwindBackTraceElement.lineNumber != -2) {
                    return false;
                }
                sNativePollOnceElement = FastUnwindBackTraceElement.obtainFastUnwindBackTraceElement(fastUnwindBackTraceElement);
                return true;
            }
        }
        return false;
    }

    private static int objArrayRealSize(Object[] objArr) {
        for (int length = objArr.length - 1; length > 0; length--) {
            if (objArr[length] != null) {
                return length + 1;
            }
        }
        return 0;
    }

    public static boolean unwindTraceElement(FastUnwindBackTraceElement fastUnwindBackTraceElement) {
        return UnwindTraceElement(fastUnwindBackTraceElement);
    }

    public static List<FastUnwindBackTraceElement> unwindTraceElements(List<FastUnwindBackTraceElement> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (FastUnwindBackTraceElement fastUnwindBackTraceElement : list) {
            if (fastUnwindBackTraceElement.hasUnwind) {
                arrayList.add(fastUnwindBackTraceElement);
            } else {
                Set<FastUnwindBackTraceElement> set = sIgnoreSet;
                if (set.contains(fastUnwindBackTraceElement)) {
                    fastUnwindBackTraceElement.isIgnore = true;
                } else if (fastUnwindBackTraceElement.isEmpty()) {
                    fastUnwindBackTraceElement.isIgnore = true;
                } else {
                    Set<FastUnwindBackTraceElement> set2 = sUnwindSet;
                    if (set2.contains(fastUnwindBackTraceElement)) {
                        for (FastUnwindBackTraceElement fastUnwindBackTraceElement2 : set2) {
                            if (fastUnwindBackTraceElement2.equals(fastUnwindBackTraceElement)) {
                                fastUnwindBackTraceElement.updateTraceInfo(fastUnwindBackTraceElement2);
                                fastUnwindBackTraceElement.hasUnwind = true;
                                fastUnwindBackTraceElement2.lastUpdateTime = fastUnwindBackTraceElement.updateTime;
                                arrayList.add(fastUnwindBackTraceElement);
                                break;
                            }
                        }
                    } else if (unwindTraceElement(fastUnwindBackTraceElement)) {
                        fastUnwindBackTraceElement.hasUnwind = true;
                        set2.add(fastUnwindBackTraceElement);
                        arrayList.add(fastUnwindBackTraceElement);
                    } else {
                        fastUnwindBackTraceElement.isIgnore = true;
                        set.add(fastUnwindBackTraceElement);
                    }
                }
            }
        }
        return arrayList;
    }

    public static String getThreadFrameInfo(Thread thread, Boolean bool, Boolean bool2, Boolean bool3) {
        if (!sIsInit) {
            return null;
        }
        if (bool == null) {
            bool = Boolean.valueOf(thread == Thread.currentThread());
        }
        return GetThreadFrameInfo(thread, bool.booleanValue(), bool2.booleanValue(), bool3.booleanValue());
    }
}

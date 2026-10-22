package com.alibaba.triver.kit.api.event;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverEventCenter {
    private static Map<String, CopyOnWriteArraySet<EventListener>> eventListenerMap = null;
    private static volatile boolean inited = false;
    private static Handler mBackgroundHandler;
    private static HandlerThread mBackgroundThread;
    private static Handler mUIHandler;

    public static synchronized void destroyed() {
        if (inited) {
            try {
                mBackgroundHandler.removeCallbacksAndMessages(null);
                mBackgroundThread.quitSafely();
            } catch (Exception e) {
                RVLogger.w(Log.getStackTraceString(e));
            }
            mBackgroundHandler = null;
            mBackgroundThread = null;
            try {
                mUIHandler.removeCallbacksAndMessages(null);
            } catch (Exception e2) {
                RVLogger.w(Log.getStackTraceString(e2));
            }
            mUIHandler = null;
            eventListenerMap.clear();
            eventListenerMap = null;
            inited = false;
        }
    }

    public static synchronized void init() {
        if (inited) {
            return;
        }
        mUIHandler = new Handler(Looper.getMainLooper());
        HandlerThread handlerThread = new HandlerThread("TriverEventCenter-BG");
        mBackgroundThread = handlerThread;
        handlerThread.start();
        mBackgroundHandler = new Handler(mBackgroundThread.getLooper());
        eventListenerMap = new ConcurrentHashMap();
        inited = true;
    }

    private static void postToBackgroundThread(final EventListener eventListener, final Event event) {
        mBackgroundHandler.post(new Runnable() { // from class: com.alibaba.triver.kit.api.event.TriverEventCenter.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    eventListener.onEvent(event);
                } catch (Exception e) {
                    RVLogger.w(Log.getStackTraceString(e));
                }
            }
        });
    }

    private static void postToUIThread(final EventListener eventListener, final Event event) {
        mUIHandler.post(new Runnable() { // from class: com.alibaba.triver.kit.api.event.TriverEventCenter.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    eventListener.onEvent(event);
                } catch (Exception e) {
                    RVLogger.w(Log.getStackTraceString(e));
                }
            }
        });
    }

    public static boolean registerEeventListener(Event event, EventListener eventListener) {
        if (!inited) {
            init();
        }
        if (event == null || event.getType() == null || eventListener == null) {
            return false;
        }
        if (!eventListenerMap.containsKey(event.getType())) {
            CopyOnWriteArraySet<EventListener> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
            copyOnWriteArraySet.add(eventListener);
            eventListenerMap.put(event.getType(), copyOnWriteArraySet);
            return true;
        }
        CopyOnWriteArraySet<EventListener> copyOnWriteArraySet2 = eventListenerMap.get(event.getType());
        if (copyOnWriteArraySet2.contains(eventListener)) {
            return false;
        }
        copyOnWriteArraySet2.add(eventListener);
        return true;
    }

    public static void removeEventListener(String str, EventListener eventListener) {
        CopyOnWriteArraySet<EventListener> copyOnWriteArraySet;
        if (!inited || str == null || (copyOnWriteArraySet = eventListenerMap.get(str)) == null) {
            return;
        }
        copyOnWriteArraySet.remove(eventListener);
    }

    public static void sendEvent(Event event) {
        if (!inited) {
            init();
            return;
        }
        if (event == null || event.getType() == null || !eventListenerMap.containsKey(event.getType())) {
            return;
        }
        for (EventListener eventListener : eventListenerMap.get(event.getType())) {
            if (eventListener.getThreadMode() == null) {
                postToBackgroundThread(eventListener, event);
            } else if (ThreadMode.UI_THREAD.equals(event.getThreadMode())) {
                if (mUIHandler.getLooper().getThread() == Thread.currentThread()) {
                    try {
                        eventListener.onEvent(event);
                    } catch (Exception e) {
                        RVLogger.w(Log.getStackTraceString(e));
                    }
                } else {
                    postToUIThread(eventListener, event);
                }
            } else if (ThreadMode.UI_POSTING.equals(event.getThreadMode())) {
                postToUIThread(eventListener, event);
            } else {
                postToBackgroundThread(eventListener, event);
            }
        }
    }
}

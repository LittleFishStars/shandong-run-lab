package cj.mobile.wm.common.utils;

import cj.mobile.wm.dexc;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MessageEvent {
    public static final String EVENT_SUCCESS = dexc.dexa("fwfou`tvddftt");
    public static final String EVENT_FAILED = dexc.dexa("fwfou`gbjmfe");
    public static final String TAG = MessageEvent.class.getSimpleName();
    public static CopyOnWriteArrayList<IMessageCallback> messageCallbackList = new CopyOnWriteArrayList<>();

    public interface IMessageCallback {
        void handleMessage(String str);
    }

    public static void attachObserver(IMessageCallback iMessageCallback) {
        try {
            CopyOnWriteArrayList<IMessageCallback> copyOnWriteArrayList = messageCallbackList;
            if (copyOnWriteArrayList == null || copyOnWriteArrayList.contains(iMessageCallback)) {
                return;
            }
            messageCallbackList.add(iMessageCallback);
        } catch (Throwable th) {
            DebugLog.release_e(TAG, dexc.dexa("buubdiPctfswfs!gbjm-") + th);
        }
    }

    public static void detachObserver(IMessageCallback iMessageCallback) {
        try {
            CopyOnWriteArrayList<IMessageCallback> copyOnWriteArrayList = messageCallbackList;
            if (copyOnWriteArrayList != null) {
                copyOnWriteArrayList.remove(iMessageCallback);
            }
        } catch (Throwable th) {
            DebugLog.release_e(TAG, dexc.dexa("efubdiPctfswfs!gbjm-") + th);
        }
    }

    public static void notify(String str) {
        try {
            for (IMessageCallback iMessageCallback : messageCallbackList) {
                detachObserver(iMessageCallback);
                iMessageCallback.handleMessage(str);
            }
        } catch (Throwable th) {
            DebugLog.release_e(TAG, dexc.dexa("opujgz!gbjm-") + th);
        }
    }

    public static void registerWakeupListener(IMessageCallback iMessageCallback) {
        attachObserver(iMessageCallback);
    }
}

package com.alibaba.alibctriver.extensions;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class EventCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23681a = "EventCenter";
    public static Set<NotifyListener> listenerSet = new CopyOnWriteArraySet();

    public interface NotifyListener {
        void onNotify(String str, Object obj);
    }

    public static synchronized void registerEventListener(NotifyListener notifyListener) {
        listenerSet.add(notifyListener);
    }
}

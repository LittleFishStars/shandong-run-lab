package com.alibaba.alibclogin.listener;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcLoginNotifyManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23598a = "AlibcLoginNotifyManager";
    private static List<ILoginListener> b = new ArrayList();

    public static List<ILoginListener> getListenerList() {
        return b;
    }

    public static synchronized void registerListener(ILoginListener iLoginListener) {
        if (iLoginListener == null) {
            return;
        }
        if (b.contains(iLoginListener)) {
            return;
        }
        b.add(iLoginListener);
    }

    public static synchronized void unRegisterListener(ILoginListener iLoginListener) {
        if (iLoginListener == null) {
            return;
        }
        b.remove(iLoginListener);
    }
}

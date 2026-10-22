package com.alibaba.triver.ipc;

import com.alibaba.ariver.app.AppNode;
import com.alibaba.triver.ipc.client.IpcMsgClientService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25001a = "ProcessResourceManager";
    private static List<WeakReference<AppNode>> b = new ArrayList();
    private static WeakReference<IpcMsgClientService> c = null;

    public static void a(AppNode appNode) {
        if (appNode != null) {
            b.add(new WeakReference<>(appNode));
        }
    }

    public static void a(IpcMsgClientService ipcMsgClientService) {
        if (ipcMsgClientService != null) {
            c = new WeakReference<>(ipcMsgClientService);
        }
    }

    public static void a() {
        for (WeakReference<AppNode> weakReference : b) {
            if (weakReference != null) {
                try {
                    if (weakReference.get() != null) {
                        weakReference.get().exit();
                    }
                } catch (Exception unused) {
                }
            }
        }
        try {
            WeakReference<IpcMsgClientService> weakReference2 = c;
            if (weakReference2 == null || weakReference2.get() == null) {
                return;
            }
            c.get().stopSelf();
        } catch (Exception unused2) {
        }
    }
}

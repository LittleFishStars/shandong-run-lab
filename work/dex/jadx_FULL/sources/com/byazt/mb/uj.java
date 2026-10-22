package com.byazt.mb;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.byazt.omf.t;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1662, 15})
public class uj extends c {
    public static HashMap<String, RemoteCallbackList<t>> c = new HashMap<>();
    public static volatile uj tt;

    public static uj tt() {
        if (tt == null) {
            synchronized (uj.class) {
                if (tt == null) {
                    tt = new uj();
                }
            }
        }
        return tt;
    }

    @Override // com.byazt.mb.c, com.byazt.omf.yp
    public void c(String str, t tVar) throws RemoteException {
        if (tVar == null) {
            return;
        }
        RemoteCallbackList<t> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(tVar);
        c.put(str, remoteCallbackList);
    }

    @Override // com.byazt.mb.c, com.byazt.omf.yp
    public void c(String str, String str2) throws RemoteException {
        RemoteCallbackList<t> remoteCallbackListRemove = c.remove(str);
        if (remoteCallbackListRemove == null) {
            return;
        }
        int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
        for (int i = 0; i < iBeginBroadcast; i++) {
            t tVar = (t) remoteCallbackListRemove.getBroadcastItem(i);
            if (tVar != null) {
                if (str2 == null) {
                    tVar.c();
                } else {
                    tVar.c(str2);
                }
            }
        }
        remoteCallbackListRemove.finishBroadcast();
        remoteCallbackListRemove.kill();
    }
}

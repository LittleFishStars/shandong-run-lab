package com.byazt.mb;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.byazt.omf.sl;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1662, 54})
public class ve extends c {
    public static HashMap<String, RemoteCallbackList<sl>> c = new HashMap<>();
    public static volatile ve tt;

    public static ve tt() {
        if (tt == null) {
            synchronized (ve.class) {
                if (tt == null) {
                    tt = new ve();
                }
            }
        }
        return tt;
    }

    @Override // com.byazt.mb.c, com.byazt.omf.yp
    public void c(String str, sl slVar) throws RemoteException {
        if (slVar == null) {
            return;
        }
        RemoteCallbackList<sl> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(slVar);
        c.put(str, remoteCallbackList);
    }

    @Override // com.byazt.mb.c, com.byazt.omf.yp
    public void c(String str, int i) throws RemoteException {
        RemoteCallbackList<sl> remoteCallbackListRemove = c.remove(str);
        if (remoteCallbackListRemove == null) {
            return;
        }
        int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
        for (int i2 = 0; i2 < iBeginBroadcast; i2++) {
            sl slVar = (sl) remoteCallbackListRemove.getBroadcastItem(i2);
            if (slVar != null) {
                if (i == 1) {
                    slVar.c();
                } else if (i == 2) {
                    slVar.tt();
                } else if (i != 3) {
                    slVar.ve();
                } else {
                    slVar.ve();
                }
            }
        }
        remoteCallbackListRemove.finishBroadcast();
        remoteCallbackListRemove.kill();
    }
}

package com.byazt.mb;

import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.byazt.omf.z;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1662, 34})
public class a extends c {
    public static final Map<String, RemoteCallbackList<z>> c = Collections.synchronizedMap(new HashMap());
    public static volatile a tt;

    public static a tt() {
        if (tt == null) {
            synchronized (a.class) {
                if (tt == null) {
                    tt = new a();
                }
            }
        }
        return tt;
    }

    private synchronized Bundle uj(String str, String str2, Bundle bundle) {
        Bundle bundle2;
        bundle2 = new Bundle();
        try {
            Map<String, RemoteCallbackList<z>> map = c;
            if (map != null) {
                RemoteCallbackList<z> remoteCallbackListRemove = "recycleRes".equals(str2) ? map.remove(str) : map.get(str);
                if (remoteCallbackListRemove != null) {
                    int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
                    for (int i = 0; i < iBeginBroadcast; i++) {
                        try {
                            z zVar = (z) remoteCallbackListRemove.getBroadcastItem(i);
                            if (zVar != null && "getPlayAgainCondition".equals(str2)) {
                                bundle2 = zVar.c(bundle.getInt("callback_extra_key_next_play_again_count"));
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    remoteCallbackListRemove.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackListRemove.kill();
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        return bundle2;
    }

    @Override // com.byazt.mb.c, com.byazt.omf.yp
    public void c(String str, z zVar) throws RemoteException {
        RemoteCallbackList<z> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(zVar);
        c.put(str, remoteCallbackList);
    }

    @Override // com.byazt.mb.c, com.byazt.omf.yp
    public Bundle ve(String str, String str2, Bundle bundle) throws RemoteException {
        return uj(str, str2, bundle);
    }
}

package com.byazt.mb;

import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.byazt.aas.nb;
import com.byazt.ete.l;
import com.byazt.omf.m;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1662, 91})
public class sp extends c {
    public static Map<String, RemoteCallbackList<m>> c = Collections.synchronizedMap(new HashMap());
    public static volatile sp tt;

    public static sp tt() {
        if (tt == null) {
            synchronized (sp.class) {
                if (tt == null) {
                    tt = new sp();
                }
            }
        }
        return tt;
    }

    private synchronized void uj(String str, String str2, Bundle bundle) {
        RemoteCallbackList<m> remoteCallbackListRemove;
        RemoteCallbackList<m> remoteCallbackListRemove2;
        try {
            if (c != null) {
                if ("recycleRes".equals(str2)) {
                    remoteCallbackListRemove = c.remove(str);
                    remoteCallbackListRemove2 = c.remove(l.c(str));
                } else {
                    remoteCallbackListRemove = c.get(str);
                    remoteCallbackListRemove2 = null;
                }
                if (remoteCallbackListRemove != null) {
                    int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
                    for (int i = 0; i < iBeginBroadcast; i++) {
                        try {
                            m mVar = (m) remoteCallbackListRemove.getBroadcastItem(i);
                            if (mVar != null) {
                                if ("onAdShow".equals(str2)) {
                                    mVar.c(bundle);
                                } else if ("onAdClose".equals(str2)) {
                                    mVar.ve();
                                } else if ("onVideoComplete".equals(str2)) {
                                    mVar.uj();
                                } else if ("onVideoError".equals(str2)) {
                                    mVar.n();
                                } else if ("onAdVideoBarClick".equals(str2)) {
                                    mVar.tt();
                                } else if ("onRewardVerify".equals(str2)) {
                                    c(mVar, bundle);
                                } else if ("onRewardArrived".equals(str2)) {
                                    tt(mVar, bundle);
                                } else if ("onSkippedVideo".equals(str2)) {
                                    mVar.a();
                                } else if ("recycleRes".equals(str2)) {
                                    mVar.c();
                                }
                            }
                        } catch (Throwable th) {
                            com.byazt.nr.m.ve("MultiProcess", "reward1 '" + str2 + "'  throws Exception :", th);
                        }
                    }
                    remoteCallbackListRemove.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackListRemove.kill();
                    }
                }
                if (remoteCallbackListRemove2 != null) {
                    int iBeginBroadcast2 = remoteCallbackListRemove2.beginBroadcast();
                    for (int i2 = 0; i2 < iBeginBroadcast2; i2++) {
                        try {
                            m mVar2 = (m) remoteCallbackListRemove2.getBroadcastItem(i2);
                            if (mVar2 != null && "recycleRes".equals(str2)) {
                                mVar2.c();
                            }
                        } catch (Throwable unused) {
                        }
                    }
                    remoteCallbackListRemove2.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remoteCallbackListRemove2.kill();
                    }
                }
            }
        } catch (Throwable th2) {
            com.byazt.nr.m.ve("MultiProcess", "reward2 '" + str2 + "'  throws Exception :", th2);
        }
    }

    @Override // com.byazt.mb.c, com.byazt.omf.yp
    public synchronized void c(String str, m mVar) throws RemoteException {
        RemoteCallbackList<m> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(mVar);
        c.put(str, remoteCallbackList);
    }

    @Override // com.byazt.mb.c, com.byazt.omf.yp
    public void c(String str, String str2, Bundle bundle) throws RemoteException {
        uj(str, str2, bundle);
    }

    private void c(m mVar, Bundle bundle) throws RemoteException {
        boolean z = bundle.getBoolean("callback_extra_key_reward_valid");
        int i = bundle.getInt("callback_extra_key_reward_amount");
        String string = bundle.getString("callback_extra_key_reward_name");
        int i2 = bundle.getInt("callback_extra_key_error_code");
        String string2 = bundle.getString("callback_extra_key_error_msg");
        mVar.c(z, i, string != null ? string : "", i2, string2 != null ? string2 : "");
    }

    private void tt(m mVar, Bundle bundle) throws RemoteException {
        boolean z = bundle.getBoolean("callback_extra_key_reward_valid");
        int i = bundle.getInt("callback_extra_key_reward_type");
        mVar.c(z, i, nb.c(i, bundle));
    }
}

package com.byazt.quv;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.byazt.uk.n;
import com.byazt.uk.ve;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.service.client.ServiceManagerNative;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT, 13})
public class tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ve f28984a;
    public static final Object c = new Object();
    public static final Object tt = new Object();
    public static final Object ve = new Object();
    public static final Map<String, Boolean> uj = new ConcurrentHashMap();
    public static final Map<String, n> n = new ConcurrentHashMap();

    public static n c(String str) {
        Boolean bool = uj.get(str);
        if (bool == null || !bool.booleanValue()) {
            n.remove(str);
        }
        Map<String, n> map = n;
        if (map.get(str) == null) {
            synchronized (tt) {
                n nVar = (n) c("service", str);
                if (nVar == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getServiceManager failed!!!");
                    return null;
                }
                map.put(str, nVar);
            }
        }
        return map.get(str);
    }

    public static ve c() {
        Boolean bool = uj.get("main");
        if (bool == null || !bool.booleanValue()) {
            f28984a = null;
        }
        if (f28984a == null) {
            synchronized (ve) {
                ve veVar = (ve) c("package", "main");
                if (veVar == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "getPackageManager failed!!!");
                    return null;
                }
                f28984a = veVar;
            }
        }
        return f28984a;
    }

    private static IBinder c(Uri uri, String str) {
        Bundle bundleCall = Zeus.getAppApplication().getContentResolver().call(uri, AbsServerManager.METHOD_QUERY_BINDER, str, (Bundle) null);
        if (bundleCall != null) {
            bundleCall.setClassLoader(AbsServerManager.class.getClassLoader());
            c cVar = (c) bundleCall.getParcelable(AbsServerManager.BUNDLE_BINDER);
            if (cVar != null) {
                return cVar.c();
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0065  */
    private static IInterface c(String str, final String str2) {
        if (Zeus.hasInit()) {
            ProviderInfo providerInfo = Zeus.getServerManagerHashMap().get(str2);
            if (providerInfo != null) {
                final IBinder iBinderC = c(Uri.parse("content://" + providerInfo.authority), str);
                if (iBinderC == null || !iBinderC.isBinderAlive()) {
                    return null;
                }
                try {
                    byte b = 0;
                    iBinderC.linkToDeath(new IBinder.DeathRecipient() { // from class: com.byazt.quv.tt.1
                        @Override // android.os.IBinder.DeathRecipient
                        public void binderDied() {
                            tt.uj.put(str2, Boolean.FALSE);
                            ZeusLogger.w(ZeusLogger.TAG_SERVER, "generateServerManager binderDied.");
                            HashMap<ServiceConnection, HashSet<ComponentName>> map = ServiceManagerNative.getInstance().process2ConnAndService.get(iBinderC);
                            if (map != null) {
                                for (ServiceConnection serviceConnection : map.keySet()) {
                                    Iterator<ComponentName> it = map.get(serviceConnection).iterator();
                                    while (it.hasNext()) {
                                        serviceConnection.onServiceDisconnected(it.next());
                                    }
                                }
                            }
                        }
                    }, 0);
                    uj.put(str2, Boolean.TRUE);
                    int iHashCode = str.hashCode();
                    if (iHashCode != -807062458) {
                        if (iHashCode == 1984153269 && str.equals("service")) {
                            b = 1;
                        } else {
                            b = -1;
                        }
                    } else if (!str.equals("package")) {
                        b = -1;
                    }
                    if (b == 0) {
                        return ve.c.c(iBinderC);
                    }
                    if (b != 1) {
                        return null;
                    }
                    return n.c.c(iBinderC);
                } catch (RemoteException e) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVER, "generateServerManager failed.", e);
                    return null;
                }
            }
            throw new RuntimeException("宿主中没有找对对应进程的serverManager ".concat(String.valueOf(str2)));
        }
        throw new RuntimeException("generateServerManager 请先初始化Zeus, processName:".concat(String.valueOf(str2)));
    }
}

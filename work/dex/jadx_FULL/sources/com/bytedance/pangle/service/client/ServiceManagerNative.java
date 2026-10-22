package com.bytedance.pangle.service.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Keep;
import com.byazt.bog.a;
import com.byazt.quv.tt;
import com.byazt.uk.n;
import com.byazt.uk.x;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.PluginManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@Keep
public class ServiceManagerNative {
    public static volatile ServiceManagerNative sInstance;
    public final HashMap<ServiceConnection, x> serviceConn2ServiceConn = new HashMap<>();
    public HashMap<IBinder, HashMap<ServiceConnection, HashSet<ComponentName>>> process2ConnAndService = new HashMap<>();
    public HashMap<ServiceConnection, HashSet<ServiceInfo>> conn2Service = new HashMap<>();

    private ServiceManagerNative() {
    }

    public static ServiceManagerNative getInstance() {
        if (sInstance == null) {
            synchronized (ServiceManagerNative.class) {
                if (sInstance == null) {
                    sInstance = new ServiceManagerNative();
                }
            }
        }
        return sInstance;
    }

    public boolean bindServiceNative(Context context, Intent intent, final ServiceConnection serviceConnection, int i, String str) {
        ServiceInfo serviceInfoQueryServiceFromPlugin = queryServiceFromPlugin(intent, str);
        if (serviceInfoQueryServiceFromPlugin == null) {
            return context.bindService(intent, serviceConnection, i);
        }
        if (!this.serviceConn2ServiceConn.containsKey(serviceConnection)) {
            this.serviceConn2ServiceConn.put(serviceConnection, new x.c() { // from class: com.bytedance.pangle.service.client.ServiceManagerNative.1
                @Override // com.byazt.uk.x
                public void c(ComponentName componentName, IBinder iBinder) {
                    serviceConnection.onServiceConnected(componentName, iBinder);
                }

                @Override // com.byazt.uk.x
                public int c() {
                    return serviceConnection.hashCode();
                }
            });
        }
        if (this.conn2Service.get(serviceConnection) == null) {
            this.conn2Service.put(serviceConnection, new HashSet<>());
        }
        this.conn2Service.get(serviceConnection).add(serviceInfoQueryServiceFromPlugin);
        n nVarC = tt.c(serviceInfoQueryServiceFromPlugin.processName);
        IBinder iBinderAsBinder = nVarC.asBinder();
        HashMap<ServiceConnection, HashSet<ComponentName>> map = this.process2ConnAndService.get(iBinderAsBinder);
        if (map == null) {
            map = new HashMap<>();
            this.process2ConnAndService.put(iBinderAsBinder, map);
        }
        HashSet<ComponentName> hashSet = map.get(serviceConnection);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            map.put(serviceConnection, hashSet);
        }
        hashSet.add(intent.getComponent());
        try {
            return nVarC.bindService(intent, this.serviceConn2ServiceConn.get(serviceConnection), i, str);
        } catch (RemoteException e) {
            ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "bindService failed!", e);
            return false;
        }
    }

    public ServiceInfo queryServiceFromPlugin(Intent intent, String str) {
        Zeus.loadPlugin(str);
        ComponentName component = intent.getComponent();
        if (component == null) {
            return null;
        }
        return PluginManager.getInstance().getPlugin(str).pluginServices.get(component.getClassName());
    }

    public ComponentName startServiceNative(Context context, Intent intent, String str) {
        ServiceInfo serviceInfoQueryServiceFromPlugin = queryServiceFromPlugin(intent, str);
        if (serviceInfoQueryServiceFromPlugin == null) {
            return context.startService(intent);
        }
        try {
            return tt.c(serviceInfoQueryServiceFromPlugin.processName).startService(intent, str);
        } catch (RemoteException e) {
            a.c(e);
            return null;
        }
    }

    public boolean stopServiceNative(Context context, Intent intent, String str) {
        ServiceInfo serviceInfoQueryServiceFromPlugin = queryServiceFromPlugin(intent, str);
        if (serviceInfoQueryServiceFromPlugin == null) {
            return context.stopService(intent);
        }
        try {
            return tt.c(serviceInfoQueryServiceFromPlugin.processName).stopService(intent, str);
        } catch (RemoteException e) {
            a.c(e);
            return false;
        }
    }

    public void unbindServiceNative(ServiceConnection serviceConnection) {
        HashSet<ServiceInfo> hashSet = this.conn2Service.get(serviceConnection);
        if (hashSet != null) {
            Iterator<ServiceInfo> it = hashSet.iterator();
            while (it.hasNext()) {
                try {
                    tt.c(it.next().processName).unbindService(this.serviceConn2ServiceConn.get(serviceConnection));
                } catch (RemoteException e) {
                    a.c(e);
                }
            }
        }
    }
}

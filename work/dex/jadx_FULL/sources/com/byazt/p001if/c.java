package com.byazt.p001if;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.byazt.bog.a;
import com.byazt.uk.n;
import com.byazt.uk.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 463, 20})
public class c extends n.c {
    public static volatile c tt;
    public final HashMap<ComponentName, IBinder> ve = new HashMap<>();
    public final HashMap<ComponentName, tt> uj = new HashMap<>();
    public final C0437c<Intent> n = new C0437c<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<ComponentName, com.byazt.fgi.c> f28644a = new HashMap<>();
    public final HashSet<ComponentName> sp = new HashSet<>();
    public final HashSet<ComponentName> x = new HashSet<>();
    public final List<Runnable> i = new ArrayList();
    public final Handler c = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: com.byazt.if.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 463, 44})
    public class C0437c<T> extends HashMap<x, T> {
        public C0437c() {
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public boolean containsKey(@Nullable Object obj) {
            if (super.containsKey(obj)) {
                return true;
            }
            if (!(obj instanceof x)) {
                return false;
            }
            Iterator<x> it = keySet().iterator();
            while (it.hasNext()) {
                try {
                    if (it.next().c() == ((x) obj).c()) {
                        return true;
                    }
                } catch (RemoteException e) {
                    a.c(e);
                }
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        @Nullable
        public T remove(@Nullable Object obj) {
            x next;
            T t = (T) super.remove(obj);
            if (t != null) {
                return t;
            }
            Iterator<x> it = keySet().iterator();
            while (it.hasNext()) {
                next = it.next();
                try {
                    if (next.c() == ((x) obj).c()) {
                        return (T) super.remove(next);
                    }
                } catch (RemoteException e) {
                    a.c(e);
                }
            }
            next = null;
            return (T) super.remove(next);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 463, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public class tt extends HashSet<x> {
        public tt() {
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@Nullable Object obj) {
            if (super.contains(obj)) {
                return true;
            }
            if (!(obj instanceof x)) {
                return false;
            }
            Iterator<x> it = iterator();
            while (it.hasNext()) {
                try {
                    if (it.next().c() == ((x) obj).c()) {
                        return true;
                    }
                } catch (RemoteException e) {
                    a.c(e);
                }
            }
            return false;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@Nullable Object obj) {
            x xVar;
            if (super.remove(obj)) {
                return true;
            }
            Iterator it = iterator();
            while (it.hasNext()) {
                xVar = (x) it.next();
                try {
                    if (xVar.c() == ((x) obj).c()) {
                        return super.remove(xVar);
                    }
                } catch (RemoteException e) {
                    a.c(e);
                }
            }
            xVar = null;
            return super.remove(xVar);
        }
    }

    private c() {
    }

    private com.byazt.fgi.c uj(Intent intent, String str) {
        boolean zLoadPlugin;
        ComponentName component = intent.getComponent();
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        try {
            zLoadPlugin = Zeus.loadPlugin(str);
            try {
                com.byazt.fgi.c cVar = (com.byazt.fgi.c) plugin.mClassLoader.loadClass(component.getClassName()).newInstance();
                cVar.attach(plugin);
                return cVar;
            } catch (Exception e) {
                e = e;
                ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "newServiceInstance failed! loadPlugin = ".concat(String.valueOf(zLoadPlugin)), e);
                return null;
            }
        } catch (Exception e2) {
            e = e2;
            zLoadPlugin = false;
        }
    }

    @Override // com.byazt.uk.n.c, android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // com.byazt.uk.n
    public boolean bindService(final Intent intent, final x xVar, final int i, final String str) throws RemoteException {
        if (!Zeus.hasInit()) {
            this.i.add(new Runnable() { // from class: com.byazt.if.c.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        c.this.tt(intent, xVar, i, str);
                    } catch (RemoteException e) {
                        ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "pending bindService failed", e);
                    }
                }
            });
            return true;
        }
        Plugin plugin = Zeus.getPlugin(str);
        if (plugin.isLoaded()) {
            return c(intent, xVar, i, str);
        }
        if (Zeus.loadPlugin(str)) {
            c(intent, xVar, i, str);
            return true;
        }
        plugin.addBindServicePluginPendingTask(new Plugin.c() { // from class: com.byazt.if.c.6
            @Override // com.bytedance.pangle.plugin.Plugin.c
            public void c(int i2) throws RemoteException {
                c.this.c(intent, xVar, i, str);
            }
        });
        return true;
    }

    @Override // com.byazt.uk.n
    public ComponentName startService(final Intent intent, final String str) {
        if (Zeus.hasInit()) {
            Plugin plugin = Zeus.getPlugin(str);
            if (plugin.isLoaded()) {
                return c(intent, str);
            }
            plugin.addStartServicePluginPendingTask(new Plugin.c() { // from class: com.byazt.if.c.2
                @Override // com.bytedance.pangle.plugin.Plugin.c
                public void c(int i) throws RemoteException {
                    c.this.c(intent, str);
                }
            });
        } else {
            this.i.add(new Runnable() { // from class: com.byazt.if.c.3
                @Override // java.lang.Runnable
                public void run() {
                    c.this.tt(intent, str);
                }
            });
        }
        return intent.getComponent();
    }

    @Override // com.byazt.uk.n
    public boolean stopService(final Intent intent, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            tt().c(intent.getComponent());
            return true;
        }
        this.c.post(new Runnable() { // from class: com.byazt.if.c.4
            @Override // java.lang.Runnable
            public void run() {
                c.tt().c(intent.getComponent());
            }
        });
        return true;
    }

    @Override // com.byazt.uk.n
    public void unbindService(final x xVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c(xVar);
        } else {
            this.c.post(new Runnable() { // from class: com.byazt.if.c.8
                @Override // java.lang.Runnable
                public void run() {
                    c.this.c(xVar);
                }
            });
        }
    }

    public void ve() {
        for (Runnable runnable : this.i) {
            if (runnable != null) {
                this.c.post(runnable);
            }
        }
        this.i.clear();
    }

    public static c tt() {
        if (tt == null) {
            synchronized (c.class) {
                if (tt == null) {
                    tt = new c();
                }
            }
        }
        return tt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ComponentName c(final Intent intent, final String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return tt(intent, str);
        }
        this.c.post(new Runnable() { // from class: com.byazt.if.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.tt(intent, str);
            }
        });
        return intent.getComponent();
    }

    private com.byazt.fgi.c ve(Intent intent, String str) {
        com.byazt.fgi.c cVarUj = uj(intent, str);
        if (cVarUj != null) {
            cVarUj.onCreate();
        }
        return cVarUj;
    }

    private void ve(ComponentName componentName) {
        com.byazt.fgi.c cVarRemove = this.f28644a.remove(componentName);
        this.x.remove(componentName);
        this.ve.remove(componentName);
        this.sp.remove(componentName);
        if (cVarRemove != null) {
            cVarRemove.onDestroy();
        }
    }

    public synchronized boolean c(ComponentName componentName) {
        if (!this.f28644a.containsKey(componentName)) {
            return false;
        }
        this.x.add(componentName);
        return tt(componentName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ComponentName tt(Intent intent, String str) {
        ComponentName component = intent.getComponent();
        if (!this.f28644a.containsKey(component)) {
            com.byazt.fgi.c cVarVe = ve(intent, str);
            if (cVarVe == null) {
                return component;
            }
            this.f28644a.put(component, cVarVe);
            this.sp.add(component);
        }
        com.byazt.fgi.c cVar = this.f28644a.get(component);
        if (cVar != null) {
            cVar.onStartCommand(intent, 0, 0);
        }
        return component;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(final Intent intent, final x xVar, final int i, final String str) throws RemoteException {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return tt(intent, xVar, i, str);
        }
        this.c.post(new Runnable() { // from class: com.byazt.if.c.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    c.this.tt(intent, xVar, i, str);
                } catch (RemoteException e) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "bindService failed", e);
                }
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(x xVar) {
        for (ComponentName componentName : this.uj.keySet()) {
            tt ttVar = this.uj.get(componentName);
            if (ttVar.contains(xVar)) {
                ttVar.remove(xVar);
                Intent intentRemove = this.n.remove(xVar);
                if (ttVar.size() == 0) {
                    this.uj.remove(componentName);
                    com.byazt.fgi.c cVar = this.f28644a.get(componentName);
                    if (cVar != null) {
                        cVar.onUnbind(intentRemove);
                    }
                }
                tt(componentName);
                return;
            }
        }
    }

    private boolean tt(ComponentName componentName) {
        if (!this.sp.contains(componentName)) {
            if (this.uj.get(componentName) != null) {
                return false;
            }
            ve(componentName);
            return true;
        }
        if (!this.x.contains(componentName) || this.uj.containsKey(componentName)) {
            return false;
        }
        ve(componentName);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean tt(Intent intent, x xVar, int i, String str) throws RemoteException {
        ComponentName component = intent.getComponent();
        if (!this.f28644a.containsKey(component)) {
            com.byazt.fgi.c cVarVe = ve(intent, str);
            if (cVarVe == null) {
                return false;
            }
            this.f28644a.put(component, cVarVe);
        }
        com.byazt.fgi.c cVar = this.f28644a.get(component);
        if (!this.ve.containsKey(component)) {
            this.ve.put(component, cVar.onBind(intent));
        }
        IBinder iBinder = this.ve.get(component);
        if (iBinder != null) {
            if (this.uj.containsKey(component)) {
                if (!this.uj.get(component).contains(xVar)) {
                    this.uj.get(component).add(xVar);
                    this.n.put(xVar, intent);
                    xVar.c(component, iBinder);
                }
            } else {
                tt ttVar = new tt();
                ttVar.add(xVar);
                this.uj.put(component, ttVar);
                this.n.put(xVar, intent);
                xVar.c(component, iBinder);
            }
        }
        return true;
    }
}

package com.alibaba.ariver.kernel.ipc;

import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.alibaba.ariver.kernel.api.IIpcChannel;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class IpcChannelManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24288a = "AriverKernel:IpcChannelManager";
    private static IpcChannelManager b;
    private static IIpcChannel c;
    private static final LongSparseArray<IIpcChannel> d = new LongSparseArray<>(5);
    private static final List<ClientListener> e = new ArrayList();
    private static final List<ServerReadyListener> f = new ArrayList();

    public interface ClientListener {
        void onRegister(long j, IIpcChannel iIpcChannel);

        void onUnRegister(long j);
    }

    public interface ServerReadyListener {
        void onServerReady();
    }

    public static IpcChannelManager getInstance() {
        if (b == null) {
            synchronized (IpcChannelManager.class) {
                if (b == null) {
                    b = new IpcChannelManager();
                }
            }
        }
        return b;
    }

    @Nullable
    public synchronized IIpcChannel getClientChannel(long j) {
        return d.get(j);
    }

    @Nullable
    public synchronized IIpcChannel getServerChannel() {
        return c;
    }

    public synchronized void registerClientChannel(long j, IIpcChannel iIpcChannel) {
        LongSparseArray<IIpcChannel> longSparseArray = d;
        if (longSparseArray.get(j) != null) {
            RVLogger.w(f24288a, "registerClientChannel: " + j + " but already registered.");
            return;
        }
        RVLogger.d(f24288a, "registerClientChannel: " + j);
        longSparseArray.put(j, iIpcChannel);
        List<ClientListener> list = e;
        synchronized (list) {
            Iterator<ClientListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onRegister(j, iIpcChannel);
            }
        }
    }

    public void registerClientListener(ClientListener clientListener) {
        List<ClientListener> list = e;
        synchronized (list) {
            list.add(clientListener);
        }
    }

    public synchronized void registerServerChannel(IIpcChannel iIpcChannel) {
        RVLogger.d(f24288a, "registerServerChannel");
        c = iIpcChannel;
        List<ServerReadyListener> list = f;
        synchronized (list) {
            Iterator<ServerReadyListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onServerReady();
            }
        }
    }

    public void registerServerReadyListener(ServerReadyListener serverReadyListener) {
        List<ServerReadyListener> list = f;
        synchronized (list) {
            list.add(serverReadyListener);
        }
    }

    public synchronized void unRegisterClientChannel(long j) {
        LongSparseArray<IIpcChannel> longSparseArray = d;
        if (longSparseArray.get(j) == null) {
            RVLogger.w(f24288a, "unRegisterClientChannel: " + j + " but already unregistered.");
            return;
        }
        RVLogger.d(f24288a, "unRegisterClientChannel: " + j);
        ShadowNodePool.getInstance().unBindStartToken(j);
        longSparseArray.remove(j);
        List<ClientListener> list = e;
        synchronized (list) {
            Iterator<ClientListener> it = list.iterator();
            while (it.hasNext()) {
                it.next().onUnRegister(j);
            }
        }
    }

    public void unRegisterClientListener(ClientListener clientListener) {
        List<ClientListener> list = e;
        synchronized (list) {
            list.remove(clientListener);
        }
    }

    public synchronized void unRegisterServerChannel() {
        RVLogger.d(f24288a, "unRegisterServerChannel");
        c = null;
    }

    public void unRegisterServerReadyListener(ServerReadyListener serverReadyListener) {
        List<ServerReadyListener> list = f;
        synchronized (list) {
            list.remove(serverReadyListener);
        }
    }
}

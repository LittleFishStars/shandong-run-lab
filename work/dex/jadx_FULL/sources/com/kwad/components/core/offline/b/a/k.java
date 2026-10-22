package com.kwad.components.core.offline.b.a;

import android.content.Context;
import com.kwad.components.offline.api.core.network.INetworkChangeListener;
import com.kwad.components.offline.api.core.network.INetworkManager;
import com.kwad.sdk.core.NetworkMonitor;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.by;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class k implements INetworkManager {
    private List<INetworkChangeListener> abH = new CopyOnWriteArrayList();
    private NetworkMonitor.a abI;

    private void aE(final Context context) {
        if (this.abI != null) {
            return;
        }
        this.abI = new NetworkMonitor.a() { // from class: com.kwad.components.core.offline.b.a.k.1
            @Override // com.kwad.sdk.core.NetworkMonitor.a
            public final void a(NetworkMonitor.NetworkState networkState) {
                by.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.offline.b.a.k.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        int networkType = k.this.getNetworkType(context);
                        Iterator it = k.this.abH.iterator();
                        while (it.hasNext()) {
                            ((INetworkChangeListener) it.next()).networkChange(networkType);
                        }
                    }
                });
            }
        };
        NetworkMonitor.getInstance().a(context, this.abI);
    }

    @Override // com.kwad.components.offline.api.core.network.INetworkManager
    public final void addNetworkChangeListener(Context context, INetworkChangeListener iNetworkChangeListener) {
        if (iNetworkChangeListener != null) {
            aE(context);
            this.abH.add(iNetworkChangeListener);
        }
    }

    @Override // com.kwad.components.offline.api.core.network.INetworkManager
    public final int getNetworkType(Context context) {
        return aq.dB(context);
    }

    @Override // com.kwad.components.offline.api.core.network.INetworkManager
    public final void removeNetworkChangeListener(Context context, INetworkChangeListener iNetworkChangeListener) {
        this.abH.remove(iNetworkChangeListener);
    }
}

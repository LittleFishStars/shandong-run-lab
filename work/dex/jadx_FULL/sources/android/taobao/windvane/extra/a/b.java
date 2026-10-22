package android.taobao.windvane.extra.a;

import android.taobao.windvane.base.m;
import com.uc.webview.export.internal.interfaces.INetworkDecider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class b implements INetworkDecider {
    public int chooseNetwork(String str) {
        android.taobao.windvane.extra.service.b bVar;
        return (str.startsWith("ws://") || str.startsWith("wss://") || (bVar = (android.taobao.windvane.extra.service.b) m.a().b(android.taobao.windvane.extra.service.b.class)) == null || !bVar.a()) ? 0 : 2;
    }
}

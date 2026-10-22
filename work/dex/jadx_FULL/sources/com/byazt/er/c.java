package com.byazt.er;

import android.os.RemoteException;
import com.byazt.uk.sl;
import com.byazt.uk.uj;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusPluginStateListener;
import com.bytedance.pangle.plugin.PluginManager;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 964, 20})
public class c extends com.byazt.uk.ve.c {
    public static volatile c c;

    public static c tt() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    @Override // com.byazt.uk.ve
    public boolean c(String str) {
        return PluginManager.getInstance().checkPluginInstalled(str);
    }

    @Override // com.byazt.uk.ve
    public boolean c(String str, String str2) {
        GlobalParam.getInstance().getReporter().c("zeus_stage_plugin_install", "start install pkg:" + str + ", path:" + str2);
        return PluginManager.getInstance().syncInstall(str, new File(str2));
    }

    @Override // com.byazt.uk.ve
    public void c(int i, uj ujVar) throws RemoteException {
        Zeus.registerPluginStateListener(new ve(ujVar, i));
    }

    @Override // com.byazt.uk.ve
    public void c(int i) throws RemoteException {
        ZeusPluginStateListener next;
        List<ZeusPluginStateListener> listVe = sl.c().ve();
        Iterator<ZeusPluginStateListener> it = listVe.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if ((next instanceof ve) && ((ve) next).c() == i) {
                break;
            }
        }
        if (next != null) {
            listVe.remove(next);
        }
    }

    @Override // com.byazt.uk.ve
    public int tt(String str) {
        return PluginManager.getInstance().getPlugin(str).getVersion();
    }
}

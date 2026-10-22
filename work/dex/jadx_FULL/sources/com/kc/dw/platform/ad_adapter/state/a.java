package com.kc.dw.platform.ad_adapter.state;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f39562a = 0;
    public volatile int b = 0;
    public volatile int c = 0;
    public final List<InterfaceC1076a> d = new ArrayList();

    /* JADX INFO: renamed from: com.kc.dw.platform.ad_adapter.state.a$a, reason: collision with other inner class name */
    @Keep
    public interface InterfaceC1076a {
        void onRenderSuccess();
    }

    public boolean a(int i) {
        if (i <= this.b) {
            return false;
        }
        this.b = i;
        if (this.b == 5) {
            try {
                if (!this.d.isEmpty()) {
                    Iterator<InterfaceC1076a> it = this.d.iterator();
                    while (it.hasNext()) {
                        it.next().onRenderSuccess();
                    }
                    this.d.clear();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return true;
    }

    public boolean b(int i) {
        if (i <= this.f39562a) {
            return false;
        }
        this.f39562a = i;
        return true;
    }

    public boolean c(int i) {
        if (i <= this.c) {
            return false;
        }
        this.c = i;
        return true;
    }
}

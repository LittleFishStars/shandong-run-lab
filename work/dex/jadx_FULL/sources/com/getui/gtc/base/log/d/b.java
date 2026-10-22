package com.getui.gtc.base.log.d;

import com.getui.gtc.base.log.ILogController;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ILogController> f30287a = new ArrayList();

    @Override // com.getui.gtc.base.log.d.a
    public final void a(int i, String str, String str2, Throwable th) {
        for (ILogController iLogController : this.f30287a) {
            try {
                if (iLogController.isLoggable(i, str)) {
                    iLogController.log(i, str, str2, th);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    @Override // com.getui.gtc.base.log.d.a
    public final void a(ILogController iLogController) {
        if (iLogController == null) {
            return;
        }
        this.f30287a.add(iLogController);
    }

    @Override // com.getui.gtc.base.log.d.a
    public final void b(ILogController iLogController) {
        if (this.f30287a.contains(iLogController)) {
            this.f30287a.remove(iLogController);
        }
    }
}

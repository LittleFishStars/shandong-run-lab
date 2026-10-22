package com.kc.dw.core.service.logrecord;

import android.util.Log;
import com.ali.auth.third.login.LoginConstants;
import com.kc.dw.core.AdSdk;
import com.kc.dw.core.router.log.EventBean;
import com.kc.dw.core.router.log.EventListBean;
import com.kc.dw.core.safe.j;
import com.kc.dw.core.utils.t;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class e extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f39319a;
    public final d b;

    public e(d dVar, List list) {
        this.b = dVar;
        this.f39319a = list;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        File file;
        try {
            try {
                List list = this.f39319a;
                if (list == null || list.isEmpty()) {
                    file = null;
                } else {
                    String str = System.currentTimeMillis() + LoginConstants.UNDER_LINE + this.b.g.nextInt(100);
                    File file2 = new File(com.kc.dw.core.bquery.c.c(com.kc.dw.base.a.getContext()), str + "_temp");
                    file2.createNewFile();
                    if (!d.a(this.b, new EventListBean(d.a(this.b), (EventBean[]) this.f39319a.toArray(new EventBean[0])), file2)) {
                        t.c(file2);
                        return;
                    }
                    file = new File(com.kc.dw.core.bquery.c.c(com.kc.dw.base.a.getContext()), str);
                    if (!file2.renameTo(file)) {
                        int i = d.j;
                        Log.e("d", "rename error");
                        t.c(file2);
                        return;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (AdSdk.getInitSuccTime() == 0) {
                int i2 = d.j;
                Log.i("d", "SDK no`t init, return");
                return;
            }
            try {
                if (c.f39315a) {
                    if (file != null) {
                        try {
                            if (file.exists()) {
                                c.c.add(file);
                                return;
                            }
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    return;
                }
                try {
                    try {
                        c.f39315a = true;
                        c.a();
                        c.c();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } finally {
                    c.f39315a = false;
                    c.b();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }
}

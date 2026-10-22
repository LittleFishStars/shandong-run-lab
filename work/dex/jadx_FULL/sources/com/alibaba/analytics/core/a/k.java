package com.alibaba.analytics.core.a;

import com.alibaba.analytics.a.x;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class k extends e {
    @Override // com.alibaba.analytics.core.a.e
    public void u() {
        try {
            x.a().submit(new Runnable() { // from class: com.alibaba.analytics.core.a.k.1
                @Override // java.lang.Runnable
                public void run() {
                    k.this.init();
                    k.this.t();
                    e.n("0");
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

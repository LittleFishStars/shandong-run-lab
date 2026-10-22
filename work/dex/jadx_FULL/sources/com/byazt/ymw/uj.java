package com.byazt.ymw;

import android.os.Bundle;
import com.byazt.nr.m;
import com.byazt.omf.z;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 462, 15})
public class uj extends z.c {
    public final com.byazt.tn.tt c;

    public uj(com.byazt.tn.tt ttVar) {
        this.c = ttVar;
    }

    @Override // com.byazt.omf.z
    public Bundle c(int i) {
        com.byazt.tn.tt ttVar = this.c;
        final Bundle bundle = new Bundle();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        if (ttVar != null) {
            ttVar.c(i, new com.byazt.ed.c() { // from class: com.byazt.ymw.uj.1
                @Override // com.byazt.ed.c
                public void onConditionReturn(Bundle bundle2) {
                    bundle.putAll(bundle2);
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await(10L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            m.c(e);
        }
        return bundle;
    }
}

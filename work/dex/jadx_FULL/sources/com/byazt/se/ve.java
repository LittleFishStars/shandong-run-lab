package com.byazt.se;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 671, 54})
public class ve implements Callable<com.byazt.co.c> {
    public final c c;
    public Long tt;

    public ve(c cVar, Long l) {
        this.c = cVar;
        this.tt = l;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public com.byazt.co.c call() throws Exception {
        Future futureC = com.byazt.ww.c.c(new Callable<com.byazt.co.c>() { // from class: com.byazt.se.ve.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public com.byazt.co.c call() throws Exception {
                try {
                    return ve.this.c.c();
                } catch (Exception e) {
                    com.byazt.tf.c.tt("__kiteFingerTask#future call error " + e.getMessage());
                    return new com.byazt.co.c();
                }
            }
        });
        try {
            return this.tt.longValue() > 0 ? (com.byazt.co.c) futureC.get(this.tt.longValue(), TimeUnit.SECONDS) : (com.byazt.co.c) futureC.get();
        } catch (TimeoutException e) {
            com.byazt.tf.c.tt("__kiteFingerTask# collection timed out" + e.getMessage());
            return new com.byazt.co.c();
        }
    }
}

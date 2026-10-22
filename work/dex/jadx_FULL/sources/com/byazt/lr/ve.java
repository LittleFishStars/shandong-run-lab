package com.byazt.lr;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 155, 54})
public class ve extends com.byazt.w.x<Long, com.byazt.nn.tt> {

    @com.byazt.zqa.c(c = {0, 1, 155, 24})
    public static class c {
        public static ve c = new ve();
    }

    public static ve c() {
        return c.c;
    }

    private ve() {
        super(16, 16);
    }

    public void c(com.byazt.nn.tt ttVar) {
        if (ttVar == null) {
            return;
        }
        put(Long.valueOf(ttVar.c()), ttVar);
    }

    public com.byazt.nn.tt c(long j, long j2) {
        return get(get(Long.valueOf(j)) != null ? Long.valueOf(j) : Long.valueOf(j2));
    }
}

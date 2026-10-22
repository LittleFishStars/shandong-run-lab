package com.getui.gtc.e;

import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.db.DbManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f30350a;
    public com.getui.gtc.e.a b;
    private e c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static c f30351a = new c(0);
    }

    private c() {
        try {
            DbManager.init(GtcProvider.context(), b.class, com.getui.gtc.e.a.class, d.class, e.class);
            this.f30350a = (d) DbManager.getTable(b.class, d.class);
            this.c = (e) DbManager.getTable(b.class, e.class);
            this.b = (com.getui.gtc.e.a) DbManager.getTable(b.class, com.getui.gtc.e.a.class);
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.c(th);
        }
    }

    public /* synthetic */ c(byte b) {
        this();
    }
}

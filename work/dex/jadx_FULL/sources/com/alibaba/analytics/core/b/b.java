package com.alibaba.analytics.core.b;

import com.fl.saas.base.cache.DatabaseHelper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    @com.alibaba.analytics.core.b.a.b
    private static boolean F = false;

    @com.alibaba.analytics.core.b.a.a(DatabaseHelper.COLUMN_ID)
    public long _id = -1;

    public void delete() {
        com.alibaba.analytics.core.d.a().m112a().a(this);
    }

    public void store() {
        com.alibaba.analytics.core.d.a().m112a().m107a(this);
    }
}

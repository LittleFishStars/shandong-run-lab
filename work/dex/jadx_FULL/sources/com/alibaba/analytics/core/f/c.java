package com.alibaba.analytics.core.f;

import android.content.Context;
import com.alibaba.analytics.a.j;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class c implements b {
    String aU = "SELECT * FROM %s ORDER BY %s ASC LIMIT %d";
    String aV = "SELECT count(*) FROM %s";
    String aW = "DELETE FROM  %s where _id in ( select _id from %s  ORDER BY priority ASC ,  _id ASC LIMIT %d )";

    public c(Context context) {
    }

    @Override // com.alibaba.analytics.core.f.b
    public synchronized boolean a(List<com.alibaba.analytics.core.model.a> list) {
        com.alibaba.analytics.core.d.a().m112a().insert(list);
        return true;
    }

    @Override // com.alibaba.analytics.core.f.b
    public synchronized int count() {
        return com.alibaba.analytics.core.d.a().m112a().count(com.alibaba.analytics.core.model.a.class);
    }

    @Override // com.alibaba.analytics.core.f.b
    public synchronized int delete(List<com.alibaba.analytics.core.model.a> list) {
        return com.alibaba.analytics.core.d.a().m112a().delete(list);
    }

    @Override // com.alibaba.analytics.core.f.b
    public synchronized List<com.alibaba.analytics.core.model.a> get(int i) {
        return com.alibaba.analytics.core.d.a().m112a().find(com.alibaba.analytics.core.model.a.class, null, "priority DESC , time DESC ", i);
    }

    @Override // com.alibaba.analytics.core.f.b
    public synchronized void updateLogPriority(List<com.alibaba.analytics.core.model.a> list) {
        com.alibaba.analytics.core.d.a().m112a().updateLogPriority(list);
    }

    @Override // com.alibaba.analytics.core.f.b
    public synchronized int a(String str, String str2) {
        j.d();
        return com.alibaba.analytics.core.d.a().m112a().delete(com.alibaba.analytics.core.model.a.class, str + "< ?", new String[]{str2});
    }

    @Override // com.alibaba.analytics.core.f.b
    public int a(int i) {
        j.d();
        String tablename = com.alibaba.analytics.core.d.a().m112a().getTablename(com.alibaba.analytics.core.model.a.class);
        return com.alibaba.analytics.core.d.a().m112a().delete(com.alibaba.analytics.core.model.a.class, " _id in ( select _id from " + tablename + "  ORDER BY priority ASC , _id ASC LIMIT " + i + " )", null);
    }

    @Override // com.alibaba.analytics.core.f.b
    public double a() {
        return com.alibaba.analytics.core.d.a().m112a().a();
    }
}

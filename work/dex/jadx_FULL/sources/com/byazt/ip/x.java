package com.byazt.ip;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1363, 71})
public class x {
    public long c;
    public Map<String, Object> tt = new ConcurrentHashMap();

    public x(long j) {
        this.c = j;
    }

    public long c() {
        return this.c;
    }

    public void c(String str, Object obj) {
        if (str == null || obj == null) {
            return;
        }
        this.tt.put(str, obj);
    }

    public Object c(String str) {
        if (str == null) {
            return null;
        }
        return this.tt.get(str);
    }
}

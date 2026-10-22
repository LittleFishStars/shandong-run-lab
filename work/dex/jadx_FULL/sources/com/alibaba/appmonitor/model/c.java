package com.alibaba.appmonitor.model;

import com.alibaba.appmonitor.event.EventType;
import com.alibaba.appmonitor.event.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c implements com.alibaba.appmonitor.pool.b {
    private Map<a, d> I = Collections.synchronizedMap(new HashMap());

    public d a(Integer num, String str, String str2, String str3, Class<? extends d> cls) {
        a aVarA;
        boolean z;
        d dVar;
        boolean z2 = false;
        if (num.intValue() == EventType.STAT.getEventId()) {
            aVarA = b.a().a(str, str2);
            z = false;
        } else {
            aVarA = (a) com.alibaba.appmonitor.pool.a.a().a(a.class, str, str2, str3);
            z = true;
        }
        if (aVarA == null) {
            return null;
        }
        if (this.I.containsKey(aVarA)) {
            dVar = this.I.get(aVarA);
            z2 = z;
        } else {
            synchronized (c.class) {
                dVar = (d) com.alibaba.appmonitor.pool.a.a().a(cls, num, str, str2, str3);
                this.I.put(aVarA, dVar);
            }
        }
        if (!z2) {
            return dVar;
        }
        com.alibaba.appmonitor.pool.a.a().a(aVarA);
        return dVar;
    }

    @Override // com.alibaba.appmonitor.pool.b
    public void clean() {
        Iterator<d> it = this.I.values().iterator();
        while (it.hasNext()) {
            com.alibaba.appmonitor.pool.a.a().a(it.next());
        }
        this.I.clear();
    }

    @Override // com.alibaba.appmonitor.pool.b
    public void fill(Object... objArr) {
        if (this.I == null) {
            this.I = Collections.synchronizedMap(new HashMap());
        }
    }

    public List<d> getEvents() {
        return new ArrayList(this.I.values());
    }
}

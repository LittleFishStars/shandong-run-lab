package com.alibaba.appmonitor.model;

import com.alibaba.analytics.a.n;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class UTDimensionValueSet extends DimensionValueSet {
    public static UTDimensionValueSet create(Map<String, String> map) {
        return (UTDimensionValueSet) com.alibaba.appmonitor.pool.a.a().a(UTDimensionValueSet.class, map);
    }

    @Override // com.alibaba.mtl.appmonitor.model.DimensionValueSet, com.alibaba.appmonitor.pool.b
    public void clean() {
        super.clean();
    }

    @Override // com.alibaba.mtl.appmonitor.model.DimensionValueSet, com.alibaba.appmonitor.pool.b
    public void fill(Object... objArr) {
        super.fill(objArr);
    }

    public Integer getEventId() {
        int iC;
        String str;
        Map<String, String> map = this.map;
        if (map == null || (str = map.get(LogField.EVENTID.toString())) == null) {
            iC = 0;
        } else {
            try {
                iC = n.c(str);
            } catch (NumberFormatException unused) {
                iC = 0;
            }
        }
        return Integer.valueOf(iC);
    }
}

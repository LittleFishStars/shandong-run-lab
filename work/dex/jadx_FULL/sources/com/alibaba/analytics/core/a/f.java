package com.alibaba.analytics.core.a;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f extends l {
    @Override // com.alibaba.analytics.core.a.l
    public void a(String str, Map<String, String> map) {
        String str2;
        if (!map.containsKey("tpk") || (str2 = map.get("tpk")) == null) {
            return;
        }
        com.alibaba.analytics.core.d.a().c(str2);
        h.f("tpk_md5", com.alibaba.analytics.core.d.a().d());
    }

    @Override // com.alibaba.analytics.core.a.l
    public void o(String str) {
        super.o(str);
    }

    @Override // com.alibaba.analytics.core.a.l
    /* JADX INFO: renamed from: a */
    public String[] mo100a() {
        return new String[]{"ut_bussiness"};
    }
}

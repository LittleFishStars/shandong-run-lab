package com.baidu.platform.core.busline;

import com.baidu.mapapi.search.busline.BusLineSearchOption;
import com.huachenjie.common.constants.UserConstants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b extends com.baidu.platform.base.c {
    public b(BusLineSearchOption busLineSearchOption) {
        a(busLineSearchOption);
    }

    private void a(BusLineSearchOption busLineSearchOption) {
        this.c.a("qt", "bsl");
        this.c.a("rt_info", "1");
        this.c.a("ie", "utf-8");
        this.c.a("oue", "0");
        this.c.a("c", busLineSearchOption.mCity);
        this.c.a(UserConstants.URL_PARAMS.b, busLineSearchOption.mUid);
        this.c.a("t", System.currentTimeMillis() + "");
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.f();
    }
}

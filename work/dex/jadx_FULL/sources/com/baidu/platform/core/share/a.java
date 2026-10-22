package com.baidu.platform.core.share;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.share.LocationShareURLOption;
import com.baidu.platform.comapi.basestruct.Point;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a extends com.baidu.platform.base.c {
    public a(LocationShareURLOption locationShareURLOption) {
        a(locationShareURLOption);
    }

    private void a(LocationShareURLOption locationShareURLOption) {
        this.c.a("qt", "cs");
        Point pointLl2point = CoordUtil.ll2point(locationShareURLOption.mLocation);
        this.c.a("geo", pointLl2point.x + "|" + pointLl2point.y);
        this.c.a("t", locationShareURLOption.mName);
        this.c.a("cnt", locationShareURLOption.mSnippet);
        b(false);
        a(false);
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.h();
    }
}

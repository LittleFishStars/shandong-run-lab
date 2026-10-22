package com.baidu.platform.core.district;

import com.ali.auth.third.login.LoginConstants;
import com.huachenjie.common.constants.UserConstants;
import com.kc.openset.advertisers.hl.HLADNID;
import com.kuaishou.weapon.p0.t;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c extends com.baidu.platform.base.c {
    public c(String str) {
        b(str);
    }

    private void b(String str) {
        this.c.a("qt", LoginConstants.EXT);
        this.c.a("num", HLADNID.Reason.OTHER);
        this.c.a(t.d, "10");
        this.c.a("ie", "utf-8");
        this.c.a("oue", "1");
        this.c.a("res", "api");
        this.c.a("fromproduct", "android_map_sdk");
        this.c.a(UserConstants.URL_PARAMS.b, str);
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.p();
    }
}

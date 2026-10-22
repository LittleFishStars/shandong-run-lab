package com.acse.ottn;

import com.acse.ottn.model.AccessiblityModel;
import com.alibaba.fastjson.JSON;
import java.io.ObjectStreamException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d2 f22943a;

    public static d2 b() {
        if (f22943a == null) {
            synchronized (d2.class) {
                if (f22943a == null) {
                    f22943a = new d2();
                }
            }
        }
        return f22943a;
    }

    public void a() {
        n3.a().b("tb_lj_data", "");
    }

    public final Object c() throws ObjectStreamException {
        return f22943a;
    }

    public void a(AccessiblityModel accessiblityModel) {
        n3.a().b("tb_lj_data", JSON.toJSONString(accessiblityModel));
    }
}

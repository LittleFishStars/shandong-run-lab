package com.byazt.lw;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2104, 66})
public class t extends nu {
    public t() {
        super(com.byazt.zg.ve.MOD);
    }

    @Override // com.byazt.dr.c
    public Object c(Map<String, JSONObject> map) {
        Object objC;
        Object objC2 = this.c.c(map);
        if (objC2 == null || (objC = this.tt.c(map)) == null) {
            return null;
        }
        return com.byazt.kq.a.c((Number) objC2, (Number) objC);
    }
}

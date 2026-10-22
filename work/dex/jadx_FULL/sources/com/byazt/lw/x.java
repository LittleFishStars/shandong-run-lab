package com.byazt.lw;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2104, 71})
public class x extends nu {
    public x() {
        super(com.byazt.zg.ve.LT_EQ);
    }

    @Override // com.byazt.dr.c
    public Object c(Map<String, JSONObject> map) {
        Object objC;
        Object objC2 = this.c.c(map);
        if (objC2 == null || (objC = this.tt.c(map)) == null) {
            return null;
        }
        return Boolean.valueOf(!((Boolean) com.byazt.kq.ve.c(objC2, (Number) objC)).booleanValue());
    }
}

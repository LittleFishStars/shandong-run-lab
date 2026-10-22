package com.byazt.lw;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2104, 215})
public class yp extends nu {
    public yp() {
        super(com.byazt.zg.ve.NOT_EQ);
    }

    @Override // com.byazt.dr.c
    public Object c(Map<String, JSONObject> map) {
        Object objC = this.c.c(map);
        Object objC2 = this.tt.c(map);
        if (objC == null && objC2 == null) {
            return Boolean.FALSE;
        }
        if (objC == null && objC2 != null) {
            return Boolean.TRUE;
        }
        if (objC == null || objC2 != null) {
            return ((objC instanceof Number) && (objC2 instanceof Number)) ? Boolean.valueOf(!com.byazt.kq.tt.c((Number) objC, (Number) objC2)) : Boolean.valueOf(!objC.equals(objC2));
        }
        return Boolean.TRUE;
    }
}

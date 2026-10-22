package com.byazt.lw;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2104, 54})
public class ve extends nu {
    public ve() {
        super(com.byazt.zg.ve.DOUBLE_BAR);
    }

    @Override // com.byazt.dr.c
    public Object c(Map<String, JSONObject> map) {
        return Boolean.valueOf(com.byazt.to.tt.c(this.c.c(map)) || com.byazt.to.tt.c(this.tt.c(map)));
    }

    @Override // com.byazt.lw.nu
    public String toString() {
        return tt();
    }
}

package com.byazt.lw;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2104, 72})
public class da implements com.byazt.dr.c {
    public com.byazt.dr.c[] c;
    public String tt;
    public boolean uj;
    public com.byazt.il.c ve;

    public da(String str) {
        this.tt = str;
    }

    public void c(com.byazt.dr.c[] cVarArr) {
        this.c = cVarArr;
    }

    @Override // com.byazt.dr.c
    public String tt() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.tt);
        sb.append("(");
        com.byazt.dr.c[] cVarArr = this.c;
        if (cVarArr != null && cVarArr.length > 0) {
            int i = 0;
            while (true) {
                com.byazt.dr.c[] cVarArr2 = this.c;
                if (i >= cVarArr2.length) {
                    break;
                }
                sb.append(cVarArr2[i].tt());
                sb.append(",");
                i++;
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean ve() {
        return this.uj;
    }

    public void c(boolean z) {
        this.uj = z;
    }

    @Override // com.byazt.dr.c
    public Object c(Map<String, JSONObject> map) {
        com.byazt.il.c cVar = new com.byazt.il.c();
        this.ve = cVar;
        cVar.c(this.tt);
        Object[] objArr = new Object[this.c.length];
        int i = 0;
        while (true) {
            com.byazt.dr.c[] cVarArr = this.c;
            if (i < cVarArr.length) {
                com.byazt.dr.c cVar2 = cVarArr[i];
                if (cVar2 != null) {
                    objArr[i] = cVar2.c(map);
                }
                i++;
            } else {
                this.ve.c(objArr);
                return com.byazt.fz.rh.c(this.tt).c(map.get("default_key"), objArr);
            }
        }
    }

    @Override // com.byazt.dr.c
    public com.byazt.zg.n c() {
        return com.byazt.zg.tt.METHOD;
    }
}

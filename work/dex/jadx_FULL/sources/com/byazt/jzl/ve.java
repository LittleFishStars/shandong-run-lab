package com.byazt.jzl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1574, 54})
public class ve implements com.byazt.fk.ve {
    public int c;
    public int tt;
    public String ve;

    public ve(int i, int i2) {
        this.c = i;
        this.tt = i2;
    }

    @Override // com.byazt.fk.ve
    public int getCode() {
        return this.c;
    }

    @Override // com.byazt.fk.ve
    public int getExtraCode() {
        return this.tt;
    }

    @Override // com.byazt.fk.ve
    public String getMsg() {
        return this.ve;
    }

    @Override // com.byazt.fk.ve
    public void setCode(int i) {
        this.c = i;
    }

    @Override // com.byazt.fk.ve
    public void setExtraCode(int i) {
        this.tt = i;
    }

    @Override // com.byazt.fk.ve
    public void setMsg(String str) {
        this.ve = str;
    }

    public ve(int i, int i2, String str) {
        this.c = i;
        this.tt = i2;
        this.ve = str;
    }
}

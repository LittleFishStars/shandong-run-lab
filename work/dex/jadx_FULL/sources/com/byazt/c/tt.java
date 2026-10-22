package com.byazt.c;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 20, 13})
public abstract class tt implements qy {
    public boolean c = false;

    @Override // com.byazt.c.qy
    public void c(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.c = true;
    }

    @Override // com.byazt.c.qy
    public boolean c() {
        return this.c;
    }
}

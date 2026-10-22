package com.byazt.gu;

import com.byazt.eg.gu;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 17, 91})
public class sp extends com.byazt.gqp.uj {
    public gu c;

    public sp(gu guVar) {
        this.c = guVar;
    }

    @Override // com.byazt.gqp.uj
    public void c(int i) {
        this.c.my().c(i);
    }

    @Override // com.byazt.gqp.uj
    public void tt(int i) {
        if (i < 5) {
            this.c.my().tt(5);
        } else {
            this.c.my().tt(i);
        }
    }
}

package com.byazt.ab;

import com.byazt.nr.x;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 757, 15})
public class uj extends com.byazt.wgf.tt {
    public uj(int i, int i2) {
        super(i, i2);
    }

    @Override // com.byazt.wgf.tt, com.byazt.wgf.c
    public void c(List<File> list) {
        int size = list.size();
        if (c(0L, size)) {
            return;
        }
        for (File file : list) {
            x.ve(file);
            size--;
            if (c(file, 0L, size)) {
                return;
            }
        }
    }
}

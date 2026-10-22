package com.byazt.aq;

import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1950, 42})
public class i {
    public float c;
    public float tt;

    public i(float f, float f2) {
        this.c = f;
        this.tt = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            i iVar = (i) obj;
            if (Float.compare(iVar.c, this.c) == 0 && Float.compare(iVar.tt, this.tt) == 0) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.c), Float.valueOf(this.tt)});
    }
}

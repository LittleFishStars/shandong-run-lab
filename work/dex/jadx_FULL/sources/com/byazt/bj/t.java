package com.byazt.bj;

import com.byakv.q.YogaNative;
import com.byakv.q.YogaNodeJNIBase;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 224, 66})
public class t extends YogaNodeJNIBase {
    public void finalize() throws Throwable {
        try {
            u();
        } finally {
            super.finalize();
        }
    }

    public void u() {
        long j = this.c;
        if (j != 0) {
            this.c = 0L;
            YogaNative.jni_YGNodeFinalizeJNI(j);
        }
    }
}

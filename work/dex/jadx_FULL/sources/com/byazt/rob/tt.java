package com.byazt.rob;

import android.os.Bundle;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1211, 13})
public class tt {
    public static tt c;
    public Map<Integer, Bundle> tt = Collections.synchronizedMap(new HashMap());

    private tt() {
    }

    public static synchronized tt c() {
        if (c == null) {
            c = new tt();
        }
        return c;
    }

    public void tt(int i) {
        this.tt.remove(Integer.valueOf(i));
    }

    public void c(int i, Bundle bundle) {
        this.tt.put(Integer.valueOf(i), bundle);
    }

    public Bundle c(int i) {
        return this.tt.get(Integer.valueOf(i));
    }
}

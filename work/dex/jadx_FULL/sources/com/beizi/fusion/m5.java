package com.beizi.fusion;

import com.zj.adlib.ze1;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class m5 extends HashMap {
    public m5() {
        put("Accept", "*/*");
        put("Content-Type", ze1.g);
        put("Connection", "keep-alive");
    }

    public static m5 a() {
        return new m5();
    }
}

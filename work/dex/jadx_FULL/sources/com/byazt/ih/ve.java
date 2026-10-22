package com.byazt.ih;

import android.util.SparseArray;
import com.byazt.yxi.uj;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1573, 54})
public final class ve {
    public final String c;
    public final String n;
    public final String tt;
    public final int uj;
    public final int ve;

    public ve(String str, String str2, int i, int i2, String str3) {
        this.c = str;
        this.tt = str2;
        this.ve = i;
        this.uj = i2;
        this.n = str3;
    }

    public SparseArray<Object> c() {
        uj ujVarC = uj.c();
        ujVarC.c(8003, this.c);
        ujVarC.c(2, this.tt);
        ujVarC.c(AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes, Integer.valueOf(this.ve));
        ujVarC.c(8094, Integer.valueOf(this.uj));
        ujVarC.c(8547, this.n);
        if (com.byazt.bp.c.t().nb() != null) {
            HashMap map = new HashMap();
            map.put("live_ad_custom_config", com.byazt.bp.c.t().nb());
            ujVarC.c(8075, map);
        }
        return ujVarC.tt();
    }

    public int tt() {
        return this.ve;
    }
}

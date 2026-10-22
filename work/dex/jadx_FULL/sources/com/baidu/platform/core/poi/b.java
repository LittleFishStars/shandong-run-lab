package com.baidu.platform.core.poi;

import com.aliyun.vod.log.struct.AliyunLogKey;
import com.baidu.mapapi.search.poi.PoiIndoorOption;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b extends com.baidu.platform.base.c {
    public b(PoiIndoorOption poiIndoorOption) {
        a(poiIndoorOption);
    }

    private void a(PoiIndoorOption poiIndoorOption) {
        this.c.a("qt", "indoor_s");
        this.c.a("x", "0");
        this.c.a("y", "0");
        this.c.a("from", "android_map_sdk");
        String str = poiIndoorOption.bid;
        if (str != null && !str.equals("")) {
            this.c.a("bid", str);
        }
        String str2 = poiIndoorOption.wd;
        if (str2 != null && !str2.equals("")) {
            this.c.a(AliyunLogKey.KEY_WIDTH, str2);
        }
        String str3 = poiIndoorOption.floor;
        if (str3 != null && !str3.equals("")) {
            this.c.a("floor", str3);
        }
        this.c.a("current", poiIndoorOption.currentPage + "");
        this.c.a("pageSize", poiIndoorOption.pageSize + "");
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.c();
    }
}

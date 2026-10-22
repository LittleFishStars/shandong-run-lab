package com.baidu.platform.core.district;

import com.aliyun.vod.log.struct.AliyunLogKey;
import com.baidu.mapapi.search.district.DistrictSearchOption;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a extends com.baidu.platform.base.c {
    public a(DistrictSearchOption districtSearchOption) {
        a(districtSearchOption);
    }

    private void a(DistrictSearchOption districtSearchOption) {
        if (districtSearchOption == null) {
            return;
        }
        this.c.a("qt", "con");
        this.c.a("rp_format", "json");
        this.c.a("rp_filter", "mobile");
        this.c.a("area_res", "true");
        this.c.a("addr_identify", "1");
        this.c.a("ie", "utf-8");
        this.c.a(AliyunLogKey.KEY_PART_NUMBER, "0");
        this.c.a("rn", "10");
        this.c.a("c", districtSearchOption.mCityName);
        String str = districtSearchOption.mDistrictName;
        if (str == null || str.equals("")) {
            this.c.a(AliyunLogKey.KEY_WIDTH, districtSearchOption.mCityName);
        } else {
            this.c.a(AliyunLogKey.KEY_WIDTH, districtSearchOption.mDistrictName);
        }
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.j();
    }
}

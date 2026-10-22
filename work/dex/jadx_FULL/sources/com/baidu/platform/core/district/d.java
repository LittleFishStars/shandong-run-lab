package com.baidu.platform.core.district;

import com.baidu.mapapi.search.district.DistrictSearchOption;
import com.baidu.mapapi.search.district.OnGetDistricSearchResultListener;
import com.baidu.platform.base.SearchType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class d extends com.baidu.platform.base.a implements IDistrictSearch {
    private OnGetDistricSearchResultListener g = null;

    @Override // com.baidu.platform.core.district.IDistrictSearch
    public void destroy() {
        this.c.lock();
        this.g = null;
        this.c.unlock();
    }

    @Override // com.baidu.platform.core.district.IDistrictSearch
    public boolean searchDistrict(DistrictSearchOption districtSearchOption) {
        b bVar = new b();
        bVar.a(SearchType.DISTRICT_SEARCH);
        return a(new a(districtSearchOption), this.g, bVar);
    }

    @Override // com.baidu.platform.core.district.IDistrictSearch
    public void setOnDistrictSearchListener(OnGetDistricSearchResultListener onGetDistricSearchResultListener) {
        this.c.lock();
        this.g = onGetDistricSearchResultListener;
        this.c.unlock();
    }
}

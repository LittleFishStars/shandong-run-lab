package com.baidu.platform.core.district;

import com.baidu.mapapi.search.district.DistrictSearchOption;
import com.baidu.mapapi.search.district.OnGetDistricSearchResultListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface IDistrictSearch {
    void destroy();

    boolean searchDistrict(DistrictSearchOption districtSearchOption);

    void setOnDistrictSearchListener(OnGetDistricSearchResultListener onGetDistricSearchResultListener);
}

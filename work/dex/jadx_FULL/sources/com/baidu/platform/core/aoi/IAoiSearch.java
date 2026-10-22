package com.baidu.platform.core.aoi;

import com.baidu.mapapi.search.aoi.AoiSearchOption;
import com.baidu.mapapi.search.aoi.OnGetAoiSearchResultListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface IAoiSearch {
    void destroy();

    boolean searchAoi(AoiSearchOption aoiSearchOption);

    void setOnAoiSearchListener(OnGetAoiSearchResultListener onGetAoiSearchResultListener);
}

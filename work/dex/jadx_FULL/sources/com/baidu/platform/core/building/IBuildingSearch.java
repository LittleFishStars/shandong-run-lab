package com.baidu.platform.core.building;

import com.baidu.mapapi.search.building.BuildingSearchOption;
import com.baidu.mapapi.search.building.OnGetBuildingSearchResultListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface IBuildingSearch {
    void destroy();

    boolean searchBuilding(BuildingSearchOption buildingSearchOption);

    void setOnBuildingSearchListener(OnGetBuildingSearchResultListener onGetBuildingSearchResultListener);
}

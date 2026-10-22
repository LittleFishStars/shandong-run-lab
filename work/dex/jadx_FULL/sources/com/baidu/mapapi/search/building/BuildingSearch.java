package com.baidu.mapapi.search.building;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BuildingSearch extends b {
    private boolean b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.baidu.platform.core.building.b f26506a = new com.baidu.platform.core.building.b();

    public static BuildingSearch newInstance() {
        BMapManager.init();
        return new BuildingSearch();
    }

    public void destroy() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.f26506a.destroy();
        BMapManager.destroy();
    }

    public boolean requestBuilding(BuildingSearchOption buildingSearchOption) {
        if (this.f26506a == null) {
            throw new IllegalStateException("BDMapSDKException: BuildingSearch is null, please call newInstance() first.");
        }
        if (buildingSearchOption == null || buildingSearchOption.getLatLng() == null) {
            throw new IllegalStateException("BDMapSDKException: option or location can not be null");
        }
        return this.f26506a.searchBuilding(buildingSearchOption);
    }

    public void setOnGetBuildingSearchResultListener(OnGetBuildingSearchResultListener onGetBuildingSearchResultListener) {
        com.baidu.platform.core.building.b bVar = this.f26506a;
        if (bVar == null) {
            throw new IllegalStateException("BDMapSDKException: BuildingSearch is null, please call newInstance first.");
        }
        if (onGetBuildingSearchResultListener == null) {
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        bVar.setOnBuildingSearchListener(onGetBuildingSearchResultListener);
    }
}

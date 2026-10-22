package com.baidu.mapapi.search.aoi;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AoiSearch extends b {
    private boolean b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.baidu.platform.core.aoi.b f26504a = new com.baidu.platform.core.aoi.b();

    public static AoiSearch newInstance() {
        BMapManager.init();
        return new AoiSearch();
    }

    public void destroy() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.f26504a.destroy();
        BMapManager.destroy();
    }

    public boolean requestAoi(AoiSearchOption aoiSearchOption) {
        if (this.f26504a == null) {
            throw new IllegalStateException("BDMapSDKException: AoiSearch is null, please call newInstance() first.");
        }
        if (aoiSearchOption == null || aoiSearchOption.getLatLngList() == null || aoiSearchOption.getLatLngList().size() <= 0) {
            throw new IllegalStateException("BDMapSDKException: option or location can not be null");
        }
        return this.f26504a.searchAoi(aoiSearchOption);
    }

    public void setOnGetAoiSearchResultListener(OnGetAoiSearchResultListener onGetAoiSearchResultListener) {
        com.baidu.platform.core.aoi.b bVar = this.f26504a;
        if (bVar == null) {
            throw new IllegalStateException("BDMapSDKException: AoiSearch is null, please call newInstance first.");
        }
        if (onGetAoiSearchResultListener == null) {
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        bVar.setOnAoiSearchListener(onGetAoiSearchResultListener);
    }
}

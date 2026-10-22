package com.baidu.platform.core.aoi;

import com.baidu.mapapi.search.aoi.AoiSearchOption;
import com.baidu.mapapi.search.aoi.OnGetAoiSearchResultListener;
import com.baidu.platform.base.SearchType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b extends com.baidu.platform.base.a implements IAoiSearch {
    private OnGetAoiSearchResultListener g;

    @Override // com.baidu.platform.core.aoi.IAoiSearch
    public void destroy() {
        this.c.lock();
        this.g = null;
        this.c.unlock();
    }

    @Override // com.baidu.platform.core.aoi.IAoiSearch
    public boolean searchAoi(AoiSearchOption aoiSearchOption) {
        a aVar = new a();
        aVar.a(SearchType.AOI_SEARCH);
        return a(new c(aoiSearchOption), this.g, aVar);
    }

    @Override // com.baidu.platform.core.aoi.IAoiSearch
    public void setOnAoiSearchListener(OnGetAoiSearchResultListener onGetAoiSearchResultListener) {
        this.c.lock();
        this.g = onGetAoiSearchResultListener;
        this.c.unlock();
    }
}

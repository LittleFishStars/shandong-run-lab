package com.baidu.platform.core.geocode;

import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.platform.base.SearchType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a extends com.baidu.platform.base.a implements IGeoCoder {
    OnGetGeoCoderResultListener g = null;

    @Override // com.baidu.platform.core.geocode.IGeoCoder
    public void destroy() {
        this.c.lock();
        this.g = null;
        this.c.unlock();
    }

    @Override // com.baidu.platform.core.geocode.IGeoCoder
    public boolean geocode(GeoCodeOption geoCodeOption) {
        b bVar = new b();
        com.baidu.platform.base.c cVar = new c(geoCodeOption);
        bVar.a(SearchType.GEO_CODER);
        if (geoCodeOption != null) {
            bVar.b(geoCodeOption.getAddress());
        }
        return a(cVar, this.g, bVar);
    }

    @Override // com.baidu.platform.core.geocode.IGeoCoder
    public boolean reverseGeoCode(ReverseGeoCodeOption reverseGeoCodeOption) {
        d dVar = new d();
        e eVar = new e(reverseGeoCodeOption);
        dVar.a(SearchType.REVERSE_GEO_CODER);
        return a(eVar, this.g, dVar);
    }

    @Override // com.baidu.platform.core.geocode.IGeoCoder
    public void setOnGetGeoCodeResultListener(OnGetGeoCoderResultListener onGetGeoCoderResultListener) {
        this.c.lock();
        this.g = onGetGeoCoderResultListener;
        this.c.unlock();
    }
}

package com.baidu.platform.core.poi;

import android.util.Log;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.amap.api.maps.AMap;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.mapapi.search.poi.PoiDetailSearchOption;
import com.bykv.vk.component.ttvideo.player.MediaFormat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class d extends com.baidu.platform.base.c {
    public d(PoiDetailSearchOption poiDetailSearchOption) {
        a(poiDetailSearchOption);
    }

    private void a(PoiDetailSearchOption poiDetailSearchOption) {
        if (poiDetailSearchOption == null) {
            Log.e(d.class.getSimpleName(), "Option is null");
            return;
        }
        if (!poiDetailSearchOption.isSearchByUids()) {
            poiDetailSearchOption.poiUids(poiDetailSearchOption.getUid());
        }
        if (poiDetailSearchOption.mLanguageType == LanguageType.LanguageTypeEnglish) {
            this.c.a(MediaFormat.KEY_LANGUAGE, AMap.ENGLISH);
        }
        this.c.a("photo_show", poiDetailSearchOption.isShowPhoto() ? "true" : AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        this.c.a("uids", poiDetailSearchOption.getUids());
        this.c.a("extensions_adcode", poiDetailSearchOption.isExtendAdcode() ? "true" : AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
        this.c.a(com.alibaba.ariver.remotedebug.b.c.g, "json");
        this.c.a("scope", "2");
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.v();
    }
}

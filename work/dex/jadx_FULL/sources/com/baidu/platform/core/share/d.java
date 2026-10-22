package com.baidu.platform.core.share;

import android.text.TextUtils;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.amap.api.maps.AMap;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.search.share.RouteShareURLOption;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.platform.comapi.basestruct.Point;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class d extends com.baidu.platform.base.c {
    public d(RouteShareURLOption routeShareURLOption) {
        a(routeShareURLOption);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:38:0x01d7  */
    private void a(RouteShareURLOption routeShareURLOption) {
        String str;
        String str2;
        String str3;
        String str4;
        com.baidu.platform.util.a aVar = new com.baidu.platform.util.a();
        Point pointLl2point = CoordUtil.ll2point(routeShareURLOption.mFrom.getLocation());
        Point pointLl2point2 = CoordUtil.ll2point(routeShareURLOption.mTo.getLocation());
        String str5 = "2$$$$$$";
        if (pointLl2point != null) {
            str = "1$$$$" + pointLl2point.x + "," + pointLl2point.y + "$$";
        } else {
            str = "2$$$$$$";
        }
        String name = routeShareURLOption.mFrom.getName();
        String str6 = "";
        if (name == null || name.equals("")) {
            name = "起点";
        }
        String str7 = str + name + "$$0$$$$";
        if (pointLl2point2 != null) {
            str5 = "1$$$$" + pointLl2point2.x + "," + pointLl2point2.y + "$$";
        }
        String name2 = routeShareURLOption.mTo.getName();
        if (name2 == null || name2.equals("")) {
            name2 = "终点";
        }
        String str8 = str5 + name2 + "$$0$$$$";
        int iOrdinal = routeShareURLOption.mMode.ordinal();
        if (iOrdinal == 0) {
            aVar.a("sc", b(routeShareURLOption.mFrom.getCity()) + "");
            aVar.a(AliyunLogKey.KEY_ERROR_CODE, b(routeShareURLOption.mTo.getCity()) + "");
            str2 = "&sharecallbackflag=carRoute";
            str3 = "nav";
        } else {
            if (iOrdinal != 1) {
                if (iOrdinal == 2) {
                    aVar.a("sc", b(routeShareURLOption.mFrom.getCity()) + "");
                    aVar.a(AliyunLogKey.KEY_ERROR_CODE, b(routeShareURLOption.mTo.getCity()) + "");
                    str2 = "&sharecallbackflag=cycleRoute";
                    str3 = "cycle";
                } else if (iOrdinal != 3) {
                    str4 = "";
                } else {
                    str4 = "&i=" + routeShareURLOption.mPn + ",1,1&sharecallbackflag=busRoute";
                    aVar.a("c", routeShareURLOption.mCityCode + "");
                    str6 = "bt";
                }
                aVar.a("sn", str7);
                aVar.a(AMap.ENGLISH, str8);
                if (!TextUtils.isEmpty(routeShareURLOption.mFrom.getPoiId())) {
                    aVar.a("origin_uid", routeShareURLOption.mFrom.getPoiId());
                }
                if (!TextUtils.isEmpty(routeShareURLOption.mTo.getPoiId())) {
                    aVar.a("destination_uid", routeShareURLOption.mTo.getPoiId());
                }
                this.c.a("url", "https://map.baidu.com/?newmap=1&s=" + str6 + (AppMD5.encodeUrlParamsValue("&" + aVar.a() + ("&start=" + name + "&end=" + name2)) + str4));
                this.c.a("from", "android_map_sdk");
            }
            aVar.a("sc", b(routeShareURLOption.mFrom.getCity()) + "");
            aVar.a(AliyunLogKey.KEY_ERROR_CODE, b(routeShareURLOption.mTo.getCity()) + "");
            str2 = "&sharecallbackflag=footRoute";
            str3 = "walk";
        }
        String str9 = str2;
        str6 = str3;
        str4 = str9;
        aVar.a("sn", str7);
        aVar.a(AMap.ENGLISH, str8);
        if (!TextUtils.isEmpty(routeShareURLOption.mFrom.getPoiId())) {
            aVar.a("origin_uid", routeShareURLOption.mFrom.getPoiId());
        }
        if (!TextUtils.isEmpty(routeShareURLOption.mTo.getPoiId())) {
            aVar.a("destination_uid", routeShareURLOption.mTo.getPoiId());
        }
        this.c.a("url", "https://map.baidu.com/?newmap=1&s=" + str6 + (AppMD5.encodeUrlParamsValue("&" + aVar.a() + ("&start=" + name + "&end=" + name2)) + str4));
        this.c.a("from", "android_map_sdk");
    }

    private int b(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.o();
    }
}

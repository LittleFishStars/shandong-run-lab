package com.baidu.platform.core.weather;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.amap.api.maps.AMap;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.LanguageType;
import com.baidu.mapapi.search.weather.WeatherDataType;
import com.baidu.mapapi.search.weather.WeatherSearchOption;
import com.baidu.mapapi.search.weather.WeatherServerType;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.bykv.vk.component.ttvideo.player.MediaFormat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b extends com.baidu.platform.base.c {
    WeatherSearchOption d;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f26802a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[LanguageType.values().length];
            c = iArr;
            try {
                iArr[LanguageType.LanguageTypeEnglish.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[LanguageType.LanguageTypeChinese.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[CoordType.values().length];
            b = iArr2;
            try {
                iArr2[CoordType.BD09LL.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[CoordType.GCJ02.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[WeatherDataType.values().length];
            f26802a = iArr3;
            try {
                iArr3[WeatherDataType.WEATHER_DATA_TYPE_REAL_TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f26802a[WeatherDataType.WEATHER_DATA_TYPE_FORECASTS_FOR_DAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f26802a[WeatherDataType.WEATHER_DATA_TYPE_FORECASTS_FOR_HOUR.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f26802a[WeatherDataType.WEATHER_DATA_TYPE_LIFE_INDEX.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f26802a[WeatherDataType.WEATHER_DATA_TYPE_ALERT.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f26802a[WeatherDataType.WEATHER_DATA_TYPE_ALL.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public b(WeatherSearchOption weatherSearchOption) {
        this.d = weatherSearchOption;
        a(weatherSearchOption);
    }

    private void a(WeatherSearchOption weatherSearchOption) {
        if (!TextUtils.isEmpty(weatherSearchOption.getDistrictID())) {
            this.c.a("district_id", weatherSearchOption.getDistrictID());
        }
        if (weatherSearchOption.getLocation() != null) {
            LatLng latLng = new LatLng(weatherSearchOption.getLocation().latitude, weatherSearchOption.getLocation().longitude);
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                latLng = CoordTrans.gcjToBaidu(latLng);
            }
            this.c.a(RequestParameters.SUBRESOURCE_LOCATION, latLng.longitude + "," + latLng.latitude);
            this.c.a("coordtype", a(CoordType.BD09LL));
        }
        if (weatherSearchOption.getDataType() != null) {
            this.c.a("data_type", a(weatherSearchOption.getDataType()));
        }
        if (weatherSearchOption.getLanguageType() != null) {
            this.c.a(MediaFormat.KEY_LANGUAGE, a(weatherSearchOption.getLanguageType()));
        }
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        WeatherSearchOption weatherSearchOption = this.d;
        if (weatherSearchOption == null) {
            return "";
        }
        if (weatherSearchOption.getServerType() == WeatherServerType.LANGUAGE_SERVER_TYPE_ABROAD) {
            return bVar.g();
        }
        return bVar.k();
    }

    private String a(WeatherDataType weatherDataType) {
        switch (a.f26802a[weatherDataType.ordinal()]) {
            case 1:
                return "now";
            case 2:
                return AliyunLogKey.KEY_FILL_COLOR;
            case 3:
                return "fc_hour";
            case 4:
                return "index";
            case 5:
                return "alert";
            case 6:
                return "all";
            default:
                return "";
        }
    }

    private String a(CoordType coordType) {
        int i = a.b[coordType.ordinal()];
        if (i != 1) {
            return i != 2 ? "" : "gcj02";
        }
        return "bd09ll";
    }

    private String a(LanguageType languageType) {
        int i = a.c[languageType.ordinal()];
        if (i != 1) {
            return i != 2 ? "" : "cn";
        }
        return AMap.ENGLISH;
    }
}

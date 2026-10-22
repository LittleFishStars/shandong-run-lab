package com.baidu.mapapi.search.weather;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.search.core.b;
import com.baidu.platform.core.weather.IWeatherSearch;
import com.baidu.platform.core.weather.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class WeatherSearch extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    IWeatherSearch f26581a = new c();

    public static WeatherSearch newInstance() {
        BMapManager.init();
        return new WeatherSearch();
    }

    public void destroy() {
        IWeatherSearch iWeatherSearch = this.f26581a;
        if (iWeatherSearch != null) {
            iWeatherSearch.destroy();
        }
        BMapManager.destroy();
    }

    public boolean request(WeatherSearchOption weatherSearchOption) {
        IWeatherSearch iWeatherSearch = this.f26581a;
        if (iWeatherSearch == null) {
            throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
        }
        if (weatherSearchOption != null) {
            return iWeatherSearch.searchWeather(weatherSearchOption);
        }
        throw new IllegalArgumentException("BDMapSDKException: option can not be null");
    }

    public void setWeatherSearchResultListener(OnGetWeatherResultListener onGetWeatherResultListener) {
        IWeatherSearch iWeatherSearch = this.f26581a;
        if (iWeatherSearch == null) {
            throw new IllegalStateException("BDMapSDKException: searcher is null, please call newInstance first.");
        }
        if (onGetWeatherResultListener == null) {
            throw new IllegalArgumentException("BDMapSDKException: listener can not be null");
        }
        iWeatherSearch.setOnGetWeatherSearchResultListener(onGetWeatherResultListener);
    }
}

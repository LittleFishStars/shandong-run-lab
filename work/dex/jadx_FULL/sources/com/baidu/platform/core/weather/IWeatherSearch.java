package com.baidu.platform.core.weather;

import com.baidu.mapapi.search.weather.OnGetWeatherResultListener;
import com.baidu.mapapi.search.weather.WeatherSearchOption;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface IWeatherSearch {
    void destroy();

    boolean searchWeather(WeatherSearchOption weatherSearchOption);

    void setOnGetWeatherSearchResultListener(OnGetWeatherResultListener onGetWeatherResultListener);
}

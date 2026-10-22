package com.baidu.platform.core.weather;

import com.baidu.mapapi.search.weather.OnGetWeatherResultListener;
import com.baidu.mapapi.search.weather.WeatherSearchOption;
import com.baidu.platform.base.SearchType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c extends com.baidu.platform.base.a implements IWeatherSearch {
    private OnGetWeatherResultListener g;

    @Override // com.baidu.platform.core.weather.IWeatherSearch
    public void destroy() {
        this.c.lock();
        this.g = null;
        this.c.unlock();
    }

    @Override // com.baidu.platform.core.weather.IWeatherSearch
    public boolean searchWeather(WeatherSearchOption weatherSearchOption) {
        a aVar = new a();
        aVar.a(SearchType.WEATHER_SEARCH);
        return a(new b(weatherSearchOption), this.g, aVar);
    }

    @Override // com.baidu.platform.core.weather.IWeatherSearch
    public void setOnGetWeatherSearchResultListener(OnGetWeatherResultListener onGetWeatherResultListener) {
        this.c.lock();
        this.g = onGetWeatherResultListener;
        this.c.unlock();
    }
}

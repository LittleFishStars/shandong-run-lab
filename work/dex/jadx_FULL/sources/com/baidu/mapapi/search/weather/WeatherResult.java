package com.baidu.mapapi.search.weather;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class WeatherResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<WeatherResult> CREATOR = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeatherSearchRealTime f26580a;
    private WeatherSearchLocation b;
    private List<WeatherSearchForecasts> c;
    private List<WeatherSearchForecastForHours> d;
    private List<WeatherLifeIndexes> e;
    private List<WeatherSearchAlerts> f;

    public static class a implements Parcelable.Creator<WeatherResult> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public WeatherResult createFromParcel(Parcel parcel) {
            return new WeatherResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public WeatherResult[] newArray(int i) {
            return new WeatherResult[i];
        }
    }

    public WeatherResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<WeatherSearchForecastForHours> getForecastHours() {
        return this.d;
    }

    public List<WeatherSearchForecasts> getForecasts() {
        return this.c;
    }

    public List<WeatherLifeIndexes> getLifeIndexes() {
        return this.e;
    }

    public WeatherSearchLocation getLocation() {
        return this.b;
    }

    public WeatherSearchRealTime getRealTimeWeather() {
        return this.f26580a;
    }

    public List<WeatherSearchAlerts> getWeatherAlerts() {
        return this.f;
    }

    public void setForecastHours(List<WeatherSearchForecastForHours> list) {
        this.d = list;
    }

    public void setForecasts(List<WeatherSearchForecasts> list) {
        this.c = list;
    }

    public void setLifeIndexes(List<WeatherLifeIndexes> list) {
        this.e = list;
    }

    public void setLocation(WeatherSearchLocation weatherSearchLocation) {
        this.b = weatherSearchLocation;
    }

    public void setRealTimeWeather(WeatherSearchRealTime weatherSearchRealTime) {
        this.f26580a = weatherSearchRealTime;
    }

    public void setWeatherAlerts(List<WeatherSearchAlerts> list) {
        this.f = list;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f26580a, i);
        parcel.writeParcelable(this.b, i);
        parcel.writeTypedList(this.c);
        parcel.writeTypedList(this.d);
        parcel.writeTypedList(this.e);
        parcel.writeTypedList(this.f);
    }

    public WeatherResult(Parcel parcel) {
        super(parcel);
        this.f26580a = (WeatherSearchRealTime) parcel.readParcelable(WeatherSearchRealTime.class.getClassLoader());
        this.b = (WeatherSearchLocation) parcel.readParcelable(WeatherSearchLocation.class.getClassLoader());
        this.c = parcel.createTypedArrayList(WeatherSearchForecasts.CREATOR);
        this.d = parcel.createTypedArrayList(WeatherSearchForecastForHours.CREATOR);
        this.e = parcel.createTypedArrayList(WeatherLifeIndexes.CREATOR);
        this.f = parcel.createTypedArrayList(WeatherSearchAlerts.CREATOR);
    }
}

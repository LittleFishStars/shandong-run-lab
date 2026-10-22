package com.baidu.platform.core.weather;

import com.alibaba.ariver.commonability.device.proxy.RVCommonAbilityProxy;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.weather.OnGetWeatherResultListener;
import com.baidu.mapapi.search.weather.WeatherLifeIndexes;
import com.baidu.mapapi.search.weather.WeatherResult;
import com.baidu.mapapi.search.weather.WeatherSearchAlerts;
import com.baidu.mapapi.search.weather.WeatherSearchForecastForHours;
import com.baidu.mapapi.search.weather.WeatherSearchForecasts;
import com.baidu.mapapi.search.weather.WeatherSearchLocation;
import com.baidu.mapapi.search.weather.WeatherSearchRealTime;
import com.zj.adlib.ze1;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class a extends com.baidu.platform.base.b {
    private boolean b(JSONObject jSONObject, WeatherResult weatherResult) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject == null || weatherResult == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray("forecast_hours")) == null) {
            return false;
        }
        if (weatherResult.getForecastHours() == null) {
            weatherResult.setForecastHours(new ArrayList());
        }
        JSONObject jSONObject2 = null;
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            try {
                jSONObject2 = (JSONObject) jSONArrayOptJSONArray.get(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (jSONObject2 != null) {
                WeatherSearchForecastForHours weatherSearchForecastForHours = new WeatherSearchForecastForHours();
                weatherSearchForecastForHours.setClouds(jSONObject2.optInt("clouds"));
                weatherSearchForecastForHours.setDataTime(jSONObject2.optString("data_time"));
                weatherSearchForecastForHours.setHourlyPrecipitation(jSONObject2.optInt("prec_1h"));
                weatherSearchForecastForHours.setRelativeHumidity(jSONObject2.optInt("rh"));
                weatherSearchForecastForHours.setTemperature(jSONObject2.optInt("temp_fc"));
                weatherSearchForecastForHours.setPhenomenon(jSONObject2.optString("text"));
                weatherSearchForecastForHours.setWindDirection(jSONObject2.optString("wind_dir"));
                weatherSearchForecastForHours.setWindPower(jSONObject2.optString("wind_class"));
                weatherResult.getForecastHours().add(weatherSearchForecastForHours);
            }
        }
        return true;
    }

    private boolean c(JSONObject jSONObject, WeatherResult weatherResult) {
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObject2;
        JSONException e;
        if (jSONObject == null || weatherResult == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray("forecasts")) == null) {
            return false;
        }
        if (weatherResult.getForecasts() == null) {
            weatherResult.setForecasts(new ArrayList());
        }
        JSONObject jSONObject3 = null;
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            try {
                jSONObject2 = (JSONObject) jSONArrayOptJSONArray.get(i);
                try {
                    new WeatherSearchForecasts();
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                }
            } catch (JSONException e3) {
                jSONObject2 = jSONObject3;
                e = e3;
            }
            jSONObject3 = jSONObject2;
            if (jSONObject3 != null) {
                WeatherSearchForecasts weatherSearchForecasts = new WeatherSearchForecasts();
                weatherSearchForecasts.setDate(jSONObject3.optString("date"));
                weatherSearchForecasts.setHighestTemp(jSONObject3.optInt(RVCommonAbilityProxy.HIGH));
                weatherSearchForecasts.setLowestTemp(jSONObject3.optInt(RVCommonAbilityProxy.LOW));
                weatherSearchForecasts.setPhenomenonDay(jSONObject3.optString("text_day"));
                weatherSearchForecasts.setPhenomenonNight(jSONObject3.optString("text_night"));
                weatherSearchForecasts.setWeek(jSONObject3.optString("week"));
                weatherSearchForecasts.setWindDirectionDay(jSONObject3.optString("wd_day"));
                weatherSearchForecasts.setWindPowerDay(jSONObject3.optString("wc_day"));
                weatherSearchForecasts.setWindDirectionNight(jSONObject3.optString("wd_night"));
                weatherSearchForecasts.setWindPowerNight(jSONObject3.optString("wc_night"));
                weatherSearchForecasts.setAirQualityIndex(jSONObject3.optInt("aqi"));
                weatherResult.getForecasts().add(weatherSearchForecasts);
            }
        }
        return true;
    }

    private boolean d(JSONObject jSONObject, WeatherResult weatherResult) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject == null || weatherResult == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray("indexes")) == null) {
            return false;
        }
        if (weatherResult.getLifeIndexes() == null) {
            weatherResult.setLifeIndexes(new ArrayList());
        }
        JSONObject jSONObject2 = null;
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            try {
                jSONObject2 = (JSONObject) jSONArrayOptJSONArray.get(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (jSONObject2 != null) {
                WeatherLifeIndexes weatherLifeIndexes = new WeatherLifeIndexes();
                weatherLifeIndexes.setBrief(jSONObject2.optString("brief"));
                weatherLifeIndexes.setDetail(jSONObject2.optString("detail"));
                weatherLifeIndexes.setName(jSONObject2.optString("name"));
                weatherResult.getLifeIndexes().add(weatherLifeIndexes);
            }
        }
        return true;
    }

    private boolean e(JSONObject jSONObject, WeatherResult weatherResult) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || weatherResult == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject(RequestParameters.SUBRESOURCE_LOCATION)) == null) {
            return false;
        }
        if (weatherResult.getLocation() != null) {
            a(weatherResult.getLocation(), jSONObjectOptJSONObject);
            return true;
        }
        WeatherSearchLocation weatherSearchLocation = new WeatherSearchLocation();
        a(weatherSearchLocation, jSONObjectOptJSONObject);
        weatherResult.setLocation(weatherSearchLocation);
        return true;
    }

    private boolean f(JSONObject jSONObject, WeatherResult weatherResult) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || weatherResult == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("now")) == null) {
            return false;
        }
        if (weatherResult.getRealTimeWeather() != null) {
            a(weatherResult.getRealTimeWeather(), jSONObjectOptJSONObject);
            return true;
        }
        WeatherSearchRealTime weatherSearchRealTime = new WeatherSearchRealTime();
        a(weatherSearchRealTime, jSONObjectOptJSONObject);
        weatherResult.setRealTimeWeather(weatherSearchRealTime);
        return true;
    }

    private boolean g(JSONObject jSONObject, WeatherResult weatherResult) {
        weatherResult.status = jSONObject.optInt("status");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("result");
        if (jSONObjectOptJSONObject == null) {
            return false;
        }
        e(jSONObjectOptJSONObject, weatherResult);
        f(jSONObjectOptJSONObject, weatherResult);
        a(jSONObjectOptJSONObject, weatherResult);
        b(jSONObjectOptJSONObject, weatherResult);
        c(jSONObjectOptJSONObject, weatherResult);
        d(jSONObjectOptJSONObject, weatherResult);
        return true;
    }

    @Override // com.baidu.platform.base.b
    public SearchResult a(String str) {
        JSONObject jSONObject;
        WeatherResult weatherResult = new WeatherResult();
        if (str == null) {
            weatherResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return weatherResult;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject == null || jSONObject.length() == 0) {
            weatherResult.error = SearchResult.ERRORNO.RESULT_NOT_FOUND;
            return weatherResult;
        }
        if (jSONObject.has("SDK_InnerError")) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("SDK_InnerError");
            if (jSONObjectOptJSONObject.has("PermissionCheckError")) {
                weatherResult.error = SearchResult.ERRORNO.PERMISSION_UNFINISHED;
                return weatherResult;
            }
            if (jSONObjectOptJSONObject.has("httpStateError")) {
                String strOptString = jSONObjectOptJSONObject.optString("httpStateError");
                strOptString.hashCode();
                if (strOptString.equals("NETWORK_ERROR")) {
                    weatherResult.error = SearchResult.ERRORNO.NETWORK_ERROR;
                } else if (strOptString.equals("REQUEST_ERROR")) {
                    weatherResult.error = SearchResult.ERRORNO.REQUEST_ERROR;
                } else {
                    weatherResult.error = SearchResult.ERRORNO.SEARCH_SERVER_INTERNAL_ERROR;
                }
                return weatherResult;
            }
        }
        if (!a(str, weatherResult, true)) {
            g(jSONObject, weatherResult);
        }
        return weatherResult;
    }

    private void a(WeatherSearchLocation weatherSearchLocation, JSONObject jSONObject) {
        weatherSearchLocation.setCountry(jSONObject.optString(ze1.s));
        weatherSearchLocation.setProvince(jSONObject.optString("province"));
        weatherSearchLocation.setCity(jSONObject.optString("city"));
        weatherSearchLocation.setDistrictName(jSONObject.optString("name"));
        weatherSearchLocation.setDistrictID(jSONObject.optString("id"));
    }

    private void a(WeatherSearchRealTime weatherSearchRealTime, JSONObject jSONObject) {
        weatherSearchRealTime.setPhenomenon(jSONObject.optString("text"));
        weatherSearchRealTime.setTemperature(jSONObject.optInt("temp"));
        weatherSearchRealTime.setSensoryTemp(jSONObject.optInt("feels_like"));
        weatherSearchRealTime.setRelativeHumidity(jSONObject.optInt("rh"));
        weatherSearchRealTime.setWindPower(jSONObject.optString("wind_class"));
        weatherSearchRealTime.setWindDirection(jSONObject.optString("wind_dir"));
        weatherSearchRealTime.setUpdateTime(jSONObject.optString("uptime"));
        weatherSearchRealTime.setCO((float) jSONObject.optDouble(AliyunLogKey.KEY_CONNECTION));
        weatherSearchRealTime.setNO2(jSONObject.optInt("no2"));
        weatherSearchRealTime.setPM10(jSONObject.optInt("pm10"));
        weatherSearchRealTime.setPM2_5(jSONObject.optInt("pm25"));
        weatherSearchRealTime.setClouds(jSONObject.optInt("clouds"));
        weatherSearchRealTime.setAirQualityIndex(jSONObject.optInt("aqi"));
        weatherSearchRealTime.setSO2(jSONObject.optInt("so2"));
        weatherSearchRealTime.setVisibility(jSONObject.optInt("vis"));
        weatherSearchRealTime.setO3(jSONObject.optInt("o3"));
        weatherSearchRealTime.setHourlyPrecipitation(jSONObject.optInt("prec_1h"));
    }

    private boolean a(JSONObject jSONObject, WeatherResult weatherResult) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject == null || weatherResult == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray("alerts")) == null) {
            return false;
        }
        if (weatherResult.getWeatherAlerts() == null) {
            weatherResult.setWeatherAlerts(new ArrayList());
        }
        JSONObject jSONObject2 = null;
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            try {
                jSONObject2 = (JSONObject) jSONArrayOptJSONArray.get(i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (jSONObject2 != null) {
                WeatherSearchAlerts weatherSearchAlerts = new WeatherSearchAlerts();
                weatherSearchAlerts.setDesc(jSONObject2.optString("desc"));
                weatherSearchAlerts.setLevel(jSONObject2.optString(com.alibaba.ariver.permission.b.b));
                weatherSearchAlerts.setTitle(jSONObject2.optString("title"));
                weatherSearchAlerts.setType(jSONObject2.optString("type"));
                weatherResult.getWeatherAlerts().add(weatherSearchAlerts);
            }
        }
        return true;
    }

    @Override // com.baidu.platform.base.b
    public void a(SearchResult searchResult, Object obj) {
        if (obj == null || !(obj instanceof OnGetWeatherResultListener)) {
            return;
        }
        ((OnGetWeatherResultListener) obj).onGetWeatherResultListener((WeatherResult) searchResult);
    }
}

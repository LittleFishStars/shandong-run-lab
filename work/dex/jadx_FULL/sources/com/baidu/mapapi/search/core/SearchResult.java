package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class SearchResult implements Parcelable {
    public ERRORNO error;
    public int status;

    public enum ERRORNO {
        NO_ERROR,
        RESULT_NOT_FOUND,
        AMBIGUOUS_KEYWORD,
        AMBIGUOUS_ROURE_ADDR,
        NOT_SUPPORT_BUS,
        NOT_SUPPORT_BUS_2CITY,
        ST_EN_TOO_NEAR,
        KEY_ERROR,
        PERMISSION_UNFINISHED,
        NETWORK_TIME_OUT,
        NETWORK_ERROR,
        POIINDOOR_BID_ERROR,
        POIINDOOR_FLOOR_ERROR,
        POIINDOOR_SERVER_ERROR,
        INDOOR_ROUTE_NO_IN_BUILDING,
        INDOOR_ROUTE_NO_IN_SAME_BUILDING,
        MASS_TRANSIT_SERVER_ERROR,
        MASS_TRANSIT_OPTION_ERROR,
        MASS_TRANSIT_NO_POI_ERROR,
        SEARCH_SERVER_INTERNAL_ERROR,
        SEARCH_OPTION_ERROR,
        REQUEST_ERROR,
        NO_ADVANCED_PERMISSION,
        INVALID_DISTRICT_ID,
        NO_DATA_FOR_LATLNG,
        PARAMER_ERROR,
        INTEGRAL_ROUTE_NOT_SUPPORT_MULTIPLE_INDOOR
    }

    public SearchResult() {
        this.status = 0;
        this.error = ERRORNO.NO_ERROR;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        ERRORNO errorno = this.error;
        parcel.writeInt(errorno == null ? -1 : errorno.ordinal());
    }

    public SearchResult(ERRORNO errorno) {
        this.status = 0;
        this.error = errorno;
    }

    public SearchResult(Parcel parcel) {
        this.status = 0;
        int i = parcel.readInt();
        this.error = i == -1 ? null : ERRORNO.values()[i];
    }
}

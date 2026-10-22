package com.getui.gtc.dim.bean;

import android.net.wifi.WifiInfo;
import android.os.Parcel;
import android.os.Parcelable;
import com.getui.gtc.dim.e.b;
import com.king.zxing.e;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class GtWifiInfo implements Parcelable {
    public static final Parcelable.Creator<GtWifiInfo> CREATOR = new Parcelable.Creator<GtWifiInfo>() { // from class: com.getui.gtc.dim.bean.GtWifiInfo.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GtWifiInfo createFromParcel(Parcel parcel) {
            return new GtWifiInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ GtWifiInfo[] newArray(int i) {
            return new GtWifiInfo[i];
        }
    };
    private String BSSID;
    private String SSID;
    private int rssi;
    private String toString;

    private GtWifiInfo() {
    }

    public GtWifiInfo(WifiInfo wifiInfo) {
        this.BSSID = wifiInfo.getBSSID();
        this.SSID = wifiInfo.getSSID();
        this.toString = wifiInfo.toString();
        this.rssi = wifiInfo.getRssi();
    }

    public GtWifiInfo(Parcel parcel) {
        this.BSSID = parcel.readString();
        this.SSID = parcel.readString();
        this.toString = parcel.readString();
        this.rssi = parcel.readInt();
    }

    public static GtWifiInfo parseJson(String str) {
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            GtWifiInfo gtWifiInfo = new GtWifiInfo();
            gtWifiInfo.toString = jSONObject.optString("toString");
            gtWifiInfo.BSSID = jSONObject.optString("BSSID");
            gtWifiInfo.SSID = jSONObject.optString(e.f.b);
            gtWifiInfo.rssi = jSONObject.optInt("rssi", 0);
            return gtWifiInfo;
        } catch (JSONException e) {
            b.b(e);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBSSID() {
        return this.BSSID;
    }

    public int getRssi() {
        return this.rssi;
    }

    public String getSSID() {
        return this.SSID;
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("BSSID", this.BSSID);
            jSONObject.put(e.f.b, this.SSID);
            jSONObject.put("toString", this.toString);
            jSONObject.put("rssi", this.rssi);
            return jSONObject.toString();
        } catch (Throwable th) {
            b.b(th);
            return null;
        }
    }

    public String toString() {
        String str = this.toString;
        return str == null ? "" : str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.BSSID);
        parcel.writeString(this.SSID);
        parcel.writeString(this.toString);
        parcel.writeInt(this.rssi);
    }
}

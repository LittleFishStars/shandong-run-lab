package com.getui.gtc.dim.bean;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;
import com.getui.gtc.dim.e.b;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class GtLocation implements Parcelable {
    public static final Parcelable.Creator<GtLocation> CREATOR = new Parcelable.Creator<GtLocation>() { // from class: com.getui.gtc.dim.bean.GtLocation.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GtLocation createFromParcel(Parcel parcel) {
            return new GtLocation(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ GtLocation[] newArray(int i) {
            return new GtLocation[i];
        }
    };
    private float accuracy;
    private double altitude;
    private long elapsedRealtimeNanos;
    private boolean hasAccuracy;
    private double latitude;
    private double longitude;
    private String provider;
    private long time;

    private GtLocation() {
    }

    public GtLocation(Location location) {
        this.hasAccuracy = location.hasAccuracy();
        this.accuracy = location.getAccuracy();
        this.time = location.getTime();
        this.provider = location.getProvider();
        this.longitude = location.getLongitude();
        this.latitude = location.getLatitude();
        this.elapsedRealtimeNanos = location.getElapsedRealtimeNanos();
        this.altitude = location.getAltitude();
    }

    public GtLocation(Parcel parcel) {
        this.hasAccuracy = parcel.readByte() != 0;
        this.time = parcel.readLong();
        this.provider = parcel.readString();
        this.longitude = parcel.readDouble();
        this.latitude = parcel.readDouble();
        this.elapsedRealtimeNanos = parcel.readLong();
        this.altitude = parcel.readDouble();
        this.accuracy = parcel.readFloat();
    }

    public static GtLocation parseJson(String str) {
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            GtLocation gtLocation = new GtLocation();
            gtLocation.hasAccuracy = jSONObject.optBoolean("hasAccuracy", false);
            gtLocation.time = jSONObject.optLong("time", 0L);
            gtLocation.provider = jSONObject.optString("provider", "");
            gtLocation.longitude = jSONObject.optDouble("longitude", AudioStats.AUDIO_AMPLITUDE_NONE);
            gtLocation.latitude = jSONObject.optDouble("latitude", AudioStats.AUDIO_AMPLITUDE_NONE);
            gtLocation.elapsedRealtimeNanos = jSONObject.optLong("elapsedRealtimeNanos", 0L);
            gtLocation.altitude = jSONObject.optDouble("altitude", AudioStats.AUDIO_AMPLITUDE_NONE);
            try {
                gtLocation.accuracy = Float.parseFloat(jSONObject.optString("accuracy", "0"));
            } catch (Throwable unused) {
            }
            return gtLocation;
        } catch (JSONException e) {
            b.b(e);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float distanceTo(double d, double d2) {
        double d3 = this.latitude;
        double d4 = (0.017453292519943295d * d2) - (this.longitude * 0.017453292519943295d);
        double dAtan = Math.atan(Math.tan(d3 * 0.017453292519943295d) * 0.996647189328169d);
        double dAtan2 = Math.atan(Math.tan(d * 0.017453292519943295d) * 0.996647189328169d);
        double dCos = Math.cos(dAtan);
        double dCos2 = Math.cos(dAtan2);
        double dSin = Math.sin(dAtan);
        double dSin2 = Math.sin(dAtan2);
        double d5 = dCos * dCos2;
        double d6 = dSin * dSin2;
        int i = 0;
        double d7 = AudioStats.AUDIO_AMPLITUDE_NONE;
        double d8 = AudioStats.AUDIO_AMPLITUDE_NONE;
        double dAtan3 = AudioStats.AUDIO_AMPLITUDE_NONE;
        double d9 = d4;
        while (i < 20) {
            double dCos3 = Math.cos(d9);
            double dSin3 = Math.sin(d9);
            double d10 = dCos2 * dSin3;
            double d11 = (dCos * dSin2) - ((dSin * dCos2) * dCos3);
            double d12 = dSin;
            double dSqrt = Math.sqrt((d10 * d10) + (d11 * d11));
            double d13 = dSin2;
            double d14 = d6 + (dCos3 * d5);
            dAtan3 = Math.atan2(dSqrt, d14);
            double d15 = dSqrt == AudioStats.AUDIO_AMPLITUDE_NONE ? 0.0d : (dSin3 * d5) / dSqrt;
            double d16 = 1.0d - (d15 * d15);
            double d17 = d16 == AudioStats.AUDIO_AMPLITUDE_NONE ? 0.0d : d14 - ((d6 * 2.0d) / d16);
            double d18 = 0.006739496756586903d * d16;
            double d19 = ((d18 / 16384.0d) * (((((320.0d - (175.0d * d18)) * d18) - 768.0d) * d18) + 4096.0d)) + 1.0d;
            double d20 = (d18 / 1024.0d) * ((d18 * (((74.0d - (47.0d * d18)) * d18) - 128.0d)) + 256.0d);
            double d21 = 2.0955066698943685E-4d * d16 * (((4.0d - (d16 * 3.0d)) * 0.0033528106718309896d) + 4.0d);
            double d22 = d17 * d17;
            double d23 = d20 * dSqrt * (d17 + ((d20 / 4.0d) * ((((d22 * 2.0d) - 1.0d) * d14) - ((((d20 / 6.0d) * d17) * (((dSqrt * 4.0d) * dSqrt) - 3.0d)) * ((d22 * 4.0d) - 3.0d)))));
            double d24 = d4 + ((1.0d - d21) * 0.0033528106718309896d * d15 * (dAtan3 + (dSqrt * d21 * (d17 + (d21 * d14 * (((2.0d * d17) * d17) - 1.0d))))));
            if (Math.abs((d24 - d9) / d24) < 1.0E-12d) {
                d7 = d23;
                d8 = d19;
                break;
            }
            i++;
            dSin = d12;
            dSin2 = d13;
            d7 = d23;
            d9 = d24;
            d8 = d19;
        }
        return (float) (d8 * 6356752.3142d * (dAtan3 - d7));
    }

    public float getAccuracy() {
        return this.accuracy;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public long getElapsedRealtimeNanos() {
        return this.elapsedRealtimeNanos;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getProvider() {
        return this.provider;
    }

    public long getTime() {
        return this.time;
    }

    public boolean hasAccuracy() {
        return this.hasAccuracy;
    }

    public String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hasAccuracy", this.hasAccuracy);
            jSONObject.put("time", this.time);
            jSONObject.put("provider", this.provider);
            jSONObject.put("longitude", this.longitude);
            jSONObject.put("latitude", this.latitude);
            jSONObject.put("elapsedRealtimeNanos", this.elapsedRealtimeNanos);
            jSONObject.put("altitude", this.altitude);
            jSONObject.put("accuracy", String.valueOf(this.accuracy));
            return jSONObject.toString();
        } catch (Throwable th) {
            b.b(th);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.hasAccuracy ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.time);
        parcel.writeString(this.provider);
        parcel.writeDouble(this.longitude);
        parcel.writeDouble(this.latitude);
        parcel.writeLong(this.elapsedRealtimeNanos);
        parcel.writeDouble(this.altitude);
        parcel.writeFloat(this.accuracy);
    }
}

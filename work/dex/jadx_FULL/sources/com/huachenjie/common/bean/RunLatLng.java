package com.huachenjie.common.bean;

import androidx.camera.video.AudioStats;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.alibaba.fastjson.annotation.JSONField;
import huachenjie.sdk.map.lib_base.HCJAddressInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Entity(tableName = "run_lat_lng")
public class RunLatLng {
    public static final int STATE_FAIL = 4;
    public static final int STATE_INIT = 1;
    public static final int STATE_SUCC = 8;
    public static final int STATE_UPLOADING = 2;
    private float accuracy;
    private long createTime;

    @PrimaryKey(autoGenerate = true)
    @JSONField(name = "index")
    private long id;

    @ColumnInfo(name = "is_uploaded")
    @JSONField(serialize = false)
    private boolean isUploaded;

    @JSONField(serialize = false)
    private boolean isValid;
    public double lat;
    public double lng;

    @JSONField(name = "offFenceDisM")
    public long offFenceDisM;

    @JSONField(serialize = false)
    private String runCode;

    @JSONField(name = "runTime")
    private int runTimestamp;
    private int satellites;

    @JSONField(serialize = false)
    private float speed;

    @JSONField(name = "state")
    public int state;

    @JSONField(name = "collectTime")
    private long timestamp;

    public RunLatLng(double lat, double lng, long id, String runCode, float accuracy, float speed, long timestamp, int runTimestamp, int satellites, boolean isValid, boolean isUploaded) {
        this.createTime = 0L;
        this.state = 1;
        this.offFenceDisM = 0L;
        this.lat = lat;
        this.lng = lng;
        this.id = id;
        this.runCode = runCode;
        this.accuracy = accuracy;
        this.speed = speed;
        this.timestamp = timestamp;
        this.runTimestamp = runTimestamp;
        this.satellites = satellites;
        this.isValid = isValid;
        this.isUploaded = isUploaded;
        this.createTime = System.currentTimeMillis();
        this.state = 1;
    }

    public float getAccuracy() {
        return this.accuracy;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public long getId() {
        return this.id;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLng() {
        return this.lng;
    }

    public long getOffFenceDisM() {
        return this.offFenceDisM;
    }

    public String getRunCode() {
        return this.runCode;
    }

    public int getRunTimestamp() {
        return this.runTimestamp;
    }

    public int getSatellites() {
        return this.satellites;
    }

    public float getSpeed() {
        return this.speed;
    }

    public int getState() {
        return this.state;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public boolean isSamePos(RunLatLng other) {
        if (other == null) {
            return false;
        }
        double d = other.lat;
        if (d == AudioStats.AUDIO_AMPLITUDE_NONE) {
            return false;
        }
        double d2 = other.lng;
        return d2 != AudioStats.AUDIO_AMPLITUDE_NONE && this.lat == d && this.lng == d2;
    }

    public boolean isUploaded() {
        return this.isUploaded;
    }

    public boolean isValid() {
        return this.isValid;
    }

    public void setAccuracy(float accuracy) {
        this.accuracy = accuracy;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public void setOffFenceDisM(long offFenceDisM) {
        this.offFenceDisM = offFenceDisM;
    }

    public void setRunCode(String runCode) {
        this.runCode = runCode;
    }

    public void setRunTimestamp(int runTimestamp) {
        this.runTimestamp = runTimestamp;
    }

    public void setSatellites(int satellites) {
        this.satellites = satellites;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setUploaded(boolean uploaded) {
        this.isUploaded = uploaded;
    }

    public void setValid(boolean valid) {
        this.isValid = valid;
    }

    public String toString() {
        return "{\"lat\":" + this.lat + ", \"lng\":" + this.lng + ", \"id\":" + this.id + ", \"runCode\":\"" + this.runCode + "\", \"accuracy\"" + this.accuracy + ", \"speed\":" + this.speed + ", \"timestamp\":" + this.timestamp + ", \"runTimestamp\":" + this.runTimestamp + ", \"satellites\":" + this.satellites + ", \"isValid\":" + this.isValid + ", \"isUploaded\":" + this.isUploaded + ", \"createTime\":" + this.createTime + ", \"state\":" + this.state + '}';
    }

    public RunLatLng(String runCode, int runTime, HCJAddressInfo addressInfo, long offFenceDis, long timestamp) {
        this.isUploaded = false;
        this.createTime = 0L;
        this.state = 1;
        this.offFenceDisM = 0L;
        this.runCode = runCode;
        this.lat = addressInfo.getLat();
        this.lng = addressInfo.getLng();
        this.accuracy = addressInfo.getAccuracy();
        this.speed = addressInfo.getSpeed();
        this.satellites = addressInfo.getSatellites();
        this.timestamp = timestamp;
        this.runTimestamp = runTime;
        this.createTime = System.currentTimeMillis();
        this.state = 1;
        this.offFenceDisM = offFenceDis;
    }
}

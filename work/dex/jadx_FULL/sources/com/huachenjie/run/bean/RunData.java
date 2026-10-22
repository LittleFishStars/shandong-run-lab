package com.huachenjie.run.bean;

import com.huachenjie.common.bean.TargetPoints;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunData {
    private long calorie;
    private HCJLatLng currentLocation;
    private long distance;
    private long duration;
    private long endTime;
    private List<HCJLatLng> filterPathList;
    private int frequency;
    private int lastRecordStep;
    private List<HCJLatLng> originPathList;
    private int pace;
    private long pauseDuratin;
    private String runRecordCode;
    private int sportType;
    private boolean startCheckPace;
    private long startTime;
    private int status;
    private List<TargetPoints> targetPointsList;
    private int totalStep;

    public void addFilterPoint(HCJLatLng latLng) {
        if (this.filterPathList == null) {
            this.filterPathList = new ArrayList();
        }
        this.filterPathList.add(latLng);
    }

    public void addOriginPoint(HCJLatLng latLng) {
        if (this.originPathList == null) {
            this.originPathList = new ArrayList();
        }
        this.originPathList.add(latLng);
    }

    public long getCalorie() {
        return this.calorie;
    }

    public HCJLatLng getCurrentLocation() {
        return this.currentLocation;
    }

    public long getDistance() {
        return this.distance;
    }

    public long getDuration() {
        return this.duration;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public List<HCJLatLng> getFilterPathList() {
        return this.filterPathList;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public int getLastRecordStep() {
        return this.lastRecordStep;
    }

    public List<HCJLatLng> getOriginPathList() {
        return this.originPathList;
    }

    public int getPace() {
        return this.pace;
    }

    public long getPauseDuratin() {
        return this.pauseDuratin;
    }

    public String getRunRecordCode() {
        return this.runRecordCode;
    }

    public int getSportType() {
        return this.sportType;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public int getStatus() {
        return this.status;
    }

    public List<TargetPoints> getTargetPointsList() {
        return this.targetPointsList;
    }

    public int getTotalStep() {
        return this.totalStep;
    }

    public void increasePauseDuration(long increaseDuration) {
        this.pauseDuratin += increaseDuration;
    }

    public boolean isStartCheckPace() {
        return this.startCheckPace;
    }

    public void setCalorie(long calorie) {
        this.calorie = calorie;
    }

    public void setCurrentLocation(HCJLatLng currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void setFilterPathList(List<HCJLatLng> filterPathList) {
        this.filterPathList = filterPathList;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void setLastRecordStep(int lastRecordStep) {
        this.lastRecordStep = lastRecordStep;
    }

    public void setOriginPathList(List<HCJLatLng> originPathList) {
        this.originPathList = originPathList;
    }

    public void setPace(int pace) {
        this.pace = pace;
    }

    public void setPauseDuratin(long pauseDuratin) {
        this.pauseDuratin = pauseDuratin;
    }

    public void setRunRecordCode(String runRecordCode) {
        this.runRecordCode = runRecordCode;
    }

    public void setSportType(int sportType) {
        this.sportType = sportType;
    }

    public void setStartCheckPace(boolean startCheckPace) {
        this.startCheckPace = startCheckPace;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTargetPointsList(List<TargetPoints> targetPointsList) {
        this.targetPointsList = targetPointsList;
    }

    public void setTotalStep(int totalStep) {
        this.totalStep = totalStep;
    }
}

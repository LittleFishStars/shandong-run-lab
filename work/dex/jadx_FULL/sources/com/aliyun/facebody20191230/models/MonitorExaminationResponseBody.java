package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MonitorExaminationResponseBody extends TeaModel {

    @NameInMap("Data")
    public MonitorExaminationResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class MonitorExaminationResponseBodyData extends TeaModel {

        @NameInMap("ChatScore")
        public Float chatScore;

        @NameInMap("FaceInfo")
        public MonitorExaminationResponseBodyDataFaceInfo faceInfo;

        @NameInMap("PersonInfo")
        public MonitorExaminationResponseBodyDataPersonInfo personInfo;

        @NameInMap("Threshold")
        public Float threshold;

        public static MonitorExaminationResponseBodyData build(Map<String, ?> map) throws Exception {
            return (MonitorExaminationResponseBodyData) TeaModel.build(map, new MonitorExaminationResponseBodyData());
        }

        public Float getChatScore() {
            return this.chatScore;
        }

        public MonitorExaminationResponseBodyDataFaceInfo getFaceInfo() {
            return this.faceInfo;
        }

        public MonitorExaminationResponseBodyDataPersonInfo getPersonInfo() {
            return this.personInfo;
        }

        public Float getThreshold() {
            return this.threshold;
        }

        public MonitorExaminationResponseBodyData setChatScore(Float f) {
            this.chatScore = f;
            return this;
        }

        public MonitorExaminationResponseBodyData setFaceInfo(MonitorExaminationResponseBodyDataFaceInfo monitorExaminationResponseBodyDataFaceInfo) {
            this.faceInfo = monitorExaminationResponseBodyDataFaceInfo;
            return this;
        }

        public MonitorExaminationResponseBodyData setPersonInfo(MonitorExaminationResponseBodyDataPersonInfo monitorExaminationResponseBodyDataPersonInfo) {
            this.personInfo = monitorExaminationResponseBodyDataPersonInfo;
            return this;
        }

        public MonitorExaminationResponseBodyData setThreshold(Float f) {
            this.threshold = f;
            return this;
        }
    }

    public static class MonitorExaminationResponseBodyDataFaceInfo extends TeaModel {

        @NameInMap("Completeness")
        public Float completeness;

        @NameInMap("FaceNumber")
        public Long faceNumber;

        @NameInMap("Pose")
        public MonitorExaminationResponseBodyDataFaceInfoPose pose;

        public static MonitorExaminationResponseBodyDataFaceInfo build(Map<String, ?> map) throws Exception {
            return (MonitorExaminationResponseBodyDataFaceInfo) TeaModel.build(map, new MonitorExaminationResponseBodyDataFaceInfo());
        }

        public Float getCompleteness() {
            return this.completeness;
        }

        public Long getFaceNumber() {
            return this.faceNumber;
        }

        public MonitorExaminationResponseBodyDataFaceInfoPose getPose() {
            return this.pose;
        }

        public MonitorExaminationResponseBodyDataFaceInfo setCompleteness(Float f) {
            this.completeness = f;
            return this;
        }

        public MonitorExaminationResponseBodyDataFaceInfo setFaceNumber(Long l) {
            this.faceNumber = l;
            return this;
        }

        public MonitorExaminationResponseBodyDataFaceInfo setPose(MonitorExaminationResponseBodyDataFaceInfoPose monitorExaminationResponseBodyDataFaceInfoPose) {
            this.pose = monitorExaminationResponseBodyDataFaceInfoPose;
            return this;
        }
    }

    public static class MonitorExaminationResponseBodyDataFaceInfoPose extends TeaModel {

        @NameInMap("Pitch")
        public Float pitch;

        @NameInMap("Roll")
        public Float roll;

        @NameInMap("Yaw")
        public Float yaw;

        public static MonitorExaminationResponseBodyDataFaceInfoPose build(Map<String, ?> map) throws Exception {
            return (MonitorExaminationResponseBodyDataFaceInfoPose) TeaModel.build(map, new MonitorExaminationResponseBodyDataFaceInfoPose());
        }

        public Float getPitch() {
            return this.pitch;
        }

        public Float getRoll() {
            return this.roll;
        }

        public Float getYaw() {
            return this.yaw;
        }

        public MonitorExaminationResponseBodyDataFaceInfoPose setPitch(Float f) {
            this.pitch = f;
            return this;
        }

        public MonitorExaminationResponseBodyDataFaceInfoPose setRoll(Float f) {
            this.roll = f;
            return this;
        }

        public MonitorExaminationResponseBodyDataFaceInfoPose setYaw(Float f) {
            this.yaw = f;
            return this;
        }
    }

    public static class MonitorExaminationResponseBodyDataPersonInfo extends TeaModel {

        @NameInMap("CellPhone")
        public MonitorExaminationResponseBodyDataPersonInfoCellPhone cellPhone;

        @NameInMap("EarPhone")
        public MonitorExaminationResponseBodyDataPersonInfoEarPhone earPhone;

        @NameInMap("PersonNumber")
        public Long personNumber;

        public static MonitorExaminationResponseBodyDataPersonInfo build(Map<String, ?> map) throws Exception {
            return (MonitorExaminationResponseBodyDataPersonInfo) TeaModel.build(map, new MonitorExaminationResponseBodyDataPersonInfo());
        }

        public MonitorExaminationResponseBodyDataPersonInfoCellPhone getCellPhone() {
            return this.cellPhone;
        }

        public MonitorExaminationResponseBodyDataPersonInfoEarPhone getEarPhone() {
            return this.earPhone;
        }

        public Long getPersonNumber() {
            return this.personNumber;
        }

        public MonitorExaminationResponseBodyDataPersonInfo setCellPhone(MonitorExaminationResponseBodyDataPersonInfoCellPhone monitorExaminationResponseBodyDataPersonInfoCellPhone) {
            this.cellPhone = monitorExaminationResponseBodyDataPersonInfoCellPhone;
            return this;
        }

        public MonitorExaminationResponseBodyDataPersonInfo setEarPhone(MonitorExaminationResponseBodyDataPersonInfoEarPhone monitorExaminationResponseBodyDataPersonInfoEarPhone) {
            this.earPhone = monitorExaminationResponseBodyDataPersonInfoEarPhone;
            return this;
        }

        public MonitorExaminationResponseBodyDataPersonInfo setPersonNumber(Long l) {
            this.personNumber = l;
            return this;
        }
    }

    public static class MonitorExaminationResponseBodyDataPersonInfoCellPhone extends TeaModel {

        @NameInMap("Score")
        public Float score;

        @NameInMap("Threshold")
        public Float threshold;

        public static MonitorExaminationResponseBodyDataPersonInfoCellPhone build(Map<String, ?> map) throws Exception {
            return (MonitorExaminationResponseBodyDataPersonInfoCellPhone) TeaModel.build(map, new MonitorExaminationResponseBodyDataPersonInfoCellPhone());
        }

        public Float getScore() {
            return this.score;
        }

        public Float getThreshold() {
            return this.threshold;
        }

        public MonitorExaminationResponseBodyDataPersonInfoCellPhone setScore(Float f) {
            this.score = f;
            return this;
        }

        public MonitorExaminationResponseBodyDataPersonInfoCellPhone setThreshold(Float f) {
            this.threshold = f;
            return this;
        }
    }

    public static class MonitorExaminationResponseBodyDataPersonInfoEarPhone extends TeaModel {

        @NameInMap("Score")
        public Float score;

        @NameInMap("Threshold")
        public Float threshold;

        public static MonitorExaminationResponseBodyDataPersonInfoEarPhone build(Map<String, ?> map) throws Exception {
            return (MonitorExaminationResponseBodyDataPersonInfoEarPhone) TeaModel.build(map, new MonitorExaminationResponseBodyDataPersonInfoEarPhone());
        }

        public Float getScore() {
            return this.score;
        }

        public Float getThreshold() {
            return this.threshold;
        }

        public MonitorExaminationResponseBodyDataPersonInfoEarPhone setScore(Float f) {
            this.score = f;
            return this;
        }

        public MonitorExaminationResponseBodyDataPersonInfoEarPhone setThreshold(Float f) {
            this.threshold = f;
            return this;
        }
    }

    public static MonitorExaminationResponseBody build(Map<String, ?> map) throws Exception {
        return (MonitorExaminationResponseBody) TeaModel.build(map, new MonitorExaminationResponseBody());
    }

    public MonitorExaminationResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public MonitorExaminationResponseBody setData(MonitorExaminationResponseBodyData monitorExaminationResponseBodyData) {
        this.data = monitorExaminationResponseBodyData;
        return this;
    }

    public MonitorExaminationResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CompareFaceWithMaskResponseBody extends TeaModel {

    @NameInMap("Data")
    public CompareFaceWithMaskResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class CompareFaceWithMaskResponseBodyData extends TeaModel {

        @NameInMap("Confidence")
        public Float confidence;

        @NameInMap("IsMaskA")
        public Long isMaskA;

        @NameInMap("IsMaskB")
        public Long isMaskB;

        @NameInMap("LandmarksAList")
        public List<Long> landmarksAList;

        @NameInMap("LandmarksBList")
        public List<Long> landmarksBList;

        @NameInMap("MessageTips")
        public String messageTips;

        @NameInMap("QualityScoreA")
        public Float qualityScoreA;

        @NameInMap("QualityScoreB")
        public Float qualityScoreB;

        @NameInMap("RectAList")
        public List<Long> rectAList;

        @NameInMap("RectBList")
        public List<Long> rectBList;

        @NameInMap("Thresholds")
        public List<Long> thresholds;

        public static CompareFaceWithMaskResponseBodyData build(Map<String, ?> map) throws Exception {
            return (CompareFaceWithMaskResponseBodyData) TeaModel.build(map, new CompareFaceWithMaskResponseBodyData());
        }

        public Float getConfidence() {
            return this.confidence;
        }

        public Long getIsMaskA() {
            return this.isMaskA;
        }

        public Long getIsMaskB() {
            return this.isMaskB;
        }

        public List<Long> getLandmarksAList() {
            return this.landmarksAList;
        }

        public List<Long> getLandmarksBList() {
            return this.landmarksBList;
        }

        public String getMessageTips() {
            return this.messageTips;
        }

        public Float getQualityScoreA() {
            return this.qualityScoreA;
        }

        public Float getQualityScoreB() {
            return this.qualityScoreB;
        }

        public List<Long> getRectAList() {
            return this.rectAList;
        }

        public List<Long> getRectBList() {
            return this.rectBList;
        }

        public List<Long> getThresholds() {
            return this.thresholds;
        }

        public CompareFaceWithMaskResponseBodyData setConfidence(Float f) {
            this.confidence = f;
            return this;
        }

        public CompareFaceWithMaskResponseBodyData setIsMaskA(Long l) {
            this.isMaskA = l;
            return this;
        }

        public CompareFaceWithMaskResponseBodyData setIsMaskB(Long l) {
            this.isMaskB = l;
            return this;
        }

        public CompareFaceWithMaskResponseBodyData setLandmarksAList(List<Long> list) {
            this.landmarksAList = list;
            return this;
        }

        public CompareFaceWithMaskResponseBodyData setLandmarksBList(List<Long> list) {
            this.landmarksBList = list;
            return this;
        }

        public CompareFaceWithMaskResponseBodyData setMessageTips(String str) {
            this.messageTips = str;
            return this;
        }

        public CompareFaceWithMaskResponseBodyData setQualityScoreA(Float f) {
            this.qualityScoreA = f;
            return this;
        }

        public CompareFaceWithMaskResponseBodyData setQualityScoreB(Float f) {
            this.qualityScoreB = f;
            return this;
        }

        public CompareFaceWithMaskResponseBodyData setRectAList(List<Long> list) {
            this.rectAList = list;
            return this;
        }

        public CompareFaceWithMaskResponseBodyData setRectBList(List<Long> list) {
            this.rectBList = list;
            return this;
        }

        public CompareFaceWithMaskResponseBodyData setThresholds(List<Long> list) {
            this.thresholds = list;
            return this;
        }
    }

    public static CompareFaceWithMaskResponseBody build(Map<String, ?> map) throws Exception {
        return (CompareFaceWithMaskResponseBody) TeaModel.build(map, new CompareFaceWithMaskResponseBody());
    }

    public CompareFaceWithMaskResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public CompareFaceWithMaskResponseBody setData(CompareFaceWithMaskResponseBodyData compareFaceWithMaskResponseBodyData) {
        this.data = compareFaceWithMaskResponseBodyData;
        return this;
    }

    public CompareFaceWithMaskResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

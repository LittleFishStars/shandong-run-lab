package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CompareFaceResponseBody extends TeaModel {

    @NameInMap("Data")
    public CompareFaceResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class CompareFaceResponseBodyData extends TeaModel {

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
        public List<Integer> rectAList;

        @NameInMap("RectBList")
        public List<Integer> rectBList;

        @NameInMap("Thresholds")
        public List<Float> thresholds;

        public static CompareFaceResponseBodyData build(Map<String, ?> map) throws Exception {
            return (CompareFaceResponseBodyData) TeaModel.build(map, new CompareFaceResponseBodyData());
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

        public List<Integer> getRectAList() {
            return this.rectAList;
        }

        public List<Integer> getRectBList() {
            return this.rectBList;
        }

        public List<Float> getThresholds() {
            return this.thresholds;
        }

        public CompareFaceResponseBodyData setConfidence(Float f) {
            this.confidence = f;
            return this;
        }

        public CompareFaceResponseBodyData setIsMaskA(Long l) {
            this.isMaskA = l;
            return this;
        }

        public CompareFaceResponseBodyData setIsMaskB(Long l) {
            this.isMaskB = l;
            return this;
        }

        public CompareFaceResponseBodyData setLandmarksAList(List<Long> list) {
            this.landmarksAList = list;
            return this;
        }

        public CompareFaceResponseBodyData setLandmarksBList(List<Long> list) {
            this.landmarksBList = list;
            return this;
        }

        public CompareFaceResponseBodyData setMessageTips(String str) {
            this.messageTips = str;
            return this;
        }

        public CompareFaceResponseBodyData setQualityScoreA(Float f) {
            this.qualityScoreA = f;
            return this;
        }

        public CompareFaceResponseBodyData setQualityScoreB(Float f) {
            this.qualityScoreB = f;
            return this;
        }

        public CompareFaceResponseBodyData setRectAList(List<Integer> list) {
            this.rectAList = list;
            return this;
        }

        public CompareFaceResponseBodyData setRectBList(List<Integer> list) {
            this.rectBList = list;
            return this;
        }

        public CompareFaceResponseBodyData setThresholds(List<Float> list) {
            this.thresholds = list;
            return this;
        }
    }

    public static CompareFaceResponseBody build(Map<String, ?> map) throws Exception {
        return (CompareFaceResponseBody) TeaModel.build(map, new CompareFaceResponseBody());
    }

    public CompareFaceResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public CompareFaceResponseBody setData(CompareFaceResponseBodyData compareFaceResponseBodyData) {
        this.data = compareFaceResponseBodyData;
        return this;
    }

    public CompareFaceResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

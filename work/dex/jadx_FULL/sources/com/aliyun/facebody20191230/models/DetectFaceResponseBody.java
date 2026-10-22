package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectFaceResponseBody extends TeaModel {

    @NameInMap("Data")
    public DetectFaceResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class DetectFaceResponseBodyData extends TeaModel {

        @NameInMap("FaceCount")
        public Integer faceCount;

        @NameInMap("FaceProbabilityList")
        public List<Float> faceProbabilityList;

        @NameInMap("FaceRectangles")
        public List<Integer> faceRectangles;

        @NameInMap("LandmarkCount")
        public Integer landmarkCount;

        @NameInMap("LandmarkScore")
        public List<Float> landmarkScore;

        @NameInMap("Landmarks")
        public List<Float> landmarks;

        @NameInMap("PoseList")
        public List<Float> poseList;

        @NameInMap("Pupils")
        public List<Double> pupils;

        @NameInMap("Qualities")
        public DetectFaceResponseBodyDataQualities qualities;

        public static DetectFaceResponseBodyData build(Map<String, ?> map) throws Exception {
            return (DetectFaceResponseBodyData) TeaModel.build(map, new DetectFaceResponseBodyData());
        }

        public Integer getFaceCount() {
            return this.faceCount;
        }

        public List<Float> getFaceProbabilityList() {
            return this.faceProbabilityList;
        }

        public List<Integer> getFaceRectangles() {
            return this.faceRectangles;
        }

        public Integer getLandmarkCount() {
            return this.landmarkCount;
        }

        public List<Float> getLandmarkScore() {
            return this.landmarkScore;
        }

        public List<Float> getLandmarks() {
            return this.landmarks;
        }

        public List<Float> getPoseList() {
            return this.poseList;
        }

        public List<Double> getPupils() {
            return this.pupils;
        }

        public DetectFaceResponseBodyDataQualities getQualities() {
            return this.qualities;
        }

        public DetectFaceResponseBodyData setFaceCount(Integer num) {
            this.faceCount = num;
            return this;
        }

        public DetectFaceResponseBodyData setFaceProbabilityList(List<Float> list) {
            this.faceProbabilityList = list;
            return this;
        }

        public DetectFaceResponseBodyData setFaceRectangles(List<Integer> list) {
            this.faceRectangles = list;
            return this;
        }

        public DetectFaceResponseBodyData setLandmarkCount(Integer num) {
            this.landmarkCount = num;
            return this;
        }

        public DetectFaceResponseBodyData setLandmarkScore(List<Float> list) {
            this.landmarkScore = list;
            return this;
        }

        public DetectFaceResponseBodyData setLandmarks(List<Float> list) {
            this.landmarks = list;
            return this;
        }

        public DetectFaceResponseBodyData setPoseList(List<Float> list) {
            this.poseList = list;
            return this;
        }

        public DetectFaceResponseBodyData setPupils(List<Double> list) {
            this.pupils = list;
            return this;
        }

        public DetectFaceResponseBodyData setQualities(DetectFaceResponseBodyDataQualities detectFaceResponseBodyDataQualities) {
            this.qualities = detectFaceResponseBodyDataQualities;
            return this;
        }
    }

    public static class DetectFaceResponseBodyDataQualities extends TeaModel {

        @NameInMap("BlurList")
        public List<Float> blurList;

        @NameInMap("FnfList")
        public List<Float> fnfList;

        @NameInMap("GlassList")
        public List<Float> glassList;

        @NameInMap("IlluList")
        public List<Float> illuList;

        @NameInMap("MaskList")
        public List<Float> maskList;

        @NameInMap("NoiseList")
        public List<Float> noiseList;

        @NameInMap("PoseList")
        public List<Float> poseList;

        @NameInMap("ScoreList")
        public List<Float> scoreList;

        public static DetectFaceResponseBodyDataQualities build(Map<String, ?> map) throws Exception {
            return (DetectFaceResponseBodyDataQualities) TeaModel.build(map, new DetectFaceResponseBodyDataQualities());
        }

        public List<Float> getBlurList() {
            return this.blurList;
        }

        public List<Float> getFnfList() {
            return this.fnfList;
        }

        public List<Float> getGlassList() {
            return this.glassList;
        }

        public List<Float> getIlluList() {
            return this.illuList;
        }

        public List<Float> getMaskList() {
            return this.maskList;
        }

        public List<Float> getNoiseList() {
            return this.noiseList;
        }

        public List<Float> getPoseList() {
            return this.poseList;
        }

        public List<Float> getScoreList() {
            return this.scoreList;
        }

        public DetectFaceResponseBodyDataQualities setBlurList(List<Float> list) {
            this.blurList = list;
            return this;
        }

        public DetectFaceResponseBodyDataQualities setFnfList(List<Float> list) {
            this.fnfList = list;
            return this;
        }

        public DetectFaceResponseBodyDataQualities setGlassList(List<Float> list) {
            this.glassList = list;
            return this;
        }

        public DetectFaceResponseBodyDataQualities setIlluList(List<Float> list) {
            this.illuList = list;
            return this;
        }

        public DetectFaceResponseBodyDataQualities setMaskList(List<Float> list) {
            this.maskList = list;
            return this;
        }

        public DetectFaceResponseBodyDataQualities setNoiseList(List<Float> list) {
            this.noiseList = list;
            return this;
        }

        public DetectFaceResponseBodyDataQualities setPoseList(List<Float> list) {
            this.poseList = list;
            return this;
        }

        public DetectFaceResponseBodyDataQualities setScoreList(List<Float> list) {
            this.scoreList = list;
            return this;
        }
    }

    public static DetectFaceResponseBody build(Map<String, ?> map) throws Exception {
        return (DetectFaceResponseBody) TeaModel.build(map, new DetectFaceResponseBody());
    }

    public DetectFaceResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public DetectFaceResponseBody setData(DetectFaceResponseBodyData detectFaceResponseBodyData) {
        this.data = detectFaceResponseBodyData;
        return this;
    }

    public DetectFaceResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

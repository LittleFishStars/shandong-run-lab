package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RecognizeFaceResponseBody extends TeaModel {

    @NameInMap("Data")
    public RecognizeFaceResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class RecognizeFaceResponseBodyData extends TeaModel {

        @NameInMap("AgeList")
        public List<Integer> ageList;

        @NameInMap("BeautyList")
        public List<Float> beautyList;

        @NameInMap("DenseFeatureLength")
        public Integer denseFeatureLength;

        @NameInMap("DenseFeatures")
        public List<String> denseFeatures;

        @NameInMap("Expressions")
        public List<Integer> expressions;

        @NameInMap("FaceCount")
        public Integer faceCount;

        @NameInMap("FaceProbabilityList")
        public List<Float> faceProbabilityList;

        @NameInMap("FaceRectangles")
        public List<Integer> faceRectangles;

        @NameInMap("GenderList")
        public List<Integer> genderList;

        @NameInMap("Glasses")
        public List<Integer> glasses;

        @NameInMap("HatList")
        public List<Integer> hatList;

        @NameInMap("LandmarkCount")
        public Integer landmarkCount;

        @NameInMap("Landmarks")
        public List<Float> landmarks;

        @NameInMap("Masks")
        public List<Long> masks;

        @NameInMap("PoseList")
        public List<Float> poseList;

        @NameInMap("Pupils")
        public List<Float> pupils;

        @NameInMap("Qualities")
        public RecognizeFaceResponseBodyDataQualities qualities;

        public static RecognizeFaceResponseBodyData build(Map<String, ?> map) throws Exception {
            return (RecognizeFaceResponseBodyData) TeaModel.build(map, new RecognizeFaceResponseBodyData());
        }

        public List<Integer> getAgeList() {
            return this.ageList;
        }

        public List<Float> getBeautyList() {
            return this.beautyList;
        }

        public Integer getDenseFeatureLength() {
            return this.denseFeatureLength;
        }

        public List<String> getDenseFeatures() {
            return this.denseFeatures;
        }

        public List<Integer> getExpressions() {
            return this.expressions;
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

        public List<Integer> getGenderList() {
            return this.genderList;
        }

        public List<Integer> getGlasses() {
            return this.glasses;
        }

        public List<Integer> getHatList() {
            return this.hatList;
        }

        public Integer getLandmarkCount() {
            return this.landmarkCount;
        }

        public List<Float> getLandmarks() {
            return this.landmarks;
        }

        public List<Long> getMasks() {
            return this.masks;
        }

        public List<Float> getPoseList() {
            return this.poseList;
        }

        public List<Float> getPupils() {
            return this.pupils;
        }

        public RecognizeFaceResponseBodyDataQualities getQualities() {
            return this.qualities;
        }

        public RecognizeFaceResponseBodyData setAgeList(List<Integer> list) {
            this.ageList = list;
            return this;
        }

        public RecognizeFaceResponseBodyData setBeautyList(List<Float> list) {
            this.beautyList = list;
            return this;
        }

        public RecognizeFaceResponseBodyData setDenseFeatureLength(Integer num) {
            this.denseFeatureLength = num;
            return this;
        }

        public RecognizeFaceResponseBodyData setDenseFeatures(List<String> list) {
            this.denseFeatures = list;
            return this;
        }

        public RecognizeFaceResponseBodyData setExpressions(List<Integer> list) {
            this.expressions = list;
            return this;
        }

        public RecognizeFaceResponseBodyData setFaceCount(Integer num) {
            this.faceCount = num;
            return this;
        }

        public RecognizeFaceResponseBodyData setFaceProbabilityList(List<Float> list) {
            this.faceProbabilityList = list;
            return this;
        }

        public RecognizeFaceResponseBodyData setFaceRectangles(List<Integer> list) {
            this.faceRectangles = list;
            return this;
        }

        public RecognizeFaceResponseBodyData setGenderList(List<Integer> list) {
            this.genderList = list;
            return this;
        }

        public RecognizeFaceResponseBodyData setGlasses(List<Integer> list) {
            this.glasses = list;
            return this;
        }

        public RecognizeFaceResponseBodyData setHatList(List<Integer> list) {
            this.hatList = list;
            return this;
        }

        public RecognizeFaceResponseBodyData setLandmarkCount(Integer num) {
            this.landmarkCount = num;
            return this;
        }

        public RecognizeFaceResponseBodyData setLandmarks(List<Float> list) {
            this.landmarks = list;
            return this;
        }

        public RecognizeFaceResponseBodyData setMasks(List<Long> list) {
            this.masks = list;
            return this;
        }

        public RecognizeFaceResponseBodyData setPoseList(List<Float> list) {
            this.poseList = list;
            return this;
        }

        public RecognizeFaceResponseBodyData setPupils(List<Float> list) {
            this.pupils = list;
            return this;
        }

        public RecognizeFaceResponseBodyData setQualities(RecognizeFaceResponseBodyDataQualities recognizeFaceResponseBodyDataQualities) {
            this.qualities = recognizeFaceResponseBodyDataQualities;
            return this;
        }
    }

    public static class RecognizeFaceResponseBodyDataQualities extends TeaModel {

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

        public static RecognizeFaceResponseBodyDataQualities build(Map<String, ?> map) throws Exception {
            return (RecognizeFaceResponseBodyDataQualities) TeaModel.build(map, new RecognizeFaceResponseBodyDataQualities());
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

        public RecognizeFaceResponseBodyDataQualities setBlurList(List<Float> list) {
            this.blurList = list;
            return this;
        }

        public RecognizeFaceResponseBodyDataQualities setFnfList(List<Float> list) {
            this.fnfList = list;
            return this;
        }

        public RecognizeFaceResponseBodyDataQualities setGlassList(List<Float> list) {
            this.glassList = list;
            return this;
        }

        public RecognizeFaceResponseBodyDataQualities setIlluList(List<Float> list) {
            this.illuList = list;
            return this;
        }

        public RecognizeFaceResponseBodyDataQualities setMaskList(List<Float> list) {
            this.maskList = list;
            return this;
        }

        public RecognizeFaceResponseBodyDataQualities setNoiseList(List<Float> list) {
            this.noiseList = list;
            return this;
        }

        public RecognizeFaceResponseBodyDataQualities setPoseList(List<Float> list) {
            this.poseList = list;
            return this;
        }

        public RecognizeFaceResponseBodyDataQualities setScoreList(List<Float> list) {
            this.scoreList = list;
            return this;
        }
    }

    public static RecognizeFaceResponseBody build(Map<String, ?> map) throws Exception {
        return (RecognizeFaceResponseBody) TeaModel.build(map, new RecognizeFaceResponseBody());
    }

    public RecognizeFaceResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public RecognizeFaceResponseBody setData(RecognizeFaceResponseBodyData recognizeFaceResponseBodyData) {
        this.data = recognizeFaceResponseBodyData;
        return this;
    }

    public RecognizeFaceResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

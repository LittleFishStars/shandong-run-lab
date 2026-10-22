package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.google.common.net.b;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ExtractPedestrianFeatureAttrResponseBody extends TeaModel {

    @NameInMap("Data")
    public ExtractPedestrianFeatureAttrResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class ExtractPedestrianFeatureAttrResponseBodyData extends TeaModel {

        @NameInMap(b.X)
        public String age;

        @NameInMap("AgeScore")
        public Float ageScore;

        @NameInMap("Feature")
        public String feature;

        @NameInMap("Gender")
        public String gender;

        @NameInMap("GenderScore")
        public Float genderScore;

        @NameInMap("Hair")
        public String hair;

        @NameInMap("HairScore")
        public Float hairScore;

        @NameInMap("LowerColor")
        public String lowerColor;

        @NameInMap("LowerColorScore")
        public Float lowerColorScore;

        @NameInMap("LowerType")
        public String lowerType;

        @NameInMap("LowerTypeScore")
        public Float lowerTypeScore;

        @NameInMap("ObjType")
        public String objType;

        @NameInMap("ObjTypeScore")
        public Float objTypeScore;

        @NameInMap("Orientation")
        public String orientation;

        @NameInMap("OrientationScore")
        public Float orientationScore;

        @NameInMap("QualityScore")
        public Float qualityScore;

        @NameInMap("UpperColor")
        public String upperColor;

        @NameInMap("UpperColorScore")
        public Float upperColorScore;

        @NameInMap("UpperType")
        public String upperType;

        @NameInMap("UpperTypeScore")
        public Float upperTypeScore;

        public static ExtractPedestrianFeatureAttrResponseBodyData build(Map<String, ?> map) throws Exception {
            return (ExtractPedestrianFeatureAttrResponseBodyData) TeaModel.build(map, new ExtractPedestrianFeatureAttrResponseBodyData());
        }

        public String getAge() {
            return this.age;
        }

        public Float getAgeScore() {
            return this.ageScore;
        }

        public String getFeature() {
            return this.feature;
        }

        public String getGender() {
            return this.gender;
        }

        public Float getGenderScore() {
            return this.genderScore;
        }

        public String getHair() {
            return this.hair;
        }

        public Float getHairScore() {
            return this.hairScore;
        }

        public String getLowerColor() {
            return this.lowerColor;
        }

        public Float getLowerColorScore() {
            return this.lowerColorScore;
        }

        public String getLowerType() {
            return this.lowerType;
        }

        public Float getLowerTypeScore() {
            return this.lowerTypeScore;
        }

        public String getObjType() {
            return this.objType;
        }

        public Float getObjTypeScore() {
            return this.objTypeScore;
        }

        public String getOrientation() {
            return this.orientation;
        }

        public Float getOrientationScore() {
            return this.orientationScore;
        }

        public Float getQualityScore() {
            return this.qualityScore;
        }

        public String getUpperColor() {
            return this.upperColor;
        }

        public Float getUpperColorScore() {
            return this.upperColorScore;
        }

        public String getUpperType() {
            return this.upperType;
        }

        public Float getUpperTypeScore() {
            return this.upperTypeScore;
        }

        public ExtractPedestrianFeatureAttrResponseBodyData setAge(String str) {
            this.age = str;
            return this;
        }

        public ExtractPedestrianFeatureAttrResponseBodyData setAgeScore(Float f) {
            this.ageScore = f;
            return this;
        }

        public ExtractPedestrianFeatureAttrResponseBodyData setFeature(String str) {
            this.feature = str;
            return this;
        }

        public ExtractPedestrianFeatureAttrResponseBodyData setGender(String str) {
            this.gender = str;
            return this;
        }

        public ExtractPedestrianFeatureAttrResponseBodyData setGenderScore(Float f) {
            this.genderScore = f;
            return this;
        }

        public ExtractPedestrianFeatureAttrResponseBodyData setHair(String str) {
            this.hair = str;
            return this;
        }

        public ExtractPedestrianFeatureAttrResponseBodyData setHairScore(Float f) {
            this.hairScore = f;
            return this;
        }

        public ExtractPedestrianFeatureAttrResponseBodyData setLowerColor(String str) {
            this.lowerColor = str;
            return this;
        }

        public ExtractPedestrianFeatureAttrResponseBodyData setLowerColorScore(Float f) {
            this.lowerColorScore = f;
            return this;
        }

        public ExtractPedestrianFeatureAttrResponseBodyData setLowerType(String str) {
            this.lowerType = str;
            return this;
        }

        public ExtractPedestrianFeatureAttrResponseBodyData setLowerTypeScore(Float f) {
            this.lowerTypeScore = f;
            return this;
        }

        public ExtractPedestrianFeatureAttrResponseBodyData setObjType(String str) {
            this.objType = str;
            return this;
        }

        public ExtractPedestrianFeatureAttrResponseBodyData setObjTypeScore(Float f) {
            this.objTypeScore = f;
            return this;
        }

        public ExtractPedestrianFeatureAttrResponseBodyData setOrientation(String str) {
            this.orientation = str;
            return this;
        }

        public ExtractPedestrianFeatureAttrResponseBodyData setOrientationScore(Float f) {
            this.orientationScore = f;
            return this;
        }

        public ExtractPedestrianFeatureAttrResponseBodyData setQualityScore(Float f) {
            this.qualityScore = f;
            return this;
        }

        public ExtractPedestrianFeatureAttrResponseBodyData setUpperColor(String str) {
            this.upperColor = str;
            return this;
        }

        public ExtractPedestrianFeatureAttrResponseBodyData setUpperColorScore(Float f) {
            this.upperColorScore = f;
            return this;
        }

        public ExtractPedestrianFeatureAttrResponseBodyData setUpperType(String str) {
            this.upperType = str;
            return this;
        }

        public ExtractPedestrianFeatureAttrResponseBodyData setUpperTypeScore(Float f) {
            this.upperTypeScore = f;
            return this;
        }
    }

    public static ExtractPedestrianFeatureAttrResponseBody build(Map<String, ?> map) throws Exception {
        return (ExtractPedestrianFeatureAttrResponseBody) TeaModel.build(map, new ExtractPedestrianFeatureAttrResponseBody());
    }

    public ExtractPedestrianFeatureAttrResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public ExtractPedestrianFeatureAttrResponseBody setData(ExtractPedestrianFeatureAttrResponseBodyData extractPedestrianFeatureAttrResponseBodyData) {
        this.data = extractPedestrianFeatureAttrResponseBodyData;
        return this;
    }

    public ExtractPedestrianFeatureAttrResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

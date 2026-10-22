package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.google.common.net.b;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PedestrianDetectAttributeResponseBody extends TeaModel {

    @NameInMap("Data")
    public PedestrianDetectAttributeResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class PedestrianDetectAttributeResponseBodyData extends TeaModel {

        @NameInMap("Attributes")
        public List<PedestrianDetectAttributeResponseBodyDataAttributes> attributes;

        @NameInMap("Boxes")
        public List<PedestrianDetectAttributeResponseBodyDataBoxes> boxes;

        @NameInMap(AliyunVodKey.KEY_VOD_HEIGHT)
        public Long height;

        @NameInMap("PersonNumber")
        public Integer personNumber;

        @NameInMap("Width")
        public Long width;

        public static PedestrianDetectAttributeResponseBodyData build(Map<String, ?> map) throws Exception {
            return (PedestrianDetectAttributeResponseBodyData) TeaModel.build(map, new PedestrianDetectAttributeResponseBodyData());
        }

        public List<PedestrianDetectAttributeResponseBodyDataAttributes> getAttributes() {
            return this.attributes;
        }

        public List<PedestrianDetectAttributeResponseBodyDataBoxes> getBoxes() {
            return this.boxes;
        }

        public Long getHeight() {
            return this.height;
        }

        public Integer getPersonNumber() {
            return this.personNumber;
        }

        public Long getWidth() {
            return this.width;
        }

        public PedestrianDetectAttributeResponseBodyData setAttributes(List<PedestrianDetectAttributeResponseBodyDataAttributes> list) {
            this.attributes = list;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyData setBoxes(List<PedestrianDetectAttributeResponseBodyDataBoxes> list) {
            this.boxes = list;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyData setHeight(Long l) {
            this.height = l;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyData setPersonNumber(Integer num) {
            this.personNumber = num;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyData setWidth(Long l) {
            this.width = l;
            return this;
        }
    }

    public static class PedestrianDetectAttributeResponseBodyDataAttributes extends TeaModel {

        @NameInMap(b.X)
        public PedestrianDetectAttributeResponseBodyDataAttributesAge age;

        @NameInMap("Backpack")
        public PedestrianDetectAttributeResponseBodyDataAttributesBackpack backpack;

        @NameInMap("Gender")
        public PedestrianDetectAttributeResponseBodyDataAttributesGender gender;

        @NameInMap("Glasses")
        public PedestrianDetectAttributeResponseBodyDataAttributesGlasses glasses;

        @NameInMap("Handbag")
        public PedestrianDetectAttributeResponseBodyDataAttributesHandbag handbag;

        @NameInMap("Hat")
        public PedestrianDetectAttributeResponseBodyDataAttributesHat hat;

        @NameInMap("LowerColor")
        public PedestrianDetectAttributeResponseBodyDataAttributesLowerColor lowerColor;

        @NameInMap("LowerWear")
        public PedestrianDetectAttributeResponseBodyDataAttributesLowerWear lowerWear;

        @NameInMap("Orient")
        public PedestrianDetectAttributeResponseBodyDataAttributesOrient orient;

        @NameInMap("ShoulderBag")
        public PedestrianDetectAttributeResponseBodyDataAttributesShoulderBag shoulderBag;

        @NameInMap("UpperColor")
        public PedestrianDetectAttributeResponseBodyDataAttributesUpperColor upperColor;

        @NameInMap("UpperWear")
        public PedestrianDetectAttributeResponseBodyDataAttributesUpperWear upperWear;

        public static PedestrianDetectAttributeResponseBodyDataAttributes build(Map<String, ?> map) throws Exception {
            return (PedestrianDetectAttributeResponseBodyDataAttributes) TeaModel.build(map, new PedestrianDetectAttributeResponseBodyDataAttributes());
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesAge getAge() {
            return this.age;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesBackpack getBackpack() {
            return this.backpack;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesGender getGender() {
            return this.gender;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesGlasses getGlasses() {
            return this.glasses;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesHandbag getHandbag() {
            return this.handbag;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesHat getHat() {
            return this.hat;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesLowerColor getLowerColor() {
            return this.lowerColor;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesLowerWear getLowerWear() {
            return this.lowerWear;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesOrient getOrient() {
            return this.orient;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesShoulderBag getShoulderBag() {
            return this.shoulderBag;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesUpperColor getUpperColor() {
            return this.upperColor;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesUpperWear getUpperWear() {
            return this.upperWear;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributes setAge(PedestrianDetectAttributeResponseBodyDataAttributesAge pedestrianDetectAttributeResponseBodyDataAttributesAge) {
            this.age = pedestrianDetectAttributeResponseBodyDataAttributesAge;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributes setBackpack(PedestrianDetectAttributeResponseBodyDataAttributesBackpack pedestrianDetectAttributeResponseBodyDataAttributesBackpack) {
            this.backpack = pedestrianDetectAttributeResponseBodyDataAttributesBackpack;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributes setGender(PedestrianDetectAttributeResponseBodyDataAttributesGender pedestrianDetectAttributeResponseBodyDataAttributesGender) {
            this.gender = pedestrianDetectAttributeResponseBodyDataAttributesGender;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributes setGlasses(PedestrianDetectAttributeResponseBodyDataAttributesGlasses pedestrianDetectAttributeResponseBodyDataAttributesGlasses) {
            this.glasses = pedestrianDetectAttributeResponseBodyDataAttributesGlasses;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributes setHandbag(PedestrianDetectAttributeResponseBodyDataAttributesHandbag pedestrianDetectAttributeResponseBodyDataAttributesHandbag) {
            this.handbag = pedestrianDetectAttributeResponseBodyDataAttributesHandbag;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributes setHat(PedestrianDetectAttributeResponseBodyDataAttributesHat pedestrianDetectAttributeResponseBodyDataAttributesHat) {
            this.hat = pedestrianDetectAttributeResponseBodyDataAttributesHat;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributes setLowerColor(PedestrianDetectAttributeResponseBodyDataAttributesLowerColor pedestrianDetectAttributeResponseBodyDataAttributesLowerColor) {
            this.lowerColor = pedestrianDetectAttributeResponseBodyDataAttributesLowerColor;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributes setLowerWear(PedestrianDetectAttributeResponseBodyDataAttributesLowerWear pedestrianDetectAttributeResponseBodyDataAttributesLowerWear) {
            this.lowerWear = pedestrianDetectAttributeResponseBodyDataAttributesLowerWear;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributes setOrient(PedestrianDetectAttributeResponseBodyDataAttributesOrient pedestrianDetectAttributeResponseBodyDataAttributesOrient) {
            this.orient = pedestrianDetectAttributeResponseBodyDataAttributesOrient;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributes setShoulderBag(PedestrianDetectAttributeResponseBodyDataAttributesShoulderBag pedestrianDetectAttributeResponseBodyDataAttributesShoulderBag) {
            this.shoulderBag = pedestrianDetectAttributeResponseBodyDataAttributesShoulderBag;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributes setUpperColor(PedestrianDetectAttributeResponseBodyDataAttributesUpperColor pedestrianDetectAttributeResponseBodyDataAttributesUpperColor) {
            this.upperColor = pedestrianDetectAttributeResponseBodyDataAttributesUpperColor;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributes setUpperWear(PedestrianDetectAttributeResponseBodyDataAttributesUpperWear pedestrianDetectAttributeResponseBodyDataAttributesUpperWear) {
            this.upperWear = pedestrianDetectAttributeResponseBodyDataAttributesUpperWear;
            return this;
        }
    }

    public static class PedestrianDetectAttributeResponseBodyDataAttributesAge extends TeaModel {

        @NameInMap("Name")
        public String name;

        @NameInMap("Score")
        public Float score;

        public static PedestrianDetectAttributeResponseBodyDataAttributesAge build(Map<String, ?> map) throws Exception {
            return (PedestrianDetectAttributeResponseBodyDataAttributesAge) TeaModel.build(map, new PedestrianDetectAttributeResponseBodyDataAttributesAge());
        }

        public String getName() {
            return this.name;
        }

        public Float getScore() {
            return this.score;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesAge setName(String str) {
            this.name = str;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesAge setScore(Float f) {
            this.score = f;
            return this;
        }
    }

    public static class PedestrianDetectAttributeResponseBodyDataAttributesBackpack extends TeaModel {

        @NameInMap("Name")
        public String name;

        @NameInMap("Score")
        public Float score;

        public static PedestrianDetectAttributeResponseBodyDataAttributesBackpack build(Map<String, ?> map) throws Exception {
            return (PedestrianDetectAttributeResponseBodyDataAttributesBackpack) TeaModel.build(map, new PedestrianDetectAttributeResponseBodyDataAttributesBackpack());
        }

        public String getName() {
            return this.name;
        }

        public Float getScore() {
            return this.score;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesBackpack setName(String str) {
            this.name = str;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesBackpack setScore(Float f) {
            this.score = f;
            return this;
        }
    }

    public static class PedestrianDetectAttributeResponseBodyDataAttributesGender extends TeaModel {

        @NameInMap("Name")
        public String name;

        @NameInMap("Score")
        public Float score;

        public static PedestrianDetectAttributeResponseBodyDataAttributesGender build(Map<String, ?> map) throws Exception {
            return (PedestrianDetectAttributeResponseBodyDataAttributesGender) TeaModel.build(map, new PedestrianDetectAttributeResponseBodyDataAttributesGender());
        }

        public String getName() {
            return this.name;
        }

        public Float getScore() {
            return this.score;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesGender setName(String str) {
            this.name = str;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesGender setScore(Float f) {
            this.score = f;
            return this;
        }
    }

    public static class PedestrianDetectAttributeResponseBodyDataAttributesGlasses extends TeaModel {

        @NameInMap("Name")
        public String name;

        @NameInMap("Score")
        public Float score;

        public static PedestrianDetectAttributeResponseBodyDataAttributesGlasses build(Map<String, ?> map) throws Exception {
            return (PedestrianDetectAttributeResponseBodyDataAttributesGlasses) TeaModel.build(map, new PedestrianDetectAttributeResponseBodyDataAttributesGlasses());
        }

        public String getName() {
            return this.name;
        }

        public Float getScore() {
            return this.score;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesGlasses setName(String str) {
            this.name = str;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesGlasses setScore(Float f) {
            this.score = f;
            return this;
        }
    }

    public static class PedestrianDetectAttributeResponseBodyDataAttributesHandbag extends TeaModel {

        @NameInMap("Name")
        public String name;

        @NameInMap("Score")
        public Float score;

        public static PedestrianDetectAttributeResponseBodyDataAttributesHandbag build(Map<String, ?> map) throws Exception {
            return (PedestrianDetectAttributeResponseBodyDataAttributesHandbag) TeaModel.build(map, new PedestrianDetectAttributeResponseBodyDataAttributesHandbag());
        }

        public String getName() {
            return this.name;
        }

        public Float getScore() {
            return this.score;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesHandbag setName(String str) {
            this.name = str;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesHandbag setScore(Float f) {
            this.score = f;
            return this;
        }
    }

    public static class PedestrianDetectAttributeResponseBodyDataAttributesHat extends TeaModel {

        @NameInMap("Name")
        public String name;

        @NameInMap("Score")
        public Float score;

        public static PedestrianDetectAttributeResponseBodyDataAttributesHat build(Map<String, ?> map) throws Exception {
            return (PedestrianDetectAttributeResponseBodyDataAttributesHat) TeaModel.build(map, new PedestrianDetectAttributeResponseBodyDataAttributesHat());
        }

        public String getName() {
            return this.name;
        }

        public Float getScore() {
            return this.score;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesHat setName(String str) {
            this.name = str;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesHat setScore(Float f) {
            this.score = f;
            return this;
        }
    }

    public static class PedestrianDetectAttributeResponseBodyDataAttributesLowerColor extends TeaModel {

        @NameInMap("Name")
        public String name;

        @NameInMap("Score")
        public Float score;

        public static PedestrianDetectAttributeResponseBodyDataAttributesLowerColor build(Map<String, ?> map) throws Exception {
            return (PedestrianDetectAttributeResponseBodyDataAttributesLowerColor) TeaModel.build(map, new PedestrianDetectAttributeResponseBodyDataAttributesLowerColor());
        }

        public String getName() {
            return this.name;
        }

        public Float getScore() {
            return this.score;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesLowerColor setName(String str) {
            this.name = str;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesLowerColor setScore(Float f) {
            this.score = f;
            return this;
        }
    }

    public static class PedestrianDetectAttributeResponseBodyDataAttributesLowerWear extends TeaModel {

        @NameInMap("Name")
        public String name;

        @NameInMap("Score")
        public Float score;

        public static PedestrianDetectAttributeResponseBodyDataAttributesLowerWear build(Map<String, ?> map) throws Exception {
            return (PedestrianDetectAttributeResponseBodyDataAttributesLowerWear) TeaModel.build(map, new PedestrianDetectAttributeResponseBodyDataAttributesLowerWear());
        }

        public String getName() {
            return this.name;
        }

        public Float getScore() {
            return this.score;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesLowerWear setName(String str) {
            this.name = str;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesLowerWear setScore(Float f) {
            this.score = f;
            return this;
        }
    }

    public static class PedestrianDetectAttributeResponseBodyDataAttributesOrient extends TeaModel {

        @NameInMap("Name")
        public String name;

        @NameInMap("Score")
        public Float score;

        public static PedestrianDetectAttributeResponseBodyDataAttributesOrient build(Map<String, ?> map) throws Exception {
            return (PedestrianDetectAttributeResponseBodyDataAttributesOrient) TeaModel.build(map, new PedestrianDetectAttributeResponseBodyDataAttributesOrient());
        }

        public String getName() {
            return this.name;
        }

        public Float getScore() {
            return this.score;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesOrient setName(String str) {
            this.name = str;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesOrient setScore(Float f) {
            this.score = f;
            return this;
        }
    }

    public static class PedestrianDetectAttributeResponseBodyDataAttributesShoulderBag extends TeaModel {

        @NameInMap("Name")
        public String name;

        @NameInMap("Score")
        public Float score;

        public static PedestrianDetectAttributeResponseBodyDataAttributesShoulderBag build(Map<String, ?> map) throws Exception {
            return (PedestrianDetectAttributeResponseBodyDataAttributesShoulderBag) TeaModel.build(map, new PedestrianDetectAttributeResponseBodyDataAttributesShoulderBag());
        }

        public String getName() {
            return this.name;
        }

        public Float getScore() {
            return this.score;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesShoulderBag setName(String str) {
            this.name = str;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesShoulderBag setScore(Float f) {
            this.score = f;
            return this;
        }
    }

    public static class PedestrianDetectAttributeResponseBodyDataAttributesUpperColor extends TeaModel {

        @NameInMap("Name")
        public String name;

        @NameInMap("Score")
        public Float score;

        public static PedestrianDetectAttributeResponseBodyDataAttributesUpperColor build(Map<String, ?> map) throws Exception {
            return (PedestrianDetectAttributeResponseBodyDataAttributesUpperColor) TeaModel.build(map, new PedestrianDetectAttributeResponseBodyDataAttributesUpperColor());
        }

        public String getName() {
            return this.name;
        }

        public Float getScore() {
            return this.score;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesUpperColor setName(String str) {
            this.name = str;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesUpperColor setScore(Float f) {
            this.score = f;
            return this;
        }
    }

    public static class PedestrianDetectAttributeResponseBodyDataAttributesUpperWear extends TeaModel {

        @NameInMap("Name")
        public String name;

        @NameInMap("Score")
        public Float score;

        public static PedestrianDetectAttributeResponseBodyDataAttributesUpperWear build(Map<String, ?> map) throws Exception {
            return (PedestrianDetectAttributeResponseBodyDataAttributesUpperWear) TeaModel.build(map, new PedestrianDetectAttributeResponseBodyDataAttributesUpperWear());
        }

        public String getName() {
            return this.name;
        }

        public Float getScore() {
            return this.score;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesUpperWear setName(String str) {
            this.name = str;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyDataAttributesUpperWear setScore(Float f) {
            this.score = f;
            return this;
        }
    }

    public static class PedestrianDetectAttributeResponseBodyDataBoxes extends TeaModel {

        @NameInMap("BottomRightX")
        public Float bottomRightX;

        @NameInMap("BottomRightY")
        public Float bottomRightY;

        @NameInMap("Score")
        public Float score;

        @NameInMap("TopLeftX")
        public Float topLeftX;

        @NameInMap("TopLeftY")
        public Float topLeftY;

        public static PedestrianDetectAttributeResponseBodyDataBoxes build(Map<String, ?> map) throws Exception {
            return (PedestrianDetectAttributeResponseBodyDataBoxes) TeaModel.build(map, new PedestrianDetectAttributeResponseBodyDataBoxes());
        }

        public Float getBottomRightX() {
            return this.bottomRightX;
        }

        public Float getBottomRightY() {
            return this.bottomRightY;
        }

        public Float getScore() {
            return this.score;
        }

        public Float getTopLeftX() {
            return this.topLeftX;
        }

        public Float getTopLeftY() {
            return this.topLeftY;
        }

        public PedestrianDetectAttributeResponseBodyDataBoxes setBottomRightX(Float f) {
            this.bottomRightX = f;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyDataBoxes setBottomRightY(Float f) {
            this.bottomRightY = f;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyDataBoxes setScore(Float f) {
            this.score = f;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyDataBoxes setTopLeftX(Float f) {
            this.topLeftX = f;
            return this;
        }

        public PedestrianDetectAttributeResponseBodyDataBoxes setTopLeftY(Float f) {
            this.topLeftY = f;
            return this;
        }
    }

    public static PedestrianDetectAttributeResponseBody build(Map<String, ?> map) throws Exception {
        return (PedestrianDetectAttributeResponseBody) TeaModel.build(map, new PedestrianDetectAttributeResponseBody());
    }

    public PedestrianDetectAttributeResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public PedestrianDetectAttributeResponseBody setData(PedestrianDetectAttributeResponseBodyData pedestrianDetectAttributeResponseBodyData) {
        this.data = pedestrianDetectAttributeResponseBodyData;
        return this;
    }

    public PedestrianDetectAttributeResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

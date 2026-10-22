package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class HandPostureResponseBody extends TeaModel {

    @NameInMap("Data")
    public HandPostureResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class HandPostureResponseBodyData extends TeaModel {

        @NameInMap("MetaObject")
        public HandPostureResponseBodyDataMetaObject metaObject;

        @NameInMap("Outputs")
        public List<HandPostureResponseBodyDataOutputs> outputs;

        public static HandPostureResponseBodyData build(Map<String, ?> map) throws Exception {
            return (HandPostureResponseBodyData) TeaModel.build(map, new HandPostureResponseBodyData());
        }

        public HandPostureResponseBodyDataMetaObject getMetaObject() {
            return this.metaObject;
        }

        public List<HandPostureResponseBodyDataOutputs> getOutputs() {
            return this.outputs;
        }

        public HandPostureResponseBodyData setMetaObject(HandPostureResponseBodyDataMetaObject handPostureResponseBodyDataMetaObject) {
            this.metaObject = handPostureResponseBodyDataMetaObject;
            return this;
        }

        public HandPostureResponseBodyData setOutputs(List<HandPostureResponseBodyDataOutputs> list) {
            this.outputs = list;
            return this;
        }
    }

    public static class HandPostureResponseBodyDataMetaObject extends TeaModel {

        @NameInMap(AliyunVodKey.KEY_VOD_HEIGHT)
        public Integer height;

        @NameInMap("Width")
        public Integer width;

        public static HandPostureResponseBodyDataMetaObject build(Map<String, ?> map) throws Exception {
            return (HandPostureResponseBodyDataMetaObject) TeaModel.build(map, new HandPostureResponseBodyDataMetaObject());
        }

        public Integer getHeight() {
            return this.height;
        }

        public Integer getWidth() {
            return this.width;
        }

        public HandPostureResponseBodyDataMetaObject setHeight(Integer num) {
            this.height = num;
            return this;
        }

        public HandPostureResponseBodyDataMetaObject setWidth(Integer num) {
            this.width = num;
            return this;
        }
    }

    public static class HandPostureResponseBodyDataOutputs extends TeaModel {

        @NameInMap("HandCount")
        public Integer handCount;

        @NameInMap("Results")
        public List<HandPostureResponseBodyDataOutputsResults> results;

        public static HandPostureResponseBodyDataOutputs build(Map<String, ?> map) throws Exception {
            return (HandPostureResponseBodyDataOutputs) TeaModel.build(map, new HandPostureResponseBodyDataOutputs());
        }

        public Integer getHandCount() {
            return this.handCount;
        }

        public List<HandPostureResponseBodyDataOutputsResults> getResults() {
            return this.results;
        }

        public HandPostureResponseBodyDataOutputs setHandCount(Integer num) {
            this.handCount = num;
            return this;
        }

        public HandPostureResponseBodyDataOutputs setResults(List<HandPostureResponseBodyDataOutputsResults> list) {
            this.results = list;
            return this;
        }
    }

    public static class HandPostureResponseBodyDataOutputsResults extends TeaModel {

        @NameInMap("Box")
        public HandPostureResponseBodyDataOutputsResultsBox box;

        @NameInMap("Hands")
        public HandPostureResponseBodyDataOutputsResultsHands hands;

        public static HandPostureResponseBodyDataOutputsResults build(Map<String, ?> map) throws Exception {
            return (HandPostureResponseBodyDataOutputsResults) TeaModel.build(map, new HandPostureResponseBodyDataOutputsResults());
        }

        public HandPostureResponseBodyDataOutputsResultsBox getBox() {
            return this.box;
        }

        public HandPostureResponseBodyDataOutputsResultsHands getHands() {
            return this.hands;
        }

        public HandPostureResponseBodyDataOutputsResults setBox(HandPostureResponseBodyDataOutputsResultsBox handPostureResponseBodyDataOutputsResultsBox) {
            this.box = handPostureResponseBodyDataOutputsResultsBox;
            return this;
        }

        public HandPostureResponseBodyDataOutputsResults setHands(HandPostureResponseBodyDataOutputsResultsHands handPostureResponseBodyDataOutputsResultsHands) {
            this.hands = handPostureResponseBodyDataOutputsResultsHands;
            return this;
        }
    }

    public static class HandPostureResponseBodyDataOutputsResultsBox extends TeaModel {

        @NameInMap("Confident")
        public Float confident;

        @NameInMap("Positions")
        public List<HandPostureResponseBodyDataOutputsResultsBoxPositions> positions;

        public static HandPostureResponseBodyDataOutputsResultsBox build(Map<String, ?> map) throws Exception {
            return (HandPostureResponseBodyDataOutputsResultsBox) TeaModel.build(map, new HandPostureResponseBodyDataOutputsResultsBox());
        }

        public Float getConfident() {
            return this.confident;
        }

        public List<HandPostureResponseBodyDataOutputsResultsBoxPositions> getPositions() {
            return this.positions;
        }

        public HandPostureResponseBodyDataOutputsResultsBox setConfident(Float f) {
            this.confident = f;
            return this;
        }

        public HandPostureResponseBodyDataOutputsResultsBox setPositions(List<HandPostureResponseBodyDataOutputsResultsBoxPositions> list) {
            this.positions = list;
            return this;
        }
    }

    public static class HandPostureResponseBodyDataOutputsResultsBoxPositions extends TeaModel {

        @NameInMap("Points")
        public List<Float> points;

        public static HandPostureResponseBodyDataOutputsResultsBoxPositions build(Map<String, ?> map) throws Exception {
            return (HandPostureResponseBodyDataOutputsResultsBoxPositions) TeaModel.build(map, new HandPostureResponseBodyDataOutputsResultsBoxPositions());
        }

        public List<Float> getPoints() {
            return this.points;
        }

        public HandPostureResponseBodyDataOutputsResultsBoxPositions setPoints(List<Float> list) {
            this.points = list;
            return this;
        }
    }

    public static class HandPostureResponseBodyDataOutputsResultsHands extends TeaModel {

        @NameInMap("Confident")
        public Float confident;

        @NameInMap("KeyPoints")
        public List<HandPostureResponseBodyDataOutputsResultsHandsKeyPoints> keyPoints;

        public static HandPostureResponseBodyDataOutputsResultsHands build(Map<String, ?> map) throws Exception {
            return (HandPostureResponseBodyDataOutputsResultsHands) TeaModel.build(map, new HandPostureResponseBodyDataOutputsResultsHands());
        }

        public Float getConfident() {
            return this.confident;
        }

        public List<HandPostureResponseBodyDataOutputsResultsHandsKeyPoints> getKeyPoints() {
            return this.keyPoints;
        }

        public HandPostureResponseBodyDataOutputsResultsHands setConfident(Float f) {
            this.confident = f;
            return this;
        }

        public HandPostureResponseBodyDataOutputsResultsHands setKeyPoints(List<HandPostureResponseBodyDataOutputsResultsHandsKeyPoints> list) {
            this.keyPoints = list;
            return this;
        }
    }

    public static class HandPostureResponseBodyDataOutputsResultsHandsKeyPoints extends TeaModel {

        @NameInMap("Label")
        public String label;

        @NameInMap("Positions")
        public List<HandPostureResponseBodyDataOutputsResultsHandsKeyPointsPositions> positions;

        public static HandPostureResponseBodyDataOutputsResultsHandsKeyPoints build(Map<String, ?> map) throws Exception {
            return (HandPostureResponseBodyDataOutputsResultsHandsKeyPoints) TeaModel.build(map, new HandPostureResponseBodyDataOutputsResultsHandsKeyPoints());
        }

        public String getLabel() {
            return this.label;
        }

        public List<HandPostureResponseBodyDataOutputsResultsHandsKeyPointsPositions> getPositions() {
            return this.positions;
        }

        public HandPostureResponseBodyDataOutputsResultsHandsKeyPoints setLabel(String str) {
            this.label = str;
            return this;
        }

        public HandPostureResponseBodyDataOutputsResultsHandsKeyPoints setPositions(List<HandPostureResponseBodyDataOutputsResultsHandsKeyPointsPositions> list) {
            this.positions = list;
            return this;
        }
    }

    public static class HandPostureResponseBodyDataOutputsResultsHandsKeyPointsPositions extends TeaModel {

        @NameInMap("Points")
        public List<Float> points;

        public static HandPostureResponseBodyDataOutputsResultsHandsKeyPointsPositions build(Map<String, ?> map) throws Exception {
            return (HandPostureResponseBodyDataOutputsResultsHandsKeyPointsPositions) TeaModel.build(map, new HandPostureResponseBodyDataOutputsResultsHandsKeyPointsPositions());
        }

        public List<Float> getPoints() {
            return this.points;
        }

        public HandPostureResponseBodyDataOutputsResultsHandsKeyPointsPositions setPoints(List<Float> list) {
            this.points = list;
            return this;
        }
    }

    public static HandPostureResponseBody build(Map<String, ?> map) throws Exception {
        return (HandPostureResponseBody) TeaModel.build(map, new HandPostureResponseBody());
    }

    public HandPostureResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public HandPostureResponseBody setData(HandPostureResponseBodyData handPostureResponseBodyData) {
        this.data = handPostureResponseBodyData;
        return this;
    }

    public HandPostureResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

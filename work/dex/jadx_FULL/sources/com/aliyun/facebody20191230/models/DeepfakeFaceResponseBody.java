package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DeepfakeFaceResponseBody extends TeaModel {

    @NameInMap("Data")
    public DeepfakeFaceResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class DeepfakeFaceResponseBodyData extends TeaModel {

        @NameInMap("Elements")
        public List<DeepfakeFaceResponseBodyDataElements> elements;

        public static DeepfakeFaceResponseBodyData build(Map<String, ?> map) throws Exception {
            return (DeepfakeFaceResponseBodyData) TeaModel.build(map, new DeepfakeFaceResponseBodyData());
        }

        public List<DeepfakeFaceResponseBodyDataElements> getElements() {
            return this.elements;
        }

        public DeepfakeFaceResponseBodyData setElements(List<DeepfakeFaceResponseBodyDataElements> list) {
            this.elements = list;
            return this;
        }
    }

    public static class DeepfakeFaceResponseBodyDataElements extends TeaModel {

        @NameInMap("FaceNumber")
        public Long faceNumber;

        @NameInMap("ImageURL")
        public String imageURL;

        @NameInMap("Results")
        public List<DeepfakeFaceResponseBodyDataElementsResults> results;

        @NameInMap("TaskId")
        public String taskId;

        public static DeepfakeFaceResponseBodyDataElements build(Map<String, ?> map) throws Exception {
            return (DeepfakeFaceResponseBodyDataElements) TeaModel.build(map, new DeepfakeFaceResponseBodyDataElements());
        }

        public Long getFaceNumber() {
            return this.faceNumber;
        }

        public String getImageURL() {
            return this.imageURL;
        }

        public List<DeepfakeFaceResponseBodyDataElementsResults> getResults() {
            return this.results;
        }

        public String getTaskId() {
            return this.taskId;
        }

        public DeepfakeFaceResponseBodyDataElements setFaceNumber(Long l) {
            this.faceNumber = l;
            return this;
        }

        public DeepfakeFaceResponseBodyDataElements setImageURL(String str) {
            this.imageURL = str;
            return this;
        }

        public DeepfakeFaceResponseBodyDataElements setResults(List<DeepfakeFaceResponseBodyDataElementsResults> list) {
            this.results = list;
            return this;
        }

        public DeepfakeFaceResponseBodyDataElements setTaskId(String str) {
            this.taskId = str;
            return this;
        }
    }

    public static class DeepfakeFaceResponseBodyDataElementsResults extends TeaModel {

        @NameInMap("Confidence")
        public Float confidence;

        @NameInMap("Label")
        public String label;

        @NameInMap("MessageTips")
        public String messageTips;

        @NameInMap("Rect")
        public DeepfakeFaceResponseBodyDataElementsResultsRect rect;

        public static DeepfakeFaceResponseBodyDataElementsResults build(Map<String, ?> map) throws Exception {
            return (DeepfakeFaceResponseBodyDataElementsResults) TeaModel.build(map, new DeepfakeFaceResponseBodyDataElementsResults());
        }

        public Float getConfidence() {
            return this.confidence;
        }

        public String getLabel() {
            return this.label;
        }

        public String getMessageTips() {
            return this.messageTips;
        }

        public DeepfakeFaceResponseBodyDataElementsResultsRect getRect() {
            return this.rect;
        }

        public DeepfakeFaceResponseBodyDataElementsResults setConfidence(Float f) {
            this.confidence = f;
            return this;
        }

        public DeepfakeFaceResponseBodyDataElementsResults setLabel(String str) {
            this.label = str;
            return this;
        }

        public DeepfakeFaceResponseBodyDataElementsResults setMessageTips(String str) {
            this.messageTips = str;
            return this;
        }

        public DeepfakeFaceResponseBodyDataElementsResults setRect(DeepfakeFaceResponseBodyDataElementsResultsRect deepfakeFaceResponseBodyDataElementsResultsRect) {
            this.rect = deepfakeFaceResponseBodyDataElementsResultsRect;
            return this;
        }
    }

    public static class DeepfakeFaceResponseBodyDataElementsResultsRect extends TeaModel {

        @NameInMap(AliyunVodKey.KEY_VOD_HEIGHT)
        public Long height;

        @NameInMap("Left")
        public Long left;

        @NameInMap("Top")
        public Long top;

        @NameInMap("Width")
        public Long width;

        public static DeepfakeFaceResponseBodyDataElementsResultsRect build(Map<String, ?> map) throws Exception {
            return (DeepfakeFaceResponseBodyDataElementsResultsRect) TeaModel.build(map, new DeepfakeFaceResponseBodyDataElementsResultsRect());
        }

        public Long getHeight() {
            return this.height;
        }

        public Long getLeft() {
            return this.left;
        }

        public Long getTop() {
            return this.top;
        }

        public Long getWidth() {
            return this.width;
        }

        public DeepfakeFaceResponseBodyDataElementsResultsRect setHeight(Long l) {
            this.height = l;
            return this;
        }

        public DeepfakeFaceResponseBodyDataElementsResultsRect setLeft(Long l) {
            this.left = l;
            return this;
        }

        public DeepfakeFaceResponseBodyDataElementsResultsRect setTop(Long l) {
            this.top = l;
            return this;
        }

        public DeepfakeFaceResponseBodyDataElementsResultsRect setWidth(Long l) {
            this.width = l;
            return this;
        }
    }

    public static DeepfakeFaceResponseBody build(Map<String, ?> map) throws Exception {
        return (DeepfakeFaceResponseBody) TeaModel.build(map, new DeepfakeFaceResponseBody());
    }

    public DeepfakeFaceResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public DeepfakeFaceResponseBody setData(DeepfakeFaceResponseBodyData deepfakeFaceResponseBodyData) {
        this.data = deepfakeFaceResponseBodyData;
        return this;
    }

    public DeepfakeFaceResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

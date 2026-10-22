package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectInfraredLivingFaceResponseBody extends TeaModel {

    @NameInMap("Data")
    public DetectInfraredLivingFaceResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class DetectInfraredLivingFaceResponseBodyData extends TeaModel {

        @NameInMap("Elements")
        public List<DetectInfraredLivingFaceResponseBodyDataElements> elements;

        public static DetectInfraredLivingFaceResponseBodyData build(Map<String, ?> map) throws Exception {
            return (DetectInfraredLivingFaceResponseBodyData) TeaModel.build(map, new DetectInfraredLivingFaceResponseBodyData());
        }

        public List<DetectInfraredLivingFaceResponseBodyDataElements> getElements() {
            return this.elements;
        }

        public DetectInfraredLivingFaceResponseBodyData setElements(List<DetectInfraredLivingFaceResponseBodyDataElements> list) {
            this.elements = list;
            return this;
        }
    }

    public static class DetectInfraredLivingFaceResponseBodyDataElements extends TeaModel {

        @NameInMap("FaceNumber")
        public Long faceNumber;

        @NameInMap("ImageURL")
        public String imageURL;

        @NameInMap("Results")
        public List<DetectInfraredLivingFaceResponseBodyDataElementsResults> results;

        public static DetectInfraredLivingFaceResponseBodyDataElements build(Map<String, ?> map) throws Exception {
            return (DetectInfraredLivingFaceResponseBodyDataElements) TeaModel.build(map, new DetectInfraredLivingFaceResponseBodyDataElements());
        }

        public Long getFaceNumber() {
            return this.faceNumber;
        }

        public String getImageURL() {
            return this.imageURL;
        }

        public List<DetectInfraredLivingFaceResponseBodyDataElementsResults> getResults() {
            return this.results;
        }

        public DetectInfraredLivingFaceResponseBodyDataElements setFaceNumber(Long l) {
            this.faceNumber = l;
            return this;
        }

        public DetectInfraredLivingFaceResponseBodyDataElements setImageURL(String str) {
            this.imageURL = str;
            return this;
        }

        public DetectInfraredLivingFaceResponseBodyDataElements setResults(List<DetectInfraredLivingFaceResponseBodyDataElementsResults> list) {
            this.results = list;
            return this;
        }
    }

    public static class DetectInfraredLivingFaceResponseBodyDataElementsResults extends TeaModel {

        @NameInMap("Label")
        public String label;

        @NameInMap("MessageTips")
        public String messageTips;

        @NameInMap("Rate")
        public Float rate;

        @NameInMap("Rect")
        public DetectInfraredLivingFaceResponseBodyDataElementsResultsRect rect;

        @NameInMap("Suggestion")
        public String suggestion;

        public static DetectInfraredLivingFaceResponseBodyDataElementsResults build(Map<String, ?> map) throws Exception {
            return (DetectInfraredLivingFaceResponseBodyDataElementsResults) TeaModel.build(map, new DetectInfraredLivingFaceResponseBodyDataElementsResults());
        }

        public String getLabel() {
            return this.label;
        }

        public String getMessageTips() {
            return this.messageTips;
        }

        public Float getRate() {
            return this.rate;
        }

        public DetectInfraredLivingFaceResponseBodyDataElementsResultsRect getRect() {
            return this.rect;
        }

        public String getSuggestion() {
            return this.suggestion;
        }

        public DetectInfraredLivingFaceResponseBodyDataElementsResults setLabel(String str) {
            this.label = str;
            return this;
        }

        public DetectInfraredLivingFaceResponseBodyDataElementsResults setMessageTips(String str) {
            this.messageTips = str;
            return this;
        }

        public DetectInfraredLivingFaceResponseBodyDataElementsResults setRate(Float f) {
            this.rate = f;
            return this;
        }

        public DetectInfraredLivingFaceResponseBodyDataElementsResults setRect(DetectInfraredLivingFaceResponseBodyDataElementsResultsRect detectInfraredLivingFaceResponseBodyDataElementsResultsRect) {
            this.rect = detectInfraredLivingFaceResponseBodyDataElementsResultsRect;
            return this;
        }

        public DetectInfraredLivingFaceResponseBodyDataElementsResults setSuggestion(String str) {
            this.suggestion = str;
            return this;
        }
    }

    public static class DetectInfraredLivingFaceResponseBodyDataElementsResultsRect extends TeaModel {

        @NameInMap(AliyunVodKey.KEY_VOD_HEIGHT)
        public Long height;

        @NameInMap("Left")
        public Long left;

        @NameInMap("Top")
        public Long top;

        @NameInMap("Width")
        public Long width;

        public static DetectInfraredLivingFaceResponseBodyDataElementsResultsRect build(Map<String, ?> map) throws Exception {
            return (DetectInfraredLivingFaceResponseBodyDataElementsResultsRect) TeaModel.build(map, new DetectInfraredLivingFaceResponseBodyDataElementsResultsRect());
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

        public DetectInfraredLivingFaceResponseBodyDataElementsResultsRect setHeight(Long l) {
            this.height = l;
            return this;
        }

        public DetectInfraredLivingFaceResponseBodyDataElementsResultsRect setLeft(Long l) {
            this.left = l;
            return this;
        }

        public DetectInfraredLivingFaceResponseBodyDataElementsResultsRect setTop(Long l) {
            this.top = l;
            return this;
        }

        public DetectInfraredLivingFaceResponseBodyDataElementsResultsRect setWidth(Long l) {
            this.width = l;
            return this;
        }
    }

    public static DetectInfraredLivingFaceResponseBody build(Map<String, ?> map) throws Exception {
        return (DetectInfraredLivingFaceResponseBody) TeaModel.build(map, new DetectInfraredLivingFaceResponseBody());
    }

    public DetectInfraredLivingFaceResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public DetectInfraredLivingFaceResponseBody setData(DetectInfraredLivingFaceResponseBodyData detectInfraredLivingFaceResponseBodyData) {
        this.data = detectInfraredLivingFaceResponseBodyData;
        return this;
    }

    public DetectInfraredLivingFaceResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

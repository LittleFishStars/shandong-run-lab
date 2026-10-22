package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectLivingFaceResponseBody extends TeaModel {

    @NameInMap("Data")
    public DetectLivingFaceResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class DetectLivingFaceResponseBodyData extends TeaModel {

        @NameInMap("Elements")
        public List<DetectLivingFaceResponseBodyDataElements> elements;

        public static DetectLivingFaceResponseBodyData build(Map<String, ?> map) throws Exception {
            return (DetectLivingFaceResponseBodyData) TeaModel.build(map, new DetectLivingFaceResponseBodyData());
        }

        public List<DetectLivingFaceResponseBodyDataElements> getElements() {
            return this.elements;
        }

        public DetectLivingFaceResponseBodyData setElements(List<DetectLivingFaceResponseBodyDataElements> list) {
            this.elements = list;
            return this;
        }
    }

    public static class DetectLivingFaceResponseBodyDataElements extends TeaModel {

        @NameInMap("FaceNumber")
        public Long faceNumber;

        @NameInMap("ImageURL")
        public String imageURL;

        @NameInMap("Results")
        public List<DetectLivingFaceResponseBodyDataElementsResults> results;

        @NameInMap("TaskId")
        public String taskId;

        public static DetectLivingFaceResponseBodyDataElements build(Map<String, ?> map) throws Exception {
            return (DetectLivingFaceResponseBodyDataElements) TeaModel.build(map, new DetectLivingFaceResponseBodyDataElements());
        }

        public Long getFaceNumber() {
            return this.faceNumber;
        }

        public String getImageURL() {
            return this.imageURL;
        }

        public List<DetectLivingFaceResponseBodyDataElementsResults> getResults() {
            return this.results;
        }

        public String getTaskId() {
            return this.taskId;
        }

        public DetectLivingFaceResponseBodyDataElements setFaceNumber(Long l) {
            this.faceNumber = l;
            return this;
        }

        public DetectLivingFaceResponseBodyDataElements setImageURL(String str) {
            this.imageURL = str;
            return this;
        }

        public DetectLivingFaceResponseBodyDataElements setResults(List<DetectLivingFaceResponseBodyDataElementsResults> list) {
            this.results = list;
            return this;
        }

        public DetectLivingFaceResponseBodyDataElements setTaskId(String str) {
            this.taskId = str;
            return this;
        }
    }

    public static class DetectLivingFaceResponseBodyDataElementsResults extends TeaModel {

        @NameInMap("Frames")
        public List<DetectLivingFaceResponseBodyDataElementsResultsFrames> frames;

        @NameInMap("Label")
        public String label;

        @NameInMap("MessageTips")
        public String messageTips;

        @NameInMap("Rate")
        public Float rate;

        @NameInMap("Rect")
        public DetectLivingFaceResponseBodyDataElementsResultsRect rect;

        @NameInMap("Suggestion")
        public String suggestion;

        public static DetectLivingFaceResponseBodyDataElementsResults build(Map<String, ?> map) throws Exception {
            return (DetectLivingFaceResponseBodyDataElementsResults) TeaModel.build(map, new DetectLivingFaceResponseBodyDataElementsResults());
        }

        public List<DetectLivingFaceResponseBodyDataElementsResultsFrames> getFrames() {
            return this.frames;
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

        public DetectLivingFaceResponseBodyDataElementsResultsRect getRect() {
            return this.rect;
        }

        public String getSuggestion() {
            return this.suggestion;
        }

        public DetectLivingFaceResponseBodyDataElementsResults setFrames(List<DetectLivingFaceResponseBodyDataElementsResultsFrames> list) {
            this.frames = list;
            return this;
        }

        public DetectLivingFaceResponseBodyDataElementsResults setLabel(String str) {
            this.label = str;
            return this;
        }

        public DetectLivingFaceResponseBodyDataElementsResults setMessageTips(String str) {
            this.messageTips = str;
            return this;
        }

        public DetectLivingFaceResponseBodyDataElementsResults setRate(Float f) {
            this.rate = f;
            return this;
        }

        public DetectLivingFaceResponseBodyDataElementsResults setRect(DetectLivingFaceResponseBodyDataElementsResultsRect detectLivingFaceResponseBodyDataElementsResultsRect) {
            this.rect = detectLivingFaceResponseBodyDataElementsResultsRect;
            return this;
        }

        public DetectLivingFaceResponseBodyDataElementsResults setSuggestion(String str) {
            this.suggestion = str;
            return this;
        }
    }

    public static class DetectLivingFaceResponseBodyDataElementsResultsFrames extends TeaModel {

        @NameInMap("Rate")
        public Float rate;

        @NameInMap(SsManifestParser.d.p)
        public String url;

        public static DetectLivingFaceResponseBodyDataElementsResultsFrames build(Map<String, ?> map) throws Exception {
            return (DetectLivingFaceResponseBodyDataElementsResultsFrames) TeaModel.build(map, new DetectLivingFaceResponseBodyDataElementsResultsFrames());
        }

        public Float getRate() {
            return this.rate;
        }

        public String getUrl() {
            return this.url;
        }

        public DetectLivingFaceResponseBodyDataElementsResultsFrames setRate(Float f) {
            this.rate = f;
            return this;
        }

        public DetectLivingFaceResponseBodyDataElementsResultsFrames setUrl(String str) {
            this.url = str;
            return this;
        }
    }

    public static class DetectLivingFaceResponseBodyDataElementsResultsRect extends TeaModel {

        @NameInMap(AliyunVodKey.KEY_VOD_HEIGHT)
        public Long height;

        @NameInMap("Left")
        public Long left;

        @NameInMap("Top")
        public Long top;

        @NameInMap("Width")
        public Long width;

        public static DetectLivingFaceResponseBodyDataElementsResultsRect build(Map<String, ?> map) throws Exception {
            return (DetectLivingFaceResponseBodyDataElementsResultsRect) TeaModel.build(map, new DetectLivingFaceResponseBodyDataElementsResultsRect());
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

        public DetectLivingFaceResponseBodyDataElementsResultsRect setHeight(Long l) {
            this.height = l;
            return this;
        }

        public DetectLivingFaceResponseBodyDataElementsResultsRect setLeft(Long l) {
            this.left = l;
            return this;
        }

        public DetectLivingFaceResponseBodyDataElementsResultsRect setTop(Long l) {
            this.top = l;
            return this;
        }

        public DetectLivingFaceResponseBodyDataElementsResultsRect setWidth(Long l) {
            this.width = l;
            return this;
        }
    }

    public static DetectLivingFaceResponseBody build(Map<String, ?> map) throws Exception {
        return (DetectLivingFaceResponseBody) TeaModel.build(map, new DetectLivingFaceResponseBody());
    }

    public DetectLivingFaceResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public DetectLivingFaceResponseBody setData(DetectLivingFaceResponseBodyData detectLivingFaceResponseBodyData) {
        this.data = detectLivingFaceResponseBodyData;
        return this;
    }

    public DetectLivingFaceResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

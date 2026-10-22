package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RecognizePublicFaceResponseBody extends TeaModel {

    @NameInMap("Data")
    public RecognizePublicFaceResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class RecognizePublicFaceResponseBodyData extends TeaModel {

        @NameInMap("Elements")
        public List<RecognizePublicFaceResponseBodyDataElements> elements;

        public static RecognizePublicFaceResponseBodyData build(Map<String, ?> map) throws Exception {
            return (RecognizePublicFaceResponseBodyData) TeaModel.build(map, new RecognizePublicFaceResponseBodyData());
        }

        public List<RecognizePublicFaceResponseBodyDataElements> getElements() {
            return this.elements;
        }

        public RecognizePublicFaceResponseBodyData setElements(List<RecognizePublicFaceResponseBodyDataElements> list) {
            this.elements = list;
            return this;
        }
    }

    public static class RecognizePublicFaceResponseBodyDataElements extends TeaModel {

        @NameInMap("ImageURL")
        public String imageURL;

        @NameInMap("Results")
        public List<RecognizePublicFaceResponseBodyDataElementsResults> results;

        @NameInMap("TaskId")
        public String taskId;

        public static RecognizePublicFaceResponseBodyDataElements build(Map<String, ?> map) throws Exception {
            return (RecognizePublicFaceResponseBodyDataElements) TeaModel.build(map, new RecognizePublicFaceResponseBodyDataElements());
        }

        public String getImageURL() {
            return this.imageURL;
        }

        public List<RecognizePublicFaceResponseBodyDataElementsResults> getResults() {
            return this.results;
        }

        public String getTaskId() {
            return this.taskId;
        }

        public RecognizePublicFaceResponseBodyDataElements setImageURL(String str) {
            this.imageURL = str;
            return this;
        }

        public RecognizePublicFaceResponseBodyDataElements setResults(List<RecognizePublicFaceResponseBodyDataElementsResults> list) {
            this.results = list;
            return this;
        }

        public RecognizePublicFaceResponseBodyDataElements setTaskId(String str) {
            this.taskId = str;
            return this;
        }
    }

    public static class RecognizePublicFaceResponseBodyDataElementsResults extends TeaModel {

        @NameInMap("Label")
        public String label;

        @NameInMap("Rate")
        public Float rate;

        @NameInMap("SubResults")
        public List<RecognizePublicFaceResponseBodyDataElementsResultsSubResults> subResults;

        @NameInMap("Suggestion")
        public String suggestion;

        public static RecognizePublicFaceResponseBodyDataElementsResults build(Map<String, ?> map) throws Exception {
            return (RecognizePublicFaceResponseBodyDataElementsResults) TeaModel.build(map, new RecognizePublicFaceResponseBodyDataElementsResults());
        }

        public String getLabel() {
            return this.label;
        }

        public Float getRate() {
            return this.rate;
        }

        public List<RecognizePublicFaceResponseBodyDataElementsResultsSubResults> getSubResults() {
            return this.subResults;
        }

        public String getSuggestion() {
            return this.suggestion;
        }

        public RecognizePublicFaceResponseBodyDataElementsResults setLabel(String str) {
            this.label = str;
            return this;
        }

        public RecognizePublicFaceResponseBodyDataElementsResults setRate(Float f) {
            this.rate = f;
            return this;
        }

        public RecognizePublicFaceResponseBodyDataElementsResults setSubResults(List<RecognizePublicFaceResponseBodyDataElementsResultsSubResults> list) {
            this.subResults = list;
            return this;
        }

        public RecognizePublicFaceResponseBodyDataElementsResults setSuggestion(String str) {
            this.suggestion = str;
            return this;
        }
    }

    public static class RecognizePublicFaceResponseBodyDataElementsResultsSubResults extends TeaModel {

        @NameInMap("Faces")
        public List<RecognizePublicFaceResponseBodyDataElementsResultsSubResultsFaces> faces;

        @NameInMap("H")
        public Float h;

        @NameInMap("W")
        public Float w;

        @NameInMap("X")
        public Float x;

        @NameInMap("Y")
        public Float y;

        public static RecognizePublicFaceResponseBodyDataElementsResultsSubResults build(Map<String, ?> map) throws Exception {
            return (RecognizePublicFaceResponseBodyDataElementsResultsSubResults) TeaModel.build(map, new RecognizePublicFaceResponseBodyDataElementsResultsSubResults());
        }

        public List<RecognizePublicFaceResponseBodyDataElementsResultsSubResultsFaces> getFaces() {
            return this.faces;
        }

        public Float getH() {
            return this.h;
        }

        public Float getW() {
            return this.w;
        }

        public Float getX() {
            return this.x;
        }

        public Float getY() {
            return this.y;
        }

        public RecognizePublicFaceResponseBodyDataElementsResultsSubResults setFaces(List<RecognizePublicFaceResponseBodyDataElementsResultsSubResultsFaces> list) {
            this.faces = list;
            return this;
        }

        public RecognizePublicFaceResponseBodyDataElementsResultsSubResults setH(Float f) {
            this.h = f;
            return this;
        }

        public RecognizePublicFaceResponseBodyDataElementsResultsSubResults setW(Float f) {
            this.w = f;
            return this;
        }

        public RecognizePublicFaceResponseBodyDataElementsResultsSubResults setX(Float f) {
            this.x = f;
            return this;
        }

        public RecognizePublicFaceResponseBodyDataElementsResultsSubResults setY(Float f) {
            this.y = f;
            return this;
        }
    }

    public static class RecognizePublicFaceResponseBodyDataElementsResultsSubResultsFaces extends TeaModel {

        @NameInMap("Id")
        public String id;

        @NameInMap("Name")
        public String name;

        @NameInMap("Rate")
        public Float rate;

        public static RecognizePublicFaceResponseBodyDataElementsResultsSubResultsFaces build(Map<String, ?> map) throws Exception {
            return (RecognizePublicFaceResponseBodyDataElementsResultsSubResultsFaces) TeaModel.build(map, new RecognizePublicFaceResponseBodyDataElementsResultsSubResultsFaces());
        }

        public String getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public Float getRate() {
            return this.rate;
        }

        public RecognizePublicFaceResponseBodyDataElementsResultsSubResultsFaces setId(String str) {
            this.id = str;
            return this;
        }

        public RecognizePublicFaceResponseBodyDataElementsResultsSubResultsFaces setName(String str) {
            this.name = str;
            return this;
        }

        public RecognizePublicFaceResponseBodyDataElementsResultsSubResultsFaces setRate(Float f) {
            this.rate = f;
            return this;
        }
    }

    public static RecognizePublicFaceResponseBody build(Map<String, ?> map) throws Exception {
        return (RecognizePublicFaceResponseBody) TeaModel.build(map, new RecognizePublicFaceResponseBody());
    }

    public RecognizePublicFaceResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public RecognizePublicFaceResponseBody setData(RecognizePublicFaceResponseBodyData recognizePublicFaceResponseBodyData) {
        this.data = recognizePublicFaceResponseBodyData;
        return this;
    }

    public RecognizePublicFaceResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

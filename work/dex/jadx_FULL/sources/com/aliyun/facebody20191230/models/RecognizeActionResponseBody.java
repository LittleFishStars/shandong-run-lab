package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RecognizeActionResponseBody extends TeaModel {

    @NameInMap("Data")
    public RecognizeActionResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class RecognizeActionResponseBodyData extends TeaModel {

        @NameInMap("Elements")
        public List<RecognizeActionResponseBodyDataElements> elements;

        public static RecognizeActionResponseBodyData build(Map<String, ?> map) throws Exception {
            return (RecognizeActionResponseBodyData) TeaModel.build(map, new RecognizeActionResponseBodyData());
        }

        public List<RecognizeActionResponseBodyDataElements> getElements() {
            return this.elements;
        }

        public RecognizeActionResponseBodyData setElements(List<RecognizeActionResponseBodyDataElements> list) {
            this.elements = list;
            return this;
        }
    }

    public static class RecognizeActionResponseBodyDataElements extends TeaModel {

        @NameInMap("Boxes")
        public List<RecognizeActionResponseBodyDataElementsBoxes> boxes;

        @NameInMap("Labels")
        public List<String> labels;

        @NameInMap("Scores")
        public List<Float> scores;

        @NameInMap("Timestamp")
        public Integer timestamp;

        public static RecognizeActionResponseBodyDataElements build(Map<String, ?> map) throws Exception {
            return (RecognizeActionResponseBodyDataElements) TeaModel.build(map, new RecognizeActionResponseBodyDataElements());
        }

        public List<RecognizeActionResponseBodyDataElementsBoxes> getBoxes() {
            return this.boxes;
        }

        public List<String> getLabels() {
            return this.labels;
        }

        public List<Float> getScores() {
            return this.scores;
        }

        public Integer getTimestamp() {
            return this.timestamp;
        }

        public RecognizeActionResponseBodyDataElements setBoxes(List<RecognizeActionResponseBodyDataElementsBoxes> list) {
            this.boxes = list;
            return this;
        }

        public RecognizeActionResponseBodyDataElements setLabels(List<String> list) {
            this.labels = list;
            return this;
        }

        public RecognizeActionResponseBodyDataElements setScores(List<Float> list) {
            this.scores = list;
            return this;
        }

        public RecognizeActionResponseBodyDataElements setTimestamp(Integer num) {
            this.timestamp = num;
            return this;
        }
    }

    public static class RecognizeActionResponseBodyDataElementsBoxes extends TeaModel {

        @NameInMap("Box")
        public List<Integer> box;

        public static RecognizeActionResponseBodyDataElementsBoxes build(Map<String, ?> map) throws Exception {
            return (RecognizeActionResponseBodyDataElementsBoxes) TeaModel.build(map, new RecognizeActionResponseBodyDataElementsBoxes());
        }

        public List<Integer> getBox() {
            return this.box;
        }

        public RecognizeActionResponseBodyDataElementsBoxes setBox(List<Integer> list) {
            this.box = list;
            return this;
        }
    }

    public static RecognizeActionResponseBody build(Map<String, ?> map) throws Exception {
        return (RecognizeActionResponseBody) TeaModel.build(map, new RecognizeActionResponseBody());
    }

    public RecognizeActionResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public RecognizeActionResponseBody setData(RecognizeActionResponseBodyData recognizeActionResponseBodyData) {
        this.data = recognizeActionResponseBodyData;
        return this;
    }

    public RecognizeActionResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

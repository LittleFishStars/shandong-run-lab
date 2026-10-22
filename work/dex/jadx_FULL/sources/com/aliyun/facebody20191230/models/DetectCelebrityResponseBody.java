package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectCelebrityResponseBody extends TeaModel {

    @NameInMap("Data")
    public DetectCelebrityResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class DetectCelebrityResponseBodyData extends TeaModel {

        @NameInMap("FaceRecognizeResults")
        public List<DetectCelebrityResponseBodyDataFaceRecognizeResults> faceRecognizeResults;

        @NameInMap(AliyunVodKey.KEY_VOD_HEIGHT)
        public Integer height;

        @NameInMap("Width")
        public Integer width;

        public static DetectCelebrityResponseBodyData build(Map<String, ?> map) throws Exception {
            return (DetectCelebrityResponseBodyData) TeaModel.build(map, new DetectCelebrityResponseBodyData());
        }

        public List<DetectCelebrityResponseBodyDataFaceRecognizeResults> getFaceRecognizeResults() {
            return this.faceRecognizeResults;
        }

        public Integer getHeight() {
            return this.height;
        }

        public Integer getWidth() {
            return this.width;
        }

        public DetectCelebrityResponseBodyData setFaceRecognizeResults(List<DetectCelebrityResponseBodyDataFaceRecognizeResults> list) {
            this.faceRecognizeResults = list;
            return this;
        }

        public DetectCelebrityResponseBodyData setHeight(Integer num) {
            this.height = num;
            return this;
        }

        public DetectCelebrityResponseBodyData setWidth(Integer num) {
            this.width = num;
            return this;
        }
    }

    public static class DetectCelebrityResponseBodyDataFaceRecognizeResults extends TeaModel {

        @NameInMap("FaceBoxes")
        public List<Float> faceBoxes;

        @NameInMap("Name")
        public String name;

        public static DetectCelebrityResponseBodyDataFaceRecognizeResults build(Map<String, ?> map) throws Exception {
            return (DetectCelebrityResponseBodyDataFaceRecognizeResults) TeaModel.build(map, new DetectCelebrityResponseBodyDataFaceRecognizeResults());
        }

        public List<Float> getFaceBoxes() {
            return this.faceBoxes;
        }

        public String getName() {
            return this.name;
        }

        public DetectCelebrityResponseBodyDataFaceRecognizeResults setFaceBoxes(List<Float> list) {
            this.faceBoxes = list;
            return this;
        }

        public DetectCelebrityResponseBodyDataFaceRecognizeResults setName(String str) {
            this.name = str;
            return this;
        }
    }

    public static DetectCelebrityResponseBody build(Map<String, ?> map) throws Exception {
        return (DetectCelebrityResponseBody) TeaModel.build(map, new DetectCelebrityResponseBody());
    }

    public DetectCelebrityResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public DetectCelebrityResponseBody setData(DetectCelebrityResponseBodyData detectCelebrityResponseBodyData) {
        this.data = detectCelebrityResponseBodyData;
        return this;
    }

    public DetectCelebrityResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

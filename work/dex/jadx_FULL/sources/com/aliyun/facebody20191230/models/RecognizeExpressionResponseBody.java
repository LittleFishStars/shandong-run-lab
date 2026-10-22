package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RecognizeExpressionResponseBody extends TeaModel {

    @NameInMap("Data")
    public RecognizeExpressionResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class RecognizeExpressionResponseBodyData extends TeaModel {

        @NameInMap("Elements")
        public List<RecognizeExpressionResponseBodyDataElements> elements;

        public static RecognizeExpressionResponseBodyData build(Map<String, ?> map) throws Exception {
            return (RecognizeExpressionResponseBodyData) TeaModel.build(map, new RecognizeExpressionResponseBodyData());
        }

        public List<RecognizeExpressionResponseBodyDataElements> getElements() {
            return this.elements;
        }

        public RecognizeExpressionResponseBodyData setElements(List<RecognizeExpressionResponseBodyDataElements> list) {
            this.elements = list;
            return this;
        }
    }

    public static class RecognizeExpressionResponseBodyDataElements extends TeaModel {

        @NameInMap("Expression")
        public String expression;

        @NameInMap("FaceProbability")
        public Float faceProbability;

        @NameInMap("FaceRectangle")
        public RecognizeExpressionResponseBodyDataElementsFaceRectangle faceRectangle;

        public static RecognizeExpressionResponseBodyDataElements build(Map<String, ?> map) throws Exception {
            return (RecognizeExpressionResponseBodyDataElements) TeaModel.build(map, new RecognizeExpressionResponseBodyDataElements());
        }

        public String getExpression() {
            return this.expression;
        }

        public Float getFaceProbability() {
            return this.faceProbability;
        }

        public RecognizeExpressionResponseBodyDataElementsFaceRectangle getFaceRectangle() {
            return this.faceRectangle;
        }

        public RecognizeExpressionResponseBodyDataElements setExpression(String str) {
            this.expression = str;
            return this;
        }

        public RecognizeExpressionResponseBodyDataElements setFaceProbability(Float f) {
            this.faceProbability = f;
            return this;
        }

        public RecognizeExpressionResponseBodyDataElements setFaceRectangle(RecognizeExpressionResponseBodyDataElementsFaceRectangle recognizeExpressionResponseBodyDataElementsFaceRectangle) {
            this.faceRectangle = recognizeExpressionResponseBodyDataElementsFaceRectangle;
            return this;
        }
    }

    public static class RecognizeExpressionResponseBodyDataElementsFaceRectangle extends TeaModel {

        @NameInMap(AliyunVodKey.KEY_VOD_HEIGHT)
        public Integer height;

        @NameInMap("Left")
        public Integer left;

        @NameInMap("Top")
        public Integer top;

        @NameInMap("Width")
        public Integer width;

        public static RecognizeExpressionResponseBodyDataElementsFaceRectangle build(Map<String, ?> map) throws Exception {
            return (RecognizeExpressionResponseBodyDataElementsFaceRectangle) TeaModel.build(map, new RecognizeExpressionResponseBodyDataElementsFaceRectangle());
        }

        public Integer getHeight() {
            return this.height;
        }

        public Integer getLeft() {
            return this.left;
        }

        public Integer getTop() {
            return this.top;
        }

        public Integer getWidth() {
            return this.width;
        }

        public RecognizeExpressionResponseBodyDataElementsFaceRectangle setHeight(Integer num) {
            this.height = num;
            return this;
        }

        public RecognizeExpressionResponseBodyDataElementsFaceRectangle setLeft(Integer num) {
            this.left = num;
            return this;
        }

        public RecognizeExpressionResponseBodyDataElementsFaceRectangle setTop(Integer num) {
            this.top = num;
            return this;
        }

        public RecognizeExpressionResponseBodyDataElementsFaceRectangle setWidth(Integer num) {
            this.width = num;
            return this;
        }
    }

    public static RecognizeExpressionResponseBody build(Map<String, ?> map) throws Exception {
        return (RecognizeExpressionResponseBody) TeaModel.build(map, new RecognizeExpressionResponseBody());
    }

    public RecognizeExpressionResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public RecognizeExpressionResponseBody setData(RecognizeExpressionResponseBodyData recognizeExpressionResponseBodyData) {
        this.data = recognizeExpressionResponseBodyData;
        return this;
    }

    public RecognizeExpressionResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

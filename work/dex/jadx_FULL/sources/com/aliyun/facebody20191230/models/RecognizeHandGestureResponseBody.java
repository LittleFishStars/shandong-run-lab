package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RecognizeHandGestureResponseBody extends TeaModel {

    @NameInMap("Data")
    public RecognizeHandGestureResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class RecognizeHandGestureResponseBodyData extends TeaModel {

        @NameInMap(AliyunVodKey.KEY_VOD_HEIGHT)
        public Long height;

        @NameInMap("Score")
        public Float score;

        @NameInMap("Type")
        public String type;

        @NameInMap("Width")
        public Long width;

        @NameInMap("X")
        public Long x;

        @NameInMap("Y")
        public Long y;

        public static RecognizeHandGestureResponseBodyData build(Map<String, ?> map) throws Exception {
            return (RecognizeHandGestureResponseBodyData) TeaModel.build(map, new RecognizeHandGestureResponseBodyData());
        }

        public Long getHeight() {
            return this.height;
        }

        public Float getScore() {
            return this.score;
        }

        public String getType() {
            return this.type;
        }

        public Long getWidth() {
            return this.width;
        }

        public Long getX() {
            return this.x;
        }

        public Long getY() {
            return this.y;
        }

        public RecognizeHandGestureResponseBodyData setHeight(Long l) {
            this.height = l;
            return this;
        }

        public RecognizeHandGestureResponseBodyData setScore(Float f) {
            this.score = f;
            return this;
        }

        public RecognizeHandGestureResponseBodyData setType(String str) {
            this.type = str;
            return this;
        }

        public RecognizeHandGestureResponseBodyData setWidth(Long l) {
            this.width = l;
            return this;
        }

        public RecognizeHandGestureResponseBodyData setX(Long l) {
            this.x = l;
            return this;
        }

        public RecognizeHandGestureResponseBodyData setY(Long l) {
            this.y = l;
            return this;
        }
    }

    public static RecognizeHandGestureResponseBody build(Map<String, ?> map) throws Exception {
        return (RecognizeHandGestureResponseBody) TeaModel.build(map, new RecognizeHandGestureResponseBody());
    }

    public RecognizeHandGestureResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public RecognizeHandGestureResponseBody setData(RecognizeHandGestureResponseBodyData recognizeHandGestureResponseBodyData) {
        this.data = recognizeHandGestureResponseBodyData;
        return this;
    }

    public RecognizeHandGestureResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

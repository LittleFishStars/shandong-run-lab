package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectPedestrianResponseBody extends TeaModel {

    @NameInMap("Data")
    public DetectPedestrianResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class DetectPedestrianResponseBodyData extends TeaModel {

        @NameInMap("Elements")
        public List<DetectPedestrianResponseBodyDataElements> elements;

        @NameInMap(AliyunVodKey.KEY_VOD_HEIGHT)
        public Integer height;

        @NameInMap("Width")
        public Integer width;

        public static DetectPedestrianResponseBodyData build(Map<String, ?> map) throws Exception {
            return (DetectPedestrianResponseBodyData) TeaModel.build(map, new DetectPedestrianResponseBodyData());
        }

        public List<DetectPedestrianResponseBodyDataElements> getElements() {
            return this.elements;
        }

        public Integer getHeight() {
            return this.height;
        }

        public Integer getWidth() {
            return this.width;
        }

        public DetectPedestrianResponseBodyData setElements(List<DetectPedestrianResponseBodyDataElements> list) {
            this.elements = list;
            return this;
        }

        public DetectPedestrianResponseBodyData setHeight(Integer num) {
            this.height = num;
            return this;
        }

        public DetectPedestrianResponseBodyData setWidth(Integer num) {
            this.width = num;
            return this;
        }
    }

    public static class DetectPedestrianResponseBodyDataElements extends TeaModel {

        @NameInMap("Boxes")
        public List<Integer> boxes;

        @NameInMap("Score")
        public Float score;

        @NameInMap("Type")
        public String type;

        public static DetectPedestrianResponseBodyDataElements build(Map<String, ?> map) throws Exception {
            return (DetectPedestrianResponseBodyDataElements) TeaModel.build(map, new DetectPedestrianResponseBodyDataElements());
        }

        public List<Integer> getBoxes() {
            return this.boxes;
        }

        public Float getScore() {
            return this.score;
        }

        public String getType() {
            return this.type;
        }

        public DetectPedestrianResponseBodyDataElements setBoxes(List<Integer> list) {
            this.boxes = list;
            return this;
        }

        public DetectPedestrianResponseBodyDataElements setScore(Float f) {
            this.score = f;
            return this;
        }

        public DetectPedestrianResponseBodyDataElements setType(String str) {
            this.type = str;
            return this;
        }
    }

    public static DetectPedestrianResponseBody build(Map<String, ?> map) throws Exception {
        return (DetectPedestrianResponseBody) TeaModel.build(map, new DetectPedestrianResponseBody());
    }

    public DetectPedestrianResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public DetectPedestrianResponseBody setData(DetectPedestrianResponseBodyData detectPedestrianResponseBodyData) {
        this.data = detectPedestrianResponseBodyData;
        return this;
    }

    public DetectPedestrianResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

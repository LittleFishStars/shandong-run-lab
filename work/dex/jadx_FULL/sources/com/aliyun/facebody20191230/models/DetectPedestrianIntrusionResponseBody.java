package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectPedestrianIntrusionResponseBody extends TeaModel {

    @NameInMap("Data")
    public DetectPedestrianIntrusionResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class DetectPedestrianIntrusionResponseBodyData extends TeaModel {

        @NameInMap("Elements")
        public List<DetectPedestrianIntrusionResponseBodyDataElements> elements;

        @NameInMap("ImageHeight")
        public Long imageHeight;

        @NameInMap("ImageWidth")
        public Long imageWidth;

        public static DetectPedestrianIntrusionResponseBodyData build(Map<String, ?> map) throws Exception {
            return (DetectPedestrianIntrusionResponseBodyData) TeaModel.build(map, new DetectPedestrianIntrusionResponseBodyData());
        }

        public List<DetectPedestrianIntrusionResponseBodyDataElements> getElements() {
            return this.elements;
        }

        public Long getImageHeight() {
            return this.imageHeight;
        }

        public Long getImageWidth() {
            return this.imageWidth;
        }

        public DetectPedestrianIntrusionResponseBodyData setElements(List<DetectPedestrianIntrusionResponseBodyDataElements> list) {
            this.elements = list;
            return this;
        }

        public DetectPedestrianIntrusionResponseBodyData setImageHeight(Long l) {
            this.imageHeight = l;
            return this;
        }

        public DetectPedestrianIntrusionResponseBodyData setImageWidth(Long l) {
            this.imageWidth = l;
            return this;
        }
    }

    public static class DetectPedestrianIntrusionResponseBodyDataElements extends TeaModel {

        @NameInMap("Box")
        public DetectPedestrianIntrusionResponseBodyDataElementsBox box;

        @NameInMap("BoxId")
        public Long boxId;

        @NameInMap("IsIntrude")
        public Boolean isIntrude;

        @NameInMap("Score")
        public Long score;

        @NameInMap("Type")
        public String type;

        public static DetectPedestrianIntrusionResponseBodyDataElements build(Map<String, ?> map) throws Exception {
            return (DetectPedestrianIntrusionResponseBodyDataElements) TeaModel.build(map, new DetectPedestrianIntrusionResponseBodyDataElements());
        }

        public DetectPedestrianIntrusionResponseBodyDataElementsBox getBox() {
            return this.box;
        }

        public Long getBoxId() {
            return this.boxId;
        }

        public Boolean getIsIntrude() {
            return this.isIntrude;
        }

        public Long getScore() {
            return this.score;
        }

        public String getType() {
            return this.type;
        }

        public DetectPedestrianIntrusionResponseBodyDataElements setBox(DetectPedestrianIntrusionResponseBodyDataElementsBox detectPedestrianIntrusionResponseBodyDataElementsBox) {
            this.box = detectPedestrianIntrusionResponseBodyDataElementsBox;
            return this;
        }

        public DetectPedestrianIntrusionResponseBodyDataElements setBoxId(Long l) {
            this.boxId = l;
            return this;
        }

        public DetectPedestrianIntrusionResponseBodyDataElements setIsIntrude(Boolean bool) {
            this.isIntrude = bool;
            return this;
        }

        public DetectPedestrianIntrusionResponseBodyDataElements setScore(Long l) {
            this.score = l;
            return this;
        }

        public DetectPedestrianIntrusionResponseBodyDataElements setType(String str) {
            this.type = str;
            return this;
        }
    }

    public static class DetectPedestrianIntrusionResponseBodyDataElementsBox extends TeaModel {

        @NameInMap("Bottom")
        public Long bottom;

        @NameInMap("Left")
        public Long left;

        @NameInMap("Right")
        public Long right;

        @NameInMap("Top")
        public Long top;

        public static DetectPedestrianIntrusionResponseBodyDataElementsBox build(Map<String, ?> map) throws Exception {
            return (DetectPedestrianIntrusionResponseBodyDataElementsBox) TeaModel.build(map, new DetectPedestrianIntrusionResponseBodyDataElementsBox());
        }

        public Long getBottom() {
            return this.bottom;
        }

        public Long getLeft() {
            return this.left;
        }

        public Long getRight() {
            return this.right;
        }

        public Long getTop() {
            return this.top;
        }

        public DetectPedestrianIntrusionResponseBodyDataElementsBox setBottom(Long l) {
            this.bottom = l;
            return this;
        }

        public DetectPedestrianIntrusionResponseBodyDataElementsBox setLeft(Long l) {
            this.left = l;
            return this;
        }

        public DetectPedestrianIntrusionResponseBodyDataElementsBox setRight(Long l) {
            this.right = l;
            return this;
        }

        public DetectPedestrianIntrusionResponseBodyDataElementsBox setTop(Long l) {
            this.top = l;
            return this;
        }
    }

    public static DetectPedestrianIntrusionResponseBody build(Map<String, ?> map) throws Exception {
        return (DetectPedestrianIntrusionResponseBody) TeaModel.build(map, new DetectPedestrianIntrusionResponseBody());
    }

    public DetectPedestrianIntrusionResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public DetectPedestrianIntrusionResponseBody setData(DetectPedestrianIntrusionResponseBodyData detectPedestrianIntrusionResponseBodyData) {
        this.data = detectPedestrianIntrusionResponseBodyData;
        return this;
    }

    public DetectPedestrianIntrusionResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

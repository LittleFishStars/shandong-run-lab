package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectPedestrianIntrusionRequest extends TeaModel {

    @NameInMap("DetectRegion")
    public List<DetectPedestrianIntrusionRequestDetectRegion> detectRegion;

    @NameInMap("ImageURL")
    public String imageURL;

    @NameInMap("RegionType")
    public String regionType;

    public static class DetectPedestrianIntrusionRequestDetectRegion extends TeaModel {

        @NameInMap("Line")
        public DetectPedestrianIntrusionRequestDetectRegionLine line;

        @NameInMap("Rect")
        public DetectPedestrianIntrusionRequestDetectRegionRect rect;

        public static DetectPedestrianIntrusionRequestDetectRegion build(Map<String, ?> map) throws Exception {
            return (DetectPedestrianIntrusionRequestDetectRegion) TeaModel.build(map, new DetectPedestrianIntrusionRequestDetectRegion());
        }

        public DetectPedestrianIntrusionRequestDetectRegionLine getLine() {
            return this.line;
        }

        public DetectPedestrianIntrusionRequestDetectRegionRect getRect() {
            return this.rect;
        }

        public DetectPedestrianIntrusionRequestDetectRegion setLine(DetectPedestrianIntrusionRequestDetectRegionLine detectPedestrianIntrusionRequestDetectRegionLine) {
            this.line = detectPedestrianIntrusionRequestDetectRegionLine;
            return this;
        }

        public DetectPedestrianIntrusionRequestDetectRegion setRect(DetectPedestrianIntrusionRequestDetectRegionRect detectPedestrianIntrusionRequestDetectRegionRect) {
            this.rect = detectPedestrianIntrusionRequestDetectRegionRect;
            return this;
        }
    }

    public static class DetectPedestrianIntrusionRequestDetectRegionLine extends TeaModel {

        @NameInMap("X1")
        public Long x1;

        @NameInMap("X2")
        public Long x2;

        @NameInMap("Y1")
        public Long y1;

        @NameInMap("Y2")
        public Long y2;

        public static DetectPedestrianIntrusionRequestDetectRegionLine build(Map<String, ?> map) throws Exception {
            return (DetectPedestrianIntrusionRequestDetectRegionLine) TeaModel.build(map, new DetectPedestrianIntrusionRequestDetectRegionLine());
        }

        public Long getX1() {
            return this.x1;
        }

        public Long getX2() {
            return this.x2;
        }

        public Long getY1() {
            return this.y1;
        }

        public Long getY2() {
            return this.y2;
        }

        public DetectPedestrianIntrusionRequestDetectRegionLine setX1(Long l) {
            this.x1 = l;
            return this;
        }

        public DetectPedestrianIntrusionRequestDetectRegionLine setX2(Long l) {
            this.x2 = l;
            return this;
        }

        public DetectPedestrianIntrusionRequestDetectRegionLine setY1(Long l) {
            this.y1 = l;
            return this;
        }

        public DetectPedestrianIntrusionRequestDetectRegionLine setY2(Long l) {
            this.y2 = l;
            return this;
        }
    }

    public static class DetectPedestrianIntrusionRequestDetectRegionRect extends TeaModel {

        @NameInMap("Bottom")
        public Long bottom;

        @NameInMap("Left")
        public Long left;

        @NameInMap("Right")
        public Long right;

        @NameInMap("Top")
        public Long top;

        public static DetectPedestrianIntrusionRequestDetectRegionRect build(Map<String, ?> map) throws Exception {
            return (DetectPedestrianIntrusionRequestDetectRegionRect) TeaModel.build(map, new DetectPedestrianIntrusionRequestDetectRegionRect());
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

        public DetectPedestrianIntrusionRequestDetectRegionRect setBottom(Long l) {
            this.bottom = l;
            return this;
        }

        public DetectPedestrianIntrusionRequestDetectRegionRect setLeft(Long l) {
            this.left = l;
            return this;
        }

        public DetectPedestrianIntrusionRequestDetectRegionRect setRight(Long l) {
            this.right = l;
            return this;
        }

        public DetectPedestrianIntrusionRequestDetectRegionRect setTop(Long l) {
            this.top = l;
            return this;
        }
    }

    public static DetectPedestrianIntrusionRequest build(Map<String, ?> map) throws Exception {
        return (DetectPedestrianIntrusionRequest) TeaModel.build(map, new DetectPedestrianIntrusionRequest());
    }

    public List<DetectPedestrianIntrusionRequestDetectRegion> getDetectRegion() {
        return this.detectRegion;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public String getRegionType() {
        return this.regionType;
    }

    public DetectPedestrianIntrusionRequest setDetectRegion(List<DetectPedestrianIntrusionRequestDetectRegion> list) {
        this.detectRegion = list;
        return this;
    }

    public DetectPedestrianIntrusionRequest setImageURL(String str) {
        this.imageURL = str;
        return this;
    }

    public DetectPedestrianIntrusionRequest setRegionType(String str) {
        this.regionType = str;
        return this;
    }
}

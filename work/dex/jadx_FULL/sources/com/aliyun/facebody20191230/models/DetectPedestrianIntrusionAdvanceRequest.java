package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectPedestrianIntrusionAdvanceRequest extends TeaModel {

    @NameInMap("DetectRegion")
    public List<DetectPedestrianIntrusionAdvanceRequestDetectRegion> detectRegion;

    @NameInMap("ImageURL")
    public InputStream imageURLObject;

    @NameInMap("RegionType")
    public String regionType;

    public static class DetectPedestrianIntrusionAdvanceRequestDetectRegion extends TeaModel {

        @NameInMap("Line")
        public DetectPedestrianIntrusionAdvanceRequestDetectRegionLine line;

        @NameInMap("Rect")
        public DetectPedestrianIntrusionAdvanceRequestDetectRegionRect rect;

        public static DetectPedestrianIntrusionAdvanceRequestDetectRegion build(Map<String, ?> map) throws Exception {
            return (DetectPedestrianIntrusionAdvanceRequestDetectRegion) TeaModel.build(map, new DetectPedestrianIntrusionAdvanceRequestDetectRegion());
        }

        public DetectPedestrianIntrusionAdvanceRequestDetectRegionLine getLine() {
            return this.line;
        }

        public DetectPedestrianIntrusionAdvanceRequestDetectRegionRect getRect() {
            return this.rect;
        }

        public DetectPedestrianIntrusionAdvanceRequestDetectRegion setLine(DetectPedestrianIntrusionAdvanceRequestDetectRegionLine detectPedestrianIntrusionAdvanceRequestDetectRegionLine) {
            this.line = detectPedestrianIntrusionAdvanceRequestDetectRegionLine;
            return this;
        }

        public DetectPedestrianIntrusionAdvanceRequestDetectRegion setRect(DetectPedestrianIntrusionAdvanceRequestDetectRegionRect detectPedestrianIntrusionAdvanceRequestDetectRegionRect) {
            this.rect = detectPedestrianIntrusionAdvanceRequestDetectRegionRect;
            return this;
        }
    }

    public static class DetectPedestrianIntrusionAdvanceRequestDetectRegionLine extends TeaModel {

        @NameInMap("X1")
        public Long x1;

        @NameInMap("X2")
        public Long x2;

        @NameInMap("Y1")
        public Long y1;

        @NameInMap("Y2")
        public Long y2;

        public static DetectPedestrianIntrusionAdvanceRequestDetectRegionLine build(Map<String, ?> map) throws Exception {
            return (DetectPedestrianIntrusionAdvanceRequestDetectRegionLine) TeaModel.build(map, new DetectPedestrianIntrusionAdvanceRequestDetectRegionLine());
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

        public DetectPedestrianIntrusionAdvanceRequestDetectRegionLine setX1(Long l) {
            this.x1 = l;
            return this;
        }

        public DetectPedestrianIntrusionAdvanceRequestDetectRegionLine setX2(Long l) {
            this.x2 = l;
            return this;
        }

        public DetectPedestrianIntrusionAdvanceRequestDetectRegionLine setY1(Long l) {
            this.y1 = l;
            return this;
        }

        public DetectPedestrianIntrusionAdvanceRequestDetectRegionLine setY2(Long l) {
            this.y2 = l;
            return this;
        }
    }

    public static class DetectPedestrianIntrusionAdvanceRequestDetectRegionRect extends TeaModel {

        @NameInMap("Bottom")
        public Long bottom;

        @NameInMap("Left")
        public Long left;

        @NameInMap("Right")
        public Long right;

        @NameInMap("Top")
        public Long top;

        public static DetectPedestrianIntrusionAdvanceRequestDetectRegionRect build(Map<String, ?> map) throws Exception {
            return (DetectPedestrianIntrusionAdvanceRequestDetectRegionRect) TeaModel.build(map, new DetectPedestrianIntrusionAdvanceRequestDetectRegionRect());
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

        public DetectPedestrianIntrusionAdvanceRequestDetectRegionRect setBottom(Long l) {
            this.bottom = l;
            return this;
        }

        public DetectPedestrianIntrusionAdvanceRequestDetectRegionRect setLeft(Long l) {
            this.left = l;
            return this;
        }

        public DetectPedestrianIntrusionAdvanceRequestDetectRegionRect setRight(Long l) {
            this.right = l;
            return this;
        }

        public DetectPedestrianIntrusionAdvanceRequestDetectRegionRect setTop(Long l) {
            this.top = l;
            return this;
        }
    }

    public static DetectPedestrianIntrusionAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (DetectPedestrianIntrusionAdvanceRequest) TeaModel.build(map, new DetectPedestrianIntrusionAdvanceRequest());
    }

    public List<DetectPedestrianIntrusionAdvanceRequestDetectRegion> getDetectRegion() {
        return this.detectRegion;
    }

    public InputStream getImageURLObject() {
        return this.imageURLObject;
    }

    public String getRegionType() {
        return this.regionType;
    }

    public DetectPedestrianIntrusionAdvanceRequest setDetectRegion(List<DetectPedestrianIntrusionAdvanceRequestDetectRegion> list) {
        this.detectRegion = list;
        return this;
    }

    public DetectPedestrianIntrusionAdvanceRequest setImageURLObject(InputStream inputStream) {
        this.imageURLObject = inputStream;
        return this;
    }

    public DetectPedestrianIntrusionAdvanceRequest setRegionType(String str) {
        this.regionType = str;
        return this;
    }
}

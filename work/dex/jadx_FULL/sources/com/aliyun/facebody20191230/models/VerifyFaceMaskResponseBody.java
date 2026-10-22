package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class VerifyFaceMaskResponseBody extends TeaModel {

    @NameInMap("Data")
    public VerifyFaceMaskResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class VerifyFaceMaskResponseBodyData extends TeaModel {

        @NameInMap("Confidence")
        public Float confidence;

        @NameInMap("Mask")
        public Integer mask;

        @NameInMap("MaskRef")
        public Integer maskRef;

        @NameInMap("Rectangle")
        public List<Integer> rectangle;

        @NameInMap("RectangleRef")
        public List<Integer> rectangleRef;

        @NameInMap("Thresholds")
        public List<Float> thresholds;

        public static VerifyFaceMaskResponseBodyData build(Map<String, ?> map) throws Exception {
            return (VerifyFaceMaskResponseBodyData) TeaModel.build(map, new VerifyFaceMaskResponseBodyData());
        }

        public Float getConfidence() {
            return this.confidence;
        }

        public Integer getMask() {
            return this.mask;
        }

        public Integer getMaskRef() {
            return this.maskRef;
        }

        public List<Integer> getRectangle() {
            return this.rectangle;
        }

        public List<Integer> getRectangleRef() {
            return this.rectangleRef;
        }

        public List<Float> getThresholds() {
            return this.thresholds;
        }

        public VerifyFaceMaskResponseBodyData setConfidence(Float f) {
            this.confidence = f;
            return this;
        }

        public VerifyFaceMaskResponseBodyData setMask(Integer num) {
            this.mask = num;
            return this;
        }

        public VerifyFaceMaskResponseBodyData setMaskRef(Integer num) {
            this.maskRef = num;
            return this;
        }

        public VerifyFaceMaskResponseBodyData setRectangle(List<Integer> list) {
            this.rectangle = list;
            return this;
        }

        public VerifyFaceMaskResponseBodyData setRectangleRef(List<Integer> list) {
            this.rectangleRef = list;
            return this;
        }

        public VerifyFaceMaskResponseBodyData setThresholds(List<Float> list) {
            this.thresholds = list;
            return this;
        }
    }

    public static VerifyFaceMaskResponseBody build(Map<String, ?> map) throws Exception {
        return (VerifyFaceMaskResponseBody) TeaModel.build(map, new VerifyFaceMaskResponseBody());
    }

    public VerifyFaceMaskResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public VerifyFaceMaskResponseBody setData(VerifyFaceMaskResponseBodyData verifyFaceMaskResponseBodyData) {
        this.data = verifyFaceMaskResponseBodyData;
        return this;
    }

    public VerifyFaceMaskResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

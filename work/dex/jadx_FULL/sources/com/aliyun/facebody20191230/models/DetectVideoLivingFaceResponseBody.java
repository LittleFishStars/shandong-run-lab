package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectVideoLivingFaceResponseBody extends TeaModel {

    @NameInMap("Data")
    public DetectVideoLivingFaceResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class DetectVideoLivingFaceResponseBodyData extends TeaModel {

        @NameInMap("Elements")
        public List<DetectVideoLivingFaceResponseBodyDataElements> elements;

        public static DetectVideoLivingFaceResponseBodyData build(Map<String, ?> map) throws Exception {
            return (DetectVideoLivingFaceResponseBodyData) TeaModel.build(map, new DetectVideoLivingFaceResponseBodyData());
        }

        public List<DetectVideoLivingFaceResponseBodyDataElements> getElements() {
            return this.elements;
        }

        public DetectVideoLivingFaceResponseBodyData setElements(List<DetectVideoLivingFaceResponseBodyDataElements> list) {
            this.elements = list;
            return this;
        }
    }

    public static class DetectVideoLivingFaceResponseBodyDataElements extends TeaModel {

        @NameInMap("FaceConfidence")
        public Float faceConfidence;

        @NameInMap("LiveConfidence")
        public Float liveConfidence;

        @NameInMap("Rect")
        public List<Integer> rect;

        public static DetectVideoLivingFaceResponseBodyDataElements build(Map<String, ?> map) throws Exception {
            return (DetectVideoLivingFaceResponseBodyDataElements) TeaModel.build(map, new DetectVideoLivingFaceResponseBodyDataElements());
        }

        public Float getFaceConfidence() {
            return this.faceConfidence;
        }

        public Float getLiveConfidence() {
            return this.liveConfidence;
        }

        public List<Integer> getRect() {
            return this.rect;
        }

        public DetectVideoLivingFaceResponseBodyDataElements setFaceConfidence(Float f) {
            this.faceConfidence = f;
            return this;
        }

        public DetectVideoLivingFaceResponseBodyDataElements setLiveConfidence(Float f) {
            this.liveConfidence = f;
            return this;
        }

        public DetectVideoLivingFaceResponseBodyDataElements setRect(List<Integer> list) {
            this.rect = list;
            return this;
        }
    }

    public static DetectVideoLivingFaceResponseBody build(Map<String, ?> map) throws Exception {
        return (DetectVideoLivingFaceResponseBody) TeaModel.build(map, new DetectVideoLivingFaceResponseBody());
    }

    public DetectVideoLivingFaceResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public DetectVideoLivingFaceResponseBody setData(DetectVideoLivingFaceResponseBodyData detectVideoLivingFaceResponseBodyData) {
        this.data = detectVideoLivingFaceResponseBodyData;
        return this;
    }

    public DetectVideoLivingFaceResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

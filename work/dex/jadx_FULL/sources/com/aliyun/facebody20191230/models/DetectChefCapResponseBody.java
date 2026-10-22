package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DetectChefCapResponseBody extends TeaModel {

    @NameInMap("Data")
    public DetectChefCapResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class DetectChefCapResponseBodyData extends TeaModel {

        @NameInMap("Elements")
        public List<DetectChefCapResponseBodyDataElements> elements;

        public static DetectChefCapResponseBodyData build(Map<String, ?> map) throws Exception {
            return (DetectChefCapResponseBodyData) TeaModel.build(map, new DetectChefCapResponseBodyData());
        }

        public List<DetectChefCapResponseBodyDataElements> getElements() {
            return this.elements;
        }

        public DetectChefCapResponseBodyData setElements(List<DetectChefCapResponseBodyDataElements> list) {
            this.elements = list;
            return this;
        }
    }

    public static class DetectChefCapResponseBodyDataElements extends TeaModel {

        @NameInMap("Box")
        public List<Float> box;

        @NameInMap("Category")
        public String category;

        @NameInMap("Confidence")
        public Float confidence;

        public static DetectChefCapResponseBodyDataElements build(Map<String, ?> map) throws Exception {
            return (DetectChefCapResponseBodyDataElements) TeaModel.build(map, new DetectChefCapResponseBodyDataElements());
        }

        public List<Float> getBox() {
            return this.box;
        }

        public String getCategory() {
            return this.category;
        }

        public Float getConfidence() {
            return this.confidence;
        }

        public DetectChefCapResponseBodyDataElements setBox(List<Float> list) {
            this.box = list;
            return this;
        }

        public DetectChefCapResponseBodyDataElements setCategory(String str) {
            this.category = str;
            return this;
        }

        public DetectChefCapResponseBodyDataElements setConfidence(Float f) {
            this.confidence = f;
            return this;
        }
    }

    public static DetectChefCapResponseBody build(Map<String, ?> map) throws Exception {
        return (DetectChefCapResponseBody) TeaModel.build(map, new DetectChefCapResponseBody());
    }

    public DetectChefCapResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public DetectChefCapResponseBody setData(DetectChefCapResponseBodyData detectChefCapResponseBodyData) {
        this.data = detectChefCapResponseBodyData;
        return this;
    }

    public DetectChefCapResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

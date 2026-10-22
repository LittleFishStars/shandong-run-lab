package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AddFaceResponseBody extends TeaModel {

    @NameInMap("Data")
    public AddFaceResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class AddFaceResponseBodyData extends TeaModel {

        @NameInMap("FaceId")
        public String faceId;

        @NameInMap("QualitieScore")
        public Float qualitieScore;

        public static AddFaceResponseBodyData build(Map<String, ?> map) throws Exception {
            return (AddFaceResponseBodyData) TeaModel.build(map, new AddFaceResponseBodyData());
        }

        public String getFaceId() {
            return this.faceId;
        }

        public Float getQualitieScore() {
            return this.qualitieScore;
        }

        public AddFaceResponseBodyData setFaceId(String str) {
            this.faceId = str;
            return this;
        }

        public AddFaceResponseBodyData setQualitieScore(Float f) {
            this.qualitieScore = f;
            return this;
        }
    }

    public static AddFaceResponseBody build(Map<String, ?> map) throws Exception {
        return (AddFaceResponseBody) TeaModel.build(map, new AddFaceResponseBody());
    }

    public AddFaceResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public AddFaceResponseBody setData(AddFaceResponseBodyData addFaceResponseBodyData) {
        this.data = addFaceResponseBodyData;
        return this;
    }

    public AddFaceResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

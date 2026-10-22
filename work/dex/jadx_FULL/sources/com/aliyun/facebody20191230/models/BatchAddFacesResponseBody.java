package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BatchAddFacesResponseBody extends TeaModel {

    @NameInMap("Data")
    public BatchAddFacesResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class BatchAddFacesResponseBodyData extends TeaModel {

        @NameInMap("FailedFaces")
        public List<BatchAddFacesResponseBodyDataFailedFaces> failedFaces;

        @NameInMap("InsertedFaces")
        public List<BatchAddFacesResponseBodyDataInsertedFaces> insertedFaces;

        public static BatchAddFacesResponseBodyData build(Map<String, ?> map) throws Exception {
            return (BatchAddFacesResponseBodyData) TeaModel.build(map, new BatchAddFacesResponseBodyData());
        }

        public List<BatchAddFacesResponseBodyDataFailedFaces> getFailedFaces() {
            return this.failedFaces;
        }

        public List<BatchAddFacesResponseBodyDataInsertedFaces> getInsertedFaces() {
            return this.insertedFaces;
        }

        public BatchAddFacesResponseBodyData setFailedFaces(List<BatchAddFacesResponseBodyDataFailedFaces> list) {
            this.failedFaces = list;
            return this;
        }

        public BatchAddFacesResponseBodyData setInsertedFaces(List<BatchAddFacesResponseBodyDataInsertedFaces> list) {
            this.insertedFaces = list;
            return this;
        }
    }

    public static class BatchAddFacesResponseBodyDataFailedFaces extends TeaModel {

        @NameInMap("Code")
        public String code;

        @NameInMap("ImageURL")
        public String imageURL;

        @NameInMap("Message")
        public String message;

        public static BatchAddFacesResponseBodyDataFailedFaces build(Map<String, ?> map) throws Exception {
            return (BatchAddFacesResponseBodyDataFailedFaces) TeaModel.build(map, new BatchAddFacesResponseBodyDataFailedFaces());
        }

        public String getCode() {
            return this.code;
        }

        public String getImageURL() {
            return this.imageURL;
        }

        public String getMessage() {
            return this.message;
        }

        public BatchAddFacesResponseBodyDataFailedFaces setCode(String str) {
            this.code = str;
            return this;
        }

        public BatchAddFacesResponseBodyDataFailedFaces setImageURL(String str) {
            this.imageURL = str;
            return this;
        }

        public BatchAddFacesResponseBodyDataFailedFaces setMessage(String str) {
            this.message = str;
            return this;
        }
    }

    public static class BatchAddFacesResponseBodyDataInsertedFaces extends TeaModel {

        @NameInMap("FaceId")
        public String faceId;

        @NameInMap("ImageURL")
        public String imageURL;

        @NameInMap("QualitieScore")
        public Float qualitieScore;

        public static BatchAddFacesResponseBodyDataInsertedFaces build(Map<String, ?> map) throws Exception {
            return (BatchAddFacesResponseBodyDataInsertedFaces) TeaModel.build(map, new BatchAddFacesResponseBodyDataInsertedFaces());
        }

        public String getFaceId() {
            return this.faceId;
        }

        public String getImageURL() {
            return this.imageURL;
        }

        public Float getQualitieScore() {
            return this.qualitieScore;
        }

        public BatchAddFacesResponseBodyDataInsertedFaces setFaceId(String str) {
            this.faceId = str;
            return this;
        }

        public BatchAddFacesResponseBodyDataInsertedFaces setImageURL(String str) {
            this.imageURL = str;
            return this;
        }

        public BatchAddFacesResponseBodyDataInsertedFaces setQualitieScore(Float f) {
            this.qualitieScore = f;
            return this;
        }
    }

    public static BatchAddFacesResponseBody build(Map<String, ?> map) throws Exception {
        return (BatchAddFacesResponseBody) TeaModel.build(map, new BatchAddFacesResponseBody());
    }

    public BatchAddFacesResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public BatchAddFacesResponseBody setData(BatchAddFacesResponseBodyData batchAddFacesResponseBodyData) {
        this.data = batchAddFacesResponseBodyData;
        return this;
    }

    public BatchAddFacesResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

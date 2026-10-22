package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BatchAddFacesAdvanceRequest extends TeaModel {

    @NameInMap("DbName")
    public String dbName;

    @NameInMap("EntityId")
    public String entityId;

    @NameInMap("Faces")
    public List<BatchAddFacesAdvanceRequestFaces> faces;

    @NameInMap("QualityScoreThreshold")
    public Float qualityScoreThreshold;

    @NameInMap("SimilarityScoreThresholdBetweenEntity")
    public Float similarityScoreThresholdBetweenEntity;

    @NameInMap("SimilarityScoreThresholdInEntity")
    public Float similarityScoreThresholdInEntity;

    public static class BatchAddFacesAdvanceRequestFaces extends TeaModel {

        @NameInMap("ExtraData")
        public String extraData;

        @NameInMap("ImageURL")
        public InputStream imageURLObject;

        public static BatchAddFacesAdvanceRequestFaces build(Map<String, ?> map) throws Exception {
            return (BatchAddFacesAdvanceRequestFaces) TeaModel.build(map, new BatchAddFacesAdvanceRequestFaces());
        }

        public String getExtraData() {
            return this.extraData;
        }

        public InputStream getImageURLObject() {
            return this.imageURLObject;
        }

        public BatchAddFacesAdvanceRequestFaces setExtraData(String str) {
            this.extraData = str;
            return this;
        }

        public BatchAddFacesAdvanceRequestFaces setImageURLObject(InputStream inputStream) {
            this.imageURLObject = inputStream;
            return this;
        }
    }

    public static BatchAddFacesAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (BatchAddFacesAdvanceRequest) TeaModel.build(map, new BatchAddFacesAdvanceRequest());
    }

    public String getDbName() {
        return this.dbName;
    }

    public String getEntityId() {
        return this.entityId;
    }

    public List<BatchAddFacesAdvanceRequestFaces> getFaces() {
        return this.faces;
    }

    public Float getQualityScoreThreshold() {
        return this.qualityScoreThreshold;
    }

    public Float getSimilarityScoreThresholdBetweenEntity() {
        return this.similarityScoreThresholdBetweenEntity;
    }

    public Float getSimilarityScoreThresholdInEntity() {
        return this.similarityScoreThresholdInEntity;
    }

    public BatchAddFacesAdvanceRequest setDbName(String str) {
        this.dbName = str;
        return this;
    }

    public BatchAddFacesAdvanceRequest setEntityId(String str) {
        this.entityId = str;
        return this;
    }

    public BatchAddFacesAdvanceRequest setFaces(List<BatchAddFacesAdvanceRequestFaces> list) {
        this.faces = list;
        return this;
    }

    public BatchAddFacesAdvanceRequest setQualityScoreThreshold(Float f) {
        this.qualityScoreThreshold = f;
        return this;
    }

    public BatchAddFacesAdvanceRequest setSimilarityScoreThresholdBetweenEntity(Float f) {
        this.similarityScoreThresholdBetweenEntity = f;
        return this;
    }

    public BatchAddFacesAdvanceRequest setSimilarityScoreThresholdInEntity(Float f) {
        this.similarityScoreThresholdInEntity = f;
        return this;
    }
}

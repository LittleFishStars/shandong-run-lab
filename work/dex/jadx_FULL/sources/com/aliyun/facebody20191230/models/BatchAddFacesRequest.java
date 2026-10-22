package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BatchAddFacesRequest extends TeaModel {

    @NameInMap("DbName")
    public String dbName;

    @NameInMap("EntityId")
    public String entityId;

    @NameInMap("Faces")
    public List<BatchAddFacesRequestFaces> faces;

    @NameInMap("QualityScoreThreshold")
    public Float qualityScoreThreshold;

    @NameInMap("SimilarityScoreThresholdBetweenEntity")
    public Float similarityScoreThresholdBetweenEntity;

    @NameInMap("SimilarityScoreThresholdInEntity")
    public Float similarityScoreThresholdInEntity;

    public static class BatchAddFacesRequestFaces extends TeaModel {

        @NameInMap("ExtraData")
        public String extraData;

        @NameInMap("ImageURL")
        public String imageURL;

        public static BatchAddFacesRequestFaces build(Map<String, ?> map) throws Exception {
            return (BatchAddFacesRequestFaces) TeaModel.build(map, new BatchAddFacesRequestFaces());
        }

        public String getExtraData() {
            return this.extraData;
        }

        public String getImageURL() {
            return this.imageURL;
        }

        public BatchAddFacesRequestFaces setExtraData(String str) {
            this.extraData = str;
            return this;
        }

        public BatchAddFacesRequestFaces setImageURL(String str) {
            this.imageURL = str;
            return this;
        }
    }

    public static BatchAddFacesRequest build(Map<String, ?> map) throws Exception {
        return (BatchAddFacesRequest) TeaModel.build(map, new BatchAddFacesRequest());
    }

    public String getDbName() {
        return this.dbName;
    }

    public String getEntityId() {
        return this.entityId;
    }

    public List<BatchAddFacesRequestFaces> getFaces() {
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

    public BatchAddFacesRequest setDbName(String str) {
        this.dbName = str;
        return this;
    }

    public BatchAddFacesRequest setEntityId(String str) {
        this.entityId = str;
        return this;
    }

    public BatchAddFacesRequest setFaces(List<BatchAddFacesRequestFaces> list) {
        this.faces = list;
        return this;
    }

    public BatchAddFacesRequest setQualityScoreThreshold(Float f) {
        this.qualityScoreThreshold = f;
        return this;
    }

    public BatchAddFacesRequest setSimilarityScoreThresholdBetweenEntity(Float f) {
        this.similarityScoreThresholdBetweenEntity = f;
        return this;
    }

    public BatchAddFacesRequest setSimilarityScoreThresholdInEntity(Float f) {
        this.similarityScoreThresholdInEntity = f;
        return this;
    }
}

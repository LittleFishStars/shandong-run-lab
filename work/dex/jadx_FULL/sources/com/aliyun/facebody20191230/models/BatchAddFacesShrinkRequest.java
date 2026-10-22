package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BatchAddFacesShrinkRequest extends TeaModel {

    @NameInMap("DbName")
    public String dbName;

    @NameInMap("EntityId")
    public String entityId;

    @NameInMap("Faces")
    public String facesShrink;

    @NameInMap("QualityScoreThreshold")
    public Float qualityScoreThreshold;

    @NameInMap("SimilarityScoreThresholdBetweenEntity")
    public Float similarityScoreThresholdBetweenEntity;

    @NameInMap("SimilarityScoreThresholdInEntity")
    public Float similarityScoreThresholdInEntity;

    public static BatchAddFacesShrinkRequest build(Map<String, ?> map) throws Exception {
        return (BatchAddFacesShrinkRequest) TeaModel.build(map, new BatchAddFacesShrinkRequest());
    }

    public String getDbName() {
        return this.dbName;
    }

    public String getEntityId() {
        return this.entityId;
    }

    public String getFacesShrink() {
        return this.facesShrink;
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

    public BatchAddFacesShrinkRequest setDbName(String str) {
        this.dbName = str;
        return this;
    }

    public BatchAddFacesShrinkRequest setEntityId(String str) {
        this.entityId = str;
        return this;
    }

    public BatchAddFacesShrinkRequest setFacesShrink(String str) {
        this.facesShrink = str;
        return this;
    }

    public BatchAddFacesShrinkRequest setQualityScoreThreshold(Float f) {
        this.qualityScoreThreshold = f;
        return this;
    }

    public BatchAddFacesShrinkRequest setSimilarityScoreThresholdBetweenEntity(Float f) {
        this.similarityScoreThresholdBetweenEntity = f;
        return this;
    }

    public BatchAddFacesShrinkRequest setSimilarityScoreThresholdInEntity(Float f) {
        this.similarityScoreThresholdInEntity = f;
        return this;
    }
}

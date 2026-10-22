package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AddFaceRequest extends TeaModel {

    @NameInMap("DbName")
    public String dbName;

    @NameInMap("EntityId")
    public String entityId;

    @NameInMap("ExtraData")
    public String extraData;

    @NameInMap("ImageUrl")
    public String imageUrl;

    @NameInMap("QualityScoreThreshold")
    public Float qualityScoreThreshold;

    @NameInMap("SimilarityScoreThresholdBetweenEntity")
    public Float similarityScoreThresholdBetweenEntity;

    @NameInMap("SimilarityScoreThresholdInEntity")
    public Float similarityScoreThresholdInEntity;

    public static AddFaceRequest build(Map<String, ?> map) throws Exception {
        return (AddFaceRequest) TeaModel.build(map, new AddFaceRequest());
    }

    public String getDbName() {
        return this.dbName;
    }

    public String getEntityId() {
        return this.entityId;
    }

    public String getExtraData() {
        return this.extraData;
    }

    public String getImageUrl() {
        return this.imageUrl;
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

    public AddFaceRequest setDbName(String str) {
        this.dbName = str;
        return this;
    }

    public AddFaceRequest setEntityId(String str) {
        this.entityId = str;
        return this;
    }

    public AddFaceRequest setExtraData(String str) {
        this.extraData = str;
        return this;
    }

    public AddFaceRequest setImageUrl(String str) {
        this.imageUrl = str;
        return this;
    }

    public AddFaceRequest setQualityScoreThreshold(Float f) {
        this.qualityScoreThreshold = f;
        return this;
    }

    public AddFaceRequest setSimilarityScoreThresholdBetweenEntity(Float f) {
        this.similarityScoreThresholdBetweenEntity = f;
        return this;
    }

    public AddFaceRequest setSimilarityScoreThresholdInEntity(Float f) {
        this.similarityScoreThresholdInEntity = f;
        return this;
    }
}

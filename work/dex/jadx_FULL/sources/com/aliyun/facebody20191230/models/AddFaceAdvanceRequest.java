package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AddFaceAdvanceRequest extends TeaModel {

    @NameInMap("DbName")
    public String dbName;

    @NameInMap("EntityId")
    public String entityId;

    @NameInMap("ExtraData")
    public String extraData;

    @NameInMap("ImageUrl")
    public InputStream imageUrlObject;

    @NameInMap("QualityScoreThreshold")
    public Float qualityScoreThreshold;

    @NameInMap("SimilarityScoreThresholdBetweenEntity")
    public Float similarityScoreThresholdBetweenEntity;

    @NameInMap("SimilarityScoreThresholdInEntity")
    public Float similarityScoreThresholdInEntity;

    public static AddFaceAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (AddFaceAdvanceRequest) TeaModel.build(map, new AddFaceAdvanceRequest());
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

    public InputStream getImageUrlObject() {
        return this.imageUrlObject;
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

    public AddFaceAdvanceRequest setDbName(String str) {
        this.dbName = str;
        return this;
    }

    public AddFaceAdvanceRequest setEntityId(String str) {
        this.entityId = str;
        return this;
    }

    public AddFaceAdvanceRequest setExtraData(String str) {
        this.extraData = str;
        return this;
    }

    public AddFaceAdvanceRequest setImageUrlObject(InputStream inputStream) {
        this.imageUrlObject = inputStream;
        return this;
    }

    public AddFaceAdvanceRequest setQualityScoreThreshold(Float f) {
        this.qualityScoreThreshold = f;
        return this;
    }

    public AddFaceAdvanceRequest setSimilarityScoreThresholdBetweenEntity(Float f) {
        this.similarityScoreThresholdBetweenEntity = f;
        return this;
    }

    public AddFaceAdvanceRequest setSimilarityScoreThresholdInEntity(Float f) {
        this.similarityScoreThresholdInEntity = f;
        return this;
    }
}

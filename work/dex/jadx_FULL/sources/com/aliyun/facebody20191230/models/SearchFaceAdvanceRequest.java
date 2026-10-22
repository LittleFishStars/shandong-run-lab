package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SearchFaceAdvanceRequest extends TeaModel {

    @NameInMap("DbName")
    public String dbName;

    @NameInMap("DbNames")
    public String dbNames;

    @NameInMap("ImageUrl")
    public InputStream imageUrlObject;

    @NameInMap("Limit")
    public Integer limit;

    @NameInMap("MaxFaceNum")
    public Long maxFaceNum;

    @NameInMap("QualityScoreThreshold")
    public Float qualityScoreThreshold;

    public static SearchFaceAdvanceRequest build(Map<String, ?> map) throws Exception {
        return (SearchFaceAdvanceRequest) TeaModel.build(map, new SearchFaceAdvanceRequest());
    }

    public String getDbName() {
        return this.dbName;
    }

    public String getDbNames() {
        return this.dbNames;
    }

    public InputStream getImageUrlObject() {
        return this.imageUrlObject;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public Long getMaxFaceNum() {
        return this.maxFaceNum;
    }

    public Float getQualityScoreThreshold() {
        return this.qualityScoreThreshold;
    }

    public SearchFaceAdvanceRequest setDbName(String str) {
        this.dbName = str;
        return this;
    }

    public SearchFaceAdvanceRequest setDbNames(String str) {
        this.dbNames = str;
        return this;
    }

    public SearchFaceAdvanceRequest setImageUrlObject(InputStream inputStream) {
        this.imageUrlObject = inputStream;
        return this;
    }

    public SearchFaceAdvanceRequest setLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public SearchFaceAdvanceRequest setMaxFaceNum(Long l) {
        this.maxFaceNum = l;
        return this;
    }

    public SearchFaceAdvanceRequest setQualityScoreThreshold(Float f) {
        this.qualityScoreThreshold = f;
        return this;
    }
}

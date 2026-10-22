package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SearchFaceRequest extends TeaModel {

    @NameInMap("DbName")
    public String dbName;

    @NameInMap("DbNames")
    public String dbNames;

    @NameInMap("ImageUrl")
    public String imageUrl;

    @NameInMap("Limit")
    public Integer limit;

    @NameInMap("MaxFaceNum")
    public Long maxFaceNum;

    @NameInMap("QualityScoreThreshold")
    public Float qualityScoreThreshold;

    public static SearchFaceRequest build(Map<String, ?> map) throws Exception {
        return (SearchFaceRequest) TeaModel.build(map, new SearchFaceRequest());
    }

    public String getDbName() {
        return this.dbName;
    }

    public String getDbNames() {
        return this.dbNames;
    }

    public String getImageUrl() {
        return this.imageUrl;
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

    public SearchFaceRequest setDbName(String str) {
        this.dbName = str;
        return this;
    }

    public SearchFaceRequest setDbNames(String str) {
        this.dbNames = str;
        return this;
    }

    public SearchFaceRequest setImageUrl(String str) {
        this.imageUrl = str;
        return this;
    }

    public SearchFaceRequest setLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public SearchFaceRequest setMaxFaceNum(Long l) {
        this.maxFaceNum = l;
        return this;
    }

    public SearchFaceRequest setQualityScoreThreshold(Float f) {
        this.qualityScoreThreshold = f;
        return this;
    }
}

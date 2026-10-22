package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ListFaceEntitiesRequest extends TeaModel {

    @NameInMap("DbName")
    public String dbName;

    @NameInMap("EntityIdPrefix")
    public String entityIdPrefix;

    @NameInMap("Labels")
    public String labels;

    @NameInMap("Limit")
    public Integer limit;

    @NameInMap("Offset")
    public Integer offset;

    @NameInMap("Order")
    public String order;

    @NameInMap("Token")
    public String token;

    public static ListFaceEntitiesRequest build(Map<String, ?> map) throws Exception {
        return (ListFaceEntitiesRequest) TeaModel.build(map, new ListFaceEntitiesRequest());
    }

    public String getDbName() {
        return this.dbName;
    }

    public String getEntityIdPrefix() {
        return this.entityIdPrefix;
    }

    public String getLabels() {
        return this.labels;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public Integer getOffset() {
        return this.offset;
    }

    public String getOrder() {
        return this.order;
    }

    public String getToken() {
        return this.token;
    }

    public ListFaceEntitiesRequest setDbName(String str) {
        this.dbName = str;
        return this;
    }

    public ListFaceEntitiesRequest setEntityIdPrefix(String str) {
        this.entityIdPrefix = str;
        return this;
    }

    public ListFaceEntitiesRequest setLabels(String str) {
        this.labels = str;
        return this;
    }

    public ListFaceEntitiesRequest setLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public ListFaceEntitiesRequest setOffset(Integer num) {
        this.offset = num;
        return this;
    }

    public ListFaceEntitiesRequest setOrder(String str) {
        this.order = str;
        return this;
    }

    public ListFaceEntitiesRequest setToken(String str) {
        this.token = str;
        return this;
    }
}

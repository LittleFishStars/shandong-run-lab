package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AddFaceEntityRequest extends TeaModel {

    @NameInMap("DbName")
    public String dbName;

    @NameInMap("EntityId")
    public String entityId;

    @NameInMap("Labels")
    public String labels;

    public static AddFaceEntityRequest build(Map<String, ?> map) throws Exception {
        return (AddFaceEntityRequest) TeaModel.build(map, new AddFaceEntityRequest());
    }

    public String getDbName() {
        return this.dbName;
    }

    public String getEntityId() {
        return this.entityId;
    }

    public String getLabels() {
        return this.labels;
    }

    public AddFaceEntityRequest setDbName(String str) {
        this.dbName = str;
        return this;
    }

    public AddFaceEntityRequest setEntityId(String str) {
        this.entityId = str;
        return this;
    }

    public AddFaceEntityRequest setLabels(String str) {
        this.labels = str;
        return this;
    }
}

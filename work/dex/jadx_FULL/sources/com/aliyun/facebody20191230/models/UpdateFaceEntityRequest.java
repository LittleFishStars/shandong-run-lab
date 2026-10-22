package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class UpdateFaceEntityRequest extends TeaModel {

    @NameInMap("DbName")
    public String dbName;

    @NameInMap("EntityId")
    public String entityId;

    @NameInMap("Labels")
    public String labels;

    public static UpdateFaceEntityRequest build(Map<String, ?> map) throws Exception {
        return (UpdateFaceEntityRequest) TeaModel.build(map, new UpdateFaceEntityRequest());
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

    public UpdateFaceEntityRequest setDbName(String str) {
        this.dbName = str;
        return this;
    }

    public UpdateFaceEntityRequest setEntityId(String str) {
        this.entityId = str;
        return this;
    }

    public UpdateFaceEntityRequest setLabels(String str) {
        this.labels = str;
        return this;
    }
}

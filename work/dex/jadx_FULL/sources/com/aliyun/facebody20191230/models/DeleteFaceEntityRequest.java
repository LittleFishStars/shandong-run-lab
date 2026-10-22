package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DeleteFaceEntityRequest extends TeaModel {

    @NameInMap("DbName")
    public String dbName;

    @NameInMap("EntityId")
    public String entityId;

    public static DeleteFaceEntityRequest build(Map<String, ?> map) throws Exception {
        return (DeleteFaceEntityRequest) TeaModel.build(map, new DeleteFaceEntityRequest());
    }

    public String getDbName() {
        return this.dbName;
    }

    public String getEntityId() {
        return this.entityId;
    }

    public DeleteFaceEntityRequest setDbName(String str) {
        this.dbName = str;
        return this;
    }

    public DeleteFaceEntityRequest setEntityId(String str) {
        this.entityId = str;
        return this;
    }
}

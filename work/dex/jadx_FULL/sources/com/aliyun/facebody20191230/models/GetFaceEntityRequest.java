package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetFaceEntityRequest extends TeaModel {

    @NameInMap("DbName")
    public String dbName;

    @NameInMap("EntityId")
    public String entityId;

    public static GetFaceEntityRequest build(Map<String, ?> map) throws Exception {
        return (GetFaceEntityRequest) TeaModel.build(map, new GetFaceEntityRequest());
    }

    public String getDbName() {
        return this.dbName;
    }

    public String getEntityId() {
        return this.entityId;
    }

    public GetFaceEntityRequest setDbName(String str) {
        this.dbName = str;
        return this;
    }

    public GetFaceEntityRequest setEntityId(String str) {
        this.entityId = str;
        return this;
    }
}

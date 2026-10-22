package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DeleteFaceRequest extends TeaModel {

    @NameInMap("DbName")
    public String dbName;

    @NameInMap("FaceId")
    public String faceId;

    public static DeleteFaceRequest build(Map<String, ?> map) throws Exception {
        return (DeleteFaceRequest) TeaModel.build(map, new DeleteFaceRequest());
    }

    public String getDbName() {
        return this.dbName;
    }

    public String getFaceId() {
        return this.faceId;
    }

    public DeleteFaceRequest setDbName(String str) {
        this.dbName = str;
        return this;
    }

    public DeleteFaceRequest setFaceId(String str) {
        this.faceId = str;
        return this;
    }
}

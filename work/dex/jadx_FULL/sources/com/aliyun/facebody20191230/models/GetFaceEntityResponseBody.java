package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetFaceEntityResponseBody extends TeaModel {

    @NameInMap("Data")
    public GetFaceEntityResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class GetFaceEntityResponseBodyData extends TeaModel {

        @NameInMap("DbName")
        public String dbName;

        @NameInMap("EntityId")
        public String entityId;

        @NameInMap("Faces")
        public List<GetFaceEntityResponseBodyDataFaces> faces;

        @NameInMap("Labels")
        public String labels;

        public static GetFaceEntityResponseBodyData build(Map<String, ?> map) throws Exception {
            return (GetFaceEntityResponseBodyData) TeaModel.build(map, new GetFaceEntityResponseBodyData());
        }

        public String getDbName() {
            return this.dbName;
        }

        public String getEntityId() {
            return this.entityId;
        }

        public List<GetFaceEntityResponseBodyDataFaces> getFaces() {
            return this.faces;
        }

        public String getLabels() {
            return this.labels;
        }

        public GetFaceEntityResponseBodyData setDbName(String str) {
            this.dbName = str;
            return this;
        }

        public GetFaceEntityResponseBodyData setEntityId(String str) {
            this.entityId = str;
            return this;
        }

        public GetFaceEntityResponseBodyData setFaces(List<GetFaceEntityResponseBodyDataFaces> list) {
            this.faces = list;
            return this;
        }

        public GetFaceEntityResponseBodyData setLabels(String str) {
            this.labels = str;
            return this;
        }
    }

    public static class GetFaceEntityResponseBodyDataFaces extends TeaModel {

        @NameInMap("FaceId")
        public String faceId;

        public static GetFaceEntityResponseBodyDataFaces build(Map<String, ?> map) throws Exception {
            return (GetFaceEntityResponseBodyDataFaces) TeaModel.build(map, new GetFaceEntityResponseBodyDataFaces());
        }

        public String getFaceId() {
            return this.faceId;
        }

        public GetFaceEntityResponseBodyDataFaces setFaceId(String str) {
            this.faceId = str;
            return this;
        }
    }

    public static GetFaceEntityResponseBody build(Map<String, ?> map) throws Exception {
        return (GetFaceEntityResponseBody) TeaModel.build(map, new GetFaceEntityResponseBody());
    }

    public GetFaceEntityResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public GetFaceEntityResponseBody setData(GetFaceEntityResponseBodyData getFaceEntityResponseBodyData) {
        this.data = getFaceEntityResponseBodyData;
        return this;
    }

    public GetFaceEntityResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

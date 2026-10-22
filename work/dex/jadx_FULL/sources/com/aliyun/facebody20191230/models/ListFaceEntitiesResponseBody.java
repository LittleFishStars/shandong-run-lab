package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ListFaceEntitiesResponseBody extends TeaModel {

    @NameInMap("Data")
    public ListFaceEntitiesResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class ListFaceEntitiesResponseBodyData extends TeaModel {

        @NameInMap("Entities")
        public List<ListFaceEntitiesResponseBodyDataEntities> entities;

        @NameInMap("Token")
        public String token;

        @NameInMap("TotalCount")
        public Integer totalCount;

        public static ListFaceEntitiesResponseBodyData build(Map<String, ?> map) throws Exception {
            return (ListFaceEntitiesResponseBodyData) TeaModel.build(map, new ListFaceEntitiesResponseBodyData());
        }

        public List<ListFaceEntitiesResponseBodyDataEntities> getEntities() {
            return this.entities;
        }

        public String getToken() {
            return this.token;
        }

        public Integer getTotalCount() {
            return this.totalCount;
        }

        public ListFaceEntitiesResponseBodyData setEntities(List<ListFaceEntitiesResponseBodyDataEntities> list) {
            this.entities = list;
            return this;
        }

        public ListFaceEntitiesResponseBodyData setToken(String str) {
            this.token = str;
            return this;
        }

        public ListFaceEntitiesResponseBodyData setTotalCount(Integer num) {
            this.totalCount = num;
            return this;
        }
    }

    public static class ListFaceEntitiesResponseBodyDataEntities extends TeaModel {

        @NameInMap("CreatedAt")
        public Long createdAt;

        @NameInMap("DbName")
        public String dbName;

        @NameInMap("EntityId")
        public String entityId;

        @NameInMap("FaceCount")
        public Integer faceCount;

        @NameInMap("Labels")
        public String labels;

        @NameInMap("UpdatedAt")
        public Long updatedAt;

        public static ListFaceEntitiesResponseBodyDataEntities build(Map<String, ?> map) throws Exception {
            return (ListFaceEntitiesResponseBodyDataEntities) TeaModel.build(map, new ListFaceEntitiesResponseBodyDataEntities());
        }

        public Long getCreatedAt() {
            return this.createdAt;
        }

        public String getDbName() {
            return this.dbName;
        }

        public String getEntityId() {
            return this.entityId;
        }

        public Integer getFaceCount() {
            return this.faceCount;
        }

        public String getLabels() {
            return this.labels;
        }

        public Long getUpdatedAt() {
            return this.updatedAt;
        }

        public ListFaceEntitiesResponseBodyDataEntities setCreatedAt(Long l) {
            this.createdAt = l;
            return this;
        }

        public ListFaceEntitiesResponseBodyDataEntities setDbName(String str) {
            this.dbName = str;
            return this;
        }

        public ListFaceEntitiesResponseBodyDataEntities setEntityId(String str) {
            this.entityId = str;
            return this;
        }

        public ListFaceEntitiesResponseBodyDataEntities setFaceCount(Integer num) {
            this.faceCount = num;
            return this;
        }

        public ListFaceEntitiesResponseBodyDataEntities setLabels(String str) {
            this.labels = str;
            return this;
        }

        public ListFaceEntitiesResponseBodyDataEntities setUpdatedAt(Long l) {
            this.updatedAt = l;
            return this;
        }
    }

    public static ListFaceEntitiesResponseBody build(Map<String, ?> map) throws Exception {
        return (ListFaceEntitiesResponseBody) TeaModel.build(map, new ListFaceEntitiesResponseBody());
    }

    public ListFaceEntitiesResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public ListFaceEntitiesResponseBody setData(ListFaceEntitiesResponseBodyData listFaceEntitiesResponseBodyData) {
        this.data = listFaceEntitiesResponseBodyData;
        return this;
    }

    public ListFaceEntitiesResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

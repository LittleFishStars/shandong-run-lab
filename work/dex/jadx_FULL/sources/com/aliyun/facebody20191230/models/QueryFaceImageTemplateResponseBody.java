package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class QueryFaceImageTemplateResponseBody extends TeaModel {

    @NameInMap("Data")
    public QueryFaceImageTemplateResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class QueryFaceImageTemplateResponseBodyData extends TeaModel {

        @NameInMap("Elements")
        public List<QueryFaceImageTemplateResponseBodyDataElements> elements;

        @NameInMap("Total")
        public Long total;

        public static QueryFaceImageTemplateResponseBodyData build(Map<String, ?> map) throws Exception {
            return (QueryFaceImageTemplateResponseBodyData) TeaModel.build(map, new QueryFaceImageTemplateResponseBodyData());
        }

        public List<QueryFaceImageTemplateResponseBodyDataElements> getElements() {
            return this.elements;
        }

        public Long getTotal() {
            return this.total;
        }

        public QueryFaceImageTemplateResponseBodyData setElements(List<QueryFaceImageTemplateResponseBodyDataElements> list) {
            this.elements = list;
            return this;
        }

        public QueryFaceImageTemplateResponseBodyData setTotal(Long l) {
            this.total = l;
            return this;
        }
    }

    public static class QueryFaceImageTemplateResponseBodyDataElements extends TeaModel {

        @NameInMap("CreateTime")
        public String createTime;

        @NameInMap("FaceInfos")
        public List<QueryFaceImageTemplateResponseBodyDataElementsFaceInfos> faceInfos;

        @NameInMap("TemplateId")
        public String templateId;

        @NameInMap("TemplateURL")
        public String templateURL;

        @NameInMap("UpdateTime")
        public String updateTime;

        @NameInMap("UserId")
        public String userId;

        public static QueryFaceImageTemplateResponseBodyDataElements build(Map<String, ?> map) throws Exception {
            return (QueryFaceImageTemplateResponseBodyDataElements) TeaModel.build(map, new QueryFaceImageTemplateResponseBodyDataElements());
        }

        public String getCreateTime() {
            return this.createTime;
        }

        public List<QueryFaceImageTemplateResponseBodyDataElementsFaceInfos> getFaceInfos() {
            return this.faceInfos;
        }

        public String getTemplateId() {
            return this.templateId;
        }

        public String getTemplateURL() {
            return this.templateURL;
        }

        public String getUpdateTime() {
            return this.updateTime;
        }

        public String getUserId() {
            return this.userId;
        }

        public QueryFaceImageTemplateResponseBodyDataElements setCreateTime(String str) {
            this.createTime = str;
            return this;
        }

        public QueryFaceImageTemplateResponseBodyDataElements setFaceInfos(List<QueryFaceImageTemplateResponseBodyDataElementsFaceInfos> list) {
            this.faceInfos = list;
            return this;
        }

        public QueryFaceImageTemplateResponseBodyDataElements setTemplateId(String str) {
            this.templateId = str;
            return this;
        }

        public QueryFaceImageTemplateResponseBodyDataElements setTemplateURL(String str) {
            this.templateURL = str;
            return this;
        }

        public QueryFaceImageTemplateResponseBodyDataElements setUpdateTime(String str) {
            this.updateTime = str;
            return this;
        }

        public QueryFaceImageTemplateResponseBodyDataElements setUserId(String str) {
            this.userId = str;
            return this;
        }
    }

    public static class QueryFaceImageTemplateResponseBodyDataElementsFaceInfos extends TeaModel {

        @NameInMap("FaceRect")
        public QueryFaceImageTemplateResponseBodyDataElementsFaceInfosFaceRect faceRect;

        @NameInMap("TemplateFaceID")
        public String templateFaceID;

        public static QueryFaceImageTemplateResponseBodyDataElementsFaceInfos build(Map<String, ?> map) throws Exception {
            return (QueryFaceImageTemplateResponseBodyDataElementsFaceInfos) TeaModel.build(map, new QueryFaceImageTemplateResponseBodyDataElementsFaceInfos());
        }

        public QueryFaceImageTemplateResponseBodyDataElementsFaceInfosFaceRect getFaceRect() {
            return this.faceRect;
        }

        public String getTemplateFaceID() {
            return this.templateFaceID;
        }

        public QueryFaceImageTemplateResponseBodyDataElementsFaceInfos setFaceRect(QueryFaceImageTemplateResponseBodyDataElementsFaceInfosFaceRect queryFaceImageTemplateResponseBodyDataElementsFaceInfosFaceRect) {
            this.faceRect = queryFaceImageTemplateResponseBodyDataElementsFaceInfosFaceRect;
            return this;
        }

        public QueryFaceImageTemplateResponseBodyDataElementsFaceInfos setTemplateFaceID(String str) {
            this.templateFaceID = str;
            return this;
        }
    }

    public static class QueryFaceImageTemplateResponseBodyDataElementsFaceInfosFaceRect extends TeaModel {

        @NameInMap(AliyunVodKey.KEY_VOD_HEIGHT)
        public String height;

        @NameInMap("Width")
        public String width;

        @NameInMap("X")
        public String x;

        @NameInMap("Y")
        public String y;

        public static QueryFaceImageTemplateResponseBodyDataElementsFaceInfosFaceRect build(Map<String, ?> map) throws Exception {
            return (QueryFaceImageTemplateResponseBodyDataElementsFaceInfosFaceRect) TeaModel.build(map, new QueryFaceImageTemplateResponseBodyDataElementsFaceInfosFaceRect());
        }

        public String getHeight() {
            return this.height;
        }

        public String getWidth() {
            return this.width;
        }

        public String getX() {
            return this.x;
        }

        public String getY() {
            return this.y;
        }

        public QueryFaceImageTemplateResponseBodyDataElementsFaceInfosFaceRect setHeight(String str) {
            this.height = str;
            return this;
        }

        public QueryFaceImageTemplateResponseBodyDataElementsFaceInfosFaceRect setWidth(String str) {
            this.width = str;
            return this;
        }

        public QueryFaceImageTemplateResponseBodyDataElementsFaceInfosFaceRect setX(String str) {
            this.x = str;
            return this;
        }

        public QueryFaceImageTemplateResponseBodyDataElementsFaceInfosFaceRect setY(String str) {
            this.y = str;
            return this;
        }
    }

    public static QueryFaceImageTemplateResponseBody build(Map<String, ?> map) throws Exception {
        return (QueryFaceImageTemplateResponseBody) TeaModel.build(map, new QueryFaceImageTemplateResponseBody());
    }

    public QueryFaceImageTemplateResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public QueryFaceImageTemplateResponseBody setData(QueryFaceImageTemplateResponseBodyData queryFaceImageTemplateResponseBodyData) {
        this.data = queryFaceImageTemplateResponseBodyData;
        return this;
    }

    public QueryFaceImageTemplateResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

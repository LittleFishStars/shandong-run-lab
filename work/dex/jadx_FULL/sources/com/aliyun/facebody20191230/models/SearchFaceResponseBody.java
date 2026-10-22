package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SearchFaceResponseBody extends TeaModel {

    @NameInMap("Data")
    public SearchFaceResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class SearchFaceResponseBodyData extends TeaModel {

        @NameInMap("MatchList")
        public List<SearchFaceResponseBodyDataMatchList> matchList;

        public static SearchFaceResponseBodyData build(Map<String, ?> map) throws Exception {
            return (SearchFaceResponseBodyData) TeaModel.build(map, new SearchFaceResponseBodyData());
        }

        public List<SearchFaceResponseBodyDataMatchList> getMatchList() {
            return this.matchList;
        }

        public SearchFaceResponseBodyData setMatchList(List<SearchFaceResponseBodyDataMatchList> list) {
            this.matchList = list;
            return this;
        }
    }

    public static class SearchFaceResponseBodyDataMatchList extends TeaModel {

        @NameInMap("FaceItems")
        public List<SearchFaceResponseBodyDataMatchListFaceItems> faceItems;

        @NameInMap("Location")
        public SearchFaceResponseBodyDataMatchListLocation location;

        @NameInMap("QualitieScore")
        public Float qualitieScore;

        public static SearchFaceResponseBodyDataMatchList build(Map<String, ?> map) throws Exception {
            return (SearchFaceResponseBodyDataMatchList) TeaModel.build(map, new SearchFaceResponseBodyDataMatchList());
        }

        public List<SearchFaceResponseBodyDataMatchListFaceItems> getFaceItems() {
            return this.faceItems;
        }

        public SearchFaceResponseBodyDataMatchListLocation getLocation() {
            return this.location;
        }

        public Float getQualitieScore() {
            return this.qualitieScore;
        }

        public SearchFaceResponseBodyDataMatchList setFaceItems(List<SearchFaceResponseBodyDataMatchListFaceItems> list) {
            this.faceItems = list;
            return this;
        }

        public SearchFaceResponseBodyDataMatchList setLocation(SearchFaceResponseBodyDataMatchListLocation searchFaceResponseBodyDataMatchListLocation) {
            this.location = searchFaceResponseBodyDataMatchListLocation;
            return this;
        }

        public SearchFaceResponseBodyDataMatchList setQualitieScore(Float f) {
            this.qualitieScore = f;
            return this;
        }
    }

    public static class SearchFaceResponseBodyDataMatchListFaceItems extends TeaModel {

        @NameInMap("Confidence")
        public Float confidence;

        @NameInMap("DbName")
        public String dbName;

        @NameInMap("EntityId")
        public String entityId;

        @NameInMap("ExtraData")
        public String extraData;

        @NameInMap("FaceId")
        public String faceId;

        @NameInMap("Score")
        public Float score;

        public static SearchFaceResponseBodyDataMatchListFaceItems build(Map<String, ?> map) throws Exception {
            return (SearchFaceResponseBodyDataMatchListFaceItems) TeaModel.build(map, new SearchFaceResponseBodyDataMatchListFaceItems());
        }

        public Float getConfidence() {
            return this.confidence;
        }

        public String getDbName() {
            return this.dbName;
        }

        public String getEntityId() {
            return this.entityId;
        }

        public String getExtraData() {
            return this.extraData;
        }

        public String getFaceId() {
            return this.faceId;
        }

        public Float getScore() {
            return this.score;
        }

        public SearchFaceResponseBodyDataMatchListFaceItems setConfidence(Float f) {
            this.confidence = f;
            return this;
        }

        public SearchFaceResponseBodyDataMatchListFaceItems setDbName(String str) {
            this.dbName = str;
            return this;
        }

        public SearchFaceResponseBodyDataMatchListFaceItems setEntityId(String str) {
            this.entityId = str;
            return this;
        }

        public SearchFaceResponseBodyDataMatchListFaceItems setExtraData(String str) {
            this.extraData = str;
            return this;
        }

        public SearchFaceResponseBodyDataMatchListFaceItems setFaceId(String str) {
            this.faceId = str;
            return this;
        }

        public SearchFaceResponseBodyDataMatchListFaceItems setScore(Float f) {
            this.score = f;
            return this;
        }
    }

    public static class SearchFaceResponseBodyDataMatchListLocation extends TeaModel {

        @NameInMap(AliyunVodKey.KEY_VOD_HEIGHT)
        public Integer height;

        @NameInMap("Width")
        public Integer width;

        @NameInMap("X")
        public Integer x;

        @NameInMap("Y")
        public Integer y;

        public static SearchFaceResponseBodyDataMatchListLocation build(Map<String, ?> map) throws Exception {
            return (SearchFaceResponseBodyDataMatchListLocation) TeaModel.build(map, new SearchFaceResponseBodyDataMatchListLocation());
        }

        public Integer getHeight() {
            return this.height;
        }

        public Integer getWidth() {
            return this.width;
        }

        public Integer getX() {
            return this.x;
        }

        public Integer getY() {
            return this.y;
        }

        public SearchFaceResponseBodyDataMatchListLocation setHeight(Integer num) {
            this.height = num;
            return this;
        }

        public SearchFaceResponseBodyDataMatchListLocation setWidth(Integer num) {
            this.width = num;
            return this;
        }

        public SearchFaceResponseBodyDataMatchListLocation setX(Integer num) {
            this.x = num;
            return this;
        }

        public SearchFaceResponseBodyDataMatchListLocation setY(Integer num) {
            this.y = num;
            return this;
        }
    }

    public static SearchFaceResponseBody build(Map<String, ?> map) throws Exception {
        return (SearchFaceResponseBody) TeaModel.build(map, new SearchFaceResponseBody());
    }

    public SearchFaceResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public SearchFaceResponseBody setData(SearchFaceResponseBodyData searchFaceResponseBodyData) {
        this.data = searchFaceResponseBodyData;
        return this;
    }

    public SearchFaceResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

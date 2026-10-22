package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ListFaceDbsResponseBody extends TeaModel {

    @NameInMap("Data")
    public ListFaceDbsResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class ListFaceDbsResponseBodyData extends TeaModel {

        @NameInMap("DbList")
        public List<ListFaceDbsResponseBodyDataDbList> dbList;

        public static ListFaceDbsResponseBodyData build(Map<String, ?> map) throws Exception {
            return (ListFaceDbsResponseBodyData) TeaModel.build(map, new ListFaceDbsResponseBodyData());
        }

        public List<ListFaceDbsResponseBodyDataDbList> getDbList() {
            return this.dbList;
        }

        public ListFaceDbsResponseBodyData setDbList(List<ListFaceDbsResponseBodyDataDbList> list) {
            this.dbList = list;
            return this;
        }
    }

    public static class ListFaceDbsResponseBodyDataDbList extends TeaModel {

        @NameInMap("Name")
        public String name;

        public static ListFaceDbsResponseBodyDataDbList build(Map<String, ?> map) throws Exception {
            return (ListFaceDbsResponseBodyDataDbList) TeaModel.build(map, new ListFaceDbsResponseBodyDataDbList());
        }

        public String getName() {
            return this.name;
        }

        public ListFaceDbsResponseBodyDataDbList setName(String str) {
            this.name = str;
            return this;
        }
    }

    public static ListFaceDbsResponseBody build(Map<String, ?> map) throws Exception {
        return (ListFaceDbsResponseBody) TeaModel.build(map, new ListFaceDbsResponseBody());
    }

    public ListFaceDbsResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public ListFaceDbsResponseBody setData(ListFaceDbsResponseBodyData listFaceDbsResponseBodyData) {
        this.data = listFaceDbsResponseBodyData;
        return this;
    }

    public ListFaceDbsResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

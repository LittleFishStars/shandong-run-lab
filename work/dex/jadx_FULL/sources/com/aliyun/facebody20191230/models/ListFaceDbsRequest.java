package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ListFaceDbsRequest extends TeaModel {

    @NameInMap("Limit")
    public Long limit;

    @NameInMap("Offset")
    public Long offset;

    public static ListFaceDbsRequest build(Map<String, ?> map) throws Exception {
        return (ListFaceDbsRequest) TeaModel.build(map, new ListFaceDbsRequest());
    }

    public Long getLimit() {
        return this.limit;
    }

    public Long getOffset() {
        return this.offset;
    }

    public ListFaceDbsRequest setLimit(Long l) {
        this.limit = l;
        return this;
    }

    public ListFaceDbsRequest setOffset(Long l) {
        this.offset = l;
        return this;
    }
}

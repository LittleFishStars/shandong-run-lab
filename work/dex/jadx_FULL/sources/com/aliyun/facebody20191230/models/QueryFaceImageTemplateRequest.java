package com.aliyun.facebody20191230.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class QueryFaceImageTemplateRequest extends TeaModel {

    @NameInMap("PageNo")
    public Long pageNo;

    @NameInMap("PageSize")
    public Long pageSize;

    @NameInMap("TemplateId")
    public String templateId;

    public static QueryFaceImageTemplateRequest build(Map<String, ?> map) throws Exception {
        return (QueryFaceImageTemplateRequest) TeaModel.build(map, new QueryFaceImageTemplateRequest());
    }

    public Long getPageNo() {
        return this.pageNo;
    }

    public Long getPageSize() {
        return this.pageSize;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public QueryFaceImageTemplateRequest setPageNo(Long l) {
        this.pageNo = l;
        return this;
    }

    public QueryFaceImageTemplateRequest setPageSize(Long l) {
        this.pageSize = l;
        return this;
    }

    public QueryFaceImageTemplateRequest setTemplateId(String str) {
        this.templateId = str;
        return this;
    }
}

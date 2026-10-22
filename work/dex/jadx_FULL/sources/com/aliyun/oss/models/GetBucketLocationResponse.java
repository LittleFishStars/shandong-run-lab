package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.alibaba.sdk.android.oss.model.CreateBucketRequest;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetBucketLocationResponse extends TeaModel {

    @NameInMap(CreateBucketRequest.TAB_LOCATIONCONSTRAINT)
    @Validation(required = true)
    public String locationConstraint;

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    public static GetBucketLocationResponse build(Map<String, ?> map) throws Exception {
        return (GetBucketLocationResponse) TeaModel.build(map, new GetBucketLocationResponse());
    }

    public String getLocationConstraint() {
        return this.locationConstraint;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public GetBucketLocationResponse setLocationConstraint(String str) {
        this.locationConstraint = str;
        return this;
    }

    public GetBucketLocationResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

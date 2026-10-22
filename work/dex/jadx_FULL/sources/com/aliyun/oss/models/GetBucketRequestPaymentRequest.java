package com.aliyun.oss.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetBucketRequestPaymentRequest extends TeaModel {

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    public static GetBucketRequestPaymentRequest build(Map<String, ?> map) throws Exception {
        return (GetBucketRequestPaymentRequest) TeaModel.build(map, new GetBucketRequestPaymentRequest());
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public GetBucketRequestPaymentRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }
}

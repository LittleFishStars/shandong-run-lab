package com.aliyun.oss.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetBucketRefererRequest extends TeaModel {

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    public static GetBucketRefererRequest build(Map<String, ?> map) throws Exception {
        return (GetBucketRefererRequest) TeaModel.build(map, new GetBucketRefererRequest());
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public GetBucketRefererRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }
}

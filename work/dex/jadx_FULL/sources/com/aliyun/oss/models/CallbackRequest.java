package com.aliyun.oss.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class CallbackRequest extends TeaModel {

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    public static CallbackRequest build(Map<String, ?> map) throws Exception {
        return (CallbackRequest) TeaModel.build(map, new CallbackRequest());
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public CallbackRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }
}

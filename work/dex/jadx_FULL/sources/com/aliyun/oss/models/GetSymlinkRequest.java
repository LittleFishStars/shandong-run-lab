package com.aliyun.oss.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetSymlinkRequest extends TeaModel {

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("ObjectName")
    @Validation(required = true)
    public String objectName;

    public static GetSymlinkRequest build(Map<String, ?> map) throws Exception {
        return (GetSymlinkRequest) TeaModel.build(map, new GetSymlinkRequest());
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public GetSymlinkRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public GetSymlinkRequest setObjectName(String str) {
        this.objectName = str;
        return this;
    }
}

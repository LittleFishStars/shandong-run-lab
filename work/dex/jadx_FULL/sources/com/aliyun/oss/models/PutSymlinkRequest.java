package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PutSymlinkRequest extends TeaModel {

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("Header")
    @Validation(required = true)
    public PutSymlinkRequestHeader header;

    @NameInMap("ObjectName")
    @Validation(required = true)
    public String objectName;

    public static class PutSymlinkRequestHeader extends TeaModel {

        @NameInMap(OSSHeaders.STORAGE_CLASS)
        public String storageClass;

        @NameInMap(OSSHeaders.OSS_HEADER_SYMLINK_TARGET)
        @Validation(required = true)
        public String symlinkTarget;

        public static PutSymlinkRequestHeader build(Map<String, ?> map) throws Exception {
            return (PutSymlinkRequestHeader) TeaModel.build(map, new PutSymlinkRequestHeader());
        }

        public String getStorageClass() {
            return this.storageClass;
        }

        public String getSymlinkTarget() {
            return this.symlinkTarget;
        }

        public PutSymlinkRequestHeader setStorageClass(String str) {
            this.storageClass = str;
            return this;
        }

        public PutSymlinkRequestHeader setSymlinkTarget(String str) {
            this.symlinkTarget = str;
            return this;
        }
    }

    public static PutSymlinkRequest build(Map<String, ?> map) throws Exception {
        return (PutSymlinkRequest) TeaModel.build(map, new PutSymlinkRequest());
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public PutSymlinkRequestHeader getHeader() {
        return this.header;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public PutSymlinkRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public PutSymlinkRequest setHeader(PutSymlinkRequestHeader putSymlinkRequestHeader) {
        this.header = putSymlinkRequestHeader;
        return this;
    }

    public PutSymlinkRequest setObjectName(String str) {
        this.objectName = str;
        return this;
    }
}

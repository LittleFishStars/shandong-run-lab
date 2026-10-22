package com.aliyun.oss.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import com.google.common.net.b;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class OptionObjectRequest extends TeaModel {

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("Header")
    @Validation(required = true)
    public OptionObjectRequestHeader header;

    @NameInMap("ObjectName")
    @Validation(required = true)
    public String objectName;

    public static class OptionObjectRequestHeader extends TeaModel {

        @NameInMap("Access-Control-Request-Headers")
        @Validation(required = true)
        public String accessControlRequestHeaders;

        @NameInMap("Access-Control-Request-Method")
        @Validation(required = true)
        public String accessControlRequestMethod;

        @NameInMap(b.F)
        @Validation(required = true)
        public String origin;

        public static OptionObjectRequestHeader build(Map<String, ?> map) throws Exception {
            return (OptionObjectRequestHeader) TeaModel.build(map, new OptionObjectRequestHeader());
        }

        public String getAccessControlRequestHeaders() {
            return this.accessControlRequestHeaders;
        }

        public String getAccessControlRequestMethod() {
            return this.accessControlRequestMethod;
        }

        public String getOrigin() {
            return this.origin;
        }

        public OptionObjectRequestHeader setAccessControlRequestHeaders(String str) {
            this.accessControlRequestHeaders = str;
            return this;
        }

        public OptionObjectRequestHeader setAccessControlRequestMethod(String str) {
            this.accessControlRequestMethod = str;
            return this;
        }

        public OptionObjectRequestHeader setOrigin(String str) {
            this.origin = str;
            return this;
        }
    }

    public static OptionObjectRequest build(Map<String, ?> map) throws Exception {
        return (OptionObjectRequest) TeaModel.build(map, new OptionObjectRequest());
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public OptionObjectRequestHeader getHeader() {
        return this.header;
    }

    public String getObjectName() {
        return this.objectName;
    }

    public OptionObjectRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public OptionObjectRequest setHeader(OptionObjectRequestHeader optionObjectRequestHeader) {
        this.header = optionObjectRequestHeader;
        return this;
    }

    public OptionObjectRequest setObjectName(String str) {
        this.objectName = str;
        return this;
    }
}

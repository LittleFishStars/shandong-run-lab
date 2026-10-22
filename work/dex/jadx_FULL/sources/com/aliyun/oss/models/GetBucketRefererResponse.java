package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetBucketRefererResponse extends TeaModel {

    @NameInMap("RefererConfiguration")
    @Validation(required = true)
    public GetBucketRefererResponseRefererConfiguration refererConfiguration;

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    public static class GetBucketRefererResponseRefererConfiguration extends TeaModel {

        @NameInMap("AllowEmptyReferer")
        public Boolean allowEmptyReferer;

        @NameInMap("RefererList")
        @Validation(required = true)
        public GetBucketRefererResponseRefererConfigurationRefererList refererList;

        public static GetBucketRefererResponseRefererConfiguration build(Map<String, ?> map) throws Exception {
            return (GetBucketRefererResponseRefererConfiguration) TeaModel.build(map, new GetBucketRefererResponseRefererConfiguration());
        }

        public Boolean getAllowEmptyReferer() {
            return this.allowEmptyReferer;
        }

        public GetBucketRefererResponseRefererConfigurationRefererList getRefererList() {
            return this.refererList;
        }

        public GetBucketRefererResponseRefererConfiguration setAllowEmptyReferer(Boolean bool) {
            this.allowEmptyReferer = bool;
            return this;
        }

        public GetBucketRefererResponseRefererConfiguration setRefererList(GetBucketRefererResponseRefererConfigurationRefererList getBucketRefererResponseRefererConfigurationRefererList) {
            this.refererList = getBucketRefererResponseRefererConfigurationRefererList;
            return this;
        }
    }

    public static class GetBucketRefererResponseRefererConfigurationRefererList extends TeaModel {

        @NameInMap("Referer")
        public List<String> referer;

        public static GetBucketRefererResponseRefererConfigurationRefererList build(Map<String, ?> map) throws Exception {
            return (GetBucketRefererResponseRefererConfigurationRefererList) TeaModel.build(map, new GetBucketRefererResponseRefererConfigurationRefererList());
        }

        public List<String> getReferer() {
            return this.referer;
        }

        public GetBucketRefererResponseRefererConfigurationRefererList setReferer(List<String> list) {
            this.referer = list;
            return this;
        }
    }

    public static GetBucketRefererResponse build(Map<String, ?> map) throws Exception {
        return (GetBucketRefererResponse) TeaModel.build(map, new GetBucketRefererResponse());
    }

    public GetBucketRefererResponseRefererConfiguration getRefererConfiguration() {
        return this.refererConfiguration;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public GetBucketRefererResponse setRefererConfiguration(GetBucketRefererResponseRefererConfiguration getBucketRefererResponseRefererConfiguration) {
        this.refererConfiguration = getBucketRefererResponseRefererConfiguration;
        return this;
    }

    public GetBucketRefererResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

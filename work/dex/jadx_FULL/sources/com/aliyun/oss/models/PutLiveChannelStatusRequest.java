package com.aliyun.oss.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PutLiveChannelStatusRequest extends TeaModel {

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("ChannelName")
    @Validation(required = true)
    public String channelName;

    @NameInMap("Filter")
    @Validation(required = true)
    public PutLiveChannelStatusRequestFilter filter;

    public static class PutLiveChannelStatusRequestFilter extends TeaModel {

        @NameInMap("status")
        @Validation(required = true)
        public String status;

        public static PutLiveChannelStatusRequestFilter build(Map<String, ?> map) throws Exception {
            return (PutLiveChannelStatusRequestFilter) TeaModel.build(map, new PutLiveChannelStatusRequestFilter());
        }

        public String getStatus() {
            return this.status;
        }

        public PutLiveChannelStatusRequestFilter setStatus(String str) {
            this.status = str;
            return this;
        }
    }

    public static PutLiveChannelStatusRequest build(Map<String, ?> map) throws Exception {
        return (PutLiveChannelStatusRequest) TeaModel.build(map, new PutLiveChannelStatusRequest());
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public PutLiveChannelStatusRequestFilter getFilter() {
        return this.filter;
    }

    public PutLiveChannelStatusRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public PutLiveChannelStatusRequest setChannelName(String str) {
        this.channelName = str;
        return this;
    }

    public PutLiveChannelStatusRequest setFilter(PutLiveChannelStatusRequestFilter putLiveChannelStatusRequestFilter) {
        this.filter = putLiveChannelStatusRequestFilter;
        return this;
    }
}

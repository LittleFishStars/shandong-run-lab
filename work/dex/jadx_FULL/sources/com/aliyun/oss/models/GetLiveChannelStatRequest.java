package com.aliyun.oss.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetLiveChannelStatRequest extends TeaModel {

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("ChannelName")
    @Validation(required = true)
    public String channelName;

    @NameInMap("Filter")
    public GetLiveChannelStatRequestFilter filter;

    public static class GetLiveChannelStatRequestFilter extends TeaModel {

        @NameInMap("comp")
        public String comp;

        public static GetLiveChannelStatRequestFilter build(Map<String, ?> map) throws Exception {
            return (GetLiveChannelStatRequestFilter) TeaModel.build(map, new GetLiveChannelStatRequestFilter());
        }

        public String getComp() {
            return this.comp;
        }

        public GetLiveChannelStatRequestFilter setComp(String str) {
            this.comp = str;
            return this;
        }
    }

    public static GetLiveChannelStatRequest build(Map<String, ?> map) throws Exception {
        return (GetLiveChannelStatRequest) TeaModel.build(map, new GetLiveChannelStatRequest());
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public GetLiveChannelStatRequestFilter getFilter() {
        return this.filter;
    }

    public GetLiveChannelStatRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public GetLiveChannelStatRequest setChannelName(String str) {
        this.channelName = str;
        return this;
    }

    public GetLiveChannelStatRequest setFilter(GetLiveChannelStatRequestFilter getLiveChannelStatRequestFilter) {
        this.filter = getLiveChannelStatRequestFilter;
        return this;
    }
}

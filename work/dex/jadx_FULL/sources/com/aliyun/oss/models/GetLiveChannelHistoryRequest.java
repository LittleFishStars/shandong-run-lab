package com.aliyun.oss.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetLiveChannelHistoryRequest extends TeaModel {

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("ChannelName")
    @Validation(required = true)
    public String channelName;

    @NameInMap("Filter")
    public GetLiveChannelHistoryRequestFilter filter;

    public static class GetLiveChannelHistoryRequestFilter extends TeaModel {

        @NameInMap("comp")
        public String comp;

        public static GetLiveChannelHistoryRequestFilter build(Map<String, ?> map) throws Exception {
            return (GetLiveChannelHistoryRequestFilter) TeaModel.build(map, new GetLiveChannelHistoryRequestFilter());
        }

        public String getComp() {
            return this.comp;
        }

        public GetLiveChannelHistoryRequestFilter setComp(String str) {
            this.comp = str;
            return this;
        }
    }

    public static GetLiveChannelHistoryRequest build(Map<String, ?> map) throws Exception {
        return (GetLiveChannelHistoryRequest) TeaModel.build(map, new GetLiveChannelHistoryRequest());
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public GetLiveChannelHistoryRequestFilter getFilter() {
        return this.filter;
    }

    public GetLiveChannelHistoryRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public GetLiveChannelHistoryRequest setChannelName(String str) {
        this.channelName = str;
        return this;
    }

    public GetLiveChannelHistoryRequest setFilter(GetLiveChannelHistoryRequestFilter getLiveChannelHistoryRequestFilter) {
        this.filter = getLiveChannelHistoryRequestFilter;
        return this;
    }
}

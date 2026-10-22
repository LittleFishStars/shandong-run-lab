package com.aliyun.oss.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetVodPlaylistRequest extends TeaModel {

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("ChannelName")
    @Validation(required = true)
    public String channelName;

    @NameInMap("Filter")
    @Validation(required = true)
    public GetVodPlaylistRequestFilter filter;

    public static class GetVodPlaylistRequestFilter extends TeaModel {

        @NameInMap("endTime")
        @Validation(required = true)
        public String endTime;

        @NameInMap("startTime")
        @Validation(required = true)
        public String startTime;

        public static GetVodPlaylistRequestFilter build(Map<String, ?> map) throws Exception {
            return (GetVodPlaylistRequestFilter) TeaModel.build(map, new GetVodPlaylistRequestFilter());
        }

        public String getEndTime() {
            return this.endTime;
        }

        public String getStartTime() {
            return this.startTime;
        }

        public GetVodPlaylistRequestFilter setEndTime(String str) {
            this.endTime = str;
            return this;
        }

        public GetVodPlaylistRequestFilter setStartTime(String str) {
            this.startTime = str;
            return this;
        }
    }

    public static GetVodPlaylistRequest build(Map<String, ?> map) throws Exception {
        return (GetVodPlaylistRequest) TeaModel.build(map, new GetVodPlaylistRequest());
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public GetVodPlaylistRequestFilter getFilter() {
        return this.filter;
    }

    public GetVodPlaylistRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public GetVodPlaylistRequest setChannelName(String str) {
        this.channelName = str;
        return this;
    }

    public GetVodPlaylistRequest setFilter(GetVodPlaylistRequestFilter getVodPlaylistRequestFilter) {
        this.filter = getVodPlaylistRequestFilter;
        return this;
    }
}

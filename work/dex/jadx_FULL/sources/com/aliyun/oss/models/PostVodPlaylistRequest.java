package com.aliyun.oss.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PostVodPlaylistRequest extends TeaModel {

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("ChannelName")
    @Validation(required = true)
    public String channelName;

    @NameInMap("Filter")
    @Validation(required = true)
    public PostVodPlaylistRequestFilter filter;

    @NameInMap("PlaylistName")
    @Validation(required = true)
    public String playlistName;

    public static class PostVodPlaylistRequestFilter extends TeaModel {

        @NameInMap("endTime")
        @Validation(required = true)
        public String endTime;

        @NameInMap("startTime")
        @Validation(required = true)
        public String startTime;

        public static PostVodPlaylistRequestFilter build(Map<String, ?> map) throws Exception {
            return (PostVodPlaylistRequestFilter) TeaModel.build(map, new PostVodPlaylistRequestFilter());
        }

        public String getEndTime() {
            return this.endTime;
        }

        public String getStartTime() {
            return this.startTime;
        }

        public PostVodPlaylistRequestFilter setEndTime(String str) {
            this.endTime = str;
            return this;
        }

        public PostVodPlaylistRequestFilter setStartTime(String str) {
            this.startTime = str;
            return this;
        }
    }

    public static PostVodPlaylistRequest build(Map<String, ?> map) throws Exception {
        return (PostVodPlaylistRequest) TeaModel.build(map, new PostVodPlaylistRequest());
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public PostVodPlaylistRequestFilter getFilter() {
        return this.filter;
    }

    public String getPlaylistName() {
        return this.playlistName;
    }

    public PostVodPlaylistRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public PostVodPlaylistRequest setChannelName(String str) {
        this.channelName = str;
        return this;
    }

    public PostVodPlaylistRequest setFilter(PostVodPlaylistRequestFilter postVodPlaylistRequestFilter) {
        this.filter = postVodPlaylistRequestFilter;
        return this;
    }

    public PostVodPlaylistRequest setPlaylistName(String str) {
        this.playlistName = str;
        return this;
    }
}

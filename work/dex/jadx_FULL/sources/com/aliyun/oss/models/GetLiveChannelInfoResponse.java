package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetLiveChannelInfoResponse extends TeaModel {

    @NameInMap("LiveChannelConfiguration")
    @Validation(required = true)
    public GetLiveChannelInfoResponseLiveChannelConfiguration liveChannelConfiguration;

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    public static class GetLiveChannelInfoResponseLiveChannelConfiguration extends TeaModel {

        @NameInMap(AliyunVodKey.KEY_VOD_DESCRIPTION)
        public String description;

        @NameInMap("Status")
        public String status;

        @NameInMap("Target")
        @Validation(required = true)
        public GetLiveChannelInfoResponseLiveChannelConfigurationTarget target;

        public static GetLiveChannelInfoResponseLiveChannelConfiguration build(Map<String, ?> map) throws Exception {
            return (GetLiveChannelInfoResponseLiveChannelConfiguration) TeaModel.build(map, new GetLiveChannelInfoResponseLiveChannelConfiguration());
        }

        public String getDescription() {
            return this.description;
        }

        public String getStatus() {
            return this.status;
        }

        public GetLiveChannelInfoResponseLiveChannelConfigurationTarget getTarget() {
            return this.target;
        }

        public GetLiveChannelInfoResponseLiveChannelConfiguration setDescription(String str) {
            this.description = str;
            return this;
        }

        public GetLiveChannelInfoResponseLiveChannelConfiguration setStatus(String str) {
            this.status = str;
            return this;
        }

        public GetLiveChannelInfoResponseLiveChannelConfiguration setTarget(GetLiveChannelInfoResponseLiveChannelConfigurationTarget getLiveChannelInfoResponseLiveChannelConfigurationTarget) {
            this.target = getLiveChannelInfoResponseLiveChannelConfigurationTarget;
            return this;
        }
    }

    public static class GetLiveChannelInfoResponseLiveChannelConfigurationTarget extends TeaModel {

        @NameInMap("FragCount")
        public String fragCount;

        @NameInMap("FragDuration")
        public String fragDuration;

        @NameInMap("PlaylistName")
        public String playlistName;

        @NameInMap("Type")
        public String type;

        public static GetLiveChannelInfoResponseLiveChannelConfigurationTarget build(Map<String, ?> map) throws Exception {
            return (GetLiveChannelInfoResponseLiveChannelConfigurationTarget) TeaModel.build(map, new GetLiveChannelInfoResponseLiveChannelConfigurationTarget());
        }

        public String getFragCount() {
            return this.fragCount;
        }

        public String getFragDuration() {
            return this.fragDuration;
        }

        public String getPlaylistName() {
            return this.playlistName;
        }

        public String getType() {
            return this.type;
        }

        public GetLiveChannelInfoResponseLiveChannelConfigurationTarget setFragCount(String str) {
            this.fragCount = str;
            return this;
        }

        public GetLiveChannelInfoResponseLiveChannelConfigurationTarget setFragDuration(String str) {
            this.fragDuration = str;
            return this;
        }

        public GetLiveChannelInfoResponseLiveChannelConfigurationTarget setPlaylistName(String str) {
            this.playlistName = str;
            return this;
        }

        public GetLiveChannelInfoResponseLiveChannelConfigurationTarget setType(String str) {
            this.type = str;
            return this;
        }
    }

    public static GetLiveChannelInfoResponse build(Map<String, ?> map) throws Exception {
        return (GetLiveChannelInfoResponse) TeaModel.build(map, new GetLiveChannelInfoResponse());
    }

    public GetLiveChannelInfoResponseLiveChannelConfiguration getLiveChannelConfiguration() {
        return this.liveChannelConfiguration;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public GetLiveChannelInfoResponse setLiveChannelConfiguration(GetLiveChannelInfoResponseLiveChannelConfiguration getLiveChannelInfoResponseLiveChannelConfiguration) {
        this.liveChannelConfiguration = getLiveChannelInfoResponseLiveChannelConfiguration;
        return this;
    }

    public GetLiveChannelInfoResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

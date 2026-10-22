package com.aliyun.oss.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PutLiveChannelRequest extends TeaModel {

    @NameInMap("Body")
    public PutLiveChannelRequestBody body;

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("ChannelName")
    @Validation(required = true)
    public String channelName;

    public static class PutLiveChannelRequestBody extends TeaModel {

        @NameInMap("LiveChannelConfiguration")
        @Validation(required = true)
        public PutLiveChannelRequestBodyLiveChannelConfiguration liveChannelConfiguration;

        public static PutLiveChannelRequestBody build(Map<String, ?> map) throws Exception {
            return (PutLiveChannelRequestBody) TeaModel.build(map, new PutLiveChannelRequestBody());
        }

        public PutLiveChannelRequestBodyLiveChannelConfiguration getLiveChannelConfiguration() {
            return this.liveChannelConfiguration;
        }

        public PutLiveChannelRequestBody setLiveChannelConfiguration(PutLiveChannelRequestBodyLiveChannelConfiguration putLiveChannelRequestBodyLiveChannelConfiguration) {
            this.liveChannelConfiguration = putLiveChannelRequestBodyLiveChannelConfiguration;
            return this;
        }
    }

    public static class PutLiveChannelRequestBodyLiveChannelConfiguration extends TeaModel {

        @NameInMap(AliyunVodKey.KEY_VOD_DESCRIPTION)
        public String description;

        @NameInMap("Snapshot")
        public PutLiveChannelRequestBodyLiveChannelConfigurationSnapshot snapshot;

        @NameInMap("Status")
        public String status;

        @NameInMap("Target")
        public PutLiveChannelRequestBodyLiveChannelConfigurationTarget target;

        public static PutLiveChannelRequestBodyLiveChannelConfiguration build(Map<String, ?> map) throws Exception {
            return (PutLiveChannelRequestBodyLiveChannelConfiguration) TeaModel.build(map, new PutLiveChannelRequestBodyLiveChannelConfiguration());
        }

        public String getDescription() {
            return this.description;
        }

        public PutLiveChannelRequestBodyLiveChannelConfigurationSnapshot getSnapshot() {
            return this.snapshot;
        }

        public String getStatus() {
            return this.status;
        }

        public PutLiveChannelRequestBodyLiveChannelConfigurationTarget getTarget() {
            return this.target;
        }

        public PutLiveChannelRequestBodyLiveChannelConfiguration setDescription(String str) {
            this.description = str;
            return this;
        }

        public PutLiveChannelRequestBodyLiveChannelConfiguration setSnapshot(PutLiveChannelRequestBodyLiveChannelConfigurationSnapshot putLiveChannelRequestBodyLiveChannelConfigurationSnapshot) {
            this.snapshot = putLiveChannelRequestBodyLiveChannelConfigurationSnapshot;
            return this;
        }

        public PutLiveChannelRequestBodyLiveChannelConfiguration setStatus(String str) {
            this.status = str;
            return this;
        }

        public PutLiveChannelRequestBodyLiveChannelConfiguration setTarget(PutLiveChannelRequestBodyLiveChannelConfigurationTarget putLiveChannelRequestBodyLiveChannelConfigurationTarget) {
            this.target = putLiveChannelRequestBodyLiveChannelConfigurationTarget;
            return this;
        }
    }

    public static class PutLiveChannelRequestBodyLiveChannelConfigurationSnapshot extends TeaModel {

        @NameInMap("DestBucket")
        public String destBucket;

        @NameInMap("Interval")
        public String interval;

        @NameInMap("NotifyTopic")
        public String notifyTopic;

        @NameInMap("RoleName")
        public String roleName;

        public static PutLiveChannelRequestBodyLiveChannelConfigurationSnapshot build(Map<String, ?> map) throws Exception {
            return (PutLiveChannelRequestBodyLiveChannelConfigurationSnapshot) TeaModel.build(map, new PutLiveChannelRequestBodyLiveChannelConfigurationSnapshot());
        }

        public String getDestBucket() {
            return this.destBucket;
        }

        public String getInterval() {
            return this.interval;
        }

        public String getNotifyTopic() {
            return this.notifyTopic;
        }

        public String getRoleName() {
            return this.roleName;
        }

        public PutLiveChannelRequestBodyLiveChannelConfigurationSnapshot setDestBucket(String str) {
            this.destBucket = str;
            return this;
        }

        public PutLiveChannelRequestBodyLiveChannelConfigurationSnapshot setInterval(String str) {
            this.interval = str;
            return this;
        }

        public PutLiveChannelRequestBodyLiveChannelConfigurationSnapshot setNotifyTopic(String str) {
            this.notifyTopic = str;
            return this;
        }

        public PutLiveChannelRequestBodyLiveChannelConfigurationSnapshot setRoleName(String str) {
            this.roleName = str;
            return this;
        }
    }

    public static class PutLiveChannelRequestBodyLiveChannelConfigurationTarget extends TeaModel {

        @NameInMap("FragCount")
        public String fragCount;

        @NameInMap("FragDuration")
        public String fragDuration;

        @NameInMap("PlaylistName")
        public String playlistName;

        @NameInMap("Type")
        public String type;

        public static PutLiveChannelRequestBodyLiveChannelConfigurationTarget build(Map<String, ?> map) throws Exception {
            return (PutLiveChannelRequestBodyLiveChannelConfigurationTarget) TeaModel.build(map, new PutLiveChannelRequestBodyLiveChannelConfigurationTarget());
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

        public PutLiveChannelRequestBodyLiveChannelConfigurationTarget setFragCount(String str) {
            this.fragCount = str;
            return this;
        }

        public PutLiveChannelRequestBodyLiveChannelConfigurationTarget setFragDuration(String str) {
            this.fragDuration = str;
            return this;
        }

        public PutLiveChannelRequestBodyLiveChannelConfigurationTarget setPlaylistName(String str) {
            this.playlistName = str;
            return this;
        }

        public PutLiveChannelRequestBodyLiveChannelConfigurationTarget setType(String str) {
            this.type = str;
            return this;
        }
    }

    public static PutLiveChannelRequest build(Map<String, ?> map) throws Exception {
        return (PutLiveChannelRequest) TeaModel.build(map, new PutLiveChannelRequest());
    }

    public PutLiveChannelRequestBody getBody() {
        return this.body;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public PutLiveChannelRequest setBody(PutLiveChannelRequestBody putLiveChannelRequestBody) {
        this.body = putLiveChannelRequestBody;
        return this;
    }

    public PutLiveChannelRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public PutLiveChannelRequest setChannelName(String str) {
        this.channelName = str;
        return this;
    }
}

package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetLiveChannelStatResponse extends TeaModel {

    @NameInMap("LiveChannelStat")
    @Validation(required = true)
    public GetLiveChannelStatResponseLiveChannelStat liveChannelStat;

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    public static class GetLiveChannelStatResponseLiveChannelStat extends TeaModel {

        @NameInMap("Audio")
        @Validation(required = true)
        public GetLiveChannelStatResponseLiveChannelStatAudio audio;

        @NameInMap("ConnectedTime")
        public String connectedTime;

        @NameInMap("RemoteAddr")
        public String remoteAddr;

        @NameInMap("Status")
        public String status;

        @NameInMap("Video")
        @Validation(required = true)
        public GetLiveChannelStatResponseLiveChannelStatVideo video;

        public static GetLiveChannelStatResponseLiveChannelStat build(Map<String, ?> map) throws Exception {
            return (GetLiveChannelStatResponseLiveChannelStat) TeaModel.build(map, new GetLiveChannelStatResponseLiveChannelStat());
        }

        public GetLiveChannelStatResponseLiveChannelStatAudio getAudio() {
            return this.audio;
        }

        public String getConnectedTime() {
            return this.connectedTime;
        }

        public String getRemoteAddr() {
            return this.remoteAddr;
        }

        public String getStatus() {
            return this.status;
        }

        public GetLiveChannelStatResponseLiveChannelStatVideo getVideo() {
            return this.video;
        }

        public GetLiveChannelStatResponseLiveChannelStat setAudio(GetLiveChannelStatResponseLiveChannelStatAudio getLiveChannelStatResponseLiveChannelStatAudio) {
            this.audio = getLiveChannelStatResponseLiveChannelStatAudio;
            return this;
        }

        public GetLiveChannelStatResponseLiveChannelStat setConnectedTime(String str) {
            this.connectedTime = str;
            return this;
        }

        public GetLiveChannelStatResponseLiveChannelStat setRemoteAddr(String str) {
            this.remoteAddr = str;
            return this;
        }

        public GetLiveChannelStatResponseLiveChannelStat setStatus(String str) {
            this.status = str;
            return this;
        }

        public GetLiveChannelStatResponseLiveChannelStat setVideo(GetLiveChannelStatResponseLiveChannelStatVideo getLiveChannelStatResponseLiveChannelStatVideo) {
            this.video = getLiveChannelStatResponseLiveChannelStatVideo;
            return this;
        }
    }

    public static class GetLiveChannelStatResponseLiveChannelStatAudio extends TeaModel {

        @NameInMap("Bandwidth")
        public String bandwidth;

        @NameInMap("Codec")
        public String codec;

        @NameInMap("SampleRate")
        public String sampleRate;

        public static GetLiveChannelStatResponseLiveChannelStatAudio build(Map<String, ?> map) throws Exception {
            return (GetLiveChannelStatResponseLiveChannelStatAudio) TeaModel.build(map, new GetLiveChannelStatResponseLiveChannelStatAudio());
        }

        public String getBandwidth() {
            return this.bandwidth;
        }

        public String getCodec() {
            return this.codec;
        }

        public String getSampleRate() {
            return this.sampleRate;
        }

        public GetLiveChannelStatResponseLiveChannelStatAudio setBandwidth(String str) {
            this.bandwidth = str;
            return this;
        }

        public GetLiveChannelStatResponseLiveChannelStatAudio setCodec(String str) {
            this.codec = str;
            return this;
        }

        public GetLiveChannelStatResponseLiveChannelStatAudio setSampleRate(String str) {
            this.sampleRate = str;
            return this;
        }
    }

    public static class GetLiveChannelStatResponseLiveChannelStatVideo extends TeaModel {

        @NameInMap("Bandwidth")
        public String bandwidth;

        @NameInMap("Codec")
        public String codec;

        @NameInMap("FrameRate")
        public String frameRate;

        @NameInMap(AliyunVodKey.KEY_VOD_HEIGHT)
        public String height;

        @NameInMap("Width")
        public String width;

        public static GetLiveChannelStatResponseLiveChannelStatVideo build(Map<String, ?> map) throws Exception {
            return (GetLiveChannelStatResponseLiveChannelStatVideo) TeaModel.build(map, new GetLiveChannelStatResponseLiveChannelStatVideo());
        }

        public String getBandwidth() {
            return this.bandwidth;
        }

        public String getCodec() {
            return this.codec;
        }

        public String getFrameRate() {
            return this.frameRate;
        }

        public String getHeight() {
            return this.height;
        }

        public String getWidth() {
            return this.width;
        }

        public GetLiveChannelStatResponseLiveChannelStatVideo setBandwidth(String str) {
            this.bandwidth = str;
            return this;
        }

        public GetLiveChannelStatResponseLiveChannelStatVideo setCodec(String str) {
            this.codec = str;
            return this;
        }

        public GetLiveChannelStatResponseLiveChannelStatVideo setFrameRate(String str) {
            this.frameRate = str;
            return this;
        }

        public GetLiveChannelStatResponseLiveChannelStatVideo setHeight(String str) {
            this.height = str;
            return this;
        }

        public GetLiveChannelStatResponseLiveChannelStatVideo setWidth(String str) {
            this.width = str;
            return this;
        }
    }

    public static GetLiveChannelStatResponse build(Map<String, ?> map) throws Exception {
        return (GetLiveChannelStatResponse) TeaModel.build(map, new GetLiveChannelStatResponse());
    }

    public GetLiveChannelStatResponseLiveChannelStat getLiveChannelStat() {
        return this.liveChannelStat;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public GetLiveChannelStatResponse setLiveChannelStat(GetLiveChannelStatResponseLiveChannelStat getLiveChannelStatResponseLiveChannelStat) {
        this.liveChannelStat = getLiveChannelStatResponseLiveChannelStat;
        return this;
    }

    public GetLiveChannelStatResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

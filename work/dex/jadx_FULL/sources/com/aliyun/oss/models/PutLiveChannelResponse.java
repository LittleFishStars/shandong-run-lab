package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PutLiveChannelResponse extends TeaModel {

    @NameInMap("CreateLiveChannelResult")
    @Validation(required = true)
    public PutLiveChannelResponseCreateLiveChannelResult createLiveChannelResult;

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    public static class PutLiveChannelResponseCreateLiveChannelResult extends TeaModel {

        @NameInMap("PlayUrls")
        @Validation(required = true)
        public PutLiveChannelResponseCreateLiveChannelResultPlayUrls playUrls;

        @NameInMap("PublishUrls")
        @Validation(required = true)
        public PutLiveChannelResponseCreateLiveChannelResultPublishUrls publishUrls;

        public static PutLiveChannelResponseCreateLiveChannelResult build(Map<String, ?> map) throws Exception {
            return (PutLiveChannelResponseCreateLiveChannelResult) TeaModel.build(map, new PutLiveChannelResponseCreateLiveChannelResult());
        }

        public PutLiveChannelResponseCreateLiveChannelResultPlayUrls getPlayUrls() {
            return this.playUrls;
        }

        public PutLiveChannelResponseCreateLiveChannelResultPublishUrls getPublishUrls() {
            return this.publishUrls;
        }

        public PutLiveChannelResponseCreateLiveChannelResult setPlayUrls(PutLiveChannelResponseCreateLiveChannelResultPlayUrls putLiveChannelResponseCreateLiveChannelResultPlayUrls) {
            this.playUrls = putLiveChannelResponseCreateLiveChannelResultPlayUrls;
            return this;
        }

        public PutLiveChannelResponseCreateLiveChannelResult setPublishUrls(PutLiveChannelResponseCreateLiveChannelResultPublishUrls putLiveChannelResponseCreateLiveChannelResultPublishUrls) {
            this.publishUrls = putLiveChannelResponseCreateLiveChannelResultPublishUrls;
            return this;
        }
    }

    public static class PutLiveChannelResponseCreateLiveChannelResultPlayUrls extends TeaModel {

        @NameInMap(SsManifestParser.d.p)
        public String url;

        public static PutLiveChannelResponseCreateLiveChannelResultPlayUrls build(Map<String, ?> map) throws Exception {
            return (PutLiveChannelResponseCreateLiveChannelResultPlayUrls) TeaModel.build(map, new PutLiveChannelResponseCreateLiveChannelResultPlayUrls());
        }

        public String getUrl() {
            return this.url;
        }

        public PutLiveChannelResponseCreateLiveChannelResultPlayUrls setUrl(String str) {
            this.url = str;
            return this;
        }
    }

    public static class PutLiveChannelResponseCreateLiveChannelResultPublishUrls extends TeaModel {

        @NameInMap(SsManifestParser.d.p)
        public String url;

        public static PutLiveChannelResponseCreateLiveChannelResultPublishUrls build(Map<String, ?> map) throws Exception {
            return (PutLiveChannelResponseCreateLiveChannelResultPublishUrls) TeaModel.build(map, new PutLiveChannelResponseCreateLiveChannelResultPublishUrls());
        }

        public String getUrl() {
            return this.url;
        }

        public PutLiveChannelResponseCreateLiveChannelResultPublishUrls setUrl(String str) {
            this.url = str;
            return this;
        }
    }

    public static PutLiveChannelResponse build(Map<String, ?> map) throws Exception {
        return (PutLiveChannelResponse) TeaModel.build(map, new PutLiveChannelResponse());
    }

    public PutLiveChannelResponseCreateLiveChannelResult getCreateLiveChannelResult() {
        return this.createLiveChannelResult;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public PutLiveChannelResponse setCreateLiveChannelResult(PutLiveChannelResponseCreateLiveChannelResult putLiveChannelResponseCreateLiveChannelResult) {
        this.createLiveChannelResult = putLiveChannelResponseCreateLiveChannelResult;
        return this;
    }

    public PutLiveChannelResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

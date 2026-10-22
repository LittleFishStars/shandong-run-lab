package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ListLiveChannelResponse extends TeaModel {

    @NameInMap("ListLiveChannelResult")
    @Validation(required = true)
    public ListLiveChannelResponseListLiveChannelResult listLiveChannelResult;

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    public static class ListLiveChannelResponseListLiveChannelResult extends TeaModel {

        @NameInMap("IsTruncated")
        public String isTruncated;

        @NameInMap("LiveChannel")
        @Validation(required = true)
        public ListLiveChannelResponseListLiveChannelResultLiveChannel liveChannel;

        @NameInMap("Marker")
        public String marker;

        @NameInMap("MaxKeys")
        public String maxKeys;

        @NameInMap("NextMarker")
        public String nextMarker;

        @NameInMap("Prefix")
        public String prefix;

        public static ListLiveChannelResponseListLiveChannelResult build(Map<String, ?> map) throws Exception {
            return (ListLiveChannelResponseListLiveChannelResult) TeaModel.build(map, new ListLiveChannelResponseListLiveChannelResult());
        }

        public String getIsTruncated() {
            return this.isTruncated;
        }

        public ListLiveChannelResponseListLiveChannelResultLiveChannel getLiveChannel() {
            return this.liveChannel;
        }

        public String getMarker() {
            return this.marker;
        }

        public String getMaxKeys() {
            return this.maxKeys;
        }

        public String getNextMarker() {
            return this.nextMarker;
        }

        public String getPrefix() {
            return this.prefix;
        }

        public ListLiveChannelResponseListLiveChannelResult setIsTruncated(String str) {
            this.isTruncated = str;
            return this;
        }

        public ListLiveChannelResponseListLiveChannelResult setLiveChannel(ListLiveChannelResponseListLiveChannelResultLiveChannel listLiveChannelResponseListLiveChannelResultLiveChannel) {
            this.liveChannel = listLiveChannelResponseListLiveChannelResultLiveChannel;
            return this;
        }

        public ListLiveChannelResponseListLiveChannelResult setMarker(String str) {
            this.marker = str;
            return this;
        }

        public ListLiveChannelResponseListLiveChannelResult setMaxKeys(String str) {
            this.maxKeys = str;
            return this;
        }

        public ListLiveChannelResponseListLiveChannelResult setNextMarker(String str) {
            this.nextMarker = str;
            return this;
        }

        public ListLiveChannelResponseListLiveChannelResult setPrefix(String str) {
            this.prefix = str;
            return this;
        }
    }

    public static class ListLiveChannelResponseListLiveChannelResultLiveChannel extends TeaModel {

        @NameInMap(AliyunVodKey.KEY_VOD_DESCRIPTION)
        public String description;

        @NameInMap("LastModified")
        public String lastModified;

        @NameInMap("Name")
        public String name;

        @NameInMap("PlayUrls")
        @Validation(required = true)
        public ListLiveChannelResponseListLiveChannelResultLiveChannelPlayUrls playUrls;

        @NameInMap("PublishUrls")
        @Validation(required = true)
        public ListLiveChannelResponseListLiveChannelResultLiveChannelPublishUrls publishUrls;

        @NameInMap("Status")
        public String status;

        public static ListLiveChannelResponseListLiveChannelResultLiveChannel build(Map<String, ?> map) throws Exception {
            return (ListLiveChannelResponseListLiveChannelResultLiveChannel) TeaModel.build(map, new ListLiveChannelResponseListLiveChannelResultLiveChannel());
        }

        public String getDescription() {
            return this.description;
        }

        public String getLastModified() {
            return this.lastModified;
        }

        public String getName() {
            return this.name;
        }

        public ListLiveChannelResponseListLiveChannelResultLiveChannelPlayUrls getPlayUrls() {
            return this.playUrls;
        }

        public ListLiveChannelResponseListLiveChannelResultLiveChannelPublishUrls getPublishUrls() {
            return this.publishUrls;
        }

        public String getStatus() {
            return this.status;
        }

        public ListLiveChannelResponseListLiveChannelResultLiveChannel setDescription(String str) {
            this.description = str;
            return this;
        }

        public ListLiveChannelResponseListLiveChannelResultLiveChannel setLastModified(String str) {
            this.lastModified = str;
            return this;
        }

        public ListLiveChannelResponseListLiveChannelResultLiveChannel setName(String str) {
            this.name = str;
            return this;
        }

        public ListLiveChannelResponseListLiveChannelResultLiveChannel setPlayUrls(ListLiveChannelResponseListLiveChannelResultLiveChannelPlayUrls listLiveChannelResponseListLiveChannelResultLiveChannelPlayUrls) {
            this.playUrls = listLiveChannelResponseListLiveChannelResultLiveChannelPlayUrls;
            return this;
        }

        public ListLiveChannelResponseListLiveChannelResultLiveChannel setPublishUrls(ListLiveChannelResponseListLiveChannelResultLiveChannelPublishUrls listLiveChannelResponseListLiveChannelResultLiveChannelPublishUrls) {
            this.publishUrls = listLiveChannelResponseListLiveChannelResultLiveChannelPublishUrls;
            return this;
        }

        public ListLiveChannelResponseListLiveChannelResultLiveChannel setStatus(String str) {
            this.status = str;
            return this;
        }
    }

    public static class ListLiveChannelResponseListLiveChannelResultLiveChannelPlayUrls extends TeaModel {

        @NameInMap(SsManifestParser.d.p)
        public String url;

        public static ListLiveChannelResponseListLiveChannelResultLiveChannelPlayUrls build(Map<String, ?> map) throws Exception {
            return (ListLiveChannelResponseListLiveChannelResultLiveChannelPlayUrls) TeaModel.build(map, new ListLiveChannelResponseListLiveChannelResultLiveChannelPlayUrls());
        }

        public String getUrl() {
            return this.url;
        }

        public ListLiveChannelResponseListLiveChannelResultLiveChannelPlayUrls setUrl(String str) {
            this.url = str;
            return this;
        }
    }

    public static class ListLiveChannelResponseListLiveChannelResultLiveChannelPublishUrls extends TeaModel {

        @NameInMap(SsManifestParser.d.p)
        public String url;

        public static ListLiveChannelResponseListLiveChannelResultLiveChannelPublishUrls build(Map<String, ?> map) throws Exception {
            return (ListLiveChannelResponseListLiveChannelResultLiveChannelPublishUrls) TeaModel.build(map, new ListLiveChannelResponseListLiveChannelResultLiveChannelPublishUrls());
        }

        public String getUrl() {
            return this.url;
        }

        public ListLiveChannelResponseListLiveChannelResultLiveChannelPublishUrls setUrl(String str) {
            this.url = str;
            return this;
        }
    }

    public static ListLiveChannelResponse build(Map<String, ?> map) throws Exception {
        return (ListLiveChannelResponse) TeaModel.build(map, new ListLiveChannelResponse());
    }

    public ListLiveChannelResponseListLiveChannelResult getListLiveChannelResult() {
        return this.listLiveChannelResult;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public ListLiveChannelResponse setListLiveChannelResult(ListLiveChannelResponseListLiveChannelResult listLiveChannelResponseListLiveChannelResult) {
        this.listLiveChannelResult = listLiveChannelResponseListLiveChannelResult;
        return this;
    }

    public ListLiveChannelResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

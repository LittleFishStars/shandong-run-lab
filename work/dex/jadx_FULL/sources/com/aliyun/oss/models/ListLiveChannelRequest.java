package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ListLiveChannelRequest extends TeaModel {

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("Filter")
    public ListLiveChannelRequestFilter filter;

    public static class ListLiveChannelRequestFilter extends TeaModel {

        @NameInMap(RequestParameters.MARKER)
        public String marker;

        @NameInMap(RequestParameters.MAX_KEYS)
        public String maxKeys;

        @NameInMap(RequestParameters.PREFIX)
        public String prefix;

        public static ListLiveChannelRequestFilter build(Map<String, ?> map) throws Exception {
            return (ListLiveChannelRequestFilter) TeaModel.build(map, new ListLiveChannelRequestFilter());
        }

        public String getMarker() {
            return this.marker;
        }

        public String getMaxKeys() {
            return this.maxKeys;
        }

        public String getPrefix() {
            return this.prefix;
        }

        public ListLiveChannelRequestFilter setMarker(String str) {
            this.marker = str;
            return this;
        }

        public ListLiveChannelRequestFilter setMaxKeys(String str) {
            this.maxKeys = str;
            return this;
        }

        public ListLiveChannelRequestFilter setPrefix(String str) {
            this.prefix = str;
            return this;
        }
    }

    public static ListLiveChannelRequest build(Map<String, ?> map) throws Exception {
        return (ListLiveChannelRequest) TeaModel.build(map, new ListLiveChannelRequest());
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public ListLiveChannelRequestFilter getFilter() {
        return this.filter;
    }

    public ListLiveChannelRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public ListLiveChannelRequest setFilter(ListLiveChannelRequestFilter listLiveChannelRequestFilter) {
        this.filter = listLiveChannelRequestFilter;
        return this;
    }
}

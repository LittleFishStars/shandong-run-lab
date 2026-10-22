package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetServiceRequest extends TeaModel {

    @NameInMap("Filter")
    public GetServiceRequestFilter filter;

    public static class GetServiceRequestFilter extends TeaModel {

        @NameInMap(RequestParameters.MARKER)
        public String marker;

        @NameInMap(RequestParameters.MAX_KEYS)
        public String maxKeys;

        @NameInMap(RequestParameters.PREFIX)
        public String prefix;

        public static GetServiceRequestFilter build(Map<String, ?> map) throws Exception {
            return (GetServiceRequestFilter) TeaModel.build(map, new GetServiceRequestFilter());
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

        public GetServiceRequestFilter setMarker(String str) {
            this.marker = str;
            return this;
        }

        public GetServiceRequestFilter setMaxKeys(String str) {
            this.maxKeys = str;
            return this;
        }

        public GetServiceRequestFilter setPrefix(String str) {
            this.prefix = str;
            return this;
        }
    }

    public static GetServiceRequest build(Map<String, ?> map) throws Exception {
        return (GetServiceRequest) TeaModel.build(map, new GetServiceRequest());
    }

    public GetServiceRequestFilter getFilter() {
        return this.filter;
    }

    public GetServiceRequest setFilter(GetServiceRequestFilter getServiceRequestFilter) {
        this.filter = getServiceRequestFilter;
        return this;
    }
}

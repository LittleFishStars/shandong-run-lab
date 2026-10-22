package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class EnhanceFaceResponseBody extends TeaModel {

    @NameInMap("Data")
    public EnhanceFaceResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class EnhanceFaceResponseBodyData extends TeaModel {

        @NameInMap("ImageURL")
        public String imageURL;

        public static EnhanceFaceResponseBodyData build(Map<String, ?> map) throws Exception {
            return (EnhanceFaceResponseBodyData) TeaModel.build(map, new EnhanceFaceResponseBodyData());
        }

        public String getImageURL() {
            return this.imageURL;
        }

        public EnhanceFaceResponseBodyData setImageURL(String str) {
            this.imageURL = str;
            return this;
        }
    }

    public static EnhanceFaceResponseBody build(Map<String, ?> map) throws Exception {
        return (EnhanceFaceResponseBody) TeaModel.build(map, new EnhanceFaceResponseBody());
    }

    public EnhanceFaceResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public EnhanceFaceResponseBody setData(EnhanceFaceResponseBodyData enhanceFaceResponseBodyData) {
        this.data = enhanceFaceResponseBodyData;
        return this;
    }

    public EnhanceFaceResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

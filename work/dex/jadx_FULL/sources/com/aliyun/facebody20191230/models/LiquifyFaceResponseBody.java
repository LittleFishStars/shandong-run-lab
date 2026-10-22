package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LiquifyFaceResponseBody extends TeaModel {

    @NameInMap("Data")
    public LiquifyFaceResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class LiquifyFaceResponseBodyData extends TeaModel {

        @NameInMap("ImageURL")
        public String imageURL;

        public static LiquifyFaceResponseBodyData build(Map<String, ?> map) throws Exception {
            return (LiquifyFaceResponseBodyData) TeaModel.build(map, new LiquifyFaceResponseBodyData());
        }

        public String getImageURL() {
            return this.imageURL;
        }

        public LiquifyFaceResponseBodyData setImageURL(String str) {
            this.imageURL = str;
            return this;
        }
    }

    public static LiquifyFaceResponseBody build(Map<String, ?> map) throws Exception {
        return (LiquifyFaceResponseBody) TeaModel.build(map, new LiquifyFaceResponseBody());
    }

    public LiquifyFaceResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public LiquifyFaceResponseBody setData(LiquifyFaceResponseBodyData liquifyFaceResponseBodyData) {
        this.data = liquifyFaceResponseBodyData;
        return this;
    }

    public LiquifyFaceResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RetouchSkinResponseBody extends TeaModel {

    @NameInMap("Data")
    public RetouchSkinResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class RetouchSkinResponseBodyData extends TeaModel {

        @NameInMap("ImageURL")
        public String imageURL;

        public static RetouchSkinResponseBodyData build(Map<String, ?> map) throws Exception {
            return (RetouchSkinResponseBodyData) TeaModel.build(map, new RetouchSkinResponseBodyData());
        }

        public String getImageURL() {
            return this.imageURL;
        }

        public RetouchSkinResponseBodyData setImageURL(String str) {
            this.imageURL = str;
            return this;
        }
    }

    public static RetouchSkinResponseBody build(Map<String, ?> map) throws Exception {
        return (RetouchSkinResponseBody) TeaModel.build(map, new RetouchSkinResponseBody());
    }

    public RetouchSkinResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public RetouchSkinResponseBody setData(RetouchSkinResponseBodyData retouchSkinResponseBodyData) {
        this.data = retouchSkinResponseBodyData;
        return this;
    }

    public RetouchSkinResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

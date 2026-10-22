package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class FaceTidyupResponseBody extends TeaModel {

    @NameInMap("Data")
    public FaceTidyupResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class FaceTidyupResponseBodyData extends TeaModel {

        @NameInMap("ImageURL")
        public String imageURL;

        public static FaceTidyupResponseBodyData build(Map<String, ?> map) throws Exception {
            return (FaceTidyupResponseBodyData) TeaModel.build(map, new FaceTidyupResponseBodyData());
        }

        public String getImageURL() {
            return this.imageURL;
        }

        public FaceTidyupResponseBodyData setImageURL(String str) {
            this.imageURL = str;
            return this;
        }
    }

    public static FaceTidyupResponseBody build(Map<String, ?> map) throws Exception {
        return (FaceTidyupResponseBody) TeaModel.build(map, new FaceTidyupResponseBody());
    }

    public FaceTidyupResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public FaceTidyupResponseBody setData(FaceTidyupResponseBodyData faceTidyupResponseBodyData) {
        this.data = faceTidyupResponseBodyData;
        return this;
    }

    public FaceTidyupResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

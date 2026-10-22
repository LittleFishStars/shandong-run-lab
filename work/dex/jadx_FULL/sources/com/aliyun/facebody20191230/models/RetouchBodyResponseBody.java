package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RetouchBodyResponseBody extends TeaModel {

    @NameInMap("Data")
    public RetouchBodyResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class RetouchBodyResponseBodyData extends TeaModel {

        @NameInMap("ImageURL")
        public String imageURL;

        public static RetouchBodyResponseBodyData build(Map<String, ?> map) throws Exception {
            return (RetouchBodyResponseBodyData) TeaModel.build(map, new RetouchBodyResponseBodyData());
        }

        public String getImageURL() {
            return this.imageURL;
        }

        public RetouchBodyResponseBodyData setImageURL(String str) {
            this.imageURL = str;
            return this;
        }
    }

    public static RetouchBodyResponseBody build(Map<String, ?> map) throws Exception {
        return (RetouchBodyResponseBody) TeaModel.build(map, new RetouchBodyResponseBody());
    }

    public RetouchBodyResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public RetouchBodyResponseBody setData(RetouchBodyResponseBodyData retouchBodyResponseBodyData) {
        this.data = retouchBodyResponseBodyData;
        return this;
    }

    public RetouchBodyResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

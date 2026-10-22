package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MergeImageFaceResponseBody extends TeaModel {

    @NameInMap("Data")
    public MergeImageFaceResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class MergeImageFaceResponseBodyData extends TeaModel {

        @NameInMap("ImageURL")
        public String imageURL;

        public static MergeImageFaceResponseBodyData build(Map<String, ?> map) throws Exception {
            return (MergeImageFaceResponseBodyData) TeaModel.build(map, new MergeImageFaceResponseBodyData());
        }

        public String getImageURL() {
            return this.imageURL;
        }

        public MergeImageFaceResponseBodyData setImageURL(String str) {
            this.imageURL = str;
            return this;
        }
    }

    public static MergeImageFaceResponseBody build(Map<String, ?> map) throws Exception {
        return (MergeImageFaceResponseBody) TeaModel.build(map, new MergeImageFaceResponseBody());
    }

    public MergeImageFaceResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public MergeImageFaceResponseBody setData(MergeImageFaceResponseBodyData mergeImageFaceResponseBodyData) {
        this.data = mergeImageFaceResponseBodyData;
        return this;
    }

    public MergeImageFaceResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GenerateHumanAnimeStyleResponseBody extends TeaModel {

    @NameInMap("Data")
    public GenerateHumanAnimeStyleResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class GenerateHumanAnimeStyleResponseBodyData extends TeaModel {

        @NameInMap("ImageURL")
        public String imageURL;

        public static GenerateHumanAnimeStyleResponseBodyData build(Map<String, ?> map) throws Exception {
            return (GenerateHumanAnimeStyleResponseBodyData) TeaModel.build(map, new GenerateHumanAnimeStyleResponseBodyData());
        }

        public String getImageURL() {
            return this.imageURL;
        }

        public GenerateHumanAnimeStyleResponseBodyData setImageURL(String str) {
            this.imageURL = str;
            return this;
        }
    }

    public static GenerateHumanAnimeStyleResponseBody build(Map<String, ?> map) throws Exception {
        return (GenerateHumanAnimeStyleResponseBody) TeaModel.build(map, new GenerateHumanAnimeStyleResponseBody());
    }

    public GenerateHumanAnimeStyleResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public GenerateHumanAnimeStyleResponseBody setData(GenerateHumanAnimeStyleResponseBodyData generateHumanAnimeStyleResponseBodyData) {
        this.data = generateHumanAnimeStyleResponseBodyData;
        return this;
    }

    public GenerateHumanAnimeStyleResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

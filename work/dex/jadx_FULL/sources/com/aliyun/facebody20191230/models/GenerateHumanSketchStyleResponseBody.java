package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GenerateHumanSketchStyleResponseBody extends TeaModel {

    @NameInMap("Data")
    public GenerateHumanSketchStyleResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class GenerateHumanSketchStyleResponseBodyData extends TeaModel {

        @NameInMap("ImageURL")
        public String imageURL;

        public static GenerateHumanSketchStyleResponseBodyData build(Map<String, ?> map) throws Exception {
            return (GenerateHumanSketchStyleResponseBodyData) TeaModel.build(map, new GenerateHumanSketchStyleResponseBodyData());
        }

        public String getImageURL() {
            return this.imageURL;
        }

        public GenerateHumanSketchStyleResponseBodyData setImageURL(String str) {
            this.imageURL = str;
            return this;
        }
    }

    public static GenerateHumanSketchStyleResponseBody build(Map<String, ?> map) throws Exception {
        return (GenerateHumanSketchStyleResponseBody) TeaModel.build(map, new GenerateHumanSketchStyleResponseBody());
    }

    public GenerateHumanSketchStyleResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public GenerateHumanSketchStyleResponseBody setData(GenerateHumanSketchStyleResponseBodyData generateHumanSketchStyleResponseBodyData) {
        this.data = generateHumanSketchStyleResponseBodyData;
        return this;
    }

    public GenerateHumanSketchStyleResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

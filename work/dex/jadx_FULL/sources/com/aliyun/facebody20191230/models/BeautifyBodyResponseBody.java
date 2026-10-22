package com.aliyun.facebody20191230.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class BeautifyBodyResponseBody extends TeaModel {

    @NameInMap("Data")
    public BeautifyBodyResponseBodyData data;

    @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
    public String requestId;

    public static class BeautifyBodyResponseBodyData extends TeaModel {

        @NameInMap("XFlowURL")
        public String XFlowURL;

        @NameInMap("YFlowURL")
        public String YFlowURL;

        @NameInMap(AliyunVodKey.KEY_VOD_ACTION)
        public String action;

        public static BeautifyBodyResponseBodyData build(Map<String, ?> map) throws Exception {
            return (BeautifyBodyResponseBodyData) TeaModel.build(map, new BeautifyBodyResponseBodyData());
        }

        public String getAction() {
            return this.action;
        }

        public String getXFlowURL() {
            return this.XFlowURL;
        }

        public String getYFlowURL() {
            return this.YFlowURL;
        }

        public BeautifyBodyResponseBodyData setAction(String str) {
            this.action = str;
            return this;
        }

        public BeautifyBodyResponseBodyData setXFlowURL(String str) {
            this.XFlowURL = str;
            return this;
        }

        public BeautifyBodyResponseBodyData setYFlowURL(String str) {
            this.YFlowURL = str;
            return this;
        }
    }

    public static BeautifyBodyResponseBody build(Map<String, ?> map) throws Exception {
        return (BeautifyBodyResponseBody) TeaModel.build(map, new BeautifyBodyResponseBody());
    }

    public BeautifyBodyResponseBodyData getData() {
        return this.data;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public BeautifyBodyResponseBody setData(BeautifyBodyResponseBodyData beautifyBodyResponseBodyData) {
        this.data = beautifyBodyResponseBodyData;
        return this;
    }

    public BeautifyBodyResponseBody setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

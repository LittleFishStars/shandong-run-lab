package com.aliyun.oss.models;

import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetLiveChannelHistoryResponse extends TeaModel {

    @NameInMap("LiveChannelHistory")
    @Validation(required = true)
    public GetLiveChannelHistoryResponseLiveChannelHistory liveChannelHistory;

    @NameInMap(OSSHeaders.OSS_HEADER_REQUEST_ID)
    @Validation(required = true)
    public String requestId;

    public static class GetLiveChannelHistoryResponseLiveChannelHistory extends TeaModel {

        @NameInMap("LiveRecord")
        public List<GetLiveChannelHistoryResponseLiveChannelHistoryLiveRecord> liveRecord;

        public static GetLiveChannelHistoryResponseLiveChannelHistory build(Map<String, ?> map) throws Exception {
            return (GetLiveChannelHistoryResponseLiveChannelHistory) TeaModel.build(map, new GetLiveChannelHistoryResponseLiveChannelHistory());
        }

        public List<GetLiveChannelHistoryResponseLiveChannelHistoryLiveRecord> getLiveRecord() {
            return this.liveRecord;
        }

        public GetLiveChannelHistoryResponseLiveChannelHistory setLiveRecord(List<GetLiveChannelHistoryResponseLiveChannelHistoryLiveRecord> list) {
            this.liveRecord = list;
            return this;
        }
    }

    public static class GetLiveChannelHistoryResponseLiveChannelHistoryLiveRecord extends TeaModel {

        @NameInMap("EndTime")
        public String endTime;

        @NameInMap("RemoteAddr")
        public String remoteAddr;

        @NameInMap("StartTime")
        public String startTime;

        public static GetLiveChannelHistoryResponseLiveChannelHistoryLiveRecord build(Map<String, ?> map) throws Exception {
            return (GetLiveChannelHistoryResponseLiveChannelHistoryLiveRecord) TeaModel.build(map, new GetLiveChannelHistoryResponseLiveChannelHistoryLiveRecord());
        }

        public String getEndTime() {
            return this.endTime;
        }

        public String getRemoteAddr() {
            return this.remoteAddr;
        }

        public String getStartTime() {
            return this.startTime;
        }

        public GetLiveChannelHistoryResponseLiveChannelHistoryLiveRecord setEndTime(String str) {
            this.endTime = str;
            return this;
        }

        public GetLiveChannelHistoryResponseLiveChannelHistoryLiveRecord setRemoteAddr(String str) {
            this.remoteAddr = str;
            return this;
        }

        public GetLiveChannelHistoryResponseLiveChannelHistoryLiveRecord setStartTime(String str) {
            this.startTime = str;
            return this;
        }
    }

    public static GetLiveChannelHistoryResponse build(Map<String, ?> map) throws Exception {
        return (GetLiveChannelHistoryResponse) TeaModel.build(map, new GetLiveChannelHistoryResponse());
    }

    public GetLiveChannelHistoryResponseLiveChannelHistory getLiveChannelHistory() {
        return this.liveChannelHistory;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public GetLiveChannelHistoryResponse setLiveChannelHistory(GetLiveChannelHistoryResponseLiveChannelHistory getLiveChannelHistoryResponseLiveChannelHistory) {
        this.liveChannelHistory = getLiveChannelHistoryResponseLiveChannelHistory;
        return this;
    }

    public GetLiveChannelHistoryResponse setRequestId(String str) {
        this.requestId = str;
        return this;
    }
}

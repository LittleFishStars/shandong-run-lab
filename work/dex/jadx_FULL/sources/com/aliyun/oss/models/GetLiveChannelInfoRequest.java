package com.aliyun.oss.models;

import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;
import com.aliyun.tea.Validation;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetLiveChannelInfoRequest extends TeaModel {

    @NameInMap("BucketName")
    @Validation(pattern = "[a-zA-Z0-9-_]+", required = true)
    public String bucketName;

    @NameInMap("ChannelName")
    @Validation(required = true)
    public String channelName;

    public static GetLiveChannelInfoRequest build(Map<String, ?> map) throws Exception {
        return (GetLiveChannelInfoRequest) TeaModel.build(map, new GetLiveChannelInfoRequest());
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public GetLiveChannelInfoRequest setBucketName(String str) {
        this.bucketName = str;
        return this;
    }

    public GetLiveChannelInfoRequest setChannelName(String str) {
        this.channelName = str;
        return this;
    }
}

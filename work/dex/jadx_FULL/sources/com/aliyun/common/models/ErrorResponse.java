package com.aliyun.common.models;

import com.aliyun.auth.core.AliyunVodKey;
import com.aliyun.tea.NameInMap;
import com.aliyun.tea.TeaModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ErrorResponse extends TeaModel {

    @NameInMap("Error")
    public Error error;

    public class Error extends TeaModel {

        @NameInMap("Code")
        public String code;

        @NameInMap("HostId")
        public String hostId;

        @NameInMap("Message")
        public String message;

        @NameInMap(AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID)
        public String requestId;

        public Error() {
        }
    }
}

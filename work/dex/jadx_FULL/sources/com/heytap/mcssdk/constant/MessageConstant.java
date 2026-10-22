package com.heytap.mcssdk.constant;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class MessageConstant {

    @Keep
    public interface CommandId {
        public static final int COMMAND_APP_NOTIFICATION_CLOSE = 12317;
        public static final int COMMAND_APP_NOTIFICATION_GET = 12318;
        public static final int COMMAND_APP_NOTIFICATION_OPEN = 12316;
        public static final int COMMAND_BASE = 12288;
        public static final int COMMAND_CANCEL_NOTIFICATION = 12319;
        public static final int COMMAND_CLEAR_ALL_NOTIFICATION = 12305;
        public static final int COMMAND_CLEAR_NOTIFICATION = 12304;
        public static final int COMMAND_CLEAR_NOTIFICATION_TYPE = 12308;
        public static final int COMMAND_CLEAR_PKG_NOTIFICATION = 12311;
        public static final int COMMAND_ERROR = 12287;
        public static final int COMMAND_GET_NOTIFICATION_STATUS = 12309;
        public static final int COMMAND_GET_PUSH_STATUS = 12306;
        public static final int COMMAND_NOTIFICATION_ALLOWANCE = 12313;
        public static final int COMMAND_PAUSE_PUSH = 12299;
        public static final int COMMAND_REGISTER = 12289;
        public static final int COMMAND_RESUME_PUSH = 12300;
        public static final int COMMAND_SEND_INSTANT_ACK = 12312;
        public static final int COMMAND_SET_ALIAS = 12292;
        public static final int COMMAND_SET_NOTIFICATION_SETTINGS = 12310;
        public static final int COMMAND_SET_NOTIFICATION_TYPE = 12307;
        public static final int COMMAND_SET_PUSH_TIME = 12298;
        public static final int COMMAND_STATISTIC = 12291;
        public static final int COMMAND_UNREGISTER = 12290;
    }

    @Keep
    public interface MessageType {
        public static final int MESSAGE_ALARM = 4100;
        public static final int MESSAGE_APP = 4098;
        public static final int MESSAGE_BASE = 4096;
        public static final int MESSAGE_CALL_BACK = 4105;
        public static final int MESSAGE_DATA = 4103;
        public static final int MESSAGE_FIND_PHONE = 4101;
        public static final int MESSAGE_LAUNCH_ALARM = 4102;
        public static final int MESSAGE_NOTIFICATION = 4097;
        public static final int MESSAGE_P2P = 4099;
        public static final int MESSAGE_REVOKE = 4108;
        public static final int MESSAGE_SMS_DATA = 4106;
        public static final int MESSAGE_STAT = 4196;
    }
}

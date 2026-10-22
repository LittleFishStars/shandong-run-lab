package com.alibaba.ariver.websocket.core;

import com.alibaba.ariver.kernel.common.utils.LangResourceUtil;
import com.alibaba.ariver.websocket.R;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum WebSocketResultEnum {
    UNKNOW_ERROR(1, R.string.ariver_websocket_unknow_error),
    WEBSOCKET_IS_CONNECTED_MSG(2, R.string.ariver_websocket_already_connected),
    URL_IS_NULL_MSG(3, R.string.ariver_websocket_url_empty),
    URL_NOT_WELL_FORMAT(4, R.string.ariver_websocket_url_invalid),
    URL_NOT_WS_OR_WSS(5, R.string.ariver_websocket_not_wss),
    CONNECTION_TIMEOUT(6, R.string.ariver_websocket_connection_timeout),
    SSL_HANDSHAKE_ERROR(7, R.string.ariver_websocket_ssl_handshake_error),
    INVALID_SEC_WS_ACCEPT_RESP(8, R.string.ariver_websocket_invalid_sec_ws_accept_resp),
    SERVER_SPEC_SEC_WS_PROTO_NOT_REQ(9, R.string.ariver_websocket_server_spec_sec_ws_proto_not_req),
    CANNOT_SEND_UNTIL_CONNECTION_IS_OPEN(10, R.string.ariver_websocket_cannot_send_until_connection_is_open),
    ERROR_WRITING_TO_STREAM(11, R.string.ariver_websocket_error_writing_to_stream),
    UNABLE_ALLOC_MEM_TO_READ(12, R.string.ariver_websocket_unable_alloc_mem_to_read),
    LAST_ITEM(100000, R.string.ariver_websocket_placeholder);

    private static final Map<String, WebSocketResultEnum> MSG_TO_RESULT_MAP;
    private int errCode;
    private int errMsgResId;

    static {
        WebSocketResultEnum webSocketResultEnum = CONNECTION_TIMEOUT;
        WebSocketResultEnum webSocketResultEnum2 = CANNOT_SEND_UNTIL_CONNECTION_IS_OPEN;
        WebSocketResultEnum webSocketResultEnum3 = UNABLE_ALLOC_MEM_TO_READ;
        HashMap map = new HashMap();
        MSG_TO_RESULT_MAP = map;
        map.put(com.alipay.android.phone.mobilesdk.socketcraft.g.e.f25312a, webSocketResultEnum3);
        map.put(com.alipay.android.phone.mobilesdk.socketcraft.g.e.b, webSocketResultEnum3);
        map.put(com.alipay.android.phone.mobilesdk.socketcraft.g.e.c, webSocketResultEnum);
        map.put(com.alipay.android.phone.mobilesdk.socketcraft.g.e.e, webSocketResultEnum2);
    }

    WebSocketResultEnum(int i, int i2) {
        this.errCode = i;
        this.errMsgResId = i2;
    }

    public static final WebSocketResultEnum getResultEnumByWsMsg(String str) {
        WebSocketResultEnum webSocketResultEnum = MSG_TO_RESULT_MAP.get(str);
        return webSocketResultEnum == null ? UNKNOW_ERROR : webSocketResultEnum;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return LangResourceUtil.getString(this.errMsgResId);
    }
}

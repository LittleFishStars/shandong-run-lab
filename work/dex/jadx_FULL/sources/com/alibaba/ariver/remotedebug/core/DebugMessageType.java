package com.alibaba.ariver.remotedebug.core;

import com.alibaba.ariver.remotedebug.b.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum DebugMessageType {
    REMOTE_DEBUG_NETWORK_ERROR("tinyAppRemoteDebug_network_error"),
    REMOTE_DEBUG_NETWORK_REQUEST("tinyAppRemoteDebug_network_request"),
    REMOTE_DEBUG_NETWORK_RESPONSE("tinyAppRemoteDebug_network_response"),
    REMOTE_DEBUG_STORAGE("tinyAppRemoteDebug_storage"),
    STANDARD_LOG(c.b);

    private String mType;

    DebugMessageType(String str) {
        this.mType = str;
    }

    public String getType() {
        return this.mType;
    }
}

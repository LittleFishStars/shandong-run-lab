package com.czhj.sdk.common.network;

import com.google.common.net.b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public enum ResponseHeader {
    LOCATION("Location"),
    USER_AGENT("User-Agent"),
    ACCEPT_LANGUAGE(b.k);

    private final String key;

    ResponseHeader(String str) {
        this.key = str;
    }

    public String getKey() {
        return this.key;
    }
}

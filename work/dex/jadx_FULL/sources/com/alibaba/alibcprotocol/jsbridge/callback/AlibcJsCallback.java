package com.alibaba.alibcprotocol.jsbridge.callback;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface AlibcJsCallback {
    void fail(String str);

    void fail(Map<String, Object> map);

    void success();

    void success(String str);

    void success(Map<String, Object> map);
}

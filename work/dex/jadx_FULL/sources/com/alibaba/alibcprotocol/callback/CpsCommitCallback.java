package com.alibaba.alibcprotocol.callback;

import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface CpsCommitCallback {
    void onFail(String str, String str2);

    void onSuccess(Map<String, String> map);
}

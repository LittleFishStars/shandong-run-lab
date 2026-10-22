package com.czhj.sdk.common.Database;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface SQLiteLisenter {
    void onFailed(Error error);

    void onSuccess(List<?> list);
}

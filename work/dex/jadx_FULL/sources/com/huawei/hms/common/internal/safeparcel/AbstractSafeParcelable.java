package com.huawei.hms.common.internal.safeparcel;

import com.huawei.hms.support.api.client.Result;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class AbstractSafeParcelable extends Result implements SafeParcelable {
    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }
}

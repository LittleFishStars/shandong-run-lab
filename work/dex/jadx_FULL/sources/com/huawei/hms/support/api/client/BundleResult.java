package com.huawei.hms.support.api.client;

import android.os.Bundle;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class BundleResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f37651a;
    private Bundle b;

    public BundleResult(int i, Bundle bundle) {
        this.f37651a = i;
        this.b = bundle;
    }

    public int getResultCode() {
        return this.f37651a;
    }

    public Bundle getRspBody() {
        return this.b;
    }

    public void setResultCode(int i) {
        this.f37651a = i;
    }

    public void setRspBody(Bundle bundle) {
        this.b = bundle;
    }
}

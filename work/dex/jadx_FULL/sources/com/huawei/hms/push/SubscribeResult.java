package com.huawei.hms.push;

import com.huawei.hms.push.notification.SubscribedItem;
import com.huawei.hms.support.api.client.Result;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class SubscribeResult extends Result {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f37618a;
    private List<SubscribedItem> b;

    public String getErrorMsg() {
        return this.f37618a;
    }

    public List<SubscribedItem> getSubscribedItems() {
        return this.b;
    }

    public void setErrorMsg(String str) {
        this.f37618a = str;
    }

    public void setSubscribedItems(List<SubscribedItem> list) {
        this.b = list;
    }
}

package com.alibaba.sdk.android.oss.model;

import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GetBucketLifecycleResult extends OSSResult {
    private ArrayList<BucketLifecycleRule> mLifecycleRules;

    public void addLifecycleRule(BucketLifecycleRule bucketLifecycleRule) {
        if (this.mLifecycleRules == null) {
            this.mLifecycleRules = new ArrayList<>();
        }
        this.mLifecycleRules.add(bucketLifecycleRule);
    }

    public ArrayList<BucketLifecycleRule> getlifecycleRules() {
        return this.mLifecycleRules;
    }

    public void setLifecycleRules(ArrayList<BucketLifecycleRule> arrayList) {
        this.mLifecycleRules = arrayList;
    }
}

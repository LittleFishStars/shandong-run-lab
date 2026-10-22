package com.aliyun.svideosdk.common.struct.asset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class AssetGroup {
    public static final int GROUP_SPECIAL_RECENT = 1;

    public abstract int getGroupId();

    public abstract String getIconUrl();

    public abstract String getName();

    public abstract int getResourceFrom();

    public abstract int getType();

    public abstract boolean isAvailable();
}

package com.aliyun.credentials.utils;

import com.aliyun.credentials.AlibabaCloudCredentials;
import com.aliyun.credentials.provider.AlibabaCloudCredentialsProvider;
import java.util.Date;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Deprecated
public class RefreshUtils {
    public static AlibabaCloudCredentials getNewCredential(AlibabaCloudCredentialsProvider alibabaCloudCredentialsProvider) {
        try {
            return alibabaCloudCredentialsProvider.getCredentials();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean withShouldRefresh(long j) {
        return new Date().getTime() >= j - 180000;
    }
}

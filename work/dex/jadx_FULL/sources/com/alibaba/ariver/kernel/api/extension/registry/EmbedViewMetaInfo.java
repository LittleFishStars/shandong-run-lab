package com.alibaba.ariver.kernel.api.extension.registry;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class EmbedViewMetaInfo {
    public String bundleName;
    public String clazzName;

    public EmbedViewMetaInfo(String str, String str2) {
        this.bundleName = str;
        this.clazzName = str2;
    }

    public String toString() {
        return "EmbedViewMetaInfo{bundleName='" + this.bundleName + "', clazzName='" + this.clazzName + "'}";
    }
}

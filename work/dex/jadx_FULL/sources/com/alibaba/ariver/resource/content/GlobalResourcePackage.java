package com.alibaba.ariver.resource.content;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class GlobalResourcePackage extends NormalResourcePackage {
    public GlobalResourcePackage(String str) {
        super(str, null);
    }

    @Override // com.alibaba.ariver.resource.content.BaseStoragePackage, com.alibaba.ariver.resource.api.content.ResourcePackage
    public void teardown() {
        super.teardown();
        GlobalPackagePool.getInstance().remove(this.appId);
    }
}

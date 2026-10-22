package com.alibaba.alibctriver.proxy;

import android.net.Uri;
import com.alibaba.ariver.integration.ipc.server.RVAppRecord;
import com.alibaba.triver.extensions.DefOpenModeExtension;
import com.alibaba.triver.point.TriverOpenModeProxy;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlibcTriverOpenModeExtension extends DefOpenModeExtension {
    @Override // com.alibaba.triver.extensions.DefOpenModeExtension, com.alibaba.triver.point.TriverOpenModeProxy
    public int getMaxInstanceCount(String str, Uri uri) {
        return super.getMaxInstanceCount(str, uri);
    }

    @Override // com.alibaba.triver.extensions.DefOpenModeExtension, com.alibaba.triver.point.TriverOpenModeProxy
    public TriverOpenModeProxy.OpenMode getOpenMode(String str, Uri uri, List<RVAppRecord> list) {
        return TriverOpenModeProxy.OpenMode.MULTI_INSTANCE;
    }

    @Override // com.alibaba.triver.extensions.DefOpenModeExtension, com.alibaba.triver.point.TriverOpenModeProxy
    public TriverOpenModeProxy.SingleMode getSingleMode(String str, Uri uri) {
        return null;
    }
}

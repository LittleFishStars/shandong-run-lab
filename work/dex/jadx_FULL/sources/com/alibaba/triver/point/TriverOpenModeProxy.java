package com.alibaba.triver.point;

import android.net.Uri;
import com.alibaba.ariver.integration.ipc.server.RVAppRecord;
import com.alibaba.ariver.kernel.common.Proxiable;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface TriverOpenModeProxy extends Proxiable {

    public enum OpenMode {
        SINGLE_INSTANCE,
        MULTI_INSTANCE
    }

    public enum SingleMode {
        CLEAR_TOP,
        NEW_INSTANCE
    }

    int getMaxInstanceCount(String str, Uri uri);

    OpenMode getOpenMode(String str, Uri uri, List<RVAppRecord> list);

    SingleMode getSingleMode(String str, Uri uri);
}

package com.alibaba.android.arouter.facade.service;

import android.net.Uri;
import com.alibaba.android.arouter.facade.template.IProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface PathReplaceService extends IProvider {
    String forString(String str);

    Uri forUri(Uri uri);
}

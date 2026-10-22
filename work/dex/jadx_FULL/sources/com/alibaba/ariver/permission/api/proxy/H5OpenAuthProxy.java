package com.alibaba.ariver.permission.api.proxy;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.permission.extension.auth.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface H5OpenAuthProxy extends Proxiable {
    void addOpenAuthHelper(String str, a aVar, @Nullable Page page);

    void startH5OpenAuth(String str, String str2, Bundle bundle);
}

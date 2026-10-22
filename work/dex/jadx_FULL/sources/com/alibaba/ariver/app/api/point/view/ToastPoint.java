package com.alibaba.ariver.app.api.point.view;

import android.content.Context;
import com.alibaba.ariver.kernel.api.annotation.AutoExtension;
import com.alibaba.ariver.kernel.api.annotation.DefaultImpl;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@AutoExtension
@DefaultImpl("com.alibaba.ariver.jsapi.toast.DefaultToastImplExtension")
public interface ToastPoint extends Extension {
    @ThreadType(ExecutorType.UI)
    void hideToast();

    @ThreadType(ExecutorType.UI)
    void showToast(Context context, String str, int i, String str2, int i2, int i3);
}

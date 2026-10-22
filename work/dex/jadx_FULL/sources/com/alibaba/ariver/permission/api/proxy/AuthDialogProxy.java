package com.alibaba.ariver.permission.api.proxy;

import android.content.Context;
import com.alibaba.ariver.kernel.common.Proxiable;
import com.alibaba.ariver.permission.b.a;
import com.alibaba.ariver.permission.b.b;
import com.alibaba.ariver.permission.b.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface AuthDialogProxy extends Proxiable {
    b getAuthNoticeDialog(Context context);

    c getLocalPermissionDialog(Context context);

    a getOpenAuthDialog(Context context);

    void showErrorTipDialog(Context context, String str, String str2);
}

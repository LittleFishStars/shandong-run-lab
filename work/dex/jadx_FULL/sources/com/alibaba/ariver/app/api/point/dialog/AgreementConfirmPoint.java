package com.alibaba.ariver.app.api.point.dialog;

import androidx.annotation.Keep;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.api.annotation.AutoExtension;
import com.alibaba.ariver.kernel.api.extension.Extension;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@AutoExtension
@Keep
public interface AgreementConfirmPoint extends Extension {
    boolean hasPermission(App app, String str);

    void onAgreementClick(App app, String str);
}

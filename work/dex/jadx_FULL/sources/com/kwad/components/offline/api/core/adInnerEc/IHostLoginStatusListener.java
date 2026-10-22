package com.kwad.components.offline.api.core.adInnerEc;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Keep
public interface IHostLoginStatusListener {
    void onLoginFailure(String str);

    void onLoginSuccess();

    void onLogout();
}

package com.kwad.components.core.proxy;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.proxy.IFragmentActivityProxy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class e extends IFragmentActivityProxy {
    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        finish();
    }
}

package com.zj.adlib;

import com.fl.saas.base.adapter.base.ReportEventListener;
import com.fl.saas.common.util.feature.Consumer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class dp0 implements Consumer {
    @Override // com.fl.saas.common.util.feature.Consumer
    public final void accept(Object obj) {
        ((ReportEventListener) obj).onClickedEvent();
    }
}

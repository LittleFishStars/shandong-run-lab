package com.fl.saas.base.base.listener;

import com.fl.saas.common.pojo.YdNativePojo;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Deprecated
public interface InnerNativeLoaded {

    @Deprecated
    public interface DrawVideoLoaded {
        @Deprecated
        void onAdViewLoaded(List<YdNativePojo> list);
    }

    @Deprecated
    public interface NativeDisplay {
        @Deprecated
        void onAdDisplay(List<YdNativePojo> list);
    }
}

package com.huachenjie.base.module_bridge.interfaces;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.huachenjie.common.callback.ValueCallback;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface MallMethodLoader {
    void a(@NonNull FragmentActivity activity, @NonNull String price, @NonNull String tradeNo, @NonNull Integer payRemainTime, @NonNull String orderNo, @NonNull String shopNo, @NonNull ValueCallback<Integer> callback);
}

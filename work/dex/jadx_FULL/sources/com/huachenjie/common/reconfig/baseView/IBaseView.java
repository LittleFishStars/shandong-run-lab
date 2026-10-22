package com.huachenjie.common.reconfig.baseView;

import android.os.Bundle;
import androidx.annotation.LayoutRes;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H'J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lcom/huachenjie/common/reconfig/baseView/IBaseView;", "", "Landroid/os/Bundle;", "savedInstanceState", "", "b", "", "getLayoutResID", "initView", "initData", "common_release"}, k = 1, mv = {1, 8, 0})
public interface IBaseView {
    default void b(@Nullable Bundle savedInstanceState) {
    }

    @LayoutRes
    int getLayoutResID();

    default void initData() {
    }

    default void initView() {
    }
}

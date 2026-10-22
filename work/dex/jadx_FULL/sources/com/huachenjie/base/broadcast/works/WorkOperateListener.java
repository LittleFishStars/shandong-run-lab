package com.huachenjie.base.broadcast.works;

import android.os.Parcelable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public interface WorkOperateListener {
    default void a() {
    }

    default void b(String workNo, boolean isChecked, int collectedCount) {
    }

    default void c() {
    }

    default void d(String workNo, boolean isChecked, int likeCount) {
    }

    default void e(String workNo, int visible) {
    }

    default void f(Parcelable worksDetail) {
    }
}

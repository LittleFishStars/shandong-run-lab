package com.huachenjie.common.video;

import com.aliyun.player.AliPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public interface AliVideoCallback {
    default void a(AliPlayer aliPlayer) {
    }

    default void b(boolean showCover) {
    }

    default void c() {
    }

    default void d() {
    }

    void e(int tag);

    default void f(AliVideoView view) {
    }

    default void g(boolean isPlaying) {
    }

    default void h() {
    }

    default void i(long progress, long totalProgress) {
    }

    default void onLoadingChanged(boolean showLoading) {
    }
}

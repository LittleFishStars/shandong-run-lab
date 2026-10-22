package com.huachenjie.mall.page.goods_detail.preview;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"Lcom/huachenjie/mall/page/goods_detail/preview/PlayerStatusListener;", "", "onHideCover", "", "onProgressChanged", "duration", "", "total", "onShowCover", "mall_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PlayerStatusListener {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class a {
        public static void a(@NotNull PlayerStatusListener playerStatusListener) {
        }

        public static void b(@NotNull PlayerStatusListener playerStatusListener, long j, long j2) {
        }

        public static void c(@NotNull PlayerStatusListener playerStatusListener) {
        }
    }

    void onHideCover();

    void onProgressChanged(long duration, long total);

    void onShowCover();
}

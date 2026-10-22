package com.huachenjie.im.page.emoji;

import android.view.KeyEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H&¨\u0006\f"}, d2 = {"Lcom/huachenjie/im/page/emoji/EmojiInputCallback;", "", "", "emoji", "", "b", "Landroid/view/KeyEvent;", "keyEventDown", "keyEventUp", "a", "url", "c", "IM_release"}, k = 1, mv = {1, 8, 0})
public interface EmojiInputCallback {
    void a(@NotNull KeyEvent keyEventDown, @NotNull KeyEvent keyEventUp);

    void b(@NotNull String emoji);

    void c(@NotNull String url);
}

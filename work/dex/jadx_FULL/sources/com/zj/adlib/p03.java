package com.zj.adlib;

import android.content.Context;
import android.content.Intent;
import com.huachenjie.common.constants.UserConstants;
import com.huachenjie.social_contact.bean.EmojiStickerBean;
import com.huachenjie.social_contact.page.emoji_sticker.detail.EmojiStickerDetailActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\f"}, d2 = {"Lcom/zj/adlib/p03;", "", "Landroid/content/Context;", "context", "Lcom/huachenjie/social_contact/bean/EmojiStickerBean;", "item", "", UserConstants.EMOJI_PARAMS.b, "", "a", "<init>", "()V", "social_contact_release"}, k = 1, mv = {1, 8, 0})
public final class p03 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final p03 f43868a = new p03();

    public final void a(@NotNull Context context, @NotNull EmojiStickerBean item, int emojiStatus) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(item, "item");
        Intent intent = new Intent(context, (Class<?>) EmojiStickerDetailActivity.class);
        intent.putExtra("emojiStickerCode", item.getEmojiBagCode());
        intent.putExtra(UserConstants.EMOJI_PARAMS.b, emojiStatus);
        intent.putExtra(UserConstants.EMOJI_PARAMS.c, item.getDownloadFlag());
        intent.putExtra(UserConstants.EMOJI_PARAMS.d, item.getAuthName());
        intent.putExtra(UserConstants.EMOJI_PARAMS.e, item.getAuthHeadImg());
        context.startActivity(intent);
    }
}

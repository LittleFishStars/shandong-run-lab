package com.zj.adlib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.byazt.hv.TTDownloadField;
import com.huachenjie.base.broadcast.emoji.EmojiStickerReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u0011\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/zj/adlib/o03;", "", "Landroid/app/Activity;", TTDownloadField.TT_ACTIVITY, "Lcom/huachenjie/base/broadcast/emoji/EmojiStickerReceiver;", "receiver", "", "a", "e", "Landroid/content/Context;", "context", "", "emojiStickerCode", "b", "c", "d", "Ljava/lang/String;", "RECEIVER_EMOJI_STICKER", "EMOJI_STICKER_CODE", "EMOJI_OPERATE_TYPE", "<init>", "()V", "base_release"}, k = 1, mv = {1, 8, 0})
public final class o03 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final o03 f43639a = new o03();

    /* JADX INFO: renamed from: a, reason: collision with other field name and from kotlin metadata */
    @NotNull
    public static final String RECEIVER_EMOJI_STICKER = "com.huachenjie.shandong_school.receiver.emoji.emojiSticker";

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @NotNull
    public static final String EMOJI_STICKER_CODE = "emojiStickerCode";

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @NotNull
    public static final String EMOJI_OPERATE_TYPE = "emojiOperateType";

    public final void a(@NotNull Activity activity, @NotNull EmojiStickerReceiver receiver) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(activity).registerReceiver(receiver, new IntentFilter(RECEIVER_EMOJI_STICKER));
    }

    public final void b(@NotNull Context context, @NotNull String emojiStickerCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(emojiStickerCode, "emojiStickerCode");
        Intent intent = new Intent(RECEIVER_EMOJI_STICKER);
        intent.putExtra("emojiStickerCode", emojiStickerCode);
        intent.putExtra(EMOJI_OPERATE_TYPE, 1);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void c(@NotNull Context context, @NotNull String emojiStickerCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(emojiStickerCode, "emojiStickerCode");
        Intent intent = new Intent(RECEIVER_EMOJI_STICKER);
        intent.putExtra("emojiStickerCode", emojiStickerCode);
        intent.putExtra(EMOJI_OPERATE_TYPE, 2);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void d(@NotNull Context context, @NotNull String emojiStickerCode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(emojiStickerCode, "emojiStickerCode");
        Intent intent = new Intent(RECEIVER_EMOJI_STICKER);
        intent.putExtra("emojiStickerCode", emojiStickerCode);
        intent.putExtra(EMOJI_OPERATE_TYPE, 3);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    public final void e(@NotNull Activity activity, @NotNull EmojiStickerReceiver receiver) {
        Intrinsics.checkNotNullParameter(activity, TTDownloadField.TT_ACTIVITY);
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        LocalBroadcastManager.getInstance(activity).unregisterReceiver(receiver);
    }
}

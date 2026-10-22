package com.google.android.exoplayer2.ui;

import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Player;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a implements PlayerNotificationManager.MediaDescriptionAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final PendingIntent f31083a;

    public a(@Nullable PendingIntent pendingIntent) {
        this.f31083a = pendingIntent;
    }

    @Override // com.google.android.exoplayer2.ui.PlayerNotificationManager.MediaDescriptionAdapter
    @Nullable
    public CharSequence a(Player player) {
        CharSequence charSequence = player.h0().f2110b;
        return !TextUtils.isEmpty(charSequence) ? charSequence : player.h0().d;
    }

    @Override // com.google.android.exoplayer2.ui.PlayerNotificationManager.MediaDescriptionAdapter
    @Nullable
    public PendingIntent b(Player player) {
        return this.f31083a;
    }

    @Override // com.google.android.exoplayer2.ui.PlayerNotificationManager.MediaDescriptionAdapter
    public CharSequence c(Player player) {
        CharSequence charSequence = player.h0().e;
        if (!TextUtils.isEmpty(charSequence)) {
            return charSequence;
        }
        CharSequence charSequence2 = player.h0().f2107a;
        return charSequence2 != null ? charSequence2 : "";
    }

    @Override // com.google.android.exoplayer2.ui.PlayerNotificationManager.MediaDescriptionAdapter
    @Nullable
    public Bitmap d(Player player, PlayerNotificationManager.b bVar) {
        byte[] bArr = player.h0().f2109a;
        if (bArr == null) {
            return null;
        }
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
    }
}

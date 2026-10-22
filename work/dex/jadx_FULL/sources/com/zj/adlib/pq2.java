package com.zj.adlib;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.core.R;
import com.google.android.exoplayer2.offline.Download;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class pq2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @StringRes
    public static final int f44043a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final NotificationCompat.Builder f18921a;

    public pq2(Context context, String str) {
        this.f18921a = new NotificationCompat.Builder(context.getApplicationContext(), str);
    }

    public Notification a(Context context, @DrawableRes int i, @Nullable PendingIntent pendingIntent, @Nullable String str) {
        return c(context, i, pendingIntent, str, R.string.exo_download_completed);
    }

    public Notification b(Context context, @DrawableRes int i, @Nullable PendingIntent pendingIntent, @Nullable String str) {
        return c(context, i, pendingIntent, str, R.string.exo_download_failed);
    }

    public final Notification c(Context context, @DrawableRes int i, @Nullable PendingIntent pendingIntent, @Nullable String str, @StringRes int i2) {
        return d(context, i, pendingIntent, str, i2, 0, 0, false, false, true);
    }

    public final Notification d(Context context, @DrawableRes int i, @Nullable PendingIntent pendingIntent, @Nullable String str, @StringRes int i2, int i3, int i4, boolean z, boolean z2, boolean z3) {
        this.f18921a.setSmallIcon(i);
        this.f18921a.setContentTitle(i2 == 0 ? null : context.getResources().getString(i2));
        this.f18921a.setContentIntent(pendingIntent);
        this.f18921a.setStyle(str != null ? new NotificationCompat.BigTextStyle().bigText(str) : null);
        this.f18921a.setProgress(i3, i4, z);
        this.f18921a.setOngoing(z2);
        this.f18921a.setShowWhen(z3);
        return this.f18921a.build();
    }

    @Deprecated
    public Notification e(Context context, @DrawableRes int i, @Nullable PendingIntent pendingIntent, @Nullable String str, List<Download> list) {
        return f(context, i, pendingIntent, str, list, 0);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0028  */
    /* JADX WARN: Code duplicated, block: B:17:0x0032  */
    /* JADX WARN: Code duplicated, block: B:20:0x003e  */
    /* JADX WARN: Code duplicated, block: B:21:0x0040  */
    /* JADX WARN: Code duplicated, block: B:43:0x0071  */
    /* JADX WARN: Code duplicated, block: B:45:0x0075  */
    /* JADX WARN: Code duplicated, block: B:50:0x0082  */
    /* JADX WARN: Code duplicated, block: B:52:0x0089  */
    public Notification f(Context context, @DrawableRes int i, @Nullable PendingIntent pendingIntent, @Nullable String str, List<Download> list, int i2) {
        int i3;
        int i4;
        boolean z;
        int i5;
        int i6;
        boolean z2;
        float fB;
        boolean z3;
        float f = 0.0f;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        int i7 = 0;
        boolean z9 = true;
        for (int i8 = 0; i8 < list.size(); i8++) {
            Download download = list.get(i8);
            int i9 = download.f30784a;
            if (i9 == 0) {
                z6 = true;
            } else if (i9 == 2) {
                fB = download.b();
                if (fB != -1.0f) {
                    f += fB;
                    z9 = false;
                }
                if (download.a() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                z7 |= z3;
                i7++;
                z5 = true;
            } else if (i9 == 5) {
                z8 = true;
            } else if (i9 == 7) {
                fB = download.b();
                if (fB != -1.0f) {
                    f += fB;
                    z9 = false;
                }
                if (download.a() > 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                z7 |= z3;
                i7++;
                z5 = true;
            }
        }
        if (!z5) {
            if (!z6 || i2 == 0) {
                if (z8) {
                    i4 = R.string.exo_download_removing;
                } else {
                    i3 = 0;
                }
                z = true;
            } else {
                i3 = (i2 & 2) != 0 ? R.string.exo_download_paused_for_wifi : (i2 & 1) != 0 ? R.string.exo_download_paused_for_network : R.string.exo_download_paused;
                z = false;
            }
            if (z) {
                if (z5) {
                    int i10 = (int) (f / i7);
                    if (z9 && z7) {
                        z4 = true;
                    }
                    i6 = i10;
                    z2 = z4;
                } else {
                    i6 = 0;
                    z2 = true;
                }
                i5 = 100;
            } else {
                i5 = 0;
                i6 = 0;
                z2 = false;
            }
            return d(context, i, pendingIntent, str, i3, i5, i6, z2, true, false);
        }
        i4 = R.string.exo_download_downloading;
        i3 = i4;
        z = true;
        if (z) {
            if (z5) {
                int i11 = (int) (f / i7);
                if (z9) {
                    z4 = true;
                }
                i6 = i11;
                z2 = z4;
            } else {
                i6 = 0;
                z2 = true;
            }
            i5 = 100;
        } else {
            i5 = 0;
            i6 = 0;
            z2 = false;
        }
        return d(context, i, pendingIntent, str, i3, i5, i6, z2, true, false);
    }
}

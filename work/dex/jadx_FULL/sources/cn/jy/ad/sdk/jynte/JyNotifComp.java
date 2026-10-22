package cn.jy.ad.sdk.jynte;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class JyNotifComp {
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;

    public static class Builder {
        private NotificationCompat.Builder builder;

        public Builder(Context context, String str) {
            this.builder = new NotificationCompat.Builder(context, str);
        }

        public Notification build() {
            return this.builder.build();
        }

        public Builder setAutoCancel(boolean z) {
            this.builder.setAutoCancel(z);
            return this;
        }

        public Builder setChannelId(String str) {
            this.builder.setChannelId(str);
            return this;
        }

        public Builder setContentIntent(PendingIntent pendingIntent) {
            this.builder.setContentIntent(pendingIntent);
            return this;
        }

        public Builder setCustomBigContentView(RemoteViews remoteViews) {
            this.builder.setCustomBigContentView(remoteViews);
            return this;
        }

        public Builder setCustomContentView(RemoteViews remoteViews) {
            this.builder.setCustomContentView(remoteViews);
            return this;
        }

        public Builder setCustomHeadsUpContentView(RemoteViews remoteViews) {
            this.builder.setCustomHeadsUpContentView(remoteViews);
            return this;
        }

        public Builder setDecoratedCustomViewStyleStyle() {
            this.builder.setStyle(new NotificationCompat.DecoratedCustomViewStyle());
            return this;
        }

        public Builder setDeleteIntent(PendingIntent pendingIntent) {
            this.builder.setDeleteIntent(pendingIntent);
            return this;
        }

        public Builder setFullScreenIntent(PendingIntent pendingIntent, boolean z) {
            this.builder.setFullScreenIntent(pendingIntent, z);
            return this;
        }

        public Builder setGroup(String str) {
            this.builder.setGroup(str);
            return this;
        }

        public Builder setOngoing(boolean z) {
            this.builder.setOngoing(z);
            return this;
        }

        public Builder setPriority(int i) {
            this.builder.setPriority(i);
            return this;
        }

        public Builder setSmallIcon(int i) {
            this.builder.setSmallIcon(i);
            return this;
        }

        public Builder setWhen(long j) {
            this.builder.setWhen(j);
            return this;
        }
    }
}

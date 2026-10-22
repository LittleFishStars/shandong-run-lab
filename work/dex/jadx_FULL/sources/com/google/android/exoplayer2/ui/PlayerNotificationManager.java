package com.google.android.exoplayer2.ui;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.NotificationUtil;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class PlayerNotificationManager {
    public static final String c = "com.google.android.exoplayer.play";
    public static final String d = "com.google.android.exoplayer.pause";
    public static final String e = "com.google.android.exoplayer.prev";
    public static final String f = "com.google.android.exoplayer.next";
    public static final String g = "com.google.android.exoplayer.ffwd";
    public static final String h = "com.google.android.exoplayer.rewind";
    public static final String i = "com.google.android.exoplayer.stop";
    public static final int j = 0;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public static final String f4797j = "INSTANCE_ID";
    public static final int k = 1;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public static final String f4798k = "com.google.android.exoplayer.dismiss";
    public static int l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f31060a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PendingIntent f4799a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f4800a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final IntentFilter f4801a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f4802a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public MediaSessionCompat.Token f4803a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public NotificationCompat.Builder f4804a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final NotificationManagerCompat f4805a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Player.Listener f4806a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Player f4807a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final CustomActionReceiver f4808a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaDescriptionAdapter f4809a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final NotificationBroadcastReceiver f4810a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final NotificationListener f4811a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f4812a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public List<NotificationCompat.Action> f4813a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<String, NotificationCompat.Action> f4814a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f4815a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public String f4816b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Map<String, NotificationCompat.Action> f4817b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4818b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f4819c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f4820c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public int f4821d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f4822d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public int f4823e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f4824e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public int f4825f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f4826f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    @DrawableRes
    public int f4827g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f4828g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public int f4829h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public boolean f4830h;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public int f4831i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public boolean f4832i;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public boolean f4833j;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public boolean f4834k;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public boolean f4835l;
    public boolean m;

    public interface CustomActionReceiver {
        void a(Player player, String str, Intent intent);

        Map<String, NotificationCompat.Action> b(Context context, int i);

        List<String> c(Player player);
    }

    public interface MediaDescriptionAdapter {
        @Nullable
        CharSequence a(Player player);

        @Nullable
        PendingIntent b(Player player);

        CharSequence c(Player player);

        @Nullable
        Bitmap d(Player player, b bVar);

        @Nullable
        default CharSequence e(Player player) {
            return null;
        }
    }

    public class NotificationBroadcastReceiver extends BroadcastReceiver {
        public NotificationBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Player player = PlayerNotificationManager.this.f4807a;
            if (player != null && PlayerNotificationManager.this.f4815a && intent.getIntExtra(PlayerNotificationManager.f4797j, PlayerNotificationManager.this.b) == PlayerNotificationManager.this.b) {
                String action = intent.getAction();
                if (PlayerNotificationManager.c.equals(action)) {
                    if (player.getPlaybackState() == 1) {
                        player.prepare();
                    } else if (player.getPlaybackState() == 4) {
                        player.seekToDefaultPosition(player.getCurrentMediaItemIndex());
                    }
                    player.play();
                    return;
                }
                if (PlayerNotificationManager.d.equals(action)) {
                    player.pause();
                    return;
                }
                if (PlayerNotificationManager.e.equals(action)) {
                    player.seekToPrevious();
                    return;
                }
                if (PlayerNotificationManager.h.equals(action)) {
                    player.seekBack();
                    return;
                }
                if (PlayerNotificationManager.g.equals(action)) {
                    player.seekForward();
                    return;
                }
                if (PlayerNotificationManager.f.equals(action)) {
                    player.seekToNext();
                    return;
                }
                if (PlayerNotificationManager.i.equals(action)) {
                    player.stop(true);
                    return;
                }
                if (PlayerNotificationManager.f4798k.equals(action)) {
                    PlayerNotificationManager.this.M(true);
                } else {
                    if (action == null || PlayerNotificationManager.this.f4808a == null || !PlayerNotificationManager.this.f4817b.containsKey(action)) {
                        return;
                    }
                    PlayerNotificationManager.this.f4808a.a(player, action, intent);
                }
            }
        }
    }

    public interface NotificationListener {
        default void a(int i, Notification notification, boolean z) {
        }

        default void b(int i, boolean z) {
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Priority {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Visibility {
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31062a;

        public void a(Bitmap bitmap) {
            if (bitmap != null) {
                PlayerNotificationManager.this.o(bitmap, this.f31062a);
            }
        }

        public b(int i) {
            this.f31062a = i;
        }
    }

    public class d implements Player.Listener {
        public d() {
        }

        @Override // com.google.android.exoplayer2.Player.Listener
        public void t(Player player, Player.c cVar) {
            if (cVar.b(4, 5, 7, 0, 12, 11, 8, 9, 14)) {
                PlayerNotificationManager.this.n();
            }
        }
    }

    public PlayerNotificationManager(Context context, String str, int i2, MediaDescriptionAdapter mediaDescriptionAdapter, @Nullable NotificationListener notificationListener, @Nullable CustomActionReceiver customActionReceiver, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, @Nullable String str2) {
        Context applicationContext = context.getApplicationContext();
        this.f4800a = applicationContext;
        this.f4812a = str;
        this.f31060a = i2;
        this.f4809a = mediaDescriptionAdapter;
        this.f4811a = notificationListener;
        this.f4808a = customActionReceiver;
        this.f4827g = i3;
        this.f4816b = str2;
        int i11 = l;
        l = i11 + 1;
        this.b = i11;
        this.f4802a = gj9.x(Looper.getMainLooper(), new Handler.Callback() { // from class: com.zj.adlib.et6
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f41523a.l(message);
            }
        });
        this.f4805a = NotificationManagerCompat.from(applicationContext);
        this.f4806a = new d();
        this.f4810a = new NotificationBroadcastReceiver();
        this.f4801a = new IntentFilter();
        this.f4818b = true;
        this.f4820c = true;
        this.f4833j = true;
        this.f4826f = true;
        this.f4828g = true;
        this.f4835l = true;
        this.m = true;
        this.f4825f = 0;
        this.f4823e = 0;
        this.f4831i = -1;
        this.f4821d = 1;
        this.f4829h = 1;
        Map<String, NotificationCompat.Action> mapK = k(applicationContext, i11, i4, i5, i6, i7, i8, i9, i10);
        this.f4814a = mapK;
        Iterator<String> it = mapK.keySet().iterator();
        while (it.hasNext()) {
            this.f4801a.addAction(it.next());
        }
        Map<String, NotificationCompat.Action> mapB = customActionReceiver != null ? customActionReceiver.b(applicationContext, this.b) : Collections.emptyMap();
        this.f4817b = mapB;
        Iterator<String> it2 = mapB.keySet().iterator();
        while (it2.hasNext()) {
            this.f4801a.addAction(it2.next());
        }
        this.f4799a = j(f4798k, applicationContext, this.b);
        this.f4801a.addAction(f4798k);
    }

    public static PendingIntent j(String str, Context context, int i2) {
        Intent intent = new Intent(str).setPackage(context.getPackageName());
        intent.putExtra(f4797j, i2);
        return PendingIntent.getBroadcast(context, i2, intent, gj9.f41922a >= 23 ? 201326592 : 134217728);
    }

    public static Map<String, NotificationCompat.Action> k(Context context, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        HashMap map = new HashMap();
        map.put(c, new NotificationCompat.Action(i3, context.getString(R.string.exo_controls_play_description), j(c, context, i2)));
        map.put(d, new NotificationCompat.Action(i4, context.getString(R.string.exo_controls_pause_description), j(d, context, i2)));
        map.put(i, new NotificationCompat.Action(i5, context.getString(R.string.exo_controls_stop_description), j(i, context, i2)));
        map.put(h, new NotificationCompat.Action(i6, context.getString(R.string.exo_controls_rewind_description), j(h, context, i2)));
        map.put(g, new NotificationCompat.Action(i7, context.getString(R.string.exo_controls_fastforward_description), j(g, context, i2)));
        map.put(e, new NotificationCompat.Action(i8, context.getString(R.string.exo_controls_previous_description), j(e, context, i2)));
        map.put(f, new NotificationCompat.Action(i9, context.getString(R.string.exo_controls_next_description), j(f, context, i2)));
        return map;
    }

    public static void t(NotificationCompat.Builder builder, @Nullable Bitmap bitmap) {
        builder.setLargeIcon(bitmap);
    }

    public final void A(boolean z) {
        if (this.f4832i != z) {
            this.f4832i = z;
            if (z) {
                this.f4824e = false;
            }
            m();
        }
    }

    public final void B(boolean z) {
        if (this.f4820c != z) {
            this.f4820c = z;
            m();
        }
    }

    public final void C(boolean z) {
        if (this.f4824e != z) {
            this.f4824e = z;
            if (z) {
                this.f4832i = false;
            }
            m();
        }
    }

    public final void D(boolean z) {
        if (this.f4833j != z) {
            this.f4833j = z;
            m();
        }
    }

    public final void E(boolean z) {
        if (this.f4818b != z) {
            this.f4818b = z;
            m();
        }
    }

    public final void F(boolean z) {
        if (this.f4822d != z) {
            this.f4822d = z;
            if (z) {
                this.f4830h = false;
            }
            m();
        }
    }

    public final void G(boolean z) {
        if (this.f4826f != z) {
            this.f4826f = z;
            m();
        }
    }

    public final void H(boolean z) {
        if (this.f4830h != z) {
            this.f4830h = z;
            if (z) {
                this.f4822d = false;
            }
            m();
        }
    }

    public final void I(boolean z) {
        if (this.f4834k == z) {
            return;
        }
        this.f4834k = z;
        m();
    }

    public final void J(int i2) {
        if (this.f4829h == i2) {
            return;
        }
        if (i2 != -1 && i2 != 0 && i2 != 1) {
            throw new IllegalStateException();
        }
        this.f4829h = i2;
        m();
    }

    public final boolean K(Player player) {
        return (player.getPlaybackState() == 4 || player.getPlaybackState() == 1 || !player.getPlayWhenReady()) ? false : true;
    }

    public final void L(Player player, @Nullable Bitmap bitmap) {
        boolean ongoing = getOngoing(player);
        NotificationCompat.Builder builderCreateNotification = createNotification(player, this.f4804a, ongoing, bitmap);
        this.f4804a = builderCreateNotification;
        if (builderCreateNotification == null) {
            M(false);
            return;
        }
        Notification notificationBuild = builderCreateNotification.build();
        this.f4805a.notify(this.f31060a, notificationBuild);
        if (!this.f4815a) {
            this.f4800a.registerReceiver(this.f4810a, this.f4801a);
        }
        NotificationListener notificationListener = this.f4811a;
        if (notificationListener != null) {
            notificationListener.a(this.f31060a, notificationBuild, ongoing || !this.f4815a);
        }
        this.f4815a = true;
    }

    public final void M(boolean z) {
        if (this.f4815a) {
            this.f4815a = false;
            this.f4802a.removeMessages(0);
            this.f4805a.cancel(this.f31060a);
            this.f4800a.unregisterReceiver(this.f4810a);
            NotificationListener notificationListener = this.f4811a;
            if (notificationListener != null) {
                notificationListener.b(this.f31060a, z);
            }
        }
    }

    @Nullable
    public NotificationCompat.Builder createNotification(Player player, @Nullable NotificationCompat.Builder builder, boolean z, @Nullable Bitmap bitmap) {
        if (player.getPlaybackState() == 1 && player.a0().w()) {
            this.f4813a = null;
            return null;
        }
        List<String> actions = getActions(player);
        ArrayList arrayList = new ArrayList(actions.size());
        for (int i2 = 0; i2 < actions.size(); i2++) {
            String str = actions.get(i2);
            NotificationCompat.Action action = this.f4814a.containsKey(str) ? this.f4814a.get(str) : this.f4817b.get(str);
            if (action != null) {
                arrayList.add(action);
            }
        }
        if (builder == null || !arrayList.equals(this.f4813a)) {
            builder = new NotificationCompat.Builder(this.f4800a, this.f4812a);
            this.f4813a = arrayList;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                builder.addAction((NotificationCompat.Action) arrayList.get(i3));
            }
        }
        androidx.media.app.NotificationCompat.MediaStyle mediaStyle = new androidx.media.app.NotificationCompat.MediaStyle();
        MediaSessionCompat.Token token = this.f4803a;
        if (token != null) {
            mediaStyle.setMediaSession(token);
        }
        mediaStyle.setShowActionsInCompactView(getActionIndicesForCompactView(actions, player));
        mediaStyle.setShowCancelButton(!z);
        mediaStyle.setCancelButtonIntent(this.f4799a);
        builder.setStyle(mediaStyle);
        builder.setDeleteIntent(this.f4799a);
        builder.setBadgeIconType(this.f4821d).setOngoing(z).setColor(this.f4825f).setColorized(this.f4835l).setSmallIcon(this.f4827g).setVisibility(this.f4829h).setPriority(this.f4831i).setDefaults(this.f4823e);
        if (gj9.f41922a < 21 || !this.m || !player.isPlaying() || player.isPlayingAd() || player.isCurrentMediaItemDynamic() || player.b().f3399a != 1.0f) {
            builder.setShowWhen(false).setUsesChronometer(false);
        } else {
            builder.setWhen(System.currentTimeMillis() - player.getContentPosition()).setShowWhen(true).setUsesChronometer(true);
        }
        builder.setContentTitle(this.f4809a.c(player));
        builder.setContentText(this.f4809a.a(player));
        builder.setSubText(this.f4809a.e(player));
        if (bitmap == null) {
            MediaDescriptionAdapter mediaDescriptionAdapter = this.f4809a;
            int i4 = this.f4819c + 1;
            this.f4819c = i4;
            bitmap = mediaDescriptionAdapter.d(player, new b(i4));
        }
        t(builder, bitmap);
        builder.setContentIntent(this.f4809a.b(player));
        String str2 = this.f4816b;
        if (str2 != null) {
            builder.setGroup(str2);
        }
        builder.setOnlyAlertOnce(true);
        return builder;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x005d  */
    public int[] getActionIndicesForCompactView(List<String> list, Player player) {
        int iIndexOf;
        int iIndexOf2;
        int i2;
        int iIndexOf3 = list.indexOf(d);
        int iIndexOf4 = list.indexOf(c);
        if (this.f4822d) {
            iIndexOf = list.indexOf(e);
        } else {
            iIndexOf = this.f4830h ? list.indexOf(h) : -1;
        }
        if (this.f4824e) {
            iIndexOf2 = list.indexOf(f);
        } else {
            iIndexOf2 = this.f4832i ? list.indexOf(g) : -1;
        }
        int[] iArr = new int[3];
        int i3 = 0;
        if (iIndexOf != -1) {
            iArr[0] = iIndexOf;
            i3 = 1;
        }
        boolean zK = K(player);
        if (iIndexOf3 == -1 || !zK) {
            if (iIndexOf4 != -1 && !zK) {
                i2 = i3 + 1;
                iArr[i3] = iIndexOf4;
            }
            if (iIndexOf2 != -1) {
                iArr[i3] = iIndexOf2;
                i3++;
            }
            return Arrays.copyOf(iArr, i3);
        }
        i2 = i3 + 1;
        iArr[i3] = iIndexOf3;
        i3 = i2;
        if (iIndexOf2 != -1) {
            iArr[i3] = iIndexOf2;
            i3++;
        }
        return Arrays.copyOf(iArr, i3);
    }

    public List<String> getActions(Player player) {
        boolean zIsCommandAvailable = player.isCommandAvailable(7);
        boolean zIsCommandAvailable2 = player.isCommandAvailable(11);
        boolean zIsCommandAvailable3 = player.isCommandAvailable(12);
        boolean zIsCommandAvailable4 = player.isCommandAvailable(9);
        ArrayList arrayList = new ArrayList();
        if (this.f4818b && zIsCommandAvailable) {
            arrayList.add(e);
        }
        if (this.f4826f && zIsCommandAvailable2) {
            arrayList.add(h);
        }
        if (this.f4833j) {
            if (K(player)) {
                arrayList.add(d);
            } else {
                arrayList.add(c);
            }
        }
        if (this.f4828g && zIsCommandAvailable3) {
            arrayList.add(g);
        }
        if (this.f4820c && zIsCommandAvailable4) {
            arrayList.add(f);
        }
        CustomActionReceiver customActionReceiver = this.f4808a;
        if (customActionReceiver != null) {
            arrayList.addAll(customActionReceiver.c(player));
        }
        if (this.f4834k) {
            arrayList.add(i);
        }
        return arrayList;
    }

    public boolean getOngoing(Player player) {
        int playbackState = player.getPlaybackState();
        return (playbackState == 2 || playbackState == 3) && player.getPlayWhenReady();
    }

    public final boolean l(Message message) {
        int i2 = message.what;
        if (i2 == 0) {
            Player player = this.f4807a;
            if (player != null) {
                L(player, null);
            }
        } else {
            if (i2 != 1) {
                return false;
            }
            Player player2 = this.f4807a;
            if (player2 != null && this.f4815a && this.f4819c == message.arg1) {
                L(player2, (Bitmap) message.obj);
            }
        }
        return true;
    }

    public final void m() {
        if (this.f4815a) {
            n();
        }
    }

    public final void n() {
        if (this.f4802a.hasMessages(0)) {
            return;
        }
        this.f4802a.sendEmptyMessage(0);
    }

    public final void o(Bitmap bitmap, int i2) {
        this.f4802a.obtainMessage(1, i2, -1, bitmap).sendToTarget();
    }

    public final void p(int i2) {
        if (this.f4821d == i2) {
            return;
        }
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException();
        }
        this.f4821d = i2;
        m();
    }

    public final void q(int i2) {
        if (this.f4825f != i2) {
            this.f4825f = i2;
            m();
        }
    }

    public final void r(boolean z) {
        if (this.f4835l != z) {
            this.f4835l = z;
            m();
        }
    }

    public final void s(int i2) {
        if (this.f4823e != i2) {
            this.f4823e = i2;
            m();
        }
    }

    public final void u(MediaSessionCompat.Token token) {
        if (gj9.c(this.f4803a, token)) {
            return;
        }
        this.f4803a = token;
        m();
    }

    public final void v(@Nullable Player player) {
        boolean z = true;
        sb0.i(Looper.myLooper() == Looper.getMainLooper());
        if (player != null && player.getApplicationLooper() != Looper.getMainLooper()) {
            z = false;
        }
        sb0.a(z);
        Player player2 = this.f4807a;
        if (player2 == player) {
            return;
        }
        if (player2 != null) {
            player2.V(this.f4806a);
            if (player == null) {
                M(false);
            }
        }
        this.f4807a = player;
        if (player != null) {
            player.u(this.f4806a);
            n();
        }
    }

    public final void w(int i2) {
        if (this.f4831i == i2) {
            return;
        }
        if (i2 != -2 && i2 != -1 && i2 != 0 && i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException();
        }
        this.f4831i = i2;
        m();
    }

    public final void x(@DrawableRes int i2) {
        if (this.f4827g != i2) {
            this.f4827g = i2;
            m();
        }
    }

    public final void y(boolean z) {
        if (this.m != z) {
            this.m = z;
            m();
        }
    }

    public final void z(boolean z) {
        if (this.f4828g != z) {
            this.f4828g = z;
            m();
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31063a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Context f4837a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public CustomActionReceiver f4838a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public MediaDescriptionAdapter f4839a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public NotificationListener f4840a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f4841a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        @Nullable
        public String f4842b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;

        @Deprecated
        public c(Context context, int i, String str, MediaDescriptionAdapter mediaDescriptionAdapter) {
            this(context, i, str);
            this.f4839a = mediaDescriptionAdapter;
        }

        public PlayerNotificationManager a() {
            int i = this.b;
            if (i != 0) {
                NotificationUtil.a(this.f4837a, this.f4841a, i, this.c, this.d);
            }
            return new PlayerNotificationManager(this.f4837a, this.f4841a, this.f31063a, this.f4839a, this.f4840a, this.f4838a, this.e, this.g, this.h, this.i, this.f, this.j, this.k, this.l, this.f4842b);
        }

        public c b(int i) {
            this.c = i;
            return this;
        }

        public c c(int i) {
            this.d = i;
            return this;
        }

        public c d(int i) {
            this.b = i;
            return this;
        }

        public c e(CustomActionReceiver customActionReceiver) {
            this.f4838a = customActionReceiver;
            return this;
        }

        public c f(int i) {
            this.j = i;
            return this;
        }

        public c g(String str) {
            this.f4842b = str;
            return this;
        }

        public c h(MediaDescriptionAdapter mediaDescriptionAdapter) {
            this.f4839a = mediaDescriptionAdapter;
            return this;
        }

        public c i(int i) {
            this.l = i;
            return this;
        }

        public c j(NotificationListener notificationListener) {
            this.f4840a = notificationListener;
            return this;
        }

        public c k(int i) {
            this.h = i;
            return this;
        }

        public c l(int i) {
            this.g = i;
            return this;
        }

        public c m(int i) {
            this.k = i;
            return this;
        }

        public c n(int i) {
            this.f = i;
            return this;
        }

        public c o(int i) {
            this.e = i;
            return this;
        }

        public c p(int i) {
            this.i = i;
            return this;
        }

        public c(Context context, @IntRange(from = 1) int i, String str) {
            sb0.a(i > 0);
            this.f4837a = context;
            this.f31063a = i;
            this.f4841a = str;
            this.d = 2;
            this.f4839a = new com.google.android.exoplayer2.ui.a(null);
            this.e = R.drawable.exo_notification_small_icon;
            this.g = R.drawable.exo_notification_play;
            this.h = R.drawable.exo_notification_pause;
            this.i = R.drawable.exo_notification_stop;
            this.f = R.drawable.exo_notification_rewind;
            this.j = R.drawable.exo_notification_fastforward;
            this.k = R.drawable.exo_notification_previous;
            this.l = R.drawable.exo_notification_next;
        }
    }
}

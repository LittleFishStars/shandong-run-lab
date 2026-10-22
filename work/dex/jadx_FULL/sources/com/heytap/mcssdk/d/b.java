package com.heytap.mcssdk.d;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.heytap.mcssdk.PushService;
import com.heytap.mcssdk.constant.c;
import com.heytap.mcssdk.constant.d;
import com.heytap.msp.push.HeytapPushManager;
import com.heytap.msp.push.constant.ConfigConstant;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.mode.NotificationSortMessage;
import com.heytap.msp.push.notification.ISortListener;
import com.heytap.msp.push.notification.PushNotification;
import com.heytap.msp.push.statis.StatisticUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class b {
    private int c;
    private int d;
    private int f;
    private int g;
    private StatusBarNotification h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f32618a = 3;
    private List<NotificationSortMessage> b = new ArrayList();
    private List<String> e = new ArrayList();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f32619a = new b();

        private a() {
        }
    }

    private int a(List<NotificationSortMessage> list, int i) {
        int size = list == null ? 0 : list.size();
        if (i <= 0 || size == 0) {
            return i;
        }
        if (size < i) {
            int i2 = i - size;
            list.clear();
            return i2;
        }
        for (int i3 = 0; i3 < i; i3++) {
            list.remove((size - 1) - i3);
        }
        return 0;
    }

    public static b a() {
        return a.f32619a;
    }

    private DataMessage a(Context context, NotificationSortMessage notificationSortMessage) {
        DataMessage dataMessage = new DataMessage(context.getPackageName(), notificationSortMessage.getMessageId());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(d.b.f32616a, AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
            String statisticData = notificationSortMessage.getStatisticData();
            if (!TextUtils.isEmpty(statisticData)) {
                jSONObject.put(d.b.b, statisticData);
            }
            dataMessage.setStatisticsExtra(jSONObject.toString());
        } catch (JSONException unused) {
        }
        return dataMessage;
    }

    private void a(int i) {
        if (i == 7) {
            this.c++;
        } else if (i == 5) {
            this.d++;
        }
    }

    private void a(NotificationManager notificationManager, Context context, int i) {
        a(com.heytap.mcssdk.d.a.a(notificationManager, context.getPackageName()), i);
    }

    private void a(Context context, NotificationManager notificationManager, int i) {
        a(this.b, i);
        a(context, notificationManager, this.b);
    }

    private void a(Context context, NotificationManager notificationManager, List<NotificationSortMessage> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        ArrayList arrayList = new ArrayList();
        a(context, notificationManager, jSONArray, list, arrayList);
        if (jSONArray.length() != 0) {
            try {
                jSONObject.put(d.b.c, jSONArray);
                HeytapPushManager.cancelNotification(jSONObject);
            } catch (JSONException unused) {
            }
        }
        if (arrayList.size() != 0) {
            HashMap map = new HashMap();
            map.put(c.a.d, arrayList);
            StatisticUtils.statisticEvent(context, map);
        }
    }

    private void a(Context context, NotificationManager notificationManager, JSONArray jSONArray, List<NotificationSortMessage> list, List<DataMessage> list2) {
        for (NotificationSortMessage notificationSortMessage : list) {
            if (notificationSortMessage.isMcs()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(ConfigConstant.NotificationSort.EXTRA_MESSAGE_ID, notificationSortMessage.getMessageId());
                    jSONObject.put(ConfigConstant.NotificationSort.EXTRA_NOTIFY_ID, notificationSortMessage.getNotifyId());
                    jSONArray.put(jSONObject);
                } catch (JSONException unused) {
                }
            } else {
                list2.add(a(context, notificationSortMessage));
                this.e.add(notificationSortMessage.getMessageId());
            }
            notificationManager.cancel(notificationSortMessage.getNotifyId());
        }
    }

    private void a(NotificationSortMessage notificationSortMessage) {
        if (notificationSortMessage.getAutoDelete() != 1) {
            return;
        }
        if (this.b.size() != 0) {
            for (int size = this.b.size() - 1; size >= 0; size--) {
                NotificationSortMessage notificationSortMessage2 = this.b.get(size);
                if (notificationSortMessage.getImportantLevel() >= notificationSortMessage2.getImportantLevel() && notificationSortMessage.getPostTime() >= notificationSortMessage2.getPostTime()) {
                    this.b.add(size + 1, notificationSortMessage2);
                    return;
                }
            }
        }
        this.b.add(0, notificationSortMessage);
    }

    private void a(ISortListener iSortListener, boolean z, PushNotification.Builder builder) {
        if (iSortListener != null) {
            iSortListener.buildCompleted(z, builder, this.e);
        }
    }

    private void a(PushNotification.Builder builder, NotificationSortMessage notificationSortMessage) {
        Bundle bundle = new Bundle();
        bundle.putInt(ConfigConstant.NotificationSort.EXTRA_AUTO_DELETE, notificationSortMessage.getAutoDelete());
        bundle.putInt(ConfigConstant.NotificationSort.EXTRA_IMPORTANT_LEVEL, notificationSortMessage.getImportantLevel());
        bundle.putString(ConfigConstant.NotificationSort.EXTRA_MESSAGE_ID, notificationSortMessage.getMessageId());
        bundle.putLong(ConfigConstant.NotificationSort.EXTRA_POST_TIME, System.currentTimeMillis());
        bundle.putBoolean(ConfigConstant.NotificationSort.EXTRA_IS_MCS, false);
        bundle.putString(ConfigConstant.NotificationSort.EXTRA_STATISTIC_DATA, notificationSortMessage.getStatisticData());
        builder.addExtras(bundle);
        builder.setGroup(notificationSortMessage.getGroup());
    }

    private void a(StatusBarNotification[] statusBarNotificationArr, int i) {
        b();
        if (statusBarNotificationArr != null && statusBarNotificationArr.length != 0) {
            for (StatusBarNotification statusBarNotification : statusBarNotificationArr) {
                Bundle bundle = statusBarNotification.getNotification().extras;
                boolean z = bundle.getBoolean(ConfigConstant.NotificationSort.EXTRA_IS_MCS, true);
                long j = bundle.getLong(ConfigConstant.NotificationSort.EXTRA_POST_TIME, statusBarNotification.getPostTime());
                String string = bundle.getString(ConfigConstant.NotificationSort.EXTRA_MESSAGE_ID, "");
                int i2 = bundle.getInt(ConfigConstant.NotificationSort.EXTRA_AUTO_DELETE, 1);
                int i3 = bundle.getInt(ConfigConstant.NotificationSort.EXTRA_IMPORTANT_LEVEL, 5);
                String string2 = bundle.getString(ConfigConstant.NotificationSort.EXTRA_STATISTIC_DATA);
                int id = statusBarNotification.getId();
                if (i == id) {
                    this.h = statusBarNotification;
                    return;
                }
                NotificationSortMessage notificationSortMessage = new NotificationSortMessage(string, i3, i2, z, j, id, string2);
                b(i2);
                a(i3);
                a(notificationSortMessage);
            }
        }
        if (com.heytap.mcssdk.utils.d.g()) {
            com.heytap.mcssdk.utils.d.b("initParams : notDelete:" + this.g + " canDelete : " + this.f + "\n highSize : " + this.c + " normalSize :" + this.d + '\n');
            StringBuilder sb = new StringBuilder("canDeleteList size : ");
            sb.append(this.b.size());
            com.heytap.mcssdk.utils.d.b(sb.toString());
            for (int i4 = 0; i4 < this.b.size(); i4++) {
                NotificationSortMessage notificationSortMessage2 = this.b.get(i4);
                com.heytap.mcssdk.utils.d.b("第" + i4 + "条消息 messageId : " + notificationSortMessage2.getMessageId() + " importanceLevel : " + notificationSortMessage2.getImportantLevel() + " autoDelete : " + notificationSortMessage2.getAutoDelete() + " notifyId: " + notificationSortMessage2.getNotifyId() + " postTime:" + notificationSortMessage2.getPostTime());
            }
        }
    }

    private boolean a(NotificationManager notificationManager, Context context, PushNotification.Builder builder, NotificationSortMessage notificationSortMessage) {
        if (com.heytap.mcssdk.utils.d.g()) {
            com.heytap.mcssdk.utils.d.b("dealCurrentMessage : deleteNumber" + (this.f + this.g) + " keepNumber : " + this.f32618a);
        }
        boolean zA = true;
        if (this.f + this.g < this.f32618a) {
            StringBuilder sb = notificationSortMessage.getAutoDelete() == -1 ? new StringBuilder(d.a.b) : new StringBuilder(d.a.c);
            sb.append(context.getPackageName());
            notificationSortMessage.setGroup(sb.toString());
        } else if (notificationSortMessage.getAutoDelete() == -1) {
            notificationSortMessage.setGroup(d.a.b + context.getPackageName());
            int i = this.f32618a - this.g;
            if (com.heytap.mcssdk.utils.d.g()) {
                com.heytap.mcssdk.utils.d.b("dealCurrentMessage : allowDelete :".concat(String.valueOf(i)));
            }
            if (i > 0) {
                a(context, notificationManager, i - 1);
            } else {
                Notification notificationA = com.heytap.mcssdk.d.a.a(context, notificationSortMessage.getGroup(), builder);
                if (notificationA != null) {
                    notificationManager.notify(4096, notificationA);
                }
            }
        } else {
            zA = a(context, notificationManager, notificationSortMessage);
        }
        if (com.heytap.mcssdk.utils.d.g()) {
            com.heytap.mcssdk.utils.d.b("dealCurrentMessage : needPost :".concat(String.valueOf(zA)));
        }
        if (zA) {
            a(builder, notificationSortMessage);
        } else {
            com.heytap.mcssdk.g.a.a(context, c.a.c, a(context, notificationSortMessage));
        }
        return zA;
    }

    private boolean a(Context context, NotificationManager notificationManager, NotificationSortMessage notificationSortMessage) {
        int i = this.g;
        int i2 = this.f32618a;
        boolean z = false;
        if (i >= i2) {
            return false;
        }
        int i3 = i2 - i;
        if (com.heytap.mcssdk.utils.d.g()) {
            com.heytap.mcssdk.utils.d.b("judgeShowCurrentMessage : allowDelete".concat(String.valueOf(i3)));
        }
        if (notificationSortMessage.getImportantLevel() == 7 || (notificationSortMessage.getImportantLevel() != 5 ? this.c + this.d < i3 : this.c < i3)) {
            z = true;
        }
        if (z) {
            a(context, notificationManager, i3 - 1);
        }
        return z;
    }

    private boolean a(Context context, PushNotification.Builder builder, NotificationSortMessage notificationSortMessage) {
        Notification notification;
        int verifyNotifyId = builder.getVerifyNotifyId();
        StatusBarNotification statusBarNotification = this.h;
        if (statusBarNotification == null || verifyNotifyId == -1 || (notification = statusBarNotification.getNotification()) == null) {
            return false;
        }
        StringBuilder sb = notificationSortMessage.getAutoDelete() == 1 ? new StringBuilder(d.a.c) : new StringBuilder(d.a.b);
        sb.append(context.getPackageName());
        notificationSortMessage.setGroup(sb.toString());
        Bundle bundle = notification.extras;
        if (bundle == null) {
            return false;
        }
        String string = bundle.getString(ConfigConstant.NotificationSort.EXTRA_MESSAGE_ID, "");
        a(builder, notificationSortMessage);
        this.e.add(string);
        return true;
    }

    private boolean a(PushNotification.Builder builder, int i, int i2, String str, String str2) {
        Context context = PushService.getInstance().getContext();
        if (builder == null || context == null) {
            return false;
        }
        NotificationManager notificationManagerA = com.heytap.mcssdk.d.a.a(context);
        NotificationSortMessage notificationSortMessage = new NotificationSortMessage(str, i2, i, false, System.currentTimeMillis(), str2);
        if (!a(context, notificationManagerA, notificationSortMessage, builder)) {
            return true;
        }
        a(notificationManagerA, context, builder.getVerifyNotifyId());
        if (a(context, builder, notificationSortMessage)) {
            return true;
        }
        return a(notificationManagerA, context, builder, notificationSortMessage);
    }

    private void b() {
        this.f = 0;
        this.g = 0;
        this.c = 0;
        this.d = 0;
        this.b.clear();
        this.e.clear();
        this.h = null;
    }

    private void b(int i) {
        if (i == -1) {
            this.g++;
        } else if (i == 1) {
            this.f++;
        }
    }

    public void a(PushNotification.Builder builder, ISortListener iSortListener) {
        if (builder == null) {
            return;
        }
        a(iSortListener, a(builder, builder.getAutoDelete(), builder.getImportantLevel(), builder.getMessageId(), builder.getStatisticData()), builder);
    }

    public boolean a(Context context, NotificationManager notificationManager, NotificationSortMessage notificationSortMessage, PushNotification.Builder builder) {
        if (notificationSortMessage.getAutoDelete() == 0 || Build.VERSION.SDK_INT >= 30) {
            return false;
        }
        if (!com.heytap.mcssdk.d.a.a(notificationManager, context.getPackageName(), 4096)) {
            return true;
        }
        notificationSortMessage.setGroup(d.a.b + context.getPackageName());
        a(builder, notificationSortMessage);
        return false;
    }
}

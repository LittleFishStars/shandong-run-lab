package com.acse.ottn;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.acse.ottn.util.HelpShopAppUtil;
import java.io.ObjectStreamException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class r4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static r4 f23177a;

    public static r4 a() {
        if (f23177a == null) {
            synchronized (r4.class) {
                if (f23177a == null) {
                    f23177a = new r4();
                }
            }
        }
        return f23177a;
    }

    public final Object b() throws ObjectStreamException {
        return f23177a;
    }

    public void b(int i, String str, String str2) {
        if (!l0.d || TextUtils.isEmpty(str2)) {
            return;
        }
        NotificationManager notificationManager = (NotificationManager) HelpShopAppUtil.getContext().getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(new NotificationChannel("1", "重要通知", 4));
        NotificationCompat.Builder builder = new NotificationCompat.Builder(HelpShopAppUtil.getContext(), "1");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("-->");
        sb.append(s0.d().f(System.currentTimeMillis() + ""));
        builder.setContentText(sb.toString()).setContentTitle(str2).setSmallIcon(R.mipmap.up_green).setWhen(System.currentTimeMillis());
        notificationManager.notify(i, builder.build());
    }

    public void a(Context context, String str) {
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.toast_layout, (ViewGroup) null);
        ((LinearLayout) viewInflate.findViewById(R.id.toast_layout)).setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        ((TextView) viewInflate.findViewById(R.id.toast_text)).setText(str);
        Toast toast = new Toast(context);
        toast.setGravity(119, 0, 0);
        toast.setDuration(1);
        toast.setView(viewInflate);
        toast.show();
    }

    public void a(int i, String str, String str2) {
        if (!n3.a().a("click_location_content") || TextUtils.isEmpty(str2)) {
            return;
        }
        NotificationManager notificationManager = (NotificationManager) HelpShopAppUtil.getContext().getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(new NotificationChannel("1", "重要通知", 4));
        NotificationCompat.Builder builder = new NotificationCompat.Builder(HelpShopAppUtil.getContext(), "1");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("-->");
        sb.append(s0.d().f(System.currentTimeMillis() + ""));
        builder.setContentText(sb.toString()).setContentTitle(str2).setSmallIcon(R.mipmap.up_green).setWhen(System.currentTimeMillis());
        notificationManager.notify(i, builder.build());
    }
}

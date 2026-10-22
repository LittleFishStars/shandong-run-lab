package com.zj.adlib;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class f30 implements WorkScheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f41582a = "AlarmManagerScheduler";
    public static final String b = "attemptNumber";
    public static final String c = "backendName";
    public static final String d = "priority";
    public static final String e = "extras";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AlarmManager f16441a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f16442a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SchedulerConfig f16443a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final EventStore f16444a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Clock f16445a;

    public f30(Context context, EventStore eventStore, Clock clock, SchedulerConfig schedulerConfig) {
        this(context, eventStore, (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM), clock, schedulerConfig);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler
    public void a(TransportContext transportContext, int i, boolean z) {
        Uri.Builder builder = new Uri.Builder();
        builder.appendQueryParameter("backendName", transportContext.b());
        builder.appendQueryParameter("priority", String.valueOf(sy6.a(transportContext.d())));
        if (transportContext.c() != null) {
            builder.appendQueryParameter("extras", Base64.encodeToString(transportContext.c(), 0));
        }
        Intent intent = new Intent(this.f16442a, (Class<?>) AlarmManagerSchedulerBroadcastReceiver.class);
        intent.setData(builder.build());
        intent.putExtra("attemptNumber", i);
        if (!z && c(intent)) {
            h25.b(f41582a, "Upload for context %s is already scheduled. Returning...", transportContext);
            return;
        }
        long jT = this.f16444a.t(transportContext);
        long jH = this.f16443a.h(transportContext.d(), jT, i);
        h25.d(f41582a, "Scheduling upload for context %s in %dms(Backend next call timestamp %d). Attempt %d", transportContext, Long.valueOf(jH), Long.valueOf(jT), Integer.valueOf(i));
        this.f16441a.set(3, this.f16445a.getTime() + jH, PendingIntent.getBroadcast(this.f16442a, 0, intent, 0));
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler
    public void b(TransportContext transportContext, int i) {
        a(transportContext, i, false);
    }

    @VisibleForTesting
    public boolean c(Intent intent) {
        return PendingIntent.getBroadcast(this.f16442a, 0, intent, 536870912) != null;
    }

    @VisibleForTesting
    public f30(Context context, EventStore eventStore, AlarmManager alarmManager, Clock clock, SchedulerConfig schedulerConfig) {
        this.f16442a = context;
        this.f16444a = eventStore;
        this.f16441a = alarmManager;
        this.f16445a = clock;
        this.f16443a = schedulerConfig;
    }
}

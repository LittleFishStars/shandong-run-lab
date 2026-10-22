package com.beizi.fusion;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.events.EventCar;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.Manager;
import com.beizi.fusion.model.ResponseInfo;
import com.beizi.fusion.model.TaskBean;
import com.beizi.fusion.model.TaskConfig;
import com.beizi.fusion.widget.JSView;
import com.beizi.fusion.widget.LandingView;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class f9 {
    private static Context i = null;
    private static ResponseInfo j = null;
    private static TaskBean k = null;
    private static boolean l = false;
    private static boolean m = false;
    private static f9 n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ScheduledExecutorService f27287a;
    private long b;
    private long c;
    private long d;
    private final b e;
    private ScheduledExecutorService f;
    private ScheduledExecutorService g;
    private boolean h = true;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f27288a;

        /* JADX INFO: renamed from: com.beizi.fusion.f9$a$a, reason: collision with other inner class name */
        public class RunnableC0309a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f27289a;
            final /* synthetic */ TaskBean.BackTaskArrayBean b;

            public RunnableC0309a(int i, TaskBean.BackTaskArrayBean backTaskArrayBean) {
                this.f27289a = i;
                this.b = backTaskArrayBean;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i = this.f27289a;
                if (i == 8) {
                    v3.b().e().execute(new r2(f9.i, this.b));
                    return;
                }
                if (i == 1) {
                    v3.b().f().execute(new vo(f9.i, this.b));
                    return;
                }
                if (i == 2) {
                    i5.a(f9.i).a(this.b);
                    return;
                }
                if (i == 3) {
                    jq.a(f9.i);
                    new LandingView(f9.i, this.b).load();
                } else {
                    if (i != 4) {
                        return;
                    }
                    jq.a(f9.i);
                    new JSView(f9.i, this.b).load();
                }
            }
        }

        public a(int i) {
            this.f27288a = i;
        }

        private void a() {
            long j;
            TaskBean taskBean = f9.k;
            if (taskBean != null) {
                long expired = taskBean.getExpired();
                long jCurrentTimeMillis = System.currentTimeMillis();
                List<TaskBean.BackTaskArrayBean> backTaskArray = f9.k.getBackTaskArray();
                if (backTaskArray != null && backTaskArray.size() > 0) {
                    EventCar.getInstance(f9.i).goRoadWithoutThread(new EventBean(q1.u, "", "500.200", "", q1.h().b(), "", "", String.valueOf(System.currentTimeMillis()), "", String.valueOf(backTaskArray.size())));
                    int i = 0;
                    while (i < backTaskArray.size()) {
                        if (System.currentTimeMillis() - jCurrentTimeMillis > expired) {
                            j = expired;
                            EventCar.getInstance(f9.i).goRoadWithoutThread(new EventBean(q1.u, "", "530.500", "", q1.h().b(), "", "", String.valueOf(System.currentTimeMillis()), "", String.valueOf(backTaskArray.size() - i)));
                        } else {
                            j = expired;
                            TaskBean.BackTaskArrayBean backTaskArrayBean = backTaskArray.get(i);
                            f9.this.e.post(new RunnableC0309a(backTaskArrayBean.getType(), backTaskArrayBean));
                            try {
                                Thread.sleep(backTaskArrayBean.getSleepTime());
                            } catch (InterruptedException unused) {
                            }
                        }
                        i++;
                        expired = j;
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            TaskConfig taskConfig;
            int i = this.f27288a;
            if (i == 2) {
                if (!f9.this.a().booleanValue()) {
                    f9.this.h = false;
                    EventCar.getInstance(f9.i).goRoad(new EventBean(q1.u, "", "310.210", "", q1.h().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                    return;
                }
                if (f9.this.h || !q1.h().p() || so.o(f9.i)) {
                    f9.this.h = false;
                    Log.d("BeiZis", "config is expire:" + Thread.currentThread().getName());
                    Message message = new Message();
                    message.what = 1;
                    message.arg1 = 1;
                    f9.this.e.sendMessage(message);
                    EventCar.getInstance(f9.i).goRoad(new EventBean(q1.u, "", "310.200", "", q1.h().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                    return;
                }
                return;
            }
            if (i == 3) {
                EventCar.getInstance(f9.i).doUpLoadLogs();
                return;
            }
            if (i != 4) {
                if (i != 5) {
                    return;
                }
                Log.d("BeiZis", "config is expire:" + Thread.currentThread().getName());
                Message message2 = new Message();
                message2.what = 1;
                message2.arg1 = 5;
                f9.this.e.sendMessage(message2);
                EventCar.getInstance(f9.i).goRoad(new EventBean(q1.u, "", "310.200", "", q1.h().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                return;
            }
            Log.d("BeiZis", "taskConfig:" + Thread.currentThread().getName());
            if (f9.j.getTaskConfig() == null || (taskConfig = f9.j.getTaskConfig()) == null || taskConfig.getUrl() == null) {
                return;
            }
            String strA = m9.a(f9.i, taskConfig.getUrl(), q1.h().b(), Boolean.TRUE);
            if (TextUtils.isEmpty(strA) || strA.length() <= 0) {
                return;
            }
            try {
                String strOptString = new JSONObject(strA).optString("data");
                if (TextUtils.isEmpty(strOptString) || strOptString.equals("null")) {
                    return;
                }
                String strA2 = i2.a(qg.b(), strOptString);
                if (TextUtils.isEmpty(strA2)) {
                    return;
                }
                TaskBean taskBeanObjectFromData = TaskBean.objectFromData(strA2);
                f9.k = taskBeanObjectFromData;
                if (taskBeanObjectFromData != null) {
                    a();
                }
            } catch (Exception unused) {
            }
        }
    }

    public static class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference f27290a;

        public b(f9 f9Var) {
            super(Looper.getMainLooper());
            this.f27290a = new WeakReference(f9Var);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (f9.m) {
                return;
            }
            f9.m = true;
            try {
                f9 f9Var = (f9) this.f27290a.get();
                if (f9Var == null) {
                    f9.m = false;
                    return;
                }
                g9 g9Var = new g9(f9.i, f9Var);
                if (f9.j.getConfigurator() != null) {
                    g9Var.executeOnExecutor(v3.b().c(), f9.j.getConfigurator().getConfigUrl());
                } else {
                    g9Var.executeOnExecutor(v3.b().c(), new String[0]);
                }
            } catch (RejectedExecutionException | Exception unused) {
            }
        }
    }

    private f9(Context context) {
        this.b = 60000L;
        this.c = 60000L;
        this.d = 0L;
        i = context.getApplicationContext();
        this.e = new b(this);
        if (j == null) {
            ResponseInfo responseInfo = ResponseInfo.getInstance(i);
            j = responseInfo;
            if (!responseInfo.isInit()) {
                j.init();
            }
            if (j.getConfigurator() != null) {
                long checkInterval = j.getConfigurator().getCheckInterval();
                if (checkInterval != 0) {
                    this.b = checkInterval;
                }
            }
            if (j.getMessenger() != null) {
                long checkInterval2 = j.getMessenger().getCheckInterval();
                if (checkInterval2 != 0) {
                    this.c = checkInterval2;
                }
            }
            if (j.getTaskConfig() != null) {
                long checkInterval3 = j.getTaskConfig().getCheckInterval();
                if (checkInterval3 != 0) {
                    this.d = checkInterval3;
                }
            }
        }
    }

    private void c(int i2) {
        fh fhVarA = fh.a(i);
        Intent intent = new Intent("com.ad.action.UPDATE_CONFIG_SUCCESS");
        intent.putExtra("updateResult", i2);
        fhVarA.a(intent);
    }

    public void a(Object obj) {
        Log.d("BeiZis", "heartbeat logSuccess!");
        if (((e9) obj) != null) {
            ResponseInfo responseInfo = ResponseInfo.getInstance(i);
            j = responseInfo;
            responseInfo.init();
            if (l) {
                c(1);
                l = false;
            }
            EventCar.getInstance(i).goRoad(new EventBean(q1.u, "", "320.200", "", q1.h().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        }
        m = false;
    }

    public void b(int i2) {
        b();
        if (i2 != 0) {
            if (i2 != 5) {
                return;
            }
            Log.d("BeiZis", "heartbeatTime:" + this.b);
            l = true;
            if (!m) {
                Message message = new Message();
                message.what = 1;
                message.arg1 = 5;
                this.e.sendMessage(message);
            }
            EventCar.getInstance(i).goRoad(new EventBean(q1.u, "", "310.200", "", q1.h().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            return;
        }
        Log.d("BeiZis", this.b + ":heartbeatTime=============start===================:logCheckTime:" + this.c);
        ScheduledExecutorService scheduledExecutorService = this.f27287a;
        a aVar = new a(2);
        long j2 = this.b;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        scheduledExecutorService.scheduleWithFixedDelay(aVar, 0L, j2, timeUnit);
        this.f.scheduleWithFixedDelay(new a(3), 0L, this.c, timeUnit);
        ScheduledExecutorService scheduledExecutorService2 = this.g;
        if (scheduledExecutorService2 != null && this.d != 0) {
            scheduledExecutorService2.scheduleWithFixedDelay(new a(4), 0L, this.d, timeUnit);
            EventCar.getInstance(i).goRoad(new EventBean(q1.u, "", "500.000", "", q1.h().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        }
        EventCar.getInstance(i).goRoad(new EventBean(q1.u, "", "300.000", "", q1.h().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
    }

    public void a(int i2) {
        Log.d("BeiZis", "heartbeat fail:" + i2);
        if (l) {
            c(0);
            l = false;
        }
        EventCar.getInstance(i).goRoad(new EventBean(q1.u, "", "320.500", "", q1.h().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        m = false;
    }

    public static synchronized f9 a(Context context) {
        if (n == null) {
            n = new f9(context);
        }
        return n;
    }

    private void b() {
        if (this.f27287a == null) {
            this.f27287a = Executors.newScheduledThreadPool(2);
        }
        if (this.f == null) {
            this.f = Executors.newScheduledThreadPool(2);
        }
        if (this.g != null || this.d == 0) {
            return;
        }
        this.g = Executors.newScheduledThreadPool(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean a() {
        Manager manager = j.getManager();
        if (manager != null) {
            List<AdSpacesBean> adSpaces = manager.getAdSpaces();
            if (adSpaces == null) {
                return Boolean.TRUE;
            }
            if (adSpaces.size() == 0) {
                return Boolean.TRUE;
            }
            String strB = q1.h().b();
            AdSpacesBean adSpacesBean = adSpaces.get(0);
            if (!strB.equals(adSpacesBean.getAppId())) {
                return Boolean.TRUE;
            }
            if (adSpacesBean.getComponent() == null) {
                return Boolean.TRUE;
            }
            if (j.getConfigurator() != null) {
                long jLongValue = ((Long) co.a(i, "lastUpdateTime", (Object) Long.valueOf(new Date(0L).getTime()))).longValue();
                long expireTime = j.getExpireTime();
                long maxValidTime = j.getMaxValidTime();
                if (maxValidTime == 0) {
                    maxValidTime = 2592000000L;
                }
                long jCurrentTimeMillis = System.currentTimeMillis() - jLongValue;
                return Boolean.valueOf(jCurrentTimeMillis > expireTime || jCurrentTimeMillis > maxValidTime);
            }
            Log.d("BeiZis", "first launch and heartConfig is null return true!");
            return Boolean.TRUE;
        }
        return Boolean.TRUE;
    }
}

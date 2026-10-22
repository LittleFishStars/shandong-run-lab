package com.huachenjie.common.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.alibaba.android.arouter.core.LogisticsCenter;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.launcher.ARouter;
import com.byazt.hv.TTDownloadField;
import com.huachenjie.common.base.SideTextInterface;
import com.imuxuan.floatingview.a;
import com.zj.adlib.ai9;
import com.zj.adlib.fx7;
import com.zj.adlib.t26;
import com.zj.adlib.ys8;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ActivityLifecycleManager implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ActivityLifecycleManager f33901a;
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LinkedList<Activity> f8885a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<BackgroundNotifyInterface> f8886a = new ArrayList();

    public interface BackgroundNotifyInterface {
        default void a() {
        }

        void onToBackGround();

        void onToForeGround();
    }

    public static TextView b(Activity activity, String text, int sideTextColor) {
        if (TextUtils.isEmpty(text)) {
            text = k();
        }
        int iMin = Math.min(fx7.c(), fx7.e());
        TextView textView = new TextView(activity);
        textView.setTextSize(1, 10.0f);
        textView.setTypeface(null, 1);
        textView.setIncludeFontPadding(false);
        textView.setGravity(81);
        textView.setText(text);
        textView.setTextColor(sideTextColor);
        textView.setRotation(90.0f);
        textView.setIncludeFontPadding(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iMin, iMin);
        layoutParams.gravity = 17;
        activity.addContentView(textView, layoutParams);
        return textView;
    }

    public static String k() {
        String alumniId = ai9.e().getAlumniId();
        return !TextUtils.isEmpty(alumniId) ? ys8.c("%s %s", alumniId, "8.7.7") : "8.7.7";
    }

    public static ActivityLifecycleManager l() {
        if (f33901a == null) {
            f33901a = new ActivityLifecycleManager();
        }
        return f33901a;
    }

    public void a(Context context) {
        try {
            try {
                h();
                if (context != null) {
                    ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).killBackgroundProcesses(context.getPackageName());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            Process.killProcess(Process.myPid());
            System.exit(0);
        }
    }

    public Activity c(Class<?> cls) {
        LinkedList<Activity> linkedList = this.f8885a;
        if (linkedList == null || linkedList.isEmpty()) {
            return null;
        }
        for (Activity activity : this.f8885a) {
            if (activity.getClass().equals(cls)) {
                return activity;
            }
        }
        return null;
    }

    public Activity d(String path) {
        Class clsO = o(path);
        if (clsO == null) {
            return null;
        }
        return c(clsO);
    }

    public void e(Activity activity) {
        LinkedList<Activity> linkedList = this.f8885a;
        if (linkedList == null || linkedList.isEmpty() || activity == null) {
            return;
        }
        this.f8885a.remove(activity);
        activity.finish();
    }

    public void f(Class<?> cls) {
        LinkedList<Activity> linkedList = this.f8885a;
        if (linkedList == null || linkedList.isEmpty()) {
            return;
        }
        Iterator<Activity> it = this.f8885a.iterator();
        while (it.hasNext()) {
            Activity next = it.next();
            if (next != null && next.getClass().equals(cls)) {
                next.finish();
                it.remove();
            }
        }
    }

    public void g(String path) {
        Class clsO = o(path);
        if (clsO != null) {
            f(clsO);
        }
    }

    public void h() {
        try {
            LinkedList<Activity> linkedList = this.f8885a;
            if (linkedList == null) {
                return;
            }
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                if (this.f8885a.get(i) != null) {
                    try {
                        this.f8885a.get(i).finish();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            this.f8885a.clear();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void i(Class<?> cls) {
        try {
            LinkedList<Activity> linkedList = this.f8885a;
            if (linkedList == null) {
                return;
            }
            for (int size = linkedList.size() - 1; size >= 0; size--) {
                Activity activity = this.f8885a.get(size);
                if (activity != null && !activity.getClass().equals(cls)) {
                    try {
                        this.f8885a.remove(size);
                        activity.finish();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void j(String path) {
        Class clsO = o(path);
        if (clsO != null) {
            i(clsO);
        }
    }

    public Activity m() {
        LinkedList<Activity> linkedList = this.f8885a;
        if (linkedList == null || linkedList.isEmpty()) {
            return null;
        }
        return this.f8885a.getLast();
    }

    public void n(BackgroundNotifyInterface backgroundNotifyInterface) {
        this.f8886a.remove(backgroundNotifyInterface);
    }

    public final Class o(String path) {
        try {
            Postcard postcardBuild = ARouter.getInstance().build(path);
            LogisticsCenter.completion(postcardBuild);
            return postcardBuild.getDestination();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        if (this.f8885a == null) {
            this.f8885a = new LinkedList<>();
        }
        this.f8885a.add(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        LinkedList<Activity> linkedList = this.f8885a;
        if (linkedList != null && !linkedList.isEmpty()) {
            this.f8885a.remove(activity);
        }
        LinkedList<Activity> linkedList2 = this.f8885a;
        if (linkedList2 == null || linkedList2.isEmpty()) {
            Iterator<BackgroundNotifyInterface> it = this.f8886a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        int i = this.K + 1;
        this.K = i;
        if (i == 1) {
            for (BackgroundNotifyInterface backgroundNotifyInterface : this.f8886a) {
                if (backgroundNotifyInterface != null) {
                    backgroundNotifyInterface.onToForeGround();
                }
            }
            t26.f44833a.b(activity, 1236);
        }
        try {
            a.r().a(activity);
            if (activity instanceof SideTextInterface) {
                SideTextInterface sideTextInterface = (SideTextInterface) activity;
                if (sideTextInterface.s() && sideTextInterface.p() == null) {
                    sideTextInterface.q(b(activity, sideTextInterface.H(), sideTextInterface.C()));
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        int i = this.K - 1;
        this.K = i;
        if (i == 0) {
            for (BackgroundNotifyInterface backgroundNotifyInterface : this.f8886a) {
                if (backgroundNotifyInterface != null) {
                    backgroundNotifyInterface.onToBackGround();
                }
            }
        }
        try {
            a.r().d(activity);
        } catch (Exception unused) {
        }
    }

    public void p(BackgroundNotifyInterface backgroundNotifyInterface) {
        this.f8886a.add(backgroundNotifyInterface);
    }

    public Activity q() {
        LinkedList<Activity> linkedList = this.f8885a;
        if (linkedList == null || linkedList.isEmpty()) {
            return null;
        }
        if (this.f8885a.size() == 1) {
            return this.f8885a.getLast();
        }
        LinkedList<Activity> linkedList2 = this.f8885a;
        return linkedList2.get(linkedList2.size() - 2);
    }
}

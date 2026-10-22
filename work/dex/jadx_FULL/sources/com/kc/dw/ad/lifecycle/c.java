package com.kc.dw.ad.lifecycle;

import android.app.Activity;
import android.app.FragmentManager;
import androidx.fragment.app.FragmentActivity;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f39122a = c.class.getName();
    public Activity b;

    public void a(d dVar) {
        try {
            Activity activity = this.b;
            if (activity == null) {
                LogUtil.e(this.f39122a, "setLifecycleListener: ", new Exception("View Context非Activity"));
                return;
            }
            if (!(activity instanceof FragmentActivity)) {
                int i = a.b;
                FragmentManager fragmentManager = activity.getFragmentManager();
                a aVar = (a) fragmentManager.findFragmentByTag("LifecycleFragment");
                if (aVar == null && !activity.isFinishing()) {
                    aVar = new a();
                    fragmentManager.beginTransaction().add(aVar, "LifecycleFragment").commitAllowingStateLoss();
                }
                if (aVar != null) {
                    aVar.f39120a = dVar;
                    return;
                }
                return;
            }
            FragmentActivity fragmentActivity = (FragmentActivity) activity;
            int i2 = b.b;
            androidx.fragment.app.FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            b bVar = (b) supportFragmentManager.findFragmentByTag("LifecycleFragment_V4");
            if (bVar == null && !fragmentActivity.isFinishing()) {
                bVar = new b();
                supportFragmentManager.beginTransaction().add(bVar, "LifecycleFragment_V4").commitAllowingStateLoss();
            }
            if (bVar != null) {
                bVar.f39121a = dVar;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

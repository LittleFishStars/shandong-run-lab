package com.fl.saas.base.adapter;

import android.os.Looper;
import android.os.MessageQueue;
import com.fl.saas.base.adapter.AdapterManager;
import com.fl.saas.base.annotation.Advertiser;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import java.util.Iterator;
import java.util.ServiceLoader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AdapterManager {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$preInitAdapter$0() {
        Iterator it = ServiceLoader.load(AdapterPreInitialize.class, DeviceUtil.getContext().getClassLoader()).iterator();
        while (true) {
            if (!it.hasNext()) {
                return false;
            }
            try {
                AdapterPreInitialize adapterPreInitialize = (AdapterPreInitialize) it.next();
                Advertiser advertiser = (Advertiser) adapterPreInitialize.getClass().getAnnotation(Advertiser.class);
                if (advertiser != null) {
                    try {
                        for (Class<?> cls : advertiser.keyClass()) {
                            if (cls != Object.class) {
                                LogcatUtil.d(cls.toString());
                            }
                        }
                        adapterPreInitialize.preInit(DeviceUtil.getContext());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    adapterPreInitialize.preInit(DeviceUtil.getContext());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void preInitAdapter() {
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.zj.adlib.t00
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                return AdapterManager.lambda$preInitAdapter$0();
            }
        });
    }
}

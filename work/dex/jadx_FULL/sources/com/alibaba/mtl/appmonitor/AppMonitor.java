package com.alibaba.mtl.appmonitor;

import android.app.Application;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.camera.video.AudioStats;
import com.alibaba.analytics.AnalyticsMgr;
import com.alibaba.analytics.IAnalytics;
import com.alibaba.analytics.a.j;
import com.alibaba.appmonitor.event.EventType;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class AppMonitor {

    @Deprecated
    public static class OffLineCounter {
        public static boolean checkSampled(String str, String str2) {
            return false;
        }

        public static void commit(String str, String str2, double d) {
            Counter.commit(str, str2, d);
        }

        public static void setSampling(int i) {
        }

        public static void setStatisticsInterval(int i) {
        }
    }

    public static class Stat {
        public static void begin(final String str, final String str2, final String str3) {
            if (AppMonitor.a()) {
                AnalyticsMgr.f601a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Stat.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AnalyticsMgr.f602a.b(str, str2, str3);
                        } catch (RemoteException e) {
                            AnalyticsMgr.a(e);
                        }
                    }
                });
            }
        }

        public static boolean checkSampled(String str, String str2) {
            IAnalytics iAnalytics = AnalyticsMgr.f602a;
            if (iAnalytics == null) {
                return false;
            }
            try {
                return iAnalytics.d(str, str2);
            } catch (RemoteException unused) {
                return false;
            }
        }

        public static void commit(String str, String str2, double d) {
            commit(str, str2, (DimensionValueSet) null, d);
        }

        public static Transaction createTransaction(String str, String str2) {
            return createTransaction(str, str2, null);
        }

        public static void end(final String str, final String str2, final String str3) {
            if (AppMonitor.a()) {
                AnalyticsMgr.f601a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Stat.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AnalyticsMgr.f602a.c(str, str2, str3);
                        } catch (RemoteException e) {
                            AnalyticsMgr.a(e);
                        }
                    }
                });
            }
        }

        public static void setSampling(final int i) {
            if (AppMonitor.a()) {
                AnalyticsMgr.f601a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Stat.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AnalyticsMgr.f602a.i(i);
                        } catch (RemoteException e) {
                            AnalyticsMgr.a(e);
                        }
                    }
                });
            }
        }

        public static void setStatisticsInterval(final int i) {
            if (AppMonitor.a()) {
                AnalyticsMgr.f601a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Stat.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AnalyticsMgr.f602a.h(i);
                        } catch (RemoteException e) {
                            AnalyticsMgr.a(e);
                        }
                    }
                });
            }
        }

        public static void commit(final String str, final String str2, final DimensionValueSet dimensionValueSet, final double d) {
            if (AppMonitor.a()) {
                AnalyticsMgr.f601a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Stat.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AnalyticsMgr.f602a.a(str, str2, dimensionValueSet, d);
                        } catch (RemoteException e) {
                            AnalyticsMgr.a(e);
                        }
                    }
                });
            }
        }

        public static Transaction createTransaction(String str, String str2, DimensionValueSet dimensionValueSet) {
            return new Transaction(Integer.valueOf(EventType.STAT.getEventId()), str, str2, dimensionValueSet);
        }

        public static void commit(final String str, final String str2, final DimensionValueSet dimensionValueSet, final MeasureValueSet measureValueSet) {
            if (AppMonitor.a()) {
                AnalyticsMgr.f601a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Stat.6
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AnalyticsMgr.f602a.a(str, str2, dimensionValueSet, measureValueSet);
                        } catch (RemoteException e) {
                            AnalyticsMgr.a(e);
                        }
                    }
                });
            }
        }

        public static void commit(String str, String str2, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
            DimensionValueSet dimensionValueSetCreate;
            double dDoubleValue;
            j.d("[commit from jni]", new Object[0]);
            MeasureValueSet measureValueSetCreate = null;
            if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
                dimensionValueSetCreate = null;
            } else {
                dimensionValueSetCreate = DimensionValueSet.create();
                for (int i = 0; i < strArr2.length; i++) {
                    dimensionValueSetCreate.setValue(strArr[i], strArr2[i]);
                }
            }
            if (strArr3 != null && strArr4 != null && strArr3.length == strArr4.length) {
                measureValueSetCreate = MeasureValueSet.create();
                for (int i2 = 0; i2 < strArr4.length; i2++) {
                    if (TextUtils.isEmpty(strArr4[i2])) {
                        dDoubleValue = AudioStats.AUDIO_AMPLITUDE_NONE;
                    } else {
                        try {
                            dDoubleValue = Double.valueOf(strArr4[i2]).doubleValue();
                        } catch (Exception unused) {
                            j.d("measure's value cannot convert to double. measurevalue:" + strArr4[i2], new Object[0]);
                            dDoubleValue = AudioStats.AUDIO_AMPLITUDE_NONE;
                        }
                    }
                    measureValueSetCreate.setValue(strArr3[i2], dDoubleValue);
                }
            } else {
                j.d("measure is null ,or lenght not match", new Object[0]);
            }
            commit(str, str2, dimensionValueSetCreate, measureValueSetCreate);
        }
    }

    private static void a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z, boolean z2) {
        if (a()) {
            j.d("AppMonitor", "[registerInternal] : module:", str, "monitorPoint:", str2, "measures:", measureSet, "dimensions:", dimensionSet, "isCommitDetail:", Boolean.valueOf(z), "isInternal:", Boolean.valueOf(z2));
            if (!z2) {
                b(str, str2, measureSet, dimensionSet, z);
            }
            AnalyticsMgr.f601a.a(a(str, str2, measureSet, dimensionSet, z));
        }
    }

    private static void b(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        try {
            AnalyticsMgr.a aVar = new AnalyticsMgr.a();
            aVar.module = str;
            aVar.monitorPoint = str2;
            aVar.f618b = measureSet;
            aVar.b = dimensionSet;
            aVar.k = z;
            AnalyticsMgr.f605a.add(aVar);
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    public static synchronized void destroy() {
    }

    public static void enableLog(final boolean z) {
        if (a()) {
            AnalyticsMgr.f601a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AnalyticsMgr.f602a.enableLog(z);
                    } catch (RemoteException e) {
                        AnalyticsMgr.a(e);
                    }
                }
            });
        }
    }

    public static String getGlobalProperty(String str) {
        return AnalyticsMgr.getGlobalProperty(str);
    }

    @Deprecated
    public static synchronized void init(Application application) {
        AnalyticsMgr.init(application);
    }

    public static void register(final String str, final String str2, final MeasureSet measureSet) {
        if (a()) {
            AnalyticsMgr.f601a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AnalyticsMgr.f602a.a(str, str2, measureSet);
                    } catch (RemoteException e) {
                        AnalyticsMgr.a(e);
                    }
                }
            });
            b(str, str2, measureSet, null, false);
        }
    }

    public static void removeGlobalProperty(String str) {
        AnalyticsMgr.removeGlobalProperty(str);
    }

    @Deprecated
    public static void setChannel(String str) {
        AnalyticsMgr.m85a(str);
    }

    public static void setGlobalProperty(String str, String str2) {
        AnalyticsMgr.setGlobalProperty(str, str2);
    }

    @Deprecated
    public static void setRequestAuthInfo(boolean z, String str, String str2) {
        throw new RuntimeException("this interface is deprecated after sdk version 6.3.0，please call Analytics.getInstance().setAppApplicationInstance(Application application,IUTApplication utcallback) ");
    }

    public static void setSampling(final int i) {
        if (a()) {
            AnalyticsMgr.f601a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AnalyticsMgr.f602a.setSampling(i);
                    } catch (RemoteException e) {
                        AnalyticsMgr.a(e);
                    }
                }
            });
        }
    }

    public static void setStatisticsInterval(final int i) {
        if (a()) {
            AnalyticsMgr.f601a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AnalyticsMgr.f602a.g(i);
                    } catch (RemoteException e) {
                        AnalyticsMgr.a(e);
                    }
                }
            });
        }
    }

    @Deprecated
    public static synchronized void triggerUpload() {
    }

    @Deprecated
    public static void turnOffRealTimeDebug() {
        AnalyticsMgr.turnOffRealTimeDebug();
    }

    @Deprecated
    public static void turnOnRealTimeDebug(Map<String, String> map) {
        AnalyticsMgr.turnOnRealTimeDebug(map);
    }

    public static void updateMeasure(final String str, final String str2, final String str3, final double d, final double d2, final double d3) {
        j.d("AppMonitor", "[updateMeasure]");
        if (a()) {
            AnalyticsMgr.f601a.post(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AnalyticsMgr.f602a.updateMeasure(str, str2, str3, d, d2, d3);
                    } catch (RemoteException e) {
                        AnalyticsMgr.a(e);
                    }
                }
            });
        }
    }

    public static class Alarm {
        @Deprecated
        public static boolean checkSampled(String str, String str2) {
            IAnalytics iAnalytics = AnalyticsMgr.f602a;
            if (iAnalytics == null) {
                return false;
            }
            try {
                return iAnalytics.b(str, str2);
            } catch (RemoteException unused) {
                return false;
            }
        }

        public static void commitFail(final String str, final String str2, final String str3, final String str4) {
            if (AppMonitor.a()) {
                AnalyticsMgr.f601a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Alarm.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AnalyticsMgr.f602a.a(str, str2, str3, str4);
                        } catch (RemoteException e) {
                            AnalyticsMgr.a(e);
                        }
                    }
                });
            }
        }

        public static void commitSuccess(final String str, final String str2) {
            if (AppMonitor.a()) {
                AnalyticsMgr.f601a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Alarm.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AnalyticsMgr.f602a.a(str, str2);
                        } catch (RemoteException e) {
                            AnalyticsMgr.a(e);
                        }
                    }
                });
            }
        }

        public static void setSampling(final int i) {
            if (AppMonitor.a()) {
                AnalyticsMgr.f601a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Alarm.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AnalyticsMgr.f602a.d(i);
                        } catch (RemoteException e) {
                            AnalyticsMgr.a(e);
                        }
                    }
                });
            }
        }

        public static void setStatisticsInterval(final int i) {
            if (AppMonitor.a()) {
                AnalyticsMgr.f601a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Alarm.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AnalyticsMgr.f602a.c(i);
                        } catch (RemoteException e) {
                            AnalyticsMgr.a(e);
                        }
                    }
                });
            }
        }

        public static void commitFail(final String str, final String str2, final String str3, final String str4, final String str5) {
            if (AppMonitor.a()) {
                AnalyticsMgr.f601a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Alarm.6
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AnalyticsMgr.f602a.a(str, str2, str3, str4, str5);
                        } catch (RemoteException e) {
                            AnalyticsMgr.a(e);
                        }
                    }
                });
            }
        }

        public static void commitSuccess(final String str, final String str2, final String str3) {
            if (AppMonitor.a()) {
                AnalyticsMgr.f601a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Alarm.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AnalyticsMgr.f602a.a(str, str2, str3);
                        } catch (RemoteException e) {
                            AnalyticsMgr.a(e);
                        }
                    }
                });
            }
        }
    }

    public static class Counter {
        @Deprecated
        public static boolean checkSampled(String str, String str2) {
            IAnalytics iAnalytics = AnalyticsMgr.f602a;
            if (iAnalytics == null) {
                return false;
            }
            try {
                return iAnalytics.mo81a(str, str2);
            } catch (RemoteException unused) {
                return false;
            }
        }

        public static void commit(final String str, final String str2, final double d) {
            if (AppMonitor.a()) {
                AnalyticsMgr.f601a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Counter.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AnalyticsMgr.f602a.a(str, str2, d);
                        } catch (RemoteException e) {
                            AnalyticsMgr.a(e);
                        }
                    }
                });
            }
        }

        public static void setSampling(final int i) {
            if (AppMonitor.a()) {
                AnalyticsMgr.f601a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Counter.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AnalyticsMgr.f602a.b(i);
                        } catch (RemoteException e) {
                            AnalyticsMgr.a(e);
                        }
                    }
                });
            }
        }

        public static void setStatisticsInterval(final int i) {
            if (AppMonitor.a()) {
                AnalyticsMgr.f601a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Counter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AnalyticsMgr.f602a.a(i);
                        } catch (RemoteException e) {
                            AnalyticsMgr.a(e);
                        }
                    }
                });
            }
        }

        public static void commit(final String str, final String str2, final String str3, final double d) {
            if (AppMonitor.a()) {
                AnalyticsMgr.f601a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.Counter.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AnalyticsMgr.f602a.a(str, str2, str3, d);
                        } catch (RemoteException e) {
                            AnalyticsMgr.a(e);
                        }
                    }
                });
            }
        }
    }

    public static void setStatisticsInterval(EventType eventType, final int i) {
        if (a()) {
            final int iA = a(eventType);
            AnalyticsMgr.f601a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AnalyticsMgr.f602a.a(iA, i);
                    } catch (RemoteException e) {
                        AnalyticsMgr.a(e);
                    }
                }
            });
        }
    }

    public static void register(final String str, final String str2, final MeasureSet measureSet, final boolean z) {
        if (a()) {
            AnalyticsMgr.f601a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AnalyticsMgr.f602a.a(str, str2, measureSet, z);
                    } catch (RemoteException e) {
                        AnalyticsMgr.a(e);
                    }
                }
            });
            b(str, str2, measureSet, null, z);
        }
    }

    private static int a(EventType eventType) {
        return eventType.getEventId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a() {
        if (!AnalyticsMgr.f607a) {
            j.d("AppMonitor", "Please call init() before call other method");
        }
        return AnalyticsMgr.f607a;
    }

    public static void register(final String str, final String str2, final MeasureSet measureSet, final DimensionSet dimensionSet) {
        j.d("外注册任务被业务方调用", "module", str, "monitorPoint", str2);
        if (a()) {
            AnalyticsMgr.f601a.a(new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        j.d("外注册任务开始执行", "module", str, "monitorPoint", str2);
                        AnalyticsMgr.f602a.a(str, str2, measureSet, dimensionSet);
                    } catch (RemoteException e) {
                        AnalyticsMgr.a(e);
                    }
                }
            });
            b(str, str2, measureSet, dimensionSet, false);
        }
    }

    private static Runnable a(final String str, final String str2, final MeasureSet measureSet, final DimensionSet dimensionSet, final boolean z) {
        return new Runnable() { // from class: com.alibaba.mtl.appmonitor.AppMonitor.9
            @Override // java.lang.Runnable
            public void run() {
                try {
                    j.d("AppMonitor", "register stat event. module: ", str, " monitorPoint: ", str2);
                    AnalyticsMgr.f602a.a(str, str2, measureSet, dimensionSet, z);
                } catch (RemoteException e) {
                    AnalyticsMgr.a(e);
                }
            }
        };
    }

    public static void register(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        if (a()) {
            a(str, str2, measureSet, dimensionSet, z, false);
        }
    }

    public static void register(String str, String str2, String[] strArr, String[] strArr2, boolean z) {
        DimensionSet dimensionSetCreate;
        j.d("AppMonitor", "[c interface] module", str, "monitorPoint", str2);
        if (strArr != null) {
            MeasureSet measureSetCreate = MeasureSet.create();
            for (String str3 : strArr) {
                measureSetCreate.addMeasure(str3);
            }
            if (strArr2 != null) {
                dimensionSetCreate = DimensionSet.create();
                for (String str4 : strArr2) {
                    dimensionSetCreate.addDimension(str4);
                }
            } else {
                dimensionSetCreate = null;
            }
            register(str, str2, measureSetCreate, dimensionSetCreate, z);
            return;
        }
        j.d("AppMonitor", "register failed:no measure");
    }
}

package com.alibaba.analytics;

import android.app.Application;
import android.os.RemoteException;
import com.alibaba.analytics.a.j;
import com.alibaba.analytics.core.d;
import com.alibaba.analytics.core.d.g;
import com.alibaba.analytics.core.sync.f;
import com.alibaba.appmonitor.a.a;
import com.alibaba.appmonitor.event.EventType;
import com.alibaba.mtl.appmonitor.Transaction;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.ut.mini.UTAnalyticsDelegate;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AnalyticsImp extends IAnalytics.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Application f23739a;

    public AnalyticsImp(Application application) {
        f23739a = application;
    }

    public static Application getApplication() {
        return f23739a;
    }

    private EventType getEventType(int i) {
        return EventType.getEventType(i);
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void a() throws RemoteException {
        j.d("start..", new Object[0]);
        d.a().init(f23739a);
        j.d("end..", new Object[0]);
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void b(int i) throws RemoteException {
        try {
            a.b.setSampling(i);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void c(int i) throws RemoteException {
        try {
            a.C0137a.setStatisticsInterval(i);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void d(int i) throws RemoteException {
        try {
            a.C0137a.setSampling(i);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void destroy() throws RemoteException {
        try {
            a.destroy();
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void dispatchLocalHits() throws RemoteException {
        try {
            f.a().R();
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void e(int i) throws RemoteException {
        try {
            a.c.setStatisticsInterval(i);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void enableLog(boolean z) throws RemoteException {
        try {
            a.enableLog(z);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void f(int i) throws RemoteException {
        a.c.setSampling(i);
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void g(int i) throws RemoteException {
        try {
            a.setStatisticsInterval(i);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public String getValue(String str) throws RemoteException {
        try {
            if ("sw_plugin".equals(str)) {
                return com.alibaba.analytics.core.a.d.a().get(str);
            }
            if ("tpk_md5".equals(str)) {
                return d.a().d();
            }
            if ("tpk_string".equals(str)) {
                return d.a().e();
            }
            if (!"session_timestamp".equals(str)) {
                if ("autoExposure".equalsIgnoreCase(str)) {
                    return com.alibaba.analytics.core.a.d.a().get(str);
                }
                return null;
            }
            return "" + g.a().b();
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void h(int i) throws RemoteException {
        try {
            a.d.setStatisticsInterval(i);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void i(int i) throws RemoteException {
        try {
            a.d.setSampling(i);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void init() throws RemoteException {
        try {
            a();
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void removeGlobalProperty(String str) throws RemoteException {
        try {
            a.removeGlobalProperty(str);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void saveCacheDataToLocal() throws RemoteException {
        try {
            UTAnalyticsDelegate.getInstance().saveCacheDataToLocal();
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public String selfCheck(String str) throws RemoteException {
        try {
            return com.alibaba.analytics.core.selfmonitor.d.a().a("selfcheck", str);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
            return null;
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void setAppVersion(String str) throws RemoteException {
        try {
            UTAnalyticsDelegate.getInstance().setAppVersion(str);
        } catch (VerifyError e) {
            j.e(null, e, new Object[0]);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void setChannel(String str) throws RemoteException {
        try {
            UTAnalyticsDelegate.getInstance().setChannel(str);
        } catch (VerifyError e) {
            j.e(null, e, new Object[0]);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void setGlobalProperty(String str, String str2) throws RemoteException {
        try {
            a.setGlobalProperty(str, str2);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void setSampling(int i) throws RemoteException {
        try {
            a.setSampling(i);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void setSessionProperties(Map map) throws RemoteException {
        try {
            UTAnalyticsDelegate.getInstance().setSessionProperties(map);
        } catch (VerifyError e) {
            j.e(null, e, new Object[0]);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void transferLog(Map map) throws RemoteException {
        j.d();
        try {
            if (!d.a().m127n()) {
                d.a().init(f23739a);
            }
            UTAnalyticsDelegate.getInstance().transferLog(map);
        } catch (VerifyError e) {
            j.e(null, e, new Object[0]);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void triggerUpload() throws RemoteException {
        try {
            a.triggerUpload();
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void turnOffRealTimeDebug() throws RemoteException {
        try {
            d.a().turnOffRealTimeDebug();
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void turnOnDebug() throws RemoteException {
        try {
            UTAnalyticsDelegate.getInstance().turnOnDebug();
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void turnOnRealTimeDebug(Map map) throws RemoteException {
        try {
            d.a().turnOnRealTimeDebug(map);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void updateMeasure(String str, String str2, String str3, double d, double d2, double d3) throws RemoteException {
        a.updateMeasure(str, str2, str3, d, d2, d3);
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void updateSessionProperties(Map map) throws RemoteException {
        try {
            UTAnalyticsDelegate.getInstance().updateSessionProperties(map);
        } catch (VerifyError e) {
            j.e(null, e, new Object[0]);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void updateUserAccount(String str, String str2, String str3) throws RemoteException {
        try {
            UTAnalyticsDelegate.getInstance().updateUserAccount(str, str2, str3);
        } catch (VerifyError e) {
            j.e(null, e, new Object[0]);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public boolean b(String str, String str2) throws RemoteException {
        try {
            return a.C0137a.checkSampled(str, str2);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
            return false;
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public boolean c(String str, String str2) throws RemoteException {
        return a.c.checkSampled(str, str2);
    }

    @Override // com.alibaba.analytics.IAnalytics
    public boolean d(String str, String str2) throws RemoteException {
        return a.d.checkSampled(str, str2);
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void a(int i, int i2) throws RemoteException {
        try {
            a.setStatisticsInterval(getEventType(i), i2);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void c(String str, String str2, String str3) throws RemoteException {
        try {
            a.d.end(str, str2, str3);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void b(String str, String str2, double d) throws RemoteException {
        a.c.commit(str, str2, d);
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void b(String str, String str2, String str3) throws RemoteException {
        try {
            a.d.begin(str, str2, str3);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void c(String str, String str2, double d) throws RemoteException {
        try {
            a.d.commit(str, str2, d);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void a(boolean z, boolean z2, String str, String str2) throws RemoteException {
        try {
            a.a(z, z2, str, str2);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void b(Transaction transaction, String str) throws RemoteException {
        try {
            com.alibaba.appmonitor.a.f.d(transaction, str);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void a(int i) throws RemoteException {
        try {
            a.b.setStatisticsInterval(i);
        } catch (VerifyError e) {
            j.e(null, e, new Object[0]);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean mo81a(String str, String str2) throws RemoteException {
        try {
            return a.b.checkSampled(str, str2);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
            return false;
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void a(String str, String str2, double d) throws RemoteException {
        try {
            a.b.commit(str, str2, d);
        } catch (VerifyError e) {
            j.e(null, e, new Object[0]);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void a(String str, String str2, String str3, double d) throws RemoteException {
        try {
            a.b.commit(str, str2, str3, d);
        } catch (VerifyError e) {
            j.e(null, e, new Object[0]);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void a(String str, String str2) throws RemoteException {
        try {
            a.C0137a.commitSuccess(str, str2);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void a(String str, String str2, String str3) throws RemoteException {
        try {
            a.C0137a.commitSuccess(str, str2, str3);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void a(String str, String str2, String str3, String str4) throws RemoteException {
        try {
            a.C0137a.commitFail(str, str2, str3, str4);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void a(String str, String str2, String str3, String str4, String str5) throws RemoteException {
        try {
            a.C0137a.commitFail(str, str2, str3, str4, str5);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void a(String str, String str2, MeasureSet measureSet) throws RemoteException {
        try {
            a.register(str, str2, measureSet);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void a(String str, String str2, MeasureSet measureSet, boolean z) throws RemoteException {
        try {
            a.register(str, str2, measureSet, z);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet) throws RemoteException {
        try {
            a.register(str, str2, measureSet, dimensionSet);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) throws RemoteException {
        try {
            a.register(str, str2, measureSet, dimensionSet, z);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void a(String str, String str2, DimensionValueSet dimensionValueSet, double d) throws RemoteException {
        try {
            a.d.commit(str, str2, dimensionValueSet, d);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void a(String str, String str2, DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) throws RemoteException {
        try {
            a.d.commit(str, str2, dimensionValueSet, measureValueSet);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.IAnalytics
    public void a(Transaction transaction, String str) throws RemoteException {
        try {
            com.alibaba.appmonitor.a.f.c(transaction, str);
        } catch (Throwable th) {
            j.e(null, th, new Object[0]);
        }
    }
}

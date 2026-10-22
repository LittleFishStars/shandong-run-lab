package com.getui.gtc.api;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.ProcessSwitchContract;
import com.getui.gtc.base.publish.Broker;
import com.getui.gtc.base.publish.Subscriber;
import com.getui.gtc.base.util.BundleCompat;
import com.getui.gtc.base.util.CommonUtil;
import com.getui.gtc.dim.Caller;
import com.getui.gtc.dim.DimManager;
import com.getui.gtc.f.b;
import com.getui.gtc.i.c.a;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class GtcManager implements Subscriber {
    private static String methodName;

    public static class InstanceHolder {
        private static final GtcManager instance = new GtcManager();

        private InstanceHolder() {
        }
    }

    private GtcManager() {
    }

    private void checkSdkInfo(SdkInfo sdkInfo) {
        if (TextUtils.isEmpty(sdkInfo.getModuleName())) {
            a.c("moduleName not set for sdkinfo");
            throw new RuntimeException("moduleName not set for sdkinfo");
        }
        if (TextUtils.isEmpty(sdkInfo.getAppid())) {
            a.c("appid not set for sdkinfo");
            throw new RuntimeException("appid not set for sdkinfo");
        }
        if (TextUtils.isEmpty(sdkInfo.getVersion())) {
            a.c("version not set for sdkinfo");
            throw new RuntimeException("version not set for sdkinfo");
        }
    }

    private Bundle createBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(ProcessSwitchContract.CLASS_NAME, getClass().getName());
        bundle.putString(ProcessSwitchContract.GET_INSTANCE, methodName);
        return bundle;
    }

    private static Caller getFromTrace() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            String name = GtcManager.class.getName();
            int i = -1;
            for (int i2 = 2; i2 < stackTrace.length; i2++) {
                if (!stackTrace[i2].getClassName().equals(name)) {
                    if (i > 0) {
                        break;
                    }
                } else {
                    i = i2;
                }
            }
            String className = stackTrace[i + 1].getClassName();
            if (className.startsWith("com.igexin")) {
                return Caller.PUSH;
            }
            if (className.startsWith("com.g.gysdk")) {
                return Caller.GY;
            }
            if (className.startsWith("com.getui.gs")) {
                return Caller.IDO;
            }
            if (className.startsWith("com.sdk.plus")) {
                return Caller.WUS;
            }
            return Caller.UNKNOWN;
        } catch (Throwable th) {
            a.c(th);
        }
    }

    public static GtcManager getInstance() {
        methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        return InstanceHolder.instance;
    }

    public void addOnDycEnableChangedListener(Context context, OnDycEnableChangedListener.Stub stub) {
        if (CommonUtil.isGtcProcess()) {
            b.a().a(stub);
            return;
        }
        GtcProvider.setContext(context);
        Bundle bundleCreateBundle = createBundle();
        bundleCreateBundle.putString(ProcessSwitchContract.METHOD_NAME, "gtc-5-1");
        BundleCompat.putBinder(bundleCreateBundle, "gtc-5-2", stub);
        Bundle bundleSubscribe = Broker.getInstance().subscribe(bundleCreateBundle);
        if (bundleSubscribe.get(ProcessSwitchContract.METHOD_EXCEPTION) != null) {
            a.c((Throwable) bundleSubscribe.get(ProcessSwitchContract.METHOD_EXCEPTION));
        }
    }

    public ClassLoader getClassLoader(Bundle bundle) {
        return com.getui.gtc.g.b.a(bundle);
    }

    @Deprecated
    public void init(Context context, GtcIdCallback.Stub stub) {
        initialize(context, stub);
    }

    @Deprecated
    public String initialize(Context context, GtcIdCallback.Stub stub) {
        return initialize(context, getFromTrace(), stub);
    }

    public String initialize(Context context, Caller caller, GtcIdCallback.Stub stub) {
        if (CommonUtil.isGtcProcess()) {
            DimManager.getInstance().set("dim-2-2-3-1", "dim-2-2-3-1", caller != null ? caller.name() : null);
            return com.getui.gtc.d.a.C0648a.f30297a.a(stub);
        }
        GtcProvider.setContext(context);
        Bundle bundleCreateBundle = createBundle();
        bundleCreateBundle.putString(ProcessSwitchContract.METHOD_NAME, "gtc-1-1");
        bundleCreateBundle.putString("gtc-1-3", caller != null ? caller.name() : null);
        BundleCompat.putBinder(bundleCreateBundle, "gtc-1-2", stub);
        Bundle bundleSubscribe = Broker.getInstance().subscribe(bundleCreateBundle);
        Object obj = bundleSubscribe.get(ProcessSwitchContract.METHOD_EXCEPTION);
        if (obj instanceof Throwable) {
            a.a("initialize", (Throwable) obj);
        }
        return bundleSubscribe.getString(ProcessSwitchContract.METHOD_RETURN);
    }

    public boolean loadBundle(Context context, Bundle bundle) {
        if (context != null) {
            GtcProvider.setContext(context.getApplicationContext());
        }
        return com.getui.gtc.g.b.a(context, bundle);
    }

    public void loadSdk(SdkInfo sdkInfo) {
        checkSdkInfo(sdkInfo);
        if (CommonUtil.isGtcProcess()) {
            com.getui.gtc.d.a.C0648a.f30297a.a(sdkInfo);
            return;
        }
        Bundle bundleCreateBundle = createBundle();
        bundleCreateBundle.putString(ProcessSwitchContract.METHOD_NAME, "gtc-2-1");
        bundleCreateBundle.putParcelable("gtc-2-2", sdkInfo);
        Bundle bundleSubscribe = Broker.getInstance().subscribe(bundleCreateBundle);
        if (bundleSubscribe.get(ProcessSwitchContract.METHOD_EXCEPTION) != null) {
            a.c((Throwable) bundleSubscribe.get(ProcessSwitchContract.METHOD_EXCEPTION));
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x005e  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.getui.gtc.base.publish.Subscriber
    public void receive(Bundle bundle, Bundle bundle2) {
        byte b;
        ArrayList arrayList = new ArrayList();
        try {
            Throwable th = (Throwable) bundle2.getSerializable(ProcessSwitchContract.METHOD_EXCEPTION);
            if (th != null) {
                arrayList.add(th);
            }
            String string = bundle.getString(ProcessSwitchContract.METHOD_NAME);
            if (TextUtils.isEmpty(string)) {
                throw new RuntimeException("methodName missed");
            }
            switch (string.hashCode()) {
                case 337397854:
                    if (!string.equals("gtc-1-1")) {
                        b = -1;
                    } else {
                        b = 0;
                    }
                    break;
                case 337398815:
                    if (!string.equals("gtc-2-1")) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                case 337399776:
                    if (!string.equals("gtc-3-1")) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                case 337400737:
                    if (!string.equals("gtc-4-1")) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                case 337401698:
                    if (!string.equals("gtc-5-1")) {
                        b = -1;
                    } else {
                        b = 4;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0) {
                DimManager.getInstance().set("dim-2-2-3-1", "dim-2-2-3-1", bundle.getString("gtc-1-3"));
                bundle2.putString(ProcessSwitchContract.METHOD_RETURN, com.getui.gtc.d.a.C0648a.f30297a.a(GtcIdCallback.Stub.asInterface(BundleCompat.getBinder(bundle, "gtc-1-2"))));
            } else if (b == 1) {
                com.getui.gtc.d.a.C0648a.f30297a.a((SdkInfo) bundle.getParcelable("gtc-2-2"));
            } else if (b == 2) {
                bundle.getString("gtc-3-2");
                com.getui.gtc.d.a.C0648a.f30297a.a(bundle.getIntArray("gtc-3-3"));
            } else if (b == 3) {
                com.getui.gtc.d.a.C0648a.f30297a.a(bundle.getInt("gtc-4-2"));
            } else if (b == 4) {
                b.a().a(OnDycEnableChangedListener.Stub.asInterface(BundleCompat.getBinder(bundle, "gtc-5-2")));
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a.b((Throwable) it.next());
            }
        } catch (Throwable th2) {
            try {
                arrayList.add(th2);
            } finally {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    a.b((Throwable) it2.next());
                }
            }
        }
    }

    public void removeExt(String str, int[] iArr) {
        if (CommonUtil.isGtcProcess()) {
            com.getui.gtc.d.a.C0648a.f30297a.a(iArr);
            return;
        }
        Bundle bundleCreateBundle = createBundle();
        bundleCreateBundle.putString(ProcessSwitchContract.METHOD_NAME, "gtc-3-1");
        bundleCreateBundle.putString("gtc-3-2", str);
        bundleCreateBundle.putIntArray("gtc-3-3", iArr);
        Bundle bundleSubscribe = Broker.getInstance().subscribe(bundleCreateBundle);
        if (bundleSubscribe.get(ProcessSwitchContract.METHOD_EXCEPTION) != null) {
            a.c((Throwable) bundleSubscribe.get(ProcessSwitchContract.METHOD_EXCEPTION));
        }
    }

    public void startType(int i) {
        if (CommonUtil.isGtcProcess()) {
            com.getui.gtc.d.a.C0648a.f30297a.a(i);
            return;
        }
        Bundle bundleCreateBundle = createBundle();
        bundleCreateBundle.putString(ProcessSwitchContract.METHOD_NAME, "gtc-4-1");
        bundleCreateBundle.putInt("gtc-4-2", i);
        Broker.getInstance().subscribe(bundleCreateBundle);
        Bundle bundleSubscribe = Broker.getInstance().subscribe(bundleCreateBundle);
        if (bundleSubscribe.get(ProcessSwitchContract.METHOD_EXCEPTION) != null) {
            a.c((Throwable) bundleSubscribe.get(ProcessSwitchContract.METHOD_EXCEPTION));
        }
    }
}

package com.getui.gtc.dim;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.acse.ottn.p3;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.ProcessSwitchContract;
import com.getui.gtc.base.crypt.CryptTools;
import com.getui.gtc.base.publish.Broker;
import com.getui.gtc.base.publish.Subscriber;
import com.getui.gtc.base.util.CommonUtil;
import com.getui.gtc.dim.b.g;
import com.getui.gtc.dim.e.b;
import com.getui.gtc.dim.e.c;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class DimManager implements Subscriber {
    private static String methodName;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final DimManager f30298a = new DimManager();
    }

    private DimManager() {
    }

    private Bundle createBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(ProcessSwitchContract.CLASS_NAME, getClass().getName());
        bundle.putString(ProcessSwitchContract.GET_INSTANCE, methodName);
        return bundle;
    }

    public static DimManager getInstance() {
        methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        return a.f30298a;
    }

    private void notifyGdiLoadSuccess(Class<?> cls) {
        g gVarD = g.d();
        if (cls != null) {
            try {
                if (cls.getName().equals(new String(Base64.decode("Y29tLmdldHVpLmd0Yy5leHRlbnNpb24uZGlzdHJpYnV0aW9uLmdkaS5zdHViLlB1c2hFeHRlbnNpb24=", 2)))) {
                    gVarD.g = cls.getDeclaredMethod(p3.f, Bundle.class);
                    gVarD.h = cls.getDeclaredMethod("updateRuntimeData", String.class);
                    return;
                }
            } catch (Throwable th) {
                b.b(th);
                return;
            }
        }
        throw new IllegalArgumentException("not support class:".concat(String.valueOf(cls)));
    }

    public Object get(DimRequest dimRequest) {
        if (!CommonUtil.isGtcProcess()) {
            Bundle bundleCreateBundle = createBundle();
            bundleCreateBundle.putString(ProcessSwitchContract.METHOD_NAME, "dim-1-1-1");
            bundleCreateBundle.putParcelable("dim-1-1-2", dimRequest);
            Object obj = Broker.getInstance().subscribe(bundleCreateBundle).get(ProcessSwitchContract.METHOD_RETURN);
            if (!(obj instanceof File)) {
                return obj;
            }
            try {
                byte[] bArrA = c.a((File) obj);
                ((File) obj).delete();
                return c.a(bArrA);
            } catch (Throwable unused) {
                return null;
            }
        }
        Object objA = com.getui.gtc.dim.a.C0649a.f30300a.a(dimRequest, true);
        try {
            if ((objA instanceof String) && "dim-2-1-5-1".equals(dimRequest.getKey())) {
                String str = (String) objA;
                if ("HONOR".equalsIgnoreCase(Build.MANUFACTURER) && str.contains("#")) {
                    String[] strArrSplit = str.split("#");
                    if (strArrSplit.length == 2) {
                        if (!TextUtils.isEmpty(strArrSplit[1])) {
                            return strArrSplit[1];
                        }
                        if (!TextUtils.isEmpty(strArrSplit[0])) {
                            return strArrSplit[0];
                        }
                    }
                }
            }
        } catch (Throwable th) {
            b.a(th);
        }
        return objA;
    }

    @Deprecated
    public Object get(String str) {
        return get(new DimRequest.Builder().key(str).build());
    }

    public int getCallers() {
        if (CommonUtil.isGtcProcess()) {
            return g.d().c();
        }
        Bundle bundleCreateBundle = createBundle();
        bundleCreateBundle.putString(ProcessSwitchContract.METHOD_NAME, "dim-1-3-1");
        return Broker.getInstance().subscribe(bundleCreateBundle).getInt(ProcessSwitchContract.METHOD_RETURN);
    }

    public Object getSetting(String str, String str2) {
        if (CommonUtil.isGtcProcess()) {
            return com.getui.gtc.dim.a.C0649a.f30300a.b(str, str2);
        }
        Bundle bundleCreateBundle = createBundle();
        bundleCreateBundle.putString(ProcessSwitchContract.METHOD_NAME, "dim-1-5-1");
        bundleCreateBundle.putString("dim-1-5-2", str);
        bundleCreateBundle.putString("dim-1-5-3", str2);
        return Broker.getInstance().subscribe(bundleCreateBundle).getSerializable(ProcessSwitchContract.METHOD_RETURN);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x005c  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.getui.gtc.base.publish.Subscriber
    public void receive(Bundle bundle, Bundle bundle2) {
        byte b;
        Serializable serializableValueOf;
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
                case 1538245748:
                    if (!string.equals("dim-1-1-1")) {
                        b = -1;
                    } else {
                        b = 0;
                    }
                    break;
                case 1538246709:
                    if (!string.equals("dim-1-2-1")) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                case 1538247670:
                    if (!string.equals("dim-1-3-1")) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                case 1538248631:
                    if (!string.equals("dim-1-4-1")) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                case 1538249592:
                    if (!string.equals("dim-1-5-1")) {
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
                Object obj = get((DimRequest) bundle.getParcelable("dim-1-1-2"));
                if (obj != null) {
                    byte[] bArrB = c.b(obj);
                    if (bArrB.length > 204800) {
                        File file = new File(GtcProvider.context().getCacheDir(), CryptTools.digestToHexString("MD5", bArrB));
                        if (!c.a(bArrB, file)) {
                            throw new RuntimeException("failed to save dim result bytes to file");
                        }
                        serializableValueOf = file;
                    } else {
                        if (obj instanceof Parcelable) {
                            bundle2.putParcelable(ProcessSwitchContract.METHOD_RETURN, (Parcelable) obj);
                        }
                        if (obj instanceof Serializable) {
                            serializableValueOf = (Serializable) obj;
                        }
                    }
                    bundle2.putSerializable(ProcessSwitchContract.METHOD_RETURN, serializableValueOf);
                }
            } else if (b == 1) {
                String string2 = bundle.getString("dim-1-2-2");
                bundle.getString("dim-1-2-3");
                com.getui.gtc.dim.a.C0649a.f30300a.a(string2, bundle.getString("dim-1-2-4"));
            } else if (b != 2) {
                if (b == 3) {
                    serializableValueOf = Boolean.valueOf(com.getui.gtc.dim.a.C0649a.f30300a.a(bundle.getString("dim-1-4-2"), bundle.getString("dim-1-4-3"), bundle.getString("dim-1-4-4")));
                } else if (b == 4) {
                    serializableValueOf = com.getui.gtc.dim.a.C0649a.f30300a.b(bundle.getString("dim-1-5-2"), bundle.getString("dim-1-5-3"));
                }
                bundle2.putSerializable(ProcessSwitchContract.METHOD_RETURN, serializableValueOf);
            } else {
                bundle2.putInt(ProcessSwitchContract.METHOD_RETURN, getCallers());
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                b.a((Throwable) it.next());
            }
        } catch (Throwable th2) {
            try {
                arrayList.add(th2);
            } finally {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    b.a((Throwable) it2.next());
                }
            }
        }
    }

    public void set(String str, String str2, String str3) {
        if (CommonUtil.isGtcProcess()) {
            com.getui.gtc.dim.a.C0649a.f30300a.a(str, str3);
            return;
        }
        Bundle bundleCreateBundle = createBundle();
        bundleCreateBundle.putString(ProcessSwitchContract.METHOD_NAME, "dim-1-2-1");
        bundleCreateBundle.putString("dim-1-2-2", str);
        bundleCreateBundle.putString("dim-1-2-3", str2);
        bundleCreateBundle.putString("dim-1-2-4", str3);
        Broker.getInstance().subscribe(bundleCreateBundle);
    }

    public boolean setAppDataProvider(Context context, AppDataProvider appDataProvider) {
        if (context == null) {
            Log.e("DimManager", "setAppDataProvider failed,because context==null");
            return false;
        }
        GtcProvider.setContext(context);
        g.d().a(appDataProvider);
        return true;
    }

    public boolean setSetting(Context context, String str, String str2, String str3) {
        if (context == null || str == null) {
            return false;
        }
        if (CommonUtil.isGtcProcess()) {
            return com.getui.gtc.dim.a.C0649a.f30300a.a(str, str2, str3);
        }
        GtcProvider.setContext(context);
        Bundle bundleCreateBundle = createBundle();
        bundleCreateBundle.putString(ProcessSwitchContract.METHOD_NAME, "dim-1-4-1");
        bundleCreateBundle.putString("dim-1-4-2", str);
        bundleCreateBundle.putString("dim-1-4-3", str2);
        bundleCreateBundle.putString("dim-1-4-4", str3);
        return Broker.getInstance().subscribe(bundleCreateBundle).getBoolean(ProcessSwitchContract.METHOD_RETURN);
    }
}

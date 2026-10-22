package com.getui.gtc.dyc;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.getui.gtc.base.ProcessSwitchContract;
import com.getui.gtc.base.publish.Broker;
import com.getui.gtc.base.publish.Subscriber;
import com.getui.gtc.base.util.BundleCompat;
import com.getui.gtc.base.util.CommonUtil;
import com.getui.gtc.dyc.b.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a implements Subscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f30331a;

    /* JADX INFO: renamed from: com.getui.gtc.dyc.a$a, reason: collision with other inner class name */
    public static class C0654a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f30334a = new a();
    }

    private a() {
    }

    public static a a() {
        f30331a = Thread.currentThread().getStackTrace()[2].getMethodName();
        return C0654a.f30334a;
    }

    private Bundle d() {
        Bundle bundle = new Bundle();
        bundle.putString(ProcessSwitchContract.CLASS_NAME, getClass().getName());
        bundle.putString(ProcessSwitchContract.GET_INSTANCE, f30331a);
        return bundle;
    }

    public Map<String, String> a(final b bVar) {
        if (CommonUtil.isGtcProcess()) {
            return f.a().a(bVar);
        }
        Bundle bundleD = d();
        bundleD.putString(ProcessSwitchContract.METHOD_NAME, "dyc-1-1");
        bundleD.putParcelable("dyc-1-2", bVar);
        if (bVar.i() != null) {
            BundleCompat.putBinder(bundleD, "dyc-1-3", new Callback.a() { // from class: com.getui.gtc.dyc.a.2
                @Override // com.getui.gtc.dyc.Callback
                public void a(Map map, Map map2) throws RemoteException {
                    bVar.i().a(map, map2);
                }

                @Override // com.getui.gtc.dyc.Callback
                public void b(String str) throws RemoteException {
                    bVar.i().b(str);
                }
            });
        }
        return (Map) Broker.getInstance().subscribe(bundleD).get(ProcessSwitchContract.METHOD_RETURN);
    }

    public Map<String, String> a(String str) {
        if (CommonUtil.isGtcProcess()) {
            return f.a().a(str);
        }
        Bundle bundleD = d();
        bundleD.putString(ProcessSwitchContract.METHOD_NAME, "dyc-2-1");
        bundleD.putString("dyc-2-2", str);
        return (Map) Broker.getInstance().subscribe(bundleD).get(ProcessSwitchContract.METHOD_RETURN);
    }

    public void a(String str, Map<String, String> map) {
        if (CommonUtil.isGtcProcess()) {
            f.a().a(str, map);
            return;
        }
        Bundle bundleD = d();
        bundleD.putString(ProcessSwitchContract.METHOD_NAME, "dyc-4-1");
        bundleD.putString("dyc-4-2", str);
        bundleD.putSerializable("dyc-4-3", (HashMap) map);
        Broker.getInstance().subscribe(bundleD);
    }

    public Map<String, Map<String, String>> c() {
        if (CommonUtil.isGtcProcess()) {
            return f.a().c();
        }
        Bundle bundleD = d();
        bundleD.putString(ProcessSwitchContract.METHOD_NAME, "dyc-3-1");
        return (Map) Broker.getInstance().subscribe(bundleD).get(ProcessSwitchContract.METHOD_RETURN);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0051  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b3 A[LOOP:0: B:40:0x00ad->B:42:0x00b3, LOOP_END] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.getui.gtc.base.publish.Subscriber
    public void receive(Bundle bundle, Bundle bundle2) {
        byte b;
        Serializable serializable;
        Iterator it;
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
                case 2112999862:
                    if (!string.equals("dyc-1-1")) {
                        b = -1;
                    } else {
                        b = 0;
                    }
                    break;
                case 2113000823:
                    if (!string.equals("dyc-2-1")) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                case 2113001784:
                    if (!string.equals("dyc-3-1")) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                case 2113002745:
                    if (!string.equals("dyc-4-1")) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            if (b == 0) {
                b bVar = (b) bundle.getParcelable("dyc-1-2");
                final Callback callbackA = Callback.a.a(BundleCompat.getBinder(bundle, "dyc-1-3"));
                if (callbackA != null) {
                    bVar.i(new com.getui.gtc.dyc.b.c() { // from class: com.getui.gtc.dyc.a.1
                        @Override // com.getui.gtc.dyc.b.c
                        public void a(Map<String, String> map, Map<String, String> map2) {
                            try {
                                callbackA.a(map, map2);
                            } catch (RemoteException e) {
                                com.getui.gtc.dyc.a.a.a.a(e);
                            }
                        }

                        @Override // com.getui.gtc.dyc.b.c
                        public void b(String str) {
                            try {
                                callbackA.b(str);
                            } catch (RemoteException e) {
                                com.getui.gtc.dyc.a.a.a.a(e);
                            }
                        }
                    });
                }
                serializable = (Serializable) a(bVar);
            } else {
                if (b != 1) {
                    if (b == 2) {
                        serializable = (Serializable) c();
                    } else if (b == 3) {
                        a(bundle.getString("dyc-4-2"), (HashMap) bundle.getSerializable("dyc-4-3"));
                    }
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                        com.getui.gtc.dyc.a.a.a.a((Throwable) it.next());
                    }
                }
                serializable = (Serializable) a(bundle.getString("dyc-2-2"));
            }
            bundle2.putSerializable(ProcessSwitchContract.METHOD_RETURN, serializable);
            it = arrayList.iterator();
            while (it.hasNext()) {
                com.getui.gtc.dyc.a.a.a.a((Throwable) it.next());
            }
        } catch (Throwable th2) {
            try {
                arrayList.add(th2);
            } finally {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    com.getui.gtc.dyc.a.a.a.a((Throwable) it2.next());
                }
            }
        }
    }
}

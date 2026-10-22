package com.acse.ottn;

import android.view.accessibility.AccessibilityEvent;
import com.acse.ottn.io.reactivex.functions.Consumer;
import com.acse.ottn.io.reactivex.schedulers.Schedulers;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.util.HelpShopAppUtil;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import java.io.ObjectStreamException;
import java.util.TreeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static e f22963a = null;
    public static String b = "acse_ShopHelperService";

    public class a implements Consumer<String> {
        public a() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
        }
    }

    public class b implements Consumer<Throwable> {
        public b() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            h2.b(e.b, "报错了=" + th.getMessage());
        }
    }

    public static e c() {
        if (f22963a == null) {
            synchronized (e.class) {
                if (f22963a == null) {
                    f22963a = new e();
                }
            }
        }
        return f22963a;
    }

    public void a(AccessibilityEvent accessibilityEvent) {
    }

    public void b() {
    }

    public final Object d() throws ObjectStreamException {
        return f22963a;
    }

    public void a(AccessiblityModel accessiblityModel) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        treeMap.put("para", accessiblityModel.getData().getCoupon_activity_name());
        treeMap.put(NativeCallContext.DOMAIN_APP, accessiblityModel.getData().getPackage_name());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        treeMap.put("is_snt", "0");
        new l1().i(t0.b().a(treeMap, "")).u5(Schedulers.newThread()).G3(i.a()).s5(new a(), new b());
    }
}

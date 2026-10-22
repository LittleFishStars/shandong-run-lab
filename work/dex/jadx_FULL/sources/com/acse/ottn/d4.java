package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.text.TextUtils;
import com.acse.ottn.io.reactivex.functions.Consumer;
import com.acse.ottn.io.reactivex.schedulers.Schedulers;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.util.HelpShopAppUtil;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.fastjson.JSON;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.io.ObjectStreamException;
import java.util.List;
import java.util.TreeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d4 {
    public static d4 c = null;
    public static String d = "ScrolledReadUtil";
    public static String e = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<String> f22944a;
    public int b = 0;

    public class a implements Consumer<AccessiblityModel> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22945a;

        public a(String str) {
            this.f22945a = str;
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(AccessiblityModel accessiblityModel) throws Exception {
            h2.a(d4.d, "请求成功 string =" + accessiblityModel.toString());
            if (1 == accessiblityModel.getR()) {
                d.d().a(accessiblityModel, this.f22945a);
            }
        }
    }

    public class b implements Consumer<Throwable> {
        public b() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            h2.b(d4.d, "报错了=" + th.getMessage());
            if (d4.this.f22944a != null) {
                d4.this.f22944a.removeAll(d4.this.f22944a);
            }
        }
    }

    public static d4 c() {
        if (c == null) {
            synchronized (d4.class) {
                if (c == null) {
                    c = new d4();
                }
            }
        }
        return c;
    }

    public final boolean b() {
        Long lValueOf = Long.valueOf(n3.a().d("scrolled_screen_time"));
        h2.b(d, "controlCouponShow appPageName =" + (System.currentTimeMillis() - lValueOf.longValue()));
        if (System.currentTimeMillis() - lValueOf.longValue() < 1000) {
            h2.a(d, "controlCouponShow return false ");
            return false;
        }
        n3.a().a("scrolled_screen_time", System.currentTimeMillis());
        h2.a(d, "controlCouponShow return true");
        return true;
    }

    public final Object d() throws ObjectStreamException {
        return c;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1104)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1058)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:358)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r2v19 java.util.Collection<?>
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    public void a(android.accessibilityservice.AccessibilityService r6) {
        /*
            Method dump skipped, instruction units count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.d4.a(android.accessibilityservice.AccessibilityService):void");
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1104)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1058)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:358)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r8v15 java.util.Collection<?>
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    @android.annotation.SuppressLint({"NewApi"})
    public void a(android.view.accessibility.AccessibilityNodeInfo r8) {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.d4.a(android.view.accessibility.AccessibilityNodeInfo):void");
    }

    public boolean a(List<String> list) {
        if (list != null && list.size() != 0) {
            h2.a(d, "samon--lists  =" + list);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).trim().equals("进店逛逛") || list.get(i).trim().equals("天猫国际") || list.get(i).trim().equals("去频道逛逛")) {
                    h2.a("zkj_samon", "包含");
                    return true;
                }
            }
            return false;
        }
        h2.a(d, "lists = null");
        return false;
    }

    public final void a(AccessibilityService accessibilityService, List<String> list, String str, String str2) {
        h2.a(d, "current packageName  =" + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        TreeMap treeMap = new TreeMap();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        treeMap.put(NativeCallContext.DOMAIN_APP, str);
        HelpShopAppUtil.getInstance();
        treeMap.put(RequestParameters.MARKER, HelpShopAppUtil.sessionExID());
        if (list != null) {
            treeMap.put("data", JSON.toJSONString(list));
            h2.a(d, "getCouponInfo string =" + JSON.toJSONString(list));
        } else {
            treeMap.put("data", "");
        }
        treeMap.put("product_info", n3.a().e("goods_info"));
        treeMap.put("new_version", l0.m);
        treeMap.put("coupon_type", t0.b().j(str));
        treeMap.put("genuine_packagename", str2);
        treeMap.put("device_brand", p4.b());
        treeMap.put("is_snt", l0.m);
        treeMap.put("version", l0.z);
        new l1().j(t0.b().a(treeMap, "")).G3(i.a()).u5(Schedulers.newThread()).s5(new a(str), new b());
    }
}

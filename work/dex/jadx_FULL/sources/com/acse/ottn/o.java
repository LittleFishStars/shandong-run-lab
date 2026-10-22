package com.acse.ottn;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.acse.ottn.io.reactivex.ObservableEmitter;
import com.acse.ottn.io.reactivex.ObservableOnSubscribe;
import com.acse.ottn.io.reactivex.functions.Consumer;
import com.acse.ottn.io.reactivex.schedulers.Schedulers;
import com.acse.ottn.util.HelpShopAppUtil;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.alibaba.fastjson.JSON;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import rx.Observable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class o {
    public static o c0 = null;
    public static String d0 = "AppPageNameUtil";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f23106a = false;
    public String b = "com.taobao.android.detail.wrapper.activity.DetailActivity";
    public String c = "com.taobao.tao.detail.activity.DetailActivity";
    public String d = "com.taobao.android.tbabilitykit.pop.StdPopActivityGroup";
    public String e = "com.taobao.live.liveshop.detail.DTLiveShopDetailActivity";
    public String f = "com.taobao.android.detail.alittdetail.TTDetailActivity";
    public String g = "com.taobao.homepage.page.MagicWindowActivity";
    public String h = "com.jd.lib.productdetail.ProductDetailActivity";
    public String i = "com.jd.lib.productdetail.ProductDetailPopActivity";
    public String j = "com.tmall.wireless.xdetail.activity.TMXDetailActivity";
    public String k = "com.tmall.wireless.newdetail.activity.NewDetailActivity";
    public String l = "com.sankuai.meituan.takeoutnew";
    public String m = "com.taobao.taobao.fz";
    public String n = "com.xingin.xhs";
    public String o = "com.kuaishou.nebulam";
    public String p = "com.smile.gifmakerm";
    public String q = "com.baidu.netdiskm";
    public String r = "com.huaxiaozhu";
    public String s = "com.yek.android.kfc.activitys";
    public String t = AlibcProtocolConstant.APPLINK_PACKAGE_NAME;
    public String u = "com.tmall.wireless";
    public String v = "com.alipay.video";
    public String w = "com.jingdong.app.mall";
    public String x = "com.jingdong.app.wm";
    public String y = "com.sankuai.meituan.flower";
    public String z = "com.sankuai.meituan.video";
    public String A = "com.sankuai.meituan.medicine";
    public String B = "com.sankuai.meituan.hotel";
    public String C = "com.sina.weibo.main";
    public String D = "com.sankuai.meituan.shop";
    public String E = "com.sankuai.meituan.vegetable";
    public String F = "com.taobao.idlefish.home";
    public String G = "com.taobao.shangou";
    public String H = "com.ss.android.ugc.aweme.mall";
    public String I = "com.ss.android.ugc.awemem";
    public String J = "com.sankuai.meituan";
    public String K = "me.didi";
    public String L = "com.tencent.qqlive";
    public String M = "com.youku.phone";
    public String N = "com.sankuai.waimai.details";
    public String O = "me.ele";
    public String P = "com.acse.xcx";
    public String Q = "com.starbucks.cn";
    public String R = "me.ele.detail";
    public String S = "com.qiyi.video";
    public String T = "com.taobao.tao.main";
    public String U = f0.b;
    public String V = "com.tmall.wireless.main";
    public String W = "com.jingdong.app.mall.main";
    public String X = "com.suning.mobile.main";
    public String Y = "com.ct.client.main";
    public String Z = "com.sinovatech.unicom.main";
    public String a0 = "com.mc10086.cmcc.main";
    public String b0 = "com.achievo.vipshop.main";

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f23107a;

        public a(Activity activity) {
            this.f23107a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            ClipData primaryClip = ((ClipboardManager) this.f23107a.getSystemService("clipboard")).getPrimaryClip();
            if (primaryClip == null || primaryClip.getItemCount() <= 0) {
                return;
            }
            h2.a("ShopHelpManager", "getFromClipboard text=" + primaryClip.getItemAt(0).getText().toString());
        }
    }

    public class b implements Consumer<List<String>> {
        public b() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(List<String> list) throws Exception {
            o.this.a(list);
        }
    }

    public class c implements Consumer<Throwable> {
        public c() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    public class d implements ObservableOnSubscribe<List<String>> {
        public d() {
        }

        @Override // com.acse.ottn.io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<List<String>> observableEmitter) throws Exception {
            PackageManager packageManager = HelpShopAppUtil.getContext().getPackageManager();
            List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(0);
            ArrayList arrayList = new ArrayList();
            for (ApplicationInfo applicationInfo : installedApplications) {
                arrayList.add(packageManager.getApplicationLabel(applicationInfo).toString() + "<---->" + applicationInfo.packageName);
            }
            observableEmitter.onNext(arrayList);
        }
    }

    public class e implements Consumer<String> {
        public e() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            h2.a(o.d0, "请求成功 string =" + str);
        }
    }

    public class f implements Consumer<Throwable> {
        public f() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    public static o c() {
        if (c0 == null) {
            synchronized (o.class) {
                if (c0 == null) {
                    c0 = new o();
                }
            }
        }
        return c0;
    }

    public void b() {
        Observable.h1(new d()).u5(Schedulers.newThread()).G3(i.a()).s5(new b(), new c());
    }

    public final Object d() throws ObjectStreamException {
        return c0;
    }

    public void a(Context context, String str) {
        h2.a("setClipboard", str);
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        ClipData clipDataNewPlainText = ClipData.newPlainText(null, str);
        if (clipboardManager == null) {
            clipboardManager = (ClipboardManager) HelpShopAppUtil.getContext().getSystemService("clipboard");
        }
        if (clipboardManager == null) {
            return;
        }
        clipboardManager.setPrimaryClip(clipDataNewPlainText);
    }

    public final void a(Activity activity) {
        try {
            activity.runOnUiThread(new a(activity));
        } catch (Exception e2) {
            h2.a("ShopHelpManager", "getFromClipboard error");
            e2.printStackTrace();
        }
    }

    public List<String> a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(0);
        ArrayList arrayList = new ArrayList();
        for (ApplicationInfo applicationInfo : installedApplications) {
            arrayList.add(packageManager.getApplicationLabel(applicationInfo).toString() + "<---->" + applicationInfo.packageName);
        }
        return arrayList;
    }

    public final void a(List<String> list) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionExID());
        if (list != null) {
            treeMap.put("data", JSON.toJSONString(list));
        } else {
            treeMap.put("data", "");
        }
        new l1().d(t0.b().a(treeMap, "")).u5(Schedulers.newThread()).G3(i.a()).s5(new e(), new f());
    }
}

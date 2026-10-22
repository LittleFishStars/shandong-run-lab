package com.kc.dw.core.loader.strategy;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.domain.SdkAdInfo;
import com.kc.dw.core.domain.SsdAdInfo;
import com.kc.dw.core.loader.AdPlatformError;
import com.kc.dw.core.loader.serverbidding.S2sbResultBean;
import com.kc.dw.core.router.log.EventBean;
import com.kc.dw.core.router.log.bean.CodeErrorNoMsg;
import com.kc.dw.core.safe.j;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.core.utils.f0;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.s0;
import com.kc.dw.core.utils.s1;
import com.kc.dw.core.utils.z;
import com.kc.dw.platform.BasePlatformLoader;
import com.kc.dw.platform.custom.splash.MsCustomSplashAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class e implements com.kc.dw.core.loader.strategy.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.kc.dw.core.loader.a f39271a;
    public SsdAdInfo b;
    public List<com.kc.dw.core.loader.b> c = Collections.synchronizedList(new ArrayList());
    public List<SdkAdInfo> d = Collections.synchronizedList(new ArrayList());
    public List<com.kc.dw.core.loader.loadbean.a> e;
    public LinkedList<com.kc.dw.core.loader.loadbean.a> f;
    public Map<String, Object> g;
    public volatile boolean h;
    public com.kc.dw.core.loader.concurrent.c i;
    public Handler j;
    public long k;
    public List<com.kc.dw.core.loader.loadbean.a> l;
    public List<com.kc.dw.core.loader.loadbean.a> m;
    public List<com.kc.dw.core.loader.loadbean.a> n;
    public List<com.kc.dw.core.loader.loadbean.a> o;
    public long p;
    public List<com.kc.dw.core.loader.b> q;
    public volatile boolean r;
    public volatile boolean s;
    public boolean t;
    public volatile boolean u;
    public int v;
    public List<Integer> w;
    public List<Integer> x;

    @Keep
    public class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f39272a;

        public a(e eVar) {
            this.f39272a = eVar;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            com.kc.dw.core.loader.concurrent.c cVar = this.f39272a.i;
            if (cVar != null) {
                com.kc.dw.core.loader.concurrent.a aVar = (com.kc.dw.core.loader.concurrent.a) cVar;
                if (aVar.g) {
                    return;
                }
                aVar.g = true;
                aVar.a();
            }
        }
    }

    @Keep
    public class b implements Comparator<Integer> {
        public b(e eVar) {
        }

        @Override // java.util.Comparator
        public int compare(Integer num, Integer num2) {
            return num2.intValue() - num.intValue();
        }
    }

    @Keep
    public class c implements Comparator<Integer> {
        public c(e eVar) {
        }

        @Override // java.util.Comparator
        public int compare(Integer num, Integer num2) {
            return num2.intValue() - num.intValue();
        }
    }

    @Keep
    public class d extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.kc.dw.core.loader.loadbean.a f39273a;
        public final e b;

        @Keep
        public class a implements com.kc.dw.core.loader.concurrent.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final com.kc.dw.core.loader.b f39274a;
            public final d b;

            public a(d dVar, com.kc.dw.core.loader.b bVar) {
                this.b = dVar;
                this.f39274a = bVar;
            }

            @Override // com.kc.dw.core.loader.concurrent.b
            public void a(Object obj, int i, String str) {
                LogUtil.e("PriceFirstStrategy", "onRenderFail :" + str);
                try {
                    d dVar = this.b;
                    e.a(dVar.b, obj, this.f39274a, dVar.f39273a, i, str);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.kc.dw.core.loader.concurrent.b
            public void onLoadedError(int i, String str) {
                LogUtil.e("PriceFirstStrategy", "onAdError: code=" + i + ",msg=  " + str);
                try {
                    AdPlatformError adPlatformError = new AdPlatformError(str, Integer.valueOf(i));
                    d dVar = this.b;
                    e.a(dVar.b, this.f39274a, dVar.f39273a, adPlatformError);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.kc.dw.core.loader.concurrent.b
            public void onLoadedSuccess(Object obj) {
                try {
                    d dVar = this.b;
                    e.a(dVar.b, this.f39274a, dVar.f39273a, obj);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.kc.dw.core.loader.concurrent.b
            public void onRenderSuccess(Object obj) {
                try {
                    d dVar = this.b;
                    e eVar = dVar.b;
                    com.kc.dw.core.loader.loadbean.a aVar = dVar.f39273a;
                    synchronized (eVar) {
                        eVar.m.add(aVar);
                        eVar.a();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public d(e eVar, com.kc.dw.core.loader.loadbean.a aVar) {
            this.b = eVar;
            this.f39273a = aVar;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            try {
                com.kc.dw.core.loader.loadbean.a aVar = this.f39273a;
                if (aVar == null) {
                    return;
                }
                e.a(this.b, aVar);
                SdkAdInfo sdkAdInfo = this.f39273a.f39268a;
                if (sdkAdInfo == null) {
                    return;
                }
                e eVar = this.b;
                com.kc.dw.core.loader.b bVarCreateDelegate = eVar.f39271a.createDelegate(sdkAdInfo, eVar.b);
                if (bVarCreateDelegate == null) {
                    e.a(this.b, bVarCreateDelegate, this.f39273a, (AdPlatformError) null);
                    return;
                }
                if (e.b(this.b, this.f39273a)) {
                    e.a(this.b, bVarCreateDelegate, this.f39273a, (AdPlatformError) null);
                    return;
                }
                bVarCreateDelegate.setLocalParams(this.b.g);
                this.b.getClass();
                bVarCreateDelegate.setGroupIndex(0);
                bVarCreateDelegate.setConCurrentLoadListener(new a(this, bVarCreateDelegate));
                sdkAdInfo.setLoadTime(SystemClock.uptimeMillis());
                sdkAdInfo.setAlreadyLoaded(true);
                com.kc.dw.core.loader.loadbean.a aVar2 = this.f39273a;
                synchronized (aVar2) {
                    aVar2.c = 4;
                }
                bVarCreateDelegate.loadAd();
                this.b.q.add(bVarCreateDelegate);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public e(com.kc.dw.core.loader.a aVar, SsdAdInfo ssdAdInfo) {
        new ArrayList();
        this.f = new LinkedList<>();
        this.j = new Handler();
        this.l = Collections.synchronizedList(new ArrayList());
        this.m = Collections.synchronizedList(new ArrayList());
        this.n = Collections.synchronizedList(new ArrayList());
        Collections.synchronizedList(new ArrayList());
        this.o = Collections.synchronizedList(new ArrayList());
        this.p = 10000L;
        this.q = Collections.synchronizedList(new ArrayList());
        this.v = 1;
        this.w = new ArrayList();
        this.x = new ArrayList();
        this.f39271a = aVar;
        this.b = ssdAdInfo;
    }

    public static void a(e eVar, com.kc.dw.core.loader.b bVar, com.kc.dw.core.loader.loadbean.a aVar, AdPlatformError adPlatformError) {
        synchronized (eVar) {
            if (!eVar.b(aVar)) {
                com.kc.dw.core.service.logrecord.a.a(5, "f2", bVar, new CodeErrorNoMsg().setData(2, adPlatformError != null ? adPlatformError.getCode().intValue() : -1, adPlatformError != null ? adPlatformError.getMessage() : ""));
            }
            synchronized (aVar) {
                aVar.c = 3;
            }
            aVar.f39268a.replaceErrorPst(adPlatformError);
            eVar.e.remove(aVar);
            eVar.h();
            eVar.n.remove(aVar);
            eVar.g();
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0229 A[Catch: all -> 0x026f, TryCatch #5 {, blocks: (B:23:0x008c, B:25:0x00b3, B:27:0x00b9, B:28:0x00c5, B:30:0x00cc, B:31:0x00e2, B:32:0x00ea, B:34:0x00ed, B:35:0x00ee, B:36:0x00f3, B:38:0x00f9, B:39:0x00fa, B:40:0x00fb, B:42:0x0101, B:43:0x0107, B:45:0x010d, B:47:0x011a, B:49:0x0121, B:51:0x012a, B:53:0x012e, B:55:0x0141, B:57:0x016d, B:50:0x0126, B:58:0x0184, B:60:0x0188, B:61:0x018c, B:62:0x018e, B:64:0x0192, B:66:0x0196, B:67:0x019a, B:71:0x01bd, B:73:0x01ca, B:74:0x01cf, B:76:0x01d3, B:78:0x01d6, B:79:0x01d7, B:81:0x01dd, B:92:0x020a, B:94:0x0210, B:95:0x0211, B:70:0x01ba, B:96:0x0212, B:98:0x0216, B:100:0x0229, B:102:0x0255, B:22:0x0089, B:33:0x00eb, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:83:0x01e2, B:85:0x01ea, B:86:0x01ef, B:89:0x01fa, B:77:0x01d4), top: B:113:0x0001, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:102:0x0255 A[Catch: all -> 0x026f, TRY_LEAVE, TryCatch #5 {, blocks: (B:23:0x008c, B:25:0x00b3, B:27:0x00b9, B:28:0x00c5, B:30:0x00cc, B:31:0x00e2, B:32:0x00ea, B:34:0x00ed, B:35:0x00ee, B:36:0x00f3, B:38:0x00f9, B:39:0x00fa, B:40:0x00fb, B:42:0x0101, B:43:0x0107, B:45:0x010d, B:47:0x011a, B:49:0x0121, B:51:0x012a, B:53:0x012e, B:55:0x0141, B:57:0x016d, B:50:0x0126, B:58:0x0184, B:60:0x0188, B:61:0x018c, B:62:0x018e, B:64:0x0192, B:66:0x0196, B:67:0x019a, B:71:0x01bd, B:73:0x01ca, B:74:0x01cf, B:76:0x01d3, B:78:0x01d6, B:79:0x01d7, B:81:0x01dd, B:92:0x020a, B:94:0x0210, B:95:0x0211, B:70:0x01ba, B:96:0x0212, B:98:0x0216, B:100:0x0229, B:102:0x0255, B:22:0x0089, B:33:0x00eb, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:83:0x01e2, B:85:0x01ea, B:86:0x01ef, B:89:0x01fa, B:77:0x01d4), top: B:113:0x0001, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:111:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:0x01e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:0x01d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x00b3 A[Catch: all -> 0x026f, TryCatch #5 {, blocks: (B:23:0x008c, B:25:0x00b3, B:27:0x00b9, B:28:0x00c5, B:30:0x00cc, B:31:0x00e2, B:32:0x00ea, B:34:0x00ed, B:35:0x00ee, B:36:0x00f3, B:38:0x00f9, B:39:0x00fa, B:40:0x00fb, B:42:0x0101, B:43:0x0107, B:45:0x010d, B:47:0x011a, B:49:0x0121, B:51:0x012a, B:53:0x012e, B:55:0x0141, B:57:0x016d, B:50:0x0126, B:58:0x0184, B:60:0x0188, B:61:0x018c, B:62:0x018e, B:64:0x0192, B:66:0x0196, B:67:0x019a, B:71:0x01bd, B:73:0x01ca, B:74:0x01cf, B:76:0x01d3, B:78:0x01d6, B:79:0x01d7, B:81:0x01dd, B:92:0x020a, B:94:0x0210, B:95:0x0211, B:70:0x01ba, B:96:0x0212, B:98:0x0216, B:100:0x0229, B:102:0x0255, B:22:0x0089, B:33:0x00eb, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:83:0x01e2, B:85:0x01ea, B:86:0x01ef, B:89:0x01fa, B:77:0x01d4), top: B:113:0x0001, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x00b9 A[Catch: all -> 0x026f, TryCatch #5 {, blocks: (B:23:0x008c, B:25:0x00b3, B:27:0x00b9, B:28:0x00c5, B:30:0x00cc, B:31:0x00e2, B:32:0x00ea, B:34:0x00ed, B:35:0x00ee, B:36:0x00f3, B:38:0x00f9, B:39:0x00fa, B:40:0x00fb, B:42:0x0101, B:43:0x0107, B:45:0x010d, B:47:0x011a, B:49:0x0121, B:51:0x012a, B:53:0x012e, B:55:0x0141, B:57:0x016d, B:50:0x0126, B:58:0x0184, B:60:0x0188, B:61:0x018c, B:62:0x018e, B:64:0x0192, B:66:0x0196, B:67:0x019a, B:71:0x01bd, B:73:0x01ca, B:74:0x01cf, B:76:0x01d3, B:78:0x01d6, B:79:0x01d7, B:81:0x01dd, B:92:0x020a, B:94:0x0210, B:95:0x0211, B:70:0x01ba, B:96:0x0212, B:98:0x0216, B:100:0x0229, B:102:0x0255, B:22:0x0089, B:33:0x00eb, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:83:0x01e2, B:85:0x01ea, B:86:0x01ef, B:89:0x01fa, B:77:0x01d4), top: B:113:0x0001, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x00c5 A[Catch: all -> 0x026f, TryCatch #5 {, blocks: (B:23:0x008c, B:25:0x00b3, B:27:0x00b9, B:28:0x00c5, B:30:0x00cc, B:31:0x00e2, B:32:0x00ea, B:34:0x00ed, B:35:0x00ee, B:36:0x00f3, B:38:0x00f9, B:39:0x00fa, B:40:0x00fb, B:42:0x0101, B:43:0x0107, B:45:0x010d, B:47:0x011a, B:49:0x0121, B:51:0x012a, B:53:0x012e, B:55:0x0141, B:57:0x016d, B:50:0x0126, B:58:0x0184, B:60:0x0188, B:61:0x018c, B:62:0x018e, B:64:0x0192, B:66:0x0196, B:67:0x019a, B:71:0x01bd, B:73:0x01ca, B:74:0x01cf, B:76:0x01d3, B:78:0x01d6, B:79:0x01d7, B:81:0x01dd, B:92:0x020a, B:94:0x0210, B:95:0x0211, B:70:0x01ba, B:96:0x0212, B:98:0x0216, B:100:0x0229, B:102:0x0255, B:22:0x0089, B:33:0x00eb, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:83:0x01e2, B:85:0x01ea, B:86:0x01ef, B:89:0x01fa, B:77:0x01d4), top: B:113:0x0001, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x00cc A[Catch: all -> 0x026f, TryCatch #5 {, blocks: (B:23:0x008c, B:25:0x00b3, B:27:0x00b9, B:28:0x00c5, B:30:0x00cc, B:31:0x00e2, B:32:0x00ea, B:34:0x00ed, B:35:0x00ee, B:36:0x00f3, B:38:0x00f9, B:39:0x00fa, B:40:0x00fb, B:42:0x0101, B:43:0x0107, B:45:0x010d, B:47:0x011a, B:49:0x0121, B:51:0x012a, B:53:0x012e, B:55:0x0141, B:57:0x016d, B:50:0x0126, B:58:0x0184, B:60:0x0188, B:61:0x018c, B:62:0x018e, B:64:0x0192, B:66:0x0196, B:67:0x019a, B:71:0x01bd, B:73:0x01ca, B:74:0x01cf, B:76:0x01d3, B:78:0x01d6, B:79:0x01d7, B:81:0x01dd, B:92:0x020a, B:94:0x0210, B:95:0x0211, B:70:0x01ba, B:96:0x0212, B:98:0x0216, B:100:0x0229, B:102:0x0255, B:22:0x0089, B:33:0x00eb, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:83:0x01e2, B:85:0x01ea, B:86:0x01ef, B:89:0x01fa, B:77:0x01d4), top: B:113:0x0001, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0101 A[Catch: all -> 0x026f, TryCatch #5 {, blocks: (B:23:0x008c, B:25:0x00b3, B:27:0x00b9, B:28:0x00c5, B:30:0x00cc, B:31:0x00e2, B:32:0x00ea, B:34:0x00ed, B:35:0x00ee, B:36:0x00f3, B:38:0x00f9, B:39:0x00fa, B:40:0x00fb, B:42:0x0101, B:43:0x0107, B:45:0x010d, B:47:0x011a, B:49:0x0121, B:51:0x012a, B:53:0x012e, B:55:0x0141, B:57:0x016d, B:50:0x0126, B:58:0x0184, B:60:0x0188, B:61:0x018c, B:62:0x018e, B:64:0x0192, B:66:0x0196, B:67:0x019a, B:71:0x01bd, B:73:0x01ca, B:74:0x01cf, B:76:0x01d3, B:78:0x01d6, B:79:0x01d7, B:81:0x01dd, B:92:0x020a, B:94:0x0210, B:95:0x0211, B:70:0x01ba, B:96:0x0212, B:98:0x0216, B:100:0x0229, B:102:0x0255, B:22:0x0089, B:33:0x00eb, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:83:0x01e2, B:85:0x01ea, B:86:0x01ef, B:89:0x01fa, B:77:0x01d4), top: B:113:0x0001, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x010d A[Catch: all -> 0x026f, TryCatch #5 {, blocks: (B:23:0x008c, B:25:0x00b3, B:27:0x00b9, B:28:0x00c5, B:30:0x00cc, B:31:0x00e2, B:32:0x00ea, B:34:0x00ed, B:35:0x00ee, B:36:0x00f3, B:38:0x00f9, B:39:0x00fa, B:40:0x00fb, B:42:0x0101, B:43:0x0107, B:45:0x010d, B:47:0x011a, B:49:0x0121, B:51:0x012a, B:53:0x012e, B:55:0x0141, B:57:0x016d, B:50:0x0126, B:58:0x0184, B:60:0x0188, B:61:0x018c, B:62:0x018e, B:64:0x0192, B:66:0x0196, B:67:0x019a, B:71:0x01bd, B:73:0x01ca, B:74:0x01cf, B:76:0x01d3, B:78:0x01d6, B:79:0x01d7, B:81:0x01dd, B:92:0x020a, B:94:0x0210, B:95:0x0211, B:70:0x01ba, B:96:0x0212, B:98:0x0216, B:100:0x0229, B:102:0x0255, B:22:0x0089, B:33:0x00eb, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:83:0x01e2, B:85:0x01ea, B:86:0x01ef, B:89:0x01fa, B:77:0x01d4), top: B:113:0x0001, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x011a A[Catch: all -> 0x026f, TryCatch #5 {, blocks: (B:23:0x008c, B:25:0x00b3, B:27:0x00b9, B:28:0x00c5, B:30:0x00cc, B:31:0x00e2, B:32:0x00ea, B:34:0x00ed, B:35:0x00ee, B:36:0x00f3, B:38:0x00f9, B:39:0x00fa, B:40:0x00fb, B:42:0x0101, B:43:0x0107, B:45:0x010d, B:47:0x011a, B:49:0x0121, B:51:0x012a, B:53:0x012e, B:55:0x0141, B:57:0x016d, B:50:0x0126, B:58:0x0184, B:60:0x0188, B:61:0x018c, B:62:0x018e, B:64:0x0192, B:66:0x0196, B:67:0x019a, B:71:0x01bd, B:73:0x01ca, B:74:0x01cf, B:76:0x01d3, B:78:0x01d6, B:79:0x01d7, B:81:0x01dd, B:92:0x020a, B:94:0x0210, B:95:0x0211, B:70:0x01ba, B:96:0x0212, B:98:0x0216, B:100:0x0229, B:102:0x0255, B:22:0x0089, B:33:0x00eb, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:83:0x01e2, B:85:0x01ea, B:86:0x01ef, B:89:0x01fa, B:77:0x01d4), top: B:113:0x0001, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0121 A[Catch: all -> 0x026f, TryCatch #5 {, blocks: (B:23:0x008c, B:25:0x00b3, B:27:0x00b9, B:28:0x00c5, B:30:0x00cc, B:31:0x00e2, B:32:0x00ea, B:34:0x00ed, B:35:0x00ee, B:36:0x00f3, B:38:0x00f9, B:39:0x00fa, B:40:0x00fb, B:42:0x0101, B:43:0x0107, B:45:0x010d, B:47:0x011a, B:49:0x0121, B:51:0x012a, B:53:0x012e, B:55:0x0141, B:57:0x016d, B:50:0x0126, B:58:0x0184, B:60:0x0188, B:61:0x018c, B:62:0x018e, B:64:0x0192, B:66:0x0196, B:67:0x019a, B:71:0x01bd, B:73:0x01ca, B:74:0x01cf, B:76:0x01d3, B:78:0x01d6, B:79:0x01d7, B:81:0x01dd, B:92:0x020a, B:94:0x0210, B:95:0x0211, B:70:0x01ba, B:96:0x0212, B:98:0x0216, B:100:0x0229, B:102:0x0255, B:22:0x0089, B:33:0x00eb, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:83:0x01e2, B:85:0x01ea, B:86:0x01ef, B:89:0x01fa, B:77:0x01d4), top: B:113:0x0001, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0126 A[Catch: all -> 0x026f, TryCatch #5 {, blocks: (B:23:0x008c, B:25:0x00b3, B:27:0x00b9, B:28:0x00c5, B:30:0x00cc, B:31:0x00e2, B:32:0x00ea, B:34:0x00ed, B:35:0x00ee, B:36:0x00f3, B:38:0x00f9, B:39:0x00fa, B:40:0x00fb, B:42:0x0101, B:43:0x0107, B:45:0x010d, B:47:0x011a, B:49:0x0121, B:51:0x012a, B:53:0x012e, B:55:0x0141, B:57:0x016d, B:50:0x0126, B:58:0x0184, B:60:0x0188, B:61:0x018c, B:62:0x018e, B:64:0x0192, B:66:0x0196, B:67:0x019a, B:71:0x01bd, B:73:0x01ca, B:74:0x01cf, B:76:0x01d3, B:78:0x01d6, B:79:0x01d7, B:81:0x01dd, B:92:0x020a, B:94:0x0210, B:95:0x0211, B:70:0x01ba, B:96:0x0212, B:98:0x0216, B:100:0x0229, B:102:0x0255, B:22:0x0089, B:33:0x00eb, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:83:0x01e2, B:85:0x01ea, B:86:0x01ef, B:89:0x01fa, B:77:0x01d4), top: B:113:0x0001, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x012e A[Catch: all -> 0x026f, TryCatch #5 {, blocks: (B:23:0x008c, B:25:0x00b3, B:27:0x00b9, B:28:0x00c5, B:30:0x00cc, B:31:0x00e2, B:32:0x00ea, B:34:0x00ed, B:35:0x00ee, B:36:0x00f3, B:38:0x00f9, B:39:0x00fa, B:40:0x00fb, B:42:0x0101, B:43:0x0107, B:45:0x010d, B:47:0x011a, B:49:0x0121, B:51:0x012a, B:53:0x012e, B:55:0x0141, B:57:0x016d, B:50:0x0126, B:58:0x0184, B:60:0x0188, B:61:0x018c, B:62:0x018e, B:64:0x0192, B:66:0x0196, B:67:0x019a, B:71:0x01bd, B:73:0x01ca, B:74:0x01cf, B:76:0x01d3, B:78:0x01d6, B:79:0x01d7, B:81:0x01dd, B:92:0x020a, B:94:0x0210, B:95:0x0211, B:70:0x01ba, B:96:0x0212, B:98:0x0216, B:100:0x0229, B:102:0x0255, B:22:0x0089, B:33:0x00eb, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:83:0x01e2, B:85:0x01ea, B:86:0x01ef, B:89:0x01fa, B:77:0x01d4), top: B:113:0x0001, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0141 A[Catch: all -> 0x026f, TryCatch #5 {, blocks: (B:23:0x008c, B:25:0x00b3, B:27:0x00b9, B:28:0x00c5, B:30:0x00cc, B:31:0x00e2, B:32:0x00ea, B:34:0x00ed, B:35:0x00ee, B:36:0x00f3, B:38:0x00f9, B:39:0x00fa, B:40:0x00fb, B:42:0x0101, B:43:0x0107, B:45:0x010d, B:47:0x011a, B:49:0x0121, B:51:0x012a, B:53:0x012e, B:55:0x0141, B:57:0x016d, B:50:0x0126, B:58:0x0184, B:60:0x0188, B:61:0x018c, B:62:0x018e, B:64:0x0192, B:66:0x0196, B:67:0x019a, B:71:0x01bd, B:73:0x01ca, B:74:0x01cf, B:76:0x01d3, B:78:0x01d6, B:79:0x01d7, B:81:0x01dd, B:92:0x020a, B:94:0x0210, B:95:0x0211, B:70:0x01ba, B:96:0x0212, B:98:0x0216, B:100:0x0229, B:102:0x0255, B:22:0x0089, B:33:0x00eb, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:83:0x01e2, B:85:0x01ea, B:86:0x01ef, B:89:0x01fa, B:77:0x01d4), top: B:113:0x0001, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x016d A[Catch: all -> 0x026f, TryCatch #5 {, blocks: (B:23:0x008c, B:25:0x00b3, B:27:0x00b9, B:28:0x00c5, B:30:0x00cc, B:31:0x00e2, B:32:0x00ea, B:34:0x00ed, B:35:0x00ee, B:36:0x00f3, B:38:0x00f9, B:39:0x00fa, B:40:0x00fb, B:42:0x0101, B:43:0x0107, B:45:0x010d, B:47:0x011a, B:49:0x0121, B:51:0x012a, B:53:0x012e, B:55:0x0141, B:57:0x016d, B:50:0x0126, B:58:0x0184, B:60:0x0188, B:61:0x018c, B:62:0x018e, B:64:0x0192, B:66:0x0196, B:67:0x019a, B:71:0x01bd, B:73:0x01ca, B:74:0x01cf, B:76:0x01d3, B:78:0x01d6, B:79:0x01d7, B:81:0x01dd, B:92:0x020a, B:94:0x0210, B:95:0x0211, B:70:0x01ba, B:96:0x0212, B:98:0x0216, B:100:0x0229, B:102:0x0255, B:22:0x0089, B:33:0x00eb, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:83:0x01e2, B:85:0x01ea, B:86:0x01ef, B:89:0x01fa, B:77:0x01d4), top: B:113:0x0001, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x0184 A[Catch: all -> 0x026f, TryCatch #5 {, blocks: (B:23:0x008c, B:25:0x00b3, B:27:0x00b9, B:28:0x00c5, B:30:0x00cc, B:31:0x00e2, B:32:0x00ea, B:34:0x00ed, B:35:0x00ee, B:36:0x00f3, B:38:0x00f9, B:39:0x00fa, B:40:0x00fb, B:42:0x0101, B:43:0x0107, B:45:0x010d, B:47:0x011a, B:49:0x0121, B:51:0x012a, B:53:0x012e, B:55:0x0141, B:57:0x016d, B:50:0x0126, B:58:0x0184, B:60:0x0188, B:61:0x018c, B:62:0x018e, B:64:0x0192, B:66:0x0196, B:67:0x019a, B:71:0x01bd, B:73:0x01ca, B:74:0x01cf, B:76:0x01d3, B:78:0x01d6, B:79:0x01d7, B:81:0x01dd, B:92:0x020a, B:94:0x0210, B:95:0x0211, B:70:0x01ba, B:96:0x0212, B:98:0x0216, B:100:0x0229, B:102:0x0255, B:22:0x0089, B:33:0x00eb, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:83:0x01e2, B:85:0x01ea, B:86:0x01ef, B:89:0x01fa, B:77:0x01d4), top: B:113:0x0001, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0188 A[Catch: all -> 0x026f, TryCatch #5 {, blocks: (B:23:0x008c, B:25:0x00b3, B:27:0x00b9, B:28:0x00c5, B:30:0x00cc, B:31:0x00e2, B:32:0x00ea, B:34:0x00ed, B:35:0x00ee, B:36:0x00f3, B:38:0x00f9, B:39:0x00fa, B:40:0x00fb, B:42:0x0101, B:43:0x0107, B:45:0x010d, B:47:0x011a, B:49:0x0121, B:51:0x012a, B:53:0x012e, B:55:0x0141, B:57:0x016d, B:50:0x0126, B:58:0x0184, B:60:0x0188, B:61:0x018c, B:62:0x018e, B:64:0x0192, B:66:0x0196, B:67:0x019a, B:71:0x01bd, B:73:0x01ca, B:74:0x01cf, B:76:0x01d3, B:78:0x01d6, B:79:0x01d7, B:81:0x01dd, B:92:0x020a, B:94:0x0210, B:95:0x0211, B:70:0x01ba, B:96:0x0212, B:98:0x0216, B:100:0x0229, B:102:0x0255, B:22:0x0089, B:33:0x00eb, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:83:0x01e2, B:85:0x01ea, B:86:0x01ef, B:89:0x01fa, B:77:0x01d4), top: B:113:0x0001, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x018c A[Catch: all -> 0x026f, TryCatch #5 {, blocks: (B:23:0x008c, B:25:0x00b3, B:27:0x00b9, B:28:0x00c5, B:30:0x00cc, B:31:0x00e2, B:32:0x00ea, B:34:0x00ed, B:35:0x00ee, B:36:0x00f3, B:38:0x00f9, B:39:0x00fa, B:40:0x00fb, B:42:0x0101, B:43:0x0107, B:45:0x010d, B:47:0x011a, B:49:0x0121, B:51:0x012a, B:53:0x012e, B:55:0x0141, B:57:0x016d, B:50:0x0126, B:58:0x0184, B:60:0x0188, B:61:0x018c, B:62:0x018e, B:64:0x0192, B:66:0x0196, B:67:0x019a, B:71:0x01bd, B:73:0x01ca, B:74:0x01cf, B:76:0x01d3, B:78:0x01d6, B:79:0x01d7, B:81:0x01dd, B:92:0x020a, B:94:0x0210, B:95:0x0211, B:70:0x01ba, B:96:0x0212, B:98:0x0216, B:100:0x0229, B:102:0x0255, B:22:0x0089, B:33:0x00eb, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:83:0x01e2, B:85:0x01ea, B:86:0x01ef, B:89:0x01fa, B:77:0x01d4), top: B:113:0x0001, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x0192 A[Catch: all -> 0x026f, TryCatch #5 {, blocks: (B:23:0x008c, B:25:0x00b3, B:27:0x00b9, B:28:0x00c5, B:30:0x00cc, B:31:0x00e2, B:32:0x00ea, B:34:0x00ed, B:35:0x00ee, B:36:0x00f3, B:38:0x00f9, B:39:0x00fa, B:40:0x00fb, B:42:0x0101, B:43:0x0107, B:45:0x010d, B:47:0x011a, B:49:0x0121, B:51:0x012a, B:53:0x012e, B:55:0x0141, B:57:0x016d, B:50:0x0126, B:58:0x0184, B:60:0x0188, B:61:0x018c, B:62:0x018e, B:64:0x0192, B:66:0x0196, B:67:0x019a, B:71:0x01bd, B:73:0x01ca, B:74:0x01cf, B:76:0x01d3, B:78:0x01d6, B:79:0x01d7, B:81:0x01dd, B:92:0x020a, B:94:0x0210, B:95:0x0211, B:70:0x01ba, B:96:0x0212, B:98:0x0216, B:100:0x0229, B:102:0x0255, B:22:0x0089, B:33:0x00eb, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:83:0x01e2, B:85:0x01ea, B:86:0x01ef, B:89:0x01fa, B:77:0x01d4), top: B:113:0x0001, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0196 A[Catch: all -> 0x026f, TRY_LEAVE, TryCatch #5 {, blocks: (B:23:0x008c, B:25:0x00b3, B:27:0x00b9, B:28:0x00c5, B:30:0x00cc, B:31:0x00e2, B:32:0x00ea, B:34:0x00ed, B:35:0x00ee, B:36:0x00f3, B:38:0x00f9, B:39:0x00fa, B:40:0x00fb, B:42:0x0101, B:43:0x0107, B:45:0x010d, B:47:0x011a, B:49:0x0121, B:51:0x012a, B:53:0x012e, B:55:0x0141, B:57:0x016d, B:50:0x0126, B:58:0x0184, B:60:0x0188, B:61:0x018c, B:62:0x018e, B:64:0x0192, B:66:0x0196, B:67:0x019a, B:71:0x01bd, B:73:0x01ca, B:74:0x01cf, B:76:0x01d3, B:78:0x01d6, B:79:0x01d7, B:81:0x01dd, B:92:0x020a, B:94:0x0210, B:95:0x0211, B:70:0x01ba, B:96:0x0212, B:98:0x0216, B:100:0x0229, B:102:0x0255, B:22:0x0089, B:33:0x00eb, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:83:0x01e2, B:85:0x01ea, B:86:0x01ef, B:89:0x01fa, B:77:0x01d4), top: B:113:0x0001, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x01ca A[Catch: all -> 0x026f, TryCatch #5 {, blocks: (B:23:0x008c, B:25:0x00b3, B:27:0x00b9, B:28:0x00c5, B:30:0x00cc, B:31:0x00e2, B:32:0x00ea, B:34:0x00ed, B:35:0x00ee, B:36:0x00f3, B:38:0x00f9, B:39:0x00fa, B:40:0x00fb, B:42:0x0101, B:43:0x0107, B:45:0x010d, B:47:0x011a, B:49:0x0121, B:51:0x012a, B:53:0x012e, B:55:0x0141, B:57:0x016d, B:50:0x0126, B:58:0x0184, B:60:0x0188, B:61:0x018c, B:62:0x018e, B:64:0x0192, B:66:0x0196, B:67:0x019a, B:71:0x01bd, B:73:0x01ca, B:74:0x01cf, B:76:0x01d3, B:78:0x01d6, B:79:0x01d7, B:81:0x01dd, B:92:0x020a, B:94:0x0210, B:95:0x0211, B:70:0x01ba, B:96:0x0212, B:98:0x0216, B:100:0x0229, B:102:0x0255, B:22:0x0089, B:33:0x00eb, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:83:0x01e2, B:85:0x01ea, B:86:0x01ef, B:89:0x01fa, B:77:0x01d4), top: B:113:0x0001, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x01d3 A[Catch: all -> 0x026f, TRY_LEAVE, TryCatch #5 {, blocks: (B:23:0x008c, B:25:0x00b3, B:27:0x00b9, B:28:0x00c5, B:30:0x00cc, B:31:0x00e2, B:32:0x00ea, B:34:0x00ed, B:35:0x00ee, B:36:0x00f3, B:38:0x00f9, B:39:0x00fa, B:40:0x00fb, B:42:0x0101, B:43:0x0107, B:45:0x010d, B:47:0x011a, B:49:0x0121, B:51:0x012a, B:53:0x012e, B:55:0x0141, B:57:0x016d, B:50:0x0126, B:58:0x0184, B:60:0x0188, B:61:0x018c, B:62:0x018e, B:64:0x0192, B:66:0x0196, B:67:0x019a, B:71:0x01bd, B:73:0x01ca, B:74:0x01cf, B:76:0x01d3, B:78:0x01d6, B:79:0x01d7, B:81:0x01dd, B:92:0x020a, B:94:0x0210, B:95:0x0211, B:70:0x01ba, B:96:0x0212, B:98:0x0216, B:100:0x0229, B:102:0x0255, B:22:0x0089, B:33:0x00eb, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:83:0x01e2, B:85:0x01ea, B:86:0x01ef, B:89:0x01fa, B:77:0x01d4), top: B:113:0x0001, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x01dd A[Catch: all -> 0x026f, TRY_LEAVE, TryCatch #5 {, blocks: (B:23:0x008c, B:25:0x00b3, B:27:0x00b9, B:28:0x00c5, B:30:0x00cc, B:31:0x00e2, B:32:0x00ea, B:34:0x00ed, B:35:0x00ee, B:36:0x00f3, B:38:0x00f9, B:39:0x00fa, B:40:0x00fb, B:42:0x0101, B:43:0x0107, B:45:0x010d, B:47:0x011a, B:49:0x0121, B:51:0x012a, B:53:0x012e, B:55:0x0141, B:57:0x016d, B:50:0x0126, B:58:0x0184, B:60:0x0188, B:61:0x018c, B:62:0x018e, B:64:0x0192, B:66:0x0196, B:67:0x019a, B:71:0x01bd, B:73:0x01ca, B:74:0x01cf, B:76:0x01d3, B:78:0x01d6, B:79:0x01d7, B:81:0x01dd, B:92:0x020a, B:94:0x0210, B:95:0x0211, B:70:0x01ba, B:96:0x0212, B:98:0x0216, B:100:0x0229, B:102:0x0255, B:22:0x0089, B:33:0x00eb, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:83:0x01e2, B:85:0x01ea, B:86:0x01ef, B:89:0x01fa, B:77:0x01d4), top: B:113:0x0001, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x01ea A[Catch: all -> 0x0209, TryCatch #3 {all -> 0x0209, blocks: (B:83:0x01e2, B:85:0x01ea, B:86:0x01ef, B:89:0x01fa), top: B:115:0x01e2, outer: #5 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:89:0x01fa A[Catch: all -> 0x0209, TRY_LEAVE, TryCatch #3 {all -> 0x0209, blocks: (B:83:0x01e2, B:85:0x01ea, B:86:0x01ef, B:89:0x01fa), top: B:115:0x01e2, outer: #5 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x0212 A[Catch: all -> 0x026f, TryCatch #5 {, blocks: (B:23:0x008c, B:25:0x00b3, B:27:0x00b9, B:28:0x00c5, B:30:0x00cc, B:31:0x00e2, B:32:0x00ea, B:34:0x00ed, B:35:0x00ee, B:36:0x00f3, B:38:0x00f9, B:39:0x00fa, B:40:0x00fb, B:42:0x0101, B:43:0x0107, B:45:0x010d, B:47:0x011a, B:49:0x0121, B:51:0x012a, B:53:0x012e, B:55:0x0141, B:57:0x016d, B:50:0x0126, B:58:0x0184, B:60:0x0188, B:61:0x018c, B:62:0x018e, B:64:0x0192, B:66:0x0196, B:67:0x019a, B:71:0x01bd, B:73:0x01ca, B:74:0x01cf, B:76:0x01d3, B:78:0x01d6, B:79:0x01d7, B:81:0x01dd, B:92:0x020a, B:94:0x0210, B:95:0x0211, B:70:0x01ba, B:96:0x0212, B:98:0x0216, B:100:0x0229, B:102:0x0255, B:22:0x0089, B:33:0x00eb, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:83:0x01e2, B:85:0x01ea, B:86:0x01ef, B:89:0x01fa, B:77:0x01d4), top: B:113:0x0001, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0216 A[Catch: all -> 0x026f, TryCatch #5 {, blocks: (B:23:0x008c, B:25:0x00b3, B:27:0x00b9, B:28:0x00c5, B:30:0x00cc, B:31:0x00e2, B:32:0x00ea, B:34:0x00ed, B:35:0x00ee, B:36:0x00f3, B:38:0x00f9, B:39:0x00fa, B:40:0x00fb, B:42:0x0101, B:43:0x0107, B:45:0x010d, B:47:0x011a, B:49:0x0121, B:51:0x012a, B:53:0x012e, B:55:0x0141, B:57:0x016d, B:50:0x0126, B:58:0x0184, B:60:0x0188, B:61:0x018c, B:62:0x018e, B:64:0x0192, B:66:0x0196, B:67:0x019a, B:71:0x01bd, B:73:0x01ca, B:74:0x01cf, B:76:0x01d3, B:78:0x01d6, B:79:0x01d7, B:81:0x01dd, B:92:0x020a, B:94:0x0210, B:95:0x0211, B:70:0x01ba, B:96:0x0212, B:98:0x0216, B:100:0x0229, B:102:0x0255, B:22:0x0089, B:33:0x00eb, B:3:0x0001, B:6:0x001b, B:8:0x002b, B:10:0x003b, B:12:0x004b, B:14:0x005b, B:15:0x0060, B:17:0x0070, B:19:0x007e, B:83:0x01e2, B:85:0x01ea, B:86:0x01ef, B:89:0x01fa, B:77:0x01d4), top: B:113:0x0001, inners: #0, #1, #2, #3, #4 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:100:0x0229, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:55:0x0141, please report this as an issue */
    public static void a(e eVar, com.kc.dw.core.loader.b bVar, com.kc.dw.core.loader.loadbean.a aVar, Object obj) {
        String err;
        String strReplace;
        String err2;
        String strReplace2;
        synchronized (eVar) {
            try {
                int ecpm = bVar.getSdkAdInfo().getEcpm();
                if ("bidding".equals(bVar.getSdkAdInfo().getOtype()) && ecpm > 0 && ("GDT".equals(bVar.getSdkAdInfo().getSdk()) || "KS".equals(bVar.getSdkAdInfo().getSdk()) || "BAIDU".equals(bVar.getSdkAdInfo().getSdk()) || "SGM".equals(bVar.getSdkAdInfo().getSdk()))) {
                    eVar.c.add(bVar);
                }
                if (!"GDT".equals(bVar.getSdkAdInfo().getSdk()) || TextUtils.isEmpty(bVar.getSdkAdInfo().getS2sb())) {
                    eVar.n.remove(aVar);
                    aVar.getClass();
                    aVar.f39268a.setLoadedTime(SystemClock.uptimeMillis());
                    aVar.f39268a.replace();
                    aVar.b = obj;
                    if ("bidding".equals(aVar.f39268a.getOtype())) {
                        if (eVar.a(aVar)) {
                            if (!eVar.b(aVar)) {
                                com.kc.dw.core.service.logrecord.a.a(5, "f2", bVar, new CodeErrorNoMsg().setData(3, com.kc.dw.core.exception.b.b.intValue(), ""));
                            }
                            eVar.e.remove(aVar);
                            eVar.h();
                            synchronized (aVar) {
                                aVar.c = 3;
                            }
                            eVar.n.remove(aVar);
                            eVar.g();
                        } else {
                            aVar.f = aVar.f39268a.getEcpm() + aVar.e;
                        }
                    }
                    if (!eVar.b(aVar)) {
                        com.kc.dw.core.service.logrecord.a.a(5, "s2", bVar);
                    }
                    if (eVar.h) {
                        if (SystemClock.uptimeMillis() - eVar.k > eVar.p) {
                            eVar.u = true;
                            if (aVar.d == 2) {
                                aVar.d = 10;
                            } else {
                                aVar.d = 8;
                            }
                            if (aVar.f39268a != null) {
                                eVar.e.remove(aVar);
                                err2 = aVar.f39268a.getErr();
                                if (err2.contains("__MS_ERRNO__")) {
                                    strReplace2 = err2.replace("__MS_ERRNO__", "1025").replace("__TIMEOUT__", aVar.d + "");
                                    aVar.f39268a.setErr(strReplace2);
                                    if (!TextUtils.isEmpty(strReplace2)) {
                                        z.a(eVar.f39271a.getContext().getApplicationContext(), g0.a(strReplace2), new com.kc.dw.core.utils.j());
                                    }
                                }
                            }
                        } else if (aVar.d == 2) {
                            aVar.d = 6;
                        } else {
                            aVar.d = 4;
                        }
                    }
                    if (!eVar.u) {
                        if (!eVar.h) {
                            try {
                                z.a(bVar.getContext(), g0.a(aVar.f39268a.getRsp().replace("__TIMEOUT__", String.valueOf(aVar.d))), new com.kc.dw.core.utils.j());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            eVar.e.remove(aVar);
                            if (!eVar.l.contains(aVar)) {
                                eVar.l.add(aVar);
                            }
                            if (aVar.c == 4) {
                                synchronized (aVar) {
                                    aVar.c = 2;
                                }
                                if (eVar.d(aVar)) {
                                    eVar.c(aVar);
                                } else {
                                    try {
                                        if (!eVar.l.contains(aVar)) {
                                            eVar.l.add(aVar);
                                        }
                                        eVar.e.remove(aVar);
                                        if (eVar.h) {
                                            Collections.sort(eVar.l, new com.kc.dw.core.loader.strategy.d(eVar));
                                            eVar.h();
                                        }
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }
                            }
                        } else if (aVar.f39268a != null) {
                            eVar.e.remove(aVar);
                            err = aVar.f39268a.getErr();
                            if (err.contains("__MS_ERRNO__")) {
                                strReplace = err.replace("__MS_ERRNO__", "1025").replace("__TIMEOUT__", aVar.d + "");
                                aVar.f39268a.setErr(strReplace);
                                if (!TextUtils.isEmpty(strReplace)) {
                                    z.a(eVar.f39271a.getContext().getApplicationContext(), g0.a(strReplace), new com.kc.dw.core.utils.j());
                                }
                            }
                        }
                    }
                    eVar.g();
                } else {
                    eVar.d.add(bVar.getSdkAdInfo());
                    eVar.n.remove(aVar);
                    aVar.getClass();
                    aVar.f39268a.setLoadedTime(SystemClock.uptimeMillis());
                    aVar.f39268a.replace();
                    aVar.b = obj;
                    if ("bidding".equals(aVar.f39268a.getOtype())) {
                        if (eVar.a(aVar)) {
                            aVar.f = aVar.f39268a.getEcpm() + aVar.e;
                        } else {
                            if (!eVar.b(aVar)) {
                                com.kc.dw.core.service.logrecord.a.a(5, "f2", bVar, new CodeErrorNoMsg().setData(3, com.kc.dw.core.exception.b.b.intValue(), ""));
                            }
                            eVar.e.remove(aVar);
                            eVar.h();
                            synchronized (aVar) {
                                aVar.c = 3;
                                eVar.n.remove(aVar);
                                eVar.g();
                            }
                        }
                    }
                    if (!eVar.b(aVar)) {
                        com.kc.dw.core.service.logrecord.a.a(5, "s2", bVar);
                    }
                    if (eVar.h) {
                        if (SystemClock.uptimeMillis() - eVar.k > eVar.p) {
                            eVar.u = true;
                            if (aVar.d == 2) {
                                aVar.d = 10;
                            } else {
                                aVar.d = 8;
                            }
                            if (aVar.f39268a != null) {
                                eVar.e.remove(aVar);
                                err2 = aVar.f39268a.getErr();
                                if (err2.contains("__MS_ERRNO__")) {
                                    strReplace2 = err2.replace("__MS_ERRNO__", "1025").replace("__TIMEOUT__", aVar.d + "");
                                    aVar.f39268a.setErr(strReplace2);
                                    if (!TextUtils.isEmpty(strReplace2)) {
                                        z.a(eVar.f39271a.getContext().getApplicationContext(), g0.a(strReplace2), new com.kc.dw.core.utils.j());
                                    }
                                }
                            }
                        } else if (aVar.d == 2) {
                            aVar.d = 6;
                        } else {
                            aVar.d = 4;
                        }
                    }
                    if (!eVar.u) {
                        if (!eVar.h) {
                            z.a(bVar.getContext(), g0.a(aVar.f39268a.getRsp().replace("__TIMEOUT__", String.valueOf(aVar.d))), new com.kc.dw.core.utils.j());
                            eVar.e.remove(aVar);
                            if (!eVar.l.contains(aVar)) {
                                eVar.l.add(aVar);
                            }
                            if (aVar.c == 4) {
                                synchronized (aVar) {
                                    aVar.c = 2;
                                    if (eVar.d(aVar)) {
                                        eVar.c(aVar);
                                    } else {
                                        if (!eVar.l.contains(aVar)) {
                                            eVar.l.add(aVar);
                                        }
                                        eVar.e.remove(aVar);
                                        if (eVar.h) {
                                            Collections.sort(eVar.l, new com.kc.dw.core.loader.strategy.d(eVar));
                                            eVar.h();
                                        }
                                    }
                                }
                            }
                        } else if (aVar.f39268a != null) {
                            eVar.e.remove(aVar);
                            err = aVar.f39268a.getErr();
                            if (err.contains("__MS_ERRNO__")) {
                                strReplace = err.replace("__MS_ERRNO__", "1025").replace("__TIMEOUT__", aVar.d + "");
                                aVar.f39268a.setErr(strReplace);
                                if (!TextUtils.isEmpty(strReplace)) {
                                    z.a(eVar.f39271a.getContext().getApplicationContext(), g0.a(strReplace), new com.kc.dw.core.utils.j());
                                }
                            }
                        }
                    }
                    eVar.g();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            throw th;
        }
    }

    public static void a(e eVar, com.kc.dw.core.loader.loadbean.a aVar) {
        Exception e;
        long all_timeout;
        eVar.getClass();
        long jMin = 0;
        long once_timeout = 10000;
        try {
            all_timeout = eVar.b.getAll_timeout() > 0 ? eVar.b.getAll_timeout() : 10000L;
            try {
                if (eVar.b.getOnce_timeout() > 0) {
                    once_timeout = eVar.b.getOnce_timeout();
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (Exception e3) {
            e = e3;
            all_timeout = 10000;
        }
        try {
            long jUptimeMillis = all_timeout - (SystemClock.uptimeMillis() - eVar.k);
            if (jUptimeMillis > 0) {
                jMin = Math.min(jUptimeMillis, once_timeout);
            }
            eVar.j.postDelayed(new com.kc.dw.core.loader.strategy.c(eVar, aVar), jMin);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static void a(e eVar, Object obj, com.kc.dw.core.loader.b bVar, com.kc.dw.core.loader.loadbean.a aVar, int i, String str) {
        com.kc.dw.core.loader.concurrent.c cVar;
        SdkAdInfo sdkAdInfo;
        synchronized (eVar) {
            synchronized (eVar) {
                eVar.e.remove(aVar);
                if (aVar != null && (sdkAdInfo = aVar.f39268a) != null) {
                    s1.a(sdkAdInfo.getEventUrl(), 12, i, str);
                    String strReplace = aVar.f39268a.getErr().replace("__MS_ERRNO__", "1026").replace("__ERROR_CODE__", String.valueOf(i)).replace("__TIMEOUT__", String.valueOf(aVar.d));
                    if (!TextUtils.isEmpty(strReplace)) {
                        z.a(eVar.f39271a.getContext().getApplicationContext(), g0.a(strReplace), new com.kc.dw.core.utils.j());
                    }
                }
                if (eVar.h && eVar.o.size() > 0 && aVar.equals(eVar.o.get(0)) && ((eVar.b.getCache() <= 0 || eVar.b.getCache() > 0) && (cVar = eVar.i) != null)) {
                    com.kc.dw.core.loader.concurrent.a aVar2 = (com.kc.dw.core.loader.concurrent.a) cVar;
                    if (aVar2.e.getLoaderListener() != null) {
                        LogUtil.d("ConCurrentManager", "onRenderFail");
                        aVar2.e.getLoaderListener().onAdFail(obj, new AdError(i, str), 0);
                    }
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0042 A[Catch: all -> 0x0055, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x000a, B:7:0x0012, B:8:0x0014, B:12:0x0021, B:15:0x0030, B:17:0x0037, B:11:0x001e, B:20:0x0042), top: B:31:0x0001, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:24:0x0053 A[DONT_GENERATE] */
    public static boolean b(e eVar, com.kc.dw.core.loader.loadbean.a aVar) {
        synchronized (eVar) {
            if (eVar.b.getCache() <= 0 && eVar.l.size() > 0) {
                try {
                    Collections.sort(eVar.l, new f(eVar));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                com.kc.dw.core.loader.loadbean.a aVar2 = eVar.l.get(0);
                if (aVar2.e <= aVar.e && (aVar.a() == -1 || aVar2.a() < aVar.a())) {
                    if (!"".equals(aVar.f39268a.getS2sb())) {
                        return false;
                    }
                }
            } else if (!"".equals(aVar.f39268a.getS2sb())) {
                return false;
            }
            return true;
        }
    }

    public final List<Integer> a(List<com.kc.dw.core.loader.loadbean.a> list, int i) {
        Integer numValueOf;
        ArrayList arrayList = new ArrayList();
        try {
            if (list.size() > 0) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    com.kc.dw.core.loader.loadbean.a aVar = list.get(i2);
                    SdkAdInfo sdkAdInfo = aVar.f39268a;
                    if (sdkAdInfo != null) {
                        if (sdkAdInfo.getEcpm() > 0 && sdkAdInfo.getEcpm() >= i && sdkAdInfo.getOriginEcpm() >= sdkAdInfo.getEcpm()) {
                            arrayList.add(Integer.valueOf(sdkAdInfo.getOriginEcpm()));
                        }
                        if (sdkAdInfo.getCodPrice() > 0 && sdkAdInfo.getCodPrice() >= i && sdkAdInfo.getPrice() >= sdkAdInfo.getCodPrice()) {
                            numValueOf = Integer.valueOf(sdkAdInfo.getPrice());
                            arrayList.add(numValueOf);
                        }
                    } else if (aVar.g && this.b.getEcpm() > 0 && this.b.getEcpm() >= i) {
                        numValueOf = Integer.valueOf(this.b.getEcpm());
                        arrayList.add(numValueOf);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public final void a() {
        synchronized (this) {
            if (this.s) {
                return;
            }
            if (this.o.size() > 0) {
                com.kc.dw.core.loader.loadbean.a aVar = this.o.get(0);
                if (!this.m.contains(aVar)) {
                    return;
                }
                if ((this.b.getCache() <= 0 || this.b.getCache() > 0) && this.i != null) {
                    this.s = true;
                    StringBuilder sbA = com.kc.dw.activity.a.a("回调adReady,成功的平台为：");
                    sbA.append(aVar.f39268a.getSdk());
                    sbA.append(", readyAd=");
                    sbA.append(aVar.b);
                    LogUtil.e("PriceFirstStrategy", sbA.toString());
                    com.kc.dw.core.loader.concurrent.c cVar = this.i;
                    Object obj = aVar.b;
                    com.kc.dw.core.loader.concurrent.a aVar2 = (com.kc.dw.core.loader.concurrent.a) cVar;
                    if (aVar2.e.getLoaderListener() != null) {
                        LogUtil.d("ConCurrentManager", "onRenderSuccess");
                        aVar2.e.getLoaderListener().onRenderSuccess(obj);
                    }
                }
                if (this.b.getCache() > 0) {
                    try {
                        Iterator<com.kc.dw.core.loader.loadbean.a> it = this.o.iterator();
                        while (it.hasNext()) {
                            com.kc.dw.core.loader.loadbean.a next = it.next();
                            if (next != null && next.equals(aVar)) {
                                it.remove();
                            }
                        }
                        Iterator<com.kc.dw.core.loader.loadbean.a> it2 = this.l.iterator();
                        while (it2.hasNext()) {
                            com.kc.dw.core.loader.loadbean.a next2 = it2.next();
                            if (next2 != null && next2.equals(aVar)) {
                                it2.remove();
                            }
                        }
                        Iterator<com.kc.dw.core.loader.loadbean.a> it3 = this.e.iterator();
                        while (it3.hasNext()) {
                            com.kc.dw.core.loader.loadbean.a next3 = it3.next();
                            if (next3 != null && next3.equals(aVar)) {
                                it3.remove();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public final void a(int i, int i2, String str) {
        try {
            this.w.clear();
            this.w.addAll(a(this.l, i));
            this.w.addAll(a(this.o, i));
            this.w.addAll(a(this.e, i));
            if (i2 > 0 && "bidding".equals(str)) {
                this.w.add(Integer.valueOf(i2));
            }
            Collections.sort(this.w, new b(this));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void a(SdkAdInfo sdkAdInfo) {
        int iIntValue;
        try {
            List<com.kc.dw.core.loader.b> list = this.c;
            if (list != null && list.size() > 0) {
                Iterator<com.kc.dw.core.loader.b> it = this.c.iterator();
                while (it.hasNext()) {
                    com.kc.dw.core.loader.b next = it.next();
                    if (next.getSdkAdInfo().getReq_uid() == sdkAdInfo.getReq_uid()) {
                        try {
                            a(sdkAdInfo.getEcpm(), sdkAdInfo.getPrice(), sdkAdInfo.getOtype());
                            iIntValue = this.w.size() > 0 ? this.w.get(0).intValue() : 0;
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        b(sdkAdInfo.getEcpm(), sdkAdInfo.getPrice(), sdkAdInfo.getOtype());
                        if (this.x.size() == 0) {
                            this.x.add(0);
                        }
                        if (this.x.size() > 0) {
                            int iIntValue2 = this.x.get(0).intValue();
                            try {
                                int iA = s0.a(iIntValue, iIntValue2, sdkAdInfo.getAt_rate(), sdkAdInfo.getPrice());
                                String finalRsp = sdkAdInfo.getFinalRsp();
                                if (!TextUtils.isEmpty(finalRsp)) {
                                    sdkAdInfo.setFinalRsp(finalRsp.replace("__S2__", String.valueOf(iA)));
                                }
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                            try {
                                ((BasePlatformLoader) next).sendGdtWinResult(true, iIntValue2);
                            } catch (Throwable th3) {
                                th3.printStackTrace();
                            }
                            it.remove();
                            return;
                        }
                    }
                }
            }
            List<SdkAdInfo> list2 = this.d;
            if (list2 == null || list2.size() <= 0) {
                return;
            }
            Iterator<SdkAdInfo> it2 = this.d.iterator();
            while (it2.hasNext()) {
                SdkAdInfo next2 = it2.next();
                if (next2.getReq_uid() == next2.getReq_uid()) {
                    b(sdkAdInfo.getCodPrice(), 0, sdkAdInfo.getOtype());
                    if (this.x.size() > 0) {
                        b(sdkAdInfo, this.x.get(0).intValue());
                        it2.remove();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(SdkAdInfo sdkAdInfo, int i) {
        S2sbResultBean s2sbResultBean;
        try {
            if (TextUtils.isEmpty(sdkAdInfo.getS2sb()) || (s2sbResultBean = (S2sbResultBean) new Gson().fromJson(sdkAdInfo.getS2sb(), S2sbResultBean.class)) == null) {
                return;
            }
            z.a(this.f39271a.getContext(), s2sbResultBean.getLurl().replace("AUCTION_PRICE", String.valueOf(i)).replace("AUCTION_SEAT_ID", String.valueOf(2)).replace("AUCTION_LOSS", String.valueOf(1)), new com.kc.dw.core.utils.j());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean a(com.kc.dw.core.loader.loadbean.a aVar) {
        boolean z;
        synchronized (this) {
            z = false;
            try {
                SdkAdInfo sdkAdInfo = aVar.f39268a;
                int ecpm = sdkAdInfo.getEcpm();
                if ("bidding".equals(sdkAdInfo.getOtype()) && sdkAdInfo.getCodPrice() > ecpm) {
                    try {
                        SdkAdInfo sdkAdInfo2 = aVar.f39268a;
                        if (sdkAdInfo2 != null && sdkAdInfo2.getErr().contains("__MS_ERRNO__")) {
                            String strReplace = aVar.f39268a.getErr().replace("__MS_ERRNO__", "1027").replace("__ERROR_CODE__", String.valueOf(0)).replace("__TIMEOUT__", String.valueOf(aVar.d)).replace("__P__", String.valueOf(sdkAdInfo.getPrice())).replace("__S__", String.valueOf(ecpm));
                            if (!TextUtils.isEmpty(strReplace)) {
                                z.a(this.f39271a.getContext().getApplicationContext(), g0.a(strReplace), new com.kc.dw.core.utils.j());
                            }
                        }
                        z = true;
                    } catch (Exception e) {
                        e = e;
                        z = true;
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        return z;
    }

    public final List<Integer> b(List<com.kc.dw.core.loader.loadbean.a> list, int i) {
        Integer numValueOf;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            try {
                com.kc.dw.core.loader.loadbean.a aVar = list.get(i2);
                SdkAdInfo sdkAdInfo = aVar.f39268a;
                if (sdkAdInfo != null) {
                    int ecpm = sdkAdInfo.getEcpm();
                    if (ecpm < i && ecpm > 0 && aVar.f39268a.getOriginEcpm() >= ecpm) {
                        arrayList.add(Integer.valueOf(aVar.f39268a.getOriginEcpm()));
                    }
                    int codPrice = aVar.f39268a.getCodPrice();
                    if (codPrice < i && codPrice > 0 && aVar.f39268a.getPrice() >= codPrice) {
                        numValueOf = Integer.valueOf(aVar.f39268a.getPrice());
                        arrayList.add(numValueOf);
                    }
                } else if (aVar.g && this.b.getEcpm() > 0 && this.b.getEcpm() < i) {
                    numValueOf = Integer.valueOf(this.b.getEcpm());
                    arrayList.add(numValueOf);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public final void b() {
        com.kc.dw.core.loader.loadbean.a aVar = new com.kc.dw.core.loader.loadbean.a();
        aVar.e = (1000 - this.b.getPriority()) * 1000000;
        aVar.f = this.b.getCacheScore();
        synchronized (aVar) {
            aVar.c = 2;
        }
        aVar.g = true;
        this.e.add(aVar);
    }

    public final void b(int i, int i2, String str) {
        try {
            this.x.clear();
            this.x.addAll(b(this.l, i));
            this.x.addAll(b(this.e, i));
            if (i2 > 0 && "bidding".equals(str)) {
                this.x.add(Integer.valueOf(i2));
            }
            Collections.sort(this.x, new c(this));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void b(SdkAdInfo sdkAdInfo, int i) {
        S2sbResultBean s2sbResultBean;
        try {
            if (TextUtils.isEmpty(sdkAdInfo.getS2sb()) || (s2sbResultBean = (S2sbResultBean) new Gson().fromJson(sdkAdInfo.getS2sb(), S2sbResultBean.class)) == null) {
                return;
            }
            z.a(this.f39271a.getContext(), s2sbResultBean.getNurl().replace("AUCTION_PRICE", String.valueOf(sdkAdInfo.getPrice())).replace("HIGHEST_LOSS_PRICE", String.valueOf(Math.min(i, sdkAdInfo.getPrice()))), new com.kc.dw.core.utils.j());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean b(com.kc.dw.core.loader.loadbean.a aVar) {
        try {
            LinkedHashMap<String, Long> eventTimes = aVar.f39268a.getAppendInfo().getEventTimes(com.kc.dw.core.service.logrecord.b.a(aVar.f39268a));
            return eventTimes.containsKey("s2") || eventTimes.containsKey("f2");
        } catch (Exception unused) {
            return false;
        }
    }

    public final void c() {
        if (this.t) {
            return;
        }
        this.t = true;
        this.h = true;
        try {
            List<com.kc.dw.core.loader.b> list = this.c;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < this.c.size(); i++) {
                    com.kc.dw.core.loader.b bVar = this.c.get(i);
                    SdkAdInfo sdkAdInfo = bVar.getSdkAdInfo();
                    a(sdkAdInfo.getEcpm(), sdkAdInfo.getPrice(), sdkAdInfo.getOtype());
                    if (this.w.size() > 0) {
                        try {
                            ((BasePlatformLoader) bVar).sendGdtWinResult(false, this.w.get(0).intValue());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            }
            List<SdkAdInfo> list2 = this.d;
            if (list2 == null || list2.size() <= 0) {
                return;
            }
            for (int i2 = 0; i2 < this.d.size(); i2++) {
                SdkAdInfo sdkAdInfo2 = this.d.get(i2);
                a(sdkAdInfo2.getEcpm(), sdkAdInfo2.getPrice(), sdkAdInfo2.getOtype());
                if (this.w.size() > 0) {
                    a(sdkAdInfo2, this.w.get(0).intValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void c(com.kc.dw.core.loader.loadbean.a aVar) {
        try {
            this.b.getCache();
            if (!this.o.contains(aVar)) {
                this.o.add(aVar);
            }
            this.e.remove(aVar);
            this.l.remove(aVar);
            f();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void d() {
        synchronized (this) {
            SdkHandler.runOnMainThread(new a(this));
        }
    }

    public final boolean d(com.kc.dw.core.loader.loadbean.a aVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.e);
        arrayList.addAll(this.l);
        if (arrayList.size() <= 0) {
            return true;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.kc.dw.core.loader.loadbean.a aVar2 = (com.kc.dw.core.loader.loadbean.a) it.next();
            if (!aVar2.equals(aVar) && aVar2.c == 2 && !this.l.contains(aVar2)) {
                this.l.add(aVar2);
                it.remove();
            }
            int i = aVar2.e;
            int i2 = aVar.e;
            if (i > i2) {
                return false;
            }
            if (i == i2 && ((!aVar2.g && "bidding".equals(aVar2.f39268a.getOtype()) && aVar2.a() == -1) || aVar2.a() > aVar.a())) {
                return false;
            }
        }
        return true;
    }

    public final void e() {
        if (this.o.size() == 0 && this.l.size() == 0) {
            LogUtil.d("PriceFirstStrategy", "handleFinish loadFinish=true");
            this.h = true;
            this.n.clear();
            d();
            return;
        }
        h();
        if (!this.h) {
            this.o.addAll(this.l);
            try {
                Collections.sort(this.o, new f(this));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        f();
        c();
    }

    public final void f() {
        LinkedHashMap<String, Long> linkedHashMap;
        String curReqId;
        long curAllTimes;
        synchronized (this) {
            if (!this.r) {
                if (this.o.size() > 0) {
                    com.kc.dw.core.loader.loadbean.a aVar = this.o.get(0);
                    if ((this.b.getCache() <= 0 || this.b.getCache() > 0) && this.i != null) {
                        if (!aVar.g || this.h) {
                            if (this.b.getCache() <= 0) {
                                LogUtil.e("PriceFirstStrategy", "handleReturnAd, loadFinished=true");
                                this.h = true;
                                this.n.clear();
                            }
                            this.r = true;
                            a(aVar.f39268a);
                            this.f.clear();
                            com.kc.dw.core.loader.concurrent.c cVar = this.i;
                            Object obj = aVar.b;
                            SdkAdInfo sdkAdInfo = aVar.f39268a;
                            com.kc.dw.core.loader.concurrent.a aVar2 = (com.kc.dw.core.loader.concurrent.a) cVar;
                            SsdAdInfo ssdAdInfo = aVar2.b;
                            String accept_id = sdkAdInfo.getAccept_id();
                            if (ssdAdInfo != null) {
                                try {
                                    ssdAdInfo.setEventUrl(g0.a(ssdAdInfo.getSourceEventUrl(), accept_id));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            if (!aVar2.g) {
                                aVar2.g = true;
                                com.kc.dw.ad.interstitial.c.a(aVar2.e.getContext(), g0.a(g0.a(sdkAdInfo.getFinalRsp().replace("__TIMEOUT__", String.valueOf(0)), System.currentTimeMillis() - aVar2.e.startLoadTime)));
                                try {
                                    if (sdkAdInfo.getAppendInfo() != null) {
                                        LinkedHashMap<String, Long> eventTimes = sdkAdInfo.getAppendInfo().getEventTimes(com.kc.dw.core.service.logrecord.b.a(sdkAdInfo));
                                        curAllTimes = sdkAdInfo.getAppendInfo().getCurAllTimes();
                                        curReqId = sdkAdInfo.getAppendInfo().getCurReqId();
                                        linkedHashMap = eventTimes;
                                    } else {
                                        linkedHashMap = null;
                                        curReqId = null;
                                        curAllTimes = 0;
                                    }
                                    String accept_id2 = sdkAdInfo.getAccept_id();
                                    String posId = aVar2.e.getPosId();
                                    AdType adType = aVar2.e.getAdType();
                                    Object obj2 = com.kc.dw.core.service.logrecord.a.f39314a;
                                    EventBean eventBeanInit = new EventBean().init("s3", linkedHashMap);
                                    eventBeanInit.put2Data("aid", sdkAdInfo.getApp_id());
                                    eventBeanInit.put2Data("pid", sdkAdInfo.getPid());
                                    com.kc.dw.core.service.logrecord.a.a(linkedHashMap, 5, "s3", accept_id2, posId, adType, curAllTimes, curReqId, eventBeanInit);
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                                if (aVar2.e.getLoaderListener() != null) {
                                    StringBuilder sbA = com.kc.dw.activity.a.a("onFinalAdLoaded: ");
                                    sbA.append(sdkAdInfo.getSdk());
                                    sbA.append(",group：");
                                    sbA.append(sdkAdInfo.getGroup());
                                    LogUtil.d("ConCurrentManager", sbA.toString());
                                    aVar2.e.getLoaderListener().onLoadSuccess(obj);
                                }
                                if ((obj instanceof MsCustomSplashAd) && aVar2.e.getAdSlot().isAutoRender()) {
                                    ((MsCustomSplashAd) obj).render();
                                }
                            }
                            a();
                        } else if (this.i != null) {
                            a(aVar.f39268a);
                            this.r = true;
                            d();
                        }
                    }
                } else if (this.i != null) {
                    this.r = true;
                    LogUtil.e("PriceFirstStrategy", "无广告返回，onAllError");
                    d();
                }
            }
        }
    }

    public final void g() {
        synchronized (this) {
            try {
                if (!this.h) {
                    try {
                        if (this.u) {
                            e();
                            return;
                        }
                        LinkedList<com.kc.dw.core.loader.loadbean.a> linkedList = this.f;
                        if (linkedList != null && linkedList.size() > 0) {
                            com.kc.dw.core.loader.loadbean.a aVarRemoveFirst = this.f.removeFirst();
                            this.n.add(aVarRemoveFirst);
                            ExecutorService executorService = f0.f39362a;
                            f0.b.f39363a.a(new d(this, aVarRemoveFirst));
                        } else if (this.n.size() == 0) {
                            e();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h() {
        try {
            Iterator it = new ArrayList(this.l).iterator();
            while (it.hasNext()) {
                com.kc.dw.core.loader.loadbean.a aVar = (com.kc.dw.core.loader.loadbean.a) it.next();
                if (!this.h && d(aVar)) {
                    c(aVar);
                    it.remove();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

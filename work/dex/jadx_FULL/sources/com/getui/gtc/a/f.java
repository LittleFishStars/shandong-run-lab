package com.getui.gtc.a;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.alibaba.alibcprotocol.base.AlibcProtocolConstant;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.util.CommonUtil;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class f implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f30266a;
    private boolean b = false;
    private long c = 86400000;
    private String[] d = {"com.huawei.appmarket", "com.bbk.launcher2", "net.oneplus.launcher", "com.android.deskclock", "com.heytap.market", "com.oppo.market"};
    private String[] e = {"com.tencent.mm", "com.tencent.mobileqq", "com.eg.android.AlipayGphone", "com.jingdong.app.mall", "com.ss.android.article.news", AlibcProtocolConstant.APPLINK_PACKAGE_NAME, "com.tmall.wireless", "com.sankuai.meituan", "com.xunmeng.pinduoduo", "com.ss.android.ugc.aweme"};

    private String a() {
        try {
            StringBuilder sb = new StringBuilder();
            for (String str : this.d) {
                try {
                    sb.append(str + "#,");
                } catch (Throwable unused) {
                    com.getui.gtc.i.c.a.b(str + " not found");
                }
            }
            if (sb.toString().endsWith(",")) {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.b(th);
            return "";
        }
    }

    @TargetApi(26)
    private String b() {
        File parentFile;
        StringBuilder sb = new StringBuilder();
        try {
            File externalCacheDir = GtcProvider.context().getExternalCacheDir();
            File parentFile2 = (externalCacheDir == null || (parentFile = externalCacheDir.getParentFile()) == null) ? null : parentFile.getParentFile();
            if (parentFile2 == null) {
                return "";
            }
            for (String str : this.e) {
                try {
                    BasicFileAttributes attributes = Files.readAttributes(new File(parentFile2, str).toPath(), (Class<BasicFileAttributes>) BasicFileAttributes.class, new LinkOption[0]);
                    sb.append(str + "#0#" + attributes.creationTime().toMillis() + "#" + attributes.lastAccessTime().toMillis());
                    sb.append(",");
                } catch (Throwable th) {
                    com.getui.gtc.i.c.a.b(th);
                }
            }
            if (sb.toString().endsWith(",")) {
                sb.deleteCharAt(sb.length() - 1);
            }
        } catch (Throwable th2) {
            com.getui.gtc.i.c.a.b(th2);
        }
        return sb.toString();
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Map<String, String> mapA = com.getui.gtc.f.c.a(com.heytap.mcssdk.constant.a.g, (com.getui.gtc.f.e) null);
            if (mapA != null && mapA.size() > 0) {
                try {
                    String str = mapA.get("sdk.gtc.type304.enable");
                    if (str != null) {
                        this.b = Boolean.parseBoolean(str);
                    }
                } catch (Exception e) {
                    com.getui.gtc.i.c.a.b(e);
                }
                try {
                    String str2 = mapA.get("sdk.gtc.type304.interval");
                    if (str2 != null) {
                        this.c = Long.parseLong(str2) * 1000;
                    }
                } catch (Exception e2) {
                    com.getui.gtc.i.c.a.b(e2);
                }
                try {
                    String str3 = mapA.get("sdk.gtc.type304.sys_al");
                    if (!TextUtils.isEmpty(str3) && !"none".equalsIgnoreCase(str3)) {
                        String[] strArrSplit = str3.split(",");
                        if (strArrSplit.length > 0) {
                            this.d = strArrSplit;
                            com.getui.gtc.i.c.a.a("type304 dyc sysApp:" + Arrays.toString(strArrSplit));
                        }
                    }
                } catch (Exception e3) {
                    com.getui.gtc.i.c.a.b(e3);
                }
                try {
                    String str4 = mapA.get("sdk.gtc.type304.hot_al");
                    if (!TextUtils.isEmpty(str4) && !"none".equalsIgnoreCase(str4)) {
                        String[] strArrSplit2 = str4.split(",");
                        if (strArrSplit2.length > 0) {
                            this.e = strArrSplit2;
                            com.getui.gtc.i.c.a.a("type304 dyc hotApp:" + Arrays.toString(strArrSplit2));
                        }
                    }
                } catch (Exception e4) {
                    com.getui.gtc.i.c.a.b(e4);
                }
            }
            if (!this.b) {
                com.getui.gtc.i.c.a.b("type 304 is not enabled");
                return;
            }
            if (CommonUtil.isAppDebugEnable()) {
                com.getui.gtc.i.c.a.b("type 304 is debug, disallow");
                return;
            }
            if (System.currentTimeMillis() - com.getui.gtc.e.c.a.f30351a.f30350a.l < this.c) {
                return;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
            String str5 = a.a(simpleDateFormat.format(new Date())) + "|" + a.a(com.getui.gtc.c.b.d) + "|" + a.a(com.getui.gtc.c.b.f30289a) + "|android|" + GtcProvider.context().getPackageName() + "|GTC-3.2.16.0|" + a() + "|" + b();
            this.f30266a = str5;
            try {
                com.getui.gtc.h.a.a(str5, 304);
                com.getui.gtc.e.d dVar = com.getui.gtc.e.c.a.f30351a.f30350a;
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (dVar.a(16, jCurrentTimeMillis)) {
                    dVar.l = jCurrentTimeMillis;
                }
            } catch (Exception e5) {
                com.getui.gtc.i.c.a.c("type 304 report error: " + e5.toString());
            }
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.a("type 304", th);
        }
    }
}

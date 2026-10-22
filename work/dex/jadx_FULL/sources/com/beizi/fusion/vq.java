package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.ad.model.BeiZiLocation;
import com.beizi.fusion.model.AdPlusConfig;
import com.beizi.fusion.model.RequestInfo;
import com.beizi.fusion.model.ResponseInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class vq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f27885a;

    public class a extends t3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f27886a;

        public a(Context context) {
            this.f27886a = context;
        }

        @Override // com.beizi.fusion.t3
        public String a() {
            try {
                if (RequestInfo.getInstance(this.f27886a).getDevInfo() != null) {
                    String oaid = RequestInfo.getInstance(this.f27886a).getDevInfo().getOaid();
                    if (!TextUtils.isEmpty(oaid)) {
                        return oaid;
                    }
                    String customOaid = RequestInfo.getInstance(this.f27886a).getCustomOaid();
                    if (!TextUtils.isEmpty(customOaid)) {
                        return customOaid;
                    }
                }
            } catch (Exception unused) {
            }
            return super.a();
        }

        @Override // com.beizi.fusion.t3
        public BeiZiLocation b() {
            return BeiZis.getCustomController() != null ? BeiZis.getCustomController().getLocation() : super.b();
        }

        @Override // com.beizi.fusion.t3
        public boolean c() {
            return BeiZis.getCustomController() != null ? BeiZis.getCustomController().isCanUseLocation() : super.c();
        }

        @Override // com.beizi.fusion.t3
        public boolean d() {
            if (BeiZis.getCustomController() != null) {
                return !al.b() && BeiZis.getCustomController().isCanUseOaid();
            }
            return super.d();
        }
    }

    private static void a(Context context, String str) {
        if (f27885a) {
            return;
        }
        try {
            a(context);
            s3.a(context, str, new a(context));
            s3.e(rf.a().b(context.getApplicationContext()));
            f27885a = true;
        } catch (Exception unused) {
        }
    }

    public static void b(Context context, String str) {
        try {
            a(context.getApplicationContext(), str);
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context) {
        String strA;
        try {
            AdPlusConfig adPlusConfig = ResponseInfo.getInstance(context).getAdPlusConfig();
            if (adPlusConfig != null) {
                List<String> h5RedirectBlackList = adPlusConfig.getH5RedirectBlackList();
                if (h5RedirectBlackList == null || h5RedirectBlackList.size() <= 0) {
                    h5RedirectBlackList = new ArrayList<>();
                    h5RedirectBlackList.add("market://");
                }
                s3.a(h5RedirectBlackList);
            }
            if (adPlusConfig != null && !TextUtils.isEmpty(adPlusConfig.getAdUrl()) && adPlusConfig.getAdUrl().startsWith("http")) {
                strA = adPlusConfig.getAdUrl();
            } else {
                strA = g3.a(BeiZis.getTransferProtocol() ? "aHR0cHM6Ly9hcGktaHRwLmJlaXppLmJpei9tYi9zZGswL2pzb24=" : "aHR0cDovL2FwaS5odHAuYWQtc2NvcGUuY29tLmNuOjQ1NjAwL21iL3NkazAvanNvbg==");
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
            }
            if (!TextUtils.isEmpty(strA)) {
                s3.b(strA);
            }
            if (adPlusConfig != null) {
                String rwReqUrl = adPlusConfig.getRwReqUrl();
                if (!TextUtils.isEmpty(rwReqUrl)) {
                    s3.c(rwReqUrl);
                }
                String unReqUrl = adPlusConfig.getUnReqUrl();
                if (TextUtils.isEmpty(unReqUrl)) {
                    return;
                }
                s3.d(unReqUrl);
            }
        } catch (Exception unused) {
        }
    }

    public static String a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            b(context, str);
            return s3.a(str2);
        }
        a4.j().a(context);
        return new vi().a(oo.a(), false);
    }
}

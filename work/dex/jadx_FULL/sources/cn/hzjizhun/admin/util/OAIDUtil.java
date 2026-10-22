package cn.hzjizhun.admin.util;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.hzjizhun.admin.JZAdSdk;
import cn.hzjizhun.admin.ddakd;
import cn.hzjizhun.admin.kasds;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class OAIDUtil {
    private static String TAG = "OAIDUtil";
    private static String oaid = "";
    private static String soaid = "";

    public interface OaidCallback {
        void onOaidGet();
    }

    public class a implements ddakd {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OaidCallback f22751a;

        public a(OaidCallback oaidCallback) {
            this.f22751a = oaidCallback;
        }

        @Override // cn.hzjizhun.admin.ddakd
        public void a(String str) {
            ALog.d("oaid....", str);
            String unused = OAIDUtil.soaid = str;
            this.f22751a.onOaidGet();
        }

        @Override // cn.hzjizhun.admin.ddakd
        public void b(Throwable th) {
            ALog.e("oaid...", th.getMessage());
            this.f22751a.onOaidGet();
        }
    }

    public static String getOaid(Context context) {
        String oaid2 = JZAdSdk.getInstance().getOAID();
        return !TextUtils.isEmpty(oaid2) ? oaid2 : soaid;
    }

    public static void requestOaid(Context context, @NonNull OaidCallback oaidCallback) {
        if (TextUtils.isEmpty(JZAdSdk.getInstance().getOAID())) {
            kasds.c(context, new a(oaidCallback));
        } else {
            oaidCallback.onOaidGet();
        }
    }
}

package cj.mobile.help.topon;

import android.content.Context;
import cj.mobile.CJInterstitial;
import cj.mobile.CJNativeExpress;
import cj.mobile.CJRenderNative;
import cj.mobile.CJRewardVideo;
import cj.mobile.CJSplash;
import cj.mobile.listener.CJInitListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class HelpUtils {
    public static Map<String, Boolean> isLoadBidding = new HashMap();
    public static Map<String, CJRewardVideo> cjRewardVideoMap = new HashMap();
    public static Map<String, CJNativeExpress> cjNativeExpressMap = new HashMap();
    public static Map<String, CJRenderNative> cjNativeRenderMap = new HashMap();
    public static Map<String, CJSplash> cjSplashMap = new HashMap();
    public static Map<String, CJInterstitial> cjInterstitialMap = new HashMap();
    public static List<CJInterstitial> cjInterstitialListOnShow = new ArrayList();

    public class a implements CJInitListener {
        @Override // cj.mobile.listener.CJInitListener
        public void initFailed(String str) {
        }

        @Override // cj.mobile.listener.CJInitListener
        public void initSuccess() {
        }
    }

    public static void destroyShowInterstitial() {
    }

    public static void init(Context context, String str) {
    }
}

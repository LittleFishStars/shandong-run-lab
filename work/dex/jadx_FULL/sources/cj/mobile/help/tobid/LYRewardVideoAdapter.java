package cj.mobile.help.tobid;

import android.app.Activity;
import android.content.Context;
import cj.mobile.CJRewardVideo;
import cj.mobile.listener.CJRewardListener;
import com.windmill.sdk.custom.WMCustomRewardAdapter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class LYRewardVideoAdapter extends WMCustomRewardAdapter {
    public CJRewardVideo i;

    public class a implements CJRewardListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LYRewardVideoAdapter f22246a;

        public a(LYRewardVideoAdapter lYRewardVideoAdapter) {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onClick() {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onClose() {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onError(String str, String str2) {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onLoad() {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onReward(String str) {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onShow() {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onVideoEnd() {
        }

        @Override // cj.mobile.listener.CJRewardListener
        public void onVideoStart() {
        }
    }

    public void destroyAd() {
    }

    public boolean isReady() {
    }

    public void loadAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
    }

    public void showAd(Activity activity, HashMap<String, String> map, Map<String, Object> map2) {
    }
}

package cj.mobile.content.horoscope;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import cj.mobile.CJBanner;
import cj.mobile.CJInterstitial;
import cj.mobile.CJRewardVideo;
import cj.mobile.dialog.LoadingDialog;
import cj.mobile.listener.CJBannerListener;
import cj.mobile.listener.CJInterstitialListener;
import cj.mobile.listener.CJRewardListener;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class CJHoroscopeActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public cj.mobile.k.a f22123a;
    public List<cj.mobile.k.b> b;
    public GridView c;
    public String d;
    public String e;
    public String f;
    public String g;
    public FrameLayout h;
    public boolean i;
    public Activity j;
    public ImageView k;
    public boolean l;
    public CJInterstitial m;
    public CJBanner n;
    public CJRewardVideo o;
    public LoadingDialog p;

    public class a implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJHoroscopeActivity f22124a;

        public a(CJHoroscopeActivity cJHoroscopeActivity) {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJHoroscopeActivity f22125a;

        public b(CJHoroscopeActivity cJHoroscopeActivity) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class c implements CJInterstitialListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJHoroscopeActivity f22126a;

        public c(CJHoroscopeActivity cJHoroscopeActivity) {
        }

        @Override // cj.mobile.listener.CJInterstitialListener
        public void onClick() {
        }

        @Override // cj.mobile.listener.CJInterstitialListener
        public void onClose() {
        }

        @Override // cj.mobile.listener.CJInterstitialListener
        public void onError(String str, String str2) {
        }

        @Override // cj.mobile.listener.CJInterstitialListener
        public void onLoad() {
        }

        @Override // cj.mobile.listener.CJInterstitialListener
        public void onShow() {
        }
    }

    public class d implements CJBannerListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJHoroscopeActivity f22127a;

        public d(CJHoroscopeActivity cJHoroscopeActivity) {
        }

        @Override // cj.mobile.listener.CJBannerListener
        public void onClick() {
        }

        @Override // cj.mobile.listener.CJBannerListener
        public void onClose() {
        }

        @Override // cj.mobile.listener.CJBannerListener
        public void onError(String str, String str2) {
        }

        @Override // cj.mobile.listener.CJBannerListener
        public void onLoad() {
        }

        @Override // cj.mobile.listener.CJBannerListener
        public void onShow() {
        }
    }

    public class e implements CJRewardListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f22128a;
        public final /* synthetic */ int b;
        public final /* synthetic */ CJHoroscopeActivity c;

        public e(CJHoroscopeActivity cJHoroscopeActivity, String str, int i) {
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

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
    }

    @Override // android.app.Activity
    public void onDestroy() {
    }

    public final void a() {
    }

    public final void b() {
    }

    public final void a(String str, int i) {
    }

    public final void b(String str, int i) {
    }
}

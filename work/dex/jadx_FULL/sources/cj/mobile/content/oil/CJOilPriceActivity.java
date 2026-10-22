package cj.mobile.content.oil;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cj.mobile.CJInterstitial;
import cj.mobile.CJRewardVideo;
import cj.mobile.dialog.LoadingDialog;
import cj.mobile.listener.CJInterstitialListener;
import cj.mobile.listener.CJRewardListener;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class CJOilPriceActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f22174a;
    public String b;
    public String c;
    public String d;
    public ListView e;
    public TextView f;
    public List<cj.mobile.n.b> g;
    public cj.mobile.n.a h;
    public CJInterstitial i;
    public CJRewardVideo j;
    public LoadingDialog k;
    public boolean l;
    public Handler m;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJOilPriceActivity f22175a;

        public a(CJOilPriceActivity cJOilPriceActivity) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class b implements cj.mobile.p.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJOilPriceActivity f22176a;

        public b(CJOilPriceActivity cJOilPriceActivity) {
        }

        @Override // cj.mobile.p.d
        public void a(IOException iOException) {
        }

        @Override // cj.mobile.p.d
        public void a(String str) {
        }
    }

    public class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJOilPriceActivity f22177a;

        public c(CJOilPriceActivity cJOilPriceActivity, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
        }
    }

    public class d implements CJInterstitialListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJOilPriceActivity f22178a;

        public d(CJOilPriceActivity cJOilPriceActivity) {
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

    public class e implements CJRewardListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJOilPriceActivity f22179a;

        public e(CJOilPriceActivity cJOilPriceActivity) {
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

    public void back(View view) {
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
    }

    public final void b() {
    }

    public final void c() {
    }

    public final void a() {
    }
}

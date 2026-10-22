package cj.mobile.content.history;

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
public class CJHistoryDayActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f22117a;
    public ListView b;
    public TextView c;
    public String d;
    public String e;
    public String f;
    public cj.mobile.j.a g;
    public List<cj.mobile.j.b> h;
    public List<cj.mobile.j.b> i;
    public CJInterstitial j;
    public CJRewardVideo k;
    public LoadingDialog l;
    public boolean m;
    public Handler n;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJHistoryDayActivity f22118a;

        public a(CJHistoryDayActivity cJHistoryDayActivity) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class b implements cj.mobile.p.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJHistoryDayActivity f22119a;

        public b(CJHistoryDayActivity cJHistoryDayActivity) {
        }

        @Override // cj.mobile.p.d
        public void a(IOException iOException) {
        }

        @Override // cj.mobile.p.d
        public void a(String str) {
        }
    }

    public class c implements CJInterstitialListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJHistoryDayActivity f22120a;

        public c(CJHistoryDayActivity cJHistoryDayActivity) {
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

    public class d implements CJRewardListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJHistoryDayActivity f22121a;

        public d(CJHistoryDayActivity cJHistoryDayActivity) {
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

    public class e extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJHistoryDayActivity f22122a;

        public e(CJHistoryDayActivity cJHistoryDayActivity, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
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

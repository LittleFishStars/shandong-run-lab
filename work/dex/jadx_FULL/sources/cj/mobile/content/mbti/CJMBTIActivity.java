package cj.mobile.content.mbti;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import cj.mobile.CJInterstitial;
import cj.mobile.CJRewardVideo;
import cj.mobile.dialog.LoadingDialog;
import cj.mobile.listener.CJInterstitialListener;
import cj.mobile.listener.CJRewardListener;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class CJMBTIActivity extends FragmentActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22135a;
    public Activity b;
    public String c;
    public String d;
    public String e;
    public String f;
    public int g;
    public String h;
    public boolean i;
    public List<CJMBTIQuestionFragment> j;
    public CJMBTIResultFragment k;
    public CJRewardVideo l;
    public CJInterstitial m;
    public boolean n;
    public int o;
    public String p;
    public LoadingDialog q;
    public cj.mobile.l.c r;
    public Handler s;
    public CJRewardListener t;

    public class a implements cj.mobile.p.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJMBTIActivity f22136a;

        public a(CJMBTIActivity cJMBTIActivity) {
        }

        @Override // cj.mobile.p.d
        public void a(IOException iOException) {
        }

        @Override // cj.mobile.p.d
        public void a(String str) {
        }
    }

    public class b implements cj.mobile.l.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJMBTIActivity f22137a;

        public b(CJMBTIActivity cJMBTIActivity) {
        }

        @Override // cj.mobile.l.c
        public void a(int i, String str) {
        }

        @Override // cj.mobile.l.c
        public void b(int i, String str) {
        }
    }

    public class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJMBTIActivity f22138a;

        public c(CJMBTIActivity cJMBTIActivity, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
        }
    }

    public class d implements CJInterstitialListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJMBTIActivity f22139a;

        public d(CJMBTIActivity cJMBTIActivity) {
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
        public final /* synthetic */ CJMBTIActivity f22140a;

        public e(CJMBTIActivity cJMBTIActivity) {
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
    }

    public final void a() {
    }

    public void b() {
    }

    public final void a(String str) {
    }

    public void a(int i) {
    }

    public void a(Fragment fragment) {
    }

    public void a(int i, String str) {
    }
}

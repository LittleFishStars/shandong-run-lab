package cj.mobile.content.videoContent;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import cj.mobile.CJRewardVideo;
import cj.mobile.dialog.LoadingDialog;
import cj.mobile.listener.CJRewardListener;
import cj.mobile.listener.CJVideoContentListener;
import cj.mobile.view.CircularProgressView;
import com.kwad.sdk.api.KsContentPage;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class CJVideoContentActivity extends FragmentActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f22195a;
    public CircularProgressView b;
    public TextView c;
    public TextView d;
    public Activity e;
    public String f;
    public String g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public boolean m;
    public CJRewardVideo n;
    public boolean o;
    public Handler p;

    public class a implements CJVideoContentListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJVideoContentActivity f22196a;

        public a(CJVideoContentActivity cJVideoContentActivity) {
        }

        @Override // cj.mobile.listener.CJVideoContentListener
        public void endVideo(KsContentPage.ContentItem contentItem) {
        }

        @Override // cj.mobile.listener.CJVideoContentListener
        public void onError(String str, String str2) {
        }

        @Override // cj.mobile.listener.CJVideoContentListener
        public void onLoad(Fragment fragment) {
        }

        @Override // cj.mobile.listener.CJVideoContentListener
        public void pauseVideo(KsContentPage.ContentItem contentItem) {
        }

        @Override // cj.mobile.listener.CJVideoContentListener
        public void resumeVideo(KsContentPage.ContentItem contentItem) {
        }

        @Override // cj.mobile.listener.CJVideoContentListener
        public void startVideo(KsContentPage.ContentItem contentItem) {
        }
    }

    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJVideoContentActivity f22197a;

        public b(CJVideoContentActivity cJVideoContentActivity) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CJVideoContentActivity f22198a;

        public c(CJVideoContentActivity cJVideoContentActivity, Looper looper) {
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
        }
    }

    public class d implements CJRewardListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LoadingDialog f22199a;
        public final /* synthetic */ CJVideoContentActivity b;

        public d(CJVideoContentActivity cJVideoContentActivity, LoadingDialog loadingDialog) {
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

    public static /* synthetic */ int l(CJVideoContentActivity cJVideoContentActivity) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
    }

    public void a(String str) {
    }
}

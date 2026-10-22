package com.kc.openset.video;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.kc.openset.R;
import com.kc.openset.VideoContentConfigData;
import com.kc.openset.util.CircularProgressView;
import com.kc.openset.util.k0;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class VideoContentActivity extends FragmentActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static OSETVideoContentTaskListener f39986a;
    private String b;
    private int c = 1;
    private int d = 15;
    private boolean e;
    private CircularProgressView f;
    private VideoContentResult g;

    @Keep
    public class a implements OSETVideoContentListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final VideoContentActivity f39987a;

        public a(VideoContentActivity videoContentActivity) {
            this.f39987a = videoContentActivity;
        }

        @Override // com.kc.openset.video.OSETVideoContentListener
        public void onLoadFail(String str, String str2) {
            if (VideoContentActivity.f39986a != null) {
                VideoContentActivity.f39986a.onLoadFail(str, str2);
            }
        }

        @Override // com.kc.openset.video.OSETVideoContentListener
        public void onLoadSuccess(VideoContentResult videoContentResult) {
            this.f39987a.g = videoContentResult;
            this.f39987a.getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, videoContentResult.getFragment()).commitAllowingStateLoss();
            this.f39987a.b();
        }

        @Override // com.kc.openset.video.OSETVideoContentListener
        public void onVideoComplete(int i, boolean z, String str) {
            if (VideoContentActivity.f39986a != null) {
                VideoContentActivity.f39986a.onVideoComplete(i, z, str);
            }
        }

        @Override // com.kc.openset.video.OSETVideoContentListener
        public void onVideoPause(int i, boolean z, String str) {
            if (VideoContentActivity.f39986a != null) {
                VideoContentActivity.f39986a.onVideoPause(i, z, str);
            }
        }

        @Override // com.kc.openset.video.OSETVideoContentListener
        public void onVideoPlayError(int i, boolean z, String str, String str2, String str3) {
            if (VideoContentActivity.f39986a != null) {
                VideoContentActivity.f39986a.onVideoPlayError(i, z, str, str2, str3);
            }
        }

        @Override // com.kc.openset.video.OSETVideoContentListener
        public void onVideoResume(int i, boolean z, String str) {
            if (VideoContentActivity.f39986a != null) {
                VideoContentActivity.f39986a.onVideoResume(i, z, str);
            }
        }

        @Override // com.kc.openset.video.OSETVideoContentListener
        public void onVideoStart(int i, boolean z, String str) {
            if (VideoContentActivity.f39986a != null) {
                VideoContentActivity.f39986a.onVideoStart(i, z, str);
            }
        }
    }

    @Keep
    public class b implements CircularProgressView.onProgressListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final VideoContentActivity f39988a;

        public b(VideoContentActivity videoContentActivity) {
            this.f39988a = videoContentActivity;
        }

        @Override // com.kc.openset.util.CircularProgressView.onProgressListener
        public void onClose() {
            this.f39988a.findViewById(R.id.rl_down).setVisibility(8);
        }

        @Override // com.kc.openset.util.CircularProgressView.onProgressListener
        public void onTimerOver() {
            if (VideoContentActivity.f39986a != null) {
                VideoContentActivity.f39986a.onTimeOver();
            }
        }
    }

    public static void a(Activity activity, VideoContentConfigData videoContentConfigData, OSETVideoContentTaskListener oSETVideoContentTaskListener) {
        f39986a = oSETVideoContentTaskListener;
        Intent intent = new Intent(activity, (Class<?>) VideoContentActivity.class);
        intent.putExtra("intent_key_video_content_config", videoContentConfigData);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        CircularProgressView circularProgressView = this.f;
        if (circularProgressView == null) {
            return;
        }
        circularProgressView.setOnProgressListener(new b(this));
        this.f.a(this.c, this.d);
    }

    private void c() {
        VideoContentConfigData videoContentConfigData = (VideoContentConfigData) getIntent().getSerializableExtra("intent_key_video_content_config");
        if (videoContentConfigData != null) {
            this.b = videoContentConfigData.c();
            if (videoContentConfigData.a() > 0) {
                this.c = videoContentConfigData.a();
            }
            if (videoContentConfigData.b() > 0) {
                this.d = videoContentConfigData.b();
            }
            this.e = videoContentConfigData.d();
        }
    }

    private void d() {
        ImageView imageView = (ImageView) findViewById(R.id.iv_back);
        if (this.e) {
            imageView.setVisibility(0);
            int iA = k0.a(this);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.topMargin = iA;
            layoutParams.leftMargin = iA / 2;
            imageView.setLayoutParams(layoutParams);
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.kc.openset.video.VideoContentActivity$$ExternalSyntheticLambda0
                public final VideoContentActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.a(view);
                }
            });
        }
        this.f = (CircularProgressView) findViewById(R.id.cpv);
    }

    private void e() {
        OSETVideoContent.getInstance().setPosId(this.b).loadRecommend(new a(this));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        VideoContentResult videoContentResult = this.g;
        if (videoContentResult == null || !videoContentResult.onBackPress()) {
            super.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.oset_activity_video_content);
        com.kc.openset.util.b.b(this, 0, false);
        c();
        d();
        e();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        OSETVideoContentTaskListener oSETVideoContentTaskListener = f39986a;
        if (oSETVideoContentTaskListener != null) {
            oSETVideoContentTaskListener.onClose();
            f39986a = null;
        }
        CircularProgressView circularProgressView = this.f;
        if (circularProgressView != null) {
            circularProgressView.a();
            this.f = null;
        }
        VideoContentResult videoContentResult = this.g;
        if (videoContentResult != null) {
            videoContentResult.destroy();
            this.g = null;
        }
    }
}

package com.kc.cw.ad.internal.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.kc.cw.ad.b.a;
import com.kc.cw.ad.b.b;
import com.kc.cw.ad.d.b.f;
import com.kc.cw.ad.internal.k;
import com.kc.cw.ad.internal.utilities.ImageManager;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class StopoverDialogActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f38860a;
    private String b;
    private String c;
    private String d;
    private boolean e;
    private boolean f;
    private a g;
    private ImageView h;
    private RelativeLayout i;
    private RelativeLayout j;
    private TextView k;
    private TextView l;
    private TextView m;

    private void a() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.SSAdAlertDialogStyle);
            View viewInflate = LayoutInflater.from(this).inflate(R.layout.ss_dialog_stopover, (ViewGroup) null);
            builder.setView(viewInflate);
            AlertDialog alertDialogCreate = builder.create();
            alertDialogCreate.setCancelable(false);
            alertDialogCreate.setCanceledOnTouchOutside(false);
            this.h = (ImageView) viewInflate.findViewById(R.id.iv_gift);
            this.i = (RelativeLayout) viewInflate.findViewById(R.id.rl_tip_start);
            this.j = (RelativeLayout) viewInflate.findViewById(R.id.rl_tip_countdown);
            this.k = (TextView) viewInflate.findViewById(R.id.tv_tip_time);
            this.l = (TextView) viewInflate.findViewById(R.id.tv_tip_end);
            ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_app_icon);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_ad_title);
            TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_ad_description);
            this.m = (TextView) viewInflate.findViewById(R.id.tv_button);
            ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.iv_click);
            ImageManager.with(this).load(this.f38860a).into(imageView);
            textView.setText(this.b);
            textView2.setText(this.c);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setRepeatCount(-1);
            alphaAnimation.setRepeatMode(2);
            imageView2.startAnimation(alphaAnimation);
            TextView textView3 = (TextView) viewInflate.findViewById(R.id.tv_continue);
            textView3.setPaintFlags(textView3.getPaintFlags() | 8);
            this.m.setOnClickListener(new View.OnClickListener(this) { // from class: com.kc.cw.ad.internal.activity.StopoverDialogActivity.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final StopoverDialogActivity f38861a;

                {
                    this.f38861a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (this.f38861a.f) {
                        this.f38861a.finish();
                    } else {
                        k.a().a("adClick");
                        this.f38861a.e = true;
                    }
                }
            });
            textView3.setOnClickListener(new View.OnClickListener(this) { // from class: com.kc.cw.ad.internal.activity.StopoverDialogActivity.2

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final StopoverDialogActivity f38862a;

                {
                    this.f38862a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f38862a.finish();
                }
            });
            alertDialogCreate.show();
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        TextView textView;
        String str;
        if (i == 1) {
            this.h.setVisibility(8);
            this.i.setVisibility(8);
            this.l.setVisibility(8);
            this.j.setVisibility(0);
            textView = this.m;
            str = "返回页面";
        } else if (i != 2) {
            this.j.setVisibility(8);
            this.l.setVisibility(8);
            this.h.setVisibility(0);
            this.i.setVisibility(0);
            textView = this.m;
            str = "立即前往";
        } else {
            this.h.setVisibility(8);
            this.i.setVisibility(8);
            this.j.setVisibility(8);
            this.l.setVisibility(0);
            textView = this.m;
            str = "返回视频";
        }
        textView.setText(str);
    }

    private void b() {
        a aVar = this.g;
        if (aVar != null) {
            aVar.c();
            return;
        }
        a aVar2 = new a(15000L, 50L);
        this.g = aVar2;
        aVar2.a(new b(this) { // from class: com.kc.cw.ad.internal.activity.StopoverDialogActivity.3

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final StopoverDialogActivity f38863a;

            {
                this.f38863a = this;
            }

            @Override // com.kc.cw.ad.b.b
            public void a() {
                k.a().a("getReward");
                this.f38863a.f = true;
                this.f38863a.a(2);
            }

            @Override // com.kc.cw.ad.b.b
            public void a(long j) {
                int i = (int) ((j / 1000) + 1);
                if (this.f38863a.k != null) {
                    this.f38863a.k.setText(String.valueOf(i));
                }
            }

            @Override // com.kc.cw.ad.b.b
            public void b() {
            }
        });
        this.g.a();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Map map;
        super.onCreate(bundle);
        try {
            Bundle bundleExtra = getIntent().getBundleExtra("bundleData");
            if (bundleExtra == null || (map = (Map) bundleExtra.getSerializable("mapData")) == null) {
                return;
            }
            this.f38860a = (String) map.get(RemoteMessageConst.Notification.ICON);
            this.b = (String) map.get("title");
            this.c = (String) map.get("description");
            this.d = (String) map.get("landingPageUrl");
            a();
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        k.a().a("StopoverFinish");
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.e) {
            a(1);
            b();
            this.e = false;
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        a aVar = this.g;
        if (aVar != null) {
            aVar.b();
        }
    }
}

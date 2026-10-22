package com.kc.cw.ad.internal.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.kc.cw.ad.d.b.f;
import com.kc.cw.ad.internal.k;
import com.kc.cw.ad.internal.utilities.ImageManager;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class EndingPageActivity extends Activity {
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Map map;
        super.onCreate(bundle);
        setContentView(R.layout.ss_activity_ending_page);
        try {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            getWindow().setAttributes(attributes);
            Bundle bundleExtra = getIntent().getBundleExtra("bundleData");
            if (bundleExtra == null || (map = (Map) bundleExtra.getSerializable("mapData")) == null) {
                return;
            }
            String str = (String) map.get(RemoteMessageConst.Notification.ICON);
            String str2 = (String) map.get("title");
            String str3 = (String) map.get("description");
            ImageView imageView = (ImageView) findViewById(R.id.ad_close);
            ImageView imageView2 = (ImageView) findViewById(R.id.iv_app_icon);
            ImageView imageView3 = (ImageView) findViewById(R.id.iv_click);
            TextView textView = (TextView) findViewById(R.id.ad_feedback);
            TextView textView2 = (TextView) findViewById(R.id.tv_ad_title);
            TextView textView3 = (TextView) findViewById(R.id.tv_ad_description);
            TextView textView4 = (TextView) findViewById(R.id.tv_button);
            ImageManager.with(this).load(str).into(imageView2);
            textView2.setText(str2);
            textView3.setText(str3);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setRepeatCount(-1);
            alphaAnimation.setRepeatMode(2);
            imageView3.startAnimation(alphaAnimation);
            textView.setOnClickListener(new View.OnClickListener(this) { // from class: com.kc.cw.ad.internal.activity.EndingPageActivity.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final EndingPageActivity f38857a;

                {
                    this.f38857a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.a().a("feedBackClick");
                }
            });
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: com.kc.cw.ad.internal.activity.EndingPageActivity.2

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final EndingPageActivity f38858a;

                {
                    this.f38858a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    this.f38858a.finish();
                }
            });
            textView4.setOnClickListener(new View.OnClickListener(this) { // from class: com.kc.cw.ad.internal.activity.EndingPageActivity.3

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final EndingPageActivity f38859a;

                {
                    this.f38859a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    k.a().a("adClick");
                }
            });
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}

package com.acse.ottn.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.acse.ottn.R;
import com.acse.ottn.h0;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class WXActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EditText f22853a;
    public EditText b;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            WXActivity.this.a();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_wxactivity);
        this.f22853a = (EditText) findViewById(R.id.et_text);
        this.b = (EditText) findViewById(R.id.et_text2);
        findViewById(R.id.tw_text).setOnClickListener(new a());
    }

    public final void a() {
        IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(this, h0.a().a((Context) this), false);
        WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
        req.userName = this.b.getText().toString();
        req.path = this.f22853a.getText().toString();
        req.miniprogramType = 0;
        iwxapiCreateWXAPI.sendReq(req);
    }
}

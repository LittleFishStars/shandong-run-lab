package com.bytedance.sdk.openadsdk.core.activity.base;

import android.os.Bundle;
import android.view.View;
import com.byazt.dh.ve;
import com.byazt.ff.TTScrollView;
import com.byazt.nr.m;
import com.byazt.un.NativeVideoTsView;
import com.byazt.un.uj;
import com.byazt.vfu.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class TTVideoScrollWebPageActivity extends TTVideoWebPageActivity {
    private TTScrollView bx;

    @Override // com.byazt.cty.BaseLandingPageActivity, com.byazt.cty.BaseThemeActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TTScrollView tTScrollView = (TTScrollView) findViewById(2114387873);
        this.bx = tTScrollView;
        tTScrollView.setListener(new TTScrollView.c() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity.1
            @Override // com.byazt.ff.TTScrollView.c
            public void c(boolean z) {
                try {
                    ve veVar = ((TTVideoWebPageActivity) TTVideoScrollWebPageActivity.this).pf;
                    if (veVar != null && (veVar instanceof uj)) {
                        if (!z || veVar.gt()) {
                            ((TTVideoWebPageActivity) TTVideoScrollWebPageActivity.this).pf.a();
                        } else {
                            ((uj) ((TTVideoWebPageActivity) TTVideoScrollWebPageActivity.this).pf).a(false);
                        }
                    }
                } catch (Throwable th) {
                    m.ve("TTVideoScrollWebPageActivity", "onCreate isShow error", th);
                }
            }
        });
        ve veVar = ((TTVideoWebPageActivity) this).pf;
        if (veVar != null) {
            veVar.uj(false);
        }
        NativeVideoTsView nativeVideoTsView = ((TTVideoWebPageActivity) this).nb;
        if (nativeVideoTsView != null) {
            nativeVideoTsView.setVideoAdInteractionListener(new ve.InterfaceC0386ve() { // from class: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity.2
                @Override // com.byazt.dh.ve.InterfaceC0386ve
                public void onProgressUpdate(long j, long j2) {
                }

                @Override // com.byazt.dh.ve.InterfaceC0386ve
                public void onVideoAdContinuePlay() {
                }

                @Override // com.byazt.dh.ve.InterfaceC0386ve
                public void onVideoAdPaused() {
                }

                @Override // com.byazt.dh.ve.InterfaceC0386ve
                public void onVideoAdStartPlay() {
                    ve veVar2;
                    if (TTVideoScrollWebPageActivity.this.bx == null || TTVideoScrollWebPageActivity.this.bx.c() || (veVar2 = ((TTVideoWebPageActivity) TTVideoScrollWebPageActivity.this).pf) == null) {
                        return;
                    }
                    veVar2.sp();
                }

                @Override // com.byazt.dh.ve.InterfaceC0386ve
                public void onVideoComplete() {
                }
            });
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        super.setContentView(a.pf(this));
    }
}

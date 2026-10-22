package com.kwad.components.core.s.a;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.c.f;
import com.kwad.components.core.webview.tachikoma.k;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.components.n;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.c;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsAdSdkDynamicImpl(FeedDownloadActivity.class)
public class a extends com.kwad.components.core.n.b<b> {
    private static final ConcurrentMap<Integer, Map<String, Object>> akU = new ConcurrentHashMap();
    private static final AtomicInteger akV = new AtomicInteger(1);
    private StyleTemplate akN;
    private String akO;
    private boolean akP;
    private n akQ;
    private k akR;
    private com.kwad.components.core.s.b.b akS;
    private int akT;
    private AdResultData mAdResultData;
    private AdBaseFrameLayout mRootContainer;
    private com.kwad.components.core.b.a mTitleBarHelper;

    public static void a(int i, String str, Object obj) {
        ConcurrentMap<Integer, Map<String, Object>> concurrentMap = akU;
        Map<String, Object> map = concurrentMap.get(Integer.valueOf(i));
        if (map == null) {
            map = new HashMap<>();
            concurrentMap.put(Integer.valueOf(i), map);
        }
        map.put(str, obj);
    }

    private static void bX(int i) {
        Map<String, Object> map = akU.get(Integer.valueOf(i));
        if (map != null) {
            map.clear();
        }
    }

    private Object bj(String str) {
        return s(this.akT, str);
    }

    @InvokeBy(invokerClass = c.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        c.putComponentProxy(FeedDownloadActivity.class, a.class);
    }

    private static Object s(int i, String str) {
        Map<String, Object> map = akU.get(Integer.valueOf(i));
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.n.b
    /* JADX INFO: renamed from: wv, reason: merged with bridge method [inline-methods] */
    public b onCreateCallerContext() {
        b bVar = new b(this);
        bVar.a(this.mAdResultData);
        bVar.akN = this.akN;
        bVar.mRootContainer = this.mRootContainer;
        bVar.akQ = this.akQ;
        bVar.akR = this.akR;
        return bVar;
    }

    public static int ww() {
        return akV.incrementAndGet();
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean checkIntentData(@Nullable Intent intent) {
        this.akT = getIntent().getIntExtra("tk_id", 0);
        String stringExtra = getIntent().getStringExtra("tk_style_template");
        k kVar = (k) bj("tk_view_holder");
        if (TextUtils.isEmpty(stringExtra) && kVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                StyleTemplate styleTemplate = new StyleTemplate();
                styleTemplate.parseJson(new JSONObject(stringExtra));
                this.akN = styleTemplate;
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTrace(th);
                return false;
            }
        }
        if (kVar != null) {
            this.akR = kVar;
        }
        int intExtra = getIntent().getIntExtra("ad_result_cache_idx", 0);
        AdResultData adResultDataD = f.oU().d(intExtra, true);
        this.mAdResultData = adResultDataD;
        return intExtra <= 0 || adResultDataD != null;
    }

    @Override // com.kwad.components.core.proxy.f
    public int getLayoutId() {
        return R.layout.ksad_tk_page;
    }

    @Override // com.kwad.components.core.proxy.f
    public String getPageName() {
        return "TKActivityProxy";
    }

    @Override // com.kwad.components.core.proxy.f
    public void initData() {
        this.akP = getIntent().getBooleanExtra("show_navigationBar", true);
        this.akO = getIntent().getStringExtra("title");
        this.akQ = (n) bj("native_intent");
    }

    @Override // com.kwad.components.core.proxy.f
    public void initView() {
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_tk_root_container);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.ksad_js_container);
        if (!this.akP && frameLayout != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.topMargin = 0;
            frameLayout.setLayoutParams(layoutParams);
        }
        com.kwad.components.core.b.a aVar = new com.kwad.components.core.b.a((ViewGroup) findViewById(R.id.ksad_kwad_web_title_bar));
        this.mTitleBarHelper = aVar;
        aVar.a(new com.kwad.components.core.b.a.InterfaceC1190a() { // from class: com.kwad.components.core.s.a.a.1
            @Override // com.kwad.components.core.b.a.InterfaceC1190a
            public final void w(View view) {
                a.this.finish();
            }

            @Override // com.kwad.components.core.b.a.InterfaceC1190a
            public final void x(View view) {
            }
        });
        this.mTitleBarHelper.a(new com.kwad.components.core.b.b(this.akO));
        this.mTitleBarHelper.ak(false);
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        com.kwad.components.core.s.b.b bVar = this.akS;
        if (bVar == null || !bVar.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override // com.kwad.components.core.n.b
    public Presenter onCreatePresenter() {
        if (this.akN != null) {
            return new com.kwad.components.core.s.b.a();
        }
        if (this.akS == null) {
            this.akS = new com.kwad.components.core.s.b.b();
        }
        return this.akS;
    }

    @Override // com.kwad.components.core.n.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            super.onDestroy();
            bX(this.akT);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.n.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
    }

    @Override // com.kwad.components.core.n.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
    }
}

package com.kc.dw.core.webview;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.a1;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class l {
    public static Handler h = null;
    public static int i = 9000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebView f39444a;
    public int c;
    public boolean d;
    public long e;
    public i g;
    public int b = 1;
    public Runnable f = new c(this);

    @Keep
    public class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l f39445a;

        public a(l lVar) {
            this.f39445a = lVar;
        }

        public void a(int i, String str) {
            i iVar = this.f39445a.g;
            if (iVar != null) {
                iVar.onWebError(i, str);
            }
        }
    }

    @Keep
    public class b implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f39446a;
        public final com.kc.dw.platform.ad_adapter.c b;
        public final l c;

        public b(l lVar, Context context, com.kc.dw.platform.ad_adapter.c cVar) {
            this.c = lVar;
            this.f39446a = context;
            this.b = cVar;
        }

        @Override // com.kc.dw.core.webview.i
        public void onClosePage() {
            Handler handler = l.h;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            i iVar = this.c.g;
            if (iVar != null) {
                iVar.onClosePage();
            }
        }

        @Override // com.kc.dw.core.webview.i
        public void onRewardSuccess() {
        }

        @Override // com.kc.dw.core.webview.i
        public void onWebClicked() {
            int rewardTmpId;
            l lVar = this.c;
            Context context = this.f39446a;
            com.kc.dw.platform.ad_adapter.c cVar = this.b;
            lVar.getClass();
            if (cVar.a() instanceof BaseAdSlot) {
                rewardTmpId = ((BaseAdSlot) cVar.a()).getRewardTmpId();
                int reward_tmp_time = ((BaseAdSlot) cVar.a()).getReward_tmp_time();
                if (reward_tmp_time > 0) {
                    l.i = reward_tmp_time * 1000;
                }
            } else {
                rewardTmpId = 0;
            }
            if (!lVar.d) {
                if (l.h == null) {
                    l.h = new Handler();
                }
                l.h.post(lVar.f);
            }
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            Intent intent = new Intent();
            intent.setAction("broadcast_onclick");
            intent.putExtra("clk_act_type", 2);
            intent.putExtra("image_width", displayMetrics.widthPixels);
            intent.putExtra("image_height", displayMetrics.heightPixels);
            intent.putExtra("click_reward_tmp_id", rewardTmpId);
            intent.putExtra("is_reward_tmp_click", true);
            LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
        }

        @Override // com.kc.dw.core.webview.i
        public void onWebError(int i, String str) {
        }

        @Override // com.kc.dw.core.webview.i
        public void onWebReady(boolean z) {
            i iVar = this.c.g;
            if (iVar != null) {
                iVar.onWebReady(z);
            }
        }
    }

    @Keep
    public class c extends com.kc.dw.core.safe.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l f39447a;

        public c(l lVar) {
            this.f39447a = lVar;
        }

        @Override // com.kc.dw.core.safe.j
        public void safeRun() {
            try {
                if (!com.kc.dw.core.service.c.a()) {
                    l lVar = this.f39447a;
                    if (lVar.e == 0) {
                        lVar.e = System.currentTimeMillis();
                    }
                    l lVar2 = this.f39447a;
                    lVar2.c += 500;
                    lVar2.b = 2;
                    Handler handler = l.h;
                    if (handler != null) {
                        handler.postDelayed(lVar2.f, 500L);
                        return;
                    }
                    return;
                }
                l lVar3 = this.f39447a;
                if (lVar3.b != 1 && lVar3.e > 0) {
                    if (System.currentTimeMillis() - this.f39447a.e < l.i) {
                        LogUtil.e("WebViewUtil", "task_interrupted, mUpdateTime=" + this.f39447a.c + ",rewardTmpTime=" + l.i);
                        l.a(this.f39447a, "task_interrupted");
                    } else {
                        LogUtil.e("WebViewUtil", "达到目标时间，成功 ,task_completed");
                        this.f39447a.d = true;
                        l.a(this.f39447a, "task_completed");
                        this.f39447a.c = 0;
                        l.h.removeCallbacksAndMessages(null);
                        i iVar = this.f39447a.g;
                        if (iVar != null) {
                            iVar.onRewardSuccess();
                        }
                    }
                }
                l.h.postDelayed(this.f39447a.f, 500L);
                l lVar4 = this.f39447a;
                lVar4.getClass();
                lVar4.b = 1;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void a(WebView webView) {
        if (webView == null) {
            return;
        }
        try {
            webView.stopLoading();
            webView.loadUrl("about:blank");
            webView.clearHistory();
            webView.clearCache(true);
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(webView);
            }
            webView.destroy();
            Handler handler = h;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0038 A[Catch: all -> 0x005e, TryCatch #1 {all -> 0x005e, blocks: (B:3:0x0003, B:6:0x000e, B:7:0x0010, B:9:0x0026, B:13:0x002f, B:15:0x0038, B:16:0x0047, B:18:0x004d, B:19:0x0056, B:12:0x002b), top: B:31:0x0003, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x004d A[Catch: all -> 0x005e, LOOP:0: B:16:0x0047->B:18:0x004d, LOOP_END, TryCatch #1 {all -> 0x005e, blocks: (B:3:0x0003, B:6:0x000e, B:7:0x0010, B:9:0x0026, B:13:0x002f, B:15:0x0038, B:16:0x0047, B:18:0x004d, B:19:0x0056, B:12:0x002b), top: B:31:0x0003, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0056 A[EDGE_INSN: B:33:0x0056->B:19:0x0056 BREAK  A[LOOP:0: B:16:0x0047->B:18:0x004d], SYNTHETIC] */
    public static void a(WebView webView, String str) throws Throwable {
        File file;
        File file2;
        StringBuilder sb;
        BufferedReader bufferedReader;
        String line;
        String str2 = a1.f39348a;
        String string = null;
        try {
            String strA = a1.a(str);
            if (!TextUtils.isEmpty(strA)) {
                try {
                    file2 = new File(com.kc.dw.base.a.getContext().getFilesDir(), "rwd_temps");
                    if (file2.exists()) {
                        file = new File(file2, strA);
                        if (file.exists()) {
                            sb = new StringBuilder();
                            bufferedReader = new BufferedReader(new FileReader(file));
                            while (true) {
                                line = bufferedReader.readLine();
                                if (line != null) {
                                    break;
                                    break;
                                } else {
                                    sb.append(line);
                                    sb.append("\n");
                                }
                            }
                            bufferedReader.close();
                            string = sb.toString();
                        }
                    } else {
                        file2.mkdirs();
                        file = new File(file2, strA);
                        if (file.exists()) {
                            sb = new StringBuilder();
                            bufferedReader = new BufferedReader(new FileReader(file));
                            while (true) {
                                line = bufferedReader.readLine();
                                if (line != null) {
                                    break;
                                }
                                sb.append(line);
                                sb.append("\n");
                            }
                            bufferedReader.close();
                            string = sb.toString();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    file2 = null;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        String str3 = string;
        if (TextUtils.isEmpty(str3)) {
            webView.loadUrl(str);
        } else {
            LogUtil.dev("WebViewUtil", "use local webView");
            webView.loadDataWithBaseURL(str, str3, "text/html", "UTF-8", null);
        }
    }

    public static void a(l lVar, String str) {
        if (lVar.f39444a == null || h == null) {
            return;
        }
        LogUtil.e("WebViewUtil", "notifyWebStatus----------------");
        lVar.f39444a.post(new m(lVar, str));
    }

    public static boolean a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.startsWith("about:") || str.startsWith("data:") || str.toLowerCase().contains(com.ipd.dsp.internal.n.a.c);
        } catch (Exception unused) {
            return false;
        }
    }

    public n a(Context context, String str, com.kc.dw.platform.ad_adapter.c cVar, boolean z, com.kc.dw.core.webview.listener.a aVar) {
        try {
            WebView webView = new WebView(new ContextWrapper(context));
            this.f39444a = webView;
            webView.setScrollBarStyle(0);
            WebSettings settings = this.f39444a.getSettings();
            settings.setSavePassword(false);
            settings.setCacheMode(2);
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setAllowFileAccess(false);
            e eVar = new e(str);
            eVar.a(aVar);
            this.f39444a.setDownloadListener(com.kc.dw.core.webview.b.a(context));
            d dVar = new d(context, str, eVar);
            dVar.h = new a(this);
            dVar.f = false;
            this.f39444a.setWebViewClient(dVar);
            this.f39444a.setWebChromeClient(new com.kc.dw.core.webview.c(str, eVar));
            com.kc.dw.core.webview.a aVar2 = new com.kc.dw.core.webview.a(cVar, this.f39444a, eVar);
            if (z) {
                this.f39444a.setBackgroundColor(0);
                aVar2.e = new b(this, context, cVar);
            }
            this.f39444a.addJavascriptInterface(aVar2, "ADMateJSBridge");
            a(this.f39444a, str);
            return new n(this.f39444a, dVar, eVar);
        } catch (Throwable th) {
            th.printStackTrace();
            ((com.kc.dw.core.webview.listener.c) aVar).onPageFinished(str, true, false, -1);
            return null;
        }
    }
}

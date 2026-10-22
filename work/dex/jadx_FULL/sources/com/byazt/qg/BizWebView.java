package com.byazt.qg;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.byazt.nl.uj;
import com.byazt.nl.ve;
import com.byazt.nr.da;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS, 2282})
public class BizWebView extends MultiWebview implements uj {
    public BizWebView(Context context) {
        super(context);
    }

    private void tt(Runnable runnable) {
        da.tt().post(runnable);
    }

    @Override // com.byazt.qg.MultiWebview
    public void M_() {
        super.M_();
    }

    @Override // com.byazt.nl.uj
    public void addJavascriptInterface(final Object obj, final String str) {
        if (this.tt != null) {
            this.tt.addJavascriptInterface(obj, str);
        } else if (this.c.get() < 3) {
            tt(new Runnable() { // from class: com.byazt.qg.BizWebView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.tt != null) {
                        BizWebView.this.tt.addJavascriptInterface(obj, str);
                    }
                }
            });
        }
    }

    @Override // com.byazt.nl.uj
    public void c(String str, String str2, Object obj) {
        if (this.tt != null) {
            this.tt.c(str, str2, obj);
        }
    }

    @Override // com.byazt.nl.uj
    public boolean canGoBack() {
        if (this.tt != null) {
            if (this.tt.canGoBack()) {
                return true;
            }
            if (getWebViewCount() > 1 && c() != null) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.nl.uj
    public void clearCache(boolean z) {
        if (this.tt != null) {
            this.tt.clearCache(z);
        }
    }

    @Override // com.byazt.nl.uj
    public void clearHistory() {
        if (this.tt != null) {
            this.tt.clearHistory();
        }
    }

    @Override // com.byazt.nl.uj
    public void clearView() {
        if (this.tt != null) {
            this.tt.clearView();
        }
    }

    @Override // android.view.View, com.byazt.nl.uj
    public void computeScroll() {
        if (this.tt != null) {
            this.tt.computeScroll();
            return;
        }
        AtomicInteger atomicInteger = this.c;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        post(new Runnable() { // from class: com.byazt.qg.BizWebView.28
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.tt != null) {
                    BizWebView.this.tt.computeScroll();
                }
            }
        });
    }

    @Override // com.byazt.qg.MultiWebview, com.byazt.nl.uj
    public void destroy() {
        super.destroy();
    }

    @Override // com.byazt.nl.uj
    public void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        if (this.tt != null) {
            this.tt.evaluateJavascript(str, valueCallback);
        } else if (this.c.get() < 3) {
            tt(new Runnable() { // from class: com.byazt.qg.BizWebView.7
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.tt != null) {
                        BizWebView.this.tt.evaluateJavascript(str, valueCallback);
                    }
                }
            });
        }
    }

    @Override // com.byazt.nl.uj
    public int getContentHeight() {
        if (this.tt != null) {
            return this.tt.getContentHeight();
        }
        return 0;
    }

    @Override // com.byazt.nl.uj
    public int getProgress() {
        if (this.tt != null) {
            return this.tt.getProgress();
        }
        return 0;
    }

    @Override // com.byazt.nl.uj
    public String getUrl() {
        return this.tt != null ? this.tt.getUrl() : "";
    }

    @Override // com.byazt.nl.uj
    public String getUserAgentString() {
        return this.tt != null ? this.tt.getUserAgentString() : "";
    }

    @Override // com.byazt.nl.uj
    public View getView() {
        return this;
    }

    @Override // com.byazt.nl.uj
    public WebView getWebView() {
        if (this.tt != null) {
            return this.tt.getWebView();
        }
        if (n()) {
            return null;
        }
        long j = 500;
        while (this.c.get() < 3 && j > 0) {
            try {
                Thread.sleep(10L);
                j -= 10;
            } catch (Exception unused) {
            }
        }
        if (this.tt != null) {
            return this.tt.getWebView();
        }
        return null;
    }

    @Override // com.byazt.nl.uj
    public void goBack() {
        if (this.tt != null) {
            this.tt.goBack();
        }
    }

    @Override // com.byazt.nl.uj
    public void loadUrl(final String str) {
        if (this.tt != null) {
            this.tt.loadUrl(str);
        } else if (this.c.get() < 3) {
            tt(new Runnable() { // from class: com.byazt.qg.BizWebView.22
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.tt != null) {
                        BizWebView.this.tt.loadUrl(str);
                    }
                }
            });
        }
    }

    public void onPause() {
        if (this.tt != null) {
            this.tt.onPause();
        }
    }

    @Override // com.byazt.nl.uj
    public void onResume() {
        if (this.tt != null) {
            this.tt.onResume();
        }
    }

    @Override // com.byazt.nl.uj
    public void pauseTimers() {
        if (this.tt != null) {
            this.tt.pauseTimers();
        }
    }

    @Override // com.byazt.nl.uj
    public void removeJavascriptInterface(String str) {
        uj ujVar = this.tt;
        if (ujVar != null) {
            ujVar.removeJavascriptInterface(str);
        }
    }

    @Override // com.byazt.nl.uj
    public void resumeTimers() {
        if (this.tt != null) {
            this.tt.resumeTimers();
        }
    }

    @Override // com.byazt.nl.uj
    public void setAllowFileAccess(final boolean z) {
        if (this.tt != null) {
            this.tt.setAllowFileAccess(z);
        } else if (this.c.get() < 3) {
            tt(new Runnable() { // from class: com.byazt.qg.BizWebView.20
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.tt != null) {
                        BizWebView.this.tt.setAllowFileAccess(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.nl.uj
    public void setAllowFileAccessFromFileURLs(final boolean z) {
        if (this.tt != null) {
            this.tt.setAllowFileAccessFromFileURLs(z);
        } else if (this.c.get() < 3) {
            tt(new Runnable() { // from class: com.byazt.qg.BizWebView.23
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.tt != null) {
                        BizWebView.this.tt.setAllowFileAccessFromFileURLs(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.nl.uj
    public void setAllowUniversalAccessFromFileURLs(final boolean z) {
        if (this.tt != null) {
            this.tt.setAllowUniversalAccessFromFileURLs(z);
        } else if (this.c.get() < 3) {
            tt(new Runnable() { // from class: com.byazt.qg.BizWebView.24
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.tt != null) {
                        BizWebView.this.tt.setAllowFileAccessFromFileURLs(z);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.byazt.nl.uj
    public void setAlpha(final float f) {
        super.setAlpha(f);
        if (this.tt != null) {
            this.tt.setAlpha(f);
            return;
        }
        AtomicInteger atomicInteger = this.c;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        post(new Runnable() { // from class: com.byazt.qg.BizWebView.32
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.tt != null) {
                    BizWebView.this.tt.setAlpha(f);
                }
            }
        });
    }

    @Override // com.byazt.nl.uj
    public void setAppCacheEnabled(final boolean z) {
        if (this.tt != null) {
            this.tt.setAppCacheEnabled(z);
        } else if (this.c.get() < 3) {
            tt(new Runnable() { // from class: com.byazt.qg.BizWebView.8
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.tt != null) {
                        BizWebView.this.tt.setAppCacheEnabled(z);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.byazt.nl.uj
    public void setBackgroundColor(final int i) {
        super.setBackgroundColor(i);
        if (this.tt != null) {
            this.tt.setBackgroundColor(i);
            return;
        }
        AtomicInteger atomicInteger = this.c;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        post(new Runnable() { // from class: com.byazt.qg.BizWebView.27
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.tt != null) {
                    BizWebView.this.tt.setBackgroundColor(i);
                }
            }
        });
    }

    @Override // com.byazt.nl.uj
    public void setBlockNetworkImage(final boolean z) {
        if (this.tt != null) {
            this.tt.setBlockNetworkImage(z);
        } else if (this.c.get() < 3) {
            tt(new Runnable() { // from class: com.byazt.qg.BizWebView.21
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.tt != null) {
                        BizWebView.this.tt.setBlockNetworkImage(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.nl.uj
    public void setBuiltInZoomControls(final boolean z) {
        if (this.tt != null) {
            this.tt.setBuiltInZoomControls(z);
        } else if (this.c.get() < 3) {
            tt(new Runnable() { // from class: com.byazt.qg.BizWebView.13
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.tt != null) {
                        BizWebView.this.tt.setBuiltInZoomControls(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.nl.uj
    public void setCacheMode(final int i) {
        if (this.tt != null) {
            this.tt.setCacheMode(i);
        } else if (this.c.get() < 3) {
            tt(new Runnable() { // from class: com.byazt.qg.BizWebView.6
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.tt != null) {
                        BizWebView.this.tt.setCacheMode(i);
                    }
                }
            });
        }
    }

    @Override // com.byazt.nl.uj
    public void setDatabaseEnabled(final boolean z) {
        if (this.tt != null) {
            this.tt.setDatabaseEnabled(z);
        } else if (this.c.get() < 3) {
            tt(new Runnable() { // from class: com.byazt.qg.BizWebView.19
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.tt != null) {
                        BizWebView.this.tt.setDatabaseEnabled(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.nl.uj
    public void setDefaultFontSize(final int i) {
        if (this.tt != null) {
            this.tt.setDefaultFontSize(i);
        } else if (this.c.get() < 3) {
            tt(new Runnable() { // from class: com.byazt.qg.BizWebView.17
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.tt != null) {
                        BizWebView.this.tt.setDefaultFontSize(i);
                    }
                }
            });
        }
    }

    @Override // com.byazt.nl.uj
    public void setDefaultTextEncodingName(final String str) {
        if (this.tt != null) {
            this.tt.setDefaultTextEncodingName(str);
        } else if (this.c.get() < 3) {
            tt(new Runnable() { // from class: com.byazt.qg.BizWebView.16
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.tt != null) {
                        BizWebView.this.tt.setDefaultTextEncodingName(str);
                    }
                }
            });
        }
    }

    @Override // com.byazt.nl.uj
    public void setDisplayZoomControls(final boolean z) {
        if (this.tt != null) {
            this.tt.setDisplayZoomControls(z);
        } else if (this.c.get() < 3) {
            tt(new Runnable() { // from class: com.byazt.qg.BizWebView.5
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.tt != null) {
                        BizWebView.this.tt.setDisplayZoomControls(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.nl.uj
    public void setDomStorageEnabled(final boolean z) {
        if (this.tt != null) {
            this.tt.setDomStorageEnabled(z);
        } else if (this.c.get() < 3) {
            tt(new Runnable() { // from class: com.byazt.qg.BizWebView.12
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.tt != null) {
                        BizWebView.this.tt.setDomStorageEnabled(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.nl.uj
    public void setDownloadListener(final DownloadListener downloadListener) {
        if (this.tt != null) {
            this.tt.setDownloadListener(downloadListener);
        } else if (this.c.get() < 3) {
            tt(new Runnable() { // from class: com.byazt.qg.BizWebView.37
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.tt != null) {
                        BizWebView.this.tt.setDownloadListener(downloadListener);
                    }
                }
            });
        }
    }

    @Override // com.byazt.nl.uj
    public void setJavaScriptCanOpenWindowsAutomatically(final boolean z) {
        if (this.tt != null) {
            this.tt.setJavaScriptCanOpenWindowsAutomatically(z);
        } else if (this.c.get() < 3) {
            tt(new Runnable() { // from class: com.byazt.qg.BizWebView.11
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.tt != null) {
                        BizWebView.this.tt.setJavaScriptCanOpenWindowsAutomatically(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.nl.uj
    public void setJavaScriptEnabled(final boolean z) {
        if (this.tt != null) {
            this.tt.setJavaScriptEnabled(z);
        } else if (this.c.get() < 3) {
            tt(new Runnable() { // from class: com.byazt.qg.BizWebView.4
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.tt != null) {
                        BizWebView.this.tt.setJavaScriptEnabled(z);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.byazt.nl.uj
    public void setLayerType(final int i, final Paint paint) {
        if (this.tt != null) {
            this.tt.setLayerType(i, paint);
            return;
        }
        AtomicInteger atomicInteger = this.c;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        post(new Runnable() { // from class: com.byazt.qg.BizWebView.29
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.tt != null) {
                    BizWebView.this.tt.setLayerType(i, paint);
                }
            }
        });
    }

    @Override // com.byazt.nl.uj
    public void setLayoutAlgorithm(final WebSettings.LayoutAlgorithm layoutAlgorithm) {
        if (this.tt != null) {
            this.tt.setLayoutAlgorithm(layoutAlgorithm);
        } else if (this.c.get() < 3) {
            tt(new Runnable() { // from class: com.byazt.qg.BizWebView.14
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.tt != null) {
                        BizWebView.this.tt.setLayoutAlgorithm(layoutAlgorithm);
                    }
                }
            });
        }
    }

    @Override // com.byazt.nl.uj
    public void setLoadWithOverviewMode(final boolean z) {
        if (this.tt != null) {
            this.tt.setLoadWithOverviewMode(z);
        } else if (this.c.get() < 3) {
            tt(new Runnable() { // from class: com.byazt.qg.BizWebView.15
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.tt != null) {
                        BizWebView.this.tt.setLoadWithOverviewMode(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.nl.uj
    public void setMediaPlaybackRequiresUserGesture(final boolean z) {
        if (this.tt != null) {
            this.tt.setMediaPlaybackRequiresUserGesture(z);
        } else if (this.c.get() < 3) {
            tt(new Runnable() { // from class: com.byazt.qg.BizWebView.26
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.tt != null) {
                        BizWebView.this.tt.setMediaPlaybackRequiresUserGesture(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.nl.uj
    public void setMixedContentMode(final int i) {
        if (this.tt != null) {
            this.tt.setMixedContentMode(i);
        } else if (this.c.get() < 3) {
            tt(new Runnable() { // from class: com.byazt.qg.BizWebView.18
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.tt != null) {
                        BizWebView.this.tt.setMixedContentMode(i);
                    }
                }
            });
        }
    }

    @Override // com.byazt.nl.uj
    public void setNetworkAvailable(final boolean z) {
        if (this.tt != null) {
            this.tt.setNetworkAvailable(z);
            return;
        }
        AtomicInteger atomicInteger = this.c;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        tt(new Runnable() { // from class: com.byazt.qg.BizWebView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.tt != null) {
                    BizWebView.this.tt.setNetworkAvailable(z);
                }
            }
        });
    }

    @Override // android.view.View, com.byazt.nl.uj
    public void setOnScrollChangeListener(final View.OnScrollChangeListener onScrollChangeListener) {
        if (this.tt != null) {
            this.tt.setOnScrollChangeListener(onScrollChangeListener);
            return;
        }
        AtomicInteger atomicInteger = this.c;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        post(new Runnable() { // from class: com.byazt.qg.BizWebView.33
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.tt != null) {
                    BizWebView.this.tt.setOnScrollChangeListener(onScrollChangeListener);
                }
            }
        });
    }

    @Override // android.view.View, com.byazt.nl.uj
    public void setOverScrollMode(final int i) {
        super.setOverScrollMode(i);
        if (this.tt != null) {
            this.tt.setOverScrollMode(i);
            return;
        }
        AtomicInteger atomicInteger = this.c;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        post(new Runnable() { // from class: com.byazt.qg.BizWebView.30
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.tt != null) {
                    BizWebView.this.tt.setOverScrollMode(i);
                }
            }
        });
    }

    @Override // com.byazt.nl.uj
    public void setSavePassword(final boolean z) {
        if (this.tt != null) {
            this.tt.setSavePassword(z);
        } else if (this.c.get() < 3) {
            tt(new Runnable() { // from class: com.byazt.qg.BizWebView.25
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.tt != null) {
                        BizWebView.this.tt.setSavePassword(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.nl.uj
    public void setSupportZoom(final boolean z) {
        if (this.tt != null) {
            this.tt.setSupportZoom(z);
        } else if (this.c.get() < 3) {
            tt(new Runnable() { // from class: com.byazt.qg.BizWebView.9
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.tt != null) {
                        BizWebView.this.tt.setSupportZoom(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.nl.ve
    public void setTouchEventListener(final ve.c cVar) {
        if (this.tt != null) {
            this.tt.setTouchEventListener(cVar);
            return;
        }
        AtomicInteger atomicInteger = this.c;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        post(new Runnable() { // from class: com.byazt.qg.BizWebView.34
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.tt != null) {
                    BizWebView.this.tt.setTouchEventListener(cVar);
                }
            }
        });
    }

    @Override // com.byazt.nl.uj
    public void setUseWideViewPort(final boolean z) {
        if (this.tt != null) {
            this.tt.setUseWideViewPort(z);
        } else if (this.c.get() < 3) {
            tt(new Runnable() { // from class: com.byazt.qg.BizWebView.10
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.tt != null) {
                        BizWebView.this.tt.setUseWideViewPort(z);
                    }
                }
            });
        }
    }

    @Override // com.byazt.nl.uj
    public void setUserAgentString(final String str) {
        if (this.tt != null) {
            this.tt.setUserAgentString(str);
        } else if (this.c.get() < 3) {
            tt(new Runnable() { // from class: com.byazt.qg.BizWebView.35
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.tt != null) {
                        BizWebView.this.tt.setUserAgentString(str);
                    }
                }
            });
        }
    }

    @Override // android.view.View, com.byazt.nl.uj
    public void setVisibility(final int i) {
        super.setVisibility(i);
        if (this.tt != null) {
            this.tt.setVisibility(i);
            return;
        }
        AtomicInteger atomicInteger = this.c;
        if (atomicInteger == null || atomicInteger.get() >= 3) {
            return;
        }
        post(new Runnable() { // from class: com.byazt.qg.BizWebView.31
            @Override // java.lang.Runnable
            public void run() {
                if (BizWebView.this.tt != null) {
                    BizWebView.this.tt.setVisibility(i);
                }
            }
        });
    }

    @Override // com.byazt.nl.uj
    public void setWebChromeClient(final WebChromeClient webChromeClient) {
        if (this.tt != null) {
            this.tt.setWebChromeClient(webChromeClient);
        } else if (this.c.get() < 3) {
            tt(new Runnable() { // from class: com.byazt.qg.BizWebView.2
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.tt != null) {
                        BizWebView.this.tt.setWebChromeClient(webChromeClient);
                    }
                }
            });
        }
    }

    public void setWebViewClient(final WebViewClient webViewClient) {
        if (this.tt != null) {
            this.tt.setWebViewClient(webViewClient);
        } else if (this.c.get() < 3) {
            tt(new Runnable() { // from class: com.byazt.qg.BizWebView.36
                @Override // java.lang.Runnable
                public void run() {
                    if (BizWebView.this.tt != null) {
                        BizWebView.this.tt.setWebViewClient(webViewClient);
                    }
                }
            });
        }
    }
}

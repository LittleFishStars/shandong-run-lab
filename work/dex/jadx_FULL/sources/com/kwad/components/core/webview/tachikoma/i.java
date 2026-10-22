package com.kwad.components.core.webview.tachikoma;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.alibaba.baichuan.trade.common.ut.UserTrackConstant;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.huachenjie.base.util.rich_text.RichTextUtils;
import com.huachenjie.common.constants.UserConstants;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.video.m;
import com.kwad.components.core.webview.jshandler.aa;
import com.kwad.components.core.webview.jshandler.ab;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.ar;
import com.kwad.components.core.webview.jshandler.aw;
import com.kwad.components.core.webview.jshandler.ay;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.components.core.webview.jshandler.bd;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.b.v;
import com.kwad.components.core.webview.tachikoma.b.x;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.c.z;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TKDownloadListener;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.components.offline.api.tk.model.report.TKPerformMsg;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.components.l;
import com.kwad.sdk.components.n;
import com.kwad.sdk.components.o;
import com.kwad.sdk.components.q;
import com.kwad.sdk.components.r;
import com.kwad.sdk.components.s;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.export.proxy.AdHttpBodyBuilder;
import com.kwad.sdk.export.proxy.AdHttpFormDataBuilder;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bf;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import com.kwad.sdk.utils.y;
import com.zj.adlib.u15;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class i implements com.kwad.components.core.e.e.f, q, com.kwad.sdk.core.view.c, com.kwad.sdk.core.webview.d.a.a {
    private static Map<Integer, WeakReference<com.kwad.components.core.webview.tachikoma.d.e>> asQ = new HashMap();
    private final z AN;
    protected long Cj;
    private long Kk;
    private StyleTemplate akN;
    private long alK;
    private long alL;
    private aw aoB;
    private com.kwad.sdk.core.download.d aoC;
    private com.kwad.components.core.offline.a.f.c asA;
    private Future<?> asB;
    private t asC;
    private p asD;
    private ay asE;
    private bc asF;
    private com.kwad.sdk.core.view.e asG;
    private TextView asH;
    private boolean asI;
    private boolean asJ;
    private boolean asK;
    private boolean asL;
    private boolean asM;
    private int asN;
    private long asO;
    private Map<String, Object> asP;
    private int asR;
    private int asS;
    private boolean asT;
    private String asU;
    private String asV;
    private boolean asW;
    protected com.kwad.sdk.core.webview.e asX;
    private o asY;
    private int asZ;

    @Nullable
    private WeakReference<Activity> asw;
    private com.kwad.components.core.webview.tachikoma.d.e asx;
    protected j asy;
    private com.kwad.sdk.core.webview.c.g asz;
    private long ata;
    private long atb;
    private long atc;
    private long atd;
    private long ate;
    private com.kwad.components.core.webview.tachikoma.a.e atf;
    private KsAdWebView.b atg;
    private a ath;
    private r ati;
    private com.kwad.sdk.components.k atj;
    private final Runnable atk;
    private final Runnable atl;
    private az fk;
    private final m kf;

    @NonNull
    private AdResultData mAdResultData;
    protected final Context mContext;

    public interface a {
        void onFailed();

        void onSuccess();
    }

    public i(Context context) {
        this(context, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bK(String str) {
        c(TKRenderFailReason.TK_FILE_LOAD_ERROR);
        bM(str);
    }

    private static StyleTemplate bL(String str) {
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return null;
    }

    private void bM(String str) {
        f(this.asy.getTkTemplateId(), str);
        StyleTemplate styleTemplateYZ = yZ();
        if (styleTemplateYZ == null) {
            return;
        }
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.asN).setRenderState(4).setErrorReason(str).setTemplateId(this.asy.getTkTemplateId()).setVersionCode(String.valueOf(styleTemplateYZ.templateVersionCode)).setTKPublishType(zc()).setRenderType(zg()).setRenderIdleTime(zh()).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN(String str) {
        com.kwad.sdk.core.d.c.d("TKLoadController", "logTkRenderFail : " + str + ", templateId = " + this.asy.getTkTemplateId());
        g(this.asy.getTkTemplateId(), str);
        if (!this.asK || this.asL) {
            return;
        }
        this.asL = true;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.asN).setRenderState(2).setErrorReason(str).setTemplateId(this.asy.getTkTemplateId()).setVersionCode(String.valueOf(this.akN.templateVersionCode)).setTKPublishType(zc()).setRenderType(zg()).setRenderIdleTime(zh()).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.sdk.components.j bj(final AdTemplate adTemplate) {
        final com.kwad.components.core.e.d.d dVar = new com.kwad.components.core.e.d.d(adTemplate);
        dVar.qs();
        return new com.kwad.sdk.components.j() { // from class: com.kwad.components.core.webview.tachikoma.i.6
            @Override // com.kwad.sdk.components.j
            public final void a(final com.kwad.sdk.components.i iVar) {
                dVar.b(new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.core.webview.tachikoma.i.6.1
                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadFailed() {
                        iVar.onDownloadFailed();
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadFinished() {
                        iVar.onDownloadFinished();
                    }

                    @Override // com.kwad.sdk.core.download.a.a, com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadStarted() {
                        iVar.onDownloadStarted();
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onIdle() {
                        iVar.onIdle();
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onInstalled() {
                        iVar.onInstalled();
                    }

                    @Override // com.kwad.sdk.core.download.a.a
                    public final void onPaused(int i) {
                        long j;
                        long j2;
                        AdTemplate adTemplate2 = i.this.asX.getAdTemplate();
                        if (adTemplate2 != null) {
                            j = com.kwad.sdk.core.response.helper.e.eO(adTemplate2).totalBytes;
                            j2 = com.kwad.sdk.core.response.helper.e.eO(adTemplate2).soFarBytes;
                        } else {
                            j = 0;
                            j2 = 0;
                        }
                        iVar.onPaused(i, j, j2);
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onProgressUpdate(int i) {
                        long j;
                        long j2;
                        AdTemplate adTemplate2 = i.this.asX.getAdTemplate();
                        if (adTemplate2 != null) {
                            j = com.kwad.sdk.core.response.helper.e.eO(adTemplate2).totalBytes;
                            j2 = com.kwad.sdk.core.response.helper.e.eO(adTemplate2).soFarBytes;
                        } else {
                            j = 0;
                            j2 = 0;
                        }
                        iVar.onProgressUpdate(i, j, j2);
                    }
                });
            }

            @Override // com.kwad.sdk.components.j
            public final void cancelDownload() {
                com.kwad.sdk.core.download.a.ew(com.kwad.sdk.core.response.helper.e.eR(adTemplate));
            }

            @Override // com.kwad.sdk.components.j
            public final void installApp() {
                dVar.qx();
            }

            @Override // com.kwad.sdk.components.j
            public final void openApp() {
                dVar.qv();
            }

            @Override // com.kwad.sdk.components.j
            public final void pauseDownload() {
                dVar.qz();
            }

            @Override // com.kwad.sdk.components.j
            public final void resumeDownload() {
                dVar.qA();
            }

            @Override // com.kwad.sdk.components.j
            public final void setCustomReportParam(String str) {
                try {
                    dVar.e(new JSONObject(str));
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }

            @Override // com.kwad.sdk.components.j
            public final void startDownload() {
                dVar.qy();
            }

            @Override // com.kwad.sdk.components.j
            public final void stopDownload() {
                dVar.qz();
            }
        };
    }

    private static boolean isLocalDebugEnable() {
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity yN() {
        WeakReference<Activity> weakReference = this.asw;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.asw.get();
    }

    private void yO() {
        StyleTemplate styleTemplateYZ = yZ();
        if (styleTemplateYZ == null) {
            bK("no template");
            return;
        }
        int iB = b(styleTemplateYZ);
        this.asZ = iB;
        try {
            t tVarA = com.kwad.components.core.t.k.a(Integer.valueOf(iB));
            if (tVarA != null) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.asO = jElapsedRealtime;
                this.atd = jElapsedRealtime;
                a(tVarA);
                return;
            }
            if (com.kwad.components.core.webview.tachikoma.e.b.zE().cm(this.asZ)) {
                yX();
            } else {
                this.ata = SystemClock.elapsedRealtime();
                com.kwad.components.core.webview.tachikoma.e.b.zE().a(this.asZ, new com.kwad.components.core.webview.tachikoma.f.f() { // from class: com.kwad.components.core.webview.tachikoma.i.12
                    @Override // com.kwad.components.core.webview.tachikoma.f.f
                    public final void zo() {
                        i.this.d(TKRenderFailReason.RENDER_ERROR);
                        i.this.bN(TKPerformMsg.ERROR_REASON.KSAD_TK_RENDER_FAIL);
                    }

                    @Override // com.kwad.components.core.webview.tachikoma.f.f
                    public final void zp() {
                        com.kwad.components.core.t.k.a aVarB = com.kwad.components.core.t.k.b(Integer.valueOf(i.this.asZ));
                        t tVarWR = aVarB.wR();
                        i.this.alK = aVarB.wN();
                        i.this.alL = aVarB.wP();
                        i.this.Kk = aVarB.wO();
                        i.this.atb = aVarB.wQ();
                        i.this.asO = SystemClock.elapsedRealtime();
                        i iVar = i.this;
                        iVar.atd = iVar.asO;
                        i.this.yP();
                        i.this.a(tVarWR);
                    }
                });
            }
        } catch (Exception e) {
            c(TKRenderFailReason.RENDER_ERROR);
            bN(e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yP() {
        long j = this.ata;
        long j2 = this.atb;
        if (j >= j2) {
            this.alK = 0L;
            this.alL = 0L;
            this.Kk = 0L;
            this.atc = 0L;
            return;
        }
        long j3 = this.alL;
        long j4 = this.alK;
        if (j >= j3 + j4) {
            this.alK = 0L;
            this.alL = 0L;
            this.Kk = 0L;
            this.atc = j2 - j;
            this.asO = j2;
            return;
        }
        if (j3 >= j && j >= this.Kk) {
            this.Kk = j;
        } else if (j3 + j4 > j) {
            this.alK = (j3 + j4) - this.Kk;
            this.alL = 0L;
            this.Kk = 0L;
        }
    }

    private static String yQ() {
        ai.a aVar = new ai.a();
        aVar.screenOrientation = !as.isOrientationPortrait() ? 1 : 0;
        return aVar.toJson().toString();
    }

    private String yR() {
        ae.a aVar = new ae.a();
        j jVar = this.asy;
        if (jVar != null) {
            jVar.a(aVar);
        } else {
            aVar.width = this.asX.adW.getWidth();
            aVar.height = this.asX.adW.getHeight();
        }
        return aVar.toJson().toString();
    }

    private void yS() {
        za();
        this.asy.aG();
        yT();
        a("setCloseAction", (String) null, new com.kwad.components.core.webview.tachikoma.a.b() { // from class: com.kwad.components.core.webview.tachikoma.i.23
            @Override // com.kwad.components.core.webview.tachikoma.a.b
            public final void c(WebCloseStatus webCloseStatus) {
                j jVar = i.this.asy;
                if (jVar != null) {
                    jVar.a(webCloseStatus);
                }
            }
        });
        a("setAdOutClickCallback", (String) null, new com.kwad.components.core.webview.tachikoma.a.c() { // from class: com.kwad.components.core.webview.tachikoma.i.34
            @Override // com.kwad.components.core.webview.tachikoma.a.c
            public final void b(com.kwad.components.core.webview.jshandler.a.C1235a c1235a) {
                j jVar = i.this.asy;
                if (jVar != null) {
                    jVar.a(c1235a);
                }
            }
        });
        a("setUpdatePositionCallback", (String) null, new com.kwad.components.core.webview.tachikoma.a.f() { // from class: com.kwad.components.core.webview.tachikoma.i.43
            @Override // com.kwad.components.core.webview.tachikoma.a.f
            public final void a(al.a aVar) {
                i.this.b(aVar);
            }
        });
        a("setCancelDownloadCallback", (String) null, new com.kwad.components.core.webview.tachikoma.a.d() { // from class: com.kwad.components.core.webview.tachikoma.i.44
            @Override // com.kwad.components.core.webview.tachikoma.a.d
            public final AdTemplate zq() {
                return i.this.zb();
            }
        });
    }

    private void yT() {
        com.kwad.components.core.e.d.d dVar = zb() != null ? new com.kwad.components.core.e.d.d(zb()) : null;
        this.atf = new com.kwad.components.core.webview.tachikoma.a.e(dVar, this.asX, this.asY);
        a("setClickAction", (String) null, new com.kwad.components.core.webview.tachikoma.a.a(yM(), dVar, this, true));
    }

    private boolean yU() {
        try {
            boolean z = (this.asV.equals("tk_feed_tk_card") && com.kwad.sdk.core.config.e.KI()) || this.asV.equals("tk_draw_card");
            this.asW = z;
            return z;
        } catch (Exception unused) {
            return false;
        }
    }

    private void yW() {
        this.asK = false;
        this.asL = false;
        this.asI = false;
        this.asJ = false;
        this.asM = false;
        this.Kk = 0L;
        this.alL = 0L;
        this.alK = 0L;
        this.asO = 0L;
    }

    private void yX() {
        if (isLocalDebugEnable()) {
            this.asR = 2000;
            this.asS = 3000;
        }
        by.runOnUiThreadDelay(this.atk, this.asR);
        int i = this.asS;
        if (i > 0) {
            by.runOnUiThreadDelay(this.atl, i);
        }
        this.asB = GlobalThreadPools.Od().submit(new bi() { // from class: com.kwad.components.core.webview.tachikoma.i.45
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                i.this.Kk = SystemClock.elapsedRealtime();
                com.kwad.sdk.core.d.c.d("TKLoadController", "开始读取模板 id: " + i.this.asy.getTkTemplateId());
                i.this.a(new TKDownloadListener() { // from class: com.kwad.components.core.webview.tachikoma.i.45.1
                    @Override // com.kwad.components.offline.api.tk.TKDownloadListener
                    public final void onFailed(String str) {
                        i.this.bK(str);
                    }

                    @Override // com.kwad.components.offline.api.tk.TKDownloadListener
                    public final void onSuccess(@NonNull StyleTemplate styleTemplate) {
                        i.this.c(styleTemplate);
                    }
                });
            }
        });
    }

    private static boolean yY() {
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return false;
    }

    private StyleTemplate yZ() {
        AdMatrixInfo.MatrixTemplate matrixTemplateT;
        String tkTemplateId = this.asy.getTkTemplateId();
        StyleTemplate styleTemplate = this.akN;
        if (styleTemplate != null) {
            tkTemplateId = styleTemplate.templateId;
        }
        StyleTemplate styleTemplateBL = bL(tkTemplateId);
        if (styleTemplateBL != null) {
            return styleTemplateBL;
        }
        if (!isLocalDebugEnable()) {
            StyleTemplate styleTemplate2 = this.akN;
            if (styleTemplate2 != null) {
                return styleTemplate2;
            }
            AdTemplate adTemplateZb = zb();
            if (adTemplateZb == null || (matrixTemplateT = com.kwad.sdk.core.response.helper.b.t(adTemplateZb, this.asy.getTkTemplateId())) == null) {
                return null;
            }
            com.kwad.components.core.offline.a.f.c cVar = this.asA;
            if (cVar != null) {
                return cVar.checkStyleTemplateById(this.mContext, matrixTemplateT.templateId, matrixTemplateT.templateMd5, matrixTemplateT.templateUrl, (int) matrixTemplateT.templateVersionCode);
            }
            StyleTemplate styleTemplate3 = new StyleTemplate();
            styleTemplate3.templateId = matrixTemplateT.templateId;
            styleTemplate3.templateMd5 = matrixTemplateT.templateMd5;
            styleTemplate3.templateUrl = matrixTemplateT.templateUrl;
            styleTemplate3.templateVersionCode = (int) matrixTemplateT.templateVersionCode;
            styleTemplate3.tkSouce = 0;
            return styleTemplate3;
        }
        StyleTemplate styleTemplate4 = new StyleTemplate();
        styleTemplate4.templateId = tkTemplateId;
        styleTemplate4.templateVersion = "1.0.4";
        styleTemplate4.templateVersionCode = 104;
        if (yY()) {
            styleTemplate4.templateUrl = "http://" + OfflineHostProvider.getApi().env().localIpAddress() + ":24680/" + tkTemplateId + ".104.coverage.zip";
        } else {
            styleTemplate4.templateUrl = "http://" + OfflineHostProvider.getApi().env().localIpAddress() + ":24680/" + tkTemplateId + ".104.zip";
        }
        return styleTemplate4;
    }

    private void za() {
        this.asX.a(!as.VM() ? 1 : 0, this.asy.getTouchCoordsView(), this.asy.getTKContainer(), this.asy.getTkTemplateId());
    }

    private int zc() {
        String tkTemplateId = this.asy.getTkTemplateId();
        int i = yZ() != null ? yZ().templateVersionCode : 0;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(tkTemplateId);
        stringBuffer.append("#");
        stringBuffer.append(i);
        return com.kwad.sdk.core.config.e.cR(stringBuffer.toString());
    }

    private void zd() {
        StyleTemplate styleTemplateYZ = yZ();
        if (styleTemplateYZ == null) {
            return;
        }
        this.asN = styleTemplateYZ.tkSouce;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.asN).setRenderState(-1).setTemplateId(this.asy.getTkTemplateId()).setVersionCode(String.valueOf(styleTemplateYZ.templateVersionCode)).setTKPublishType(zc()).setRenderType(zg()).setRenderIdleTime(zh()).toJson());
    }

    private void ze() {
        if (this.asK) {
            return;
        }
        this.asK = true;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.asN).setRenderState(0).setTemplateId(this.asy.getTkTemplateId()).setVersionCode(String.valueOf(this.akN.templateVersionCode)).setTKPublishType(zc()).setRenderType(zg()).setRenderIdleTime(zh()).toJson());
    }

    private void zf() {
        StringBuilder sb = new StringBuilder("logTkRenderSuccess, templateId = ");
        sb.append(this.asy.getTkTemplateId());
        sb.append(u15.f19942b);
        StyleTemplate styleTemplate = this.akN;
        sb.append(styleTemplate != null ? styleTemplate.templateVersionCode : 0);
        com.kwad.sdk.core.d.c.d("TKLoadController", sb.toString());
        if (!this.asK || this.asL) {
            return;
        }
        this.asL = true;
        long jElapsedRealtime = this.asO > 0 ? SystemClock.elapsedRealtime() - this.asO : 0L;
        com.kwad.sdk.core.d.c.d("TKLoadController", "render time, templateId = " + this.asy.getTkTemplateId() + " init:" + this.alK + " load:" + (this.alL - this.Kk) + " render:" + jElapsedRealtime);
        if (this.asW) {
            this.ate = SystemClock.elapsedRealtime() - this.atd;
        }
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.asN).setRenderState(1).setRenderTime(jElapsedRealtime).setTemplateId(this.asy.getTkTemplateId()).setLoadTime(this.alL - this.Kk).setInitTime(this.alK).setRegisterEndTime(this.atc).setGetViewEndTime(this.ate).setTemplateId(this.asy.getTkTemplateId()).setVersionCode(String.valueOf(this.akN.templateVersionCode)).setTKPublishType(zc()).setRenderType(zg()).setRenderIdleTime(zh()).toJson());
    }

    private int zg() {
        return this.asW ? 1 : 0;
    }

    private long zh() {
        if (zg() == 1) {
            return com.kwad.sdk.core.config.e.KJ().longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zi() {
        com.kwad.sdk.core.d.c.d("TKLoadController", "logTkRenderFail : timeout, templateId = " + this.asy.getTkTemplateId());
        StyleTemplate styleTemplateYZ = yZ();
        if (styleTemplateYZ == null) {
            return;
        }
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.asN).setRenderState(3).setErrorReason(com.alipay.sdk.m.o.b.r0).setTemplateId(this.asy.getTkTemplateId()).setVersionCode(String.valueOf(styleTemplateYZ.templateVersionCode)).setTKPublishType(zc()).setRenderType(zg()).setRenderIdleTime(zh()).toJson());
    }

    private Map<String, Object> zj() {
        if (this.asP == null) {
            HashMap map = new HashMap();
            this.asP = map;
            map.put("TKVersion", "6.2.3");
            this.asP.put("SDKVersion", BuildConfig.VERSION_NAME);
            this.asP.put(UserTrackConstant.SDK_TYPE, 1);
        }
        return this.asP;
    }

    private void zk() {
        if (this.asA == null || this.asC == null) {
            return;
        }
        File file = new File(new File(this.asA.getJsBaseDir(this.mContext, this.asy.getTkTemplateId())), "kcov.json");
        if (file.exists()) {
            try {
                String strY = y.Y(file);
                if (TextUtils.isEmpty(strY)) {
                    return;
                }
                com.kwad.sdk.core.d.c.d("TKLoadController", "kcov.json:" + strY);
                JSONObject jSONObject = new JSONObject(strY);
                final String string = jSONObject.getString("gitHeadCommit");
                final String string2 = jSONObject.getString("coverageApi");
                final String string3 = jSONObject.getString("coverageTaskId");
                final String string4 = jSONObject.getString("currentBranch");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string4)) {
                    StringBuilder sb = new StringBuilder("尝试获取覆盖率统计... ");
                    sb.append(this.akN);
                    com.kwad.sdk.core.d.c.d("TKLoadController", sb.toString() != null ? this.akN.templateId : "");
                    Object objExecute = this.asC.execute("JSON.stringify(this.__coverage__)");
                    if (objExecute instanceof String) {
                        final String str = (String) objExecute;
                        com.kwad.sdk.utils.i.execute(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.41
                            @Override // java.lang.Runnable
                            public final void run() {
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("coverage_task_id", Integer.valueOf(string3));
                                    jSONObject2.put(RichTextUtils.USER_SCHEME, "");
                                    jSONObject2.put("timestamp", System.currentTimeMillis() / 1000);
                                    jSONObject2.put("branch_name", string4);
                                    jSONObject2.put("version", BuildConfig.VERSION_NAME);
                                    jSONObject2.put("tk_version", String.valueOf(i.this.akN.templateVersionCode));
                                    jSONObject2.put("tk_template_ids", i.this.akN.templateId);
                                } catch (JSONException e) {
                                    com.kwad.sdk.core.d.c.printStackTrace(e);
                                }
                                com.kwad.sdk.core.network.c cVarDoPost = com.kwad.sdk.h.EG().doPost(string2 + "/analysis/add/pkg/info", (Map<String, String>) null, jSONObject2);
                                if (cVarDoPost.Mf()) {
                                    com.kwad.sdk.core.d.c.d("TKLoadController", "上传TK覆盖率pkg完成:" + cVarDoPost.aSY);
                                } else {
                                    com.kwad.sdk.core.d.c.d("TKLoadController", "上传覆盖率pkg失败");
                                }
                                com.kwad.sdk.core.network.c cVarDoPost2 = com.kwad.sdk.h.EG().doPost(string2 + "/attachment/ec", (Map<String, String>) null, new AdHttpBodyBuilder() { // from class: com.kwad.components.core.webview.tachikoma.i.41.1
                                    @Override // com.kwad.sdk.export.proxy.AdHttpBodyBuilder
                                    public final void buildFormData(AdHttpFormDataBuilder adHttpFormDataBuilder) {
                                        adHttpFormDataBuilder.addFormDataPart("task_id", string3);
                                        adHttpFormDataBuilder.addFormDataPart("os_build_model", Build.MODEL);
                                        adHttpFormDataBuilder.addFormDataPart("os_build_serial", "unknown");
                                        adHttpFormDataBuilder.addFormDataPart("os_build_brand", Build.BRAND);
                                        adHttpFormDataBuilder.addFormDataPart(AlibcCommonConstant.APP_VERSION, BuildConfig.VERSION_NAME);
                                        adHttpFormDataBuilder.addFormDataPart("git_head_commit", string);
                                        adHttpFormDataBuilder.addFormDataPart("execute_type", "manual_qa");
                                        adHttpFormDataBuilder.addFormDataPart(UserConstants.URL_PARAMS.b, "");
                                        adHttpFormDataBuilder.addFormDataPart("did", bf.getDeviceId());
                                        adHttpFormDataBuilder.addFormDataPart("execute_user", "");
                                        adHttpFormDataBuilder.addFormDataPart("url_type", "transform");
                                        try {
                                            adHttpFormDataBuilder.addFormDataPart("file", UUID.randomUUID().toString() + ".json", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE, str.getBytes("UTF-8"));
                                        } catch (UnsupportedEncodingException e2) {
                                            com.kwad.sdk.core.d.c.printStackTrace(e2);
                                        }
                                    }
                                });
                                if (!cVarDoPost2.Mf()) {
                                    com.kwad.sdk.core.d.c.d("TKLoadController", "上传TK覆盖率失败");
                                    return;
                                }
                                com.kwad.sdk.core.d.c.d("TKLoadController", "上传TK覆盖率完成:" + cVarDoPost2.aSY);
                            }
                        });
                        return;
                    }
                    return;
                }
                com.kwad.sdk.core.d.c.d("TKLoadController", "kcov.json数据不合法，缺少关键字段gitHeadCommit | coverageApi | coverageTaskId | currentBranch");
            } catch (Throwable th) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th);
            }
        }
    }

    public void a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.d dVar, t tVar, ViewGroup viewGroup) {
    }

    @Override // com.kwad.sdk.components.q
    public final void callJS(String str) {
        t tVar = this.asC;
        if (tVar != null) {
            tVar.a(str, null, null);
        }
    }

    @Override // com.kwad.components.core.e.e.f
    public void dismiss() {
        az azVar = this.fk;
        if (azVar != null) {
            azVar.yB();
        }
    }

    public void f(String str, String str2) {
    }

    public void g(String str, String str2) {
    }

    public final String getTkTemplateId() {
        j jVar = this.asy;
        if (jVar == null) {
            return null;
        }
        return jVar.getTkTemplateId();
    }

    public void kV() {
        if (this.asw != null) {
            this.asw = null;
        }
        com.kwad.sdk.core.view.e eVar = this.asG;
        if (eVar != null) {
            eVar.getWindowFocusChangeHelper().b(this);
            this.asG = null;
        }
        Future<?> future = this.asB;
        if (future != null) {
            future.cancel(true);
        }
        by.b(this.atk);
        by.b(this.atl);
        com.kwad.components.core.e.e.g.qK().b(this);
        if (this.aoC != null) {
            com.kwad.sdk.core.download.b.Lz().a(this.aoC);
        }
        com.kwad.components.core.webview.tachikoma.d.e eVar2 = this.asx;
        if (eVar2 != null) {
            eVar2.dismiss();
        }
        if (com.kwad.components.core.a.pe.booleanValue()) {
            zk();
        }
        com.kwad.components.core.offline.a.f.c cVar = this.asA;
        if (cVar != null) {
            cVar.onDestroy();
        }
        final t tVar = this.asC;
        if (tVar != null) {
            this.asC = null;
            if (this.asW) {
                com.kwad.components.core.t.k.c(Integer.valueOf(this.asZ));
            } else {
                by.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.40
                    @Override // java.lang.Runnable
                    public final void run() {
                        t tVar2 = tVar;
                        if (tVar2 != null) {
                            tVar2.onDestroy();
                        }
                    }
                });
            }
        }
    }

    public boolean pz() {
        return false;
    }

    @Override // com.kwad.components.core.e.e.f
    public void show() {
        az azVar = this.fk;
        if (azVar != null) {
            azVar.yC();
        }
    }

    public final com.kwad.sdk.core.webview.b yM() {
        return this.asX;
    }

    public final boolean yV() {
        return this.asW;
    }

    public final AdTemplate zb() {
        return this.asX.getAdTemplate();
    }

    public final o zl() {
        return this.asY;
    }

    public final void zm() {
        com.kwad.sdk.core.d.c.d("TKLoadController", "judgeTKRenderResult tkHasTimeout： " + this.asJ);
        if (this.asJ) {
            com.kwad.sdk.core.d.c.d("TKLoadController", "judgeTKRenderResult: " + this.asy.getTkTemplateId());
            c(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            return;
        }
        by.b(this.atl);
        zf();
        if (this.asy != null) {
            by.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.42
                @Override // java.lang.Runnable
                public final void run() {
                    i.this.asy.aE();
                }
            });
            com.kwad.components.core.webview.tachikoma.e.c.zG().c(this.asy.getTkTemplateId(), this.alL - this.Kk, this.alK, this.asO > 0 ? SystemClock.elapsedRealtime() - this.asO : 0L);
        }
    }

    public i(Context context, boolean z) {
        this.asI = false;
        this.asJ = false;
        this.asK = false;
        this.asL = false;
        this.asM = false;
        this.asN = 0;
        this.Cj = -1L;
        this.asR = 1000;
        this.asS = 0;
        this.asT = true;
        this.asX = new com.kwad.sdk.core.webview.e();
        this.atg = new KsAdWebView.b() { // from class: com.kwad.components.core.webview.tachikoma.i.1
            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                if (i.this.aoB != null) {
                    i.this.aoB.onFailed();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                if (i.this.aoB != null) {
                    i.this.aoB.onSuccess();
                }
            }
        };
        this.ath = new a() { // from class: com.kwad.components.core.webview.tachikoma.i.47
            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onFailed() {
                i.this.c(TKRenderFailReason.RENDER_ERROR);
                com.kwad.sdk.core.d.c.d("TKLoadController", "JS执行失败");
            }

            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onSuccess() {
                com.kwad.sdk.core.d.c.d("TKLoadController", "JS执行成功");
            }
        };
        this.ati = new r() { // from class: com.kwad.components.core.webview.tachikoma.i.4
            @Override // com.kwad.sdk.components.r
            public final void a(l lVar) {
                StyleTemplate styleTemplate;
                Activity activityYN = i.this.yN();
                if (activityYN == null) {
                    com.kwad.sdk.core.c.b.LW();
                    activityYN = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activityYN == null || activityYN.isFinishing()) {
                    lVar.callbackPageStatus(false, "no host activity");
                    return;
                }
                final String viewKey = lVar.getViewKey();
                if (viewKey == null) {
                    styleTemplate = new StyleTemplate();
                    try {
                        styleTemplate.parseJson(styleTemplate, new JSONObject(lVar.getStyleTemplate()));
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.c.printStackTrace(th);
                        lVar.callbackPageStatus(false, "template parse failed");
                        return;
                    }
                } else {
                    styleTemplate = null;
                }
                com.kwad.components.core.webview.tachikoma.d.e.b bVar = new com.kwad.components.core.webview.tachikoma.d.e.b();
                bVar.a(i.this.mAdResultData);
                bVar.c(lVar);
                if (styleTemplate != null) {
                    bVar.a(styleTemplate);
                }
                if (viewKey != null) {
                    bVar.a(new k() { // from class: com.kwad.components.core.webview.tachikoma.i.4.1
                        @Override // com.kwad.components.core.webview.tachikoma.k
                        public final o a(Object... objArr) {
                            if (i.this.asC != null) {
                                return i.this.asC.a(viewKey, objArr);
                            }
                            return null;
                        }
                    });
                }
                com.kwad.components.core.webview.tachikoma.d.e eVarB = com.kwad.components.core.webview.tachikoma.d.e.b(bVar);
                eVarB.show(activityYN.getFragmentManager(), "");
                i.asQ.put(Integer.valueOf(lVar.getDialogId()), new WeakReference(eVarB));
            }

            @Override // com.kwad.sdk.components.r
            public final void b(l lVar) {
                WeakReference weakReference = (WeakReference) i.asQ.get(Integer.valueOf(lVar.getDialogId()));
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                ((com.kwad.components.core.webview.tachikoma.d.e) weakReference.get()).dismiss();
            }

            /* JADX WARN: Code duplicated, block: B:6:0x0011  */
            @Override // com.kwad.sdk.components.r
            public final void a(n nVar) {
                Activity activityYN = i.this.yN();
                if (activityYN != null) {
                    com.kwad.sdk.core.c.b.LW();
                    if (activityYN != com.kwad.sdk.core.c.b.getCurrentActivity()) {
                        com.kwad.sdk.core.c.b.LW();
                        activityYN = com.kwad.sdk.core.c.b.getCurrentActivity();
                    }
                } else {
                    com.kwad.sdk.core.c.b.LW();
                    activityYN = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activityYN == null) {
                    nVar.callbackPageStatus(false, "no host activity");
                    return;
                }
                Intent intent = nVar.getIntent();
                if (TextUtils.isEmpty(nVar.getTemplateString()) && TextUtils.isEmpty(nVar.getViewKey())) {
                    if (!TextUtils.isEmpty(nVar.getClassName())) {
                        try {
                            com.kwad.sdk.service.c.putComponentProxy(FeedDownloadActivity.class, Class.forName(nVar.getClassName()));
                            intent.setClass(i.this.mContext, FeedDownloadActivity.class);
                        } catch (ClassNotFoundException e) {
                            nVar.callbackPageStatus(false, e.getMessage());
                            return;
                        }
                    }
                } else {
                    com.kwad.sdk.service.c.putComponentProxy(FeedDownloadActivity.class, com.kwad.components.core.s.a.a.class);
                    int iWw = com.kwad.components.core.s.a.a.ww();
                    com.kwad.components.core.s.a.a.a(iWw, "native_intent", nVar);
                    if (i.this.mAdResultData != null) {
                        intent.putExtra("ad_result_cache_idx", com.kwad.components.core.c.f.oU().l(i.this.mAdResultData));
                    }
                    if (!TextUtils.isEmpty(nVar.getTemplateString())) {
                        intent.putExtra("tk_style_template", nVar.getTemplateString());
                    } else {
                        final String viewKey = nVar.getViewKey();
                        com.kwad.components.core.s.a.a.a(iWw, "tk_view_holder", new k() { // from class: com.kwad.components.core.webview.tachikoma.i.4.2
                            @Override // com.kwad.components.core.webview.tachikoma.k
                            public final o a(Object... objArr) {
                                if (i.this.asC != null) {
                                    return i.this.asC.a(viewKey, objArr);
                                }
                                return null;
                            }
                        });
                    }
                    intent.putExtra("tk_id", iWw);
                    intent.setClass(i.this.mContext, FeedDownloadActivity.class);
                }
                if (!TextUtils.isEmpty(nVar.getUrl())) {
                    intent.setData(Uri.parse(nVar.getUrl()));
                    int intExtra = intent.getIntExtra("adCacheId", 0);
                    if (intExtra > 0) {
                        com.kwad.components.core.proxy.launchdialog.e.vJ().ba(com.kwad.sdk.core.response.helper.c.r(com.kwad.components.core.offline.a.f.a.a.bp(intExtra)));
                    }
                }
                try {
                    activityYN.startActivity(intent);
                    nVar.callbackPageStatus(true, null);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                    nVar.callbackPageStatus(false, th.getMessage());
                }
            }
        };
        this.atj = new com.kwad.sdk.components.k() { // from class: com.kwad.components.core.webview.tachikoma.i.5
            @Override // com.kwad.sdk.components.k
            public final com.kwad.sdk.components.j bO(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    AdTemplate adTemplate = new AdTemplate();
                    adTemplate.parseJson(jSONObject);
                    return i.this.bj(adTemplate);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                    return null;
                }
            }

            @Override // com.kwad.sdk.components.k
            public final com.kwad.sdk.components.j ch(int i) {
                return i.this.bj(com.kwad.sdk.core.response.helper.c.r(com.kwad.components.core.offline.a.f.a.a.bp(i)));
            }
        };
        this.atk = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.7
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.c.d("TKLoadController", "mDownloadTimeoutRunnable 已经超时" + i.this.asy.getTkTemplateId());
                i.this.zi();
                i.a(i.this, true);
                i.this.c(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.atl = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.8
            @Override // java.lang.Runnable
            public final void run() {
                i.b(i.this, true);
                com.kwad.sdk.core.d.c.d("TKLoadController", "mTKLoadTotalTimeoutRunnable run: " + i.this.asy.getTkTemplateId());
                i.this.c(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.kf = new m() { // from class: com.kwad.components.core.webview.tachikoma.i.39
            private void e(double d) {
                i.this.AN.auB = false;
                i.this.AN.ajf = false;
                i.this.AN.rq = (int) ((d / 1000.0d) + 0.5d);
                kq();
            }

            private void kq() {
                if (i.this.asD == null || i.this.AN == null) {
                    return;
                }
                i.this.asD.a(i.this.AN);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                i.this.AN.ajf = true;
                i.this.AN.auB = false;
                i.this.AN.rq = com.kwad.sdk.core.response.helper.a.N(com.kwad.sdk.core.response.helper.e.eO(i.this.zb()));
                kq();
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayError(int i, int i2) {
                i.this.AN.auB = true;
                i.this.AN.ajf = false;
                kq();
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayProgress(long j, long j2) {
                e(j2);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                e(AudioStats.AUDIO_AMPLITUDE_NONE);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPreparing() {
                e(AudioStats.AUDIO_AMPLITUDE_NONE);
            }
        };
        this.mContext = context;
        this.Cj = -1L;
        this.asR = 1000;
        this.asT = z;
        this.AN = new z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Throwable th) {
        com.kwad.sdk.core.d.c.d("TKLoadController", "logTkRenderFail : " + th + ", templateId = " + this.asy.getTkTemplateId());
        String tkTemplateId = this.asy.getTkTemplateId();
        StringBuilder sb = new StringBuilder("error:");
        sb.append(th.toString());
        g(tkTemplateId, sb.toString());
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.asN).setRenderState(3).setErrorReason(th.toString()).setTemplateId(this.asy.getTkTemplateId()).setVersionCode(String.valueOf(this.akN.templateVersionCode)).setTKPublishType(zc()).setRenderType(zg()).setRenderIdleTime(zh()).toJson());
    }

    @Override // com.kwad.sdk.core.view.c
    public final void i(View view, boolean z) {
        ay ayVar;
        FrameLayout tKContainer = this.asy.getTKContainer();
        if (tKContainer == null || !tKContainer.equals(view) || (ayVar = this.asE) == null) {
            return;
        }
        ayVar.bl(z);
    }

    public static /* synthetic */ boolean c(i iVar, boolean z) {
        iVar.asM = true;
        return true;
    }

    private void d(StyleTemplate styleTemplate) {
        if (com.kwad.components.core.a.pe.booleanValue() && this.asy.getTKContainer() != null) {
            if (this.asH == null) {
                TextView textView = new TextView(this.mContext);
                this.asH = textView;
                textView.setTextSize(12.0f);
                this.asH.setTextColor(-65536);
                this.asy.getTKContainer().addView(this.asH);
            }
            this.asH.setText(styleTemplate.templateId + " " + styleTemplate.templateVersionCode);
            this.asH.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final StyleTemplate styleTemplate) {
        com.kwad.sdk.utils.l.b("", "renderType_tk", styleTemplate.templateId, styleTemplate.templateUrl);
        com.kwad.sdk.core.d.c.d("TKLoadController", "读取完毕，总耗时" + (SystemClock.elapsedRealtime() - this.Kk) + ", 读取成功" + styleTemplate.templateId);
        if (this.asI) {
            return;
        }
        com.kwad.sdk.core.d.c.d("TKLoadController", "没有超时");
        by.b(this.atk);
        by.runOnUiThread(new bi() { // from class: com.kwad.components.core.webview.tachikoma.i.46
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                i iVar = i.this;
                iVar.a(styleTemplate, iVar.ath);
            }
        });
        ViewParent tKContainer = this.asy.getTKContainer();
        if (tKContainer instanceof com.kwad.sdk.core.view.e) {
            com.kwad.sdk.core.view.e eVar = (com.kwad.sdk.core.view.e) tKContainer;
            this.asG = eVar;
            eVar.getWindowFocusChangeHelper().a(this);
        }
    }

    public static /* synthetic */ boolean b(i iVar, boolean z) {
        iVar.asJ = true;
        return true;
    }

    private static int b(StyleTemplate styleTemplate) {
        if (styleTemplate == null) {
            return 0;
        }
        return (styleTemplate.templateId + " " + styleTemplate.templateVersionCode).hashCode();
    }

    private void b(StyleTemplate styleTemplate, final a aVar) {
        com.kwad.sdk.core.d.c.w("TKLoadController", "registerTKViewNew start center1: ");
        ze();
        this.alL = SystemClock.elapsedRealtime();
        t tVarA = this.asA.a(this.mContext, styleTemplate.templateId, styleTemplate.templateVersionCode, styleTemplate.tkSouce, this.asT);
        com.kwad.components.core.offline.a.f.a.a.a(this.mAdResultData.hashCode(), this.mAdResultData);
        tVarA.a(this.ati);
        tVarA.a(this.atj);
        if (this.akN != null) {
            zj().put("styleTemplate", this.akN.toJson().toString());
        }
        zj().put("appId", ServiceProvider.getAppId());
        zj().put("isDebug", com.kwad.components.core.a.pe);
        zj().put("newRenderType", Boolean.valueOf(this.asW));
        tVarA.setCustomEnv(zj());
        this.asC = tVarA;
        com.kwad.sdk.core.d.c.w("TKLoadController", "registerTKViewNew center1: ");
        com.kwad.sdk.core.c.b.LW();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        if (currentActivity != null) {
            ViewGroup viewGroup = (ViewGroup) currentActivity.getWindow().getDecorView();
            zj().put("isImmersiveMode", Boolean.valueOf(com.kwad.sdk.c.a.a.J(viewGroup) && com.kwad.sdk.c.a.a.bA(currentActivity) == viewGroup.getHeight()));
        }
        tVarA.setCustomEnv(zj());
        com.kwad.sdk.core.webview.c.g gVar = this.asz;
        if (gVar != null) {
            tVarA.b(gVar);
        }
        this.alK = SystemClock.elapsedRealtime() - this.alL;
        this.asO = SystemClock.elapsedRealtime();
        c(tVarA);
        File file = new File(this.asA.getJsBaseDir(this.mContext, this.asy.getTkTemplateId()));
        tVarA.a(styleTemplate.jsStr, file.getAbsolutePath() + WVNativeCallbackUtil.SEPERATER, new s() { // from class: com.kwad.components.core.webview.tachikoma.i.2
            @Override // com.kwad.sdk.components.s
            public final void onFailed(Throwable th) {
                com.kwad.sdk.core.d.c.w("TKLoadController", "registerTKViewNew onFailed: " + th.getMessage());
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onFailed();
                }
                i.this.m(th);
            }

            @Override // com.kwad.sdk.components.s
            public final void onSuccess() {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onSuccess();
                }
            }
        });
        com.kwad.sdk.core.d.c.w("TKLoadController", "registerTKViewNew end: ");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final TKRenderFailReason tKRenderFailReason) {
        by.postOnUiThread(new bi() { // from class: com.kwad.components.core.webview.tachikoma.i.10
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                if (i.this.asM) {
                    return;
                }
                i.c(i.this, true);
                i.this.asy.a(tKRenderFailReason);
                com.kwad.components.core.e.e.g.qK().b(i.this);
                com.kwad.components.core.webview.tachikoma.e.c.zG().x(i.this.asU, i.this.asV);
            }
        });
    }

    public static /* synthetic */ boolean a(i iVar, boolean z) {
        iVar.asI = true;
        return true;
    }

    private void c(StyleTemplate styleTemplate, final a aVar) {
        com.kwad.sdk.core.d.c.w("TKLoadController", "renderTKView start: ");
        ze();
        this.alL = SystemClock.elapsedRealtime();
        t tVarA = this.asA.a(this.mContext, styleTemplate.templateId, styleTemplate.templateVersionCode, styleTemplate.tkSouce, this.asT);
        com.kwad.components.core.offline.a.f.a.a.a(tVarA.getUniqId(), this.mAdResultData);
        tVarA.a(this.ati);
        tVarA.a(this.atj);
        AdResultData adResultData = this.mAdResultData;
        if (adResultData != null && com.kwad.sdk.core.response.helper.c.r(adResultData).mAdScene != null) {
            zj().put("adStyle", Integer.valueOf(com.kwad.sdk.core.response.helper.c.r(this.mAdResultData).mAdScene.getAdStyle()));
            zj().put("adScene", com.kwad.sdk.core.response.helper.c.r(this.mAdResultData).mAdScene.toJson().toString());
        }
        if (this.akN != null) {
            zj().put("styleTemplate", this.akN.toJson().toString());
        }
        zj().put("adCacheId", Integer.valueOf(tVarA.getUniqId()));
        zj().put("appId", ServiceProvider.getAppId());
        zj().put("isDebug", com.kwad.components.core.a.pe);
        zj().put("newRenderType", Boolean.valueOf(this.asW));
        tVarA.setCustomEnv(zj());
        this.asC = tVarA;
        com.kwad.sdk.core.c.b.LW();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        if (currentActivity != null) {
            ViewGroup viewGroup = (ViewGroup) currentActivity.getWindow().getDecorView();
            zj().put("isImmersiveMode", Boolean.valueOf(com.kwad.sdk.c.a.a.J(viewGroup) && com.kwad.sdk.c.a.a.bA(currentActivity) == viewGroup.getHeight()));
        }
        tVarA.setCustomEnv(zj());
        com.kwad.sdk.core.webview.c.g gVar = this.asz;
        if (gVar != null) {
            tVarA.b(gVar);
        }
        this.alK = SystemClock.elapsedRealtime() - this.alL;
        this.asO = SystemClock.elapsedRealtime();
        za();
        com.kwad.sdk.core.d.c.w("TKLoadController", "renderTKView center1: ");
        b(tVarA);
        File file = new File(this.asA.getJsBaseDir(this.mContext, this.asy.getTkTemplateId()));
        tVarA.a(styleTemplate.jsStr, file.getAbsolutePath() + WVNativeCallbackUtil.SEPERATER, new s() { // from class: com.kwad.components.core.webview.tachikoma.i.3
            @Override // com.kwad.sdk.components.s
            public final void onFailed(Throwable th) {
                com.kwad.sdk.core.d.c.w("TKLoadController", "renderTKView onFailed: " + th.getMessage());
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onFailed();
                }
                i.this.m(th);
            }

            @Override // com.kwad.sdk.components.s
            public final void onSuccess() {
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.onSuccess();
                }
            }
        });
        FrameLayout tKContainer = this.asy.getTKContainer();
        if (tKContainer != null && this.asT) {
            View view = tVarA.getView();
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            tKContainer.addView(view);
            d(styleTemplate);
        }
        com.kwad.sdk.core.d.c.w("TKLoadController", "renderTKView end: ");
    }

    public final void a(StyleTemplate styleTemplate) {
        this.akN = styleTemplate;
    }

    public void a(@Nullable Activity activity, AdResultData adResultData, j jVar) {
        this.asw = new WeakReference<>(activity);
        this.mAdResultData = adResultData;
        this.asX.a(adResultData);
        this.asy = jVar;
        this.asU = jVar.getTkTemplateId();
        this.asV = this.asy.getTKReaderScene();
        yW();
        FrameLayout tKContainer = this.asy.getTKContainer();
        if (tKContainer != null) {
            tKContainer.removeAllViews();
        }
        if (!com.kwad.sdk.core.config.e.JM()) {
            c(TKRenderFailReason.SWITCH_CLOSE);
            return;
        }
        this.asA = (com.kwad.components.core.offline.a.f.c) com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.f.c.class);
        zd();
        com.kwad.sdk.core.d.c.d("TKLoadController", "bind mTKPlugin: " + this.asA);
        if (TextUtils.isEmpty(this.asU)) {
            com.kwad.sdk.commercial.d.a.n(zb(), this.asV);
        }
        if (this.asA != null) {
            if (yU()) {
                yO();
                return;
            } else {
                yX();
                return;
            }
        }
        c(TKRenderFailReason.PLUGIN_NOT_READY);
        f(this.asU, TKPerformMsg.ERROR_REASON.KSAD_TK_OFFLINE_FAILED);
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.asN).setRenderState(4).setErrorReason(TKPerformMsg.ERROR_REASON.KSAD_TK_OFFLINE_FAILED).setTemplateId(this.asU).toJson());
    }

    public i(long j, Context context) {
        this.asI = false;
        this.asJ = false;
        this.asK = false;
        this.asL = false;
        this.asM = false;
        this.asN = 0;
        this.Cj = -1L;
        this.asR = 1000;
        this.asS = 0;
        this.asT = true;
        this.asX = new com.kwad.sdk.core.webview.e();
        this.atg = new KsAdWebView.b() { // from class: com.kwad.components.core.webview.tachikoma.i.1
            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                if (i.this.aoB != null) {
                    i.this.aoB.onFailed();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                if (i.this.aoB != null) {
                    i.this.aoB.onSuccess();
                }
            }
        };
        this.ath = new a() { // from class: com.kwad.components.core.webview.tachikoma.i.47
            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onFailed() {
                i.this.c(TKRenderFailReason.RENDER_ERROR);
                com.kwad.sdk.core.d.c.d("TKLoadController", "JS执行失败");
            }

            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onSuccess() {
                com.kwad.sdk.core.d.c.d("TKLoadController", "JS执行成功");
            }
        };
        this.ati = new r() { // from class: com.kwad.components.core.webview.tachikoma.i.4
            @Override // com.kwad.sdk.components.r
            public final void a(l lVar) {
                StyleTemplate styleTemplate;
                Activity activityYN = i.this.yN();
                if (activityYN == null) {
                    com.kwad.sdk.core.c.b.LW();
                    activityYN = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activityYN == null || activityYN.isFinishing()) {
                    lVar.callbackPageStatus(false, "no host activity");
                    return;
                }
                final String viewKey = lVar.getViewKey();
                if (viewKey == null) {
                    styleTemplate = new StyleTemplate();
                    try {
                        styleTemplate.parseJson(styleTemplate, new JSONObject(lVar.getStyleTemplate()));
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.c.printStackTrace(th);
                        lVar.callbackPageStatus(false, "template parse failed");
                        return;
                    }
                } else {
                    styleTemplate = null;
                }
                com.kwad.components.core.webview.tachikoma.d.e.b bVar = new com.kwad.components.core.webview.tachikoma.d.e.b();
                bVar.a(i.this.mAdResultData);
                bVar.c(lVar);
                if (styleTemplate != null) {
                    bVar.a(styleTemplate);
                }
                if (viewKey != null) {
                    bVar.a(new k() { // from class: com.kwad.components.core.webview.tachikoma.i.4.1
                        @Override // com.kwad.components.core.webview.tachikoma.k
                        public final o a(Object... objArr) {
                            if (i.this.asC != null) {
                                return i.this.asC.a(viewKey, objArr);
                            }
                            return null;
                        }
                    });
                }
                com.kwad.components.core.webview.tachikoma.d.e eVarB = com.kwad.components.core.webview.tachikoma.d.e.b(bVar);
                eVarB.show(activityYN.getFragmentManager(), "");
                i.asQ.put(Integer.valueOf(lVar.getDialogId()), new WeakReference(eVarB));
            }

            @Override // com.kwad.sdk.components.r
            public final void b(l lVar) {
                WeakReference weakReference = (WeakReference) i.asQ.get(Integer.valueOf(lVar.getDialogId()));
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                ((com.kwad.components.core.webview.tachikoma.d.e) weakReference.get()).dismiss();
            }

            /* JADX WARN: Code duplicated, block: B:6:0x0011  */
            @Override // com.kwad.sdk.components.r
            public final void a(n nVar) {
                Activity activityYN = i.this.yN();
                if (activityYN != null) {
                    com.kwad.sdk.core.c.b.LW();
                    if (activityYN != com.kwad.sdk.core.c.b.getCurrentActivity()) {
                        com.kwad.sdk.core.c.b.LW();
                        activityYN = com.kwad.sdk.core.c.b.getCurrentActivity();
                    }
                } else {
                    com.kwad.sdk.core.c.b.LW();
                    activityYN = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activityYN == null) {
                    nVar.callbackPageStatus(false, "no host activity");
                    return;
                }
                Intent intent = nVar.getIntent();
                if (TextUtils.isEmpty(nVar.getTemplateString()) && TextUtils.isEmpty(nVar.getViewKey())) {
                    if (!TextUtils.isEmpty(nVar.getClassName())) {
                        try {
                            com.kwad.sdk.service.c.putComponentProxy(FeedDownloadActivity.class, Class.forName(nVar.getClassName()));
                            intent.setClass(i.this.mContext, FeedDownloadActivity.class);
                        } catch (ClassNotFoundException e) {
                            nVar.callbackPageStatus(false, e.getMessage());
                            return;
                        }
                    }
                } else {
                    com.kwad.sdk.service.c.putComponentProxy(FeedDownloadActivity.class, com.kwad.components.core.s.a.a.class);
                    int iWw = com.kwad.components.core.s.a.a.ww();
                    com.kwad.components.core.s.a.a.a(iWw, "native_intent", nVar);
                    if (i.this.mAdResultData != null) {
                        intent.putExtra("ad_result_cache_idx", com.kwad.components.core.c.f.oU().l(i.this.mAdResultData));
                    }
                    if (!TextUtils.isEmpty(nVar.getTemplateString())) {
                        intent.putExtra("tk_style_template", nVar.getTemplateString());
                    } else {
                        final String viewKey = nVar.getViewKey();
                        com.kwad.components.core.s.a.a.a(iWw, "tk_view_holder", new k() { // from class: com.kwad.components.core.webview.tachikoma.i.4.2
                            @Override // com.kwad.components.core.webview.tachikoma.k
                            public final o a(Object... objArr) {
                                if (i.this.asC != null) {
                                    return i.this.asC.a(viewKey, objArr);
                                }
                                return null;
                            }
                        });
                    }
                    intent.putExtra("tk_id", iWw);
                    intent.setClass(i.this.mContext, FeedDownloadActivity.class);
                }
                if (!TextUtils.isEmpty(nVar.getUrl())) {
                    intent.setData(Uri.parse(nVar.getUrl()));
                    int intExtra = intent.getIntExtra("adCacheId", 0);
                    if (intExtra > 0) {
                        com.kwad.components.core.proxy.launchdialog.e.vJ().ba(com.kwad.sdk.core.response.helper.c.r(com.kwad.components.core.offline.a.f.a.a.bp(intExtra)));
                    }
                }
                try {
                    activityYN.startActivity(intent);
                    nVar.callbackPageStatus(true, null);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                    nVar.callbackPageStatus(false, th.getMessage());
                }
            }
        };
        this.atj = new com.kwad.sdk.components.k() { // from class: com.kwad.components.core.webview.tachikoma.i.5
            @Override // com.kwad.sdk.components.k
            public final com.kwad.sdk.components.j bO(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    AdTemplate adTemplate = new AdTemplate();
                    adTemplate.parseJson(jSONObject);
                    return i.this.bj(adTemplate);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                    return null;
                }
            }

            @Override // com.kwad.sdk.components.k
            public final com.kwad.sdk.components.j ch(int i) {
                return i.this.bj(com.kwad.sdk.core.response.helper.c.r(com.kwad.components.core.offline.a.f.a.a.bp(i)));
            }
        };
        this.atk = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.7
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.c.d("TKLoadController", "mDownloadTimeoutRunnable 已经超时" + i.this.asy.getTkTemplateId());
                i.this.zi();
                i.a(i.this, true);
                i.this.c(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.atl = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.8
            @Override // java.lang.Runnable
            public final void run() {
                i.b(i.this, true);
                com.kwad.sdk.core.d.c.d("TKLoadController", "mTKLoadTotalTimeoutRunnable run: " + i.this.asy.getTkTemplateId());
                i.this.c(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.kf = new m() { // from class: com.kwad.components.core.webview.tachikoma.i.39
            private void e(double d) {
                i.this.AN.auB = false;
                i.this.AN.ajf = false;
                i.this.AN.rq = (int) ((d / 1000.0d) + 0.5d);
                kq();
            }

            private void kq() {
                if (i.this.asD == null || i.this.AN == null) {
                    return;
                }
                i.this.asD.a(i.this.AN);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                i.this.AN.ajf = true;
                i.this.AN.auB = false;
                i.this.AN.rq = com.kwad.sdk.core.response.helper.a.N(com.kwad.sdk.core.response.helper.e.eO(i.this.zb()));
                kq();
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayError(int i, int i2) {
                i.this.AN.auB = true;
                i.this.AN.ajf = false;
                kq();
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayProgress(long j2, long j3) {
                e(j3);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                e(AudioStats.AUDIO_AMPLITUDE_NONE);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPreparing() {
                e(AudioStats.AUDIO_AMPLITUDE_NONE);
            }
        };
        this.mContext = context;
        this.Cj = j;
        this.AN = new z();
    }

    private void b(t tVar) {
        com.kwad.components.core.e.d.d dVar = zb() != null ? new com.kwad.components.core.e.d.d(zb()) : null;
        this.asy.a(tVar, this.asX);
        a(tVar, new com.kwad.components.core.webview.jshandler.q());
        a(tVar, new com.kwad.components.core.webview.jshandler.r());
        com.kwad.components.core.webview.tachikoma.b.s sVar = new com.kwad.components.core.webview.tachikoma.b.s();
        sVar.a(new com.kwad.components.core.webview.tachikoma.b.s.a() { // from class: com.kwad.components.core.webview.tachikoma.i.11
            @Override // com.kwad.components.core.webview.tachikoma.b.s.a
            public final void a(com.kwad.components.core.webview.tachikoma.c.t tVar2) {
                if (TextUtils.isEmpty(tVar2.message)) {
                    return;
                }
                com.kwad.sdk.utils.ae.d(i.this.mContext, tVar2.message, 0L);
            }
        });
        a(tVar, sVar);
        a(tVar, c(this.asX));
        a(tVar, new com.kwad.components.core.webview.jshandler.n(this.asX));
        a(tVar, new com.kwad.components.core.webview.jshandler.o(this.asX));
        a(tVar, new com.kwad.sdk.core.webview.d.a());
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.f());
        a(tVar, new x());
        if (pz()) {
            com.kwad.components.core.webview.jshandler.z zVar = new com.kwad.components.core.webview.jshandler.z(this.asX, dVar, this);
            if (!this.asU.equals(com.kwad.sdk.core.response.helper.b.dG(this.asX.getAdTemplate()))) {
                com.kwad.components.core.e.e.g.qK().a(this);
            }
            a(tVar, zVar);
        } else {
            a(tVar, new ac(this.asX, dVar, this, (byte) 0));
        }
        a(tVar, new ab(this.asX));
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.k());
        a(tVar, new af(this.asX));
        a(tVar, new ai(this.asX));
        a(tVar, new ar(this.mContext, zb()));
        ae aeVar = new ae(this.asX);
        aeVar.a(new ae.c() { // from class: com.kwad.components.core.webview.tachikoma.i.13
            @Override // com.kwad.components.core.webview.jshandler.ae.c
            public final void c(ae.a aVar) {
                i.this.asy.a(aVar);
            }
        });
        a(tVar, aeVar);
        a(tVar, new bd(this.asX, new bd.a() { // from class: com.kwad.components.core.webview.tachikoma.i.14
            @Override // com.kwad.components.core.webview.jshandler.bd.a
            public final void g(AdTemplate adTemplate) {
                try {
                    i.this.asX.Pu().remove(0);
                    i.this.asX.Pu().add(adTemplate);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(adTemplate);
                    AdResultData adResultData = new AdResultData();
                    adResultData.setAdTemplateList(arrayList);
                    adResultData.llsid = adTemplate.llsid;
                    i.this.mAdResultData = adResultData;
                    i iVar = i.this;
                    iVar.asy.g(com.kwad.sdk.core.response.helper.c.r(iVar.mAdResultData));
                    if (i.this.asC != null) {
                        com.kwad.components.core.offline.a.f.a.a.a(i.this.asC.getUniqId(), i.this.mAdResultData);
                    }
                    i.this.asF.setApkDownloadHelper(new com.kwad.components.core.e.d.d(adTemplate));
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
        }));
        a(tVar, new al(this.asX, new al.b() { // from class: com.kwad.components.core.webview.tachikoma.i.15
            @Override // com.kwad.components.core.webview.jshandler.al.b
            public final void a(al.a aVar) {
                i.this.b(aVar);
            }
        }));
        a(tVar, new com.kwad.components.core.webview.jshandler.as(new com.kwad.components.core.webview.jshandler.as.b() { // from class: com.kwad.components.core.webview.tachikoma.i.16
            @Override // com.kwad.components.core.webview.jshandler.as.b
            public final void a(com.kwad.components.core.webview.jshandler.as.a aVar) {
                if (aVar.status == 1) {
                    i.this.zm();
                } else {
                    i.this.c(TKRenderFailReason.RENDER_ERROR);
                    i.this.bN(aVar.errorMsg);
                }
            }
        }));
        az azVar = new az();
        this.fk = azVar;
        a(tVar, azVar);
        this.asy.a(this.fk);
        ay ayVar = new ay();
        this.asE = ayVar;
        a(tVar, ayVar);
        bc bcVar = new bc(this.asX, dVar);
        this.asF = bcVar;
        a(tVar, bcVar);
        p pVar = new p();
        this.asD = pVar;
        a(tVar, pVar);
        this.asy.a(this.asD);
        a(tVar, new com.kwad.components.core.webview.jshandler.a(new com.kwad.components.core.webview.jshandler.a.b() { // from class: com.kwad.components.core.webview.tachikoma.i.17
            @Override // com.kwad.components.core.webview.jshandler.a.b
            public final void c(com.kwad.components.core.webview.jshandler.a.C1235a c1235a) {
                i.this.asy.a(c1235a);
            }
        }));
        if (zb() != null && com.kwad.sdk.core.response.helper.a.aL(com.kwad.sdk.core.response.helper.e.eO(zb()))) {
            final com.kwad.components.core.webview.tachikoma.b.l lVar = new com.kwad.components.core.webview.tachikoma.b.l();
            a(tVar, lVar);
            this.aoC = new com.kwad.sdk.core.download.d(zb()) { // from class: com.kwad.components.core.webview.tachikoma.i.18
                @Override // com.kwad.sdk.core.download.d, com.kwad.sdk.core.download.c
                public final void b(String str, String str2, com.kwad.sdk.core.download.e eVar) {
                    super.b(str, str2, eVar);
                    com.kwad.components.core.webview.tachikoma.c.b bVar = new com.kwad.components.core.webview.tachikoma.c.b();
                    bVar.aui = 1;
                    lVar.a(bVar);
                }
            };
            com.kwad.sdk.core.download.b.Lz().a(this.aoC, zb());
        }
        com.kwad.components.core.webview.tachikoma.b.t tVar2 = new com.kwad.components.core.webview.tachikoma.b.t();
        tVar2.a(new com.kwad.components.core.webview.tachikoma.b.t.a() { // from class: com.kwad.components.core.webview.tachikoma.i.19
            @Override // com.kwad.components.core.webview.tachikoma.b.t.a
            public final void b(u uVar) {
                i.this.asy.a(uVar);
            }
        });
        a(tVar, tVar2);
        v vVar = new v();
        vVar.a(new v.a() { // from class: com.kwad.components.core.webview.tachikoma.i.20
            @Override // com.kwad.components.core.webview.tachikoma.b.v.a
            public final void b(com.kwad.components.core.webview.tachikoma.c.n nVar) {
                i.this.asy.a(nVar);
            }
        });
        a(tVar, vVar);
        com.kwad.components.core.webview.tachikoma.b.o oVar = new com.kwad.components.core.webview.tachikoma.b.o();
        a(tVar, oVar);
        this.asy.a(oVar);
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.r() { // from class: com.kwad.components.core.webview.tachikoma.i.21
            @Override // com.kwad.components.core.webview.tachikoma.b.r
            public final void a(com.kwad.components.core.webview.tachikoma.c.s sVar2) {
                super.a(sVar2);
                Activity activityYN = i.this.yN();
                if (activityYN == null) {
                    com.kwad.sdk.core.c.b.LW();
                    activityYN = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activityYN == null || activityYN.isFinishing()) {
                    return;
                }
                if (i.this.asx != null) {
                    i.this.asx.dismiss();
                }
                com.kwad.components.core.webview.tachikoma.d.e.b bVar = new com.kwad.components.core.webview.tachikoma.d.e.b();
                bVar.a(i.this.mAdResultData);
                bVar.bP(sVar2.templateId);
                i.this.asx = com.kwad.components.core.webview.tachikoma.d.e.b(bVar);
                i.this.asx.show(activityYN.getFragmentManager(), "");
            }
        });
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.c() { // from class: com.kwad.components.core.webview.tachikoma.i.22
            @Override // com.kwad.components.core.webview.tachikoma.b.c
            public final void kt() {
                super.kt();
                if (i.this.asx != null) {
                    i.this.asx.dismiss();
                }
                j jVar = i.this.asy;
                if (jVar != null) {
                    jVar.aF();
                }
            }
        });
        a(tVar, new aa(new com.kwad.sdk.core.webview.d.a.b() { // from class: com.kwad.components.core.webview.tachikoma.i.24
            @Override // com.kwad.sdk.core.webview.d.a.b
            public final void b(WebCloseStatus webCloseStatus) {
                i.this.asy.a(webCloseStatus);
            }
        }));
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.d() { // from class: com.kwad.components.core.webview.tachikoma.i.25
            @Override // com.kwad.components.core.webview.tachikoma.b.d
            public final void a(com.kwad.components.core.webview.tachikoma.c.g gVar) {
                int i = gVar.apo;
                AdTemplate adTemplateA = i >= 0 ? com.kwad.sdk.core.response.helper.c.a(com.kwad.components.core.offline.a.f.a.a.bp(i), gVar.PC) : null;
                if (adTemplateA == null) {
                    adTemplateA = i.this.zb();
                }
                com.kwad.components.core.p.a.vL().a(gVar.actionType, adTemplateA, gVar.QY);
            }
        });
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.j() { // from class: com.kwad.components.core.webview.tachikoma.i.26
            @Override // com.kwad.components.core.webview.tachikoma.b.j
            public final void a(com.kwad.components.core.webview.tachikoma.c.o oVar2) {
                super.a(oVar2);
                AdWebViewActivityProxy.launch(i.this.mContext, new AdWebViewActivityProxy.a.C1220a().aY(oVar2.title).aZ(oVar2.url).aS(!oVar2.auu).q(i.this.mAdResultData).ua());
            }
        });
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.a(zb()));
        a(tVar, new com.kwad.components.core.webview.tachikoma.a(zb()));
        a(this.asX, dVar, tVar, this.asy.getTKContainer());
        a(tVar, new com.kwad.components.core.webview.jshandler.a.f(this.mContext));
        a(tVar, new com.kwad.components.core.webview.jshandler.a.d(this.mContext));
        a(tVar, new com.kwad.components.core.webview.jshandler.a.a());
        a(tVar, new com.kwad.components.core.webview.jshandler.a.e(this.mContext));
        aw awVar = new aw();
        this.aoB = awVar;
        a(tVar, awVar);
        a(tVar, new com.kwad.components.core.webview.jshandler.c(this.asX));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(t tVar) {
        try {
            com.kwad.sdk.core.d.c.d("TKLoadController", "renderTKTemplate start tachikomaContext: " + tVar);
            if (this.akN == null) {
                this.akN = yZ();
            }
            if (tVar == null) {
                return;
            }
            this.asC = tVar;
            ze();
            int iHashCode = this.mAdResultData.hashCode();
            com.kwad.components.core.offline.a.f.a.a.a(iHashCode, this.mAdResultData);
            this.mAdResultData.mAdCacheId = iHashCode;
            com.kwad.sdk.core.d.c.d("TKLoadController", "renderTKTemplate tachikomaContext is not null");
            o oVarA = tVar.a(this.asy.getRegisterViewKey(), new af.a(this.mAdResultData).toJson().toString(), yR(), yQ());
            com.kwad.sdk.core.d.c.d("TKLoadController", "renderTKTemplate itkView: " + oVarA);
            this.asY = oVarA;
            yS();
            View view = oVarA.getView();
            com.kwad.sdk.core.d.c.d("TKLoadController", "renderTKTemplate itkView getView: " + view);
            if (view != null) {
                FrameLayout tKContainer = this.asy.getTKContainer();
                if (tKContainer != 0 && this.asT) {
                    if (tKContainer instanceof com.kwad.sdk.core.view.e) {
                        com.kwad.sdk.core.view.e eVar = (com.kwad.sdk.core.view.e) tKContainer;
                        this.asG = eVar;
                        eVar.getWindowFocusChangeHelper().a(this);
                    }
                    view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    tKContainer.addView(view);
                }
                d(yZ());
                zm();
                return;
            }
            com.kwad.components.core.t.k.c(Integer.valueOf(this.asZ));
            c(TKRenderFailReason.RENDER_ERROR);
            bN(TKPerformMsg.ERROR_REASON.KSAD_TK_RENDER_FAIL);
            com.kwad.sdk.core.d.c.d("TKLoadController", "renderTKTemplate start end: ");
        } catch (Exception e) {
            com.kwad.components.core.t.k.c(Integer.valueOf(this.asZ));
            c(TKRenderFailReason.RENDER_ERROR);
            bN(e.getMessage());
            ServiceProvider.reportSdkCaughtException(e);
        }
    }

    public i(Context context, int i, int i2) {
        this.asI = false;
        this.asJ = false;
        this.asK = false;
        this.asL = false;
        this.asM = false;
        this.asN = 0;
        this.Cj = -1L;
        this.asR = 1000;
        this.asS = 0;
        this.asT = true;
        this.asX = new com.kwad.sdk.core.webview.e();
        this.atg = new KsAdWebView.b() { // from class: com.kwad.components.core.webview.tachikoma.i.1
            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onFailed() {
                if (i.this.aoB != null) {
                    i.this.aoB.onFailed();
                }
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.b
            public final void onSuccess() {
                if (i.this.aoB != null) {
                    i.this.aoB.onSuccess();
                }
            }
        };
        this.ath = new a() { // from class: com.kwad.components.core.webview.tachikoma.i.47
            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onFailed() {
                i.this.c(TKRenderFailReason.RENDER_ERROR);
                com.kwad.sdk.core.d.c.d("TKLoadController", "JS执行失败");
            }

            @Override // com.kwad.components.core.webview.tachikoma.i.a
            public final void onSuccess() {
                com.kwad.sdk.core.d.c.d("TKLoadController", "JS执行成功");
            }
        };
        this.ati = new r() { // from class: com.kwad.components.core.webview.tachikoma.i.4
            @Override // com.kwad.sdk.components.r
            public final void a(l lVar) {
                StyleTemplate styleTemplate;
                Activity activityYN = i.this.yN();
                if (activityYN == null) {
                    com.kwad.sdk.core.c.b.LW();
                    activityYN = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activityYN == null || activityYN.isFinishing()) {
                    lVar.callbackPageStatus(false, "no host activity");
                    return;
                }
                final String viewKey = lVar.getViewKey();
                if (viewKey == null) {
                    styleTemplate = new StyleTemplate();
                    try {
                        styleTemplate.parseJson(styleTemplate, new JSONObject(lVar.getStyleTemplate()));
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.c.printStackTrace(th);
                        lVar.callbackPageStatus(false, "template parse failed");
                        return;
                    }
                } else {
                    styleTemplate = null;
                }
                com.kwad.components.core.webview.tachikoma.d.e.b bVar = new com.kwad.components.core.webview.tachikoma.d.e.b();
                bVar.a(i.this.mAdResultData);
                bVar.c(lVar);
                if (styleTemplate != null) {
                    bVar.a(styleTemplate);
                }
                if (viewKey != null) {
                    bVar.a(new k() { // from class: com.kwad.components.core.webview.tachikoma.i.4.1
                        @Override // com.kwad.components.core.webview.tachikoma.k
                        public final o a(Object... objArr) {
                            if (i.this.asC != null) {
                                return i.this.asC.a(viewKey, objArr);
                            }
                            return null;
                        }
                    });
                }
                com.kwad.components.core.webview.tachikoma.d.e eVarB = com.kwad.components.core.webview.tachikoma.d.e.b(bVar);
                eVarB.show(activityYN.getFragmentManager(), "");
                i.asQ.put(Integer.valueOf(lVar.getDialogId()), new WeakReference(eVarB));
            }

            @Override // com.kwad.sdk.components.r
            public final void b(l lVar) {
                WeakReference weakReference = (WeakReference) i.asQ.get(Integer.valueOf(lVar.getDialogId()));
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                ((com.kwad.components.core.webview.tachikoma.d.e) weakReference.get()).dismiss();
            }

            /* JADX WARN: Code duplicated, block: B:6:0x0011  */
            @Override // com.kwad.sdk.components.r
            public final void a(n nVar) {
                Activity activityYN = i.this.yN();
                if (activityYN != null) {
                    com.kwad.sdk.core.c.b.LW();
                    if (activityYN != com.kwad.sdk.core.c.b.getCurrentActivity()) {
                        com.kwad.sdk.core.c.b.LW();
                        activityYN = com.kwad.sdk.core.c.b.getCurrentActivity();
                    }
                } else {
                    com.kwad.sdk.core.c.b.LW();
                    activityYN = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activityYN == null) {
                    nVar.callbackPageStatus(false, "no host activity");
                    return;
                }
                Intent intent = nVar.getIntent();
                if (TextUtils.isEmpty(nVar.getTemplateString()) && TextUtils.isEmpty(nVar.getViewKey())) {
                    if (!TextUtils.isEmpty(nVar.getClassName())) {
                        try {
                            com.kwad.sdk.service.c.putComponentProxy(FeedDownloadActivity.class, Class.forName(nVar.getClassName()));
                            intent.setClass(i.this.mContext, FeedDownloadActivity.class);
                        } catch (ClassNotFoundException e) {
                            nVar.callbackPageStatus(false, e.getMessage());
                            return;
                        }
                    }
                } else {
                    com.kwad.sdk.service.c.putComponentProxy(FeedDownloadActivity.class, com.kwad.components.core.s.a.a.class);
                    int iWw = com.kwad.components.core.s.a.a.ww();
                    com.kwad.components.core.s.a.a.a(iWw, "native_intent", nVar);
                    if (i.this.mAdResultData != null) {
                        intent.putExtra("ad_result_cache_idx", com.kwad.components.core.c.f.oU().l(i.this.mAdResultData));
                    }
                    if (!TextUtils.isEmpty(nVar.getTemplateString())) {
                        intent.putExtra("tk_style_template", nVar.getTemplateString());
                    } else {
                        final String viewKey = nVar.getViewKey();
                        com.kwad.components.core.s.a.a.a(iWw, "tk_view_holder", new k() { // from class: com.kwad.components.core.webview.tachikoma.i.4.2
                            @Override // com.kwad.components.core.webview.tachikoma.k
                            public final o a(Object... objArr) {
                                if (i.this.asC != null) {
                                    return i.this.asC.a(viewKey, objArr);
                                }
                                return null;
                            }
                        });
                    }
                    intent.putExtra("tk_id", iWw);
                    intent.setClass(i.this.mContext, FeedDownloadActivity.class);
                }
                if (!TextUtils.isEmpty(nVar.getUrl())) {
                    intent.setData(Uri.parse(nVar.getUrl()));
                    int intExtra = intent.getIntExtra("adCacheId", 0);
                    if (intExtra > 0) {
                        com.kwad.components.core.proxy.launchdialog.e.vJ().ba(com.kwad.sdk.core.response.helper.c.r(com.kwad.components.core.offline.a.f.a.a.bp(intExtra)));
                    }
                }
                try {
                    activityYN.startActivity(intent);
                    nVar.callbackPageStatus(true, null);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                    nVar.callbackPageStatus(false, th.getMessage());
                }
            }
        };
        this.atj = new com.kwad.sdk.components.k() { // from class: com.kwad.components.core.webview.tachikoma.i.5
            @Override // com.kwad.sdk.components.k
            public final com.kwad.sdk.components.j bO(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    AdTemplate adTemplate = new AdTemplate();
                    adTemplate.parseJson(jSONObject);
                    return i.this.bj(adTemplate);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                    return null;
                }
            }

            @Override // com.kwad.sdk.components.k
            public final com.kwad.sdk.components.j ch(int i3) {
                return i.this.bj(com.kwad.sdk.core.response.helper.c.r(com.kwad.components.core.offline.a.f.a.a.bp(i3)));
            }
        };
        this.atk = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.7
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.d.c.d("TKLoadController", "mDownloadTimeoutRunnable 已经超时" + i.this.asy.getTkTemplateId());
                i.this.zi();
                i.a(i.this, true);
                i.this.c(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.atl = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.8
            @Override // java.lang.Runnable
            public final void run() {
                i.b(i.this, true);
                com.kwad.sdk.core.d.c.d("TKLoadController", "mTKLoadTotalTimeoutRunnable run: " + i.this.asy.getTkTemplateId());
                i.this.c(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.kf = new m() { // from class: com.kwad.components.core.webview.tachikoma.i.39
            private void e(double d) {
                i.this.AN.auB = false;
                i.this.AN.ajf = false;
                i.this.AN.rq = (int) ((d / 1000.0d) + 0.5d);
                kq();
            }

            private void kq() {
                if (i.this.asD == null || i.this.AN == null) {
                    return;
                }
                i.this.asD.a(i.this.AN);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayCompleted() {
                i.this.AN.ajf = true;
                i.this.AN.auB = false;
                i.this.AN.rq = com.kwad.sdk.core.response.helper.a.N(com.kwad.sdk.core.response.helper.e.eO(i.this.zb()));
                kq();
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayError(int i3, int i4) {
                i.this.AN.auB = true;
                i.this.AN.ajf = false;
                kq();
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayProgress(long j2, long j3) {
                e(j3);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPlayStart() {
                e(AudioStats.AUDIO_AMPLITUDE_NONE);
            }

            @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
            public final void onMediaPreparing() {
                e(AudioStats.AUDIO_AMPLITUDE_NONE);
            }
        };
        this.mContext = context;
        this.asR = i;
        this.AN = new z();
        this.asS = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final TKRenderFailReason tKRenderFailReason) {
        by.postOnUiThread(new bi() { // from class: com.kwad.components.core.webview.tachikoma.i.9
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                if (i.this.asM) {
                    return;
                }
                i.c(i.this, true);
                i.this.asy.a(tKRenderFailReason);
                com.kwad.components.core.e.e.g.qK().b(i.this);
                com.kwad.components.core.webview.tachikoma.e.c.zG().x(i.this.asU, i.this.asV);
                com.kwad.components.core.webview.tachikoma.e.b.zE().b(i.this.asZ, i.this.asU, i.this.asV);
            }
        });
    }

    private void c(final t tVar) {
        com.kwad.components.core.e.d.d dVar = zb() != null ? new com.kwad.components.core.e.d.d(zb()) : null;
        this.asy.a(tVar, this.asX);
        a(tVar, new com.kwad.components.core.webview.jshandler.q());
        a(tVar, new com.kwad.components.core.webview.jshandler.r());
        com.kwad.components.core.webview.tachikoma.b.s sVar = new com.kwad.components.core.webview.tachikoma.b.s();
        sVar.a(new com.kwad.components.core.webview.tachikoma.b.s.a() { // from class: com.kwad.components.core.webview.tachikoma.i.27
            @Override // com.kwad.components.core.webview.tachikoma.b.s.a
            public final void a(com.kwad.components.core.webview.tachikoma.c.t tVar2) {
                if (TextUtils.isEmpty(tVar2.message)) {
                    return;
                }
                com.kwad.sdk.utils.ae.d(i.this.mContext, tVar2.message, 0L);
            }
        });
        a(tVar, sVar);
        a(tVar, c(this.asX));
        a(tVar, new com.kwad.sdk.core.webview.d.a());
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.f());
        a(tVar, new x());
        if (pz()) {
            com.kwad.components.core.webview.jshandler.z zVar = new com.kwad.components.core.webview.jshandler.z(this.asX, dVar, this);
            if (!this.asU.equals(com.kwad.sdk.core.response.helper.b.dG(this.asX.getAdTemplate()))) {
                com.kwad.components.core.e.e.g.qK().a(this);
            }
            a(tVar, zVar);
        } else {
            a(tVar, new ac(this.asX, dVar, this, (byte) 0));
        }
        a(tVar, new ab(this.asX));
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.k());
        a(tVar, new ar(this.mContext, zb()));
        a(tVar, new bd(this.asX, new bd.a() { // from class: com.kwad.components.core.webview.tachikoma.i.28
            @Override // com.kwad.components.core.webview.jshandler.bd.a
            public final void g(AdTemplate adTemplate) {
                try {
                    i.this.asX.Pu().remove(0);
                    i.this.asX.Pu().add(adTemplate);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(adTemplate);
                    AdResultData adResultData = new AdResultData();
                    adResultData.setAdTemplateList(arrayList);
                    adResultData.llsid = adTemplate.llsid;
                    i.this.mAdResultData = adResultData;
                    i iVar = i.this;
                    iVar.asy.g(com.kwad.sdk.core.response.helper.c.r(iVar.mAdResultData));
                    if (i.this.asC != null) {
                        com.kwad.components.core.offline.a.f.a.a.a(i.this.asC.getUniqId(), i.this.mAdResultData);
                    }
                    i.this.asF.setApkDownloadHelper(new com.kwad.components.core.e.d.d(adTemplate));
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
        }));
        a(tVar, new com.kwad.components.core.webview.jshandler.as(new com.kwad.components.core.webview.jshandler.as.b() { // from class: com.kwad.components.core.webview.tachikoma.i.29
            @Override // com.kwad.components.core.webview.jshandler.as.b
            public final void a(com.kwad.components.core.webview.jshandler.as.a aVar) {
                if (aVar.status != 2 || !i.this.asW) {
                    if (aVar.status == 0) {
                        i.this.c(TKRenderFailReason.RENDER_ERROR);
                        i.this.bN(aVar.errorMsg);
                        return;
                    }
                    return;
                }
                try {
                    i.this.atb = SystemClock.elapsedRealtime();
                    i iVar = i.this;
                    iVar.atd = iVar.atb;
                    i iVar2 = i.this;
                    iVar2.atc = iVar2.atb - i.this.asO;
                    com.kwad.sdk.core.d.c.d("WebCardPageStatusHandler", "registerTKContext");
                    com.kwad.components.core.t.k.a(Integer.valueOf(i.this.asZ), tVar, i.this.alK, i.this.Kk, i.this.alL, i.this.atb);
                    i.this.a(tVar);
                    com.kwad.components.core.webview.tachikoma.e.b.zE().co(i.this.asZ);
                } catch (Exception e) {
                    com.kwad.components.core.t.k.c(Integer.valueOf(i.this.asZ));
                    i.this.c(TKRenderFailReason.RENDER_ERROR);
                    i.this.bN(e.getMessage());
                }
            }
        }));
        ay ayVar = new ay();
        this.asE = ayVar;
        a(tVar, ayVar);
        p pVar = new p();
        this.asD = pVar;
        a(tVar, pVar);
        this.asy.a(this.asD);
        if (zb() != null && com.kwad.sdk.core.response.helper.a.aL(com.kwad.sdk.core.response.helper.e.eO(zb()))) {
            final com.kwad.components.core.webview.tachikoma.b.l lVar = new com.kwad.components.core.webview.tachikoma.b.l();
            a(tVar, lVar);
            this.aoC = new com.kwad.sdk.core.download.d(zb()) { // from class: com.kwad.components.core.webview.tachikoma.i.30
                @Override // com.kwad.sdk.core.download.d, com.kwad.sdk.core.download.c
                public final void b(String str, String str2, com.kwad.sdk.core.download.e eVar) {
                    super.b(str, str2, eVar);
                    com.kwad.components.core.webview.tachikoma.c.b bVar = new com.kwad.components.core.webview.tachikoma.c.b();
                    bVar.aui = 1;
                    lVar.a(bVar);
                }
            };
            com.kwad.sdk.core.download.b.Lz().a(this.aoC, zb());
        }
        com.kwad.components.core.webview.tachikoma.b.t tVar2 = new com.kwad.components.core.webview.tachikoma.b.t();
        tVar2.a(new com.kwad.components.core.webview.tachikoma.b.t.a() { // from class: com.kwad.components.core.webview.tachikoma.i.31
            @Override // com.kwad.components.core.webview.tachikoma.b.t.a
            public final void b(u uVar) {
                i.this.asy.a(uVar);
            }
        });
        a(tVar, tVar2);
        v vVar = new v();
        vVar.a(new v.a() { // from class: com.kwad.components.core.webview.tachikoma.i.32
            @Override // com.kwad.components.core.webview.tachikoma.b.v.a
            public final void b(com.kwad.components.core.webview.tachikoma.c.n nVar) {
                i.this.asy.a(nVar);
            }
        });
        a(tVar, vVar);
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.r() { // from class: com.kwad.components.core.webview.tachikoma.i.33
            @Override // com.kwad.components.core.webview.tachikoma.b.r
            public final void a(com.kwad.components.core.webview.tachikoma.c.s sVar2) {
                super.a(sVar2);
                Activity activityYN = i.this.yN();
                if (activityYN == null) {
                    com.kwad.sdk.core.c.b.LW();
                    activityYN = com.kwad.sdk.core.c.b.getCurrentActivity();
                }
                if (activityYN == null || activityYN.isFinishing()) {
                    return;
                }
                if (i.this.asx != null) {
                    i.this.asx.dismiss();
                }
                com.kwad.components.core.webview.tachikoma.d.e.b bVar = new com.kwad.components.core.webview.tachikoma.d.e.b();
                bVar.a(i.this.mAdResultData);
                bVar.bP(sVar2.templateId);
                i.this.asx = com.kwad.components.core.webview.tachikoma.d.e.b(bVar);
                i.this.asx.show(activityYN.getFragmentManager(), "");
            }
        });
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.c() { // from class: com.kwad.components.core.webview.tachikoma.i.35
            @Override // com.kwad.components.core.webview.tachikoma.b.c
            public final void kt() {
                super.kt();
                if (i.this.asx != null) {
                    i.this.asx.dismiss();
                }
                j jVar = i.this.asy;
                if (jVar != null) {
                    jVar.aF();
                }
            }
        });
        a(tVar, new aa(new com.kwad.sdk.core.webview.d.a.b() { // from class: com.kwad.components.core.webview.tachikoma.i.36
            @Override // com.kwad.sdk.core.webview.d.a.b
            public final void b(WebCloseStatus webCloseStatus) {
                i.this.asy.a(webCloseStatus);
            }
        }));
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.d() { // from class: com.kwad.components.core.webview.tachikoma.i.37
            @Override // com.kwad.components.core.webview.tachikoma.b.d
            public final void a(com.kwad.components.core.webview.tachikoma.c.g gVar) {
                int i = gVar.apo;
                AdTemplate adTemplateA = i >= 0 ? com.kwad.sdk.core.response.helper.c.a(com.kwad.components.core.offline.a.f.a.a.bp(i), gVar.PC) : null;
                if (adTemplateA == null) {
                    adTemplateA = i.this.zb();
                }
                com.kwad.components.core.p.a.vL().a(gVar.actionType, adTemplateA, gVar.QY);
            }
        });
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.j() { // from class: com.kwad.components.core.webview.tachikoma.i.38
            @Override // com.kwad.components.core.webview.tachikoma.b.j
            public final void a(com.kwad.components.core.webview.tachikoma.c.o oVar) {
                super.a(oVar);
                AdWebViewActivityProxy.launch(i.this.mContext, new AdWebViewActivityProxy.a.C1220a().aY(oVar.title).aZ(oVar.url).aS(!oVar.auu).q(i.this.mAdResultData).ua());
            }
        });
        a(tVar, new com.kwad.components.core.webview.tachikoma.b.a(zb()));
        a(tVar, new com.kwad.components.core.webview.tachikoma.a(zb()));
        a(this.asX, dVar, tVar, this.asy.getTKContainer());
        a(tVar, new com.kwad.components.core.webview.jshandler.a.f(this.mContext));
        a(tVar, new com.kwad.components.core.webview.jshandler.a.d(this.mContext));
        a(tVar, new com.kwad.components.core.webview.jshandler.a.a());
        a(tVar, new com.kwad.components.core.webview.jshandler.a.e(this.mContext));
        aw awVar = new aw();
        this.aoB = awVar;
        a(tVar, awVar);
    }

    public final Object a(String str, String str2, com.kwad.sdk.components.m mVar) {
        o oVar = this.asY;
        if (oVar != null) {
            return oVar.b(str, str2, mVar);
        }
        return null;
    }

    public final void a(com.kwad.sdk.core.webview.c.g gVar) {
        this.asz = gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TKDownloadListener tKDownloadListener) {
        StyleTemplate styleTemplateYZ = yZ();
        if (styleTemplateYZ == null) {
            tKDownloadListener.onFailed("no template");
            return;
        }
        if (!isLocalDebugEnable()) {
            String strO = h.yK().o(styleTemplateYZ.templateId, styleTemplateYZ.templateVersionCode);
            if (!TextUtils.isEmpty(strO) && !isLocalDebugEnable()) {
                styleTemplateYZ.jsStr = strO;
                styleTemplateYZ.tkSouce = 4;
                com.kwad.sdk.core.d.c.d("TKLoadController", "使用TK模板缓存");
                tKDownloadListener.onSuccess(styleTemplateYZ);
                return;
            }
        }
        this.asA.loadTkFileByTemplateId(this.mContext, styleTemplateYZ.templateId, styleTemplateYZ.templateMd5, styleTemplateYZ.templateUrl, styleTemplateYZ.templateVersionCode, tKDownloadListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(StyleTemplate styleTemplate, a aVar) {
        this.akN = styleTemplate;
        com.kwad.sdk.core.d.c.w("TKLoadController", "addTKView mTKPlugin.getState(): " + this.asA.getState());
        if (this.asA.getState() == ITkOfflineCompo.TKState.SO_FAIL) {
            bM(TKPerformMsg.ERROR_REASON.KSAD_TK_SO_FAIL);
            if (aVar != null) {
                aVar.onFailed();
                return;
            }
            return;
        }
        com.kwad.sdk.core.d.c.w("TKLoadController", "addTKView TextUtils.isEmpty(styleTemplate.jsStr) " + TextUtils.isEmpty(styleTemplate.jsStr));
        if (TextUtils.isEmpty(styleTemplate.jsStr)) {
            bN(TKPerformMsg.ERROR_REASON.KSAD_TK_NO_TEMPLATE);
            if (aVar != null) {
                aVar.onFailed();
                return;
            }
            return;
        }
        try {
            com.kwad.sdk.core.d.c.w("TKLoadController", "addTKView isReuseTKContext: " + this.asW);
            if (this.asW) {
                b(styleTemplate, aVar);
            } else {
                c(styleTemplate, aVar);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
            m(th);
            if (aVar != null) {
                aVar.onFailed();
            }
        }
    }

    private static void a(t tVar, com.kwad.sdk.core.webview.c.a aVar) {
        tVar.c(aVar);
    }

    public final void a(String str, Object obj) {
        zj().put(str, obj);
    }

    @Override // com.kwad.sdk.core.webview.d.a.a
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        j jVar = this.asy;
        if (jVar != null) {
            jVar.a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(al.a aVar) {
        FrameLayout tKContainer = this.asy.getTKContainer();
        if (tKContainer != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tKContainer.getLayoutParams();
            layoutParams.height = com.kwad.sdk.c.a.a.a(this.mContext, aVar.height);
            layoutParams.leftMargin = com.kwad.sdk.c.a.a.a(this.mContext, aVar.leftMargin);
            layoutParams.rightMargin = com.kwad.sdk.c.a.a.a(this.mContext, aVar.rightMargin);
            layoutParams.bottomMargin = com.kwad.sdk.c.a.a.a(this.mContext, aVar.bottomMargin);
            layoutParams.width = -1;
            tKContainer.setLayoutParams(layoutParams);
        }
    }

    public am c(com.kwad.sdk.core.webview.b bVar) {
        return new am(bVar);
    }
}

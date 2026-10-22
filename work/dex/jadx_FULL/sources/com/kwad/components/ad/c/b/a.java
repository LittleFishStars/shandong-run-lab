package com.kwad.components.ad.c.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.c.c;
import com.kwad.components.ad.c.d.b;
import com.kwad.components.ad.c.e;
import com.kwad.components.ad.c.f;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.n.d;
import com.kwad.components.core.video.g;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.helper.SlideConvertHelper;
import com.kwad.sdk.core.response.helper.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@SuppressLint({"ViewConstructor"})
public final class a extends d<c> implements View.OnClickListener, com.kwad.sdk.widget.d {
    private boolean cA;
    private com.kwad.sdk.core.video.videoview.a cB;
    private e cC;
    private LinearLayout cD;
    private TextView cE;
    private TextView cF;
    private TextView cG;
    private ImageView cH;
    private KsLogoView cI;
    public InterfaceC1132a cJ;
    private com.kwad.sdk.core.video.videoview.a.InterfaceC1290a cK;
    private com.kwad.components.core.video.a.b cL;
    private OfflineOnAudioConflictListener cM;
    private KsAdVideoPlayConfig ce;
    private f cp;
    private List<Integer> cv;
    private FrameLayout cw;
    private ImageView cx;
    private LinearLayout cy;
    private ImageView cz;
    private AdInfo mAdInfo;
    private SceneImpl mAdScene;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;
    private Context mContext;
    private boolean mIsAudioEnable;

    /* JADX INFO: renamed from: com.kwad.components.ad.c.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC1132a {
        void a(int i, int i2, AdTemplate adTemplate);

        void d(AdTemplate adTemplate);

        void e(AdTemplate adTemplate);

        void o(String str);
    }

    public a(Context context, AdTemplate adTemplate, InterfaceC1132a interfaceC1132a) {
        super(context);
        this.mIsAudioEnable = true;
        this.cL = new com.kwad.components.core.video.a.b() { // from class: com.kwad.components.ad.c.b.a.1
            @Override // com.kwad.components.core.video.a.c
            public final void as() {
                com.kwad.sdk.core.video.videoview.a aVar = a.this.cB;
                a aVar2 = a.this;
                aVar.setVideoSoundEnable(aVar2.f(aVar2.mIsAudioEnable));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void at() {
                com.kwad.sdk.core.adlog.c.cu(((c) a.this.abm).mAdTemplate);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j) {
                a.this.c(j);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayError(int i, int i2) {
                InterfaceC1132a interfaceC1132a2 = a.this.cJ;
                if (interfaceC1132a2 != null) {
                    interfaceC1132a2.o(i + "," + i2);
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.sdk.core.adlog.c.ct(a.this.mAdTemplate);
            }
        };
        this.cM = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.c.b.a.2
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                a.b(a.this, false);
                if (a.this.cB != null) {
                    a.this.cB.setVideoSoundEnable(false);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        this.mAdTemplate = adTemplate;
        this.mAdScene = adTemplate.mAdScene;
        this.cJ = interfaceC1132a;
        this.mContext = getContext();
        tp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.n.d
    /* JADX INFO: renamed from: ao, reason: merged with bridge method [inline-methods] */
    public c an() {
        f fVar = new f(this.oC, (int) (com.kwad.sdk.core.config.e.Kd() * 100.0f));
        this.cp = fVar;
        fVar.Aa();
        c cVar = new c();
        cVar.setAdTemplate(this.mAdTemplate);
        cVar.mAdScene = this.mAdScene;
        cVar.mApkDownloadHelper = this.mApkDownloadHelper;
        return cVar;
    }

    private static Presenter ap() {
        Presenter presenter = new Presenter();
        presenter.a(new b());
        return presenter;
    }

    private boolean ar() {
        boolean z;
        boolean z2 = true;
        if (com.kwad.sdk.core.config.e.Kh() || !com.kwad.components.core.t.a.aO(this.mContext).wD()) {
            KsAdVideoPlayConfig ksAdVideoPlayConfig = this.ce;
            if (!(ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) || ((KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig).getVideoSoundValue() == 0) {
                if (com.kwad.sdk.core.response.helper.a.ce(this.mAdInfo)) {
                    z2 = false;
                }
                z = z2;
            } else {
                z = !this.ce.isVideoSoundEnable();
            }
        } else {
            z = z2;
        }
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            adTemplate.mIsAudioEnable = !z;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(boolean z) {
        if (!z) {
            return false;
        }
        if (com.kwad.sdk.core.config.e.Kh()) {
            if (!this.cA) {
                this.cA = com.kwad.components.core.t.a.aO(this.mContext).bd(true);
            }
            return this.cA;
        }
        if (com.kwad.components.core.t.a.aO(this.mContext).wE()) {
            return !com.kwad.components.core.t.a.aO(this.mContext).wD();
        }
        return com.kwad.components.core.t.a.aO(this.mContext).bd(false);
    }

    @Override // com.kwad.components.core.n.d, com.kwad.sdk.widget.KSFrameLayout
    public final void ae() {
        super.ae();
    }

    @Override // com.kwad.components.core.n.d
    public final boolean al() {
        return true;
    }

    public final void aq() {
        this.cw.setVisibility(0);
        this.cJ.d(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.n.d
    public final int getLayoutId() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics.widthPixels > displayMetrics.heightPixels ? R.layout.ksad_banner_item_land : R.layout.ksad_banner_item;
    }

    @Override // com.kwad.components.core.n.d
    public final void initData() {
        this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate);
        this.mApkDownloadHelper = new com.kwad.components.core.e.d.d(this.mAdTemplate);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.cw || view == this.cx || view == this.cB || view == this.cz) {
            this.cJ.a(100, 3, this.mAdTemplate);
            return;
        }
        if (view == this.cD || view == this.cy) {
            this.cJ.a(53, 2, this.mAdTemplate);
            return;
        }
        if (view == this.cE) {
            this.cJ.a(32, 2, this.mAdTemplate);
            return;
        }
        if (view == this.cF) {
            this.cJ.a(31, 2, this.mAdTemplate);
        } else if (view == this.cG) {
            this.cJ.a(29, 1, this.mAdTemplate);
        } else if (view == this.cH) {
            this.cJ.e(this.mAdTemplate);
        }
    }

    @Override // com.kwad.components.core.n.d
    @NonNull
    public final Presenter onCreatePresenter() {
        getContext();
        return ap();
    }

    public static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.cA = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) {
        int iCeil = (int) Math.ceil(j / 1000.0f);
        List<Integer> list = this.cv;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.cv.iterator();
        while (it.hasNext()) {
            if (iCeil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, iCeil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    @Override // com.kwad.components.core.n.d
    public final void a(@NonNull ViewGroup viewGroup) {
        FrameLayout frameLayout = (FrameLayout) this.oC.findViewById(R.id.ksad_banner_item_content);
        this.cw = frameLayout;
        frameLayout.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.oC.findViewById(R.id.ksad_banner_item_info);
        this.cD = linearLayout;
        linearLayout.setOnClickListener(this);
        TextView textView = (TextView) this.oC.findViewById(R.id.ksad_banner_item_des);
        this.cE = textView;
        textView.setText(com.kwad.sdk.core.response.helper.a.aA(this.mAdInfo));
        this.cE.setOnClickListener(this);
        TextView textView2 = (TextView) this.oC.findViewById(R.id.ksad_banner_item_title);
        this.cF = textView2;
        textView2.setText(com.kwad.sdk.core.response.helper.a.cs(this.mAdInfo));
        this.cF.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) this.oC.findViewById(R.id.ksad_banner_button_base);
        this.cy = linearLayout2;
        linearLayout2.setOnClickListener(this);
        TextView textView3 = (TextView) this.oC.findViewById(R.id.ksad_banner_item_button);
        this.cG = textView3;
        textView3.setText(com.kwad.sdk.core.response.helper.a.aK(this.mAdInfo));
        this.cG.setOnClickListener(this);
        ImageView imageView = (ImageView) this.oC.findViewById(R.id.ksad_banner_item_close);
        this.cH = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) this.oC.findViewById(R.id.ksad_banner_item_image);
        this.cx = imageView2;
        imageView2.setOnClickListener(this);
        ImageView imageView3 = (ImageView) this.oC.findViewById(R.id.ksad_banner_item_image_bg);
        this.cz = imageView3;
        imageView3.setOnClickListener(this);
        this.cI = (KsLogoView) this.oC.findViewById(R.id.ksad_banner_logo);
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.helper.a.M(this.mAdInfo)) && TextUtils.isEmpty(com.kwad.sdk.core.response.helper.a.ba(this.mAdInfo).materialUrl)) {
            int i = (int) ((this.mContext.getResources().getDisplayMetrics().density * 40.0f) + 0.5f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
            layoutParams.gravity = 17;
            this.cx.setLayoutParams(layoutParams);
            KSImageLoader.loadImage(this.cx, com.kwad.sdk.core.response.helper.a.cv(this.mAdInfo), this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setCornerRound(8).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.c.b.a.3
                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BitmapFactory.decodeStream(inputStream);
                    return true;
                }
            });
        } else if (!com.kwad.sdk.core.response.helper.a.bj(this.mAdInfo)) {
            this.cx.setScaleType(ImageView.ScaleType.CENTER_CROP);
            KSImageLoader.loadImage(this.cx, com.kwad.sdk.core.response.helper.a.bA(this.mAdInfo).getUrl(), this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.c.b.a.4
                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
            });
            this.cx.setOnClickListener(this);
        } else {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            AdInfo.AdMaterialInfo.MaterialFeature materialFeatureBa = com.kwad.sdk.core.response.helper.a.ba(this.mAdInfo);
            if (!TextUtils.isEmpty(materialFeatureBa.materialUrl)) {
                int i2 = materialFeatureBa.width;
                int i3 = materialFeatureBa.height;
                if (i2 > 0 && i2 < i3) {
                    this.cz.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    KSImageLoader.loadImage(this.cz, com.kwad.sdk.core.response.helper.a.Q(this.mAdInfo), this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.c.b.a.5
                        @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                            decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                            return true;
                        }
                    });
                    int i4 = (int) ((displayMetrics.density * 54.0f) + 0.5f);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((i4 / 16) * 9, i4);
                    layoutParams2.gravity = 5;
                    layoutParams2.rightMargin = (int) ((displayMetrics.density * 14.0f) + 0.5f);
                    this.cx.setLayoutParams(layoutParams2);
                }
            }
            KSImageLoader.loadImage(this.cx, com.kwad.sdk.core.response.helper.a.ba(this.mAdInfo).materialUrl, this.mAdTemplate);
        }
        this.cI.bl(this.mAdTemplate);
        this.cw.setVisibility(4);
    }

    public final void a(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        String strFx;
        if (ksAdVideoPlayConfig == null) {
            ksAdVideoPlayConfig = new KSAdVideoPlayConfigImpl();
        }
        this.ce = ksAdVideoPlayConfig;
        this.mIsAudioEnable = !ar();
        this.cv = com.kwad.sdk.core.response.helper.a.bv(this.mAdInfo);
        this.cB = new com.kwad.sdk.core.video.videoview.a(getContext());
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureBb = com.kwad.sdk.core.response.helper.a.bb(this.mAdInfo);
        if (!TextUtils.isEmpty(com.kwad.sdk.core.response.helper.a.Q(this.mAdInfo))) {
            int i = materialFeatureBb.width;
            int i2 = materialFeatureBb.height;
            if (i > 0 && i < i2) {
                int i3 = (int) ((displayMetrics.density * 54.0f) + 0.5f);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((i3 / 16) * 9, i3);
                layoutParams.gravity = 5;
                layoutParams.rightMargin = 14;
                this.cB.setLayoutParams(layoutParams);
            }
        }
        this.cB.setOnClickListener(this);
        int iGa = com.kwad.sdk.core.config.e.Ga();
        String strM = com.kwad.sdk.core.response.helper.a.M(this.mAdInfo);
        if (TextUtils.isEmpty(strM)) {
            return;
        }
        if (iGa < 0) {
            File fileCO = com.kwad.sdk.core.diskcache.b.a.Lx().cO(strM);
            if (fileCO == null || !fileCO.exists()) {
                strM = null;
            } else {
                strFx = fileCO.getAbsolutePath();
                strM = strFx;
            }
        } else if (iGa != 0) {
            com.kwad.sdk.core.videocache.f fVarCm = com.kwad.sdk.core.videocache.c.a.cm(this.mContext);
            if (com.kwad.sdk.core.config.e.Jn()) {
                int iGa2 = com.kwad.sdk.core.config.e.Ga();
                if (!fVarCm.fz(strM)) {
                    if (fVarCm.a(strM, iGa2 * 1024, new com.kwad.sdk.core.network.a.a.C1286a(), null)) {
                        strFx = fVarCm.fx(strM);
                    }
                } else {
                    strFx = fVarCm.fx(strM);
                }
                strM = strFx;
            } else {
                strM = fVarCm.fx(strM);
            }
        }
        if (TextUtils.isEmpty(strM)) {
            return;
        }
        this.cB.a(new com.kwad.sdk.contentalliance.a.a.b.a(this.mAdTemplate).dQ(strM).dR(h.b(com.kwad.sdk.core.response.helper.e.eP(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.a.a.a.cm(this.mAdTemplate)).IG(), null);
        com.kwad.sdk.core.video.videoview.a.InterfaceC1290a interfaceC1290a = new com.kwad.sdk.core.video.videoview.a.InterfaceC1290a() { // from class: com.kwad.components.ad.c.b.a.6
            @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC1290a
            public final com.kwad.sdk.core.video.a.c a(com.kwad.sdk.contentalliance.a.a.b bVar) {
                if (!((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aQq)).booleanValue() || !((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aQr)).booleanValue()) {
                    return null;
                }
                g gVar = new g(bVar, a.this.mAdTemplate);
                if (g.isWaynePlayerReady()) {
                    return gVar;
                }
                return null;
            }
        };
        this.cK = interfaceC1290a;
        this.cB.setExternalPlayerListener(interfaceC1290a);
        this.cB.setVideoSoundEnable(this.mIsAudioEnable);
        this.ce.setVideoAutoPlayType(com.kwad.sdk.core.response.helper.a.dA(this.mAdInfo));
        e eVar = new e(this.mContext, this.mAdTemplate, this.cB, this.ce);
        this.cC = eVar;
        eVar.setHideEnd(true);
        this.cC.setVideoPlayCallback(this.cL);
        this.cB.setController(this.cC);
        this.cw.addView(this.cB);
        this.oC.findViewById(R.id.ksad_banner_logo).bringToFront();
        this.cw.setClickable(true);
        this.cC.startPlay();
        new com.kwad.sdk.widget.h(getContext(), this.cw, this);
        if (this.mIsAudioEnable) {
            com.kwad.components.core.t.a.aO(this.mContext).a(this.cM);
        }
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        onClick(view);
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view, float f, float f2, float f3, float f4) {
        if (SlideConvertHelper.a(this.mAdTemplate, f, f2, f3, f4)) {
            onClick(view);
        }
    }
}

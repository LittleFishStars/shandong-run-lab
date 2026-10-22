package com.kc.cw.ad.internal.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.aliyun.auth.core.AliyunVodKey;
import com.kc.cw.ad.NativeAdResponse;
import com.kc.cw.ad.OnSensorListener;
import com.kc.cw.ad.SSAd;
import com.kc.cw.ad.d.i;
import com.kc.cw.ad.d.l;
import com.kc.cw.ad.internal.c.k;
import com.kc.cw.ad.internal.c.q;
import com.kc.cw.ad.internal.h;
import com.kc.cw.ad.internal.n;
import com.kc.cw.ad.internal.nativead.NativeAdEventListener;
import com.kc.cw.ad.internal.nativead.NativeAdShownListener;
import com.kc.cw.ad.internal.p;
import com.kc.cw.ad.internal.utilities.ImageManager;
import com.kc.cw.ad.internal.utilities.ViewUtil;
import com.kc.cw.ad.internal.video.VideoStateListener;
import com.kc.cw.ad.internal.y;
import com.kc.cw.ad.model.AdLogoInfo;
import com.kc.cw.ad.model.ComplianceInfo;
import com.kc.cw.ad.model.ShakeValue;
import com.kc.cw.ad.utils.ThreadUtils;
import com.kc.cw.ad.widget.RegionClickView;
import com.kc.openset.R;
import com.kc.openset.sdk.dsp.util.QdActivityType;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class e implements NativeAdResponse {
    private String C;
    private HashMap<String, Object> D;
    private AdLogoInfo K;
    private AdLogoInfo L;
    private f M;
    private c N;
    private Context O;
    private AppCompatTextView P;
    private com.kc.cw.ad.a.c.u Q;
    private l R;
    private View S;
    private VideoView T;
    private TextureView U;
    private ImageView V;
    private LinearLayout W;
    private MediaPlayer X;
    private ProgressBar Y;
    private Handler Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NativeAdResponse.b f38876a;
    private com.kc.cw.ad.internal.g aA;
    private h aB;
    private ArrayList<n> aC;
    private List<? extends View> aD;
    private OnSensorListener aE;
    private com.kc.cw.ad.b.a aF;
    private com.kc.cw.ad.a.c.b aG;
    private ComplianceInfo aH;
    private Runnable aa;
    private com.kc.cw.ad.a.a ab;
    private String ac;
    private boolean ad;
    private boolean ae;
    private boolean af;
    private boolean ag;
    private boolean ah;
    private boolean ai;
    private boolean al;
    private int am;
    private int ao;
    private ViewGroup ap;
    private View aq;
    private View ar;
    private List<View> as;
    private List<View> at;
    private NativeAdEventListener au;
    private VideoStateListener av;
    private View.OnClickListener aw;
    private View.OnTouchListener ax;
    private View.OnClickListener ay;
    private y az;
    private String b;
    private String c;
    private String d;
    private String e;
    private Bitmap f;
    private Bitmap g;
    private String h;
    private String i;
    private double j;
    private String k;
    private int l;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean s;
    private boolean t;
    private boolean v;
    private boolean w;
    private Boolean z;
    private boolean r = false;
    private boolean u = false;
    private int x = 0;
    private int y = 0;
    private boolean A = false;
    private boolean B = false;
    private boolean E = false;
    private final ArrayList<String> F = new ArrayList<>();
    private final ArrayList<String> G = new ArrayList<>();
    private final ArrayList<String> H = new ArrayList<>();
    private ArrayList<String> I = new ArrayList<>();
    private ArrayList<String> J = new ArrayList<>();
    private boolean aj = true;
    private boolean ak = true;
    private int an = 0;

    /* JADX INFO: renamed from: com.kc.cw.ad.internal.b.e$12, reason: invalid class name */
    @Keep
    public class AnonymousClass12 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final float f38880a;
        final ImageView b;
        final ImageView c;
        final TextView d;
        final ImageView e;
        final TextView f;
        final TextView g;
        final FrameLayout h;
        final ImageView i;
        final FrameLayout j;
        final e k;

        /* JADX INFO: renamed from: com.kc.cw.ad.internal.b.e$12$2, reason: invalid class name */
        @Keep
        public class AnonymousClass2 implements ImageManager.BitmapLoadedListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final AnonymousClass12 f38882a;

            /* JADX INFO: renamed from: com.kc.cw.ad.internal.b.e$12$2$1, reason: invalid class name */
            @Keep
            public class AnonymousClass1 implements com.kc.cw.ad.d.d.a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final Bitmap f38883a;
                final AnonymousClass2 b;

                public AnonymousClass1(AnonymousClass2 anonymousClass2, Bitmap bitmap) {
                    this.b = anonymousClass2;
                    this.f38883a = bitmap;
                }

                @Override // com.kc.cw.ad.d.d.a
                public void a(Bitmap bitmap) {
                    ThreadUtils.runOnUIThread(new Runnable(this, bitmap) { // from class: com.kc.cw.ad.internal.b.e.12.2.1.1

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        final Bitmap f38884a;
                        final AnonymousClass1 b;

                        {
                            this.b = this;
                            this.f38884a = bitmap;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (this.f38884a != null) {
                                    this.b.b.f38882a.i.setBackground(new BitmapDrawable(this.b.b.f38882a.k.O.getResources(), this.f38884a));
                                }
                                AnonymousClass1 anonymousClass1 = this.b;
                                anonymousClass1.b.f38882a.i.setImageBitmap(anonymousClass1.f38883a);
                                if (this.b.b.f38882a.k.Y != null) {
                                    this.b.b.f38882a.k.Y.setVisibility(8);
                                }
                                this.b.b.f38882a.k.w();
                            } catch (Exception e) {
                                if (this.b.b.f38882a.k.au != null) {
                                    this.b.b.f38882a.k.au.onAdRenderFailed(80101);
                                }
                                if (this.b.b.f38882a.k.M != null) {
                                    this.b.b.f38882a.k.M.a(e.getMessage());
                                }
                            }
                        }
                    });
                }
            }

            public AnonymousClass2(AnonymousClass12 anonymousClass12) {
                this.f38882a = anonymousClass12;
            }

            @Override // com.kc.cw.ad.internal.utilities.ImageManager.BitmapLoadedListener
            public void onBitmapLoadFailed() {
                if (this.f38882a.k.au != null) {
                    this.f38882a.k.au.onAdRenderFailed(80101);
                }
                if (this.f38882a.k.M != null) {
                    this.f38882a.k.M.a("onBitmapLoadFailed");
                }
            }

            @Override // com.kc.cw.ad.internal.utilities.ImageManager.BitmapLoadedListener
            public void onBitmapLoaded(Bitmap bitmap) {
                com.kc.cw.ad.d.d.a(this.f38882a.k.O, bitmap, new AnonymousClass1(this, bitmap));
            }
        }

        public AnonymousClass12(e eVar, float f, ImageView imageView, ImageView imageView2, TextView textView, ImageView imageView3, TextView textView2, TextView textView3, FrameLayout frameLayout, ImageView imageView4, FrameLayout frameLayout2) {
            this.k = eVar;
            this.f38880a = f;
            this.b = imageView;
            this.c = imageView2;
            this.d = textView;
            this.e = imageView3;
            this.f = textView2;
            this.g = textView3;
            this.h = frameLayout;
            this.i = imageView4;
            this.j = frameLayout2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.k.ap == null) {
                return;
            }
            if (this.k.am <= 0) {
                e eVar = this.k;
                eVar.am = eVar.aq.getWidth();
                if (this.k.am <= 0) {
                    e eVar2 = this.k;
                    eVar2.am = ViewUtil.getScreenWidth(eVar2.aq.getContext());
                    this.k.aq.getLayoutParams().width = this.k.am;
                }
                this.k.aq.getLayoutParams().height = (int) (this.k.am / this.f38880a);
            }
            Log.i("native_size", "adWidth:" + this.k.am + "  adHeight:" + this.k.aq.getLayoutParams().height);
            int iPx2dip = ViewUtil.px2dip(this.k.ap.getContext(), (float) this.k.am);
            float f = iPx2dip > 0 ? iPx2dip / 360.0f : 1.0f;
            float f2 = f <= 1.0f ? f : 1.0f;
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.b);
            arrayList.add(this.c);
            arrayList.add(this.d);
            arrayList.add(this.e);
            arrayList.add(this.f);
            arrayList.add(this.g);
            arrayList.add(this.k.Y);
            this.k.a((ArrayList<View>) arrayList, f2);
            if (this.k.aH != null) {
                e eVar3 = this.k;
                eVar3.P = ViewUtil.createComplianceView(eVar3.ap.getContext(), this.k.aH, f2, true);
                if (this.k.x == 3 || this.k.x == 4) {
                    this.k.P.post(new Runnable(this) { // from class: com.kc.cw.ad.internal.b.e.12.1

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        final AnonymousClass12 f38881a;

                        {
                            this.f38881a = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            this.f38881a.k.aq.getLayoutParams().height += this.f38881a.k.P.getHeight();
                        }
                    });
                }
            }
            if (this.k.isVideo()) {
                if (!this.k.getVideoUrls().isEmpty()) {
                    this.h.setBackgroundColor(-16777216);
                    if (this.k.ae) {
                        this.k.U.setVisibility(0);
                        this.k.q();
                    } else {
                        this.k.T.setVisibility(0);
                        this.k.p();
                    }
                }
            } else if (!TextUtils.isEmpty(this.k.getImageUrl())) {
                ImageManager.with(null).getBitmap(this.k.getImageUrl(), new AnonymousClass2(this));
            }
            this.k.a(this.j);
            this.k.a((ViewGroup) this.h);
            this.k.a(this.f);
            this.k.e();
            if (this.k.M != null) {
                this.g.setOnClickListener(new View.OnClickListener(this, q.a("https://www.adintl.cn/sdkFeedback.html?slotId=${SLOT_ID}&sdkVersion=${SDK_VERSION}&deviceId=${DEVICE_ID}", this.k.M.e(), SSAd.getOaid(this.k.O))) { // from class: com.kc.cw.ad.internal.b.e.12.3

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final String f38885a;
                    final AnonymousClass12 b;

                    {
                        this.b = this;
                        this.f38885a = str;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ViewUtil.openLocalBrowser(this.f38885a, 0);
                        if (this.b.k.M != null) {
                            this.b.k.M.c();
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: com.kc.cw.ad.internal.b.e$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements TextureView.SurfaceTextureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final e f38893a;

        public AnonymousClass2(e eVar) {
            this.f38893a = eVar;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            Surface surface = new Surface(surfaceTexture);
            this.f38893a.X = new MediaPlayer();
            this.f38893a.X.setSurface(surface);
            this.f38893a.X.setOnCompletionListener(new MediaPlayer.OnCompletionListener(this) { // from class: com.kc.cw.ad.internal.b.e.2.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final AnonymousClass2 f38894a;

                {
                    this.f38894a = this;
                }

                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) {
                    this.f38894a.f38893a.ai = true;
                    this.f38894a.f38893a.ao = 0;
                    if (this.f38894a.f38893a.M != null) {
                        this.f38894a.f38893a.M.aj();
                    }
                    if (this.f38894a.f38893a.av != null) {
                        this.f38894a.f38893a.av.onVideoCompleted();
                    }
                }
            });
            this.f38893a.X.setOnErrorListener(new MediaPlayer.OnErrorListener(this) { // from class: com.kc.cw.ad.internal.b.e.2.2

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final AnonymousClass2 f38895a;

                {
                    this.f38895a = this;
                }

                @Override // android.media.MediaPlayer.OnErrorListener
                public boolean onError(MediaPlayer mediaPlayer, int i3, int i4) {
                    if (this.f38895a.f38893a.av == null) {
                        return true;
                    }
                    this.f38895a.f38893a.av.onVideoError(i3, i4);
                    return true;
                }
            });
            this.f38893a.X.setOnPreparedListener(new MediaPlayer.OnPreparedListener(this) { // from class: com.kc.cw.ad.internal.b.e.2.3

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final AnonymousClass2 f38896a;

                {
                    this.f38896a = this;
                }

                @Override // android.media.MediaPlayer.OnPreparedListener
                public void onPrepared(MediaPlayer mediaPlayer) {
                    this.f38896a.f38893a.s();
                    float fG = com.kc.cw.ad.internal.q.a().g();
                    if (this.f38896a.f38893a.M != null && this.f38896a.f38893a.M.A() && com.kc.cw.ad.internal.q.a().h()) {
                        mediaPlayer.setVolume(0.0f, 0.0f);
                    } else {
                        if (fG <= 0.0f) {
                            fG = 1.0f;
                        }
                        mediaPlayer.setVolume(fG, fG);
                    }
                    if (this.f38896a.f38893a.Y != null) {
                        this.f38896a.f38893a.Y.setVisibility(8);
                    }
                    if (this.f38896a.f38893a.M != null) {
                        this.f38896a.f38893a.M.ah();
                    }
                    if (this.f38896a.f38893a.av != null) {
                        this.f38896a.f38893a.av.onVideoStart();
                    }
                    this.f38896a.f38893a.t();
                    this.f38896a.f38893a.w();
                    this.f38896a.f38893a.r();
                }
            });
            this.f38893a.d();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            if (this.f38893a.Z != null) {
                this.f38893a.Z.removeCallbacksAndMessages(null);
                this.f38893a.Z = null;
            }
            if (this.f38893a.X != null) {
                this.f38893a.X.release();
                this.f38893a.X = null;
            }
            this.f38893a.aa = null;
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* JADX INFO: renamed from: com.kc.cw.ad.internal.b.e$8, reason: invalid class name */
    @Keep
    public class AnonymousClass8 implements ImageManager.BitmapLoadedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f38912a;
        final e b;

        /* JADX INFO: renamed from: com.kc.cw.ad.internal.b.e$8$1, reason: invalid class name */
        @Keep
        public class AnonymousClass1 implements com.kc.cw.ad.d.d.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Bitmap f38913a;
            final AnonymousClass8 b;

            public AnonymousClass1(AnonymousClass8 anonymousClass8, Bitmap bitmap) {
                this.b = anonymousClass8;
                this.f38913a = bitmap;
            }

            @Override // com.kc.cw.ad.d.d.a
            public void a(Bitmap bitmap) {
                ThreadUtils.runOnUIThread(new Runnable(this, bitmap) { // from class: com.kc.cw.ad.internal.b.e.8.1.1

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final Bitmap f38914a;
                    final AnonymousClass1 b;

                    {
                        this.b = this;
                        this.f38914a = bitmap;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (this.f38914a != null) {
                                this.b.b.b.V.setBackground(new BitmapDrawable(this.b.b.f38912a.getResources(), this.f38914a));
                            }
                            this.b.b.b.V.setImageBitmap(this.b.f38913a);
                        } catch (Exception e) {
                            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
                        }
                    }
                });
            }
        }

        public AnonymousClass8(e eVar, Context context) {
            this.b = eVar;
            this.f38912a = context;
        }

        @Override // com.kc.cw.ad.internal.utilities.ImageManager.BitmapLoadedListener
        public void onBitmapLoadFailed() {
        }

        @Override // com.kc.cw.ad.internal.utilities.ImageManager.BitmapLoadedListener
        public void onBitmapLoaded(Bitmap bitmap) {
            com.kc.cw.ad.d.d.a(this.f38912a, bitmap, new AnonymousClass1(this, bitmap));
        }
    }

    private void A() {
        this.aw = new View.OnClickListener(this) { // from class: com.kc.cw.ad.internal.b.e.20

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final e f38897a;

            {
                this.f38897a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e eVar = this.f38897a;
                eVar.a(eVar.v());
            }
        };
    }

    private void B() {
        this.ax = new com.kc.cw.ad.internal.e.h(this.ap, this.A, new com.kc.cw.ad.internal.e.h.a(this) { // from class: com.kc.cw.ad.internal.b.e.21

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final e f38898a;

            {
                this.f38898a = this;
            }

            @Override // com.kc.cw.ad.internal.e.h.a
            public void a(View view, com.kc.cw.ad.a.d dVar) {
                this.f38898a.a(dVar);
            }
        });
    }

    private void C() {
        this.ay = new View.OnClickListener(this) { // from class: com.kc.cw.ad.internal.b.e.22

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final e f38899a;

            {
                this.f38899a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (this.f38899a.M != null) {
                    e eVar = this.f38899a;
                    eVar.B = eVar.M.T();
                }
                if (this.f38899a.B && !this.f38899a.p) {
                    this.f38899a.y = 2;
                    e eVar2 = this.f38899a;
                    eVar2.a(eVar2.v());
                    return;
                }
                if (this.f38899a.au != null) {
                    this.f38899a.au.onAdClose();
                }
                if (this.f38899a.M != null) {
                    this.f38899a.M.ac();
                }
                if (this.f38899a.ap != null) {
                    if (this.f38899a.ah) {
                        this.f38899a.ap.removeAllViews();
                    } else {
                        ViewUtil.removeChildFromParent(this.f38899a.ap);
                    }
                }
                this.f38899a.destroy();
            }
        };
    }

    public static e a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        ArrayList<String> arrayListA = k.a(k.a(jSONObject, "ImpressionTrackers"));
        e eVar = new e();
        if (arrayListA != null) {
            eVar.I = arrayListA;
        }
        eVar.b = k.c(jSONObject, "Headline");
        eVar.c = k.c(jSONObject, "Body");
        eVar.d = k.c(jSONObject, "Image");
        eVar.x = k.d(jSONObject, "LayoutType");
        eVar.t = k.f(jSONObject, "IsShowClose");
        JSONArray jSONArrayA = k.a(jSONObject, "Images");
        JSONArray jSONArrayA2 = k.a(jSONObject, "Videos");
        JSONArray jSONArrayA3 = k.a(jSONObject, "Texts");
        if (jSONArrayA != null) {
            for (int i = 0; i < jSONArrayA.length(); i++) {
                eVar.F.add((String) jSONArrayA.get(i));
            }
        }
        if (jSONArrayA2 != null) {
            for (int i2 = 0; i2 < jSONArrayA2.length(); i2++) {
                eVar.G.add((String) jSONArrayA2.get(i2));
            }
        }
        if (jSONArrayA3 != null) {
            for (int i3 = 0; i3 < jSONArrayA3.length(); i3++) {
                eVar.H.add((String) jSONArrayA3.get(i3));
            }
        }
        if (jSONObject.has("AppIcon")) {
            eVar.f38876a = NativeAdResponse.b.APP_INSTALL;
            eVar.e = k.c(jSONObject, "AppIcon");
            eVar.i = k.c(jSONObject, AliyunVodKey.KEY_VOD_ACTION);
            eVar.j = k.e(jSONObject, "Star");
            eVar.k = k.c(jSONObject, "Store");
            eVar.l = k.d(jSONObject, "Price");
        } else {
            eVar.f38876a = NativeAdResponse.b.CONTENT;
            eVar.e = k.c(jSONObject, "Logo");
            eVar.i = k.c(jSONObject, AliyunVodKey.KEY_VOD_ACTION);
            eVar.C = k.c(jSONObject, "Advertiser");
        }
        ArrayList<String> arrayListA2 = k.a(k.a(jSONObject, "ClickTrackers"));
        if (arrayListA2 != null) {
            eVar.J = arrayListA2;
        }
        eVar.D = k.a(k.b(jSONObject, TypedValues.Custom.NAME));
        return eVar;
    }

    private void a(float f) {
        View view;
        if (this.ap == null || (view = this.aq) == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_container);
        ImageView imageView = (ImageView) this.aq.findViewById(R.id.ad_image);
        TextView textView = (TextView) this.aq.findViewById(R.id.ad_feedback);
        FrameLayout frameLayout2 = (FrameLayout) this.aq.findViewById(R.id.ad_compliance);
        ImageView imageView2 = (ImageView) this.aq.findViewById(R.id.ad_logo);
        ImageView imageView3 = (ImageView) this.aq.findViewById(R.id.ad_logo_text);
        ImageView imageView4 = (ImageView) this.aq.findViewById(R.id.ad_close);
        TextView textView2 = (TextView) this.aq.findViewById(R.id.ad_title);
        TextView textView3 = (TextView) this.aq.findViewById(R.id.ad_action);
        this.T = (VideoView) this.aq.findViewById(R.id.ad_video);
        this.U = (TextureView) this.aq.findViewById(R.id.ad_texture);
        this.Y = (ProgressBar) this.aq.findViewById(R.id.ad_loading);
        if (!TextUtils.isEmpty(getTitle())) {
            textView2.setText(getTitle());
        }
        if (!TextUtils.isEmpty(getButtonText())) {
            textView3.setText(getButtonText());
        }
        if (TextUtils.isEmpty(getLogoUrl()) || !getLogoUrl().endsWith("octlogo.png")) {
            ImageManager.with(null).load(getLogoUrl()).into(imageView2);
        } else {
            imageView2.setImageResource(R.drawable.ss_logo);
        }
        if (TextUtils.isEmpty(getTextLogoUrl()) || !getTextLogoUrl().endsWith("remdad.png")) {
            ImageManager.with(null).load(getTextLogoUrl()).into(imageView3);
        } else {
            imageView3.setImageResource(R.drawable.ss_logo_text);
        }
        this.as = new ArrayList();
        if (this.t) {
            imageView4.setVisibility(0);
            ArrayList arrayList = new ArrayList();
            this.at = arrayList;
            arrayList.add(imageView4);
        } else {
            imageView4.setVisibility(8);
        }
        if (this.am == 0) {
            this.al = true;
        }
        if (this.al) {
            this.ap.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this, f) { // from class: com.kc.cw.ad.internal.b.e.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final float f38877a;
                final e b;

                {
                    this.b = this;
                    this.f38877a = f;
                }

                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    try {
                        if (this.b.ap != null) {
                            this.b.ap.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            int width = this.b.ap.getWidth();
                            if (width <= 0 || width == this.b.am) {
                                return;
                            }
                            this.b.aq.getLayoutParams().width = width;
                            this.b.aq.getLayoutParams().height = (int) (width / this.f38877a);
                        }
                    } catch (Exception e) {
                        com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
                    }
                }
            });
        }
        this.ap.post(new AnonymousClass12(this, f, imageView2, imageView3, textView2, imageView4, textView3, textView, frameLayout, imageView, frameLayout2));
    }

    private void a(int i, float f) {
        ViewGroup viewGroup = this.ap;
        if (viewGroup == null) {
            NativeAdEventListener nativeAdEventListener = this.au;
            if (nativeAdEventListener != null) {
                nativeAdEventListener.onAdRenderFailed(80101);
            }
            f fVar = this.M;
            if (fVar != null) {
                fVar.a("AdContainer is null");
                return;
            }
            return;
        }
        try {
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(i, (ViewGroup) null);
            this.aq = viewInflate;
            if (this.am > 0) {
                int i2 = this.am;
                this.ap.addView(this.aq, new ViewGroup.LayoutParams(i2, (int) (i2 / f)));
            } else {
                this.ap.addView(viewInflate);
            }
            a(f);
        } catch (Exception e) {
            NativeAdEventListener nativeAdEventListener2 = this.au;
            if (nativeAdEventListener2 != null) {
                nativeAdEventListener2.onAdRenderFailed(80101);
            }
            f fVar2 = this.M;
            if (fVar2 != null) {
                fVar2.a(e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        com.kc.cw.ad.a.c.o oVarK;
        com.kc.cw.ad.a.c.r rVarB;
        f fVar = this.M;
        if (fVar == null || fVar.m() != p.DRAW || (oVarK = this.M.K()) == null || (rVarB = oVarK.b()) == null || rVarB.a() != 1) {
            return;
        }
        a(view, rVarB.b());
    }

    private void a(View view, String str) {
        View view2;
        try {
            if (this.ap != null && (view2 = this.aq) != null) {
                RegionClickView regionClickView = (RegionClickView) view2.findViewById(R.id.regionClickView);
                if (TextUtils.isEmpty(str)) {
                    str = "点击跳转至第三方应用或详情页";
                }
                regionClickView.setTitle(str);
                regionClickView.setVisibility(0);
                this.as.add(view);
                this.as.add(regionClickView);
                o();
            }
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.c("OctopusAd", "An Exception Caught: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ViewGroup viewGroup) {
        com.kc.cw.ad.a.c.u uVar;
        int i;
        float f;
        if (viewGroup == null || (uVar = this.Q) == null || uVar.a() != 1) {
            return;
        }
        int i2 = this.x;
        if (i2 == 3 || i2 == 4) {
            i = 130;
            f = 13.0f;
        } else {
            i = 100;
            f = 10.0f;
        }
        addShakeView(viewGroup, i, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ViewGroup viewGroup, int i, float f) {
        com.kc.cw.ad.a.c.u uVar;
        String str;
        if (viewGroup != null) {
            try {
                com.kc.cw.ad.a.c.u uVar2 = this.Q;
                if (uVar2 == null) {
                    return;
                }
                if (TextUtils.isEmpty(uVar2.e())) {
                    if (this.Q.h() == 0) {
                        uVar = this.Q;
                        str = "摇动或点击了解更多";
                    } else {
                        uVar = this.Q;
                        str = "转动或点击了解更多";
                    }
                    uVar.a(str);
                }
                if (this.R == null) {
                    b(viewGroup);
                }
                this.R.a("50%", "50%", i + "", i + "");
                if (this.M != null) {
                    this.S = this.R.a(this.ap, viewGroup, f, this.Q.e(), this.M.m(), this.aj);
                }
                if (this.S != null) {
                    if (this.Q.b() == 1) {
                        this.y = 7;
                    }
                    if (this.Q.g() == 1) {
                        c(viewGroup);
                    }
                    if (this.Q.i() != 1) {
                        this.S.setOnClickListener(null);
                    } else {
                        this.S.setOnClickListener(this.aw);
                        this.S.setOnTouchListener(this.ax);
                    }
                }
            } catch (Exception e) {
                com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FrameLayout frameLayout) {
        AppCompatTextView appCompatTextView;
        if (frameLayout == null || (appCompatTextView = this.P) == null) {
            return;
        }
        ViewUtil.removeChildFromParent(appCompatTextView);
        frameLayout.addView(this.P, new FrameLayout.LayoutParams(-1, -2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kc.cw.ad.a.d dVar) {
        if (this.ad || this.n || this.r) {
            boolean z = false;
            if (System.currentTimeMillis() - l.f38820a <= 2000) {
                this.q = false;
                this.y = 0;
                return;
            }
            this.p = true;
            x();
            c cVar = this.N;
            boolean z2 = cVar != null && cVar.h();
            NativeAdEventListener nativeAdEventListener = this.au;
            if (nativeAdEventListener != null && z2) {
                Boolean bool = Boolean.TRUE;
                Boolean bool2 = this.z;
                if (bool == bool2 || (Boolean.FALSE != bool2 && !this.q && !this.A && !this.B)) {
                    z = true;
                }
            }
            if (z) {
                nativeAdEventListener.onAdClick();
            }
            f fVar = this.M;
            if (fVar != null) {
                fVar.b(z);
                int i = this.an + 1;
                this.an = i;
                this.M.a(this.O, this.y, this.n, this.r, z2, dVar, i);
            }
            l.f38820a = System.currentTimeMillis();
        }
    }

    private void a(NativeAdShownListener nativeAdShownListener) {
        StringBuilder sb;
        String str;
        if (this.E || this.ap == null) {
            return;
        }
        y yVar = this.az;
        if (yVar != null) {
            yVar.c();
        }
        Object tag = this.ap.getTag(55665918);
        if (tag instanceof y) {
            ((y) tag).c();
        }
        y yVarA = y.a(this.ap);
        this.az = yVarA;
        this.ap.setTag(55665918, yVarA);
        if (this.az == null) {
            return;
        }
        if (this.N != null) {
            this.aB = h.a(this.ap, (NativeAdShownListener) null);
            this.aC = new ArrayList<>();
            for (String string : this.I) {
                if (string.contains("?rv=1")) {
                    ViewUtil.openLocalBrowser(string, 0);
                } else {
                    if (string.contains("track=oct")) {
                        if (this.N.h()) {
                            f fVar = this.M;
                            if (fVar != null && !fVar.Q()) {
                                sb = new StringBuilder();
                                sb.append(string);
                                str = "&opt=11";
                            }
                        } else {
                            sb = new StringBuilder();
                            sb.append(string);
                            str = "&opt=4";
                        }
                        sb.append(str);
                        string = sb.toString();
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    com.kc.cw.ad.internal.d dVarJ = this.N.j();
                    if (dVarJ != null) {
                        jCurrentTimeMillis = dVarJ.h();
                    }
                    n nVarA = n.a(QdActivityType.IMP, this.N.d(), f(), jCurrentTimeMillis, string, this.az, this.ap.getContext(), this.I);
                    if (nVarA != null && string.contains("track=octimp")) {
                        nVarA.a(new com.kc.cw.ad.internal.c.d.a(this, nativeAdShownListener) { // from class: com.kc.cw.ad.internal.b.e.9

                            /* JADX INFO: renamed from: a, reason: collision with root package name */
                            final NativeAdShownListener f38915a;
                            final e b;

                            {
                                this.b = this;
                                this.f38915a = nativeAdShownListener;
                            }

                            @Override // com.kc.cw.ad.internal.c.d.a
                            public void a(int i, boolean z, String str2) {
                                if (this.f38915a != null) {
                                    if (z && this.b.N != null) {
                                        z = this.b.N.h();
                                    }
                                    this.f38915a.onAdShown(z);
                                }
                            }
                        });
                    }
                    if (nVarA != null) {
                        this.aC.add(nVarA);
                    }
                }
            }
        } else {
            this.ad = true;
        }
        this.ar = this.ap;
        f fVar2 = this.M;
        if (fVar2 == null || this.v) {
            return;
        }
        this.v = true;
        com.kc.cw.ad.internal.e.a.a(fVar2, new com.kc.cw.ad.internal.e.a.c(this) { // from class: com.kc.cw.ad.internal.b.e.10

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final e f38878a;

            {
                this.f38878a = this;
            }

            @Override // com.kc.cw.ad.internal.e.a.c
            public void a() {
                e eVar;
                int i;
                if (this.f38878a.o || this.f38878a.p || this.f38878a.ar == null || this.f38878a.M == null) {
                    return;
                }
                if (com.kc.cw.ad.internal.e.a.a(this.f38878a.M)) {
                    i = 0;
                    this.f38878a.q = false;
                    eVar = this.f38878a;
                } else {
                    this.f38878a.q = true;
                    eVar = this.f38878a;
                    i = 9;
                }
                eVar.y = i;
                e eVar2 = this.f38878a;
                eVar2.a(eVar2.v());
            }
        });
        this.z = this.M.R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ArrayList<View> arrayList, float f) {
        View next;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator<View> it = arrayList.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (next instanceof TextView) {
                TextView textView = (TextView) next;
                textView.setTextSize(0, textView.getTextSize() * f);
            } else {
                next.post(new Runnable(this, next, f) { // from class: com.kc.cw.ad.internal.b.e.24

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final View f38901a;
                    final float b;
                    final e c;

                    {
                        this.c = this;
                        this.f38901a = next;
                        this.b = f;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        ViewGroup.LayoutParams layoutParams = this.f38901a.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = (int) (this.f38901a.getWidth() * this.b);
                            layoutParams.height = (int) (this.f38901a.getHeight() * this.b);
                            this.f38901a.setLayoutParams(layoutParams);
                        }
                    }
                });
            }
        }
    }

    private View b(Context context) {
        if (this.V == null) {
            this.V = new ImageView(context);
            ImageManager.with(context).getBitmap(getImageUrl(), new AnonymousClass8(this, context));
        }
        return this.V;
    }

    private void b(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        if (this.R == null) {
            l lVar = new l(viewGroup.getContext());
            this.R = lVar;
            lVar.a(this.Q);
            this.R.a(viewGroup);
            this.R.a(new l.a(this) { // from class: com.kc.cw.ad.internal.b.e.6

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final e f38910a;

                {
                    this.f38910a = this;
                }

                @Override // com.kc.cw.ad.d.l.a
                public void a(com.kc.cw.ad.a.d dVar) {
                    this.f38910a.a(dVar);
                    if (this.f38910a.aE != null) {
                        this.f38910a.aE.onShakeTrigger(1, dVar.o(), dVar.p());
                    }
                }
            });
        }
        this.R.b();
    }

    private void c(ViewGroup viewGroup) {
        View view;
        if (viewGroup == null || (view = this.S) == null) {
            return;
        }
        ViewUtil.removeChildFromParent(view);
        if (!(viewGroup instanceof RelativeLayout)) {
            viewGroup.addView(this.S);
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        viewGroup.addView(this.S, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z) {
        NativeAdEventListener nativeAdEventListener;
        f fVar;
        if (this.ad) {
            return;
        }
        this.ad = true;
        if (z && (fVar = this.M) != null) {
            z = fVar.Q();
        }
        if (z && (nativeAdEventListener = this.au) != null) {
            nativeAdEventListener.onADExposed();
        }
        f fVar2 = this.M;
        if (fVar2 != null) {
            fVar2.a(this.ab, z);
        }
        if (this.ab == null || !f().equals(this.ab.a())) {
            return;
        }
        com.kc.cw.ad.internal.q.a().l.remove(this.ab.b());
    }

    private void j() {
        int i;
        if (this.ap == null) {
            NativeAdEventListener nativeAdEventListener = this.au;
            if (nativeAdEventListener != null) {
                nativeAdEventListener.onAdRenderFailed(80101);
            }
            f fVar = this.M;
            if (fVar != null) {
                fVar.a("AdContainer is null");
                return;
            }
            return;
        }
        u();
        int i2 = this.x;
        float f = 1.4f;
        if (i2 == 1) {
            i = R.layout.ss_native_text_above_img;
        } else if (i2 != 2) {
            f = 4.74f;
            if (i2 == 3) {
                i = R.layout.ss_native_text_right_img;
            } else {
                if (i2 != 4) {
                    a(R.layout.ss_native_one_img, 1.78f);
                    return;
                }
                i = R.layout.ss_native_text_left_img;
            }
        } else {
            i = R.layout.ss_native_text_below_img;
        }
        a(i, f);
    }

    private void k() {
        if (this.ap != null) {
            e();
            u();
            return;
        }
        NativeAdEventListener nativeAdEventListener = this.au;
        if (nativeAdEventListener != null) {
            nativeAdEventListener.onAdRenderFailed(80101);
        }
        f fVar = this.M;
        if (fVar != null) {
            fVar.a("AdContainer is null");
        }
    }

    private void l() {
        if (this.ap != null) {
            u();
            View viewInflate = LayoutInflater.from(this.ap.getContext()).inflate(R.layout.ss_layout_draw, this.ap);
            this.aq = viewInflate;
            this.am = ViewUtil.getScreenWidth(viewInflate.getContext());
            a(1.0f);
            return;
        }
        NativeAdEventListener nativeAdEventListener = this.au;
        if (nativeAdEventListener != null) {
            nativeAdEventListener.onAdRenderFailed(80101);
        }
        f fVar = this.M;
        if (fVar != null) {
            fVar.a("AdContainer is null");
        }
    }

    private void m() {
        if (this.ap != null) {
            u();
            a(isVideo() ? R.layout.ss_layout_banner_video : R.layout.ss_layout_banner, 6.4f);
            return;
        }
        NativeAdEventListener nativeAdEventListener = this.au;
        if (nativeAdEventListener != null) {
            nativeAdEventListener.onAdRenderFailed(80101);
        }
        f fVar = this.M;
        if (fVar != null) {
            fVar.a("AdContainer is null");
        }
    }

    private void n() {
        com.kc.cw.ad.a.c.o oVarK;
        ViewGroup viewGroup;
        f fVar = this.M;
        if (fVar == null || (oVarK = fVar.K()) == null) {
            return;
        }
        com.kc.cw.ad.a.c.m mVarA = oVarK.a();
        if (this.M.m() == p.DRAW) {
            if (mVarA == null || mVarA.a() != 1 || (viewGroup = this.ap) == null) {
                return;
            }
        } else if ((mVarA != null && mVarA.a() != 1) || (viewGroup = this.ap) == null) {
            return;
        }
        viewGroup.setOnClickListener(this.aw);
        this.ap.setOnTouchListener(this.ax);
    }

    private void o() {
        ViewGroup viewGroup = this.ap;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(new View.OnClickListener(this) { // from class: com.kc.cw.ad.internal.b.e.23

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final e f38900a;

                {
                    this.f38900a = this;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    VideoStateListener videoStateListener;
                    VideoStateListener videoStateListener2;
                    try {
                        if (this.f38900a.isVideo()) {
                            if (this.f38900a.ae) {
                                if (this.f38900a.X != null) {
                                    if (this.f38900a.X.isPlaying()) {
                                        this.f38900a.X.pause();
                                        this.f38900a.u = true;
                                        if (this.f38900a.av != null) {
                                            videoStateListener2 = this.f38900a.av;
                                            videoStateListener2.onVideoPause();
                                            return;
                                        }
                                        return;
                                    }
                                    this.f38900a.X.start();
                                    this.f38900a.u = false;
                                    if (this.f38900a.av != null) {
                                        videoStateListener = this.f38900a.av;
                                        videoStateListener.onVideoResume();
                                    }
                                    return;
                                }
                                return;
                            }
                            if (this.f38900a.T != null) {
                                if (this.f38900a.T.isPlaying()) {
                                    this.f38900a.T.pause();
                                    this.f38900a.u = true;
                                    if (this.f38900a.av != null) {
                                        videoStateListener2 = this.f38900a.av;
                                        videoStateListener2.onVideoPause();
                                        return;
                                    }
                                    return;
                                }
                                this.f38900a.T.start();
                                this.f38900a.u = false;
                                if (this.f38900a.av != null) {
                                    videoStateListener = this.f38900a.av;
                                    videoStateListener.onVideoResume();
                                }
                            }
                        }
                    } catch (Exception e) {
                        com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.T == null) {
            return;
        }
        this.Z = new Handler();
        this.aa = new Runnable(this) { // from class: com.kc.cw.ad.internal.b.e.25

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final e f38902a;

            {
                this.f38902a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i;
                if (this.f38902a.T == null || this.f38902a.T.getDuration() <= 0) {
                    return;
                }
                int duration = this.f38902a.T.getDuration();
                e eVar = this.f38902a;
                eVar.ao = eVar.T.getCurrentPosition();
                if (!this.f38902a.T.isPlaying()) {
                    if (this.f38902a.ao <= 0 || this.f38902a.ai || this.f38902a.M == null) {
                        return;
                    }
                    this.f38902a.M.ai();
                    return;
                }
                this.f38902a.t();
                com.kc.cw.ad.d.b.f.a("OctopusAd", "currentPosition:" + this.f38902a.ao + WVNativeCallbackUtil.SEPERATER + duration);
                if (this.f38902a.ao / 1000 == duration / 4000) {
                    i = 1;
                } else if (this.f38902a.ao / 1000 == duration / 2000) {
                    i = 2;
                } else {
                    i = this.f38902a.ao / 1000 == (duration * 3) / 4000 ? 3 : 0;
                }
                if (i > 0 && this.f38902a.M != null) {
                    this.f38902a.M.c(i);
                }
                com.kc.cw.ad.d.b.f.a("OctopusAd", "video progress:" + i);
            }
        };
        this.T.setOnCompletionListener(new MediaPlayer.OnCompletionListener(this) { // from class: com.kc.cw.ad.internal.b.e.26

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final e f38903a;

            {
                this.f38903a = this;
            }

            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                this.f38903a.ai = true;
                this.f38903a.ao = 0;
                if (this.f38903a.M != null) {
                    this.f38903a.M.aj();
                }
                if (this.f38903a.av != null) {
                    this.f38903a.av.onVideoCompleted();
                }
            }
        });
        this.T.setOnErrorListener(new MediaPlayer.OnErrorListener(this) { // from class: com.kc.cw.ad.internal.b.e.27

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final e f38904a;

            {
                this.f38904a = this;
            }

            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                if (this.f38904a.av == null) {
                    return true;
                }
                this.f38904a.av.onVideoError(i, i2);
                return true;
            }
        });
        this.T.setOnPreparedListener(new MediaPlayer.OnPreparedListener(this) { // from class: com.kc.cw.ad.internal.b.e.28

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final e f38905a;

            {
                this.f38905a = this;
            }

            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                float fG = com.kc.cw.ad.internal.q.a().g();
                if (this.f38905a.M != null && this.f38905a.M.A() && com.kc.cw.ad.internal.q.a().h() && this.f38905a.ak) {
                    mediaPlayer.setVolume(0.0f, 0.0f);
                } else {
                    if (fG <= 0.0f) {
                        fG = 1.0f;
                    }
                    mediaPlayer.setVolume(fG, fG);
                }
                if (this.f38905a.Y != null) {
                    this.f38905a.Y.setVisibility(8);
                }
                if (this.f38905a.M != null) {
                    this.f38905a.M.ah();
                }
                if (this.f38905a.av != null) {
                    this.f38905a.av.onVideoStart();
                }
                this.f38905a.t();
                this.f38905a.w();
                this.f38905a.r();
            }
        });
        this.T.getHolder().addCallback(new SurfaceHolder.Callback(this) { // from class: com.kc.cw.ad.internal.b.e.29

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final e f38906a;

            {
                this.f38906a = this;
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                if (this.f38906a.T == null || this.f38906a.T.isPlaying()) {
                    return;
                }
                if (this.f38906a.ao > 0) {
                    this.f38906a.T.seekTo(this.f38906a.ao);
                }
                this.f38906a.T.start();
                if (this.f38906a.Y != null) {
                    this.f38906a.Y.setVisibility(0);
                }
                if (this.f38906a.av != null) {
                    this.f38906a.av.onVideoReady();
                }
            }

            @Override // android.view.SurfaceHolder.Callback
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            }
        });
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        TextureView textureView = this.U;
        if (textureView == null) {
            return;
        }
        textureView.setSurfaceTextureListener(new AnonymousClass2(this));
        this.Z = new Handler();
        this.aa = new Runnable(this) { // from class: com.kc.cw.ad.internal.b.e.3

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final e f38907a;

            {
                this.f38907a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i;
                if (this.f38907a.X == null || this.f38907a.X.getDuration() <= 0) {
                    return;
                }
                int duration = this.f38907a.X.getDuration();
                e eVar = this.f38907a;
                eVar.ao = eVar.X.getCurrentPosition();
                if (!this.f38907a.X.isPlaying()) {
                    if (this.f38907a.ao <= 0 || this.f38907a.ai || this.f38907a.M == null) {
                        return;
                    }
                    this.f38907a.M.ai();
                    return;
                }
                this.f38907a.t();
                com.kc.cw.ad.d.b.f.a("OctopusAd", "currentPosition:" + this.f38907a.ao + WVNativeCallbackUtil.SEPERATER + duration);
                if (this.f38907a.ao / 1000 == duration / 4000) {
                    i = 1;
                } else if (this.f38907a.ao / 1000 == duration / 2000) {
                    i = 2;
                } else {
                    i = this.f38907a.ao / 1000 == (duration * 3) / 4000 ? 3 : 0;
                }
                if (i > 0 && this.f38907a.M != null) {
                    this.f38907a.M.c(i);
                }
                com.kc.cw.ad.d.b.f.a("OctopusAd", "video progress:" + i);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        f fVar;
        if (this.ap == null || (fVar = this.M) == null || fVar.m() != p.DRAW || this.aA != null) {
            return;
        }
        this.aA = com.kc.cw.ad.internal.g.a(this.ap, new NativeAdShownListener(this) { // from class: com.kc.cw.ad.internal.b.e.4

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final e f38908a;

            {
                this.f38908a = this;
            }

            @Override // com.kc.cw.ad.internal.nativead.NativeAdShownListener
            public void onAdShown(boolean z) {
                try {
                    if (this.f38908a.ae) {
                        if (this.f38908a.X != null) {
                            if (z) {
                                if (!this.f38908a.u && !this.f38908a.X.isPlaying()) {
                                    this.f38908a.X.start();
                                }
                            } else if (this.f38908a.X.isPlaying()) {
                                this.f38908a.X.pause();
                            }
                        }
                    } else if (z) {
                        if (!this.f38908a.u && !this.f38908a.T.isPlaying()) {
                            this.f38908a.T.start();
                        }
                    } else if (this.f38908a.T.isPlaying()) {
                        this.f38908a.T.pause();
                    }
                } catch (Exception e) {
                    com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        Matrix matrixA;
        TextureView textureView = this.U;
        if (textureView == null || this.X == null || (matrixA = new com.kc.cw.ad.c(new com.kc.cw.ad.c.C0970c(textureView.getWidth(), this.U.getHeight()), new com.kc.cw.ad.c.C0970c(this.X.getVideoWidth(), this.X.getVideoHeight())).a(com.kc.cw.ad.c.b.FIT_CENTER)) == null) {
            return;
        }
        this.U.setTransform(matrixA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        Handler handler = this.Z;
        if (handler == null || this.aa == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
        this.Z.postDelayed(this.aa, 1000L);
    }

    private void u() {
        f fVar;
        com.kc.cw.ad.a.c.o oVarK;
        if (this.ap == null || (fVar = this.M) == null || this.Q != null || (oVarK = fVar.K()) == null) {
            return;
        }
        com.kc.cw.ad.a.c.u uVarC = oVarK.c();
        this.Q = uVarC;
        if (uVarC == null || uVarC.a() != 1) {
            return;
        }
        b(this.ap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:23:0x0068  */
    public com.kc.cw.ad.a.d v() {
        int screenWidth;
        float f;
        int screenHeight;
        try {
            float f2 = 1.4f;
            if (this.r || this.n) {
                screenWidth = ViewUtil.getScreenWidth(com.kc.cw.ad.internal.q.a().l());
                f = screenWidth;
                int i = (int) (f / 1.4f);
                f fVar = this.M;
                if (fVar == null) {
                    screenHeight = i;
                } else if (fVar.m() == p.DRAW) {
                    screenHeight = ViewUtil.getScreenHeight(com.kc.cw.ad.internal.q.a().l());
                } else if (this.M.m() == p.BANNER) {
                    f2 = 6.4f;
                    screenHeight = (int) (f / f2);
                } else {
                    screenHeight = i;
                }
            } else {
                ViewGroup viewGroup = this.ap;
                if (viewGroup != null) {
                    screenWidth = viewGroup.getWidth();
                    screenHeight = this.ap.getHeight();
                } else {
                    screenWidth = 0;
                    screenHeight = 0;
                }
                if (screenWidth == 0 || screenHeight == 0) {
                    screenWidth = ViewUtil.getScreenWidth(com.kc.cw.ad.internal.q.a().l());
                    f = screenWidth;
                    screenHeight = (int) (f / f2);
                }
            }
            int iA = i.a(screenWidth);
            int iA2 = i.a(screenHeight);
            int iA3 = i.a(150);
            com.kc.cw.ad.a.d dVar = new com.kc.cw.ad.a.d(1);
            dVar.a(iA);
            dVar.b(iA2);
            dVar.a(String.valueOf(System.currentTimeMillis()));
            dVar.d(String.valueOf(System.currentTimeMillis()));
            dVar.c(String.valueOf(System.currentTimeMillis() / 1000));
            dVar.c(iA);
            dVar.d(iA2);
            dVar.b(String.valueOf(System.currentTimeMillis() + ((long) (iA3 + 50))));
            dVar.e(screenWidth);
            dVar.f(screenHeight);
            return dVar;
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        f fVar;
        if (this.w || this.aq == null || (fVar = this.M) == null || fVar.m() != p.DRAW) {
            return;
        }
        this.w = true;
        com.kc.cw.ad.a.c.y yVarK = this.M.k();
        if (yVarK == null || yVarK.a() != 1) {
            return;
        }
        this.W = (LinearLayout) this.aq.findViewById(R.id.rl_auto);
        TextView textView = (TextView) this.aq.findViewById(R.id.tv_auto);
        TextView textView2 = (TextView) this.aq.findViewById(R.id.tv_stop);
        this.W.setVisibility(0);
        com.kc.cw.ad.b.a aVar = new com.kc.cw.ad.b.a(((long) yVarK.b()) * 1000, 50L);
        this.aF = aVar;
        aVar.a(new com.kc.cw.ad.b.b(this, textView) { // from class: com.kc.cw.ad.internal.b.e.18

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final TextView f38891a;
            final e b;

            {
                this.b = this;
                this.f38891a = textView;
            }

            @Override // com.kc.cw.ad.b.b
            public void a() {
                this.b.y = 3;
                this.b.q = true;
                e eVar = this.b;
                eVar.a(eVar.v());
                this.b.x();
            }

            @Override // com.kc.cw.ad.b.b
            public void a(long j) {
                int i = (int) ((j / 1000) + 1);
                this.f38891a.setText(String.format(Locale.US, "%d秒后自动跳转详情页", Integer.valueOf(i)));
                if (i <= 3) {
                    this.f38891a.setBackgroundResource(R.drawable.ss_bg_common_orange);
                }
            }

            @Override // com.kc.cw.ad.b.b
            public void b() {
            }
        });
        this.aF.a();
        textView2.setOnClickListener(new View.OnClickListener(this) { // from class: com.kc.cw.ad.internal.b.e.19

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final e f38892a;

            {
                this.f38892a = this;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f38892a.x();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        com.kc.cw.ad.b.a aVar = this.aF;
        if (aVar != null) {
            aVar.d();
        }
        LinearLayout linearLayout = this.W;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        StringBuilder sb;
        String str;
        ArrayList<String> arrayList = this.I;
        if (arrayList == null) {
            return;
        }
        for (String string : arrayList) {
            if (string.contains("?rv=1")) {
                ViewUtil.openLocalBrowser(string, 0);
            } else {
                if (string.contains("track=oct")) {
                    if (this.n) {
                        sb = new StringBuilder();
                        sb.append(string);
                        str = "&opt=10";
                    } else if (this.r) {
                        sb = new StringBuilder();
                        sb.append(string);
                        str = "&opt=1";
                    }
                    sb.append(str);
                    string = sb.toString();
                }
                new com.kc.cw.ad.internal.i(string).b();
            }
        }
    }

    private void z() {
        f fVar = this.M;
        if (fVar != null) {
            this.A = fVar.S();
        }
        A();
        B();
        C();
        List<View> list = this.as;
        if (list == null || list.isEmpty()) {
            n();
        } else {
            for (View view : this.as) {
                if (view != null) {
                    view.setOnClickListener(this.aw);
                    view.setOnTouchListener(this.ax);
                }
            }
        }
        List<View> list2 = this.at;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        for (View view2 : this.at) {
            if (view2 != null) {
                view2.setOnClickListener(this.ay);
            }
        }
    }

    public int a() {
        return this.m;
    }

    public void a(int i) {
        this.m = i;
    }

    public void a(int i, String str, String str2) {
        f fVar = this.M;
        if (fVar != null) {
            fVar.a(i, str, str2);
        }
    }

    public void a(long j, long j2) {
        com.kc.cw.ad.a.c.l lVarJ;
        if (this.M == null || !com.kc.cw.ad.internal.q.a().f() || (lVarJ = this.M.j()) == null || TextUtils.isEmpty(lVarJ.c())) {
            return;
        }
        com.kc.cw.ad.internal.q.a().a(this.M.ag());
        if (lVarJ.b() == 1) {
            this.ab = com.kc.cw.ad.internal.q.a().l.get(lVarJ.c());
        }
        com.kc.cw.ad.a.a aVar = this.ab;
        if (aVar == null || !aVar.j() || this.ab.f() < getPrice()) {
            com.kc.cw.ad.a.a aVar2 = new com.kc.cw.ad.a.a();
            this.ab = aVar2;
            aVar2.a(getPrice());
            this.ab.a(j);
            this.ab.b(j2);
            this.ab.a(f());
            this.ab.b(lVarJ.a());
            this.ab.b(lVarJ.c());
            this.ab.c(lVarJ.d());
            this.ab.a(this.M.U());
            this.ab.e(this.M.Z());
            if (this.M.a() != null) {
                this.ab.d(this.M.X());
                this.ab.a(this.M.a().t());
            }
            com.kc.cw.ad.internal.q.a().l.put(lVarJ.c(), this.ab);
        }
    }

    public void a(Context context) {
        this.O = context;
        if (context == null) {
            this.O = com.kc.cw.ad.internal.q.a().l();
        }
    }

    public void a(com.kc.cw.ad.a.c.b bVar) {
        this.aG = bVar;
        if (bVar != null) {
            this.aH = bVar.i();
        }
    }

    public void a(c cVar) {
        this.N = cVar;
    }

    public void a(f fVar) {
        this.M = fVar;
    }

    public void a(AdLogoInfo adLogoInfo) {
        this.K = adLogoInfo;
    }

    public void a(String str) {
        this.ac = str;
    }

    public void a(boolean z) {
        this.af = z;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public void addShakeView(ViewGroup viewGroup, int i, float f) {
        if (viewGroup == null) {
            return;
        }
        viewGroup.post(new Runnable(this, viewGroup, i, f) { // from class: com.kc.cw.ad.internal.b.e.7

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final ViewGroup f38911a;
            final int b;
            final float c;
            final e d;

            {
                this.d = this;
                this.f38911a = viewGroup;
                this.b = i;
                this.c = f;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.d.Q == null || this.d.Q.a() == 0) {
                    this.d.Q = new com.kc.cw.ad.a.c.u(1.5d, AudioStats.AUDIO_AMPLITUDE_NONE, 0, "摇动或点击了解更多", 1, 0, 0, 3);
                }
                this.d.a(this.f38911a, this.b, this.c);
            }
        });
    }

    public f b() {
        return this.M;
    }

    public void b(int i) {
        f fVar = this.M;
        if (fVar != null) {
            fVar.b(i);
        }
    }

    public void b(AdLogoInfo adLogoInfo) {
        this.L = adLogoInfo;
    }

    public void b(String str) {
        this.h = str;
    }

    public void b(boolean z) {
        this.ag = z;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public void bindUnifiedView(ViewGroup viewGroup, List<View> list, NativeAdEventListener nativeAdEventListener) {
        bindUnifiedView(viewGroup, list, null, nativeAdEventListener);
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public void bindUnifiedView(ViewGroup viewGroup, List<View> list, List<View> list2, NativeAdEventListener nativeAdEventListener) {
        this.ah = true;
        this.ap = viewGroup;
        this.au = nativeAdEventListener;
        this.as = list;
        this.at = list2;
        k();
        f fVar = this.M;
        if (fVar != null) {
            fVar.b();
        }
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public void bindView(ViewGroup viewGroup, NativeAdEventListener nativeAdEventListener) {
        this.ah = true;
        this.ap = viewGroup;
        this.au = nativeAdEventListener;
        j();
        f fVar = this.M;
        if (fVar != null) {
            fVar.b();
        }
    }

    public void c() {
        VideoView videoView;
        String str = getVideoUrls().get(0);
        if (this.T == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            com.kc.cw.ad.internal.d.h hVarB = com.kc.cw.ad.internal.q.a().b();
            if (hVarB != null) {
                String strA = hVarB.a(str);
                if (hVarB.b(str)) {
                    this.T.setVideoPath(strA);
                    return;
                }
                videoView = this.T;
            } else {
                videoView = this.T;
            }
            videoView.setVideoPath(str);
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
            NativeAdEventListener nativeAdEventListener = this.au;
            if (nativeAdEventListener != null) {
                nativeAdEventListener.onAdRenderFailed(80202);
            }
            f fVar = this.M;
            if (fVar != null) {
                fVar.a(e.getMessage());
            }
        }
    }

    public void c(String str) {
        this.I.add(str);
    }

    public void c(boolean z) {
        this.ae = z;
    }

    public void d() {
        String str = getVideoUrls().get(0);
        if (this.X == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            com.kc.cw.ad.internal.d.h hVarB = com.kc.cw.ad.internal.q.a().b();
            if (hVarB != null) {
                String strA = hVarB.a(str);
                if (hVarB.b(str)) {
                    str = strA;
                }
            }
            this.X.setDataSource(str);
            this.X.prepare();
            this.X.start();
            VideoStateListener videoStateListener = this.av;
            if (videoStateListener != null) {
                videoStateListener.onVideoReady();
            }
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
            NativeAdEventListener nativeAdEventListener = this.au;
            if (nativeAdEventListener != null) {
                nativeAdEventListener.onAdRenderFailed(80202);
            }
            f fVar = this.M;
            if (fVar != null) {
                fVar.a(e.getMessage());
            }
        }
    }

    public void d(String str) {
        this.J.add(str);
    }

    public void d(boolean z) {
        this.r = z;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public void destroy() {
        this.o = true;
        this.E = true;
        x();
        com.kc.cw.ad.internal.g gVar = this.aA;
        if (gVar != null) {
            gVar.a();
        }
        h hVar = this.aB;
        if (hVar != null) {
            hVar.a();
        }
        l lVar = this.R;
        if (lVar != null) {
            lVar.a();
            this.R = null;
        }
        Handler handler = this.Z;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.Z = null;
        }
        y yVar = this.az;
        if (yVar != null) {
            yVar.c();
            this.az = null;
        }
        f fVar = this.M;
        if (fVar != null) {
            fVar.al();
            this.M = null;
        }
        Bitmap bitmap = this.g;
        if (bitmap != null) {
            bitmap.recycle();
            this.g = null;
        }
        Bitmap bitmap2 = this.f;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.f = null;
        }
        MediaPlayer mediaPlayer = this.X;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.X = null;
        }
        this.aa = null;
        this.ar = null;
        this.as = null;
        this.at = null;
        this.ap = null;
        this.aC = null;
        this.au = null;
    }

    public void e() {
        z();
        a(new NativeAdShownListener(this) { // from class: com.kc.cw.ad.internal.b.e.5

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final e f38909a;

            {
                this.f38909a = this;
            }

            @Override // com.kc.cw.ad.internal.nativead.NativeAdShownListener
            public void onAdShown(boolean z) {
                this.f38909a.g(z);
            }
        });
    }

    public void e(boolean z) {
        this.n = z;
    }

    public String f() {
        if (this.ac == null) {
            this.ac = "";
        }
        return this.ac;
    }

    public void f(boolean z) {
        f fVar = this.M;
        if (fVar != null) {
            fVar.a(z);
        }
    }

    public void g() {
        f fVar;
        com.kc.cw.ad.a.c.w wVarL;
        com.kc.cw.ad.a.c.p pVarC;
        if (this.r || (fVar = this.M) == null || (wVarL = fVar.L()) == null || (pVarC = wVarL.c()) == null) {
            return;
        }
        if (pVarC.a() == 1) {
            d(true);
            new Handler().postDelayed(new Runnable(this) { // from class: com.kc.cw.ad.internal.b.e.11

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final e f38879a;

                {
                    this.f38879a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f38879a.y();
                }
            }, pVarC.c());
            if (pVarC.b() == 1) {
                this.q = true;
                com.kc.cw.ad.internal.k.a aVar = new com.kc.cw.ad.internal.k.a(this) { // from class: com.kc.cw.ad.internal.b.e.13

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final e f38886a;

                    {
                        this.f38886a = this;
                    }

                    @Override // com.kc.cw.ad.internal.k.a
                    public void a(String str) {
                        if ("AppBackground".equals(str)) {
                            this.f38886a.s = true;
                        }
                    }
                };
                com.kc.cw.ad.internal.k.a().a(aVar);
                new Handler().postDelayed(new Runnable(this, aVar) { // from class: com.kc.cw.ad.internal.b.e.14

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final com.kc.cw.ad.internal.k.a f38887a;
                    final e b;

                    {
                        this.b = this;
                        this.f38887a = aVar;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (!this.b.s) {
                            e eVar = this.b;
                            eVar.a(eVar.v());
                        }
                        com.kc.cw.ad.internal.k.a().b(this.f38887a);
                    }
                }, pVarC.d());
            }
        }
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public String getAdvertiser() {
        return this.C;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public View getBlurView(Context context) {
        return b(context);
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public String getButtonText() {
        return TextUtils.isEmpty(this.i) ? "查看详情" : this.i;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public ComplianceInfo getComplianceInfo() {
        return this.aH;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public View getComplianceView(Context context) {
        ComplianceInfo complianceInfo = this.aH;
        if (complianceInfo != null) {
            return ViewUtil.createComplianceView(context, complianceInfo, 1.0f, true);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0016  */
    @Override // com.kc.cw.ad.NativeAdResponse
    public View getComplianceView(Context context, int i) {
        float f;
        if (this.aH == null) {
            return null;
        }
        float screenWidthDp = ViewUtil.getScreenWidthDp(context);
        if (screenWidthDp <= 0.0f || i <= 0) {
            f = 1.0f;
        } else {
            float f2 = i;
            if (screenWidthDp > f2) {
                f = f2 / screenWidthDp;
            } else {
                f = 1.0f;
            }
        }
        return ViewUtil.createComplianceView(context, this.aH, f, true);
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public String getDescription() {
        return this.c;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public Bitmap getIcon() {
        return this.g;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public String getIconUrl() {
        return this.e;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public Bitmap getImage() {
        return this.f;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public String getImageUrl() {
        return this.d;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public ArrayList<String> getImageUrls() {
        return this.F;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public int getInteractionType() {
        com.kc.cw.ad.a.c.b bVar = this.aG;
        if (bVar != null) {
            return bVar.d();
        }
        return 4;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public String getLandingPageUrl() {
        return this.h;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public Bitmap getLogo(Context context) {
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.ss_logo);
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public AdLogoInfo getLogoInfo() {
        return this.L;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public String getLogoUrl() {
        return "https://fpvideo.shenshiads.com/qidian_gray_logo.png";
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public int getMaterialType() {
        return isVideo() ? 2 : 1;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public Map<String, Object> getMediaExtraInfo() {
        f fVar = this.M;
        return fVar != null ? fVar.ab() : Collections.emptyMap();
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public NativeAdResponse.b getNativeAdType() {
        return this.f38876a;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public HashMap<String, Object> getNativeElements() {
        return this.D;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public List<? extends View> getNativeInfoListView() {
        return this.aD;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public View getNativeView() {
        return this.ap;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public NativeAdResponse.a getNetworkIdentifier() {
        return NativeAdResponse.a.OCTOPUS;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public int getPictureHeight() {
        f fVar = this.M;
        if (fVar != null) {
            return fVar.o();
        }
        return 0;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public int getPictureWidth() {
        f fVar = this.M;
        if (fVar != null) {
            return fVar.p();
        }
        return 0;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public int getPrice() {
        return this.l;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public ShakeValue getShakeValue() {
        f fVar = this.M;
        if (fVar != null) {
            return fVar.aa();
        }
        return null;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public double getStarRating() {
        return this.j;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public String getStore() {
        return this.k;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public ArrayList<String> getTextList() {
        return this.H;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public Bitmap getTextLogo(Context context) {
        return BitmapFactory.decodeResource(context.getResources(), R.drawable.ss_logo_text);
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public AdLogoInfo getTextLogoInfo() {
        return this.K;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public String getTextLogoUrl() {
        AdLogoInfo adLogoInfo = this.K;
        if (adLogoInfo == null || adLogoInfo.getType() != AdLogoInfo.TYPE_PIC) {
            return null;
        }
        return this.K.getAdurl();
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public String getTitle() {
        return this.b;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public ArrayList<String> getVideoUrls() {
        return this.G;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public View getVideoView(Context context) {
        if (context == null || !isVideo() || getVideoUrls().isEmpty()) {
            return null;
        }
        if (this.ae) {
            if (this.U == null) {
                this.U = new TextureView(context);
                q();
            }
            return this.U;
        }
        if (this.T == null) {
            this.T = new VideoView(context);
            p();
        }
        return this.T;
    }

    public void h() {
        com.kc.cw.ad.a.c.w wVarL;
        com.kc.cw.ad.a.c.p pVarC;
        f fVar = this.M;
        if (fVar == null || (wVarL = fVar.L()) == null || (pVarC = wVarL.c()) == null) {
            return;
        }
        if (pVarC.a() == 1) {
            e(true);
            new Handler().postDelayed(new Runnable(this) { // from class: com.kc.cw.ad.internal.b.e.15

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final e f38888a;

                {
                    this.f38888a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.f38888a.y();
                }
            }, pVarC.c());
            if (pVarC.b() == 1) {
                this.q = true;
                com.kc.cw.ad.internal.k.a aVar = new com.kc.cw.ad.internal.k.a(this) { // from class: com.kc.cw.ad.internal.b.e.16

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final e f38889a;

                    {
                        this.f38889a = this;
                    }

                    @Override // com.kc.cw.ad.internal.k.a
                    public void a(String str) {
                        if ("AppBackground".equals(str)) {
                            this.f38889a.s = true;
                        }
                    }
                };
                com.kc.cw.ad.internal.k.a().a(aVar);
                new Handler().postDelayed(new Runnable(this, aVar) { // from class: com.kc.cw.ad.internal.b.e.17

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final com.kc.cw.ad.internal.k.a f38890a;
                    final e b;

                    {
                        this.b = this;
                        this.f38890a = aVar;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (!this.b.s) {
                            e eVar = this.b;
                            eVar.a(eVar.v());
                        }
                        com.kc.cw.ad.internal.k.a().b(this.f38890a);
                    }
                }, pVarC.d());
            }
        }
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public boolean hasExpired() {
        return this.E;
    }

    public boolean i() {
        return this.r;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public boolean isShakeAd() {
        return this.ag;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public boolean isVideo() {
        return this.af;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public void setAdWidth(int i) {
        this.am = i;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public void setAutoFitWidth(boolean z) {
        this.al = z;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public void setIcon(Bitmap bitmap) {
        this.g = bitmap;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public void setImage(Bitmap bitmap) {
        this.f = bitmap;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public void setIsVideoMute(boolean z) {
        this.ak = z;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public void setNativeAdEventListener(NativeAdEventListener nativeAdEventListener) {
        this.aj = false;
        if (this.O == null) {
            this.O = com.kc.cw.ad.internal.q.a().l();
        }
        this.ah = false;
        FrameLayout frameLayout = new FrameLayout(this.O);
        this.ap = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.au = nativeAdEventListener;
        f fVar = this.M;
        if (fVar != null) {
            if (fVar.m() == p.DRAW) {
                l();
            } else if (this.M.m() == p.BANNER) {
                m();
            } else {
                j();
            }
            this.M.b();
        }
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public void setNativeInfoListView(List<? extends View> list) {
        this.aD = list;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public void setOnSensorListener(OnSensorListener onSensorListener) {
        this.aE = onSensorListener;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public void setVideoStateListener(VideoStateListener videoStateListener) {
        this.av = videoStateListener;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public void showCloseButton(boolean z) {
        this.t = z;
    }

    @Override // com.kc.cw.ad.NativeAdResponse
    public void unregisterViews() {
        View view = this.ar;
        if (view != null) {
            view.setOnClickListener(null);
        }
        List<View> list = this.as;
        if (list != null && !list.isEmpty()) {
            for (View view2 : this.as) {
                if (view2 != null) {
                    view2.setOnClickListener(null);
                }
            }
        }
        List<View> list2 = this.at;
        if (list2 != null && !list2.isEmpty()) {
            for (View view3 : this.at) {
                if (view3 != null) {
                    view3.setOnClickListener(null);
                }
            }
        }
        destroy();
    }
}

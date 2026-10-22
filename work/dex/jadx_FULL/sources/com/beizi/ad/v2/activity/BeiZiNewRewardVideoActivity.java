package com.beizi.ad.v2.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.camera.video.AudioStats;
import com.alibaba.baichuan.trade.common.constants.AlibcCommonConstant;
import com.beizi.ad.internal.activity.DownloadAppInfoActivity;
import com.beizi.ad.internal.download.BeiZiWebView;
import com.beizi.ad.internal.view.CustomRoundImageView;
import com.beizi.fusion.R;
import com.beizi.fusion.a5;
import com.beizi.fusion.aj;
import com.beizi.fusion.bq;
import com.beizi.fusion.g5;
import com.beizi.fusion.il;
import com.beizi.fusion.im;
import com.beizi.fusion.j5;
import com.beizi.fusion.k8;
import com.beizi.fusion.kh;
import com.beizi.fusion.kj;
import com.beizi.fusion.kl;
import com.beizi.fusion.kn;
import com.beizi.fusion.lj;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.ng;
import com.beizi.fusion.o6;
import com.beizi.fusion.of;
import com.beizi.fusion.ol;
import com.beizi.fusion.on;
import com.beizi.fusion.q1;
import com.beizi.fusion.q7;
import com.beizi.fusion.qf;
import com.beizi.fusion.rn;
import com.beizi.fusion.sn;
import com.beizi.fusion.tl;
import com.beizi.fusion.to;
import com.beizi.fusion.u5;
import com.beizi.fusion.vp;
import com.beizi.fusion.w3;
import com.beizi.fusion.widget.BZCarouselView;
import com.beizi.fusion.wk;
import com.beizi.fusion.wn;
import com.beizi.fusion.x1;
import com.beizi.fusion.xo;
import com.zj.adlib.bv9;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BeiZiNewRewardVideoActivity extends Activity {
    private TextView A;
    private boolean A0;
    private FrameLayout B;
    private boolean B0;
    private CustomRoundImageView C;
    private boolean C0;
    private CustomRoundImageView D;
    private boolean D0;
    private VideoView E;
    private ProgressBar F;
    private boolean H;
    private int H0;
    private int I0;
    private int J0;
    private int K;
    private int L;
    private boolean L0;
    private boolean M;
    private List M0;
    private MediaPlayer N;
    private List N0;
    private int P;
    private BZCarouselView P0;
    private boolean Q;
    private j5 Q0;
    private int R;
    private j5 R0;
    private int S0;
    private String T;
    private int T0;
    private String U;
    private xo U0;
    private String V;
    private xo V0;
    private String W;
    private xo W0;
    private String X;
    private xo X0;
    private AdSpacesBean.BuyerBean Y;
    private LinearLayout Y0;
    private tl Z;
    private RelativeLayout Z0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private aj f26938a;
    private sn a0;
    private TextView a1;
    private on b;
    private kn b0;
    private TextView b1;
    private RelativeLayout c;
    private q7 c0;
    private TextView c1;
    private RelativeLayout d;
    private k8 d0;
    private TextView d1;
    private LinearLayout e;
    private o6 e1;
    private LinearLayout f;
    private boolean f0;
    private boolean f1;
    private LinearLayout g;
    private String g0;
    private boolean g1;
    private LinearLayout h;
    private String h0;
    private FrameLayout h1;
    private LinearLayout i;
    private String i0;
    private TextView i1;
    private LinearLayout j;
    private long j0;
    private ImageView j1;
    private View k;
    private int k1;
    private ImageView l;
    private boolean l0;
    private int l1;
    private ImageView m;
    private boolean m0;
    private int m1;
    private ImageView n;
    private boolean n0;
    private TextView o;
    private boolean o0;
    private TextView p;
    private String p0;
    private TextView q;
    private int q0;
    private TextView r;
    private boolean r0;
    private TextView s;
    private boolean s0;
    private TextView t;
    private boolean t0;
    private TextView u;
    private boolean u0;
    private int u1;
    private TextView v;
    private boolean v0;
    private lj v1;
    private TextView w;
    private im w0;
    private boolean w1;
    private TextView x;
    private int x0;
    private TextView y;
    private il y0;
    private TextView z;
    private int z0;
    private boolean G = false;
    private boolean I = false;
    private int J = 30;
    private boolean O = false;
    private boolean S = true;
    private boolean e0 = true;
    private boolean k0 = false;
    private int E0 = 0;
    private int F0 = 0;
    private int G0 = 1;
    private Handler K0 = new k(Looper.getMainLooper());
    private int O0 = 0;
    private int n1 = 1;
    private int o1 = 2;
    private int p1 = 0;
    private int q1 = 5;
    private int r1 = 15;
    private int s1 = 15;
    private int t1 = 0;

    public class a implements MediaPlayer.OnErrorListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                kh.a("BeiZisAd", "setOnErrorListener: 播放失败");
                vp vpVarC = vp.c();
                BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity = BeiZiNewRewardVideoActivity.this;
                vpVarC.a(beiZiNewRewardVideoActivity, beiZiNewRewardVideoActivity.W);
                BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity2 = BeiZiNewRewardVideoActivity.this;
                if (beiZiNewRewardVideoActivity2.g1) {
                    return true;
                }
                beiZiNewRewardVideoActivity2.k();
                BeiZiNewRewardVideoActivity.this.t();
                BeiZiNewRewardVideoActivity.this.l();
                BeiZiNewRewardVideoActivity.this.i();
                BeiZiNewRewardVideoActivity.this.W();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public class b implements MediaPlayer.OnInfoListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (mediaPlayer == null || i != 701) {
                return false;
            }
            try {
                BeiZiNewRewardVideoActivity.this.b(mediaPlayer.getCurrentPosition());
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public class b0 implements of.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CustomRoundImageView f26942a;
        final /* synthetic */ int b;

        public b0(CustomRoundImageView customRoundImageView, int i) {
            this.f26942a = customRoundImageView;
            this.b = i;
        }

        @Override // com.beizi.fusion.of.f
        public void a() {
        }

        @Override // com.beizi.fusion.of.f
        public void a(Bitmap bitmap) {
            try {
                CustomRoundImageView customRoundImageView = this.f26942a;
                if (customRoundImageView != null) {
                    customRoundImageView.setImageBitmap(bitmap);
                    this.f26942a.setRectRadius(this.b / 2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity = BeiZiNewRewardVideoActivity.this;
                if (beiZiNewRewardVideoActivity.I) {
                    beiZiNewRewardVideoActivity.l.setImageResource(R.drawable.beizi_voice_off);
                    MediaPlayer mediaPlayer = BeiZiNewRewardVideoActivity.this.N;
                    if (mediaPlayer != null) {
                        mediaPlayer.setVolume(0.0f, 0.0f);
                    }
                } else {
                    beiZiNewRewardVideoActivity.l.setImageResource(R.drawable.beizi_voice_on);
                    MediaPlayer mediaPlayer2 = BeiZiNewRewardVideoActivity.this.N;
                    if (mediaPlayer2 != null) {
                        mediaPlayer2.setVolume(0.0f, 1.0f);
                    }
                }
                BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity2 = BeiZiNewRewardVideoActivity.this;
                beiZiNewRewardVideoActivity2.I = !beiZiNewRewardVideoActivity2.I;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f26945a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        public d(String str, String str2, String str3, String str4) {
            this.f26945a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Intent intent = new Intent(BeiZiNewRewardVideoActivity.this, (Class<?>) DownloadAppInfoActivity.class);
                intent.putExtra("title_content_key", this.f26945a);
                intent.putExtra("privacy_content_key", this.b);
                intent.putExtra("permission_content_key", this.c);
                intent.putExtra("intro_content_key", this.d);
                intent.setFlags(268435456);
                BeiZiNewRewardVideoActivity.this.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class d0 implements BZCarouselView.e {
        public d0() {
        }

        @Override // com.beizi.fusion.widget.BZCarouselView.e
        public void a(int i) {
            x1.d dVarA;
            List listJ;
            kl klVarA;
            try {
                BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity = BeiZiNewRewardVideoActivity.this;
                beiZiNewRewardVideoActivity.O0 = i;
                beiZiNewRewardVideoActivity.a(beiZiNewRewardVideoActivity.E0, (x1.d) beiZiNewRewardVideoActivity.M0.get(i));
                List list = BeiZiNewRewardVideoActivity.this.N0;
                if (list == null || list.size() <= 0 || BeiZiNewRewardVideoActivity.this.N0.size() < i) {
                    return;
                }
                kl klVar = (kl) BeiZiNewRewardVideoActivity.this.N0.get(i);
                BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity2 = BeiZiNewRewardVideoActivity.this;
                if (!beiZiNewRewardVideoActivity2.L0) {
                    beiZiNewRewardVideoActivity2.a(beiZiNewRewardVideoActivity2.C, 55, klVar.h());
                    BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity3 = BeiZiNewRewardVideoActivity.this;
                    beiZiNewRewardVideoActivity3.a(beiZiNewRewardVideoActivity3.p, beiZiNewRewardVideoActivity3.q, klVar.l(), klVar.k());
                }
                BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity4 = BeiZiNewRewardVideoActivity.this;
                if (beiZiNewRewardVideoActivity4.m0) {
                    if (beiZiNewRewardVideoActivity4.J0 == 0) {
                        beiZiNewRewardVideoActivity4.a(beiZiNewRewardVideoActivity4.D, 47, klVar.h());
                        BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity5 = BeiZiNewRewardVideoActivity.this;
                        beiZiNewRewardVideoActivity5.a(beiZiNewRewardVideoActivity5.x, beiZiNewRewardVideoActivity5.y, klVar.l(), klVar.k());
                    } else {
                        on onVar = beiZiNewRewardVideoActivity4.b;
                        if (onVar != null) {
                            List listE = onVar.e();
                            if (listE != null && listE.size() > 0) {
                                Iterator it = listE.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        dVarA = null;
                                        break;
                                    }
                                    dVarA = (x1.d) it.next();
                                    if (dVarA.z() && !dVarA.y()) {
                                        break;
                                    }
                                }
                            } else {
                                dVarA = null;
                                break;
                            }
                            if (dVarA == null) {
                                BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity6 = BeiZiNewRewardVideoActivity.this;
                                dVarA = beiZiNewRewardVideoActivity6.b.a(beiZiNewRewardVideoActivity6.E0);
                            }
                            if (dVarA != null && (listJ = dVarA.j()) != null && listJ.size() > 0 && (klVarA = BeiZiNewRewardVideoActivity.this.a(((x1.a) listJ.get(0)).d())) != null) {
                                BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity7 = BeiZiNewRewardVideoActivity.this;
                                beiZiNewRewardVideoActivity7.a(beiZiNewRewardVideoActivity7.D, 47, klVarA.h());
                                BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity8 = BeiZiNewRewardVideoActivity.this;
                                beiZiNewRewardVideoActivity8.a(beiZiNewRewardVideoActivity8.x, beiZiNewRewardVideoActivity8.y, klVarA.l(), klVarA.k());
                            }
                        }
                    }
                }
                BeiZiNewRewardVideoActivity.this.O();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class e implements tl.c {
        public e() {
        }

        @Override // com.beizi.fusion.tl.c
        public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            kh.a("BeiZisAd", "handleRegionalClickViewContent click");
            BeiZiNewRewardVideoActivity.this.a(0, str, str2, str3, str4, str5, str6, str7, str8, 0);
        }
    }

    public class e0 implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f26948a;
        float b;
        float c;
        float d;

        public e0() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f26948a = motionEvent.getX();
                this.b = motionEvent.getY();
                this.c = motionEvent.getX();
                this.d = motionEvent.getY();
            } else if (action == 1) {
                if (this.c - this.f26948a < 0.0f) {
                    BeiZiNewRewardVideoActivity.this.c0();
                    BeiZiNewRewardVideoActivity.this.Y();
                }
                if (this.c - this.f26948a > 0.0f) {
                    BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity = BeiZiNewRewardVideoActivity.this;
                    if (beiZiNewRewardVideoActivity.O0 > 0) {
                        beiZiNewRewardVideoActivity.b0();
                        BeiZiNewRewardVideoActivity.this.Y();
                    }
                }
            } else if (action == 2) {
                this.c = motionEvent.getX();
                this.d = motionEvent.getY();
            }
            return true;
        }
    }

    public class f implements sn.f {
        public f() {
        }

        @Override // com.beizi.fusion.sn.f
        public void a() {
            kh.a("BeiZisAd", "handleShakeViewContent click");
            BeiZiNewRewardVideoActivity.this.a(0, "", "", "", "", "", "", "", "", 2);
        }
    }

    public class f0 implements MediaPlayer.OnCompletionListener {
        public f0() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            kh.a("BeiZisAd", "onCompletion: 播放完成");
            try {
                BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity = BeiZiNewRewardVideoActivity.this;
                beiZiNewRewardVideoActivity.r0 = true;
                ProgressBar progressBar = beiZiNewRewardVideoActivity.F;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity2 = BeiZiNewRewardVideoActivity.this;
                beiZiNewRewardVideoActivity2.P = 0;
                if (mediaPlayer != null) {
                    beiZiNewRewardVideoActivity2.e(mediaPlayer.getDuration());
                }
                BeiZiNewRewardVideoActivity.this.J();
                BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity3 = BeiZiNewRewardVideoActivity.this;
                if (beiZiNewRewardVideoActivity3.g1) {
                    return;
                }
                beiZiNewRewardVideoActivity3.j();
                BeiZiNewRewardVideoActivity.this.i();
                BeiZiNewRewardVideoActivity.this.W();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class g implements q7.e {
        public g() {
        }

        @Override // com.beizi.fusion.q7.e
        public void a() {
            kh.a("BeiZisAd", "handleEulerAngleViewContent click");
            BeiZiNewRewardVideoActivity.this.a(0, "", "", "", "", "", "", "", "", 2);
        }
    }

    public class g0 implements MediaPlayer.OnPreparedListener {
        public g0() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity = BeiZiNewRewardVideoActivity.this;
                beiZiNewRewardVideoActivity.N = mediaPlayer;
                if (beiZiNewRewardVideoActivity.I) {
                    mediaPlayer.setVolume(0.0f, 1.0f);
                } else {
                    mediaPlayer.setVolume(0.0f, 0.0f);
                }
                BeiZiNewRewardVideoActivity.this.Z();
                if (BeiZiNewRewardVideoActivity.this.e0) {
                    int duration = mediaPlayer.getDuration() / 1000;
                    BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity2 = BeiZiNewRewardVideoActivity.this;
                    if (beiZiNewRewardVideoActivity2.J > duration) {
                        beiZiNewRewardVideoActivity2.J = duration;
                    }
                    beiZiNewRewardVideoActivity2.K = beiZiNewRewardVideoActivity2.J;
                    ProgressBar progressBar = beiZiNewRewardVideoActivity2.F;
                    if (progressBar != null) {
                        progressBar.setMax(duration);
                    }
                    BeiZiNewRewardVideoActivity.this.a();
                    BeiZiNewRewardVideoActivity.this.t();
                    BeiZiNewRewardVideoActivity.this.l();
                    Handler handler = BeiZiNewRewardVideoActivity.this.K0;
                    if (handler != null) {
                        handler.sendEmptyMessageDelayed(10010, 1000L);
                    }
                    BeiZiNewRewardVideoActivity.this.K();
                }
                BeiZiNewRewardVideoActivity.this.e0 = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class h implements k8.b {
        public h() {
        }

        @Override // com.beizi.fusion.k8.b
        public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            kh.a("BeiZisAd", "handleFullScreenClickContent click");
            BeiZiNewRewardVideoActivity.this.a(0, str, str2, str3, str4, str5, str6, str7, str8, 0);
        }
    }

    public class i implements of.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f26954a;

        public i(ImageView imageView) {
            this.f26954a = imageView;
        }

        @Override // com.beizi.fusion.of.f
        public void a() {
        }

        @Override // com.beizi.fusion.of.f
        public void a(Bitmap bitmap) {
            try {
                ImageView imageView = this.f26954a;
                if (imageView == null || bitmap == null) {
                    return;
                }
                imageView.setVisibility(0);
                this.f26954a.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class j implements of.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f26955a;

        public j(ImageView imageView) {
            this.f26955a = imageView;
        }

        @Override // com.beizi.fusion.of.f
        public void a() {
        }

        @Override // com.beizi.fusion.of.f
        public void a(Bitmap bitmap) {
            try {
                ImageView imageView = this.f26955a;
                if (imageView == null || bitmap == null) {
                    return;
                }
                imageView.setVisibility(0);
                this.f26955a.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class k extends Handler {
        public k(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            VideoView videoView;
            super.handleMessage(message);
            try {
                int i = message.what;
                int currentPosition = 0;
                if (i == 10001) {
                    BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity = BeiZiNewRewardVideoActivity.this;
                    if (beiZiNewRewardVideoActivity.O) {
                        return;
                    }
                    beiZiNewRewardVideoActivity.a(0);
                    return;
                }
                if (i != 10010) {
                    return;
                }
                BeiZiNewRewardVideoActivity.this.K0.sendEmptyMessageDelayed(10010, 1000L);
                BeiZiNewRewardVideoActivity.this.f0();
                BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity2 = BeiZiNewRewardVideoActivity.this;
                if (beiZiNewRewardVideoActivity2.M && (videoView = beiZiNewRewardVideoActivity2.E) != null && videoView.isPlaying()) {
                    int duration = BeiZiNewRewardVideoActivity.this.E.getDuration();
                    currentPosition = BeiZiNewRewardVideoActivity.this.E.getCurrentPosition();
                    BeiZiNewRewardVideoActivity.this.e(currentPosition);
                    BeiZiNewRewardVideoActivity.this.a(duration, currentPosition);
                }
                BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity3 = BeiZiNewRewardVideoActivity.this;
                if (!beiZiNewRewardVideoActivity3.s0 && !beiZiNewRewardVideoActivity3.m0 && !beiZiNewRewardVideoActivity3.g1 && !beiZiNewRewardVideoActivity3.D0) {
                    if (!beiZiNewRewardVideoActivity3.M) {
                        int i2 = beiZiNewRewardVideoActivity3.z0 + 1;
                        beiZiNewRewardVideoActivity3.z0 = i2;
                        currentPosition = i2 * 1000;
                    }
                    int i3 = (beiZiNewRewardVideoActivity3.J * 1000) - currentPosition;
                    int i4 = i3 / 1000;
                    int i5 = i3 / 1000;
                    beiZiNewRewardVideoActivity3.K = i5;
                    int i6 = beiZiNewRewardVideoActivity3.L;
                    if (i5 <= i6 || i6 <= 0) {
                        beiZiNewRewardVideoActivity3.L = i5;
                        int i7 = beiZiNewRewardVideoActivity3.m1;
                        int i8 = beiZiNewRewardVideoActivity3.n1;
                        if (i7 == i8) {
                            beiZiNewRewardVideoActivity3.p1 = (beiZiNewRewardVideoActivity3.q1 * 1000) - currentPosition;
                        }
                        if (i7 != i8 || beiZiNewRewardVideoActivity3.p1 > 0 || i4 <= 0) {
                            beiZiNewRewardVideoActivity3.d(i4);
                        } else {
                            beiZiNewRewardVideoActivity3.Q();
                        }
                        BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity4 = BeiZiNewRewardVideoActivity.this;
                        if (!beiZiNewRewardVideoActivity4.M && i4 <= 0) {
                            beiZiNewRewardVideoActivity4.W();
                        }
                        BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity5 = BeiZiNewRewardVideoActivity.this;
                        if ((beiZiNewRewardVideoActivity5.q1 * 1000) - currentPosition >= 0 || beiZiNewRewardVideoActivity5.m1 != beiZiNewRewardVideoActivity5.o1 || beiZiNewRewardVideoActivity5.l0) {
                            return;
                        }
                        beiZiNewRewardVideoActivity5.X();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public class l implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f26957a;
        float b;
        float c;
        float d;
        float e;
        float f;

        public l() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f26957a = motionEvent.getX();
                this.b = motionEvent.getY();
                this.c = motionEvent.getRawX();
                this.d = motionEvent.getRawY();
                this.e = motionEvent.getX();
                this.f = motionEvent.getY();
            } else if (action != 1) {
                if (action == 2) {
                    this.e = motionEvent.getX();
                    this.f = motionEvent.getY();
                }
            } else if (Math.abs(this.e - this.f26957a) <= 15.0f && Math.abs(this.f - this.b) <= 15.0f) {
                BeiZiNewRewardVideoActivity.this.a(0, String.valueOf(this.f26957a), String.valueOf(this.b), String.valueOf(this.c), String.valueOf(this.d), String.valueOf(this.f26957a), String.valueOf(this.b), String.valueOf(this.c), String.valueOf(this.d), 0);
            }
            return true;
        }
    }

    public class m implements Runnable {
        public m() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BeiZiNewRewardVideoActivity.this.T0 = 0;
        }
    }

    public class n implements View.OnClickListener {
        public n() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity = BeiZiNewRewardVideoActivity.this;
            if (beiZiNewRewardVideoActivity.S0 == 1 || beiZiNewRewardVideoActivity.T0 > 0) {
                return;
            }
            beiZiNewRewardVideoActivity.n();
        }
    }

    public class o implements View.OnClickListener {
        public o() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BeiZiNewRewardVideoActivity.this.b();
        }
    }

    public class p implements View.OnClickListener {
        public p() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity = BeiZiNewRewardVideoActivity.this;
            beiZiNewRewardVideoActivity.s0 = false;
            beiZiNewRewardVideoActivity.b();
            BeiZiNewRewardVideoActivity.this.o();
            BeiZiNewRewardVideoActivity.this.Y();
        }
    }

    public class q implements View.OnClickListener {
        public q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class r implements View.OnClickListener {
        public r() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BeiZiNewRewardVideoActivity.this.q();
        }
    }

    public class s implements of.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f26964a;

        public s(ImageView imageView) {
            this.f26964a = imageView;
        }

        @Override // com.beizi.fusion.of.f
        public void a() {
        }

        @Override // com.beizi.fusion.of.f
        public void a(Bitmap bitmap) {
            try {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(qf.a(BeiZiNewRewardVideoActivity.this, bitmap, 10.0f));
                ImageView imageView = this.f26964a;
                if (imageView == null || bitmap == null) {
                    return;
                }
                imageView.setBackground(bitmapDrawable);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class t implements View.OnClickListener {
        public t() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
        }
    }

    public class u implements View.OnClickListener {
        public u() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity = BeiZiNewRewardVideoActivity.this;
            beiZiNewRewardVideoActivity.s1 = beiZiNewRewardVideoActivity.r1;
            beiZiNewRewardVideoActivity.x();
            BeiZiNewRewardVideoActivity.this.Y();
        }
    }

    public class v implements View.OnClickListener {
        public v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BeiZiNewRewardVideoActivity.this.U();
        }
    }

    public class w implements View.OnClickListener {
        public w() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Intent launchIntentForPackage = BeiZiNewRewardVideoActivity.this.getPackageManager().getLaunchIntentForPackage(BeiZiNewRewardVideoActivity.this.b.T());
                if (launchIntentForPackage != null) {
                    launchIntentForPackage.setFlags(268435456);
                    BeiZiNewRewardVideoActivity.this.startActivity(launchIntentForPackage);
                }
                BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity = BeiZiNewRewardVideoActivity.this;
                beiZiNewRewardVideoActivity.o0 = true;
                beiZiNewRewardVideoActivity.w();
                BeiZiNewRewardVideoActivity.this.e0();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class x implements lj.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f26969a;
        final /* synthetic */ x1.d b;

        public x(int i, x1.d dVar) {
            this.f26969a = i;
            this.b = dVar;
        }

        @Override // com.beizi.fusion.lj.e
        public void a() {
            BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity = BeiZiNewRewardVideoActivity.this;
            if (beiZiNewRewardVideoActivity.k0) {
                beiZiNewRewardVideoActivity.a(this.f26969a);
            }
        }

        @Override // com.beizi.fusion.lj.e
        public void b() {
            BeiZiNewRewardVideoActivity.this.a(this.f26969a, this.b);
        }
    }

    public class y implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bitmap f26970a;
        final /* synthetic */ ImageView b;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ BitmapDrawable f26971a;

            public a(BitmapDrawable bitmapDrawable) {
                this.f26971a = bitmapDrawable;
            }

            @Override // java.lang.Runnable
            public void run() {
                ImageView imageView;
                try {
                    BitmapDrawable bitmapDrawable = this.f26971a;
                    if (bitmapDrawable == null || (imageView = y.this.b) == null) {
                        return;
                    }
                    imageView.setBackground(bitmapDrawable);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public y(Bitmap bitmap, ImageView imageView) {
            this.f26970a = bitmap;
            this.b = imageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Bitmap bitmap = this.f26970a;
                if (bitmap != null) {
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(qf.a(BeiZiNewRewardVideoActivity.this, bitmap, 20.0f));
                    Handler handler = BeiZiNewRewardVideoActivity.this.K0;
                    if (handler != null) {
                        handler.post(new a(bitmapDrawable));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class z implements sn.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f26972a;
        final /* synthetic */ int b;
        final /* synthetic */ double c;
        final /* synthetic */ double d;
        final /* synthetic */ int e;

        public z(boolean z, int i, double d, double d2, int i2) {
            this.f26972a = z;
            this.b = i;
            this.c = d;
            this.d = d2;
            this.e = i2;
        }

        @Override // com.beizi.fusion.sn.f
        public void a() {
            try {
                BeiZiNewRewardVideoActivity.this.w1 = true;
                if (this.f26972a) {
                    AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = new AdSpacesBean.BuyerBean.ShakeViewBean();
                    shakeViewBean.setShakeCount(this.b);
                    shakeViewBean.setShakeStartAmplitude(this.c);
                    shakeViewBean.setShakeEndAmplitude(this.d);
                    shakeViewBean.setRegulatoryAngle(this.e);
                    sn snVar = BeiZiNewRewardVideoActivity.this.a0;
                    if (snVar != null) {
                        snVar.a(shakeViewBean);
                    }
                }
                kh.a("BeiZisAd", "handleShakeViewContent click");
                BeiZiNewRewardVideoActivity.this.a(0, "", "", "", "", "", "", "", "", 2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void A() {
        this.m0 = false;
        LinearLayout linearLayout = this.g;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        if (this.g1) {
            e0();
        } else {
            if (this.k0) {
                Z();
            }
            a(this.m);
        }
        Y();
    }

    private void B() {
        try {
            im imVar = this.w0;
            if (imVar == null) {
                return;
            }
            j5 j5VarD = imVar.d();
            this.Q0 = j5VarD;
            if (j5VarD == null) {
                this.Q0 = new j5();
            }
            xo xoVarB = this.Q0.b();
            this.U0 = xoVarB;
            if (xoVarB == null) {
                xo xoVar = new xo();
                this.U0 = xoVar;
                xoVar.b("__TIME__秒后可领取奖励");
                this.U0.c("点击广告可提前领取奖励");
                this.U0.a("已经获得奖励");
                this.Q0.b(this.U0);
            }
            xo xoVarA = this.Q0.a();
            this.V0 = xoVarA;
            if (xoVarA == null) {
                xo xoVar2 = new xo();
                this.V0 = xoVar2;
                xoVar2.b("跳过");
                this.V0.a("关闭");
                this.Q0.a(this.V0);
            }
            j5 j5VarB = this.w0.b();
            this.R0 = j5VarB;
            if (j5VarB == null) {
                this.R0 = new j5();
            }
            xo xoVarB2 = this.R0.b();
            this.W0 = xoVarB2;
            if (xoVarB2 == null) {
                xo xoVar3 = new xo();
                this.W0 = xoVar3;
                xoVar3.b("点击广告领取奖励");
                this.W0.c("点击广告领取奖励");
                this.W0.a("已经获得奖励");
                this.R0.b(this.W0);
            }
            xo xoVarA2 = this.R0.a();
            this.X0 = xoVarA2;
            if (xoVarA2 == null) {
                xo xoVar4 = new xo();
                this.X0 = xoVar4;
                xoVar4.b("跳过");
                this.X0.c("跳过");
                this.X0.a("关闭");
                this.R0.a(this.X0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void C() {
        try {
            im imVar = this.w0;
            if (imVar == null) {
                return;
            }
            o6 o6VarE = imVar.e();
            this.e1 = o6VarE;
            if (o6VarE == null) {
                this.e1 = new o6();
            }
            if (this.e1.f() == null) {
                xo xoVar = new xo();
                xoVar.b("仅需再观看__TIME__秒即可获取奖励");
                this.e1.d(xoVar);
            }
            if (this.e1.c() == null) {
                xo xoVar2 = new xo();
                xoVar2.b("确定退出吗");
                this.e1.c(xoVar2);
            }
            if (this.e1.a() == null) {
                xo xoVar3 = new xo();
                xoVar3.b("继续观看");
                this.e1.a(xoVar3);
            }
            if (this.e1.b() == null) {
                xo xoVar4 = new xo();
                xoVar4.b("关闭广告");
                this.e1.b(xoVar4);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void D() {
        if (this.f1) {
            return;
        }
        this.f1 = true;
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.beizi_reward_video_ad_end_car_container_rl);
        relativeLayout.setVisibility(0);
        int iH = to.h(this);
        int iG = to.g(this);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.width = iH;
        layoutParams.height = iG;
        relativeLayout.setLayoutParams(layoutParams);
        this.i1 = (TextView) findViewById(R.id.beizi_reward_video_ad_end_car_close_tv);
        a((FrameLayout) findViewById(R.id.beizi_reward_video_ad_end_car_logo_container_fl));
        this.h1 = (FrameLayout) findViewById(R.id.beizi_reward_video_ad_end_car_container_fl);
        if (this.i1 != null) {
            int iA = bq.a(this, 15.0f);
            int iA2 = bq.a(this, 30.0f);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.i1.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = iA2;
            this.i1.setLayoutParams(layoutParams2);
            this.i1.setVisibility(0);
            wn.a(this.i1, "#66000000", 1, "#66FFFFFF", iA);
            this.i1.setOnClickListener(new r());
            P();
        }
    }

    private void E() {
        x1.d dVarA;
        String strG;
        on onVar;
        List listJ;
        kl klVarA;
        FrameLayout frameLayout;
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.beizi_reward_video_end_car_normal, (ViewGroup) null);
        if (viewInflate != null && (frameLayout = this.h1) != null) {
            frameLayout.removeAllViews();
            this.h1.addView(viewInflate);
        }
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.beizi_reward_video_ad_end_car_image_iv);
        viewInflate.findViewById(R.id.beizi_reward_video_ad_end_car_image_mask_view);
        on onVar2 = this.b;
        boolean z2 = false;
        int i2 = 5;
        if (onVar2 != null) {
            dVarA = onVar2.a(5);
            strG = (dVarA == null || (listJ = dVarA.j()) == null || listJ.size() <= 0 || (klVarA = a(((x1.a) listJ.get(0)).d())) == null) ? null : klVarA.i();
        } else {
            dVarA = null;
            strG = null;
        }
        if (TextUtils.isEmpty(strG) && (onVar = this.b) != null) {
            strG = onVar.G();
        }
        if (imageView != null && !TextUtils.isEmpty(strG)) {
            of.a(this).a(strG, new s(imageView));
            if (dVarA != null) {
                a(5, dVarA);
            }
        }
        View view = (LinearLayout) viewInflate.findViewById(R.id.beizi_reward_video_ad_end_car_interaction_container_ll);
        if (view != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = bq.a(this, 50.0f);
            view.setLayoutParams(layoutParams);
        }
        if (view != null) {
            wn.a(view, "#3976FF", 0, (String) null, bq.a(this, 25.0f));
        }
        CustomRoundImageView customRoundImageView = (CustomRoundImageView) viewInflate.findViewById(R.id.beizi_reward_video_ad_end_car_app_icon_iv);
        TextView textView = (TextView) viewInflate.findViewById(R.id.beizi_reward_video_ad_end_car_app_title_tv);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.beizi_reward_video_ad_end_car_app_subtitle_tv);
        if (dVarA == null) {
            dVarA = this.b.a(this.E0);
            i2 = this.E0;
        } else {
            z2 = true;
        }
        a(dVarA, i2, z2, customRoundImageView, 89, textView, textView2);
        this.j1 = (ImageView) viewInflate.findViewById(R.id.beizi_reward_video_ad_end_car_interaction_iv);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.beizi_reward_video_ad_end_car_interaction_title_tv);
        if (!TextUtils.isEmpty(this.g0) && textView3 != null) {
            textView3.setText(this.g0);
        }
        a(this.j1);
        a(view);
        a(dVarA, this.j1);
    }

    private void F() {
        im imVar = this.w0;
        if (imVar == null) {
            return;
        }
        il ilVarJ = imVar.j();
        this.y0 = ilVarJ;
        if (ilVarJ == null) {
            this.y0 = new il();
            int i2 = this.w0.i();
            if (i2 > 0) {
                this.y0.h(i2);
            }
            int iA = this.w0.a();
            if (iA > 0) {
                this.y0.d(iA);
            }
            int iH = this.w0.h();
            if (iH > 0) {
                this.y0.i(iH);
            }
            int iN = this.w0.n();
            if (iN > 0) {
                this.y0.b(iN);
            }
        }
        this.q1 = this.y0.m();
        int iB = this.y0.b();
        this.t1 = iB;
        this.u1 = iB;
        int iD = this.y0.d();
        this.r1 = iD;
        this.s1 = iD;
        this.m1 = this.y0.l();
        this.l1 = this.y0.a();
        this.I0 = this.y0.c();
        if (this.y0.o() == null) {
            xo xoVar = new xo();
            xoVar.b("恭喜获得特权");
            xoVar.c("恭喜获得特权");
            xoVar.a("恭喜获得特权");
            this.y0.f(xoVar);
        }
        if (this.y0.n() == null) {
            xo xoVar2 = new xo();
            xoVar2.b("打开并体验内容");
            xoVar2.c("只需再体验__TIME__秒");
            xoVar2.a("任务达成");
            this.y0.e(xoVar2);
        }
        if (this.y0.h() == null) {
            xo xoVar3 = new xo();
            xoVar3.b("__TIME__秒即可获得奖励");
            xoVar3.c("即可获得奖励");
            xoVar3.a("已经提前获取到奖励");
            this.y0.d(xoVar3);
        }
        if (this.y0.f() == null) {
            xo xoVar4 = new xo();
            xoVar4.b("浏览详情，获取奖励");
            xoVar4.c("继续浏览，获取奖励");
            xoVar4.a("已获得奖励，继续体验");
            this.y0.b(xoVar4);
        }
        if (this.y0.e() == null) {
            xo xoVar5 = new xo();
            xoVar5.b("__TIME__秒后继续播放");
            xoVar5.c("浏览时间不足，无法领取奖励");
            xoVar5.a("恭喜您！已提前获取奖励");
            this.y0.a(xoVar5);
        }
        if (this.y0.g() == null) {
            xo xoVar6 = new xo();
            xoVar6.b("放弃特权");
            xoVar6.c("放弃特权");
            xoVar6.a("关闭");
            this.y0.c(xoVar6);
        }
    }

    private void G() {
        wk wkVarR;
        int iA;
        on onVar = this.b;
        if (onVar == null || this.K0 == null) {
            return;
        }
        try {
            if (!this.O && (wkVarR = onVar.R()) != null && (iA = wkVarR.a()) > 0) {
                this.K0.sendEmptyMessageDelayed(10001, iA);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void H() {
        VideoView videoView = this.E;
        if (videoView == null) {
            return;
        }
        videoView.pause();
    }

    private void I() {
        try {
            int[] iArr = new int[2];
            this.f.getLocationOnScreen(iArr);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f.getLayoutParams();
            int iA = bq.a(this, 50.0f);
            int i2 = layoutParams != null ? layoutParams.width : 0;
            if (i2 <= 0) {
                i2 = to.i(this) - bq.a(this, 30.0f);
            }
            int[] iArrB = ol.b(i2 / 2, iA / 2);
            String strX = this.f26938a.x();
            g5 g5Var = new g5();
            g5Var.g(String.valueOf(iArrB[0]));
            g5Var.c(String.valueOf(iArrB[0]));
            g5Var.h(String.valueOf(iArrB[1]));
            g5Var.d(String.valueOf(iArrB[1]));
            g5Var.e(String.valueOf(iArrB[0] + iArr[0]));
            g5Var.a(String.valueOf(iArrB[0] + iArr[0]));
            g5Var.f(String.valueOf(iArrB[1] + iArr[1]));
            g5Var.b(String.valueOf(iArrB[1] + iArr[1]));
            this.b.c(true);
            this.b.a(this.f, g5Var, String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis() + 10), strX, 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        on onVarZ;
        try {
            aj ajVar = this.f26938a;
            if (ajVar == null || (onVarZ = ajVar.z()) == null) {
                return;
            }
            onVarZ.a(this.c, this.f26938a.x());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        on onVarZ;
        try {
            aj ajVar = this.f26938a;
            if (ajVar == null || (onVarZ = ajVar.z()) == null) {
                return;
            }
            onVarZ.e(this.c, this.f26938a.x());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void L() {
        try {
            int iA = bq.a(this, 15.0f);
            int iA2 = bq.a(this, 30.0f);
            ImageView imageView = this.l;
            if (imageView != null && this.M) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams.width = iA2;
                layoutParams.height = iA2;
                this.l.setLayoutParams(layoutParams);
            }
            View view = this.k;
            if (view != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) view.getLayoutParams();
                layoutParams2.width = iA2;
                layoutParams2.height = iA2;
                this.k.setLayoutParams(layoutParams2);
                wn.a(this.k, (String) null, 1, "#66FFFFFF", iA2 / 2);
            }
            LinearLayout linearLayout = this.e;
            if (linearLayout != null) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams3.width = -2;
                layoutParams3.height = iA2;
                this.e.setLayoutParams(layoutParams3);
                wn.a(this.e, "#66000000", 1, "#66FFFFFF", iA);
            }
            LinearLayout linearLayout2 = this.f;
            if (linearLayout2 != null) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) linearLayout2.getLayoutParams();
                layoutParams4.width = -1;
                layoutParams4.height = bq.a(this, 44.0f);
                this.f.setLayoutParams(layoutParams4);
            }
            LinearLayout linearLayout3 = this.h;
            if (linearLayout3 != null) {
                wn.a(linearLayout3, "#FFFFFF", 0, (String) null, iA);
            }
            LinearLayout linearLayout4 = this.i;
            if (linearLayout4 != null) {
                wn.a(linearLayout4, "#EBF1FF", 0, (String) null, iA2 / 3);
            }
            LinearLayout linearLayout5 = this.j;
            if (linearLayout5 != null) {
                LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) linearLayout5.getLayoutParams();
                layoutParams5.width = -1;
                layoutParams5.height = bq.a(this, 50.0f);
                this.j.setLayoutParams(layoutParams5);
            }
            TextView textView = this.w;
            if (textView != null) {
                LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) textView.getLayoutParams();
                int iA3 = bq.a(this, 120.0f);
                int iA4 = bq.a(this, 35.0f);
                layoutParams6.width = iA3;
                layoutParams6.height = iA4;
                this.w.setLayoutParams(layoutParams6);
                wn.a(this.w, "#4DFFFFFF", 0, (String) null, iA4 / 2);
            }
            LinearLayout linearLayout6 = this.Y0;
            if (linearLayout6 != null) {
                wn.a(linearLayout6, "#FFFFFF", 0, (String) null, iA);
            }
            TextView textView2 = this.c1;
            if (textView2 != null) {
                LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) textView2.getLayoutParams();
                layoutParams7.width = -1;
                int iA5 = bq.a(this, 44.0f);
                layoutParams7.height = iA5;
                wn.a(this.c1, "#3976FF", 0, (String) null, iA5 / 2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void M() {
        ImageView imageView = this.l;
        if (imageView != null) {
            imageView.setOnClickListener(new c());
        }
    }

    private void N() {
        try {
            TextView textView = (TextView) findViewById(R.id.beizi_reward_video_complaint_tv);
            textView.setVisibility(0);
            textView.setOnClickListener(new v());
            float fA = bq.a(this, 5.0f);
            wn.a(textView, "#66000000", 1, "#66FFFFFF", new float[]{0.0f, 0.0f, fA, fA, fA, fA, 0.0f, 0.0f});
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:30:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:37:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c1  */
    public void O() {
        String strK;
        String str;
        String str2;
        String strQ;
        String strO;
        String strP;
        String str3;
        int iE;
        String strG;
        String strJ;
        String strN;
        String str4;
        try {
            on onVar = this.b;
            if (onVar == null) {
                return;
            }
            if (this.E0 != this.F0) {
                List list = this.N0;
                if (list != null) {
                    int size = list.size();
                    int i2 = this.O0;
                    if (size >= i2) {
                        kl klVar = (kl) this.N0.get(i2);
                        if (klVar == null) {
                            this.A.setVisibility(8);
                            return;
                        }
                        if (!klVar.m()) {
                            this.A.setVisibility(8);
                            return;
                        }
                        int iJ = klVar.j();
                        String strB = klVar.b();
                        String strA = klVar.a();
                        String strF = klVar.f();
                        String strD = klVar.d();
                        String strC = klVar.c();
                        String strE = klVar.e();
                        strG = klVar.g();
                        iE = iJ;
                        strJ = strB;
                        strK = strA;
                        strQ = strF;
                        strO = strD;
                        strN = strC;
                        strP = strE;
                    }
                    if (iE == 2 && iE != 5) {
                        this.A.setVisibility(8);
                        return;
                    }
                    this.A.setVisibility(0);
                    if (TextUtils.isEmpty(strO)) {
                        str4 = str2;
                    } else {
                        str4 = strO;
                    }
                    this.A.setText(Html.fromHtml("应用名称：" + str + " | 开发者：" + strK + " | 应用版本：" + strQ + " | <u>权限详情</u> | <u>隐私协议</u> | <u>功能介绍</u>"));
                    this.A.setOnClickListener(new d(str, strP, str4, str3));
                }
                strK = "";
                str = null;
                str2 = "";
                strQ = str2;
                strO = strQ;
                strP = strO;
                str3 = strP;
                iE = 0;
                if (iE == 2) {
                }
                this.A.setVisibility(0);
                if (TextUtils.isEmpty(strO)) {
                    str4 = strO;
                } else {
                    str4 = str2;
                }
                this.A.setText(Html.fromHtml("应用名称：" + str + " | 开发者：" + strK + " | 应用版本：" + strQ + " | <u>权限详情</u> | <u>隐私协议</u> | <u>功能介绍</u>"));
                this.A.setOnClickListener(new d(str, strP, str4, str3));
            }
            if (!this.f0) {
                this.A.setVisibility(8);
                return;
            }
            iE = onVar.E();
            strJ = this.b.j();
            strK = this.b.k();
            strQ = this.b.q();
            strO = this.b.o();
            strN = this.b.n();
            strP = this.b.p();
            strG = this.b.r();
            str3 = strG;
            String str5 = strN;
            str = strJ;
            str2 = str5;
            if (iE == 2) {
            }
            this.A.setVisibility(0);
            if (TextUtils.isEmpty(strO)) {
                str4 = strO;
            } else {
                str4 = str2;
            }
            this.A.setText(Html.fromHtml("应用名称：" + str + " | 开发者：" + strK + " | 应用版本：" + strQ + " | <u>权限详情</u> | <u>隐私协议</u> | <u>功能介绍</u>"));
            this.A.setOnClickListener(new d(str, strP, str4, str3));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void P() {
        String strB;
        try {
            xo xoVar = this.W0;
            String strB2 = null;
            if (xoVar == null) {
                strB = null;
            } else if (this.o0) {
                strB = xoVar.a();
            } else {
                strB = xoVar.b();
                if (TextUtils.isEmpty(strB)) {
                    strB = this.W0.c();
                }
            }
            xo xoVar2 = this.X0;
            if (xoVar2 != null) {
                if (this.o0) {
                    strB2 = xoVar2.a();
                } else {
                    strB2 = xoVar2.b();
                    if (TextUtils.isEmpty(strB2)) {
                        strB2 = this.X0.c();
                    }
                }
            }
            TextView textView = this.i1;
            if (textView != null) {
                textView.setText(strB + " ｜ " + strB2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        try {
            if (this.m1 == this.n1 && !this.o0 && this.o != null) {
                this.n0 = true;
                xo xoVar = this.U0;
                String strC = xoVar != null ? xoVar.c() : null;
                xo xoVar2 = this.V0;
                String strB = xoVar2 != null ? xoVar2.b() : null;
                if (this.S0 == 0 && this.T0 == 0) {
                    if (TextUtils.isEmpty(strC)) {
                        strC = strB;
                    } else {
                        strC = strC + " ｜ " + strB;
                    }
                }
                if (this.o == null || TextUtils.isEmpty(strC)) {
                    return;
                }
                this.o.setText(strC);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void R() {
        on onVar;
        List<x1.d> listE;
        List listJ;
        kl klVarA;
        try {
            if (this.E0 != this.F0 && (onVar = this.b) != null && (listE = onVar.e()) != null && !listE.isEmpty()) {
                for (x1.d dVar : listE) {
                    if (dVar.x() == 1) {
                        if (this.M0 == null) {
                            this.M0 = new ArrayList();
                        }
                        this.M0.add(dVar);
                    }
                }
                List list = this.M0;
                if (list != null && !list.isEmpty()) {
                    ArrayList arrayList = null;
                    for (x1.d dVar2 : this.M0) {
                        if (dVar2 != null && (listJ = dVar2.j()) != null && listJ.size() > 0 && (klVarA = a(((x1.a) listJ.get(0)).d())) != null) {
                            String strI = klVarA.i();
                            if (!TextUtils.isEmpty(strI)) {
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(strI);
                                if (this.N0 == null) {
                                    this.N0 = new ArrayList();
                                }
                                x1.b bVarL = dVar2.l();
                                if (bVarL != null) {
                                    klVarA.c(bVarL.a());
                                    klVarA.a(bVarL.n());
                                    klVarA.a(bVarL.c());
                                    klVarA.g(bVarL.i());
                                    klVarA.d(bVarL.f());
                                    klVarA.e(bVarL.g());
                                    klVarA.f(bVarL.h());
                                    klVarA.h(bVarL.j());
                                    klVarA.i(bVarL.k());
                                    klVarA.b(bVarL.d());
                                }
                                this.N0.add(klVarA);
                            }
                        }
                    }
                    if (arrayList != null && !arrayList.isEmpty()) {
                        d(this.J);
                        ProgressBar progressBar = this.F;
                        if (progressBar != null) {
                            progressBar.setVisibility(8);
                        }
                        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.beizi_reward_video_group_image_container_fl);
                        BZCarouselView bZCarouselView = new BZCarouselView(this);
                        this.P0 = bZCarouselView;
                        bZCarouselView.setOnContentChangeListener(new d0());
                        this.P0.setImageUrls(arrayList);
                        im imVar = this.w0;
                        if (imVar != null) {
                            this.P0.setScrollInterval(imVar.m());
                        }
                        frameLayout.setVisibility(0);
                        frameLayout.addView(this.P0);
                        frameLayout.setOnTouchListener(new e0());
                        Y();
                        a();
                        t();
                        l();
                        Handler handler = this.K0;
                        if (handler != null) {
                            handler.sendEmptyMessageDelayed(10010, 1000L);
                        }
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void S() {
        try {
            if (!this.M && !TextUtils.isEmpty(this.p0)) {
                d(this.J);
                ProgressBar progressBar = this.F;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
                ImageView imageView = (ImageView) findViewById(R.id.beizi_reward_video_ad_image_iv);
                imageView.setVisibility(0);
                of.a(this).a(this.p0, new c0(imageView));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void T() {
        try {
            if (this.M && this.E != null && !TextUtils.isEmpty(this.W)) {
                d(this.J);
                ImageView imageView = this.l;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    if (this.I) {
                        this.l.setImageResource(R.drawable.beizi_voice_on);
                    } else {
                        this.l.setImageResource(R.drawable.beizi_voice_off);
                    }
                }
                this.E.setVisibility(0);
                if (this.H) {
                    kh.a("BeiZisAd", "isVideoCacheSuccess: true");
                    b(0);
                } else {
                    kh.a("BeiZisAd", "isVideoCacheSuccess: false");
                    this.E.setVideoPath(this.W);
                    this.E.requestFocus();
                }
                this.E.setOnCompletionListener(new f0());
                this.E.setOnPreparedListener(new g0());
                this.E.setOnErrorListener(new a());
                this.E.setOnInfoListener(new b());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        try {
            v();
            u5.a aVar = new u5.a(this);
            aVar.a(new a0());
            aVar.a().show();
            this.D0 = true;
        } catch (Exception e2) {
            e2.printStackTrace();
            this.D0 = false;
        }
    }

    private void V() {
        try {
            if (this.Z0 == null) {
                return;
            }
            a0();
            if (this.o0) {
                W();
                return;
            }
            this.s0 = true;
            v();
            this.Z0.setVisibility(0);
            o6 o6Var = this.e1;
            String strB = null;
            if (o6Var != null) {
                xo xoVarF = o6Var.f();
                strB = xoVarF != null ? xoVarF.b() : null;
                a(this.b1, this.e1.c());
                a(this.c1, this.e1.a());
                a(this.d1, this.e1.b());
            }
            if (this.a1 != null && !TextUtils.isEmpty(strB)) {
                this.a1.setText(strB.replace("__TIME__", this.K + ""));
            }
            TextView textView = this.c1;
            if (textView != null) {
                textView.setOnClickListener(new o());
            }
            TextView textView2 = this.d1;
            if (textView2 != null) {
                textView2.setOnClickListener(new p());
            }
            this.Z0.setOnClickListener(new q());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        x1.d dVarA;
        try {
            if (this.w0 == null) {
                return;
            }
            a0();
            if (this.g1) {
                return;
            }
            this.g1 = true;
            a5 a5VarC = this.w0.c();
            if (a5VarC == null) {
                a5VarC = new a5();
                a5VarC.a(0);
            }
            this.k1 = a5VarC.a();
            String strF = this.b.F();
            if (TextUtils.isEmpty(strF)) {
                this.k1 = 0;
            }
            RelativeLayout relativeLayout = this.d;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            D();
            on onVar = this.b;
            if (onVar != null && (dVarA = onVar.a(7)) != null) {
                a(dVarA, 7);
            }
            int i2 = this.k1;
            if (i2 != 0 && i2 != 1) {
                if (i2 != 2 || this.b == null) {
                    return;
                }
                v();
                I();
                HashMap map = new HashMap();
                if (this.b != null) {
                    map = new HashMap();
                    map.put("isRedirectionCanJump", Boolean.valueOf(this.b.h0()));
                    map.put("isDownload", Boolean.valueOf(this.f0));
                    map.put("landingPageUrl", strF);
                    map.put("deeplinkUrl", this.b.z());
                    map.put("webDeepLink", Boolean.valueOf(this.b.p0()));
                }
                BeiZiWebView beiZiWebView = new BeiZiWebView(this, map);
                beiZiWebView.loadUrl(strF);
                this.h1.addView(beiZiWebView);
                return;
            }
            p();
            E();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        x1.d dVarA;
        try {
            if (this.y0 != null && this.g != null) {
                a0();
                if (this.m0) {
                    return;
                }
                u();
                this.l0 = true;
                this.m0 = true;
                if (this.m1 == 1) {
                    this.n0 = true;
                }
                this.q1 = this.y0.m();
                int iB = this.y0.b();
                this.t1 = iB;
                this.u1 = iB;
                int iD = this.y0.d();
                this.r1 = iD;
                this.s1 = iD;
                this.g.setVisibility(0);
                this.g.setOnClickListener(new t());
                a(this.s, this.y0.o());
                a(this.t, this.y0.n());
                xo xoVarH = this.y0.h();
                if (xoVarH != null) {
                    String strB = xoVarH.b();
                    if (this.u != null && !TextUtils.isEmpty(strB)) {
                        if (strB.contains("__TIME__秒")) {
                            String str = this.s1 + "秒";
                            String strReplace = strB.replace("__TIME__秒", str);
                            int iIndexOf = strReplace.indexOf(str);
                            SpannableString spannableString = new SpannableString(strReplace);
                            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#3976FF")), iIndexOf, str.length() + iIndexOf, 33);
                            this.u.setText(spannableString);
                        } else {
                            this.u.setText(strB);
                        }
                    }
                }
                a(this.z, this.y0.f());
                xo xoVarE = this.y0.e();
                if (xoVarE != null) {
                    String strB2 = xoVarE.b();
                    if (this.v != null && !TextUtils.isEmpty(strB2)) {
                        this.v.setText(strB2.replace("__TIME__", this.u1 + ""));
                    }
                }
                a(this.w, this.y0.g());
                H();
                if (this.i != null) {
                    if (TextUtils.isEmpty(this.T) && TextUtils.isEmpty(this.U) && TextUtils.isEmpty(this.V)) {
                        this.i.setVisibility(8);
                    } else {
                        this.i.setVisibility(0);
                    }
                }
                x1.d dVarA2 = null;
                if (this.J0 == 0) {
                    on onVar = this.b;
                    if (onVar != null) {
                        dVarA2 = onVar.a(this.E0);
                        List list = this.M0;
                        if (list != null) {
                            int size = list.size();
                            int i2 = this.O0;
                            if (size > i2) {
                                dVarA = (x1.d) this.M0.get(i2);
                                dVarA2 = dVarA;
                            }
                        }
                    }
                } else {
                    on onVar2 = this.b;
                    if (onVar2 != null) {
                        List<x1.d> listE = onVar2.e();
                        if (listE != null && listE.size() > 0) {
                            for (x1.d dVar : listE) {
                                if (dVar.z() && !dVar.y()) {
                                    dVarA2 = dVar;
                                    break;
                                }
                            }
                        }
                        if (dVarA2 == null) {
                            dVarA = this.b.a(this.E0);
                            dVarA2 = dVarA;
                        }
                    }
                }
                a(dVarA2, this.E0, false, this.D, 47, this.x, this.y);
                a(this.n);
                a(this.j);
                if (this.w != null) {
                    if (this.y0.k() == 1) {
                        this.w.setVisibility(8);
                    } else {
                        this.w.setVisibility(0);
                    }
                    this.w.setOnClickListener(new u());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        BZCarouselView bZCarouselView;
        try {
            if (this.s0 || this.g1 || this.m0 || (bZCarouselView = this.P0) == null) {
                return;
            }
            bZCarouselView.startCarousel();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        MediaPlayer mediaPlayer;
        try {
            if (this.E != null && this.M && !this.m0 && !this.s0 && !this.g1) {
                int i2 = this.P;
                if (i2 > 0 && (mediaPlayer = this.N) != null) {
                    mediaPlayer.seekTo(i2, 3);
                }
                this.E.start();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0033  */
    private void a(x1.d dVar, int i2, boolean z2, CustomRoundImageView customRoundImageView, int i3, TextView textView, TextView textView2) {
        kl klVarA;
        String strL;
        String strK;
        String strI;
        if (dVar != null) {
            try {
                List listJ = dVar.j();
                if (listJ == null || listJ.size() <= 0 || (klVarA = a(((x1.a) listJ.get(0)).d())) == null) {
                    strL = null;
                    strI = null;
                    strK = null;
                } else {
                    strL = klVarA.l();
                    strK = klVarA.k();
                    strI = z2 ? klVarA.i() : klVarA.h();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        } else {
            strL = null;
            strI = null;
            strK = null;
        }
        a(customRoundImageView, i3, strI);
        a(textView, textView2, strL, strK);
        a(i2, dVar);
    }

    private void a0() {
        try {
            BZCarouselView bZCarouselView = this.P0;
            if (bZCarouselView != null) {
                bZCarouselView.stopCarousel();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2) {
        try {
            String strF = f();
            if (TextUtils.isEmpty(strF)) {
                return;
            }
            this.E.setVideoPath(strF);
            if (i2 == 0) {
                this.E.requestFocus();
            } else {
                this.E.start();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        try {
            BZCarouselView bZCarouselView = this.P0;
            if (bZCarouselView != null) {
                bZCarouselView.performLastCarousel();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void c() {
        Handler handler = this.K0;
        if (handler != null) {
            handler.removeCallbacks(null);
        }
        aj ajVar = this.f26938a;
        if (ajVar != null) {
            ajVar.Q();
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0() {
        try {
            BZCarouselView bZCarouselView = this.P0;
            if (bZCarouselView != null) {
                bZCarouselView.performNextCarousel();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i2) {
        try {
            if (this.o == null) {
                return;
            }
            String strReplace = null;
            if (this.J > 0 && i2 <= 0) {
                xo xoVar = this.U0;
                String strA = xoVar != null ? xoVar.a() : null;
                xo xoVar2 = this.V0;
                strReplace = xoVar2 != null ? xoVar2.a() : null;
                if (this.S0 == 0 && this.T0 == 0) {
                    strA = strA + " ｜ " + strReplace;
                }
                this.o.setText(strA);
                i();
                return;
            }
            if (this.o0) {
                return;
            }
            xo xoVar3 = this.U0;
            String strB = xoVar3 != null ? xoVar3.b() : null;
            xo xoVar4 = this.V0;
            String strB2 = xoVar4 != null ? xoVar4.b() : null;
            if (!TextUtils.isEmpty(strB)) {
                strReplace = strB.replace("__TIME__", i2 + "");
            }
            if (this.S0 != 0 || this.T0 != 0) {
                strB2 = strReplace;
            } else if (!TextUtils.isEmpty(strReplace)) {
                strB2 = strReplace + " ｜ " + strB2;
            }
            if (this.o != null && !TextUtils.isEmpty(strB2)) {
                this.o.setText(strB2);
            }
            if (i2 <= 0) {
                i();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void d0() {
        try {
            LinearLayout linearLayout = this.f;
            if (linearLayout == null) {
                return;
            }
            int[] iArr = new int[2];
            linearLayout.getLocationOnScreen(iArr);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f.getLayoutParams();
            int iA = bq.a(this, 50.0f);
            int i2 = layoutParams != null ? layoutParams.width : 0;
            if (i2 <= 0) {
                i2 = to.i(this) - bq.a(this, 30.0f);
            }
            int[] iArrB = ol.b(i2 / 2, iA / 2);
            a(0, String.valueOf(iArrB[0]), String.valueOf(iArrB[1]), String.valueOf(iArrB[0] + iArr[0]), String.valueOf(iArrB[1] + iArr[1]), String.valueOf(iArrB[0]), String.valueOf(iArrB[1]), String.valueOf(iArrB[0] + iArr[0]), String.valueOf(iArrB[1] + iArr[1]), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void e() {
        this.c = (RelativeLayout) findViewById(R.id.beizi_reward_video_ad_container_rl);
        this.E = (VideoView) findViewById(R.id.beizi_reward_video_ad_video_vv);
        this.F = (ProgressBar) findViewById(R.id.beizi_reward_video_progress_bar);
        this.d = (RelativeLayout) findViewById(R.id.beizi_reward_video_ad_voice_close_container_rl);
        this.l = (ImageView) findViewById(R.id.beizi_reward_video_ad_voice_iv);
        this.k = findViewById(R.id.beizi_reward_video_ad_voice_outline_view);
        this.e = (LinearLayout) findViewById(R.id.beizi_reward_video_ad_get_rewards_container_ll);
        this.o = (TextView) findViewById(R.id.beizi_reward_video_ad_get_rewards_close_tv);
        this.C = (CustomRoundImageView) findViewById(R.id.beizi_reward_video_ad_app_icon_iv);
        this.p = (TextView) findViewById(R.id.beizi_reward_video_ad_app_title_tv);
        this.q = (TextView) findViewById(R.id.beizi_reward_video_ad_app_subtitle_tv);
        this.B = (FrameLayout) findViewById(R.id.beizi_reward_video_ad_logo_container_fl);
        this.f = (LinearLayout) findViewById(R.id.beizi_reward_video_ad_interaction_container_ll);
        this.m = (ImageView) findViewById(R.id.beizi_reward_video_ad_interaction_iv);
        this.r = (TextView) findViewById(R.id.beizi_reward_video_ad_interaction_title_tv);
        this.A = (TextView) findViewById(R.id.beizi_reward_video_ad_app_download_info_tv);
        this.g = (LinearLayout) findViewById(R.id.beizi_reward_video_privilege_dialog_container_ll);
        this.h = (LinearLayout) findViewById(R.id.beizi_reward_video_privilege_dialog_content_container_ll);
        this.s = (TextView) findViewById(R.id.beizi_reward_video_privilege_dialog_tip_title_tv);
        this.t = (TextView) findViewById(R.id.beizi_reward_video_privilege_dialog_tip_sub_title_tv);
        this.i = (LinearLayout) findViewById(R.id.beizi_reward_video_privilege_dialog_app_info_ll);
        this.D = (CustomRoundImageView) findViewById(R.id.beizi_reward_video_privilege_dialog_app_icon_iv);
        this.x = (TextView) findViewById(R.id.beizi_reward_video_privilege_dialog_app_title_tv);
        this.y = (TextView) findViewById(R.id.beizi_reward_video_privilege_dialog_app_subtitle_tv);
        this.u = (TextView) findViewById(R.id.beizi_reward_video_privilege_dialog_tip_detail_tv);
        this.j = (LinearLayout) findViewById(R.id.beizi_reward_video_privilege_dialog_interaction_container_ll);
        this.z = (TextView) findViewById(R.id.beizi_reward_video_privilege_dialog_interaction_title_tv);
        this.n = (ImageView) findViewById(R.id.beizi_reward_video_privilege_dialog_interaction_iv);
        this.v = (TextView) findViewById(R.id.beizi_reward_video_privilege_dialog_countdown_tv);
        this.w = (TextView) findViewById(R.id.beizi_reward_video_cancel_privilege_dialog_tv);
        this.Z0 = (RelativeLayout) findViewById(R.id.beizi_reward_video_quit_dialog_container_rl);
        this.Y0 = (LinearLayout) findViewById(R.id.beizi_reward_video_quit_dialog_content_container_ll);
        this.a1 = (TextView) findViewById(R.id.beizi_reward_video_quit_dialog_get_reward_tv);
        this.b1 = (TextView) findViewById(R.id.beizi_reward_video_quit_dialog_quit_tv);
        this.c1 = (TextView) findViewById(R.id.beizi_reward_video_quit_dialog_continue_play_tv);
        this.d1 = (TextView) findViewById(R.id.beizi_reward_video_quit_dialog_close_ad_tv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        try {
            if (this.g1) {
                P();
                if (!this.m0) {
                    a(this.j1);
                }
                p();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private String f() {
        aj ajVar = this.f26938a;
        if (ajVar == null) {
            return null;
        }
        return ajVar.M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0() {
        int i2;
        try {
            il ilVar = this.y0;
            if (ilVar != null && ilVar.b() != 0 && this.m0 && this.k0 && !this.s0 && (i2 = this.u1) != -999 && !this.D0) {
                if (i2 <= 0) {
                    if (i2 == 0) {
                        A();
                        return;
                    }
                    return;
                }
                xo xoVarE = this.y0.e();
                if (xoVarE != null) {
                    String strB = xoVarE.b();
                    if (this.v != null && !TextUtils.isEmpty(strB)) {
                        this.v.setText(strB.replace("__TIME__", this.u1 + ""));
                    }
                }
                this.u1--;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void g() {
        try {
            aj ajVar = aj.S;
            this.f26938a = ajVar;
            this.Y = ajVar.g();
            this.f0 = this.f26938a.C();
            this.H = this.f26938a.O();
            AdSpacesBean.BuyerBean buyerBean = this.Y;
            if (buyerBean == null) {
                return;
            }
            if (buyerBean.getTemplate() == 1) {
                this.G = true;
            } else {
                this.G = false;
            }
            on onVarZ = this.f26938a.z();
            this.b = onVarZ;
            if (onVarZ == null) {
                return;
            }
            this.X = onVarZ.c();
            boolean zO0 = this.b.o0();
            this.M = zO0;
            if (zO0) {
                this.W = this.b.e0();
            }
            this.q0 = this.b.d0();
            this.T = this.b.m();
            this.Q = this.b.g0();
            this.R = this.b.K();
            this.U = this.b.b0();
            this.V = this.b.Y();
            this.I = !this.b.l0();
            this.p0 = this.b.G();
            im imVarW = this.b.W();
            this.w0 = imVarW;
            if (imVarW == null) {
                im imVar = new im();
                this.w0 = imVar;
                imVar.c(30);
            }
            int iG = this.w0.g();
            this.J = iG;
            if (iG <= 0) {
                int iL = this.b.L();
                if (iL > 0) {
                    this.J = iL;
                } else {
                    this.J = 30;
                }
            }
            int i2 = this.q0;
            if (i2 > 0 && this.J > i2) {
                this.J = i2;
            }
            this.x0 = this.w0.k();
            this.K = this.J;
            this.E0 = this.b.f();
            this.J0 = this.w0.f();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void h() {
        j5 j5Var = this.Q0;
        if ((j5Var != null ? j5Var.g() : 0) != 1) {
            c();
            return;
        }
        if (this.m0) {
            A();
        }
        W();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        aj ajVar;
        on onVarZ;
        try {
            if (this.o0 || (ajVar = this.f26938a) == null || (onVarZ = ajVar.z()) == null) {
                return;
            }
            this.o0 = true;
            onVarZ.a(this.f26938a.x(), this.f26938a.f(), this.f26938a.A());
            this.f26938a.a((String) null, 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        aj ajVar;
        try {
            if (this.B0 || (ajVar = this.f26938a) == null || ajVar.z() == null) {
                return;
            }
            this.B0 = true;
            this.f26938a.R();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        aj ajVar;
        try {
            if (this.C0 || (ajVar = this.f26938a) == null || ajVar.z() == null) {
                return;
            }
            this.C0 = true;
            this.f26938a.S();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        on onVarZ;
        x1.d dVarA;
        try {
            aj ajVar = this.f26938a;
            if (ajVar == null || this.A0 || (onVarZ = ajVar.z()) == null) {
                return;
            }
            this.A0 = true;
            String strX = this.f26938a.x();
            int i2 = this.E0;
            if (i2 == this.F0) {
                dVarA = onVarZ.a(i2);
            } else {
                List list = this.M0;
                dVarA = (list == null || list.size() <= 0) ? null : (x1.d) this.M0.get(this.O0);
            }
            onVarZ.a(dVarA, this.c, strX);
            this.f26938a.T();
            x1.d dVarA2 = onVarZ.a(2);
            if (dVarA2 != null) {
                a(dVarA2, 2);
            } else {
                a(dVarA, this.E0);
            }
            G();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void m() {
        j5 j5Var;
        try {
            if (this.w0 != null && (j5Var = this.Q0) != null) {
                this.S0 = j5Var.f();
                this.T0 = this.Q0.h();
                xo xoVarB = this.Q0.b();
                this.U0 = xoVarB;
                String strReplace = null;
                String strB = xoVarB != null ? xoVarB.b() : null;
                xo xoVarA = this.Q0.a();
                this.V0 = xoVarA;
                String strB2 = xoVarA != null ? xoVarA.b() : null;
                if (!TextUtils.isEmpty(strB)) {
                    strReplace = strB.replace("__TIME__", this.J + "");
                }
                if (this.S0 != 0 || this.T0 != 0) {
                    strB2 = strReplace;
                } else if (!TextUtils.isEmpty(strReplace)) {
                    strB2 = strReplace + " ｜ " + strB2;
                }
                if (this.o != null && !TextUtils.isEmpty(strB2)) {
                    this.o.setText(strB2);
                }
                if (this.S0 == 0 && this.T0 > 0) {
                    new Handler().postDelayed(new m(), this.T0 * 1000);
                }
                TextView textView = this.o;
                if (textView != null) {
                    textView.setOnClickListener(new n());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        j5 j5Var;
        try {
            if (this.w0 != null && (j5Var = this.Q0) != null) {
                int iC = j5Var.c();
                if (!ol.a(this.Q0.d())) {
                    iC = 0;
                }
                if (this.o0) {
                    iC = 0;
                }
                int iE = this.Q0.e();
                if (iC != 0) {
                    if (iC == 1) {
                        this.Q0.b(0);
                        X();
                        return;
                    } else {
                        if (iC != 2) {
                            return;
                        }
                        this.Q0.b(0);
                        d0();
                        return;
                    }
                }
                if (this.Q0.c() == 1 && iE == 1 && this.m0) {
                    return;
                }
                if (this.o0) {
                    h();
                } else {
                    V();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        try {
            if (this.w0 == null) {
                h();
                return;
            }
            o6 o6Var = this.e1;
            if (o6Var == null) {
                h();
                return;
            }
            int iD = o6Var.d();
            if (!ol.a(this.e1.e())) {
                iD = 0;
            }
            if (this.o0) {
                iD = 0;
            }
            if (iD == 0) {
                h();
                return;
            }
            if (iD == 1) {
                b();
                this.e1.b(0);
                if (this.m0) {
                    A();
                }
                W();
                return;
            }
            if (iD == 2) {
                b();
                this.e1.b(0);
                X();
            } else if (iD == 3) {
                b();
                this.e1.b(0);
                d0();
            } else {
                if (iD != 4) {
                    return;
                }
                this.e1.b(0);
                b();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            h();
        }
    }

    private void p() {
        MediaPlayer mediaPlayer;
        try {
            if (this.k1 != 1 || this.r0) {
                H();
                return;
            }
            if (this.E == null || !this.M) {
                return;
            }
            int i2 = this.P;
            if (i2 > 0 && (mediaPlayer = this.N) != null) {
                mediaPlayer.seekTo(i2, 3);
            }
            ImageView imageView = this.l;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.beizi_voice_off);
            }
            this.I = false;
            this.N.setVolume(0.0f, 0.0f);
            this.E.start();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        try {
            if (this.w0 == null) {
                c();
                return;
            }
            j5 j5Var = this.R0;
            if (j5Var == null) {
                c();
                return;
            }
            int iC = j5Var.c();
            if (!ol.a(this.R0.d())) {
                iC = 0;
            }
            if (this.o0) {
                iC = 0;
            }
            if (iC == 0) {
                c();
                return;
            }
            if (iC == 1) {
                this.R0.b(0);
                X();
            } else {
                if (iC != 2) {
                    return;
                }
                this.R0.b(0);
                d0();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            c();
        }
    }

    private void r() {
        AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleRule;
        try {
            if (this.Y == null || q1.h().u() || (eulerAngleRule = this.Y.getEulerAngleRule()) == null) {
                return;
            }
            q7 q7Var = new q7(this, eulerAngleRule, this.Y.getSpaceId(), this.X);
            this.c0 = q7Var;
            q7Var.a(new g());
            this.i0 = "eulerAngle";
            this.h0 = this.c0.c();
            a(this.m);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void s() {
        AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClick;
        try {
            AdSpacesBean.BuyerBean buyerBean = this.Y;
            if (buyerBean == null || (fullScreenClick = buyerBean.getFullScreenClick()) == null) {
                return;
            }
            k8 k8Var = new k8(this, fullScreenClick, this.X);
            this.d0 = k8Var;
            k8Var.a(this.c, new h());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        try {
            if (this.Y == null) {
                return;
            }
            LinearLayout linearLayout = this.f;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            s();
            y();
            z();
            r();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        try {
            sn snVar = this.a0;
            if (snVar != null) {
                snVar.m();
            }
            q7 q7Var = this.c0;
            if (q7Var != null) {
                q7Var.l();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void v() {
        try {
            VideoView videoView = this.E;
            if (videoView != null && this.M) {
                int currentPosition = videoView.getCurrentPosition();
                if (currentPosition > 0) {
                    this.P = currentPosition;
                }
                H();
            }
            sn snVar = this.a0;
            if (snVar != null) {
                snVar.l();
            }
            q7 q7Var = this.c0;
            if (q7Var != null) {
                q7Var.k();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        xo xoVarN;
        try {
            if (this.S) {
                return;
            }
            if (this.m0) {
                a(this.n);
            }
            if (this.O && !this.s0 && this.m0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                long j2 = this.j0;
                long j3 = jCurrentTimeMillis - j2;
                if (this.x0 != 3) {
                    if (j2 <= 0) {
                        return;
                    }
                    if (this.m1 == this.n1 && !this.n0) {
                        return;
                    }
                    if ((j3 > this.s1 * 1000 && this.l1 == 0) || (this.l1 == 1 && this.o0)) {
                        i();
                        d(0);
                    }
                } else {
                    if (j2 <= 0 && this.r1 > 0) {
                        return;
                    }
                    int i2 = this.I0;
                    if ((i2 > 0 && this.H0 >= i2) || j3 > this.s1 * 1000) {
                        i();
                        d(0);
                    }
                }
                b(this.s, this.y0.o());
                int i3 = ((int) (((long) (this.s1 * 1000)) - j3)) / 1000;
                this.s1 = i3;
                if (i3 <= 0) {
                    this.s1 = 1;
                }
                if (this.t != null && (xoVarN = this.y0.n()) != null) {
                    String strC = xoVarN.c();
                    if (this.o0) {
                        strC = xoVarN.a();
                    }
                    if (!TextUtils.isEmpty(strC)) {
                        if (strC.contains("__TIME__秒")) {
                            String str = this.s1 + "秒";
                            String strReplace = strC.replace("__TIME__秒", str);
                            SpannableString spannableString = new SpannableString(strReplace);
                            int iIndexOf = strReplace.indexOf(str);
                            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#3976FF")), iIndexOf, str.length() + iIndexOf, 33);
                            this.t.setText(spannableString);
                        } else {
                            this.t.setText(strC);
                        }
                    }
                }
                b(this.u, this.y0.h());
                b(this.z, this.y0.f());
                this.u1 = AlibcCommonConstant.HTTP_INVALID_RESPONSE_CODE;
                b(this.v, this.y0.e());
                b(this.w, this.y0.g());
                if (this.l1 == 1) {
                    this.v.setOnClickListener(new w());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        try {
            il ilVar = this.y0;
            if (ilVar == null) {
                return;
            }
            int i2 = ilVar.i();
            if (!ol.a(this.y0.j())) {
                i2 = 0;
            }
            boolean z2 = this.o0;
            if (z2) {
                i2 = 0;
            }
            if (i2 != 0) {
                if (i2 != 1) {
                    return;
                }
                this.y0.f(0);
                d0();
                return;
            }
            if (z2) {
                h();
            } else {
                A();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void y() {
        try {
            AdSpacesBean.BuyerBean buyerBean = this.Y;
            if (buyerBean == null) {
                return;
            }
            AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickView = buyerBean.getRegionalClickView();
            String str = "#3976FF";
            if (regionalClickView == null) {
                regionalClickView = new AdSpacesBean.BuyerBean.RegionalClickViewBean();
                regionalClickView.setBackgroundAlpha(1.0d);
                regionalClickView.setBackgroundColor("#3976FF");
                regionalClickView.setTitle("点击跳转网页或第三方应用");
                regionalClickView.setTitleColor("#FFFFFF");
            }
            this.g0 = regionalClickView.getTitle();
            tl tlVar = new tl(this, regionalClickView, this.X, this.f0);
            this.Z = tlVar;
            String strA = tlVar.a();
            if (!TextUtils.isEmpty(strA)) {
                str = strA;
            }
            LinearLayout linearLayout = this.f;
            if (linearLayout != null) {
                wn.a(linearLayout, str, 0, (String) null, bq.a(this, 5.0f));
                this.Z.a(this.f, this.r);
                this.Z.a(new e());
            }
            LinearLayout linearLayout2 = this.j;
            if (linearLayout2 != null) {
                wn.a(linearLayout2, "#2A8BEF", 0, (String) null, bq.a(this, 25.0f));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void z() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView;
        try {
            if (this.Y == null || q1.h().u() || (shakeView = this.Y.getShakeView()) == null) {
                return;
            }
            sn snVar = new sn(this, shakeView, this.Y.getSpaceId(), this.X);
            this.a0 = snVar;
            snVar.a(new f());
            this.i0 = "shake";
            this.h0 = this.a0.c();
            a(this.m);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.activity_beizi_reward_video);
            e();
            g();
            L();
            N();
            if (this.E0 != this.F0) {
                R();
            } else if (this.M) {
                T();
            } else {
                S();
            }
            int i2 = 3;
            x1.d dVarA = this.b.a(3);
            if (dVarA == null) {
                dVarA = this.b.a(this.E0);
                i2 = this.E0;
            } else {
                this.L0 = true;
            }
            a(dVarA, i2, this.L0, this.C, 55, this.p, this.q);
            F();
            C();
            B();
            m();
            M();
            O();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            tl tlVar = this.Z;
            if (tlVar != null) {
                tlVar.b();
            }
            this.Z = null;
            sn snVar = this.a0;
            if (snVar != null) {
                snVar.k();
            }
            this.a0 = null;
            q7 q7Var = this.c0;
            if (q7Var != null) {
                q7Var.j();
            }
            this.c0 = null;
            kn knVar = this.b0;
            if (knVar != null) {
                knVar.b();
            }
            this.b0 = null;
            k8 k8Var = this.d0;
            if (k8Var != null) {
                k8Var.b();
            }
            this.d0 = null;
            Handler handler = this.K0;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.K0 = null;
            d();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 || i2 == 3) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.k0 = false;
        v();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            if (this.b == null || this.f26938a == null) {
                finish();
            }
            this.k0 = true;
            u();
            w();
            e0();
            this.j0 = 0L;
            if (this.o0) {
                return;
            }
            VideoView videoView = this.E;
            if (videoView != null && this.M && !this.r0 && !this.s0 && !this.m0 && !this.g1 && !videoView.isPlaying()) {
                this.E.resume();
            }
            if (!this.S) {
                Y();
            }
            this.S = false;
        } catch (Exception unused) {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        if (this.m0) {
            if (!this.O) {
                this.j0 = 0L;
            } else if (this.r1 >= 0) {
                this.j0 = System.currentTimeMillis();
            } else {
                this.j0 = 0L;
            }
        }
    }

    public class a0 implements u5.b {
        public a0() {
        }

        @Override // com.beizi.fusion.u5.b
        public void a(String str) {
            try {
                aj ajVar = BeiZiNewRewardVideoActivity.this.f26938a;
                if (ajVar == null) {
                    return;
                }
                ajVar.g(str);
                BeiZiNewRewardVideoActivity.this.f26938a.Q();
                BeiZiNewRewardVideoActivity.this.finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.beizi.fusion.u5.b
        public void a() {
            BeiZiNewRewardVideoActivity beiZiNewRewardVideoActivity = BeiZiNewRewardVideoActivity.this;
            beiZiNewRewardVideoActivity.D0 = false;
            beiZiNewRewardVideoActivity.u();
            BeiZiNewRewardVideoActivity.this.Z();
        }
    }

    private void c(int i2) {
        on onVarZ;
        aj ajVar = this.f26938a;
        if (ajVar == null || (onVarZ = ajVar.z()) == null) {
            return;
        }
        String strX = this.f26938a.x();
        if (i2 == 25) {
            onVarZ.b(this.c, strX);
        } else if (i2 == 50) {
            onVarZ.c(this.c, strX);
        } else if (i2 == 75) {
            onVarZ.d(this.c, strX);
        }
    }

    public class c0 implements of.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ImageView f26944a;

        public c0(ImageView imageView) {
            this.f26944a = imageView;
        }

        @Override // com.beizi.fusion.of.f
        public void a(Bitmap bitmap) {
            try {
                BeiZiNewRewardVideoActivity.this.a(bitmap, this.f26944a);
                BeiZiNewRewardVideoActivity.this.a();
                BeiZiNewRewardVideoActivity.this.t();
                BeiZiNewRewardVideoActivity.this.l();
                Handler handler = BeiZiNewRewardVideoActivity.this.K0;
                if (handler != null) {
                    handler.sendEmptyMessageDelayed(10010, 1000L);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.beizi.fusion.of.f
        public void a() {
            BeiZiNewRewardVideoActivity.this.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            this.s0 = false;
            RelativeLayout relativeLayout = this.Z0;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            u();
            Z();
            Y();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public kl a(String str) {
        try {
            if (!TextUtils.isEmpty(str) && str.startsWith(bv9.b)) {
                JSONObject jSONObject = new JSONObject(str);
                String strE = jSONObject.has("title") ? ng.e(jSONObject, "title") : null;
                String strE2 = jSONObject.has("desc") ? ng.e(jSONObject, "desc") : null;
                String strE3 = jSONObject.has("appIcon") ? ng.e(jSONObject, "appIcon") : null;
                String strE4 = jSONObject.has("lauchImageUrl") ? ng.e(jSONObject, "lauchImageUrl") : null;
                kl klVar = new kl();
                klVar.m(strE);
                klVar.l(strE2);
                klVar.j(strE3);
                klVar.k(strE4);
                return klVar;
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return null;
    }

    private void b(TextView textView, xo xoVar) {
        if (textView == null || xoVar == null) {
            return;
        }
        try {
            String strC = xoVar.c();
            if (this.o0) {
                strC = xoVar.a();
            }
            if (TextUtils.isEmpty(strC)) {
                return;
            }
            textView.setText(strC);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void d() {
        try {
            lj ljVar = this.v1;
            if (ljVar != null) {
                ljVar.b();
            }
            this.v1 = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CustomRoundImageView customRoundImageView, int i2, String str) {
        try {
            if (this.b == null || customRoundImageView == null) {
                return;
            }
            if (TextUtils.isEmpty(str)) {
                customRoundImageView.setVisibility(8);
                return;
            }
            int iA = bq.a(this, i2);
            customRoundImageView.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) customRoundImageView.getLayoutParams();
            layoutParams.width = iA;
            layoutParams.height = iA;
            customRoundImageView.setLayoutParams(layoutParams);
            of.a(this).a(str, new b0(customRoundImageView, iA));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, TextView textView2, String str, String str2) {
        if (textView != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    textView.setVisibility(0);
                    textView.setText(str);
                } else {
                    textView.setVisibility(8);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (textView2 != null) {
            if (!TextUtils.isEmpty(str2)) {
                textView2.setVisibility(0);
                textView2.setText(str2);
            } else {
                textView2.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            FrameLayout frameLayoutB = bq.b(this, this.b.H());
            frameLayoutB.setVisibility(0);
            linearLayout.addView(frameLayoutB, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            View viewA = bq.a(this, this.b.h());
            viewA.setVisibility(0);
            linearLayout.addView(viewA, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewA.getLayoutParams();
            layoutParams.setMargins(5, 0, 0, 0);
            layoutParams.gravity = 17;
            viewA.setLayoutParams(layoutParams);
            if (this.B != null) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 85);
                int iA = bq.a(this, 8.0f);
                layoutParams2.setMargins(0, 0, iA, iA);
                this.B.addView(linearLayout, layoutParams2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i2) {
        try {
            ProgressBar progressBar = this.F;
            if (progressBar == null) {
                return;
            }
            progressBar.setProgress(i2 / 1000);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:59:0x00db  */
    /* JADX WARN: Code duplicated, block: B:72:0x0107  */
    public void a(int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i3) {
        on onVarZ;
        x1.d dVarA;
        try {
            if (this.f26938a != null && !this.s0 && hasWindowFocus() && (onVarZ = this.f26938a.z()) != null) {
                if (this.m1 == this.n1 && this.n0 && this.r1 > 0 && !this.o0) {
                    X();
                }
                String strX = this.f26938a.x();
                g5 g5Var = new g5();
                g5Var.g(str);
                g5Var.c(str5);
                g5Var.h(str2);
                g5Var.d(str6);
                g5Var.e(str3);
                g5Var.a(str7);
                g5Var.f(str4);
                g5Var.b(str8);
                onVarZ.c(true);
                a0();
                if (this.J0 != 0) {
                    List listE = onVarZ.e();
                    if (listE != null && listE.size() > 0) {
                        Iterator it = listE.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                dVarA = null;
                                break;
                            }
                            x1.d dVar = (x1.d) it.next();
                            if (dVar.z() && !dVar.y()) {
                                dVarA = dVar;
                                break;
                            }
                        }
                    } else {
                        dVarA = null;
                        break;
                    }
                } else if (i2 != 2 && i2 != 7) {
                    if (this.E0 == this.F0) {
                        if (!this.g1) {
                            dVarA = null;
                            break;
                        }
                        dVarA = onVarZ.a(5);
                    } else {
                        List list = this.M0;
                        if (list == null || list.size() <= 0) {
                            dVarA = null;
                            break;
                        } else if (!this.g1) {
                            dVarA = (x1.d) this.M0.get(this.O0);
                        } else {
                            dVarA = onVarZ.a(5);
                            if (dVarA == null) {
                                dVarA = (x1.d) this.M0.get(0);
                            }
                        }
                    }
                } else {
                    x1.d dVarA2 = onVarZ.a(i2);
                    if (dVarA2 != null) {
                        dVarA = dVarA2;
                    } else if (this.E0 == this.F0) {
                        if (this.g1) {
                            dVarA = onVarZ.a(5);
                        } else {
                            dVarA = dVarA2;
                        }
                    } else {
                        List list2 = this.M0;
                        if (list2 == null || list2.size() <= 0) {
                            dVarA = dVarA2;
                        } else if (i2 == 2) {
                            dVarA = (x1.d) this.M0.get(this.O0);
                        } else if (i2 == 7) {
                            dVarA = (x1.d) this.M0.get(0);
                        } else {
                            dVarA = dVarA2;
                        }
                    }
                }
                if (dVarA == null) {
                    dVarA = onVarZ.a(this.E0);
                }
                onVarZ.a(dVarA, this.c, g5Var, String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis() + 10), this.O, strX, i3);
                this.O = true;
                if (this.m0 && this.x0 == 3) {
                    this.H0++;
                }
                this.f26938a.P();
                if (this.m0) {
                    c0();
                }
                lj ljVar = this.v1;
                if (ljVar != null) {
                    ljVar.c();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(ImageView imageView) {
        if (imageView == null) {
            return;
        }
        try {
            if ("shake".equals(this.i0)) {
                imageView.setVisibility(0);
                imageView.setImageResource(R.mipmap.beizi_interaction_icon_shake);
                if (!TextUtils.isEmpty(this.h0)) {
                    of.a(this).b(this.h0, new i(imageView));
                }
                sn snVar = this.a0;
                if (snVar != null) {
                    snVar.a(imageView);
                    return;
                }
                return;
            }
            if ("eulerAngle".equals(this.i0)) {
                imageView.setVisibility(0);
                imageView.setImageResource(R.mipmap.beizi_interaction_icon_euler_angle);
                if (!TextUtils.isEmpty(this.h0)) {
                    of.a(this).b(this.h0, new j(imageView));
                }
                q7 q7Var = this.c0;
                if (q7Var != null) {
                    q7Var.a(imageView);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(View view) {
        if (view == null) {
            return;
        }
        view.setOnTouchListener(new l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3) {
        double d2 = i3;
        double d3 = i2;
        if (d2 >= 0.25d * d3 && !this.t0) {
            this.t0 = true;
            c(25);
        }
        if (d2 >= 0.5d * d3 && !this.u0) {
            this.u0 = true;
            c(50);
        }
        if (d2 < d3 * 0.75d || this.v0) {
            return;
        }
        this.v0 = true;
        c(75);
    }

    private void a(FrameLayout frameLayout) {
        try {
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            FrameLayout frameLayoutB = bq.b(this, this.b.H());
            frameLayoutB.setVisibility(0);
            linearLayout.addView(frameLayoutB, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            View viewA = bq.a(this, this.b.h());
            viewA.setVisibility(0);
            linearLayout.addView(viewA, new LinearLayout.LayoutParams(-2, -2, 17.0f));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewA.getLayoutParams();
            layoutParams.setMargins(5, 0, 0, 0);
            layoutParams.gravity = 17;
            viewA.setLayoutParams(layoutParams);
            if (frameLayout != null) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 85);
                layoutParams2.setMargins(0, 0, bq.a(this, 12.0f), bq.a(this, 30.0f));
                frameLayout.addView(linearLayout, layoutParams2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(TextView textView, xo xoVar) {
        if (textView == null || xoVar == null) {
            return;
        }
        try {
            String strB = xoVar.b();
            if (TextUtils.isEmpty(strB)) {
                return;
            }
            textView.setText(strB);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(x1.d dVar, int i2) {
        kj kjVarQ;
        List listJ;
        kl klVarA;
        try {
            on onVar = this.b;
            if (onVar != null && this.c != null) {
                if (i2 == 7) {
                    kjVarQ = onVar.B();
                } else {
                    kjVarQ = onVar.Q();
                }
                kj kjVar = kjVarQ;
                if (kjVar == null) {
                    return;
                }
                if (dVar != null && (listJ = dVar.j()) != null && listJ.size() > 0 && (klVarA = a(((x1.a) listJ.get(0)).d())) != null) {
                    String strI = klVarA.i();
                    if (!TextUtils.isEmpty(strI)) {
                        kjVar.c(strI);
                    }
                    String strL = klVarA.l();
                    if (!TextUtils.isEmpty(strL)) {
                        kjVar.d(strL);
                    }
                    String strK = klVarA.k();
                    if (!TextUtils.isEmpty(strK)) {
                        kjVar.b(strK);
                    }
                }
                lj ljVar = this.v1;
                if (ljVar != null) {
                    ljVar.b();
                    this.v1 = null;
                }
                this.v1 = new lj();
                this.v1.a(this.c, to.h(this), to.g(this), kjVar, new x(i2, dVar));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2) {
        try {
            int[] iArr = new int[2];
            int width = this.f.getWidth();
            int height = this.f.getHeight();
            this.f.getLocationOnScreen(iArr);
            int[] iArrB = ol.b(width / 2, height / 2);
            a(i2, String.valueOf(iArrB[0]), String.valueOf(iArrB[1]), String.valueOf(iArrB[0] + iArr[0]), String.valueOf(iArrB[1] + iArr[1]), String.valueOf(iArrB[0]), String.valueOf(iArrB[1]), String.valueOf(iArrB[0] + iArr[0]), String.valueOf(iArrB[1] + iArr[1]), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, x1.d dVar) {
        if (i2 == 0 || dVar == null) {
            return;
        }
        try {
            aj ajVar = this.f26938a;
            if (ajVar == null) {
                return;
            }
            String strX = ajVar.x();
            on onVar = this.b;
            if (onVar == null) {
                return;
            }
            onVar.a(dVar, this.c, strX);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bitmap bitmap, ImageView imageView) {
        try {
            float fAbs = Math.abs(((float) ((((double) to.h(this)) * 1.0d) / ((double) to.g(this)))) - ((float) ((((double) bitmap.getWidth()) * 1.0d) / ((double) bitmap.getHeight()))));
            if (fAbs > 0.1f) {
                w3.c().e().execute(new y(bitmap, imageView));
            } else if (fAbs > 0.07d) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else {
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            imageView.setImageBitmap(bitmap);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(x1.d dVar, ImageView imageView) {
        rn rnVarW;
        try {
            if (q1.h().u() || dVar == null || (rnVarW = dVar.w()) == null) {
                return;
            }
            sn snVar = this.a0;
            if (snVar != null) {
                snVar.k();
                this.a0 = null;
            }
            int i2 = rnVarW.i();
            double dK = rnVarW.k();
            double dJ = rnVarW.j();
            int iH = rnVarW.h();
            int iB = rnVarW.b();
            double d2 = rnVarW.d();
            double dC = rnVarW.c();
            int iA = rnVarW.a();
            boolean z2 = true;
            if (rnVarW.e() != 1 || iB <= 0 || d2 <= AudioStats.AUDIO_AMPLITUDE_NONE || dC <= AudioStats.AUDIO_AMPLITUDE_NONE) {
                z2 = false;
            }
            AdSpacesBean.BuyerBean.ShakeViewBean shakeViewBean = new AdSpacesBean.BuyerBean.ShakeViewBean();
            if (this.w1 && z2) {
                shakeViewBean.setShakeCount(iB);
                shakeViewBean.setShakeStartAmplitude(d2);
                shakeViewBean.setShakeEndAmplitude(dC);
                shakeViewBean.setRegulatoryAngle(iA);
            } else {
                shakeViewBean.setShakeCount(i2);
                shakeViewBean.setShakeStartAmplitude(dK);
                shakeViewBean.setShakeEndAmplitude(dJ);
                shakeViewBean.setRegulatoryAngle(iH);
            }
            sn snVar2 = new sn(this, shakeViewBean, null, null);
            this.a0 = snVar2;
            snVar2.a(new z(z2, iB, d2, dC, iA));
            this.i0 = "shake";
            this.h0 = this.a0.c();
            a(imageView);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}

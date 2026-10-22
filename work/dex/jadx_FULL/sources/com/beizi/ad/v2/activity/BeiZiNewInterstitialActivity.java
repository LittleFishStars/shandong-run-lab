package com.beizi.ad.v2.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.camera.video.AudioStats;
import com.beizi.ad.internal.activity.DownloadAppInfoActivity;
import com.beizi.ad.internal.view.CustomRoundImageView;
import com.beizi.fusion.R;
import com.beizi.fusion.bq;
import com.beizi.fusion.cl;
import com.beizi.fusion.f5;
import com.beizi.fusion.g5;
import com.beizi.fusion.k8;
import com.beizi.fusion.kh;
import com.beizi.fusion.kj;
import com.beizi.fusion.kn;
import com.beizi.fusion.lj;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.of;
import com.beizi.fusion.oh;
import com.beizi.fusion.ol;
import com.beizi.fusion.on;
import com.beizi.fusion.q1;
import com.beizi.fusion.q7;
import com.beizi.fusion.qf;
import com.beizi.fusion.sn;
import com.beizi.fusion.so;
import com.beizi.fusion.tl;
import com.beizi.fusion.to;
import com.beizi.fusion.u5;
import com.beizi.fusion.vp;
import com.beizi.fusion.widget.BZLpView;
import com.beizi.fusion.wk;
import com.beizi.fusion.wn;
import com.beizi.fusion.xi;
import com.beizi.fusion.yo;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BeiZiNewInterstitialActivity extends Activity {
    private View A;
    private boolean D;
    private MediaPlayer E;
    private int G;
    private boolean H;
    private int I;
    private CountDownTimer J;
    private String L;
    private String M;
    private String N;
    private String O;
    private String P;
    private AdSpacesBean.BuyerBean Q;
    private tl R;
    private sn S;
    private kn T;
    private q7 U;
    private k8 V;
    private Timer X;
    private TimerTask Y;
    private boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private xi f26894a;
    private on b;
    private lj b0;
    private RelativeLayout c;
    private f5 c0;
    private RelativeLayout d;
    private int d0;
    private LinearLayout e;
    private int e0;
    private LinearLayout f;
    private String f0;
    private LinearLayout g;
    private TextView h;
    private BZLpView h0;
    private TextView i;
    private boolean i0;
    private TextView j;
    private boolean j0;
    private TextView k;
    private TextView l;
    private boolean l0;
    private RelativeLayout m;
    private boolean m0;
    private RelativeLayout n;
    private boolean n0;
    private RelativeLayout o;
    private RelativeLayout p;
    private RelativeLayout q;
    private RelativeLayout r;
    private FrameLayout s;
    private CustomRoundImageView t;
    private CustomRoundImageView u;
    private ImageView v;
    private ImageView w;
    private ImageView x;
    private VideoView y;
    private View z;
    private boolean B = false;
    private boolean C = false;
    private boolean F = false;
    private boolean K = true;
    private boolean W = true;
    protected Handler a0 = new k(Looper.getMainLooper());
    private ViewGroup g0 = null;
    private boolean k0 = true;

    public class a implements MediaPlayer.OnPreparedListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                BeiZiNewInterstitialActivity.this.E = mediaPlayer;
                kh.a("BeiZisAd", "onPrepared: 准备完成");
                BeiZiNewInterstitialActivity beiZiNewInterstitialActivity = BeiZiNewInterstitialActivity.this;
                if (beiZiNewInterstitialActivity.C) {
                    beiZiNewInterstitialActivity.E.setVolume(0.0f, 1.0f);
                } else {
                    beiZiNewInterstitialActivity.E.setVolume(0.0f, 0.0f);
                }
                BeiZiNewInterstitialActivity beiZiNewInterstitialActivity2 = BeiZiNewInterstitialActivity.this;
                if (beiZiNewInterstitialActivity2.y != null) {
                    int i = beiZiNewInterstitialActivity2.G;
                    if (i > 0) {
                        beiZiNewInterstitialActivity2.E.seekTo(i, 3);
                    } else {
                        beiZiNewInterstitialActivity2.E.seekTo(2L, 3);
                    }
                    RelativeLayout relativeLayout = BeiZiNewInterstitialActivity.this.p;
                    if (relativeLayout != null && relativeLayout.getVisibility() == 8) {
                        BeiZiNewInterstitialActivity.this.y.start();
                    }
                }
                BeiZiNewInterstitialActivity beiZiNewInterstitialActivity3 = BeiZiNewInterstitialActivity.this;
                if (beiZiNewInterstitialActivity3.W) {
                    if (!beiZiNewInterstitialActivity3.H || beiZiNewInterstitialActivity3.I <= 0) {
                        int duration = mediaPlayer.getDuration() / 1000;
                        TextView textView = BeiZiNewInterstitialActivity.this.i;
                        if (textView != null) {
                            textView.setText(String.valueOf(duration));
                        }
                    }
                    BeiZiNewInterstitialActivity.this.E();
                    BeiZiNewInterstitialActivity.this.a();
                    BeiZiNewInterstitialActivity.this.o();
                    BeiZiNewInterstitialActivity.this.k();
                    Handler handler = BeiZiNewInterstitialActivity.this.a0;
                    if (handler != null) {
                        handler.sendEmptyMessageDelayed(10010, 1000L);
                    }
                    BeiZiNewInterstitialActivity.this.A();
                }
                BeiZiNewInterstitialActivity.this.W = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class b implements MediaPlayer.OnErrorListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                vp vpVarC = vp.c();
                BeiZiNewInterstitialActivity beiZiNewInterstitialActivity = BeiZiNewInterstitialActivity.this;
                vpVarC.a(beiZiNewInterstitialActivity, beiZiNewInterstitialActivity.O);
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                BeiZiNewInterstitialActivity.this.e();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                BeiZiNewInterstitialActivity beiZiNewInterstitialActivity = BeiZiNewInterstitialActivity.this;
                if (beiZiNewInterstitialActivity.C) {
                    beiZiNewInterstitialActivity.v.setImageResource(R.drawable.beizi_voice_off);
                    MediaPlayer mediaPlayer = BeiZiNewInterstitialActivity.this.E;
                    if (mediaPlayer != null) {
                        mediaPlayer.setVolume(0.0f, 0.0f);
                    }
                } else {
                    beiZiNewInterstitialActivity.v.setImageResource(R.drawable.beizi_voice_on);
                    MediaPlayer mediaPlayer2 = BeiZiNewInterstitialActivity.this.E;
                    if (mediaPlayer2 != null) {
                        mediaPlayer2.setVolume(0.0f, 1.0f);
                    }
                }
                BeiZiNewInterstitialActivity beiZiNewInterstitialActivity2 = BeiZiNewInterstitialActivity.this;
                beiZiNewInterstitialActivity2.C = !beiZiNewInterstitialActivity2.C;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f26899a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;

        public e(String str, String str2, String str3, String str4) {
            this.f26899a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Intent intent = new Intent(BeiZiNewInterstitialActivity.this, (Class<?>) DownloadAppInfoActivity.class);
                intent.putExtra("title_content_key", this.f26899a);
                intent.putExtra("privacy_content_key", this.b);
                intent.putExtra("permission_content_key", this.c);
                intent.putExtra("intro_content_key", this.d);
                intent.setFlags(268435456);
                BeiZiNewInterstitialActivity.this.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class f implements tl.c {
        public f() {
        }

        @Override // com.beizi.fusion.tl.c
        public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            kh.a("BeiZisAd", "handleRegionalClickViewContent click");
            BeiZiNewInterstitialActivity.this.a(str, str2, str3, str4, str5, str6, str7, str8, 0);
        }
    }

    public class g implements sn.f {
        public g() {
        }

        @Override // com.beizi.fusion.sn.f
        public void a() {
            kh.a("BeiZisAd", "handleShakeViewContent click");
            BeiZiNewInterstitialActivity.this.d();
            BeiZiNewInterstitialActivity.this.a("", "", "", "", "", "", "", "", 2);
            BeiZiNewInterstitialActivity.this.B();
        }
    }

    public class h implements kn.d {
        public h() {
        }

        @Override // com.beizi.fusion.kn.d
        public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            k8 k8Var = BeiZiNewInterstitialActivity.this.V;
            if (k8Var == null || !k8Var.a()) {
                return;
            }
            kh.a("BeiZisAd", "handleScrollViewContent scroll click");
            BeiZiNewInterstitialActivity.this.a(str, str2, str3, str4, str5, str6, str7, str8, 0);
        }

        @Override // com.beizi.fusion.kn.d
        public void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            kh.a("BeiZisAd", "handleScrollViewContent scroll");
            BeiZiNewInterstitialActivity.this.a(str, str2, str3, str4, str5, str6, str7, str8, 1);
        }
    }

    public class i implements q7.e {
        public i() {
        }

        @Override // com.beizi.fusion.q7.e
        public void a() {
            kh.a("BeiZisAd", "handleEulerAngleViewContent click");
            BeiZiNewInterstitialActivity.this.a("", "", "", "", "", "", "", "", 2);
        }
    }

    public class j implements k8.b {
        public j() {
        }

        @Override // com.beizi.fusion.k8.b
        public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            kh.a("BeiZisAd", "handleFullScreenClickContent click");
            BeiZiNewInterstitialActivity.this.a(str, str2, str3, str4, str5, str6, str7, str8, 0);
        }
    }

    public class k extends Handler {
        public k(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            VideoView videoView;
            int i = message.what;
            if (i == 10001) {
                BeiZiNewInterstitialActivity.this.l();
                return;
            }
            if (i != 10010) {
                return;
            }
            try {
                Handler handler = BeiZiNewInterstitialActivity.this.a0;
                if (handler != null) {
                    handler.sendEmptyMessageDelayed(10010, 1000L);
                }
                BeiZiNewInterstitialActivity beiZiNewInterstitialActivity = BeiZiNewInterstitialActivity.this;
                if (beiZiNewInterstitialActivity.D && (videoView = beiZiNewInterstitialActivity.y) != null && videoView.isPlaying()) {
                    BeiZiNewInterstitialActivity.this.a(BeiZiNewInterstitialActivity.this.y.getDuration(), BeiZiNewInterstitialActivity.this.y.getCurrentPosition());
                }
            } catch (Exception unused) {
            }
        }
    }

    public class l extends TimerTask {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                int duration;
                try {
                    BeiZiNewInterstitialActivity beiZiNewInterstitialActivity = BeiZiNewInterstitialActivity.this;
                    if (beiZiNewInterstitialActivity.i == null || (duration = (beiZiNewInterstitialActivity.y.getDuration() - BeiZiNewInterstitialActivity.this.y.getCurrentPosition()) / 1000) <= 0) {
                        return;
                    }
                    BeiZiNewInterstitialActivity.this.i.setText(String.valueOf(duration));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public l() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                VideoView videoView = BeiZiNewInterstitialActivity.this.y;
                if (videoView == null || !videoView.isPlaying()) {
                    return;
                }
                BeiZiNewInterstitialActivity.this.runOnUiThread(new a());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class m implements lj.e {
        public m() {
        }

        @Override // com.beizi.fusion.lj.e
        public void a() {
            BeiZiNewInterstitialActivity.this.l();
        }

        @Override // com.beizi.fusion.lj.e
        public void b() {
        }
    }

    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BeiZiNewInterstitialActivity beiZiNewInterstitialActivity = BeiZiNewInterstitialActivity.this;
            if (beiZiNewInterstitialActivity.F) {
                return;
            }
            beiZiNewInterstitialActivity.e0 = 2;
            beiZiNewInterstitialActivity.l();
            BeiZiNewInterstitialActivity.this.B();
        }
    }

    public class o implements BZLpView.d {
        public o() {
        }

        @Override // com.beizi.fusion.widget.BZLpView.d
        public void onDetachedFromWindow() {
            BeiZiNewInterstitialActivity.this.w();
        }
    }

    public class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                BeiZiNewInterstitialActivity beiZiNewInterstitialActivity = BeiZiNewInterstitialActivity.this;
                if (beiZiNewInterstitialActivity.k0) {
                    beiZiNewInterstitialActivity.y();
                    BeiZiNewInterstitialActivity.this.w();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class q extends CountDownTimer {
        public q(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            try {
                kh.a("BeiZisAd", "onFinish");
                BeiZiNewInterstitialActivity beiZiNewInterstitialActivity = BeiZiNewInterstitialActivity.this;
                if (!beiZiNewInterstitialActivity.H || beiZiNewInterstitialActivity.I <= 0) {
                    return;
                }
                beiZiNewInterstitialActivity.e();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            try {
                int i = (int) ((j / 1000) + 1);
                TextView textView = BeiZiNewInterstitialActivity.this.i;
                if (textView != null) {
                    textView.setText(String.valueOf(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class s implements View.OnClickListener {
        public s() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BeiZiNewInterstitialActivity.this.L();
        }
    }

    public class u implements of.f {
        public u() {
        }

        @Override // com.beizi.fusion.of.f
        public void a() {
        }

        @Override // com.beizi.fusion.of.f
        public void a(Bitmap bitmap) {
            try {
                CustomRoundImageView customRoundImageView = BeiZiNewInterstitialActivity.this.u;
                if (customRoundImageView != null) {
                    customRoundImageView.setImageBitmap(bitmap);
                }
                BeiZiNewInterstitialActivity beiZiNewInterstitialActivity = BeiZiNewInterstitialActivity.this;
                beiZiNewInterstitialActivity.u.setRectRadius(bq.a(beiZiNewInterstitialActivity, 6.0f));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class v implements View.OnClickListener {
        public v() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                RelativeLayout relativeLayout = BeiZiNewInterstitialActivity.this.p;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
                BeiZiNewInterstitialActivity beiZiNewInterstitialActivity = BeiZiNewInterstitialActivity.this;
                if (beiZiNewInterstitialActivity.y != null) {
                    beiZiNewInterstitialActivity.E.seekTo(0L, 3);
                    BeiZiNewInterstitialActivity.this.y.start();
                }
                int duration = BeiZiNewInterstitialActivity.this.E.getDuration() / 1000;
                TextView textView = BeiZiNewInterstitialActivity.this.i;
                if (textView != null) {
                    textView.setText(String.valueOf(duration));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class x implements MediaPlayer.OnCompletionListener {
        public x() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            kh.a("BeiZisAd", "onCompletion: 播放完成");
            try {
                BeiZiNewInterstitialActivity beiZiNewInterstitialActivity = BeiZiNewInterstitialActivity.this;
                beiZiNewInterstitialActivity.G = 0;
                RelativeLayout relativeLayout = beiZiNewInterstitialActivity.p;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                }
                BeiZiNewInterstitialActivity beiZiNewInterstitialActivity2 = BeiZiNewInterstitialActivity.this;
                boolean z = beiZiNewInterstitialActivity2.H;
                if (!z || beiZiNewInterstitialActivity2.I <= 0) {
                    if (z) {
                        beiZiNewInterstitialActivity2.e();
                    } else {
                        TextView textView = beiZiNewInterstitialActivity2.i;
                        if (textView != null) {
                            textView.setText("0");
                        }
                    }
                }
                BeiZiNewInterstitialActivity.this.z();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        on onVarZ;
        try {
            xi xiVar = this.f26894a;
            if (xiVar == null || (onVarZ = xiVar.z()) == null) {
                return;
            }
            onVarZ.e(this.m, this.f26894a.x());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void C() {
        RelativeLayout.LayoutParams layoutParams;
        double d2;
        double d3;
        RelativeLayout.LayoutParams layoutParams2;
        LinearLayout.LayoutParams layoutParams3;
        try {
            int iA = bq.a(this, 10.0f);
            wn.a(this.e, "#FFFFFF", 0, (String) null, iA);
            int iA2 = bq.a(this, 49.0f);
            int iA3 = bq.a(this, 19.0f);
            int iA4 = bq.a(this, 8.0f);
            int iA5 = bq.a(this, 52.0f);
            TextView textView = this.h;
            if (textView != null) {
                wn.a(textView, "#66303030", 0, (String) null, iA);
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
                layoutParams4.width = iA2;
                layoutParams4.height = iA3;
                layoutParams4.setMargins(iA4, iA4, 0, 0);
                layoutParams4.addRule(17);
                this.h.setLayoutParams(layoutParams4);
            }
            ImageView imageView = this.v;
            if (imageView != null && this.D) {
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams5.width = iA3;
                layoutParams5.height = iA3;
                layoutParams5.setMargins(0, iA4, iA, 0);
                this.v.setLayoutParams(layoutParams5);
            }
            LinearLayout linearLayout = this.f;
            if (linearLayout != null) {
                RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams6.width = iA5;
                layoutParams6.height = iA3;
                layoutParams6.setMargins(0, iA4, iA4, 0);
                this.f.setLayoutParams(layoutParams6);
                wn.a(this.f, "#66303030", 0, (String) null, iA);
            }
            TextView textView2 = this.i;
            if (textView2 != null) {
                LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) textView2.getLayoutParams();
                layoutParams7.width = iA3;
                layoutParams7.height = iA3;
                this.i.setLayoutParams(layoutParams7);
                wn.a(this.i, "#66303030", 0, (String) null, iA * 2);
            }
            ImageView imageView2 = this.w;
            if (imageView2 != null) {
                RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
                layoutParams8.width = iA3;
                layoutParams8.height = iA3;
                layoutParams8.setMargins(0, iA4, iA4, 0);
                this.w.setLayoutParams(layoutParams8);
            }
            int iH = to.h(this);
            int iG = to.g(this);
            double d4 = iH;
            int i2 = (int) (0.65d * d4);
            int iA6 = bq.a(this, 5.0f);
            if (this.B) {
                i2 = (int) (d4 * 0.85d);
                iA6 = bq.a(this, 10.0f);
                this.r.setVisibility(0);
                RelativeLayout relativeLayout = this.r;
                if (relativeLayout != null && (layoutParams3 = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams()) != null) {
                    layoutParams3.width = i2 - (iA6 * 3);
                    layoutParams3.height = -2;
                    if (!TextUtils.isEmpty(this.L) && TextUtils.isEmpty(this.M) && TextUtils.isEmpty(this.N)) {
                        layoutParams3.setMargins(0, iA6, 0, bq.a(this, 5.0f));
                    } else {
                        layoutParams3.setMargins(0, (int) (((double) iA6) * 1.5d), 0, bq.a(this, 5.0f));
                    }
                    this.r.setLayoutParams(layoutParams3);
                }
            } else {
                this.q.setVisibility(0);
                RelativeLayout relativeLayout2 = this.q;
                if (relativeLayout2 != null && (layoutParams = (RelativeLayout.LayoutParams) relativeLayout2.getLayoutParams()) != null) {
                    layoutParams.width = i2;
                    layoutParams.height = -2;
                    layoutParams.setMargins(0, iA6 * 3, 0, 0);
                    this.q.setLayoutParams(layoutParams);
                }
            }
            LinearLayout linearLayout2 = this.e;
            if (linearLayout2 != null && (layoutParams2 = (RelativeLayout.LayoutParams) linearLayout2.getLayoutParams()) != null) {
                layoutParams2.width = i2;
                layoutParams2.height = -2;
                this.e.setLayoutParams(layoutParams2);
                this.e.setPadding(iA6, iA6, iA6, iA6);
            }
            RelativeLayout relativeLayout3 = this.o;
            if (relativeLayout3 != null) {
                int i3 = i2 - (iA6 * 2);
                if (this.B) {
                    d2 = i3;
                    d3 = 0.56d;
                } else {
                    d2 = i3;
                    d3 = 1.78d;
                }
                int i4 = (int) (d2 * d3);
                double d5 = iG;
                if (i4 > 0.7d * d5) {
                    i4 = (int) (d5 * 0.5d);
                }
                RelativeLayout.LayoutParams layoutParams9 = (RelativeLayout.LayoutParams) relativeLayout3.getLayoutParams();
                if (layoutParams9 != null) {
                    layoutParams9.width = i3;
                    layoutParams9.height = i4;
                    this.o.setLayoutParams(layoutParams9);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void D() {
        try {
            if (TextUtils.isEmpty(this.M) && TextUtils.isEmpty(this.N)) {
                this.g.setVisibility(8);
            } else {
                this.g.setVisibility(0);
            }
            if (this.k != null) {
                if (TextUtils.isEmpty(this.M)) {
                    this.k.setVisibility(8);
                } else {
                    this.k.setVisibility(0);
                    this.k.setText(this.M);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.k.getLayoutParams();
                    if (layoutParams != null) {
                        if (TextUtils.isEmpty(this.N)) {
                            layoutParams.setMargins(0, bq.a(this, 13.0f), 0, 0);
                        } else {
                            layoutParams.setMargins(0, bq.a(this, 10.0f), 0, 0);
                        }
                        this.k.setLayoutParams(layoutParams);
                    }
                    this.k.setPadding(0, 0, 0, 0);
                }
            }
            if (this.l != null) {
                if (TextUtils.isEmpty(this.N)) {
                    this.l.setVisibility(8);
                } else {
                    this.l.setVisibility(0);
                    this.l.setText(this.N);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.l.getLayoutParams();
                    if (TextUtils.isEmpty(this.M)) {
                        layoutParams2.setMargins(0, bq.a(this, 13.0f), 0, 0);
                    } else {
                        layoutParams2.setMargins(0, bq.a(this, 8.0f), 0, 0);
                    }
                    if (layoutParams2 != null) {
                        this.l.setLayoutParams(layoutParams2);
                    }
                    this.l.setPadding(0, 0, 0, 0);
                }
            }
            if (this.B) {
                View view = this.A;
                if (view != null) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            if (this.A != null) {
                if (TextUtils.isEmpty(this.M) && TextUtils.isEmpty(this.N) && TextUtils.isEmpty(this.L)) {
                    this.A.setVisibility(8);
                    return;
                }
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.A.getLayoutParams();
                layoutParams3.width = -2;
                if (TextUtils.isEmpty(this.M) && TextUtils.isEmpty(this.N) && !TextUtils.isEmpty(this.L)) {
                    layoutParams3.height = bq.a(this, 5.0f);
                } else {
                    layoutParams3.height = bq.a(this, 10.0f);
                }
                this.A.setLayoutParams(layoutParams3);
                this.A.setVisibility(0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        try {
            if (this.y == null) {
                return;
            }
            int width = this.o.getWidth();
            int height = this.o.getHeight();
            this.y.measure(0, 0);
            int measuredWidth = this.y.getMeasuredWidth();
            int measuredHeight = this.y.getMeasuredHeight();
            float f2 = (float) ((((double) measuredWidth) * 1.0d) / ((double) measuredHeight));
            ViewGroup.LayoutParams layoutParams = this.y.getLayoutParams();
            int i2 = -2;
            int i3 = -1;
            if (measuredWidth < width && (measuredHeight > height || width - measuredWidth > height - measuredHeight)) {
                i3 = -2;
                i2 = -1;
            }
            if (layoutParams != null) {
                layoutParams.width = i3;
                layoutParams.height = i2;
                this.y.setLayoutParams(layoutParams);
            }
            float f3 = (this.B ? 1.78f : 0.56f) - f2;
            if (Math.abs(f3) < 0.0f || Math.abs(f3) > 0.15d) {
                return;
            }
            this.y.setOutlineProvider(new yo(bq.a(this, 6.0f)));
            this.y.setClipToOutline(true);
            RelativeLayout relativeLayout = this.o;
            if (relativeLayout != null) {
                wn.a(relativeLayout, "#FFFFFF", 0, (String) null, bq.a(this, 6.0f));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void F() {
        try {
            if (this.b == null) {
                return;
            }
            if (TextUtils.isEmpty(this.L)) {
                View view = this.z;
                if (view != null) {
                    view.setVisibility(8);
                }
                CustomRoundImageView customRoundImageView = this.u;
                if (customRoundImageView != null) {
                    customRoundImageView.setVisibility(8);
                    return;
                }
                return;
            }
            int iA = bq.a(this, 20.0f);
            CustomRoundImageView customRoundImageView2 = this.u;
            if (customRoundImageView2 != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) customRoundImageView2.getLayoutParams();
                int i2 = iA * 2;
                layoutParams.width = i2;
                layoutParams.height = i2;
                this.u.setLayoutParams(layoutParams);
                this.u.setVisibility(0);
            }
            View view2 = this.z;
            if (view2 != null) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) view2.getLayoutParams();
                layoutParams2.width = -1;
                layoutParams2.height = iA;
                this.z.setLayoutParams(layoutParams2);
                this.z.setVisibility(0);
            }
            of.a(this).a(this.L, new u());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void G() {
        RelativeLayout relativeLayout = this.n;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new c());
        }
        ImageView imageView = this.v;
        if (imageView != null) {
            imageView.setOnClickListener(new d());
        }
    }

    private void H() {
        AdSpacesBean.ComplainBean complain;
        TextView textView;
        try {
            AdSpacesBean.BuyerBean buyerBean = this.Q;
            if (buyerBean == null || (complain = buyerBean.getComplain()) == null || complain.getOpen() != 1 || (textView = this.h) == null) {
                return;
            }
            textView.setVisibility(0);
            this.h.setOnClickListener(new s());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void I() {
        try {
            on onVar = this.b;
            if (onVar == null) {
                return;
            }
            int iE = onVar.E();
            if (iE != 2 && iE != 5) {
                return;
            }
            this.j.setVisibility(0);
            String strJ = this.b.j();
            String strK = this.b.k();
            String strQ = this.b.q();
            String strO = this.b.o();
            String strN = !TextUtils.isEmpty(strO) ? strO : this.b.n();
            String strP = this.b.p();
            String strR = this.b.r();
            this.j.setText(Html.fromHtml("应用名称：" + strJ + " | 开发者：" + strK + " | 应用版本：" + strQ + " | <u>权限详情</u> | <u>隐私协议</u> | <u>功能介绍</u>"));
            this.j.setOnClickListener(new e(strJ, strP, strN, strR));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void J() {
        try {
            if (!this.D && this.t != null && !TextUtils.isEmpty(this.O)) {
                this.t.setVisibility(0);
                of.a(this).a(this.O, new r());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void K() {
        try {
            if (this.D && this.y != null && !TextUtils.isEmpty(this.O)) {
                RelativeLayout relativeLayout = this.o;
                if (relativeLayout != null) {
                    wn.a(relativeLayout, "#000000", 0, (String) null, bq.a(this, 6.0f));
                }
                ImageView imageView = this.v;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    if (this.C) {
                        this.v.setImageResource(R.drawable.beizi_voice_on);
                    } else {
                        this.v.setImageResource(R.drawable.beizi_voice_off);
                    }
                }
                RelativeLayout relativeLayout2 = this.p;
                if (relativeLayout2 != null) {
                    wn.a(relativeLayout2, "#66303030", 0, (String) null, bq.a(this, 6.0f));
                    this.p.setOnClickListener(new v());
                }
                if (this.x != null) {
                    int iA = bq.a(this, 54.0f);
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.x.getLayoutParams();
                    layoutParams.width = iA;
                    layoutParams.height = iA;
                    this.x.setLayoutParams(layoutParams);
                }
                this.y.setVisibility(0);
                vp.c().a(this, this.O, new w());
                this.y.setOnCompletionListener(new x());
                this.y.setOnPreparedListener(new a());
                this.y.setOnErrorListener(new b());
                if (!this.H || this.I <= 0) {
                    O();
                } else {
                    N();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        try {
            p();
            u5.a aVar = new u5.a(this);
            aVar.a(new t());
            aVar.a().show();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void M() {
        kj kjVarQ;
        try {
            on onVar = this.b;
            if (onVar != null && this.c != null && (kjVarQ = onVar.Q()) != null) {
                this.b0 = new lj();
                this.b0.a(this.c, to.h(this), to.g(this), kjVarQ, new m());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        try {
            this.J = null;
            int i2 = this.I;
            TextView textView = this.i;
            if (textView != null) {
                try {
                    String string = textView.getText().toString();
                    if (!TextUtils.isEmpty(string) && !"0".equals(string)) {
                        i2 = Integer.parseInt(string);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.i.setText(String.valueOf(i2));
            }
            q qVar = new q(i2 * 1000, 1000L);
            this.J = qVar;
            qVar.start();
        } catch (Exception e3) {
            e3.printStackTrace();
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
            if (this.s != null) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2, 85);
                int iA = bq.a(this, 8.0f);
                layoutParams2.setMargins(0, 0, iA, iA);
                this.s.addView(linearLayout, layoutParams2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void c() {
        Handler handler;
        try {
            int iH = h();
            if (iH > 0 && (handler = this.a0) != null) {
                handler.postDelayed(new n(), iH);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            f5 f5Var = this.c0;
            if (f5Var != null && this.S != null && this.e0 == 1) {
                double dB = f5Var.b();
                double dA = this.c0.a();
                double d2 = this.S.d();
                double dE = this.S.e();
                if (dA > AudioStats.AUDIO_AMPLITUDE_NONE && d2 > AudioStats.AUDIO_AMPLITUDE_NONE && d2 < dA) {
                    this.e0 = 2;
                } else {
                    if (dB <= AudioStats.AUDIO_AMPLITUDE_NONE || dE <= AudioStats.AUDIO_AMPLITUDE_NONE || dE >= dB) {
                        return;
                    }
                    this.e0 = 2;
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        CountDownTimer countDownTimer = this.J;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.J = null;
        }
        xi xiVar = this.f26894a;
        if (xiVar != null) {
            xiVar.O();
        }
        finish();
    }

    private void f() {
        try {
            lj ljVar = this.b0;
            if (ljVar != null) {
                ljVar.b();
            }
            this.b0 = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void g() {
        this.c = (RelativeLayout) findViewById(R.id.beizi_interstitial_root_container_rl);
        this.m = (RelativeLayout) findViewById(R.id.beizi_interstitial_ad_content_rl);
        this.e = (LinearLayout) findViewById(R.id.beizi_interstitial_ad_container_ll);
        this.d = (RelativeLayout) findViewById(R.id.beizi_interstitial_ad_content_container_rl);
        this.h = (TextView) findViewById(R.id.beizi_interstitial_ad_complain_tv);
        this.n = (RelativeLayout) findViewById(R.id.beizi_interstitial_ad_close_container_rl);
        this.f = (LinearLayout) findViewById(R.id.beizi_interstitial_ad_close_text_container_ll);
        this.w = (ImageView) findViewById(R.id.beizi_interstitial_ad_close_iv);
        this.i = (TextView) findViewById(R.id.beizi_interstitial_ad_countdown_tv);
        this.o = (RelativeLayout) findViewById(R.id.beizi_interstitial_ad_material_container_rl);
        this.p = (RelativeLayout) findViewById(R.id.beizi_interstitial_ad_video_replay_container_rl);
        this.x = (ImageView) findViewById(R.id.beizi_interstitial_ad_video_replay_iv);
        this.s = (FrameLayout) findViewById(R.id.beizi_interstitial_ad_logo_container_fl);
        this.t = (CustomRoundImageView) findViewById(R.id.beizi_interstitial_ad_img_iv);
        this.y = (VideoView) findViewById(R.id.beizi_interstitial_ad_video_vv);
        this.u = (CustomRoundImageView) findViewById(R.id.beizi_interstitial_ad_app_icon_iv);
        this.z = findViewById(R.id.beizi_interstitial_ad_divide_view);
        this.v = (ImageView) findViewById(R.id.beizi_interstitial_ad_voice_iv);
        this.g = (LinearLayout) findViewById(R.id.beizi_interstitial_ad_title_container_ll);
        this.k = (TextView) findViewById(R.id.beizi_interstitial_ad_title_tv);
        this.l = (TextView) findViewById(R.id.beizi_interstitial_ad_subtitle_tv);
        this.A = findViewById(R.id.beizi_interstitial_ad_title_divider_view);
        this.r = (RelativeLayout) findViewById(R.id.beizi_interstitial_ad_interaction_container_landscape_rl);
        this.q = (RelativeLayout) findViewById(R.id.beizi_interstitial_ad_interaction_container_portrait_rl);
        this.j = (TextView) findViewById(R.id.beizi_interstitial_ad_app_download_info_tv);
    }

    private void i() {
        try {
            xi xiVar = xi.Q;
            this.f26894a = xiVar;
            this.Q = xiVar.g();
            this.Z = this.f26894a.C();
            AdSpacesBean.BuyerBean buyerBean = this.Q;
            if (buyerBean == null) {
                return;
            }
            if (buyerBean.getTemplate() == 1) {
                this.B = true;
            } else {
                this.B = false;
            }
            on onVarZ = this.f26894a.z();
            this.b = onVarZ;
            if (onVarZ == null) {
                return;
            }
            this.P = onVarZ.c();
            boolean zO0 = this.b.o0();
            this.D = zO0;
            if (zO0) {
                this.O = this.b.e0();
            } else {
                this.O = this.b.D();
            }
            this.L = this.b.m();
            this.H = this.b.g0();
            this.I = this.b.K();
            this.M = this.b.b0();
            this.N = this.b.Y();
            this.C = !this.b.l0();
            f5 f5VarW = this.b.w();
            this.c0 = f5VarW;
            if (f5VarW != null) {
                int iC = f5VarW.c();
                this.d0 = iC;
                if (iC != 0) {
                    this.e0 = this.c0.e() + 1;
                }
            }
            this.f0 = this.b.F();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void j() {
        try {
            if (!v()) {
                this.f.setVisibility(8);
                this.w.setVisibility(0);
            } else {
                this.f.setVisibility(0);
                this.w.setVisibility(8);
                this.f.measure(0, 0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        on onVarZ;
        try {
            xi xiVar = this.f26894a;
            if (xiVar == null || (onVarZ = xiVar.z()) == null) {
                return;
            }
            onVarZ.f(this.e, this.f26894a.x());
            this.f26894a.P();
            M();
            x();
            c();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        int width;
        int height;
        try {
            if (this.F) {
                return;
            }
            int[] iArr = new int[2];
            if (this.B) {
                width = this.r.getWidth();
                height = this.r.getHeight();
                this.r.getLocationOnScreen(iArr);
            } else {
                width = this.q.getWidth();
                height = this.q.getHeight();
                this.q.getLocationOnScreen(iArr);
            }
            int[] iArrB = ol.b(width / 2, height / 2);
            a(String.valueOf(iArrB[0]), String.valueOf(iArrB[1]), String.valueOf(iArrB[0] + iArr[0]), String.valueOf(iArrB[1] + iArr[1]), String.valueOf(iArrB[0]), String.valueOf(iArrB[1]), String.valueOf(iArrB[0] + iArr[0]), String.valueOf(iArrB[1] + iArr[1]), 0);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void m() {
        AdSpacesBean.BuyerBean.EulerAngleViewBean eulerAngleRule;
        try {
            if (this.Q == null || q1.h().u() || (eulerAngleRule = this.Q.getEulerAngleRule()) == null) {
                return;
            }
            q7 q7Var = new q7(this, eulerAngleRule, this.Q.getSpaceId(), this.P);
            this.U = q7Var;
            if (this.B) {
                q7Var.b(this.r);
            } else {
                q7Var.b(this.q);
            }
            this.U.a(new i());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void n() {
        AdSpacesBean.BuyerBean.FullScreenClickBean fullScreenClick;
        try {
            AdSpacesBean.BuyerBean buyerBean = this.Q;
            if (buyerBean == null || (fullScreenClick = buyerBean.getFullScreenClick()) == null) {
                return;
            }
            k8 k8Var = new k8(this, fullScreenClick, this.P);
            this.V = k8Var;
            k8Var.a(this.m, new j());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        try {
            if (this.Q == null) {
                return;
            }
            n();
            r();
            t();
            s();
            m();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void p() {
        try {
            if (this.y != null && this.D) {
                if (this.p.getVisibility() == 0) {
                    this.G = 0;
                } else {
                    int currentPosition = this.y.getCurrentPosition();
                    if (currentPosition > 0) {
                        this.G = currentPosition;
                    }
                }
                this.y.pause();
            }
            sn snVar = this.S;
            if (snVar != null) {
                snVar.l();
            }
            q7 q7Var = this.U;
            if (q7Var != null) {
                q7Var.k();
            }
            CountDownTimer countDownTimer = this.J;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.J = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        try {
            VideoView videoView = this.y;
            if (videoView != null && this.D && !videoView.isPlaying()) {
                this.y.resume();
            }
            sn snVar = this.S;
            if (snVar != null) {
                snVar.m();
            }
            q7 q7Var = this.U;
            if (q7Var != null) {
                q7Var.l();
            }
            if (!this.K && this.H && this.I > 0) {
                N();
            }
            this.K = false;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void r() {
        try {
            AdSpacesBean.BuyerBean buyerBean = this.Q;
            if (buyerBean == null) {
                return;
            }
            AdSpacesBean.BuyerBean.RegionalClickViewBean regionalClickView = buyerBean.getRegionalClickView();
            if (regionalClickView == null) {
                regionalClickView = new AdSpacesBean.BuyerBean.RegionalClickViewBean();
                regionalClickView.setBackgroundAlpha(1.0d);
                regionalClickView.setBackgroundColor("#3976FF");
                regionalClickView.setTitle("点击跳转网页或第三方应用");
                regionalClickView.setTitleColor("#FFFFFF");
            }
            tl tlVar = new tl(this, regionalClickView, this.P, this.Z);
            this.R = tlVar;
            if (this.B) {
                tlVar.b(this.r);
            } else {
                tlVar.b(this.q);
            }
            this.R.a(new f());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void s() {
        AdSpacesBean.BuyerBean.ScrollClickBean scrollClick;
        try {
            AdSpacesBean.BuyerBean buyerBean = this.Q;
            if (buyerBean == null || (scrollClick = buyerBean.getScrollClick()) == null) {
                return;
            }
            kn knVar = new kn(this, scrollClick, this.Q.getSpaceId(), this.P);
            this.T = knVar;
            knVar.a(u());
            if (this.B) {
                this.T.b(this.r);
            } else {
                this.T.b(this.q);
            }
            this.T.a(this.m, new h());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void t() {
        AdSpacesBean.BuyerBean.ShakeViewBean shakeView;
        try {
            if (this.Q == null || q1.h().u() || (shakeView = this.Q.getShakeView()) == null) {
                return;
            }
            sn snVar = new sn(this, shakeView, this.Q.getSpaceId(), this.P);
            this.S = snVar;
            if (this.B) {
                snVar.d(this.r);
            } else {
                snVar.d(this.q);
            }
            f5 f5Var = this.c0;
            if (f5Var != null) {
                this.S.a(f5Var.b());
            }
            this.S.a(new g());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private boolean u() {
        wk wkVarR;
        try {
            on onVar = this.b;
            return (onVar == null || (wkVarR = onVar.R()) == null || wkVarR.d() != 1) ? false : true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private boolean v() {
        if (this.D) {
            return true;
        }
        return this.H && this.I > 0;
    }

    private void x() {
        wk wkVarR;
        int iA;
        on onVar = this.b;
        if (onVar == null || this.a0 == null) {
            return;
        }
        try {
            if (!this.F && (wkVarR = onVar.R()) != null && (iA = wkVarR.a()) > 0) {
                this.a0.sendEmptyMessageDelayed(10001, iA);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        BZLpView bZLpView;
        BZLpView bZLpView2;
        try {
            ViewGroup viewGroup = this.g0;
            if (viewGroup != null && (bZLpView2 = this.h0) != null) {
                viewGroup.removeView(bZLpView2);
            }
            this.g0 = null;
            RelativeLayout relativeLayout = this.d;
            if (relativeLayout != null && (bZLpView = this.h0) != null) {
                relativeLayout.removeView(bZLpView);
            }
            this.h0 = null;
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        on onVarZ;
        try {
            xi xiVar = this.f26894a;
            if (xiVar == null || (onVarZ = xiVar.z()) == null) {
                return;
            }
            onVarZ.a(this.m, this.f26894a.x());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void B() {
        try {
            f5 f5Var = this.c0;
            if (f5Var != null) {
                int iC = f5Var.c();
                this.d0 = iC;
                if (iC != 0) {
                    this.e0 = this.c0.e() + 1;
                } else {
                    this.e0 = 0;
                }
            } else {
                this.e0 = 0;
            }
            on onVar = this.b;
            if (onVar != null) {
                onVar.b(this.e0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void O() {
        try {
            if (this.X == null) {
                this.X = new Timer();
            }
            if (this.Y == null) {
                this.Y = new l();
            }
            this.X.scheduleAtFixedRate(this.Y, 0L, 1000L);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x014d A[Catch: Exception -> 0x01c5, TryCatch #4 {Exception -> 0x01c5, blocks: (B:3:0x0006, B:6:0x0010, B:9:0x0016, B:12:0x001e, B:15:0x0026, B:17:0x002f, B:18:0x0057, B:22:0x0072, B:53:0x012b, B:55:0x014d, B:62:0x0178, B:64:0x017e, B:66:0x0182, B:68:0x018d, B:78:0x01a0, B:80:0x01a4, B:81:0x01a8, B:83:0x01ac, B:84:0x01bb, B:86:0x01bf, B:76:0x019b, B:77:0x019e, B:57:0x0157, B:58:0x015f, B:61:0x0168, B:51:0x0122, B:23:0x007b), top: B:97:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0155 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x0157 A[Catch: Exception -> 0x01c5, TryCatch #4 {Exception -> 0x01c5, blocks: (B:3:0x0006, B:6:0x0010, B:9:0x0016, B:12:0x001e, B:15:0x0026, B:17:0x002f, B:18:0x0057, B:22:0x0072, B:53:0x012b, B:55:0x014d, B:62:0x0178, B:64:0x017e, B:66:0x0182, B:68:0x018d, B:78:0x01a0, B:80:0x01a4, B:81:0x01a8, B:83:0x01ac, B:84:0x01bb, B:86:0x01bf, B:76:0x019b, B:77:0x019e, B:57:0x0157, B:58:0x015f, B:61:0x0168, B:51:0x0122, B:23:0x007b), top: B:97:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x015f A[Catch: Exception -> 0x01c5, TryCatch #4 {Exception -> 0x01c5, blocks: (B:3:0x0006, B:6:0x0010, B:9:0x0016, B:12:0x001e, B:15:0x0026, B:17:0x002f, B:18:0x0057, B:22:0x0072, B:53:0x012b, B:55:0x014d, B:62:0x0178, B:64:0x017e, B:66:0x0182, B:68:0x018d, B:78:0x01a0, B:80:0x01a4, B:81:0x01a8, B:83:0x01ac, B:84:0x01bb, B:86:0x01bf, B:76:0x019b, B:77:0x019e, B:57:0x0157, B:58:0x015f, B:61:0x0168, B:51:0x0122, B:23:0x007b), top: B:97:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0167  */
    /* JADX WARN: Code duplicated, block: B:61:0x0168 A[Catch: Exception -> 0x01c5, TryCatch #4 {Exception -> 0x01c5, blocks: (B:3:0x0006, B:6:0x0010, B:9:0x0016, B:12:0x001e, B:15:0x0026, B:17:0x002f, B:18:0x0057, B:22:0x0072, B:53:0x012b, B:55:0x014d, B:62:0x0178, B:64:0x017e, B:66:0x0182, B:68:0x018d, B:78:0x01a0, B:80:0x01a4, B:81:0x01a8, B:83:0x01ac, B:84:0x01bb, B:86:0x01bf, B:76:0x019b, B:77:0x019e, B:57:0x0157, B:58:0x015f, B:61:0x0168, B:51:0x0122, B:23:0x007b), top: B:97:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x018d A[Catch: Exception -> 0x01c5, TryCatch #4 {Exception -> 0x01c5, blocks: (B:3:0x0006, B:6:0x0010, B:9:0x0016, B:12:0x001e, B:15:0x0026, B:17:0x002f, B:18:0x0057, B:22:0x0072, B:53:0x012b, B:55:0x014d, B:62:0x0178, B:64:0x017e, B:66:0x0182, B:68:0x018d, B:78:0x01a0, B:80:0x01a4, B:81:0x01a8, B:83:0x01ac, B:84:0x01bb, B:86:0x01bf, B:76:0x019b, B:77:0x019e, B:57:0x0157, B:58:0x015f, B:61:0x0168, B:51:0x0122, B:23:0x007b), top: B:97:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0190  */
    /* JADX WARN: Code duplicated, block: B:80:0x01a4 A[Catch: Exception -> 0x01c5, TryCatch #4 {Exception -> 0x01c5, blocks: (B:3:0x0006, B:6:0x0010, B:9:0x0016, B:12:0x001e, B:15:0x0026, B:17:0x002f, B:18:0x0057, B:22:0x0072, B:53:0x012b, B:55:0x014d, B:62:0x0178, B:64:0x017e, B:66:0x0182, B:68:0x018d, B:78:0x01a0, B:80:0x01a4, B:81:0x01a8, B:83:0x01ac, B:84:0x01bb, B:86:0x01bf, B:76:0x019b, B:77:0x019e, B:57:0x0157, B:58:0x015f, B:61:0x0168, B:51:0x0122, B:23:0x007b), top: B:97:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x01a8 A[Catch: Exception -> 0x01c5, TryCatch #4 {Exception -> 0x01c5, blocks: (B:3:0x0006, B:6:0x0010, B:9:0x0016, B:12:0x001e, B:15:0x0026, B:17:0x002f, B:18:0x0057, B:22:0x0072, B:53:0x012b, B:55:0x014d, B:62:0x0178, B:64:0x017e, B:66:0x0182, B:68:0x018d, B:78:0x01a0, B:80:0x01a4, B:81:0x01a8, B:83:0x01ac, B:84:0x01bb, B:86:0x01bf, B:76:0x019b, B:77:0x019e, B:57:0x0157, B:58:0x015f, B:61:0x0168, B:51:0x0122, B:23:0x007b), top: B:97:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x01ac A[Catch: Exception -> 0x01c5, TryCatch #4 {Exception -> 0x01c5, blocks: (B:3:0x0006, B:6:0x0010, B:9:0x0016, B:12:0x001e, B:15:0x0026, B:17:0x002f, B:18:0x0057, B:22:0x0072, B:53:0x012b, B:55:0x014d, B:62:0x0178, B:64:0x017e, B:66:0x0182, B:68:0x018d, B:78:0x01a0, B:80:0x01a4, B:81:0x01a8, B:83:0x01ac, B:84:0x01bb, B:86:0x01bf, B:76:0x019b, B:77:0x019e, B:57:0x0157, B:58:0x015f, B:61:0x0168, B:51:0x0122, B:23:0x007b), top: B:97:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x01bf A[Catch: Exception -> 0x01c5, TRY_LEAVE, TryCatch #4 {Exception -> 0x01c5, blocks: (B:3:0x0006, B:6:0x0010, B:9:0x0016, B:12:0x001e, B:15:0x0026, B:17:0x002f, B:18:0x0057, B:22:0x0072, B:53:0x012b, B:55:0x014d, B:62:0x0178, B:64:0x017e, B:66:0x0182, B:68:0x018d, B:78:0x01a0, B:80:0x01a4, B:81:0x01a8, B:83:0x01ac, B:84:0x01bb, B:86:0x01bf, B:76:0x019b, B:77:0x019e, B:57:0x0157, B:58:0x015f, B:61:0x0168, B:51:0x0122, B:23:0x007b), top: B:97:0x0006 }] */
    public void b() {
        f5 f5Var;
        oh ohVarD;
        int width;
        int height;
        int i2;
        int i3;
        int i4;
        int i5;
        View rootView;
        int iD;
        sn snVar;
        Handler handler;
        try {
            if (!TextUtils.isEmpty(this.f0) && (f5Var = this.c0) != null && (ohVarD = f5Var.d()) != null && ohVarD.e() != 0) {
                y();
                if (this.i0) {
                    cl clVar = new cl();
                    clVar.f("0");
                    clVar.g("0");
                    clVar.e("100%");
                    clVar.c("100%");
                    ohVarD.b(2);
                    ohVarD.d(1);
                    ohVarD.c(0);
                    ohVarD.a(0);
                    ohVarD.a(clVar);
                    this.c0.a(ohVarD);
                    this.k0 = false;
                }
                this.i0 = true;
                BZLpView bZLpView = new BZLpView(this);
                this.h0 = bZLpView;
                bZLpView.setData(this.f0);
                int iB = ohVarD.b();
                cl clVarC = ohVarD.c();
                if (iB == 0 || iB == 1) {
                    width = this.d.getWidth();
                    height = this.d.getHeight();
                } else {
                    width = so.j(this);
                    height = so.g(this);
                }
                if (clVarC != null) {
                    try {
                        String strE = clVarC.e();
                        String strC = clVarC.c();
                        String strF = clVarC.f();
                        String strG = clVarC.g();
                        i2 = strE.endsWith("%") ? (Integer.parseInt(strE.substring(0, strE.indexOf("%"))) * width) / 100 : so.a(this, Integer.parseInt(strE));
                        try {
                            i3 = strC.endsWith("%") ? (Integer.parseInt(strC.substring(0, strC.indexOf("%"))) * height) / 100 : so.a(this, Integer.parseInt(strC));
                            try {
                                i4 = strF.endsWith("%") ? (Integer.parseInt(strF.substring(0, strF.indexOf("%"))) * width) / 100 : so.a(this, Integer.parseInt(strF));
                                try {
                                    i5 = strG.endsWith("%") ? (Integer.parseInt(strG.substring(0, strG.indexOf("%"))) * height) / 100 : so.a(this, Integer.parseInt(strG));
                                } catch (Exception e2) {
                                    e = e2;
                                    e.printStackTrace();
                                    i5 = 0;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                i4 = 0;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            i3 = 0;
                            i4 = i3;
                            e.printStackTrace();
                            i5 = 0;
                            this.h0.setLayoutParams(new FrameLayout.LayoutParams(i2, i3));
                            this.h0.setX(i4);
                            this.h0.setY(i5);
                            this.h0.setOnDetachedFromWindowListener(new o());
                            if (iB == 0) {
                                this.d.addView(this.h0, 0);
                            } else if (iB == 1) {
                                this.d.addView(this.h0);
                            } else {
                                rootView = this.d.getRootView();
                                if (rootView == null) {
                                    return;
                                }
                                ViewGroup viewGroup = (ViewGroup) rootView.findViewById(android.R.id.content);
                                this.g0 = viewGroup;
                                viewGroup.addView(this.h0);
                            }
                            iD = ohVarD.d();
                            if (iD > 0) {
                                handler.postDelayed(new p(), iD);
                            }
                            if (iB == 0) {
                                this.j0 = true;
                            } else if (i4 < width) {
                                this.j0 = true;
                            } else {
                                this.j0 = true;
                            }
                            if (!this.j0) {
                                p();
                                return;
                            }
                            snVar = this.S;
                            if (snVar != null) {
                                snVar.m();
                                this.S.a(1.9d, 1.5d);
                            }
                            if (this.U != null) {
                                this.S.m();
                            }
                        }
                    } catch (Exception e5) {
                        e = e5;
                        i2 = 0;
                        i3 = 0;
                    }
                } else {
                    i5 = 0;
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                }
                this.h0.setLayoutParams(new FrameLayout.LayoutParams(i2, i3));
                this.h0.setX(i4);
                this.h0.setY(i5);
                this.h0.setOnDetachedFromWindowListener(new o());
                if (iB == 0) {
                    this.d.addView(this.h0, 0);
                } else if (iB == 1) {
                    this.d.addView(this.h0);
                } else {
                    rootView = this.d.getRootView();
                    if (rootView == null) {
                        return;
                    }
                    ViewGroup viewGroup2 = (ViewGroup) rootView.findViewById(android.R.id.content);
                    this.g0 = viewGroup2;
                    viewGroup2.addView(this.h0);
                }
                iD = ohVarD.d();
                if (iD > 0 && (handler = this.a0) != null) {
                    handler.postDelayed(new p(), iD);
                }
                if (iB == 0) {
                    this.j0 = true;
                } else if ((i4 < width || i4 <= (-width)) && (i5 >= height || i5 <= (-height))) {
                    this.j0 = true;
                } else {
                    this.j0 = false;
                }
                if (!this.j0) {
                    p();
                    return;
                }
                snVar = this.S;
                if (snVar != null) {
                    snVar.m();
                    this.S.a(1.9d, 1.5d);
                }
                if (this.U != null) {
                    this.S.m();
                }
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public int h() {
        oh ohVarD;
        try {
            f5 f5Var = this.c0;
            if (f5Var == null || (ohVarD = f5Var.d()) == null) {
                return 0;
            }
            int iA = ohVarD.a();
            if (iA <= 0 || ohVarD.e() == 2) {
                return iA;
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setContentView(R.layout.activity_beizi_interstitial);
            g();
            i();
            C();
            H();
            F();
            J();
            K();
            j();
            D();
            G();
            I();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            tl tlVar = this.R;
            if (tlVar != null) {
                tlVar.b();
            }
            this.R = null;
            sn snVar = this.S;
            if (snVar != null) {
                snVar.k();
            }
            this.S = null;
            q7 q7Var = this.U;
            if (q7Var != null) {
                q7Var.j();
            }
            this.U = null;
            kn knVar = this.T;
            if (knVar != null) {
                knVar.b();
            }
            this.T = null;
            k8 k8Var = this.V;
            if (k8Var != null) {
                k8Var.b();
            }
            this.V = null;
            Timer timer = this.X;
            if (timer != null) {
                timer.cancel();
            }
            this.X = null;
            TimerTask timerTask = this.Y;
            if (timerTask != null) {
                timerTask.cancel();
            }
            this.Y = null;
            Handler handler = this.a0;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.a0 = null;
            f();
            y();
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
        p();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        q();
    }

    public void w() {
        try {
            if (!this.j0) {
                q();
                return;
            }
            sn snVar = this.S;
            if (snVar != null) {
                snVar.m();
                this.S.a(1.9d, 1.5d);
            }
            if (this.U != null) {
                this.S.m();
            }
        } catch (Exception unused) {
        }
    }

    public class w implements vp.e {
        public w() {
        }

        @Override // com.beizi.fusion.vp.e
        public void a(String str) {
            try {
                kh.a("BeiZisAd", "onVideoLoaded: 加载成功");
                BeiZiNewInterstitialActivity.this.y.setVideoPath(str);
                BeiZiNewInterstitialActivity.this.y.requestFocus();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.beizi.fusion.vp.e
        public void a() {
            BeiZiNewInterstitialActivity.this.finish();
        }
    }

    public class t implements u5.b {
        public t() {
        }

        @Override // com.beizi.fusion.u5.b
        public void a(String str) {
            try {
                xi xiVar = BeiZiNewInterstitialActivity.this.f26894a;
                if (xiVar == null) {
                    return;
                }
                xiVar.g(str);
                BeiZiNewInterstitialActivity.this.f26894a.O();
                BeiZiNewInterstitialActivity.this.finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.beizi.fusion.u5.b
        public void a() {
            BeiZiNewInterstitialActivity.this.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2) {
        on onVarZ;
        try {
            if (this.f26894a != null && hasWindowFocus() && (onVarZ = this.f26894a.z()) != null) {
                String strX = this.f26894a.x();
                g5 g5Var = new g5();
                g5Var.g(str);
                g5Var.c(str5);
                g5Var.h(str2);
                g5Var.d(str6);
                g5Var.e(str3);
                g5Var.a(str7);
                g5Var.f(str4);
                g5Var.b(str8);
                g5Var.a(this.e0);
                onVarZ.c(true);
                onVarZ.b(this.e0);
                onVarZ.a(this.e, g5Var, String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis() + 10), this.F, strX, i2);
                this.F = true;
                b();
                this.f26894a.N();
                lj ljVar = this.b0;
                if (ljVar != null) {
                    ljVar.c();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public class r implements of.f {
        public r() {
        }

        @Override // com.beizi.fusion.of.f
        public void a(Bitmap bitmap) {
            try {
                BeiZiNewInterstitialActivity beiZiNewInterstitialActivity = BeiZiNewInterstitialActivity.this;
                if (beiZiNewInterstitialActivity.t != null) {
                    RelativeLayout relativeLayout = beiZiNewInterstitialActivity.o;
                    if (relativeLayout != null) {
                        relativeLayout.measure(0, 0);
                        ViewGroup.LayoutParams layoutParams = BeiZiNewInterstitialActivity.this.t.getLayoutParams();
                        if (layoutParams != null) {
                            layoutParams.width = BeiZiNewInterstitialActivity.this.o.getMeasuredWidth();
                            layoutParams.height = BeiZiNewInterstitialActivity.this.o.getMeasuredHeight();
                            BeiZiNewInterstitialActivity.this.t.setLayoutParams(layoutParams);
                        }
                    }
                    BeiZiNewInterstitialActivity beiZiNewInterstitialActivity2 = BeiZiNewInterstitialActivity.this;
                    beiZiNewInterstitialActivity2.t.setRectRadius(bq.a(beiZiNewInterstitialActivity2, 6.0f));
                    BeiZiNewInterstitialActivity.this.t.setBackground(new BitmapDrawable(qf.a(BeiZiNewInterstitialActivity.this, bitmap, 20.0f)));
                    BeiZiNewInterstitialActivity.this.t.setImageBitmap(bitmap);
                    BeiZiNewInterstitialActivity.this.a();
                    BeiZiNewInterstitialActivity.this.o();
                    BeiZiNewInterstitialActivity.this.k();
                    BeiZiNewInterstitialActivity beiZiNewInterstitialActivity3 = BeiZiNewInterstitialActivity.this;
                    if (!beiZiNewInterstitialActivity3.H || beiZiNewInterstitialActivity3.I <= 0) {
                        return;
                    }
                    beiZiNewInterstitialActivity3.N();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.beizi.fusion.of.f
        public void a() {
            BeiZiNewInterstitialActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, int i3) {
        double d2 = i3;
        double d3 = i2;
        if (d2 >= 0.25d * d3 && !this.l0) {
            this.l0 = true;
            a(25);
        }
        if (d2 >= 0.5d * d3 && !this.m0) {
            this.m0 = true;
            a(50);
        }
        if (d2 < d3 * 0.75d || this.n0) {
            return;
        }
        this.n0 = true;
        a(75);
    }

    private void a(int i2) {
        on onVarZ;
        xi xiVar = this.f26894a;
        if (xiVar == null || (onVarZ = xiVar.z()) == null) {
            return;
        }
        String strX = this.f26894a.x();
        if (i2 == 25) {
            onVarZ.b(this.m, strX);
        } else if (i2 == 50) {
            onVarZ.c(this.m, strX);
        } else if (i2 == 75) {
            onVarZ.d(this.m, strX);
        }
    }
}

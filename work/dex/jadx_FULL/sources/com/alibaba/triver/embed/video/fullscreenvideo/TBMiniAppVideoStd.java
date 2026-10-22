package com.alibaba.triver.embed.video.fullscreenvideo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import com.alibaba.triver.embed.video.R;
import com.alibaba.triver.kit.api.utils.TriverToastUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TBMiniAppVideoStd extends TBMiniAppVideo {
    public static long aU = 0;
    public static int aV = 70;
    protected static Timer au;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BroadcastReceiver f24839a;
    public LinearLayout aA;
    public TextView aB;
    public TextView aC;
    public TextView aD;
    public PopupWindow aE;
    public TextView aF;
    public LinearLayout aG;
    protected a aH;
    protected Dialog aI;
    protected ProgressBar aJ;
    protected TextView aK;
    protected TextView aL;
    protected ImageView aM;
    protected Dialog aN;
    protected ProgressBar aO;
    protected TextView aP;
    protected ImageView aQ;
    protected Dialog aR;
    protected ProgressBar aS;
    protected TextView aT;
    public boolean aW;
    public String aX;
    private int aY;
    private int aZ;
    public ImageView av;
    public ProgressBar aw;
    public ProgressBar ax;
    public ImageView ay;
    public ImageView az;
    private ImageView b;
    private int ba;
    private ImageView c;
    private int d;
    private int e;
    private int f;

    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            TBMiniAppVideoStd.this.ae();
        }
    }

    public TBMiniAppVideoStd(Context context) {
        super(context);
        this.f24839a = new BroadcastReceiver() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                try {
                    if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                        TBMiniAppVideoStd.aV = (intent.getIntExtra(com.alibaba.ariver.permission.b.b, 0) * 100) / intent.getIntExtra("scale", 100);
                        TBMiniAppVideoStd.this.Y();
                        TBMiniAppVideoStd.this.getContext().unregisterReceiver(TBMiniAppVideoStd.this.f24839a);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.aW = false;
        this.aX = "1";
        this.d = 4;
        this.e = 4;
        this.f = 4;
        this.aY = 4;
        this.aZ = 4;
        this.ba = 4;
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void B() {
        super.B();
        ad();
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void C() {
        super.C();
        ad();
        PopupWindow popupWindow = this.aE;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void M() {
        super.M();
        this.aw.setProgress(0);
        this.aw.setSecondaryProgress(0);
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void S() {
        super.S();
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(getResources().getString(R.string.triver_video_tips_not_wifi));
        builder.setPositiveButton(getResources().getString(R.string.triver_video_tips_not_wifi_confirm), new DialogInterface.OnClickListener() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd.5
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                TBMiniAppVideoStd.this.a(103);
                TBMiniAppVideoStd.this.a();
                TBMiniAppVideo.E = true;
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.triver_video_tips_not_wifi_cancel), new DialogInterface.OnClickListener() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                TBMiniAppVideoStd.this.I();
            }
        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd.7
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void T() {
        super.T();
        Dialog dialog = this.aI;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void U() {
        super.U();
        Dialog dialog = this.aN;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void V() {
        super.V();
        Dialog dialog = this.aR;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void W() {
        if (this.V.getVisibility() != 0) {
            X();
            this.aD.setText(this.ab.b().toString());
        }
        int i = this.L;
        if (i == 1) {
            i();
            if (this.V.getVisibility() == 0) {
                return;
            }
            X();
            return;
        }
        if (i == 3) {
            if (this.V.getVisibility() == 0) {
                k();
                return;
            } else {
                j();
                return;
            }
        }
        if (i == 5) {
            if (this.V.getVisibility() == 0) {
                m();
            } else {
                l();
            }
        }
    }

    public void X() {
        this.aB.setText(new SimpleDateFormat("HH:mm").format(new Date()));
        if (System.currentTimeMillis() - aU <= 30000) {
            Y();
        } else {
            aU = System.currentTimeMillis();
            getContext().registerReceiver(this.f24839a, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        }
    }

    public void Y() {
    }

    public void Z() {
        int i = this.L;
        if (i == 1) {
            if (this.V.getVisibility() == 0) {
                i();
            }
        } else if (i == 3) {
            if (this.V.getVisibility() == 0) {
                k();
            }
        } else if (i == 5) {
            if (this.V.getVisibility() == 0) {
                m();
            }
        } else if (i == 6 && this.V.getVisibility() == 0) {
            n();
        }
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void a(Context context) {
        super.a(context);
        this.aA = (LinearLayout) findViewById(R.id.trv_battery_time_layout);
        this.aw = (ProgressBar) findViewById(R.id.trv_bottom_progress);
        this.av = (ImageView) findViewById(R.id.trv_back);
        this.ay = (ImageView) findViewById(R.id.trv_thumb);
        this.ax = (ProgressBar) findViewById(R.id.trv_loading);
        this.az = (ImageView) findViewById(R.id.trv_back_tiny);
        this.aB = (TextView) findViewById(R.id.trv_video_current_time);
        this.aC = (TextView) findViewById(R.id.trv_replay_text);
        this.aD = (TextView) findViewById(R.id.trv_clarity);
        this.aF = (TextView) findViewById(R.id.trv_retry_btn);
        this.aG = (LinearLayout) findViewById(R.id.trv_retry_layout);
        this.c = (ImageView) findViewById(R.id.trv_iv_mute);
        this.b = (ImageView) findViewById(R.id.trv_bottom_play_button);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TBMiniAppVideoStd tBMiniAppVideoStd = TBMiniAppVideoStd.this;
                boolean z = !tBMiniAppVideoStd.aW;
                tBMiniAppVideoStd.aW = z;
                tBMiniAppVideoStd.setMuted(z);
            }
        });
        this.T.setOnTouchListener(new View.OnTouchListener() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    System.out.println("-------->down");
                    if (!"1".equals(TBMiniAppVideoStd.this.aX)) {
                        return false;
                    }
                    TBMiniAppVideoStd.this.W();
                    TBMiniAppVideoStd.this.ac();
                    return false;
                }
                if (action == 1) {
                    System.out.println("-------->up");
                    return false;
                }
                if (action != 2) {
                    return false;
                }
                System.out.println("-------->move");
                return false;
            }
        });
        this.av.setOnClickListener(this);
        this.az.setOnClickListener(this);
        this.aD.setOnClickListener(this);
        this.aF.setOnClickListener(this);
        this.b.setOnClickListener(this);
        setMuted(c.f() == 0.0f);
    }

    public void aa() {
        setFullScreenButtonVisibility(this.d);
        setMuteButtonVisibility(this.e);
        setCenterPlayButtonVisibility(this.f);
        setBottomPlayVisibility(this.aY);
        setControlsVisibility(this.aZ);
        setThinProgressBarVisibility(this.ba);
    }

    public void ab() {
        int i = this.L;
        if (i == 3) {
            this.O.setVisibility(this.f);
            this.O.setImageResource(R.drawable.jz_click_pause_selector);
            this.b.setImageResource(R.mipmap.control_pause);
            this.aC.setVisibility(4);
            return;
        }
        if (i == 7) {
            this.O.setVisibility(this.f);
            this.aC.setVisibility(4);
            return;
        }
        if (i == 6) {
            this.O.setVisibility(this.f);
            this.O.setImageResource(R.drawable.jz_click_replay_selector);
            this.b.setImageResource(R.mipmap.control_play);
            this.aC.setVisibility(0);
            return;
        }
        if (i != 8) {
            this.O.setImageResource(R.drawable.jz_click_play_selector);
            this.b.setImageResource(R.mipmap.control_play);
            this.aC.setVisibility(4);
        } else {
            this.O.setVisibility(this.f);
            this.O.setImageResource(R.drawable.jz_click_play_selector);
            this.b.setImageResource(R.mipmap.control_play);
            this.aC.setVisibility(4);
        }
    }

    public void ac() {
        ad();
        au = new Timer();
        a aVar = new a();
        this.aH = aVar;
        au.schedule(aVar, com.ipd.dsp.internal.v1.b.C0923b.f);
    }

    public void ad() {
        Timer timer = au;
        if (timer != null) {
            timer.cancel();
        }
        a aVar = this.aH;
        if (aVar != null) {
            aVar.cancel();
        }
    }

    public void ae() {
        int i = this.L;
        if (i == 0 || i == 7 || i == 6) {
            return;
        }
        post(new Runnable() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd.8
            @Override // java.lang.Runnable
            public void run() {
                TBMiniAppVideoStd.this.V.setVisibility(4);
                TBMiniAppVideoStd.this.U.setVisibility(4);
                TBMiniAppVideoStd.this.O.setVisibility(4);
                PopupWindow popupWindow = TBMiniAppVideoStd.this.aE;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
                TBMiniAppVideoStd tBMiniAppVideoStd = TBMiniAppVideoStd.this;
                if (tBMiniAppVideoStd.M != 3) {
                    tBMiniAppVideoStd.aw.setVisibility(tBMiniAppVideoStd.ba);
                }
            }
        });
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void d() {
        super.d();
        k();
        ac();
    }

    public void d(int i) {
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void e() {
        super.e();
        l();
        ad();
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void f() {
        super.f();
        o();
        ad();
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void g() {
        super.g();
        n();
        ad();
        this.aw.setProgress(100);
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public int getLayoutId() {
        return R.layout.triver_jz_layout_standard;
    }

    public void h() {
        int i = this.M;
        if (i == 0 || i == 1 || i == 2) {
            a(0, 4, 0, 4, 0, 4, 4);
            ab();
        }
        aa();
    }

    public void i() {
        int i = this.M;
        if (i == 0 || i == 1 || i == 2) {
            a(4, 4, 4, 0, 0, 4, 4);
            ab();
        }
        aa();
    }

    public void j() {
        int i = this.M;
        if (i == 0 || i == 1 || i == 2) {
            a(0, 0, 0, 4, 4, 4, 4);
            ab();
        }
        aa();
        ab();
    }

    public void k() {
        int i = this.M;
        if (i == 0 || i == 1 || i == 2) {
            a(4, 4, 4, 4, 4, 0, 4);
        }
        aa();
        ab();
    }

    public void l() {
        int i = this.M;
        if (i == 0 || i == 1 || i == 2) {
            a(0, 0, 0, 4, 4, 4, 4);
            ab();
        }
        aa();
        ab();
    }

    public void m() {
        int i = this.M;
        if (i == 0 || i == 1 || i == 2) {
            a(4, 4, 4, 4, 4, 0, 4);
        }
        aa();
        ab();
    }

    public void n() {
        int i = this.M;
        if (i == 0 || i == 1 || i == 2) {
            a(0, 4, 0, 4, 0, 4, 4);
            ab();
        }
        aa();
    }

    public void o() {
        int i = this.M;
        if (i == 0 || i == 1) {
            a(4, 4, 0, 4, 4, 4, 0);
            ab();
        } else if (i == 2) {
            a(0, 4, 0, 4, 4, 4, 0);
            ab();
        }
        aa();
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == R.id.trv_thumb) {
            if (this.ab.c.isEmpty() || this.ab.a() == null) {
                TriverToastUtils.showToast(getContext(), getResources().getString(R.string.triver_video_no_url));
                return;
            }
            int i = this.L;
            if (i != 0) {
                if (i == 6) {
                    W();
                    return;
                }
                return;
            } else if (!this.ab.a().toString().startsWith("file") && !this.ab.a().toString().startsWith(WVNativeCallbackUtil.SEPERATER) && !g.a(getContext()) && !TBMiniAppVideo.E) {
                S();
                return;
            } else {
                a();
                a(101);
                return;
            }
        }
        if (id == R.id.trv_surface_container) {
            ac();
            return;
        }
        if (id == R.id.trv_back) {
            TBMiniAppVideo.u();
            return;
        }
        if (id == R.id.trv_back_tiny) {
            if (h.a().M == 1) {
                TBMiniAppVideo.v();
                return;
            } else {
                TBMiniAppVideo.u();
                return;
            }
        }
        if (id == R.id.trv_clarity) {
            final LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.triver_jz_layout_clarity, (ViewGroup) null);
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    int iIntValue = ((Integer) view2.getTag()).intValue();
                    TBMiniAppVideoStd tBMiniAppVideoStd = TBMiniAppVideoStd.this;
                    tBMiniAppVideoStd.a(iIntValue, tBMiniAppVideoStd.getCurrentPositionWhenPlaying());
                    TBMiniAppVideoStd tBMiniAppVideoStd2 = TBMiniAppVideoStd.this;
                    tBMiniAppVideoStd2.aD.setText(tBMiniAppVideoStd2.ab.b().toString());
                    for (int i2 = 0; i2 < linearLayout.getChildCount(); i2++) {
                        if (i2 == TBMiniAppVideoStd.this.ab.b) {
                            ((TextView) linearLayout.getChildAt(i2)).setTextColor(Color.parseColor("#fff85959"));
                        } else {
                            ((TextView) linearLayout.getChildAt(i2)).setTextColor(Color.parseColor("#ffffff"));
                        }
                    }
                    PopupWindow popupWindow = TBMiniAppVideoStd.this.aE;
                    if (popupWindow != null) {
                        popupWindow.dismiss();
                    }
                }
            };
            for (int i2 = 0; i2 < this.ab.c.size(); i2++) {
                String strA = this.ab.a(i2);
                TextView textView = (TextView) View.inflate(getContext(), R.layout.triver_jz_layout_clarity_item, null);
                textView.setText(strA);
                textView.setTag(Integer.valueOf(i2));
                linearLayout.addView(textView, i2);
                textView.setOnClickListener(onClickListener);
                if (i2 == this.ab.b) {
                    textView.setTextColor(Color.parseColor("#fff85959"));
                }
            }
            PopupWindow popupWindow = new PopupWindow((View) linearLayout, -2, -2, true);
            this.aE = popupWindow;
            popupWindow.setContentView(linearLayout);
            this.aE.showAsDropDown(this.aD);
            linearLayout.measure(0, 0);
            this.aE.update(this.aD, -(this.aD.getMeasuredWidth() / 3), -(this.aD.getMeasuredHeight() / 3), Math.round(linearLayout.getMeasuredWidth() * 2), linearLayout.getMeasuredHeight());
            return;
        }
        if (id != R.id.trv_retry_btn) {
            if (id == R.id.trv_bottom_play_button) {
                if (this.L == 5) {
                    this.b.setImageResource(R.mipmap.control_pause);
                } else {
                    this.b.setImageResource(R.mipmap.control_play);
                }
                super.onClick(this.O);
                return;
            }
            return;
        }
        if (this.ab.c.isEmpty() || this.ab.a() == null) {
            TriverToastUtils.showToast(getContext(), getResources().getString(R.string.triver_video_no_url));
            return;
        }
        if (!this.ab.a().toString().startsWith("file") && !this.ab.a().toString().startsWith(WVNativeCallbackUtil.SEPERATER) && !g.a(getContext()) && !TBMiniAppVideo.E) {
            S();
            return;
        }
        E();
        F();
        c.a(this.ab);
        c();
        a(1);
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        super.onStartTrackingTouch(seekBar);
        ad();
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo, android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        super.onStopTrackingTouch(seekBar);
        if (this.L == 3) {
            ae();
        } else {
            ac();
        }
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int id = view.getId();
        if (id == R.id.trv_surface_container) {
            if (motionEvent.getAction() == 1) {
                ac();
                if (this.am) {
                    long duration = getDuration();
                    long j = this.ar * 100;
                    if (duration == 0) {
                        duration = 1;
                    }
                    this.aw.setProgress((int) (j / duration));
                }
                if (!this.am && !this.al) {
                    a(102);
                    W();
                }
            }
        } else if (id == R.id.trv_bottom_seek_progress) {
            int action = motionEvent.getAction();
            if (action == 0) {
                ad();
            } else if (action == 1) {
                ac();
            }
        }
        return super.onTouch(view, motionEvent);
    }

    public void setAllViewRotation(int i) {
    }

    public void setBottomPlayVisibility(int i) {
        this.aY = i;
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void setBufferProgress(int i) {
        super.setBufferProgress(i);
        if (i != 0) {
            this.aw.setSecondaryProgress(i);
        }
    }

    public void setCenterPlayButtonVisibility(int i) {
        this.f = i;
        ImageView imageView = this.O;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
    }

    public void setControlsVisibility(int i) {
        this.aZ = i;
        ViewGroup viewGroup = this.V;
        if (viewGroup != null) {
            viewGroup.setVisibility(i);
        }
    }

    public void setFullScreenButtonVisibility(int i) {
        this.d = i;
        ImageView imageView = this.Q;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
    }

    public void setMuteButtonVisibility(int i) {
        this.e = i;
        ImageView imageView = this.c;
        if (imageView != null) {
            imageView.setVisibility(i);
            setMuted(c.f() == 0.0f);
        }
    }

    public void setMuted(boolean z) {
        if (z) {
            this.c.setImageResource(R.mipmap.jz_close_volume);
            c.b(0.0f);
        } else {
            this.c.setImageResource(R.mipmap.jz_add_volume);
            c.b(1.0f);
        }
    }

    public void setThinProgressBarVisibility(int i) {
        this.ba = i;
        ProgressBar progressBar = this.aw;
        if (progressBar != null) {
            progressBar.setVisibility(i);
        }
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void b() {
        super.b();
        h();
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void c() {
        super.c();
        i();
    }

    public Dialog b(View view) {
        Dialog dialog = new Dialog(getContext(), R.style.jz_style_dialog_progress);
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        window.addFlags(8);
        window.addFlags(32);
        window.addFlags(16);
        window.setLayout(-2, -2);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 17;
        window.setAttributes(attributes);
        return dialog;
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void c(int i) {
        super.c(i);
        if (this.aR == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.triver_jz_dialog_brightness, (ViewGroup) null);
            this.aT = (TextView) viewInflate.findViewById(R.id.trv_tv_brightness);
            this.aS = (ProgressBar) viewInflate.findViewById(R.id.trv_brightness_progressbar);
            this.aR = b(viewInflate);
        }
        if (!this.aR.isShowing()) {
            this.aR.show();
        }
        if (i > 100) {
            i = 100;
        } else if (i < 0) {
            i = 0;
        }
        this.aT.setText(i + "%");
        this.aS.setProgress(i);
        Z();
    }

    public TBMiniAppVideoStd(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24839a = new BroadcastReceiver() { // from class: com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideoStd.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                try {
                    if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                        TBMiniAppVideoStd.aV = (intent.getIntExtra(com.alibaba.ariver.permission.b.b, 0) * 100) / intent.getIntExtra("scale", 100);
                        TBMiniAppVideoStd.this.Y();
                        TBMiniAppVideoStd.this.getContext().unregisterReceiver(TBMiniAppVideoStd.this.f24839a);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
        this.aW = false;
        this.aX = "1";
        this.d = 4;
        this.e = 4;
        this.f = 4;
        this.aY = 4;
        this.aZ = 4;
        this.ba = 4;
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void a(com.alibaba.triver.embed.video.fullscreenvideo.a aVar, int i) {
        super.a(aVar, i);
        int i2 = this.M;
        if (i2 == 2) {
            this.Q.setImageResource(R.mipmap.jz_shrink);
            this.av.setVisibility(0);
            this.az.setVisibility(4);
            this.aA.setVisibility(0);
            if (aVar.c.size() == 1) {
                this.aD.setVisibility(8);
            } else {
                this.aD.setText(aVar.b().toString());
                this.aD.setVisibility(0);
            }
            d((int) getResources().getDimension(R.dimen.jz_start_button_w_h_fullscreen));
        } else if (i2 == 0 || i2 == 1) {
            this.Q.setImageResource(R.mipmap.jz_enlarge);
            this.av.setVisibility(8);
            this.az.setVisibility(4);
            d((int) getResources().getDimension(R.dimen.jz_start_button_w_h_normal));
            this.aA.setVisibility(8);
            this.aD.setVisibility(8);
        } else if (i2 == 3) {
            this.az.setVisibility(0);
            a(4, 4, 4, 4, 4, 4, 4);
            this.aA.setVisibility(8);
            this.aD.setVisibility(8);
        }
        X();
        if (this.as) {
            this.as = false;
            h.a(this);
            TBMiniAppVideo.u();
        }
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void a(int i, long j) {
        super.a(i, j);
        this.ax.setVisibility(0);
        this.O.setVisibility(4);
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void a(int i, long j, long j2) {
        super.a(i, j, j2);
        if (i != 0) {
            this.aw.setProgress(i);
        }
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.U.setVisibility(i);
        this.V.setVisibility(i2);
        this.O.setVisibility(i3);
        this.ax.setVisibility(i4);
        this.ay.setVisibility(i5);
        this.aw.setVisibility(i6);
        this.aG.setVisibility(i7);
    }

    public void a(TBMiniAppVideoStd tBMiniAppVideoStd) {
        if (tBMiniAppVideoStd != null) {
            this.d = tBMiniAppVideoStd.d;
            this.e = tBMiniAppVideoStd.e;
            this.f = tBMiniAppVideoStd.f;
            this.aY = tBMiniAppVideoStd.aY;
            this.aZ = tBMiniAppVideoStd.aZ;
        }
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void a(float f, String str, long j, String str2, long j2) {
        super.a(f, str, j, str2, j2);
        if (this.aI == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.triver_jz_dialog_progress, (ViewGroup) null);
            this.aJ = (ProgressBar) viewInflate.findViewById(R.id.trv_duration_progressbar);
            this.aK = (TextView) viewInflate.findViewById(R.id.trv_tv_current);
            this.aL = (TextView) viewInflate.findViewById(R.id.trv_tv_duration);
            this.aM = (ImageView) viewInflate.findViewById(R.id.trv_duration_image_tip);
            this.aI = b(viewInflate);
        }
        if (!this.aI.isShowing()) {
            this.aI.show();
        }
        this.aK.setText(str);
        this.aL.setText(" / " + str2);
        this.aJ.setProgress(j2 <= 0 ? 0 : (int) ((j * 100) / j2));
        if (f > 0.0f) {
            this.aM.setBackgroundResource(R.mipmap.jz_forward_icon);
        } else {
            this.aM.setBackgroundResource(R.mipmap.jz_backward_icon);
        }
        Z();
    }

    @Override // com.alibaba.triver.embed.video.fullscreenvideo.TBMiniAppVideo
    public void a(float f, int i) {
        super.a(f, i);
        if (this.aN == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.triver_jz_dialog_volume, (ViewGroup) null);
            this.aQ = (ImageView) viewInflate.findViewById(R.id.trv_volume_image_tip);
            this.aP = (TextView) viewInflate.findViewById(R.id.trv_tv_volume);
            this.aO = (ProgressBar) viewInflate.findViewById(R.id.trv_volume_progressbar);
            this.aN = b(viewInflate);
        }
        if (!this.aN.isShowing()) {
            this.aN.show();
        }
        if (i <= 0) {
            this.aQ.setBackgroundResource(R.mipmap.jz_close_volume);
        } else {
            this.aQ.setBackgroundResource(R.mipmap.jz_add_volume);
        }
        if (i > 100) {
            i = 100;
        } else if (i < 0) {
            i = 0;
        }
        this.aP.setText(i + "%");
        this.aO.setProgress(i);
        Z();
    }
}

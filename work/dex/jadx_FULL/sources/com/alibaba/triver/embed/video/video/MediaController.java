package com.alibaba.triver.embed.video.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.triver.embed.video.R;
import java.lang.ref.WeakReference;
import java.util.Formatter;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MediaController extends FrameLayout {
    private static final String c = "tclMediaController";
    private static final int m = Integer.MAX_VALUE;
    private static final int n = 1;
    private static final int o = 2;
    private View.OnClickListener A;
    private SeekBar.OnSeekBarChangeListener B;
    private View.OnClickListener C;
    private View.OnClickListener D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    StringBuilder f24880a;
    Formatter b;
    private a d;
    private Context e;
    private ViewGroup f;
    private View g;
    private SeekBar h;
    private TextView i;
    private TextView j;
    private boolean k;
    private boolean l;
    private boolean p;
    private boolean q;
    private boolean r;
    private View.OnClickListener s;
    private View.OnClickListener t;
    private ImageButton u;
    private ImageButton v;
    private ImageButton w;
    private Handler x;
    private Button y;
    private View.OnClickListener z;

    public interface a {
        void a();

        void a(int i);

        void b();

        int c();

        int d();

        boolean e();

        int f();

        boolean g();

        boolean h();

        boolean i();

        boolean j();

        void k();
    }

    public static class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<MediaController> f24886a;

        public b(MediaController mediaController) {
            this.f24886a = new WeakReference<>(mediaController);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MediaController mediaController = this.f24886a.get();
            if (mediaController == null || mediaController.d == null) {
                return;
            }
            int i = message.what;
            if (i == 1) {
                mediaController.d();
                return;
            }
            if (i != 2) {
                return;
            }
            int iG = mediaController.g();
            if (!mediaController.l && mediaController.k && mediaController.d.e()) {
                sendMessageDelayed(obtainMessage(2), 1000 - (iG % 1000));
            }
        }
    }

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.x = new b(this);
        this.z = new View.OnClickListener() { // from class: com.alibaba.triver.embed.video.video.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MediaController.this.h();
                MediaController.this.a(Integer.MAX_VALUE);
            }
        };
        this.A = new View.OnClickListener() { // from class: com.alibaba.triver.embed.video.video.MediaController.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MediaController.this.i();
                MediaController.this.a(Integer.MAX_VALUE);
            }
        };
        this.B = new SeekBar.OnSeekBarChangeListener() { // from class: com.alibaba.triver.embed.video.video.MediaController.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (MediaController.this.d != null && z) {
                    int iC = (int) ((((long) MediaController.this.d.c()) * ((long) i)) / 1000);
                    MediaController.this.d.a(iC);
                    if (MediaController.this.j != null) {
                        MediaController.this.j.setText(MediaController.this.b(iC));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.a(3600000);
                MediaController.this.l = true;
                MediaController.this.x.removeMessages(2);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                MediaController.this.l = false;
                MediaController.this.g();
                RVLogger.d(MediaController.c, "onStopTrackingTouch :update()");
                MediaController.this.e();
                MediaController.this.a(Integer.MAX_VALUE);
                MediaController.this.x.sendEmptyMessage(2);
            }
        };
        this.C = new View.OnClickListener() { // from class: com.alibaba.triver.embed.video.video.MediaController.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int iC;
                if (MediaController.this.d == null) {
                    return;
                }
                int iD = MediaController.this.d.d();
                if (MediaController.this.d.c() > 1800000) {
                    if (MediaController.this.d.c() >= 1800000) {
                        iC = MediaController.this.d.c() / 30;
                    }
                    MediaController.this.d.a(iD);
                    MediaController.this.g();
                    MediaController.this.a(Integer.MAX_VALUE);
                }
                iC = MediaController.this.d.c() / 10;
                iD -= iC;
                MediaController.this.d.a(iD);
                MediaController.this.g();
                MediaController.this.a(Integer.MAX_VALUE);
            }
        };
        this.D = new View.OnClickListener() { // from class: com.alibaba.triver.embed.video.video.MediaController.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int iC;
                if (MediaController.this.d == null) {
                    return;
                }
                int iD = MediaController.this.d.d();
                if (MediaController.this.d.c() > 1800000) {
                    if (MediaController.this.d.c() >= 1800000) {
                        iC = MediaController.this.d.c() / 30;
                    }
                    MediaController.this.d.a(iD);
                    MediaController.this.g();
                    MediaController.this.a(Integer.MAX_VALUE);
                }
                iC = MediaController.this.d.c() / 10;
                iD += iC;
                MediaController.this.d.a(iD);
                MediaController.this.g();
                MediaController.this.a(Integer.MAX_VALUE);
            }
        };
        this.g = null;
        this.e = context;
        this.p = true;
        this.q = true;
        RVLogger.d(c, c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.d == null) {
            return;
        }
        RVLogger.d(c, "doToggleFullscreen");
        this.d.k();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.d == null) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        boolean z = keyEvent.getRepeatCount() == 0 && keyEvent.getAction() == 0;
        if (keyCode == 79 || keyCode == 85 || keyCode == 62) {
            if (z) {
                h();
                a(Integer.MAX_VALUE);
                ImageButton imageButton = this.u;
                if (imageButton != null) {
                    imageButton.requestFocus();
                }
            }
            return true;
        }
        if (keyCode == 126) {
            if (z && !this.d.e()) {
                this.d.a();
                RVLogger.d(c, "dispatchKeyEvent KEYCODE_MEDIA_PLAY:update()");
                e();
                a(Integer.MAX_VALUE);
            }
            return true;
        }
        if (keyCode == 86 || keyCode == 127) {
            if (z && this.d.e()) {
                this.d.b();
                RVLogger.d(c, "dispatchKeyEvent KEYCODE_MEDIA_PAUSE:update()");
                e();
                a(Integer.MAX_VALUE);
            }
            return true;
        }
        if (keyCode == 25 || keyCode == 24 || keyCode == 164) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyCode != 4 && keyCode != 82) {
            a(Integer.MAX_VALUE);
            return super.dispatchKeyEvent(keyEvent);
        }
        if (z) {
            d();
        }
        return true;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        View view = this.g;
        if (view != null) {
            a(view);
        }
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(MediaController.class.getName());
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(MediaController.class.getName());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a(Integer.MAX_VALUE);
        return true;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        a(Integer.MAX_VALUE);
        return false;
    }

    public void setAnchorView(ViewGroup viewGroup) {
        this.f = viewGroup;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        removeAllViews();
        addView(a(), layoutParams);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        ImageButton imageButton = this.u;
        if (imageButton != null) {
            imageButton.setEnabled(z);
        }
        ImageButton imageButton2 = this.v;
        if (imageButton2 != null) {
            imageButton2.setEnabled(z);
        }
        ImageButton imageButton3 = this.w;
        if (imageButton3 != null) {
            imageButton3.setEnabled(z);
        }
        SeekBar seekBar = this.h;
        if (seekBar != null) {
            seekBar.setEnabled(z);
        }
        f();
        super.setEnabled(z);
    }

    public void setMediaPlayer(a aVar) {
        this.d = aVar;
        RVLogger.d(c, "setMediaPlayer :update()" + this.d.e());
        e();
    }

    private void f() {
        a aVar = this.d;
        if (aVar == null) {
            return;
        }
        try {
            if (this.u != null && !aVar.g()) {
                this.u.setEnabled(false);
            }
            if (this.w != null && !this.d.h()) {
                this.w.setEnabled(false);
            }
            if (this.v == null || this.d.i()) {
                return;
            }
            this.v.setEnabled(false);
        } catch (IncompatibleClassChangeError unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g() {
        a aVar = this.d;
        if (aVar == null || this.l) {
            return 0;
        }
        int iD = aVar.d();
        int iC = this.d.c();
        SeekBar seekBar = this.h;
        if (seekBar != null) {
            if (iC > 0) {
                seekBar.setProgress((int) ((((long) iD) * 1000) / ((long) iC)));
            }
            this.h.setSecondaryProgress(this.d.f() * 10);
        }
        TextView textView = this.i;
        if (textView != null) {
            textView.setText(b(iC));
        }
        TextView textView2 = this.j;
        if (textView2 != null) {
            textView2.setText(b(iD));
        }
        return iD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        a aVar = this.d;
        if (aVar == null) {
            return;
        }
        if (aVar.e()) {
            this.d.b();
        } else {
            this.d.a();
        }
        e();
    }

    public void b() {
        a(Integer.MAX_VALUE);
    }

    public boolean c() {
        return this.k;
    }

    public void d() {
        ViewGroup viewGroup = this.f;
        if (viewGroup == null) {
            return;
        }
        try {
            viewGroup.removeView(this);
            this.x.removeMessages(2);
        } catch (IllegalArgumentException unused) {
            RVLogger.w("MediaController", "already removed");
        }
        this.k = false;
    }

    public void e() {
        a aVar;
        if (this.g == null || this.u == null || (aVar = this.d) == null) {
            return;
        }
        if (aVar.e()) {
            this.u.setImageResource(R.mipmap.control_pause);
        } else {
            if (this.d.e()) {
                return;
            }
            this.u.setImageResource(R.mipmap.control_play);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        this.f24880a.setLength(0);
        return i5 > 0 ? this.b.format("%d:%02d:%02d", Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)).toString() : this.b.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3)).toString();
    }

    public View a() {
        View viewInflate = ((LayoutInflater) this.e.getSystemService("layout_inflater")).inflate(R.layout.triver_now_media_controller, (ViewGroup) null);
        this.g = viewInflate;
        a(viewInflate);
        return this.g;
    }

    private void a(View view) {
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.trv_pause);
        this.u = imageButton;
        if (imageButton != null) {
            imageButton.requestFocus();
            this.u.setOnClickListener(this.z);
            this.u.invalidate();
        }
        ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.trv_ffwd);
        this.v = imageButton2;
        if (imageButton2 != null) {
            imageButton2.setOnClickListener(this.D);
            if (!this.q) {
                this.v.setVisibility(this.p ? 0 : 8);
            }
        }
        ImageButton imageButton3 = (ImageButton) view.findViewById(R.id.trv_rew);
        this.w = imageButton3;
        if (imageButton3 != null) {
            imageButton3.setOnClickListener(this.C);
            if (!this.q) {
                this.w.setVisibility(this.p ? 0 : 8);
            }
        }
        Button button = (Button) view.findViewById(R.id.trv_button2);
        this.y = button;
        button.setOnClickListener(this.A);
        SeekBar seekBar = (SeekBar) view.findViewById(R.id.trv_mediaController_progress);
        this.h = seekBar;
        if (seekBar != null) {
            if (seekBar instanceof SeekBar) {
                seekBar.setOnSeekBarChangeListener(this.B);
            }
            this.h.setMax(1000);
        }
        this.i = (TextView) view.findViewById(R.id.trv_time);
        this.j = (TextView) view.findViewById(R.id.trv_time_current);
        this.f24880a = new StringBuilder();
        this.b = new Formatter(this.f24880a, Locale.getDefault());
    }

    public MediaController(Context context, boolean z) {
        super(context);
        this.x = new b(this);
        this.z = new View.OnClickListener() { // from class: com.alibaba.triver.embed.video.video.MediaController.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MediaController.this.h();
                MediaController.this.a(Integer.MAX_VALUE);
            }
        };
        this.A = new View.OnClickListener() { // from class: com.alibaba.triver.embed.video.video.MediaController.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MediaController.this.i();
                MediaController.this.a(Integer.MAX_VALUE);
            }
        };
        this.B = new SeekBar.OnSeekBarChangeListener() { // from class: com.alibaba.triver.embed.video.video.MediaController.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z2) {
                if (MediaController.this.d != null && z2) {
                    int iC = (int) ((((long) MediaController.this.d.c()) * ((long) i)) / 1000);
                    MediaController.this.d.a(iC);
                    if (MediaController.this.j != null) {
                        MediaController.this.j.setText(MediaController.this.b(iC));
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.a(3600000);
                MediaController.this.l = true;
                MediaController.this.x.removeMessages(2);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                MediaController.this.l = false;
                MediaController.this.g();
                RVLogger.d(MediaController.c, "onStopTrackingTouch :update()");
                MediaController.this.e();
                MediaController.this.a(Integer.MAX_VALUE);
                MediaController.this.x.sendEmptyMessage(2);
            }
        };
        this.C = new View.OnClickListener() { // from class: com.alibaba.triver.embed.video.video.MediaController.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int iC;
                if (MediaController.this.d == null) {
                    return;
                }
                int iD = MediaController.this.d.d();
                if (MediaController.this.d.c() > 1800000) {
                    if (MediaController.this.d.c() >= 1800000) {
                        iC = MediaController.this.d.c() / 30;
                    }
                    MediaController.this.d.a(iD);
                    MediaController.this.g();
                    MediaController.this.a(Integer.MAX_VALUE);
                }
                iC = MediaController.this.d.c() / 10;
                iD -= iC;
                MediaController.this.d.a(iD);
                MediaController.this.g();
                MediaController.this.a(Integer.MAX_VALUE);
            }
        };
        this.D = new View.OnClickListener() { // from class: com.alibaba.triver.embed.video.video.MediaController.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int iC;
                if (MediaController.this.d == null) {
                    return;
                }
                int iD = MediaController.this.d.d();
                if (MediaController.this.d.c() > 1800000) {
                    if (MediaController.this.d.c() >= 1800000) {
                        iC = MediaController.this.d.c() / 30;
                    }
                    MediaController.this.d.a(iD);
                    MediaController.this.g();
                    MediaController.this.a(Integer.MAX_VALUE);
                }
                iC = MediaController.this.d.c() / 10;
                iD += iC;
                MediaController.this.d.a(iD);
                MediaController.this.g();
                MediaController.this.a(Integer.MAX_VALUE);
            }
        };
        this.e = context;
        this.p = z;
        RVLogger.d(c, c);
    }

    public MediaController(Context context) {
        this(context, true);
        RVLogger.d(c, c);
    }

    public void a(int i) {
        if (!this.k && this.f != null) {
            g();
            ImageButton imageButton = this.u;
            if (imageButton != null) {
                imageButton.requestFocus();
            }
            f();
            this.f.addView(this, new FrameLayout.LayoutParams(-1, -2, 80));
            this.k = true;
        }
        e();
        this.x.sendEmptyMessage(2);
        Message messageObtainMessage = this.x.obtainMessage(1);
        if (i != 0) {
            this.x.removeMessages(1);
            this.x.sendMessageDelayed(messageObtainMessage, i);
        }
    }

    public void a(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.s = onClickListener;
        this.t = onClickListener2;
        this.r = true;
    }
}

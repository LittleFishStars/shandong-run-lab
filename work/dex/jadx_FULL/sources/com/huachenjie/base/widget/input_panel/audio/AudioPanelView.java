package com.huachenjie.base.widget.input_panel.audio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.hjq.permissions.Permission;
import com.huachenjie.base.R;
import com.huachenjie.common.util.permission.PermissionResultListener;
import com.zj.adlib.vo6;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class AudioPanelView extends ConstraintLayout {
    public static final int AUDIO_DEADLINE = 2;
    public static final int AUDIO_NORMAL = 0;
    public static final int AUDIO_RECORDING = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View.OnTouchListener f32989a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageView f7337a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LottieAnimationView f7338a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AudioRecordCallback f7339a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AtomicInteger f7340a;
    public ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public LottieAnimationView f7341b;
    public TextView e;

    public class a implements PermissionResultListener {
        public a() {
        }

        @Override // com.huachenjie.common.util.permission.PermissionResultListener
        public void onResult(boolean granted) {
            if (granted) {
                AudioPanelView.this.f7340a.set(1);
                if (AudioPanelView.this.f7339a != null) {
                    AudioPanelView.this.f7339a.a();
                }
            }
        }
    }

    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();
            if (action != 1) {
                if (action != 2 || AudioPanelView.this.f7340a.get() == 0) {
                    return false;
                }
                if (AudioPanelView.this.h(v, event)) {
                    AudioPanelView.this.C();
                } else {
                    AudioPanelView.this.D();
                }
            } else if (AudioPanelView.this.f7340a.get() != 0) {
                AudioPanelView.this.showNormal();
                if (AudioPanelView.this.f7339a != null) {
                    AudioPanelView.this.f7339a.b(AudioPanelView.this.h(v, event));
                }
            }
            return false;
        }
    }

    public AudioPanelView(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean j(View view) {
        if (this.f7340a.get() != 0) {
            return false;
        }
        E();
        return true;
    }

    public final void C() {
        this.f7337a.setImageResource(R.drawable.ic_audio_panel_cancel);
        this.f7338a.setVisibility(0);
        this.f7341b.setVisibility(0);
        if (this.f7340a.get() != 2) {
            this.e.setVisibility(0);
            this.b.setVisibility(8);
            this.e.setText("松开取消发送");
            this.e.setTextColor(Color.parseColor("#9C9C9C"));
        }
    }

    public final void D() {
        this.f7337a.setImageResource(R.drawable.ic_audio_panel_recording);
        this.f7338a.setVisibility(0);
        this.f7341b.setVisibility(0);
        if (this.f7340a.get() != 2) {
            this.e.setVisibility(0);
            this.b.setVisibility(8);
            this.e.setText("松开发送 上滑取消");
            this.e.setTextColor(Color.parseColor("#9C9C9C"));
        }
    }

    public final void E() {
        vo6.j(getContext(), Permission.RECORD_AUDIO, "为了能正常录制您的语音发送给他人，我们需要访问您终端设备的麦克风权限", new a());
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void g(Context context) {
        View.inflate(context, R.layout.view_panel_audio, this);
        this.f7337a = (ImageView) findViewById(R.id.iv_audio_bt);
        this.f7338a = (LottieAnimationView) findViewById(R.id.iv_audio_line_left);
        this.f7341b = (LottieAnimationView) findViewById(R.id.iv_audio_line_right);
        this.b = (ImageView) findViewById(R.id.iv_audio_recorde_tip);
        this.e = (TextView) findViewById(R.id.tv_audio_recorde_tip);
        this.f7337a.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.zj.adlib.we0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f45579a.j(view);
            }
        });
        this.f7337a.setOnTouchListener(this.f32989a);
        this.f7340a.set(0);
    }

    public final boolean h(View view, MotionEvent event) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int iRound = Math.round(view.getWidth() / 2.0f);
        if (iRound == 0) {
            iRound = Math.round(TypedValue.applyDimension(1, 126.0f, view.getContext().getResources().getDisplayMetrics()) / 2.0f);
        }
        return !i(event.getRawX(), event.getRawY(), iArr[0] + iRound, iArr[1] + iRound, iRound);
    }

    public final boolean i(float x, float y, float cX, float cY, float radius) {
        float f = x - cX;
        float f2 = y - cY;
        return radius * radius > (f * f) + (f2 * f2);
    }

    public void setCallback(AudioRecordCallback callback) {
        this.f7339a = callback;
    }

    public void showCountdown(String tipText) {
        this.f7340a.set(2);
        this.e.setVisibility(0);
        this.b.setVisibility(0);
        this.e.setText(tipText);
        this.e.setTextColor(Color.parseColor("#FFFF762F"));
    }

    public void showNormal() {
        this.f7340a.set(0);
        this.f7337a.setImageResource(R.drawable.ic_audio_panel_start);
        this.f7338a.setVisibility(8);
        this.f7341b.setVisibility(8);
        this.e.setVisibility(8);
        this.b.setVisibility(8);
    }

    public AudioPanelView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AudioPanelView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f7340a = new AtomicInteger();
        this.f32989a = new b();
        g(context);
    }
}

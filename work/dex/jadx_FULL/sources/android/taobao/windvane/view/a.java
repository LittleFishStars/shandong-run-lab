package android.taobao.windvane.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.taobao.windvane.util.EnvUtil;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;
import com.zj.adlib.ar6;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    AtomicBoolean f21244a;
    private Context b;
    private View c;
    private PopupWindow d;
    private FrameLayout e;
    private LinearLayout f;
    private Animation g;
    private boolean h;
    private int i;

    /* JADX INFO: renamed from: android.taobao.windvane.view.a$3, reason: invalid class name */
    public class AnonymousClass3 implements ViewTreeObserver.OnScrollChangedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Field f21247a;
        final /* synthetic */ PopupWindow b;
        final /* synthetic */ ViewTreeObserver.OnScrollChangedListener c;

        public AnonymousClass3(Field field, PopupWindow popupWindow, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
            this.f21247a = field;
            this.b = popupWindow;
            this.c = onScrollChangedListener;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            try {
                WeakReference weakReference = (WeakReference) this.f21247a.get(this.b);
                if (weakReference != null && weakReference.get() != null) {
                    this.c.onScrollChanged();
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public a(Context context, View view, String[] strArr, View.OnClickListener onClickListener) {
        this(context, view, null, strArr, onClickListener);
    }

    private void a(PopupWindow popupWindow) {
    }

    private void d() {
        PopupWindow popupWindow = new PopupWindow(this.b);
        this.d = popupWindow;
        popupWindow.setContentView(this.e);
        this.d.setWidth(-1);
        this.d.setHeight(-1);
        this.d.setFocusable(true);
        this.d.setOutsideTouchable(true);
        this.d.setBackgroundDrawable(new ColorDrawable(2130706432));
        a(this.d);
        this.d.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: android.taobao.windvane.view.a.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (!a.this.h) {
                    a.this.h = true;
                    return;
                }
                View childAt = a.this.f.getChildAt(a.this.i);
                if (childAt != null) {
                    childAt.performClick();
                }
            }
        });
    }

    public a(Context context, View view, String str, String[] strArr, View.OnClickListener onClickListener) {
        this.f21244a = new AtomicBoolean(false);
        this.h = true;
        this.i = 4;
        this.b = context;
        this.c = view;
        a(str, strArr, onClickListener);
        d();
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 1, 1.0f, 1, 0.0f);
        this.g = translateAnimation;
        translateAnimation.setDuration(250L);
    }

    public void b() {
        if (this.f21244a.get()) {
            this.h = false;
            this.d.dismiss();
            if (this.d.isShowing()) {
                return;
            }
            this.f21244a.compareAndSet(true, false);
        }
    }

    public void c() {
        PopupWindow popupWindow = this.d;
        if (popupWindow != null) {
            popupWindow.dismiss();
            this.d = null;
        }
    }

    public void a() {
        if (this.f21244a.compareAndSet(false, true)) {
            try {
                this.d.showAtLocation(this.c, 81, 0, 0);
                this.f.startAnimation(this.g);
                this.d.update();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void a(String str, String[] strArr, View.OnClickListener onClickListener) {
        FrameLayout frameLayout = new FrameLayout(this.b);
        this.e = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(this.b);
        this.f = linearLayout;
        linearLayout.setOrientation(1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.f.setLayoutParams(layoutParams);
        this.f.setBackgroundColor(-7829368);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        if (!TextUtils.isEmpty(str)) {
            Button button = new Button(this.b);
            button.setText(str);
            button.setBackgroundColor(ar6.E);
            button.setTextColor(-7829368);
            button.setLayoutParams(layoutParams2);
            this.f.addView(button);
            TextView textView = new TextView(this.b);
            textView.setHeight(4);
            this.f.addView(textView);
        }
        if (strArr != null) {
            for (String str2 : strArr) {
                Button button2 = new Button(this.b);
                button2.setText(str2);
                button2.setTag(str2);
                button2.setBackgroundColor(ar6.E);
                button2.setTextColor(-16777216);
                button2.setLayoutParams(layoutParams2);
                button2.setOnClickListener(onClickListener);
                this.f.addView(button2);
                TextView textView2 = new TextView(this.b);
                textView2.setHeight(2);
                this.f.addView(textView2);
            }
        }
        final Button button3 = new Button(this.b);
        button3.setText(EnvUtil.isCN() ? OptionsPickerHelper.e : "Cancel");
        button3.setBackgroundColor(ar6.E);
        button3.setTextColor(-7829368);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = 4;
        button3.setLayoutParams(layoutParams3);
        this.f.addView(button3);
        this.e.addView(this.f);
        button3.setOnClickListener(onClickListener);
        this.e.setOnTouchListener(new View.OnTouchListener() { // from class: android.taobao.windvane.view.a.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int top = a.this.f.getTop();
                int y = (int) motionEvent.getY();
                if (motionEvent.getAction() == 1 && y < top) {
                    button3.performClick();
                }
                return true;
            }
        });
    }
}

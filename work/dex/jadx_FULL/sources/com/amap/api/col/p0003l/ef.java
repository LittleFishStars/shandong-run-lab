package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.zj.adlib.twa;
import com.zj.adlib.zwa;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ef extends ScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25915a = "ef";
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f795a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f796a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LinearLayout f797a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f798a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Runnable f799a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<String> f800a;
    int b;

    public interface a {
        void a(int i);
    }

    public class b implements Runnable {

        public class a implements Runnable {
            public final /* synthetic */ int K;
            public final /* synthetic */ int L;

            public a(int i, int i2) {
                this.K = i;
                this.L = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ef efVar = ef.this;
                efVar.smoothScrollTo(0, (efVar.S - this.K) + ef.this.K);
                ef efVar2 = ef.this;
                efVar2.b = this.L + efVar2.Q + 1;
                ef.this.j();
            }
        }

        /* JADX INFO: renamed from: com.amap.api.col.3l.ef$b$b, reason: collision with other inner class name */
        public class RunnableC0246b implements Runnable {
            public final /* synthetic */ int K;
            public final /* synthetic */ int L;

            public RunnableC0246b(int i, int i2) {
                this.K = i;
                this.L = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ef efVar = ef.this;
                efVar.smoothScrollTo(0, efVar.S - this.K);
                ef efVar2 = ef.this;
                efVar2.b = this.L + efVar2.Q;
                ef.this.j();
            }
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ef.this.S - ef.this.getScrollY() != 0) {
                ef efVar = ef.this;
                efVar.S = efVar.getScrollY();
                ef efVar2 = ef.this;
                efVar2.postDelayed(efVar2.f799a, ef.this.T);
                return;
            }
            if (ef.this.K == 0) {
                return;
            }
            int i = ef.this.S % ef.this.K;
            int i2 = ef.this.S / ef.this.K;
            if (i == 0) {
                ef efVar3 = ef.this;
                efVar3.b = i2 + efVar3.Q;
                ef.this.j();
            } else if (i > ef.this.K / 2) {
                ef.this.post(new a(i, i2));
            } else {
                ef.this.post(new RunnableC0246b(i, i2));
            }
        }
    }

    public class c extends Drawable {
        public c() {
        }

        public final void a(Canvas canvas) {
            canvas.drawColor(ef.this.N);
        }

        public final void b(Canvas canvas) {
            Paint paint = new Paint();
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            rect.left = 0;
            rect.top = 0;
            rect.right = ef.this.f796a.getWidth() + 0;
            rect.bottom = ef.this.f796a.getHeight() + 0;
            rect2.left = 0;
            rect2.top = ef.this.i()[0];
            rect2.right = ef.this.M + 0;
            rect2.bottom = ef.this.i()[1];
            canvas.drawBitmap(ef.this.f796a, rect, rect2, paint);
        }

        public final void c(Canvas canvas) {
            Paint paint = new Paint();
            Rect clipBounds = canvas.getClipBounds();
            paint.setColor(ef.this.O);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(ef.this.P);
            canvas.drawRect(clipBounds, paint);
        }

        @Override // android.graphics.drawable.Drawable
        public final void draw(Canvas canvas) {
            try {
                a(canvas);
                b(canvas);
                c(canvas);
            } catch (Throwable unused) {
            }
        }

        @Override // android.graphics.drawable.Drawable
        public final int getOpacity() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public final void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public final void setColorFilter(ColorFilter colorFilter) {
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ int K;

        public d(int i) {
            this.K = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ef efVar = ef.this;
            efVar.smoothScrollTo(0, this.K * efVar.K);
        }
    }

    public ef(Context context) {
        super(context);
        this.K = 0;
        this.L = -1;
        this.f796a = null;
        this.N = Color.parseColor("#eeffffff");
        this.O = Color.parseColor("#44383838");
        this.P = 4;
        this.Q = 1;
        this.b = 1;
        this.T = 50;
        d(context);
    }

    @Override // android.widget.ScrollView
    public void fling(int i) {
        super.fling(i / 3);
    }

    @Override // android.view.View
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        c(i2);
        if (i2 > i4) {
            this.L = 1;
        } else {
            this.L = 0;
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.M = i;
        try {
            setBackgroundDrawable(null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            g();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.N = i;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.M == 0) {
            try {
                WindowManager windowManager = (WindowManager) this.f795a.getSystemService("window");
                if (windowManager != null) {
                    this.M = windowManager.getDefaultDisplay().getWidth();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        super.setBackgroundDrawable(new c());
    }

    public static int b(View view) {
        f(view);
        return view.getMeasuredHeight();
    }

    public static void f(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public final void c(int i) {
        int i2 = this.K;
        if (i2 == 0) {
            return;
        }
        int i3 = this.Q;
        int i4 = (i / i2) + i3;
        int i5 = i % i2;
        int i6 = i / i2;
        if (i5 == 0) {
            i4 = i6 + i3;
        } else if (i5 > i2 / 2) {
            i4 = i6 + i3 + 1;
        }
        int childCount = this.f797a.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            TextView textView = (TextView) this.f797a.getChildAt(i7);
            if (textView == null) {
                return;
            }
            if (i4 == i7) {
                textView.setTextColor(Color.parseColor("#0288ce"));
            } else {
                textView.setTextColor(Color.parseColor("#bbbbbb"));
            }
        }
    }

    public final void d(Context context) {
        this.f795a = context;
        setVerticalScrollBarEnabled(false);
        try {
            if (this.f796a == null) {
                InputStream inputStreamOpen = twa.b(context).open("map_indoor_select.png");
                this.f796a = BitmapFactory.decodeStream(inputStreamOpen);
                inputStreamOpen.close();
            }
        } catch (Throwable unused) {
        }
        LinearLayout linearLayout = new LinearLayout(context);
        this.f797a = linearLayout;
        linearLayout.setOrientation(1);
        addView(this.f797a);
        this.f799a = new b();
    }

    public final TextView e(String str) {
        TextView textView = new TextView(this.f795a);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        textView.setSingleLine(true);
        textView.setTextSize(2, 16.0f);
        textView.setText(str);
        textView.setGravity(17);
        textView.getPaint().setFakeBoldText(true);
        int iA = a(this.f795a, 8.0f);
        int iA2 = a(this.f795a, 6.0f);
        textView.setPadding(iA, iA2, iA, iA2);
        if (this.K == 0) {
            this.K = b(textView);
            this.f797a.setLayoutParams(new FrameLayout.LayoutParams(-2, this.K * this.R));
            setLayoutParams(new LinearLayout.LayoutParams(-2, this.K * this.R));
        }
        return textView;
    }

    public final void g() {
        this.S = getScrollY();
        postDelayed(this.f799a, this.T);
    }

    public final void h() {
        List<String> list = this.f800a;
        if (list == null || list.size() == 0) {
            return;
        }
        this.f797a.removeAllViews();
        this.R = (this.Q * 2) + 1;
        for (int size = this.f800a.size() - 1; size >= 0; size--) {
            this.f797a.addView(e(this.f800a.get(size)));
        }
        c(0);
    }

    public final int[] i() {
        int i = this.K;
        int i2 = this.Q;
        return new int[]{i * i2, i * (i2 + 1)};
    }

    public final void j() {
        a aVar = this.f798a;
        if (aVar != null) {
            try {
                aVar.a(k());
            } catch (Throwable unused) {
            }
        }
    }

    public final int k() {
        List<String> list = this.f800a;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return Math.min(this.f800a.size() - (this.Q * 2), Math.max(0, ((this.f800a.size() - 1) - this.b) - this.Q));
    }

    public final void a(String[] strArr) {
        if (this.f800a == null) {
            this.f800a = new ArrayList();
        }
        this.f800a.clear();
        for (String str : strArr) {
            this.f800a.add(str);
        }
        for (int i = 0; i < this.Q; i++) {
            this.f800a.add(0, "");
            this.f800a.add("");
        }
        h();
    }

    public final boolean b() {
        return getVisibility() == 0;
    }

    public final void a() {
        Bitmap bitmap = this.f796a;
        if (bitmap != null && !bitmap.isRecycled()) {
            zwa.B(this.f796a);
            this.f796a = null;
        }
        if (this.f798a != null) {
            this.f798a = null;
        }
    }

    public final void a(String str) {
        List<String> list = this.f800a;
        if (list == null || list.size() == 0) {
            return;
        }
        int iIndexOf = this.f800a.indexOf(str);
        int size = this.f800a.size();
        int i = this.Q;
        int i2 = ((size - i) - 1) - iIndexOf;
        this.b = i + i2;
        post(new d(i2));
    }

    public final void a(a aVar) {
        this.f798a = aVar;
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final void a(boolean z) {
        setVisibility(z ? 0 : 8);
    }
}

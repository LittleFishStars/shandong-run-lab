package com.beizi.fusion;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.fusion.widget.CustomRoundImageView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class lj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewGroup f27512a;
    private View b;
    private CustomRoundImageView c;
    private TextView d;
    private TextView e;
    private LinearLayout f;
    private TextView g;
    private e h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    protected Handler r = new a(Looper.getMainLooper());

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    if (lj.this.f27512a != null) {
                        try {
                            lj ljVar = lj.this;
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ljVar.k, ljVar.l);
                            lj ljVar2 = lj.this;
                            View view = ljVar2.b;
                            int i = ljVar2.p;
                            view.setPadding(i, i, i, i);
                            lj ljVar3 = lj.this;
                            vn.a(ljVar3.b, "#FFFFFF", 0, null, ljVar3.l / 4);
                            lj ljVar4 = lj.this;
                            ljVar4.f27512a.addView(ljVar4.b, layoutParams);
                            lj ljVar5 = lj.this;
                            d7.a(ljVar5.b, ljVar5.k, ljVar5.l, ljVar5.i, ljVar5.j, ljVar5.m, 300);
                            e eVar = lj.this.h;
                            if (eVar != null) {
                                eVar.b();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                        break;
                    }
                    break;
                case 1002:
                    lj.this.c();
                    break;
                case 1003:
                    lj.this.a();
                    break;
            }
        }
    }

    public class b implements of.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f27514a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Bitmap f27515a;

            /* JADX INFO: renamed from: com.beizi.fusion.lj$b$a$a, reason: collision with other inner class name */
            public class RunnableC0313a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ BitmapDrawable f27516a;

                public RunnableC0313a(BitmapDrawable bitmapDrawable) {
                    this.f27516a = bitmapDrawable;
                }

                @Override // java.lang.Runnable
                public void run() {
                    CustomRoundImageView customRoundImageView;
                    try {
                        BitmapDrawable bitmapDrawable = this.f27516a;
                        if (bitmapDrawable == null || (customRoundImageView = lj.this.c) == null) {
                            return;
                        }
                        customRoundImageView.setBackground(bitmapDrawable);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }

            public a(Bitmap bitmap) {
                this.f27515a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                try {
                    Context context = b.this.f27514a;
                    if (context == null || (bitmap = this.f27515a) == null) {
                        return;
                    }
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(qf.a(context, bitmap, 20.0f));
                    Handler handler = lj.this.r;
                    if (handler != null) {
                        handler.post(new RunnableC0313a(bitmapDrawable));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        public b(Context context) {
            this.f27514a = context;
        }

        @Override // com.beizi.fusion.of.f
        public void a() {
        }

        @Override // com.beizi.fusion.of.f
        public void a(Bitmap bitmap) {
            try {
                float fAbs = Math.abs(1.0f - ((float) ((((double) bitmap.getWidth()) * 1.0d) / ((double) bitmap.getHeight()))));
                if (fAbs > 0.1f) {
                    w3.c().e().execute(new a(bitmap));
                } else if (fAbs > 0.07d) {
                    lj.this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
                } else {
                    lj.this.c.setScaleType(ImageView.ScaleType.FIT_XY);
                }
                CustomRoundImageView customRoundImageView = lj.this.c;
                if (customRoundImageView != null) {
                    customRoundImageView.setVisibility(0);
                    lj.this.c.setImageBitmap(bitmap);
                    lj.this.c.setRectRadius(20.0f);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27517a;

        public c(int i) {
            this.f27517a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Handler handler = lj.this.r;
                if (handler != null) {
                    if (this.f27517a == 0) {
                        handler.sendEmptyMessage(1003);
                    } else {
                        handler.sendEmptyMessage(1002);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class d implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27518a;

        public d(int i) {
            this.f27518a = i;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Handler handler;
            try {
                if (motionEvent.getAction() == 0 && (handler = lj.this.r) != null) {
                    if (this.f27518a == 1) {
                        handler.sendEmptyMessage(1003);
                    } else {
                        handler.sendEmptyMessage(1002);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    public interface e {
        void a();

        void b();
    }

    public void a(ViewGroup viewGroup, int i, int i2, kj kjVar, e eVar) {
        Handler handler;
        Handler handler2;
        TextView textView;
        TextView textView2;
        if (viewGroup == null || kjVar == null) {
            return;
        }
        try {
            this.h = eVar;
            this.f27512a = viewGroup;
            Context context = viewGroup.getContext();
            this.m = kjVar.a();
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.beizi_notification_window, (ViewGroup) null);
            this.b = viewInflate;
            this.c = (CustomRoundImageView) viewInflate.findViewById(R.id.bz_notification_iv);
            this.d = (TextView) this.b.findViewById(R.id.bz_notification_title_tv);
            this.e = (TextView) this.b.findViewById(R.id.bz_notification_desc_tv);
            this.f = (LinearLayout) this.b.findViewById(R.id.bz_notification_action_container_ll);
            this.g = (TextView) this.b.findViewById(R.id.bz_notification_action_tv);
            a(context, i, i2, kjVar);
            String strG = kjVar.g();
            this.p = so.a(context, 15.0f);
            if (TextUtils.isEmpty(strG)) {
                CustomRoundImageView customRoundImageView = this.c;
                if (customRoundImageView != null) {
                    customRoundImageView.setVisibility(8);
                }
            } else {
                int i3 = this.l - (this.p * 2);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
                CustomRoundImageView customRoundImageView2 = this.c;
                if (customRoundImageView2 != null) {
                    customRoundImageView2.setLayoutParams(layoutParams);
                    of.a((Context) null).a(strG, new b(context));
                }
            }
            String strL = kjVar.l();
            if (!TextUtils.isEmpty(strL) && (textView2 = this.d) != null) {
                textView2.setText(strL);
            }
            String strE = kjVar.e();
            if (!TextUtils.isEmpty(strE) && (textView = this.e) != null) {
                textView.setText(strE);
            }
            String strC = kjVar.c();
            if (TextUtils.isEmpty(strC)) {
                LinearLayout linearLayout = this.f;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
            } else {
                LinearLayout linearLayout2 = this.f;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                    this.f.setOnClickListener(new c(kjVar.d()));
                }
                TextView textView3 = this.g;
                if (textView3 != null) {
                    vn.a(textView3, "#80000000", 0, null, (this.l - (this.p * 2)) / 2);
                    this.g.setText(strC);
                }
            }
            this.b.setOnTouchListener(new d(kjVar.k()));
            int iJ = kjVar.j();
            Handler handler3 = this.r;
            if (handler3 != null) {
                handler3.sendEmptyMessageDelayed(1001, iJ);
            }
            int iB = kjVar.b();
            if (iB > 0 && (handler2 = this.r) != null) {
                handler2.sendEmptyMessageDelayed(1003, iB + iJ);
            }
            int iF = kjVar.f();
            if (iF <= 0 || (handler = this.r) == null) {
                return;
            }
            handler.sendEmptyMessageDelayed(1002, iF + iJ);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b() {
        try {
            Handler handler = this.r;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.r = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c() {
        try {
            d7.a(this.b, this.n, this.o, this.m, 300);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        try {
            if (this.h != null && !this.q) {
                this.q = true;
                View view = this.b;
                if (view != null) {
                    if (view.getVisibility() != 8) {
                        c();
                    }
                }
                this.h.a();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(Context context, int i, int i2, kj kjVar) {
        if (context == null || kjVar == null) {
            return;
        }
        try {
            cl clVarI = kjVar.i();
            if (clVarI == null) {
                return;
            }
            String strA = clVarI.a();
            String strD = clVarI.d();
            String strE = clVarI.e();
            String strC = clVarI.c();
            if (TextUtils.isEmpty(strA)) {
                strA = "0";
            }
            if (TextUtils.isEmpty(strD)) {
                strD = "10%";
            }
            if (TextUtils.isEmpty(strE) || "0".equals(strE)) {
                strE = "90%";
            }
            if (TextUtils.isEmpty(strC) || "0".equals(strC)) {
                strC = "80";
            }
            if (strA.endsWith("%")) {
                this.i = (Integer.parseInt(strA.substring(0, strA.indexOf("%"))) * i) / 100;
            } else {
                this.i = so.a(context, Integer.parseInt(strA));
            }
            if (strD.endsWith("%")) {
                this.j = (Integer.parseInt(strD.substring(0, strD.indexOf("%"))) * i2) / 100;
            } else {
                this.j = so.a(context, Integer.parseInt(strD));
            }
            if (strE.endsWith("%")) {
                this.k = (Integer.parseInt(strE.substring(0, strE.indexOf("%"))) * i) / 100;
            } else {
                this.k = so.a(context, Integer.parseInt(strE));
            }
            if (strC.endsWith("%")) {
                this.l = (i2 * Integer.parseInt(strC.substring(0, strC.indexOf("%")))) / 100;
            } else {
                this.l = so.a(context, Integer.parseInt(strC));
            }
            int iJ = so.j(context);
            this.n = iJ;
            if (this.k > iJ) {
                this.k = iJ;
            }
            int iG = so.g(context);
            this.o = iG;
            if (this.l > iG) {
                this.l = iG;
            }
            int i3 = this.i;
            int i4 = this.k;
            int i5 = i3 - (i4 / 2);
            this.i = i5;
            if (i5 <= 0) {
                this.i = (i - i4) / 2;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}

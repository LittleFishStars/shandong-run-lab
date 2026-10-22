package com.igexin.push.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Movie;
import android.graphics.Outline;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.getui.gtc.base.GtcProvider;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import com.igexin.push.core.a.c.k;
import com.igexin.push.core.b.m;
import com.igexin.push.core.b.s;
import com.igexin.push.core.i.a.h;
import com.igexin.push.core.l;
import com.igexin.push.extension.mod.PushTaskBean;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.main.FeedbackImpl;
import com.igexin.sdk.message.GTPopupMessage;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class g extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f37866a = false;
    private final String b = "popupAct";
    private final ArrayList<com.igexin.push.core.i.a.f> c = new ArrayList<>();

    /* JADX INFO: renamed from: com.igexin.push.a.g$1, reason: invalid class name */
    public class AnonymousClass1 implements c<m.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicLong f37867a;
        final /* synthetic */ Activity b;
        final /* synthetic */ PushTaskBean c;
        final /* synthetic */ Context d;

        public AnonymousClass1(AtomicLong atomicLong, Activity activity, PushTaskBean pushTaskBean, Context context) {
            this.f37867a = atomicLong;
            this.b = activity;
            this.c = pushTaskBean;
            this.d = context;
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        private void a2(m.b bVar) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.f37867a.getAndSet(jCurrentTimeMillis) < 350) {
                    com.igexin.c.a.c.a.b("popupAct", "repetition click");
                    return;
                }
                if (bVar.o.getAction().isClosePopup()) {
                    this.b.finish();
                }
                g.a(bVar, this.c, this.d);
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }

        @Override // com.igexin.push.a.c
        public final /* synthetic */ void a(m.b bVar) {
            m.b bVar2 = bVar;
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.f37867a.getAndSet(jCurrentTimeMillis) < 350) {
                    com.igexin.c.a.c.a.b("popupAct", "repetition click");
                    return;
                }
                if (bVar2.o.getAction().isClosePopup()) {
                    this.b.finish();
                }
                g.a(bVar2, this.c, this.d);
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.a.g$2, reason: invalid class name */
    public class AnonymousClass2 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f37868a;
        final /* synthetic */ PushTaskBean b;

        public AnonymousClass2(m mVar, PushTaskBean pushTaskBean) {
            this.f37868a = mVar;
            this.b = pushTaskBean;
        }

        @Override // java.lang.Runnable
        public final void run() {
            l lVarA = l.a();
            GTPopupMessage gTPopupMessage = this.f37868a.j;
            Bundle bundle = new Bundle();
            bundle.putInt("action", PushConsts.ACTION_POPUP_SHOW);
            bundle.putSerializable(PushConsts.KEY_POPUP_SHOW, gTPopupMessage);
            lVarA.a(bundle);
            FeedbackImpl.getInstance().feedbackMessageAction(this.b, this.f37868a.i, "ok");
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.a.g$3, reason: invalid class name */
    public static class AnonymousClass3 implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ m.b f37869a;
        final /* synthetic */ PushTaskBean b;
        final /* synthetic */ Context c;

        public AnonymousClass3(m.b bVar, PushTaskBean pushTaskBean, Context context) {
            this.f37869a = bVar;
            this.b = pushTaskBean;
            this.c = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            l lVarA = l.a();
            GTPopupMessage gTPopupMessage = this.f37869a.o;
            Bundle bundle = new Bundle();
            bundle.setClassLoader(GTPopupMessage.class.getClassLoader());
            bundle.putInt("action", PushConsts.ACTION_POPUP_CLICKED);
            bundle.putSerializable(PushConsts.KEY_POPUP_CLICKED, gTPopupMessage);
            lVarA.a(bundle);
            FeedbackImpl.getInstance().feedbackMessageAction(this.b, this.f37869a.p, "ok");
            GTPopupMessage.GtAction action = this.f37869a.o.getAction();
            String actionType = action.getActionType();
            if (m.a.intent.name().equals(actionType)) {
                new k();
                k.a(action.getIntent(), this.c);
                return;
            }
            if (!m.a.url.name().equals(actionType)) {
                m.a.closePopup.name().equals(actionType);
                return;
            }
            new com.igexin.push.core.a.c.l();
            String url = action.getUrl();
            Context context = this.c;
            try {
                if (TextUtils.isEmpty(url)) {
                    return;
                }
                s sVar = new s();
                sVar.f37971a = url;
                com.igexin.push.core.a.c.l.a(sVar, com.igexin.push.core.b.A);
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setFlags(268435456);
                intent.setPackage(sVar.d);
                intent.setData(Uri.parse(sVar.a()));
                context.startActivity(intent);
            } catch (Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.a.g$4, reason: invalid class name */
    public class AnonymousClass4 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f37870a;
        final /* synthetic */ m.b b;

        public AnonymousClass4(c cVar, m.b bVar) {
            this.f37870a = cVar;
            this.b = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f37870a.a(this.b);
        }
    }

    /* JADX INFO: renamed from: com.igexin.push.a.g$9, reason: invalid class name */
    public class AnonymousClass9 implements e.a<byte[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ m.b f37876a;
        final /* synthetic */ Context b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;
        final /* synthetic */ d e;

        public AnonymousClass9(m.b bVar, Context context, int i, int i2, d dVar) {
            this.f37876a = bVar;
            this.b = context;
            this.c = i;
            this.d = i2;
            this.e = dVar;
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        private void a2(byte[] bArr) {
            try {
                com.igexin.c.a.c.a.b("popupAct", "movie duration is 0 use glide " + this.f37876a.h);
                com.igexin.push.core.i.a.f fVarA = new com.igexin.push.core.i.a.a(this.b).a(ByteBuffer.wrap(bArr), this.c, this.d);
                fVarA.b();
                com.igexin.push.core.i.a.e eVarA = fVarA.c();
                this.e.setImageDrawable(eVarA);
                com.igexin.push.core.i.a.k.a(!eVarA.d, "You cannot restart a currently running animation.");
                h hVar = eVarA.c.f38062a;
                com.igexin.push.core.i.a.k.a(hVar.c ? false : true, "Can't restart a running animation");
                hVar.d = true;
                if (hVar.i != null) {
                    hVar.i = null;
                }
                eVarA.start();
                g.this.c.add(fVarA);
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }

        @Override // com.igexin.push.a.e.a
        public final /* synthetic */ void a(byte[] bArr) {
            byte[] bArr2 = bArr;
            try {
                com.igexin.c.a.c.a.b("popupAct", "movie duration is 0 use glide " + this.f37876a.h);
                com.igexin.push.core.i.a.f fVarA = new com.igexin.push.core.i.a.a(this.b).a(ByteBuffer.wrap(bArr2), this.c, this.d);
                fVarA.b();
                com.igexin.push.core.i.a.e eVarA = fVarA.c();
                this.e.setImageDrawable(eVarA);
                com.igexin.push.core.i.a.k.a(!eVarA.d, "You cannot restart a currently running animation.");
                h hVar = eVarA.c.f38062a;
                com.igexin.push.core.i.a.k.a(hVar.c ? false : true, "Can't restart a running animation");
                hVar.d = true;
                if (hVar.i != null) {
                    hVar.i = null;
                }
                eVarA.start();
                g.this.c.add(fVarA);
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }

        @Override // com.igexin.push.a.e.a
        public final void a(Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private static int a(m.b bVar) {
        String str = bVar.b;
        str.hashCode();
        if (str.equals("center")) {
            return 17;
        }
        return !str.equals("right") ? GravityCompat.START : GravityCompat.END;
    }

    private View a(final m.b bVar, final Context context, c<m.b> cVar) {
        View textView;
        if (bVar == null) {
            return null;
        }
        String str = bVar.f37965a;
        str.hashCode();
        switch (str) {
            case "button":
                Button button = new Button(context);
                button.setAllCaps(false);
                textView = button;
                break;
            case "column":
            case "row":
            case "view":
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(!"row".equals(bVar.f37965a) ? 1 : 0);
                View viewA = a(bVar, linearLayout, cVar);
                if (bVar.g != null) {
                    for (int i = 0; i < bVar.g.size(); i++) {
                        linearLayout.addView(a(bVar.g.get(i), context, cVar));
                    }
                }
                return viewA;
            case "image":
            case "image_button":
                final d dVar = new d(context);
                View viewA2 = a(bVar, dVar, cVar);
                dVar.setScaleType(ImageView.ScaleType.CENTER_CROP);
                try {
                    if (!TextUtils.isEmpty(bVar.h)) {
                        if (bVar.h.endsWith(".gif")) {
                            final int iA = bVar.a();
                            final int iB = bVar.b();
                            e.b(bVar.h, new e.a<Movie>() { // from class: com.igexin.push.a.g.5
                                /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
                                private void a2(Movie movie) {
                                    if (movie.duration() == 0) {
                                        g.a(g.this, bVar, context, iA, iB, dVar);
                                        return;
                                    }
                                    d dVar2 = dVar;
                                    dVar2.f37855a = movie;
                                    dVar2.b = 0L;
                                    dVar2.c = 0;
                                    dVar2.setLayerType(1, null);
                                    dVar2.setImageDrawable(null);
                                    dVar2.requestLayout();
                                    dVar2.invalidate();
                                    d dVar3 = dVar;
                                    if (dVar3.d) {
                                        dVar3.d = false;
                                        if (dVar3.f37855a != null) {
                                            dVar3.b = SystemClock.uptimeMillis() - ((long) dVar3.c);
                                            dVar3.invalidate();
                                        }
                                    }
                                }

                                @Override // com.igexin.push.a.e.a
                                public final /* synthetic */ void a(Movie movie) {
                                    Movie movie2 = movie;
                                    if (movie2.duration() == 0) {
                                        g.a(g.this, bVar, context, iA, iB, dVar);
                                        return;
                                    }
                                    d dVar2 = dVar;
                                    dVar2.f37855a = movie2;
                                    dVar2.b = 0L;
                                    dVar2.c = 0;
                                    dVar2.setLayerType(1, null);
                                    dVar2.setImageDrawable(null);
                                    dVar2.requestLayout();
                                    dVar2.invalidate();
                                    d dVar3 = dVar;
                                    if (dVar3.d) {
                                        dVar3.d = false;
                                        if (dVar3.f37855a != null) {
                                            dVar3.b = SystemClock.uptimeMillis() - ((long) dVar3.c);
                                            dVar3.invalidate();
                                        }
                                    }
                                }

                                @Override // com.igexin.push.a.e.a
                                public final void a(Throwable th) {
                                    com.igexin.c.a.c.a.a(th);
                                }
                            });
                        } else {
                            e.a(bVar.h, bVar.a(), new e.a<Bitmap>() { // from class: com.igexin.push.a.g.6
                                /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
                                private void a2(Bitmap bitmap) {
                                    dVar.setImageBitmap(bitmap);
                                }

                                @Override // com.igexin.push.a.e.a
                                public final /* synthetic */ void a(Bitmap bitmap) {
                                    dVar.setImageBitmap(bitmap);
                                }

                                @Override // com.igexin.push.a.e.a
                                public final void a(Throwable th) {
                                    com.igexin.c.a.c.a.a(th);
                                }
                            });
                        }
                    }
                    break;
                } catch (Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                }
                return viewA2;
            case "label":
                textView = new TextView(context);
                break;
            default:
                throw new RuntimeException("can't find type " + bVar.f37965a);
        }
        return a(bVar, textView, cVar);
    }

    /* JADX WARN: Code duplicated, block: B:47:0x010a  */
    private View a(final m.b bVar, final View view, final c<m.b> cVar) {
        view.setPadding(bVar.j(), bVar.g(), bVar.i(), bVar.h());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(bVar.a(), bVar.b());
        layoutParams.setMargins(bVar.f(), bVar.c(), bVar.e(), bVar.d());
        if (bVar.b != null) {
            layoutParams.gravity = a(bVar);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        int i = bVar.m;
        if (i != 0) {
            gradientDrawable.setColor(i);
        }
        int iM = bVar.m();
        if (iM > 0) {
            gradientDrawable.setStroke(iM, bVar.n);
        }
        final int iK = bVar.k();
        if (iK > 0) {
            gradientDrawable.setCornerRadius(iK);
        }
        view.setBackground(gradientDrawable);
        if (!TextUtils.isEmpty(bVar.j) && !bVar.j.endsWith(".gif")) {
            e.a(bVar.j, bVar.a(), new e.a<Bitmap>() { // from class: com.igexin.push.a.g.7

                /* JADX INFO: renamed from: com.igexin.push.a.g$7$1, reason: invalid class name */
                public class AnonymousClass1 extends ViewOutlineProvider {
                    public AnonymousClass1() {
                    }

                    @Override // android.view.ViewOutlineProvider
                    public final void getOutline(View view, Outline outline) {
                        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), iK);
                    }
                }

                /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
                private void a2(Bitmap bitmap) {
                    try {
                        view.setBackground(new BitmapDrawable(view.getResources(), bitmap));
                        if (iK > 0) {
                            view.setClipToOutline(true);
                            view.setOutlineProvider(new AnonymousClass1());
                        }
                    } catch (Throwable th) {
                        com.igexin.c.a.c.a.a(th);
                    }
                }

                @Override // com.igexin.push.a.e.a
                public final /* synthetic */ void a(Bitmap bitmap) {
                    try {
                        view.setBackground(new BitmapDrawable(view.getResources(), bitmap));
                        if (iK > 0) {
                            view.setClipToOutline(true);
                            view.setOutlineProvider(new AnonymousClass1());
                        }
                    } catch (Throwable th) {
                        com.igexin.c.a.c.a.a(th);
                    }
                }

                @Override // com.igexin.push.a.e.a
                public final void a(Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                }
            });
        }
        view.setLayoutParams(layoutParams);
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            textView.setText(!TextUtils.isEmpty(bVar.k) ? bVar.k : bVar.d);
            int i2 = bVar.l;
            if (i2 != 0) {
                textView.setTextColor(i2);
            }
            float fL = bVar.l();
            if (fL != 0.0f) {
                textView.setTextSize(0, fL);
            }
            if (bVar.i) {
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                textView.getPaint().setFakeBoldText(true);
            }
            if (bVar.n() != 0) {
                textView.setMaxHeight(bVar.n());
                textView.setMovementMethod(ScrollingMovementMethod.getInstance());
            }
            if (!TextUtils.isEmpty(bVar.c)) {
                textView.setGravity(a(bVar));
            }
        }
        GTPopupMessage gTPopupMessage = bVar.o;
        if (gTPopupMessage != null) {
            GTPopupMessage.GtAction action = gTPopupMessage.getAction();
            if (action.isClosePopup() || !m.a.closePopup.name().equals(action.getActionType())) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.igexin.push.a.g.8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        cVar.a(bVar);
                    }
                });
            } else {
                view.setClickable(true);
                view.setFocusable(true);
            }
        } else {
            view.setClickable(true);
            view.setFocusable(true);
        }
        return view;
    }

    private LinearLayout a(c cVar, m mVar, Context context) {
        m.b bVar = mVar.f37963a;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setBackgroundColor(bVar.m);
        GTPopupMessage gTPopupMessage = bVar.o;
        if (gTPopupMessage != null) {
            GTPopupMessage.GtAction action = gTPopupMessage.getAction();
            if (action.isClosePopup() || !m.a.closePopup.name().equals(action.getActionType())) {
                linearLayout.setOnClickListener(new AnonymousClass4(cVar, bVar));
            } else {
                linearLayout.setClickable(true);
                linearLayout.setFocusable(true);
            }
        }
        View viewA = a(mVar.b, context, (c<m.b>) cVar);
        if (viewA != null) {
            linearLayout.addView(viewA);
        }
        return linearLayout;
    }

    public static /* synthetic */ void a(g gVar, m.b bVar, Context context, int i, int i2, d dVar) {
        e.a(bVar.h, gVar.new AnonymousClass9(bVar, context, i, i2, dVar));
    }

    private void a(m.b bVar, Context context, int i, int i2, d dVar) {
        e.a(bVar.h, new AnonymousClass9(bVar, context, i, i2, dVar));
    }

    public static /* synthetic */ void a(m.b bVar, PushTaskBean pushTaskBean, Context context) {
        com.igexin.b.a.a().f37791a.execute(new AnonymousClass3(bVar, pushTaskBean, context));
    }

    private static void b(m.b bVar, PushTaskBean pushTaskBean, Context context) {
        com.igexin.b.a.a().f37791a.execute(new AnonymousClass3(bVar, pushTaskBean, context));
    }

    private void c(Activity activity) {
        Intent intent = activity.getIntent();
        try {
            f37866a = true;
            Context applicationContext = activity.getApplicationContext();
            GtcProvider.setContext(applicationContext);
            try {
                if (Build.VERSION.SDK_INT != 26) {
                    if (1 == applicationContext.getResources().getConfiguration().orientation) {
                        activity.setRequestedOrientation(7);
                    } else {
                        activity.setRequestedOrientation(6);
                    }
                }
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
            AtomicLong atomicLong = new AtomicLong(0L);
            m mVar = (m) intent.getExtras().getSerializable(BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
            PushTaskBean pushTaskBean = new PushTaskBean();
            pushTaskBean.setAppid(mVar.e);
            pushTaskBean.setMessageId(mVar.f);
            pushTaskBean.setTaskId(mVar.g);
            pushTaskBean.setAppKey(mVar.h);
            m.a(applicationContext);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(atomicLong, activity, pushTaskBean, applicationContext);
            m.b bVar = mVar.f37963a;
            LinearLayout linearLayout = new LinearLayout(applicationContext);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            linearLayout.setBackgroundColor(bVar.m);
            GTPopupMessage gTPopupMessage = bVar.o;
            if (gTPopupMessage != null) {
                GTPopupMessage.GtAction action = gTPopupMessage.getAction();
                if (action.isClosePopup() || !m.a.closePopup.name().equals(action.getActionType())) {
                    linearLayout.setOnClickListener(new AnonymousClass4(anonymousClass1, bVar));
                } else {
                    linearLayout.setClickable(true);
                    linearLayout.setFocusable(true);
                }
            }
            View viewA = a(mVar.b, applicationContext, anonymousClass1);
            if (viewA != null) {
                linearLayout.addView(viewA);
            }
            activity.setContentView(linearLayout);
            com.igexin.b.a.a().f37791a.execute(new AnonymousClass2(mVar, pushTaskBean));
        } catch (Throwable th2) {
            com.igexin.c.a.c.a.a(th2);
            activity.finish();
        }
    }

    @Override // com.igexin.push.a.b
    public final void a(Activity activity) {
        try {
            if (Build.VERSION.SDK_INT == 26) {
                activity.finish();
            }
        } catch (Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    @Override // com.igexin.push.a.b
    public final boolean a() {
        return false;
    }

    @Override // com.igexin.push.a.b
    public final void b(Activity activity) {
        Intent intent = activity.getIntent();
        try {
            f37866a = true;
            Context applicationContext = activity.getApplicationContext();
            GtcProvider.setContext(applicationContext);
            try {
                if (Build.VERSION.SDK_INT != 26) {
                    if (1 == applicationContext.getResources().getConfiguration().orientation) {
                        activity.setRequestedOrientation(7);
                    } else {
                        activity.setRequestedOrientation(6);
                    }
                }
            } catch (Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
            AtomicLong atomicLong = new AtomicLong(0L);
            m mVar = (m) intent.getExtras().getSerializable(BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
            PushTaskBean pushTaskBean = new PushTaskBean();
            pushTaskBean.setAppid(mVar.e);
            pushTaskBean.setMessageId(mVar.f);
            pushTaskBean.setTaskId(mVar.g);
            pushTaskBean.setAppKey(mVar.h);
            m.a(applicationContext);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(atomicLong, activity, pushTaskBean, applicationContext);
            m.b bVar = mVar.f37963a;
            LinearLayout linearLayout = new LinearLayout(applicationContext);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
            linearLayout.setBackgroundColor(bVar.m);
            GTPopupMessage gTPopupMessage = bVar.o;
            if (gTPopupMessage != null) {
                GTPopupMessage.GtAction action = gTPopupMessage.getAction();
                if (action.isClosePopup() || !m.a.closePopup.name().equals(action.getActionType())) {
                    linearLayout.setOnClickListener(new AnonymousClass4(anonymousClass1, bVar));
                } else {
                    linearLayout.setClickable(true);
                    linearLayout.setFocusable(true);
                }
            }
            View viewA = a(mVar.b, applicationContext, anonymousClass1);
            if (viewA != null) {
                linearLayout.addView(viewA);
            }
            activity.setContentView(linearLayout);
            com.igexin.b.a.a().f37791a.execute(new AnonymousClass2(mVar, pushTaskBean));
        } catch (Throwable th2) {
            com.igexin.c.a.c.a.a(th2);
            activity.finish();
        }
    }

    @Override // com.igexin.push.a.b
    public final boolean b() {
        return false;
    }

    @Override // com.igexin.push.a.b
    public final void c() {
    }

    @Override // com.igexin.push.a.b
    public final void d() {
    }

    @Override // com.igexin.push.a.b
    public final void e() {
    }

    @Override // com.igexin.push.a.b
    public final void f() {
    }

    @Override // com.igexin.push.a.b
    public final void g() {
    }

    @Override // com.igexin.push.a.b
    public final void h() {
    }

    @Override // com.igexin.push.a.b
    public final void i() {
        f37866a = false;
        for (com.igexin.push.core.i.a.f fVar : this.c) {
            if (fVar != null) {
                fVar.f();
            }
        }
        this.c.clear();
    }

    @Override // com.igexin.push.a.b
    public final void j() {
    }

    @Override // com.igexin.push.a.b
    public final void k() {
    }
}

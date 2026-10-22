package com.beizi.fusion;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.beizi.ad.internal.activity.DownloadAppInfoActivity;
import com.beizi.ad.lance.ApkBean;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class pi {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ mi f27654a;
        final /* synthetic */ View b;
        final /* synthetic */ ji c;

        public a(mi miVar, View view, ji jiVar) {
            this.f27654a = miVar;
            this.b = view;
            this.c = jiVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f27654a.a(this.b, this.c)) {
                this.b.setTag(R.string.beizi_native_tag, new WeakReference(this.f27654a));
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ mi f27655a;
        final /* synthetic */ View b;
        final /* synthetic */ List c;
        final /* synthetic */ ji d;

        public b(mi miVar, View view, List list, ji jiVar) {
            this.f27655a = miVar;
            this.b = view;
            this.c = list;
            this.d = jiVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f27655a.a(this.b, this.c, this.d)) {
                this.b.setTag(R.string.beizi_native_tag, new WeakReference(this.f27655a));
            }
        }
    }

    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f27656a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;

        public c(Context context, String str, String str2, String str3, String str4) {
            this.f27656a = context;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            try {
                Intent intent = new Intent(this.f27656a, (Class<?>) DownloadAppInfoActivity.class);
                intent.putExtra("title_content_key", this.b);
                intent.putExtra("privacy_content_key", this.c);
                intent.putExtra("permission_content_key", this.d);
                intent.putExtra("intro_content_key", this.e);
                intent.setFlags(268435456);
                this.f27656a.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    public static void a(mi miVar, View view, ji jiVar) {
        if (!a(miVar) || view == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new a(miVar, view, jiVar));
    }

    public static void a(mi miVar, View view, List list, ji jiVar) {
        if (!a(miVar) || view == null || list == null || list.isEmpty()) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new b(miVar, view, list, jiVar));
    }

    public static void a(mi miVar, View view, String str, String str2, String str3, String str4, int i) {
        try {
            view.getContext();
            View rootView = view.getRootView();
            if (rootView != null) {
                rootView.getContext();
            }
        } catch (Exception unused) {
        }
    }

    public static boolean a(mi miVar) {
        return (miVar == null || miVar.f()) ? false : true;
    }

    public static FrameLayout a(View view, mi miVar) {
        try {
            int i = R.drawable.beizi_button_close_background;
            if (view.getTag(i) != null && (view.getTag(i) instanceof FrameLayout)) {
                bq.a((FrameLayout) view.getTag(i));
                return (FrameLayout) view.getTag(i);
            }
            view.getContext();
            bq.a(view);
            FrameLayout frameLayout = new FrameLayout(view.getContext());
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -1, 17));
            LinearLayout linearLayout = new LinearLayout(view.getContext());
            linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            FrameLayout frameLayoutB = bq.b(view.getContext(), miVar.n());
            frameLayoutB.setVisibility(0);
            linearLayout.addView(frameLayoutB, new FrameLayout.LayoutParams(-2, -2, 17));
            View viewA = bq.a(view.getContext(), miVar.a());
            viewA.setVisibility(0);
            linearLayout.addView(viewA, new FrameLayout.LayoutParams(-2, -2, 17));
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewA.getLayoutParams();
            layoutParams.setMargins(5, 0, 0, 0);
            layoutParams.gravity = 17;
            viewA.setLayoutParams(layoutParams);
            frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-2, -2, 85));
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) linearLayout.getLayoutParams();
            int iA = bq.a(view.getContext(), 20.0f);
            layoutParams2.setMargins(0, 0, iA, iA);
            linearLayout.setLayoutParams(layoutParams2);
            view.setTag(i, frameLayout);
            return frameLayout;
        } catch (Exception unused) {
            return null;
        }
    }

    public static FrameLayout a(Context context, Bitmap bitmap, mi miVar) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setVisibility(0);
        imageView.setImageBitmap(bitmap);
        return a(imageView, miVar);
    }

    public static View a(Context context, mi miVar) {
        if (context != null && miVar != null) {
            try {
                ApkBean apkBeanP = miVar.p();
                if (apkBeanP == null) {
                    return null;
                }
                String apkName = apkBeanP.getApkName();
                String appDeveloper = apkBeanP.getAppDeveloper();
                String appVersion = apkBeanP.getAppVersion();
                String appPermissionsUrl = apkBeanP.getAppPermissionsUrl();
                String appPermissionsDesc = apkBeanP.getAppPermissionsDesc();
                if (!TextUtils.isEmpty(appPermissionsUrl)) {
                    appPermissionsDesc = appPermissionsUrl;
                }
                String appPrivacyUrl = apkBeanP.getAppPrivacyUrl();
                String appintro = apkBeanP.getAppintro();
                TextView textView = new TextView(context);
                textView.setText(Html.fromHtml("应用名称：" + apkName + " | 开发者：" + appDeveloper + " | 应用版本：" + appVersion + " | <u>权限详情</u> | <u>隐私协议</u> | <u>功能介绍</u>"));
                textView.setTextSize(2, 6.0f);
                textView.setTextColor(Color.parseColor("#999999"));
                textView.setShadowLayer(1.0f, 1.0f, 1.0f, Color.parseColor("#333333"));
                textView.setPadding(10, 10, 10, 10);
                textView.setOnClickListener(new c(context, apkName, appPrivacyUrl, appPermissionsDesc, appintro));
                return textView;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}

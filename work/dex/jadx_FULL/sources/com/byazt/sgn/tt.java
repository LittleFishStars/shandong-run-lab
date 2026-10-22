package com.byazt.sgn;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.el.SSWebView;
import com.byazt.omf.gt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 211, 13})
@SuppressLint({"SetJavaScriptEnabled"})
public class tt extends AlertDialog {
    public static volatile AtomicInteger tt = new AtomicInteger(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ListView f29015a;
    public Context c;
    public String da;
    public c i;
    public ImageView n;
    public HashMap<String, String> sl;
    public SSWebView sp;
    public List<ve> t;
    public boolean u;
    public Button uj;
    public Button ve;
    public String x;

    public interface c {
        void c(Dialog dialog);

        void tt(Dialog dialog);

        void ve(Dialog dialog);
    }

    /* JADX INFO: renamed from: com.byazt.sgn.tt$tt, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 211, 240})
    public class C0518tt extends ArrayAdapter<ve> {

        /* JADX INFO: renamed from: com.byazt.sgn.tt$tt$c */
        @com.byazt.zqa.c(c = {0, 1, 211, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
        public class c {
            public TextView tt;
            public ImageView uj;
            public TextView ve;

            public c() {
            }
        }

        public C0518tt(Context context, int i, List<ve> list) {
            super(context, i, list);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            View view2;
            ve veVar = (ve) getItem(i);
            if (view == null) {
                RelativeLayout relativeLayout = new RelativeLayout(tt.this.c);
                relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                relativeLayout.setPadding(0, 0, 0, pf.ve(tt.this.c, 17.0f));
                TextView textView = new TextView(tt.this.c);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                int iVe = pf.ve(tt.this.c, 16.0f);
                layoutParams.leftMargin = iVe;
                layoutParams.rightMargin = iVe;
                textView.setGravity(16);
                textView.setId(View.generateViewId());
                textView.setTextColor(Color.parseColor("#161823"));
                textView.setTextSize(16.0f);
                textView.setTypeface(null, 1);
                textView.setPadding(0, pf.ve(tt.this.c, 19.0f), 0, 0);
                textView.setLayoutParams(layoutParams);
                relativeLayout.addView(textView);
                ImageView imageView = new ImageView(tt.this.c);
                imageView.setId(View.generateViewId());
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iVe, iVe);
                layoutParams2.topMargin = pf.ve(tt.this.c, 7.0f);
                layoutParams2.addRule(3, textView.getId());
                layoutParams2.addRule(5, textView.getId());
                com.byazt.nr.z.c(tt.this.c, "tt_open_app_detail_list_item", (View) imageView, 320);
                imageView.setLayoutParams(layoutParams2);
                relativeLayout.addView(imageView);
                TextView textView2 = new TextView(tt.this.c);
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams3.leftMargin = pf.ve(tt.this.c, 8.0f);
                layoutParams3.topMargin = pf.ve(tt.this.c, 6.0f);
                layoutParams3.addRule(3, textView.getId());
                layoutParams3.addRule(1, imageView.getId());
                textView2.setLayoutParams(layoutParams3);
                textView2.setTextColor(Color.parseColor("#161823"));
                textView2.setTextSize(13.0f);
                textView2.setAlpha(0.5f);
                textView2.setGravity(16);
                relativeLayout.addView(textView2);
                cVar = new c();
                cVar.tt = textView;
                cVar.ve = textView2;
                cVar.uj = imageView;
                relativeLayout.setTag(cVar);
                view2 = relativeLayout;
            } else {
                cVar = (c) view.getTag();
                view2 = view;
            }
            cVar.uj.setVisibility(0);
            if ("补充中，可于应用官网查看".equals(veVar.c())) {
                cVar.uj.setVisibility(4);
            }
            cVar.tt.setText(veVar.c());
            cVar.ve.setText(veVar.tt());
            return view2;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 211, 519})
    public class ve {
        public String tt;
        public String ve;

        public ve(String str, String str2) {
            this.tt = str;
            this.ve = str2;
        }

        public String c() {
            return this.tt;
        }

        public String tt() {
            return this.ve;
        }
    }

    public tt(Context context, String str) {
        super(context);
        this.t = new ArrayList();
        this.u = false;
        this.c = context;
        this.da = str;
    }

    private void n() {
        if (this.c == null) {
            this.c = gt.getContext();
        }
        if (this.c.getResources().getConfiguration().orientation == 1) {
            setContentView(tt(1));
        } else {
            setContentView(tt(0));
        }
    }

    private LinearLayout tt(int i, LinearLayout linearLayout, LinearLayout linearLayout2) {
        if (i == 0) {
            return linearLayout;
        }
        View view = new View(this.c);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, pf.ve(this.c, 34.0f)));
        linearLayout2.addView(view);
        return linearLayout;
    }

    private void uj() {
        if (this.c == null) {
            this.c = gt.getContext();
        }
        if (this.c.getResources().getConfiguration().orientation == 1) {
            setContentView(c(1));
        } else {
            setContentView(c(0));
        }
    }

    private LinearLayout ve(int i, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        LinearLayout linearLayout2 = new LinearLayout(this.c);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout2.setOrientation(0);
        int iVe = pf.ve(this.c, 16.0f);
        linearLayout2.setPadding(iVe, iVe, iVe, iVe);
        linearLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(linearLayout2);
        this.uj = new Button(this.c);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        int iVe2 = pf.ve(this.c, 7.0f);
        layoutParams2.leftMargin = iVe2;
        layoutParams2.rightMargin = iVe2;
        layoutParams2.weight = 1.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(pf.ve(this.c, 3.0f));
        gradientDrawable.setStroke(pf.ve(this.c, 0.5f), Color.parseColor("#E0161823"));
        this.uj.setBackground(gradientDrawable);
        int iVe3 = pf.ve(this.c, 12.0f);
        this.uj.setText("上一步");
        this.uj.setPadding(0, iVe3, 0, iVe3);
        this.uj.setTextColor(Color.parseColor("#A8161823"));
        this.uj.setLayoutParams(layoutParams2);
        linearLayout2.addView(this.uj);
        return c(i, linearLayout, relativeLayout, linearLayout2, iVe2, iVe3);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        tt.set(0);
        c cVar = this.i;
        if (cVar != null) {
            cVar.tt(this);
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        com.byazt.vfu.sp.tt(this);
        tt();
        if (this.u) {
            n();
        } else {
            uj();
        }
        ve();
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
    }

    private View c(int i) {
        LinearLayout linearLayout = new LinearLayout(this.c);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i);
        linearLayout.setBackgroundColor(0);
        linearLayout.setLayoutParams(layoutParams);
        View view = new View(this.c);
        LinearLayout.LayoutParams layoutParams2 = i == 0 ? new LinearLayout.LayoutParams(0, -1) : new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 0.38f;
        view.setLayoutParams(layoutParams2);
        linearLayout.addView(view);
        LinearLayout linearLayout2 = new LinearLayout(this.c);
        LinearLayout.LayoutParams layoutParams3 = i == 0 ? new LinearLayout.LayoutParams(0, -1) : new LinearLayout.LayoutParams(-1, 0);
        layoutParams3.weight = 0.62f;
        layoutParams3.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(pf.ve(this.c, 8.0f));
        linearLayout2.setBackground(gradientDrawable);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams3);
        linearLayout.addView(linearLayout2);
        RelativeLayout relativeLayout = new RelativeLayout(this.c);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        return c(i, linearLayout, linearLayout2, relativeLayout);
    }

    private View tt(int i) {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = new LinearLayout(this.c);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setOrientation(i);
        linearLayout.setBackgroundColor(0);
        linearLayout.setLayoutParams(layoutParams3);
        View view = new View(this.c);
        if (i == 0) {
            layoutParams = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams.weight = 0.38f;
        view.setLayoutParams(layoutParams);
        linearLayout.addView(view);
        RelativeLayout relativeLayout = new RelativeLayout(this.c);
        if (i == 0) {
            layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        }
        layoutParams2.weight = 0.62f;
        layoutParams2.gravity = 1;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(pf.ve(this.c, 8.0f));
        relativeLayout.setBackground(gradientDrawable);
        relativeLayout.setLayoutParams(layoutParams2);
        linearLayout.addView(relativeLayout);
        return c(i, linearLayout, relativeLayout);
    }

    private LinearLayout uj(int i, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        if (i == 0) {
            return linearLayout;
        }
        View view = new View(this.c);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, pf.ve(this.c, 34.0f)));
        relativeLayout.addView(view);
        return linearLayout;
    }

    public void ve() {
        if (this.u) {
            c();
        } else {
            SSWebView sSWebView = this.sp;
            if (sSWebView != null) {
                sSWebView.setWebViewClient(new SSWebView.c());
            }
        }
        this.ve.setVisibility(0);
        this.ve.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.sgn.tt.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                tt.tt.set(0);
                if (tt.this.i != null) {
                    tt.this.i.c(tt.this);
                }
            }
        });
        this.n.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.sgn.tt.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                tt.tt.set(0);
                if (tt.this.i != null) {
                    tt.this.i.tt(tt.this);
                }
            }
        });
        this.uj.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.sgn.tt.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                tt.tt.set(0);
                if (tt.this.i != null) {
                    tt.this.i.ve(tt.this);
                }
            }
        });
        List<ve> list = this.t;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f29015a.setAdapter((ListAdapter) new C0518tt(this.c, 0, this.t));
    }

    private LinearLayout c(int i, LinearLayout linearLayout, LinearLayout linearLayout2, RelativeLayout relativeLayout) {
        ImageView imageView = new ImageView(this.c);
        this.n = imageView;
        imageView.setMaxHeight(pf.ve(this.c, 46.0f));
        this.n.setMaxWidth(pf.ve(this.c, 46.0f));
        this.n.setMinimumHeight(pf.ve(this.c, 46.0f));
        this.n.setMinimumWidth(pf.ve(this.c, 46.0f));
        this.n.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        com.byazt.vfu.ve veVar = new com.byazt.vfu.ve(pf.ve(this.c, 14.0f));
        veVar.c(-16777216);
        veVar.c(pf.ve(this.c, 2.0f));
        this.n.setImageDrawable(veVar);
        relativeLayout.addView(this.n);
        TextView textView = new TextView(this.c);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText("权限列表");
        textView.setLayoutParams(layoutParams);
        relativeLayout.addView(textView);
        linearLayout2.addView(relativeLayout);
        View view = new View(this.c);
        view.setId(View.generateViewId());
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, pf.ve(this.c, 1.0f)));
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view);
        return c(i, linearLayout, c(linearLayout2, view));
    }

    private LinearLayout tt(int i, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        View view = new View(this.c);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, pf.ve(this.c, 1.0f)));
        view.setBackgroundColor(Color.parseColor("#E8E8E8"));
        relativeLayout.addView(view);
        this.sp = new SSWebView(this.c);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        this.sp.setLayoutParams(layoutParams);
        relativeLayout.addView(this.sp);
        View view2 = new View(this.c);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, pf.ve(this.c, 1.0f)));
        view2.setBackgroundColor(Color.parseColor("#E8E8E8"));
        relativeLayout.addView(view2);
        return ve(i, linearLayout, relativeLayout);
    }

    public void tt() {
        if (TextUtils.isEmpty(this.da)) {
            c(this.sl);
            return;
        }
        try {
            com.byazt.ete.a aVarN = com.byazt.omf.c.n(new JSONObject(this.da));
            if (aVarN != null) {
                HashMap<String, String> mapC = aVarN.c();
                this.sl = mapC;
                if (!mapC.isEmpty()) {
                    this.u = false;
                    c(this.sl);
                } else if (!TextUtils.isEmpty(aVarN.tt())) {
                    this.x = aVarN.tt();
                    this.u = true;
                } else {
                    c(this.sl);
                }
            }
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }

    private LinearLayout c(LinearLayout linearLayout, View view) {
        LinearLayout linearLayout2 = new LinearLayout(this.c);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(3, view.getId());
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setOrientation(1);
        linearLayout.addView(linearLayout2);
        this.f29015a = new ListView(this.c);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 1.0f;
        layoutParams2.topMargin = pf.ve(this.c, 20.0f);
        int iVe = pf.ve(this.c, 16.0f);
        this.f29015a.setPadding(iVe, 0, iVe, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setShape(2);
        gradientDrawable.setStroke(pf.ve(this.c, 1.0f), Color.parseColor("#F0F0F0"));
        this.f29015a.setDivider(gradientDrawable);
        this.f29015a.setDividerHeight(pf.ve(this.c, 24.0f));
        this.f29015a.setSelector(new ColorDrawable(0));
        this.f29015a.setLayoutParams(layoutParams2);
        linearLayout2.addView(this.f29015a);
        View view2 = new View(this.c);
        view2.setLayoutParams(new LinearLayout.LayoutParams(-1, pf.ve(this.c, 1.0f)));
        view2.setBackgroundColor(Color.parseColor("#E8E8E8"));
        linearLayout2.addView(view2);
        return linearLayout2;
    }

    private LinearLayout c(int i, LinearLayout linearLayout, LinearLayout linearLayout2) {
        LinearLayout linearLayout3 = new LinearLayout(this.c);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        linearLayout3.setOrientation(0);
        int iVe = pf.ve(this.c, 16.0f);
        linearLayout3.setPadding(iVe, iVe, iVe, iVe);
        linearLayout3.setLayoutParams(layoutParams);
        linearLayout2.addView(linearLayout3);
        this.uj = new Button(this.c);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        int iVe2 = pf.ve(this.c, 7.0f);
        layoutParams2.leftMargin = iVe2;
        layoutParams2.rightMargin = iVe2;
        layoutParams2.weight = 1.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(pf.ve(this.c, 3.0f));
        gradientDrawable.setStroke(pf.ve(this.c, 0.5f), Color.parseColor("#E0161823"));
        this.uj.setBackground(gradientDrawable);
        int iVe3 = pf.ve(this.c, 12.0f);
        this.uj.setText("上一步");
        this.uj.setPadding(0, iVe3, 0, iVe3);
        this.uj.setTextColor(Color.parseColor("#A8161823"));
        this.uj.setLayoutParams(layoutParams2);
        linearLayout3.addView(this.uj);
        return c(iVe2, iVe3, linearLayout3, tt(i, linearLayout, linearLayout2));
    }

    private LinearLayout c(int i, int i2, LinearLayout linearLayout, LinearLayout linearLayout2) {
        this.ve = new Button(this.c);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i;
        layoutParams.weight = 1.0f;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#F93F3F"));
        gradientDrawable.setCornerRadius(pf.ve(this.c, 3.0f));
        this.ve.setBackground(gradientDrawable);
        this.ve.setText("立即下载");
        this.ve.setPadding(0, i2, 0, i2);
        this.ve.setTextColor(-1);
        this.ve.setLayoutParams(layoutParams);
        linearLayout.addView(this.ve);
        return linearLayout2;
    }

    private LinearLayout c(int i, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        RelativeLayout relativeLayout2 = new RelativeLayout(this.c);
        relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        ImageView imageView = new ImageView(this.c);
        this.n = imageView;
        imageView.setMaxHeight(pf.ve(this.c, 46.0f));
        this.n.setMaxWidth(pf.ve(this.c, 46.0f));
        this.n.setMinimumHeight(pf.ve(this.c, 46.0f));
        this.n.setMinimumWidth(pf.ve(this.c, 46.0f));
        this.n.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        com.byazt.vfu.ve veVar = new com.byazt.vfu.ve(pf.ve(this.c, 14.0f));
        veVar.c(-16777216);
        veVar.c(pf.ve(this.c, 2.0f));
        this.n.setImageDrawable(veVar);
        relativeLayout2.addView(this.n);
        TextView textView = new TextView(this.c);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        textView.setGravity(17);
        layoutParams.addRule(15);
        textView.setTextAlignment(4);
        textView.setTextColor(Color.parseColor("#161823"));
        textView.setTextSize(17.0f);
        textView.setTypeface(null, 1);
        textView.setText("权限列表");
        textView.setLayoutParams(layoutParams);
        relativeLayout2.addView(textView);
        relativeLayout.addView(relativeLayout2);
        return tt(i, linearLayout, relativeLayout);
    }

    private LinearLayout c(int i, LinearLayout linearLayout, RelativeLayout relativeLayout, LinearLayout linearLayout2, int i2, int i3) {
        return c(i2, i3, linearLayout2, uj(i, linearLayout, relativeLayout));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c() {
        this.sp.setWebViewClient(new com.byazt.jwd.uj(this.c, null, 0 == true ? 1 : 0) { // from class: com.byazt.sgn.tt.1
            @Override // com.byazt.jwd.uj
            public boolean c(WebView webView, WebResourceRequest webResourceRequest) {
                this.x = tt.tt;
                return super.c(webView, webResourceRequest);
            }

            @Override // com.byazt.jwd.uj, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (webView == null) {
                    return true;
                }
                try {
                    if (TextUtils.isEmpty(str)) {
                        return true;
                    }
                    String scheme = Uri.parse(str).getScheme();
                    if (TextUtils.isEmpty(scheme)) {
                        return true;
                    }
                    String lowerCase = scheme.toLowerCase(Locale.ROOT);
                    if (!lowerCase.contains("http") && !lowerCase.contains("https")) {
                        return true;
                    }
                    webView.loadUrl(str);
                    return true;
                } catch (Exception unused) {
                    return true;
                }
            }

            @Override // com.byazt.jwd.uj
            public boolean c(WebView webView, String str) {
                this.x = tt.tt;
                return super.c(webView, str);
            }
        });
        this.sp.setJavaScriptEnabled(true);
        this.sp.setDisplayZoomControls(false);
        this.sp.setCacheMode(2);
        this.sp.loadUrl(this.x);
    }

    private void c(HashMap<String, String> map) {
        List<ve> list = this.t;
        if (list != null && list.size() > 0) {
            this.t.clear();
        }
        if (this.t == null) {
            this.t = new ArrayList();
        }
        if (map != null && map.size() > 0) {
            for (String str : map.keySet()) {
                this.t.add(new ve(str, map.get(str)));
            }
            return;
        }
        this.t.add(new ve("补充中，可于应用官网查看", ""));
    }

    public tt c(c cVar) {
        this.i = cVar;
        return this;
    }
}

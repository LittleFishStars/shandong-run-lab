package com.alibaba.triver.extensions;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVAccountService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.permission.api.proxy.AuthDialogProxy;
import com.alibaba.ariver.permission.model.AuthProtocol;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.triver.kit.api.proxy.IAuthUIProxy;
import com.alibaba.triver.kit.api.proxy.IDarkModeProxy;
import com.alibaba.triver.kit.api.utils.CommonUtils;
import com.alibaba.triver.kit.api.utils.InternationalUtil;
import com.alibaba.triver.kit.api.utils.SPUtils;
import com.alibaba.triver.support.ui.R;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.taobao.uikit.extend.feature.view.TUrlImageView;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AuthDialogExtention implements AuthDialogProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24932a = "AuthDialogExtention";

    public static class b implements com.alibaba.ariver.permission.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Context f24940a;
        AlertDialog b;
        View c;
        View d;
        View e;
        View.OnClickListener f;
        View.OnClickListener g;
        private String h;
        private String i;
        private List<String> j;
        private List<AuthProtocol> k;
        private String l;
        private List<String> m;
        private Page n;
        private App o;

        public b(Context context) {
            this.f24940a = context;
        }

        @Override // com.alibaba.ariver.permission.b.a
        public void a(String str, String str2, App app, List<String> list, List<String> list2, List<AuthProtocol> list3, String str3, Map<String, String> map) {
            this.i = str2;
            this.h = str;
            this.j = list2;
            this.k = list3;
            this.o = app;
            if (app != null) {
                this.n = app.getActivePage();
            }
            this.m = list;
            if (map != null) {
                this.l = map.get("appAlias");
            }
        }

        @Override // com.alibaba.ariver.permission.b.a
        public void b(View.OnClickListener onClickListener) {
            this.f = onClickListener;
        }

        @Override // com.alibaba.ariver.permission.b.a
        public void b() {
            AlertDialog alertDialog = this.b;
            if (alertDialog == null || !alertDialog.isShowing()) {
                return;
            }
            this.b.dismiss();
        }

        @Override // com.alibaba.ariver.permission.b.a
        public void a(View.OnClickListener onClickListener) {
            this.g = onClickListener;
        }

        @Override // com.alibaba.ariver.permission.b.a
        public void a() {
            RVExecutorService rVExecutorService = (RVExecutorService) RVProxy.get(RVExecutorService.class);
            if (rVExecutorService != null) {
                rVExecutorService.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.extensions.AuthDialogExtention.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Drawable authGrantBgDrawable;
                        Context context = b.this.f24940a;
                        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
                            return;
                        }
                        View viewInflate = View.inflate(b.this.f24940a, R.layout.triver_dialog_auth_new, null);
                        ScrollView scrollView = (ScrollView) viewInflate.findViewById(R.id.scrollView);
                        b.this.d = viewInflate.findViewById(R.id.open_auth_btn_cancel);
                        b.this.d.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.triver.extensions.AuthDialogExtention.b.1.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (b.this.o == null) {
                                    return;
                                }
                                b.this.g.onClick(view);
                                String appKey = ((AppModel) b.this.n.getApp().getData(AppModel.class)).getAppInfoModel().getAppKey();
                                String userId = ((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId(b.this.o);
                                if (b.this.m != null) {
                                    Iterator it = b.this.m.iterator();
                                    while (it.hasNext()) {
                                        SPUtils.writeString(((String) it.next()) + appKey + userId, AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE);
                                    }
                                }
                            }
                        });
                        b.this.e = viewInflate.findViewById(R.id.open_auth_btn_grant);
                        b bVar = b.this;
                        bVar.e.setOnClickListener(bVar.f);
                        b.this.b = new AlertDialog.Builder(b.this.f24940a, R.style.triver_wopc_dialog_new).create();
                        if (RVProxy.get(IDarkModeProxy.class) != null && ((IDarkModeProxy) RVProxy.get(IDarkModeProxy.class)).isDarkModeEnable(b.this.f24940a)) {
                            ((IDarkModeProxy) RVProxy.get(IDarkModeProxy.class)).enableAutoDark(b.this.b);
                        }
                        IAuthUIProxy iAuthUIProxy = (IAuthUIProxy) RVProxy.get(IAuthUIProxy.class);
                        if (iAuthUIProxy != null && (authGrantBgDrawable = iAuthUIProxy.getAuthGrantBgDrawable(b.this.f24940a)) != null) {
                            b.this.e.setBackgroundDrawable(authGrantBgDrawable);
                        }
                        TUrlImageView tUrlImageViewFindViewById = viewInflate.findViewById(R.id.open_auth_app_icon);
                        tUrlImageViewFindViewById.a(new com.taobao.uikit.a.a.b());
                        tUrlImageViewFindViewById.setImageUrl(b.this.i);
                        ((TextView) viewInflate.findViewById(R.id.open_auth_grant_title)).setText(b.this.h + " 请求获取以下信息");
                        ViewGroup viewGroup = (ViewGroup) viewInflate.findViewById(R.id.open_auth_desc_layout);
                        if (b.this.j != null) {
                            for (String str : b.this.j) {
                                ViewGroup viewGroup2 = (ViewGroup) View.inflate(b.this.f24940a, R.layout.triver_auth_desc_text_new, null);
                                ((TextView) viewGroup2.findViewById(R.id.open_auth_desc)).setText(str);
                                viewGroup.addView(viewGroup2, new ViewGroup.LayoutParams(-1, -2));
                            }
                        }
                        TextView textView = (TextView) viewInflate.findViewById(R.id.open_auth_see_more_btn);
                        if (b.this.k == null || b.this.k.size() < 1) {
                            textView.setVisibility(4);
                        } else {
                            textView.setText(String.format(InternationalUtil.getString(b.this.f24940a, R.string.triver_core_xuzhi), InternationalUtil.getString(b.this.f24940a, R.string.triver_core_shouquan_title)));
                            textView.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.triver.extensions.AuthDialogExtention.b.1.2
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    b bVar2 = b.this;
                                    AuthDialogExtention.showAuthDescDialog(bVar2.f24940a, bVar2.k);
                                }
                            });
                        }
                        try {
                            scrollView.measure(0, 0);
                            int measuredHeight = scrollView.getMeasuredHeight();
                            DisplayMetrics displayMetrics = new DisplayMetrics();
                            ((WindowManager) b.this.f24940a.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                            int iDip2px = (int) ((((double) displayMetrics.heightPixels) * 0.6d) - ((double) CommonUtils.dip2px(b.this.f24940a, 52.0f)));
                            if (measuredHeight > iDip2px) {
                                ViewGroup.LayoutParams layoutParams = scrollView.getLayoutParams();
                                layoutParams.height = iDip2px;
                                scrollView.setLayoutParams(layoutParams);
                            }
                        } catch (Exception e) {
                            RVLogger.e(AuthDialogExtention.f24932a, e);
                        }
                        b.this.b.setCancelable(false);
                        b.this.b.show();
                        if (b.this.b.getWindow() != null) {
                            b.this.b.getWindow().setContentView(viewInflate);
                            b.this.b.getWindow().setGravity(80);
                            b.this.b.getWindow().setWindowAnimations(R.style.triver_wopc_dialog_anim);
                            b.this.b.getWindow().setLayout(-1, -2);
                        }
                    }
                });
            }
        }
    }

    public static class c implements com.alibaba.ariver.permission.b.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private View.OnClickListener f24944a;
        private View b;

        public c(Context context) {
            this.b = new View(context);
        }

        @Override // com.alibaba.ariver.permission.b.b
        public void a() {
            this.f24944a.onClick(this.b);
        }

        @Override // com.alibaba.ariver.permission.b.b
        public void a(View.OnClickListener onClickListener) {
        }

        @Override // com.alibaba.ariver.permission.b.b
        public void b() {
        }

        @Override // com.alibaba.ariver.permission.b.b
        public void b(View.OnClickListener onClickListener) {
            this.f24944a = onClickListener;
        }
    }

    public static class d implements com.alibaba.ariver.permission.b.b {
        @Override // com.alibaba.ariver.permission.b.b
        public void a() {
        }

        @Override // com.alibaba.ariver.permission.b.b
        public void a(View.OnClickListener onClickListener) {
        }

        @Override // com.alibaba.ariver.permission.b.b
        public void b() {
        }

        @Override // com.alibaba.ariver.permission.b.b
        public void b(View.OnClickListener onClickListener) {
        }
    }

    public static void showAuthDescDialog(Context context, final List<AuthProtocol> list) {
        View viewInflate = View.inflate(context, R.layout.triver_auth_pop_window, null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.open_auth_desc_cancel_btn);
        final WebView webView = (WebView) viewInflate.findViewById(R.id.open_auth_webview);
        webView.setWebViewClient(new WebViewClient() { // from class: com.alibaba.triver.extensions.AuthDialogExtention.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, WebResourceRequest webResourceRequest) {
                return super.shouldOverrideUrlLoading(webView2, webResourceRequest);
            }
        });
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.protocol_list_layout);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.alibaba.triver.extensions.AuthDialogExtention.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view == null || view.getTag() == null || !(view.getTag() instanceof String)) {
                    return;
                }
                webView.setVisibility(0);
                webView.loadUrl((String) view.getTag());
            }
        };
        if (list == null || list.size() == 0) {
            webView.setVisibility(0);
            webView.loadUrl(InternationalUtil.getString(R.string.triver_extension_default_link));
        } else if (list.size() == 1) {
            webView.setVisibility(0);
            webView.loadUrl(list.get(0).getLink());
        } else {
            for (AuthProtocol authProtocol : list) {
                TextView textView2 = new TextView(context);
                textView2.setTag(authProtocol.getLink());
                textView2.setText(authProtocol.getName());
                textView2.setTextColor(Color.parseColor("#0000FE"));
                textView2.getPaint().setFlags(8);
                textView2.setTypeface(Typeface.defaultFromStyle(1));
                textView2.setTextSize(15.0f);
                textView2.setOnClickListener(onClickListener);
                textView2.setPadding(0, 15, 0, 15);
                linearLayout.addView(textView2);
            }
            webView.setVisibility(8);
        }
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(context, R.style.triver_wopc_dialog).create();
        alertDialogCreate.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.alibaba.triver.extensions.AuthDialogExtention.3
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                List list2;
                if (i != 4) {
                    return false;
                }
                if (webView.getVisibility() == 0 && (list2 = list) != null && list2.size() > 1) {
                    webView.setVisibility(8);
                } else if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
                return true;
            }
        });
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.show();
        alertDialogCreate.getWindow().setContentView(viewInflate);
        alertDialogCreate.getWindow().setLayout(-1, -1);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.triver.extensions.AuthDialogExtention.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List list2;
                if (view.getId() == R.id.open_auth_desc_cancel_btn && alertDialogCreate.isShowing()) {
                    if (webView.getVisibility() == 0 && (list2 = list) != null && list2.size() > 1) {
                        webView.setVisibility(8);
                        return;
                    }
                    AlertDialog alertDialog = alertDialogCreate;
                    if (alertDialog != null) {
                        alertDialog.dismiss();
                    }
                }
            }
        });
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthDialogProxy
    public com.alibaba.ariver.permission.b.b getAuthNoticeDialog(Context context) {
        return new c(context);
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthDialogProxy
    public com.alibaba.ariver.permission.b.c getLocalPermissionDialog(Context context) {
        return new a(context);
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthDialogProxy
    public com.alibaba.ariver.permission.b.a getOpenAuthDialog(Context context) {
        return new b(context);
    }

    @Override // com.alibaba.ariver.permission.api.proxy.AuthDialogProxy
    public void showErrorTipDialog(Context context, String str, String str2) {
    }

    public static class a implements com.alibaba.ariver.permission.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        AlertDialog.Builder f24936a;
        Context b;

        public a(Context context) {
            this.f24936a = new AlertDialog.Builder(context);
            this.b = context;
        }

        @Override // com.alibaba.ariver.permission.b.c
        public void a(String str, String str2, String str3) {
            AlertDialog.Builder builder = this.f24936a;
            if (builder != null) {
                builder.setMessage(str);
            }
        }

        @Override // com.alibaba.ariver.permission.b.c
        public void a(final com.alibaba.ariver.permission.b.d dVar) {
            AlertDialog.Builder builder = this.f24936a;
            if (builder != null) {
                builder.setPositiveButton(R.string.triver_core_grant, new DialogInterface.OnClickListener() { // from class: com.alibaba.triver.extensions.AuthDialogExtention.a.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        com.alibaba.ariver.permission.b.d dVar2 = dVar;
                        if (dVar2 != null) {
                            dVar2.a();
                        }
                    }
                });
                this.f24936a.setNegativeButton(R.string.triver_core_cancel, new DialogInterface.OnClickListener() { // from class: com.alibaba.triver.extensions.AuthDialogExtention.a.2
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        com.alibaba.ariver.permission.b.d dVar2 = dVar;
                        if (dVar2 != null) {
                            dVar2.a(0, null, true);
                        }
                    }
                });
            }
        }

        @Override // com.alibaba.ariver.permission.b.c
        public void a() {
            RVExecutorService rVExecutorService = (RVExecutorService) RVProxy.get(RVExecutorService.class);
            if (rVExecutorService != null) {
                rVExecutorService.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.triver.extensions.AuthDialogExtention.a.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AlertDialog.Builder builder;
                        Context context = a.this.b;
                        if (((context instanceof Activity) && ((Activity) context).isFinishing()) || (builder = a.this.f24936a) == null) {
                            return;
                        }
                        AlertDialog alertDialogCreate = builder.create();
                        alertDialogCreate.setCancelable(false);
                        alertDialogCreate.show();
                    }
                });
            }
        }
    }
}

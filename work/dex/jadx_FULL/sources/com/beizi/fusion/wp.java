package com.beizi.fusion;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class wp extends r3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WebChromeClient.CustomViewCallback f27992a;
    private FrameLayout b;
    private Activity c;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            wp.this.onHideCustomView();
        }
    }

    public wp(Activity activity) {
        this.c = activity;
    }

    private void a(FrameLayout frameLayout) {
        ImageButton imageButton = new ImageButton(this.c);
        imageButton.setImageDrawable(this.c.getResources().getDrawable(android.R.drawable.ic_menu_close_clear_cancel));
        imageButton.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 53));
        imageButton.setBackgroundColor(0);
        imageButton.setOnClickListener(new a());
        frameLayout.addView(imageButton);
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        ViewGroup viewGroup;
        super.onHideCustomView();
        Activity activity = this.c;
        if (activity == null || this.b == null || (viewGroup = (ViewGroup) activity.findViewById(android.R.id.content)) == null) {
            return;
        }
        viewGroup.removeView(this.b);
        WebChromeClient.CustomViewCallback customViewCallback = this.f27992a;
        if (customViewCallback != null) {
            try {
                customViewCallback.onCustomViewHidden();
            } catch (NullPointerException unused) {
            }
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, customViewCallback);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        ViewGroup viewGroup;
        super.onShowCustomView(view, customViewCallback);
        Activity activity = this.c;
        if (activity == null || (viewGroup = (ViewGroup) activity.findViewById(android.R.id.content)) == null) {
            return;
        }
        this.f27992a = customViewCallback;
        if (!(view instanceof FrameLayout)) {
            this.b = null;
            return;
        }
        FrameLayout frameLayout = (FrameLayout) view;
        this.b = frameLayout;
        frameLayout.setClickable(true);
        this.b.setBackgroundColor(-16777216);
        try {
            a(this.b);
            viewGroup.addView(this.b, new ViewGroup.LayoutParams(-1, -1));
        } catch (Exception unused) {
        }
    }
}

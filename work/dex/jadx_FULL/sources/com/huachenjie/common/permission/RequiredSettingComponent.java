package com.huachenjie.common.permission;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import com.huachenjie.common.R;
import com.huachenjie.common.base.BaseComponent;
import com.huachenjie.common.widget.CustomizeViewDialog;
import com.zj.adlib.vo6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class RequiredSettingComponent<T> extends BaseComponent<T> {
    public static final String f = "RequiredSetting";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Dialog f33836a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CustomizeViewDialog.Builder f8810a;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            vo6.f(RequiredSettingComponent.this.b());
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            vo6.g(RequiredSettingComponent.this.b());
        }
    }

    public RequiredSettingComponent(T context) {
        super(context);
    }

    @Override // com.huachenjie.common.base.BaseComponent
    public void bindData() {
    }

    public void d(int type) {
        e(type, null, null, null, null);
    }

    public void e(int type, String title, String content, String noTxt, String yesTxt) {
        Dialog dialog = this.f33836a;
        if (dialog != null) {
            dialog.dismiss();
        }
        if (type == 1) {
            if (TextUtils.isEmpty(title)) {
                title = b().getString(R.string.location_disable_title);
            }
            if (TextUtils.isEmpty(content)) {
                content = b().getString(R.string.location_disable_content);
            }
            if (TextUtils.isEmpty(noTxt)) {
                noTxt = b().getString(R.string.cancel);
            }
            if (TextUtils.isEmpty(yesTxt)) {
                yesTxt = b().getString(R.string.go_to_set);
            }
            this.f8810a.setTitle(title);
            this.f8810a.setMessage(content);
            this.f8810a.setNegative(noTxt);
            this.f8810a.setCancelable(false);
            this.f8810a.setPositive(yesTxt, new a());
        } else if (type == 2) {
            this.f8810a.setTitle(b().getString(R.string.notification_disable_title));
            this.f8810a.setMessage(b().getString(R.string.notification_disable_content));
            this.f8810a.setPositive(b().getString(R.string.go_to_set), new b());
        }
        CustomizeViewDialog customizeViewDialogCreate = this.f8810a.create(getActivity());
        this.f33836a = customizeViewDialogCreate;
        customizeViewDialogCreate.show();
    }

    @Override // com.huachenjie.common.base.BaseComponent
    public void findViews() {
        this.f8810a = new CustomizeViewDialog.Builder().setDialogWidth(270).setCancelable(false).setCanceledOnTouchOutside(false).setNegative(b().getString(R.string.cancel)).setOrientation(0);
    }

    @Override // com.huachenjie.common.base.BaseComponent
    public void initListeners() {
    }

    @Override // com.huachenjie.common.base.BaseComponent, com.huachenjie.common.base.ILifecycleCallback
    public void onDestroy() {
        super.onDestroy();
    }
}

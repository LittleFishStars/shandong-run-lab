package com.kc.aw;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.kc.aw.component.widgets.PtgConfirmBtn;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _cr extends _ak {
    public ImageView _c;
    public TextView _d;
    public PtgConfirmBtn _e;
    public String _f;
    public _a _g;

    @Keep
    public interface _a {
    }

    public _cr(Activity activity) {
        super(activity, R.style.aw_style_alert_dialog);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.aw_dialog_download);
        setCanceledOnTouchOutside(true);
        this._b = getWindow().getDecorView().findViewById(android.R.id.content);
        this._c = (ImageView) findViewById(R.id.ptg_close_iv);
        this._d = (TextView) findViewById(R.id.ptg_title_tv);
        this._e = (PtgConfirmBtn) findViewById(R.id.ptg_continue_btn);
        this._c.setOnClickListener(new _cp(this));
        this._e.setOnClickListener(new _cq(this));
        TextView textView = this._d;
        if (textView != null) {
            textView.setText(this._f);
        }
    }
}

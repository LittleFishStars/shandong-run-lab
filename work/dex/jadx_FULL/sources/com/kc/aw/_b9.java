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
public final class _b9 extends _ak {
    public ImageView _c;
    public TextView _d;
    public TextView _e;
    public PtgConfirmBtn _f;
    public String _g;
    public _a _h;

    @Keep
    public interface _a {
    }

    public _b9(Activity activity) {
        super(activity, R.style.aw_style_alert_dialog);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.aw_dialog_close_video);
        setCanceledOnTouchOutside(false);
        this._b = getWindow().getDecorView().findViewById(android.R.id.content);
        this._c = (ImageView) findViewById(R.id.ptg_close_iv);
        this._d = (TextView) findViewById(R.id.ptg_title_tv);
        this._e = (TextView) findViewById(R.id.ptg_cancel_btn);
        this._f = (PtgConfirmBtn) findViewById(R.id.ptg_continue_btn);
        this._c.setOnClickListener(new _b6(this));
        this._e.setOnClickListener(new _b7(this));
        this._f.setOnClickListener(new _b8(this));
        TextView textView = this._d;
        if (textView != null) {
            textView.setText(this._g);
        }
    }
}

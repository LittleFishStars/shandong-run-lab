package com.kc.aw.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.kc.aw.component.videoplayer.NiceVideoPlayer;
import com.kc.aw.component.widgets.PlaceholderImageView;
import com.kc.aw.widget.PtgRoundLinearLayout;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class PtgBaseVideoActivity extends Activity {
    public TextView _A;
    public TextView _B;
    public TextView _C;
    public TextView _D;
    public TextView _E;
    public TextView _F;
    public LinearLayout _G;
    public FrameLayout _a;
    public NiceVideoPlayer _b;
    public ProgressBar _c;
    public FrameLayout _d;
    public ImageView _e;
    public PtgRoundLinearLayout _f;
    public ImageView _g;
    public TextView _h;
    public ImageView _i;
    public LinearLayout _j;
    public PlaceholderImageView _k;
    public TextView _l;
    public TextView _m;
    public LinearLayout _n;
    public TextView _o;
    public TextView _p;
    public TextView _q;
    public TextView _r;
    public TextView _s;
    public TextView _t;
    public LinearLayout _u;
    public LinearLayout _v;
    public PlaceholderImageView _w;
    public TextView _x;
    public TextView _y;
    public LinearLayout _z;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
            getWindow().addFlags(1024);
            getWindow().addFlags(16777216);
        } catch (Throwable unused) {
        }
    }
}

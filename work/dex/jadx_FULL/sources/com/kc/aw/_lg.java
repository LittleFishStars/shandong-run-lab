package com.kc.aw;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.ipd.dsp.internal.b1.b;
import com.ipd.dsp.internal.e1.i;
import com.kc.aw.activity.PtgLaunchActivity;
import com.kc.aw.activity.PtgRewardVideoPortraitActivity;
import com.kc.aw.activity.PtgWebActivity;
import com.kc.aw.component.videoplayer.NiceVideoPlayer;
import com.kc.aw.component.widgets.PlaceholderImageView;
import com.kc.aw.component.widgets.PtgShakeView;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.constants.PtgRewardConstant;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.PtgAppDownloadListener;
import com.kc.aw.lib.interf.PtgRewardVideoAd;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.model.AppInfo;
import com.kc.aw.lib.utils.Logger;
import com.kc.aw.lib.utils.TextUtil;
import com.kc.aw.widget.PtgRoundLinearLayout;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _lg {
    public static int _aa;
    public TextView _0;
    public LinearLayout _1;
    public TextView _2;
    public TextView _3;
    public TextView _4;
    public TextView _5;
    public TextView _6;
    public TextView _7;
    public LinearLayout _8;
    public LinearLayout _9;
    public FrameLayout _A;
    public _k9 _B;
    public NiceVideoPlayer _C;
    public _kb _D;
    public _in _E;
    public ProgressBar _F;
    public FrameLayout _G;
    public ImageView _H;
    public TextView _I;
    public ImageView _J;
    public PtgRoundLinearLayout _K;
    public ImageView _L;
    public LinearLayout _M;
    public PlaceholderImageView _N;
    public TextView _O;
    public TextView _P;
    public LinearLayout _Q;
    public TextView _R;
    public TextView _S;
    public TextView _T;
    public TextView _U;
    public TextView _V;
    public TextView _W;
    public LinearLayout _X;
    public PlaceholderImageView _Y;
    public TextView _Z;
    public _f4 _a;
    public PtgShakeView _a0;
    public PtgShakeView _a1;
    public String _a2;
    public _i _a5;
    public boolean _a7;
    public _b9 _a9;
    public com.kc.aw._h _b;
    public AdSlot _c;
    public int _d;
    public int _e;
    public int _g;
    public String _h;
    public String _i;
    public String _j;
    public String _k;
    public String _l;
    public String _m;
    public String _n;
    public String _o;
    public String _p;
    public String _q;
    public boolean _r;
    public int _u;
    public int _v;
    public String _w;
    public boolean _f = true;
    public int _s = 0;
    public int _t = 0;
    public boolean _x = false;
    public boolean _y = false;
    public boolean _z = false;
    public int _a3 = 0;
    public final _a _a4 = new _a(this);
    public final AtomicBoolean _a6 = new AtomicBoolean();
    public final _c _a8 = new _c(this);

    @Keep
    public final class _a implements _in._b {
        public final _lg _a;

        public _a(_lg _lgVar) {
            this._a = _lgVar;
        }

        @Override // com.kc.aw._in._b
        public final void _a(View view, int i, _nk _nkVar) {
            _lg _lgVar = this._a;
            _lgVar._a(view, i, _nkVar, true);
            _m1._a(_lgVar._A, view, null);
        }

        @Override // com.kc.aw._in._b
        public final void _a(boolean z) {
            _lg _lgVar = this._a;
            _lgVar._a7 = z;
            _lgVar._c(false);
        }

        @Override // com.kc.aw._in._b
        public final void _b(View view, int i, _nk _nkVar) {
            this._a._a(view, i, _nkVar, false);
        }
    }

    @Keep
    public final class _b implements _b3<Boolean> {
        public final _lg _a;

        public _b(_lg _lgVar) {
            this._a = _lgVar;
        }

        @Override // com.kc.aw._b3
        public final void _a(Boolean bool) {
            PtgRewardConstant.ServerErr serverErr;
            String msg;
            _lg _lgVar;
            boolean z;
            int code;
            Boolean bool2 = bool;
            _lg _lgVar2 = this._a;
            _lgVar2._z = false;
            if (bool2 != null) {
                if (bool2.booleanValue()) {
                    _lgVar = this._a;
                    PtgRewardConstant.ServerErr serverErr2 = PtgRewardConstant.ServerErr.SUC;
                    code = serverErr2.getCode();
                    msg = serverErr2.getMsg();
                    z = true;
                } else {
                    _lgVar2 = this._a;
                    serverErr = PtgRewardConstant.ServerErr.SUC_ERR;
                }
                _lgVar._a(code, msg, z);
            }
            serverErr = PtgRewardConstant.ServerErr.ERR_DATA;
            int code2 = serverErr.getCode();
            _lg _lgVar3 = _lgVar2;
            msg = serverErr.getMsg();
            _lgVar = _lgVar3;
            z = false;
            code = code2;
            _lgVar._a(code, msg, z);
        }

        @Override // com.kc.aw._b3
        public final void onError(AdError adError) {
            _lg _lgVar = this._a;
            _lgVar._z = false;
            _lgVar._a(adError.getErrorCode(), adError.getMessage(), false);
        }
    }

    @Keep
    public final class _c implements PtgAppDownloadListener {
        public final _lg _a;

        public _c(_lg _lgVar) {
            this._a = _lgVar;
        }

        @Override // com.kc.aw.lib.interf.PtgAppDownloadListener
        public final void onDownloadActive(long j, long j2, String str) {
            Logger.d("RewardVideoManagerTag", "onDownloadActive totalBytes:" + j + " currBytes: " + j2 + " appName: " + str);
            _la._a()._a(this._a._a2, j, j2, str);
            _lg._a(this._a, j, j2);
        }

        @Override // com.kc.aw.lib.interf.PtgAppDownloadListener
        public final void onDownloadCancel() {
            Logger.d("RewardVideoManagerTag", "onDownloadCancel");
            _la._a()._c(this._a._a2);
            _lg _lgVar = this._a;
            _lgVar._a(_lgVar._W);
            _lg _lgVar2 = this._a;
            _lgVar2._a(_lgVar2._7);
        }

        @Override // com.kc.aw.lib.interf.PtgAppDownloadListener
        public final void onDownloadFailed(String str) {
            Logger.d("RewardVideoManagerTag", "onDownloadFailed: " + str);
            _la._a()._a(this._a._a2, str);
            _lg _lgVar = this._a;
            _lgVar._a(_lgVar._W);
            _lg _lgVar2 = this._a;
            _lgVar2._a(_lgVar2._7);
        }

        @Override // com.kc.aw.lib.interf.PtgAppDownloadListener
        public final void onDownloadFinished(String str) {
            Logger.d("RewardVideoManagerTag", "onDownloadFinished appName: " + str);
            _la._a()._b(this._a._a2, str);
            _lg _lgVar = this._a;
            _lgVar._a(_lgVar._W);
            _lg _lgVar2 = this._a;
            _lgVar2._a(_lgVar2._7);
        }

        @Override // com.kc.aw.lib.interf.PtgAppDownloadListener
        public final void onDownloadPaused(long j, long j2, String str) {
            Logger.d("RewardVideoManagerTag", "onDownloadPaused totalBytes:" + j + " currBytes: " + j2 + " appName: " + str);
            _la._a()._b(this._a._a2, j, j2, str);
            _lg._a(this._a, j, j2);
        }

        @Override // com.kc.aw.lib.interf.PtgAppDownloadListener
        public final void onIdle() {
            Logger.d("RewardVideoManagerTag", "onIdle");
            _la._a()._d(this._a._a2);
        }

        @Override // com.kc.aw.lib.interf.PtgAppDownloadListener
        public final void onInstalled(String str) {
            Logger.d("RewardVideoManagerTag", "onInstalled");
            _la._a()._c(this._a._a2, str);
            _lg _lgVar = this._a;
            _lgVar._a(_lgVar._W);
            _lg _lgVar2 = this._a;
            _lgVar2._a(_lgVar2._7);
        }
    }

    @Keep
    public final class _d implements _eu {
        public final _lg _a;

        public _d(_lg _lgVar) {
            this._a = _lgVar;
        }

        public final void _a(String str) {
            _la._a()._a(this._a._a2, PtgErrorCode.SDK_RESOURCE_ERROR, str);
        }
    }

    @Keep
    public final class _e implements View.OnClickListener {
        public final _lg _a;

        public _e(_lg _lgVar) {
            this._a = _lgVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (com.kc.aw.lib.utils._a._c() || this._a._b == null) {
                return;
            }
            int i_a = _o6._a(view);
            if (!(i_a == 6 || i_a == 4)) {
                this._a._a(view, 0, null, false);
                return;
            }
            _lg _lgVar = this._a;
            _lgVar._a(view, _o6._a(view), null, true);
            _m1._a(_lgVar._A, view, null);
        }
    }

    @Keep
    public final class _f implements View.OnClickListener {
        public final _lg _a;

        public _f(_lg _lgVar) {
            this._a = _lgVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Context context = view.getContext();
            String str = this._a._p;
            int i = PtgWebActivity._g;
            _r _rVar = new _r();
            _rVar._a = str;
            try {
                Intent intent = new Intent(context, (Class<?>) PtgWebActivity.class);
                intent.setFlags(268435456);
                intent.putExtra("playerInfo", _rVar);
                context.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    @Keep
    public final class _g implements View.OnClickListener {
        public final _lg _a;

        public _g(_lg _lgVar) {
            this._a = _lgVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Context context = view.getContext();
            String str = this._a._o;
            int i = PtgWebActivity._g;
            _r _rVar = new _r();
            _rVar._a = str;
            try {
                Intent intent = new Intent(context, (Class<?>) PtgWebActivity.class);
                intent.setFlags(268435456);
                intent.putExtra("playerInfo", _rVar);
                context.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    @Keep
    public final class _h implements View.OnClickListener {
        public final _lg _a;

        public _h(_lg _lgVar) {
            this._a = _lgVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Context context = view.getContext();
            String str = this._a._q;
            int i = PtgWebActivity._g;
            _r _rVar = new _r();
            _rVar._a = str;
            try {
                Intent intent = new Intent(context, (Class<?>) PtgWebActivity.class);
                intent.setFlags(268435456);
                intent.putExtra("playerInfo", _rVar);
                context.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    @Keep
    public static final class _i extends Handler {
        public final WeakReference<_lg> _a;
        public int _b;

        public _i(_lg _lgVar, int i) {
            super(Looper.getMainLooper());
            this._a = new WeakReference<>(_lgVar);
            this._b = i;
            _lg._aa = (int) (Math.floor(((double) i) / 1000.0d) * 1000.0d);
            Logger.d(i.b, "SafeHandler countDownTime:" + this._b);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            _lg _lgVar = this._a.get();
            if (_lgVar != null) {
                int i = this._b;
                int i2 = _lg._aa;
                if (i2 > 0) {
                    long j = i - i2;
                    _kb _kbVar = _lgVar._D;
                    if (_kbVar != null) {
                        _kbVar._a(_lgVar._b, j);
                    }
                    long j2 = i;
                    _lgVar._a(j2, i - _lg._aa);
                    if (!_lgVar._r) {
                        _la._a()._a(j2, i - _lg._aa, _lgVar._a2);
                    }
                    _i _iVar = _lgVar._a5;
                    if (_iVar != null) {
                        _iVar.sendEmptyMessageDelayed(0, 1000L);
                    }
                } else {
                    long j3 = i;
                    _lgVar._a(j3, j3);
                    _kb _kbVar2 = _lgVar._D;
                    if (_kbVar2 != null) {
                        _kbVar2._a(_lgVar._b, -1L);
                    }
                    if (!_lgVar._r) {
                        _la._a()._a(j3, i - _lg._aa, _lgVar._a2);
                        _la _laVar_a = _la._a();
                        String str = _lgVar._a2;
                        if (str == null) {
                            _laVar_a.getClass();
                        } else {
                            List list = (List) _laVar_a._c.get(str);
                            if (list != null && !list.isEmpty()) {
                                Iterator it = list.iterator();
                                while (it.hasNext()) {
                                    ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onVideoComplete();
                                }
                            }
                        }
                        _lgVar._x = true;
                        _lgVar._a();
                    }
                }
                _lg._aa -= 1000;
            }
        }
    }

    public static void _a(_lg _lgVar, long j, long j2) {
        if (_lgVar._W == null || _lgVar._7 == null) {
            return;
        }
        String str = (j <= 0 || j2 <= 0) ? "已下载 0%" : String.format(Locale.CHINA, "已下载 %d%%", Integer.valueOf((int) ((j2 / j) * 100.0f)));
        _lgVar._W.setText(str);
        _lgVar._7.setText(str);
    }

    public final void _a() {
        this._H.setVisibility(0);
        this._M.setVisibility(8);
        this._X.setVisibility(0);
        if (PtgAdSdk.getConfig()._b()) {
            _ez._a(this._j, this._Y);
        } else {
            new _d3(PtgAdSdk.getContext(), this._Y).execute(this._j);
        }
        this._Z.setText(this._k);
        this._0.setText(this._l);
        _a(this._7);
        if (this._g == 0) {
            this._1.setVisibility(0);
            this._2.setText(this._m);
            this._3.setText(this._n);
            this._4.setOnClickListener(new _g(this));
            this._5.setOnClickListener(new _f(this));
            this._6.setOnClickListener(new _h(this));
        } else {
            this._1.setVisibility(8);
        }
        this._7.setOnClickListener(new _e(this));
        _m1._a(this._A, this._7, null);
        _c(true);
    }

    public final void _a(int i, String str, boolean z) {
        int rewardAmount;
        String rewardName;
        _la _laVar_a = _la._a();
        String str2 = this._a2;
        Bundle bundle = new Bundle();
        bundle.putInt(PtgRewardConstant.REWARD_PARAMS.SERVER_CODE, i);
        bundle.putString(PtgRewardConstant.REWARD_PARAMS.SERVER_MSG, str);
        AdSlot adSlot = this._c;
        _f4 _f4Var = this._a;
        if (adSlot != null && adSlot.getRewardAmount() > 0) {
            rewardAmount = adSlot.getRewardAmount();
        } else if (_f4Var == null || (rewardAmount = _f4Var._e) <= 0) {
            rewardAmount = 0;
        }
        bundle.putInt("reward_amount", rewardAmount);
        AdSlot adSlot2 = this._c;
        _f4 _f4Var2 = this._a;
        if (adSlot2 == null || TextUtils.isEmpty(adSlot2.getRewardName())) {
            rewardName = (_f4Var2 == null || TextUtils.isEmpty(_f4Var2._d)) ? "" : _f4Var2._d;
        } else {
            rewardName = adSlot2.getRewardName();
        }
        bundle.putString("reward_name", rewardName);
        AdSlot adSlot3 = this._c;
        if (adSlot3 != null) {
            bundle.putString("extra", adSlot3.getMediaExtra());
            bundle.putString(PtgRewardConstant.REWARD_PARAMS.USER_ID, this._c.getUserID());
        } else {
            bundle.putString("extra", "");
            bundle.putString(PtgRewardConstant.REWARD_PARAMS.USER_ID, "");
        }
        if (str2 == null) {
            _laVar_a.getClass();
        } else {
            List list = (List) _laVar_a._c.get(str2);
            if (list != null && !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onRewardVerify(z, bundle);
                }
            }
        }
        this._y = true;
    }

    public final void _a(long j, long j2) {
        if (j < j2 || this._I == null) {
            return;
        }
        int iFloor = ((int) Math.floor((j - j2) / 1000.0f)) - ((int) ((j - Math.min((int) (j * 0.7f), 30000L)) / 1000.0f));
        if (iFloor < 0) {
            iFloor = 0;
        }
        this._I.setText("奖励发放时长倒计时 " + iFloor + "s");
        this._I.setTag(Integer.valueOf(iFloor));
        ImageView imageView = this._J;
        if (imageView != null && this._I != null) {
            int i = iFloor <= 0 ? 8 : 0;
            imageView.setVisibility(i);
            this._I.setVisibility(i);
        }
        _b(iFloor);
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:58:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:63:0x00d2  */
    public final void _a(View view, int i, _nk _nkVar, boolean z) {
        boolean z_a;
        com.kc.aw._h _hVar;
        if (view == null || this._b == null) {
            return;
        }
        AdSlot adSlot = this._c;
        if (adSlot != null) {
            adSlot.setCt(i);
        }
        com.kc.aw._h _hVar2 = this._b;
        if (_hVar2 != null) {
            _hVar2._t = _nkVar;
        }
        _dj._a(_hVar2);
        boolean z2 = z && (_hVar = this._b) != null && _hVar._p();
        com.kc.aw._h _hVar3 = this._b;
        if (z2) {
            i = 0;
        }
        _m2 _m2Var = _m1._a;
        if (_m2Var != null) {
            _m2Var._a(view, _hVar3, i);
        }
        _la _laVar_a = _la._a();
        String str = this._a2;
        if (str == null) {
            _laVar_a.getClass();
        } else {
            List list = (List) _laVar_a._c.get(str);
            if (list != null && !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onAdVideoBarClick();
                }
            }
        }
        Context context = view.getContext();
        com.kc.aw._h _hVar4 = this._b;
        AdSlot adSlot2 = this._c;
        _d _dVar = new _d(this);
        if (_hVar4._x) {
            PtgAdProxy.onAdClicked(_hVar4, adSlot2);
        }
        int i2 = _hVar4._a;
        if (i2 != 1) {
            if (i2 == 0) {
                if (context != null) {
                    try {
                        AppInfo appInfo = _hVar4._c;
                        z_a = _cb._a(context, (appInfo == null || TextUtils.isEmpty(appInfo.getPackage_name())) ? "" : _hVar4._c.getPackage_name());
                    } catch (Exception unused) {
                        z_a = false;
                    }
                } else {
                    z_a = false;
                }
                if (!z_a) {
                    _d2._a(context, _hVar4, adSlot2, _dVar);
                } else if (true ^ TextUtils.isEmpty(_hVar4._d)) {
                    int i3 = PtgLaunchActivity._b;
                    try {
                        String str_a = _jj._a(new _jh(_hVar4, adSlot2));
                        Intent intent = new Intent(context, (Class<?>) PtgLaunchActivity.class);
                        intent.setFlags(268435456);
                        intent.putExtra("cache_id", str_a);
                        context.startActivity(intent);
                    } catch (Exception unused2) {
                    }
                } else if (!TextUtils.isEmpty(_hVar4._i)) {
                    PtgWebActivity._a(context, _hVar4);
                }
            } else if (i2 != 2) {
                _dVar._a(PtgErrorCode.SDK_CLICK_ERR_MSG1);
            } else if (!_o9._a(context, _hVar4, adSlot2) && !TextUtils.isEmpty(_hVar4._i)) {
                PtgWebActivity._a(context, _hVar4);
            }
        } else if (true ^ TextUtils.isEmpty(_hVar4._d)) {
            int i4 = PtgLaunchActivity._b;
            String str_a2 = _jj._a(new _jh(_hVar4, adSlot2));
            Intent intent2 = new Intent(context, (Class<?>) PtgLaunchActivity.class);
            intent2.setFlags(268435456);
            intent2.putExtra("cache_id", str_a2);
            context.startActivity(intent2);
        } else if (!TextUtils.isEmpty(_hVar4._i)) {
            PtgWebActivity._a(context, _hVar4);
        }
        _in _inVar = this._E;
        if (_inVar != null) {
            _jw._a(_inVar._i, _inVar._k);
            this._E._a(false);
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x006b  */
    public final void _a(TextView textView) {
        String str;
        boolean z_a;
        if (this._g == 0) {
            Context context = textView.getContext();
            com.kc.aw._h _hVar = this._b;
            boolean z_a2 = false;
            if (context == null || _hVar == null) {
                z_a = false;
            } else {
                try {
                    AppInfo appInfo = _hVar._c;
                    z_a = _cb._a(context, (appInfo == null || TextUtils.isEmpty(appInfo.getPackage_name())) ? "" : _hVar._c.getPackage_name());
                } catch (Exception unused) {
                    z_a = false;
                }
            }
            if (z_a) {
                str = "查看详情";
            } else {
                Context context2 = textView.getContext();
                com.kc.aw._h _hVar2 = this._b;
                if (context2 != null && _hVar2 != null) {
                    try {
                        AppInfo appInfo2 = _hVar2._c;
                        z_a2 = _da._a(_da._a(context2, _da._a((appInfo2 == null || TextUtils.isEmpty(appInfo2.getName())) ? "应用" : _hVar2._c.getName(), ".apk")));
                    } catch (Exception unused2) {
                    }
                }
                str = z_a2 ? b.a.o : "立即下载";
            }
        } else {
            str = "查看详情";
        }
        textView.setText(str);
    }

    public final void _a(PtgRewardVideoPortraitActivity._a _aVar) {
        try {
            PtgRewardVideoPortraitActivity ptgRewardVideoPortraitActivity = _aVar._a;
            this._A = ptgRewardVideoPortraitActivity._a;
            this._C = ptgRewardVideoPortraitActivity._b;
            this._F = ptgRewardVideoPortraitActivity._c;
            this._G = ptgRewardVideoPortraitActivity._d;
            this._H = ptgRewardVideoPortraitActivity._e;
            this._K = ptgRewardVideoPortraitActivity._f;
            this._J = ptgRewardVideoPortraitActivity._g;
            this._I = ptgRewardVideoPortraitActivity._h;
            this._L = ptgRewardVideoPortraitActivity._i;
            this._M = ptgRewardVideoPortraitActivity._j;
            this._N = ptgRewardVideoPortraitActivity._k;
            this._O = ptgRewardVideoPortraitActivity._l;
            this._P = ptgRewardVideoPortraitActivity._m;
            this._Q = ptgRewardVideoPortraitActivity._n;
            this._R = ptgRewardVideoPortraitActivity._o;
            this._S = ptgRewardVideoPortraitActivity._p;
            this._T = ptgRewardVideoPortraitActivity._q;
            this._U = ptgRewardVideoPortraitActivity._r;
            this._V = ptgRewardVideoPortraitActivity._s;
            this._W = ptgRewardVideoPortraitActivity._t;
            this._X = ptgRewardVideoPortraitActivity._v;
            this._Y = ptgRewardVideoPortraitActivity._w;
            this._Z = ptgRewardVideoPortraitActivity._x;
            this._0 = ptgRewardVideoPortraitActivity._y;
            this._1 = ptgRewardVideoPortraitActivity._z;
            PtgRewardVideoPortraitActivity ptgRewardVideoPortraitActivity2 = _aVar._a;
            this._2 = ptgRewardVideoPortraitActivity2._A;
            this._3 = ptgRewardVideoPortraitActivity2._B;
            this._4 = ptgRewardVideoPortraitActivity2._C;
            this._5 = ptgRewardVideoPortraitActivity2._D;
            this._6 = ptgRewardVideoPortraitActivity2._E;
            this._7 = ptgRewardVideoPortraitActivity2._F;
            LinearLayout linearLayout = ptgRewardVideoPortraitActivity2._u;
            this._8 = linearLayout;
            this._9 = ptgRewardVideoPortraitActivity2._G;
            if (linearLayout != null) {
                this._a0 = (PtgShakeView) linearLayout.findViewById(R.id.ptgShakeIv);
            }
            LinearLayout linearLayout2 = this._9;
            if (linearLayout2 != null) {
                this._a1 = (PtgShakeView) linearLayout2.findViewById(R.id.ptgShakeIv);
            }
        } catch (Exception unused) {
        }
    }

    public final void _a(boolean z) {
        _i _iVar;
        if (!z && _aa > 0 && !this._r) {
            _la _laVar_a = _la._a();
            String str = this._a2;
            if (str == null) {
                _laVar_a.getClass();
            } else {
                List list = (List) _laVar_a._c.get(str);
                if (list != null && !list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onVideoResume();
                    }
                }
            }
        }
        _i _iVar2 = this._a5;
        if (_iVar2 != null) {
            _iVar2.removeMessages(0);
        }
        com.kc.aw._h _hVar = this._b;
        if (_hVar == null || !_hVar._x || (_iVar = this._a5) == null) {
            return;
        }
        _iVar.sendEmptyMessage(0);
    }

    public final boolean _a(Activity activity) {
        _la _laVar_a;
        String str;
        String str2;
        this._a2 = activity.getIntent().getStringExtra("VIDEO_ADVERT_ID");
        this._b = (com.kc.aw._h) _la._a()._a.get(this._a2);
        this._c = (AdSlot) _la._a()._b.get(this._a2);
        com.kc.aw._h _hVar = this._b;
        boolean z = false;
        if (_hVar != null) {
            _f4 _f4Var = _hVar._B;
            this._a = _f4Var;
            if (_f4Var != null) {
                this._s = _f4Var._a;
                this._t = _f4Var._b;
                this._u = _f4Var._c;
                this._v = _f4Var._f;
                this._w = _f4Var._g;
            }
            this._D = new _kb();
            this._a2 = String.valueOf(this._b.hashCode());
            com.kc.aw._h _hVar2 = this._b;
            this._g = _hVar2._a;
            this._r = _hVar2._s();
            this._k = this._b._k();
            this._l = this._b._e();
            if (this._r) {
                _k8 _k8Var_l = this._b._l();
                if (_k8Var_l != null) {
                    this._d = _k8Var_l._c;
                    this._e = _k8Var_l._d;
                    this._h = _k8Var_l._a;
                    this._i = _k8Var_l._b;
                }
            } else {
                _j9 _j9Var_f = this._b._f();
                if (_j9Var_f != null) {
                    this._d = _j9Var_f._b;
                    this._e = _j9Var_f._c;
                    String str3 = _j9Var_f._a;
                    this._h = str3;
                    this._i = str3;
                }
                this._t = 0;
            }
            this._j = this._b._i();
            AppInfo appInfo = this._b._c;
            if (appInfo != null) {
                if (!TextUtils.isEmpty(appInfo.getName())) {
                    this._k = appInfo.getName();
                }
                if (!TextUtils.isEmpty(appInfo.getIcon_url())) {
                    this._j = appInfo.getIcon_url();
                }
                this._m = appInfo.getDevelopers();
                StringBuilder sb_a = _jf._a("版本号：");
                sb_a.append(appInfo.getAppVersion());
                this._n = sb_a.toString();
                this._o = appInfo.getFunctionDescUrl();
                this._p = appInfo.getPermissionProtocolUrl();
                this._q = appInfo.getPrivacyProtocolUrl();
            }
            _i6 _i6Var = this._b._z;
            float f = ((_i6Var != null && _i6Var._a() && _i6Var._a()) ? _i6Var._f._e : 0) * 0.7f;
            if (this._u > f) {
                this._u = (int) Math.floor(f);
            }
            com.kc.aw._h _hVar3 = this._b;
            if (_hVar3 != null && _hVar3._a == 0) {
                String str4 = _hVar3._i;
                _c _cVar = this._a8;
                HashMap map = _d2._a;
                if (!TextUtils.isEmpty(str4) && _cVar != null) {
                    String str_c = com.kc.aw.lib.utils._a._c(str4);
                    if (map.containsKey(str_c)) {
                        map.remove(str_c);
                    }
                    map.put(str_c, _cVar);
                }
            }
        }
        if (this._a == null) {
            _laVar_a = _la._a();
            str = this._a2;
            str2 = "advert params exception![videoConfig]";
        } else if (this._b == null) {
            _laVar_a = _la._a();
            str = this._a2;
            str2 = "advert params exception![advertInfo]";
        } else {
            if (this._c != null) {
                if (TextUtils.isEmpty(this._h)) {
                    _laVar_a = _la._a();
                    str = this._a2;
                    str2 = "advert params exception![videoUrl]";
                }
                return !z;
            }
            _laVar_a = _la._a();
            str = this._a2;
            str2 = "advert params exception![adSlot]";
        }
        _laVar_a._a(str, PtgErrorCode.SDK_RESOURCE_ERROR, str2);
        z = true;
        return !z;
    }

    public final void _b(int i) {
        String rewardName;
        int rewardAmount;
        AdErrorImpl adErrorImpl;
        PtgRewardConstant.ServerErr serverErr;
        if (i != 0 || this._y || this._z) {
            return;
        }
        if (1 != this._v) {
            PtgRewardConstant.ServerErr serverErr2 = PtgRewardConstant.ServerErr.DEF;
            _a(serverErr2.getCode(), serverErr2.getMsg(), true);
            return;
        }
        this._z = true;
        AdSlot adSlot = this._c;
        _f4 _f4Var = this._a;
        String str_a = "";
        if (adSlot == null || TextUtils.isEmpty(adSlot.getRewardName())) {
            rewardName = (_f4Var == null || TextUtils.isEmpty(_f4Var._d)) ? "" : _f4Var._d;
        } else {
            rewardName = adSlot.getRewardName();
        }
        AdSlot adSlot2 = this._c;
        _f4 _f4Var2 = this._a;
        if (adSlot2 != null && adSlot2.getRewardAmount() > 0) {
            rewardAmount = adSlot2.getRewardAmount();
        } else if (_f4Var2 == null || (rewardAmount = _f4Var2._e) <= 0) {
            rewardAmount = 0;
        }
        String str = this._w;
        AdSlot adSlot3 = this._c;
        _b _bVar = new _b(this);
        if (_l9._a.get()) {
            return;
        }
        if (!(-1 != _h2._b(PtgAdSdk.getContext()))) {
            adErrorImpl = new AdErrorImpl();
            serverErr = PtgRewardConstant.ServerErr.ERR_NET;
        } else {
            if (!TextUtils.isEmpty(str) && adSlot3 != null) {
                try {
                    str_a = _l9._a(str, _l9._a(adSlot3, rewardName, rewardAmount));
                } catch (Exception e) {
                    AdErrorImpl adErrorImpl2 = new AdErrorImpl();
                    PtgRewardConstant.ServerErr serverErr3 = PtgRewardConstant.ServerErr.ERR_PARAMS;
                    adErrorImpl2._a = serverErr3.getCode();
                    adErrorImpl2._b = serverErr3.getMsg() + " : " + e.getMessage();
                    _bVar.onError(adErrorImpl2);
                }
                if (TextUtils.isEmpty(str_a)) {
                    return;
                }
                Handler handler = new Handler(Looper.getMainLooper());
                _l7 _l7Var = new _l7(new WeakReference(_bVar));
                handler.postDelayed(_l7Var, 3000L);
                _l9._a.set(true);
                _l8 _l8Var = new _l8(handler, _l7Var, _bVar);
                _h1._f _fVar = _h1._a;
                _ee _eeVar = new _ee(str_a);
                _eeVar._d = "GET";
                _eeVar._h = _l8Var;
                _h1._b.offer(_eeVar);
                return;
            }
            adErrorImpl = new AdErrorImpl();
            serverErr = PtgRewardConstant.ServerErr.ERR_BODY;
        }
        adErrorImpl._a = serverErr.getCode();
        adErrorImpl._b = serverErr.getMsg();
        _bVar.onError(adErrorImpl);
    }

    public final void _b(Activity activity) {
        Handler handler;
        _d3._c _cVar;
        Runnable _f1Var;
        ProgressBar progressBar = this._F;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        if (this._r) {
            _k9 _k9Var = new _k9(activity);
            this._B = _k9Var;
            NiceVideoPlayer niceVideoPlayer = this._C;
            int i = this._s;
            int i2 = this._d;
            int i3 = this._e;
            niceVideoPlayer._t = i;
            niceVideoPlayer._u = i2;
            niceVideoPlayer._v = i3;
            niceVideoPlayer.setController(_k9Var);
            String str_a = _hu._a(activity.getApplicationContext())._a(this._h, true);
            this._B.setVisibility(8);
            this._B.setUrl(str_a);
            this._B.setPlayStateChanged(new _lq(this));
            this._B.setProgressListener(new _lr(this));
            this._C.setOnPreparedListener(new _ls(this, activity));
            this._C.setOnCompletionListener(new _lt(this));
            this._C.setOnErrorListener(new _lu(this));
            this._C._e();
            if (PtgAdSdk.getConfig()._b()) {
                String str = TextUtil.isNotEmpty(this._i) ? this._i : this._h;
                _li _liVar = new _li(this, activity);
                AtomicBoolean atomicBoolean = _ez._a;
                if (!TextUtil.isEmpty(str)) {
                    _f1Var = new _f1(str, _liVar);
                    com.kc.aw.lib.utils._d._b(_f1Var);
                }
            } else if (TextUtils.isEmpty(this._i)) {
                _d3 _d3Var = new _d3(activity.getApplicationContext(), new _lk(this, activity));
                String str2 = this._h;
                _d3Var._g = true;
                _d3Var._i = 3000;
                _d3Var._h = true;
                _d3Var.executeOnExecutor(_d3Var._f, str2);
                int i4 = _d3Var._i;
                if (i4 > 0 && (handler = _d3Var._a) != null && (_cVar = _d3Var._l) != null) {
                    handler.postDelayed(_cVar, i4);
                }
            } else {
                _d3 _d3Var2 = new _d3(activity.getApplicationContext(), new _lj(this, activity));
                _d3Var2.executeOnExecutor(_d3Var2._f, this._i);
            }
        } else if (PtgAdSdk.getConfig()._b()) {
            String str3 = this._h;
            _lw _lwVar = new _lw(this, activity);
            AtomicBoolean atomicBoolean2 = _ez._a;
            if (!TextUtil.isEmpty(str3)) {
                _f1Var = new _f2(_lwVar, str3);
                com.kc.aw.lib.utils._d._b(_f1Var);
            }
        } else {
            _d3 _d3Var3 = new _d3(activity, new _lv(this, activity));
            _d3Var3.executeOnExecutor(_d3Var3._f, this._h);
        }
        this._M.setVisibility(0);
        this._X.setVisibility(8);
        if (TextUtils.isEmpty(this._j)) {
            this._N.setVisibility(8);
        } else {
            this._N.setVisibility(0);
            if (PtgAdSdk.getConfig()._b()) {
                _ez._a(this._j, this._N);
            } else {
                new _d3(activity, this._N).execute(this._j);
            }
        }
        this._O.setText(this._k);
        this._P.setText(this._l);
        _a(this._W);
        if (this._g == 0) {
            this._Q.setVisibility(0);
            this._R.setText(this._m);
            this._S.setText(this._n);
            this._T.setOnClickListener(new _g(this));
            this._U.setOnClickListener(new _f(this));
            this._V.setOnClickListener(new _h(this));
        } else {
            this._Q.setVisibility(8);
        }
        this._W.setOnClickListener(new _e(this));
        _m1._a(this._A, this._W, null);
    }

    public final void _b(boolean z) {
        ImageView imageView;
        int i;
        NiceVideoPlayer niceVideoPlayer = this._C;
        if (niceVideoPlayer != null) {
            this._f = z;
            if (z) {
                niceVideoPlayer.setMediaVolume(0);
                imageView = this._L;
                if (imageView == null) {
                    return;
                } else {
                    i = R.drawable.aw_ic_player_mute;
                }
            } else {
                niceVideoPlayer.setMediaVolume(7);
                imageView = this._L;
                if (imageView == null) {
                    return;
                } else {
                    i = R.drawable.aw_ic_player_unmute;
                }
            }
            imageView.setImageResource(i);
        }
    }

    public final void _c(boolean z) {
        LinearLayout linearLayout;
        if (!this._a7) {
            LinearLayout linearLayout2 = this._8;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            linearLayout = this._9;
            if (linearLayout == null) {
                return;
            }
        } else if (this._s != 0) {
            LinearLayout linearLayout3 = this._8;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(0);
            }
            linearLayout = this._9;
            if (linearLayout == null) {
                return;
            }
        } else {
            if (z) {
                LinearLayout linearLayout4 = this._8;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(8);
                }
                LinearLayout linearLayout5 = this._9;
                if (linearLayout5 != null) {
                    linearLayout5.setVisibility(0);
                    return;
                }
                return;
            }
            LinearLayout linearLayout6 = this._8;
            if (linearLayout6 != null) {
                linearLayout6.setVisibility(0);
            }
            linearLayout = this._9;
            if (linearLayout == null) {
                return;
            }
        }
        linearLayout.setVisibility(8);
    }
}

package com.kc.aw.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.kc.aw._8;
import com.kc.aw._cr;
import com.kc.aw._d1;
import com.kc.aw._d2;
import com.kc.aw._h;
import com.kc.aw._h7;
import com.kc.aw._in;
import com.kc.aw._jw;
import com.kc.aw._la;
import com.kc.aw._le;
import com.kc.aw._lg;
import com.kc.aw._ln;
import com.kc.aw._lp;
import com.kc.aw._lz;
import com.kc.aw._m1;
import com.kc.aw._mg;
import com.kc.aw._o6;
import com.kc.aw.component.videoplayer.NiceVideoPlayer;
import com.kc.aw.component.widgets.PlaceholderImageView;
import com.kc.aw.component.widgets.PtgShakeView;
import com.kc.aw.lib.PtgAdSdk;
import com.kc.aw.lib.constants.PtgErrorCode;
import com.kc.aw.lib.core.model.AdErrorImpl;
import com.kc.aw.lib.interf.PtgRewardVideoAd;
import com.kc.aw.lib.model.AppInfo;
import com.kc.aw.provider.PtgApiProvider;
import com.kc.aw.widget.PtgRoundLinearLayout;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class PtgRewardVideoPortraitActivity extends PtgBaseVideoActivity {
    public static final int _J = 0;
    public final _a _H = new _a(this);
    public _lg _I;

    @Keep
    public final class _a implements _le {
        public final PtgRewardVideoPortraitActivity _a;

        public _a(PtgRewardVideoPortraitActivity ptgRewardVideoPortraitActivity) {
            this._a = ptgRewardVideoPortraitActivity;
        }

        public final void _a() {
            PtgRewardVideoPortraitActivity ptgRewardVideoPortraitActivity = this._a;
            ptgRewardVideoPortraitActivity._a = (FrameLayout) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_reward_root);
            ptgRewardVideoPortraitActivity._c = (ProgressBar) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_reward_playable_loading);
            ptgRewardVideoPortraitActivity._e = (ImageView) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_cover);
            ptgRewardVideoPortraitActivity._d = (FrameLayout) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_video_reward_container);
            ptgRewardVideoPortraitActivity._f = (PtgRoundLinearLayout) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_close_layout);
            ptgRewardVideoPortraitActivity._g = (ImageView) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_reward_icon);
            ptgRewardVideoPortraitActivity._h = (TextView) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_top_countdown);
            ptgRewardVideoPortraitActivity._i = (ImageView) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_top_mute);
            ptgRewardVideoPortraitActivity._b = (NiceVideoPlayer) ptgRewardVideoPortraitActivity.findViewById(R.id.ptgVideoNiceVideoPlayer);
            ptgRewardVideoPortraitActivity._j = (LinearLayout) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_bottom_bar);
            ptgRewardVideoPortraitActivity._k = (PlaceholderImageView) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_bottom_bar_icon);
            ptgRewardVideoPortraitActivity._l = (TextView) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_bottom_bar_title);
            ptgRewardVideoPortraitActivity._m = (TextView) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_bottom_bar_subtitle);
            ptgRewardVideoPortraitActivity._n = (LinearLayout) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_app_layout);
            ptgRewardVideoPortraitActivity._o = (TextView) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_app_company_tv);
            ptgRewardVideoPortraitActivity._p = (TextView) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_app_version_tv);
            ptgRewardVideoPortraitActivity._q = (TextView) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_app_function_tv);
            ptgRewardVideoPortraitActivity._r = (TextView) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_app_authority_tv);
            ptgRewardVideoPortraitActivity._s = (TextView) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_app_privacy_tv);
            ptgRewardVideoPortraitActivity._t = (TextView) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_reward_ad_download);
            ptgRewardVideoPortraitActivity._u = (LinearLayout) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_shake_layout);
            ptgRewardVideoPortraitActivity._v = (LinearLayout) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_finished_layout);
            ptgRewardVideoPortraitActivity._w = (PlaceholderImageView) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_finished_ad_icon);
            ptgRewardVideoPortraitActivity._x = (TextView) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_finished_title);
            ptgRewardVideoPortraitActivity._y = (TextView) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_finished_subtitle);
            ptgRewardVideoPortraitActivity._z = (LinearLayout) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_finished_app_layout);
            ptgRewardVideoPortraitActivity._A = (TextView) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_finished_app_company_tv);
            ptgRewardVideoPortraitActivity._B = (TextView) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_finished_app_version_tv);
            ptgRewardVideoPortraitActivity._C = (TextView) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_finished_app_function_tv);
            ptgRewardVideoPortraitActivity._D = (TextView) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_finished_app_authority_tv);
            ptgRewardVideoPortraitActivity._E = (TextView) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_finished_app_privacy_tv);
            int i = R.id.ptg_finished_download;
            ptgRewardVideoPortraitActivity._F = (TextView) ptgRewardVideoPortraitActivity.findViewById(i);
            ptgRewardVideoPortraitActivity._F = (TextView) ptgRewardVideoPortraitActivity.findViewById(i);
            ptgRewardVideoPortraitActivity._G = (LinearLayout) ptgRewardVideoPortraitActivity.findViewById(R.id.ptg_finished_shake_layout);
            try {
                LinearLayout linearLayout = (LinearLayout) ptgRewardVideoPortraitActivity.findViewById(R.id.bar_logo_layout);
                LinearLayout linearLayout2 = (LinearLayout) ptgRewardVideoPortraitActivity.findViewById(R.id.end_logo_layout);
                int i2 = R.id.ptg_sdk_ad_logo_iv;
                ImageView imageView = (ImageView) linearLayout.findViewById(i2);
                ImageView imageView2 = (ImageView) linearLayout2.findViewById(i2);
                _o6._a(imageView);
                _o6._a(imageView2);
            } catch (Exception unused) {
            }
        }
    }

    public final void _a() {
        _cr _crVar = _8._a;
        if (_crVar != null) {
            try {
                if (_crVar.isShowing()) {
                    Context context = _8._a.getContext();
                    if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                        _8._a.dismiss();
                    }
                }
            } catch (Exception unused) {
            } finally {
                _8._a = null;
            }
        }
        _lg _lgVar = this._I;
        if (_lgVar != null) {
            _in _inVar = _lgVar._E;
            if (_inVar != null) {
                _inVar._a(true);
                _inVar._c = null;
                _inVar._d = null;
                _inVar._n = null;
                _lgVar._E = null;
            }
            _lg._aa = 0;
            _h _hVar = _lgVar._b;
            if (_hVar != null && _hVar._a == 0) {
                String str = _hVar._i;
                HashMap map = _d2._a;
                if (!TextUtils.isEmpty(str)) {
                    map.remove(com.kc.aw.lib.utils._a._c(str));
                }
            }
            if (_h7._a == null) {
                synchronized (_h7.class) {
                    try {
                        if (_h7._a == null) {
                            _h7._a = new _h7();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            _h7._a.getClass();
            _lgVar._A = null;
            _lgVar._B = null;
            NiceVideoPlayer niceVideoPlayer = _lgVar._C;
            if (niceVideoPlayer != null) {
                niceVideoPlayer._c();
                _lgVar._C = null;
            }
            _lgVar._F = null;
            _lgVar._G = null;
            _lgVar._H = null;
            _lgVar._I = null;
            _lgVar._K = null;
            _lgVar._L = null;
            _lgVar._M = null;
            _lgVar._N = null;
            _lgVar._O = null;
            _lgVar._P = null;
            _lgVar._Q = null;
            _lgVar._R = null;
            _lgVar._S = null;
            _lgVar._T = null;
            _lgVar._U = null;
            _lgVar._V = null;
            _lgVar._W = null;
            _lgVar._X = null;
            _lgVar._Y = null;
            _lgVar._Z = null;
            _lgVar._0 = null;
            _lgVar._1 = null;
            _lgVar._2 = null;
            _lgVar._3 = null;
            _lgVar._4 = null;
            _lgVar._5 = null;
            _lgVar._6 = null;
            _lgVar._7 = null;
            _lgVar._8 = null;
            _lgVar._9 = null;
            _lgVar._J = null;
            PtgShakeView ptgShakeView = _lgVar._a0;
            if (ptgShakeView != null) {
                ImageView imageView = ptgShakeView._a;
                if (imageView != null) {
                    imageView.clearAnimation();
                }
                _lz _lzVar = ptgShakeView._d;
                if (_lzVar != null) {
                    _lzVar.cancel();
                    ptgShakeView._d = null;
                }
                _lgVar._a0 = null;
            }
            PtgShakeView ptgShakeView2 = _lgVar._a1;
            if (ptgShakeView2 != null) {
                ImageView imageView2 = ptgShakeView2._a;
                if (imageView2 != null) {
                    imageView2.clearAnimation();
                }
                _lz _lzVar2 = ptgShakeView2._d;
                if (_lzVar2 != null) {
                    _lzVar2.cancel();
                    ptgShakeView2._d = null;
                }
                _lgVar._a1 = null;
            }
            _lg._i _iVar = _lgVar._a5;
            if (_iVar != null) {
                _iVar.removeCallbacksAndMessages(null);
            }
            _la _laVar_a = _la._a();
            String str2 = _lgVar._a2;
            if (str2 == null) {
                _laVar_a.getClass();
            } else {
                List list = (List) _laVar_a._c.get(str2);
                if (list != null && !list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onAdClose();
                    }
                }
            }
            _la._a()._b(_lgVar._a2);
            this._I = null;
            if (isFinishing()) {
                return;
            }
        } else if (isFinishing()) {
            return;
        }
        finish();
    }

    public void _b() {
        setRequestedOrientation(1);
        setContentView(R.layout.aw_activity_reward_video_portrait);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
    }

    @Override // com.kc.aw.activity.PtgBaseVideoActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        _la _laVar_a;
        String str;
        AdErrorImpl adErrorImpl;
        String str2 = PtgErrorCode.SDK_RENDER_ERROR_4;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (bundle != null || intent == null) {
            finish();
            return;
        }
        intent.getIntExtra("VIDEO_SCREEN_TYPE", 0);
        _b();
        _lg _lgVar = new _lg();
        this._I = _lgVar;
        _a _aVar = this._H;
        if (_aVar != null) {
            try {
                if (_lgVar._a(this)) {
                    _aVar._a();
                    _lgVar._a(_aVar);
                    if (_lgVar._K != null) {
                        _in _inVar = new _in(_lgVar._b, _lgVar._a4);
                        _lgVar._E = _inVar;
                        FrameLayout frameLayout = _lgVar._A;
                        _inVar._c = frameLayout;
                        _inVar._d = frameLayout;
                        _m1._a(frameLayout, frameLayout, null);
                        _lgVar._b(_lgVar._t == 0);
                        _lgVar._K.setOnClickListener(new _ln(_lgVar, _aVar, this));
                        _lgVar._L.setOnClickListener(new _lp(_lgVar, this));
                        _lgVar._b(this);
                        return;
                    }
                    _la _laVar_a2 = _la._a();
                    str = _lgVar._a2;
                    adErrorImpl = new AdErrorImpl();
                    adErrorImpl._c = PtgApiProvider.providerName;
                    adErrorImpl._d = PtgErrorCode.SDK_RENDER_ERROR;
                    adErrorImpl._e = PtgErrorCode.SDK_RENDER_ERROR_9;
                    adErrorImpl._a = PtgErrorCode.SDK_RENDER_ERROR;
                    _laVar_a = _laVar_a2;
                    str2 = PtgErrorCode.SDK_RENDER_ERROR_9;
                } else {
                    _laVar_a = _la._a();
                    str = _lgVar._a2;
                    adErrorImpl = new AdErrorImpl();
                    adErrorImpl._c = PtgApiProvider.providerName;
                    adErrorImpl._d = PtgErrorCode.SDK_RENDER_ERROR;
                    adErrorImpl._e = PtgErrorCode.SDK_RENDER_ERROR_4;
                    adErrorImpl._a = PtgErrorCode.SDK_RENDER_ERROR;
                }
                adErrorImpl._b = str2;
                _laVar_a._a(str, adErrorImpl);
                _a();
            } catch (Exception e) {
                _la _laVar_a3 = _la._a();
                String str3 = _lgVar._a2;
                AdErrorImpl adErrorImpl2 = new AdErrorImpl();
                adErrorImpl2._c = PtgApiProvider.providerName;
                adErrorImpl2._d = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl2._e = PtgErrorCode.SDK_RENDER_ERROR_1;
                adErrorImpl2._a = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl2._b = e.getMessage();
                _laVar_a3._a(str3, adErrorImpl2);
                _a();
            }
        }
    }

    @Override // android.app.Activity
    public final void onPause() {
        _in _inVar;
        super.onPause();
        _lg _lgVar = this._I;
        if (_lgVar == null || (_inVar = _lgVar._E) == null) {
            return;
        }
        _mg._a(_inVar._b);
    }

    @Override // android.app.Activity
    public final void onResume() {
        AppInfo appInfo;
        boolean z;
        ApplicationInfo applicationInfo;
        super.onResume();
        _lg _lgVar = this._I;
        if (_lgVar != null) {
            _in _inVar = _lgVar._E;
            if (_inVar != null) {
                _inVar._b();
            }
            Context context = PtgAdSdk.getContext();
            _h _hVar = _lgVar._b;
            HashMap map = _d2._a;
            if (!TextUtils.isEmpty(context == null ? "" : _jw._c(context, "uninstall_apk_path"))) {
                Handler handler = _d2._d;
                _d2._a _aVar = _d2._e;
                handler.removeCallbacks(_aVar);
                handler.postDelayed(_aVar, 3000L);
                return;
            }
            if (_hVar == null || _hVar._a != 0 || (appInfo = _hVar._c) == null) {
                return;
            }
            String package_name = appInfo.getPackage_name();
            if (TextUtils.isEmpty(package_name)) {
                return;
            }
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(package_name, 1);
                z = (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 8388608) == 0 || packageInfo.versionCode <= 0) ? false : true;
            } catch (PackageManager.NameNotFoundException unused) {
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (z) {
                com.kc.aw.lib.utils._d._c(new _d1(_hVar._i, _hVar._d()));
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        NiceVideoPlayer niceVideoPlayer;
        NiceVideoPlayer niceVideoPlayer2;
        super.onWindowFocusChanged(z);
        _lg _lgVar = this._I;
        if (_lgVar != null) {
            if (z) {
                if (_lgVar._r && (niceVideoPlayer2 = _lgVar._C) != null && !_lgVar._x) {
                    niceVideoPlayer2._d();
                }
                _lgVar._a(false);
                return;
            }
            if (_lgVar._r && (niceVideoPlayer = _lgVar._C) != null) {
                if (niceVideoPlayer._h == 3) {
                    niceVideoPlayer._d.pause();
                    niceVideoPlayer._h = 4;
                    niceVideoPlayer._a._a(4);
                }
                if (niceVideoPlayer._h == 5) {
                    niceVideoPlayer._d.pause();
                    niceVideoPlayer._h = 6;
                    niceVideoPlayer._a._a(6);
                }
                if (!niceVideoPlayer._r && niceVideoPlayer._h == 1) {
                    niceVideoPlayer._s = true;
                    niceVideoPlayer._h = 4;
                    niceVideoPlayer._a._a(4);
                }
            }
            if (_lg._aa > 0 && !_lgVar._r) {
                _la _laVar_a = _la._a();
                String str = _lgVar._a2;
                if (str == null) {
                    _laVar_a.getClass();
                } else {
                    List list = (List) _laVar_a._c.get(str);
                    if (list != null && !list.isEmpty()) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onVideoPause();
                        }
                    }
                }
            }
            _lg._i _iVar = _lgVar._a5;
            if (_iVar != null) {
                _iVar.removeMessages(0);
            }
        }
    }
}

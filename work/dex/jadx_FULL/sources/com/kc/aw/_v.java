package com.kc.aw;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kc.aw.lib.model.AdSlot;
import com.kc.aw.lib.model.PtgAdLoadType;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class _v implements AdSlot {
    public int _A;
    public long _C;
    public long _F;
    public _c9 _G;
    public boolean _L;
    public int _M;
    public _at _N;
    public String _S;
    public String _a;
    public String _b;
    public String _c;
    public int _d;
    public int _e;
    public int _i;
    public int _j;
    public _cl _m;
    public WeakReference<ViewGroup> _n;
    public WeakReference<ViewGroup> _o;
    public long _p;
    public int _q;
    public List<View> _r;
    public List<View> _s;
    public int _t;
    public _nr _u;
    public int _v;
    public boolean _w;
    public boolean _x;
    public String _y;
    public boolean _z;
    public float _f = 0.0f;
    public float _g = 0.0f;
    public boolean _l = true;
    public int _B = 1;
    public PtgAdLoadType _D = PtgAdLoadType.UNKNOWN;
    public boolean _E = true;
    public String _H = "";
    public int _I = 0;
    public String _J = "";
    public String _K = "";
    public float _O = 10.0f;
    public float _P = 10.0f;
    public float _Q = 10.0f;
    public float _R = 10.0f;
    public int _T = 0;
    public int _h = 1;
    public boolean _k = true;

    public _v() {
    }

    public _v(int i) {
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final void bind(_cl _clVar) {
        setDispatchPolicyCustomerItem(_clVar);
        setOriginalAdContainer(getAdContainer());
        this._b = _clVar._P;
        this._c = _clVar._Q;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public AdSlot createCustomerAdSlot(_cl _clVar) {
        AdSlot adSlotWrite = write(new _by(this));
        adSlotWrite.bind(_clVar);
        return adSlotWrite;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final ViewGroup getAdContainer() {
        WeakReference<ViewGroup> weakReference = this._n;
        return weakReference == null ? getOriginalAdContainer() : weakReference.get();
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final int getAdCount() {
        return this._h;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final PtgAdLoadType getAdLoadType() {
        return this._D;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final long getBasePrice() {
        return this._C;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final _at getBidAdm() {
        return this._N;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final int getCategoryType() {
        return this._t;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final List<View> getClickView() {
        return this._r;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final String getCodeId() {
        return this._c;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final long getCountdownTime() {
        return this._F;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final List<View> getCreativeView() {
        return this._s;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final int getCt() {
        return this._M;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final int getCurrentReqLayer() {
        return this._B;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final _c9 getDeviceInfo() {
        return this._G;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final _cl getDispatchPolicyCustomerItem() {
        return this._m;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final float getExpressViewAcceptedHeight() {
        return this._g;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final float getExpressViewAcceptedWidth() {
        return this._f;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final String getExpressViewColor() {
        return this._S;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final float getExpressViewPaddingBottom() {
        return this._R;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final float getExpressViewPaddingLeft() {
        return this._O;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final float getExpressViewPaddingRight() {
        return this._Q;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final float getExpressViewPaddingTop() {
        return this._P;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final int getImgAcceptedHeight() {
        return this._e;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final int getImgAcceptedWidth() {
        return this._d;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final String getInteractionAdvUrl() {
        return this._y;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final String getMediaExtra() {
        return this._J;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final int getNativeAdType() {
        return this._j;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final int getOrientation() {
        return this._i;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final ViewGroup getOriginalAdContainer() {
        WeakReference<ViewGroup> weakReference = this._o;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final int getPosition(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return (i == 3 || i == 4 || i == 7 || i == 8) ? 5 : 3;
        }
        return 4;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final String getPtgSlotID() {
        return this._a;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final long getRandomTime() {
        return this._p;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final int getRandomToken() {
        return this._q;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final String getReqId() {
        _nr _nrVar = this._u;
        return _nrVar != null ? _nrVar._h : "";
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final int getRewardAmount() {
        return this._I;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final String getRewardName() {
        return this._H;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final int getStype() {
        return this._v;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final int getTimeoutMs() {
        return this._T;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final _nr getTrackingData() {
        return this._u;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final int getUsedFor() {
        return this._A;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final String getUserID() {
        return this._K;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final String getVendorId() {
        return this._b;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final boolean isAdExposed() {
        return this._L;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final boolean isAutoPlay() {
        return this._k;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final boolean isConcurrent() {
        return this._w;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final boolean isCountdownVisibility() {
        return this._E;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final boolean isPlayMuted() {
        return this._l;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final boolean isSelfRender() {
        return this._z;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final boolean isUniqueReq() {
        return this._x;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final void setAdContainer(ViewGroup viewGroup) {
        this._n = new WeakReference<>(viewGroup);
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final void setAdCount(int i) {
        this._h = i;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final void setAdExposed(boolean z) {
        this._L = z;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final void setAdLoadType(PtgAdLoadType ptgAdLoadType) {
        this._D = ptgAdLoadType;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final void setBasePrice(long j) {
        this._C = j;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final void setCategoryType(int i) {
        this._t = i;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final void setCodeID(String str) {
        this._c = str;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final void setConcurrent(boolean z) {
        this._w = z;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final void setConsumerPrice(int i) {
        _cl _clVar = this._m;
        if (_clVar != null) {
            long j = i;
            _clVar._h = (long) (_clVar._g * j);
            _clVar._i = j;
        }
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final void setCountdownTime(long j) {
        this._F = j;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final void setCountdownVisibility(boolean z) {
        this._E = z;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final void setCt(int i) {
        this._M = i;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final void setDeviceInfo(_c9 _c9Var) {
        if (_c9Var != null) {
            _m4._a = _c9Var;
        }
        this._G = _c9Var;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final void setDispatchPolicyCustomerItem(_cl _clVar) {
        this._m = _clVar;
        this._b = _clVar._P;
        this._c = _clVar._Q;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final void setExpressViewColor(String str) {
        this._S = str;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final void setInteractionAdvUrl(String str) {
        this._y = str;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final void setNativeAdType(int i) {
        this._j = i;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final void setNextLayer(int i) {
        this._B = i;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final void setOriginalAdContainer(ViewGroup viewGroup) {
        this._o = new WeakReference<>(viewGroup);
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final void setPtgSlotID(String str) {
        this._a = str;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final void setRandomTime(long j) {
        this._p = j;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final void setRandomToken(int i) {
        this._q = i;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final void setStype(int i) {
        this._v = i;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final void setTimeoutMs(int i) {
        this._T = i;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final void setTrackingData(_nr _nrVar) {
        this._u = _nrVar;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final void setUniqueReq(boolean z) {
        this._x = z;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final void setVendorId(String str) {
        this._b = str;
    }

    public final String toString() {
        StringBuilder sb_a = _mm._a(_jf._a("AdSlot{mCodeId='"), this._c, '\'', ", mImgAcceptedWidth=");
        sb_a.append(this._d);
        sb_a.append(", mImgAcceptedHeight=");
        sb_a.append(this._e);
        sb_a.append(", mExpressViewAcceptedWidth=");
        sb_a.append(this._f);
        sb_a.append(", mExpressViewAcceptedHeight=");
        sb_a.append(this._g);
        sb_a.append(", mAdCount=");
        sb_a.append(this._h);
        sb_a.append(", mRewardName='");
        StringBuilder sb_a2 = _mm._a(sb_a, this._H, '\'', ", mRewardAmount=");
        sb_a2.append(this._I);
        sb_a2.append(", mMediaExtra='");
        StringBuilder sb_a3 = _mm._a(_mm._a(sb_a2, this._J, '\'', ", mUserID='"), this._K, '\'', ", mOrientation=");
        sb_a3.append(this._i);
        sb_a3.append(", mNativeAdType=");
        sb_a3.append(this._j);
        sb_a3.append(", mIsAutoPlay=");
        sb_a3.append(this._k);
        sb_a3.append('}');
        return sb_a3.toString();
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public final void withBid(String str) {
        _at _atVar;
        if (TextUtils.isEmpty(str)) {
            _atVar = null;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                _atVar = new _at();
                _atVar._a = jSONObject.optString("reqid");
                _atVar._c = jSONObject.optString("price");
                _atVar._b = jSONObject.optString("data");
            } catch (Exception unused) {
                _atVar = null;
            }
        }
        this._N = _atVar;
    }

    @Override // com.kc.aw.lib.model.AdSlot
    public AdSlot write(AdSlot adSlot) {
        if (adSlot instanceof _v) {
            _v _vVar = (_v) adSlot;
            _vVar._a = this._a;
            _vVar._b = this._b;
            _vVar._c = this._c;
            _vVar._d = this._d;
            _vVar._e = this._e;
            _vVar._f = this._f;
            _vVar._g = this._g;
            _vVar._h = this._h;
            _vVar._H = this._H;
            _vVar._I = this._I;
            _vVar._J = this._J;
            _vVar._K = this._K;
            _vVar._i = this._i;
            _vVar._j = this._j;
            _vVar._k = this._k;
            _vVar._l = this._l;
            _cl _clVar = this._m;
            _vVar._m = _clVar;
            _vVar._n = this._n;
            _vVar._o = this._o;
            _vVar._p = this._p;
            _vVar._q = this._q;
            _vVar._r = this._r;
            _vVar._s = this._s;
            _vVar._t = this._t;
            _vVar._u = this._u;
            _vVar._v = this._v;
            _vVar._w = this._w;
            _vVar._x = this._x;
            _vVar._y = this._y;
            _vVar._z = this._z;
            _vVar._A = this._A;
            _vVar._B = this._B;
            _vVar._G = this._G;
            _vVar._C = this._C;
            _vVar._M = this._M;
            _vVar._D = this._D;
            _vVar._E = this._E;
            _vVar._F = this._F;
            _vVar._N = this._N;
            _vVar._O = this._O;
            _vVar._P = this._P;
            _vVar._Q = this._Q;
            _vVar._R = this._R;
            _vVar._S = this._S;
            _vVar._T = this._T;
            if (_clVar != null) {
                _vVar.bind(_clVar);
            }
        }
        return adSlot;
    }
}

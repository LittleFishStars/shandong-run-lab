package com.kc.aw;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import com.kc.aw.component.videoplayer.NiceVideoPlayer;
import com.kc.aw.lib.interf.PtgRewardVideoAd;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _k9 extends _h6 implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    public ImageView _l;
    public ImageView _m;
    public LinearLayout _n;
    public TextView _o;
    public ProgressBar _p;
    public LinearLayout _q;
    public TextView _r;
    public _es _s;
    public long _t;
    public _b _u;
    public _a _v;

    @Keep
    public interface _a {
    }

    @Keep
    public interface _b {
        void _a(long j, long j2);
    }

    public _k9(Context context) {
        super(context);
        _f();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.kc.aw._h6
    public final void _a(int i) {
        _la _laVar_a;
        if (i == -1) {
            _a();
            this._q.setVisibility(0);
        } else if (i != 1) {
            switch (i) {
                case 3:
                    this._n.setVisibility(8);
                    _d();
                    break;
                case 4:
                    this._n.setVisibility(8);
                    _a();
                    break;
                case 5:
                    this._n.setVisibility(0);
                    this._o.setText("正在缓冲中...");
                    break;
                case 6:
                    this._o.setText("正在缓冲中...");
                    break;
                case 7:
                    _a();
                    this._l.setVisibility(0);
                    _es _esVar = this._s;
                    if (_esVar != null) {
                        long duration = _esVar.getDuration();
                        _b _bVar = this._u;
                        if (_bVar != null) {
                            _bVar._a(duration, duration);
                        }
                    }
                    break;
                case 8:
                    _d();
                    break;
            }
        } else {
            this._l.setVisibility(8);
            this._n.setVisibility(0);
            this._o.setText("正在准备...");
            this._q.setVisibility(8);
            this._m.setVisibility(8);
        }
        _a _aVar = this._v;
        if (_aVar != null) {
            _lq _lqVar = (_lq) _aVar;
            if (4 == i) {
                _laVar_a = _la._a();
                String str = _lqVar._a._a2;
                if (str != null) {
                    List list = (List) _laVar_a._c.get(str);
                    if (list == null || list.isEmpty()) {
                        return;
                    }
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onVideoPause();
                    }
                    return;
                }
            } else {
                if (3 == i || 8 != i) {
                    return;
                }
                _laVar_a = _la._a();
                String str2 = _lqVar._a._a2;
                if (str2 != null) {
                    List list2 = (List) _laVar_a._c.get(str2);
                    if (list2 == null || list2.isEmpty()) {
                        return;
                    }
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        ((PtgRewardVideoAd.RewardAdInteractionListener) it2.next()).onVideoResume();
                    }
                    return;
                }
            }
            _laVar_a.getClass();
        }
    }

    @Override // com.kc.aw._h6
    public final void _b() {
    }

    @Override // com.kc.aw._h6
    public final void _c() {
        _a();
        ImageView imageView = this._m;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        ImageView imageView2 = this._l;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        LinearLayout linearLayout = this._n;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        LinearLayout linearLayout2 = this._q;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
    }

    @Override // com.kc.aw._h6
    public final void _e() {
        _b _bVar;
        long currentPosition = this._s.getCurrentPosition();
        long duration = this._s.getDuration();
        if (this._t != currentPosition && (_bVar = this._u) != null) {
            _bVar._a(duration, currentPosition);
        }
        this._t = currentPosition;
        ProgressBar progressBar = this._p;
        if (progressBar != null) {
            progressBar.setProgress((int) ((currentPosition * 100.0f) / duration));
        }
    }

    public final void _f() {
        LayoutInflater.from(getContext()).inflate(R.layout.aw_video_palyer_controller, (ViewGroup) this, true);
        this._m = (ImageView) findViewById(R.id.ptgVideoCenterStart);
        this._l = (ImageView) findViewById(R.id.ptgVideoImage);
        this._n = (LinearLayout) findViewById(R.id.ptgVideoLoading);
        this._o = (TextView) findViewById(R.id.ptgVideoLoadText);
        this._p = (ProgressBar) findViewById(R.id.ptgVideoChangePositionProgress);
        this._q = (LinearLayout) findViewById(R.id.ptgVideoError);
        this._r = (TextView) findViewById(R.id.ptgVideoRetry);
        this._m.setOnClickListener(this);
        this._r.setOnClickListener(this);
    }

    @Override // com.kc.aw._h6
    public ImageView getImageView() {
        return this._l;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view != this._m) {
            if (view == this._r) {
                ((NiceVideoPlayer) this._s)._d();
            }
        } else {
            NiceVideoPlayer niceVideoPlayer = (NiceVideoPlayer) this._s;
            if (niceVideoPlayer._h == 0) {
                niceVideoPlayer._e();
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStartTrackingTouch(SeekBar seekBar) {
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0016  */
    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public final void onStopTrackingTouch(SeekBar seekBar) {
        NiceVideoPlayer niceVideoPlayer = (NiceVideoPlayer) this._s;
        int i = niceVideoPlayer._h;
        if (i == 6) {
            niceVideoPlayer._d();
        } else {
            if (i == 4) {
                niceVideoPlayer._d();
            }
        }
        long duration = (long) ((this._s.getDuration() * ((long) seekBar.getProgress())) / 100.0f);
        MediaPlayer mediaPlayer = ((NiceVideoPlayer) this._s)._d;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo((int) duration);
        }
    }

    @Override // com.kc.aw._h6
    public void setImage(int i) {
        this._l.setImageResource(i);
    }

    @Override // com.kc.aw._h6
    public void setNiceVideoPlayer(_es _esVar) {
        super.setNiceVideoPlayer(_esVar);
        this._s = _esVar;
    }

    public void setPlayStateChanged(_a _aVar) {
        this._v = _aVar;
    }

    public void setProgressListener(_b _bVar) {
        this._u = _bVar;
    }

    public void setUrl(String str) {
        _es _esVar;
        if (str == null || (_esVar = this._s) == null) {
            return;
        }
        NiceVideoPlayer niceVideoPlayer = (NiceVideoPlayer) _esVar;
        niceVideoPlayer._j = str;
        niceVideoPlayer._k = null;
    }
}

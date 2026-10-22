package com.kc.aw;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.ipd.dsp.internal.l0.g;
import com.kc.aw.component.widgets.PlaceholderImageView;
import com.kc.aw.lib.doodle.Doodle;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _ez {
    public static final AtomicBoolean _a = new AtomicBoolean(false);
    public static final Handler _b = new Handler(Looper.getMainLooper());

    @Keep
    public final class _a implements _mk {
        public final ImageView _a;

        public _a(ImageView imageView) {
            this._a = imageView;
        }

        @Override // com.kc.aw._mk
        public final void _a(Object obj) {
            if (obj instanceof Bitmap) {
                this._a.setImageBitmap((Bitmap) obj);
            }
        }
    }

    public static void _a(Context context) {
        if (_a.compareAndSet(false, true)) {
            _o2._a = context.getApplicationContext();
            File file = new File(context.getCacheDir(), "ptg_ad_cache");
            if (!file.exists() && !file.mkdirs()) {
                file = context.getCacheDir();
            }
            Doodle.config().getClass();
            _bn._b = g.f;
            if (20971520 <= Runtime.getRuntime().maxMemory() / 2) {
                _bn._c = 20971520L;
            }
            _fu._a = _co._a;
            _bn._a = file.getPath();
            com.kc.aw.lib.utils._d._b _bVar = com.kc.aw.lib.utils._d._a;
            if (_bVar != null) {
                com.kc.aw.lib.doodle._d._e = _bVar;
            } else {
                com.kc.aw.lib.doodle._d._a _aVar = com.kc.aw.lib.doodle._d._a;
            }
            _dy _dyVar = _dy._a;
            if (_bn._d == null) {
                _bn._d = new ArrayList(1);
            }
            _bn._d.add(_dyVar);
            _a0 _a0Var = _a0._a;
            if (_bn._d == null) {
                _bn._d = new ArrayList(1);
            }
            _bn._d.add(_a0Var);
        }
    }

    public static void _a(ImageView imageView, String str, int i, int i2) {
        if (imageView == null || str == null || str.isEmpty()) {
            return;
        }
        _l2 _l2VarLoad = Doodle.load(str);
        _l2VarLoad._d = i;
        _l2VarLoad._e = i2;
        _l2VarLoad._h = false;
        _l2VarLoad._n = new _a(imageView);
        _l2VarLoad._a(i, i2);
    }

    public static void _a(String str, _i3 _i3Var) {
        if (str == null || str.isEmpty()) {
            return;
        }
        _l2 _l2VarLoad = Doodle.load(str);
        _l2VarLoad._j = 1;
        _l2VarLoad._n = new _f3(_i3Var);
        _l2VarLoad._a(_l2VarLoad._d, _l2VarLoad._e);
    }

    public static void _a(String str, PlaceholderImageView placeholderImageView) {
        int width;
        int height;
        int i;
        int i2;
        int i3;
        _b5 _b5Var;
        if (placeholderImageView == null || str == null || str.isEmpty()) {
            return;
        }
        _l2 _l2VarLoad = Doodle.load(str);
        if (_l2VarLoad._f == _b5.NOT_SET) {
            switch (_b5._a._a[placeholderImageView.getScaleType().ordinal()]) {
                case 1:
                    _b5Var = _b5.MATRIX;
                    break;
                case 2:
                    _b5Var = _b5.CENTER;
                    break;
                case 3:
                case 4:
                case 5:
                    _b5Var = _b5.FIT_CENTER;
                    break;
                case 6:
                    _b5Var = _b5.CENTER_CROP;
                    break;
                default:
                    _b5Var = _b5.CENTER_INSIDE;
                    break;
            }
            _l2VarLoad._f = _b5Var;
        }
        _l2VarLoad._o = new WeakReference<>(placeholderImageView);
        if (_l2VarLoad._f != _b5.NO_CLIP) {
            int i4 = _l2VarLoad._d;
            if (i4 > 0 && (i3 = _l2VarLoad._e) > 0) {
                _l2VarLoad._a(i4, i3);
                return;
            }
            if (placeholderImageView.getWidth() <= 0 || placeholderImageView.getHeight() <= 0) {
                ViewGroup.LayoutParams layoutParams = placeholderImageView.getLayoutParams();
                if (layoutParams != null && ((i = layoutParams.width) > 0 || i == -2) && ((i2 = layoutParams.height) > 0 || i2 == -2)) {
                    ViewGroup.LayoutParams layoutParams2 = placeholderImageView.getLayoutParams();
                    width = layoutParams2.width;
                    height = layoutParams2.height;
                    if (width >= 0 || height >= 0) {
                        if (width <= 0) {
                            if (_o2._d == null) {
                                synchronized (_o2.class) {
                                    try {
                                        if (_o2._d == null) {
                                            _o2._a();
                                        }
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                            }
                            width = _o2._d.x;
                        }
                        if (height <= 0) {
                            if (_o2._d == null) {
                                synchronized (_o2.class) {
                                    try {
                                        if (_o2._d == null) {
                                            _o2._a();
                                        }
                                    } catch (Throwable th2) {
                                        throw th2;
                                    }
                                }
                            }
                            height = _o2._d.y;
                        }
                    }
                } else if (placeholderImageView.getWindowToken() == null) {
                    placeholderImageView.getViewTreeObserver().addOnPreDrawListener(new _l1(_l2VarLoad));
                    return;
                }
            } else {
                width = placeholderImageView.getWidth();
                height = placeholderImageView.getHeight();
            }
            _l2VarLoad._a(width, height);
            return;
        }
        _l2VarLoad._a(0, 0);
    }
}

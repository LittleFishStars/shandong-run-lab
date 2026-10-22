package com.kc.aw;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import com.kc.openset.R;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _br {
    public static volatile boolean _a;
    public static final LinkedHashMap<View, _l2> _b = new LinkedHashMap<>();
    public static final _a _c = new _a();

    @Keep
    public static final class _a implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            _br._a(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            _br._c(view);
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0016  */
    public static void _a(View view) {
        Animatable animatable;
        Object obj;
        try {
            if (view instanceof ImageView) {
                Drawable drawable = ((ImageView) view).getDrawable();
                if (drawable instanceof Animatable) {
                    obj = drawable;
                    obj = view;
                    animatable = (Animatable) obj;
                } else {
                    obj = view;
                    animatable = null;
                }
            } else if (view instanceof Animatable) {
                obj = view;
                animatable = (Animatable) obj;
            } else {
                obj = view;
                animatable = null;
            }
            if (animatable == null || animatable.isRunning()) {
                return;
            }
            animatable.start();
        } catch (Throwable th) {
            _fu._a("Controller", th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void _a(View view, Drawable drawable) {
        if (drawable != null) {
            if (view instanceof ImageView) {
                ((ImageView) view).setImageDrawable(drawable);
            } else if (view instanceof _bx) {
                ((_bx) view)._c();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:137:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:14:0x002b  */
    /* JADX WARN: Code duplicated, block: B:16:0x0037 A[PHI: r4
      0x0037: PHI (r4v13 android.content.Context) = (r4v12 android.content.Context), (r4v35 android.content.Context), (r4v38 android.content.Context) binds: [B:7:0x0015, B:15:0x0035, B:13:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:17:0x003a  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:51:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:53:0x00b6  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.View, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v20, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v27 */
    public static void _a(_l2 _l2Var) {
        ?? r0;
        Object obj;
        boolean z;
        boolean z2;
        Activity activity;
        boolean z3;
        WeakReference<View> weakReference = _l2Var._o;
        boolean z4 = false;
        Object obj_b = null;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view != 0) {
                Context context = view.getContext();
                if (context instanceof Activity) {
                    r0 = view;
                    activity = (Activity) context;
                } else if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext() instanceof Activity) {
                        r0 = view;
                        context = contextWrapper.getBaseContext();
                    } else {
                        r0 = view;
                        r0 = view;
                        context = view.getRootView().getContext();
                        if (context instanceof Activity) {
                            activity = null;
                        }
                    }
                    r0 = view;
                    activity = (Activity) context;
                } else {
                    r0 = view;
                    r0 = view;
                    context = view.getRootView().getContext();
                    if (context instanceof Activity) {
                        activity = null;
                    } else {
                        r0 = view;
                        activity = (Activity) context;
                    }
                }
                if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                    _fu._a("Controller", new Exception("Activity not available"));
                } else {
                    if (_l2Var._l == 0) {
                        _l2Var._l = System.identityHashCode(activity);
                    }
                    Object tag = view.getTag(R.id.aw_doodle_view_tag);
                    if (tag instanceof _l2) {
                        _l2 _l2Var2 = (_l2) tag;
                        if (_l2Var._a().equals(_l2Var2._a())) {
                            z3 = true;
                        } else {
                            WeakReference<View> weakReference2 = _l2Var2._o;
                            if (weakReference2 != null) {
                                _c(weakReference2.get());
                                _l2Var2._o = null;
                            }
                            WeakReference<com.kc.aw.lib.doodle._f> weakReference3 = _l2Var2._p;
                            if (weakReference3 != null) {
                                _l2Var2._p = null;
                                com.kc.aw.lib.doodle._f _fVar = weakReference3.get();
                                if (_fVar != null && !_fVar._d.get()) {
                                    _fVar._d.set(true);
                                    try {
                                        _fVar._a.cancel(true);
                                    } catch (Throwable unused) {
                                    }
                                }
                            }
                        }
                        if (z3) {
                            if (view instanceof ImageView) {
                                ((ImageView) view).setImageDrawable(null);
                            } else if (view instanceof _bx) {
                                ((_bx) view)._c();
                            }
                            view.setTag(R.id.aw_doodle_view_tag, null);
                            r0 = view;
                        }
                    } else if (tag != null) {
                        throw new IllegalArgumentException("Invalid tag type");
                    }
                    z3 = false;
                    if (z3) {
                        if (view instanceof ImageView) {
                            ((ImageView) view).setImageDrawable(null);
                        } else if (view instanceof _bx) {
                            ((_bx) view)._c();
                        }
                        view.setTag(R.id.aw_doodle_view_tag, null);
                        r0 = view;
                    }
                }
                r0 = 0;
            }
            if (r0 == 0) {
                return;
            }
        } else {
            r0 = 0;
        }
        if (TextUtils.isEmpty(_l2Var._b)) {
            _mk _mkVar = _l2Var._n;
            if (_mkVar != null) {
                _mkVar._a(null);
                return;
            }
            return;
        }
        Bitmap bitmap_a = _g5._a(_l2Var._a());
        _l2._a _aVar = _l2Var._m;
        if (_aVar != null && (bitmap_a != null || _aVar._b == 0)) {
            _aVar._a = bitmap_a;
            return;
        }
        if (bitmap_a != null) {
            _a(_l2Var, r0, bitmap_a, true);
            return;
        }
        _oa _oaVar = _g5._d;
        _az _azVar_a = _l2Var._a();
        synchronized (_oaVar) {
            Reference<? extends Object> referencePoll = _oaVar._b.poll();
            while (true) {
                _oa._a _aVar2 = (_oa._a) referencePoll;
                if (_aVar2 == null) {
                    break;
                }
                _oa._a _aVar3 = (_oa._a) _oaVar._a.get(_aVar2._a);
                if (_aVar3 != null && _aVar3.get() == null) {
                    _oaVar._a.remove(_aVar2._a);
                }
                referencePoll = _oaVar._b.poll();
            }
            _oa._a _aVar4 = (_oa._a) _oaVar._a.get(_azVar_a);
            obj = _aVar4 != null ? _aVar4.get() : null;
        }
        if (obj != null) {
            _a(_l2Var, r0, obj, true);
            return;
        }
        if (r0 != 0) {
            if (r0 instanceof ImageView) {
                obj_b = ((ImageView) r0).getDrawable();
            } else if (r0 instanceof _bx) {
                obj_b = ((_bx) r0)._b();
            }
            if ((obj_b instanceof Animatable) && !_a) {
                ((Animatable) obj_b).start();
                r0.addOnAttachStateChangeListener(_c);
            }
        }
        if (r0 != 0 && _a) {
            synchronized (_br.class) {
                try {
                    _b.put((View) r0, _l2Var);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        if (_l2Var._b.startsWith("http")) {
            _az _azVar_a2 = _l2Var._a();
            com.kc.aw.lib.doodle._a _aVar5 = com.kc.aw.lib.doodle._b._a;
            synchronized (_aVar5) {
                HashMap map = _aVar5._h;
                z2 = map != null && map.containsKey(_azVar_a2);
            }
            if (z2) {
                z = false;
            } else {
                z = true;
            }
        } else {
            z = false;
        }
        com.kc.aw.lib.doodle._f _fVar2 = new com.kc.aw.lib.doodle._f(_l2Var, r0, z);
        int i = _l2Var._l;
        if (_fVar2._c == 1) {
            if (i != 0) {
                synchronized (_fq.class) {
                    try {
                        SparseArray<_fq._a> sparseArray = _fq._a;
                        _fq._a _aVar6 = sparseArray.get(i);
                        if (_aVar6 == null) {
                            _aVar6 = new _fq._a();
                            sparseArray.put(i, _aVar6);
                        }
                        Iterator<WeakReference<com.kc.aw.lib.doodle._c>> it = _aVar6._a.iterator();
                        while (it.hasNext()) {
                            if (it.next().get() == _fVar2) {
                                z4 = true;
                                break;
                            }
                        }
                        if (!z4) {
                            _aVar6._a.add(new WeakReference<>(_fVar2));
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            _fVar2._f = i;
            _fVar2._c = 2;
            com.kc.aw.lib.doodle._d._b _bVar = com.kc.aw.lib.doodle._d._c;
            _az _azVar_d = _fVar2._d();
            com.kc.aw.lib.doodle._c._a _aVar7 = _fVar2._a;
            boolean z5 = _fVar2._g;
            synchronized (_bVar) {
                if (_aVar7 != null) {
                    com.kc.aw.lib.doodle._e _eVar = new com.kc.aw.lib.doodle._e(_bVar, _aVar7, z5, _azVar_d);
                    HashSet hashSet = com.kc.aw.lib.doodle._d._b._a;
                    if (hashSet.contains(_azVar_d)) {
                        HashMap map2 = com.kc.aw.lib.doodle._d._b._b;
                        LinkedList linkedList = (LinkedList) map2.get(_azVar_d);
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            map2.put(_azVar_d, linkedList);
                        }
                        linkedList.offer(_eVar);
                    } else {
                        hashSet.add(_azVar_d);
                        (z5 ? com.kc.aw.lib.doodle._d._b : com.kc.aw.lib.doodle._d._a).execute(_eVar);
                    }
                }
            }
        }
        if (_aVar == null || _fVar2._b || _fVar2._d.get()) {
            return;
        }
        try {
            _aVar._a = (Bitmap) _fVar2._a.get(Long.valueOf(_aVar._b).longValue(), TimeUnit.MILLISECONDS);
        } catch (Throwable th3) {
            _fu._a("Controller", th3);
        }
        if (_fVar2._b) {
            return;
        }
        _fVar2._d.set(true);
        try {
            _fVar2._a.cancel(true);
        } catch (Throwable unused2) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002c  */
    /* JADX WARN: Code duplicated, block: B:21:0x0038 A[PHI: r1
      0x0038: PHI (r1v3 android.content.Context) = (r1v2 android.content.Context), (r1v22 android.content.Context), (r1v25 android.content.Context) binds: [B:12:0x0016, B:20:0x0036, B:18:0x0027] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:22:0x003b  */
    /* JADX WARN: Multi-variable type inference failed */
    public static void _a(_l2 _l2Var, View view, Object obj, boolean z) {
        Activity activity;
        Animatable animatable;
        if (_l2Var._m != null) {
            return;
        }
        _mk _mkVar = _l2Var._n;
        if (_mkVar != null) {
            _mkVar._a(obj);
            return;
        }
        if (view == 0) {
            return;
        }
        Context context = view.getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else if (context instanceof ContextWrapper) {
            ContextWrapper contextWrapper = (ContextWrapper) context;
            if (contextWrapper.getBaseContext() instanceof Activity) {
                context = contextWrapper.getBaseContext();
            } else {
                context = view.getRootView().getContext();
                if (context instanceof Activity) {
                    activity = null;
                }
            }
            activity = (Activity) context;
        } else {
            context = view.getRootView().getContext();
            if (context instanceof Activity) {
                activity = null;
            } else {
                activity = (Activity) context;
            }
        }
        if (activity == null || activity.isFinishing() || activity.isDestroyed() || obj == null) {
            return;
        }
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            Boolean.valueOf(z).booleanValue();
            if (view instanceof ImageView) {
                ((ImageView) view).setImageBitmap(bitmap);
                return;
            } else {
                if (view instanceof _bx) {
                    new BitmapDrawable(_o2._a.getResources(), bitmap);
                    ((_bx) view)._c();
                    return;
                }
                return;
            }
        }
        if (obj instanceof Drawable) {
            _a(view, (Drawable) obj);
            if (!(obj instanceof Animatable)) {
                return;
            } else {
                animatable = (Animatable) obj;
            }
        } else {
            if (!(view instanceof _bx)) {
                return;
            }
            ((_bx) view)._a();
            if (!(view instanceof Animatable)) {
                return;
            } else {
                animatable = (Animatable) view;
            }
        }
        animatable.start();
        view.addOnAttachStateChangeListener(_c);
    }

    public static void _b(View view) {
        Object tag = view.getTag(R.id.aw_doodle_view_tag);
        if (tag instanceof _l2) {
            _l2 _l2Var = (_l2) tag;
            WeakReference<com.kc.aw.lib.doodle._f> weakReference = _l2Var._p;
            if (weakReference != null) {
                _l2Var._p = null;
                com.kc.aw.lib.doodle._f _fVar = weakReference.get();
                if (_fVar != null && !_fVar._d.get()) {
                    _fVar._d.set(true);
                    try {
                        _fVar._a.cancel(true);
                    } catch (Throwable unused) {
                    }
                }
            }
            view.setTag(R.id.aw_doodle_view_tag, null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0016  */
    public static void _c(View view) {
        Animatable animatable;
        Object obj;
        try {
            if (view instanceof ImageView) {
                Drawable drawable = ((ImageView) view).getDrawable();
                if (drawable instanceof Animatable) {
                    obj = drawable;
                    obj = view;
                    animatable = (Animatable) obj;
                } else {
                    obj = view;
                    animatable = null;
                }
            } else if (view instanceof Animatable) {
                obj = view;
                animatable = (Animatable) obj;
            } else {
                obj = view;
                animatable = null;
            }
            if (animatable == null || !animatable.isRunning()) {
                return;
            }
            animatable.stop();
        } catch (Throwable th) {
            _fu._a("Controller", th);
        }
    }
}

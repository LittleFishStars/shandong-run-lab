package com.kc.dw.core.bquery;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kc.dw.core.bquery.a;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.SoftReference;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class a<T extends a<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f39236a;
    public Constructor<T> b;
    public View c;
    public View d;

    public a(Activity activity) {
        this.f39236a = activity;
    }

    public a(Context context) {
    }

    public a(View view) {
        this.c = view;
        this.d = view;
    }

    public T a(int i) {
        View viewFindViewById;
        View view = this.c;
        if (view != null) {
            viewFindViewById = view.findViewById(i);
        } else {
            Activity activity = this.f39236a;
            viewFindViewById = activity != null ? activity.findViewById(i) : null;
        }
        if (this.b == null) {
            try {
                this.b = (Constructor<T>) getClass().getConstructor(View.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            return this.b.newInstance(viewFindViewById);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public T a(CharSequence charSequence) {
        View view = this.d;
        if (view instanceof TextView) {
            ((TextView) view).setText(charSequence);
        }
        return this;
    }

    public T a(String str) {
        return (T) a(str, false);
    }

    public T a(String str, boolean z) {
        View view = this.d;
        if (view instanceof ImageView) {
            try {
                ImageView imageView = (ImageView) view;
                if (imageView != null && str != null) {
                    imageView.setTag(str);
                    com.kc.dw.cache.b.a(str, new g(new SoftReference(imageView), str, z));
                }
            } catch (Throwable unused) {
            }
        }
        return this;
    }

    public T b(int i) {
        View viewFindViewById;
        View view = this.c;
        if (view != null) {
            viewFindViewById = view.findViewById(i);
        } else {
            Activity activity = this.f39236a;
            viewFindViewById = activity != null ? activity.findViewById(i) : null;
        }
        this.d = viewFindViewById;
        return this;
    }

    public T c(int i) {
        View view = this.d;
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            if (i == 0) {
                imageView.setImageBitmap(null);
            } else {
                imageView.setImageResource(i);
            }
        }
        return this;
    }

    public T d(int i) {
        View view = this.d;
        if (view != null && view.getVisibility() != i) {
            this.d.setVisibility(i);
        }
        return this;
    }
}

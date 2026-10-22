package androidx.coroutines;

import androidx.coroutines.ViewDataBinding;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public abstract class OnRebindCallback<T extends ViewDataBinding> {
    public void onBound(T t) {
    }

    public void onCanceled(T t) {
    }

    public boolean onPreBind(T t) {
        return true;
    }
}

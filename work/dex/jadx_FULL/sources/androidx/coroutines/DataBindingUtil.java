package androidx.coroutines;

import android.R;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class DataBindingUtil {
    private static DataBinderMapper sMapper = new DataBinderMapperImpl();
    private static DataBindingComponent sDefaultComponent = null;

    private DataBindingUtil() {
    }

    @Nullable
    public static <T extends ViewDataBinding> T bind(@NonNull View view) {
        return (T) bind(view, sDefaultComponent);
    }

    private static <T extends ViewDataBinding> T bindToAddedViews(DataBindingComponent dataBindingComponent, ViewGroup viewGroup, int i, int i2) {
        int childCount = viewGroup.getChildCount();
        int i3 = childCount - i;
        if (i3 == 1) {
            return (T) bind(dataBindingComponent, viewGroup.getChildAt(childCount - 1), i2);
        }
        View[] viewArr = new View[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            viewArr[i4] = viewGroup.getChildAt(i4 + i);
        }
        return (T) bind(dataBindingComponent, viewArr, i2);
    }

    @Nullable
    public static String convertBrIdToString(int i) {
        return sMapper.convertBrIdToString(i);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0038  */
    @Nullable
    public static <T extends ViewDataBinding> T findBinding(@NonNull View view) {
        while (view != null) {
            T t = (T) ViewDataBinding.getBinding(view);
            if (t != null) {
                return t;
            }
            Object tag = view.getTag();
            if (tag instanceof String) {
                String str = (String) tag;
                if (str.startsWith("layout") && str.endsWith("_0")) {
                    char cCharAt = str.charAt(6);
                    int iIndexOf = str.indexOf(47, 7);
                    boolean z = true;
                    boolean z2 = false;
                    if (cCharAt == '/') {
                        if (iIndexOf != -1) {
                            z = false;
                        }
                        z2 = z;
                    } else if (cCharAt == '-' && iIndexOf != -1) {
                        if (str.indexOf(47, iIndexOf + 1) != -1) {
                            z = false;
                        }
                        z2 = z;
                    }
                    if (z2) {
                        return null;
                    }
                }
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    @Nullable
    public static <T extends ViewDataBinding> T getBinding(@NonNull View view) {
        return (T) ViewDataBinding.getBinding(view);
    }

    @Nullable
    public static DataBindingComponent getDefaultComponent() {
        return sDefaultComponent;
    }

    public static <T extends ViewDataBinding> T inflate(@NonNull LayoutInflater layoutInflater, int i, @Nullable ViewGroup viewGroup, boolean z) {
        return (T) inflate(layoutInflater, i, viewGroup, z, sDefaultComponent);
    }

    public static <T extends ViewDataBinding> T setContentView(@NonNull Activity activity, int i) {
        return (T) setContentView(activity, i, sDefaultComponent);
    }

    public static void setDefaultComponent(@Nullable DataBindingComponent dataBindingComponent) {
        sDefaultComponent = dataBindingComponent;
    }

    @Nullable
    public static <T extends ViewDataBinding> T bind(@NonNull View view, DataBindingComponent dataBindingComponent) {
        T t = (T) getBinding(view);
        if (t != null) {
            return t;
        }
        Object tag = view.getTag();
        if (!(tag instanceof String)) {
            throw new IllegalArgumentException("View is not a binding layout");
        }
        int layoutId = sMapper.getLayoutId((String) tag);
        if (layoutId != 0) {
            return (T) sMapper.getDataBinder(dataBindingComponent, view, layoutId);
        }
        throw new IllegalArgumentException("View is not a binding layout. Tag: " + tag);
    }

    public static <T extends ViewDataBinding> T inflate(@NonNull LayoutInflater layoutInflater, int i, @Nullable ViewGroup viewGroup, boolean z, @Nullable DataBindingComponent dataBindingComponent) {
        boolean z2 = viewGroup != null && z;
        return z2 ? (T) bindToAddedViews(dataBindingComponent, viewGroup, z2 ? viewGroup.getChildCount() : 0, i) : (T) bind(dataBindingComponent, layoutInflater.inflate(i, viewGroup, z), i);
    }

    public static <T extends ViewDataBinding> T setContentView(@NonNull Activity activity, int i, @Nullable DataBindingComponent dataBindingComponent) {
        activity.setContentView(i);
        return (T) bindToAddedViews(dataBindingComponent, (ViewGroup) activity.getWindow().getDecorView().findViewById(R.id.content), 0, i);
    }

    public static <T extends ViewDataBinding> T bind(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        return (T) sMapper.getDataBinder(dataBindingComponent, viewArr, i);
    }

    public static <T extends ViewDataBinding> T bind(DataBindingComponent dataBindingComponent, View view, int i) {
        return (T) sMapper.getDataBinder(dataBindingComponent, view, i);
    }
}

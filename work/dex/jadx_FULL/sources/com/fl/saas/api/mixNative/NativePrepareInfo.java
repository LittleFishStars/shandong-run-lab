package com.fl.saas.api.mixNative;

import android.app.Activity;
import android.view.View;
import com.fl.saas.common.util.feature.Optional;
import com.zj.adlib.hx5;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class NativePrepareInfo {
    private WeakReference<Activity> activityRef;
    private View closeView;
    private boolean isSelfRenderShake;
    private final List<View> ctaViewList = new ArrayList();
    private final List<View> clickViewList = new ArrayList();
    private final List<View> imageViewList = new ArrayList();

    private synchronized void addViewList(List<View> list, View... viewArr) {
        if (viewArr != null) {
            if (viewArr.length != 0) {
                for (View view : viewArr) {
                    if (view != null && !list.contains(view) && view != this.closeView) {
                        list.add(view);
                    }
                }
            }
        }
    }

    public Activity getActivity() {
        return (Activity) Optional.ofNullable(this.activityRef).map(new hx5()).orElse(null);
    }

    public List<View> getAllClickViews() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.clickViewList);
        arrayList.addAll(this.ctaViewList);
        return arrayList;
    }

    public List<View> getClickViewList() {
        return this.clickViewList;
    }

    public View getCloseView() {
        return this.closeView;
    }

    public List<View> getCtaViewList() {
        return this.ctaViewList;
    }

    public List<View> getImageViewList() {
        return this.imageViewList;
    }

    public boolean isSelfRenderShake() {
        return this.isSelfRenderShake;
    }

    public void setActivity(Activity activity) {
        this.activityRef = new WeakReference<>(activity);
    }

    public void setClickView(View... viewArr) {
        addViewList(this.clickViewList, viewArr);
    }

    public void setCloseView(View view) {
        this.closeView = view;
    }

    public void setCtaView(View... viewArr) {
        addViewList(this.ctaViewList, viewArr);
    }

    public void setImageView(View... viewArr) {
        if (viewArr == null || viewArr.length == 0) {
            return;
        }
        for (View view : viewArr) {
            if (view != null && !this.imageViewList.contains(view)) {
                this.imageViewList.add(view);
            }
        }
    }

    public void setSelfRenderShake(boolean z) {
        this.isSelfRenderShake = z;
    }
}

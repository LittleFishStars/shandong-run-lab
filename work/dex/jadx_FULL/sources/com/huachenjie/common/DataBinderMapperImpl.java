package com.huachenjie.common;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.coroutines.DataBinderMapper;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.common.databinding.ActivityVideoPlayerBindingImpl;
import com.huachenjie.common.databinding.ActivityWebviewBindingImpl;
import com.huachenjie.common.databinding.DialogBottomExamNoticeBindingImpl;
import com.huachenjie.common.databinding.FragmentWebviewBindingImpl;
import com.huachenjie.common.databinding.LayoutBottomIconViewBindingImpl;
import com.huachenjie.common.databinding.LayoutToolbarBindingBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DataBinderMapperImpl extends DataBinderMapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f33622a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final SparseIntArray f8472a;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    public static final int f = 6;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SparseArray<String> f33623a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(6);
            f33623a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "checked");
            sparseArray.put(2, "click");
            sparseArray.put(3, "data");
            sparseArray.put(4, "title");
            sparseArray.put(5, "vm");
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HashMap<String, Integer> f33624a;

        static {
            HashMap<String, Integer> map = new HashMap<>(6);
            f33624a = map;
            map.put("layout/activity_video_player_0", Integer.valueOf(R.layout.activity_video_player));
            map.put("layout/activity_webview_0", Integer.valueOf(R.layout.activity_webview));
            map.put("layout/dialog_bottom_exam_notice_0", Integer.valueOf(R.layout.dialog_bottom_exam_notice));
            map.put("layout/fragment_webview_0", Integer.valueOf(R.layout.fragment_webview));
            map.put("layout/layout_bottom_icon_view_0", Integer.valueOf(R.layout.layout_bottom_icon_view));
            map.put("layout/layout_toolbar_binding_0", Integer.valueOf(R.layout.layout_toolbar_binding));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(6);
        f8472a = sparseIntArray;
        sparseIntArray.put(R.layout.activity_video_player, 1);
        sparseIntArray.put(R.layout.activity_webview, 2);
        sparseIntArray.put(R.layout.dialog_bottom_exam_notice, 3);
        sparseIntArray.put(R.layout.fragment_webview, 4);
        sparseIntArray.put(R.layout.layout_bottom_icon_view, 5);
        sparseIntArray.put(R.layout.layout_toolbar_binding, 6);
    }

    @Override // androidx.coroutines.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(new androidx.coroutines.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.flyco.tablayout.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.pay.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.qrcode.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.step.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.coroutines.DataBinderMapper
    public String convertBrIdToString(int localId) {
        return a.f33623a.get(localId);
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
        int i = f8472a.get(layoutId);
        if (i <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i) {
            case 1:
                if ("layout/activity_video_player_0".equals(tag)) {
                    return new ActivityVideoPlayerBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for activity_video_player is invalid. Received: " + tag);
            case 2:
                if ("layout/activity_webview_0".equals(tag)) {
                    return new ActivityWebviewBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for activity_webview is invalid. Received: " + tag);
            case 3:
                if ("layout/dialog_bottom_exam_notice_0".equals(tag)) {
                    return new DialogBottomExamNoticeBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_bottom_exam_notice is invalid. Received: " + tag);
            case 4:
                if ("layout/fragment_webview_0".equals(tag)) {
                    return new FragmentWebviewBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_webview is invalid. Received: " + tag);
            case 5:
                if ("layout/layout_bottom_icon_view_0".equals(tag)) {
                    return new LayoutBottomIconViewBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for layout_bottom_icon_view is invalid. Received: " + tag);
            case 6:
                if ("layout/layout_toolbar_binding_0".equals(tag)) {
                    return new LayoutToolbarBindingBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for layout_toolbar_binding is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.coroutines.DataBinderMapper
    public int getLayoutId(String tag) {
        Integer num;
        if (tag == null || (num = b.f33624a.get(tag)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
        if (views == null || views.length == 0 || f8472a.get(layoutId) <= 0 || views[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}

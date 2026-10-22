package com.huachenjie.shandong_school;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.coroutines.DataBinderMapper;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.alipay.sdk.m.c0.d;
import com.huachenjie.mall.page.comment.write.WriteReviewActivity;
import com.huachenjie.run.page.sun_run.success.SchoolActivitySuccessActivity;
import com.huachenjie.shandong_school.databinding.ActivityHomeBindingImpl;
import com.huachenjie.shandong_school.databinding.ActivityPrivacyBindingImpl;
import com.huachenjie.shandong_school.databinding.ActivitySplashBindingImpl;
import com.huachenjie.shandong_school.databinding.LayoutHomeSlideBindingImpl;
import com.huachenjie.shandong_school.databinding.LayoutHomeTabBarBindingImpl;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class DataBinderMapperImpl extends DataBinderMapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f36013a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final SparseIntArray f12621a;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SparseArray<String> f36014a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(68);
            f36014a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "adapter");
            sparseArray.put(2, "addressBean");
            sparseArray.put(3, "appealTime");
            sparseArray.put(4, "badgeOption");
            sparseArray.put(5, "bannerHeight");
            sparseArray.put(6, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
            sparseArray.put(7, "bgOption");
            sparseArray.put(8, "cardBg");
            sparseArray.put(9, "checked");
            sparseArray.put(10, "click");
            sparseArray.put(11, "commentType");
            sparseArray.put(12, "contains");
            sparseArray.put(13, "content");
            sparseArray.put(14, "data");
            sparseArray.put(15, "date");
            sparseArray.put(16, SchoolActivitySuccessActivity.x);
            sparseArray.put(17, "flowAdapter");
            sparseArray.put(18, "fragment");
            sparseArray.put(19, WriteReviewActivity.x);
            sparseArray.put(20, "hasBuy");
            sparseArray.put(21, "hasChat");
            sparseArray.put(22, "index");
            sparseArray.put(23, "infoMargin");
            sparseArray.put(24, "isAdmin");
            sparseArray.put(25, "isEdit");
            sparseArray.put(26, "isEnable");
            sparseArray.put(27, "isFinish");
            sparseArray.put(28, "isLast");
            sparseArray.put(29, "isMyOrganize");
            sparseArray.put(30, "isSelect");
            sparseArray.put(31, "isSelected");
            sparseArray.put(32, "isSelf");
            sparseArray.put(33, "item");
            sparseArray.put(34, "jackpotType");
            sparseArray.put(35, "layoutManage");
            sparseArray.put(36, "listType");
            sparseArray.put(37, "mState");
            sparseArray.put(38, "onClick");
            sparseArray.put(39, "pageChange");
            sparseArray.put(40, "portraitUrl");
            sparseArray.put(41, "position");
            sparseArray.put(42, "postType");
            sparseArray.put(43, d.x);
            sparseArray.put(44, "scroll");
            sparseArray.put(45, "selectedPosition");
            sparseArray.put(46, "sexType");
            sparseArray.put(47, "showAll");
            sparseArray.put(48, "showAppealTime");
            sparseArray.put(49, "showContent");
            sparseArray.put(50, "showFace");
            sparseArray.put(51, "showFollow");
            sparseArray.put(52, "showGradient");
            sparseArray.put(53, "showRelation");
            sparseArray.put(54, "showSeaView");
            sparseArray.put(55, "showTag");
            sparseArray.put(56, "size");
            sparseArray.put(57, "source");
            sparseArray.put(58, "statusBarHeight");
            sparseArray.put(59, "tagBg");
            sparseArray.put(60, "tagText");
            sparseArray.put(61, "targetNo");
            sparseArray.put(62, "teamGroupTitle");
            sparseArray.put(63, "time");
            sparseArray.put(64, "title");
            sparseArray.put(65, "topicGroupTitle");
            sparseArray.put(66, "type");
            sparseArray.put(67, "vm");
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HashMap<String, Integer> f36015a;

        static {
            HashMap<String, Integer> map = new HashMap<>(5);
            f36015a = map;
            map.put("layout/activity_home_0", Integer.valueOf(R.layout.activity_home));
            map.put("layout/activity_privacy_0", Integer.valueOf(R.layout.activity_privacy));
            map.put("layout/activity_splash_0", Integer.valueOf(R.layout.activity_splash));
            map.put("layout/layout_home_slide_0", Integer.valueOf(R.layout.layout_home_slide));
            map.put("layout/layout_home_tab_bar_0", Integer.valueOf(R.layout.layout_home_tab_bar));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(5);
        f12621a = sparseIntArray;
        sparseIntArray.put(R.layout.activity_home, 1);
        sparseIntArray.put(R.layout.activity_privacy, 2);
        sparseIntArray.put(R.layout.activity_splash, 3);
        sparseIntArray.put(R.layout.layout_home_slide, 4);
        sparseIntArray.put(R.layout.layout_home_tab_bar, 5);
    }

    @Override // androidx.coroutines.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(20);
        arrayList.add(new androidx.coroutines.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.flyco.tablayout.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.ad.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.base.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.channel.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.college.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.common.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.compat.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.home.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.im.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.login.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.mall.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.mine.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.pay.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.qrcode.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.run.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.social_contact.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.sport.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.step.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.works.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.coroutines.DataBinderMapper
    public String convertBrIdToString(int i) {
        return a.f36014a.get(i);
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        int i2 = f12621a.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        if (i2 == 1) {
            if ("layout/activity_home_0".equals(tag)) {
                return new ActivityHomeBindingImpl(dataBindingComponent, view);
            }
            throw new IllegalArgumentException("The tag for activity_home is invalid. Received: " + tag);
        }
        if (i2 == 2) {
            if ("layout/activity_privacy_0".equals(tag)) {
                return new ActivityPrivacyBindingImpl(dataBindingComponent, view);
            }
            throw new IllegalArgumentException("The tag for activity_privacy is invalid. Received: " + tag);
        }
        if (i2 == 3) {
            if ("layout/activity_splash_0".equals(tag)) {
                return new ActivitySplashBindingImpl(dataBindingComponent, view);
            }
            throw new IllegalArgumentException("The tag for activity_splash is invalid. Received: " + tag);
        }
        if (i2 == 4) {
            if ("layout/layout_home_slide_0".equals(tag)) {
                return new LayoutHomeSlideBindingImpl(dataBindingComponent, view);
            }
            throw new IllegalArgumentException("The tag for layout_home_slide is invalid. Received: " + tag);
        }
        if (i2 != 5) {
            return null;
        }
        if ("layout/layout_home_tab_bar_0".equals(tag)) {
            return new LayoutHomeTabBarBindingImpl(dataBindingComponent, view);
        }
        throw new IllegalArgumentException("The tag for layout_home_tab_bar is invalid. Received: " + tag);
    }

    @Override // androidx.coroutines.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f36015a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || f12621a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}

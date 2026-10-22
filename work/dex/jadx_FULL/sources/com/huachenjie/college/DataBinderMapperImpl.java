package com.huachenjie.college;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.coroutines.DataBinderMapper;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.alipay.sdk.m.c0.d;
import com.huachenjie.college.databinding.CollegeActivityHomeBindingImpl;
import com.huachenjie.college.databinding.CollegeActivityHwHealthBindingImpl;
import com.huachenjie.college.databinding.CollegeActivityHwHealthSportDetailBindingImpl;
import com.huachenjie.college.databinding.CollegeActivityLightningPlayBindingImpl;
import com.huachenjie.college.databinding.CollegeActivityPointActivityListBindingImpl;
import com.huachenjie.college.databinding.CollegeActivityRecreationBindingImpl;
import com.huachenjie.college.databinding.CollegeFragmentCollegiateTownItemBindingImpl;
import com.huachenjie.college.databinding.CollegeFragmentLightningPlayBindingImpl;
import com.huachenjie.college.databinding.CollegeItemApplicationBindingImpl;
import com.huachenjie.college.databinding.CollegeItemHwHealthBindingImpl;
import com.huachenjie.college.databinding.CollegeItemPointActivityListBindingImpl;
import com.huachenjie.college.databinding.CollegeItemTownRecommendBindingImpl;
import com.huachenjie.college.databinding.CollegeItemTownRecommendEmptyBindingImpl;
import com.huachenjie.college.databinding.CollegeLayoutHomeHeaderBindingImpl;
import com.huachenjie.college.databinding.CollegeViewHwHealthHeaderBindingImpl;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class DataBinderMapperImpl extends DataBinderMapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f33545a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final SparseIntArray f8321a;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    public static final int f = 6;
    public static final int g = 7;
    public static final int h = 8;
    public static final int i = 9;
    public static final int j = 10;
    public static final int k = 11;
    public static final int l = 12;
    public static final int m = 13;
    public static final int n = 14;
    public static final int o = 15;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SparseArray<String> f33546a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(19);
            f33546a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "adapter");
            sparseArray.put(2, "badgeOption");
            sparseArray.put(3, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
            sparseArray.put(4, "bgOption");
            sparseArray.put(5, "checked");
            sparseArray.put(6, "click");
            sparseArray.put(7, "commentType");
            sparseArray.put(8, "data");
            sparseArray.put(9, "fragment");
            sparseArray.put(10, "index");
            sparseArray.put(11, "isSelf");
            sparseArray.put(12, "position");
            sparseArray.put(13, "postType");
            sparseArray.put(14, d.x);
            sparseArray.put(15, "showRelation");
            sparseArray.put(16, "source");
            sparseArray.put(17, "title");
            sparseArray.put(18, "vm");
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HashMap<String, Integer> f33547a;

        static {
            HashMap<String, Integer> map = new HashMap<>(15);
            f33547a = map;
            map.put("layout/college_activity_home_0", Integer.valueOf(R.layout.college_activity_home));
            map.put("layout/college_activity_hw_health_0", Integer.valueOf(R.layout.college_activity_hw_health));
            map.put("layout/college_activity_hw_health_sport_detail_0", Integer.valueOf(R.layout.college_activity_hw_health_sport_detail));
            map.put("layout/college_activity_lightning_play_0", Integer.valueOf(R.layout.college_activity_lightning_play));
            map.put("layout/college_activity_point_activity_list_0", Integer.valueOf(R.layout.college_activity_point_activity_list));
            map.put("layout/college_activity_recreation_0", Integer.valueOf(R.layout.college_activity_recreation));
            map.put("layout/college_fragment_collegiate_town_item_0", Integer.valueOf(R.layout.college_fragment_collegiate_town_item));
            map.put("layout/college_fragment_lightning_play_0", Integer.valueOf(R.layout.college_fragment_lightning_play));
            map.put("layout/college_item_application_0", Integer.valueOf(R.layout.college_item_application));
            map.put("layout/college_item_hw_health_0", Integer.valueOf(R.layout.college_item_hw_health));
            map.put("layout/college_item_point_activity_list_0", Integer.valueOf(R.layout.college_item_point_activity_list));
            map.put("layout/college_item_town_recommend_0", Integer.valueOf(R.layout.college_item_town_recommend));
            map.put("layout/college_item_town_recommend_empty_0", Integer.valueOf(R.layout.college_item_town_recommend_empty));
            map.put("layout/college_layout_home_header_0", Integer.valueOf(R.layout.college_layout_home_header));
            map.put("layout/college_view_hw_health_header_0", Integer.valueOf(R.layout.college_view_hw_health_header));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(15);
        f8321a = sparseIntArray;
        sparseIntArray.put(R.layout.college_activity_home, 1);
        sparseIntArray.put(R.layout.college_activity_hw_health, 2);
        sparseIntArray.put(R.layout.college_activity_hw_health_sport_detail, 3);
        sparseIntArray.put(R.layout.college_activity_lightning_play, 4);
        sparseIntArray.put(R.layout.college_activity_point_activity_list, 5);
        sparseIntArray.put(R.layout.college_activity_recreation, 6);
        sparseIntArray.put(R.layout.college_fragment_collegiate_town_item, 7);
        sparseIntArray.put(R.layout.college_fragment_lightning_play, 8);
        sparseIntArray.put(R.layout.college_item_application, 9);
        sparseIntArray.put(R.layout.college_item_hw_health, 10);
        sparseIntArray.put(R.layout.college_item_point_activity_list, 11);
        sparseIntArray.put(R.layout.college_item_town_recommend, 12);
        sparseIntArray.put(R.layout.college_item_town_recommend_empty, 13);
        sparseIntArray.put(R.layout.college_layout_home_header, 14);
        sparseIntArray.put(R.layout.college_view_hw_health_header, 15);
    }

    @Override // androidx.coroutines.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(9);
        arrayList.add(new androidx.coroutines.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.flyco.tablayout.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.ad.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.base.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.common.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.pay.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.qrcode.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.step.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.works.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.coroutines.DataBinderMapper
    public String convertBrIdToString(int i2) {
        return a.f33546a.get(i2);
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i2) {
        int i3 = f8321a.get(i2);
        if (i3 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i3) {
            case 1:
                if ("layout/college_activity_home_0".equals(tag)) {
                    return new CollegeActivityHomeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for college_activity_home is invalid. Received: " + tag);
            case 2:
                if ("layout/college_activity_hw_health_0".equals(tag)) {
                    return new CollegeActivityHwHealthBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for college_activity_hw_health is invalid. Received: " + tag);
            case 3:
                if ("layout/college_activity_hw_health_sport_detail_0".equals(tag)) {
                    return new CollegeActivityHwHealthSportDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for college_activity_hw_health_sport_detail is invalid. Received: " + tag);
            case 4:
                if ("layout/college_activity_lightning_play_0".equals(tag)) {
                    return new CollegeActivityLightningPlayBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for college_activity_lightning_play is invalid. Received: " + tag);
            case 5:
                if ("layout/college_activity_point_activity_list_0".equals(tag)) {
                    return new CollegeActivityPointActivityListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for college_activity_point_activity_list is invalid. Received: " + tag);
            case 6:
                if ("layout/college_activity_recreation_0".equals(tag)) {
                    return new CollegeActivityRecreationBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for college_activity_recreation is invalid. Received: " + tag);
            case 7:
                if ("layout/college_fragment_collegiate_town_item_0".equals(tag)) {
                    return new CollegeFragmentCollegiateTownItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for college_fragment_collegiate_town_item is invalid. Received: " + tag);
            case 8:
                if ("layout/college_fragment_lightning_play_0".equals(tag)) {
                    return new CollegeFragmentLightningPlayBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for college_fragment_lightning_play is invalid. Received: " + tag);
            case 9:
                if ("layout/college_item_application_0".equals(tag)) {
                    return new CollegeItemApplicationBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for college_item_application is invalid. Received: " + tag);
            case 10:
                if ("layout/college_item_hw_health_0".equals(tag)) {
                    return new CollegeItemHwHealthBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for college_item_hw_health is invalid. Received: " + tag);
            case 11:
                if ("layout/college_item_point_activity_list_0".equals(tag)) {
                    return new CollegeItemPointActivityListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for college_item_point_activity_list is invalid. Received: " + tag);
            case 12:
                if ("layout/college_item_town_recommend_0".equals(tag)) {
                    return new CollegeItemTownRecommendBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for college_item_town_recommend is invalid. Received: " + tag);
            case 13:
                if ("layout/college_item_town_recommend_empty_0".equals(tag)) {
                    return new CollegeItemTownRecommendEmptyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for college_item_town_recommend_empty is invalid. Received: " + tag);
            case 14:
                if ("layout/college_layout_home_header_0".equals(tag)) {
                    return new CollegeLayoutHomeHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for college_layout_home_header is invalid. Received: " + tag);
            case 15:
                if ("layout/college_view_hw_health_header_0".equals(tag)) {
                    return new CollegeViewHwHealthHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for college_view_hw_health_header is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.coroutines.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f33547a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i2) {
        if (viewArr == null || viewArr.length == 0 || f8321a.get(i2) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}

package com.huachenjie.compat;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.coroutines.DataBinderMapper;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.alipay.sdk.m.c0.d;
import com.huachenjie.compat.databinding.ActivityAboutAsBindingImpl;
import com.huachenjie.compat.databinding.ActivityAccountManageBindingImpl;
import com.huachenjie.compat.databinding.ActivityAuthorizeBindingImpl;
import com.huachenjie.compat.databinding.ActivityAuthorizeVerifyBindingImpl;
import com.huachenjie.compat.databinding.ActivityCancelAccountBindingImpl;
import com.huachenjie.compat.databinding.ActivityCancelAccountSubmitBindingImpl;
import com.huachenjie.compat.databinding.ActivityCancelAccountTipBindingImpl;
import com.huachenjie.compat.databinding.ActivityChangeNickNameBindingImpl;
import com.huachenjie.compat.databinding.ActivityChangePasswordBindingImpl;
import com.huachenjie.compat.databinding.ActivityModifyAddressBindingImpl;
import com.huachenjie.compat.databinding.ActivityPersonalV2BindingImpl;
import com.huachenjie.compat.databinding.ActivityStudentCardBindingImpl;
import com.huachenjie.compat.databinding.CompatActivityAdReportBindingImpl;
import com.huachenjie.compat.databinding.CompatActivityPushSettingBindingImpl;
import com.huachenjie.compat.databinding.CompatActivityUserFaceBindingImpl;
import com.huachenjie.compat.databinding.CompatItemPushSettingContentBindingImpl;
import com.huachenjie.compat.databinding.CompatItemPushSettingTitleBindingImpl;
import com.huachenjie.compat.databinding.ItemStudentCourseBindingImpl;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class DataBinderMapperImpl extends DataBinderMapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f33978a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final SparseIntArray f8978a;
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
    public static final int p = 16;
    public static final int q = 17;
    public static final int r = 18;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SparseArray<String> f33979a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(9);
            f33979a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
            sparseArray.put(2, "checked");
            sparseArray.put(3, "click");
            sparseArray.put(4, "data");
            sparseArray.put(5, "mState");
            sparseArray.put(6, d.x);
            sparseArray.put(7, "title");
            sparseArray.put(8, "vm");
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HashMap<String, Integer> f33980a;

        static {
            HashMap<String, Integer> map = new HashMap<>(18);
            f33980a = map;
            map.put("layout/activity_about_as_0", Integer.valueOf(R.layout.activity_about_as));
            map.put("layout/activity_account_manage_0", Integer.valueOf(R.layout.activity_account_manage));
            map.put("layout/activity_authorize_0", Integer.valueOf(R.layout.activity_authorize));
            map.put("layout/activity_authorize_verify_0", Integer.valueOf(R.layout.activity_authorize_verify));
            map.put("layout/activity_cancel_account_0", Integer.valueOf(R.layout.activity_cancel_account));
            map.put("layout/activity_cancel_account_submit_0", Integer.valueOf(R.layout.activity_cancel_account_submit));
            map.put("layout/activity_cancel_account_tip_0", Integer.valueOf(R.layout.activity_cancel_account_tip));
            map.put("layout/activity_change_nick_name_0", Integer.valueOf(R.layout.activity_change_nick_name));
            map.put("layout/activity_change_password_0", Integer.valueOf(R.layout.activity_change_password));
            map.put("layout/activity_modify_address_0", Integer.valueOf(R.layout.activity_modify_address));
            map.put("layout/activity_personal_v2_0", Integer.valueOf(R.layout.activity_personal_v2));
            map.put("layout/activity_student_card_0", Integer.valueOf(R.layout.activity_student_card));
            map.put("layout/compat_activity_ad_report_0", Integer.valueOf(R.layout.compat_activity_ad_report));
            map.put("layout/compat_activity_push_setting_0", Integer.valueOf(R.layout.compat_activity_push_setting));
            map.put("layout/compat_activity_user_face_0", Integer.valueOf(R.layout.compat_activity_user_face));
            map.put("layout/compat_item_push_setting_content_0", Integer.valueOf(R.layout.compat_item_push_setting_content));
            map.put("layout/compat_item_push_setting_title_0", Integer.valueOf(R.layout.compat_item_push_setting_title));
            map.put("layout/item_student_course_0", Integer.valueOf(R.layout.item_student_course));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(18);
        f8978a = sparseIntArray;
        sparseIntArray.put(R.layout.activity_about_as, 1);
        sparseIntArray.put(R.layout.activity_account_manage, 2);
        sparseIntArray.put(R.layout.activity_authorize, 3);
        sparseIntArray.put(R.layout.activity_authorize_verify, 4);
        sparseIntArray.put(R.layout.activity_cancel_account, 5);
        sparseIntArray.put(R.layout.activity_cancel_account_submit, 6);
        sparseIntArray.put(R.layout.activity_cancel_account_tip, 7);
        sparseIntArray.put(R.layout.activity_change_nick_name, 8);
        sparseIntArray.put(R.layout.activity_change_password, 9);
        sparseIntArray.put(R.layout.activity_modify_address, 10);
        sparseIntArray.put(R.layout.activity_personal_v2, 11);
        sparseIntArray.put(R.layout.activity_student_card, 12);
        sparseIntArray.put(R.layout.compat_activity_ad_report, 13);
        sparseIntArray.put(R.layout.compat_activity_push_setting, 14);
        sparseIntArray.put(R.layout.compat_activity_user_face, 15);
        sparseIntArray.put(R.layout.compat_item_push_setting_content, 16);
        sparseIntArray.put(R.layout.compat_item_push_setting_title, 17);
        sparseIntArray.put(R.layout.item_student_course, 18);
    }

    @Override // androidx.coroutines.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(9);
        arrayList.add(new androidx.coroutines.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.flyco.tablayout.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.ad.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.base.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.common.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.im.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.pay.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.qrcode.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.step.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.coroutines.DataBinderMapper
    public String convertBrIdToString(int i2) {
        return a.f33979a.get(i2);
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i2) {
        int i3 = f8978a.get(i2);
        if (i3 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i3) {
            case 1:
                if ("layout/activity_about_as_0".equals(tag)) {
                    return new ActivityAboutAsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_about_as is invalid. Received: " + tag);
            case 2:
                if ("layout/activity_account_manage_0".equals(tag)) {
                    return new ActivityAccountManageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_account_manage is invalid. Received: " + tag);
            case 3:
                if ("layout/activity_authorize_0".equals(tag)) {
                    return new ActivityAuthorizeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_authorize is invalid. Received: " + tag);
            case 4:
                if ("layout/activity_authorize_verify_0".equals(tag)) {
                    return new ActivityAuthorizeVerifyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_authorize_verify is invalid. Received: " + tag);
            case 5:
                if ("layout/activity_cancel_account_0".equals(tag)) {
                    return new ActivityCancelAccountBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_cancel_account is invalid. Received: " + tag);
            case 6:
                if ("layout/activity_cancel_account_submit_0".equals(tag)) {
                    return new ActivityCancelAccountSubmitBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_cancel_account_submit is invalid. Received: " + tag);
            case 7:
                if ("layout/activity_cancel_account_tip_0".equals(tag)) {
                    return new ActivityCancelAccountTipBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_cancel_account_tip is invalid. Received: " + tag);
            case 8:
                if ("layout/activity_change_nick_name_0".equals(tag)) {
                    return new ActivityChangeNickNameBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_change_nick_name is invalid. Received: " + tag);
            case 9:
                if ("layout/activity_change_password_0".equals(tag)) {
                    return new ActivityChangePasswordBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_change_password is invalid. Received: " + tag);
            case 10:
                if ("layout/activity_modify_address_0".equals(tag)) {
                    return new ActivityModifyAddressBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_modify_address is invalid. Received: " + tag);
            case 11:
                if ("layout/activity_personal_v2_0".equals(tag)) {
                    return new ActivityPersonalV2BindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_personal_v2 is invalid. Received: " + tag);
            case 12:
                if ("layout/activity_student_card_0".equals(tag)) {
                    return new ActivityStudentCardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_student_card is invalid. Received: " + tag);
            case 13:
                if ("layout/compat_activity_ad_report_0".equals(tag)) {
                    return new CompatActivityAdReportBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for compat_activity_ad_report is invalid. Received: " + tag);
            case 14:
                if ("layout/compat_activity_push_setting_0".equals(tag)) {
                    return new CompatActivityPushSettingBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for compat_activity_push_setting is invalid. Received: " + tag);
            case 15:
                if ("layout/compat_activity_user_face_0".equals(tag)) {
                    return new CompatActivityUserFaceBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for compat_activity_user_face is invalid. Received: " + tag);
            case 16:
                if ("layout/compat_item_push_setting_content_0".equals(tag)) {
                    return new CompatItemPushSettingContentBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for compat_item_push_setting_content is invalid. Received: " + tag);
            case 17:
                if ("layout/compat_item_push_setting_title_0".equals(tag)) {
                    return new CompatItemPushSettingTitleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for compat_item_push_setting_title is invalid. Received: " + tag);
            case 18:
                if ("layout/item_student_course_0".equals(tag)) {
                    return new ItemStudentCourseBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_student_course is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.coroutines.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f33980a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i2) {
        if (viewArr == null || viewArr.length == 0 || f8978a.get(i2) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}

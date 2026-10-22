package com.huachenjie.login;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.coroutines.DataBinderMapper;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.login.databinding.LoginActivityAccountBindingImpl;
import com.huachenjie.login.databinding.LoginActivityBindPhoneBindingImpl;
import com.huachenjie.login.databinding.LoginActivityChoosePortraitBindingImpl;
import com.huachenjie.login.databinding.LoginActivityChooseSexBindingImpl;
import com.huachenjie.login.databinding.LoginActivityChooseUniversityBindingImpl;
import com.huachenjie.login.databinding.LoginActivityFillNicknameBindingImpl;
import com.huachenjie.login.databinding.LoginActivityGenerateAlumnusBindingImpl;
import com.huachenjie.login.databinding.LoginActivityPasswordBindingImpl;
import com.huachenjie.login.databinding.LoginActivityPasswordSetBindingImpl;
import com.huachenjie.login.databinding.LoginActivitySchoolCertificationBindingImpl;
import com.huachenjie.login.databinding.LoginActivitySchoolCertificationWebBindingImpl;
import com.huachenjie.login.databinding.LoginActivitySearchSchoolBindingImpl;
import com.huachenjie.login.databinding.LoginActivityVerifyCodeBindingImpl;
import com.huachenjie.login.databinding.LoginActivityWecomeLoginBindingImpl;
import com.huachenjie.login.databinding.LoginItemChoosePortraitBindingImpl;
import com.huachenjie.login.databinding.LoginItemSchoolCertificationBindingImpl;
import com.huachenjie.login.databinding.LoginItemSearchSchoolBindingImpl;
import com.huachenjie.login.databinding.LoginLayoutProtocolCheckboxBindingImpl;
import com.huachenjie.login.databinding.LoginLayoutThirdLoginBindingImpl;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class DataBinderMapperImpl extends DataBinderMapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f34608a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final SparseIntArray f9914a;
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
    public static final int s = 19;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SparseArray<String> f34609a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(9);
            f34609a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
            sparseArray.put(2, "checked");
            sparseArray.put(3, "click");
            sparseArray.put(4, "data");
            sparseArray.put(5, "isSelected");
            sparseArray.put(6, "portraitUrl");
            sparseArray.put(7, "title");
            sparseArray.put(8, "vm");
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HashMap<String, Integer> f34610a;

        static {
            HashMap<String, Integer> map = new HashMap<>(19);
            f34610a = map;
            map.put("layout/login_activity_account_0", Integer.valueOf(R.layout.login_activity_account));
            map.put("layout/login_activity_bind_phone_0", Integer.valueOf(R.layout.login_activity_bind_phone));
            map.put("layout/login_activity_choose_portrait_0", Integer.valueOf(R.layout.login_activity_choose_portrait));
            map.put("layout/login_activity_choose_sex_0", Integer.valueOf(R.layout.login_activity_choose_sex));
            map.put("layout/login_activity_choose_university_0", Integer.valueOf(R.layout.login_activity_choose_university));
            map.put("layout/login_activity_fill_nickname_0", Integer.valueOf(R.layout.login_activity_fill_nickname));
            map.put("layout/login_activity_generate_alumnus_0", Integer.valueOf(R.layout.login_activity_generate_alumnus));
            map.put("layout/login_activity_password_0", Integer.valueOf(R.layout.login_activity_password));
            map.put("layout/login_activity_password_set_0", Integer.valueOf(R.layout.login_activity_password_set));
            map.put("layout/login_activity_school_certification_0", Integer.valueOf(R.layout.login_activity_school_certification));
            map.put("layout/login_activity_school_certification_web_0", Integer.valueOf(R.layout.login_activity_school_certification_web));
            map.put("layout/login_activity_search_school_0", Integer.valueOf(R.layout.login_activity_search_school));
            map.put("layout/login_activity_verify_code_0", Integer.valueOf(R.layout.login_activity_verify_code));
            map.put("layout/login_activity_wecome_login_0", Integer.valueOf(R.layout.login_activity_wecome_login));
            map.put("layout/login_item_choose_portrait_0", Integer.valueOf(R.layout.login_item_choose_portrait));
            map.put("layout/login_item_school_certification_0", Integer.valueOf(R.layout.login_item_school_certification));
            map.put("layout/login_item_search_school_0", Integer.valueOf(R.layout.login_item_search_school));
            map.put("layout/login_layout_protocol_checkbox_0", Integer.valueOf(R.layout.login_layout_protocol_checkbox));
            map.put("layout/login_layout_third_login_0", Integer.valueOf(R.layout.login_layout_third_login));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(19);
        f9914a = sparseIntArray;
        sparseIntArray.put(R.layout.login_activity_account, 1);
        sparseIntArray.put(R.layout.login_activity_bind_phone, 2);
        sparseIntArray.put(R.layout.login_activity_choose_portrait, 3);
        sparseIntArray.put(R.layout.login_activity_choose_sex, 4);
        sparseIntArray.put(R.layout.login_activity_choose_university, 5);
        sparseIntArray.put(R.layout.login_activity_fill_nickname, 6);
        sparseIntArray.put(R.layout.login_activity_generate_alumnus, 7);
        sparseIntArray.put(R.layout.login_activity_password, 8);
        sparseIntArray.put(R.layout.login_activity_password_set, 9);
        sparseIntArray.put(R.layout.login_activity_school_certification, 10);
        sparseIntArray.put(R.layout.login_activity_school_certification_web, 11);
        sparseIntArray.put(R.layout.login_activity_search_school, 12);
        sparseIntArray.put(R.layout.login_activity_verify_code, 13);
        sparseIntArray.put(R.layout.login_activity_wecome_login, 14);
        sparseIntArray.put(R.layout.login_item_choose_portrait, 15);
        sparseIntArray.put(R.layout.login_item_school_certification, 16);
        sparseIntArray.put(R.layout.login_item_search_school, 17);
        sparseIntArray.put(R.layout.login_layout_protocol_checkbox, 18);
        sparseIntArray.put(R.layout.login_layout_third_login, 19);
    }

    @Override // androidx.coroutines.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(8);
        arrayList.add(new androidx.coroutines.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.flyco.tablayout.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.ad.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.base.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.common.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.pay.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.qrcode.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.step.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.coroutines.DataBinderMapper
    public String convertBrIdToString(int i2) {
        return a.f34609a.get(i2);
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i2) {
        int i3 = f9914a.get(i2);
        if (i3 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i3) {
            case 1:
                if ("layout/login_activity_account_0".equals(tag)) {
                    return new LoginActivityAccountBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for login_activity_account is invalid. Received: " + tag);
            case 2:
                if ("layout/login_activity_bind_phone_0".equals(tag)) {
                    return new LoginActivityBindPhoneBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for login_activity_bind_phone is invalid. Received: " + tag);
            case 3:
                if ("layout/login_activity_choose_portrait_0".equals(tag)) {
                    return new LoginActivityChoosePortraitBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for login_activity_choose_portrait is invalid. Received: " + tag);
            case 4:
                if ("layout/login_activity_choose_sex_0".equals(tag)) {
                    return new LoginActivityChooseSexBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for login_activity_choose_sex is invalid. Received: " + tag);
            case 5:
                if ("layout/login_activity_choose_university_0".equals(tag)) {
                    return new LoginActivityChooseUniversityBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for login_activity_choose_university is invalid. Received: " + tag);
            case 6:
                if ("layout/login_activity_fill_nickname_0".equals(tag)) {
                    return new LoginActivityFillNicknameBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for login_activity_fill_nickname is invalid. Received: " + tag);
            case 7:
                if ("layout/login_activity_generate_alumnus_0".equals(tag)) {
                    return new LoginActivityGenerateAlumnusBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for login_activity_generate_alumnus is invalid. Received: " + tag);
            case 8:
                if ("layout/login_activity_password_0".equals(tag)) {
                    return new LoginActivityPasswordBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for login_activity_password is invalid. Received: " + tag);
            case 9:
                if ("layout/login_activity_password_set_0".equals(tag)) {
                    return new LoginActivityPasswordSetBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for login_activity_password_set is invalid. Received: " + tag);
            case 10:
                if ("layout/login_activity_school_certification_0".equals(tag)) {
                    return new LoginActivitySchoolCertificationBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for login_activity_school_certification is invalid. Received: " + tag);
            case 11:
                if ("layout/login_activity_school_certification_web_0".equals(tag)) {
                    return new LoginActivitySchoolCertificationWebBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for login_activity_school_certification_web is invalid. Received: " + tag);
            case 12:
                if ("layout/login_activity_search_school_0".equals(tag)) {
                    return new LoginActivitySearchSchoolBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for login_activity_search_school is invalid. Received: " + tag);
            case 13:
                if ("layout/login_activity_verify_code_0".equals(tag)) {
                    return new LoginActivityVerifyCodeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for login_activity_verify_code is invalid. Received: " + tag);
            case 14:
                if ("layout/login_activity_wecome_login_0".equals(tag)) {
                    return new LoginActivityWecomeLoginBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for login_activity_wecome_login is invalid. Received: " + tag);
            case 15:
                if ("layout/login_item_choose_portrait_0".equals(tag)) {
                    return new LoginItemChoosePortraitBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for login_item_choose_portrait is invalid. Received: " + tag);
            case 16:
                if ("layout/login_item_school_certification_0".equals(tag)) {
                    return new LoginItemSchoolCertificationBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for login_item_school_certification is invalid. Received: " + tag);
            case 17:
                if ("layout/login_item_search_school_0".equals(tag)) {
                    return new LoginItemSearchSchoolBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for login_item_search_school is invalid. Received: " + tag);
            case 18:
                if ("layout/login_layout_protocol_checkbox_0".equals(tag)) {
                    return new LoginLayoutProtocolCheckboxBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for login_layout_protocol_checkbox is invalid. Received: " + tag);
            case 19:
                if ("layout/login_layout_third_login_0".equals(tag)) {
                    return new LoginLayoutThirdLoginBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for login_layout_third_login is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.coroutines.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f34610a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i2) {
        if (viewArr == null || viewArr.length == 0 || f9914a.get(i2) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}

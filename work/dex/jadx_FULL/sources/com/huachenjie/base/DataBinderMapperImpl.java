package com.huachenjie.base;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.coroutines.DataBinderMapper;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.huachenjie.base.databinding.BaseDialogMoreOptBindingImpl;
import com.huachenjie.base.databinding.BaseItemMoreOptBindingImpl;
import com.huachenjie.base.databinding.DialogInspirationBindingImpl;
import com.huachenjie.base.databinding.DialogLetterImportantBindingImpl;
import com.huachenjie.base.databinding.DialogLotteryBindingImpl;
import com.huachenjie.base.databinding.DialogOpenOaidBindingImpl;
import com.huachenjie.base.databinding.FragmentDetectFaceAuthBindingImpl;
import com.huachenjie.base.databinding.FragmentDetectFaceBindingImpl;
import com.huachenjie.base.databinding.FragmentDetectFaceCheckBindingImpl;
import com.huachenjie.base.databinding.FragmentDetectFaceLocalCheckBindingImpl;
import com.huachenjie.base.databinding.FragmentDetectFaceNoticeBindingImpl;
import com.huachenjie.base.databinding.FragmentDetectFaceUploadBindingImpl;
import com.huachenjie.base.databinding.FragmentDetectLaseFaceBindingImpl;
import com.huachenjie.base.databinding.LayoutEmptyChannelListBindingImpl;
import com.huachenjie.base.databinding.LayoutEmptyChatTeamBindingImpl;
import com.huachenjie.base.databinding.LayoutEmptyCommonBindingImpl;
import com.huachenjie.base.databinding.LayoutEmptyContactBindingImpl;
import com.huachenjie.base.databinding.LayoutEmptyDataBindingImpl;
import com.huachenjie.base.databinding.LayoutEmptyFriendBindingImpl;
import com.huachenjie.base.databinding.LayoutEmptyWorkBindingImpl;
import com.huachenjie.base.databinding.ViewItemImagePickAddBindingImpl;
import com.huachenjie.base.databinding.ViewItemImagePickImageBindingImpl;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class DataBinderMapperImpl extends DataBinderMapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f32757a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final SparseIntArray f6925a;
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
    public static final int t = 20;
    public static final int u = 21;
    public static final int v = 22;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SparseArray<String> f32758a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(7);
            f32758a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
            sparseArray.put(2, "checked");
            sparseArray.put(3, "click");
            sparseArray.put(4, "data");
            sparseArray.put(5, "title");
            sparseArray.put(6, "vm");
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HashMap<String, Integer> f32759a;

        static {
            HashMap<String, Integer> map = new HashMap<>(22);
            f32759a = map;
            map.put("layout/base_dialog_more_opt_0", Integer.valueOf(R.layout.base_dialog_more_opt));
            map.put("layout/base_item_more_opt_0", Integer.valueOf(R.layout.base_item_more_opt));
            map.put("layout/dialog_inspiration_0", Integer.valueOf(R.layout.dialog_inspiration));
            map.put("layout/dialog_letter_important_0", Integer.valueOf(R.layout.dialog_letter_important));
            map.put("layout/dialog_lottery_0", Integer.valueOf(R.layout.dialog_lottery));
            map.put("layout/dialog_open_oaid_0", Integer.valueOf(R.layout.dialog_open_oaid));
            map.put("layout/fragment_detect_face_0", Integer.valueOf(R.layout.fragment_detect_face));
            map.put("layout/fragment_detect_face_auth_0", Integer.valueOf(R.layout.fragment_detect_face_auth));
            map.put("layout/fragment_detect_face_check_0", Integer.valueOf(R.layout.fragment_detect_face_check));
            map.put("layout/fragment_detect_face_local_check_0", Integer.valueOf(R.layout.fragment_detect_face_local_check));
            map.put("layout/fragment_detect_face_notice_0", Integer.valueOf(R.layout.fragment_detect_face_notice));
            map.put("layout/fragment_detect_face_upload_0", Integer.valueOf(R.layout.fragment_detect_face_upload));
            map.put("layout/fragment_detect_lase_face_0", Integer.valueOf(R.layout.fragment_detect_lase_face));
            map.put("layout/layout_empty_channel_list_0", Integer.valueOf(R.layout.layout_empty_channel_list));
            map.put("layout/layout_empty_chat_team_0", Integer.valueOf(R.layout.layout_empty_chat_team));
            map.put("layout/layout_empty_common_0", Integer.valueOf(R.layout.layout_empty_common));
            map.put("layout/layout_empty_contact_0", Integer.valueOf(R.layout.layout_empty_contact));
            map.put("layout/layout_empty_data_0", Integer.valueOf(R.layout.layout_empty_data));
            map.put("layout/layout_empty_friend_0", Integer.valueOf(R.layout.layout_empty_friend));
            map.put("layout/layout_empty_work_0", Integer.valueOf(R.layout.layout_empty_work));
            map.put("layout/view_item_image_pick_add_0", Integer.valueOf(R.layout.view_item_image_pick_add));
            map.put("layout/view_item_image_pick_image_0", Integer.valueOf(R.layout.view_item_image_pick_image));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(22);
        f6925a = sparseIntArray;
        sparseIntArray.put(R.layout.base_dialog_more_opt, 1);
        sparseIntArray.put(R.layout.base_item_more_opt, 2);
        sparseIntArray.put(R.layout.dialog_inspiration, 3);
        sparseIntArray.put(R.layout.dialog_letter_important, 4);
        sparseIntArray.put(R.layout.dialog_lottery, 5);
        sparseIntArray.put(R.layout.dialog_open_oaid, 6);
        sparseIntArray.put(R.layout.fragment_detect_face, 7);
        sparseIntArray.put(R.layout.fragment_detect_face_auth, 8);
        sparseIntArray.put(R.layout.fragment_detect_face_check, 9);
        sparseIntArray.put(R.layout.fragment_detect_face_local_check, 10);
        sparseIntArray.put(R.layout.fragment_detect_face_notice, 11);
        sparseIntArray.put(R.layout.fragment_detect_face_upload, 12);
        sparseIntArray.put(R.layout.fragment_detect_lase_face, 13);
        sparseIntArray.put(R.layout.layout_empty_channel_list, 14);
        sparseIntArray.put(R.layout.layout_empty_chat_team, 15);
        sparseIntArray.put(R.layout.layout_empty_common, 16);
        sparseIntArray.put(R.layout.layout_empty_contact, 17);
        sparseIntArray.put(R.layout.layout_empty_data, 18);
        sparseIntArray.put(R.layout.layout_empty_friend, 19);
        sparseIntArray.put(R.layout.layout_empty_work, 20);
        sparseIntArray.put(R.layout.view_item_image_pick_add, 21);
        sparseIntArray.put(R.layout.view_item_image_pick_image, 22);
    }

    @Override // androidx.coroutines.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(7);
        arrayList.add(new androidx.coroutines.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.flyco.tablayout.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.ad.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.common.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.pay.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.qrcode.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.step.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.coroutines.DataBinderMapper
    public String convertBrIdToString(int localId) {
        return a.f32758a.get(localId);
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
        int i2 = f6925a.get(layoutId);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i2) {
            case 1:
                if ("layout/base_dialog_more_opt_0".equals(tag)) {
                    return new BaseDialogMoreOptBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for base_dialog_more_opt is invalid. Received: " + tag);
            case 2:
                if ("layout/base_item_more_opt_0".equals(tag)) {
                    return new BaseItemMoreOptBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for base_item_more_opt is invalid. Received: " + tag);
            case 3:
                if ("layout/dialog_inspiration_0".equals(tag)) {
                    return new DialogInspirationBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_inspiration is invalid. Received: " + tag);
            case 4:
                if ("layout/dialog_letter_important_0".equals(tag)) {
                    return new DialogLetterImportantBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_letter_important is invalid. Received: " + tag);
            case 5:
                if ("layout/dialog_lottery_0".equals(tag)) {
                    return new DialogLotteryBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_lottery is invalid. Received: " + tag);
            case 6:
                if ("layout/dialog_open_oaid_0".equals(tag)) {
                    return new DialogOpenOaidBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_open_oaid is invalid. Received: " + tag);
            case 7:
                if ("layout/fragment_detect_face_0".equals(tag)) {
                    return new FragmentDetectFaceBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_detect_face is invalid. Received: " + tag);
            case 8:
                if ("layout/fragment_detect_face_auth_0".equals(tag)) {
                    return new FragmentDetectFaceAuthBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_detect_face_auth is invalid. Received: " + tag);
            case 9:
                if ("layout/fragment_detect_face_check_0".equals(tag)) {
                    return new FragmentDetectFaceCheckBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_detect_face_check is invalid. Received: " + tag);
            case 10:
                if ("layout/fragment_detect_face_local_check_0".equals(tag)) {
                    return new FragmentDetectFaceLocalCheckBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_detect_face_local_check is invalid. Received: " + tag);
            case 11:
                if ("layout/fragment_detect_face_notice_0".equals(tag)) {
                    return new FragmentDetectFaceNoticeBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_detect_face_notice is invalid. Received: " + tag);
            case 12:
                if ("layout/fragment_detect_face_upload_0".equals(tag)) {
                    return new FragmentDetectFaceUploadBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_detect_face_upload is invalid. Received: " + tag);
            case 13:
                if ("layout/fragment_detect_lase_face_0".equals(tag)) {
                    return new FragmentDetectLaseFaceBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for fragment_detect_lase_face is invalid. Received: " + tag);
            case 14:
                if ("layout/layout_empty_channel_list_0".equals(tag)) {
                    return new LayoutEmptyChannelListBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for layout_empty_channel_list is invalid. Received: " + tag);
            case 15:
                if ("layout/layout_empty_chat_team_0".equals(tag)) {
                    return new LayoutEmptyChatTeamBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for layout_empty_chat_team is invalid. Received: " + tag);
            case 16:
                if ("layout/layout_empty_common_0".equals(tag)) {
                    return new LayoutEmptyCommonBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for layout_empty_common is invalid. Received: " + tag);
            case 17:
                if ("layout/layout_empty_contact_0".equals(tag)) {
                    return new LayoutEmptyContactBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for layout_empty_contact is invalid. Received: " + tag);
            case 18:
                if ("layout/layout_empty_data_0".equals(tag)) {
                    return new LayoutEmptyDataBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for layout_empty_data is invalid. Received: " + tag);
            case 19:
                if ("layout/layout_empty_friend_0".equals(tag)) {
                    return new LayoutEmptyFriendBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for layout_empty_friend is invalid. Received: " + tag);
            case 20:
                if ("layout/layout_empty_work_0".equals(tag)) {
                    return new LayoutEmptyWorkBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for layout_empty_work is invalid. Received: " + tag);
            case 21:
                if ("layout/view_item_image_pick_add_0".equals(tag)) {
                    return new ViewItemImagePickAddBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for view_item_image_pick_add is invalid. Received: " + tag);
            case 22:
                if ("layout/view_item_image_pick_image_0".equals(tag)) {
                    return new ViewItemImagePickImageBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for view_item_image_pick_image is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.coroutines.DataBinderMapper
    public int getLayoutId(String tag) {
        Integer num;
        if (tag == null || (num = b.f32759a.get(tag)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
        if (views == null || views.length == 0 || f6925a.get(layoutId) <= 0 || views[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}

package com.huachenjie.im;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.coroutines.DataBinderMapper;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.alipay.sdk.m.c0.d;
import com.huachenjie.im.databinding.ActivityChatBindingImpl;
import com.huachenjie.im.databinding.ActivityChatRoomBindingImpl;
import com.huachenjie.im.databinding.ActivityChatTeamBindingImpl;
import com.huachenjie.im.databinding.ActivitySignalTowerBindingImpl;
import com.huachenjie.im.databinding.ActivityTeamMemberBindingImpl;
import com.huachenjie.im.databinding.ChatItemTeamMemberBindingImpl;
import com.huachenjie.im.databinding.FragmentChatRoomBindingImpl;
import com.huachenjie.im.databinding.FragmentChatTeamBindingImpl;
import com.huachenjie.im.databinding.FragmentEmojiBindingImpl;
import com.huachenjie.im.databinding.FragmentEmojiPanelBindingImpl;
import com.huachenjie.im.databinding.FragmentFloatingSignalTowerBindingImpl;
import com.huachenjie.im.databinding.FragmentInputPanelBindingImpl;
import com.huachenjie.im.databinding.FragmentSignalTowerBindingImpl;
import com.huachenjie.im.databinding.FragmentSingleChatBindingImpl;
import com.huachenjie.im.databinding.FragmentStickerBindingImpl;
import com.huachenjie.im.databinding.ItemStickerBindingImpl;
import com.huachenjie.im.databinding.ItemStickerIconBindingImpl;
import com.huachenjie.im.databinding.LayoutContactEmptyBindingImpl;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class DataBinderMapperImpl extends DataBinderMapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f34378a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final SparseIntArray f9620a;
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
        public static final SparseArray<String> f34379a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(9);
            f34379a = sparseArray;
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
        public static final HashMap<String, Integer> f34380a;

        static {
            HashMap<String, Integer> map = new HashMap<>(18);
            f34380a = map;
            map.put("layout/activity_chat_0", Integer.valueOf(R.layout.activity_chat));
            map.put("layout/activity_chat_room_0", Integer.valueOf(R.layout.activity_chat_room));
            map.put("layout/activity_chat_team_0", Integer.valueOf(R.layout.activity_chat_team));
            map.put("layout/activity_signal_tower_0", Integer.valueOf(R.layout.activity_signal_tower));
            map.put("layout/activity_team_member_0", Integer.valueOf(R.layout.activity_team_member));
            map.put("layout/chat_item_team_member_0", Integer.valueOf(R.layout.chat_item_team_member));
            map.put("layout/fragment_chat_room_0", Integer.valueOf(R.layout.fragment_chat_room));
            map.put("layout/fragment_chat_team_0", Integer.valueOf(R.layout.fragment_chat_team));
            map.put("layout/fragment_emoji_0", Integer.valueOf(R.layout.fragment_emoji));
            map.put("layout/fragment_emoji_panel_0", Integer.valueOf(R.layout.fragment_emoji_panel));
            map.put("layout/fragment_floating_signal_tower_0", Integer.valueOf(R.layout.fragment_floating_signal_tower));
            map.put("layout/fragment_input_panel_0", Integer.valueOf(R.layout.fragment_input_panel));
            map.put("layout/fragment_signal_tower_0", Integer.valueOf(R.layout.fragment_signal_tower));
            map.put("layout/fragment_single_chat_0", Integer.valueOf(R.layout.fragment_single_chat));
            map.put("layout/fragment_sticker_0", Integer.valueOf(R.layout.fragment_sticker));
            map.put("layout/item_sticker_0", Integer.valueOf(R.layout.item_sticker));
            map.put("layout/item_sticker_icon_0", Integer.valueOf(R.layout.item_sticker_icon));
            map.put("layout/layout_contact_empty_0", Integer.valueOf(R.layout.layout_contact_empty));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(18);
        f9620a = sparseIntArray;
        sparseIntArray.put(R.layout.activity_chat, 1);
        sparseIntArray.put(R.layout.activity_chat_room, 2);
        sparseIntArray.put(R.layout.activity_chat_team, 3);
        sparseIntArray.put(R.layout.activity_signal_tower, 4);
        sparseIntArray.put(R.layout.activity_team_member, 5);
        sparseIntArray.put(R.layout.chat_item_team_member, 6);
        sparseIntArray.put(R.layout.fragment_chat_room, 7);
        sparseIntArray.put(R.layout.fragment_chat_team, 8);
        sparseIntArray.put(R.layout.fragment_emoji, 9);
        sparseIntArray.put(R.layout.fragment_emoji_panel, 10);
        sparseIntArray.put(R.layout.fragment_floating_signal_tower, 11);
        sparseIntArray.put(R.layout.fragment_input_panel, 12);
        sparseIntArray.put(R.layout.fragment_signal_tower, 13);
        sparseIntArray.put(R.layout.fragment_single_chat, 14);
        sparseIntArray.put(R.layout.fragment_sticker, 15);
        sparseIntArray.put(R.layout.item_sticker, 16);
        sparseIntArray.put(R.layout.item_sticker_icon, 17);
        sparseIntArray.put(R.layout.layout_contact_empty, 18);
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
        return a.f34379a.get(i2);
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i2) {
        int i3 = f9620a.get(i2);
        if (i3 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i3) {
            case 1:
                if ("layout/activity_chat_0".equals(tag)) {
                    return new ActivityChatBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_chat is invalid. Received: " + tag);
            case 2:
                if ("layout/activity_chat_room_0".equals(tag)) {
                    return new ActivityChatRoomBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_chat_room is invalid. Received: " + tag);
            case 3:
                if ("layout/activity_chat_team_0".equals(tag)) {
                    return new ActivityChatTeamBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_chat_team is invalid. Received: " + tag);
            case 4:
                if ("layout/activity_signal_tower_0".equals(tag)) {
                    return new ActivitySignalTowerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_signal_tower is invalid. Received: " + tag);
            case 5:
                if ("layout/activity_team_member_0".equals(tag)) {
                    return new ActivityTeamMemberBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_team_member is invalid. Received: " + tag);
            case 6:
                if ("layout/chat_item_team_member_0".equals(tag)) {
                    return new ChatItemTeamMemberBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for chat_item_team_member is invalid. Received: " + tag);
            case 7:
                if ("layout/fragment_chat_room_0".equals(tag)) {
                    return new FragmentChatRoomBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_chat_room is invalid. Received: " + tag);
            case 8:
                if ("layout/fragment_chat_team_0".equals(tag)) {
                    return new FragmentChatTeamBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_chat_team is invalid. Received: " + tag);
            case 9:
                if ("layout/fragment_emoji_0".equals(tag)) {
                    return new FragmentEmojiBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_emoji is invalid. Received: " + tag);
            case 10:
                if ("layout/fragment_emoji_panel_0".equals(tag)) {
                    return new FragmentEmojiPanelBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_emoji_panel is invalid. Received: " + tag);
            case 11:
                if ("layout/fragment_floating_signal_tower_0".equals(tag)) {
                    return new FragmentFloatingSignalTowerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_floating_signal_tower is invalid. Received: " + tag);
            case 12:
                if ("layout/fragment_input_panel_0".equals(tag)) {
                    return new FragmentInputPanelBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_input_panel is invalid. Received: " + tag);
            case 13:
                if ("layout/fragment_signal_tower_0".equals(tag)) {
                    return new FragmentSignalTowerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_signal_tower is invalid. Received: " + tag);
            case 14:
                if ("layout/fragment_single_chat_0".equals(tag)) {
                    return new FragmentSingleChatBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_single_chat is invalid. Received: " + tag);
            case 15:
                if ("layout/fragment_sticker_0".equals(tag)) {
                    return new FragmentStickerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_sticker is invalid. Received: " + tag);
            case 16:
                if ("layout/item_sticker_0".equals(tag)) {
                    return new ItemStickerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_sticker is invalid. Received: " + tag);
            case 17:
                if ("layout/item_sticker_icon_0".equals(tag)) {
                    return new ItemStickerIconBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_sticker_icon is invalid. Received: " + tag);
            case 18:
                if ("layout/layout_contact_empty_0".equals(tag)) {
                    return new LayoutContactEmptyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_contact_empty is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.coroutines.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f34380a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i2) {
        if (viewArr == null || viewArr.length == 0 || f9620a.get(i2) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}

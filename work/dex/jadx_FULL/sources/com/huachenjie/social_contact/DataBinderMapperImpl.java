package com.huachenjie.social_contact;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.coroutines.DataBinderMapper;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.alipay.sdk.m.c0.d;
import com.huachenjie.social_contact.databinding.ActivityEmojiStickerBindingImpl;
import com.huachenjie.social_contact.databinding.ActivityEmojiStickerCreateBindingImpl;
import com.huachenjie.social_contact.databinding.ActivityEmojiStickerDetailBindingImpl;
import com.huachenjie.social_contact.databinding.ActivityEmojiStickerMineBindingImpl;
import com.huachenjie.social_contact.databinding.ActivityEmojiStickerSearchBindingImpl;
import com.huachenjie.social_contact.databinding.ActivityPayBindingImpl;
import com.huachenjie.social_contact.databinding.ActivityRechargeBindingImpl;
import com.huachenjie.social_contact.databinding.ActivityReplenishEnergyBindingImpl;
import com.huachenjie.social_contact.databinding.ActivityReportUserBindingImpl;
import com.huachenjie.social_contact.databinding.ActivitySearchFriendIdBindingImpl;
import com.huachenjie.social_contact.databinding.ActivitySuperPackBindingImpl;
import com.huachenjie.social_contact.databinding.ActivityUserWearBindingImpl;
import com.huachenjie.social_contact.databinding.ActivityWorldLetterBindingImpl;
import com.huachenjie.social_contact.databinding.DialogBuySuccessBindingImpl;
import com.huachenjie.social_contact.databinding.DialogEmojiStickerExplainBindingImpl;
import com.huachenjie.social_contact.databinding.DialogEmojiStickerReportBindingImpl;
import com.huachenjie.social_contact.databinding.DialogEmojiStickerSuccessBindingImpl;
import com.huachenjie.social_contact.databinding.DialogExchangeWorldCrystalsBindingImpl;
import com.huachenjie.social_contact.databinding.DialogLoadingTipBindingImpl;
import com.huachenjie.social_contact.databinding.DialogPropLetterBindingImpl;
import com.huachenjie.social_contact.databinding.DialogReceiveSysGiftBindingImpl;
import com.huachenjie.social_contact.databinding.DialogShareEmojiFriendBindingImpl;
import com.huachenjie.social_contact.databinding.FragmentReplenishEnergyListBindingImpl;
import com.huachenjie.social_contact.databinding.FragmentUserWearGameBindingImpl;
import com.huachenjie.social_contact.databinding.FragmentUserWearIpBindingImpl;
import com.huachenjie.social_contact.databinding.FragmentUserWearSuitBindingImpl;
import com.huachenjie.social_contact.databinding.FragmentUserWearSuitListBindingImpl;
import com.huachenjie.social_contact.databinding.FragmnetEmojiStickerMineBindingImpl;
import com.huachenjie.social_contact.databinding.ItemEmojiStickerAddBindingImpl;
import com.huachenjie.social_contact.databinding.ItemEmojiStickerBindingImpl;
import com.huachenjie.social_contact.databinding.ItemEmojiStickerCreateBindingImpl;
import com.huachenjie.social_contact.databinding.ItemEmojiStickerDetailBindingImpl;
import com.huachenjie.social_contact.databinding.ItemEmojiStickerTitleBindingImpl;
import com.huachenjie.social_contact.databinding.ItemReplenishEnergyListBindingImpl;
import com.huachenjie.social_contact.databinding.ItemReportImageEvidenceBindingImpl;
import com.huachenjie.social_contact.databinding.ItemReportUserBindingImpl;
import com.huachenjie.social_contact.databinding.ItemShareEmojiFriendBindingImpl;
import com.huachenjie.social_contact.databinding.ItemWorldLetterBindingImpl;
import com.huachenjie.social_contact.databinding.LayoutEmijiStickerEmptyBindingImpl;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    public static final int A = 27;
    public static final int B = 28;
    public static final int C = 29;
    public static final int D = 30;
    public static final int E = 31;
    public static final int F = 32;
    public static final int G = 33;
    public static final int H = 34;
    public static final int I = 35;
    public static final int J = 36;
    public static final int K = 37;
    public static final int L = 38;
    public static final int M = 39;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f36066a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final SparseIntArray f12685a;
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
    public static final int w = 23;
    public static final int x = 24;
    public static final int y = 25;
    public static final int z = 26;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SparseArray<String> f36067a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(9);
            f36067a = sparseArray;
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
        public static final HashMap<String, Integer> f36068a;

        static {
            HashMap<String, Integer> map = new HashMap<>(39);
            f36068a = map;
            map.put("layout/activity_emoji_sticker_0", Integer.valueOf(R.layout.activity_emoji_sticker));
            map.put("layout/activity_emoji_sticker_create_0", Integer.valueOf(R.layout.activity_emoji_sticker_create));
            map.put("layout/activity_emoji_sticker_detail_0", Integer.valueOf(R.layout.activity_emoji_sticker_detail));
            map.put("layout/activity_emoji_sticker_mine_0", Integer.valueOf(R.layout.activity_emoji_sticker_mine));
            map.put("layout/activity_emoji_sticker_search_0", Integer.valueOf(R.layout.activity_emoji_sticker_search));
            map.put("layout/activity_pay_0", Integer.valueOf(R.layout.activity_pay));
            map.put("layout/activity_recharge_0", Integer.valueOf(R.layout.activity_recharge));
            map.put("layout/activity_replenish_energy_0", Integer.valueOf(R.layout.activity_replenish_energy));
            map.put("layout/activity_report_user_0", Integer.valueOf(R.layout.activity_report_user));
            map.put("layout/activity_search_friend_id_0", Integer.valueOf(R.layout.activity_search_friend_id));
            map.put("layout/activity_super_pack_0", Integer.valueOf(R.layout.activity_super_pack));
            map.put("layout/activity_user_wear_0", Integer.valueOf(R.layout.activity_user_wear));
            map.put("layout/activity_world_letter_0", Integer.valueOf(R.layout.activity_world_letter));
            map.put("layout/dialog_buy_success_0", Integer.valueOf(R.layout.dialog_buy_success));
            map.put("layout/dialog_emoji_sticker_explain_0", Integer.valueOf(R.layout.dialog_emoji_sticker_explain));
            map.put("layout/dialog_emoji_sticker_report_0", Integer.valueOf(R.layout.dialog_emoji_sticker_report));
            map.put("layout/dialog_emoji_sticker_success_0", Integer.valueOf(R.layout.dialog_emoji_sticker_success));
            map.put("layout/dialog_exchange_world_crystals_0", Integer.valueOf(R.layout.dialog_exchange_world_crystals));
            map.put("layout/dialog_loading_tip_0", Integer.valueOf(R.layout.dialog_loading_tip));
            map.put("layout/dialog_prop_letter_0", Integer.valueOf(R.layout.dialog_prop_letter));
            map.put("layout/dialog_receive_sys_gift_0", Integer.valueOf(R.layout.dialog_receive_sys_gift));
            map.put("layout/dialog_share_emoji_friend_0", Integer.valueOf(R.layout.dialog_share_emoji_friend));
            map.put("layout/fragment_replenish_energy_list_0", Integer.valueOf(R.layout.fragment_replenish_energy_list));
            map.put("layout/fragment_user_wear_game_0", Integer.valueOf(R.layout.fragment_user_wear_game));
            map.put("layout/fragment_user_wear_ip_0", Integer.valueOf(R.layout.fragment_user_wear_ip));
            map.put("layout/fragment_user_wear_suit_0", Integer.valueOf(R.layout.fragment_user_wear_suit));
            map.put("layout/fragment_user_wear_suit_list_0", Integer.valueOf(R.layout.fragment_user_wear_suit_list));
            map.put("layout/fragmnet_emoji_sticker_mine_0", Integer.valueOf(R.layout.fragmnet_emoji_sticker_mine));
            map.put("layout/item_emoji_sticker_0", Integer.valueOf(R.layout.item_emoji_sticker));
            map.put("layout/item_emoji_sticker_add_0", Integer.valueOf(R.layout.item_emoji_sticker_add));
            map.put("layout/item_emoji_sticker_create_0", Integer.valueOf(R.layout.item_emoji_sticker_create));
            map.put("layout/item_emoji_sticker_detail_0", Integer.valueOf(R.layout.item_emoji_sticker_detail));
            map.put("layout/item_emoji_sticker_title_0", Integer.valueOf(R.layout.item_emoji_sticker_title));
            map.put("layout/item_replenish_energy_list_0", Integer.valueOf(R.layout.item_replenish_energy_list));
            map.put("layout/item_report_image_evidence_0", Integer.valueOf(R.layout.item_report_image_evidence));
            map.put("layout/item_report_user_0", Integer.valueOf(R.layout.item_report_user));
            map.put("layout/item_share_emoji_friend_0", Integer.valueOf(R.layout.item_share_emoji_friend));
            map.put("layout/item_world_letter_0", Integer.valueOf(R.layout.item_world_letter));
            map.put("layout/layout_emiji_sticker_empty_0", Integer.valueOf(R.layout.layout_emiji_sticker_empty));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(39);
        f12685a = sparseIntArray;
        sparseIntArray.put(R.layout.activity_emoji_sticker, 1);
        sparseIntArray.put(R.layout.activity_emoji_sticker_create, 2);
        sparseIntArray.put(R.layout.activity_emoji_sticker_detail, 3);
        sparseIntArray.put(R.layout.activity_emoji_sticker_mine, 4);
        sparseIntArray.put(R.layout.activity_emoji_sticker_search, 5);
        sparseIntArray.put(R.layout.activity_pay, 6);
        sparseIntArray.put(R.layout.activity_recharge, 7);
        sparseIntArray.put(R.layout.activity_replenish_energy, 8);
        sparseIntArray.put(R.layout.activity_report_user, 9);
        sparseIntArray.put(R.layout.activity_search_friend_id, 10);
        sparseIntArray.put(R.layout.activity_super_pack, 11);
        sparseIntArray.put(R.layout.activity_user_wear, 12);
        sparseIntArray.put(R.layout.activity_world_letter, 13);
        sparseIntArray.put(R.layout.dialog_buy_success, 14);
        sparseIntArray.put(R.layout.dialog_emoji_sticker_explain, 15);
        sparseIntArray.put(R.layout.dialog_emoji_sticker_report, 16);
        sparseIntArray.put(R.layout.dialog_emoji_sticker_success, 17);
        sparseIntArray.put(R.layout.dialog_exchange_world_crystals, 18);
        sparseIntArray.put(R.layout.dialog_loading_tip, 19);
        sparseIntArray.put(R.layout.dialog_prop_letter, 20);
        sparseIntArray.put(R.layout.dialog_receive_sys_gift, 21);
        sparseIntArray.put(R.layout.dialog_share_emoji_friend, 22);
        sparseIntArray.put(R.layout.fragment_replenish_energy_list, 23);
        sparseIntArray.put(R.layout.fragment_user_wear_game, 24);
        sparseIntArray.put(R.layout.fragment_user_wear_ip, 25);
        sparseIntArray.put(R.layout.fragment_user_wear_suit, 26);
        sparseIntArray.put(R.layout.fragment_user_wear_suit_list, 27);
        sparseIntArray.put(R.layout.fragmnet_emoji_sticker_mine, 28);
        sparseIntArray.put(R.layout.item_emoji_sticker, 29);
        sparseIntArray.put(R.layout.item_emoji_sticker_add, 30);
        sparseIntArray.put(R.layout.item_emoji_sticker_create, 31);
        sparseIntArray.put(R.layout.item_emoji_sticker_detail, 32);
        sparseIntArray.put(R.layout.item_emoji_sticker_title, 33);
        sparseIntArray.put(R.layout.item_replenish_energy_list, 34);
        sparseIntArray.put(R.layout.item_report_image_evidence, 35);
        sparseIntArray.put(R.layout.item_report_user, 36);
        sparseIntArray.put(R.layout.item_share_emoji_friend, 37);
        sparseIntArray.put(R.layout.item_world_letter, 38);
        sparseIntArray.put(R.layout.layout_emiji_sticker_empty, 39);
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
        return a.f36067a.get(i2);
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i2) {
        int i3 = f12685a.get(i2);
        if (i3 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i3) {
            case 1:
                if ("layout/activity_emoji_sticker_0".equals(tag)) {
                    return new ActivityEmojiStickerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_emoji_sticker is invalid. Received: " + tag);
            case 2:
                if ("layout/activity_emoji_sticker_create_0".equals(tag)) {
                    return new ActivityEmojiStickerCreateBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_emoji_sticker_create is invalid. Received: " + tag);
            case 3:
                if ("layout/activity_emoji_sticker_detail_0".equals(tag)) {
                    return new ActivityEmojiStickerDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_emoji_sticker_detail is invalid. Received: " + tag);
            case 4:
                if ("layout/activity_emoji_sticker_mine_0".equals(tag)) {
                    return new ActivityEmojiStickerMineBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_emoji_sticker_mine is invalid. Received: " + tag);
            case 5:
                if ("layout/activity_emoji_sticker_search_0".equals(tag)) {
                    return new ActivityEmojiStickerSearchBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_emoji_sticker_search is invalid. Received: " + tag);
            case 6:
                if ("layout/activity_pay_0".equals(tag)) {
                    return new ActivityPayBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_pay is invalid. Received: " + tag);
            case 7:
                if ("layout/activity_recharge_0".equals(tag)) {
                    return new ActivityRechargeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_recharge is invalid. Received: " + tag);
            case 8:
                if ("layout/activity_replenish_energy_0".equals(tag)) {
                    return new ActivityReplenishEnergyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_replenish_energy is invalid. Received: " + tag);
            case 9:
                if ("layout/activity_report_user_0".equals(tag)) {
                    return new ActivityReportUserBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_report_user is invalid. Received: " + tag);
            case 10:
                if ("layout/activity_search_friend_id_0".equals(tag)) {
                    return new ActivitySearchFriendIdBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_search_friend_id is invalid. Received: " + tag);
            case 11:
                if ("layout/activity_super_pack_0".equals(tag)) {
                    return new ActivitySuperPackBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_super_pack is invalid. Received: " + tag);
            case 12:
                if ("layout/activity_user_wear_0".equals(tag)) {
                    return new ActivityUserWearBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_user_wear is invalid. Received: " + tag);
            case 13:
                if ("layout/activity_world_letter_0".equals(tag)) {
                    return new ActivityWorldLetterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for activity_world_letter is invalid. Received: " + tag);
            case 14:
                if ("layout/dialog_buy_success_0".equals(tag)) {
                    return new DialogBuySuccessBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_buy_success is invalid. Received: " + tag);
            case 15:
                if ("layout/dialog_emoji_sticker_explain_0".equals(tag)) {
                    return new DialogEmojiStickerExplainBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_emoji_sticker_explain is invalid. Received: " + tag);
            case 16:
                if ("layout/dialog_emoji_sticker_report_0".equals(tag)) {
                    return new DialogEmojiStickerReportBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_emoji_sticker_report is invalid. Received: " + tag);
            case 17:
                if ("layout/dialog_emoji_sticker_success_0".equals(tag)) {
                    return new DialogEmojiStickerSuccessBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_emoji_sticker_success is invalid. Received: " + tag);
            case 18:
                if ("layout/dialog_exchange_world_crystals_0".equals(tag)) {
                    return new DialogExchangeWorldCrystalsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_exchange_world_crystals is invalid. Received: " + tag);
            case 19:
                if ("layout/dialog_loading_tip_0".equals(tag)) {
                    return new DialogLoadingTipBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_loading_tip is invalid. Received: " + tag);
            case 20:
                if ("layout/dialog_prop_letter_0".equals(tag)) {
                    return new DialogPropLetterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_prop_letter is invalid. Received: " + tag);
            case 21:
                if ("layout/dialog_receive_sys_gift_0".equals(tag)) {
                    return new DialogReceiveSysGiftBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_receive_sys_gift is invalid. Received: " + tag);
            case 22:
                if ("layout/dialog_share_emoji_friend_0".equals(tag)) {
                    return new DialogShareEmojiFriendBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for dialog_share_emoji_friend is invalid. Received: " + tag);
            case 23:
                if ("layout/fragment_replenish_energy_list_0".equals(tag)) {
                    return new FragmentReplenishEnergyListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_replenish_energy_list is invalid. Received: " + tag);
            case 24:
                if ("layout/fragment_user_wear_game_0".equals(tag)) {
                    return new FragmentUserWearGameBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_user_wear_game is invalid. Received: " + tag);
            case 25:
                if ("layout/fragment_user_wear_ip_0".equals(tag)) {
                    return new FragmentUserWearIpBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_user_wear_ip is invalid. Received: " + tag);
            case 26:
                if ("layout/fragment_user_wear_suit_0".equals(tag)) {
                    return new FragmentUserWearSuitBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_user_wear_suit is invalid. Received: " + tag);
            case 27:
                if ("layout/fragment_user_wear_suit_list_0".equals(tag)) {
                    return new FragmentUserWearSuitListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragment_user_wear_suit_list is invalid. Received: " + tag);
            case 28:
                if ("layout/fragmnet_emoji_sticker_mine_0".equals(tag)) {
                    return new FragmnetEmojiStickerMineBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for fragmnet_emoji_sticker_mine is invalid. Received: " + tag);
            case 29:
                if ("layout/item_emoji_sticker_0".equals(tag)) {
                    return new ItemEmojiStickerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_emoji_sticker is invalid. Received: " + tag);
            case 30:
                if ("layout/item_emoji_sticker_add_0".equals(tag)) {
                    return new ItemEmojiStickerAddBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_emoji_sticker_add is invalid. Received: " + tag);
            case 31:
                if ("layout/item_emoji_sticker_create_0".equals(tag)) {
                    return new ItemEmojiStickerCreateBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_emoji_sticker_create is invalid. Received: " + tag);
            case 32:
                if ("layout/item_emoji_sticker_detail_0".equals(tag)) {
                    return new ItemEmojiStickerDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_emoji_sticker_detail is invalid. Received: " + tag);
            case 33:
                if ("layout/item_emoji_sticker_title_0".equals(tag)) {
                    return new ItemEmojiStickerTitleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_emoji_sticker_title is invalid. Received: " + tag);
            case 34:
                if ("layout/item_replenish_energy_list_0".equals(tag)) {
                    return new ItemReplenishEnergyListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_replenish_energy_list is invalid. Received: " + tag);
            case 35:
                if ("layout/item_report_image_evidence_0".equals(tag)) {
                    return new ItemReportImageEvidenceBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_report_image_evidence is invalid. Received: " + tag);
            case 36:
                if ("layout/item_report_user_0".equals(tag)) {
                    return new ItemReportUserBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_report_user is invalid. Received: " + tag);
            case 37:
                if ("layout/item_share_emoji_friend_0".equals(tag)) {
                    return new ItemShareEmojiFriendBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_share_emoji_friend is invalid. Received: " + tag);
            case 38:
                if ("layout/item_world_letter_0".equals(tag)) {
                    return new ItemWorldLetterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for item_world_letter is invalid. Received: " + tag);
            case 39:
                if ("layout/layout_emiji_sticker_empty_0".equals(tag)) {
                    return new LayoutEmijiStickerEmptyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for layout_emiji_sticker_empty is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.coroutines.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f36068a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i2) {
        if (viewArr == null || viewArr.length == 0 || f12685a.get(i2) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}

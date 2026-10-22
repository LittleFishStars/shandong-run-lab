package com.huachenjie.home;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.coroutines.DataBinderMapper;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.alipay.sdk.m.c0.d;
import com.huachenjie.home.databinding.HomeActivityChangeRewardBindingImpl;
import com.huachenjie.home.databinding.HomeActivityInspirationRecordBindingImpl;
import com.huachenjie.home.databinding.HomeActivityLotteryDrawBindingImpl;
import com.huachenjie.home.databinding.HomeActivityRebateGoodsListBindingImpl;
import com.huachenjie.home.databinding.HomeActivityRewardDetailBindingImpl;
import com.huachenjie.home.databinding.HomeActivityRewardRecordBindingImpl;
import com.huachenjie.home.databinding.HomeActivityUnionGoodsSearchBindingImpl;
import com.huachenjie.home.databinding.HomeDialogDoubleRewardBindingImpl;
import com.huachenjie.home.databinding.HomeDialogHomeRewardBindingImpl;
import com.huachenjie.home.databinding.HomeDialogRewardInfoBindingImpl;
import com.huachenjie.home.databinding.HomeDialogSignBindingImpl;
import com.huachenjie.home.databinding.HomeDialogTaskListBindingImpl;
import com.huachenjie.home.databinding.HomeFragmentChangeRewardListBindingImpl;
import com.huachenjie.home.databinding.HomeFragmentGoodStuffBindingImpl;
import com.huachenjie.home.databinding.HomeFragmentInsporationRecordBindingImpl;
import com.huachenjie.home.databinding.HomeFragmentMainBindingImpl;
import com.huachenjie.home.databinding.HomeFragmentRebateGoodsListBindingImpl;
import com.huachenjie.home.databinding.HomeFragmentTaskListBindingImpl;
import com.huachenjie.home.databinding.HomeItemChangeRewardListBindingImpl;
import com.huachenjie.home.databinding.HomeItemGoodStuffBannerBindingImpl;
import com.huachenjie.home.databinding.HomeItemGoodStuffBindingImpl;
import com.huachenjie.home.databinding.HomeItemHomeGoodsBindingImpl;
import com.huachenjie.home.databinding.HomeItemHomeGoodsMallBindingImpl;
import com.huachenjie.home.databinding.HomeItemHomeHeaderBindingImpl;
import com.huachenjie.home.databinding.HomeItemInspirationRecordConsumeBindingImpl;
import com.huachenjie.home.databinding.HomeItemInspirationRecordGetBindingImpl;
import com.huachenjie.home.databinding.HomeItemInspirationRecordTitleBindingImpl;
import com.huachenjie.home.databinding.HomeItemLotteryDrawBannerBindingImpl;
import com.huachenjie.home.databinding.HomeItemPointsGoodStuffBindingImpl;
import com.huachenjie.home.databinding.HomeItemRewardRecordBindingImpl;
import com.huachenjie.home.databinding.HomeItemSearchTextSwitchBindingImpl;
import com.huachenjie.home.databinding.HomeItemSign7ExtraBindingImpl;
import com.huachenjie.home.databinding.HomeItemSignBindingImpl;
import com.huachenjie.home.databinding.HomeItemTaskListBindingImpl;
import com.huachenjie.home.databinding.HomeItemWinnerListBroadcastBindingImpl;
import com.huachenjie.home.databinding.HomeLayoutEmptyDataBindingImpl;
import com.huachenjie.home.databinding.HomeLayoutFlashCoinsHeaderBindingImpl;
import com.huachenjie.home.databinding.HomeLayoutGoodStuffPickBindingImpl;
import com.huachenjie.mall.page.comment.write.WriteReviewActivity;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f34183a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final SparseIntArray f9258a;
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
        public static final SparseArray<String> f34184a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(28);
            f34184a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "adapter");
            sparseArray.put(2, "addressBean");
            sparseArray.put(3, "bannerHeight");
            sparseArray.put(4, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
            sparseArray.put(5, "checked");
            sparseArray.put(6, "click");
            sparseArray.put(7, "commentType");
            sparseArray.put(8, "data");
            sparseArray.put(9, "fragment");
            sparseArray.put(10, WriteReviewActivity.x);
            sparseArray.put(11, "hasBuy");
            sparseArray.put(12, "index");
            sparseArray.put(13, "infoMargin");
            sparseArray.put(14, "isSelf");
            sparseArray.put(15, "item");
            sparseArray.put(16, "jackpotType");
            sparseArray.put(17, "mState");
            sparseArray.put(18, "position");
            sparseArray.put(19, "postType");
            sparseArray.put(20, d.x);
            sparseArray.put(21, "showRelation");
            sparseArray.put(22, "showSeaView");
            sparseArray.put(23, "source");
            sparseArray.put(24, "statusBarHeight");
            sparseArray.put(25, "targetNo");
            sparseArray.put(26, "title");
            sparseArray.put(27, "vm");
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HashMap<String, Integer> f34185a;

        static {
            HashMap<String, Integer> map = new HashMap<>(38);
            f34185a = map;
            map.put("layout/home_activity_change_reward_0", Integer.valueOf(R.layout.home_activity_change_reward));
            map.put("layout/home_activity_inspiration_record_0", Integer.valueOf(R.layout.home_activity_inspiration_record));
            map.put("layout/home_activity_lottery_draw_0", Integer.valueOf(R.layout.home_activity_lottery_draw));
            map.put("layout/home_activity_rebate_goods_list_0", Integer.valueOf(R.layout.home_activity_rebate_goods_list));
            map.put("layout/home_activity_reward_detail_0", Integer.valueOf(R.layout.home_activity_reward_detail));
            map.put("layout/home_activity_reward_record_0", Integer.valueOf(R.layout.home_activity_reward_record));
            map.put("layout/home_activity_union_goods_search_0", Integer.valueOf(R.layout.home_activity_union_goods_search));
            map.put("layout/home_dialog_double_reward_0", Integer.valueOf(R.layout.home_dialog_double_reward));
            map.put("layout/home_dialog_home_reward_0", Integer.valueOf(R.layout.home_dialog_home_reward));
            map.put("layout/home_dialog_reward_info_0", Integer.valueOf(R.layout.home_dialog_reward_info));
            map.put("layout/home_dialog_sign_0", Integer.valueOf(R.layout.home_dialog_sign));
            map.put("layout/home_dialog_task_list_0", Integer.valueOf(R.layout.home_dialog_task_list));
            map.put("layout/home_fragment_change_reward_list_0", Integer.valueOf(R.layout.home_fragment_change_reward_list));
            map.put("layout/home_fragment_good_stuff_0", Integer.valueOf(R.layout.home_fragment_good_stuff));
            map.put("layout/home_fragment_insporation_record_0", Integer.valueOf(R.layout.home_fragment_insporation_record));
            map.put("layout/home_fragment_main_0", Integer.valueOf(R.layout.home_fragment_main));
            map.put("layout/home_fragment_rebate_goods_list_0", Integer.valueOf(R.layout.home_fragment_rebate_goods_list));
            map.put("layout/home_fragment_task_list_0", Integer.valueOf(R.layout.home_fragment_task_list));
            map.put("layout/home_item_change_reward_list_0", Integer.valueOf(R.layout.home_item_change_reward_list));
            map.put("layout/home_item_good_stuff_0", Integer.valueOf(R.layout.home_item_good_stuff));
            map.put("layout/home_item_good_stuff_banner_0", Integer.valueOf(R.layout.home_item_good_stuff_banner));
            map.put("layout/home_item_home_goods_0", Integer.valueOf(R.layout.home_item_home_goods));
            map.put("layout/home_item_home_goods_mall_0", Integer.valueOf(R.layout.home_item_home_goods_mall));
            map.put("layout/home_item_home_header_0", Integer.valueOf(R.layout.home_item_home_header));
            map.put("layout/home_item_inspiration_record_consume_0", Integer.valueOf(R.layout.home_item_inspiration_record_consume));
            map.put("layout/home_item_inspiration_record_get_0", Integer.valueOf(R.layout.home_item_inspiration_record_get));
            map.put("layout/home_item_inspiration_record_title_0", Integer.valueOf(R.layout.home_item_inspiration_record_title));
            map.put("layout/home_item_lottery_draw_banner_0", Integer.valueOf(R.layout.home_item_lottery_draw_banner));
            map.put("layout/home_item_points_good_stuff_0", Integer.valueOf(R.layout.home_item_points_good_stuff));
            map.put("layout/home_item_reward_record_0", Integer.valueOf(R.layout.home_item_reward_record));
            map.put("layout/home_item_search_text_switch_0", Integer.valueOf(R.layout.home_item_search_text_switch));
            map.put("layout/home_item_sign_0", Integer.valueOf(R.layout.home_item_sign));
            map.put("layout/home_item_sign_7_extra_0", Integer.valueOf(R.layout.home_item_sign_7_extra));
            map.put("layout/home_item_task_list_0", Integer.valueOf(R.layout.home_item_task_list));
            map.put("layout/home_item_winner_list_broadcast_0", Integer.valueOf(R.layout.home_item_winner_list_broadcast));
            map.put("layout/home_layout_empty_data_0", Integer.valueOf(R.layout.home_layout_empty_data));
            map.put("layout/home_layout_flash_coins_header_0", Integer.valueOf(R.layout.home_layout_flash_coins_header));
            map.put("layout/home_layout_good_stuff_pick_0", Integer.valueOf(R.layout.home_layout_good_stuff_pick));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(38);
        f9258a = sparseIntArray;
        sparseIntArray.put(R.layout.home_activity_change_reward, 1);
        sparseIntArray.put(R.layout.home_activity_inspiration_record, 2);
        sparseIntArray.put(R.layout.home_activity_lottery_draw, 3);
        sparseIntArray.put(R.layout.home_activity_rebate_goods_list, 4);
        sparseIntArray.put(R.layout.home_activity_reward_detail, 5);
        sparseIntArray.put(R.layout.home_activity_reward_record, 6);
        sparseIntArray.put(R.layout.home_activity_union_goods_search, 7);
        sparseIntArray.put(R.layout.home_dialog_double_reward, 8);
        sparseIntArray.put(R.layout.home_dialog_home_reward, 9);
        sparseIntArray.put(R.layout.home_dialog_reward_info, 10);
        sparseIntArray.put(R.layout.home_dialog_sign, 11);
        sparseIntArray.put(R.layout.home_dialog_task_list, 12);
        sparseIntArray.put(R.layout.home_fragment_change_reward_list, 13);
        sparseIntArray.put(R.layout.home_fragment_good_stuff, 14);
        sparseIntArray.put(R.layout.home_fragment_insporation_record, 15);
        sparseIntArray.put(R.layout.home_fragment_main, 16);
        sparseIntArray.put(R.layout.home_fragment_rebate_goods_list, 17);
        sparseIntArray.put(R.layout.home_fragment_task_list, 18);
        sparseIntArray.put(R.layout.home_item_change_reward_list, 19);
        sparseIntArray.put(R.layout.home_item_good_stuff, 20);
        sparseIntArray.put(R.layout.home_item_good_stuff_banner, 21);
        sparseIntArray.put(R.layout.home_item_home_goods, 22);
        sparseIntArray.put(R.layout.home_item_home_goods_mall, 23);
        sparseIntArray.put(R.layout.home_item_home_header, 24);
        sparseIntArray.put(R.layout.home_item_inspiration_record_consume, 25);
        sparseIntArray.put(R.layout.home_item_inspiration_record_get, 26);
        sparseIntArray.put(R.layout.home_item_inspiration_record_title, 27);
        sparseIntArray.put(R.layout.home_item_lottery_draw_banner, 28);
        sparseIntArray.put(R.layout.home_item_points_good_stuff, 29);
        sparseIntArray.put(R.layout.home_item_reward_record, 30);
        sparseIntArray.put(R.layout.home_item_search_text_switch, 31);
        sparseIntArray.put(R.layout.home_item_sign, 32);
        sparseIntArray.put(R.layout.home_item_sign_7_extra, 33);
        sparseIntArray.put(R.layout.home_item_task_list, 34);
        sparseIntArray.put(R.layout.home_item_winner_list_broadcast, 35);
        sparseIntArray.put(R.layout.home_layout_empty_data, 36);
        sparseIntArray.put(R.layout.home_layout_flash_coins_header, 37);
        sparseIntArray.put(R.layout.home_layout_good_stuff_pick, 38);
    }

    @Override // androidx.coroutines.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(10);
        arrayList.add(new androidx.coroutines.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.flyco.tablayout.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.ad.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.base.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.common.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.mall.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.pay.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.qrcode.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.step.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.works.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.coroutines.DataBinderMapper
    public String convertBrIdToString(int i2) {
        return a.f34184a.get(i2);
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i2) {
        int i3 = f9258a.get(i2);
        if (i3 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch (i3) {
            case 1:
                if ("layout/home_activity_change_reward_0".equals(tag)) {
                    return new HomeActivityChangeRewardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_activity_change_reward is invalid. Received: " + tag);
            case 2:
                if ("layout/home_activity_inspiration_record_0".equals(tag)) {
                    return new HomeActivityInspirationRecordBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_activity_inspiration_record is invalid. Received: " + tag);
            case 3:
                if ("layout/home_activity_lottery_draw_0".equals(tag)) {
                    return new HomeActivityLotteryDrawBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_activity_lottery_draw is invalid. Received: " + tag);
            case 4:
                if ("layout/home_activity_rebate_goods_list_0".equals(tag)) {
                    return new HomeActivityRebateGoodsListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_activity_rebate_goods_list is invalid. Received: " + tag);
            case 5:
                if ("layout/home_activity_reward_detail_0".equals(tag)) {
                    return new HomeActivityRewardDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_activity_reward_detail is invalid. Received: " + tag);
            case 6:
                if ("layout/home_activity_reward_record_0".equals(tag)) {
                    return new HomeActivityRewardRecordBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_activity_reward_record is invalid. Received: " + tag);
            case 7:
                if ("layout/home_activity_union_goods_search_0".equals(tag)) {
                    return new HomeActivityUnionGoodsSearchBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_activity_union_goods_search is invalid. Received: " + tag);
            case 8:
                if ("layout/home_dialog_double_reward_0".equals(tag)) {
                    return new HomeDialogDoubleRewardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_dialog_double_reward is invalid. Received: " + tag);
            case 9:
                if ("layout/home_dialog_home_reward_0".equals(tag)) {
                    return new HomeDialogHomeRewardBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_dialog_home_reward is invalid. Received: " + tag);
            case 10:
                if ("layout/home_dialog_reward_info_0".equals(tag)) {
                    return new HomeDialogRewardInfoBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_dialog_reward_info is invalid. Received: " + tag);
            case 11:
                if ("layout/home_dialog_sign_0".equals(tag)) {
                    return new HomeDialogSignBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_dialog_sign is invalid. Received: " + tag);
            case 12:
                if ("layout/home_dialog_task_list_0".equals(tag)) {
                    return new HomeDialogTaskListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_dialog_task_list is invalid. Received: " + tag);
            case 13:
                if ("layout/home_fragment_change_reward_list_0".equals(tag)) {
                    return new HomeFragmentChangeRewardListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_fragment_change_reward_list is invalid. Received: " + tag);
            case 14:
                if ("layout/home_fragment_good_stuff_0".equals(tag)) {
                    return new HomeFragmentGoodStuffBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_fragment_good_stuff is invalid. Received: " + tag);
            case 15:
                if ("layout/home_fragment_insporation_record_0".equals(tag)) {
                    return new HomeFragmentInsporationRecordBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_fragment_insporation_record is invalid. Received: " + tag);
            case 16:
                if ("layout/home_fragment_main_0".equals(tag)) {
                    return new HomeFragmentMainBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_fragment_main is invalid. Received: " + tag);
            case 17:
                if ("layout/home_fragment_rebate_goods_list_0".equals(tag)) {
                    return new HomeFragmentRebateGoodsListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_fragment_rebate_goods_list is invalid. Received: " + tag);
            case 18:
                if ("layout/home_fragment_task_list_0".equals(tag)) {
                    return new HomeFragmentTaskListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_fragment_task_list is invalid. Received: " + tag);
            case 19:
                if ("layout/home_item_change_reward_list_0".equals(tag)) {
                    return new HomeItemChangeRewardListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_item_change_reward_list is invalid. Received: " + tag);
            case 20:
                if ("layout/home_item_good_stuff_0".equals(tag)) {
                    return new HomeItemGoodStuffBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_item_good_stuff is invalid. Received: " + tag);
            case 21:
                if ("layout/home_item_good_stuff_banner_0".equals(tag)) {
                    return new HomeItemGoodStuffBannerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_item_good_stuff_banner is invalid. Received: " + tag);
            case 22:
                if ("layout/home_item_home_goods_0".equals(tag)) {
                    return new HomeItemHomeGoodsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_item_home_goods is invalid. Received: " + tag);
            case 23:
                if ("layout/home_item_home_goods_mall_0".equals(tag)) {
                    return new HomeItemHomeGoodsMallBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_item_home_goods_mall is invalid. Received: " + tag);
            case 24:
                if ("layout/home_item_home_header_0".equals(tag)) {
                    return new HomeItemHomeHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_item_home_header is invalid. Received: " + tag);
            case 25:
                if ("layout/home_item_inspiration_record_consume_0".equals(tag)) {
                    return new HomeItemInspirationRecordConsumeBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_item_inspiration_record_consume is invalid. Received: " + tag);
            case 26:
                if ("layout/home_item_inspiration_record_get_0".equals(tag)) {
                    return new HomeItemInspirationRecordGetBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_item_inspiration_record_get is invalid. Received: " + tag);
            case 27:
                if ("layout/home_item_inspiration_record_title_0".equals(tag)) {
                    return new HomeItemInspirationRecordTitleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_item_inspiration_record_title is invalid. Received: " + tag);
            case 28:
                if ("layout/home_item_lottery_draw_banner_0".equals(tag)) {
                    return new HomeItemLotteryDrawBannerBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_item_lottery_draw_banner is invalid. Received: " + tag);
            case 29:
                if ("layout/home_item_points_good_stuff_0".equals(tag)) {
                    return new HomeItemPointsGoodStuffBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_item_points_good_stuff is invalid. Received: " + tag);
            case 30:
                if ("layout/home_item_reward_record_0".equals(tag)) {
                    return new HomeItemRewardRecordBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_item_reward_record is invalid. Received: " + tag);
            case 31:
                if ("layout/home_item_search_text_switch_0".equals(tag)) {
                    return new HomeItemSearchTextSwitchBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_item_search_text_switch is invalid. Received: " + tag);
            case 32:
                if ("layout/home_item_sign_0".equals(tag)) {
                    return new HomeItemSignBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_item_sign is invalid. Received: " + tag);
            case 33:
                if ("layout/home_item_sign_7_extra_0".equals(tag)) {
                    return new HomeItemSign7ExtraBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_item_sign_7_extra is invalid. Received: " + tag);
            case 34:
                if ("layout/home_item_task_list_0".equals(tag)) {
                    return new HomeItemTaskListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_item_task_list is invalid. Received: " + tag);
            case 35:
                if ("layout/home_item_winner_list_broadcast_0".equals(tag)) {
                    return new HomeItemWinnerListBroadcastBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_item_winner_list_broadcast is invalid. Received: " + tag);
            case 36:
                if ("layout/home_layout_empty_data_0".equals(tag)) {
                    return new HomeLayoutEmptyDataBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_layout_empty_data is invalid. Received: " + tag);
            case 37:
                if ("layout/home_layout_flash_coins_header_0".equals(tag)) {
                    return new HomeLayoutFlashCoinsHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_layout_flash_coins_header is invalid. Received: " + tag);
            case 38:
                if ("layout/home_layout_good_stuff_pick_0".equals(tag)) {
                    return new HomeLayoutGoodStuffPickBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for home_layout_good_stuff_pick is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.coroutines.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f34185a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i2) {
        if (viewArr == null || viewArr.length == 0 || f9258a.get(i2) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}

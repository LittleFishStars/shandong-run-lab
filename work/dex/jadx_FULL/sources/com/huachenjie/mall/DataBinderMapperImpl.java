package com.huachenjie.mall;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.coroutines.DataBinderMapper;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.ViewDataBinding;
import com.alipay.sdk.m.c0.d;
import com.huachenjie.mall.databinding.MallActivityApplyRefundBindingImpl;
import com.huachenjie.mall.databinding.MallActivityBannerPreviewBindingImpl;
import com.huachenjie.mall.databinding.MallActivityCatBindingImpl;
import com.huachenjie.mall.databinding.MallActivityCheckOrderBindingImpl;
import com.huachenjie.mall.databinding.MallActivityCommodityCommentDetailBindingImpl;
import com.huachenjie.mall.databinding.MallActivityCommodityCommentListBindingImpl;
import com.huachenjie.mall.databinding.MallActivityCourseDetailBindingImpl;
import com.huachenjie.mall.databinding.MallActivityEpisodesDetailBindingImpl;
import com.huachenjie.mall.databinding.MallActivityExpressCompanyBindingImpl;
import com.huachenjie.mall.databinding.MallActivityExpressLogisticsBindingImpl;
import com.huachenjie.mall.databinding.MallActivityGoodsDetailBindingImpl;
import com.huachenjie.mall.databinding.MallActivityGoodsSpecificationPreviewBindingImpl;
import com.huachenjie.mall.databinding.MallActivityLklWebviewBindingImpl;
import com.huachenjie.mall.databinding.MallActivityMallBindingImpl;
import com.huachenjie.mall.databinding.MallActivityMallSearchBindingImpl;
import com.huachenjie.mall.databinding.MallActivityMerchantsBindingImpl;
import com.huachenjie.mall.databinding.MallActivityMyOrderBindingImpl;
import com.huachenjie.mall.databinding.MallActivityOrderDetailBindingImpl;
import com.huachenjie.mall.databinding.MallActivityPayResultBindingImpl;
import com.huachenjie.mall.databinding.MallActivityRedeemPiontsResultBindingImpl;
import com.huachenjie.mall.databinding.MallActivityRefundDetailBindingImpl;
import com.huachenjie.mall.databinding.MallActivityRefundListBindingImpl;
import com.huachenjie.mall.databinding.MallActivityRewardPaySucBindingImpl;
import com.huachenjie.mall.databinding.MallActivityRewardShippingAddressBindingImpl;
import com.huachenjie.mall.databinding.MallActivityRuleCenterBindingImpl;
import com.huachenjie.mall.databinding.MallActivitySelectGoodsBindingImpl;
import com.huachenjie.mall.databinding.MallActivityShippingAddressBindingImpl;
import com.huachenjie.mall.databinding.MallActivityShippingAddressEditBindingImpl;
import com.huachenjie.mall.databinding.MallActivityShippingAddressModifyBindingImpl;
import com.huachenjie.mall.databinding.MallActivityShoppingMessageBindingImpl;
import com.huachenjie.mall.databinding.MallActivityTestPlayBindingImpl;
import com.huachenjie.mall.databinding.MallActivityTrySeeListBindingImpl;
import com.huachenjie.mall.databinding.MallActivityVideoEnterBindingImpl;
import com.huachenjie.mall.databinding.MallActivityWriteReviewBindingImpl;
import com.huachenjie.mall.databinding.MallActivityWriteReviewSuccessBindingImpl;
import com.huachenjie.mall.databinding.MallDialogCancelReasonBindingImpl;
import com.huachenjie.mall.databinding.MallDialogCreatePosterBindingImpl;
import com.huachenjie.mall.databinding.MallDialogFillExpressBindingImpl;
import com.huachenjie.mall.databinding.MallDialogGoodsParamBindingImpl;
import com.huachenjie.mall.databinding.MallDialogGoodsSpecificationBindingImpl;
import com.huachenjie.mall.databinding.MallDialogOrderRemarkBindingImpl;
import com.huachenjie.mall.databinding.MallDialogPayBindingImpl;
import com.huachenjie.mall.databinding.MallDialogPayPointsBindingImpl;
import com.huachenjie.mall.databinding.MallFooterOrderDetailBindingImpl;
import com.huachenjie.mall.databinding.MallFragmentAllVideoGoodsBindingImpl;
import com.huachenjie.mall.databinding.MallFragmentChooseShopOrderBindingImpl;
import com.huachenjie.mall.databinding.MallFragmentCommodityBindingImpl;
import com.huachenjie.mall.databinding.MallFragmentCommodityCommentListBindingImpl;
import com.huachenjie.mall.databinding.MallFragmentEpisodesListBindingImpl;
import com.huachenjie.mall.databinding.MallFragmentMallItemBindingImpl;
import com.huachenjie.mall.databinding.MallFragmentMyOrderListBindingImpl;
import com.huachenjie.mall.databinding.MallFragmentPurchasedVideoGoodsBindingImpl;
import com.huachenjie.mall.databinding.MallFragmentRefundListBindingImpl;
import com.huachenjie.mall.databinding.MallFragmentSearchResultGoodsBindingImpl;
import com.huachenjie.mall.databinding.MallFragmentSelectGoodsBindingImpl;
import com.huachenjie.mall.databinding.MallHeaderOrderDetailBindingImpl;
import com.huachenjie.mall.databinding.MallItemApplyRefundPicAddBindingImpl;
import com.huachenjie.mall.databinding.MallItemApplyRefundPicBindingImpl;
import com.huachenjie.mall.databinding.MallItemCancelReasonBindingImpl;
import com.huachenjie.mall.databinding.MallItemChooseShopOrderBindingImpl;
import com.huachenjie.mall.databinding.MallItemCommodityBindingImpl;
import com.huachenjie.mall.databinding.MallItemCommodityCommentBindingImpl;
import com.huachenjie.mall.databinding.MallItemCourseDetailBindingImpl;
import com.huachenjie.mall.databinding.MallItemEpisodesListBindingImpl;
import com.huachenjie.mall.databinding.MallItemExpressCompanyBindingImpl;
import com.huachenjie.mall.databinding.MallItemExpressCompanyNameBindingImpl;
import com.huachenjie.mall.databinding.MallItemExpressLogisticsBindingImpl;
import com.huachenjie.mall.databinding.MallItemExpressLogisticsHeadBindingImpl;
import com.huachenjie.mall.databinding.MallItemExpressLogisticsSimpleBindingImpl;
import com.huachenjie.mall.databinding.MallItemGoodsDetailCommentBindingImpl;
import com.huachenjie.mall.databinding.MallItemGoodsDetailShopBindingImpl;
import com.huachenjie.mall.databinding.MallItemGoodsDetailShopItemBindingImpl;
import com.huachenjie.mall.databinding.MallItemGoodsParamBindingImpl;
import com.huachenjie.mall.databinding.MallItemGoodsSpecificationBindingImpl;
import com.huachenjie.mall.databinding.MallItemGoodsSpecificationPreviewBindingImpl;
import com.huachenjie.mall.databinding.MallItemMyOrderBindingImpl;
import com.huachenjie.mall.databinding.MallItemMyOrderGoodsBindingImpl;
import com.huachenjie.mall.databinding.MallItemOrderDetailGoodsBindingImpl;
import com.huachenjie.mall.databinding.MallItemPosterBgBindingImpl;
import com.huachenjie.mall.databinding.MallItemPurchasedVideoGoodsBindingImpl;
import com.huachenjie.mall.databinding.MallItemRefundListBindingImpl;
import com.huachenjie.mall.databinding.MallItemRefundRefundDetailFileBindingImpl;
import com.huachenjie.mall.databinding.MallItemRewardShippingAddressBindingImpl;
import com.huachenjie.mall.databinding.MallItemRuleCenterBindingImpl;
import com.huachenjie.mall.databinding.MallItemSearchTextSwitchBindingImpl;
import com.huachenjie.mall.databinding.MallItemSelectGoodsBindingImpl;
import com.huachenjie.mall.databinding.MallItemShippingAddressBindingImpl;
import com.huachenjie.mall.databinding.MallItemShippingAddressModifyBindingImpl;
import com.huachenjie.mall.databinding.MallItemShoppingMessageBindingImpl;
import com.huachenjie.mall.databinding.MallItemShoppingMessageHeaderBindingImpl;
import com.huachenjie.mall.databinding.MallItemTestVideoBindingImpl;
import com.huachenjie.mall.databinding.MallItemTrySeeListBindingImpl;
import com.huachenjie.mall.databinding.MallItemWriteReviewImageAddBindingImpl;
import com.huachenjie.mall.databinding.MallItemWriteReviewImageBindingImpl;
import com.huachenjie.mall.databinding.MallLayoutEmptyDataBindingImpl;
import com.huachenjie.mall.databinding.MallLayoutGoodsDetailBottomBindingImpl;
import com.huachenjie.mall.databinding.MallLayoutGoodsDetailBottomDistributingBindingImpl;
import com.huachenjie.mall.databinding.MallLayoutGoodsDetailBottomPointBindingImpl;
import com.huachenjie.mall.databinding.MallLayoutGoodsDetailBottomTeamLeaderBindingImpl;
import com.huachenjie.mall.databinding.MallLayoutGoodsDetailToolbarBindingImpl;
import com.huachenjie.mall.databinding.MallViewCourseDetailHeaderBindingImpl;
import com.huachenjie.mall.databinding.MallViewGoodsDetailHeaderActivityContentBindingImpl;
import com.huachenjie.mall.databinding.MallViewGoodsDetailHeaderBindingImpl;
import com.huachenjie.mall.databinding.MallViewGoodsDetailHeaderContentBindingImpl;
import com.huachenjie.mall.databinding.MallViewOrderDetailAddressBindingImpl;
import com.huachenjie.mall.databinding.MallViewOrderDetailDeliverBindingImpl;
import com.huachenjie.mall.databinding.MallViewOrderDetailServiceBindingImpl;
import com.huachenjie.mall.databinding.MallViewRefundDetailAddressBindingImpl;
import com.huachenjie.mall.page.comment.write.WriteReviewActivity;
import com.huachenjie.works.page.broadcast_floor.dialog.BroadcastFloorDetailDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    public static final int A = 27;
    public static final int A0 = 79;
    public static final int B = 28;
    public static final int B0 = 80;
    public static final int C = 29;
    public static final int C0 = 81;
    public static final int D = 30;
    public static final int D0 = 82;
    public static final int E = 31;
    public static final int E0 = 83;
    public static final int F = 32;
    public static final int F0 = 84;
    public static final int G = 33;
    public static final int G0 = 85;
    public static final int H = 34;
    public static final int H0 = 86;
    public static final int I = 35;
    public static final int I0 = 87;
    public static final int J = 36;
    public static final int J0 = 88;
    public static final int K = 37;
    public static final int K0 = 89;
    public static final int L = 38;
    public static final int L0 = 90;
    public static final int M = 39;
    public static final int M0 = 91;
    public static final int N = 40;
    public static final int N0 = 92;
    public static final int O = 41;
    public static final int O0 = 93;
    public static final int P = 42;
    public static final int P0 = 94;
    public static final int Q = 43;
    public static final int Q0 = 95;
    public static final int R = 44;
    public static final int R0 = 96;
    public static final int S = 45;
    public static final int S0 = 97;
    public static final int T = 46;
    public static final int T0 = 98;
    public static final int U = 47;
    public static final int U0 = 99;
    public static final int V = 48;
    public static final int V0 = 100;
    public static final int W = 49;
    public static final int W0 = 101;
    public static final int X = 50;
    public static final int X0 = 102;
    public static final int Y = 51;
    public static final int Y0 = 103;
    public static final int Z = 52;
    public static final int Z0 = 104;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f34760a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final SparseIntArray f10124a;
    public static final int a0 = 53;
    public static final int a1 = 105;
    public static final int b = 2;
    public static final int b0 = 54;
    public static final int b1 = 106;
    public static final int c = 3;
    public static final int c0 = 55;
    public static final int c1 = 107;
    public static final int d = 4;
    public static final int d0 = 56;
    public static final int d1 = 108;
    public static final int e = 5;
    public static final int e0 = 57;
    public static final int f = 6;
    public static final int f0 = 58;
    public static final int g = 7;
    public static final int g0 = 59;
    public static final int h = 8;
    public static final int h0 = 60;
    public static final int i = 9;
    public static final int i0 = 61;
    public static final int j = 10;
    public static final int j0 = 62;
    public static final int k = 11;
    public static final int k0 = 63;
    public static final int l = 12;
    public static final int l0 = 64;
    public static final int m = 13;
    public static final int m0 = 65;
    public static final int n = 14;
    public static final int n0 = 66;
    public static final int o = 15;
    public static final int o0 = 67;
    public static final int p = 16;
    public static final int p0 = 68;
    public static final int q = 17;
    public static final int q0 = 69;
    public static final int r = 18;
    public static final int r0 = 70;
    public static final int s = 19;
    public static final int s0 = 71;
    public static final int t = 20;
    public static final int t0 = 72;
    public static final int u = 21;
    public static final int u0 = 73;
    public static final int v = 22;
    public static final int v0 = 74;
    public static final int w = 23;
    public static final int w0 = 75;
    public static final int x = 24;
    public static final int x0 = 76;
    public static final int y = 25;
    public static final int y0 = 77;
    public static final int z = 26;
    public static final int z0 = 78;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SparseArray<String> f34761a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(27);
            f34761a = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "adapter");
            sparseArray.put(2, "addressBean");
            sparseArray.put(3, "badgeOption");
            sparseArray.put(4, "bannerHeight");
            sparseArray.put(5, BroadcastFloorDetailDialog.DETAIL_BEAN_KEY);
            sparseArray.put(6, "bgOption");
            sparseArray.put(7, "checked");
            sparseArray.put(8, "click");
            sparseArray.put(9, "commentType");
            sparseArray.put(10, "data");
            sparseArray.put(11, "fragment");
            sparseArray.put(12, WriteReviewActivity.x);
            sparseArray.put(13, "hasBuy");
            sparseArray.put(14, "index");
            sparseArray.put(15, "infoMargin");
            sparseArray.put(16, "isSelf");
            sparseArray.put(17, "mState");
            sparseArray.put(18, "position");
            sparseArray.put(19, "postType");
            sparseArray.put(20, d.x);
            sparseArray.put(21, "showRelation");
            sparseArray.put(22, "source");
            sparseArray.put(23, "statusBarHeight");
            sparseArray.put(24, "targetNo");
            sparseArray.put(25, "title");
            sparseArray.put(26, "vm");
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HashMap<String, Integer> f34762a;

        static {
            HashMap<String, Integer> map = new HashMap<>(108);
            f34762a = map;
            map.put("layout/mall_activity_apply_refund_0", Integer.valueOf(R.layout.mall_activity_apply_refund));
            map.put("layout/mall_activity_banner_preview_0", Integer.valueOf(R.layout.mall_activity_banner_preview));
            map.put("layout/mall_activity_cat_0", Integer.valueOf(R.layout.mall_activity_cat));
            map.put("layout/mall_activity_check_order_0", Integer.valueOf(R.layout.mall_activity_check_order));
            map.put("layout/mall_activity_commodity_comment_detail_0", Integer.valueOf(R.layout.mall_activity_commodity_comment_detail));
            map.put("layout/mall_activity_commodity_comment_list_0", Integer.valueOf(R.layout.mall_activity_commodity_comment_list));
            map.put("layout/mall_activity_course_detail_0", Integer.valueOf(R.layout.mall_activity_course_detail));
            map.put("layout/mall_activity_episodes_detail_0", Integer.valueOf(R.layout.mall_activity_episodes_detail));
            map.put("layout/mall_activity_express_company_0", Integer.valueOf(R.layout.mall_activity_express_company));
            map.put("layout/mall_activity_express_logistics_0", Integer.valueOf(R.layout.mall_activity_express_logistics));
            map.put("layout/mall_activity_goods_detail_0", Integer.valueOf(R.layout.mall_activity_goods_detail));
            map.put("layout/mall_activity_goods_specification_preview_0", Integer.valueOf(R.layout.mall_activity_goods_specification_preview));
            map.put("layout/mall_activity_lkl_webview_0", Integer.valueOf(R.layout.mall_activity_lkl_webview));
            map.put("layout/mall_activity_mall_0", Integer.valueOf(R.layout.mall_activity_mall));
            map.put("layout/mall_activity_mall_search_0", Integer.valueOf(R.layout.mall_activity_mall_search));
            map.put("layout/mall_activity_merchants_0", Integer.valueOf(R.layout.mall_activity_merchants));
            map.put("layout/mall_activity_my_order_0", Integer.valueOf(R.layout.mall_activity_my_order));
            map.put("layout/mall_activity_order_detail_0", Integer.valueOf(R.layout.mall_activity_order_detail));
            map.put("layout/mall_activity_pay_result_0", Integer.valueOf(R.layout.mall_activity_pay_result));
            map.put("layout/mall_activity_redeem_pionts_result_0", Integer.valueOf(R.layout.mall_activity_redeem_pionts_result));
            map.put("layout/mall_activity_refund_detail_0", Integer.valueOf(R.layout.mall_activity_refund_detail));
            map.put("layout/mall_activity_refund_list_0", Integer.valueOf(R.layout.mall_activity_refund_list));
            map.put("layout/mall_activity_reward_pay_suc_0", Integer.valueOf(R.layout.mall_activity_reward_pay_suc));
            map.put("layout/mall_activity_reward_shipping_address_0", Integer.valueOf(R.layout.mall_activity_reward_shipping_address));
            map.put("layout/mall_activity_rule_center_0", Integer.valueOf(R.layout.mall_activity_rule_center));
            map.put("layout/mall_activity_select_goods_0", Integer.valueOf(R.layout.mall_activity_select_goods));
            map.put("layout/mall_activity_shipping_address_0", Integer.valueOf(R.layout.mall_activity_shipping_address));
            map.put("layout/mall_activity_shipping_address_edit_0", Integer.valueOf(R.layout.mall_activity_shipping_address_edit));
            map.put("layout/mall_activity_shipping_address_modify_0", Integer.valueOf(R.layout.mall_activity_shipping_address_modify));
            map.put("layout/mall_activity_shopping_message_0", Integer.valueOf(R.layout.mall_activity_shopping_message));
            map.put("layout/mall_activity_test_play_0", Integer.valueOf(R.layout.mall_activity_test_play));
            map.put("layout/mall_activity_try_see_list_0", Integer.valueOf(R.layout.mall_activity_try_see_list));
            map.put("layout/mall_activity_video_enter_0", Integer.valueOf(R.layout.mall_activity_video_enter));
            map.put("layout/mall_activity_write_review_0", Integer.valueOf(R.layout.mall_activity_write_review));
            map.put("layout/mall_activity_write_review_success_0", Integer.valueOf(R.layout.mall_activity_write_review_success));
            map.put("layout/mall_dialog_cancel_reason_0", Integer.valueOf(R.layout.mall_dialog_cancel_reason));
            map.put("layout/mall_dialog_create_poster_0", Integer.valueOf(R.layout.mall_dialog_create_poster));
            map.put("layout/mall_dialog_fill_express_0", Integer.valueOf(R.layout.mall_dialog_fill_express));
            map.put("layout/mall_dialog_goods_param_0", Integer.valueOf(R.layout.mall_dialog_goods_param));
            map.put("layout/mall_dialog_goods_specification_0", Integer.valueOf(R.layout.mall_dialog_goods_specification));
            map.put("layout/mall_dialog_order_remark_0", Integer.valueOf(R.layout.mall_dialog_order_remark));
            map.put("layout/mall_dialog_pay_0", Integer.valueOf(R.layout.mall_dialog_pay));
            map.put("layout/mall_dialog_pay_points_0", Integer.valueOf(R.layout.mall_dialog_pay_points));
            map.put("layout/mall_footer_order_detail_0", Integer.valueOf(R.layout.mall_footer_order_detail));
            map.put("layout/mall_fragment_all_video_goods_0", Integer.valueOf(R.layout.mall_fragment_all_video_goods));
            map.put("layout/mall_fragment_choose_shop_order_0", Integer.valueOf(R.layout.mall_fragment_choose_shop_order));
            map.put("layout/mall_fragment_commodity_0", Integer.valueOf(R.layout.mall_fragment_commodity));
            map.put("layout/mall_fragment_commodity_comment_list_0", Integer.valueOf(R.layout.mall_fragment_commodity_comment_list));
            map.put("layout/mall_fragment_episodes_list_0", Integer.valueOf(R.layout.mall_fragment_episodes_list));
            map.put("layout/mall_fragment_mall_item_0", Integer.valueOf(R.layout.mall_fragment_mall_item));
            map.put("layout/mall_fragment_my_order_list_0", Integer.valueOf(R.layout.mall_fragment_my_order_list));
            map.put("layout/mall_fragment_purchased_video_goods_0", Integer.valueOf(R.layout.mall_fragment_purchased_video_goods));
            map.put("layout/mall_fragment_refund_list_0", Integer.valueOf(R.layout.mall_fragment_refund_list));
            map.put("layout/mall_fragment_search_result_goods_0", Integer.valueOf(R.layout.mall_fragment_search_result_goods));
            map.put("layout/mall_fragment_select_goods_0", Integer.valueOf(R.layout.mall_fragment_select_goods));
            map.put("layout/mall_header_order_detail_0", Integer.valueOf(R.layout.mall_header_order_detail));
            map.put("layout/mall_item_apply_refund_pic_0", Integer.valueOf(R.layout.mall_item_apply_refund_pic));
            map.put("layout/mall_item_apply_refund_pic_add_0", Integer.valueOf(R.layout.mall_item_apply_refund_pic_add));
            map.put("layout/mall_item_cancel_reason_0", Integer.valueOf(R.layout.mall_item_cancel_reason));
            map.put("layout/mall_item_choose_shop_order_0", Integer.valueOf(R.layout.mall_item_choose_shop_order));
            map.put("layout/mall_item_commodity_0", Integer.valueOf(R.layout.mall_item_commodity));
            map.put("layout/mall_item_commodity_comment_0", Integer.valueOf(R.layout.mall_item_commodity_comment));
            map.put("layout/mall_item_course_detail_0", Integer.valueOf(R.layout.mall_item_course_detail));
            map.put("layout/mall_item_episodes_list_0", Integer.valueOf(R.layout.mall_item_episodes_list));
            map.put("layout/mall_item_express_company_0", Integer.valueOf(R.layout.mall_item_express_company));
            map.put("layout/mall_item_express_company_name_0", Integer.valueOf(R.layout.mall_item_express_company_name));
            map.put("layout/mall_item_express_logistics_0", Integer.valueOf(R.layout.mall_item_express_logistics));
            map.put("layout/mall_item_express_logistics_head_0", Integer.valueOf(R.layout.mall_item_express_logistics_head));
            map.put("layout/mall_item_express_logistics_simple_0", Integer.valueOf(R.layout.mall_item_express_logistics_simple));
            map.put("layout/mall_item_goods_detail_comment_0", Integer.valueOf(R.layout.mall_item_goods_detail_comment));
            map.put("layout/mall_item_goods_detail_shop_0", Integer.valueOf(R.layout.mall_item_goods_detail_shop));
            map.put("layout/mall_item_goods_detail_shop_item_0", Integer.valueOf(R.layout.mall_item_goods_detail_shop_item));
            map.put("layout/mall_item_goods_param_0", Integer.valueOf(R.layout.mall_item_goods_param));
            map.put("layout/mall_item_goods_specification_0", Integer.valueOf(R.layout.mall_item_goods_specification));
            map.put("layout/mall_item_goods_specification_preview_0", Integer.valueOf(R.layout.mall_item_goods_specification_preview));
            map.put("layout/mall_item_my_order_0", Integer.valueOf(R.layout.mall_item_my_order));
            map.put("layout/mall_item_my_order_goods_0", Integer.valueOf(R.layout.mall_item_my_order_goods));
            map.put("layout/mall_item_order_detail_goods_0", Integer.valueOf(R.layout.mall_item_order_detail_goods));
            map.put("layout/mall_item_poster_bg_0", Integer.valueOf(R.layout.mall_item_poster_bg));
            map.put("layout/mall_item_purchased_video_goods_0", Integer.valueOf(R.layout.mall_item_purchased_video_goods));
            map.put("layout/mall_item_refund_list_0", Integer.valueOf(R.layout.mall_item_refund_list));
            map.put("layout/mall_item_refund_refund_detail_file_0", Integer.valueOf(R.layout.mall_item_refund_refund_detail_file));
            map.put("layout/mall_item_reward_shipping_address_0", Integer.valueOf(R.layout.mall_item_reward_shipping_address));
            map.put("layout/mall_item_rule_center_0", Integer.valueOf(R.layout.mall_item_rule_center));
            map.put("layout/mall_item_search_text_switch_0", Integer.valueOf(R.layout.mall_item_search_text_switch));
            map.put("layout/mall_item_select_goods_0", Integer.valueOf(R.layout.mall_item_select_goods));
            map.put("layout/mall_item_shipping_address_0", Integer.valueOf(R.layout.mall_item_shipping_address));
            map.put("layout/mall_item_shipping_address_modify_0", Integer.valueOf(R.layout.mall_item_shipping_address_modify));
            map.put("layout/mall_item_shopping_message_0", Integer.valueOf(R.layout.mall_item_shopping_message));
            map.put("layout/mall_item_shopping_message_header_0", Integer.valueOf(R.layout.mall_item_shopping_message_header));
            map.put("layout/mall_item_test_video_0", Integer.valueOf(R.layout.mall_item_test_video));
            map.put("layout/mall_item_try_see_list_0", Integer.valueOf(R.layout.mall_item_try_see_list));
            map.put("layout/mall_item_write_review_image_0", Integer.valueOf(R.layout.mall_item_write_review_image));
            map.put("layout/mall_item_write_review_image_add_0", Integer.valueOf(R.layout.mall_item_write_review_image_add));
            map.put("layout/mall_layout_empty_data_0", Integer.valueOf(R.layout.mall_layout_empty_data));
            map.put("layout/mall_layout_goods_detail_bottom_0", Integer.valueOf(R.layout.mall_layout_goods_detail_bottom));
            map.put("layout/mall_layout_goods_detail_bottom_distributing_0", Integer.valueOf(R.layout.mall_layout_goods_detail_bottom_distributing));
            map.put("layout/mall_layout_goods_detail_bottom_point_0", Integer.valueOf(R.layout.mall_layout_goods_detail_bottom_point));
            map.put("layout/mall_layout_goods_detail_bottom_team_leader_0", Integer.valueOf(R.layout.mall_layout_goods_detail_bottom_team_leader));
            map.put("layout/mall_layout_goods_detail_toolbar_0", Integer.valueOf(R.layout.mall_layout_goods_detail_toolbar));
            map.put("layout/mall_view_course_detail_header_0", Integer.valueOf(R.layout.mall_view_course_detail_header));
            map.put("layout/mall_view_goods_detail_header_0", Integer.valueOf(R.layout.mall_view_goods_detail_header));
            map.put("layout/mall_view_goods_detail_header_activity_content_0", Integer.valueOf(R.layout.mall_view_goods_detail_header_activity_content));
            map.put("layout/mall_view_goods_detail_header_content_0", Integer.valueOf(R.layout.mall_view_goods_detail_header_content));
            map.put("layout/mall_view_order_detail_address_0", Integer.valueOf(R.layout.mall_view_order_detail_address));
            map.put("layout/mall_view_order_detail_deliver_0", Integer.valueOf(R.layout.mall_view_order_detail_deliver));
            map.put("layout/mall_view_order_detail_service_0", Integer.valueOf(R.layout.mall_view_order_detail_service));
            map.put("layout/mall_view_refund_detail_address_0", Integer.valueOf(R.layout.mall_view_refund_detail_address));
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(108);
        f10124a = sparseIntArray;
        sparseIntArray.put(R.layout.mall_activity_apply_refund, 1);
        sparseIntArray.put(R.layout.mall_activity_banner_preview, 2);
        sparseIntArray.put(R.layout.mall_activity_cat, 3);
        sparseIntArray.put(R.layout.mall_activity_check_order, 4);
        sparseIntArray.put(R.layout.mall_activity_commodity_comment_detail, 5);
        sparseIntArray.put(R.layout.mall_activity_commodity_comment_list, 6);
        sparseIntArray.put(R.layout.mall_activity_course_detail, 7);
        sparseIntArray.put(R.layout.mall_activity_episodes_detail, 8);
        sparseIntArray.put(R.layout.mall_activity_express_company, 9);
        sparseIntArray.put(R.layout.mall_activity_express_logistics, 10);
        sparseIntArray.put(R.layout.mall_activity_goods_detail, 11);
        sparseIntArray.put(R.layout.mall_activity_goods_specification_preview, 12);
        sparseIntArray.put(R.layout.mall_activity_lkl_webview, 13);
        sparseIntArray.put(R.layout.mall_activity_mall, 14);
        sparseIntArray.put(R.layout.mall_activity_mall_search, 15);
        sparseIntArray.put(R.layout.mall_activity_merchants, 16);
        sparseIntArray.put(R.layout.mall_activity_my_order, 17);
        sparseIntArray.put(R.layout.mall_activity_order_detail, 18);
        sparseIntArray.put(R.layout.mall_activity_pay_result, 19);
        sparseIntArray.put(R.layout.mall_activity_redeem_pionts_result, 20);
        sparseIntArray.put(R.layout.mall_activity_refund_detail, 21);
        sparseIntArray.put(R.layout.mall_activity_refund_list, 22);
        sparseIntArray.put(R.layout.mall_activity_reward_pay_suc, 23);
        sparseIntArray.put(R.layout.mall_activity_reward_shipping_address, 24);
        sparseIntArray.put(R.layout.mall_activity_rule_center, 25);
        sparseIntArray.put(R.layout.mall_activity_select_goods, 26);
        sparseIntArray.put(R.layout.mall_activity_shipping_address, 27);
        sparseIntArray.put(R.layout.mall_activity_shipping_address_edit, 28);
        sparseIntArray.put(R.layout.mall_activity_shipping_address_modify, 29);
        sparseIntArray.put(R.layout.mall_activity_shopping_message, 30);
        sparseIntArray.put(R.layout.mall_activity_test_play, 31);
        sparseIntArray.put(R.layout.mall_activity_try_see_list, 32);
        sparseIntArray.put(R.layout.mall_activity_video_enter, 33);
        sparseIntArray.put(R.layout.mall_activity_write_review, 34);
        sparseIntArray.put(R.layout.mall_activity_write_review_success, 35);
        sparseIntArray.put(R.layout.mall_dialog_cancel_reason, 36);
        sparseIntArray.put(R.layout.mall_dialog_create_poster, 37);
        sparseIntArray.put(R.layout.mall_dialog_fill_express, 38);
        sparseIntArray.put(R.layout.mall_dialog_goods_param, 39);
        sparseIntArray.put(R.layout.mall_dialog_goods_specification, 40);
        sparseIntArray.put(R.layout.mall_dialog_order_remark, 41);
        sparseIntArray.put(R.layout.mall_dialog_pay, 42);
        sparseIntArray.put(R.layout.mall_dialog_pay_points, 43);
        sparseIntArray.put(R.layout.mall_footer_order_detail, 44);
        sparseIntArray.put(R.layout.mall_fragment_all_video_goods, 45);
        sparseIntArray.put(R.layout.mall_fragment_choose_shop_order, 46);
        sparseIntArray.put(R.layout.mall_fragment_commodity, 47);
        sparseIntArray.put(R.layout.mall_fragment_commodity_comment_list, 48);
        sparseIntArray.put(R.layout.mall_fragment_episodes_list, 49);
        sparseIntArray.put(R.layout.mall_fragment_mall_item, 50);
        sparseIntArray.put(R.layout.mall_fragment_my_order_list, 51);
        sparseIntArray.put(R.layout.mall_fragment_purchased_video_goods, 52);
        sparseIntArray.put(R.layout.mall_fragment_refund_list, 53);
        sparseIntArray.put(R.layout.mall_fragment_search_result_goods, 54);
        sparseIntArray.put(R.layout.mall_fragment_select_goods, 55);
        sparseIntArray.put(R.layout.mall_header_order_detail, 56);
        sparseIntArray.put(R.layout.mall_item_apply_refund_pic, 57);
        sparseIntArray.put(R.layout.mall_item_apply_refund_pic_add, 58);
        sparseIntArray.put(R.layout.mall_item_cancel_reason, 59);
        sparseIntArray.put(R.layout.mall_item_choose_shop_order, 60);
        sparseIntArray.put(R.layout.mall_item_commodity, 61);
        sparseIntArray.put(R.layout.mall_item_commodity_comment, 62);
        sparseIntArray.put(R.layout.mall_item_course_detail, 63);
        sparseIntArray.put(R.layout.mall_item_episodes_list, 64);
        sparseIntArray.put(R.layout.mall_item_express_company, 65);
        sparseIntArray.put(R.layout.mall_item_express_company_name, 66);
        sparseIntArray.put(R.layout.mall_item_express_logistics, 67);
        sparseIntArray.put(R.layout.mall_item_express_logistics_head, 68);
        sparseIntArray.put(R.layout.mall_item_express_logistics_simple, 69);
        sparseIntArray.put(R.layout.mall_item_goods_detail_comment, 70);
        sparseIntArray.put(R.layout.mall_item_goods_detail_shop, 71);
        sparseIntArray.put(R.layout.mall_item_goods_detail_shop_item, 72);
        sparseIntArray.put(R.layout.mall_item_goods_param, 73);
        sparseIntArray.put(R.layout.mall_item_goods_specification, 74);
        sparseIntArray.put(R.layout.mall_item_goods_specification_preview, 75);
        sparseIntArray.put(R.layout.mall_item_my_order, 76);
        sparseIntArray.put(R.layout.mall_item_my_order_goods, 77);
        sparseIntArray.put(R.layout.mall_item_order_detail_goods, 78);
        sparseIntArray.put(R.layout.mall_item_poster_bg, 79);
        sparseIntArray.put(R.layout.mall_item_purchased_video_goods, 80);
        sparseIntArray.put(R.layout.mall_item_refund_list, 81);
        sparseIntArray.put(R.layout.mall_item_refund_refund_detail_file, 82);
        sparseIntArray.put(R.layout.mall_item_reward_shipping_address, 83);
        sparseIntArray.put(R.layout.mall_item_rule_center, 84);
        sparseIntArray.put(R.layout.mall_item_search_text_switch, 85);
        sparseIntArray.put(R.layout.mall_item_select_goods, 86);
        sparseIntArray.put(R.layout.mall_item_shipping_address, 87);
        sparseIntArray.put(R.layout.mall_item_shipping_address_modify, 88);
        sparseIntArray.put(R.layout.mall_item_shopping_message, 89);
        sparseIntArray.put(R.layout.mall_item_shopping_message_header, 90);
        sparseIntArray.put(R.layout.mall_item_test_video, 91);
        sparseIntArray.put(R.layout.mall_item_try_see_list, 92);
        sparseIntArray.put(R.layout.mall_item_write_review_image, 93);
        sparseIntArray.put(R.layout.mall_item_write_review_image_add, 94);
        sparseIntArray.put(R.layout.mall_layout_empty_data, 95);
        sparseIntArray.put(R.layout.mall_layout_goods_detail_bottom, 96);
        sparseIntArray.put(R.layout.mall_layout_goods_detail_bottom_distributing, 97);
        sparseIntArray.put(R.layout.mall_layout_goods_detail_bottom_point, 98);
        sparseIntArray.put(R.layout.mall_layout_goods_detail_bottom_team_leader, 99);
        sparseIntArray.put(R.layout.mall_layout_goods_detail_toolbar, 100);
        sparseIntArray.put(R.layout.mall_view_course_detail_header, 101);
        sparseIntArray.put(R.layout.mall_view_goods_detail_header, 102);
        sparseIntArray.put(R.layout.mall_view_goods_detail_header_activity_content, 103);
        sparseIntArray.put(R.layout.mall_view_goods_detail_header_content, 104);
        sparseIntArray.put(R.layout.mall_view_order_detail_address, 105);
        sparseIntArray.put(R.layout.mall_view_order_detail_deliver, 106);
        sparseIntArray.put(R.layout.mall_view_order_detail_service, 107);
        sparseIntArray.put(R.layout.mall_view_refund_detail_address, 108);
    }

    public final ViewDataBinding a(DataBindingComponent dataBindingComponent, View view, int i2, Object obj) {
        switch (i2) {
            case 1:
                if ("layout/mall_activity_apply_refund_0".equals(obj)) {
                    return new MallActivityApplyRefundBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_apply_refund is invalid. Received: " + obj);
            case 2:
                if ("layout/mall_activity_banner_preview_0".equals(obj)) {
                    return new MallActivityBannerPreviewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_banner_preview is invalid. Received: " + obj);
            case 3:
                if ("layout/mall_activity_cat_0".equals(obj)) {
                    return new MallActivityCatBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_cat is invalid. Received: " + obj);
            case 4:
                if ("layout/mall_activity_check_order_0".equals(obj)) {
                    return new MallActivityCheckOrderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_check_order is invalid. Received: " + obj);
            case 5:
                if ("layout/mall_activity_commodity_comment_detail_0".equals(obj)) {
                    return new MallActivityCommodityCommentDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_commodity_comment_detail is invalid. Received: " + obj);
            case 6:
                if ("layout/mall_activity_commodity_comment_list_0".equals(obj)) {
                    return new MallActivityCommodityCommentListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_commodity_comment_list is invalid. Received: " + obj);
            case 7:
                if ("layout/mall_activity_course_detail_0".equals(obj)) {
                    return new MallActivityCourseDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_course_detail is invalid. Received: " + obj);
            case 8:
                if ("layout/mall_activity_episodes_detail_0".equals(obj)) {
                    return new MallActivityEpisodesDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_episodes_detail is invalid. Received: " + obj);
            case 9:
                if ("layout/mall_activity_express_company_0".equals(obj)) {
                    return new MallActivityExpressCompanyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_express_company is invalid. Received: " + obj);
            case 10:
                if ("layout/mall_activity_express_logistics_0".equals(obj)) {
                    return new MallActivityExpressLogisticsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_express_logistics is invalid. Received: " + obj);
            case 11:
                if ("layout/mall_activity_goods_detail_0".equals(obj)) {
                    return new MallActivityGoodsDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_goods_detail is invalid. Received: " + obj);
            case 12:
                if ("layout/mall_activity_goods_specification_preview_0".equals(obj)) {
                    return new MallActivityGoodsSpecificationPreviewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_goods_specification_preview is invalid. Received: " + obj);
            case 13:
                if ("layout/mall_activity_lkl_webview_0".equals(obj)) {
                    return new MallActivityLklWebviewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_lkl_webview is invalid. Received: " + obj);
            case 14:
                if ("layout/mall_activity_mall_0".equals(obj)) {
                    return new MallActivityMallBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_mall is invalid. Received: " + obj);
            case 15:
                if ("layout/mall_activity_mall_search_0".equals(obj)) {
                    return new MallActivityMallSearchBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_mall_search is invalid. Received: " + obj);
            case 16:
                if ("layout/mall_activity_merchants_0".equals(obj)) {
                    return new MallActivityMerchantsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_merchants is invalid. Received: " + obj);
            case 17:
                if ("layout/mall_activity_my_order_0".equals(obj)) {
                    return new MallActivityMyOrderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_my_order is invalid. Received: " + obj);
            case 18:
                if ("layout/mall_activity_order_detail_0".equals(obj)) {
                    return new MallActivityOrderDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_order_detail is invalid. Received: " + obj);
            case 19:
                if ("layout/mall_activity_pay_result_0".equals(obj)) {
                    return new MallActivityPayResultBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_pay_result is invalid. Received: " + obj);
            case 20:
                if ("layout/mall_activity_redeem_pionts_result_0".equals(obj)) {
                    return new MallActivityRedeemPiontsResultBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_redeem_pionts_result is invalid. Received: " + obj);
            case 21:
                if ("layout/mall_activity_refund_detail_0".equals(obj)) {
                    return new MallActivityRefundDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_refund_detail is invalid. Received: " + obj);
            case 22:
                if ("layout/mall_activity_refund_list_0".equals(obj)) {
                    return new MallActivityRefundListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_refund_list is invalid. Received: " + obj);
            case 23:
                if ("layout/mall_activity_reward_pay_suc_0".equals(obj)) {
                    return new MallActivityRewardPaySucBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_reward_pay_suc is invalid. Received: " + obj);
            case 24:
                if ("layout/mall_activity_reward_shipping_address_0".equals(obj)) {
                    return new MallActivityRewardShippingAddressBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_reward_shipping_address is invalid. Received: " + obj);
            case 25:
                if ("layout/mall_activity_rule_center_0".equals(obj)) {
                    return new MallActivityRuleCenterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_rule_center is invalid. Received: " + obj);
            case 26:
                if ("layout/mall_activity_select_goods_0".equals(obj)) {
                    return new MallActivitySelectGoodsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_select_goods is invalid. Received: " + obj);
            case 27:
                if ("layout/mall_activity_shipping_address_0".equals(obj)) {
                    return new MallActivityShippingAddressBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_shipping_address is invalid. Received: " + obj);
            case 28:
                if ("layout/mall_activity_shipping_address_edit_0".equals(obj)) {
                    return new MallActivityShippingAddressEditBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_shipping_address_edit is invalid. Received: " + obj);
            case 29:
                if ("layout/mall_activity_shipping_address_modify_0".equals(obj)) {
                    return new MallActivityShippingAddressModifyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_shipping_address_modify is invalid. Received: " + obj);
            case 30:
                if ("layout/mall_activity_shopping_message_0".equals(obj)) {
                    return new MallActivityShoppingMessageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_shopping_message is invalid. Received: " + obj);
            case 31:
                if ("layout/mall_activity_test_play_0".equals(obj)) {
                    return new MallActivityTestPlayBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_test_play is invalid. Received: " + obj);
            case 32:
                if ("layout/mall_activity_try_see_list_0".equals(obj)) {
                    return new MallActivityTrySeeListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_try_see_list is invalid. Received: " + obj);
            case 33:
                if ("layout/mall_activity_video_enter_0".equals(obj)) {
                    return new MallActivityVideoEnterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_video_enter is invalid. Received: " + obj);
            case 34:
                if ("layout/mall_activity_write_review_0".equals(obj)) {
                    return new MallActivityWriteReviewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_write_review is invalid. Received: " + obj);
            case 35:
                if ("layout/mall_activity_write_review_success_0".equals(obj)) {
                    return new MallActivityWriteReviewSuccessBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_activity_write_review_success is invalid. Received: " + obj);
            case 36:
                if ("layout/mall_dialog_cancel_reason_0".equals(obj)) {
                    return new MallDialogCancelReasonBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_dialog_cancel_reason is invalid. Received: " + obj);
            case 37:
                if ("layout/mall_dialog_create_poster_0".equals(obj)) {
                    return new MallDialogCreatePosterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_dialog_create_poster is invalid. Received: " + obj);
            case 38:
                if ("layout/mall_dialog_fill_express_0".equals(obj)) {
                    return new MallDialogFillExpressBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_dialog_fill_express is invalid. Received: " + obj);
            case 39:
                if ("layout/mall_dialog_goods_param_0".equals(obj)) {
                    return new MallDialogGoodsParamBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_dialog_goods_param is invalid. Received: " + obj);
            case 40:
                if ("layout/mall_dialog_goods_specification_0".equals(obj)) {
                    return new MallDialogGoodsSpecificationBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_dialog_goods_specification is invalid. Received: " + obj);
            case 41:
                if ("layout/mall_dialog_order_remark_0".equals(obj)) {
                    return new MallDialogOrderRemarkBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_dialog_order_remark is invalid. Received: " + obj);
            case 42:
                if ("layout/mall_dialog_pay_0".equals(obj)) {
                    return new MallDialogPayBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_dialog_pay is invalid. Received: " + obj);
            case 43:
                if ("layout/mall_dialog_pay_points_0".equals(obj)) {
                    return new MallDialogPayPointsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_dialog_pay_points is invalid. Received: " + obj);
            case 44:
                if ("layout/mall_footer_order_detail_0".equals(obj)) {
                    return new MallFooterOrderDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_footer_order_detail is invalid. Received: " + obj);
            case 45:
                if ("layout/mall_fragment_all_video_goods_0".equals(obj)) {
                    return new MallFragmentAllVideoGoodsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_fragment_all_video_goods is invalid. Received: " + obj);
            case 46:
                if ("layout/mall_fragment_choose_shop_order_0".equals(obj)) {
                    return new MallFragmentChooseShopOrderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_fragment_choose_shop_order is invalid. Received: " + obj);
            case 47:
                if ("layout/mall_fragment_commodity_0".equals(obj)) {
                    return new MallFragmentCommodityBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_fragment_commodity is invalid. Received: " + obj);
            case 48:
                if ("layout/mall_fragment_commodity_comment_list_0".equals(obj)) {
                    return new MallFragmentCommodityCommentListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_fragment_commodity_comment_list is invalid. Received: " + obj);
            case 49:
                if ("layout/mall_fragment_episodes_list_0".equals(obj)) {
                    return new MallFragmentEpisodesListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_fragment_episodes_list is invalid. Received: " + obj);
            case 50:
                if ("layout/mall_fragment_mall_item_0".equals(obj)) {
                    return new MallFragmentMallItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_fragment_mall_item is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    public final ViewDataBinding b(DataBindingComponent dataBindingComponent, View view, int i2, Object obj) {
        switch (i2) {
            case 51:
                if ("layout/mall_fragment_my_order_list_0".equals(obj)) {
                    return new MallFragmentMyOrderListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_fragment_my_order_list is invalid. Received: " + obj);
            case 52:
                if ("layout/mall_fragment_purchased_video_goods_0".equals(obj)) {
                    return new MallFragmentPurchasedVideoGoodsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_fragment_purchased_video_goods is invalid. Received: " + obj);
            case 53:
                if ("layout/mall_fragment_refund_list_0".equals(obj)) {
                    return new MallFragmentRefundListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_fragment_refund_list is invalid. Received: " + obj);
            case 54:
                if ("layout/mall_fragment_search_result_goods_0".equals(obj)) {
                    return new MallFragmentSearchResultGoodsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_fragment_search_result_goods is invalid. Received: " + obj);
            case 55:
                if ("layout/mall_fragment_select_goods_0".equals(obj)) {
                    return new MallFragmentSelectGoodsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_fragment_select_goods is invalid. Received: " + obj);
            case 56:
                if ("layout/mall_header_order_detail_0".equals(obj)) {
                    return new MallHeaderOrderDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_header_order_detail is invalid. Received: " + obj);
            case 57:
                if ("layout/mall_item_apply_refund_pic_0".equals(obj)) {
                    return new MallItemApplyRefundPicBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_apply_refund_pic is invalid. Received: " + obj);
            case 58:
                if ("layout/mall_item_apply_refund_pic_add_0".equals(obj)) {
                    return new MallItemApplyRefundPicAddBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_apply_refund_pic_add is invalid. Received: " + obj);
            case 59:
                if ("layout/mall_item_cancel_reason_0".equals(obj)) {
                    return new MallItemCancelReasonBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_cancel_reason is invalid. Received: " + obj);
            case 60:
                if ("layout/mall_item_choose_shop_order_0".equals(obj)) {
                    return new MallItemChooseShopOrderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_choose_shop_order is invalid. Received: " + obj);
            case 61:
                if ("layout/mall_item_commodity_0".equals(obj)) {
                    return new MallItemCommodityBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_commodity is invalid. Received: " + obj);
            case 62:
                if ("layout/mall_item_commodity_comment_0".equals(obj)) {
                    return new MallItemCommodityCommentBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_commodity_comment is invalid. Received: " + obj);
            case 63:
                if ("layout/mall_item_course_detail_0".equals(obj)) {
                    return new MallItemCourseDetailBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_course_detail is invalid. Received: " + obj);
            case 64:
                if ("layout/mall_item_episodes_list_0".equals(obj)) {
                    return new MallItemEpisodesListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_episodes_list is invalid. Received: " + obj);
            case 65:
                if ("layout/mall_item_express_company_0".equals(obj)) {
                    return new MallItemExpressCompanyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_express_company is invalid. Received: " + obj);
            case 66:
                if ("layout/mall_item_express_company_name_0".equals(obj)) {
                    return new MallItemExpressCompanyNameBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_express_company_name is invalid. Received: " + obj);
            case 67:
                if ("layout/mall_item_express_logistics_0".equals(obj)) {
                    return new MallItemExpressLogisticsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_express_logistics is invalid. Received: " + obj);
            case 68:
                if ("layout/mall_item_express_logistics_head_0".equals(obj)) {
                    return new MallItemExpressLogisticsHeadBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_express_logistics_head is invalid. Received: " + obj);
            case 69:
                if ("layout/mall_item_express_logistics_simple_0".equals(obj)) {
                    return new MallItemExpressLogisticsSimpleBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_express_logistics_simple is invalid. Received: " + obj);
            case 70:
                if ("layout/mall_item_goods_detail_comment_0".equals(obj)) {
                    return new MallItemGoodsDetailCommentBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_goods_detail_comment is invalid. Received: " + obj);
            case 71:
                if ("layout/mall_item_goods_detail_shop_0".equals(obj)) {
                    return new MallItemGoodsDetailShopBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_goods_detail_shop is invalid. Received: " + obj);
            case 72:
                if ("layout/mall_item_goods_detail_shop_item_0".equals(obj)) {
                    return new MallItemGoodsDetailShopItemBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_goods_detail_shop_item is invalid. Received: " + obj);
            case 73:
                if ("layout/mall_item_goods_param_0".equals(obj)) {
                    return new MallItemGoodsParamBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_goods_param is invalid. Received: " + obj);
            case 74:
                if ("layout/mall_item_goods_specification_0".equals(obj)) {
                    return new MallItemGoodsSpecificationBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_goods_specification is invalid. Received: " + obj);
            case 75:
                if ("layout/mall_item_goods_specification_preview_0".equals(obj)) {
                    return new MallItemGoodsSpecificationPreviewBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_goods_specification_preview is invalid. Received: " + obj);
            case 76:
                if ("layout/mall_item_my_order_0".equals(obj)) {
                    return new MallItemMyOrderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_my_order is invalid. Received: " + obj);
            case 77:
                if ("layout/mall_item_my_order_goods_0".equals(obj)) {
                    return new MallItemMyOrderGoodsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_my_order_goods is invalid. Received: " + obj);
            case 78:
                if ("layout/mall_item_order_detail_goods_0".equals(obj)) {
                    return new MallItemOrderDetailGoodsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_order_detail_goods is invalid. Received: " + obj);
            case 79:
                if ("layout/mall_item_poster_bg_0".equals(obj)) {
                    return new MallItemPosterBgBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_poster_bg is invalid. Received: " + obj);
            case 80:
                if ("layout/mall_item_purchased_video_goods_0".equals(obj)) {
                    return new MallItemPurchasedVideoGoodsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_purchased_video_goods is invalid. Received: " + obj);
            case 81:
                if ("layout/mall_item_refund_list_0".equals(obj)) {
                    return new MallItemRefundListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_refund_list is invalid. Received: " + obj);
            case 82:
                if ("layout/mall_item_refund_refund_detail_file_0".equals(obj)) {
                    return new MallItemRefundRefundDetailFileBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_refund_refund_detail_file is invalid. Received: " + obj);
            case 83:
                if ("layout/mall_item_reward_shipping_address_0".equals(obj)) {
                    return new MallItemRewardShippingAddressBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_reward_shipping_address is invalid. Received: " + obj);
            case 84:
                if ("layout/mall_item_rule_center_0".equals(obj)) {
                    return new MallItemRuleCenterBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_rule_center is invalid. Received: " + obj);
            case 85:
                if ("layout/mall_item_search_text_switch_0".equals(obj)) {
                    return new MallItemSearchTextSwitchBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_search_text_switch is invalid. Received: " + obj);
            case 86:
                if ("layout/mall_item_select_goods_0".equals(obj)) {
                    return new MallItemSelectGoodsBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_select_goods is invalid. Received: " + obj);
            case 87:
                if ("layout/mall_item_shipping_address_0".equals(obj)) {
                    return new MallItemShippingAddressBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_shipping_address is invalid. Received: " + obj);
            case 88:
                if ("layout/mall_item_shipping_address_modify_0".equals(obj)) {
                    return new MallItemShippingAddressModifyBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_shipping_address_modify is invalid. Received: " + obj);
            case 89:
                if ("layout/mall_item_shopping_message_0".equals(obj)) {
                    return new MallItemShoppingMessageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_shopping_message is invalid. Received: " + obj);
            case 90:
                if ("layout/mall_item_shopping_message_header_0".equals(obj)) {
                    return new MallItemShoppingMessageHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_shopping_message_header is invalid. Received: " + obj);
            case 91:
                if ("layout/mall_item_test_video_0".equals(obj)) {
                    return new MallItemTestVideoBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_test_video is invalid. Received: " + obj);
            case 92:
                if ("layout/mall_item_try_see_list_0".equals(obj)) {
                    return new MallItemTrySeeListBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_try_see_list is invalid. Received: " + obj);
            case 93:
                if ("layout/mall_item_write_review_image_0".equals(obj)) {
                    return new MallItemWriteReviewImageBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_write_review_image is invalid. Received: " + obj);
            case 94:
                if ("layout/mall_item_write_review_image_add_0".equals(obj)) {
                    return new MallItemWriteReviewImageAddBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_item_write_review_image_add is invalid. Received: " + obj);
            case 95:
                if ("layout/mall_layout_empty_data_0".equals(obj)) {
                    return new MallLayoutEmptyDataBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_layout_empty_data is invalid. Received: " + obj);
            case 96:
                if ("layout/mall_layout_goods_detail_bottom_0".equals(obj)) {
                    return new MallLayoutGoodsDetailBottomBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_layout_goods_detail_bottom is invalid. Received: " + obj);
            case 97:
                if ("layout/mall_layout_goods_detail_bottom_distributing_0".equals(obj)) {
                    return new MallLayoutGoodsDetailBottomDistributingBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_layout_goods_detail_bottom_distributing is invalid. Received: " + obj);
            case 98:
                if ("layout/mall_layout_goods_detail_bottom_point_0".equals(obj)) {
                    return new MallLayoutGoodsDetailBottomPointBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_layout_goods_detail_bottom_point is invalid. Received: " + obj);
            case 99:
                if ("layout/mall_layout_goods_detail_bottom_team_leader_0".equals(obj)) {
                    return new MallLayoutGoodsDetailBottomTeamLeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_layout_goods_detail_bottom_team_leader is invalid. Received: " + obj);
            case 100:
                if ("layout/mall_layout_goods_detail_toolbar_0".equals(obj)) {
                    return new MallLayoutGoodsDetailToolbarBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_layout_goods_detail_toolbar is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    public final ViewDataBinding c(DataBindingComponent dataBindingComponent, View view, int i2, Object obj) {
        switch (i2) {
            case 101:
                if ("layout/mall_view_course_detail_header_0".equals(obj)) {
                    return new MallViewCourseDetailHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_view_course_detail_header is invalid. Received: " + obj);
            case 102:
                if ("layout/mall_view_goods_detail_header_0".equals(obj)) {
                    return new MallViewGoodsDetailHeaderBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_view_goods_detail_header is invalid. Received: " + obj);
            case 103:
                if ("layout/mall_view_goods_detail_header_activity_content_0".equals(obj)) {
                    return new MallViewGoodsDetailHeaderActivityContentBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_view_goods_detail_header_activity_content is invalid. Received: " + obj);
            case 104:
                if ("layout/mall_view_goods_detail_header_content_0".equals(obj)) {
                    return new MallViewGoodsDetailHeaderContentBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_view_goods_detail_header_content is invalid. Received: " + obj);
            case 105:
                if ("layout/mall_view_order_detail_address_0".equals(obj)) {
                    return new MallViewOrderDetailAddressBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_view_order_detail_address is invalid. Received: " + obj);
            case 106:
                if ("layout/mall_view_order_detail_deliver_0".equals(obj)) {
                    return new MallViewOrderDetailDeliverBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_view_order_detail_deliver is invalid. Received: " + obj);
            case 107:
                if ("layout/mall_view_order_detail_service_0".equals(obj)) {
                    return new MallViewOrderDetailServiceBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_view_order_detail_service is invalid. Received: " + obj);
            case 108:
                if ("layout/mall_view_refund_detail_address_0".equals(obj)) {
                    return new MallViewRefundDetailAddressBindingImpl(dataBindingComponent, view);
                }
                throw new IllegalArgumentException("The tag for mall_view_refund_detail_address is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    @Override // androidx.coroutines.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(11);
        arrayList.add(new androidx.coroutines.library.baseAdapters.DataBinderMapperImpl());
        arrayList.add(new com.flyco.tablayout.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.ad.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.base.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.college.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.common.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.im.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.pay.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.qrcode.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.step.DataBinderMapperImpl());
        arrayList.add(new com.huachenjie.works.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.coroutines.DataBinderMapper
    public String convertBrIdToString(int i2) {
        return a.f34761a.get(i2);
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i2) {
        int i3 = f10124a.get(i2);
        if (i3 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        int i4 = (i3 - 1) / 50;
        if (i4 == 0) {
            return a(dataBindingComponent, view, i3, tag);
        }
        if (i4 == 1) {
            return b(dataBindingComponent, view, i3, tag);
        }
        if (i4 != 2) {
            return null;
        }
        return c(dataBindingComponent, view, i3, tag);
    }

    @Override // androidx.coroutines.DataBinderMapper
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f34762a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i2) {
        if (viewArr == null || viewArr.length == 0 || f10124a.get(i2) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}

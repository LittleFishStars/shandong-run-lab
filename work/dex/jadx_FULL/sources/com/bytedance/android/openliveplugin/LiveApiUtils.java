package com.bytedance.android.openliveplugin;

import com.bytedance.gromore.R;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class LiveApiUtils {
    public static Map<String, Integer> getCJPayAnimationResourceMap() {
        HashMap map = new HashMap();
        map.put("TTCJPayKeyActivityAddInAnimationResource", Integer.valueOf(R.anim.cj_pay_activity_add_in_animation));
        map.put("TTCJPayKeyActivityRemoveOutAnimationResource", Integer.valueOf(R.anim.cj_pay_activity_remove_out_animation));
        map.put("TTCJPayKeyActivityFadeInAnimationResource", Integer.valueOf(R.anim.cj_pay_activity_fade_in_animation));
        map.put("TTCJPayKeyActivityFadeOutAnimationResource", Integer.valueOf(R.anim.cj_pay_activity_fade_out_animation));
        map.put("TTCJPayKeySlideInFromBottomAnimationResource", Integer.valueOf(R.anim.cj_pay_slide_in_from_bottom_with_bezier));
        map.put("TTCJPayKeySlideOutToBottomAnimationResource", Integer.valueOf(R.anim.cj_pay_slide_out_to_bottom_with_bezier));
        map.put("TTCJPayKeySlideRightInAnimationResource", Integer.valueOf(R.anim.cj_pay_slide_right_in));
        map.put("TTCJPayKeyFragmentUpInAnimationResource", Integer.valueOf(R.anim.cj_pay_fragment_up_in_animation));
        map.put("TTCJPayKeyFragmentDownOutAnimationResource", Integer.valueOf(R.anim.cj_pay_fragment_down_out_animation));
        return map;
    }
}

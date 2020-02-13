package com.example.wjk.myapplication.app;

import android.content.Context;

/**
 * @author AllenKK
 * @version 1.0
 * @date 16/12/25
 * @Description transition between dp and px
 */

public class DensityUtil {
    
    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
    
    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
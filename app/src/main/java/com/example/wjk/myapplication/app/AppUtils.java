package com.example.wjk.myapplication.app;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class AppUtils {


    /**
     * 获取当前版本号
     *
     * @param context 上下文
     * @return 版本号
     */
    public static String getVersionName(Context context) {
        String versionName = "";
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo("com.package.name", 0);
            versionName = packageInfo.versionName;
        } catch (Exception e) {
            versionName = "";
        }
        return versionName;
    }
}
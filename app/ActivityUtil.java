import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Process;

/**
 * @author AllenKK
 * @version 1.0
 * @date 16/12/26
 * @Description activity utils
 */

public class ActivityUtil {

    /**
     * whether the activity is exist in the specific package
     *
     * @param context
     * @param packageName
     * @param activityName
     * @return
     */
    public static boolean isActivityExist(Context context, String packageName, String activityName) {
        Intent intent = new Intent();
        intent.setClassName(packageName, activityName);
        return !(context.getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) == null ||
                intent.resolveActivity(context.getPackageManager()) == null ||
                context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY).size() == 0);
    }

    /**
     * find the entry point(launcher activity) for the specific package
     *
     * @param context
     * @param packageName
     * @return
     */
    public static String launcherActivity(Context context, String packageName) {
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);

        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> info = pm.queryIntentActivities(intent, 0);
        for (ResolveInfo item : info) {
            if (item.activityInfo.packageName.equals(packageName)) {
                return item.activityInfo.name;
            }
        }
        return null;
    }

    /**
     * get the name of current process
     *
     * @param context
     * @return
     */
    public static String getCurrentProcessName(Context context) {
        String processName = "";
        int pid = Process.myPid();
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo info : manager.getRunningAppProcesses()) {
            if (info.pid == pid) {
                processName = info.processName;
                break;
            }
        }
        return processName;
    }
}

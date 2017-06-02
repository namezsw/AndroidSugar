package com.seven.library.controller;

import android.app.Activity;
import android.content.Context;

import java.util.Stack;

import javax.inject.Inject;

/**
 * Activity管理工具类,将activity放入栈统一管理
 * Created by Seven on 2017/2/15.
 */
public class ActivityManager {
    //activity管理栈
    private volatile Stack<Activity> activityStack;
    //全局单例
    private static volatile ActivityManager instance;
    private Activity currentActivity;

    @Inject
    public ActivityManager() {
        activityStack = new Stack<>();
    }

    /**
     * 单例
     *
     * @return ActivityManager实例
     */
    public static ActivityManager getInstance() {
        if (instance == null)
            instance = new ActivityManager();
        return instance;
    }

    /**
     * 添加activity到管理栈
     *
     * @param activity activity
     */
    public void addActivity(Activity activity) {
        activityStack.add(activity);
    }

    /**
     * 移除activity
     *
     * @param activity activity
     */
    public void removeActivity(Activity activity) {
        activityStack.remove(activity);
    }

    /**
     * 获取管理栈顶的activity
     *
     * @return 栈顶的activity
     */
    public Activity getTopActivity() {
        return activityStack.lastElement();
    }

    /**
     * 将在前台的activity保存
     *
     * @param currentActivity
     */
    public void setCurrentActivity(Activity currentActivity) {
        this.currentActivity = currentActivity;
    }

    /**
     * 获得当前在前台的activity
     *
     * @return 前台的activity
     */
    public Activity getCurrentActivity() {
        return currentActivity;
    }

    /**
     * 结束指定的activity
     *
     * @param activity activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 结束指定的activity(class方式)
     *
     * @param activityClass activityClass
     */
    public void finishActivity(Class<? extends Activity> activityClass) {
        for (Activity activity : activityStack) {
            if (activityClass.equals(activity.getClass()))
                finishActivity(activity);
        }
    }

    /**
     * 是否存在指定的activity(class方式)
     *
     * @param activityClass activityClass
     */
    public boolean hasActivity(Class<? extends Activity> activityClass) {
        for (Activity activity : activityStack) {
            if (activityClass.equals(activity.getClass()))
                return true;
        }
        return false;
    }


    /**
     * 退出栈中其他所有Activity
     *
     * @param cls activityClass
     */
    public void popOtherActivity(Class<? extends Activity>... cls) {
        if (null == cls) return;
        for (Activity activity : activityStack) {
            boolean isActExist = false;
            for (int i = 0; i < cls.length; i++) {
                if (null == activity || activity.getClass().equals(cls[i])) {
                    isActExist = true;
                    break;
                }
            }
            if (!isActExist)
                activity.finish();
        }
    }

    /**
     * 结束所有的activity
     */
    public void finishAllActivity() {
        while (activityStack.size() > 0 && getCurrentActivity() != null) {
            finishActivity(getCurrentActivity());
        }
        activityStack.clear();
    }

    /**
     * 退出应用程序
     */
    public void killProcess(Context context) {
        try {
            finishAllActivity();
            android.app.ActivityManager activityMgr = (android.app.ActivityManager) context
                    .getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.killBackgroundProcesses(context.getPackageName());
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

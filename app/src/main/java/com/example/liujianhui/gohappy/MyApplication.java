package com.example.liujianhui.gohappy;


import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.demo.liujian.module.common.base.BaseApplication;
import com.demo.liujian.module.common.util.AppInfoUtil;
import com.demo.liujian.module.common.util.LogUtil;
import com.demo.liujian.module.common.util.ToastUtil;
import com.taobao.sophix.PatchStatus;
import com.taobao.sophix.SophixManager;
import com.taobao.sophix.listener.PatchLoadStatusListener;


public class MyApplication extends BaseApplication {
    private static final String TAG = MyApplication.class.getSimpleName();

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        // initialize最好放在attachBaseContext最前面
        String appVersion = "";
        try {
            PackageInfo localPackageInfo = base.getPackageManager().getPackageInfo(base.getPackageName(), 0);
            appVersion = localPackageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        SophixManager.getInstance().setContext(this)
                .setAppVersion(appVersion)
                .setAesKey("liujian123456789")
                .setEnableDebug(false)
                .setPatchLoadStatusStub(new PatchLoadStatusListener() {
                    @Override
                    public void onLoad(final int mode, final int code, final String info, final int handlePatchVersion) {
                        // 补丁加载回调通知
                        if (code == PatchStatus.CODE_LOAD_SUCCESS) {
                            // 表明补丁加载成功
                            LogUtil.d(TAG,"补丁加载成功  "+code);
                            ToastUtil.shortToast(MyApplication.this,"补丁加载成功   "+code);
                        } else if (code == PatchStatus.CODE_LOAD_RELAUNCH) {
                            // 表明新补丁生效需要重启. 开发者可提示用户或者强制重启;
                            // 建议: 用户可以监听进入后台事件, 然后调用killProcessSafely自杀，以此加快应用补丁
                            SophixManager.getInstance().killProcessSafely();

                            ToastUtil.shortToast(MyApplication.this,"新补丁生效需要重启:  "+code);
                            LogUtil.d(TAG,"新补丁生效需要重启  "+code);
                        } else {
                            ToastUtil.shortToast(MyApplication.this,"补丁失败:  "+code);
                            LogUtil.d(TAG,"新补丁生效需要重启  "+code);
                        }
                    }
                }).initialize();
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }
}

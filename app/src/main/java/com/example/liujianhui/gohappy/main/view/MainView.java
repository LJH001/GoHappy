package com.example.liujianhui.gohappy.main.view;

/**
 *description:视图切换接口<br/>
 * <br/>
 *author:liujianhui
 *creatorTime:2017/1/21  21:32
*/
public interface MainView {
    /**
     * 切换到新闻tab栏
     */
    void switchNews();

    /**
     * 切换到音乐tab栏
     */
    void switchMusic();

    /**
     * 切换到图片tab栏
     */
    void switchImages();

    /**
     * 切换到视频tab栏
     */
    void switchVideo();

    /**
     * 切换到导航栏的皮肤设置
     */
    void switchSetSkin();

    /**
     * 切换到导航栏的收藏
     */
    void switchCollection();

    /**
     * 切换到密码管理
     */
    void switchPwdManager();

    /**
     * 切换到版本更新
     */
    void switchVersionUpdate();

    /**
     * 切换到注册
     */
    void switchRegister();

    /**
     * 切换到登录
     */
    void switchLogin();

}

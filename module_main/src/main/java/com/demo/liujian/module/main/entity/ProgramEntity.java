package com.demo.liujian.module.main.entity;

import java.util.List;

/**
 * <p>Class: com.demo.liujian.module.main.entity.ProgramEntity</p>
 * <p>Description: </p>
 * <pre>
 *
 * </pre>
 *
 * @author liujianhui
 * @date 2021/2/25/18:23
 */

public class ProgramEntity {

    /**
     * data : {"curPage":1,"datas":[{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"host":"","id":17415,"link":"https://juejin.cn/post/6932778923491065864","niceDate":"1小时前","niceShareDate":"1小时前","origin":"","prefix":"","projectLink":"","publishTime":1614218071000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1614218071000,"shareUser":"renxhui","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Gradle学习系列（一）：Groovy学习","type":0,"userId":27931,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"host":"","id":17414,"link":"https://blog.csdn.net/knight1996/article/details/114028572","niceDate":"1小时前","niceShareDate":"1小时前","origin":"","prefix":"","projectLink":"","publishTime":1614216545000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1614216545000,"shareUser":"knight","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"类比学习&mdash;&mdash;java 泛型&amp; kotlin 泛型中的 in out where","type":0,"userId":1928,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"gdutxiaoxu","canEdit":false,"chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"锚点任务，可以用来解决多线程加载任务依赖的问题。常见的，比如 Android 启动优化，通常会进行多线程异步加载。\r\n\r\n它的实现原理是通过有向无环图的拓扑排序解决的。","descMd":"","envelopePic":"https://wanandroid.com/resources/image/pc/default_project_img.jpg","fresh":true,"host":"","id":17412,"link":"https://www.wanandroid.com/blog/show/2944","niceDate":"12小时前","niceShareDate":"12小时前","origin":"","prefix":"","projectLink":"https://github.com/gdutxiaoxu/AnchorTask","publishTime":1614179475000,"realSuperChapterId":293,"selfVisible":0,"shareDate":1614179475000,"shareUser":"","superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"AnchorTask - Android 启动优化 ","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"host":"","id":17408,"link":"https://juejin.cn/post/6932842985616834568","niceDate":"12小时前","niceShareDate":"12小时前","origin":"","prefix":"","projectLink":"","publishTime":1614178810000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1614178810000,"shareUser":"一只修仙的猿","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"这一篇TCP总结请收下","type":0,"userId":66812,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"host":"","id":17404,"link":"https://mp.weixin.qq.com/s/xWYe-uxgXTPuitYcLgXYNg","niceDate":"20小时前","niceShareDate":"20小时前","origin":"","prefix":"","projectLink":"","publishTime":1614149978000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1614149978000,"shareUser":"程序员徐公","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android 启动优化（一） - 有向无环图","type":0,"userId":5339,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"host":"","id":17398,"link":"https://juejin.cn/post/6844903881671966727","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1614129686000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1614129686000,"shareUser":"躬行之","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Gradle系列之Gradle插件","type":0,"userId":23270,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":89,"chapterName":"app缓存相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":17388,"link":"https://juejin.cn/post/6931912030144167950","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1614100559000,"realSuperChapterId":35,"selfVisible":0,"shareDate":1614100194000,"shareUser":"鸿洋","superChapterId":89,"superChapterName":"数据存储","tags":[],"title":"这是一篇你应该了解的Android数据存储优化","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":423,"chapterName":"Architecture","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":17390,"link":"https://juejin.cn/post/6931932235553570823","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1614100552000,"realSuperChapterId":422,"selfVisible":0,"shareDate":1614100273000,"shareUser":"鸿洋","superChapterId":423,"superChapterName":"Jetpack","tags":[],"title":"一个例子学会使用Jetpack Compose Modifier","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":89,"chapterName":"app缓存相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":17391,"link":"https://juejin.cn/post/6932277268110639112","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1614100543000,"realSuperChapterId":35,"selfVisible":0,"shareDate":1614100347000,"shareUser":"鸿洋","superChapterId":89,"superChapterName":"数据存储","tags":[],"title":"一文读懂 SharedPreferences 的缺陷及一点点思考","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":93,"chapterName":"基础知识","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":17392,"link":"https://www.jianshu.com/p/6e45f42da304","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1614100530000,"realSuperChapterId":37,"selfVisible":0,"shareDate":1614100357000,"shareUser":"鸿洋","superChapterId":126,"superChapterName":"自定义控件","tags":[],"title":"Android Window 如何确定大小/onMeasure()多次执行原因","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":40,"chapterName":"Context","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":17395,"link":"https://www.jianshu.com/p/fcd6341b09b6","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1614100523000,"realSuperChapterId":9,"selfVisible":0,"shareDate":1614100415000,"shareUser":"鸿洋","superChapterId":10,"superChapterName":"四大组件","tags":[],"title":"关于 Context 你需要知道的一切","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":169,"chapterName":"gradle","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":17396,"link":"https://www.jianshu.com/p/0248780eae06","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1614100511000,"realSuperChapterId":150,"selfVisible":0,"shareDate":1614100480000,"shareUser":"鸿洋","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Gradle 插件 + ASM 实战 - JVM 虚拟机加载 Class 原理","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":17409,"link":"https://mp.weixin.qq.com/s/VBMDIE0QHXQAMuIjon-Fjg","niceDate":"1天前","niceShareDate":"12小时前","origin":"","prefix":"","projectLink":"","publishTime":1614096000000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1614179365000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"再见SharedPreferences，你好MMKV！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"谷歌开发者","canEdit":false,"chapterId":415,"chapterName":"谷歌开发者","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":17410,"link":"https://mp.weixin.qq.com/s/7HeCJIhKJ8P4K1FaLPw8zw","niceDate":"1天前","niceShareDate":"12小时前","origin":"","prefix":"","projectLink":"","publishTime":1614096000000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1614179386000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/415/1"}],"title":"在多进程应用中使用 WorkManager","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"郭霖","canEdit":false,"chapterId":409,"chapterName":"郭霖","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":17411,"link":"https://mp.weixin.qq.com/s/GPYUA1Ff3kpQgurIDLr3rA","niceDate":"1天前","niceShareDate":"12小时前","origin":"","prefix":"","projectLink":"","publishTime":1614096000000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1614179402000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/409/1"}],"title":"ConcurrentHashMap竟然还能挖出这些东西！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"yetel","canEdit":false,"chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"EasyChat是一款开源的社交类的App。主要包含消息、好友、群组等相关的IM核心功能。部分界面参照了QQ、微信等相关社交APP。EasyChat APP采用MVVM模式构建。","descMd":"","envelopePic":"https://www.wanandroid.com/blogimgs/2efab4c3-4500-4980-ba31-0ca14098c6e0.png","fresh":false,"host":"","id":17387,"link":"https://www.wanandroid.com/blog/show/2943","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"https://github.com/yetel/EasyChatAndroidClient","publishTime":1614094021000,"realSuperChapterId":293,"selfVisible":0,"shareDate":1614094021000,"shareUser":"","superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"EasyChat是一款开源的社交类的App。主要包含消息、好友、群组等相关的IM核心功能","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"RuffianZhong","canEdit":false,"chapterId":539,"chapterName":"未分类","collect":false,"courseId":13,"desc":"本项目使用 MVVM 模式架构，使用 Jetpack 组件实现，功能代码实现组件化，目标是编写一个 玩安卓 客户端\r\n目前 MVVM 框架已经完成，Http 框架已经完成。玩安卓客户端功能代码正在进行中，组件化将在基础功能实现之后完成，请持续关注。。。","descMd":"","envelopePic":"https://www.wanandroid.com/resources/image/pc/default_project_img.jpg","fresh":false,"host":"","id":17386,"link":"https://www.wanandroid.com/blog/show/2942","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"https://github.com/RuffianZhong/JetpackMVVM","publishTime":1614093892000,"realSuperChapterId":293,"selfVisible":0,"shareDate":1614093892000,"shareUser":"","superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=539"}],"title":"MVVM+Jetpack+组件化模式架构项目","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":17383,"link":"https://www.jianshu.com/p/8b8265bcee23","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1614082982000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1614082982000,"shareUser":"KXwonderful","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Jetpack - Hilt","type":0,"userId":565,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":17381,"link":"https://juejin.cn/post/6930648501311242248","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1614068819000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1614068819000,"shareUser":"彭旭锐","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android | 代码混淆到底做了什么？","type":0,"userId":30587,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":17380,"link":"https://juejin.cn/post/6925702262102687758","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1614068708000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1614068708000,"shareUser":"吊儿郎当","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"App这么搞就永远不崩溃了","type":0,"userId":2554,"visible":1,"zan":0}],"offset":0,"over":false,"pageCount":503,"size":20,"total":10051}
     * errorCode : 0
     * errorMsg :
     */

    private DataBean data;
    private int errorCode;
    private String errorMsg;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static class DataBean {
        /**
         * curPage : 1
         * datas : [{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"host":"","id":17415,"link":"https://juejin.cn/post/6932778923491065864","niceDate":"1小时前","niceShareDate":"1小时前","origin":"","prefix":"","projectLink":"","publishTime":1614218071000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1614218071000,"shareUser":"renxhui","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Gradle学习系列（一）：Groovy学习","type":0,"userId":27931,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"host":"","id":17414,"link":"https://blog.csdn.net/knight1996/article/details/114028572","niceDate":"1小时前","niceShareDate":"1小时前","origin":"","prefix":"","projectLink":"","publishTime":1614216545000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1614216545000,"shareUser":"knight","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"类比学习&mdash;&mdash;java 泛型&amp; kotlin 泛型中的 in out where","type":0,"userId":1928,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"gdutxiaoxu","canEdit":false,"chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"锚点任务，可以用来解决多线程加载任务依赖的问题。常见的，比如 Android 启动优化，通常会进行多线程异步加载。\r\n\r\n它的实现原理是通过有向无环图的拓扑排序解决的。","descMd":"","envelopePic":"https://wanandroid.com/resources/image/pc/default_project_img.jpg","fresh":true,"host":"","id":17412,"link":"https://www.wanandroid.com/blog/show/2944","niceDate":"12小时前","niceShareDate":"12小时前","origin":"","prefix":"","projectLink":"https://github.com/gdutxiaoxu/AnchorTask","publishTime":1614179475000,"realSuperChapterId":293,"selfVisible":0,"shareDate":1614179475000,"shareUser":"","superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"AnchorTask - Android 启动优化 ","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"host":"","id":17408,"link":"https://juejin.cn/post/6932842985616834568","niceDate":"12小时前","niceShareDate":"12小时前","origin":"","prefix":"","projectLink":"","publishTime":1614178810000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1614178810000,"shareUser":"一只修仙的猿","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"这一篇TCP总结请收下","type":0,"userId":66812,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"host":"","id":17404,"link":"https://mp.weixin.qq.com/s/xWYe-uxgXTPuitYcLgXYNg","niceDate":"20小时前","niceShareDate":"20小时前","origin":"","prefix":"","projectLink":"","publishTime":1614149978000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1614149978000,"shareUser":"程序员徐公","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android 启动优化（一） - 有向无环图","type":0,"userId":5339,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":true,"host":"","id":17398,"link":"https://juejin.cn/post/6844903881671966727","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1614129686000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1614129686000,"shareUser":"躬行之","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Gradle系列之Gradle插件","type":0,"userId":23270,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":89,"chapterName":"app缓存相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":17388,"link":"https://juejin.cn/post/6931912030144167950","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1614100559000,"realSuperChapterId":35,"selfVisible":0,"shareDate":1614100194000,"shareUser":"鸿洋","superChapterId":89,"superChapterName":"数据存储","tags":[],"title":"这是一篇你应该了解的Android数据存储优化","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":423,"chapterName":"Architecture","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":17390,"link":"https://juejin.cn/post/6931932235553570823","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1614100552000,"realSuperChapterId":422,"selfVisible":0,"shareDate":1614100273000,"shareUser":"鸿洋","superChapterId":423,"superChapterName":"Jetpack","tags":[],"title":"一个例子学会使用Jetpack Compose Modifier","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":89,"chapterName":"app缓存相关","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":17391,"link":"https://juejin.cn/post/6932277268110639112","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1614100543000,"realSuperChapterId":35,"selfVisible":0,"shareDate":1614100347000,"shareUser":"鸿洋","superChapterId":89,"superChapterName":"数据存储","tags":[],"title":"一文读懂 SharedPreferences 的缺陷及一点点思考","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":93,"chapterName":"基础知识","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":17392,"link":"https://www.jianshu.com/p/6e45f42da304","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1614100530000,"realSuperChapterId":37,"selfVisible":0,"shareDate":1614100357000,"shareUser":"鸿洋","superChapterId":126,"superChapterName":"自定义控件","tags":[],"title":"Android Window 如何确定大小/onMeasure()多次执行原因","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":40,"chapterName":"Context","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":17395,"link":"https://www.jianshu.com/p/fcd6341b09b6","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1614100523000,"realSuperChapterId":9,"selfVisible":0,"shareDate":1614100415000,"shareUser":"鸿洋","superChapterId":10,"superChapterName":"四大组件","tags":[],"title":"关于 Context 你需要知道的一切","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":169,"chapterName":"gradle","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":17396,"link":"https://www.jianshu.com/p/0248780eae06","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1614100511000,"realSuperChapterId":150,"selfVisible":0,"shareDate":1614100480000,"shareUser":"鸿洋","superChapterId":60,"superChapterName":"开发环境","tags":[],"title":"Gradle 插件 + ASM 实战 - JVM 虚拟机加载 Class 原理","type":0,"userId":2,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"鸿洋","canEdit":false,"chapterId":408,"chapterName":"鸿洋","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":17409,"link":"https://mp.weixin.qq.com/s/VBMDIE0QHXQAMuIjon-Fjg","niceDate":"1天前","niceShareDate":"12小时前","origin":"","prefix":"","projectLink":"","publishTime":1614096000000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1614179365000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/408/1"}],"title":"再见SharedPreferences，你好MMKV！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"谷歌开发者","canEdit":false,"chapterId":415,"chapterName":"谷歌开发者","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":17410,"link":"https://mp.weixin.qq.com/s/7HeCJIhKJ8P4K1FaLPw8zw","niceDate":"1天前","niceShareDate":"12小时前","origin":"","prefix":"","projectLink":"","publishTime":1614096000000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1614179386000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/415/1"}],"title":"在多进程应用中使用 WorkManager","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"郭霖","canEdit":false,"chapterId":409,"chapterName":"郭霖","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":17411,"link":"https://mp.weixin.qq.com/s/GPYUA1Ff3kpQgurIDLr3rA","niceDate":"1天前","niceShareDate":"12小时前","origin":"","prefix":"","projectLink":"","publishTime":1614096000000,"realSuperChapterId":407,"selfVisible":0,"shareDate":1614179402000,"shareUser":"","superChapterId":408,"superChapterName":"公众号","tags":[{"name":"公众号","url":"/wxarticle/list/409/1"}],"title":"ConcurrentHashMap竟然还能挖出这些东西！","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"yetel","canEdit":false,"chapterId":294,"chapterName":"完整项目","collect":false,"courseId":13,"desc":"EasyChat是一款开源的社交类的App。主要包含消息、好友、群组等相关的IM核心功能。部分界面参照了QQ、微信等相关社交APP。EasyChat APP采用MVVM模式构建。","descMd":"","envelopePic":"https://www.wanandroid.com/blogimgs/2efab4c3-4500-4980-ba31-0ca14098c6e0.png","fresh":false,"host":"","id":17387,"link":"https://www.wanandroid.com/blog/show/2943","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"https://github.com/yetel/EasyChatAndroidClient","publishTime":1614094021000,"realSuperChapterId":293,"selfVisible":0,"shareDate":1614094021000,"shareUser":"","superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=294"}],"title":"EasyChat是一款开源的社交类的App。主要包含消息、好友、群组等相关的IM核心功能","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"RuffianZhong","canEdit":false,"chapterId":539,"chapterName":"未分类","collect":false,"courseId":13,"desc":"本项目使用 MVVM 模式架构，使用 Jetpack 组件实现，功能代码实现组件化，目标是编写一个 玩安卓 客户端\r\n目前 MVVM 框架已经完成，Http 框架已经完成。玩安卓客户端功能代码正在进行中，组件化将在基础功能实现之后完成，请持续关注。。。","descMd":"","envelopePic":"https://www.wanandroid.com/resources/image/pc/default_project_img.jpg","fresh":false,"host":"","id":17386,"link":"https://www.wanandroid.com/blog/show/2942","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"https://github.com/RuffianZhong/JetpackMVVM","publishTime":1614093892000,"realSuperChapterId":293,"selfVisible":0,"shareDate":1614093892000,"shareUser":"","superChapterId":294,"superChapterName":"开源项目主Tab","tags":[{"name":"项目","url":"/project/list/1?cid=539"}],"title":"MVVM+Jetpack+组件化模式架构项目","type":0,"userId":-1,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":17383,"link":"https://www.jianshu.com/p/8b8265bcee23","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1614082982000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1614082982000,"shareUser":"KXwonderful","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Jetpack - Hilt","type":0,"userId":565,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":17381,"link":"https://juejin.cn/post/6930648501311242248","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1614068819000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1614068819000,"shareUser":"彭旭锐","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"Android | 代码混淆到底做了什么？","type":0,"userId":30587,"visible":1,"zan":0},{"apkLink":"","audit":1,"author":"","canEdit":false,"chapterId":502,"chapterName":"自助","collect":false,"courseId":13,"desc":"","descMd":"","envelopePic":"","fresh":false,"host":"","id":17380,"link":"https://juejin.cn/post/6925702262102687758","niceDate":"1天前","niceShareDate":"1天前","origin":"","prefix":"","projectLink":"","publishTime":1614068708000,"realSuperChapterId":493,"selfVisible":0,"shareDate":1614068708000,"shareUser":"吊儿郎当","superChapterId":494,"superChapterName":"广场Tab","tags":[],"title":"App这么搞就永远不崩溃了","type":0,"userId":2554,"visible":1,"zan":0}]
         * offset : 0
         * over : false
         * pageCount : 503
         * size : 20
         * total : 10051
         */

        private int curPage;
        private int offset;
        private boolean over;
        private int pageCount;
        private int size;
        private int total;
        private List<DatasBean> datas;

        public int getCurPage() {
            return curPage;
        }

        public void setCurPage(int curPage) {
            this.curPage = curPage;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public boolean isOver() {
            return over;
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public int getPageCount() {
            return pageCount;
        }

        public void setPageCount(int pageCount) {
            this.pageCount = pageCount;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<DatasBean> getDatas() {
            return datas;
        }

        public void setDatas(List<DatasBean> datas) {
            this.datas = datas;
        }

        public static class DatasBean {
            /**
             * apkLink :
             * audit : 1
             * author :
             * canEdit : false
             * chapterId : 502
             * chapterName : 自助
             * collect : false
             * courseId : 13
             * desc :
             * descMd :
             * envelopePic :
             * fresh : true
             * host :
             * id : 17415
             * link : https://juejin.cn/post/6932778923491065864
             * niceDate : 1小时前
             * niceShareDate : 1小时前
             * origin :
             * prefix :
             * projectLink :
             * publishTime : 1614218071000
             * realSuperChapterId : 493
             * selfVisible : 0
             * shareDate : 1614218071000
             * shareUser : renxhui
             * superChapterId : 494
             * superChapterName : 广场Tab
             * tags : []
             * title : Gradle学习系列（一）：Groovy学习
             * type : 0
             * userId : 27931
             * visible : 1
             * zan : 0
             */

            private String apkLink;
            private int audit;
            private String author;
            private boolean canEdit;
            private int chapterId;
            private String chapterName;
            private boolean collect;
            private int courseId;
            private String desc;
            private String descMd;
            private String envelopePic;
            private boolean fresh;
            private String host;
            private int id;
            private String link;
            private String niceDate;
            private String niceShareDate;
            private String origin;
            private String prefix;
            private String projectLink;
            private long publishTime;
            private int realSuperChapterId;
            private int selfVisible;
            private long shareDate;
            private String shareUser;
            private int superChapterId;
            private String superChapterName;
            private String title;
            private int type;
            private int userId;
            private int visible;
            private int zan;
            private List<?> tags;

            public String getApkLink() {
                return apkLink;
            }

            public void setApkLink(String apkLink) {
                this.apkLink = apkLink;
            }

            public int getAudit() {
                return audit;
            }

            public void setAudit(int audit) {
                this.audit = audit;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public boolean isCanEdit() {
                return canEdit;
            }

            public void setCanEdit(boolean canEdit) {
                this.canEdit = canEdit;
            }

            public int getChapterId() {
                return chapterId;
            }

            public void setChapterId(int chapterId) {
                this.chapterId = chapterId;
            }

            public String getChapterName() {
                return chapterName;
            }

            public void setChapterName(String chapterName) {
                this.chapterName = chapterName;
            }

            public boolean isCollect() {
                return collect;
            }

            public void setCollect(boolean collect) {
                this.collect = collect;
            }

            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getDescMd() {
                return descMd;
            }

            public void setDescMd(String descMd) {
                this.descMd = descMd;
            }

            public String getEnvelopePic() {
                return envelopePic;
            }

            public void setEnvelopePic(String envelopePic) {
                this.envelopePic = envelopePic;
            }

            public boolean isFresh() {
                return fresh;
            }

            public void setFresh(boolean fresh) {
                this.fresh = fresh;
            }

            public String getHost() {
                return host;
            }

            public void setHost(String host) {
                this.host = host;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }

            public String getNiceDate() {
                return niceDate;
            }

            public void setNiceDate(String niceDate) {
                this.niceDate = niceDate;
            }

            public String getNiceShareDate() {
                return niceShareDate;
            }

            public void setNiceShareDate(String niceShareDate) {
                this.niceShareDate = niceShareDate;
            }

            public String getOrigin() {
                return origin;
            }

            public void setOrigin(String origin) {
                this.origin = origin;
            }

            public String getPrefix() {
                return prefix;
            }

            public void setPrefix(String prefix) {
                this.prefix = prefix;
            }

            public String getProjectLink() {
                return projectLink;
            }

            public void setProjectLink(String projectLink) {
                this.projectLink = projectLink;
            }

            public long getPublishTime() {
                return publishTime;
            }

            public void setPublishTime(long publishTime) {
                this.publishTime = publishTime;
            }

            public int getRealSuperChapterId() {
                return realSuperChapterId;
            }

            public void setRealSuperChapterId(int realSuperChapterId) {
                this.realSuperChapterId = realSuperChapterId;
            }

            public int getSelfVisible() {
                return selfVisible;
            }

            public void setSelfVisible(int selfVisible) {
                this.selfVisible = selfVisible;
            }

            public long getShareDate() {
                return shareDate;
            }

            public void setShareDate(long shareDate) {
                this.shareDate = shareDate;
            }

            public String getShareUser() {
                return shareUser;
            }

            public void setShareUser(String shareUser) {
                this.shareUser = shareUser;
            }

            public int getSuperChapterId() {
                return superChapterId;
            }

            public void setSuperChapterId(int superChapterId) {
                this.superChapterId = superChapterId;
            }

            public String getSuperChapterName() {
                return superChapterName;
            }

            public void setSuperChapterName(String superChapterName) {
                this.superChapterName = superChapterName;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getVisible() {
                return visible;
            }

            public void setVisible(int visible) {
                this.visible = visible;
            }

            public int getZan() {
                return zan;
            }

            public void setZan(int zan) {
                this.zan = zan;
            }

            public List<?> getTags() {
                return tags;
            }

            public void setTags(List<?> tags) {
                this.tags = tags;
            }
        }
    }
}

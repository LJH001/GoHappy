
package com.example.liujianhui.gohappy.component;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;

import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
   *Description:   ViewPager实现的轮播图广告自定义视图 既支持自动轮播页面也支持手势滑动切换页面
   * <br/>
   *Creator:jhliu <br>
   *Date:2017/1/19 0019 22:53
 */
public class SlideShowView extends FrameLayout {
    private static final String TAG = SlideShowView.class.getSimpleName()+">>>";
    private static final int IMAGE_COUNT = 4 ;

    // 异步加载图片组件
//    private ImageLoader imageLoader = ImageLoader.getInstance();

    // 轮播图图片数量
    private int imageCount = 0;

    // 自动轮播的时间间隔
    private final static int TIME_INTERVAL = 5;

    // 自动轮播启用开关
    private final static boolean isAutoPlay = true;

    // 自定义轮播图的资源
    private String[] imageUrls;

    //自定义本地轮播图片
    private int [] imageIds;

    // 链接
    private String[] pageUrls;

    // 放轮播图片的ImageView 的list
    private List<ImageView> imageViewsList;

    // 放圆点的View的list
    private List<View> dotViewsList;

    // 滑页组件
    private ViewPager viewPager;

    // 当前轮播页
    private int currentItem = 0;

    // 定时任务
    private ScheduledExecutorService scheduledExecutorService;

    private Context context;

    // Handler
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            viewPager.setCurrentItem(currentItem);
        }

    };

    /**
     * 构造方法
     *
     * @param context 上下文
     */
    public SlideShowView(Context context) {
        this(context, null);
    }

    /**
     * 构造方法
     *
     * @param context 上下文
     * @param attrs 属性
     */
    public SlideShowView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * 构造方法
     *
     * @param context 上下文
     * @param attrs 属性
     * @param defStyle 默认样式
     */
    public SlideShowView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;

        initData();
    }

    /**
     * 开始轮播图切换
     */
    private void startPlay() {
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(new SlideShowTask(), 1, TIME_INTERVAL, TimeUnit.SECONDS);
    }

    /**
     * 停止轮播图切换
     */
    private void stopPlay() {
        scheduledExecutorService.shutdown();
    }

    /**
     * 初始化相关Data
     */
    private void initData() {
        imageViewsList = new ArrayList<ImageView>();
        dotViewsList = new ArrayList<View>();

    }


    /**
     * 执行轮播图切换任务
     */
    private class SlideShowTask implements Runnable {

        @Override
        public void run() {
            synchronized (viewPager) {
                currentItem = (currentItem + 1) % imageCount;
                handler.obtainMessage().sendToTarget();
            }
        }

    }

    /**
     * 销毁ImageView资源，回收内存
     */
    private void destroyBitmaps() {

        for (int i = 0; i < imageCount; i++) {
            ImageView imageView = imageViewsList.get(i);
            Drawable drawable = imageView.getDrawable();
            if (drawable != null) {
                // 解除drawable对view的引用
                drawable.setCallback(null);
            }
        }
    }

}

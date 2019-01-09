package com.demo.liujian.module.main;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
  *descption:引导页适配器
  * <p>
  *packageName: com.demo.liujian.module.main
  * <p>
  *author:liujianhui
  *<p>
  *date:2019/1/9 10:58
*/
public class GuideAdapter extends PagerAdapter {
    private String[] mDescs;   //引导页引导语
    private TypedArray mIcons;   //引导页图片
    private Context mContext;
    private OnClickCallback mOnClickCallback;

    public GuideAdapter(int icoImage, int des, Context mContext) {
        mDescs = mContext.getResources().getStringArray(des);
        mIcons = mContext.getResources().obtainTypedArray(icoImage);
        this.mContext = mContext;
    }

    /**
     * 设置点击回调
     *
     * @param mOnClickCallback
     */
    public void setOnClickCallback(OnClickCallback  mOnClickCallback){
        this.mOnClickCallback = mOnClickCallback;
    }

    @Override
    public int getCount() {
        return mIcons.length();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemLayout = LayoutInflater.from(mContext).inflate(R.layout.vp_guide_layout, null, false);
        ImageView mImage = (ImageView) itemLayout.findViewById(R.id.iv_img);
        TextView mTextView = (TextView) itemLayout.findViewById(R.id.tv_desc);
        mImage.setImageResource(mIcons.getResourceId(position, 0));
        mTextView.setText(mDescs[position]);

        Button mButton = (Button) itemLayout.findViewById(R.id.btn_launch);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnClickCallback.onClick();
            }
        });

        if (position == getCount() - 1) {
            mButton.setVisibility(View.VISIBLE);
        } else {
            mButton.setVisibility(View.GONE);
        }

        container.addView(itemLayout);

        return itemLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    /**
     * 点击监听
     */
    interface OnClickCallback{
       void  onClick();
    }

}

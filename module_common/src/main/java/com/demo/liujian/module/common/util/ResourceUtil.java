package com.demo.liujian.module.common.util;

import android.content.Context;

/**
 * 
 * 用于获取资源ID，避免R类的引用
 * 
 * @version  [V1.0.0, 2013-4-27]
 */
public class ResourceUtil {

	/**
	 * 获取layout的id
	 * @param ctx	上下文
	 * @param name	布局名称
     * @return	id
     */
	public static int getLayoutId(Context ctx, String name) {
		return ctx.getResources().getIdentifier(name, "layout",
				ctx.getPackageName());
	}

    /**
     * 获取raw的id
     * @param ctx	上下文
     * @param name	raw名称
     * @return	id
     */
	public static int getRawId(Context ctx, String name) {
        return ctx.getResources().getIdentifier(name, "raw",
                ctx.getPackageName());
    }

    /**
     * 获取String的id
     * @param ctx	上下文
     * @param name	String名称
     * @return	id
     */
	public static int getStringId(Context ctx, String name) {
		return ctx.getResources().getIdentifier(name, "string",
				ctx.getPackageName());
	}

    /**
     * 获取Drawable的id
     * @param ctx	上下文
     * @param name	Drawable名称
     * @return	id
     */
	public static int getDrawableId(Context ctx, String name) {
		return ctx.getResources().getIdentifier(name, "drawable",
				ctx.getPackageName());
	}

    /**
     * 获取Style的id
     * @param ctx	上下文
     * @param name	Style名称
     * @return	id
     */
	public static int getStyleId(Context ctx, String name) {
		return ctx.getResources().getIdentifier(name, "style",
				ctx.getPackageName());
	}

    /**
     * 获取id的id
     * @param ctx	上下文
     * @param name	id名称
     * @return	id
     */
	public static int getId(Context ctx, String name) {
		return ctx.getResources().getIdentifier(name, "id",
				ctx.getPackageName());
	}

    /**
     * 获取Color的id
     * @param ctx	上下文
     * @param name	Color名称
     * @return	id
     */
	public static int getColorId(Context ctx, String name) {
		return ctx.getResources().getIdentifier(name, "color",
				ctx.getPackageName());
	}

}
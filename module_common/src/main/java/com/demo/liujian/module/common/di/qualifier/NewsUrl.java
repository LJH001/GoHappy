package com.demo.liujian.module.common.di.qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * 限定新闻url范围
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface NewsUrl {
}

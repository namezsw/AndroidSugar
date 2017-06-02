package com.seven.library.base.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Seven on 2017/4/10.
 */

@Scope
@Retention(RUNTIME)
public @interface AppScope {

}

package pl.misztal.template.di.annotation;

import javax.inject.Qualifier;

import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Used to inject {@link AndroidSchedulers#mainThread()}
 */

@Qualifier
public @interface MainThread {
}

package pl.misztal.template.di.annotation;

import javax.inject.Qualifier;

import io.reactivex.schedulers.Schedulers;

/**
 * Used to inject {@link Schedulers#io()}
 */

@Qualifier
public @interface IOThread {
}

package pl.misztal.template.ui.base;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

import pl.misztal.template.App;
import pl.misztal.template.di.scope.PresenterSingleton;
import toothpick.Scope;
import toothpick.Toothpick;

public abstract class BasePresenter<V extends MvpView> extends MvpBasePresenter<V> {
    protected Scope scope;

    @Override
    public void attachView(V view) {
        super.attachView(view);
        scope = Toothpick.openScopes(App.get(), this);
        scope.bindScopeAnnotation(PresenterSingleton.class);

        Toothpick.inject(this, scope);
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        Toothpick.closeScope(this);
        scope = null;
    }
}

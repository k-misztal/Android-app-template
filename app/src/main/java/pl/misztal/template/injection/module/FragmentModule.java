package pl.misztal.template.injection.module;

import android.support.v4.app.FragmentManager;

import dagger.Module;
import dagger.Provides;
import pl.misztal.template.injection.scope.PerFragment;
import pl.misztal.template.ui.fragment.BaseFragment;

@Module
public class FragmentModule {
    final BaseFragment baseFragment;

    public FragmentModule(BaseFragment baseFragment) {
        this.baseFragment = baseFragment;
    }

    @Provides
    @PerFragment
    BaseFragment provideBaseFragment() {
        return baseFragment;
    }

    @Provides
    @PerFragment
    public FragmentManager provideFragmentManager() {
        return baseFragment.getFragmentManager();
    }
}

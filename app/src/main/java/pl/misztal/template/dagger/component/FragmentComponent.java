package pl.misztal.template.dagger.component;


import dagger.Component;
import pl.misztal.template.dagger.module.FragmentModule;
import pl.misztal.template.dagger.scope.PerFragment;

@PerFragment
@Component(modules = FragmentModule.class, dependencies = ActivityComponent.class)
public interface FragmentComponent {

}

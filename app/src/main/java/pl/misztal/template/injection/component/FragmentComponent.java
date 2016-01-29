package pl.misztal.template.injection.component;


import dagger.Component;
import pl.misztal.template.injection.module.FragmentModule;
import pl.misztal.template.injection.scope.PerFragment;

@PerFragment
@Component(modules = FragmentModule.class, dependencies = ActivityComponent.class)
public interface FragmentComponent {

}

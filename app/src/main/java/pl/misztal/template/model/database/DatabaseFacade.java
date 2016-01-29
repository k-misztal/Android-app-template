package pl.misztal.template.model.database;

import javax.inject.Inject;

import pl.misztal.template.injection.scope.PerApplication;

@PerApplication
public class DatabaseFacade {

    @Inject
    public DatabaseFacade() {
    }

    //TODO remember about reactive model - return observables !

}

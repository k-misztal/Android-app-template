package pl.misztal.template.model.database;

import android.content.Context;

import javax.inject.Inject;

import pl.misztal.template.dagger.scope.PerApplication;

@PerApplication
public class DatabaseFacade {

    final DatabaseHelper helper;

    @Inject
    public DatabaseFacade(Context context) {
        helper = new DatabaseHelper(context);
    }


    //TODO remember about reactive model - return observables !

}

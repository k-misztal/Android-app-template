package pl.misztal.template.model;

import javax.inject.Inject;

import pl.misztal.template.injection.scope.PerApplication;
import pl.misztal.template.model.api.RestService;
import pl.misztal.template.model.database.DatabaseFacade;

@PerApplication
public class DataManager {

    private DatabaseFacade databaseFacade;
    private RestService restService;

    @Inject
    public DataManager(DatabaseFacade databaseFacade, RestService restService) {
        this.databaseFacade = databaseFacade;
        this.restService = restService;
    }

    public DatabaseFacade db() {
        return databaseFacade;
    }

    public RestService api() {
        return restService;
    }
}

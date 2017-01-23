package pl.misztal.template.di.module;

import pl.misztal.template.model.DataManager;
import toothpick.config.Module;

public class DataModule extends Module {

    public DataModule() {
        bind(DataManager.class).to(DataManager.class);
    }
    
}

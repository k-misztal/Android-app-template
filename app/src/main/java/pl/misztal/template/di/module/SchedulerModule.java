package pl.misztal.template.di.module;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import pl.misztal.template.di.annotation.ComputationThread;
import pl.misztal.template.di.annotation.IOThread;
import pl.misztal.template.di.annotation.MainThread;
import toothpick.config.Module;

public class SchedulerModule extends Module {

    public SchedulerModule() {
        bind(Scheduler.class).withName(MainThread.class).toInstance(AndroidSchedulers.mainThread());
        bind(Scheduler.class).withName(IOThread.class).toInstance(Schedulers.io());
        bind(Scheduler.class).withName(ComputationThread.class).toInstance(Schedulers.computation());
    }
}

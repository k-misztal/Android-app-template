package pl.misztal.template.model;

import javax.inject.Inject;

import pl.misztal.template.dagger.scope.PerApplication;
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

// TODO: 28.03.16
// mosby, stetho, autovalue
//rób commity po ang
//Krzysztof Misztal
//23:10
//        Krzysztof Misztal
//        słuszna uwaga, akurat robie mix tutaj pl-eng
//        Łukasz Matysik
//        23:16
//        Łukasz Matysik
//        czemu exception handle ma database managera?
//        i czemu jest per activity?
//        i czemu exception handler jest w ogóle związany z activity?
//        i czemu data manager zwraca api i db?
//        Krzysztof Misztal
//        23:18
//        Krzysztof Misztal
//        ExHandler wyświetla teksty błędów dla użytkownika, był PerFragment, ale zmieniłem żeby można było wyświetlać snackbar
//        *był PerApplication
//        datamanager owija wszystkie rzeczy które dostarczają dane
//        Łukasz Matysik
//        23:19
//        Łukasz Matysik
//        BasePresenter tez nie powinien byc zwiazany z activity
//        Krzysztof Misztal
//        23:20
//        Krzysztof Misztal
//        np. w tym projekcie ktory robie beda 2x api, database i shared preferences
//        Łukasz Matysik
//        23:20
//        Łukasz Matysik
//        masz 2 base presentery i obydwa wygladaja tak samo
//        tylko ze jeden ma activity drugi fragment
//        presentera nie obchodzi cos takiego jak activity/fragment
//        on powinien dostac widok
//        dokladniej interfejs widoku
//        i data manager jest ok ale on nie powinien exposowac ani api ani db
//        Krzysztof Misztal
//        23:21
//        Krzysztof Misztal
//        powinien delegować wszystkie metody?
//        Łukasz Matysik
//        23:21
//        Łukasz Matysik
//        niepotrzebnie tez gson factory i rest service factory rozbijac
//        np ja robie to tak ze mam network module
//        on providuje sobie okhttp gsona itd
//        i mamy api per feature tak jakby
//        i data manager tez per feature
//        Krzysztof Misztal
//        23:22
//        Krzysztof Misztal
//        odnośnie presetera, chciałem go połączyć z cyklem życia fragmentu/aktywności żeby wiedział kiedy np. fragment się ubija (np żeby anulować zapytaie restowe)
//        Łukasz Matysik
//        23:22
//        Łukasz Matysik
//        i exception handler powinien zwracac error message
//        presenter nie powinien wiedziec o cyklu zycia
//        Łukasz Matysik
//        23:23
//        Łukasz Matysik
//        http://hannesdorfmann.com/android/presenters-dont-need-lifecycle
//
//        Presenters don't need lifecycle events
//        My life with Android
//        hannesdorfmann.com
//        Łukasz Matysik
//        23:23
//        Łukasz Matysik
//        paczke inkection nazwalbym dagger
//        i niepotrzebnie tez tyle rzeczy exposujesz w graphach
//        Krzysztof Misztal
//        23:26
//        Krzysztof Misztal
//        dzięki za feedback
//        polecasz tego mosby'ego ogarnac?
//        Łukasz Matysik
//        23:26
//        Łukasz Matysik
//        ta, w miare spoko to działa
//        w sensie nie warto imo swojego mvp robic
//        chyba ze chcesz cos konkretnego osiagnac
//        Krzysztof Misztal
//        23:27
//        Krzysztof Misztal
//        no nie, tak sobie kiedys rozkminiłęm i zostało
//        dołożyłem tylko pare poprawek
//        akurat projekt zaczynam to dobry czas na autovalue i mosbyego Emotikon grin
//        Łukasz Matysik
//        23:27
//        Łukasz Matysik
//        no autovalue to tak raczej 4 educational purpouses
//        w sensie jest spoko ale bez extensions jest lipa
//        a extensions nie maja stabilnego api jeszcze
//        w sensie jest dopiero RC1
//        ogolnie pisz klasy tak
//        zeby android sie konczyl na presenterze
//        w idealnym swiecie presenter nie powinien nic wiedziec o androidzie
//        tak zeby dalo sie to unit testowac
//        odpowiedzialnosc za wyswietlenie bledu na dobrym watku trzymalbym po stronie presentera
//        bo to on rozmawia z widokiem
//        exception handler powinien throwable na error message imo zamieniac
//        ogolnie polecam daggerowe moduly tez per feature robic
//        HttpClientFactory
//        od tego jest dagger zeby nie trzeba bylo robic factory
//        ;d
//public static OkHttpClient build() {
//        to tez takie se
//        nazwalbym to raczej newOkHttpClient
//        poza tym okhttp powinien byc singletonem
//        jak potrzebujesz mu cos zmienic to od 3.0 masz newBuilder
//        i wtedy mozesz zmodyfikowac
//        np jesli masz inne interceptory per api wtedy robisz @Provides @InneApi i tam zmeiniasz zmodyfikowanego okhttp
//        uzywajac qualifiera albo @Named("inneapi")
//ogólnie nie jest źle, z pół roku temu też pewno bym podobnie zrobil
//        chociaz fragment scope imo niepotrzebny jest
//        ogolnie w template warto sobie crashlyticsa spiac
//        najlepiej z timberem skoro uzywasz
//        stetho sobie dodaj
//        bo to pr0 jest
//        ormlite bym wywalil z tego template rzadko baze danych trzeba na androidzie
//        a jesli juz jest w teplate to chociaz ta klase bazowa do stawiania tej bazy
//        na ormlicie robilem tez zazwyczaj fasady per tablica
//        i to moze fajnie generycznie zrobic delegujac zapytania do dao
//        w mCoachu chyba tak robilismy
//        powinienes miec tez prezenter rxowy
//        ktory ma composite subscription
//        i na onDetachView anulujesz wszystkie subskrypcje
//        Krzysztof Misztal
//        23:43
//        Krzysztof Misztal
//        chyba sobie obczaje mosbyego, wiec narazie nie bede zmieniał mojego mvp
//        dzięki za rady Emotikon grin
//        bardzo cenne
//@PerFeature?
//        tzn?
//        i czemu mówisz zeby wywalić @PErFragment
//Łukasz Matysik
//        23:43
//        Łukasz Matysik
//        tzn jesli uzywasz moze zostac
//        ale ja np nie mam nic co by mialo sens jako @PerFragment
//Krzysztof Misztal
//        23:44
//        Krzysztof Misztal
//        adapter i presenter miałem do tej pory zawsze na @PerFragment
//Łukasz Matysik
//        23:44
//        Łukasz Matysik
//        i tak bedziesz mial 1 fragment per aktywnosc
//        no np jak mam aktywnosc jakis presenter tam jakis presenter do fragmentu itd
//        to mam @ActivityScope w FeatureModule
import java.lang.reflect.Array;
import java.util.*;
import org.apache.commons.collections.ListUtils;

public class Main {
    public static void main(String[] args) {
        List<String> sakstypeavslagsgrunn = new ArrayList<>(hentSakstypeOgAvslagsgrunn());

        System.out.print(sakstypeavslagsgrunn.get(0) + " - " + sakstypeavslagsgrunn.get(1));

    }

    static void test() {



    }

    static List<String> hentSakstypeOgAvslagsgrunn() {
        List<String> felles = new ArrayList<>(Arrays.asList(
                "Ikke tilskudsmidler",
                "Ikke startlansmidler",
                "Annet"
        ));

        List<String> avslagkonkretrefinans = new ArrayList<>(Arrays.asList(
                "KonkretRefinans",
                "Dyr bolig",
                "Uegnet bolig",
                "Lav betalingsvilje"));
        avslagkonkretrefinans = org.apache.commons.collections.ListUtils.union(avslagkonkretrefinans, felles);

        List<String> avslagoverta = new ArrayList<>(Arrays.asList(
                "Overta",
                "Lav betalingsvilje"));
        avslagoverta = org.apache.commons.collections.ListUtils.union(avslagoverta, felles);

        List<String> avslagtilpasse = new ArrayList<>(Arrays.asList(
                "Tilpasse",
                "Finansierer tilpasning selv",
                "Ikke nodvendig for funksjonshemmingen",
                "Ikke eldre med fremtidig behov"));
        avslagtilpasse = org.apache.commons.collections.ListUtils.union(avslagtilpasse, felles);

        List<List> sakstyperavslag = new ArrayList<>();
        sakstyperavslag.add(avslagkonkretrefinans);
        sakstyperavslag.add(avslagoverta);
        sakstyperavslag.add(avslagtilpasse);

        List<String> sakstypegrunn = sakstyperavslag.get(new Random().nextInt(sakstyperavslag.size()));
        String sakstype = sakstypegrunn.get(0);
        sakstypegrunn.remove(0);
        String grunn = sakstypegrunn.get(new Random().nextInt(sakstyperavslag.size()));

        return new ArrayList<>(Arrays.asList(sakstype, grunn));
    }

}

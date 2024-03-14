package strings;

import java.util.HashSet;
import java.util.Set;

public class ComponentIdsUtils {

    public static Set<ComponentId> getVilocifyIds() {
        Set<ComponentId> componentIds = new HashSet<>();
        ComponentId cId = new ComponentId();
        cId.setId(1);
        cId.setLastUpdate("2022-10-03");
        componentIds.add(cId);

        ComponentId cId1 = new ComponentId();
        cId1.setId(2);
        cId1.setLastUpdate("2022-11-05");
        componentIds.add(cId1);

        ComponentId cId2 = new ComponentId();
        cId2.setId(3);
        cId2.setLastUpdate("2022-11-06");
       // cId2.setLastUpdate(null);
        componentIds.add(cId2);

        ComponentId cId4 = new ComponentId();
        cId4.setId(4);
        cId4.setLastUpdate("2022-11-07");
       // cId4.setLastUpdate(null);
        componentIds.add(cId4);

        ComponentId cId5 = new ComponentId();
        cId5.setId(5);
        cId5.setLastUpdate("2021-03-08");
        //cId5.setLastUpdate(null);
        componentIds.add(cId5);

        ComponentId cId6 = new ComponentId();
        cId6.setId(6);
        cId6.setLastUpdate("2021-03-09");
        //cId6.setLastUpdate(null);
        componentIds.add(cId6);

        return componentIds;
    }

    public static Set<ComponentId> getDbIds() {
        Set<ComponentId> componentIds = new HashSet<>();
        ComponentId cId = new ComponentId();
        cId.setId(1);
        cId.setLastUpdate("2022-10-03");
        componentIds.add(cId);

        ComponentId cId1 = new ComponentId();
        cId1.setId(2);
        cId1.setLastUpdate("2022-11-05");
        componentIds.add(cId1);

        ComponentId cId2 = new ComponentId();
        cId2.setId(3);
        cId2.setLastUpdate("2022-11-06");
        componentIds.add(cId2);

        ComponentId cId4 = new ComponentId();
        cId4.setId(4);
        cId4.setLastUpdate("2022-11-07");
        componentIds.add(cId4);

        ComponentId cId5 = new ComponentId();
        cId5.setId(5);
        cId5.setLastUpdate("2021-03-08");
        componentIds.add(cId5);

        ComponentId cId6 = new ComponentId();
        cId6.setId(6);
        cId6.setLastUpdate("2021-03-09");
        componentIds.add(cId6);

        ComponentId cId7 = new ComponentId();
        cId7.setId(7);
        cId7.setLastUpdate("2022-3-31");
        componentIds.add(cId7);

        ComponentId cId8 = new ComponentId();
        cId8.setId(8);
        cId8.setLastUpdate("2022-3-30");
        componentIds.add(cId8);


        return componentIds;
    }
}

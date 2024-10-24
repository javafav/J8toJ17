package collections.maps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdventureGame {
    private static final String GAME_LOCATIONS = """
            road, at a dusty crossroad, W: hill, E: well house, S: valley, N: forest
            hill, on top of a windswept hill, N: forest, E: road
            well house, inside an old well house, W: road, N: lake, S: stream
            valley, a quiet forest valley, N: road, W: hill, E: stream
            forest, at the edge of a dense forest, S: road, E: lake
            lake, next to a tranquil mountain lake, W: forest, S: well house
            stream, beside a rushing stream, W: valley, N: well house
            cave, deep inside a shadowy cave, S: mountain, E: forest
            mountain, a towering mountain peak, N: hill, W: cave
            village, in a peaceful village square, N: river, S: road, W: barn, E: meadow
            river, beside a wide flowing river, S: village, W: waterfall
            waterfall, near a thundering waterfall, E: river, S: cliff
            cliff, on the edge of a steep cliff, N: waterfall, W: path, S: cave
            path, along a narrow mountain path, N: cliff, E: cave, S: valley
            barn, inside an old barn, E: village, N: forest
            tower, at the top of a tall stone tower, S: meadow, W: lake
            ruins, among ancient ruins overgrown with vines, N: tower, W: forest
            field, in a golden wheat field, N: barn, E: stream, S: meadow
            swamp, deep inside a murky swamp, S: road, W: stream
            desert, in the middle of a vast desert, N: oasis, E: dunes, W: canyon
            oasis, at a small desert oasis, S: desert, E: camp
            camp, in a traveler’s desert camp, W: oasis, N: mountain, E: dunes
            dunes, on top of rolling sand dunes, W: camp, S: desert, E: ruins
            ruins, inside crumbling desert ruins, N: well house, S: oasis, W: dunes
            canyon, at the bottom of a deep canyon, E: desert, N: waterfall
            waterfall, next to a hidden waterfall, W: cave, E: canyon
            forest path, on a narrow forest path, N: stream, S: village, E: clearing
            clearing, in a small clearing in the forest, W: forest path, N: hill
            castle, in the grand hall of a stone castle, N: courtyard, S: moat
            courtyard, in a courtyard surrounded by high walls, S: castle, W: tower
            tower, on the spiral staircase of a tall tower, E: courtyard, N: wall
            wall, at the base of a crumbling stone wall, S: tower, W: ruins
            bridge, on a stone bridge over a river, N: village, S: fields, E: waterfall
            fields, in rolling fields of green, N: bridge, W: lake, E: meadow
            lake shore, along the shore of a calm lake, N: forest, W: dock
            dock, on a wooden dock by the lake, N: boat house, S: lake shore
            boat house, inside a small boat house, S: dock, E: river
            riverbank, at a bend in the river, N: forest, S: plains, E: farm
            farm, on a small farm, W: riverbank, N: barn, S: farmhouse
            farmhouse, inside a cozy farmhouse, N: farm, E: fields
            plains, in the middle of wide open plains, N: riverbank, S: canyon
            canyon edge, at the edge of a deep canyon, N: plains, S: desert
            desert camp, at a small desert camp, W: canyon, N: river
            river crossing, at a ford in the river, S: swamp, W: mountains
            mountains, in the foothills of a towering mountain range, E: river, S: valley
            valley path, on a path through a lush valley, W: mountains, N: cave
            cave entrance, at the entrance to a dark cave, S: valley path, E: mountains
            mountain peak, at the top of a snowy mountain peak, N: cliffs, S: village
            cliffs, at the edge of steep cliffs, S: mountain peak, W: beach
            beach, on a sandy beach by the sea, N: cliffs, E: ocean
            ocean, at the edge of the vast ocean, W: beach, N: island
            island, on a small tropical island, S: ocean, W: shipwreck
            shipwreck, at the site of a sunken ship, E: island, N: coral reef
            coral reef, near a vibrant coral reef, S: shipwreck, E: lagoon
            lagoon, in a calm lagoon surrounded by cliffs, N: cave, W: coral reef
            cave exit, at the exit of a winding cave, S: lagoon, W: mountain
            forest clearing, in a quiet forest clearing, N: stream, S: road
            road junction, at a crossroads in the middle of a forest, E: swamp, W: river
            river bend, at a sharp bend in the river, S: fields, N: bridge
            waterfall base, at the base of a cascading waterfall, E: canyon, W: forest
            forest glade, in a peaceful forest glade, N: ruins, S: riverbend
            ruins gate, at the gate of ancient ruins, S: glade, W: castle
            castle gate, in front of a massive castle gate, N: ruins, S: village
            village center, in the center of a small village, N: castle gate, E: inn
            inn, inside a cozy village inn, W: village center, S: road
            road crossing, at the intersection of two roads, N: inn, E: riverbank
            riverbank road, on a road beside the river, W: crossing, E: waterfall
            waterfall cliff, on a cliff next to a waterfall, S: riverbank, N: ruins
            ruins hall, in a grand hall of ancient ruins, S: waterfall, W: bridge
            bridge pass, on a stone bridge over a deep gorge, E: ruins, W: hills
            hills, on rolling green hills, N: bridge pass, S: valley
            valley river, by a river flowing through the valley, W: hills, E: forest
            forest river, in a dense forest by the river, S: valley, E: clearing
            forest clearing, in a sunny forest clearing, W: forest river, N: lake
            lakefront, at the edge of a large lake, S: forest clearing, W: road
            road to village, on a road leading to a distant village, E: lakefront, N: swamp
            swamp edge, at the edge of a vast swamp, S: road to village, N: mountain
            mountain pass, in a narrow pass through the mountains, S: swamp, E: desert
            desert plain, in the middle of a vast desert plain, W: mountains, E: ruins
            """;

    private enum Compass {
        E(" ↑ "), N(" ← "), S(" → "), W(  " ↓ " );
        private final String symbol;

        Compass (String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }

        private static final String[] directions = {"East", "North", "South", "West"};

        public String getString() {
            return directions[this.ordinal()] + getSymbol();
        }


    }

    private record Location(String description, Map<Compass, String> nextPlaces){}

    private String lastPlace;
    private Map<String, Location> adventureMap = new HashMap<>();

    public AdventureGame() {
        this(null);
    }

    public AdventureGame(String customLocations) {
        loadLocation(GAME_LOCATIONS);
        if(customLocations != null){
            loadLocation(customLocations);
        }

    }


    private void loadLocation(String data){
        for(String s: data.split("\\R")){
            String[] parts = s.split(",", 3);
            Arrays.asList(parts).replaceAll(String::trim);

            Map<Compass, String> nextPlaces = loadDirection(parts[2]);

            Location location = new Location(parts[1], nextPlaces);
            adventureMap.put(parts[0], location);


        }
       // adventureMap.forEach((k,v) -> System.out.printf("%s:%s%n".formatted(k,v)));
    }

    private Map<Compass, String> loadDirection(String nextPlaces){
        Map<Compass, String> directions = new HashMap<>();
        List<String> nextSteps = Arrays.asList(nextPlaces.split(","));
        nextSteps.replaceAll(String::trim);
        for(String nextPlace : nextSteps){
            String[] splits = nextPlace.split(":");
            Compass compass = Compass.valueOf(splits[0].trim());
            String destination = splits[1].trim();
            directions.put(compass, destination);
        }

        return directions;
    }

    private void visit(Location location){
        System.out.printf("*** You're standings %s *** %n",location.description);
        System.out.println("\tFrom here, you can see:" );
        location.nextPlaces().forEach((k,v) -> {
            System.out.printf("\t• A %s to the %s (%S) %n", v, k.getString(), k );
        });
        System.out.print("Select Your Compass (Q to quit)>>");
    }

    public void move(String direction){
        var nextPlaces = adventureMap.get(lastPlace).nextPlaces;
        String nextPlace = null;
        if("ENSW".contains(direction)){
            nextPlace = nextPlaces.get(Compass.valueOf(direction));
            if(nextPlace != null){
                play(nextPlace);
            }

        }else {
            System.out.println("!! Invalid direction, try again");
        }
    }

    public void play(String location) {
        if(adventureMap.containsKey(location)){
            Location next = adventureMap.get(location);
            lastPlace = location;
            visit(next);
        }else {
            System.out.println(location + " is an ivalid location");
        }
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cities = scanner.nextInt();
        int countRoads = scanner.nextInt();

        List<Graph> states = new ArrayList<>();
        int default1 = 0;
        int default2 = 0;

        for (int i = 1; i <= countRoads; i++) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            int len = scanner.nextInt();
            if (num1 == default1 || num2 == default1 || num1 == default2 || num2 == default2) {
                Graph state = states.get(states.size() - 1);
                state.addCity(num1);
                state.addCity(num2);
                state.addRoad(num1, num2, len);
            } else {
                Graph state = new Graph();
                state.addCity(num1);
                state.addCity(num2);
                state.addRoad(num1, num2, len);
                states.add(state);
            }
            default1 = num1;
            default2 = num2;
        }

        int decrementer = 1;
        int cntRoadsOfState = 0;
        boolean flag = false;

        while (!flag) {
            for (Graph state : states) {
                for (City city : state.map.keySet()) {
                    cntRoadsOfState += state.map.get(city).size();
                    state.removeRoads(city, decrementer);
                }
                if (cntRoadsOfState == state.map.size() - 1) {
                    flag = true;
                } else break;
            }
            if (!flag) {
                decrementer++;
                cntRoadsOfState = 0;
            }
        }
        System.out.println(decrementer);
    }
    static class Graph {
        Map<City, List<Road>> map;

        public Graph() {
            map = new HashMap<>();
        }

        void addCity(Integer num) {
            map.putIfAbsent(new City(num), new ArrayList<>());
        }

        void addRoad(Integer num1, Integer num2, int len) {
            City c1 = new City(num1);
            Road road = new Road(num1, num2, len);
            map.get(c1).add(road);
        }

        void removeRoads(City city, int decrement) {
            List<Road> roads = map.get(city);
            if (roads != null) {
                List<Road> newRoads = roads.stream().filter(road -> road.len > decrement).toList();

                map.put(city, newRoads);
            }
        }
    }

    static class City {
        int num;
        public City(int number) {
            this.num = number;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            City city = (City) o;
            return num == city.num;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num);
        }
    }
    static class Road {
        int num1;
        int num2;
        int len;

        public Road(int num1, int num2, int len) {
            this.num1 = num1;
            this.num2 = num2;
            this.len = len;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Road road = (Road) o;
            return num1 == road.num1 && num2 == road.num2 && len == road.len;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num1, num2);
        }
    }
}


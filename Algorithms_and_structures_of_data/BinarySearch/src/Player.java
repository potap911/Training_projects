import java.util.Objects;

public class Player {
    private int rating;
    private String name;

    public Player(int rating, String name) {
        this.rating = rating;
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return rating == player.rating && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rating, name);
    }

    @Override
    public String toString() {
        return "Player{" +
                "rating=" + rating +
                ", name='" + name + '\'' +
                '}';
    }
}

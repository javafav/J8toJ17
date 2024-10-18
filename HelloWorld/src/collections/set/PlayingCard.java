package collections.set;

public class PlayingCard {
    private String face;
    private String suit;
    private int hashValue;

    public PlayingCard( String suit, String face) {
        this.face = face;
        this.suit = suit;
        this.hashValue = 1;
    }

    @Override
    public String toString() {
        return face + " of " + suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayingCard that = (PlayingCard) o;
        return face.equals(that.face) && suit.equals(that.suit);
    }

    @Override
    public int hashCode() {
        int result = face.hashCode();
        result = 31 * result + suit.hashCode();
        return result;
    }
}

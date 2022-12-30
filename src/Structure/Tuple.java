package Structure;

import java.util.Objects;

//It can be a record class. (Java 16)
public record Tuple<Item>(Item firstItem, Item secondItem) {

    @Override
    public String toString() {
        return "(" + this.firstItem + ", " + this.secondItem + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple<?> tuple = (Tuple<?>) o;
        return Objects.equals(firstItem, tuple.firstItem) && Objects.equals(secondItem, tuple.secondItem);
    }

}

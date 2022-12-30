package Structure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisjointSet<Item> {

    private final Map<Item, Item>    parent = new HashMap<>();
    private final Map<Item, Integer> rank   = new HashMap<>();

    public void makeSet(List<Item> universe) {
        for (Item item : universe) {
            parent.put(item, item);
            rank.put(item, 0);
        }
    }

    public Item find(Item k) {

        if (!(parent.get(k).equals(k))) {
            parent.put(k, this.find(parent.get(k)));
        }

        return parent.get(k);
    }

    public void union(Item a, Item b) {
        Item x = this.find(a);
        Item y = this.find(b);

        if (x == y) {
            return;
        }

        if (rank.get(x) > rank.get(y)) {
            parent.put(y, x);
            rank.put(x, rank.get(x) + 1);
            return;
        }

        parent.put(x, y);
        rank.put(y, rank.get(y) + 1);

    }
}
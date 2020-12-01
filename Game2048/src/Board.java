import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Board <Key, T> {
    int weigh;
    int height;
    Map<Key, T> board = new HashMap<>();

    public Board() {

    }

    public Board(int weigh,int height) {
        this.height = height;
        this.weigh = weigh;
    }

    abstract void fillBoard(List<T> list);
    abstract List<Key> availableSpace();
    abstract void addItem(Key key, T value);
    abstract Key getKey(int i, int j);
    abstract T getValue(Key key);
    abstract List<Key> getColumn(int j);
    abstract List<Key> getRow(int i);
    abstract boolean hasValue(T value);
    abstract List<T> getValues(List<Key> keys);

}

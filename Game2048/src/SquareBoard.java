import java.util.*;


public class SquareBoard<T> extends Board<Key, T> {

    public SquareBoard(int size) {
        super(size, size);
    }

    @Override
    void fillBoard(List<T> list) {
        if (list.size() != weigh * height) throw new RuntimeException();

        for (int i = 0; i < weigh; i++) {
            for (int j = 0; j < height; j++) {
                board.put(new Key(i, j), list.get(i * height + j));
            }
        }
    }


    @Override
    List<Key> availableSpace() {
        List<Key> keyList = new ArrayList<>();
        for (Map.Entry<Key, T> entry : board.entrySet()) {
            if (entry.getValue() == null) {
                keyList.add(entry.getKey());
            }
        }
        return keyList;
    }

    @Override
    void addItem(Key key, T value) {
        board.put(key, value);
    }

    @Override
    public Key getKey(int i, int j) {

        return board
                .keySet()
                .stream()
                .filter(key -> key.getI() == i && key.getJ() == j)
                .findFirst()
                .orElseGet(() -> null);
    }

    @Override
    T getValue(Key key) {
        return board.get(key);
    }

    @Override
    List<Key> getColumn(int j) {
        ArrayList<Key> list = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            list.add(getKey(i, j));
        }

        return list;
    }

    @Override
    List<Key> getRow(int i) {
        ArrayList<Key> list = new ArrayList<>();

        for (int j = 0; j < weigh; j++) {
            list.add(getKey(i, j));
        }

        return list;
    }

    @Override
    boolean hasValue(T value) {
        return board.containsValue(value);
    }

    @Override
    List<T> getValues(List<Key> keys) {
        ArrayList<T> list = new ArrayList<>();

        for (Key key: keys) {
            list.add(board.get(key));
        }

        return list;
    }
}


/* This is more like a set than a list. Order does not matter and duplicates are not added */
public class UnorderedList {
    private int manyItems;
    private int[] data;

    private final static int DEFAULT_CAPACITY = 10;

    public UnorderedList() {
        manyItems = 0;
        data = new int[DEFAULT_CAPACITY];
    }

    public UnorderedList(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("Initial Capacity must be greater than 0.");

        manyItems = 0;
        data = new int[capacity];
    }

    public int size() {
        return manyItems;
    }

    public void add(int val) {
        if (!contains(val)) {
            if (manyItems == data.length)
                increaseCapacity(manyItems * 2);

            data[manyItems] = val;
            manyItems++;
        }
    }

    private boolean contains(int val) {
        for (int i = 0; i < manyItems; i++) {
            if (data[i] == val)
                return true;
        }

        return false;
    }

    private void increaseCapacity(int newCapacity) {
        int[] temp = new int[newCapacity];

        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }

        data = temp;
    }

    public void remove(int val) {
        for (int i = 0; i < manyItems; i++) {
            if (val == data[i]) {
                data[i] = data[manyItems - 1];
                manyItems--;
                return;
            }
        }
    }
}
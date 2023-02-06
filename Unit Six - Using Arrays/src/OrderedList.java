public class OrderedList {
    private int manyItems;
    private int[] data;

    private final static int DEFAULT_CAPACITY = 10;

    public OrderedList() {
        manyItems = 0;
        data = new int[DEFAULT_CAPACITY];
    }

    public OrderedList(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("Initial Capacity must be greater than 0.");

        manyItems = 0;
        data = new int[capacity];
    }

    public int size() {
        return manyItems;
    }

    public void add(int val) {

        if (manyItems == data.length)
            increaseCapacity(manyItems * 2);

        data[manyItems] = val;
        manyItems++;
    }

    private void increaseCapacity(int newCapacity) {
        int[] temp = new int[newCapacity];

        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }

        data = temp;
    }

    public int get(int index) {
        if (index < 0)
            throw new IllegalArgumentException("Index must be greater or equal to 0");

        if (index >= manyItems) {
            throw new IndexOutOfBoundsException("Invalid index " + index + " max index must be " + (manyItems - 1));
        }

        return data[index];
    }

    public int remove(int index) {
        if (index < 0)
            throw new IllegalArgumentException("Index must be greater or equal to 0");

        if (index >= manyItems) {
            throw new IndexOutOfBoundsException("Invalid index " + index + " max index must be " + (manyItems - 1));
        }

        int temp = data[index];

        for (int i = index; i < manyItems - 1; i++) {
            data[i] = data[i + 1];
        }

        manyItems--;

        return temp;
    }

    /*
     * Set the value at index to the specified val and return what was there before.
     */
    public int set(int index, int val) {
        if (index < 0)
            throw new IllegalArgumentException("Index must be greater or equal to 0");

        if (index >= manyItems) {
            throw new IndexOutOfBoundsException("Invalid index " + index + " max index must be " + (manyItems - 1));
        }

        int temp = data[index];
        data[index] = val;
        return temp;

    }

    public void add(int index, int val) {
        if (index < 0)
            throw new IllegalArgumentException("Index must be greater or equal to 0");

        if (index > manyItems) {
            throw new IndexOutOfBoundsException("Invalid index " + index + " max index must be " + (manyItems - 1));
        }

        if (manyItems == data.length)
            increaseCapacity(manyItems * 2);

        // shift from the back to make room
        for (int i = manyItems; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = val;
        manyItems++;

    }

}

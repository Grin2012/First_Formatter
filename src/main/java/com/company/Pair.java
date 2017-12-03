package com.company;

/**
 * A pair of any objects with correct equals() and hashCode() overridden.
 * @param <T> type of the fist element of the pair
 * @param <U> type of the second element of the pair
 */
public final class Pair<T, U> {

    private final T first;
    private final U second;

    /**
     * Creates the pair.
     * @param first first element
     * @param second second element
     */
    public Pair(final T first, final U second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Gets the first element of the pair.
     * @return the first element
     */
    public T getFirst() {
        return first;
    }

    /**
     * Gets the second element of the pair.
     * @return the second element
     */
    public U getSecond() {
        return second;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Pair)) {
            return false;
        }

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if (first != null ? !first.equals(pair.first) : pair.first != null) {
            return false;
        }
        return second != null ? second.equals(pair.second) : pair.second == null;
    }

    @Override
    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }

}
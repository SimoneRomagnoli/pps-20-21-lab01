package lab01.tdd;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private List<Integer> list;
    private int index;

    public CircularListImpl() {
        this.list = new ArrayList<>();
        this.index = -1;
    }

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    /**
     * Manages the circular implementation of the list:
     * corrects the unbounded index if it is out of bounds.
     *
     * @param unboundedIndex
     * @return the wanted element
     */
    private int get(int unboundedIndex) {
        if(unboundedIndex < 0) {
            this.index = this.size()-1;
        } else if(unboundedIndex >= this.size()){
            this.index = 0;
        }
        return this.list.get(index);
    }

    @Override
    public Optional<Integer> next() {
        return this.isEmpty()
                ? Optional.empty()
                : Optional.of(this.get(++index));
    }

    @Override
    public Optional<Integer> previous() {
        return this.isEmpty()
                ? Optional.empty()
                : Optional.of(this.get(--index));
    }

    @Override
    public void reset() {
        this.index = -1;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        if(this.isEmpty()) {
            return Optional.empty();
        } else {
            Optional<Integer> first = Optional.empty();
            while(first.isEmpty() && index < this.size()-1) {
                Optional<Integer> next = this.next();
                first = strategy.apply(next.get())
                        ? next
                        : Optional.empty();
            }
            return first;
        }
    }
}

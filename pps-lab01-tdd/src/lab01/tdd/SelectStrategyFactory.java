package lab01.tdd;

import java.util.Optional;

public class SelectStrategyFactory extends AbstractFactory {

    private static final int REST = 1;
    private static final int NO_REST = 0;

    @Override
    public SelectStrategy getSelectStrategy(StrategyType type, Optional<Integer> operator) {
        switch (type) {
            case EQUALS:
                return element -> element == operator.get();
            case ODD:
                return element -> element % 2 == REST;
            case EVEN:
                return element -> element % 2 == NO_REST;
            case MULTIPLE_OF:
                return element -> element % operator.get() == NO_REST;
            case SQUARE:
                return element -> element == operator.get() * operator.get();
        }
        return null;
    }
}

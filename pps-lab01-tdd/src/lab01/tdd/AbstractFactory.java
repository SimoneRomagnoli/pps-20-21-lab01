package lab01.tdd;

import java.util.Optional;

public abstract class AbstractFactory {
    abstract SelectStrategy getSelectStrategy(StrategyType type, Optional<Integer> number);
}

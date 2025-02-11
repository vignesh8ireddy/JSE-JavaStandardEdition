package Java8Features;

@FunctionalInterface
public interface Addition<T extends Number> {
    T add(T a, T b);
}
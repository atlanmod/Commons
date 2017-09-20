package fr.inria.atlanmod.commons;

import java.util.function.BiFunction;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * An object that converts an object of type {@link T} to another of type {@link R}, by using an object of type {@link
 * U}.
 * <p>
 * The reverse operation <b>may</b> be strict <i>inverse</i>, meaning that {@code converter.revert(converter.convert(a,
 * c), c).equals(a)} always {@code true}.
 *
 * @param <T> the type of the first argument to the converter
 * @param <U> the type of the second argument to the converter
 * @param <R> the type of the result of the converter
 */
@ParametersAreNonnullByDefault
public interface BiConverter<T, U, R> {

    /**
     * Creates a bi-converter that always converts or reverses an object to itself.
     *
     * @param <T> the type of the converted instance and the result
     *
     * @return a new converter
     */
    @Nonnull
    static <T, U> BiConverter<T, U, T> identity() {
        return new BiConverter<T, U, T>() {
            @Nonnull
            @Override
            public T convert(T t, U u) {
                return t;
            }

            @Nonnull
            @Override
            public T revert(T t, U u) {
                return t;
            }
        };
    }

    /**
     * Creates a bi-converter based on separate forward and backward functions.
     *
     * @param convertFunc the function used for {@link #convert(Object, Object)}
     * @param revertFunc  the function used for {@link #revert(Object, Object)}
     * @param <T>         the type of the first argument to the converter
     * @param <U>         the type of the second argument to the converter
     * @param <R>         the type of the result of the converter
     *
     * @return a new converter
     */
    @Nonnull
    static <T, U, R> BiConverter<T, U, R> from(BiFunction<? super T, ? super U, ? extends R> convertFunc, BiFunction<? super R, ? super U, ? extends T> revertFunc) {
        return new BiConverter<T, U, R>() {
            @Nonnull
            @Override
            public R convert(T t, U u) {
                return convertFunc.apply(t, u);
            }

            @Nonnull
            @Override
            public T revert(R r, U u) {
                return revertFunc.apply(r, u);
            }
        };
    }

    /**
     * Returns a representation of {@code t} as an instance of type {@link R}, by using an object of type {@link U}.
     *
     * @param t the instance to convert
     * @param u the helper instance
     *
     * @return the converted instance
     */
    R convert(T t, U u);

    /**
     * Returns a representation of {@code r} as an instance of type {@link T}, by using an object of type {@link U}.
     *
     * @param r the instance to convert
     * @param u the helper instance
     *
     * @return the converted instance
     */
    T revert(R r, U u);
}

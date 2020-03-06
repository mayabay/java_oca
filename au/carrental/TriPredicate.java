/*
 * TriPredicate
 * v0.1
 * filter Vehicles by price range
 * */
package au.carrental;

@FunctionalInterface
public interface TriPredicate<T, U, V> {
	public abstract boolean test( T v, U d1, V d2 );
}

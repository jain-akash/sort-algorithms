package personal.jain.akash.sort.api;

public interface ISort {
	public enum Order {
		ASCENDING, DESCENDING
	}
	public <G extends Comparable<? super G>> G[] sort(G[] arr, Order order);
}

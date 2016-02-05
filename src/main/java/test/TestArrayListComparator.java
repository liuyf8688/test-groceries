package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestArrayListComparator {

	public static void main(String[] args) {
		
		System.out.println("initiate data ...");
		List<Distance> distances = new ArrayList<>();
		distances.add(new Distance(false, 20));
		distances.add(new Distance(true, 20));
		distances.add(new Distance(false, 15));
		distances.add(new Distance(true, 14));
		
		distances.forEach(System.out::println);
		System.out.println();
		System.out.println();
		System.out.println("enable preferred feature:");
		
		distances.sort(new DefaultComparator(true));
		distances.forEach(System.out::println);
		
		System.out.println("clear the data ...");
		System.out.println("initiate data again ...");
		distances.clear();
		distances.add(new Distance(false, 20));
		distances.add(new Distance(true, 20));
		distances.add(new Distance(false, 15));
		distances.add(new Distance(true, 14));
		
		System.out.println();
		System.out.println();
		System.out.println("disable preferred feature:");
		distances.sort(new DefaultComparator(false));
		distances.forEach(System.out::println);
	}
	
	private static class DefaultComparator implements Comparator<Distance> {

		private boolean enablePreferred = false;
		
		public DefaultComparator(boolean enablePreferred) {
			this.enablePreferred = enablePreferred;
		}

		@Override
		public int compare(Distance o1, Distance o2) {
			int out = 0;
			if (enablePreferred) {
//				if (o1.preferred == o2.preferred) {
//					out = 0;
//				} else if (o1.preferred) {
//					out = -1;
//				} else {
//					out = 1;
//				}
				if (o1.preferred != o2.preferred) {
					out = o1.preferred ? -1 : 1;
				}
			}
			
			if (out == 0) {
				return o1.distance - o2.distance;
			}
			
			return out;
		}
		
	}

	private static class Distance {
		
		private Boolean preferred;
		
		private int distance;

		public Distance(Boolean preferred, int distance) {
			super();
			this.preferred = preferred;
			this.distance = distance;
		}
		
		@Override
		public String toString() {
			return "[ perferred=" + preferred + ", distance="+ distance + "]";
		}
		
	}
}


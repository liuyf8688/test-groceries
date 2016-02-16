package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestArrayListWithDynamicComparator {

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
		System.out.println("sort by distance first:");
		
		distances.sort(new DefaultComparator(Arrays.asList(DefaultComparator.DISTANCE, DefaultComparator.PREFERRED)));
		distances.forEach(System.out::println);
		
		System.out.println("clear the data ...");
		distances.clear();
		System.out.println("initiate data again ...");
		distances.add(new Distance(false, 20));
		distances.add(new Distance(true, 20));
		distances.add(new Distance(false, 15));
		distances.add(new Distance(true, 14));
		
		System.out.println();
		System.out.println();
		System.out.println("sort by preferred first:");
		distances.sort(new DefaultComparator(Arrays.asList(DefaultComparator.PREFERRED, DefaultComparator.DISTANCE)));
		distances.forEach(System.out::println);
	}
	
	private static class DefaultComparator implements Comparator<Distance> {

		static final String PREFERRED = "PREFERRED";
		static final String DISTANCE = "DISTANCE";
		
		private List<String> sortOptions;
		
		public DefaultComparator(List<String> sortOptions) {
			this.sortOptions = sortOptions;
		}

		@Override
		public int compare(Distance o1, Distance o2) {
			
			int out = 0;
			if ((sortOptions == null) || (sortOptions.size() < 1)) {
				return out;
			}
			
			for (String sortOption : sortOptions) {
				//
				if (DISTANCE.equals(sortOption)) {
					out = sortByDistance(o1, o2);
					if (out != 0) {
						break;
					}
				}
				//
				if (PREFERRED.equals(sortOption)) {
					out = sortByPreferred(o1, o2);
					if (out != 0) {
						break;
					}
				}
			}
				
			return out;
		}

		private int sortByPreferred(Distance o1, Distance o2) {
			if (o1.preferred == o2.preferred) {
				return 0;
			}
			return o1.preferred ? -1 : 1;
		}

		private int sortByDistance(Distance o1, Distance o2) {
			return o1.distance - o2.distance;
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


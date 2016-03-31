package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestArrayListWithDynamicComparator {

	public static void main(String[] args) {
		
		System.out.println("initiate data ...");
		List<Workshop> distances = new ArrayList<>();
		distances.add(new Workshop(false, 20, 4));
		distances.add(new Workshop(true, 20, 3));
		distances.add(new Workshop(false, 15, 10));
		distances.add(new Workshop(true, 14, 6));
		
		distances.forEach(System.out::println);
		System.out.println();
		System.out.println();
		System.out.println("sort by distance first:");
		
		distances.sort(new DefaultComparator(Arrays.asList(DefaultComparator.DISTANCE, DefaultComparator.PREFERRED, DefaultComparator.HEADCOUNT)));
		distances.forEach(System.out::println);
		
		System.out.println();
		System.out.println();
		System.out.println("clear the data ...");
		distances.clear();
		System.out.println("initiate data again ...");
		distances.add(new Workshop(false, 20, 4));
		distances.add(new Workshop(true, 20, 3));
		distances.add(new Workshop(false, 15, 10));
		distances.add(new Workshop(true, 14, 6));
		
		System.out.println();
		System.out.println();
		System.out.println("sort by preferred first:");
		distances.sort(new DefaultComparator(Arrays.asList(DefaultComparator.PREFERRED, DefaultComparator.DISTANCE, DefaultComparator.HEADCOUNT)));
		distances.forEach(System.out::println);
		
		System.out.println();
		System.out.println();
		System.out.println("clear the data ...");
		distances.clear();
		System.out.println("initiate data again ...");
		distances.add(new Workshop(false, 20, 4));
		distances.add(new Workshop(true, 20, 3));
		distances.add(new Workshop(false, 15, 10));
		distances.add(new Workshop(true, 14, 6));
		
		System.out.println();
		System.out.println();
		System.out.println("sort by headcount first:");
		distances.sort(new DefaultComparator(Arrays.asList(DefaultComparator.HEADCOUNT, DefaultComparator.PREFERRED, DefaultComparator.DISTANCE)));
		distances.forEach(System.out::println);
	}
	
	private static class DefaultComparator implements Comparator<Workshop> {

		static final String HEADCOUNT = "HEADCOUNT";
		static final String PREFERRED = "PREFERRED";
		static final String DISTANCE = "DISTANCE";
		
		private List<String> sortOptions;
		
		public DefaultComparator(List<String> sortOptions) {
			this.sortOptions = sortOptions;
		}

		@Override
		public int compare(Workshop o1, Workshop o2) {
			
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
				
				//
				if (HEADCOUNT.equals(sortOption)) {
					out = sortByHeadcount(o1, o2);
					if (out != 0) {
						break;
					}
				}
			}
				
			return out;
		}

		private int sortByPreferred(Workshop o1, Workshop o2) {
			if (o1.preferred == o2.preferred) {
				return 0;
			}
			return o1.preferred ? -1 : 1;
		}

		private int sortByDistance(Workshop o1, Workshop o2) {
			return o1.distance - o2.distance;
		}
		
		private int sortByHeadcount(Workshop o1, Workshop o2) {
			return o2.headcount - o1.headcount;
		}
		
	}

	private static class Workshop {
		
		private Boolean preferred;
		
		private int distance;
		
		private int headcount;

		public Workshop(Boolean preferred, int distance, int headcount) {
			super();
			this.preferred = preferred;
			this.distance = distance;
			this.headcount = headcount;
		}
		
		@Override
		public String toString() {
			return "[ preferred=" + preferred + ", distance="+ distance + ", headcount=" + headcount + "]";
		}
		
	}
}


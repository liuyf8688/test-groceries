package test;
import java.util.HashMap;
import java.util.Map;

public class TestHashMap {

	public static void main(String[] args) {
		
		String key = "poiuyyy";
		int h = key.hashCode();
		System.out.println("hashCode: " + h);
		h ^= (h >>> 20) ^ (h >>> 12);
		h = h ^ (h >>> 7) ^ (h >>> 4);
		System.out.println("h: " + h);
		
		System.out.println("h & (length - 1): " + (h & (16 - 1)));
		
		System.out.println("=====1.8======");
		
		h = (h = key.hashCode()) ^ (h >>> 16);
		System.out.println("h: " + h);
		
		//
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("abc1", "==============");
		
		System.out.println(map.put(key, "=============="));
		
		System.out.println(map.put("abc1", "=============="));
		
		int concurrencyLevel = 13;
		
		int sshift = 0;
        int ssize = 1;
        while (ssize < concurrencyLevel) {
            ++sshift;
            ssize <<= 1;
            System.out.println(ssize);
        }
        
        int segmentShift = 32 - sshift;
        int segmentMask = ssize - 1;
        
        System.out.println("======================================");
        System.out.println("segmentShift: " + segmentShift);
        System.out.println("segmentMask: " + segmentMask);
        
        System.out.println("0xffffcd7d: " + 0xffffcd7d);
        
        int hOfCurrentHashMap = key.hashCode();
        hOfCurrentHashMap += (hOfCurrentHashMap <<  15) ^ 0xffffcd7d;
        hOfCurrentHashMap ^= (hOfCurrentHashMap >>> 10);
        hOfCurrentHashMap += (hOfCurrentHashMap <<   3);
        hOfCurrentHashMap ^= (hOfCurrentHashMap >>>  6);
        hOfCurrentHashMap += (hOfCurrentHashMap <<   2) + (hOfCurrentHashMap << 14);
        hOfCurrentHashMap = hOfCurrentHashMap ^ (hOfCurrentHashMap >>> 16);
        
        System.out.println("hash: " + hOfCurrentHashMap);
        
        int hashOfCurrentHashMap = (hOfCurrentHashMap >>> segmentShift) & segmentMask;
        
        System.out.println("hashOfCurrentHashMap: " + hashOfCurrentHashMap);
	}
}

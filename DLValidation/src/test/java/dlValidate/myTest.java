package dlValidate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class myTest {

	public static void main(String[] args) {

		 final InsertData insertData = new InsertData();

		new Thread() {
			public void run() {
				insertData.insert(Thread.currentThread());
			};
		}.start();

		new Thread() {
			public void run() {
				insertData.insert(Thread.currentThread());
			};
		}.start();
		
		new Thread() {
			public void run() {
				insertData.insert(Thread.currentThread());
			};
		}.start();
		System.out.println(insertData.getArrayList().size());
	}

	public static int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			myMap.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (myMap.containsKey(complement) && i != myMap.get(complement)) {
				return new int[] { myMap.get(complement), i };

			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}

class lkq {

	lkq() {
		System.out.println("i am lkq");
	}
}

class InsertData {
	private ArrayList<Integer> arrayList = new ArrayList<Integer>();

	public ArrayList<Integer> getArrayList() {
		return arrayList;
	}

	public void setArrayList(ArrayList<Integer> arrayList) {
		this.arrayList = arrayList;
	}

	public  void insert(Thread thread) {
		for (int i = 0; i < 5; i++) {
			System.out.println(thread.getName() + "在插入数据" + i);
			this.arrayList.add(i);
		}
	}
}

package dlValidate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Test {
	private int queueSize = 10;
	private PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queueSize);
	int counter = 100;

	public static void main(String[] args) {
//		Singleton myInstance = Singleton.getInstance();
//
//		Singleton myInstance2 = Singleton.getInstance();
//
//		myInstance.counter = myInstance.counter + 1;
//		myInstance2.counter = myInstance2.counter + 1;
//		System.out.println(myInstance2.counter);
		//System.out.println(majorityElement(new int[]{4,4,4,1,1,2,1,3,4,1,4,1,1,5}));
		String s="asdasdsass";
		//System.out.println(s.valueOf('a'));
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");

	}

	public static int majorityElement(int[] nums) {
		int index = 0;
		Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
		tempMap.put(index, 0);
		int answer=0;
		for (int i = 0; i < nums.length; i++) {
			
			if (tempMap.containsKey(nums[i])) {
				int count = tempMap.get(nums[i]) + 1;
				tempMap.put(nums[i], count);
			} else {
				tempMap.put(nums[i], 1);
				
			}
			if(tempMap.get(nums[i])>tempMap.get(index)){
				index=nums[i];
				answer=i;
				
			}
		}
		
		return answer;

	}

	class Consumer extends Thread {

		@Override
		public void run() {
			consume();
		}

		private void consume() {
			while (counter != 0) {
				synchronized (queue) {
					while (queue.size() == 0) {
						try {
							System.out.println("队列空，等待数据");
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
							queue.notify();
						}
					}
					queue.poll(); // 每次移走队首元素
					queue.notify();
					System.out.println("从队列取走一个元素，队列剩余" + queue.size() + "个元素");
				}
			}
			counter--;
		
		}
	}

	class Producer extends Thread {

		@Override
		public void run() {
			produce();
		}

		private void produce() {
			while (counter != 0) {
				counter--;
				synchronized (queue) {
					while (queue.size() == queueSize) {
						try {
							System.out.println("队列满，等待有空余空间");
							queue.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
							queue.notify();
						}
					}
					queue.offer(1); // 每次插入一个元素
					queue.notify();
					System.out.println("向队列取中插入一个元素，队列剩余空间："
							+ (queueSize - queue.size()));
				}
			}

		}
	}
}
package HashMap;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap<K extends Comparable<K>, V> {

    private class HMNode {
		K key;
		V value;

		public HMNode(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return "[" + this.key + ", " + this.value + "]";
		}
	}

	private LinkedList<HMNode>[] bucketArray;
	private int size;

	public HashMap(int cap) {
		this.bucketArray = new LinkedList[cap];
		this.size = 0;
	}

	public void put(K key, V value) {
		int bi = this.hashFunction(key);

		if (this.bucketArray[bi] == null) {

			LinkedList<HMNode> bucket = new LinkedList<HMNode>();

			this.bucketArray[bi] = bucket;

			HMNode node = new HMNode(key, value);
			bucket.add(node);
			this.size++;

		} else {

			int nodeIndex = findInBucket(this.bucketArray[bi], key);

			if (nodeIndex == -1) { // add new node

				HMNode node = new HMNode(key, value);
				this.bucketArray[bi].add(node);
				this.size++;

			} else { // update existing node

				HMNode node = this.bucketArray[bi].get(nodeIndex);
				node.value = value;
			}

		}

		// if loading factor exceeded then rehash
		double lf = (this.size * 1.0) / this.bucketArray.length;
		if (lf >= 2.0) {
			this.rehash();
		}

	}

	private void rehash() {

		LinkedList<HMNode>[] oba = this.bucketArray;
		this.size = 0;

		this.bucketArray = new LinkedList[oba.length * 2];

		for (int i = 0; i < oba.length; i++) {
			LinkedList<HMNode> bucket = oba[i];

			while (bucket != null && bucket.size() > 0) {
				HMNode node = bucket.removeFirst();
				this.put(node.key, node.value);

			}

		}

	}

	public void display() {

		for (int i = 0; i < this.bucketArray.length; i++) {

			LinkedList<HMNode> bucket = this.bucketArray[i];

			System.out.println("Bucket " + (i + 1) + ": ");
			for (int j = 0; bucket != null && j < bucket.size(); j++) {
				HMNode node = bucket.removeFirst();

				System.out.print(node + ", ");

				bucket.addLast(node);
			}
			System.out.println();
		}

	}

	private int findInBucket(LinkedList<HMNode> bucket, K key) {
		int rv = -1;

		for (int i = 0; i < bucket.size(); i++) {

			// new - O(n)
			HMNode node = bucket.removeFirst();
			if (node.key.compareTo(key)==0)
				rv = i;
			bucket.addLast(node);
		}

		return rv;
	}

	private int hashFunction(K key) {
		int hc = key.hashCode();
		return hc % this.bucketArray.length;
	}

	public V remove(K key) {

		int bi = this.hashFunction(key);

		if (this.bucketArray[bi] == null) {
			System.out.println("element not present");
			return null;
		}

		LinkedList<HMNode> bucket = this.bucketArray[bi];

		int nodeIdx = this.findInBucket(bucket, key);
		if (nodeIdx == -1) {
			System.out.println("element not present");
			return null;
		}

		V rv = bucket.get(nodeIdx).value;
		bucket.remove(nodeIdx);
		this.size--;

		return rv;
	}

	public boolean containsKey(K key) {

		int bi = this.hashFunction(key);

		if (this.bucketArray[bi] == null) {
			System.out.println("element not present");
			return false;
		}

		LinkedList<HMNode> bucket = this.bucketArray[bi];

		int nodeIdx = this.findInBucket(bucket, key);
		if (nodeIdx == -1) {
			System.out.println("element not present");
			return false;
		}

		return true;
	}

	public V get(K key) {

		int bi = this.hashFunction(key);

		if (this.bucketArray[bi] == null) {
			System.out.println("element not present");
			return null;
		}

		LinkedList<HMNode> bucket = this.bucketArray[bi];

		int nodeIdx = this.findInBucket(bucket, key);
		if (nodeIdx == -1) {
			System.out.println("element not present");
			return null;
		}

		V rv = bucket.get(nodeIdx).value;

		return rv;
	}

	public Integer size() {
		return this.size;
	}

	public ArrayList<K> keySet() {

		ArrayList<K> keys = new ArrayList<K>();
		for (int i = 0; i < this.bucketArray.length; i++) {

			LinkedList<HMNode> bucket = this.bucketArray[i];

			for (int j = 0; bucket != null && j < bucket.size(); j++) {
				HMNode node = bucket.removeFirst();

				keys.add(node.key);

				bucket.addLast(node);
			}
		}

		return keys;
	}
}
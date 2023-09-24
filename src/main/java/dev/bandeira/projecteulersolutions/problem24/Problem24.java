package dev.bandeira.projecteulersolutions.problem24;

import java.util.ArrayList;

/*
 * https://projecteuler.net/problem=24
 * A permutation is an ordered arrangement of objects. For example, 3124 is one
 * possible permutation of the digits 1, 2, 3 and 4. If all of the permutations
 * are listed numerically or alphabetically, we call it lexicographic order. The
 * lexicographic permutations of 0, 1 and 2 are:
 * 
 * 012 021 102 120 201 210
 * 
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4,
 * 5, 6, 7, 8 and 9?
 * 
 * COMPLETED ON 15/07/18
 */
public class Problem24 {
	public static final int[] ITEMS = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	public static ArrayList<int[]> permutes = new ArrayList<>();

	public static void main(String[] args) {

		permute(ITEMS, 0, ITEMS.length - 1);
		for(int i : permutes.get(999999)) {
			System.out.print(i);
		}
	}

	public static void permute(int[] numbers, int l, int r) {
		if (r == l) {
			permutes.add(numbers);
		} else {
			for (int i = l; i <= r; i++) {
				numbers = swap(numbers, l, i);
				permute(numbers, l + 1, r);
			}
		}
	}

	public static int[] swap(int[] target, int a, int b) {
		int[] result = target.clone();
		int aux = result[a];

		result[a] = result[b];
		result[b] = aux;

		return result;
	}

}

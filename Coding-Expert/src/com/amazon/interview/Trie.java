package com.amazon.interview;

public class Trie {
	private static final int alphabetSize = 26;

	static class TrieDataStructure {

		boolean isEndOfWord;
		TrieDataStructure[] childrens = new TrieDataStructure[alphabetSize];

		TrieDataStructure() {
			isEndOfWord = false;
			for (int i = 0; i < alphabetSize; i++) {
				childrens[i] = null;
			}
		}
	};

	static TrieDataStructure root;

	private static void insert(String key) {

		TrieDataStructure child = root;

		for (int i = 0; i < key.length(); i++) {
			int index = key.charAt(i) - 'a';
			if (child.childrens[index] == null) {
				System.out.println(index);
				child.childrens[index] = new TrieDataStructure();
			}
			child = child.childrens[index];
		}
		child.isEndOfWord = true;

	}

	public static void main(String[] args) {

		String str[] = { "the", "bye", "hello", "the" };
		int l = str.length;
		root = new TrieDataStructure();

		for (int i = 0; i < l; i++) {
			insert(str[i]);
		}

		if (search("hellos") == true) {
			System.out.println("found");

		} else
			System.out.println("not found");

	}

	private static boolean search(String key) {

		TrieDataStructure child = root;
		for (int i = 0; i < key.length(); i++)

		{
			int index = key.charAt(i) - 'a';
			if (child.childrens[index] == null)
				return false;
			child = child.childrens[index];
		}
		return (child != null && child.isEndOfWord);
	}

}

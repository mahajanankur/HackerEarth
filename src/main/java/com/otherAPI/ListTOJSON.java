package com.otherAPI;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.java.miscellaneous.DummyList;

public class ListTOJSON {

	public static void main(String[] args) {
		firstApproach();

	}

	private static void firstApproach() {
		List<DummyList> list = new ArrayList<DummyList>();
		list.add(new DummyList("Ankur", 1, 00000));
		list.add(new DummyList("An", 2, 10000));
		list.add(new DummyList("Anku", 3, 20000));
		list.add(new DummyList("Ankurrr", 4, 40000));
//		for (DummyList dummyList : list) {
//			System.out.println(dummyList.getName());
//		}
		String json = new Gson().toJson(list);

		System.out.println(json);
	}

}

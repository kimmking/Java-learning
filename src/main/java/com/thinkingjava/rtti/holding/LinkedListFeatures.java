//: holding/LinkedListFeatures.java
package com.thinkingjava.rtti.holding;

import static net.mindview.util.Print.print;

import java.util.LinkedList;

import com.thinkingjava.rtti.typeinfo.pets.Hamster;
import com.thinkingjava.rtti.typeinfo.pets.Pet;
import com.thinkingjava.rtti.typeinfo.pets.Pets;
import com.thinkingjava.rtti.typeinfo.pets.Rat;

public class LinkedListFeatures {
	public static void main(String[] args) {
		LinkedList<Pet> pets = new LinkedList<Pet>(Pets.arrayList(5));
		print(pets);
		// Identical:
		print("pets.getFirst(): " + pets.getFirst());
		print("pets.element(): " + pets.element());
		// Only differs in empty-list behavior:
		print("pets.peek(): " + pets.peek());
		// Identical; remove and return the first element:
		print("pets.remove(): " + pets.remove());
		print("pets.removeFirst(): " + pets.removeFirst());
		// Only differs in empty-list behavior:
		print("pets.poll(): " + pets.poll());
		print(pets);
		pets.addFirst(new Rat());
		print("After addFirst(): " + pets);
		pets.offer(Pets.randomPet());
		print("After offer(): " + pets);
		pets.add(Pets.randomPet());
		print("After add(): " + pets);
		pets.addLast(new Hamster());
		print("After addLast(): " + pets);
		print("pets.removeLast(): " + pets.removeLast());
	}
}

/*
 * [Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug, Manx, Cymric, Rat, EgyptianMau,
 * Hamster, EgyptianMau, Mutt, Mutt] pets.getFirst(): Rat pets.element(): Rat
 * pets.peek(): Rat pets.remove(): Rat pets.removeFirst(): Manx pets.poll():
 * Cymric [Mutt, Pug, Cymric, Pug, Manx, Cymric, Rat, EgyptianMau, Hamster,
 * EgyptianMau, Mutt, Mutt] After addFirst(): [Rat, Mutt, Pug, Cymric, Pug,
 * Manx, Cymric, Rat, EgyptianMau, Hamster, EgyptianMau, Mutt, Mutt] After
 * offer(): [Rat, Mutt, Pug, Cymric, Pug, Manx, Cymric, Rat, EgyptianMau,
 * Hamster, EgyptianMau, Mutt, Mutt, Cymric] After add(): [Rat, Mutt, Pug,
 * Cymric, Pug, Manx, Cymric, Rat, EgyptianMau, Hamster, EgyptianMau, Mutt,
 * Mutt, Cymric, Mouse] After addLast(): [Rat, Mutt, Pug, Cymric, Pug, Manx,
 * Cymric, Rat, EgyptianMau, Hamster, EgyptianMau, Mutt, Mutt, Cymric, Mouse,
 * Hamster] pets.removeLast(): Hamster
 */

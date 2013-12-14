package models.character.race;

import java.util.ArrayList;

import models.items.Item;

public class SlotList extends ArrayList<Item>{
	int count = 0;

	public SlotList(int initialCapacity) {
		super(initialCapacity);
	}

	@Override
	public void add(int index, Item item) {
		if (areSlotsAvailable(item.size())) {
			super.add(index, item);
			count = count + item.size();
		}
	}

	@Override
	public boolean add(Item item) {
		if (areSlotsAvailable(item.size())) {
			count++;
			return super.add(item);
		}
		return false;
	}

	@Override
	public Item remove(int index) {
		Item x = super.remove(index);
		count = x.size();
		return x;
	}

	@Override
	public boolean remove(Object o) {
		if (super.remove(o)) {
			count--;
			return true;
		}
		return false;
	}

	public boolean areSlotsAvailable(int size) {
		return count + size <= this.size();
	}
}

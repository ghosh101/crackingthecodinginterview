package com.cracking.interview.oopdeign.filesystem;

import java.util.ArrayList;

/*
 * Design of a FileSystem
 */
public abstract class Entry {

	protected String name;
	protected long created;
	protected long lastUpdated;
	protected long lastAccessed;
	protected Directory parent;
	
	public Entry(String name, Directory parent) {
		this.name = name;
		this.parent = parent;
		this.created = System.currentTimeMillis();
		this.lastAccessed = System.currentTimeMillis();
		this.lastUpdated = System.currentTimeMillis();
	}
	
	public abstract int size();
}

class File extends Entry{
	private String content;
	private int size;
	
	File(String n, Directory p, int sz){
		super(n, p);
		this.size = sz;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
}

class Directory extends Entry{
	protected ArrayList<Entry> contents;
	
	public Directory(String name, Directory parent) {
		super(name, parent);
		contents = new ArrayList<>();
	}
	
	public int size() {
		int size = 0;
		for (Entry entry : contents) {
			size = size + entry.size();
		}
		return size;
	}
	
	public int numberOfFiles() {
		int count = 0;
		for (Entry entry : contents) {
			if(entry instanceof Directory) {
				count++;
				Directory d = (Directory) entry;
				count = count + d.numberOfFiles();
			}else if(entry instanceof File) {
				count++;
			}
		}
		
		return count;
	}
	
	protected ArrayList<Entry> getContents(){
		return contents;
	}
	
	public boolean deleteEntry(Entry entry) {
		return contents.remove(entry);
	}
	
	public void addEntry(Entry entry) {
		contents.add(entry);
	}
}

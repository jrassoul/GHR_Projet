package ghrChine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * In this class, the phonebook is implemented by using ArrayList. 
 * 
 * Three ways for visiting elements in ArrayList are showed in three methods.
 */
public class PhonebookArrayList {
	private static final String SEPARATOR = ";";
	private final ArrayList<Profil> profils = new ArrayList<Profil>();



	//private String name;
	//	private String lastName;
	//	private String dateOfBirth;
//,String lastName,String dateOfBirth
	public Boolean searchProfile(String name) throws NoSuchElementException {

		List<String> lines = null;
		String row;
		String[] data = new String[0];
		try {
			BufferedReader csvReader = new BufferedReader(new FileReader("./csv/gpaye1dos.csv"));
			while ((row = csvReader.readLine()) != null && data[0] != name) {
				data = row.split(";");
			}
			csvReader.close();

		} catch (Exception e) {
			System.out.println("impossible de lire");
		}
		if (data[0].equals(name)) {
			return true;
		}else {
			return false;
		}
	}


		Iterator<Profil> iterator = profils.iterator();
		while (iterator.hasNext()) {
			Profil contact = iterator.next();
			if (contact.getlastName().equals(lastName)) {
				return contact;
			}
		}
		throw new NoSuchElementException("Contact with number " + lastName + " does not exist in the phonebook.");
	}

	public Profil searchByName(String name) throws NoSuchElementException {
		for (int index = 0; index <= profils.size() - 1; index++) {
			Profil contact = profils.get(index);
			if (contact.getName().equals(name)) {
				return contact;
			}
		}
		throw new NoSuchElementException("Contact with name " + name + " does not exist in the phonebook.");
	}

	public int currentContactCount() {
		return profils.size();
	}

	public String toString() {
		String result = "";
		for (Profil contact : profils) {
			result += contact.toString() + "\n";
		}

		return result;
	}

	public boolean containsContact(Profil contact) {
		return profils.contains(contact);
	}


	public void serializationSave(String fileName) {
		ObjectOutputStream stream;
		try {
			stream = new ObjectOutputStream(new FileOutputStream(fileName));
			for (Profil contact : profils) {
				stream.writeObject(contact);
			}
			stream.close();
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}





	public void textRead(String fileName) {
		String line, fields[];
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			while ((line = reader.readLine()) != null) {
				fields = line.split(SEPARATOR);
				Profil contact = new Profil(fields[0], fields[1], fields[2]);
				add(contact);
			}
			reader.close();

		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	public void removeAll() {
		profils.clear();
	}
}

package model;

import java.beans.Transient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;


public class Patient implements Serializable {

	private int id;
	private String firstName;
	private String lastName;
	private String jmbg;
	private String dateOfBirth;
	private String address;
	private String phoneNumber;
	private MedicalRecord mr;
	private ArrayList<String> anamnesis = new ArrayList<String>();
	private ArrayList<PhysicalExamination> pregledi = new ArrayList<PhysicalExamination>();
	
	private Vector<Object> structuredData;
	
	public Patient() {
		super();

	}
	
	
	
	public Patient(int id, String firstName, String lastName, String jmbg, String dateOfBirth, String address,
			String phoneNumber, MedicalRecord mr, ArrayList<String> anamnesis, ArrayList<PhysicalExamination> pregledi) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.jmbg = jmbg;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.mr = mr;
		this.anamnesis = anamnesis;
		this.pregledi = pregledi;
		createVectorOfData();
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	

	public MedicalRecord getMr() {
		return mr;
	}



	public void setMr(MedicalRecord mr) {
		this.mr = mr;
	}

	


	public ArrayList<String> getAnamnesis() {
		return anamnesis;
	}



	public void setAnamnesis(ArrayList<String> anamnesis) {
		this.anamnesis = anamnesis;
	}
	
	



	public ArrayList<PhysicalExamination> getPregledi() {
		return pregledi;
	}



	public void setPregledi(ArrayList<PhysicalExamination> pregledi) {
		this.pregledi = pregledi;
	}



	public Vector<Object> getStructuredData() {
		return structuredData;
	}



	public void setStructuredData(Vector<Object> structuredData) {
		this.structuredData = structuredData;
	}



	



	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", jmbg=" + jmbg
				+ ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", phoneNumber=" + phoneNumber + ", mr="
				+ mr + ", anamnesis=" + anamnesis + ", pregledi=" + pregledi + ", structuredData=" + structuredData
				+ "]";
	}



	public void createVectorOfData() {
		Vector<Object> objects = new Vector<Object>();
		objects.add(getId());
		objects.add(getFirstName());
		objects.add(getLastName());
		objects.add(getDateOfBirth());
		objects.add(getJmbg());
		objects.add(getAddress());
		objects.add(getPhoneNumber());
		objects.add(getMr());
		objects.add(getAnamnesis());
		objects.add(getPregledi());
		setStructuredData(objects);
	}
	
}
